package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface AccountService {
	public Object getAcccount(HttpSession session);
	public Object findAccount(String query);
}
