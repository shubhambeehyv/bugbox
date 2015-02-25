package com.beehyv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beehyv.modal.User;

public class AuthenticationFilter implements Filter  {
	
	private ServletContext context;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
         
        
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        System.out.println(uri);
        
        
        
        
        HttpSession session = req.getSession(false);
        User currentUser  = (User)session.getAttribute("user");
        
        if(currentUser != null){
        	this.context.log("User Id::"+currentUser.getIdUser());
            
        	chain.doFilter(request, response);
        }else{
        	this.context.log("Unauthorized access request");
        	resp.sendRedirect("Login.jsp?error=login");
        }
		
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
		
	}
	

}
