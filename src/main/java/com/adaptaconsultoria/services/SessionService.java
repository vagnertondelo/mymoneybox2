package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.User;

public interface SessionService {
	public void setUser(HttpSession session);
	public void setAtribute(String name, Object value, HttpSession session);
	public void setProjectName(HttpSession session);
	public User getUser(HttpSession session);
}
