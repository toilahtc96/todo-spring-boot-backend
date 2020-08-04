package com.htc.todo.rest.webservices.restfulwebservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcrypPasswordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 10; i++) {

			String encoderStr = encoder.encode("123123a@");
			System.out.println(encoderStr);
		}
	}

}
