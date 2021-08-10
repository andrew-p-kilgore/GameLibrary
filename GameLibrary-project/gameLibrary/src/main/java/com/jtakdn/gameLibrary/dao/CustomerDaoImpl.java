package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    @Override
    public Customer create() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public Customer get() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = null;
        return customerList;
    }

    @Override
    public Customer update() {
        Customer customer = new Customer();
        return customer;
    }

    @Override
    public Customer delete() {
        Customer customer = new Customer();
        return customer;
    }

    public static final class CustomerMapper implements CustomerMapper<Customer> {
        public Customer mapCustomer(ResultSet rs, int index) throws SQLException{
            Customer ct = new Customer();
        }
    }
}
