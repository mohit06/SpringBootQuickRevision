package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
@Controller
public class DIClass {
	
	private Student st;
	
@RequestMapping( )
	public DIClass(Student st){
		System.out.println("Student = "+st.getName());
		this.st =st;
	}
	
	public Student getStudent() {
		return st;
	}

}
