package com.tkd.spring.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tkd.spring.auth.components.MyBasicAuthenticationEntryPoint;
import com.tkd.spring.auth.filter.CustomFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("tarun").password("password").roles("ADMIN")
			.and()
			.withUser("arun").password("password").roles("USER")
			.and()
			.withUser("vinayak").password("password").roles("GENERAL_USER")
			.and()
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
			.antMatchers("/admin").access("hasRole('ADMIN')")			
			.antMatchers("/user").access("hasRole('USER')")
			.antMatchers("/generalUser").access("hasRole('GENERAL_USER')")
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.httpBasic();
		
		http.addFilterAfter(new CustomFilter(),BasicAuthenticationFilter.class);*/
		
		/*http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()	
		.antMatchers("/user").hasRole("USER").anyRequest().authenticated()
		.antMatchers("/generalUser").hasRole("GENERAL_USER").anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.httpBasic();
	
	http.addFilterAfter(new CustomFilter(),BasicAuthenticationFilter.class);*/
		
		
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()	
		.antMatchers("/user").hasRole("USER").anyRequest().authenticated()
		.antMatchers("/generalUser").hasRole("GENERAL_USER").anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.httpBasic();
	
	http.addFilterAfter(new CustomFilter(),BasicAuthenticationFilter.class);
	}
	

	
}
