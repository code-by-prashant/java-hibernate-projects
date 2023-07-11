package com;

import java.util.Scanner;

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
        
        Product product = new Product();

        Scanner scanner = new Scanner(System.in);

		/*
		 * System.out.println("Enter Product ID: "); int productID = scanner.nextInt();
		 * product.setProductID(productID);
		 */

        System.out.println("Enter Name: ");
        String name = scanner.next();
        product.setName(name);

        System.out.println("Enter Price: ");
        float price = scanner.nextInt();
        product.setPrice(price);

        System.out.println("Enter Product Description: ");
        String description = scanner.next();
        product.setDescription(description);

        session.save(product);
        tx.commit();

        System.out.println("Data inserted successfully");
	}

}
