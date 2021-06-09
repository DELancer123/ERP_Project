package com.myspring.commonProduction.operationRegist.dao;

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
import com.myspring.commonProduction.operationRegist.vo.FactoryViewVO;
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;



@Repository("OperationRegistDAO")
public class OperationRegistDAOImpl implements OperationRegistDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllOperationInfo() throws DataAccessException {
		List<OperationRegistVO> infoList = null;
		infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistInfo");
		return infoList;
	}
	
	@Override
	public List viewPop() throws DataAccessException {
		List<FactoryViewVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectFactoryList");
		return popList;
	}
	
	@Override
	public List departmentViewPop() throws DataAccessException {
		List<DepartmentViewVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectDepartmentList");
		return popList;
	}
	
	@Override
	public List productionPlanPop(String startDate, String endDate) throws DataAccessException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date(sdf.parse(startDate).getTime());
		Date end = new Date(sdf.parse(endDate).getTime());
		CommitOperationInstructionVO COIvo = new CommitOperationInstructionVO();
		COIvo.setStartDate(start);
		COIvo.setEndDate(end);
		List<CommitOperationInstructionVO> COIList = null;
		COIList = sqlSession.selectList("mappers.erp.selectProductionPlanList", COIvo);
		return COIList;
	}
}
