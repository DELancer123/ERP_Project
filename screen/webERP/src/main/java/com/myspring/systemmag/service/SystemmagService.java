package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagService {
	//�Ϲݰŷ�ó���
	public int addCustomer(SystemmagVO systemmagVO) throws Exception;
	
	public List searchCustomer(String customerCode) throws DataAccessException;
	
	public List viewAllCustomer() throws DataAccessException;
	
	public List viewCustomer(String com_code) throws DataAccessException;
	
	public void delCustomer(String[] noary) throws DataAccessException;
	
	public void updCustomer(SystemmagVO systemmagVO) throws DataAccessException;
	
	public List zipViewCustomer() throws DataAccessException;
	
	//â��/����/���ְ������
	public List viewAllHouOutware() throws DataAccessException;
	
	public List viewAllProOutware() throws DataAccessException;
	
	public List viewAllOutOutware() throws DataAccessException;
		
}
