package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Connection;

//ADDS EMPLOYEE
public class AddEmployee extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private static final String INSERT_QUERY="insert into `employee` (`First Name`,`Last Name`,`Email`,`Age`) values (?,?,?,?);";
	
	/**
	 * Handles request coming from HTML form
	 * @param req, request
	 * @param res, response after submitting HTML form
	 */
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int result=0;
		
		PrintWriter out = res.getWriter();//gets the writer of the response
		
		//get parameters from the HTML form
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		
		try {
			result = add(firstName,lastName,email,Integer.parseInt(age));//calls add method
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result==1){
			out.println("insertion successfull");
			
			RequestDispatcher requestdispatch = req.getRequestDispatcher("index.html");

			requestdispatch.include(req, res);//send response as well as index HTML page content
		}
		else{
			out.print("not successfull");
		}
		
		out.close();
	}
	
	
	/**
	 * Inserts an employee in the employee table
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param age
	 * @return updated rows
	 * @throws SQLException
	 */
	public int add(String firstName, String lastName, String email, int age) throws SQLException{
		
		try (
				java.sql.Connection conn = Connection.getConnection();//Allocate a database 'Connection' object
				PreparedStatement psmt = conn.prepareStatement(INSERT_QUERY);) {//Allocate a 'Statement' object in the Connection
			
			psmt.setString(1, firstName);//binding variable with place holder ? at position 1
			psmt.setString(2, lastName);
			psmt.setString(3, email);
			psmt.setInt(4, age);
			
			return psmt.executeUpdate();//TO GET LIST OF POJO class order BY PASSING RESULT SET
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

}