package com.adaptaconsultoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
public class DashboardController {

	@Autowired
	private CbcService cbcService;

	@GetMapping(path = "dashboard")
	public ModelAndView login() {
		PageUtil pageUtil = new PageUtil(new ModelAndView("dashboard"));
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setPageTitle("Dashboard");
		pageUtil.setTitle("Dashboard");
		return pageUtil.getModel();
	}
}
