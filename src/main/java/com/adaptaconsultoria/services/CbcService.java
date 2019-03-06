package com.adaptaconsultoria.services;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.models.Token;

public interface CbcService {
	public String getUrl();
	public String getToken();
	public String getPassword();
	public String getIpAdress();
	public String getName();
	public MultiValueMap<Object, Object> getAll();
	public HttpEntity<MultiValueMap<Object, Object>> getRequest(MultiValueMap<Object, Object> map);
	public String append(String path);
	public Token requestToken();
}
