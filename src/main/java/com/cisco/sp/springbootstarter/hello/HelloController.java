package com.cisco.sp.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHai() {
		return "Hi";
	}

}
