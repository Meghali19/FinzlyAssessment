package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the Amount is not valid or entered wrong by the user
 */
public class InvalidTradeAmountException extends RuntimeException {
	public InvalidTradeAmountException() {
		super("Trade amount must be greater than zero.");
	}

}
