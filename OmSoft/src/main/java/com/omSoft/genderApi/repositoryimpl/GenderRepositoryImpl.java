package com.omSoft.genderApi.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omSoft.genderApi.model.Gender;
import com.omSoft.genderApi.repository.GenderDao;
import com.omSoft.genderApi.repository.GenderRepository;

@Repository
public class GenderRepositoryImpl implements GenderRepository {

	@Autowired
	private GenderDao genderDao;

	@Override
	public List<Gender> getAllGender() {
		return genderDao.findAll();
	}

	@Override
	public Gender getGenderById(Long id) {
		return genderDao.findById(id).orElse(null);
	}

	@Override
	public void saveGenderInfo(Gender gender) {
		genderDao.save(gender);
	}

}
