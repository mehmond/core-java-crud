package com.myecommapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.myecommapp.dao.CustomerDAO;
import com.myecommapp.model.Customer;
import com.myecommapp.utility.DBConnection;

public class CustomerRepository implements CustomerDAO {
	DBConnection db;
	Connection con;
	
	public CustomerRepository() {
		super();
		db = new DBConnection();
		con = db.getConnection();
	}

	public boolean authenticate(String email, String password) {
		final String SQL_QUERY = "select * from customers where customer_email='" + email.toLowerCase() + "' and password='" + password + "'";
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SQL_QUERY);
			if (rs.first()) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Customer getByName(String customerName) {
		Customer customer = new Customer();
		try {
			final String SQL_QUERY = "select * from customers where customer_name = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, customerName);
			ResultSet rs = stmt.executeQuery();
			if (!rs.first()) {
				return null;
			} else {
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setPhoneNumber(rs.getString(5));
				customer.setAddress(rs.getString(6));
				customer.setDateOfRegistration(rs.getString(7));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Customer customer) {
		try {
			final String SQL_QUERY = "insert into customers(customer_name, customer_email, password, phone_number, address) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, customer.getCustomerName().trim());
			stmt.setString(2, customer.getCustomerEmail().trim().toLowerCase());
			stmt.setString(3, customer.getPassword().trim());
			stmt.setString(4, customer.getPhoneNumber().trim());
			stmt.setString(5, customer.getAddress().trim());
			stmt.executeQuery();
			con.close();
			System.out.println("Customer has been added to the database...");
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Customer customer) {
		try {
			final String SQL_QUERY = "delete from customers where customer_id = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, customer.getCustomerId().trim());
			stmt.executeUpdate();
			con.close();
			System.out.println("Customer has been deleted succesfully!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		try {
			final String SQL_QUERY = "update customers set customer_name = ?, customer_email = ?,"
					+ "password= ?, phone_number = ?, address = ? where customer_id = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, customer.getCustomerName().trim());
			stmt.setString(2, customer.getCustomerEmail().trim().toLowerCase());
			stmt.setString(3, customer.getPassword().trim());
			stmt.setString(4, customer.getPhoneNumber().trim());
			stmt.setString(5, customer.getAddress().trim());
			stmt.setString(6, customer.getCustomerId().trim());
			stmt.executeUpdate();
			con.close();
			System.out.println("Customer " + customer.getCustomerName() + " has been succecfully updated!");
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}
