package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.springframework.util.MultiValueMap;

public interface RequestService {
	public Object postRequest(String url, Object obj, HttpSession session);
	public Object getRequest(String url, Boolean isLoggedIn, MultiValueMap<String, String> params);
}
