package com.levelup.dao;

import com.levelup.model.Customer;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public interface CustomerRepository {

    void createCustomer(Customer customer);

    Customer getCustomerById(Long id);
}
