//package com.myspring.salesmanage.pop.custview.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Repository;
//
//import com.myspring.salesmanage.pop.custview.vo.CustViewVO;
//
//@Repository("custviewDAO")
//public class CustViewDAOImpl implements CustViewDAO {
//	
//
//	@Autowired
//	private SqlSession sqlSession;
//	
//
//	@Override
//	public List selectAllCustList() throws DataAccessException {
//		List<CustViewVO> allCustsList = null;
//		allCustsList = sqlSession.selectList("mappers.erp.selectAllCustList");
//		return allCustsList;
//	}
//
//
//	@Override
//	public int insertCust(CustViewVO custviewVO) throws DataAccessException {
//		int result = sqlSession.insert("mappers.erp.insertCust", custviewVO);
//		return result;
//	}
//
//
//	@Override
//	public int deleteCust(String custCode) throws DataAccessException {
//		int result = sqlSession.delete("mappers.erp.deleteCust", custCode);
//		return result;
//	}
//
//
//}
