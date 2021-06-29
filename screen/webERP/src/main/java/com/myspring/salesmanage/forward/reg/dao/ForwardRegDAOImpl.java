package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.cor.vo.CorVO;
import com.myspring.salesmanage.forward.vo.ForwardVO;
import com.myspring.systemmag.vo.SystemmagVOMJ;

@Repository("forwardRegDAO")
public class ForwardRegDAOImpl implements ForwardRegDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//popCust
	@Override
	public List selectAllCustList() throws DataAccessException {
		List<SystemmagVOMJ> custList = null;
		custList = sqlSession.selectList("mappers.erp.allCustList");
		return custList;
	}//popRegForwardCust1 
	
	@Override
	public List selectCustsList() throws DataAccessException {
		List<ForwardVO> custForwardList = null;
		custForwardList = sqlSession.selectList("mappers.erp.selCustforward");
		return custForwardList;
	}//pop2 (cust for insert)
		
	@Override
	public List submitForwardCustSupReg(String general_Customer_Code) throws DataAccessException {
		List<ForwardVO> submitCustList = null;
		submitCustList = sqlSession.selectList("mappers.erp.submitSupForward",general_Customer_Code);
		return submitCustList;
	}//choice custCode by superForward 
	
	@Override
	public void delSupForward(String[] forwardCodeary) throws DataAccessException {
		for(String relCode: forwardCodeary) {
			sqlSession.delete("mappers.erp.delSupforward",relCode);
			}
		
	}//delete super Forward  
	
	@Override
	public List submitForwardReg(String custCode) throws DataAccessException {
		List<ForwardVO> submitList = null;
		submitList = sqlSession.selectList("mappers.erp.submitCustForward",custCode);
		return submitList;
	}//choice custCode by insert  

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


	@Override
	public int addForward(ForwardVO forwardVO) throws DataAccessException {
		int idx = forwardVO.getListVO().size()-1;
		int result = sqlSession.insert("mappers.erp.insertSupForward",forwardVO.getListVO().get(idx));
		return 0;
	}

}
