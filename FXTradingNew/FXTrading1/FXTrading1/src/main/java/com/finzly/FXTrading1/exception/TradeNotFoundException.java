package com.finzly.FXTrading1.exception;

/*
 * This is the Custom exception class for throwing exception if 
 * there the trade is not present in the database
 */
public class TradeNotFoundException extends RuntimeException {
	public TradeNotFoundException() {
		super("No trades are available.");
	}

}
