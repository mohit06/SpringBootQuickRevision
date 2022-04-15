package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@RestController

public class RequestMapApplication {

	public static void main(String[] args) {
		ApplicationContext t = SpringApplication.run(RequestMapApplication.class, args);
		t.getBean(TimedAspect.class);
		RequestMapApplication j = new RequestMapApplication();
		j.getGreeting();
	}
	
	
	@RequestMapping(
			path = {"{id}/m1","/m2"},
	        headers = {"key1=val1","k2"},
	        
	        produces = {"plain/text"},
	        name = "ReqMap",
	        params = {"p1=23","p2=pp"},
			method = RequestMethod.POST
			
			)
	public String m(@PathVariable int id, @RequestHeader(name = "content-type") Object c, 
			@RequestBody Object o, @RequestParam(name="p1") int p1	) {
		System.out.println(id+" "+c.toString() + " "+o.toString()+" "+p1);
		return "value returned";
	}
	
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		System.out.println(registry.toString());
	    return new TimedAspect(registry);
	}
	    
	@GetMapping("/mk")
	@Timed(value = "greeting.time", description = "Time taken to return greeting")
	public String getGreeting() {
		System.out.println("Method called");
	    return  "NEW VALUE";
	}

}
