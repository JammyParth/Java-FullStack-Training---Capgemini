package com.capg.lpu.service;

import com.capg.lpu.entity.*;
import javax.persistence.*;
import java.util.*;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Customer customer = em.find(Customer.class, customerId);

            if (customer == null) {
                System.out.println("Customer Not Found.");
                return;
            }

            Order order = new Order();
            order.setCustomer(customer);
            order.setOrderDate(new Date());

            double total = 0;

            for (Long pid : productIds) {
                Product product = em.find(Product.class, pid);
                if (product != null) {
                    order.getProducts().add(product);
                    total += product.getPrice();
                }
            }

            order.setTotalAmount(total);

            em.persist(order);
            tx.commit();
            System.out.println("Order Placed Successfully. Total: " + total);

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}