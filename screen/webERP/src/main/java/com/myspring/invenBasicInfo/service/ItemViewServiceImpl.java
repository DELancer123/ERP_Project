package com.myspring.invenBasicInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.invenBasicInfo.regItemUnitPrice.dao.ItemViewDAO;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.ItemVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)

public class ItemViewServiceImpl implements itemViewService{
	@Autowired
	private ItemViewDAO itemDAO;
	
	@Override
	public List itemView() throws DataAccessException{
		List itemList = null;
		itemList = itemDAO.viewItem();
		return itemList;
	}
	
	@Override
	public List popView() throws DataAccessException{
		List popList = null;
		popList = itemDAO.viewPop();
		return popList;
	}
	
	@Override
	public List setText(String Item_Code) throws DataAccessException {
		List searchList = null;
		searchList = itemDAO.setText(Item_Code);
		return searchList;
	}
	
	@Override
	public List SearchView(String Item_Code) throws DataAccessException {
		List searchList = null;
		searchList = itemDAO.SearchView(Item_Code);
		return searchList;
	}
	
	@Override
	public List itemSet() throws DataAccessException {
		List itemSet = null;
		/* itemSet = bomDAO.itemSet(); */
		return null;
	}
	
	@Override
	public int addItem(ItemVO itemVO) throws DataAccessException {
		return itemDAO.addItem(itemVO);
	}
	
	@Override
	public int updateItem(ItemVO itemVO) throws DataAccessException {
		return itemDAO.updateItem(itemVO);
	}
}

