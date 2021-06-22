package com.myspring.businessStatus.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.businessStatus.releaseStatus.vo.*;

public interface RsViewService {
	public List rsView() throws DataAccessException;
	public List setText(String dueDate) throws DataAccessException;
	public List searchView(String dueDate) throws DataAccessException;
}
