package com.accolite.mini_au;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

public boolean validate(String email) {
		
		for( int i = 0;i < email.length(); i++) {
			if(email.charAt(i) == '@') {
				
				for(int j = i;j < email.length();j++) {
					if(email.charAt(j) == '.')
						return true;
				}
			}
		}
		
		return false;
	}
       
	public void doPost(HttpServletRequest request,HttpServletResponse response)  throws ServletException,IOException  {  
		
			String email = request.getParameter("fname");
			System.out.println("email");
			String validity;  
			boolean isValid = validate(email);
			if(isValid)
				validity = "This is a valid email-id.";
			else validity = "This email id is invalid";
			request.setAttribute("validity", validity);
			request.getRequestDispatcher("/WEB-INF/validity.jsp").forward(request, response);
			
	}  
	
}
