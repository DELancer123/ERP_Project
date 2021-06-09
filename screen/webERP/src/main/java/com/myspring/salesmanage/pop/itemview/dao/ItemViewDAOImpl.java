//package com.myspring.salesmanage.pop.itemview.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Repository;
//
//import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
//
//@Repository("itemviewDAO")
//public class ItemViewDAOImpl implements ItemViewDAO{
//
//	@Autowired
//	private SqlSession sqlSession;
//
//
//	@Override
//	public List selectAllItemList() throws DataAccessException {
//		List<ItemViewVO> itemqueryList = null;
//		itemqueryList = sqlSession.selectList("mappers.erp.selectAllItemList");
//		System.out.println("뭐냐고"+itemqueryList);
//		return itemqueryList;
//	}
//
//	@Override
//	public int insertMember(ItemViewVO itemview) throws DataAccessException {
//		int result = sqlSession.insert("mappers.erp.insertMember", itemview);
//		return result;
//	}
//
//	@Override
//	public int deleteMember(String id) throws DataAccessException {
//		int result = sqlSession.delete("mappers.erp.deleteMember", id);
//		return result;
//	}
//
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
