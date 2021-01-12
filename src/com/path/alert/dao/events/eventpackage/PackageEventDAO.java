package com.path.alert.dao.events.eventpackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.alert.vo.events.eventpackage.EventInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.EventInPackageEventSC;
import com.path.alert.vo.events.eventpackage.EventNotInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventCO;
import com.path.alert.vo.events.eventpackage.PackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventSC;
import com.path.alert.vo.subscriber.groups.GroupPackageCO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.ALRT_NOT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.lib.common.exception.DAOException;

public interface PackageEventDAO
{
    /**
     * get the count of the initial search grid
     */
    Integer pkgEventCount(PackageEventSC pkgEvtSC) throws DAOException;

    /**
     * get the list of the initial search grid
     */
    List<PackageEventListCO> pkgEventList(PackageEventSC pkgEvtSC) throws DAOException;
    /**
     * get the object of the initial search grid
     */
    PackageEventListCO pkgEventListById(PackageEventSC pkgEvtSC) throws DAOException;

    /**
     * get the count of the event not in package grid
     */
    Integer evtNotInPackageCount(EventInPackageEventSC evtNotInPkgSC) throws DAOException;

    /**
     * get the list of the event not in package grid
     */
    List<EventNotInPackageEventListCO> evtNotInPackageList(EventInPackageEventSC evtNotInPkgSC) throws DAOException;

    /**
     * get the count of the event in package grid
     */
    Integer evtInPackageCount(EventInPackageEventSC evtInPkgSC) throws DAOException;

    /**
     * get the list of the event in package grid
     */
    List<EventInPackageEventListCO> evtInPackageList(EventInPackageEventSC evtInPkgSC) throws DAOException;

    /**
     * get the details of the selected package to be populated on the screen
     * upon double click
     */
    PackageEventCO returnPackageById(PackageEventSC pkgEvtSC) throws DAOException;

    /**
     * get the status by package id
     */
    String getStatusByPackage(PackageEventSC pkgEvtSC) throws DAOException;

    /**
     * 
     * delete alert subscriber param ALRT_SUB_PKG
     */
    void deleteAlrtSubscParam(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * delete alert subscriber event ALRT_GRP_PKG
     */
    void deleteAlrtSubEvt(PackageEventCO packageEventCO) throws DAOException;
    
    /**
     * 
     * delete alert subscriber param ALRT_SUB_PKG
     */
    void deleteAlrtSubscParam2(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * delete alert subscriber event ALRT_GRP_PKG
     */
    void deleteAlrtSubEvt2(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * delete alert event package
     */
    void deleteAlrtEvtPk(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * return line group package
     */
    ALRT_GRP_PKGVO returnLineGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

    /**
     * 
     * return event paramset by id
     */
    BigDecimal returnEventParamsetById(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * return group package by package id
     */
    List<GroupPackageCO> returnGroupPkgByPkgId(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * return subscriber package by package id
     */
    List<ALRT_SUB_PKGVO> returnSubPkgByPkgId(PackageEventCO packageEventCO) throws DAOException;

    /**
     * 
     * return subscriber  by group id
     */
    List<ALRT_SUB_GRPVOKey> returnSubByGrpId(GroupPackageCO groupPackageCO) throws DAOException;

    /**
     * 
     * insert alert event paramset
     */
    void insertAlrtEvtParamset(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;
    
    /**
     * 
     * return group package count
     */
    BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;
    
    /**
     * 
     * return subscriber package count
     */
    BigDecimal returnSubPkgCount(ALRT_SUB_PKGVO alrtSubPkgVO) throws DAOException;
    
    /**
     * 
     * delete subscription param
     */
    void deleteSbtParam(GroupPackageCO groupPackageCO) throws DAOException;
    
    /**
     * 
     * update subscriber event
     */
    void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;
    
    /**
     * 
     * update group package
     */
    void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;
    
    /**
     * 
     * update subscriber package
     */
    void updateSubPkg(ALRT_SUB_PKGVO alrtSubPkgVO) throws DAOException;
    
    /**
     * 
     * update alert subscriber event
     */
    void updateAlrtSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;
    
    /**
     * 
     * update alert subscriber event
     */
    void updateAlrtSubEvt1(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;
    
    /**
     * 
     * insert into alert in package TMP table
     */
    void insertAlrtInPkgTmp(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws DAOException;
    
    /**
     * 
     * insert into alert not in package TMP table
     */
    void insertAlrtNotInPkgTmp(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws DAOException;
    
    /**
     * 
     * delete alert in package tmp table
     */
    void deleteAlrtInPkgTmp() throws DAOException;
    
    /**
     * 
     * delete alert not in package tmp table
     */
    void deleteAlrtNotInPkgTmp() throws DAOException;
    
    /**
     * 
     * delete alert in package tmp table by id
     */
    void deleteAlrtInPkgTmpById(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws DAOException;
    
    /**
     * 
     * delete alert not in package tmp table by id
     */
    void deleteAlrtNotInPkgTmpById(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws DAOException;
    
    /**
     * get all new events to be added to the physical table
     * @throws DAOException
     */
    ArrayList<ALRT_IN_PKG_TMPVO> getAlrtInPkgTmp (PackageEventCO packageEventCO) throws DAOException;
    
    /**
     * get all new events to be remove from the physical table
     * @throws DAOException
     */
    ArrayList<ALRT_NOT_IN_PKG_TMPVO> getAlrtNotInPkgTmp (PackageEventCO packageEventCO) throws DAOException;
    
    /**
     * get all events related to a package
     * @throws DAOException
     */
    ArrayList<BigDecimal> getAlrtInPkg (PackageEventCO packageEventCO) throws DAOException;
   
    /**
     * method to Insert/Delete Subscriptions of the Package
     * @param PackageEventCO
     * @return
     * @throws DAOException
     */
    public Integer updateSubscriptionsByPackageId(PackageEventCO packageEventCO) throws DAOException;
}
