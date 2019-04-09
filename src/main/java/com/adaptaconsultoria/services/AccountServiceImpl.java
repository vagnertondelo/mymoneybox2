package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import com.adaptaconsultoria.models.Account;
import com.adaptaconsultoria.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.objects.in.AccountAutoCompleteIn;
import com.adaptaconsultoria.objects.in.AccountIn;

import java.lang.reflect.Method;

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

	@Override
	public Object getAccountForEditing(HttpSession session) {
		try {
			return mergeToAccount(sessionService.getUser(session), (Account) getAcccount(session));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User mergeToAccount(User user, Account account) {
		try {
			User u = new User();

			u.setLastname(user.getLastname());
			u.setName(user.getName());
			u.setLogin(user.getLogin());
			u.setEmail(user.getEmail());
			u.setPhone(u.getPhone());
			u.setRole(user.getRole());

			u.setCountryIsoCode(account.getCountryIsoCode());
			u.setAccountNo(account.getAccountNo());
			u.setSponsorAccountNo(account.getAccountSponsorAccount());
			u.setAddress(account.getAddress());
			u.setAddressCountryIsoCode(account.getCountryIsoCode());
			u.setAddressRegionCode(account.getAddressRegionCode());
			u.setAddressCityCode(account.getAddressCityCode());
			u.setAddressDistrict(account.getAddressDistrict());
			u.setAddressZipcode(account.getAddressZipcode());
			u.setAddressNumber(account.getAddressNumber());

			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
