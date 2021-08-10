package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer create();

    public Customer get();

    public List<Customer> getAll();

    public Customer update();

    public Customer delete();

}
