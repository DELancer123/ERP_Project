package com.myspring.salesmanage.estimate.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EstimateDAO {
	public List selectEstimateList() throws DataAccessException;
	public List selectAllCustList() throws DataAccessException;
	public List submitCust(String custCode) throws DataAccessException;
	public List addCust(String custCode) throws DataAccessException;
	

}
