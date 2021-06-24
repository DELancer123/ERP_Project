package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	//일반거래처등록
	public int insertNewCustomer (SystemmagVO systemmagVO) throws DataAccessException;
	
	public List searchCustomer(String customerCode) throws DataAccessException;

	public List viewAllCustomer() throws DataAccessException;
	
	public List viewCustomer(String com_code) throws DataAccessException;
	
	public void deleteCustomer(String[] noary) throws DataAccessException;
	
	public void updateCustomer(SystemmagVO systemmagVO) throws DataAccessException;
	
	public List zipViewCustomer() throws DataAccessException;
	
	//창고/공정/외주공정등록
	public List viewAllHouOutware() throws DataAccessException;
	
	public List viewAllProOutware() throws DataAccessException;
	
	public List viewAllOutOutware() throws DataAccessException;
}
