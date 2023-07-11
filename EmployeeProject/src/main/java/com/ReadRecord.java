package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReadRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        
        List empList = session.createQuery("FROM Employee").list();
        
        Iterator i = empList.iterator();
        
        while(i.hasNext()) {
        	 emp = (Employee)i.next();
        	
         	System.out.println("\nID: " + emp.getUserID());
        	System.out.println("NAME: " + emp.getName());
     		System.out.println("AGE: " + emp.getAge());
     		System.out.println("SALARY: " + emp.getSalary());
     		System.out.println("DESIGNATION: " + emp.getDesignation());
        }
        
	}

}
