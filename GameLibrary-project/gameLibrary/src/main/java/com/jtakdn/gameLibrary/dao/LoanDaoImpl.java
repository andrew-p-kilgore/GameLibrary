package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoanDaoImpl implements LoanDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Loan createLoan(Loan loan){
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
    public Loan getLoan(String loanId) {
        final String sql = "SELECT * FROM GameLoans WHERE LoanId = ?";
        return jdbcTemplate.queryForObject(sql, new LoanMapper(), Integer.parseInt(loanId));
    }

    @Override
    public List<Loan> getAllLoans() {
        final String sql = "SELECT * FROM GameLoans;";
        return jdbcTemplate.query(sql, new LoanMapper());
    }

    @Override
    @Transactional
    public boolean updateLoan(Loan loan) {
        if(getLoan(loan.getCustomerId()) != null) {
            final String sql = "UPDATE GameLoans SET "
                    + "GameId = ?, "
                    + "CustomerId = ?, "
                    + "StartDate = ?, "
                    + "EndDate = ?, "
                    + "Cost = ? "
                    + "WHERE LoanId = ?;";
            return jdbcTemplate.update(sql, loan.getGameId(),
                    loan.getCustomerId(), loan.getStartDate(),
                    loan.getEndDate(), loan.getCost(),
                    Integer.parseInt(loan.getLoanId())) > 0;
        }
        else return false;
    }

    @Override
    @Transactional
    public boolean deleteLoan(String loanId) {
        if (getLoan(loanId) != null) {
            final String sql = "DELETE FROM GameLoans WHERE LoanId = ?";
            return jdbcTemplate.update(sql, Integer.parseInt(loanId)) > 0;
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
