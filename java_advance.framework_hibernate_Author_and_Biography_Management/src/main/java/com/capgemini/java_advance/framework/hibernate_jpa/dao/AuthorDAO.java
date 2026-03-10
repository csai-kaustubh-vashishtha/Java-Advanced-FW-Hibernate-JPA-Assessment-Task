package com.capgemini.java_advance.framework.hibernate_jpa.dao;



import com.capgemini.java_advance.framework.hibernate_jpa.entity.Author;

import jakarta.persistence.*;


public class AuthorDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("author");
    EntityManager em = emf.createEntityManager();

    public void addAuthor(Author author) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(author);

        tx.commit();

        System.out.println("Author added successfully");
    }

    public Author searchAuthor(int id) {

        Author a = em.find(Author.class, id);

        if(a == null)
            System.out.println("Author not found");

        return a;
    }

    public void updateBiography(int authorId, String summary, String birthPlace, String birthDate) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Author a = em.find(Author.class, authorId);

        if(a != null) {

            a.getBiography().setSummary(summary);
            a.getBiography().setBirthPlace(birthPlace);
            a.getBiography().setBirthDate(birthDate);

            em.merge(a);

            System.out.println("Biography updated successfully");
        }

        tx.commit();
    }

    public void deleteAuthor(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Author a = em.find(Author.class, id);

        if(a != null) {
            em.remove(a);
            System.out.println("Author deleted successfully");
        }

        tx.commit();
    }
}