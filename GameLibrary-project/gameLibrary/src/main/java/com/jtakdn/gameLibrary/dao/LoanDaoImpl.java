package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoanDaoImpl implements LoanDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Loan create(Loan loan) {
        final String INSERT_GAME = "INSERT INTO GameLoans(GameId, CustomerId, StartDate,"
            + " EndDate, Cost) values(?,?,?,?,?)";
        jdbcTemplate.update(INSERT_GAME, loan.getGameId(),
            loan.getCustomerId(), loan.getStartDate(),
            loan.getEndDate(), loan.getCost());
        String newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
        loan.setLoanId(newId);
        return loan;
    }

    @Override
    public Loan get(String loanId) {
        final String sql = "SELECT * FROM GameLoans WHERE LoanId = ?";
        return jdbcTemplate.queryForObject(sql, new LoanMapper(), loanId);
    }

    @Override
    public List<Loan> getAll() {
        final String sql = "SELECT * FROM GameLoans;";
        return jdbcTemplate.query(sql, new LoanMapper());
    }

    @Override
    @Transactional
    public boolean update(Loan loan) {
        if(get(loan.getCustomerId()) != null) {
            final String sql = "UPDATE GameLoans SET "
                    + "GameId = ?, "
                    + "CustomerId = ?, "
                    + "StartDate = ?, "
                    + "EndDate = ?"
                    + "Cost = ?"
                    + "WHERE LoanId = ?;";
            return jdbcTemplate.update(sql, loan.getGameId(),
                    loan.getCustomerId(), loan.getStartDate(),
                    loan.getEndDate(), loan.getCost(),
                    loan.getLoanId()) > 0;
        }
        else return false;
    }

    @Override
    @Transactional
    public boolean delete(String loanId) {
        if (get(loanId) != null) {
            final String sql = "DELETE FROM GameLoans WHERE LoanId = ?";
            return jdbcTemplate.update(sql, loanId) > 0;
        }
        else return false;
    }

    private static final class LoanMapper implements RowMapper<Loan> {

        @Override
        public Loan mapRow(ResultSet resultSet, int i) throws SQLException {
            Loan loan = new Loan();
            loan.setLoanId(resultSet.getString("LoanId"));
            loan.setGameId(resultSet.getString("GameId"));
            loan.setCustomerId(resultSet.getString("CustomerId"));
            loan.setStartDate(resultSet.getString("StartDate"));
            loan.setEndDate(resultSet.getString("EndDate"));
            loan.setCost(resultSet.getString("Cost"));
            return loan;
        }
    }
}
