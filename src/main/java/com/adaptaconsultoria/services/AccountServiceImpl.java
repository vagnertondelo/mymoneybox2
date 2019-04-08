package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.objects.in.AccountAutoCompleteIn;
import com.adaptaconsultoria.objects.in.AccountIn;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private RequestService requestService;

	@Autowired
	private SessionService sessionService;

	@Autowired
	private JsonService jsonService;
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	private static final String account = "account";
	private static final String find = account + "/find";

	@Override
	public Object getAcccount(HttpSession session) {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.set("login", sessionService.getUser(session).getLogin());
			Object o = requestService.getRequest(account, true, map);
			AccountIn objOp = (AccountIn) jsonService.objToObj(o, new AccountIn());
			return  objOp.getAccount();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public Object findAccount(String query) {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("query", query);
			Object o = requestService.getRequest(find, true, map);
			AccountAutoCompleteIn objOp = (AccountAutoCompleteIn) jsonService.objToObj(o, new AccountAutoCompleteIn());
			return objOp.getAccounts();
		} catch (Exception e) {
			return null;
		}
	}

}
