package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there currencyPair does not match with the value present in database 
 */
public class CurrencyPairNotExistException extends RuntimeException {
	public CurrencyPairNotExistException(String currencyPair) {
		super("Currency Pair Not Exist" + currencyPair);
	}

}
