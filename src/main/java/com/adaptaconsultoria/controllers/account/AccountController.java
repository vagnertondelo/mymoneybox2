package com.adaptaconsultoria.controllers.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.services.AccountService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.SessionService;
import com.adaptaconsultoria.services.UserService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "account")
public class AccountController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private CbcService cbcService;

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@PostMapping(value = "save")
	public Object register(@RequestBody User obj, HttpSession session) {
	    return ResponseEntity.ok(userService.save(obj));
	}

	@GetMapping(value = "register")
	public ModelAndView accredited(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Meus dados");
		pageUtil.setTitle("Meus dados");
		pageUtil.setInnerTitle("Meus dados");
		pageUtil.setFormId("account-form");
		pageUtil.setJs("account-register.js");
		pageUtil.setTableId("accountpercentagedonation-table");
		pageUtil.setModelAttribute("user");
		pageUtil.setAttr("URL", request.getRequestURL().toString().split(request.getRequestURI())[0]);

		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());

		pageUtil.setAttr("user", accountService.getAccountForEditing(session));
		return pageUtil.getModel();
	}

}
