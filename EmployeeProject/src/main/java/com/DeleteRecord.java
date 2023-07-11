package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User ID: ");
        int userID = scanner.nextInt();
        emp.setUserID(userID);
        
        session.delete(emp);
        tx.commit();
        
        System.out.println("Data deleted successfully");

	}

}
