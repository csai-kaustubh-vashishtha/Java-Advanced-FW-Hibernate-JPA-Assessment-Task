package com.capgemini.java_advance.framework.hibernate_jpa.dao;


import com.capgemini.java_advance.framework.hibernate_jpa.entity.Customer;

import jakarta.persistence.*;

public class CustomerDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
    EntityManager em = emf.createEntityManager();

    public void addCustomer(Customer customer) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(customer);

        tx.commit();

        System.out.println("Customer added successfully");
    }

    public Customer searchCustomer(int id) {

        Customer c = em.find(Customer.class, id);

        if(c == null) {
            System.out.println("Customer not found");
        }

        return c;
    }

    public void updateWallet(int customerId, double newBalance) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = em.find(Customer.class, customerId);

        if(c != null) {
            c.getWallet().setBalance(newBalance);
            em.merge(c);
            System.out.println("Wallet updated successfully");
        }

        tx.commit();
    }

    public void deleteCustomer(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = em.find(Customer.class, id);

        if(c != null) {
            em.remove(c);
            System.out.println("Customer deleted successfully");
        }

        tx.commit();
    }
}