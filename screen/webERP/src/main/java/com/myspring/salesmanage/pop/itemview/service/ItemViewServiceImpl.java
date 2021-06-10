package com.myspring.salesmanage.pop.itemview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.pop.itemview.dao.ItemViewDAO;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;

@Service("itemviewService")
public class ItemViewServiceImpl implements ItemViewService{
	
	@Autowired
	private ItemViewDAO itemviewDAO;

	@Override
	public List listItems() throws DataAccessException {
		List allItemsList = null;
		allItemsList = itemviewDAO.selectAllItemList();
		return allItemsList;
	}
	@Override
	public List submitItem(String item_code) throws DataAccessException {
		List searchList = null;
		searchList = itemviewDAO.searchView(item_code);
		return searchList;
	}

	@Override
	public int addItem(ItemViewVO itemview) throws DataAccessException {
		return itemviewDAO.insertItem(itemview);
	}

	@Override
	public int removeItem(String item_code) throws DataAccessException {
		return itemviewDAO.deleteItem(item_code);
	}


}

//	
////	@Autowired
////	private ItemViewDAO itemViewDAO;
////
////	@Override
////	public List itemSearch() throws DataAccessException {
////		List itemList = null;
////		itemList = itemViewDAO.searchItem();
////		return itemList;
////	}//itemViewDAO.searchItem()
////
////	@Override
////	public List planItemView() throws DataAccessException {
////		List planItemList = null;
////		planItemList = itemViewDAO.viewPlanItem();
////		return planItemList;
////	}//itemViewDAO.viewPlanItem()
////
////	@Override
////	public List itemIn(String Item_Code) throws DataAccessException {
////		List textList = null;
////		textList = itemViewDAO.inItem(Item_Code);
////		return textList;
////	}
////
////	@Override
////	public List viewSearch(String Item_Code) throws DataAccessException {
////		List searchList = null;
////		searchList = itemViewDAO.searchView(Item_Code);
////		return searchList;
////	}
//}
