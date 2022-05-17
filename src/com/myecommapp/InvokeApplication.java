package com.myecommapp;


import com.myecommapp.repository.CustomerRepository;

public class InvokeApplication {

	public static void main(String[] args) {
		try {
			CustomerRepository customerRepo = new CustomerRepository();
			if (customerRepo.authenticate("mr.arthur.morgan@gmail.com", "arthurito")) {
				System.out.println("Welcome user");
			} else {
				System.out.println("Access Denied");
			}
		} catch (Exception e) {
			System.out.println("problem in connecting to db ");
		}

	}

}
