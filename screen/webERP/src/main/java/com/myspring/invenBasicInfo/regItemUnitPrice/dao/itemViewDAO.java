package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import org.springframework.dao.DataAccessException;
import java.util.List;

public interface itemViewDAO {
	public List viewItem() throws DataAccessException;
	public List viewPop() throws DataAccessException;
	
	public List setText(String Item_Code) throws DataAccessException;
	public List SearchView(String Item_Code) throws DataAccessException;
	
	public int addItem(ItemVO itemVO) throws DataAccessException;
	public int updateItem(ItemVO itemVO) throws DataAccessException;
}
