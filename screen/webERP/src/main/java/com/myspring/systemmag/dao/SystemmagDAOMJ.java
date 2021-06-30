package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVOMJ;

public interface SystemmagDAOMJ {
	//�Ϲݰŷ�ó���
	public List viewAllCustomer() throws DataAccessException;
	
	public List viewCustomer(String com_code) throws DataAccessException;
	
	public int insertNewCustomer (SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public List searchCustomer(String customerCode) throws DataAccessException;
	
	public void deleteCustomer(String[] noary) throws DataAccessException;
	
	public void updateCustomer(SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public List zipViewCustomer() throws DataAccessException;
	
	public List<SystemmagVOMJ> viewsearchPopName(String itemName) throws DataAccessException;
	
	public List<SystemmagVOMJ> viewsearchPopZipCodeName(String itemName) throws DataAccessException;
	
	//â��/����/���ְ������
	public List viewAllHouOutware() throws DataAccessException;
	
	public List viewAllProOutware() throws DataAccessException;
	
	public List viewAllOutOutware() throws DataAccessException;
	
	public List viewAllHouWorOutware() throws DataAccessException;
	
	public List viewAllProWorOutware() throws DataAccessException;
	
	public List viewAllOutWorOutware() throws DataAccessException;
	
	public List viewSelectedHouOutware(String search) throws DataAccessException;
	
	public List viewSelectedProOutware(String search) throws DataAccessException;
	
	public List viewSelectedOutOutware(String search) throws DataAccessException;
	
	//���������������
	public List viewAllLogistics() throws DataAccessException;
	
	public List viewSelectedLogistics(String com_code) throws DataAccessException;
	
	public int insertNewLogistics (SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public void deleteLogistics(String[] noary) throws DataAccessException;
	
	public void updateLogistics(SystemmagVOMJ systemmagVO) throws DataAccessException;
	
	public List<SystemmagVOMJ> viewsearchPopLogisticsName(String itemName) throws DataAccessException;

	public List<SystemmagVOMJ> searchPopOutwareName(String itemName) throws DataAccessException;

}
