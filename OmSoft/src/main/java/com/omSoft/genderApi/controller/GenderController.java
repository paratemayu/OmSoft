package com.omSoft.genderApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omSoft.genderApi.model.Gender;
import com.omSoft.genderApi.servicee.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {

	@Autowired
	GenderService genderService;

	@GetMapping("/get/all")
	List<Gender> getAllGender() {
		return genderService.getAllGender();
	}

	@GetMapping("/get/by/id/{id}")
	Gender getGenderById(@PathVariable Long id) {
		return genderService.getGenderById(id);
	}
}
