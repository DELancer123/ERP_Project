package com.myspring.productionBaseInfo.regDefectiveType.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.productionBaseInfo.regDefectiveType.vo.DefectiveTypeVO;

public interface DefectiveTypeDAO {

	List viewDefective() throws DataAccessException;

	int addoutprice(DefectiveTypeVO defVO) throws DataAccessException;

	int updDefType(DefectiveTypeVO defVO) throws DataAccessException;

	List viewGroupList() throws DataAccessException;


}
