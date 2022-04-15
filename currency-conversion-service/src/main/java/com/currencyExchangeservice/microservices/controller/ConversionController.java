package com.currencyExchangeservice.microservices.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyExchangeservice.microservices.beans.ConvertedCurrency;
import com.currencyExchangeservice.microservices.beans.CurrencyExchange;
import com.currencyExchangeservice.microservices.beans.CurrencyExchangeProxy;

@RestController
public class ConversionController {

	@Autowired
	private CurrencyExchangeProxy cep;
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{qty}")
	public ConvertedCurrency convertCurrency(@PathVariable String from, @PathVariable String to, 
			@PathVariable double qty) {
	
		CurrencyExchange responseEntity =  cep.convertCurrency(from, to);
		responseEntity.setEnvironment(responseEntity.getEnvironment()+" feign");
		ConvertedCurrency coc = new ConvertedCurrency(responseEntity,qty,responseEntity.getRate()*qty);
		return coc;
		
	}
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{qty}")
	public ConvertedCurrency convertCurrencyFeign(@PathVariable String from, @PathVariable String to, 
			@PathVariable double qty) {
		HashMap<String,String> uriVariables = new HashMap<>();;
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyExchange> responseEntity =  new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}/",
				CurrencyExchange.class,uriVariables);
		CurrencyExchange cc = responseEntity.getBody();
		ConvertedCurrency coc = new ConvertedCurrency(cc,qty,cc.getRate()*qty);
		return coc;
		
	}
	
}
