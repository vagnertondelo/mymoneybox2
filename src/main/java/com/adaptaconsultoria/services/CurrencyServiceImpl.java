package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.objects.in.CurrenciesIn;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private JsonService jsonService;
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	private static final String path = "currency";

	@Override
	public Object getCurrencyByCompany(HttpSession session) {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			Object o = requestService.getRequest(path, true, map);
			CurrenciesIn objOp = (CurrenciesIn) jsonService.objToObj(o, new CurrenciesIn());
			return objOp.getCurrencies();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
