package com.myspring.StockManage.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.StockManage.dao.StockManageDAO;
import com.myspring.StockManage.vo.StockManageVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;

public interface StockManageService {
	public static final StockManageDAO stockManageDAO = null;

	List<StockManageVO> SearchStockAll();

	List<StockManageVO> SearchfinishedStockAll();

	List<StockManageVO> SearchStock(String type);

	List<StockManageVO> SearchfinishedStock(String type);

	List nameView();

	List<StockManageVO> searchPopName(String itemName);







}