package com.adaptaconsultoria.services;

import com.adaptaconsultoria.objects.in.UserIn;

public interface LoginService {
	public UserIn login(String username, String password);
	public UserIn remoteLogin(String token);
}
