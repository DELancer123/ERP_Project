package com.myspring.salesmanage.pop.custView.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;

public interface CustViewService {
	public List custView() throws DataAccessException;
	public List setText(String General_Customer_Code)throws DataAccessException;
	public List searchView(String General_Customer_Code) throws DataAccessException;

}
