package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import java.util.List;

public interface CustomerDao {

    public void createCustomer(Customer customer);

    public Customer getCustomer(String customerId);

    public List<Customer> getAllCustomers();

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(String customerId);

}
