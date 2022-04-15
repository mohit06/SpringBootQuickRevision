package com.currencyExchangeservice.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyExchangeservice.microservices.beans.CurrencyExchange;

public interface Repo extends JpaRepository<CurrencyExchange,Integer> {

	public Optional<CurrencyExchange> findByFromAndTo(String from,String to); 
	
}
