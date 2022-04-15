package com.example.demo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Endpoint(id = "helloWorld")
@Component
public class HelloWorldEndpoint {

	
	//Get Request Query params
	@ReadOperation
	public String helloWorld( String name) {
		  return "Hello World"+ " "+ name;
		}
	
	// Get Request Path VAriable
	@ReadOperation
	public String helloWorld2(@Selector String name) {
		  return "Hello World2"+ " "+ name;
		}
	
	
	
}
