package com.myspring.salesmanage.pop.custView.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.pop.custView.vo.CustViewVO;

@Repository("custViewDAO")
public class CustViewDAOImpl implements CustViewDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List viewCust() throws DataAccessException {
		List<CustViewVO> viewCustList = null;
		viewCustList = sqlSession.selectList("mappers.erp.selectAllCustList");
		return viewCustList;
	}

///////////////////////////////////////////////////////////
//	@Override
//	public List viewPop() throws DataAccessException {
//		List<CustViewVO> popCustList = null;
//		popCustList = sqlSession.selectList("mappers.erp.selectPopCustList");
//		return popCustList;
//	}
//	///////////////////////////////////////////////

	@Override
	public List setText(String General_Customer_Code) throws DataAccessException {
		List<CustViewVO> textCustList = null;
		textCustList = sqlSession.selectList("mappers.erp.selectBySearchCust",General_Customer_Code);
		return textCustList;
	}

	@Override
	public List searchView(String General_Customer_Code) throws DataAccessException {
		List<CustViewVO> searchCustList = null;
		searchCustList = sqlSession.selectList("mappers.erp.searchViewCust",General_Customer_Code);
		return searchCustList;
	}

}
