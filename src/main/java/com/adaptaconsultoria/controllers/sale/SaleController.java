package com.adaptaconsultoria.controllers.sale;

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

import com.adaptaconsultoria.models.Account;
import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.objects.in.Seller;
import com.adaptaconsultoria.services.AccountService;
import com.adaptaconsultoria.services.AccreditedService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.SaleService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "sale")
public class SaleController {

	@Autowired
	private CbcService cbcService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccreditedService accreditedService;
	
	@Autowired
	private SaleService saleService;

	@GetMapping(value = "register")
	public ModelAndView partner(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		Sale obj = new Sale();
		pageUtil.setPageTitle("Registro de Compra");
		pageUtil.setTitle("Registro de Compra");
		pageUtil.setInnerTitle("Registro de Compra");
		pageUtil.setFormId("sale-form");
		pageUtil.setJs("sale-register.js");
//		pageUtil.setAttr("rules", getRules(session));
		pageUtil.setAttr("mi", "sale");
		pageUtil.setAttr("sale", obj);
		pageUtil.setModelAttribute("sale");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		return pageUtil.getModel();
	}
	
	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Lista de Compras");
		pageUtil.setTitle("Lista de Compras");
		pageUtil.setSubTitle("Lista de Compras");
		pageUtil.setTableId("sale-table");
		pageUtil.setJs("sale-list.js");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setAttr("mi", "sale");
		return pageUtil.getModel();
	}
	
	@GetMapping(value = "getlist")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok( saleService.list() );
	}
	
	@PostMapping(value = "getaccounts")
	public ResponseEntity<?> getAccountsAutoComplete(String query) {
		return ResponseEntity.ok( accountService.findAccount(query) );
	}

	@PostMapping(value = "getrules")
	private ResponseEntity<?> getRules(HttpSession session) {
		try {
			Account account = (Account) accountService.getAcccount(session);
			Seller seller = (Seller) accreditedService.findByAccountNo(account.getAccountNo());
			return ResponseEntity.ok(seller.getRules());
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "save")
	public Object register(@RequestBody Sale obj, HttpSession session) {
		 return ResponseEntity.ok( saleService.save(obj, session) );
	}
}
