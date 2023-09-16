package com.finzly.FXTrading1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FXTrading1.entity.Ccy;
import com.finzly.FXTrading1.entity.Trade;

/*
 * Author: Meghali Likhar
 * 
 * This is service class for entity Trade
 */
@Repository
public class TradeDao {
	@Autowired
	SessionFactory sf;

	/*
	 * Saves a trade in the database.
	 * 
	 * @param trade The trade to be saved.
	 * 
	 * @return A message indicating the status of the trade booking.
	 */

	public String bookTrade(Trade trade) {
		Session sessionTrade = sf.openSession();
		Criteria criteriaTrade = sessionTrade.createCriteria(Trade.class);
		sessionTrade.save(trade);
		sessionTrade.beginTransaction().commit();

		return "Trade is Booked";

	}

	/*
	 * Retrieves a list of all trades from the database.
	 * 
	 * @return A list of Trade objects representing all trades in the database.
	 */

	public List<Trade> getAllTrade() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		return criteria.list();
	}

}
