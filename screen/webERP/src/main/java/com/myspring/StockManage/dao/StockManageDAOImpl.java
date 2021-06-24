package com.myspring.StockManage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.myspring.StockManage.vo.StockManageVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;


@Repository("StockManageDAO")
public class StockManageDAOImpl implements StockManageDAO {
	
	@Autowired
	SqlSession sqlSession;
	private Object serachVO;

	@Override
	public List<StockManageVO> SearchStock(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.stockView", name);
		return stockList;
	}

	@Override
	public List<StockManageVO> SearchStockAll() {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.stockViewAll");
		return stockList;
	}

	@Override
	public List<StockManageVO> SearchfinishedStockAll() {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.finishedstockViewAll");
		return stockList;
	}

	@Override
	public List SearchfinishedStock(String name) {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.finishedstockView", name);
		return stockList;
	}

	@Override
	public List nameView() {
		List<StockManageVO> nameList = null;
		nameList = sqlSession.selectList("mappers.erp.selectstockList");
		return nameList;
	}

	@Override
	public List<StockManageVO> viewserachPopName(String itemName) {
		List<StockManageVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopstockList",itemName);
		return popList;
	}



	


}
