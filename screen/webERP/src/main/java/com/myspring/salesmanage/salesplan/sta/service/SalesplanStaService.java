package com.myspring.salesmanage.salesplan.sta.service;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;

public interface SalesplanStaService {

	//salesplan
	public List listSalesplans() throws DataAccessException;
	
	//item
	public List listItems() throws DataAccessException;
	public List submitItem(String item_code) throws DataAccessException;
	public List itemText(String item_code) throws DataAccessException;
//	public int addItem(ItemViewVO itemviewVO) throws DataAccessException;
//	public int removeItem(String item_Code) throws DataAccessException;
//	public int inputNo() throws DataAccessException;


}