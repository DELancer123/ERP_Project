package com.myspring.salesmanage.salesplan.sta.service;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.pop.itemgroup.vo.ItemGroupVO;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanStaService {

	//salesplan
	public List listSalesplans() throws DataAccessException;
	
	//item
	public List listItems() throws DataAccessException;
	public List submitItem(String item_code) throws DataAccessException;
	public List itemText(String item_code) throws DataAccessException;
	public int addItem(ItemViewVO itemviewVO) throws DataAccessException;
	public int removeItem(String item_Code) throws DataAccessException;
	
//	//itemgroup
//	public List listGroups() throws DataAccessException;
//	public List submitGroup(String groupcode) throws DataAccessException;
//	public List groupText(String groupcode) throws DataAccessException;
////	public SalesplanVO searchCode(String Item_Code) throws Exception;
////	public SalesplanVO searchDate(Date Plan_Date) throws Exception;
////	public SalesplanVO searchGroup(String Item_Group_Code) throws Exception;

}
