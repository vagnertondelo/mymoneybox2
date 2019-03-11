package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface SessionService {
	public void setUser(HttpSession session);
	public void setAtribute(String name, Object value, HttpSession session);
	public void setProjectName(HttpSession session);
	
}
