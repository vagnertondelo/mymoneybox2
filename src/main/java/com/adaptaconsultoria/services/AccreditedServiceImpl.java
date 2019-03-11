package com.adaptaconsultoria.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.models.Accredited;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccreditedServiceImpl implements AccreditedService {

	@Autowired
	private CbcService cbcService;

	private static final Logger log = LoggerFactory.getLogger(AccreditedServiceImpl.class);
	private static final String url = "seller";
	
	@Override
	public Object save(Accredited obj, HttpSession session) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Object> o = restTemplate.exchange(cbcService.append(url), HttpMethod.POST,
					cbcService.getPostRequestHeaders( objToJson(obj) ), Object.class);
			
			Optional<Object> object = Optional.of(o.getBody());
//			sessionService.setAtribute("token", object.get().getToken(), session);
			return object.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	public String objToJson(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
}
