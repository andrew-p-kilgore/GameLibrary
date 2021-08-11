package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoImpl implements GameDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void createGame(Game game) {
        final String INSERT_GAME = "INSERT INTO VideoGame(GameName, Genre, Platform,"
                + " GameYear, Publisher) values(?,?,?,?,?)";
        jdbcTemplate.update(INSERT_GAME, game.getGameName(),
                game.getGameGenre(), game.getGamePlatform(),
                game.getGameYear(), game.getGamePublisher());
        String newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
        game.setGameId(newId);
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
    @Transactional
    public boolean updateGame(Game game) {
        if(getGame(game.getGameId()) != null) {
            final String sql = "UPDATE VideoGame SET "
                    + "GameName = ?, "
                    + "Genre = ?, "
                    + "Platform = ?"
                    + "GameYear = ?"
                    + "Publisher = ? "
                    + "WHERE GameId = ?;";
            return jdbcTemplate.update(sql, game.getGameName(),
                    game.getGameGenre(), game.getGamePlatform(),
                    game.getGameYear(), game.getGamePublisher(),
                    game.getGameId()) > 0;
        }
        else return false;
    }

    @Override
    @Transactional
    public boolean deleteGame(String gameId) {
        if (getGame(gameId) != null) {
            final String sql = "DELETE FROM VideoGame WHERE GameId = ?";
            return jdbcTemplate.update(sql, gameId) > 0;
        }
        else return false;
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
