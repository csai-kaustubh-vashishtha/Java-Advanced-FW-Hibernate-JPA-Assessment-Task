package com.capgemini.java_dev.framework.hibernate_jpa.main;



import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.ProductDAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

    public static void execution() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("product");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        ProductDAO dao = new ProductDAO(em);

        while (true) {

            System.out.println("\n1 Add Product");
            System.out.println("2 View All Products");
            System.out.println("3 Search Product by ID");
            System.out.println("4 Search Product by Category");
            System.out.println("5 Update Product Price");
            System.out.println("6 Delete Product");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Add Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    if (name.isEmpty() || category.isEmpty()) {
                        System.out.println("Name and Category must not be empty.");
                        break;
                    }

                    if (price <= 0 || qty <= 0) {
                        System.out.println("Price and Quantity must be positive.");
                        break;
                    }

                    Product p = new Product(name, category, price, qty);

                    et.begin();
                    dao.addProduct(p);
                    et.commit();

                    break;

                case 2:
                    dao.getAllProducts();
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    dao.getProductById(id);
                    break;

                case 4:

                    System.out.print("Category: ");
                    String cat = sc.nextLine();

                    dao.getProductsByCategory(cat);
                    break;

                case 5:

                    System.out.print("ID: ");
                    int pid = sc.nextInt();

                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();

                    et.begin();
                    dao.updateProductPrice(pid, newPrice);
                    et.commit();

                    break;

                case 6:

                    System.out.print("ID: ");
                    int did = sc.nextInt();

                    et.begin();
                    dao.deleteProduct(did);
                    et.commit();

                    break;

                case 7:
                    System.out.println("Program Ended.");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
