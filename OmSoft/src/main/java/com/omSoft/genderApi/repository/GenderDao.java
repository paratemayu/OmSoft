package com.omSoft.genderApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omSoft.genderApi.model.Gender;

@Repository
public interface GenderDao extends JpaRepository<Gender, Long>{

	
}
