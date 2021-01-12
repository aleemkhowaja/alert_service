package com.path.alert.bo.statusmngmnt;

import java.util.List;

import com.path.alert.vo.statusmngmnt.StatusMngmntCO;
import com.path.alert.vo.statusmngmnt.StatusMngmntSC;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntBO.java used to
 */
public interface StatusMngmntBO
{
    public int returnStatusMngmntListCount(StatusMngmntSC criteria) throws BaseException;

    public List returnStatusMngmntList(StatusMngmntSC criteria) throws BaseException;

    public StatusMngmntCO processSuspend(StatusMngmntCO stmgmtco) throws BaseException;

    public StatusMngmntCO processApprove(StatusMngmntCO stmgmtco) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public int returnSubscriberPackageListCount(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public List returnSubscriberPackageList(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnGroupPackageListCount(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public List returnGroupPackageList(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param stmgmtco
     * @return
     */
    public StatusMngmntCO loadStatusMngmntPage(StatusMngmntCO stmgmtco) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnsubScriberEventCount(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public List returnSubscriberEventList(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnGroupEventListCount(StatusMngmntSC criteria) throws BaseException;

    /**
     * @param criteria
     * @return
     */
    public List returnGroupEventList(StatusMngmntSC criteria) throws BaseException;

}