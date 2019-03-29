package com.adaptaconsultoria.controllers.freely;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.adaptaconsultoria.components.CbcAuthenticationProvider;
import com.adaptaconsultoria.services.CbcService;

@Controller
@RequestMapping(value = "freely")
public class RemoteLoginController {
	
	@Autowired
	private CbcAuthenticationProvider cbcAuthenticationProvider;
	
	@Autowired
	private CbcService cbcService;
	
	@GetMapping(value = "remoteauthenticate")
	public RedirectView remoteAuthenticate(String token, HttpSession session, HttpServletRequest request) {
		SecurityContextHolder.getContext().setAuthentication(
				cbcAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(cbcService.getAppToken(), token)));
		return new RedirectView(request.getContextPath() + "/dashboard");
	}
}
