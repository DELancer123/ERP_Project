package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.systemmag.dao.SystemmagDAOMJ;
import com.myspring.systemmag.vo.SystemmagVOMJ;

@Service("SystemmagServiceMJ")
@Transactional(propagation=Propagation.REQUIRED)
public class SystemmagServiceMJImpl implements SystemmagServiceMJ {
	@Autowired
	private SystemmagDAOMJ systemmagDAO;
	
	//일반거래처등록
	@Override
	public int addCustomer (SystemmagVOMJ systemmagVO) throws Exception{
		int result = systemmagDAO.insertNewCustomer(systemmagVO);
		return result;
    }
	
	@Override
	public List searchCustomer(String customerCode) throws DataAccessException {
		List cusList = null;
		cusList = systemmagDAO.searchCustomer(customerCode);
		return cusList;
	}

	@Override
	public List viewAllCustomer() throws DataAccessException {
		List comList = null;
		comList = systemmagDAO.viewAllCustomer();
		return comList;
	}
	
	@Override
	public List viewCustomer(String com_code) throws DataAccessException {
		List comList = systemmagDAO.viewCustomer(com_code);
		return comList;
	}

	@Override
	public void delCustomer(String[] noary) throws DataAccessException {
		systemmagDAO.deleteCustomer(noary);
	}

	@Override
	public void updCustomer(SystemmagVOMJ systemmagVO) throws DataAccessException {		
		systemmagDAO.updateCustomer(systemmagVO);
	}

	@Override
	public List zipViewCustomer() throws DataAccessException {
		return systemmagDAO.zipViewCustomer();
	}
	
	@Override
	public List<SystemmagVOMJ> searchPopCustomerName(String itemName) {
		return systemmagDAO.viewsearchPopName(itemName);
	}
	
	@Override
	public List<SystemmagVOMJ> searchPopZipCodeName(String itemName) {
		return systemmagDAO.viewsearchPopZipCodeName(itemName);
	}

	
	//창고/공정/외주공정등록
	@Override
	public List viewAllHouOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllHouOutware();	
		return outwareList;
	}
	
	@Override
	public List viewAllProOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllProOutware();	
		return outwareList;
	}
	
	@Override
	public List viewAllOutOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllOutOutware();	
		return outwareList;
	}
	
	@Override
	public List viewAllHouWorOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllHouWorOutware();	
		return outwareList;
	}
	
	@Override
	public List viewAllProWorOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllProWorOutware();	
		return outwareList;
	}
	
	@Override
	public List viewAllOutWorOutware() throws DataAccessException {
		List outwareList = null;
		outwareList = systemmagDAO.viewAllOutWorOutware();	
		return outwareList;
	}
	
	//물류관리내역등록
	@Override
	public List viewAllLogistics() throws DataAccessException {
		List logisticsList = null;
		logisticsList = systemmagDAO.viewAllLogistics();
		return logisticsList;
	}
	
	@Override
	public List viewSelectedLogistics(String com_code) throws DataAccessException {
		List logisticsList = null;
		logisticsList = systemmagDAO.viewSelectedLogistics(com_code);
		return logisticsList;
	}
	
	@Override
	public int addLogistics (SystemmagVOMJ systemmagVO) throws Exception{
		int result = systemmagDAO.insertNewLogistics(systemmagVO);
		return result;
    }

	@Override
	public void deleteLogistics(String[] noary) throws DataAccessException {
		systemmagDAO.deleteLogistics(noary);
	}

	@Override
	public void updateLogistics(SystemmagVOMJ systemmagVO) throws DataAccessException {		
		systemmagDAO.updateLogistics(systemmagVO);
	}
	
	@Override
	public List<SystemmagVOMJ> searchPopLogisticsName(String itemName) {
		return systemmagDAO.viewsearchPopLogisticsName(itemName);
	}
	
	

	
	
}