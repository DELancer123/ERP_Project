package com.myspring.commonProduction.workInProcess.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO;
import com.myspring.commonProduction.operationRegist.vo.DepartmentViewVO;
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;

@Repository("WorkInProcessDAO")
public class WorkInProcessDAOImpl implements WorkInProcessDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List checkStock(String itemCode) throws DataAccessException {
		List<CommitOperationInstructionVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.checkStockView", itemCode);
		return popList;
	}
	
	@Override
	public int minValue(String itemCode) throws DataAccessException {
		List<CommitOperationInstructionVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.checkStockQuantity", itemCode);
		int minValue = popList.get(0).getQuantity();
		return minValue;
	}
}
