package com.path.alert.bo.companies.impl;

import java.util.List;

import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.companies.CompaniesBO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.companies.CompaniesSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * CompaniesBOImpl.java used to
 */
public class CompaniesBOImpl extends BaseBO implements CompaniesBO
{

    private com.path.bo.admin.companies.CompaniesBO companiesBO;

    @Override
    public List returnCompaniesList(CompaniesSC companiesSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	companiesSC.setConnCO(AlertUtils.returnConnectionCo());
	
	return companiesBO.getCompaniesList(companiesSC);
    }

    @Override
    public int returnCompaniesCount(CompaniesSC companiesSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	companiesSC.setConnCO(AlertUtils.returnConnectionCo());
	
	return companiesBO.getCompaniesCount(companiesSC);
    }

    @Override
    public COMPANIESVO returnCompanyDetails(CompaniesSC companiesSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	companiesSC.setConnCO(AlertUtils.returnConnectionCo());
	
	COMPANIESVO companiesVO = new COMPANIESVO();
	companiesVO.setCOMP_CODE(companiesSC.getCompCode());
	return companiesBO.getCompaniesDetails(companiesVO);
    }

    /**
     * @param companiesBO the companiesBO to set
     */
    public void setCompaniesBO(com.path.bo.admin.companies.CompaniesBO companiesBO)
    {
        this.companiesBO = companiesBO;
    }
    
}
