package com.myspring.Login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.Login.dao.LoginDAO;


@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public List depView() throws DataAccessException {
		List depList = null;
		depList = loginDAO.depView();
		return depList;
	}

	@Override
	public List empView(String depCode) throws DataAccessException {
		List empList = null;
		empList = loginDAO.empView(depCode);
		return empList;
	}
}
