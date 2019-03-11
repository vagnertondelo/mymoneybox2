package com.adaptaconsultoria.controllers.partner;

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

import com.adaptaconsultoria.models.Accredited;
import com.adaptaconsultoria.models.Partner;
import com.adaptaconsultoria.services.CategoryService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.PartnerService;
import com.adaptaconsultoria.services.SessionService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "partner")
public class PartnerController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Parceiro");
		pageUtil.setTitle("Parceiro");
		sessionService.setAtribute("token", cbcService.requestToken().getToken(), session);
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		return pageUtil.getModel();
	}
	
	@GetMapping(value = "register")
	public ModelAndView accredited(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Parceiro");
		pageUtil.setTitle("Parceiro");
		pageUtil.setInnerTitle("Parceiro");
		pageUtil.setFormId("partner-form");
		pageUtil.setJs("partner-register.js");
		pageUtil.setAttr("mi", "accredited");
		Object obj = new Partner();

//		if (id != null) {
//			pageUtil.setSubTitle("Editar");
//			try {
//				obj = credenciadoDao.findOne(id);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			pageUtil.setSubTitle("Adicionar");
//		}
		
		pageUtil.setAttr("partner", obj);
		pageUtil.setModelAttribute("partner");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		// last call 
		pageUtil.setAttr("categories", categoryService.getCategoryByCompany(session));
		return pageUtil.getModel();
	}
	
	@PostMapping(value = "save")
	public Object register(@RequestBody Accredited obj, HttpSession session) {
		return ResponseEntity.ok( partnerService.save(obj, session) );
	}
}
