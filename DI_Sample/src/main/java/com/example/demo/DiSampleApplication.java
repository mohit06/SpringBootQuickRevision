package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiSampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiSampleApplication.class, args);
		DIClass c = context.getBean(DIClass.class);
		System.out.println(c.getStudent().getName());
	}

}
