package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.iupVO;

public interface iupViewDAO {
	public List viewIup() throws DataAccessException;
	public List viewPop() throws DataAccessException;
	public List setText(String itemCode) throws DataAccessException;
	public List searchView(String itemCode) throws DataAccessException;
	public int addIup(iupVO iupVO) throws DataAccessException;
	public void delIup(String[] noary) throws DataAccessException;
	public int updateIup(iupVO iupVO) throws DataAccessException;
	public int selNo() throws DataAccessException;
}
