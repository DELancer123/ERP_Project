package com.myspring.Login.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface LoginService {

	List depView() throws DataAccessException;

	List empView(String depCode) throws DataAccessException;

}
