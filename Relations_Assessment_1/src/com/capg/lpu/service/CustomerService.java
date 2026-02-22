package com.capg.lpu.service;

import com.capg.lpu.entity.*;
import javax.persistence.*;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            em.persist(customer);
            tx.commit();
            System.out.println("Customer Registered Successfully.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Customer customer = em.find(Customer.class, customerId);
            if (customer != null) {
                customer.setAddress(address);
                em.persist(address);
                tx.commit();
                System.out.println("Address Added Successfully.");
            } else {
                System.out.println("Customer Not Found.");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}