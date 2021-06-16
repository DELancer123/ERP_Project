package com.myspring.salesmanage.salesplan.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;

@Repository("salesplanDAO")
public class SalesplanDAOImpl implements SalesplanDAO{

		@Autowired
		private SqlSession sqlSession;
		
		List<ItemViewVO> itemList;


		@Override
		public List selectAllSalesplanList() throws DataAccessException {
			List<ItemViewVO> salesplansList = null;
			salesplansList = sqlSession.selectList("mappers.erp.selectAllSalesplanList");
			//mapper.salesplan
			return salesplansList;
		}//selectAllMemberList

		@Override
		public List selectAllItemList() throws DataAccessException {
			List<ItemViewVO> allItemList = null;
			allItemList = sqlSession.selectList("mappers.erp.selectAllItemList");
			System.out.println("확인2");
			return allItemList;
		}//selectPopList
		
		@Override
		public List submitItemView(String item_code) throws DataAccessException {
			List<ItemViewVO> searchItemList = null;
			searchItemList = sqlSession.selectList("mappers.erp.submititemview",item_code);
			return searchItemList;
		}//submit를 누르면 table에 들어감
		
//		@Override
//		public int addItem(ItemViewVO itemview) throws DataAccessException {
//			int idx = itemview.getList().size()-1;
//			int result = sqlSession.insert("mappers.erp.insertsalesplan",itemview.getList().get(idx));
//			return result;
//		}
//
//		@Override
//		public int updNewSalesplan(String item_code) throws DataAccessException {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public void delSalesplan(String[] noary) throws DataAccessException {
////			for(String obj: noary) {
////				sqlSession.delete("mappers.erp.delsalesplan", Integer.parseInt(obj));		
////				System.out.println("DAO.delsalesplan");
////			}
//		}
//
//		@Override
//		public String selPlanCode(String nextPlanCode) throws DataAccessException {
//			return sqlSession.selectOne("mappers.erp.selplancode");
//		}
//		
////		@Override
////		public List selectItemGroupList() throws DataAccessException {
////			List<ItemGroupVO> allItemGroupList = null;
////			allItemGroupList = sqlSession.selectList("mappers.erp.selectItemGroupList");
////			return allItemGroupList;
////		}
////		
////		@Override
////		public List submitGroupView(String groupcode) throws DataAccessException{
////			List<ItemGroupVO> searchGroupList = null;
////			searchGroupList = sqlSession.selectList("mappers.erp.submitgroupview",groupcode);
////			return searchGroupList;
////		}
////		@Override
////		public List addGroup(String groupcode) throws DataAccessException {
////			List<ItemGroupVO> addGroupList = null;
////			addGroupList = sqlSession.selectList("mappers.erp.addgroup",groupcode);
////			return addGroupList;
////		}
//
//
//		
//		
//		
//		
//		
////		@Override
////		public int insertItem(ItemViewVO itemviewVO) throws DataAccessException {
////			int result = sqlSession.insert("mappers.erp.insertItem", itemviewVO);
////			return result;
////		}
////	
////		@Override
////		public int deleteItem(String item_code) throws DataAccessException {
////			int result = sqlSession.delete("mappers.erp.deleteItem", item_code);
////			return result;
////		}
////
////		@Override
////		public int selNo() throws DataAccessException {
////			return sqlSession.selectOne("mappers.erp.selectNo");
////		}
////
////		
//////		@Override
//////		public int insertSalesplan(SalesplanVO salesplanVO) throws DataAccessException {
//////			int result = sqlSession.insert("mappers.erp.insertSalesplan", salesplanVO);
//////			return result;
//////		}
//////
//////		@Override
//////		public int updateNewSalesplan(String Item_Code) throws DataAccessException {
//////			int result = sqlSession.update("mappers.erp.updateNewSalesplan", Item_Code);
//////			return result;
//////		}
//////
//////		@Override
//////		public int deleteSalesplan(String Item_Code) throws DataAccessException {
//////			int result = sqlSession.delete("mappers.erp.deleteSalesplan", Item_Code);
//////			return result;
//////		}
//////
//////		@Override
//////		public SalesplanVO searchByItemCode(String Item_Code) throws DataAccessException {
//////			SalesplanVO vo = sqlSession.selectOne("mapper.erp.searchByItemCode",Item_Code);
//////			return vo;
//////		}
//////
////////		@Override
////////		public SalesplanVO searchByItemName(String Item_Name) throws DataAccessException {
////////			SalesplanVO vo = sqlSession.selectOne("mapper.erp.searchByItemName",Item_Name);
////////			return vo;
////////		}
//////
//////		@Override
//////		public SalesplanVO searchByPlanDate(Date Plan_Date) throws DataAccessException {
//////			SalesplanVO vo = sqlSession.selectOne("mappers.erp.searchByPlanDate",Plan_Date);
//////			return vo;
//////		}
//////
//////		@Override
//////		public SalesplanVO searchByItemGroup(String Item_Group_Code) throws DataAccessException {
//////			SalesplanVO vo = sqlSession.selectOne("mappers.erp.searchByPlanGroup",Item_Group_Code);
//////			return vo;
//////		}

}


