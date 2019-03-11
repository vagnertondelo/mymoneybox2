package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private RequestService requestService;

	private static final Logger log = LoggerFactory.getLogger(AccreditedServiceImpl.class);
	private static final String url = "partner";
	
	@Override
	public Object save(Object obj, HttpSession session) {
		try {
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
}
