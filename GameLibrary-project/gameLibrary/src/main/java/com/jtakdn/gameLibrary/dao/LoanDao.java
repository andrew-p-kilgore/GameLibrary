package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public interface LoanDao {

    public Loan createLoan(Loan loan);

    public Loan getLoan(String loadId);

    public List<Loan> getAllLoans();

    public boolean updateLoan(Loan loan);

    public boolean deleteLoan(String loadId);

}
