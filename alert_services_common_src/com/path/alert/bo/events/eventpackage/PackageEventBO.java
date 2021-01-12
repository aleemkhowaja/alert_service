package com.path.alert.bo.events.eventpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.alert.vo.events.eventpackage.EventInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.EventInPackageEventSC;
import com.path.alert.vo.events.eventpackage.EventNotInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventCO;
import com.path.alert.vo.events.eventpackage.PackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventSC;
import com.path.dbmaps.vo.ALRT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.ALRT_NOT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface PackageEventBO
{
    /**
     * get the count of the initial search grid
     */
    Integer pkgEventCount(PackageEventSC pkgEvtSC) throws BaseException;

    /**
     * get the list of the initial search grid
     */
    List<PackageEventListCO> pkgEventList(PackageEventSC pkgEvtSC) throws BaseException;
    
    /**
     * get the object of the initial search grid
     */
    PackageEventListCO pkgEventListById(PackageEventSC pkgEvtSC) throws BaseException;

    /**
     * get the count of the event not in package grid
     */
    Integer evtNotInPackageCount(EventInPackageEventSC evtNotInPkgSC) throws BaseException;

    /**
     * get the list of the event not in package grid
     */
    List<EventNotInPackageEventListCO> evtNotInPackageList(EventInPackageEventSC evtNotInPkgSC) throws BaseException;

    /**
     * get the count of the event in package grid
     */
    Integer evtInPackageCount(EventInPackageEventSC evtInPkgSC) throws BaseException;

    /**
     * get the list of the event not in package grid
     */
    List<EventInPackageEventListCO> evtInPackageList(EventInPackageEventSC evtInPkgSC) throws BaseException;

    /**
     * get the package details by package Id for the double click on the initial
     * search grid
     */
    PackageEventCO returnPackageById(PackageEventSC pkgEvtSC) throws BaseException;

    /**
     * apply visibility on the delete screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(PackageEventCO packageEventCO)
	    throws BaseException;

    /**
     * apply visibility on the approve screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeApproveVisibilities(
	    PackageEventCO packageEventCO) throws BaseException;

    /**
     * apply visibility on the maintenance screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeMaintVisibilities(
	    PackageEventCO packageEventCO, String iv_crud) throws BaseException;

    /**
     * get status by package id
     */
    String getStatusByPackage(PackageEventSC pkgEvtSC) throws BaseException;

    /**
     * save the new package or add new event to an existing package if the
     * status of the record is new
     */
    void saveRecord(ArrayList<EventNotInPackageEventListCO> evtNotInPkgList,
	    ArrayList<EventInPackageEventListCO> evtInPkgList, PackageEventCO packageEventCO) throws BaseException;

    /**
     * check if there subscription related to events in this package before
     * proceed in the delete process
     */
    PackageEventCO checkSubscription(PackageEventCO packageEventCO) throws BaseException;

    /**
     * delete package only from maintenance screen having for status new
     */
    void deleteRecord(PackageEventCO packageEventCO) throws BaseException;
    
    /**
     * approve the package only if the status is new
     */
    void approveRecord(PackageEventCO packageEventCO) throws BaseException;
    
    /**
     * 
     * insert into alert in package TMP table
     */
    void insertAlrtInPkgTmp(PackageEventCO packageEventCO) throws BaseException;
    
    /**
     * 
     * insert into alert not in package TMP table
     */
    void insertAlrtNotInPkgTmp(PackageEventCO packageEventCO) throws BaseException;
    
    /**
     * 
     * delete alert in package tmp table
     */
    void deleteAlrtInPkgTmp() throws BaseException;
    
    /**
     * 
     * delete alert not in package tmp table
     */
    void deleteAlrtNotInPkgTmp() throws BaseException;
    
    /**
     * 
     * delete alert in package tmp table by id
     */
    void deleteAlrtInPkgTmpById(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws BaseException;
    
    /**
     * 
     * delete alert not in package tmp table by id
     */
    void deleteAlrtNotInPkgTmpById(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws BaseException;
    
}
