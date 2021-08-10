package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public interface LoanDao {

    public Loan create();

    public Loan get();

    public List<Loan> getAll();

    public Loan update();

    public Loan delete();

}
