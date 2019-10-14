package com.cisco.sp.springbootstarter.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	
	@RequestMapping("/token")
	public Token getToken() {
		return bankService.getToken();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createAccount/{accountId}")
	public String createAccount(@RequestBody Account account, @PathVariable String accountId) {
		return bankService.getCreateAccount(account, accountId);
		
	}

}
