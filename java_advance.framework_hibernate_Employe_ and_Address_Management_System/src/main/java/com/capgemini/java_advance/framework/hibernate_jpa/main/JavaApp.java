package com.capgemini.java_advance.framework.hibernate_jpa.main;

import java.util.Scanner;

import com.capgemini.java_advance.framework.hibernate_jpa.dao.EmployeeDAO;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Address;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Employee;

public class JavaApp {

    public static void execution() {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while(true) {

            System.out.println("\n========= Employee Management System =========");
            System.out.println("1 Add Employee");
            System.out.println("2 Search Employee");
            System.out.println("3 Update Salary");
            System.out.println("4 Update Address");
            System.out.println("5 Delete Employee");
            System.out.println("6 Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.println("\n--- Add Employee ---");

                sc.nextLine();

                
                
                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();
                
              
                System.out.print("Enter Employee Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Employee Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Street: ");
                String street = sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter Zipcode: ");
                String zip = sc.nextLine();

                Address address = new Address(street, city, zip);
                Employee emp = new Employee(name, email, salary, address);

                dao.addEmployee(emp);

                break;

            case 2:

                System.out.println("\n--- Search Employee ---");

                System.out.print("Enter Employee ID to search: ");
                int id = sc.nextInt();

                dao.searchEmployee(id);

                break;

            case 3:

                System.out.println("\n--- Update Employee Salary ---");

                System.out.print("Enter Employee ID: ");
                int empId = sc.nextInt();

                System.out.print("Enter New Salary: ");
                double newSalary = sc.nextDouble();

                dao.updateSalary(empId, newSalary);

                break;

            case 4:

                System.out.println("\n--- Update Employee Address ---");

                System.out.print("Enter Employee ID: ");
                int id2 = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Street: ");
                String st = sc.nextLine();

                System.out.print("Enter New City: ");
                String ct = sc.nextLine();

                System.out.print("Enter New Zipcode: ");
                String zp = sc.nextLine();

                dao.updateAddress(id2, st, ct, zp);

                break;

            case 5:

                System.out.println("\n--- Delete Employee ---");

                System.out.print("Enter Employee ID to delete: ");
                int delId = sc.nextInt();

                dao.deleteEmployee(delId);

                break;

            case 6:

                System.out.println("Program terminated.");
                return;

            default:

                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}