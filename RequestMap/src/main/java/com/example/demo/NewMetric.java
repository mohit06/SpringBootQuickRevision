package com.example.demo;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
@Component
public class NewMetric {

	private MeterRegistry reg;
	
	public NewMetric(MeterRegistry re) {
		this.reg=re;
		this.init();
	}
	
	public void init() {
		 Counter lightOrderCounter = this.reg.counter("beer.orders", "type", "light"); // 1 - create a counter
			/*
			 * Object aleOrderCounter = Counter.builder("beer.orders") // 2 - create a
			 * counter using the fluent API .tag("type", "ale")
			 * .description("The number of orders ever placed for Ale beers")
			 * .register(reg);
			 */
	}
	
	
}
