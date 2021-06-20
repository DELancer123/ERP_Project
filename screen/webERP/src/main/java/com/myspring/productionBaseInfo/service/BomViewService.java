package com.myspring.productionBaseInfo.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.productionBaseInfo.BOM.vo.RegOutSourcingPriceVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;

public interface BomViewService {
	public List bomView() throws DataAccessException;
	public List itemView1() throws DataAccessException;
	public List itemView2() throws DataAccessException;
	public List setText(String itemNumber)throws DataAccessException;
	public List SearchView(String itemNumber) throws DataAccessException;
	public List itemSet() throws DataAccessException;
	public int addBOM(bomVO bomVO) throws DataAccessException;
	public void delBOM(String[] noary) throws DataAccessException;
	public int updateBOM(bomVO bomVO) throws DataAccessException;
	public int inputNo() throws DataAccessException;
	public List ChildView(String itemNumber,String childCode) throws DataAccessException;
	public List SearchOutView() throws DataAccessException;
	public List SearchOutView1(String itemNumber) throws DataAccessException;
	public List getoutprice(String itemNumber, String placeCode) throws DataAccessException;
	public int addoutprice(RegOutSourcingPriceVO outVO) throws DataAccessException;
	public List inputText(String itemCode)throws DataAccessException;
	public int updoutprice(RegOutSourcingPriceVO outVO) throws DataAccessException;
	public int deloutprice(RegOutSourcingPriceVO outVO) throws DataAccessException;
}
