package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface RequestService {
	public Object postRequest(String url, Object obj, HttpSession session);
}
