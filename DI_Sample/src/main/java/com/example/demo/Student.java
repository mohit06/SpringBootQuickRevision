package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String name;
	
	public Student(){
		this.name = "Mohit";
	}

	public String getName() {
		return this.name;
	}
}
