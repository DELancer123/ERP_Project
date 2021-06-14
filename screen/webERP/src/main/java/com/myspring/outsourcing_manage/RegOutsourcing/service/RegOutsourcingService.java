package com.myspring.outsourcing_manage.RegOutsourcing.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.myspring.outsourcing_manage.RegOutsourcing.vo.RegOutsourcingVO;

public interface RegOutsourcingService {
	 public List listOutsourcing() throws DataAccessException;
	 public int addOutsourcing(RegOutsourcingVO regOutsourcingVO) throws DataAccessException;
	 public void removeOutsourcing(String[] noary) throws DataAccessException;
	 public int updateOutsourcing(RegOutsourcingVO regOutsourcingVO) throws DataAccessException;
	public List productionPlanView(String startDate, String endDate) throws ParseException;
}
