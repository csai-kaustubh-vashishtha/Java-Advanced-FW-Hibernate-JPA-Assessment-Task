package com.capgemini.java_advance.framework_hibernate_jpa.entity;



import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    private Registration registration;

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.isEmpty())
            throw new RuntimeException("Brand cannot be empty");
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.isEmpty())
            throw new RuntimeException("Model cannot be empty");
        this.model = model;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}