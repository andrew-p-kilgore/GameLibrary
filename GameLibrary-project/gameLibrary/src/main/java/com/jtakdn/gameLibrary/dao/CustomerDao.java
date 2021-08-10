package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer create(Customer customer);

    public Customer get(String customerId);

    public List<Customer> getAll();

    public boolean update(Customer customer);

    public boolean delete(String customerId);

}
