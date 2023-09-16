package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there is no currencyPair with its rate present in database
 */
public class CcyNotFoundException extends RuntimeException {
	public CcyNotFoundException() {
		super("No Currency Pair along with rate is found");
	}

}
