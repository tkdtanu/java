package com.tkd.spring.auth.components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("TarunDas");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic Realm=" + getRealmName() + "");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("Http Status 401 -"+ authException.getMessage());
	}

	
}
