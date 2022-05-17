package com.myecommapp.dao;

import com.myecommapp.model.Customer;

public interface CustomerDAO {
	Customer getByName(String customerName);
	boolean add(Customer customer);
	boolean delete(Customer customer);
	boolean update(Customer customer);

}
