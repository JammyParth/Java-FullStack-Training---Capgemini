package com.capg.food.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FOOD_ORDER")
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1)
	private Long id;

    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private double totalAmount;

    @ManyToMany
    @JoinTable(
        name = "ORDER_FOODITEM",
        joinColumns = @JoinColumn(name = "ORDER_ID"),
        inverseJoinColumns = @JoinColumn(name = "FOODITEM_ID")
    )
    private List<FoodItem> foodItems;

    public FoodOrder() {}

    // Getters and Setters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public List<FoodItem> getFoodItems() { return foodItems; }
    public void setFoodItems(List<FoodItem> foodItems) { this.foodItems = foodItems; }
}