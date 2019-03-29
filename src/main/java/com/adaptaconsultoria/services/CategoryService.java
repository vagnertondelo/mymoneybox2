package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

public interface CategoryService {
	public Object getPartnerCategoryByCompany(HttpSession session);
	public Object getSellerCategoryByCompany(HttpSession session);
}
