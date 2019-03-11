package com.adaptaconsultoria.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.SessionService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "dashboard")
public class DashboardController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private SessionService sessionService;

	@GetMapping()
	public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
		User user = new User();
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user.setName(authentication.getPrincipal().toString());
		pageUtil.setPageTitle("Dashboard");
		pageUtil.setTitle("Dashboard");
		sessionService.setAtribute("user", user, session);
		sessionService.setAtribute("projectName", cbcService.getName(), session);
		return pageUtil.getModel();
	}
	
	
	
	
	
}
