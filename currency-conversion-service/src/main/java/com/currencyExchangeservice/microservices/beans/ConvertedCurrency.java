package com.currencyExchangeservice.microservices.beans;

public class ConvertedCurrency {

	private CurrencyExchange ce;
	private double qty;
	private double totalAmt;
	public CurrencyExchange getCe() {
		return ce;
	}
	public void setCe(CurrencyExchange ce) {
		this.ce = ce;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public ConvertedCurrency(CurrencyExchange ce, double qty, double totalAmt) {
		super();
		this.ce = ce;
		this.qty = qty;
		this.totalAmt = totalAmt;
	}
	public ConvertedCurrency() {
		super();
	}
	
	
}
