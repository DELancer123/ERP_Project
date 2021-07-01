package com.myspring.salesmanage.forward.reg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.forward.reg.dao.ForwardRegDAO;
import com.myspring.salesmanage.forward.vo.ForwardVO;

@Service("forwardRegService")
public class ForwardRegServiceImpl implements ForwardRegService {
	
	@Autowired
	private ForwardRegDAO forwardDAO;
	@Override
	public List listCusts() throws DataAccessException {
		List custList = null;
		custList = forwardDAO.selectAllCustList();
		return custList;
	}

	@Override
	public List listCust() throws DataAccessException {
		List custList = null;
		custList = forwardDAO.selectCustsList();
		return custList;
	}
	
	@Override
	public List listSupForward() throws DataAccessException {
		List supForwardList = null;
		supForwardList = forwardDAO.selectSupForwardList();
		return supForwardList;
	}
	
	@Override
	public List submitCust(String general_Customer_Code) throws DataAccessException {
		List submitCustList = null;
		submitCustList = forwardDAO.submitForwardCustSupReg(general_Customer_Code);
		return submitCustList;
	}
	@Override
	public List submitCustByInsert(String custCode) throws DataAccessException {
		List submitList = null;
		submitList = forwardDAO.submitForwardReg(custCode);
		return submitList;
	}

	@Override
	public int addForward(ForwardVO forwardVO) throws DataAccessException {
		return forwardDAO.addForward(forwardVO);
	}

	@Override
	public int updForward(ForwardVO forwardVO) throws DataAccessException {
		return forwardDAO.updForward(forwardVO);
	}
	
	@Override
	public void removeForward(String[] noary) throws DataAccessException {
		forwardDAO.delSupForward(noary);	
	}
	  
	@Override
	public List<ForwardVO> submitItemInfo(String relCode) throws DataAccessException {
		
		return forwardDAO.submitSubReg(relCode);	
	}//submitSubReg

//	@Override
//	public int addSubItem(ForwardVO forwardVO) throws DataAccessException {
//		return forwardDAO.addItemForward(forwardVO);
//	}

//	@Override
//	public void removeSubItem(String[] noary) throws DataAccessException {
//		forwardDAO.delItemForward(noary);	
//	}

//	@Override
//	public int updSubItem(ForwardVO forwardVO) throws DataAccessException {
//		return forwardDAO.updItemForward(forwardVO);
//	}
} 
