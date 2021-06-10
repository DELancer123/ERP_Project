package com.myspring.salesmanage.pop.itemview.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;

@Repository("itemviewDAO")
public class ItemViewDAOImpl implements ItemViewDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllItemList() throws DataAccessException {
		List<ItemViewVO> allItemsList = null;
		allItemsList = sqlSession.selectList("mappers.erp.selectAllItemList");
		return allItemsList;
	}//allItemsList

	@Override
	public List submitView(String item_code) throws DataAccessException {
		List<ItemViewVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.submitview",item_code);
		return searchList;
	}//submit를 누르면 table에 들어감
	
	@Override
	public int insertItem(ItemViewVO itemviewVO) throws DataAccessException {
		int result = sqlSession.insert("mappers.erp.insertItem", itemviewVO);
		return result;
	}

	@Override
	public int deleteItem(String item_code) throws DataAccessException {
		int result = sqlSession.delete("mappers.erp.deleteItem", item_code);
		return result;
	}

}


////	@Override
////	public List searchItem() throws DataAccessException {
////		List<ItemViewVO> itemViewList = null;
////		itemViewList = sqlSession.selectList("mappers.erp.selectItemSearchList");
////		return itemViewList;
////	}
////
////	@Override
////	public List viewPlanItem() throws DataAccessException {
////		List<ItemViewVO> planList = null;
////		planList = sqlSession.selectList("mappers.erp.selectItemSearchList");
////		return planList;
////	}
////
////	@Override
////	public List inItem(String Item_Code) throws DataAccessException {
////		List<ItemViewVO> textList = null;
////		textList = sqlSession.selectList("mappers.erp.selectItem",Item_Code);
////		return textList;
////	}
////
////	@Override
////	public List searchView(String Item_Code) throws DataAccessException {
////		List<ItemViewVO> searchList = null;
////		searchList = sqlSession.selectList("mappers.erp.searchItem",Item_Code);
////		return searchList;
////	}
////	
//
//
//	
//}
