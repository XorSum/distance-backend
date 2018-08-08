package com.example.distance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class DistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceApplication.class, args);
	}
}
