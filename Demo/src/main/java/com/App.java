package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
		
		emp.setUserID(2);
		emp.setName("Abhay");
		emp.setDesignation("Tester");
		
		session.save(emp);
		tx.commit();
		
		System.out.println("Data inserted successfully");
	}

}
