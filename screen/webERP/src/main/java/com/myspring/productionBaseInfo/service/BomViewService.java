package com.myspring.productionBaseInfo.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BomViewService {
	public List bomView() throws DataAccessException;
	public List itemView() throws DataAccessException;
}
