package com.adaptaconsultoria.components;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.services.LoginService;

@Component
public class CbcAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		try {
			Optional<User> op = Optional.of(loginService.login(username, password));
			return new UsernamePasswordAuthenticationToken(op.get().getName(), password, new ArrayList<>());
		} catch (Exception e) {
			return null;
		}
	}	

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
