package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.objects.in.EntityToPersistIn;

public interface EntityService {
	public Object save(EntityToPersistIn obj, HttpSession session);
	public Object getEntities();
	public Object getEntitiesByAccount();
}
