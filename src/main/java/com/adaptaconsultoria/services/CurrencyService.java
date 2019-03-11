package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface CurrencyService {
	public Object getCurrencyByCompany(HttpSession session);
}
