package com.web_service.my_first_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringAppApplication.class, args);
		System.out.println("Hii");
	}

}
