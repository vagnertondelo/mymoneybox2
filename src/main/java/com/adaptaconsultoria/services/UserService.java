package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.User;

public interface UserService {
	public Object save(User user);
	public Object isLogin(String login, HttpSession session);
	public Object isEmail(String email, HttpSession session);
}
