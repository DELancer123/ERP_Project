package com.myspring.businessStatus.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.businessStatus.releaseStatus.vo.*;

public interface RsViewService {
	public List rsView() throws DataAccessException;
//	public List setText(String startDate, String endDate) throws DataAccessException,ParseException;
	public List searchView(String startDate, String endDate) throws DataAccessException,ParseException;
}
