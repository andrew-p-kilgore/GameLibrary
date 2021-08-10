package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

public interface LoanDao {

    public Loan create();

    public Loan get();

    public Loan getAll();

    public Loan update();

    public Loan delete();

}
