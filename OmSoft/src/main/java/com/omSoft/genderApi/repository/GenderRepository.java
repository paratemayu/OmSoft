package com.omSoft.genderApi.repository;

import java.util.List;

import com.omSoft.genderApi.model.Gender;


public interface GenderRepository {

	public List<Gender> getAllGender();

	public Gender getGenderById(Long id);

	public void saveGenderInfo(Gender gender);

}
