package com.metacube.user.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class ProfileFilter implements Filter {

	@Override
	public void destroy() {	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();  
		
		String email = (String)session.getAttribute("name");
        
		if(session!=null && email.equals(request.getParameter("Email"))){    
          
			out.print("Hello, "+request.getParameter("First Name")+" Welcome to Profile");  
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
        out.close(); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}

}
