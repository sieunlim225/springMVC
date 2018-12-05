package com.mvc.project.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String url = request.getContextPath()+"?error=";
		if(exception instanceof DisabledException) {
           response.sendRedirect(url+"error");
        }else if(exception instanceof InternalAuthenticationServiceException) {
        	 response.sendRedirect(url+"error");
        } else if(exception instanceof BadCredentialsException) {
        	 response.sendRedirect(url+"error");
        } else if(exception instanceof CredentialsExpiredException) { 
        	 response.sendRedirect(url+"error");
        } else if(exception instanceof LockedException) {
        	 response.sendRedirect(url+"error");
        }else if(exception instanceof AccountExpiredException) {
        	 response.sendRedirect(url+"error");
        }else {
        	 response.sendRedirect(url);
        }
		
	}

}
