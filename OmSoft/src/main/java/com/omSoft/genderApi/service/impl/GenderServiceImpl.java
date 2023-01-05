package com.omSoft.genderApi.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omSoft.genderApi.model.Gender;
import com.omSoft.genderApi.repository.GenderRepository;
import com.omSoft.genderApi.servicee.GenderService;

@Service
public class GenderServiceImpl implements GenderService {

	Logger logger = LoggerFactory.getLogger(GenderServiceImpl.class);

	@Autowired
	private GenderRepository genderRepository;

	@Scheduled(cron = "0 */1 * ? * *")
	@Override
	public void saveGenderInfo() throws Exception {

		URL yahoo = new URL("https://api.genderize.io?name=luc");
		URLConnection yc = yahoo.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

		String inline;

		while ((inline = in.readLine()) != null) {

			ObjectMapper mapper = new ObjectMapper();
			Gender readValue = mapper.readValue(inline, Gender.class);

			long currentTimeMillis = System.currentTimeMillis();

			logger.info("Current Time : {}", new Date(currentTimeMillis).toGMTString());

			Gender gender = setGenderValues(readValue);

			genderRepository.saveGenderInfo(gender);
		}

	}

	private Gender setGenderValues(Gender readValue) {
		Gender gender = new Gender();
		gender.setCount(readValue.getCount());
		gender.setGender(readValue.getGender());
		gender.setName(readValue.getName());
		gender.setProbability(readValue.getProbability());
		return gender;
	}

	@Override
	public List<Gender> getAllGender() {
		return genderRepository.getAllGender();
	}

	@Override
	public Gender getGenderById(Long id) {
		return genderRepository.getGenderById(id);
	}

}
