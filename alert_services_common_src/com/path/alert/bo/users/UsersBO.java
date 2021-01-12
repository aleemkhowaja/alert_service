package com.path.alert.bo.users;

import java.util.List;

import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * UserBO.java used to
 */
public interface UsersBO {

    /**
     * return User list
     * @param usrSC
     * @return
     * @throws BaseException
     */
    public List getUserList(UsrSC usrSC) throws BaseException;

    /**
     * return users count
     * @param usrSC
     * @return
     * @throws BaseException
     */
    public int getUserCount(UsrSC usrSC) throws BaseException;
    
    /**
     * return user details by user id
     * @param usrSC
     * @return
     * @throws BaseException
     */
    public USRVO getUserDetails(UsrSC usrSC) throws BaseException;
	
}
