package com.capgemini.java_advance.framework_hibernate_jpa.entity;



import jakarta.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String registrationNumber;
    private String expiryDate;

    public int getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if(registrationNumber.isEmpty())
            throw new RuntimeException("Registration number cannot be empty");
        this.registrationNumber = registrationNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        if(expiryDate.isEmpty())
            throw new RuntimeException("Expiry date cannot be empty");
        this.expiryDate = expiryDate;
    }
}
