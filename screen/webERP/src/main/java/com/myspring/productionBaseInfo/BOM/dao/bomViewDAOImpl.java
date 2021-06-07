package com.myspring.productionBaseInfo.BOM.dao;

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
		//System.out.println("�떎�삤 �떆�옉 : " + bomList);
		bomList = sqlSession.selectList("mappers.erp.selectAllMemberList");
		//System.out.println("�떎�삤 醫낅즺 : " + bomList);
		return bomList;
	}

	@Override
	public List viewPop() throws DataAccessException {
		List<bomVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList");
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
		int result = sqlSession.insert("mappers.erp.insertBOM",bomVO);
		return 0;
	}
	
	@Override

	public void delBOM(String itemCode) throws DataAccessException{
		Map<String, String> param = new HashMap<>();
		param.put("itemCode", itemCode);
		sqlSession.delete("mappers.erp.deleteBOM", itemCode);
	}


	public int updateBOM(bomVO bomVO) throws DataAccessException {
		int result = sqlSession.update("mappers.erp.updateBOM",bomVO);
		return 0;
	}
	


}
