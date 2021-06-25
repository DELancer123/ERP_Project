package com.myspring.salesmanage.salesplan.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.salesplan.vo.spVO;

public interface SpViewDAO {
	public List viewSp() throws DataAccessException;
	public List viewPop1() throws DataAccessException;
	public List viewPop2() throws DataAccessException;
	public List setText(String itemCode) throws DataAccessException;
	public List SearchView(String itemCode) throws DataAccessException;
	public int addSp(spVO spVO) throws DataAccessException;
	public void delSp(String[] noary) throws DataAccessException;
	public int updSp(spVO spVO) throws DataAccessException;
	public List spChildView() throws DataAccessException;
}
