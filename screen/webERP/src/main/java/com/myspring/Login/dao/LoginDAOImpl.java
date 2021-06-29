package com.myspring.Login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
	@Autowired
	private SqlSession sqlSession;
}
