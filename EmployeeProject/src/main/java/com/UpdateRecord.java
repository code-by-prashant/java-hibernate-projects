package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateRecord {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User ID: ");
        int userID = scanner.nextInt();

        Employee emp = session.get(Employee.class, userID);
        
        if (emp == null) {
            System.out.println("Employee with User ID " + userID + " not found.");
        } else {
            System.out.println("Existing Salary: " + emp.getSalary());

            System.out.println("Enter New Salary: ");
            float newSalary = scanner.nextFloat();
            emp.setSalary(newSalary);

            session.update(emp);
            tx.commit();

            System.out.println("Data updated successfully");
        }

    }

}
