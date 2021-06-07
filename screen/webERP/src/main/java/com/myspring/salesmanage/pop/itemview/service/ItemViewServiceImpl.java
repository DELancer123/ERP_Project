package com.myspring.salesmanage.pop.itemview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.pop.itemview.dao.ItemViewDAO;

@Service("itemViewService")
public class ItemViewServiceImpl implements ItemViewService {
	
	@Autowired
	private ItemViewDAO itemViewDAO;

	@Override
	public List itemSearch() throws DataAccessException {
		List itemList = null;
		itemList = itemViewDAO.searchItem();
		return itemList;
	}//itemViewDAO.searchItem()

	@Override
	public List planItemView() throws DataAccessException {
		List planItemList = null;
		planItemList = itemViewDAO.viewPlanItem();
		return planItemList;
	}//itemViewDAO.viewPlanItem()

	@Override
	public List itemIn(String Item_Code) throws DataAccessException {
		List textList = null;
		textList = itemViewDAO.inItem(Item_Code);
		return textList;
	}

	@Override
	public List viewSearch(String Item_Code) throws DataAccessException {
		List searchList = null;
		searchList = itemViewDAO.searchView(Item_Code);
		return searchList;
	}
}
