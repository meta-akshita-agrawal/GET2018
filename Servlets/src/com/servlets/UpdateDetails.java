package com.servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import jdbc.Connection;

public class UpdateDetails extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static final String GET_DETAILS_BY_EMAIL = "select * from employee where email = ?";
	
	
	/**
	 * Handles request coming from HTML form
	 * @param req, request
	 * @param res, response after submitting HTML form
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
	
		String email = req.getParameter("email");
		String firstName = null;
		String lastName = null;
		int age = 0;
		int id=0;
		
		java.sql.Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;

		try{
			conn = Connection.getConnection();
			psmt = conn.prepareStatement(GET_DETAILS_BY_EMAIL);
			
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				firstName = rs.getString("First Name");
				lastName = rs.getString("Last Name");
				age = rs.getInt("Age");
				id = rs.getInt("idEmployee");
			}
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"Update\">");
		out.println("<input type='hidden' name='id' value='" + id + "'>");
		out.println("First name <input type='text' name='firstName' value='" + firstName + "'>");
		out.println("Last name <input type='text' name='lastName' value='" + lastName + "'>");
		out.println("Email <input type='text' name='email' value='" + email + "'>");
		out.println("Age <input type='text' name='age' value='" + age + "'>");
		out.println("<input type='submit' value='update'>");
		out.println("</form></body></html>");
		
		out.close();
	}
	
}
