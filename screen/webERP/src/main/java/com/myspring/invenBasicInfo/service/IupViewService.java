package com.myspring.invenBasicInfo.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.IupVO;

public interface IupViewService {
	public List iupView() throws DataAccessException;
	public List itemView() throws DataAccessException;
	public List setText(String Item_Code) throws DataAccessException;
	public List searchView(String Item_Code) throws DataAccessException;
	public List itemSet() throws DataAccessException;
	public int addIup(IupVO iupVO) throws DataAccessException;
	public void delIup(String[] noary) throws DataAccessException;
	public int updateIup(IupVO iupVO) throws DataAccessException;
	public int inputNo() throws DataAccessException;
}
