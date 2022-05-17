package com.myecommapp.validator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String EMPLOYEE_CODE = "[0-9]{1,5}";
	private static final String CONTACT_NUMBER="\\d{10}";
	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private static Matcher matcher;
	protected HashMap<String, String> errorMessage = new HashMap<String, String>();

	public boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean validateEmployeeID(String employeeID) {
		Pattern.compile(EMPLOYEE_CODE);
		matcher = pattern.matcher(employeeID);
		return matcher.matches();
	}

	public boolean empty(String value) {
		if (value == null)
			return true;
		return "".equals(value.trim());
	}	
	

}

