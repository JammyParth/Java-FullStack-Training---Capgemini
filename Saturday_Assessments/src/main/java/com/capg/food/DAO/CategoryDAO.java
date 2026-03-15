package com.capg.food.DAO;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.food.entity.Category;

@Repository
@Transactional
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Category category) {
        em.persist(category);
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }
}