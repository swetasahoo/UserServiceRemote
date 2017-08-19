package com.statckroute.activitiystream.security;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.stackroute.activitystream.model.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	
	//This method is not calling...
	
	

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure******************************************************8");
	    http.csrf().disable().authorizeRequests()
	        //.antMatchers(HttpMethod.GET,"http://localhost:9012/api/user/allusers").permitAll()
	        .antMatchers(HttpMethod.POST, "/api/user/login").permitAll()
	        .anyRequest().authenticated().and()
	        // We filter the api/login requests
	        .addFilterBefore(new JWTLoginFilter("/api/user/login", authenticationManager()),UsernamePasswordAuthenticationFilter.class)
	        // And filter other requests to check the presence of JWT in header
	        .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
	  }

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    
		 /* auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery("select emailId,password,active from user where emailId=?")
		  
		  .authoritiesByUsernameQuery("select emailId,'USER' as role from user where emailId=?");
		  
		 */ 
		  
		  
		  auth.inMemoryAuthentication()
	        .withUser("admin")
	        .password("password")
	        .roles("ADMIN");

	  }
}
