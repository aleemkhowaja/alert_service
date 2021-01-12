package com.path.alert.bo.dynamictags.impl;

import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.dynamictags.DynamicTagsBO;
import com.path.alert.dao.dynamictags.DynamicTagsDAO;
import com.path.alert.vo.dynamictags.DynamicTagsSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.alert.vo.dynamictags.DynamicTagsCO;

import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsBOImpl.java used to
 */
public class DynamicTagsBOImpl extends BaseBO implements DynamicTagsBO
{
	DynamicTagsDAO dynamicTagsDAO;
	
	
	/*Getter and Setter for dynamicTagsDAO  */
	public DynamicTagsDAO getDynamicTagsDAO()
	{
		return dynamicTagsDAO;
	}
	public void setDynamicTagsDAO(DynamicTagsDAO dynamicTagsDAO)
	{
		this.dynamicTagsDAO = dynamicTagsDAO;
	}
	
	
	@Override
	public int returnDynamicTagsListCount(DynamicTagsSC criteria) throws BaseException
	{
		return dynamicTagsDAO.returnDynamicTagsListCount(criteria);
	}
	
	
	@Override
	public List returnDynamicTagsList(DynamicTagsSC criteria) throws BaseException
	{
		return dynamicTagsDAO.returnDynamicTagsList(criteria);
	}
	
	

	@Override
	public DynamicTagsCO returnDynamicTagsByID(DynamicTagsSC dynamicTagsSC) throws BaseException {
		return dynamicTagsDAO.returnDynamicTagsByID(dynamicTagsSC);
	}
	
	
	@Override
	public void deleteDynamicTag (DynamicTagsCO dynamicTagsCO) throws BaseException {
		genericDAO.delete(dynamicTagsCO.getAlrtTagsVO());
	}
	
	
	@Override
	public void saveDynamicTags(DynamicTagsCO dynamicTagsCO) throws BaseException {
		
		//Insert - new record
		if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals( dynamicTagsCO.getAlrtTagsVO().getTAG_ID()))
		{
			//set tagId
			BigDecimal tagId =  dynamicTagsDAO.returnMaxTagId();
			dynamicTagsCO.getAlrtTagsVO().setTAG_ID(tagId);
			dynamicTagsCO.getAlrtTagsVO().setDYNAMIC_TYPE_YN(AlertConstant.TYPE_Y);
			
			if(NumberUtil.isEmptyDecimal(dynamicTagsCO.getAlrtTagsVO().getFIXED_EVT_ID()) ||  dynamicTagsCO.getAlrtTagsVO().getTAG_TYPE()== AlertConstant.TYPE_C) {
				dynamicTagsCO.getAlrtTagsVO().setFIXED_EVT_ID(BigDecimal.ZERO);
			}
			genericDAO.insert(dynamicTagsCO.getAlrtTagsVO());
		}
		//Update an existing record
		else
		{
			if (dynamicTagsCO.getAlrtTagsVO().getTAG_TYPE().equals(AlertConstant.TYPE_C)) {
				dynamicTagsCO.getAlrtTagsVO().setFIXED_EVT_ID(BigDecimal.ZERO);
			}
			
			Integer row=genericDAO.update(dynamicTagsCO.getAlrtTagsVO());
			if (row == null || row < 1)
			 {
			     throw new BOException(MessageCodes.RECORD_CHANGED);
			 }
			
		}
		
	}
}
