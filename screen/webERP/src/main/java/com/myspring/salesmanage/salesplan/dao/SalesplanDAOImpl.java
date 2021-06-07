package com.myspring.salesmanage.salesplan.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

@Repository("salesplanDAO")
public class SalesplanDAOImpl implements SalesplanDAO{

		@Autowired
		private SqlSession sqlSession;


		@Override
		public List selectAllSalesplanList() throws DataAccessException {
			List<SalesplanVO> salesplansList = null;
			salesplansList = sqlSession.selectList("mappers.erp.selectAllSalesplanList");
			//mapper.salesplan
			return salesplansList;
		}

		@Override
		public int insertSalesplan(SalesplanVO salesplanVO) throws DataAccessException {
			int result = sqlSession.insert("mappers.erp.insertSalesplan", salesplanVO);
			return result;
		}

		@Override
		public int updateNewSalesplan(String Item_Code) throws DataAccessException {
			int result = sqlSession.update("mappers.erp.updateNewSalesplan", Item_Code);
			return result;
		}

		@Override
		public int deleteSalesplan(String Item_Code) throws DataAccessException {
			int result = sqlSession.delete("mappers.erp.deleteSalesplan", Item_Code);
			return result;
		}

		@Override
		public SalesplanVO searchByItemCode(String Item_Code) throws DataAccessException {
			SalesplanVO vo = sqlSession.selectOne("mapper.erp.searchByItemCode",Item_Code);
			return vo;
		}

		@Override
		public SalesplanVO searchByItemName(String Item_Name) throws DataAccessException {
			SalesplanVO vo = sqlSession.selectOne("mapper.erp.searchByItemName",Item_Name);
			return vo;
		}

		@Override
		public SalesplanVO searchByPlanDate(Date Plan_Date) throws DataAccessException {
			SalesplanVO vo = sqlSession.selectOne("mappers.erp.searchByPlanDate",Plan_Date);
			return vo;
		}

		@Override
		public SalesplanVO searchByItemGroup(String Item_Group_Code) throws DataAccessException {
			SalesplanVO vo = sqlSession.selectOne("mappers.erp.searchByPlanGroup",Item_Group_Code);
			return vo;
		}

}


