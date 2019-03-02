package com.adaptaconsultoria.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestServiceImpl implements RequestService {

	@Override
	public Object get(String url, Object request) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object post(String url, @SuppressWarnings("rawtypes") MultiValueMap parameters,
			Class clazz) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);
			return restTemplate.postForEntity(url, request, clazz);
		} catch (Exception e) {

		}
		return null;
	}
}
