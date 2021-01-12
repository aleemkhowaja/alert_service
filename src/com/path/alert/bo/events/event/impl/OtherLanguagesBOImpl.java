package com.path.alert.bo.events.event.impl;

import java.util.List;

import com.path.alert.bo.events.event.OtherLanguagesBO;
import com.path.alert.dao.events.event.OtherLanguagesDAO;
import com.path.alert.vo.events.event.OtherLanguagesCO;
import com.path.alert.vo.events.event.OtherLanguagesSC;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: suhail.shoukathali
 *
 *          CommonLanguagesBOImpl.java used to
 */
public class OtherLanguagesBOImpl extends BaseBO implements OtherLanguagesBO
{
    public OtherLanguagesDAO otherLanguagesDAO;

    @Override
    public int returnOtherLanguagesListCount(OtherLanguagesSC otherLanguagesSC) throws BaseException
    {
    	return otherLanguagesDAO.returnOtherLanguagesListCount(otherLanguagesSC);
    }

    @Override
    public List<OtherLanguagesCO> returnOtherLanguagesListRec(OtherLanguagesSC otherLanguagesSC) throws BaseException
    {
	return otherLanguagesDAO.returnOtherLanguagesListRec(otherLanguagesSC);
    }
    
    @Override
    public JSONArray returnOtherLanguagesJson(OtherLanguagesSC otherLanguagesSC) throws BaseException
    {
	List<OtherLanguagesCO> lst = otherLanguagesDAO.returnOtherLanguagesListRec(otherLanguagesSC);
	JSONArray jsArray = new JSONArray();
	JSONObject jsObject;
	for(OtherLanguagesCO otherLanguagesCO : lst)
	{
	    if(!otherLanguagesCO.getOtherLanguagesVO().getLANG_CODE().equals(otherLanguagesSC.getExcludeLang()))
	    {
		jsObject = new JSONObject();
		jsObject.put("otherLanguagesVO.LANG_CODE", otherLanguagesCO.getOtherLanguagesVO().getLANG_CODE());
		//jsObject.put("otherLanguagesVO.DESCRIPTION", otherLanguagesCO.getOtherLanguagesVO().getDESCRIPTION());
		jsObject.put("isDeleted", "");
		jsObject.put("langDesc", otherLanguagesCO.getLangDesc());
		jsArray.add(jsObject);
	    }
	}
	return jsArray; 
    }
    
    public OtherLanguagesDAO getOtherLanguagesDAO()
    {
	return otherLanguagesDAO;
    }

    public void setOtherLanguagesDAO(OtherLanguagesDAO otherLanguagesDAO)
    {
	this.otherLanguagesDAO = otherLanguagesDAO;
    }
}
