package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IupViewDAO {
	public List viewIup() throws DataAccessException;
	public List viewPop() throws DataAccessException;
	public List setText(String Item_Code) throws DataAccessException;
	public List searchView(String Item_Code) throws DataAccessException;
	public int addIup(IupVO iupVO) throws DataAccessException;
	public void delIup(String[] noary) throws DataAccessException;
	public int updIup(IupVO iupVO) throws DataAccessException;
}
