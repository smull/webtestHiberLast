package com.levelup.dao.impl;

import com.levelup.dao.CustomerRepository;
import com.levelup.dao.HibernateSessionProvider;
import com.levelup.model.Customer;
import org.hibernate.Session;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public void createCustomer(Customer customer) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class,id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }
}
