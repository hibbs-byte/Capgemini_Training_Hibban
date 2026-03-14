package com.app.main;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.entity.Customer;
import com.app.entity.Order;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAOImpl();

        Order order = new Order();
        order.setOrderNumber("ORD101");
        order.setProductName("Laptop");
        order.setQuantity(1);
        order.setPrice(70000);
        order.setOrderDate(LocalDate.now());

        Customer c = new Customer();
        c.setCustomerName("Arham");
        c.setEmail("arham@gmail.com");
        c.setGender("Male");
        c.setPhone(9876543210L);
        c.setRegistrationDate(LocalDate.now());
        c.setOrder(order);

        dao.saveCustomer(c);

        System.out.println("Inserted Successfully");
    }
}