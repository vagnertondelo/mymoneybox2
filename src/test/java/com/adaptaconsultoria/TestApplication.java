package com.adaptaconsultoria;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.models.Bean;
import com.adaptaconsultoria.objects.in.UserIn;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.LocationService;
import com.adaptaconsultoria.services.RequestService;
import com.adaptaconsultoria.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

	@Autowired
	public RequestService requestService;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private LocationService locationService;

	@Test
	public void contextLoads() {
		testAccount();
	}
	
	public void getLocation() {
		locationService.getLocationByCompany();
	}

	public void testJson() {
		String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

		try {
			Bean bean = new ObjectMapper().readerFor(Bean.class).readValue(json);

			System.out.println(bean.getProperties().get("name"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testAccount() {
		JSONObject request = new JSONObject();
		request.put("firstname", "maria");
		RestTemplate restTemplate = new RestTemplate();

		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		// send request and parse result
		ResponseEntity<Object> r = restTemplate.exchange("http://localhost:8082/cbc/api/account", HttpMethod.POST, entity, Object.class);
		System.out.println(r);
	}

	public void testUser() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("appToken", "00463E4E085EFDFE9527CFC07503AE6A2A925E9593761A540805F9C259DB0C23");
		map.add("appPassword", "FB88F6C4EB701247DDBE7EB0F5F57655A6228C66E1395D0301B390105EB3ABD8");
		map.add("ipAddress", "localhost");
		map.add("userName", "moises");
		map.add("userPassword", "1");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//		List<UserIn> userIn = restTemplate.postForObject("http://localhost:8090/cbc/api/account", request, UserIn.class);
//		Object object =  restTemplate.postForObject("http://localhost:8090/cbc/api/account", request, Object.class);

//		ResponseEntity<List<UserIn>> obj = restTemplate.exchange("http://localhost:8090/cbc/api/account", HttpMethod.POST, null, new ParameterizedTypeReference<List<UserIn>>() {});
		ResponseEntity<UserIn> obj = restTemplate.exchange("http://192.168.0.34/cbc/api/auth", HttpMethod.POST, request, UserIn.class);
		
	    UserIn userIn = obj.getBody();
		System.out.println(userIn);
	}

}
