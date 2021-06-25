package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVO;

@Repository("SystemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//�Ϲݰŷ�ó���
	@Override
	public int insertNewCustomer (SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCustomer",systemmagVO);
		return result;
	}
	
	@Override
	public List searchCustomer(String customerCode) throws DataAccessException {
		List<SystemmagVO> cusList = null;
		cusList = sqlSession.selectList("mappers.erp.selectSearchBasicList", customerCode);
		return cusList;
	}

	@Override
	public List viewAllCustomer() throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllBasicList");
		return comList;
	}
	
	@Override
	public List viewCustomer(String com_code) throws DataAccessException {
		List<SystemmagVO> comList = null;
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
	public void updateCustomer(SystemmagVO systemmagVO) throws DataAccessException {
		sqlSession.update("mappers.erp.updateBasicList", systemmagVO);
	}

	@Override
	public List zipViewCustomer() throws DataAccessException {
		List zipList = null;
		zipList = sqlSession.selectList("mappers.erp.selectZipList");
		return zipList;
	}
	
	//â��/����/���ְ������
	@Override /* â��/��� ���� */
	public List viewAllHouOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouOutware");
		return outwareList;
	}
	
	@Override /* �������/�۾��� ���� */
	public List viewAllProOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProOutware");
		return outwareList;
	}
	
	@Override /* ���ְ���/�۾��� ���� */
	public List viewAllOutOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutOutware");
		return outwareList;
	}
	
	@Override /* â��/��� �������̺����� */
	public List viewAllHouWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouWorOutware");
		return outwareList;
	}
	
	@Override /* �������/�۾��� �������̺����� */
	public List viewAllProWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProWorOutware");
		return outwareList;
	}
	
	@Override /* ���ְ���/�۾��� �������̺����� */
	public List viewAllOutWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutWorOutware");
		return outwareList;
	}
	
	//���������������
	@Override
	public List viewAllLogistics() throws DataAccessException {
		List<SystemmagVO> logisticsList = null;
		logisticsList = sqlSession.selectList("mappers.erp.selectAllLogisticsManagement");
		return logisticsList;
	}
	
	@Override
	public List viewSelectedLogistics(String com_code) throws DataAccessException {
		List<SystemmagVO> logisticsList = null;
		logisticsList = sqlSession.selectList("mappers.erp.selectOneLogisticsManagement", com_code);
		return logisticsList;
	}
	
	@Override
	public int insertNewLogistics (SystemmagVO systemmagVO) throws DataAccessException{
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
	public void updateLogistics(SystemmagVO systemmagVO) throws DataAccessException {
		sqlSession.update("mappers.erp.updateLogisticsManagement", systemmagVO);
	}
	

}
