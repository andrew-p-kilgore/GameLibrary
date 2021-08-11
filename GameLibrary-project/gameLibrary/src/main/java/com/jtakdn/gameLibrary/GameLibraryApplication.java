package com.jtakdn.gameLibrary;

import com.jtakdn.gameLibrary.dao.CustomerDao;
import com.jtakdn.gameLibrary.dao.CustomerDaoImpl;
import com.jtakdn.gameLibrary.dao.GameDao;
import com.jtakdn.gameLibrary.dao.GameDaoImpl;
import com.jtakdn.gameLibrary.dao.LoanDao;
import com.jtakdn.gameLibrary.dao.LoanDaoImpl;
import com.jtakdn.gameLibrary.service.GameLibraryServiceLayerImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		GameDao gameDao = new GameDaoImpl();
		LoanDao loanDao = new LoanDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		GameLibraryServiceLayerImpl gameLibraryServiceLayerImpl = new GameLibraryServiceLayerImpl(gameDao, loanDao, customerDao);
		SpringApplication.run(GameLibraryApplication.class, args);
	}
}
