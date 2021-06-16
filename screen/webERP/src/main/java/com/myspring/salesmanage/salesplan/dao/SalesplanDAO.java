package com.myspring.salesmanage.salesplan.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;

public interface SalesplanDAO {

		public List selectAllSalesplanList() throws DataAccessException;
		public List selectAllItemList() throws DataAccessException;
		public List submitItemView(String item_code) throws DataAccessException;
		public List addItem(String item_code) throws DataAccessException;
//		public List selectItemGroupList() throws DataAccessException;
//		public List submitGroupView(String groupcode) throws DataAccessException;
//		public List addGroup(String groupcode) throws DataAccessException;

//		
//		public int insertItem(ItemViewVO itemviewVO) throws DataAccessException ;
//		public int deleteItem(String item_code) throws DataAccessException;
////		public int insertSalesplan(SalesplanVO salesplanVO) throws DataAccessException;
////		public int updateNewSalesplan(String Item_Code) throws DataAccessException;
////		public int deleteSalesplan(String Item_Code) throws DataAccessException;
////		public SalesplanVO searchByItemCode(String Item_Code) throws DataAccessException;
////		public SalesplanVO searchByPlanDate(Date Plan_Date) throws DataAccessException;
////		public SalesplanVO searchByItemGroup(String Item_Group_Code) throws DataAccessException;
//		public int selNo() throws DataAccessException;
//		
}	