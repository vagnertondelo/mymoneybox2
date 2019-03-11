package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Accredited;

@Service
public class AccreditedServiceImpl implements AccreditedService {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TokenService tokenService;

	private static final Logger log = LoggerFactory.getLogger(AccreditedServiceImpl.class);
	private static final String url = "seller";
	
	@Override
	public Object save(Accredited obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}