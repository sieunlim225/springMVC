package com.project.instagram.http;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

public class MultiEncodingFilter extends CharacterEncodingFilter{

	private String eucEncoding;

	public void setEucEncoding(String eucEncoding) {
		this.eucEncoding = eucEncoding;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestUri = request.getRequestURI();

		if (requestUri.contains("/anyUrlToSetEuc")) {
			
			request.setCharacterEncoding(this.eucEncoding);
			
			filterChain.doFilter(request, response);
			
		} else {

			super.doFilterInternal(request, response, filterChain);
		}

	}
}
