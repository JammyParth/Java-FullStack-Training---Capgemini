package com.capg.food.DAO;

import javax.persistence.*;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.food.entity.FoodItem;

@Repository
@Transactional
public class FoodItemDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(FoodItem item) {
        em.persist(item);
    }

    public FoodItem findById(Long id) {
        return em.find(FoodItem.class, id);
    }

    public List<FoodItem> findByCategory(Long categoryId) {
        return em.createQuery(
            "FROM FoodItem f WHERE f.category.id = :cid",
            FoodItem.class)
            .setParameter("cid", categoryId)
            .getResultList();
    }

    public void delete(Long id) {
        FoodItem item = findById(id);
        if (item != null) {
            em.remove(item);
        }
    }
}