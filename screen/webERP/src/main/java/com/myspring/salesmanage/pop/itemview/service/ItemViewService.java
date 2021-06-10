package com.myspring.salesmanage.pop.itemview.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;


public interface ItemViewService {

	public List listItems() throws DataAccessException;
	public List submitItem(String item_code) throws DataAccessException;
	public List addText(String item_code) throws DataAccessException;
	public int addItem(ItemViewVO itemviewVO) throws DataAccessException;
	public int removeItem(String item_code) throws DataAccessException;
}
