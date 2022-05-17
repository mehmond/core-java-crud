package com.myecommapp.utility;
import java.sql.*;

public class DBConnection {
	Connection con;

	public Connection getConnection()  {
		final String URL = "jdbc:oracle:thin:@localhost:1522:xe";
		final String USER = "hr";
		final String PASSWORD = "password";
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Successful");
		} catch (Exception e) {
			System.out.println(e);
		} 
		return con;
	}
}
