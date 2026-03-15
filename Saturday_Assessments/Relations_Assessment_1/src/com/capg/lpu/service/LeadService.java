package com.capg.lpu.service;

import com.capg.lpu.entity.*;
import javax.persistence.*;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public void createLead(String name, String source, String contactInfo) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Lead lead = new Lead();
            lead.setName(name);
            lead.setSource(source);
            lead.setContactInfo(contactInfo);

            em.persist(lead);
            tx.commit();
            System.out.println("Lead Created Successfully.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

            if (lead != null && employee != null) {
                lead.setEmployee(employee);
                tx.commit();
                System.out.println("Lead Assigned Successfully.");
            } else {
                System.out.println("Lead or Employee Not Found.");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void convertLeadToCustomer(Long leadId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Lead lead = em.find(Lead.class, leadId);
            if (lead != null) {
                Customer customer = new Customer();
                customer.setName(lead.getName());
                customer.setEmail(lead.getContactInfo());
                customer.setPhone("N/A");

                em.persist(customer);
                em.remove(lead);

                tx.commit();
                System.out.println("Lead Converted to Customer.");
            } else {
                System.out.println("Lead Not Found.");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}