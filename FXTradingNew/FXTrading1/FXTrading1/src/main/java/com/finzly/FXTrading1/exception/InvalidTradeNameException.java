package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the name is not valid or entered wrong by the user
 */
public class InvalidTradeNameException extends RuntimeException {
	public InvalidTradeNameException() {
		super("Proper Trader Name is required.");
	}
}
