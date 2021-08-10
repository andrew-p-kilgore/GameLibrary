package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        return false;
    }
}
