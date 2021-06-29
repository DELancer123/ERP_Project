package com.myspring.Login.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface LoginDAO {

	List depView() throws DataAccessException;

	List empView(String depCode) throws DataAccessException;

}
