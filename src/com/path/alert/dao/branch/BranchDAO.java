package com.path.alert.dao.branch;

import java.util.List;

import com.path.alert.vo.branch.BranchCO;
import com.path.alert.vo.branch.BranchSC;
import com.path.lib.common.exception.DAOException;

public interface BranchDAO
{
    /**
     * Return Branch List
     * 
     * @param branchSC
     * @return
     * @throws DAOException
     */
    public List returnBranchByCompCodeList(BranchSC branchSC) throws DAOException;

    /**
     * return Branch List Count
     * 
     * @param branchSC
     * @return
     * @throws DAOException
     */
    public int returnBranchByCompCodeCount(BranchSC branchSC) throws DAOException;
    
    /**
     * return Branch Details
     * @param branchSC
     * @return
     */
    public BranchCO returnBranchDetails(BranchSC branchSC)throws DAOException;
}
