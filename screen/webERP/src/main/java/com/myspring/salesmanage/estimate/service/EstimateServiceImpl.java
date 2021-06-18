package com.myspring.salesmanage.estimate.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.estimate.dao.EstimateDAO;
import com.myspring.salesmanage.estimate.vo.EstimateVO;

@Service("estimateService")
public class EstimateServiceImpl implements EstimateService{

	@Autowired
	private EstimateDAO estimateDAO;
	

	@Override
	public List listCust() throws DataAccessException {
		List allCustList = null;
		allCustList = estimateDAO.selectAllCustList();
		return allCustList;
	}
	
	@Override
	public List listEst() throws DataAccessException {
		List estList = null;
//		estList = estimateDAO.selectEstList();
		return estList;
	}
	
	@Override
	public List submitCust(String custCode) {
		List estList = null;
		estList = estimateDAO.submitEstSta(custCode);
		return estList;
	}
	@Override
	public List listCor() throws DataAccessException {
		List corList = null;
		corList = estimateDAO.selectCorList();
		return corList;
	}



	@Override
	public List submitEstCust(String custCode) throws DataAccessException {
		List searchCustList = null;
		searchCustList = estimateDAO.submitEstCust(custCode);
		return searchCustList;
	}
	@Override
	public List submitCorCust(String custCode) throws DataAccessException {
		List searchCorList = null;
		searchCorList = estimateDAO.submitCorCust(custCode);
		return searchCorList;
	}

	
	
	
	
	
	
	
	
	
	
	
//	public EstimateVO getOneCust(String custCode) {
//	return estimateDAO.getSubmit(custCode);
//}
//
//@Override
//public List submitCust(EstimateVO custCode) {
//	List estList = null;
//	estList = estimateDAO.submitEstSta(custCode);
//	return estList;
//}
}
