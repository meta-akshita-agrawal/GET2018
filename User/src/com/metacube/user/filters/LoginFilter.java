package com.metacube.user.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;



public class LoginFilter implements Filter {

	UserFacade userFacade = UserFacade.getInstance();
	
	@Override
	public void destroy() {		
	}

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out= res.getWriter();
		
		User user = userFacade.getUserByEmail(req.getParameter("Email"));
		String password = user.getPassword();
		
		if(user == null){
			out.println("Email does not exists. Create One");
			req.getRequestDispatcher("index.html").include(req, res);  
		}
		else if(req.getParameter("Password").equals(password)){
			chain.doFilter(req,res);
		}
		else{
			out.println("UserName or password error");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
