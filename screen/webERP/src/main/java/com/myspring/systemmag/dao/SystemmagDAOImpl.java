package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVO;

@Repository("SystemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCompany",systemmagVO);
		return result;
	}

	@Override
	public List allviewCom() throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllBasicList");
		System.out.println("comList: "+comList);
		return comList;
	}
	
	@Override
	public List viewCom(String com_code) throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectBasicList",com_code);
		System.out.println("comList12: "+com_code);
		return comList;
	}


	@Override
	public void deleteCom(String[] noary) throws DataAccessException {
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteBasicList", Integer.parseInt(obj));	
		}
		
	}

	@Override
	public void updateCom(SystemmagVO systemmagVO) throws DataAccessException {
		sqlSession.update("mappers.erp.updateBasicList", systemmagVO);
	}

	@Override
	public List zipViewCom() throws DataAccessException {
		List zipList = null;
		zipList = sqlSession.selectList("mappers.erp.selectZipList");
		return zipList;
	}

}
