package com.adaptaconsultoria.services;

import com.adaptaconsultoria.objects.in.UserIn;

public interface LoginService {
	public UserIn login(String username, String password);
}
