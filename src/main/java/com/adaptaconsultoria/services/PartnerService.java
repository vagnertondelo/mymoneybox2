package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Partner;

public interface PartnerService {
	public Object save(Partner obj, HttpSession session);
	public Object findByAccountNo(String accountNo);
	public Object list();
}
