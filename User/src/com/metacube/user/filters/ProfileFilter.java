package com.metacube.user.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;

public class ProfileFilter implements Filter {

	UserFacade userFacade = UserFacade.getInstance();

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession(false);  
		
		System.out.println("email: " + req.getParameter("email"));
		
		User user = userFacade.getUserByEmail(req.getParameter("email"));
		
//		String email = (String)session.getAttribute("name");
//       
		System.out.println(req.getSession(false));
		
		if(session!=null){    
          
			out.print("Hello, "+user.getFirstName()+" Welcome to Profile");  
			chain.doFilter(request, response);
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
        out.close(); 
	}

	public void init(FilterConfig arg0) throws ServletException {		
	}
	
	public void destroy() {	
	}

}
