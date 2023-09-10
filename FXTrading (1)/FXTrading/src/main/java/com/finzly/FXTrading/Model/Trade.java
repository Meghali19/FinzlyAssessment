package com.finzly.FXTrading.Model;

//import com.finzly.FXTrading.Service.TradeService;

public class Trade
{
	protected static double rate = 66.00;
	private static int count = 0;
	private int tradeNo;
	protected String name;
	protected String currencyPair;
	protected double amount;
	private double convertedAmount;

	
	//Default CONSTRUCTOR
	public Trade()
	{
		
	}
	
	
    //Parameterized CONTRUCTORS
	public Trade(String name, String currencyPair, double amount, double convertedAmount) 
	{
		
		this.tradeNo = ++count;
		this.name = name;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
		
	}

    
	//GETTERS And SETTERS
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getCurrencyPair() {
		return currencyPair;
	}
	
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	

	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	public static double getRate() {
		return rate;
	}
	
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	

	@Override
    public String toString()
    {
		return tradeNo + "\t" + currencyPair.toUpperCase() + "\t" + name + "\t" + convertedAmount + "\t" + getRate();
    }


	

}
