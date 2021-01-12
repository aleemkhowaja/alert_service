package com.path.alert.dao.dynamictags.impl;

import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.alert.dao.dynamictags.DynamicTagsDAO;
import com.path.alert.vo.dynamictags.DynamicTagsSC;
import com.path.alert.vo.dynamictags.DynamicTagsCO;
import com.path.lib.common.util.DAOHelper;

import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsDAOImpl.java used to
 */
public class DynamicTagsDAOImpl extends BaseDAO implements DynamicTagsDAO
{
	 /**
	 * Method used to return Count of DynamicTags
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnDynamicTagsListCount(DynamicTagsSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTagsMapper.resDynamicTagsListMap");
		return ((Integer) getSqlMap().queryForObject("dynamicTagsMapper.returnDynamicTagsListCount", criteria)).intValue();
	}
	
	 /**
	 * Method used to return List of DynamicTags
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnDynamicTagsList(DynamicTagsSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTagsMapper.resDynamicTagsListMap");
		
		if(criteria.getSortOrder()==null) //to be compatible with sybase since it does not work with a nested order by
		{
			criteria.setSortOrder("ORDER BY TAG_ID ");
		}
		
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("dynamicTagsMapper.returnDynamicTagsList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("dynamicTagsMapper.returnDynamicTagsList", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	
 	/**
	 * Method used to return details for a specific Tag
	 * @param dynamicTagsSC Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public DynamicTagsCO returnDynamicTagsByID(DynamicTagsSC dynamicTagsSC) throws DAOException {
		 return (DynamicTagsCO)getSqlMap().queryForObject("dynamicTagsMapper.returnDynamicTagsByID", dynamicTagsSC);
	}
	
	/**
	 * Method used to return List of DynamicTags
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public BigDecimal returnMaxTagId() throws DAOException {
		return (BigDecimal) (getSqlMap().queryForObject("dynamicTagsMapper.returnMaxTagId", null));
	}
}
