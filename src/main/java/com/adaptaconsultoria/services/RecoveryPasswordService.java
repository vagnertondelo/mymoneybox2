package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Email;

public interface RecoveryPasswordService {
	Object sendEmail(Email email, HttpSession session);
}
