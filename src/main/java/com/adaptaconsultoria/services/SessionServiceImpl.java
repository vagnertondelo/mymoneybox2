package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.objects.in.UserIn;


@Service	
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private CbcService cbcService;

	@Override
	public void setAtribute(String name, Object value, HttpSession session) {
		session.setAttribute(name, value);
	}

	@Override
	public void setUser(HttpSession session) {
		UserIn userIn = (UserIn)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		setAtribute("user", userIn.getUser(), session);
	}
	
	@Override
	public void setProjectName(HttpSession session) {
		setAtribute("projectName", cbcService.getName(), session);
	}
	
	@Override
	public User getUser(HttpSession session) {
		try {
			return (User) session.getAttribute("user");
		} catch (Exception e) {
			return null;
		}
	}
}
