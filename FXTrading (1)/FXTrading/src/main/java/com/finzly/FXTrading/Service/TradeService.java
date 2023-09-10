package com.finzly.FXTrading.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrading.Model.Trade;

@Service
public class TradeService
{
	private static List<Trade> trades = new LinkedList<>();

	private static double convertedAmount;
	
	
	public Map<String,String> isNull(Trade trade)
	{
		Map<String,String> result = new HashMap<>();
		
		if(trade.getName()==null)
			result.put("Customer_Name", "Customer name cannot be empty!");
		
		if(trade.getCurrencyPair()==null)
			result.put("Currency_Pair", "Currency Pair cannot be empty!");
		
		if(!trade.getCurrencyPair().equalsIgnoreCase("USDINR"))
			result.put("Currency_Pair", "Currency Pair should be 'USDINR' only!");
		
		if(trade.getAmount()<=0)
			result.put("Amount", "Amount should be a Positve Number!");
		
		return result;
			
	}
    
	
	
	public ResponseEntity<Map<String, String>> bookTrade(Trade trade)
	{
		Map<String,String> result1 = new HashMap<>();
		result1 = isNull(trade);
		
		if(!(result1.isEmpty()))
		{
			result1.put("Message","Trade not booked");   
            return ResponseEntity.badRequest().body(result1);
		}
		
		
		if(result1.isEmpty())
		{
			double amount = trade.getAmount();
			convertedAmount = amount * Trade.getRate();
			trade.setConvertedAmount(convertedAmount);
		
			Trade bookTrade = new Trade(trade.getName(), trade.getCurrencyPair().toUpperCase(), trade.getAmount(), trade.getConvertedAmount());
			trades.add(bookTrade);
			
			result1.put("Message", "Trade for " + trade.getCurrencyPair() + " has been booked with rate of " + Trade.getRate() + ". The amount of Rs " + trade.getConvertedAmount() + " will be transferred in 2 working days to " + trade.getName());
            return ResponseEntity.ok().body(result1);
		}
	
		
		result1.put("Message","Trade not booked");
        return ResponseEntity.badRequest().body(result1); 
	}
	
	
	public ResponseEntity<Object> getTrades()
	{
		 if(trades.isEmpty())
		 {
             return ResponseEntity.badRequest().body("No Trade Information available");
	     }

	         return ResponseEntity.ok().body(trades);
    }



	
		
	
}
