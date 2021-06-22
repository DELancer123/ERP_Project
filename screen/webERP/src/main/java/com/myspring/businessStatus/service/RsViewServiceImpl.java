package com.myspring.businessStatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.businessStatus.releaseStatus.dao.*;
import com.myspring.businessStatus.releaseStatus.vo.*;

import org.springframework.transaction.annotation.Propagation;

@Service("iupMemberService")
@Transactional(propagation = Propagation.REQUIRED)
public class RsViewServiceImpl implements RsViewService{
	@Autowired
	private RsViewDAO rsDAO;
	
	@Override
	public List rsView() throws DataAccessException{
		List rsList = null;
		rsList = rsDAO.viewRs();
		return rsList;
	}
	
	@Override
	public List setText(String dueDate) throws DataAccessException{
		List searchList = null;
		searchList = rsDAO.setText(dueDate);
		return searchList;
	}
	
	@Override
	public List searchView(String dueDate) throws DataAccessException{
		List searchList = null;
		searchList = rsDAO.searchView(dueDate);
		return searchList;
	}
}
