package com.myspring.productionBaseInfo.BOM.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;

public interface bomViewDAO {
	public List viewBOM() throws DataAccessException;

	public List viewPop1() throws DataAccessException;
	public List viewPop2() throws DataAccessException;
	public List setText(String itemNumber) throws DataAccessException;
	public List SearchView(String itemNumber) throws DataAccessException;
	public int addBOM(bomVO bomVO) throws DataAccessException;
	public void delBOM(String[] noary) throws DataAccessException;
	public int updBOM(bomVO bomVO) throws DataAccessException;
	public int selNo() throws DataAccessException;

	public List childView(String itemNumber,String childCode) throws DataAccessException;

}
