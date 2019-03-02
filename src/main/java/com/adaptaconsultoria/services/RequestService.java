package com.adaptaconsultoria.services;

import org.springframework.util.MultiValueMap;

public interface RequestService {
	public Object get(String url, Object request);
	public Object post(String url, MultiValueMap<String, String> parameters, Class<?> clazz);
}
