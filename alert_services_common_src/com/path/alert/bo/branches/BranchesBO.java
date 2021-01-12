package com.path.alert.bo.branches;

import java.util.List;

import com.path.alert.vo.branch.BranchCO;
import com.path.alert.vo.branch.BranchSC;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * BranchesBO.java used to
 */
public interface BranchesBO {

    /**
     * return branches list by company code
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public List returnBranchesListByCompCode(BranchSC branchSC) throws BaseException;

    /**
     * return branches count  by company code
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public int returnBranchesListCountByCompCode(BranchSC branchSC) throws BaseException;
    
    /**
     * return branches details by branch code
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public BranchCO returnBranchDetailsByCode(BranchSC criteria) throws BaseException;
	
}
