package com.aop.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	
	@GetMapping("/link1")
	public String link1() 
	{
		System.out.println("link1 called...");
		return "Yellow";
	}
	
	@GetMapping("/link2")
	public String link2() 
	{
		System.out.println("link2 called...");
		return "Yellow2";
	}
}
