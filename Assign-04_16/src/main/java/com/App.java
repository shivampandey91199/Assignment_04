package com;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Reader r1 = new Reader();
		r1.setReaderId(1);
		r1.setFirstName("oak");
		r1.setLastName("java");
		r1.setEmail("java@gmail.com");

		Reader r2 = new Reader();
		r2.setReaderId(2);
		r2.setFirstName("py");
		r2.setLastName("python");
		r2.setEmail("python@gmail.com");

		Subscription s1 = new Subscription();
		s1.setSubscriptionId(1);
		s1.setSubscriptionName("j");

		Subscription s2 = new Subscription();
		s2.setSubscriptionId(2);
		s2.setSubscriptionName("p");

		Set<Reader> rset = new HashSet<Reader>();
		rset.add(r1);
		rset.add(r2);

		Set<Subscription> sset = new HashSet<Subscription>();
		sset.add(s1);
		sset.add(s2);

		s.save(s1);
		s.save(s2);
		s.save(r1);
		s.save(r2);

		tx.commit();
		s.close();
		sf.close();

	}
}
