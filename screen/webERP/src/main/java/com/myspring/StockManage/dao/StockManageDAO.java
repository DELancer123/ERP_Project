package com.myspring.StockManage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.StockManage.vo.StockManageVO;


public interface StockManageDAO {


	List<StockManageVO> SearchStockAll();

	List<StockManageVO> SearchfinishedStockAll();

	List<StockManageVO> SearchStock(String name) throws DataAccessException;

	List SearchfinishedStock(String type);

	List nameView();

	List<StockManageVO> viewserachPopName(String itemName);

//	List viewType();
//
//	List<StockManageVO> SearchStock(String type) throws DataAccessException;
//
//	List<StockManageVO> SearchStockAll();


}
