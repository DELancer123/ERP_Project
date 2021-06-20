package com.myspring.productionBaseInfo.regDefectiveType.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface DefectiveTypeDAO {

	List viewDefective() throws DataAccessException;

}
