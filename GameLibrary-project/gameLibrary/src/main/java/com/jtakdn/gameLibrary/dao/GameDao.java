package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;

import java.util.List;

public interface GameDao {

    public Game create(Game game);

    public Game get(String gameId);

    public List<Game> getAll();

    public Game update();

    public Game delete();

}
