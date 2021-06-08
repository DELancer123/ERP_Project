package com.myspring.commonProduction.operationRegist.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OperationRegistDAO {
	public List selectAllOperationInfo() throws DataAccessException;
	public List viewPop() throws DataAccessException;
	public List departmentViewPop() throws DataAccessException;
}
