package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	//일반거래처등록
	public List viewAllCustomer() throws DataAccessException;
	
	public List viewCustomer(String com_code) throws DataAccessException;
	
	public int insertNewCustomer (SystemmagVO systemmagVO) throws DataAccessException;
	
	public List searchCustomer(String customerCode) throws DataAccessException;
	
	public void deleteCustomer(String[] noary) throws DataAccessException;
	
	public void updateCustomer(SystemmagVO systemmagVO) throws DataAccessException;
	
	public List zipViewCustomer() throws DataAccessException;
	
	public List<SystemmagVO> viewsearchPopName(String itemName) throws DataAccessException;
	
	//창고/공정/외주공정등록
	public List viewAllHouOutware() throws DataAccessException;
	
	public List viewAllProOutware() throws DataAccessException;
	
	public List viewAllOutOutware() throws DataAccessException;
	
	public List viewAllHouWorOutware() throws DataAccessException;
	
	public List viewAllProWorOutware() throws DataAccessException;
	
	public List viewAllOutWorOutware() throws DataAccessException;
	
	//물류관리내역등록
	public List viewAllLogistics() throws DataAccessException;
	
	public List viewSelectedLogistics(String com_code) throws DataAccessException;
	
	public int insertNewLogistics (SystemmagVO systemmagVO) throws DataAccessException;
	
	public void deleteLogistics(String[] noary) throws DataAccessException;
	
	public void updateLogistics(SystemmagVO systemmagVO) throws DataAccessException;
}
