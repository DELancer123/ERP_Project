package com.myspring.productionBaseInfo.BOM.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.productionBaseInfo.service.BomViewService;

@Repository("bomViewDAO")
public class bomViewDAOImpl implements bomViewDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List viewBOM() throws DataAccessException {
		List<bomVO> bomList = null;
		//System.out.println("�뜝�럥堉꾢뜝�럩沅� �뜝�럥六삣뜝�럩�굚 : " + bomList);
		bomList = sqlSession.selectList("mappers.erp.selectAllMemberList");
		//System.out.println("�뜝�럥堉꾢뜝�럩沅� 占쎈꽞占쎄턁筌앾옙 : " + bomList);
		return bomList;
	}

	@Override
	public List viewPop1() throws DataAccessException {
		List<bomVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList1");
		return popList;
	}
	@Override
	public List viewPop2() throws DataAccessException {
		List<bomVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList2");
		return popList;
	}

	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List<bomVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.selectitem",itemNumber);
		return textList;
	}
	@Override
	public List SearchView(String itemNumber) throws DataAccessException{
		List<bomVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.searchitem",itemNumber);
		return searchList;
	}

	@Override
	public int addBOM(bomVO bomVO) throws DataAccessException {
		int idx = bomVO.getListVO().size()-1;
		int result = sqlSession.insert("mappers.erp.insertBOM",bomVO.getListVO().get(idx));
		return 0;
	}
	
	@Override
	public void delBOM(String[] noary) throws DataAccessException{
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteBOM", Integer.parseInt(obj));		
			System.out.println("DAO.delBOM");
		}
	}


	@Override
	public int updBOM(bomVO bomVO) throws DataAccessException {
		int result = 0; 

		int idx = bomVO.getListVO().size()-1;
		for(int i = 0; i<idx;i++) {
			System.out.println("i"+i);
		System.out.println("idx : "+idx);
		result = sqlSession.update("mappers.erp.updateBOM",bomVO.getListVO().get(i));		
		System.out.println("DAOresult:"+result);
		//bomList.add(bomVO);
		//}
		}
		return result;
	}

	@Override
	public int selNo() throws DataAccessException {
		return sqlSession.selectOne("mappers.erp.selectNo");
	}

	@Override
	public List childView() throws DataAccessException {
		return sqlSession.selectList("mappers.erp.childView");
	}
	


}
