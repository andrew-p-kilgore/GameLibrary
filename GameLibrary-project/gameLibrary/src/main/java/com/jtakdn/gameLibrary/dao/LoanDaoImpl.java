package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public class LoanDaoImpl implements LoanDao{

    @Override
    public Loan createLoan(Loan loan) {
        return null;
    }

    @Override
    public Loan getLoan(String loadId) {
        return null;
    }

    @Override
    public List<Loan> getAllLoans() {
        return null;
    }

    @Override
    public boolean updateLoan(Loan loan) {
        return false;
    }

    @Override
    public boolean deleteLoan(String loadId) {
        Loan loan = new Loan();
        return false;
    }
}
