package com.htc.todo.rest.webservices.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller 
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
			
//	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "/")
	public String helloWorld() {
		return "Hello World22";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
//		throw new RuntimeErrorException(null,"Have Error! Contact HTC To get Support!");
		return new HelloWorldBean("zxcxzc");
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
