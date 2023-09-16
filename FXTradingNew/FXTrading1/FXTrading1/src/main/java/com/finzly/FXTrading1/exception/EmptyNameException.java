package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the name enter by user is null or empty 
 */
public class EmptyNameException extends RuntimeException {
	public EmptyNameException() {
		super("Name should not be Empty");
	}

}
