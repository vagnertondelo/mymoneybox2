package com.adaptaconsultoria.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonServiceImpl implements JsonService {

	private static final Logger log = LoggerFactory.getLogger(JsonServiceImpl.class);
	
	@Override
	public String objToJsonString(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Object objToObj(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.convertValue(obj, obj.getClass());
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}
}
