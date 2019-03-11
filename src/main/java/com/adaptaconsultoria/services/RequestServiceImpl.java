package com.adaptaconsultoria.services;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private CbcService cbcService;
			
	@Autowired
	private JsonService jsonService;
	
	@Autowired
	private TokenService tokenService;
	
	private static final Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public Object postRequest(String url, Object obj, HttpSession session) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Object> o = restTemplate.exchange(cbcService.append(url), HttpMethod.POST,
					cbcService.getPostRequestHeaders( jsonService.objToJsonString(obj) ), Object.class);
			Optional<Object> object = Optional.of(o.getBody());
			
			Map<Object, Object> map = (Map<Object, Object>)  object.get();
			tokenService.updateToken(map.get("token").toString());
			
			return object.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	
}
