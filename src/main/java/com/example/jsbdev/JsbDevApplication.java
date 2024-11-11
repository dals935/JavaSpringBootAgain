package com.example.jsbdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JsbDevApplication {

	public static void main(String[] args) {

//		System.out.println("Hello, World");
		SpringApplication.run(JsbDevApplication.class, args);
	}

}
