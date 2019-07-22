package com.riadh.farhati.controller;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.farhati.domain.TokenResponse;
import com.riadh.farhati.domain.User;
import com.riadh.farhati.security.TokenUtils;
import com.riadh.farhati.service.UserServiceImp;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private TokenUtils tokenUtils;
	
	
	@PostMapping("")
	public  TokenResponse Login(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)throws Exception {

		String header = httpServletRequest.getHeader("Authorization");
		System.out.println(header);
		
		if ((header == null) || (!header.startsWith("Basic "))) {
			
			throw new AuthenticationException();
		}
		
		try {
			String[] tokens = tokenUtils.extractAndDecodeToken(header);
			if (tokens.length != 2) {
			
				throw new IOException("FAIL_DECODE_TOKEN");
			}
			String login = tokens[0];
			String password = tokens[1];
			System.out.println("login"+login );
			System.out.println("passsword"+password );
			
		}catch (Exception e) {
		//	throw new AuthenticationException(e.toString());
		}
			
			
			
		User userResponse = userServiceImp.findUserById(0);
		  TokenResponse tokenResponse =new TokenResponse(tokenUtils.generateToken("hholl"));
		
		return  tokenResponse;
	}
	
}
