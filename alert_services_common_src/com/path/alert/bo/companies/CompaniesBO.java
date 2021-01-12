package com.path.alert.bo.companies;

import java.util.List;

import com.path.dbmaps.vo.COMPANIESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.companies.CompaniesSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * CompaniesBO.java used to
 */
public interface CompaniesBO {

    /**
     * return companies list
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public List returnCompaniesList(CompaniesSC companiesSC) throws BaseException;

    /**
     * return companies count
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public int returnCompaniesCount(CompaniesSC companiesSC) throws BaseException;
    
    /**
     * return companies list by company code
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public COMPANIESVO returnCompanyDetails(CompaniesSC companiesSC) throws BaseException;
	
}
