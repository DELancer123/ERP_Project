package com.myspring.salesmanage.estimate.dao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.estimate.vo.EstimateVO;




@Repository("estimateDAO")
public class EstimateDAOImpl extends SqlSessionDaoSupport implements EstimateDAO{
	

	@Override
	public List selectAllCustList() throws DataAccessException {
		List<EstimateVO> allCustList = null;
		allCustList = getSqlSession().selectList("mappers.erp.selectCustList");
		return allCustList;
	}
	
	@Override
	public List selectEstCorList() throws DataAccessException {
		List<EstimateVO> estCorList = null;
//		estCorList = getSqlSession().selectList("mappers.erp.selectEstCorList");
		return estCorList;
	}
	@Override
	public List submitEstSta(String custCode) throws DataAccessException {
		List<EstimateVO> estList = null;
		estList = getSqlSession().selectList("mappers.erp.submitEstSta",custCode);
		return estList;
	}	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public EstimateVO getSubmit(String custCode) throws DataAccessException{
//		return getSqlSession().selectOne("mappers.erp.submitEstSta",custCode);
//	}

//	@Override
//	public List submitEstSta(EstimateVO custCode) throws DataAccessException {
//		List<EstimateVO> estList = null;
//		estList = getSqlSession().selectList("mappers.erp.submitEstSta",custCode);
//		return estList;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List selectEstList() throws DataAccessException {
		List<EstimateVO> allEstList = null;
//		allEstList = sqlSession.selectList("mappers.erp.selectEstimateList");
		return allEstList;
	}



	@Override
	public List selectCorList() throws DataAccessException {
		List<EstimateVO> allCorList = null;
//		allCorList = sqlSession.selectList("mappers.erp.selectCorList");
		return allCorList;
	}

	@Override
	public List submitEstCust(String custCode) throws DataAccessException {
		List<EstimateVO> submitEstCust= null;
//		submitEstCust = sqlSession.selectList("mappers.erp.submitEstCust");
		return submitEstCust;
	}

	@Override
	public List submitCorCust(String custCode) throws DataAccessException {
		List<EstimateVO> submitCorCust= null;
//		submitCorCust = sqlSession.selectList("mappers.erp.submitCorCust");
		return submitCorCust;
	}

	@Override
	public List addCust(String custCode) throws DataAccessException {
		List<EstimateVO> addCustList= null;
//		addCustList = sqlSession.selectList("mappers.erp.addCust");
		return addCustList;
	}



}
