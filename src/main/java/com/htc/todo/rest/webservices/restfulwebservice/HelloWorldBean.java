package com.htc.todo.rest.webservices.restfulwebservice;

public class HelloWorldBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloWorldBean(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [name=" + name + "]";
	}
	
	
	
}
