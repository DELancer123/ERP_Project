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
	public void delBOM(String[] noary) throws DataAccessException;
	public int updBOM(bomVO bomVO) throws DataAccessException;

	public int selNo() throws DataAccessException;

<<<<<<< .merge_file_a02256
	public List nullView() throws DataAccessException;

=======
>>>>>>> .merge_file_a16300
}
