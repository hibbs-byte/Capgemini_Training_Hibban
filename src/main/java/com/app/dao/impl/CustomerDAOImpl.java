package com.app.dao.impl;

import com.app.dao.CustomerDAO;
import com.app.entity.Customer;
import com.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public String saveCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();

        return "Customer Saved";
    }

    public String updateCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(customer);

        tx.commit();
        session.close();

        return "Customer Updated";
    }

    public String deleteCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class,id);
        session.delete(c);

        tx.commit();
        session.close();

        return "Customer Deleted";
    }

    public Customer getCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Customer.class,id);
    }

    public List<Customer> getAllCustomers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createQuery("from Customer",Customer.class).list();
    }

    public Customer getCustomerByEmail(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createQuery(
                "from Customer c where c.email=:email",
                Customer.class
        ).setParameter("email",email).uniqueResult();
    }
}