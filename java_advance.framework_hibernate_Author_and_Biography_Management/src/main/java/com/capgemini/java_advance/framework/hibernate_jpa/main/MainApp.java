package com.capgemini.java_advance.framework.hibernate_jpa.main;


import java.util.Scanner;

import com.capgemini.java_advance.framework.hibernate_jpa.dao.AuthorDAO;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Author;
import com.capgemini.java_advance.framework.hibernate_jpa.entity.Biography;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthorDAO dao = new AuthorDAO();

        System.out.println("Enter name email summary birthPlace birthDate");

        String name = sc.next();
        String email = sc.next();
        String summary = sc.next();
        String birthPlace = sc.next();
        String birthDate = sc.next();

        Biography b = new Biography();
        b.setSummary(summary);
        b.setBirthPlace(birthPlace);
        b.setBirthDate(birthDate);

        Author a = new Author();
        a.setName(name);
        a.setEmail(email);
        a.setBiography(b);

        dao.addAuthor(a);

        System.out.println("ID: " + a.getId());
        System.out.println("Name: " + a.getName());
        System.out.println("Email: " + a.getEmail());

        System.out.println("Biography:");
        System.out.println("Summary: " + a.getBiography().getSummary());
        System.out.println("Birth Place: " + a.getBiography().getBirthPlace());
        System.out.println("Birth Date: " + a.getBiography().getBirthDate());
    }
}