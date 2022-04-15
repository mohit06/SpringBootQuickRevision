package com.currencyExchangeservice.microservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyExchangeservice.microservices.beans.CurrencyExchange;
import com.currencyExchangeservice.microservices.repository.Repo;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private Repo repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange currencyExchangeMethod(@PathVariable String from, @PathVariable String to) {
		String port = env.getProperty("local.server.port");
		
		Optional<CurrencyExchange> op =  repo.findByFromAndTo(from, to);
		if(op.isPresent()) {
		CurrencyExchange co = op.get();
		co.setEnvironment(port);
		return co;
		}
		return null;
	} 
}
