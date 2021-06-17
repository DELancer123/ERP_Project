package com.myspring.salesmanage.estimate.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.estimate.dao.EstimateDAO;

@Service("estimateService")
public class EstimateServiceImpl implements EstimateService{

	@Autowired
	private EstimateDAO estimateDAO;
	
	@Override
	public List listEst() throws DataAccessException {
		List estList = null;
		estList = estimateDAO.selectEstList();
		return estList;
	}

	@Override
	public List listCust() throws DataAccessException {
		List custList = null;
		custList = estimateDAO.selectAllCustList();
		return custList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List searchCustList = null;
		searchCustList = estimateDAO.submitCust(custCode);
		return searchCustList;
	}

}
