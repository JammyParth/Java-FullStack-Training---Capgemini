package com.capg.food.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FOOD_ITEM")
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_seq")
	@SequenceGenerator(name = "food_seq", sequenceName = "FOOD_SEQ", allocationSize = 1)
	private Long id;

    private String itemName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToMany(mappedBy = "foodItems")
    private List<FoodOrder> orders;

    public FoodItem() {}

    public FoodItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}