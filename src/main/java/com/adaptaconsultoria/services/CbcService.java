package com.adaptaconsultoria.services;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.models.Token;

public interface CbcService {
	public String getUrl();
	
	public String getAppToken();
	
	public String getPassword();
	
	public String getIpAdress();
	
	public String getName();
	
	public MultiValueMap<Object, Object> getApplicationCredentials();
	
	public String getGetRequest(String path, MultiValueMap<String, String> parameters);
	
	public String append(String path);
	
	public Token requestToken();
	
	public MultiValueMap<String, String> getBasicPublicServiceRequest();
	
	public HttpEntity<MultiValueMap<Object, Object>> getPostRequest(MultiValueMap<Object, Object> map);
	
	public HttpEntity<?> requestHeaders();
}
