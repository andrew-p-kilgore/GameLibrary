package com.jtakdn.gameLibrary.service;

import java.util.List;

import com.jtakdn.gameLibrary.dto.Game;
import com.jtakdn.gameLibrary.dto.Loan;

public interface GameLibraryServiceLayer {
    Game createGame(Game game);
    Game getGame(String gameId);
    List<Game> getAllGames();
    Game updateGame();
    Game deleteGame();

    Loan createLoan();
    Loan getLoan();
    List<Loan> getAllLoans();
    Loan updateLoan();
    Loan deleteLoan();
    
}
