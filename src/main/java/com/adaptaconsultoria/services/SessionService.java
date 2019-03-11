package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface SessionService {
	public void setToken(String token, HttpSession session);
	public String getToken(HttpSession session);
	public void setAtribute(String name, Object value, HttpSession session);
}
