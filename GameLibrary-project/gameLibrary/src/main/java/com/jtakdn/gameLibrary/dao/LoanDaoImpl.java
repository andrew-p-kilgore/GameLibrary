package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public class LoanDaoImpl implements LoanDao{

    @Override
    public Loan createLoan() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public Loan getLoan() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public List<Loan> getAllLoan() {
        List<Loan> loanList = null;
        return loanList;
    }

    @Override
    public Loan updateLoan() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public Loan deleteLoan() {
        Loan loan = new Loan();
        return loan;
    }
}
