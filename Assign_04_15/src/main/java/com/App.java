package com;

import java.util.HashSet;
import java.util.Set;

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
	   
		   SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	       Session s=sf.openSession();
	       Transaction tx=s.beginTransaction();
	       
	       
	        Cart c=new Cart();
	        c.setName("My Cart");
	        c.setTotal(0.0);
	        
	        item i=new item();
	        i.setItemId("item1");
	        i.setItemTotal(10.0);
	        i.setQuantity(4);
	        
	        item i2=new item();
	        i2.setItemId("item2");
	        i2.setItemTotal(100.0);
	        i2.setQuantity(5);
	        
	        
	        Set<item> set=new HashSet<item>();
	        set.add(i2);
	        set.add(i);
	        
	       c.setItems(set);
	       i.setCart(c);
	       i2.setCart(c);
	       
	       
	       s.save(c);
	       s.save(i);
	       s.save(i2);
	       
	       tx.commit();
	       s.close();
	       sf.close();
	
	}
}
