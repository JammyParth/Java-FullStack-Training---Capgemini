package com.capg.food.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.food.DAO.CategoryDAO;
import com.capg.food.DAO.FoodItemDAO;
import com.capg.food.entity.Category;
import com.capg.food.entity.FoodItem;

@Service
public class FoodService {

    @Autowired
    private FoodItemDAO foodItemDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    public void addFoodItem(Long categoryId, String name, double price) {

        Category category = categoryDAO.findById(categoryId);

        if (category == null)
            throw new RuntimeException("Category Not Found");

        FoodItem item = new FoodItem(name, price);
        item.setCategory(category);

        foodItemDAO.save(item);
    }

    public List<FoodItem> getItemsByCategory(Long categoryId) {
        return foodItemDAO.findByCategory(categoryId);
    }

    public void removeFoodItem(Long id) {
        foodItemDAO.delete(id);
    }
}