package com.myspring.invenBasicInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.invenBasicInfo.regItemUnitPrice.dao.IupViewDAO;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.IupVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class IupViewServiceImpl implements IupViewService{
	@Autowired
	private IupViewDAO iupDAO;
	
	@Override
	public List iupView() throws DataAccessException{
		List iupList = null;
		iupList = iupDAO.viewIup();
		return iupList;
	}
	
	@Override
	public List itemView() throws DataAccessException{
		List popList = null;
		popList = iupDAO.viewPop();
		return popList;
	}
	
	@Override
}
