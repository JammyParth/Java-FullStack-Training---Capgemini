package com.capg.food.DAO;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.food.entity.FoodOrder;

@Repository
@Transactional
public class OrderDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(FoodOrder order) {
        em.persist(order);
    }

    public FoodOrder findById(Long id) {
        return em.find(FoodOrder.class, id);
    }
}