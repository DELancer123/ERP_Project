package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;

public interface SystemmagDAO {
	//회사등록
	public int addCom(SystemmagVO systemmagVO) throws DataAccessException;
	public List viewCom() throws DataAccessException;
	public List allviewCom(String com_code) throws DataAccessException;
	//사업장등록
	public int addWor(WorkplaceVO workplaceVO) throws DataAccessException;
	public List viewWor() throws DataAccessException;
	public List allviewWor(String wor_code) throws DataAccessException;
	//품목등록
	public List viewItem() throws DataAccessException;
	public List allviewItem(String item_code) throws DataAccessException;
	//품목군등록
	public List allviewItemg() throws DataAccessException;
	//사원조회
	public List allviewemployee() throws DataAccessException;
	//부서등록
	public List allviewdepartment() throws DataAccessException;
	public int addDep(DepartmentVO departmentVO) throws DataAccessException;
}
