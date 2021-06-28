package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVOMJ;

public interface SystemmagServiceMJ {
	//일반거래처등록
	public List searchCustomer(String customerCode) throws DataAccessException;
	
	public List viewAllCustomer() throws DataAccessException;
	
	public List viewCustomer(String com_code) throws DataAccessException;
	
	public int addCustomer(SystemmagVOMJ systemmagVO) throws Exception;
	
	public void delCustomer(String[] noary) throws DataAccessException;
	
	public void updCustomer(SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public List zipViewCustomer() throws DataAccessException;
	
	public List<SystemmagVOMJ> searchPopCustomerName(String itemName) throws DataAccessException;
	
	//창고/공정/외주공정등록
	public List viewAllHouOutware() throws DataAccessException;
	
	public List viewAllProOutware() throws DataAccessException;
	
	public List viewAllOutOutware() throws DataAccessException;
	
	public List viewAllHouWorOutware() throws DataAccessException;
	
	public List viewAllProWorOutware() throws DataAccessException;
	
	public List viewAllOutWorOutware() throws DataAccessException;
	
	//물류관리등록
	public List viewAllLogistics() throws DataAccessException;
	
	public List viewSelectedLogistics(String com_code) throws DataAccessException;
	
	public int addLogistics(SystemmagVOMJ systemmagVO) throws Exception;
	
	public void deleteLogistics(String[] noary) throws DataAccessException;
	
	public void updateLogistics(SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public List<SystemmagVOMJ> searchPopLogisticsName(String itemName) throws DataAccessException;
		
}
