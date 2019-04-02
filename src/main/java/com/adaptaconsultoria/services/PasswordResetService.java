package com.adaptaconsultoria.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Password;

public interface PasswordResetService {
	public Object save(Password obj, HttpSession session, HttpServletRequest request);
}
