package com.finzly.FXTrading1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrading1.entity.Ccy;
import com.finzly.FXTrading1.service.CcyService;

/*
 * Author: Meghali Likhar 
 * 
 * This is controller class for entity Ccy
 */
@RestController
public class CcyController {

	@Autowired
	CcyService ccyService;

	
	/*
	 * Endpoint for inserting a new currency (Ccy) into the
	 * system.
	 * 
	 * @param ccy The Ccy object to be inserted.
	 * 
	 * @return A message indicating the status of the currency insertion.
	 */

	@PostMapping("insertCcy")
	public String insertCcy(@RequestBody Ccy ccy) {
		return ccyService.insertCcy(ccy);
	}

	
	/*
	 * Endpoint for retrieving a list of all currencies (Ccy)
	 * in the system.
	 * 
	 * @return A list of Ccy objects representing all currency pairs with their
	 * rates in the system.
	 */

	@GetMapping("getAllCcy")
	public List<Ccy> getAllCcy() {
		return ccyService.getAllCcy();
	}

	
	/*
	 * Endpoint for updating a currency pair with its
	 * rate(Ccy) into the system.
	 * 
	 * @param ccy The Ccy object to be updated, and currencyPair to get that
	 * particular row to be updated .
	 * 
	 * @return A message indicating the status of the currency Updation.
	 */

	@PutMapping("updateCcy/{currencyPair}")
	public String updateCcyRate(@PathVariable String currencyPair, @RequestBody Ccy ccy) {
		return ccyService.updateCcyRate(currencyPair, ccy);
	}
}
