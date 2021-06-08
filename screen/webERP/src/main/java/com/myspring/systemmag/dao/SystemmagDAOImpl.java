package com.myspring.systemmag.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVO;

@Repository("systemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException{
		sqlSession.insert("mapper.company.insertNewCompany",systemmagVO);
	}

}
