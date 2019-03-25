package com.adaptaconsultoria.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.objects.in.CashBackIn;
import com.adaptaconsultoria.utils.date.DateUtil;

@Service
public class CashBackServiceImpl implements CashBackService {
	
	@Autowired
	private RequestService requestService;

	@Autowired
	private JsonService jsonService;

	private static final Logger log = LoggerFactory.getLogger(CashBackServiceImpl.class);
	private static final String url = "cashback";

	@Override
	public Object list(Date dateStart, Date dateEnd) {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			String format = "dd-MM-yyyy";
			map.add("dateStart", DateUtil.dateToString(dateStart, format));
			map.add("dateEnd", DateUtil.dateToString(dateEnd, format));
			Object o = requestService.getRequest(url, true, map);
			CashBackIn objOp = (CashBackIn) jsonService.objToObj(o, new CashBackIn());
			return objOp.getCashbacks();
		} catch (Exception e) {
			log.debug(e.getMessage());
			return null;
		}
	}
}
