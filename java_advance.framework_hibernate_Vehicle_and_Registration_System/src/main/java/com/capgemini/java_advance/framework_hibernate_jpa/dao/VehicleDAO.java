package com.capgemini.java_advance.framework_hibernate_jpa.dao;


import com.capgemini.java_advance.framework_hibernate_jpa.entity.Vehicle;

import jakarta.persistence.*;


public class VehicleDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle");
    EntityManager em = emf.createEntityManager();

    public void addVehicle(Vehicle vehicle) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(vehicle);

        tx.commit();

        System.out.println("Vehicle added successfully");
    }

    public Vehicle searchVehicle(int id) {

        Vehicle v = em.find(Vehicle.class, id);

        if(v == null)
            System.out.println("Vehicle not found");

        return v;
    }

    public void updateRegistration(int vehicleId, String newExpiryDate) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Vehicle v = em.find(Vehicle.class, vehicleId);

        if(v != null) {
            v.getRegistration().setExpiryDate(newExpiryDate);
            em.merge(v);
            System.out.println("Registration updated successfully");
        }

        tx.commit();
    }

    public void deleteVehicle(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Vehicle v = em.find(Vehicle.class, id);

        if(v != null) {
            em.remove(v);
            System.out.println("Vehicle deleted successfully");
        }

        tx.commit();
    }
}