package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Accredited;

public interface AccreditedService {

	public Object save(Accredited obj, HttpSession session);
	public Object list();
	public Object findByAccountNo(String accountNo);

}
