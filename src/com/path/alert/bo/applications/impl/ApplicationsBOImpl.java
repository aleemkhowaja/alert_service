package com.path.alert.bo.applications.impl;

import java.util.List;

import com.path.alert.bo.applications.ApplicationsBO;
import com.path.alert.bo.common.AlertUtils;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.applications.ApplicationsSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ApplicationsBOImpl.java used to
 */
public class ApplicationsBOImpl extends BaseBO implements ApplicationsBO
{

    private com.path.bo.admin.applications.ApplicationsBO applicationsBO;
    
    @Override
    public List returnAplicationList(ApplicationsSC applciationssSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	applciationssSC.setConnCO(AlertUtils.returnConnectionCo());
		 
	return applicationsBO.returnAplicationList(applciationssSC);
    }

    @Override
    public int returnApplicationCount(ApplicationsSC applciationssSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	applciationssSC.setConnCO(AlertUtils.returnConnectionCo());
	
	return applicationsBO.returnApplicationCount(applciationssSC);
    }

    @Override
    public S_APPVO returnAplicationDetailsByAppId(ApplicationsSC applciationssSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * @param applicationsBO the applicationsBO to set
     */
    public void setApplicationsBO(com.path.bo.admin.applications.ApplicationsBO applicationsBO)
    {
        this.applicationsBO = applicationsBO;
    }
    
}
