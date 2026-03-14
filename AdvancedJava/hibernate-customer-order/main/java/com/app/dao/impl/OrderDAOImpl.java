package com.app.dao.impl;

import com.app.dao.OrderDAO;
import com.app.entity.Order;
import com.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAOImpl implements OrderDAO {

    public String saveOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(order);

        tx.commit();
        session.close();

        return "Order Saved";
    }

    public String updateOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(order);

        tx.commit();
        session.close();

        return "Order Updated";
    }

    public String deleteOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order o = session.get(Order.class,id);
        session.delete(o);

        tx.commit();
        session.close();

        return "Order Deleted";
    }

    public Order getOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Order.class,id);
    }
}