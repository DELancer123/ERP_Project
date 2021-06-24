//package com.myspring.salesmanage.order.reg.service;
//
//import java.util.List;
//
//import org.springframework.dao.DataAccessException;
//
//import com.myspring.salesmanage.order.vo.OrderVO;
//
//public interface OrderRegService {
//
//	
//	//salesplan
//	public List listOrder() throws DataAccessException;
//	
//	//cust
//	public List listCusts() throws DataAccessException;
//	public List submitCust(String custCode) throws DataAccessException;
//	
//	//reg-delete
//	public int inputNo() throws DataAccessException;
//	public void removeOrder(String[] noary) throws DataAccessException;
//	
//	//reg-insert
//	public int addOrder(OrderVO orderVO) throws DataAccessException;
//	public List custText(String custCode) throws DataAccessException;
////
////	
////	//item
////	public List listItems() throws DataAccessException;
////	public List submitItem(String item_code) throws DataAccessException;
////	public List itemText(String item_code) throws DataAccessException;
////	public int inputNo() throws DataAccessException;
//////	public int addItem(ItemViewVO itemviewVO) throws DataAccessException;
////////	public int removeItem(String item_Code) throws DataAccessException;
//}
