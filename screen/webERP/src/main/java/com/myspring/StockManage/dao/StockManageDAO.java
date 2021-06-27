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

	List finishednameView();

	List<StockManageVO> viewserachPopName2(String itemName);

	List cusView();

	List<StockManageVO> viewserachPopCus(String itemName);

	List<StockManageVO> Searchsuju(String customerCode);

	List<String> selectKeywordSearch(String keyword);

	String searchMenu(String searchWord);

//	List viewType();
//
//	List<StockManageVO> SearchStock(String type) throws DataAccessException;
//
//	List<StockManageVO> SearchStockAll();


}
