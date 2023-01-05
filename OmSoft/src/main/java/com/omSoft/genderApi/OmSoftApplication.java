package com.omSoft.genderApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OmSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmSoftApplication.class, args);
	}

}
