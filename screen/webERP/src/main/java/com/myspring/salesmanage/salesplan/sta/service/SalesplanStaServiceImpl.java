package com.myspring.salesmanage.salesplan.sta.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.dao.SalesplanDAO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;


@Service("salesplanStaService")
@Transactional(propagation = Propagation.REQUIRED)
public class SalesplanStaServiceImpl implements SalesplanStaService{

	@Autowired
	private SalesplanDAO salesplanDAO;

	//salesplan
	@Override
	public List listSalesplans() throws DataAccessException {
		List salesplanList = null;
		salesplanList = salesplanDAO.selectAllSalesplanList();
		return salesplanList;
	}
	
	//item
	@Override
	public List listItems() throws DataAccessException {
		List allItemsList = null;
		allItemsList = salesplanDAO.selectAllItemList();
		return allItemsList;
	}
	@Override
	public List submitItem(String item_code) throws DataAccessException {
		List searchItemList = null;
		searchItemList = salesplanDAO.submitItemView(item_code);
		return searchItemList;
	}

	@Override
	public List itemText(String item_code) throws DataAccessException {
		List additemList = null;
		additemList = salesplanDAO.addItem(item_code);
		return additemList;
	}
	@Override
	public int addItem(ItemViewVO itemview) throws DataAccessException {
		return salesplanDAO.insertItem(itemview);
	}

	@Override
	public int removeItem(String item_code) throws DataAccessException {
		return salesplanDAO.deleteItem(item_code);
	}
//	//itemgroup
//	@Override
//	public List listGroups() throws DataAccessException{
//		List allItemGroupList = null;
//		allItemGroupList = salesplanDAO.selectItemGroupList();
//		return allItemGroupList;
//	}
//	@Override
//	public List submitGroup(String groupcode) throws DataAccessException{
//		List searchGroupList = null;
//		searchGroupList = salesplanDAO.submitGroupView(groupcode);
//		return searchGroupList;
//	}
//	
//	@Override
//	public List groupText(String groupcode) throws DataAccessException{
//		List addGroupList = null;
//		addGroupList = salesplanDAO.addGroup(groupcode);
//		return addGroupList;
//	}
////
////	@Override
////	public SalesplanVO searchCode(String Item_Code) throws Exception {
////		return salesplanDAO.searchByItemCode(Item_Code);
////	}
////
////	@Override
////	public SalesplanVO searchDate(Date Plan_Date) throws Exception {
////		return salesplanDAO.searchByPlanDate(Plan_Date);
////	}
////
////	@Override
////	public SalesplanVO searchGroup(String Item_Group_Code) throws Exception {
////		return salesplanDAO.searchByItemGroup(Item_Group_Code);
////	}

	@Override
	public int inputNo() throws DataAccessException {
		return salesplanDAO.selNo();
		
	}

	



}
