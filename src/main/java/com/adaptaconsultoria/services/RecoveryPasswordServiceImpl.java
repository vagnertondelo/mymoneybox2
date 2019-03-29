package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Email;
import com.adaptaconsultoria.models.Token;

@Service
public class RecoveryPasswordServiceImpl implements RecoveryPasswordService {
	private static final Logger log = LoggerFactory.getLogger(RecoveryPasswordServiceImpl.class);
	private static final String path = "recoverypassword";

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private CbcService cbcService;
	
	public Object sendEmail(Email email, HttpSession session) {
		try {
			Token token = cbcService.requestToken();
			email.setToken(token.getToken());
			email.setIpAddress(token.getIpAddress());
			return requestService.postRequest(path, email ,session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
