package com.capg.food.service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.food.DAO.FoodItemDAO;
import com.capg.food.DAO.OrderDAO;
import com.capg.food.entity.FoodItem;
import com.capg.food.entity.FoodOrder;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private FoodItemDAO foodItemDAO;

    public void placeOrder(String customerName, List<Long> ids) {

        List<FoodItem> items = ids.stream()
                .map(foodItemDAO::findById)
                .collect(Collectors.toList());

        double total = items.stream()
                .mapToDouble(FoodItem::getPrice)
                .sum();

        FoodOrder order = new FoodOrder();
        order.setCustomerName(customerName);
        order.setOrderDate(new Date());
        order.setFoodItems(items);
        order.setTotalAmount(total);

        orderDAO.save(order);
    }

    public double calculateTotal(Long orderId) {
        FoodOrder order = orderDAO.findById(orderId);
        return order != null ? order.getTotalAmount() : 0;
    }
}