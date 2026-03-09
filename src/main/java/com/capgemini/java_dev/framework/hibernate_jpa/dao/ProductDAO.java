package com.capgemini.java_dev.framework.hibernate_jpa.dao;



import java.util.List;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void addProduct(Product p) {
        em.persist(p);
        System.out.println("Product added successfully.");
        System.out.println(p);
    }

    public void getAllProducts() {

        List<Product> list = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();

        if (list.isEmpty())
            System.out.println("No product found.");
        else
            list.forEach(System.out::println);
    }

    public void getProductById(int id) {

        Product p = em.find(Product.class, id);

        if (p == null)
            System.out.println("No product found.");
        else
            System.out.println(p);
    }

    public void getProductsByCategory(String category) {

        Query q = em.createQuery("SELECT p FROM Product p WHERE p.category = :category");
        q.setParameter("category", category);

        List<Product> list = q.getResultList();

        if (list.isEmpty())
            System.out.println("No product found.");
        else
            list.forEach(System.out::println);
    }

    public void updateProductPrice(int id, double newPrice) {

        Product p = em.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        p.setPrice(newPrice);
        em.merge(p);

        System.out.println("Product price updated successfully.");
        System.out.println(p);
    }

    public void deleteProduct(int id) {

        Product p = em.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        em.remove(p);
        System.out.println("Product deleted successfully.");
    }
}
