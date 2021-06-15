package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

@Repository("SystemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCompany",systemmagVO);
		return result;
	}
	//ȸ���� ��ȸ
	@Override
	public List viewCom() throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectcomList");
		System.out.println("comList: "+comList);
		return comList;
	}
	@Override
	public List allviewCom(String com_code) throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllcomList",com_code);
		System.out.println("comList12: "+com_code);
		return comList;
	}
	
	
	//������� ��ȸ
	@Override
	public List viewWor() throws DataAccessException {
		List<WorkplaceVO> worList = null;
		worList = sqlSession.selectList("mappers.erp.selectworList");
		System.out.println("worList: "+worList);
		return worList;
	}
	@Override
	public List allviewWor(String wor_code) throws DataAccessException {
		List<WorkplaceVO> worList = null;
		worList = sqlSession.selectList("mappers.erp.selectAllworList",wor_code);
		System.out.println("worList12: "+wor_code);
		return worList;
	}
	//ǰ����
	@Override
	public List viewItem() throws DataAccessException {
		List<itemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectitemList");
		System.out.println("worList: "+itemList);
		return itemList;
	}
	@Override
	public List allviewItem(String item_code) throws DataAccessException {
		List<itemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectAllitemList",item_code);
		System.out.println("itemList123: "+item_code);
		return itemList;
	}
}
