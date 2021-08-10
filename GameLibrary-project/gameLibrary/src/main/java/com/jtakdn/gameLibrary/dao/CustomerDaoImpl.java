package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    @Override
    public Customer createCustomer() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public Customer getCustomer() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = null;
        return customerList;
    }

    @Override
    public Customer updateCustomer() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public Customer deleteCustomer() {
        Customer customer = new Customer();
        return customer;
    }

}
