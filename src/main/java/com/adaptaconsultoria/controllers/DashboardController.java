package com.adaptaconsultoria.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.SessionService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "dashboard")
public class DashboardController {

	@Autowired
	private SessionService sessionService;

	@GetMapping()
	public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Dashboard");
		pageUtil.setTitle("Dashboard");
		
		sessionService.setProjectName(session);
		sessionService.setUser(session);

		pageUtil.setAttr("URL", request.getRequestURL().toString().split(request.getRequestURI())[0]);

		pageUtil.setAttr("mi", "dashboard");
		pageUtil.setJs("dashboard.js");
		return pageUtil.getModel();
	}
}
