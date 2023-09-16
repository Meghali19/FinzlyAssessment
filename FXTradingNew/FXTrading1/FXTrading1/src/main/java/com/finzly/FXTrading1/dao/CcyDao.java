package com.finzly.FXTrading1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FXTrading1.entity.Ccy;


/*
 * Author: Meghali Likhar
 * 
 * This is service class for entity Ccy
 */
@Repository
public class CcyDao {
	@Autowired
	SessionFactory sf;

	/*
	 * This method is to insert the Ccy properties in database or check for
	 * validations
	 */
	public String insertCcy(Ccy ccy) {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Ccy.class);
		List<Ccy> list = criteria.list();

		for (Ccy ccyExisting : list) {
			if (!ccyExisting.getCurrencyPair().equalsIgnoreCase(ccy.getCurrencyPair())) {
				session.save(ccy);
				session.beginTransaction().commit();
				return "Currency Pair along with corresponding rate is Added..!!";
			} else {
				return "Currency Pair Already Exist...!!";
			}

		}

		return "Invalid Currency Pair...!!";

	}

	/*
	 * Retrieves a list of all currency (Ccy) entities from the database.
	 * 
	 * @return A list of Ccy objects representing all currency pairs with rates in
	 * the database.
	 */

	public List<Ccy> getAllCcy() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Ccy.class);
		return criteria.list();

	}

	/*
	 * This method is to Update the Ccy properties in database
	 */
	public String updateCcyRate(String currencyPair, Ccy ccy) {
		Session session = sf.openSession();
		Ccy existingCcy = session.get(Ccy.class, currencyPair);

		if (existingCcy != null) {

			existingCcy.setRate(ccy.getRate());

			session.update(existingCcy);
			session.beginTransaction().commit();
			return "Currency Pair with Updated";

		} else {
			return "Currency Pair not found";
		}

	}

}
