package com.jtakdn.gameLibrary.service;

import java.util.List;

import com.jtakdn.gameLibrary.dao.CustomerDao;
import com.jtakdn.gameLibrary.dao.GameDao;
import com.jtakdn.gameLibrary.dao.LoanDao;
import com.jtakdn.gameLibrary.dto.Customer;
import com.jtakdn.gameLibrary.dto.Game;
import com.jtakdn.gameLibrary.dto.Loan;

public class GameLibraryServiceLayerImpl implements GameLibraryServiceLayer{
    GameDao gameDao;
    LoanDao loanDao;
    CustomerDao customerDao;

    public GameLibraryServiceLayerImpl(GameDao gameDao, LoanDao loanDao, CustomerDao customerDao){
        this.customerDao = customerDao;
        this.gameDao = gameDao;
        this.loanDao = loanDao;
    }

    @Override
    public void createGame(Game game){
        gameDao.createGame(game);
    }

    @Override
    public Game getGame(String gameId){
        return gameDao.getGame(gameId);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanDao.getAllLoans();
    }

    @Override
    public boolean updateGame(Game game) {
        return gameDao.updateGame(game);
    }

    @Override
    public boolean deleteGame(String gameId) {
        return gameDao.deleteGame(gameId);
    }

    @Override
    public void createLoan(Loan loan) {
        loanDao.createLoan(loan);
    }

    @Override
    public Loan getLoan(String loanId) {
        return loanDao.getLoan(loanId);
    }

    @Override
    public boolean updateLoan(Loan loan) {
        return loanDao.updateLoan(loan);
    }

    @Override
    public boolean deleteLoan(String loanId) {
        return loanDao.deleteLoan(loanId);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
        
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerDao.getCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        return customerDao.deleteCustomer(customerId);
    }
    


}