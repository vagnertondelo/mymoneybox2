package com.adaptaconsultoria.services;

import com.adaptaconsultoria.models.User;

public interface UserService {
	public Object save(User user);
	public Boolean isLogin(String login);
	public Boolean isEmail(String email);
}
