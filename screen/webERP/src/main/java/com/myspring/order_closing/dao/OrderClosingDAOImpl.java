package com.myspring.order_closing.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.order_closing.vo.OrderClosingVO;

@Repository("orderclosingDAO")
public class OrderClosingDAOImpl implements OrderClosingDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllClosingList() throws Exception{
		List<OrderClosingVO>ClosingList = sqlSession.selectList("mappers.erp.selectAllClosingList");
		return ClosingList;
	}
	
	@Override
	public int updateOrderClosing(OrderClosingVO vo) throws DataAccessException {
		int result = 0; 

		int idx = vo.getListVO().size()-1;
		for(int i = 0; i<idx;i++) {
			System.out.println("i"+i);
		System.out.println("idx : "+idx);
		result = sqlSession.update("mappers.erp.updateOrderClosing",vo.getListVO().get(i));
		}
		return result;
	}
}
