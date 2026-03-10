package com.capgemini.java_advance.framework_hibernate_jpa.main;



import java.util.Scanner;

import com.capgemini.java_advance.framework_hibernate_jpa.dao.VehicleDAO;
import com.capgemini.java_advance.framework_hibernate_jpa.entity.Registration;
import com.capgemini.java_advance.framework_hibernate_jpa.entity.Vehicle;



public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleDAO dao = new VehicleDAO();

        System.out.println("Enter brand model registrationNumber expiryDate");

        String brand = sc.next();
        String model = sc.next();
        String number = sc.next();
        String expiry = sc.next();

        Registration r = new Registration();
        r.setRegistrationNumber(number);
        r.setExpiryDate(expiry);

        Vehicle v = new Vehicle();
        v.setBrand(brand);
        v.setModel(model);
        v.setRegistration(r);

        dao.addVehicle(v);

        System.out.println("ID: " + v.getId());
        System.out.println("Brand: " + v.getBrand());
        System.out.println("Model: " + v.getModel());

        System.out.println("Registration:");
        System.out.println("Number: " + v.getRegistration().getRegistrationNumber());
        System.out.println("Expiry Date: " + v.getRegistration().getExpiryDate());
    }
}