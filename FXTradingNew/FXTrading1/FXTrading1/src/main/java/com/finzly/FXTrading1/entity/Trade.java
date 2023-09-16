package com.finzly.FXTrading1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Author: Meghali Likhar
 * Entity class for Trade.
 */
@Entity
public class Trade {
	@Id
	@Column(name = "trade_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeNo;
	protected String name;
	protected String currencyPair;
	protected double amount;
	private double convertedAmount;

	/*
	 * GETTERS And SETTERS
	 */

	public int getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}

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

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNo + ", name=" + name + ", currencyPair=" + currencyPair + ", amount=" + amount
				+ ", convertedAmount=" + convertedAmount + "]";
	}

}
