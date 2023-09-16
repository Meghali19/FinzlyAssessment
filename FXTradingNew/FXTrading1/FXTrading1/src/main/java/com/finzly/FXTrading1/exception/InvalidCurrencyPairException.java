package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the currencyPair is not valid or entered wrong by the user
 */
public class InvalidCurrencyPairException extends RuntimeException {
	public InvalidCurrencyPairException(String currencyPair) {
		super("Invalid Currnecy Fair: " + currencyPair);
	}

}
