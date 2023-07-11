package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {

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

        System.out.println("Enter Name: ");
        String name = scanner.next();
        emp.setName(name);

        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        emp.setAge(age);

        System.out.println("Enter Salary: ");
        float salary = scanner.nextFloat();
        emp.setSalary(salary);

        System.out.println("Enter Designation: ");
        String designation = scanner.next();
        emp.setDesignation(designation);

        session.save(emp);
        tx.commit();

        System.out.println("Data inserted successfully");
    }

}
