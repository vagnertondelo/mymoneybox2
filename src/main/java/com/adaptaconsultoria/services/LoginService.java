package com.adaptaconsultoria.services;

import com.adaptaconsultoria.models.User;

public interface LoginService {
	public User login(String username, String password);
}
