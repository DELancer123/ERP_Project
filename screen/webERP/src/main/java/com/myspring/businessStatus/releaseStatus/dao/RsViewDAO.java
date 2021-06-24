package com.myspring.businessStatus.releaseStatus.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.businessStatus.releaseStatus.vo.*;

public interface RsViewDAO {
	public List viewRs() throws DataAccessException;
	public List setText(String dueDate) throws DataAccessException;
	public List searchView(String dueDate) throws DataAccessException;
}
