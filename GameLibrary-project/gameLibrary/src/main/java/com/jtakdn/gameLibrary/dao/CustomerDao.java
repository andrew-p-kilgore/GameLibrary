package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

public interface CustomerDao {

    public Customer create();

    public Customer get();

    public Customer getAll();

    public Customer update();

    public Customer delete();

}
