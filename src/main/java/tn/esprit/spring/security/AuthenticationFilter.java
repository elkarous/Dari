package tn.esprit.spring.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.spring.SpringApplicationContext;
import tn.esprit.spring.dto.UserDto;
import tn.esprit.spring.service.UserService;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	

	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {

			UserDto creds = new ObjectMapper().readValue(req.getInputStream(), UserDto.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getEncryptedPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String userName = ((User) auth.getPrincipal()).getUsername(); 
	        
            UserService userService = (UserService)SpringApplicationContext.getBean("userSeviceImpl");
	        
	        UserDto userDto = userService.getUser(userName);
	        
	        String token = Jwts.builder()
	                .setSubject(userName)
	                .claim("id", userDto.getUserId())
	                .claim("name", userDto.getFirstName() + " " + userDto.getLastName())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
	                .compact();
	        
	       
	       
	        res.addHeader(SecurityConstants.AUTHORIZATION_HEADER_STRING, SecurityConstants.TOKEN_BEARER_PREFIX + token);
	        res.addHeader("user_id", userDto.getUserId());
	        
	        res.getWriter().write("{\"token\": \"" + token + "\", \"id\": \""+ userDto.getUserId() + "\"}");

	    }  
	 
	  
	 
}
