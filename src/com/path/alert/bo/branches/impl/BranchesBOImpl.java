package com.path.alert.bo.branches.impl;

import java.util.List;

import com.path.alert.bo.branches.BranchesBO;
import com.path.alert.bo.common.AlertUtils;
import com.path.alert.dao.branch.BranchDAO;
import com.path.alert.vo.branch.BranchCO;
import com.path.alert.vo.branch.BranchSC;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * BranchesBOImpl.java used to
 */
public class BranchesBOImpl extends BaseBO implements BranchesBO
{

    private BranchDAO alertBranchDAO;

    @Override
    public List returnBranchesListByCompCode(BranchSC branchSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	branchSC.setConnCO(AlertUtils.returnConnectionCo());
	
	return alertBranchDAO.returnBranchByCompCodeList(branchSC);
    }

    @Override
    public int returnBranchesListCountByCompCode(BranchSC branchSC) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	branchSC.setConnCO(AlertUtils.returnConnectionCo());
	
	return alertBranchDAO.returnBranchByCompCodeCount(branchSC);
    }

    @Override
    public BranchCO returnBranchDetailsByCode(BranchSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());
	
	return alertBranchDAO.returnBranchDetails(criteria);
    }

    /**
     * @param alertBranchDAO the alertBranchDAO to set
     */
    public void setAlertBranchDAO(BranchDAO alertBranchDAO)
    {
        this.alertBranchDAO = alertBranchDAO;
    }
}