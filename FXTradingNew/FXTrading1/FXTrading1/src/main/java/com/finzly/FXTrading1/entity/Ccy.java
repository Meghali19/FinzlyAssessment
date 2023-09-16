package com.finzly.FXTrading1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Author:Meghali Likhar
 * Entity class for ccy
 */
@Entity
public class Ccy {
	private String currencyPair;
	private double rate;

	/*
	 * Getters and Setters
	 */

	@Id
	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Ccy [currencyPair=" + currencyPair + ", rate=" + rate + "]";
	}

}
