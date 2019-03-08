package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.models.Token;

import net.minidev.json.JSONObject;

public interface CbcService {
	
	public String getUrl();
	
	public String getAppToken();
	
	public String getPassword();
	
	public String getIpAdress();
	
	public String getName();
	
	public JSONObject getApplicationCredentials();
	
	public String getGetRequest(String path, MultiValueMap<String, String> parameters);
	
	public String append(String path);
	
	public Token requestToken();
	
	public MultiValueMap<String, String> getBasicPublicServiceRequest();
	
	public HttpEntity<String> getPostRequestHeaders(JSONObject params);
	
	public HttpEntity<?> requestHeaders();
	
	public MultiValueMap<Object, Object> getApplicationCredentialsMultiPart();
	
	public String getToken(HttpSession session);
}
