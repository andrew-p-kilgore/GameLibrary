package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public interface LoanDao {

    public Loan createLoan();

    public Loan getLoan();

    public List<Loan> getAllLoans();

    public Loan updateLoan();

    public Loan deleteLoan();

}
