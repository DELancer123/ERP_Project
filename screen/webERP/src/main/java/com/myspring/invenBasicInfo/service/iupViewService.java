package com.myspring.invenBasicInfo.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.iupVO;

public interface iupViewService {
	public List iupView() throws DataAccessException;
	public List itemView() throws DataAccessException;
	public List setText(String itemCode) throws DataAccessException;
	public List searchView(String itemCode) throws DataAccessException;
	public List itemSet() throws DataAccessException;
	public int addIup(iupVO iupVO) throws DataAccessException;
	public void delIup(String[] noary) throws DataAccessException;
	public int updateIup(iupVO iupVO) throws DataAccessException;
	public int inputNo() throws DataAccessException;
}
