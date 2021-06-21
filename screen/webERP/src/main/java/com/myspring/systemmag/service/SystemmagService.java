package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.ItemgVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

public interface SystemmagService {
	//회사등록
	public int addCom(SystemmagVO systemmagVO) throws Exception;
	public List comView() throws DataAccessException;
	public List comcom(String com_code) throws DataAccessException;
	//팝업
	public List zipView(String zipNumber) throws DataAccessException;
	public List zipText(String zipNumber) throws DataAccessException;
	//사업장등록
	public int addWor(WorkplaceVO workplaceVO) throws Exception;
	public List worView() throws DataAccessException;
	public List worcom(String wor_code) throws DataAccessException;
	//품목등록
	public int addItem(itemVO itemVO) throws Exception;
	public List itemView() throws DataAccessException;
	public List comitem(String item_code) throws DataAccessException;
	//품목군등록
	public int addItemg(ItemgVO itemgVO) throws Exception;
	public List itemgView() throws DataAccessException;
	//사원조회
	public List employeeView() throws DataAccessException;
	//부서등록
	public int addDep(DepartmentVO departmentVO) throws Exception;
	public List departmentView() throws DataAccessException;
}
