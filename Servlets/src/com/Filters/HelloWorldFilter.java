package com.Filters;

import java.io.PrintWriter;
import javax.servlet.*;
public class HelloWorldFilter implements javax.servlet.Filter {
    private FilterConfig filterConfig;
    public void doFilter(final ServletRequest request, final ServletResponse response,
   		 FilterChain chain) throws java.io.IOException, javax.servlet.ServletException  {
   	 System.out.println("Entering Filter");
   	 request.setAttribute("hello", request.getParameter("name") + " from Filter");
   	 PrintWriter out = response.getWriter();  
   	 out.print("filter is invoked before  \n");  
   	 chain.doFilter(request,response);
   	 System.out.println("Exiting HelloWorldFilter");
    }
    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
