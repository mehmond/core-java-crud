package com.myecommapp.model;

import java.util.HashMap;

import com.myecommapp.validator.Validator;

public class Customer extends Validator {
	private String customerId;
	private String customerName;
	private String customerEmail;
	private String password;
	private String phoneNumber;
	private String address;
	private String dateOfRegistration;

	public Customer() {
		super();
		errorMessage = new HashMap<String, String>();
	}

	public Customer(String customerId, String customerName, String customerEmail, String password, String phoneNumber,
			String address, String dateOfRegistration) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public HashMap<String, String> validate() {
		String message;
		String field;
		String emptyField = "Field cannot be empty";
		Validator validator = new Validator();
		if (!(validator.validateEmail(this.getCustomerEmail()))) {
			message = "Email invalid";
			field = "email";
			errorMessage.put(field, message);
		}
		if (this.getCustomerEmail().isEmpty()) {
			message = "Field can't be empty";
			field = "email";
			errorMessage.put(field, emptyField);
		}
		if (this.getPassword().isEmpty()) {
			message = "Field can't be empty";
			field = "password";
			errorMessage.put(field, emptyField);
		}

		return errorMessage;
	}

}
