package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the Rate is not valid or entered wrong by the user
 */
public class InvalidRateException extends RuntimeException {
	public InvalidRateException() {
		super("Invalid Rate....Enter Proper Rate");
	}

}
