package com.myspring.productionBaseInfo.BOM.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;

public interface bomViewDAO {
	public List viewBOM() throws DataAccessException;

	public List viewPop() throws DataAccessException;
	public List setText(String itemNumber) throws DataAccessException;
	public List SearchView(String itemNumber) throws DataAccessException;

	public int addBOM(bomVO bomVO) throws DataAccessException;

	public int updBOM(bomVO bomVO) throws DataAccessException;
}
