package com.metacube.user.JDBCConnection;

import java.sql.*;
import java.sql.SQLException;

public class ConnectionHelper {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //jdbc driver class  
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/storefront1?useSSL=false"; //jdbc url to connect to the sql server
	
	/**
	 * @return Connection, connection object by using credentials and url
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		 try {
				Class.forName(JDBC_DRIVER);
				   	 } catch (ClassNotFoundException cnfe) {
				   		 System.out.println("Error loading driver: " + cnfe);
				   	 }
				   	 
		return DriverManager.getConnection(JDBC_DB_URL, Credentials.getUser(),Credentials.getPassword());
	}
	
}
