package com.currencyExchangeservice.microservices.controller;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = Logger.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample", fallbackMethod = "hardcodeMethod")
	@CircuitBreaker(name = "sampleBreaker", fallbackMethod = "hardcodeMethod")
	@RateLimiter(name="default") // 10sec 10000 calls only to the method.
	@Bulkhead(name="default") // how many concurrent calls are allowed
	public String getApi() {
		logger.info("Retrying....");
	    ResponseEntity<String>  r = 	new RestTemplate().getForEntity("http://localhost:9090/getMyPorno",String.class);
		return r.getBody();
	}
	
	public String hardcodeMethod(Exception ex) {
		return "fallback-called.";
	}

}
