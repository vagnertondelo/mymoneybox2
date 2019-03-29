package com.adaptaconsultoria.services;

import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.objects.in.UserIn;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public void updateToken(String token) {
		try {
			UserIn userIn = new UserIn();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			userIn = (UserIn) auth.getPrincipal();
			userIn.setToken(token);
			
			Authentication newAuth = new UsernamePasswordAuthenticationToken(userIn, auth.getCredentials(),
					new ArrayList<>());
			SecurityContextHolder.getContext().setAuthentication(newAuth);
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public String getToken() {
		try {
			UserIn userIn = new UserIn();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			userIn = (UserIn) auth.getPrincipal();
			return userIn.getToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
