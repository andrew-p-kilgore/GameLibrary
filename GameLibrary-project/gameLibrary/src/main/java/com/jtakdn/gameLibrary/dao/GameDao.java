package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;

public interface GameDao {

    public Game create();

    public Game get();

    public Game getAll();

    public Game update();

    public Game delete();

}
