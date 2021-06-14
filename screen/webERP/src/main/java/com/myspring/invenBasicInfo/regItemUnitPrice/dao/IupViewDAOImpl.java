package com.myspring.invenBasicInfo.regItemUnitPrice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.IupVO;

@Repository("IupViewDAO")
public class IupViewDAOImpl implements IupViewDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List viewIup() throws DataAccessException{
		List<IupVO> iupList = null;
		iupList = sqlSession.selectList("mappers.erp.selectAllMemberList");
		return iupList;
	}
	
	@Override
	public List viewPop() throws DataAccessException{
		List<IupVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopList");
		return popList;
	}
	
	@Override
	public List setText(String Item_Code) throws DataAccessException{
		List<IupVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.searchitem",Item_Code);
		return textList;
	}
	
	@Override
	public List searchView(String Item_Code) throws DataAccessException{
		List<IupVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.searchitem",Item_Code);
		return searchList;
	}
	
	@Override
	public int addIup(IupVO iupVO) throws DataAccessException{
		int idx = iupVO.getListVO().size()-1;
		int result = sqlSession.insert("mappers.erp.insertIup",iupVO.getListVO().get(idx));
		return 0;
	}
	
	@Override
	public void delIup(String[] noary) throws DataAccessException{
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteIup",Integer.parseInt(obj));
			System.out.println("DAO.delIup");
		}
	}
	
	@Override
	public int updateIup(IupVO iupVO) throws DataAccessException{
		int result = 0;
		int idx = iupVO.getListVO().size()-1;
		for(int i=0; i<idx; i++) {
			System.out.println("i"+i);
			System.out.println("idx"+idx);
			result = sqlSession.update("mappers.erp.updateIup",iupVO.getListVO().get(i));
			System.out.println("DAOresult:"+result);
		}
		return result;
	}
	
	@Override
	public int selNo() throws DataAccessException{
		return sqlSession.selectOne("mappers.erp.selectNo");
	}
}
