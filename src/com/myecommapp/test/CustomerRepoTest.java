package com.myecommapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myecommapp.model.Customer;
import com.myecommapp.repository.CustomerRepository;

class CustomerRepoTest {
	CustomerRepository customerRepo;
	Customer customer;

	@BeforeEach
	void setUp()  {
		customerRepo = new CustomerRepository();
		customer = new Customer();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void testAuthenticate() {
		assertEquals("Failed to validate the user!", true, customerRepo.authenticate("mr.arthur.morgan@gmail.com", "arthurito"));
	}
	//@Ignore
	@Test
	void testAdd() {
		customer.setCustomerName("Arthur Morgan");
		customer.setCustomerEmail("mr.arthur.morgan@gmail.com");
		customer.setPassword("arthurito");
		customer.setPhoneNumber("123456789");
		customer.setAddress("Valentine");
		assertEquals("Failed to ADD Customer !", true, customerRepo.add(customer));
	}
	
	@Ignore
	@Test
	void testDelete() {
		customer.setCustomerId("C0000041");
		assertEquals("Failed to DELETE Customer", true, customerRepo.delete(customer));
	}
	@Ignore
	@Test
	void testUpdate() {
		customer.setCustomerName("Arthur Morgan");
		customer.setCustomerEmail("mr.arthur.morgan@gmail.com");
		customer.setPassword("arthurito");
		customer.setPhoneNumber("123456789");
		customer.setAddress("Valentine EDITED");
		customer.setCustomerId("C0000044");
		assertEquals("Failed to UPDATE Customer !", true, customerRepo.update(customer));
	}

}
