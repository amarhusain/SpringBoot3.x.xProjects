package com.beat.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

}
