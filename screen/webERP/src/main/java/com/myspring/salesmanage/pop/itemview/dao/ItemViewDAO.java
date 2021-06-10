package com.myspring.salesmanage.pop.itemview.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;


public interface ItemViewDAO {
	
	 public List selectAllItemList() throws DataAccessException;
	 public int insertItem(ItemViewVO itemviewVO) throws DataAccessException ;
	 public int deleteItem(String item_code) throws DataAccessException;

}
