package com.adaptaconsultoria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.models.Token;
import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.services.RequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CashfastApplicationTests {

	@Autowired
	public RequestService requestService;
	private static final Logger log = LoggerFactory.getLogger(CashfastApplication.class);

	@Test
	public void contextLoads() {
		
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
		
		Token token =  restTemplate.postForObject("http://192.168.3.34:80/cbc/api/auth", request, Token.class);
		
		User user = token.getUser();
		
		System.out.println(user);
		

	}

}
