package com.finzly.FXTrading1.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * This class is for handling all the exception
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * This Method is going to through exception when amount is invalid
	 */
	@ExceptionHandler(InvalidTradeAmountException.class)
	public String invalidTradeAmountException(InvalidTradeAmountException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when Ccy pair is not present in
	 * table
	 */
	@ExceptionHandler(CcyNotFoundException.class)
	public String ccyNotFoundException(CcyNotFoundException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when currency pair does not exist
	 * in databse
	 */
	@ExceptionHandler(CurrencyPairNotExistException.class)
	public String currencyPairNotExistException(CurrencyPairNotExistException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when Name is Enpty
	 */
	@ExceptionHandler(EmptyNameException.class)
	public String emptyNameException(EmptyNameException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when currencyPair is invalid
	 */
	@ExceptionHandler(InvalidCurrencyPairException.class)
	public String invalidCurrencyPairException(InvalidCurrencyPairException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when rate is invalid
	 */
	@ExceptionHandler(InvalidRateException.class)
	public String invalidRateException(InvalidRateException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when Trade is invalid
	 */
	@ExceptionHandler(InvalidTradeNameException.class)
	public String invalidTradeNameException(InvalidTradeNameException e) {
		return e.getMessage();
	}

	/*
	 * This Method is going to through exception when trade is not presednt in
	 * database
	 */
	@ExceptionHandler(TradeNotFoundException.class)
	public String tradeNotFoundException(TradeNotFoundException e) {
		return e.getMessage();
	}
}
