package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "spring";
	}

}
