package com.myspring.salesmanage.order.reg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.order.dao.OrderDAO;
import com.myspring.salesmanage.order.vo.OrderVO;

@Service("orderRegService")
public class OrderRegServiceImpl implements OrderRegService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List listRegOrder() throws DataAccessException {
		List orderList = null;
		orderList = orderDAO.RegOrderSupList();
		return orderList;
	}

	@Override
	public List listCusts() throws DataAccessException {
		List orderCustList = null;
		orderCustList = orderDAO.selectAllCustList();
		return orderCustList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List submitOrderCust = null;
		submitOrderCust = orderDAO.submitOrdCustSupReg(custCode);
		return submitOrderCust;
	}

//	@Override
//	public int inputNo() throws DataAccessException {
//		return orderDAO.selOrdCode();
//	}
//
//	@Override
//	public void removeOrder(String[] noary) throws DataAccessException {
//		orderDAO.delOrder(noary);
//	}
//
//	@Override
//	public int addOrder(OrderVO orderVO) throws DataAccessException {
//		return orderDAO.addOrder(orderVO);
//	}
//	
//	@Override
//	public List custText(String custCode) throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
