package com.angularspringoracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AngularMain {

	public static void main(String[] args) {
		SpringApplication.run(AngularMain.class, args);

	}

}
