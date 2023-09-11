package com.finzly.FXTrading.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrading.Model.Trade;
import com.finzly.FXTrading.Service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {
	/*
	 * Autowire the TradeService to handle trade-related operations
	 */
	@Autowired
	private TradeService tradeservice;

	/*
	 * POST endpoint to book a trade.
	 * 
	 * @param trade The trade details provided in the request body.
	 * 
	 * @return ResponseEntity containing a map with a message indicating the status
	 * of the trade booking.
	 */
	@PostMapping("bookTrade")
	public ResponseEntity<Map<String, String>> bookTrade(@RequestBody Trade trade) {

		try {
			// Attempt to book the trade
			return tradeservice.bookTrade(trade);
		} catch (Exception ex) {
			/*
			 * Handle unexpected exceptions Return a 500 Internal Server Error response with
			 * a generic error message
			 */
			Map<String, String> errorResponse = Map.of("error", "An unexpected error occurred.");
			return ResponseEntity.status(500).body(errorResponse);
		}
	}

	/*
	 * GET endpoint to retrieve a list of trades.
	 * 
	 * @return ResponseEntity containing the list of trades or an error message if
	 * no trades are available.
	 */
	@GetMapping("getTrade")
	public ResponseEntity<Object> getTrade() {

		try {
			// Attempt to retrieve the list of trades
			return tradeservice.getTrades();
		} catch (Exception ex) {

			/*
			 * Handle unexpected exceptions Return a 500 Internal Server Error response with
			 * a generic error message
			 */
			Map<String, String> errorResponse = Map.of("error", "An unexpected error occurred.");
			return ResponseEntity.status(500).body(errorResponse);
		}
	}

}



