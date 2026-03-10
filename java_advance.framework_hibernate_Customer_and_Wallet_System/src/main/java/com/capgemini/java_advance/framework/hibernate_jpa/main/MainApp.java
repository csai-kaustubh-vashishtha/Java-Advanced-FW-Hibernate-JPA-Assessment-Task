package com.capgemini.java_advance.framework.hibernate_jpa.main;




import java.util.Scanner;

import com.capgemini.java_advance.framework.hibernate_jpa.dao.CustomerDAO;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Customer;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Wallet;





public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerDAO dao = new CustomerDAO();

        System.out.println("Enter name email balance currency");

        String name = sc.next();
        String email = sc.next();
        double balance = sc.nextDouble();
        String currency = sc.next();

        Wallet w = new Wallet();
        w.setBalance(balance);
        w.setCurrency(currency);

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setWallet(w);

        dao.addCustomer(c);

        System.out.println("ID: " + c.getId());
        System.out.println("Name: " + c.getName());
        System.out.println("Email: " + c.getEmail());

        System.out.println("Wallet:");
        System.out.println("Balance: " + c.getWallet().getBalance());
        System.out.println("Currency: " + c.getWallet().getCurrency());

    }
}