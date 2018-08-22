

import java.sql.*;

public class Connectivity {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/storefront1?useSSL=false";
	
	
	public static Connection getConnection() throws SQLException{
		 try {
				Class.forName(JDBC_DRIVER);
				   	 } catch (ClassNotFoundException cnfe) {
				   		 System.out.println("Error loading driver: " + cnfe);
				   	 }
				   	 
		return  DriverManager.getConnection(JDBC_DB_URL, Credentials.getUser(),Credentials.getPassword());
	}


}
