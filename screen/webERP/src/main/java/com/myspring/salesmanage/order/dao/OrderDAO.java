package com.myspring.salesmanage.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OrderDAO {
	
	//sta, reg
	public List selectAllOrderList() throws DataAccessException;
	public List selectAllCustList() throws DataAccessException;
	public List submitOrderCust(String custCode) throws DataAccessException;
	
	//reg
//	public int selNo() throws DataAccessException;
//	public int addItem(OrderVO OrderVO) throws DataAccessException;
//	public int updNewSalesplan(String custCode) throws DataAccessException;
//	public void delSalesplan(String[] noary) throws DataAccessException;		
//	public int selPlanCode() throws DataAccessException;

	
//	public List selectItemGroupList() throws DataAccessException;
//	public List addGroup(String groupcode) throws DataAccessException;
//	public List submitGroupView(String groupcode) throws DataAccessException;

}
