package com.path.alert.bo.applications;

import java.util.List;

import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.applications.ApplicationsSC;
import com.path.vo.admin.branches.BranchesSC;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ApplicationBO.java used to
 */
public interface ApplicationsBO {

    /**
     * 
     * Used for returning application List
     * 
     * @param applciationssSC
     * @return
     * @throws BaseException
     */
    public List returnAplicationList(ApplicationsSC applciationssSC) throws BaseException;
    /**
     * 
     * Used for returning Application Count
     * 
     * @param applciationssSC
     * @return
     * @throws BaseException
     */
    public int returnApplicationCount(ApplicationsSC applciationssSC) throws BaseException;
    
    /**
     * 
     * Used for returning application details
     * 
     * @param applciationssSC
     * @return
     * @throws BaseException
     */
    public S_APPVO returnAplicationDetailsByAppId(ApplicationsSC applciationssSC) throws BaseException;
	
}
