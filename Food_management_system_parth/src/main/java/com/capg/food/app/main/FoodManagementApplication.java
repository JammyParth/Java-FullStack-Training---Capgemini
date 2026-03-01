package com.capg.food.app.main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capg.food.service.CategoryService;
import com.capg.food.service.FoodService;
import com.capg.food.service.OrderService;

public class FoodManagementApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        CategoryService categoryService = ctx.getBean(CategoryService.class);
        FoodService foodService = ctx.getBean(FoodService.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Category \n2.Add Food Item \n3.View Items By Category \n4.Place Order \n5.Calculate Total Bill \n6.exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                	sc.nextLine();
                	System.out.println("Category Name: ");
                	String cname = sc.nextLine();
                	
                	System.out.println("Description: ");
                	String desc = sc.nextLine();
                	
                	categoryService.addCategory(cname,desc);
                	System.out.println("Category added.");
                	break;
                
                case 2:
                	System.out.println("Category ID: ");
                	long catId = sc.nextLong();
                	sc.nextLine();
                	
                	System.out.println("Item Name: ");
                	String itemName = sc.nextLine();
                	
                	System.out.println("Price: ");
                	double price = sc.nextDouble();
                	
                	foodService.addFoodItem(catId,itemName,price);
                	System.out.println("Food Item added");
                	break;
                	
                case 3:
                	System.out.println("Category ID: ");
                	long categoryId = sc.nextLong();
                	
                	foodService.getItemsByCategory(categoryId)
                	.forEach(item-> System.out.println(item.getId()+" "+item.getItemName()+" "+item.getPrice()));
                	break;
                	
                case 4:
                	sc.nextLine();
                	System.out.println("Customer Name: ");
                	String customer = sc.nextLine();
                	
                	System.out.println("Number of Items: ");
                	int n = sc.nextInt();
                	
                	List<Long> ids = new ArrayList<>();
                	for(int i=0;i<n;i++) {
                		System.out.println("Enter Food Item ID: ");
                		ids.add(sc.nextLong());
                	}
                	
                	orderService.placeOrder(customer,ids);
                	System.out.println("Order Placed");
                	break;
                	
                case 5:
                	System.out.println("Order ID: ");
                	long orderId = sc.nextLong();
                	
                	double total = orderService.calculateTotal(orderId);
                	System.out.println("Total Bill: "+total);
                	break;
                	
                case 6:
                	System.out.println("Application Closed.");
                	System.exit(0);
                	
                    
            }
        }
    }
}