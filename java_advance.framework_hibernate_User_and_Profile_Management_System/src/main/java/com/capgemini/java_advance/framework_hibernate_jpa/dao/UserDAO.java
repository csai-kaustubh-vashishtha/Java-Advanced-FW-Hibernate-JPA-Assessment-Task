package com.capgemini.java_advance.framework_hibernate_jpa.dao;


import jakarta.persistence.*;
import java.util.Date;

import com.capgemini.java_advance.framework_hibernate_jpa.entity.Profile;
import com.capgemini.java_advance.framework_hibernate_jpa.entity.User;

public class UserDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("user");

    public void addUser(User user) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(user);
        tx.commit();

        System.out.println("User added successfully");

        display(user);

        em.close();
    }

    public void searchUser(int id) {

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, id);

        if(user==null) {
            System.out.println("No user found");
        }
        else {
            display(user);
        }

        em.close();
    }

    public void updateEmail(int id,String email) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        User user = em.find(User.class, id);

        if(user==null) {
            System.out.println("No user found");
            return;
        }

        tx.begin();
        user.setEmail(email);
        em.merge(user);
        tx.commit();

        System.out.println("Email updated successfully");

        em.close();
    }

    public void updateProfile(int id,String phone,String gender,Date dob) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        User user = em.find(User.class, id);

        if(user==null) {
            System.out.println("No user found");
            return;
        }

        tx.begin();

        Profile p = user.getProfile();
        p.setPhone(phone);
        p.setGender(gender);
        p.setDob(dob);

        em.merge(user);

        tx.commit();

        System.out.println("Profile updated successfully");

        em.close();
    }

    public void deleteUser(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        User user = em.find(User.class, id);

        if(user==null) {
            System.out.println("No user found");
            return;
        }

        tx.begin();
        em.remove(user);
        tx.commit();

        System.out.println("User deleted successfully");

        em.close();
    }

    public void display(User user) {

        System.out.println("ID: "+user.getId());
        System.out.println("Username: "+user.getUsername());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Profile:");

        Profile p = user.getProfile();

        System.out.println("  Phone: "+p.getPhone());
        System.out.println("  Gender: "+p.getGender());
        System.out.println("  DOB: "+p.getDob());
    }
}