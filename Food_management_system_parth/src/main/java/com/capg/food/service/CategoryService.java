package com.capg.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.food.DAO.CategoryDAO;
import com.capg.food.entity.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public void addCategory(String name, String description) {
        Category category = new Category(name, description);
        categoryDAO.save(category);
    }
}