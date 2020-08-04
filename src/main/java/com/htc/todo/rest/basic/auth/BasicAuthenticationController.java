package com.htc.todo.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller 
@RestController
@CrossOrigin(origins = "http://localhost:4200")				
public class BasicAuthenticationController {
			
	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() {
//		throw new RuntimeErrorException(null,"Have Error! Contact HTC To get Support!");
		return new AuthenticationBean("You art authenticated!");
	}
	
}
