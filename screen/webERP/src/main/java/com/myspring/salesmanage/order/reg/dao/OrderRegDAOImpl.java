package com.myspring.salesmanage.order.reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.cor.vo.CorVO;
import com.myspring.salesmanage.order.vo.OrderVO;

@Repository("orderRegDAO")
public class OrderRegDAOImpl implements OrderRegDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	List<OrderVO> orderList;
	
	//////////////////////popCust
	@Override
	public List selectAllCustList() throws DataAccessException {
		List<OrderVO> orderCustList = null;
		orderCustList = sqlSession.selectList("mappers.erp.allCustForRegOrder");
		return orderCustList;
	}

	@Override
	public List submitOrdCustSupReg(String custCode) throws DataAccessException {
		List<OrderVO> submitOrderCust = null;
		submitOrderCust = sqlSession.selectList("mappers.erp.submitOrderSupReg", custCode);
		return submitOrderCust;
	}//customer submit by superOrder registration
	
	@Override
	public List selectSupOrderList() throws DataAccessException {
		List<OrderVO> orderSupList = null;
		orderSupList = sqlSession.selectList("mappers.erp.RegOrderSupList");
		return orderSupList;
	}
	
	@Override
	public void delSupOrder(String[] noary) throws DataAccessException {
		for(String ordcode: noary) {
			sqlSession.delete("mappers.erp.delSupOrd",ordcode);
		}
	}

	@Override
	public List submitOrderCorReg(String ordCode) throws DataAccessException {
		List<OrderVO> submitOrderCor = null;
		submitOrderCor = sqlSession.selectList("mappers.erp.submitSubOrdReg", ordCode);
		return submitOrderCor;
	}
	
	@Override
	public List selectSubCorList() throws DataAccessException {
		List<CorVO> subOrderList = null;
		subOrderList = sqlSession.selectList("mappers.erp.orderCorList");
		return subOrderList;
	}



//	@Override
//	public List RegOrderSubList() throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List submitOrdSubReg(String ordCode) throws DataAccessException {
//		List<OrderVO> submitSubOrdList = null;
//		submitSubOrdList = sqlSession.selectList("mappers.erp.submitsubOrder", ordCode);
//		return submitSubOrdList;
//	}//customer submit by subOrder registration


	

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
