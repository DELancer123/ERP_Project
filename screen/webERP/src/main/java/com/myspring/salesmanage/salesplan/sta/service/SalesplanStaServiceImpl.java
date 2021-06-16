package com.myspring.salesmanage.salesplan.sta.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.dao.SalesplanDAO;



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
	}//selectItemList
	
	//item
	@Override
	public List listItems() throws DataAccessException {
		List allItemList = null;
		System.out.println("리스트아이템"); 
		allItemList = salesplanDAO.selectAllItemList();
		return allItemList;
	}
	@Override
	public List submitItem(String item_code) throws DataAccessException {
		List searchItemList = null;
		searchItemList = salesplanDAO.submitItemView(item_code);
		return searchItemList;
	}//searchitem

//	@Override
//	public List itemText(String item_code) throws DataAccessException {
//		List additemList = null;
//		additemList = salesplanDAO.salesText(item_code);
//		return additemList;
//	}
//	@Override
//	public int inputNo() throws DataAccessException {
//		return salesplanDAO.selNo();
//		
//	}
//////	@Override
//////	public int addItem(ItemViewVO itemview) throws DataAccessException {
//////		return salesplanDAO.insertItem(itemview);
//////	}
//////
//////	@Override
//////	public int removeItem(String item_code) throws DataAccessException {
//////		return salesplanDAO.deleteItem(item_code);
//////	}

}
