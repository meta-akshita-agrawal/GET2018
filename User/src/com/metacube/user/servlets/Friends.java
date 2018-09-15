package com.metacube.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;

public class Friends extends HttpServlet{

	UserFacade userFacade = UserFacade.getInstance();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
		
		
		
		String email = req.getParameter("email");
		String companyName = userFacade.getUserByEmail(email).getCompanyName();
		
		//System.out.println(out);
		
		List<String> friendsEmailList = userFacade.getEmailListByCompanyName(companyName, email);
		
		//System.out.println(friendsEmailList.get(0));
		
		out.println("<html>");
			out.println("<body>");
				out.println("<table>");
		
					for(String friendEmail:friendsEmailList){
						User user = userFacade.getUserByEmail(friendEmail);
						out.println("<tr>");
						out.println("<form action=\"Profile\">");
							out.println("<td>"+ user.getFirstName() + " " + user.getLastName() +"</td>");
							out.println("<td><input type='hidden' name = 'email' value='" + friendEmail +"'></td>");
							out.println("<td><input type='submit' value='View Profile'></td>");
							out.println("<td><input type='hidden' name='visibility' value='hidden'>");
						out.println("</form>");
						out.println("</tr>");
					}
					
				out.println("</table>");
			out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
