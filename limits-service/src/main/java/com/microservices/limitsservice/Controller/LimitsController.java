package com.microservices.limitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.beans.Limits;
import com.microservices.limitsservice.config.LimitsConfig;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfig lc;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(lc.getMinimum(),lc.getMaximum());
	}

}
