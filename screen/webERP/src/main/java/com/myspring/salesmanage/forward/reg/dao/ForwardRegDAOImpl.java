package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.cor.vo.CorVO;
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
	public List selectCustList() throws DataAccessException {
		List<ForwardVO> custList = null;
		custList = sqlSession.selectList("mappers.erp.selcustforward");
		return custList;
	}

	@Override
	public List submitForwardCustReg(String custCode) throws DataAccessException {
		List<ForwardVO> submitCustList = null;
		submitCustList = sqlSession.selectList("mappers.erp.submitCustForward",custCode);
		return submitCustList;
	}

	@Override
	public List selectCustInsert() throws DataAccessException {
		List<ForwardVO> supForwardInsert = null;
		supForwardInsert = sqlSession.selectList("mappers.erp.supForwardInsert");
		return supForwardInsert;
	}

	
	@Override
	public List ChildView() throws DataAccessException {
		return sqlSession.selectList("mappers.erp.ChildView");
	}
	
	
	@Override
	public List submitSubForwardCustReg(String relCode) throws DataAccessException {
		List<ForwardVO> submitCustList = null;
		submitCustList = sqlSession.selectList("mappers.erp.submitForwardItem",relCode);
		return submitCustList;
	}

	@Override
	public List selectForwardSubList() throws DataAccessException {
		List<CorVO> forwardItemList = null;
		forwardItemList = sqlSession.selectList("mappers.erp.allForwardItem");
		return forwardItemList;
	}
	
	@Override
	public int selRelCode() throws DataAccessException {	
		return sqlSession.selectOne("mappers.erp.selRelCode");
	}

	@Override
	public void delSupForward(String[] forwardCodeary) throws DataAccessException {
		for(String relCode: forwardCodeary) {
			sqlSession.delete("mappers.erp.delSupforward",relCode);
			}
		
	}	

	@Override
	public int addForward(ForwardVO forwardVO) throws DataAccessException {
		int idx = forwardVO.getListVO().size()-1;
		int result = sqlSession.insert("mappers.erp.insertSupForward",forwardVO.getListVO().get(idx));
		return 0;
	}

	@Override
	public int updForward(ForwardVO forwardVO) throws DataAccessException {
		int result = 0; 

		int idx = forwardVO.getListVO().size();
		for(int i = 0; i<idx; i++) {
			System.out.println("i" + i);
		System.out.println("idx : " + idx);
		result = sqlSession.update("mappers.erp.updateForward", forwardVO.getListVO().get(i));		
		System.out.println("DAOresult:"+result);
		}
		return result;
	}

//
//	
//	
//
//	@Override
//	public void delForwardItem(String[] itemCodeary) throws DataAccessException {
//		for(String obj: itemCodeary) {
//			sqlSession.delete("mappers.erp.delForwardItem",obj);		
//			System.out.println("DAO.delForwardItem");
//		}
//	}
//	@Override
//	public List forwardChildView() throws DataAccessException {
//		return sqlSession.selectList("mappers.erp.forwardChildView");
//	}
//
//	@Override
//	public int addForwardItem(CorVO forwardItemVO) throws DataAccessException {
//		int idx = forwardItemVO.getListCor().size()-1;
//		int result = sqlSession.insert("mappers.erp.insertSp",forwardItemVO.getListCor().get(idx));
//		return 0;
//	}

}
