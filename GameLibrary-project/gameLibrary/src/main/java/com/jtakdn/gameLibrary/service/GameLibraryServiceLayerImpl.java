package com.jtakdn.gameLibrary.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.jtakdn.gameLibrary.dao.CustomerDao;
import com.jtakdn.gameLibrary.dao.GameDao;
import com.jtakdn.gameLibrary.dao.LoanDao;
import com.jtakdn.gameLibrary.dto.Customer;
import com.jtakdn.gameLibrary.dto.Game;
import com.jtakdn.gameLibrary.dto.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameLibraryServiceLayerImpl implements GameLibraryServiceLayer
{
    GameDao gameDao;
    LoanDao loanDao;
    CustomerDao customerDao;

    @Autowired
    public GameLibraryServiceLayerImpl(GameDao gameDao, LoanDao loanDao,
            CustomerDao customerDao)
    {
        this.customerDao = customerDao;
        this.gameDao = gameDao;
        this.loanDao = loanDao;
    }

    @Override
    public Game createGame(Game game)
    {
        return gameDao.createGame(game);
    }

    @Override
    public Game getGame(String gameId)
    {
        return gameDao.getGame(gameId);
    }

    @Override
    public List<Game> getAllGames()
    {
        return gameDao.getAllGames();
    }

    @Override
    public List<Loan> getAllLoans()
    {
        return loanDao.getAllLoans();
    }

    @Override
    public boolean updateGame(Game game)
    {
        return gameDao.updateGame(game);
    }

    @Override
    public boolean deleteGame(String gameId)
    {
        return gameDao.deleteGame(gameId);
    }

    @Override
    public Loan createLoan(Loan loan)
    {
        LocalDate start = LocalDate.parse(loan.getStartDate());
        LocalDate end = LocalDate.parse(loan.getEndDate());
        long elapsed = ChronoUnit.DAYS.between(start, end);
        int cost = (int) elapsed * 2;
        loan.setCost(String.valueOf(cost));
        return loanDao.createLoan(loan);
    }

    @Override
    public Loan getLoan(String loanId)
    {
        return loanDao.getLoan(loanId);
    }

    @Override
    public boolean updateLoan(Loan loan)
    {
        LocalDate start = LocalDate.parse(loan.getStartDate());
        LocalDate end = LocalDate.parse(loan.getEndDate());
        long elapsed = ChronoUnit.DAYS.between(start, end);
        int cost = (int) elapsed * 2;
        loan.setCost(String.valueOf(cost));
        return loanDao.updateLoan(loan);
    }

    @Override
    public boolean deleteLoan(String loanId)
    {
        return loanDao.deleteLoan(loanId);
    }

    @Override
    public Customer createCustomer(Customer customer)
    {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer getCustomer(String customerId)
    {
        return customerDao.getCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerDao.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(Customer customer)
    {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String customerId)
    {
        return customerDao.deleteCustomer(customerId);
    }

}