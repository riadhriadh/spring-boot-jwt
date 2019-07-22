package com.riadh.farhati.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	  private  CustomAuth  customAuth;
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		authenticationManagerBuilder.authenticationProvider(customAuth);
		//authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	    .cors().and().csrf().disable()
	    .sessionManagement()
	       .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	       .and()
	     .formLogin().disable()
	     .authorizeRequests()
	       .antMatchers("/auth").permitAll()
	       .antMatchers("/register").permitAll()
	       .anyRequest().authenticated()
	         .and()
	          .httpBasic().disable();
	}
}
