package com.metacube.user.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;



public class LoginFilter implements Filter {

	UserFacade userFacade = UserFacade.getInstance();
	
	public void destroy() {		
	}


	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		PrintWriter out= response.getWriter();
		
		User user = userFacade.getUserByEmail(request.getParameter("email"));
		
		if(user == null){
			out.println("Email does not exists. Create One");
			request.getRequestDispatcher("index.html").include(request, response);  
		}
		else if(request.getParameter("password").equals(user.getPassword())){
			chain.doFilter(request,response);
		}
		else{
			out.println("UserName or password error");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
