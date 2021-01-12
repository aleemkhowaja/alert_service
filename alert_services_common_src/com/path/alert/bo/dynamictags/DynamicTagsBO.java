package com.path.alert.bo.dynamictags;

import java.util.List;

import com.path.alert.vo.dynamictags.DynamicTagsCO;
import com.path.alert.vo.dynamictags.DynamicTagsSC;
import com.path.lib.common.exception.BaseException;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsBO.java used to
 */
public interface DynamicTagsBO 
{
	/**
	 * Method used to return Count of DynamicTags
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnDynamicTagsListCount(DynamicTagsSC criteria) throws BaseException;
	/**
	 * Method used to return List of  DynamicTags
	 * @param criteria
	 * Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */	
	public List returnDynamicTagsList(DynamicTagsSC criteria) throws BaseException;
	/**
	 * Method used to return DynamicTags Object details
	 * @param criteria
	 * Search dynamicTagsSC Parameter
	 * @return Object Result
	 * @throws BaseException
	 */	
	public DynamicTagsCO returnDynamicTagsByID(DynamicTagsSC dynamicTagsSC) throws BaseException;
	/**
	 * Method used to delete a record
	 * @param CO
	 * @return Object Result
	 * @throws BaseException
	 */
	public void deleteDynamicTag(DynamicTagsCO dynamicTagsCO) throws BaseException;
	/**
	 * Method used to save a record
	 * @param CO
	 * @return Object Result
	 * @throws BaseException
	 */
	public void saveDynamicTags(DynamicTagsCO dynamicTagsCO) throws BaseException;
}