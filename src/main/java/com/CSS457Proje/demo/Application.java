package com.CSS457Proje.demo;

import com.CSS457Proje.demo.controller.ExtraFeaturesController;
import com.CSS457Proje.demo.controller.ProductController;
import com.CSS457Proje.demo.controller.ReviewController;
import com.CSS457Proje.demo.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ProductController productController;
		ExtraFeaturesController extraFeaturesController;
		ReviewController reviewController;
	}

}
