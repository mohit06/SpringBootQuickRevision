package com.aop.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class NewController {

	@GetMapping("/link3")
	public String link1() 
	{
		System.out.println("link3 called...");
		return "Yellow3";
	}
	
}
