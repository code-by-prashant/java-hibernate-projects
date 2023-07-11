package com;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUDOperations {
    public static void main(String[] args) {
    	
        // set up the Hibernate environment
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // create a SessionFactory to interact with the database.
        SessionFactory factory = cfg.buildSessionFactory();

        // open a session, it provides methods for querying, 
        // saving, updating, and deleting objects.
        Session session = factory.openSession();

        // initialize Transaction object to null, will use this
        // object to manage transactions during database operations.
        Transaction tx = null;

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    create(session);
//                    App.main(args);
                    break;
                case 2:
                    read(session);
                    break;
                case 3:
                    update(session);
                    break;
                case 4:
                    delete(session);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
        session.close();
        factory.close();
    }

    private static void create(Session session) {
        System.out.println("Performing create operation...");

        // create a new Employee object
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

        // begin transaction
        Transaction tx = session.beginTransaction();
        // save the employee object to the database
        session.save(emp);
        // commit the transaction
        tx.commit();

        System.out.println("Data inserted successfully");
    }

    private static void read(Session session) {
        System.out.println("Performing read operation...");

        // fetch all employee records from the database
        List<Employee> empList = session.createQuery("FROM Employee").list();

        // iterate over the employee list and display the details
        for (Employee emp : empList) {
            System.out.println("\nID: " + emp.getUserID());
            System.out.println("NAME: " + emp.getName());
            System.out.println("AGE: " + emp.getAge());
            System.out.println("SALARY: " + emp.getSalary());
            System.out.println("DESIGNATION: " + emp.getDesignation());
        }
    }

    private static void update(Session session) {
        System.out.println("Performing update operation...");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User ID: ");
        int userID = scanner.nextInt();

        // retrieve the employee object with the given user ID
        Employee emp = session.get(Employee.class, userID);

        if (emp == null) {
            System.out.println("Employee with User ID " + userID + " not found.");
        } else {
            System.out.println("Existing Salary: " + emp.getSalary());

            System.out.println("Enter New Salary: ");
            float newSalary = scanner.nextFloat();
            emp.setSalary(newSalary);

            // begin transaction
            Transaction tx = session.beginTransaction();
            // update the employee object in the database
            session.update(emp);
            // commit the transaction
            tx.commit();

            System.out.println("Data updated successfully");
        }
    }

    private static void delete(Session session) {
        System.out.println("Performing delete operation...");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User ID: ");
        int userID = scanner.nextInt();

        // retrieve the employee object with the given user ID
        Employee emp = session.get(Employee.class, userID);

        if (emp == null) {
            System.out.println("Employee with User ID " + userID + " not found.");
        } else {
            // begin transaction
            Transaction tx = session.beginTransaction();
            // delete the employee object from the database
            session.delete(emp);
            // commit the transaction
            tx.commit();

            System.out.println("Data deleted successfully");
        }
    }
}
