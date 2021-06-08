package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.ItemVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;

@Repository("RegItemUnitPriceDAO")
public class ItemVIewDAOImpl implements ItemViewDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List viewItem() throws DataAccessException{
		List<ItemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectAllMemberList");
		return itemList;
	}
	
	@Override
	public List viewPop() throws DataAccessException {
		List<ItemVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList");
		return popList;
	}

	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List<ItemVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.selectitem",itemNumber);
		return textList;
	}
	@Override
	public List SearchView(String itemNumber) throws DataAccessException{
		List<ItemVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.searchitem",itemNumber);
		return searchList;
	}

	@Override
	public int addItem(ItemVO itemVO) throws DataAccessException {
		int result = sqlSession.insert("mappers.erp.insertItem",itemVO);
		return 0;
	}
	
	@Override
	public int updateItem(ItemVO itemVO) throws DataAccessException {
		int result = sqlSession.update("mappers.erp.updateItem",itemVO);
		return 0;
	}
	
}

