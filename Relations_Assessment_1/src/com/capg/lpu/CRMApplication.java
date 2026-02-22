package com.capg.lpu;

import java.util.*;

import javax.persistence.EntityManager;

import com.capg.lpu.entity.Address;
import com.capg.lpu.service.*;
import com.capg.lpu.util.JPAUtil;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== CRM SYSTEM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Create Lead");
            System.out.println("3. Convert Lead to Customer");
            System.out.println("4. Add Product");
            System.out.println("5. Place Order");
            System.out.println("6. Raise Support Ticket");
            System.out.println("7. Employee Performance Report");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter Lead Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                case 3:
                    System.out.print("Enter Lead ID to Convert: ");
                    Long leadId = sc.nextLong();
                    leadService.convertLeadToCustomer(leadId);
                    break;

                case 4:
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();

                    List<Long> productIds = new ArrayList<>();
                    System.out.println("Enter Product IDs (enter -1 to stop): ");

                    while (true) {
                        Long pid = sc.nextLong();
                        if (pid == -1)
                            break;
                        productIds.add(pid);
                    }

                    orderService.placeOrder(custId, productIds);
                    break;

                case 6:
                    System.out.print("Enter Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter Issue Description: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId, issue);
                    break;

                case 7:
                    System.out.print("Enter Employee ID: ");
                    Long empId = sc.nextLong();

                    reportService.getEmployeePerformance(empId);
                    break;

                case 0:
                    System.out.println("Exiting CRM System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        em.close();
        JPAUtil.close();
        sc.close();

        System.out.println("Application Closed Successfully.");
    }
}