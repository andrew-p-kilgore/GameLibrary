package com.jtakdn.gameLibrary.service;

import com.jtakdn.gameLibrary.dao.CustomerDao;
import com.jtakdn.gameLibrary.dao.GameDao;
import com.jtakdn.gameLibrary.dao.LoanDao;
import com.jtakdn.gameLibrary.dto.Game;

public class GameLibraryServiceLayerImpl {
    GameDao gameDao;
    LoanDao loanDao;
    CustomerDao customerDao;

    public GameLibraryServiceLayerImpl(GameDao gameDao, LoanDao loanDao, CustomerDao customerDao){
        this.customerDao = customerDao;
        this.gameDao = gameDao;
        this.loanDao = loanDao;
    }

    @Override
    Game createGame(Game game){}
        
    }


}