package com.path.alert.bo.users.impl;

import java.util.List;

import com.path.alert.bo.branches.BranchesBO;
import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.users.UsersBO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.admin.user.UsrSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * UsersBOImpl.java used to
 */
public class UsersBOImpl extends BaseBO implements UsersBO
{

    @Override
    public List getUserList(UsrSC usrSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int getUserCount(UsrSC usrSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public USRVO getUserDetails(UsrSC usrSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }
    
    
    
}
