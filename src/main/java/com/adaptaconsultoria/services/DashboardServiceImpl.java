package com.adaptaconsultoria.services;

import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.objects.in.CategoriesIn;
import com.adaptaconsultoria.objects.in.StatsIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.ws.ServiceMode;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private RequestService requestService;

	@Autowired
	private JsonService jsonService;

	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static final String url = "dashboard/stats";

	@Override
	public Object list() {
		try {
			Object o = requestService.getRequest(url, true, null);
			StatsIn objOp = (StatsIn) jsonService.objToObj(o, new StatsIn());
			return objOp.getStats();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
