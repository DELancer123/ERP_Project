package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;

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
	public List itemView() throws DataAccessException;
	public List comitem(String item_code) throws DataAccessException;
	//ǰ�񱺵��
	public List itemgView() throws DataAccessException;
	//�����ȸ
	public List employeeView() throws DataAccessException;
	//�μ����
	public List departmentView() throws DataAccessException;
}
