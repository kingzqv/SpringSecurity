package com.test;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.entity.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(arg1, "username", null, "�û�������Ϊ��");    
        ValidationUtils.rejectIfEmpty(arg1, "password", null, "�Ա���Ϊ��");   
        ValidationUtils.rejectIfEmpty(arg1, "state", null, "���䲻��Ϊ��");   
	}

}
