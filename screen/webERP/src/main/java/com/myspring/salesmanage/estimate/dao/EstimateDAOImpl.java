package com.myspring.salesmanage.estimate.dao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.estimate.vo.EstimateVO;


public class EstimateDAOImpl implements EstimateDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectEstList() throws DataAccessException {
		List<EstimateVO> allEstList = null;
		allEstList = sqlSession.selectList("mappers.erp.selectEstimateList");
		return allEstList;
	}

	@Override
	public List selectAllCustList() throws DataAccessException {
		List<EstimateVO> allCustList = null;
		allCustList = sqlSession.selectList("mappers.erp.selectCustList");
		return allCustList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List<EstimateVO> submitCust= null;
		submitCust = sqlSession.selectList("mappers.erp.submitCust");
		return submitCust;
	}

	@Override
	public List addCust(String custCode) throws DataAccessException {
		List<EstimateVO> addCustList= null;
//		addCustList = sqlSession.selectList("mappers.erp.addCust");
//		System.out.println("확인3"+addCustList);
		return addCustList;
	}

}
