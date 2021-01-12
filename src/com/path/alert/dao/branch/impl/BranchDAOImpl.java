package com.path.alert.dao.branch.impl;

import java.util.List;

import com.path.alert.dao.branch.BranchDAO;
import com.path.alert.vo.branch.BranchCO;
import com.path.alert.vo.branch.BranchSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * BranchDAOImpl.java used to
 */
public class BranchDAOImpl extends BaseDAO implements BranchDAO
{

    @Override
    public List returnBranchByCompCodeList(BranchSC branchSC) throws DAOException
    {
	DAOHelper.fixGridMaps(branchSC, getSqlMap(), "alertBranchMapper.branchResultMap");

	if(branchSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("alertBranchMapper.returnBranchByCompCodeList", branchSC);
	}
	else
	{
	    return getSqlMap().queryForList("alertBranchMapper.returnBranchByCompCodeList", branchSC, branchSC.getRecToskip(),
		    branchSC.getNbRec());
	}
    }
    
    @Override
    public int returnBranchByCompCodeCount(BranchSC branchSC) throws DAOException
    {
	DAOHelper.fixGridMaps(branchSC, getSqlMap(), "alertBranchMapper.branchResultMap");
	return ((Integer) getSqlMap().queryForObject("alertBranchMapper.returnBranchByCompCodeCount", branchSC)).intValue();
    }



    @Override
    public BranchCO returnBranchDetails(BranchSC branchSC) throws DAOException
    {
	return (BranchCO) getSqlMap().queryForObject("alertBranchMapper.returnBranchDetails", branchSC);
    }
}