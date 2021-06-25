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
	public List selectAllCustList() throws DataAccessException {
		List<OrderVO> orderCustList = null;
		orderCustList = sqlSession.selectList("mappers.erp.orderCustList");
		return orderCustList;
	}
	
	//////////////////status
	@Override
	public List selectOrderCorList() throws DataAccessException {
		List<OrderVO> orderList = null;
		orderList = sqlSession.selectList("mappers.erp.StaOrderList");
		return orderList;
	}

	@Override
	public List submitOrdCust(String custCode) throws DataAccessException {
		List<OrderVO> submitOrderCust = null;
		submitOrderCust = sqlSession.selectList("mappers.erp.submitOrderSta", custCode);
		return submitOrderCust;
	}

	//////////////////////registration
	@Override
	public List RegOrderList() throws DataAccessException {
		List<OrderVO> orderList = null;
		orderList = sqlSession.selectList("mappers.erp.RegOrderList");
		return orderList;
	}



	@Override
	public List submitOrderCust(String custCode) throws DataAccessException {
		List<OrderVO> submitOrderCust = null;
		submitOrderCust = sqlSession.selectList("mappers.erp.staOrderCust", custCode);
		return submitOrderCust;
	}


	
//	@Override
//	public void delOrder(String[] noary) throws DataAccessException {
//		for(String obj: noary) {
//			sqlSession.delete("mappers.erp.delOrd",obj);
//		}
//	}
//		
//	@Override
//	public int selOrdCode() throws DataAccessException {	
//		return sqlSession.selectOne("mappers.erp.selOrderCode");
//	}
//
//	@Override
//	public int addOrder(OrderVO orderVO) throws DataAccessException {
//		int idx = orderVO.getListOrd().size()+1;
//		int result = sqlSession.insert("mappers.erp.insertOrder",orderVO.getListOrd().get(idx));
//		return result;
//	}
//	
//	@Override
//	public List selectLine(String custCode) throws DataAccessException {
//		List<OrderVO> textList = null;
//		textList = sqlSession.selectList("mappers.erp.selectLine", custCode);
//		return textList;
//	}
//
////	@Override
////	public int updNewOrder(String custCode) throws DataAccessException {
////		// TODO Auto-generated method stub
////		return 0;
////	}

}
