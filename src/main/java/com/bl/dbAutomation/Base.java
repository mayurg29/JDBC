package com.bl.dbAutomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {

	static Connection connection;
	
	public Connection setUp() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/university";
		String username = "root";
		String password = "7265262";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
