package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GameDaoImpl implements GameDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Game createGame(Game game) {
        final String INSERT_GAME = "INSERT INTO VideoGame(GameName, Genre, Platform,"
                + " GameYear, Publisher) values(?,?,?,?,?)";
        jdbcTemplate.update(INSERT_GAME, game.getGameName(),
                game.getGameGenre(), game.getGamePlatform(),
                game.getGameYear(), game.getGamePublisher());
        String newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
        game.setGameId(newId);
        return game;
    }

    @Override
    public Game getGame(String gameId) {
        final String sql = "SELECT * FROM VideoGame WHERE GameId = ?";
        return jdbcTemplate.queryForObject(sql, new GameMapper(), gameId);
    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "SELECT * FROM VideoGame;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    public Game updateGame() {
        Game game = new Game();
        return game;
    }

    @Override
    public Game deleteGame() {
        Game game = new Game();
        return game;
    }

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet resultSet, int i) throws SQLException {
            Game game = new Game();
            game.setGameId(resultSet.getString("GameId"));
            game.setGameName(resultSet.getString("GameName"));
            game.setGameGenre(resultSet.getString("Genre"));
            game.setGamePlatform(resultSet.getString("Platform"));
            game.setGameYear(resultSet.getString("GameYear"));
            game.setGamePublisher(resultSet.getString("Publisher"));
            return game;
        }
    }
}
