package com.omSoft.genderApi.servicee;

import java.util.List;

import com.omSoft.genderApi.model.Gender;

public interface GenderService {

	public void saveGenderInfo() throws Exception;

	public Gender getGenderById(Long id);

	public List<Gender> getAllGender();
}
