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

		//sta, reg
		public List selectAllSalesplanList() throws DataAccessException;
		public List selectAllItemList() throws DataAccessException;
		public List submitItemView(String item_code) throws DataAccessException;
		
		//reg
		public int selCode() throws DataAccessException;
		public int insertItem(ItemViewVO itemview) throws DataAccessException;
		public void deletePlan(String[] planAry) throws DataAccessException;		
//		public int updNewSalesplan(String item_code) throws DataAccessException;

		
//		public List selectItemGroupList() throws DataAccessException;
//		public List addGroup(String groupcode) throws DataAccessException;
//		public List submitGroupView(String groupcode) throws DataAccessException;
}	