package com.myspring.salesmanage.estimate.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EstimateService {

	//estimate
	public List listEst()  throws DataAccessException;
	
	//cust
	public List listCust() throws DataAccessException;
	public List submitCust(String custCode) throws DataAccessException;
}
