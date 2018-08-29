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


public class AddEmployee extends HttpServlet{

	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int result=0;
		PrintWriter out = res.getWriter();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		try {
			result = add(firstName,lastName,email,Integer.parseInt(age));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result==1){
			out.println("insertion successfull");
			RequestDispatcher requestdispatch = req.getRequestDispatcher("index.html");

			requestdispatch.include(req, res);
		}
		else{
			out.print("not successfull");
		}
		
		out.close();
	}
	
	
	public int add(String firstName, String lastName, String email, int age) throws SQLException{
		
		
		try (
				java.sql.Connection conn = Connection.getConnection();//Allocate a database 'Connection' object
				PreparedStatement psmt = conn.prepareStatement("insert into `employee` (`First Name`,`Last Name`,`Email`,`Age`) values (?,?,?,?);");) {//Allocate a 'Statement' object in the Connection
			
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