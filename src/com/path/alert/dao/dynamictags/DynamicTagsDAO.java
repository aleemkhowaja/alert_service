package com.path.alert.dao.dynamictags;

import com.path.lib.common.exception.DAOException;
import com.path.alert.vo.dynamictags.DynamicTagsSC;
import com.path.alert.vo.dynamictags.DynamicTagsCO;

import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsDAO.java used to
 */
public interface DynamicTagsDAO 
{
	public int returnDynamicTagsListCount(DynamicTagsSC criteria) throws DAOException;
	public List returnDynamicTagsList(DynamicTagsSC criteria) throws DAOException;
	public DynamicTagsCO returnDynamicTagsByID(DynamicTagsSC dynamicTagsSC)throws DAOException;
	public BigDecimal returnMaxTagId()throws DAOException;
}