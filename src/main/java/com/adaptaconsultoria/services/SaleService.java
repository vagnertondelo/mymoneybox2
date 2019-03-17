package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Sale;

public interface SaleService {
	Object save(Sale obj, HttpSession session);
	Object list();
}
