package com.jtakdn.gameLibrary.dao;

import com.jtakdn.gameLibrary.dto.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        final String INSERT_GAME = "INSERT INTO Customer(FirstName, LastName, PhoneNumber,"
            + " Address, CardNumber) values(?,?,?,?,?)";
        jdbcTemplate.update(INSERT_GAME, customer.getFirstName(),
            customer.getLastName(), customer.getPhoneNumber(),
            customer.getAddress(), customer.getCardNumber());
        String newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
        customer.setCustomerId(newId);
        return customer;
    }

    @Override
    public Customer getCustomer(String customerId) {
        final String sql = "SELECT * FROM Customer WHERE CustomerId = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerMapper(), Integer.parseInt(customerId));
    }

    @Override
    public List<Customer> getAllCustomers() {
        final String sql = "SELECT * FROM Customer;";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }

    @Override
    @Transactional
    public boolean updateCustomer(Customer customer) {
        if(getCustomer(customer.getCustomerId()) != null) {
            final String sql = "UPDATE Customer SET "
                    + "FirstName = ?, "
                    + "LastName = ?, "
                    + "PhoneNumber = ?, "
                    + "Address = ?, "
                    + "CardNumber = ? "
                    + "WHERE CustomerId = ?;";
            return jdbcTemplate.update(sql, customer.getFirstName(),
                    customer.getLastName(), customer.getPhoneNumber(),
                    customer.getAddress(), customer.getCardNumber(),
                    Integer.parseInt(customer.getCustomerId())) > 0;
        }
        else return false;
    }

    @Override
    @Transactional
    public boolean deleteCustomer(String customerId) {
        if (getCustomer(customerId) != null) {
            final String sql = "DELETE FROM Customer WHERE CustomerId = ?";
            return jdbcTemplate.update(sql, Integer.parseInt(customerId)) > 0;
        }
        else return false;
    }

    private static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("CustomerId"));
            customer.setFirstName(resultSet.getString("FirstName"));
            customer.setLastName(resultSet.getString("LastName"));
            customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
            customer.setAddress(resultSet.getString("Address"));
            customer.setCardNumber(resultSet.getString("CardNumber"));
            return customer;
        }
    }

}
