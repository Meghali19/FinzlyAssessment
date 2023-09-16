package com.finzly.FXTrading1.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.finzly.FXTrading1.dao.CcyDao;
import com.finzly.FXTrading1.dao.TradeDao;
import com.finzly.FXTrading1.entity.Ccy;
import com.finzly.FXTrading1.entity.Trade;

import com.finzly.FXTrading1.exception.CurrencyPairNotExistException;
import com.finzly.FXTrading1.exception.EmptyNameException;
import com.finzly.FXTrading1.exception.InvalidCurrencyPairException;
import com.finzly.FXTrading1.exception.InvalidTradeAmountException;
import com.finzly.FXTrading1.exception.InvalidTradeNameException;
import com.finzly.FXTrading1.exception.TradeNotFoundException;

/*
 * Author: Meghali Likhar
 * 
 * Service class for Trade Entity
 */

@org.springframework.stereotype.Service
public class TradeService {
	@Autowired
	TradeDao tradeDao;

	@Autowired
	CcyDao ccyDao;

	/*
	 * Method to book a trade, if currency pair is not valid or not present in table
	 * then throw a custom exception
	 */

	public String bookTrade(Trade trade) {

		// Validate trader name
		if (trade.getName() == null || trade.getName().isEmpty()) {
			throw new EmptyNameException();
		}

		// Validate trader name
		if (!trade.getName().matches("^(?!\\.+$)[A-Za-z. ]+$")) {
			throw new InvalidTradeNameException();
		}

		// Validate currency pair
		if (trade.getCurrencyPair() == null || trade.getCurrencyPair().isEmpty()) {
			throw new InvalidCurrencyPairException(trade.getCurrencyPair());
		}

		// Validate trade amount
		if (trade.getAmount() <= 0) {
			throw new InvalidTradeAmountException();
		}

		List<Ccy> listCcy = ccyDao.getAllCcy();

		double convertedAmount;

		boolean validCurrencyPair = false;

		for (Ccy ccyExisting : listCcy) {
			if (trade.getCurrencyPair().equalsIgnoreCase(ccyExisting.getCurrencyPair())) {
				convertedAmount = trade.getAmount() * ccyExisting.getRate();
				trade.setAmount(convertedAmount);
				validCurrencyPair = true;
				return tradeDao.bookTrade(trade);

			}
		}

		if (!validCurrencyPair) {
			throw new InvalidCurrencyPairException(trade.getCurrencyPair());
		}

		// If the currency is not found in the table, throw CurrencyNotFoundException
		throw new CurrencyPairNotExistException(trade.getCurrencyPair());

	}

	/*
	 * Method to get a list of trades
	 * 
	 * @return containing the list of trades or an error message if no trades are
	 * available.
	 */

	public List<Trade> getAllTrade() {

		List<Trade> trades = tradeDao.getAllTrade();
		if (trades.isEmpty()) {
			throw new TradeNotFoundException();
		}
		return trades;

	}

}
