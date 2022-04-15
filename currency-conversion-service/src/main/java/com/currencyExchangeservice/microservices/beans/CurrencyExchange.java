package com.currencyExchangeservice.microservices.beans;




public class CurrencyExchange {

	private int id;
	private String from;
	private String to;
	private double rate;
	private String environment;
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", rate=" + rate + ", environment="
				+ environment + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange( String from, String to, double rate, String environment) {
		super();
		
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.environment = environment;
	}
	
	
	
}
