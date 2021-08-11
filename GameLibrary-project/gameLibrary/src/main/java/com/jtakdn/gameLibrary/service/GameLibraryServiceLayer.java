package com.jtakdn.gameLibrary.service;

import java.util.List;

import com.jtakdn.gameLibrary.dto.Customer;
import com.jtakdn.gameLibrary.dto.Game;
import com.jtakdn.gameLibrary.dto.Loan;

public interface GameLibraryServiceLayer {
    Game createGame(Game game);
    Game getGame(String gameId);
    List<Game> getAllGames();
    boolean updateGame(Game game);
    boolean deleteGame(String gameId);

    Loan createLoan(Loan loan);
    Loan getLoan(String loanId);
    List<Loan> getAllLoans();
    boolean updateLoan(Loan loan);
    boolean deleteLoan(String loanId);

    Customer createCustomer(Customer customer);
    Customer getCustomer(String customerId);
    List<Customer> getAllCustomers();
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String customerId);
    
}
