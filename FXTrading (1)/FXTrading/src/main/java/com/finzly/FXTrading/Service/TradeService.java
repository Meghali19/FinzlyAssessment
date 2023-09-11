package com.finzly.FXTrading.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrading.Model.Trade;

@Service
public class TradeService {
	// List to store trade objects
	private static List<Trade> trades = new LinkedList<>();

	// Static variable to store converted amount
	private static double convertedAmount;

	// Method to validate trade object fields
	public Map<String, String> isNull(Trade trade) {
		Map<String, String> result = new HashMap<>();

		// Check if customer name is null
		if (trade.getName() == null)
			result.put("Customer_Name", "Customer name cannot be empty!");

		// Check if currency pair is null
		if (trade.getCurrencyPair() == null)
			result.put("Currency_Pair", "Currency Pair cannot be empty!");

		// Check if currency pair is not 'USDINR'
		if (!trade.getCurrencyPair().equalsIgnoreCase("USDINR"))
			result.put("Currency_Pair", "Currency Pair should be 'USDINR' only!");

		// Check if amount is not a positive number
		if (trade.getAmount() <= 0)
			result.put("Amount", "Amount should be a Positve Number!");

		return result;

	}

	// Method to book a trade
	public ResponseEntity<Map<String, String>> bookTrade(Trade trade) {
		Map<String, String> result1 = new HashMap<>();
		result1 = isNull(trade);

		try {
			// If there are validation errors, return a bad request response
			if (!(result1.isEmpty())) {
				result1.put("Message", "Trade not booked");
				return ResponseEntity.badRequest().body(result1);
			}

			// If there are no validation errors, proceed to book the trade
			if (result1.isEmpty()) {
				double amount = trade.getAmount();

				// Calculate the converted amount based on the rate
				convertedAmount = amount * Trade.getRate();
				trade.setConvertedAmount(convertedAmount);

				// Create a new Trade object and add it to the list
				Trade bookTrade = new Trade(trade.getName(), trade.getCurrencyPair().toUpperCase(), trade.getAmount(),
						trade.getConvertedAmount());
				trades.add(bookTrade);

				result1.put("Message",
						"Trade for " + trade.getCurrencyPair() + " has been booked with a rate of " + Trade.getRate()
								+ ". The amount of Rs " + trade.getConvertedAmount()
								+ " will be transferred in 2 working days to " + trade.getName());

				// Return a successful response
				return ResponseEntity.ok().body(result1);
			}
		} catch (Exception ex) {
			// Handle unexpected exceptions and return an error response
			result1.put("Message", "Trade not booked due to an unexpected error.");
			return ResponseEntity.status(500).body(result1);
		}

		// If there was an unexpected error, return a bad request response
		result1.put("Message", "Trade not booked");
		return ResponseEntity.badRequest().body(result1);
	}

	/*
	 * Method to get a list of trades
	 * 
	 * @return ResponseEntity containing the list of trades or an error message if
	 * no trades are available.
	 */
	public ResponseEntity<Object> getTrades() {
		try {
			if (trades.isEmpty()) {
				return ResponseEntity.badRequest().body("No Trade Information available");
			}

			// If there are trades, return them in a successful response
			return ResponseEntity.ok().body(trades);
		} catch (Exception ex) {
			// Handle unexpected exceptions and return an error response
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "An unexpected error occurred.");
			return ResponseEntity.status(500).body(errorResponse);
		}
	}

}
