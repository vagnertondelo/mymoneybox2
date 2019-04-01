package com.adaptaconsultoria.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Password;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private CbcService cbcService;
	
	private static final Logger log = LoggerFactory.getLogger(PasswordResetServiceImpl.class);
	private static final String url = "recoverypassword/redefine";
	
	@Override
	public Object save(Password obj, HttpSession session, HttpServletRequest request) {
		try {
			obj.setToken(tokenService.getToken());
			obj.setIpAddress(cbcService.getIpAdress());
			SecurityContextHolder.clearContext();
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
