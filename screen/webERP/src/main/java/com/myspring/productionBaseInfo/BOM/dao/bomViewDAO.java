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

<<<<<<< HEAD
	public void delBOM(String itemCode) throws DataAccessException;
=======
	public int updateBOM(bomVO bomVO) throws DataAccessException;
>>>>>>> 81038a2736614bc72197ad0df327da9ba7a333f2
}
