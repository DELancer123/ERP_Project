package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.itemVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;

@Repository("RegItemUnitPriceDAO")
public class itemVIewDAOImpl implements itemViewDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List viewItem() throws DataAccessException{
		List<itemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectAllMemberList");
		return itemList;
	}
	
	@Override
	public List viewPop() throws DataAccessException {
		List<itemVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList");
		return popList;
	}

	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List<itemVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.selectitem",itemNumber);
		return textList;
	}
	@Override
	public List SearchView(String itemNumber) throws DataAccessException{
		List<itemVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.searchitem",itemNumber);
		return searchList;
	}

	@Override
	public int addItem(itemVO itemVO) throws DataAccessException {
		int result = sqlSession.insert("mappers.erp.insertItem",itemVO);
		return 0;
	}
	
	@Override
	public int updateItem(itemVO itemVO) throws DataAccessException {
		int result = sqlSession.update("mappers.erp.updateItem",itemVO);
		return 0;
	}
	
}

