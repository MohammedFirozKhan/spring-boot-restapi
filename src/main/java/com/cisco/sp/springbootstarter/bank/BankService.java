package com.cisco.sp.springbootstarter.bank;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Token getToken() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "DirectLogin username=firozkhan408,password=Test@123456,consumer_key=1rndh3vtdod0tnm2vl0vl1cz0zbxka1adlwjvkvv");

		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		return restTemplate.exchange("https://apisandbox.openbankproject.com/my/logins/direct", HttpMethod.POST, entity, Token.class).getBody();
		
	}
	
	
public String getCreateAccount(Account account, String accountId) {
	
	AccountRouting accountRouting = new AccountRouting();
	accountRouting.setAddress("UK123456");
	accountRouting.setScheme("OBP");
	
	account.setAccountRouting(accountRouting);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "DirectLogin token="+getToken().getToken());

		HttpEntity<Account> entity = new HttpEntity<>(account, headers);

		return restTemplate.exchange("https://apisandbox.openbankproject.com/obp/v4.0.0/banks/at.03.2080.uk/accounts/"+accountId, HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	
	

}
