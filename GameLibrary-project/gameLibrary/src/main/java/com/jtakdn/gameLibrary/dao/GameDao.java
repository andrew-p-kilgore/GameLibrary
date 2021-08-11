package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;

import java.util.List;

public interface GameDao {

    public Game createGame(Game game);

    public Game getGame(String gameId);

    public List<Game> getAllGames();

    public boolean updateGame(Game game);

    public boolean deleteGame(String gameId);

}
