package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		student ss = new student();
		ss.setId(20);
		ss.setName("java");

		Address ad = new Address();
		ad.setAid(40);
		ad.setState("gujarat");
		ad.setCity("ahmedabad");
		ad.setStreet("maninagar");

		ss.setAddress(ad);
		ad.setStu(ss);
		
		 s.save(ss);
		 s.save(ad);
		tx.commit();
		s.close();
		sf.close();
	}
}
