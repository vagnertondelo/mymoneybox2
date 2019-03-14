package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Sale;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RequestService requestService;
	
	private static final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);
	private static final String url = "sale";
	
	@Override
	public Object save(Sale obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
}
