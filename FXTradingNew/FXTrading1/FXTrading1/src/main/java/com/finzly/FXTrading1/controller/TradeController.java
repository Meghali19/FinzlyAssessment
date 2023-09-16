package com.finzly.FXTrading1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrading1.entity.Ccy;
import com.finzly.FXTrading1.entity.Trade;
import com.finzly.FXTrading1.service.TradeService;

/*
 * Author: Meghali Likhar
 *  
 * This is controller class for entity Trade
 */
@RestController
public class TradeController {
	@Autowired
	TradeService tradeService;

	/* 
	 * POST endpoint to book a trade.
	 * 
	 * @param trade The trade details provided in the request body.
	 * 
	 * @return containing a List with a message indicating the status of the trade
	 * booking.
	 */

	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);
	@PostMapping("bookTrade")
	public String bookTrade(@RequestBody Trade trade) {
		logger.info("traade"+trade.getCurrencyPair()+" "+trade.getTradeNo());
		return tradeService.bookTrade(trade);
	}

	
	/*
	 * GET endpoint to retrieve a list of trades.
	 * 
	 * @return containing the list of trades or an error message if no trades are
	 * available.
	 */

	@GetMapping("getAllTrade")
	public List<Trade> getAllTrade() {
		return tradeService.getAllTrade();
	}

}
