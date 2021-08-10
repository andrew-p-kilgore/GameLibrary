package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import java.util.List;

public interface LoanDao {

    public Loan create(Loan loan);

    public Loan get(String loadId);

    public List<Loan> getAll();

    public boolean update(Loan loan);

    public boolean delete(String loadId);

}
