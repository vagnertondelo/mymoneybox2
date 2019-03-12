package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TokenService tokenService;

	private static final Logger log = LoggerFactory.getLogger(PartnerServiceImpl.class);
	private static final String url = "partner";
	
	@Override
	public Object save(Partner obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}

