package com.basics.begin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basics.begin.Formatter1;
import com.basics.begin.services.BasicService;

@Controller
public class BasicController {
	
	@Autowired
	public BasicService bs;
	
	
	@Autowired
	@Qualifier("b1")
	private Formatter1 Formatter;
	
	@GetMapping("/link1")
	@ResponseBody
	public String link1() {
		return bs.businessLogic();
	}
	
	
	@GetMapping("/link2")
	public String link2() {
		return "Link 2 called.";
	}

}
