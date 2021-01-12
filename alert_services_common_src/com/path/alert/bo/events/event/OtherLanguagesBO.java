package com.path.alert.bo.events.event;

import java.util.List;

import com.path.alert.vo.events.event.OtherLanguagesCO;
import com.path.alert.vo.events.event.OtherLanguagesSC;
import com.path.lib.common.exception.BaseException;

import net.sf.json.JSONArray;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: suhail.shoukathali
 *
 * CommonLanguagesBO.java used to
 */
public interface OtherLanguagesBO
{
    /**
     * Fetch count of records in table
     * @param otherLanguagesSC
     * @return int
     * @throws BaseException
     */
    public int returnOtherLanguagesListCount(OtherLanguagesSC otherLanguagesSC) throws BaseException;
    
    /**
     * Fetch other languages list
     * @param otherLanguagesSC
     * @return List
     * @throws BaseException
     */
    public JSONArray returnOtherLanguagesJson(OtherLanguagesSC otherLanguagesSC) throws BaseException;
    
    /**
     * Fetch other languages list
     * @param otherLanguagesSC
     * @return List
     * @throws BaseException
     */
    public List<OtherLanguagesCO> returnOtherLanguagesListRec(OtherLanguagesSC otherLanguagesSC) throws BaseException;
    
}
