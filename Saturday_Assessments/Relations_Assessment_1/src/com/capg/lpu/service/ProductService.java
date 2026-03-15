package com.capg.lpu.service;

import com.capg.lpu.entity.*;
import javax.persistence.*;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void addProduct(String name, double price) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            em.persist(product);
            tx.commit();
            System.out.println("Product Added Successfully.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}