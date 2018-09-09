package com.metacube.advertismentWebServices.JDBCConnection;

public class Credentials {

	static final String USER_NAME = "root";
	static final String PASSWORD ="1234";
	
	/**
	 * @return user
	 */
	public static String getUser() {
		return USER_NAME;
	}
	
	/**
	 * @return password
	 */
	public static String getPassword() {
		return PASSWORD;
	}
}
