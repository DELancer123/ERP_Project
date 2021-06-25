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
	
	//일반거래처등록
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
	
	//창고/공정/외주공정등록
	@Override /* 창고/장소 쿼리 */
	public List viewAllHouOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouOutware");
		return outwareList;
	}
	
	@Override /* 생산공정/작업장 쿼리 */
	public List viewAllProOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProOutware");
		return outwareList;
	}
	
	@Override /* 외주공정/작업장 쿼리 */
	public List viewAllOutOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutOutware");
		return outwareList;
	}
	
	@Override /* 창고/장소 하위테이블쿼리 */
	public List viewAllHouWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllHouWorOutware");
		return outwareList;
	}
	
	@Override /* 생산공정/작업장 하위테이블쿼리 */
	public List viewAllProWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllProWorOutware");
		return outwareList;
	}
	
	@Override /* 외주공정/작업장 하위테이블쿼리 */
	public List viewAllOutWorOutware() throws DataAccessException {
		List<SystemmagVO> outwareList = null;
		outwareList = sqlSession.selectList("mappers.erp.selectAllOutWorOutware");
		return outwareList;
	}
	
	//물류관리내역등록
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
