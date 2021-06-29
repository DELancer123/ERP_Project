package com.myspring.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Login.dao.LoginDAO;


@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO loginDAO;
}
