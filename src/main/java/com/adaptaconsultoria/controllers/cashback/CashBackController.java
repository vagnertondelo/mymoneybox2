package com.adaptaconsultoria.controllers.cashback;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CashBackService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "cashback")
public class CashBackController {

	@Autowired
	private CbcService cbcService;

	@Autowired
	private CashBackService cashBackService;

	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Extrato de Compras");
		pageUtil.setTitle("Extrato de Compras");
		pageUtil.setSubTitle("Extrato de Compras");
		pageUtil.setTableId("cashback-table");
		pageUtil.setJs("cashback-list.js");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setAttr("mi", "sale");
		return pageUtil.getModel();
	}

	@GetMapping(value = "getlist")
	public ResponseEntity<?> getList(Date dateStart, Date dateEnd) {
		return ResponseEntity.ok(cashBackService.list(dateStart, dateEnd));
	}
}
