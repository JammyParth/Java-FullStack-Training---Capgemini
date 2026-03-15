package com.capg.lpu.service;

import com.capg.lpu.entity.*;
import javax.persistence.*;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issueDescription) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Order order = em.find(Order.class, orderId);

            if (order != null) {
                SupportTicket ticket = new SupportTicket();
                ticket.setIssueDescription(issueDescription);
                ticket.setOrder(order);

                em.persist(ticket);
                tx.commit();
                System.out.println("Support Ticket Raised.");
            } else {
                System.out.println("Order Not Found.");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}