package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.ItemgVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

public interface SystemmagService {
	//ȸ����
	public int addCom(SystemmagVO systemmagVO) throws Exception;
	public List comView() throws DataAccessException;
	public List comcom(String com_code) throws DataAccessException;
	//�������
	public int addWor(WorkplaceVO workplaceVO) throws Exception;
	public List worView() throws DataAccessException;
	public List worcom(String wor_code) throws DataAccessException;
	//ǰ����
	public int addItem(itemVO itemVO) throws Exception;
	public List itemView() throws DataAccessException;
	public List comitem(String item_code) throws DataAccessException;
	//ǰ�񱺵��
	public int addItemg(ItemgVO itemgVO) throws Exception;
	public List itemgView() throws DataAccessException;
	//�����ȸ
	public List employeeView() throws DataAccessException;
	//�μ����
	public int addDep(DepartmentVO departmentVO) throws Exception;
	public List departmentView() throws DataAccessException;
}
