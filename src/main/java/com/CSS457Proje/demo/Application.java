package com.CSS457Proje.demo;

import com.CSS457Proje.demo.controller.ExtraFeaturesController;
import com.CSS457Proje.demo.controller.ReviewController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ExtraFeaturesController extraFeaturesController;
		ReviewController reviewController;
	}

}
