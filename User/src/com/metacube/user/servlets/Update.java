package com.metacube.user.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.metacube.user.enums.Status;
import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;

public class Update extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserFacade userFacade = UserFacade.getInstance();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String contactNumber = req.getParameter("contactNumber");
		String companyName = req.getParameter("companyName");

		Status updationStatus = userFacade
				.update(new User(firstName, lastName, password, email, contactNumber, companyName));

		if (updationStatus == Status.UPDATED) {
			out.println("Updation successfull");
		} else {
			out.println("Error!");
		}

		req.getRequestDispatcher("Profile").include(req, res);
	}

}
