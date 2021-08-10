package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;

import java.util.List;

public class GameDaoImpl implements GameDao{

    @Override
    public Game create() {
        Game game = new Game();
        return game;
    }

    @Override
    public Game get() {
        Game game = new Game();
        return game;
    }

    @Override
    public List<Game> getAll() {
        List<Game> gameList = null;
        return gameList;
    }

    @Override
    public Game update() {
        Game game = new Game();
        return game;
    }

    @Override
    public Game delete() {
        Game game = new Game();
        return game;
    }
}
