package com.myspring.businessStatus.releaseStatus.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.businessStatus.releaseStatus.vo.*;

@Repository("rsViewDAO")
public class RsViewDAOImpl implements RsViewDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List viewRs() throws DataAccessException {
		List<rsVO> rsList = null;
		rsList = sqlSession.selectList("mappers.erp.rsSelectAllMemberList");
		return rsList;
	}
	
	@Override
	public List setText(String dueDate) throws DataAccessException{
		List<rsVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.rsSelectItem",dueDate);
		return textList;
	}
	
	@Override
	public List searchView(String dueDate) throws DataAccessException{
		List<rsVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.rsSearchItem",dueDate);
		return searchList;
	}
}
