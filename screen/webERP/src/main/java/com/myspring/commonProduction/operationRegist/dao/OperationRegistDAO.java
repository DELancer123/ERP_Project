package com.myspring.commonProduction.operationRegist.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OperationRegistDAO {
	public List selectAllOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException;
	public List viewPop() throws DataAccessException;
	public List departmentViewPop() throws DataAccessException;
	public List productionPlanPop(String startDate, String endDate) throws DataAccessException, ParseException;
}
