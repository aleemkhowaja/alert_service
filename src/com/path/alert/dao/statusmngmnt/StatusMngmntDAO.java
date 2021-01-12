package com.path.alert.dao.statusmngmnt;

import java.util.List;

import com.path.alert.vo.statusmngmnt.StatusMngmntCO;
import com.path.alert.vo.statusmngmnt.StatusMngmntSC;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntDAO.java used to
 */
public interface StatusMngmntDAO
{
    public int returnStatusMngmntListCount(StatusMngmntSC criteria) throws DAOException;

    public List returnStatusMngmntList(StatusMngmntSC criteria) throws DAOException;

    public StatusMngmntCO processSuspend(StatusMngmntSC criteria) throws DAOException;

    public StatusMngmntCO retriveData(StatusMngmntSC criteria) throws DAOException;

    public StatusMngmntCO alertevtmethod(StatusMngmntCO stmgmtCO) throws DAOException;

    public StatusMngmntCO alertCentralizedMethod(StatusMngmntCO stmgmtCO) throws DAOException;

    public StatusMngmntCO subscriberDetails(StatusMngmntCO stmgmtCO) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public int returnSubscriberPackageListCount(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public List returnSubscriberPackageList(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnGroupPackageListCount(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public List returnGroupPackageList(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public List returnSubscriberEventList(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnsubScriberEventCount(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public Integer returnGroupEventListCount(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param criteria
     * @return
     */
    public List returnGroupEventList(StatusMngmntSC criteria) throws DAOException;

    /**
     * @param stmgmtco
     */
    public StatusMngmntCO updateAlrtSubEvtStatus(StatusMngmntCO stmgmtco) throws DAOException;
}