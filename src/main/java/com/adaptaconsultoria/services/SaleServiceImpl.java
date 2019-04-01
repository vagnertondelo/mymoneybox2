package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.objects.in.SaleIn;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private RequestService requestService;

	@Autowired
	private JsonService jsonService;

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

	@Override
	public Object list() {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			Object o = requestService.getRequest(url, true, map);
			SaleIn objOp = (SaleIn) jsonService.objToObj(o, new SaleIn());
			return objOp.getSales();
		} catch (Exception e) {
			return null;
		}
	}
}
