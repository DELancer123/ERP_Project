package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.vo.SystemmagVO;

@Service("SystemmagService")
@Transactional(propagation=Propagation.REQUIRED)
public class SystemmagServiceImpl implements SystemmagService {
	@Autowired
	private SystemmagDAO systemmagDAO;
	
	//�Ϲݰŷ�ó���
	@Override
	public int addCustomer (SystemmagVO systemmagVO) throws Exception{
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
	public void updCustomer(SystemmagVO systemmagVO) throws DataAccessException {		
		systemmagDAO.updateCustomer(systemmagVO);
	}

	@Override
	public List zipViewCustomer() throws DataAccessException {
		return systemmagDAO.zipViewCustomer();
	}

	
	//â��/����/���ְ������
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
	
	//���������������
	@Override
	public List viewAllLogistics() throws DataAccessException {
		List logisticsList = null;
		logisticsList = systemmagDAO.viewAllLogistics();
		return logisticsList;
	}
	
	//���������������
	@Override
	public List viewSelectedLogistics(String com_code) throws DataAccessException {
		List logisticsList = null;
		logisticsList = systemmagDAO.viewSelectedLogistics(com_code);
		return logisticsList;
	}
	
	
	

	

	
	
	
}