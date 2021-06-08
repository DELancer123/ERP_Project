//package com.myspring.salesmanage.pop.custView.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//
//import com.myspring.salesmanage.pop.custView.dao.CustViewDAO;
//
//public class CustViewServiceImpl implements CustViewService{
//	@Autowired
//	private CustViewDAO custViewDAO;
//
//	@Override
//	public List custView() throws DataAccessException {
//		List viewCustList = null;
//		viewCustList = custViewDAO.viewCust();
//		return null;
//	}
//
//	@Override
//	public List setText(String General_Customer_Code) throws DataAccessException {
//		
//		return custViewDAO.setText(General_Customer_Code);
//	}
//
//	@Override
//	public List searchView(String General_Customer_Code) throws DataAccessException {
//		List searchCustList = null;
//		searchCustList = custViewDAO.searchView(General_Customer_Code);
//		return searchCustList;
//	}
//
//}
