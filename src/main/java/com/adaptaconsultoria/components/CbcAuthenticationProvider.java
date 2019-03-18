package com.adaptaconsultoria.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.adaptaconsultoria.objects.in.UserIn;
import com.adaptaconsultoria.services.LoginService;

@Component
public class CbcAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String username = authentication.getName().trim();
			String password = authentication.getCredentials().toString().trim();
			Optional<UserIn> op = Optional.of(loginService.login(username, password));
			
			if (op.get().getHasError()) {
				throw new Exception();
			}
			
			List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
			listAuthorities.add(new SimpleGrantedAuthority(op.get().getUser().getRole() ));
			
			return new UsernamePasswordAuthenticationToken(op.get(), password, listAuthorities);
		} catch (Exception e) {
			return null;
		}
	}	

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
