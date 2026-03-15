package com.capg.lpu.service;

import javax.persistence.*;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {

        String jpql = "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :empId";

        Query query = em.createQuery(jpql);
        query.setParameter("empId", employeeId);

        Long count = (Long) query.getSingleResult();

        System.out.println("Total Leads Assigned: " + count);
    }
}