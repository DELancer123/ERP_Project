package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVOMJ;

@Repository("SystemmagDAOMJ")
public class SystemmagDAOMJImpl implements SystemmagDAOMJ {
	@Autowired
	private SqlSession sqlSession;
	
	//�Ϲݰŷ�ó���
	@Override
	public int insertNewCustomer (SystemmagVOMJ systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCustomer",systemmagVO);
		return result;
	}
	
	@Override
	public List searchCustomer(String customerCode) throws DataAccessException {
		List<SystemmagVOMJ> cusList = null;
		cusList = sqlSession.selectList("mappers.erp.selectSearchBasicList", customerCode);
		return cusList;
	}

	@Override
	public List viewAllCustomer() throws DataAccessException {
		List<SystemmagVOMJ> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllBasicList");
		return comList;
	}
	
	@Override
	public List viewCustomer(String com_code) throws DataAccessException {
		List<SystemmagVOMJ> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectBasicList",com_code);
		return comList;
	}


	@Override
	public void deleteCustomer(String[] noary) throws DataAccessException {
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteBasicList", Integer.parseInt(obj));	
		}	
	}

	@Override
	public void updateCustomer(SystemmagVOMJ systemmagVO) throws DataAccessException {
		sqlSession.update("mappers.erp.updateBasicList", systemmagVO);
	}

	@Override
	public List zipViewCustomer() throws DataAccessException {
		List zipList = null;
		zipList = sqlSession.selectList("mappers.erp.selectZipList1");
		return zipList;
	}
	
	@Override
	public List<SystemmagVOMJ> viewsearchPopName(String itemName) {
		List<SystemmagVOMJ> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopCustomerList",itemName);
		return popList;
	}
	
	//â��/����/���ְ������
	@Override /* â��/��� ���� */
	public List viewAllHouOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouOutware");
		return outwareList;
	}
	
	@Override /* �������/�۾��� ���� */
	public List viewAllProOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProOutware");
		return outwareList;
	}
	
	@Override /* ���ְ���/�۾��� ���� */
	public List viewAllOutOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutOutware");
		return outwareList;
	}
	
	@Override /* â��/��� �������̺����� */
	public List viewAllHouWorOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouWorOutware");
		return outwareList;
	}
	
	@Override /* �������/�۾��� �������̺����� */
	public List viewAllProWorOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProWorOutware");
		return outwareList;
	}
	
	@Override /* ���ְ���/�۾��� �������̺����� */
	public List viewAllOutWorOutware() throws DataAccessException {
		List<SystemmagVOMJ> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutWorOutware");
		return outwareList;
	}
	
	//���������������
	@Override
	public List viewAllLogistics() throws DataAccessException {
		List<SystemmagVOMJ> logisticsList = null;
		logisticsList = sqlSession.selectList("mappers.erp.selectAllLogisticsManagement");
		return logisticsList;
	}
	
	@Override
	public List viewSelectedLogistics(String com_code) throws DataAccessException {
		List<SystemmagVOMJ> logisticsList = null;
		logisticsList = sqlSession.selectList("mappers.erp.selectOneLogisticsManagement", com_code);
		return logisticsList;
	}
	
	@Override
	public int insertNewLogistics (SystemmagVOMJ systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewLogisticsManagement",systemmagVO);
		return result;
	}

	@Override
	public void deleteLogistics(String[] noary) throws DataAccessException {
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteLogisticsManagement", Integer.parseInt(obj));	
		}	
	}

	@Override
	public void updateLogistics(SystemmagVOMJ systemmagVO) throws DataAccessException {
		sqlSession.update("mappers.erp.updateLogisticsManagement", systemmagVO);
	}
	

}
