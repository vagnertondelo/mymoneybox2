package com.adaptaconsultoria.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.AccountService;
import com.adaptaconsultoria.services.DashboardService;
import com.adaptaconsultoria.services.SessionService;
import com.adaptaconsultoria.utils.pages.PageUtil;
import com.sun.org.glassfish.external.statistics.Stats;

@Controller
@RequestMapping(value = {"dashboard", ""})
public class DashboardController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private AccountService accountService;

	@GetMapping()
	public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
		String path = request.getServletPath();

		if (path.equals("/")) {
			path = "/dashboard";
		}

		PageUtil pageUtil = new PageUtil(new ModelAndView(path));
		pageUtil.setPageTitle("Dashboard");
		pageUtil.setTitle("Dashboard");
		sessionService.setProjectName(session);
		sessionService.setUser(session);
		pageUtil.setAttr("URL", request.getRequestURL().toString().split(request.getRequestURI())[0]);
		pageUtil.setAttr("mi", "dashboard");
		List<Stats> stats = (List<Stats>) dashboardService.list();

		pageUtil.setAttr("stats", stats);
		pageUtil.setJs("dashboard.js");

		return pageUtil.getModel();
	}

	@GetMapping("getaccount")
	public ResponseEntity<?> getAccount(HttpSession session) {
		return ResponseEntity.ok(accountService.getAcccount(session));
	}
}
