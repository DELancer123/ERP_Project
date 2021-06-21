package com.myspring.salesmanage.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	List<OrderVO> orderList;

	@Override
	public List selectAllOrderList() throws DataAccessException {
		List<OrderVO> orderList = null;
		orderList = sqlSession.selectList("mappers.erp.selectOrderList");
		return orderList;
	}

	@Override
	public List selectAllCustList() throws DataAccessException {
		List<OrderVO> orderCustList = null;
		orderCustList = sqlSession.selectList("mappers.erp.orderCustList");
		return orderCustList;
	}

	@Override
	public List submitOrderCust(String custCode) throws DataAccessException {
		List<OrderVO> submitOrderCust = null;
		submitOrderCust = sqlSession.selectList("mappers.erp.submitOrderCust", custCode);
		return submitOrderCust;
	}

}
