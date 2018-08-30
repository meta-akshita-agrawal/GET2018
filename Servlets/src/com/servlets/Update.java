package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import jdbc.Connection;

public class Update extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final String UPDATE_QUERY = "update employee set `First Name` = ?, `Last Name` = ?, `Email`=?,`Age` = ? where `idEmployee` = ?";

	/**
	 * Handles request coming from HTML form
	 * @param req, request
	 * @param res, response after submitting HTML form
	 */
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		int result=0;
		
		java.sql.Connection conn=null;
		PreparedStatement psmt =null;

		
		try {
			
			conn = Connection.getConnection();//Allocate a database 'Connection' object
			psmt = conn.prepareStatement(UPDATE_QUERY);
			
			psmt.setString(1, req.getParameter("firstName"));
			psmt.setString(2,req.getParameter("lastName"));
			psmt.setString(3, req.getParameter("email"));
			psmt.setInt(4, Integer.parseInt(req.getParameter("age")));
			psmt.setInt(5, Integer.parseInt(req.getParameter("id")));
			
			result = psmt.executeUpdate();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		if(result==1){
			out.println("updation successfull");
			RequestDispatcher requestdispatch = req.getRequestDispatcher("index.html");

			requestdispatch.include(req, res);
		}
		else{
			out.print("not successfull");
		}
		
	}
	
}
