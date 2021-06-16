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
	public List selectEstimateList() throws DataAccessException {
		List<EstimateVO> allEstList = null;
//		allEstList = sqlSession.selectList("mappers.erp.selectEstimateList");
//		System.out.println("확인1"+allEstList);
		return allEstList;
	}

	@Override
	public List selectAllCustList() throws DataAccessException {
		List<EstimateVO> allCustList = null;
//		allCustList = sqlSession.selectList("mappers.erp.selectAllCustList");
//		System.out.println("확인2"+allCustList);
		return allCustList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List<EstimateVO> submitCust= null;
//		submitCust = sqlSession.selectList("mappers.erp.submitCust");
//		System.out.println("확인3"+submitCust);
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
