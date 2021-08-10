package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public class LoanDaoImpl implements LoanDao{

    @Override
    public Loan create() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public Loan get() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public List<Loan> getAll() {
        List<Loan> loanList = null;
        return loanList;
    }

    @Override
    public Loan update() {
        Loan loan = new Loan();
        return loan;
    }

    @Override
    public Loan delete() {
        Loan loan = new Loan();
        return loan;
    }
}
