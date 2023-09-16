package com.finzly.FXTrading1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.FXTrading1.dao.CcyDao;
import com.finzly.FXTrading1.entity.Ccy;
import com.finzly.FXTrading1.entity.Trade;

import com.finzly.FXTrading1.exception.CcyNotFoundException;
import com.finzly.FXTrading1.exception.InvalidCurrencyPairException;
import com.finzly.FXTrading1.exception.InvalidRateException;



/*
 * Author: Meghali Likhar
 * Service class for Ccy Entity
 */
@Service
public class CcyService {

	@Autowired
	CcyDao ccyDao;

	/*
	 * @param ccy containing detail to be added in the table
	 * 
	 * Insert a currency Pair along with rate (Ccy) in the database.
	 * 
	 * @return proper message of Insertion or error message
	 */

	public String insertCcy(Ccy ccy) {

		// Validate currency pair
		if (ccy.getCurrencyPair() == null || ccy.getCurrencyPair().isEmpty()) {
			throw new InvalidCurrencyPairException(ccy.getCurrencyPair());
		}

		// Validate Ccy Rate
		if (ccy.getRate() <= 0) {
			throw new InvalidRateException();
		}

		return ccyDao.insertCcy(ccy);
	}

	/*
	 * Retrieves a list of all currency (Ccy) entities from the database.
	 * 
	 * @return A list of Ccy objects representing all currency pairs with rates in
	 * the database.
	 */

	public List<Ccy> getAllCcy() {

		List<Ccy> ccy = ccyDao.getAllCcy();
		if (ccy.isEmpty()) {
			throw new CcyNotFoundException();
		}
		return ccy;
	}

	/*
	 * @param on the basis of currencyPair, we are updating ccy.
	 * 
	 * Update a currency Pair along with rate (Ccy) on the basis of id in the
	 * database.
	 * 
	 * @return proper message of updation or error message
	 */

	public String updateCcyRate(String currencyPair, Ccy ccy) {

		// Validate currency pair
		if (ccy.getCurrencyPair() == null || ccy.getCurrencyPair().isEmpty()) {
			throw new InvalidCurrencyPairException(ccy.getCurrencyPair());
		}

		// Validate Ccy Rate
		if (ccy.getRate() <= 0) {
			throw new InvalidRateException();
		}

		return ccyDao.updateCcyRate(currencyPair, ccy);

	}
}
