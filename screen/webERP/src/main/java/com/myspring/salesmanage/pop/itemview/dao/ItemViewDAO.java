package com.myspring.salesmanage.pop.itemview.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ItemViewDAO {

	public List searchItem() throws DataAccessException;
	public List viewPlanItem() throws DataAccessException;
	public List inItem(String Item_Code) throws DataAccessException;
	public List searchView(String Item_Code) throws DataAccessException;
	
}
