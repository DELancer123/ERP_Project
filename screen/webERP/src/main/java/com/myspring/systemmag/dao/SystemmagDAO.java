package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	//ȸ����
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException;
	public List viewCom() throws DataAccessException;
	public List allviewCom(String com_code) throws DataAccessException;
	//�������
	public List viewWor() throws DataAccessException;
	public List allviewWor(String wor_code) throws DataAccessException;
	//ǰ����
	public List viewItem() throws DataAccessException;
	public List allviewItem(String item_code) throws DataAccessException;
	//ǰ�񱺵��
	public List allviewItemg() throws DataAccessException;
	//�����ȸ
	public List allviewemployee() throws DataAccessException;
	//�μ����
	public List allviewdepartment() throws DataAccessException;
}
