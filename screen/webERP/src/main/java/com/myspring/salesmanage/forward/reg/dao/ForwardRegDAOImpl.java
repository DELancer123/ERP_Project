package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.forward.vo.ForwardVO;

@Repository("forwardRegDAO")
public class ForwardRegDAOImpl implements ForwardRegDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//popCust
	@Override
	public List selectAllCustList() throws DataAccessException {
		List<ForwardVO> forwardCustList = null;
		forwardCustList = sqlSession.selectList("mappers.erp.allCustforward");
		return forwardCustList;
	}
	
	@Override
	public List submitForwardCustSupReg(String custCode) throws DataAccessException {
		List<ForwardVO> submitCustList = null;
		submitCustList = sqlSession.selectList("mappers.erp.submitSupForward",custCode);
		return submitCustList;
	}

	@Override
	public List selectSupForwardList() throws DataAccessException {
		List<ForwardVO> supForwardList = null;
		supForwardList = sqlSession.selectList("mappers.erp.allSupForward");
		return supForwardList;
	}


	@Override
	public void delSupForward(String[] noary) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
