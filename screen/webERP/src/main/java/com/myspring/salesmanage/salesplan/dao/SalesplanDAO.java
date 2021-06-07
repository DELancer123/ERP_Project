package com.myspring.salesmanage.salesplan.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanDAO {

		public List selectAllSalesplanList() throws DataAccessException; 
		public int insertSalesplan(SalesplanVO salesplanVO) throws DataAccessException;
		public int updateNewSalesplan(String Item_Code) throws DataAccessException;
		public int deleteSalesplan(String Item_Code) throws DataAccessException;
		public SalesplanVO searchByItemCode(String Item_Code) throws DataAccessException;
		public SalesplanVO searchByItemName(String Item_Name) throws DataAccessException;
		public SalesplanVO searchByPlanDate(Date Plan_Date) throws DataAccessException;
		public SalesplanVO searchByItemGroup(String Item_Group_Code) throws DataAccessException;
		
}

