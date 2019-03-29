package com.adaptaconsultoria.controllers.entity;

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

import com.adaptaconsultoria.models.Entity;
import com.adaptaconsultoria.objects.in.EntityToPersistIn;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.EntityService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "entity")
public class EntityController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private EntityService entityService;
	
	
	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Entidade");
		pageUtil.setTitle("Entidade");
		pageUtil.setSubTitle("Entidade");
		pageUtil.setTableId("entity-table");
		pageUtil.setJs("entity-list.js");
		pageUtil.setAttr("mi", "entity");
		return pageUtil.getModel();
	}
	
	@GetMapping(value = "getlist")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok( entityService.getEntitiesByAccount() );
	}
	
	@PostMapping(value = "save")
	public Object register(@RequestBody EntityToPersistIn obj, HttpSession session) {
		return ResponseEntity.ok( entityService.save(obj, session) );
	}
	
	@GetMapping(value = "register")
	public ModelAndView entity(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Entidade");
		pageUtil.setTitle("Entidade");
		pageUtil.setInnerTitle("Entidade");
		pageUtil.setFormId("entity-form");
		pageUtil.setJs("entity-register.js");
		pageUtil.setTableId("entitypercentagedonation-table");
		pageUtil.setAttr("entities", entityService.getEntities());
		pageUtil.setAttr("mi", "entity");
		Entity obj = new Entity();

		pageUtil.setAttr("entity", obj);
		pageUtil.setModelAttribute("entity");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		return pageUtil.getModel();
	}
}
