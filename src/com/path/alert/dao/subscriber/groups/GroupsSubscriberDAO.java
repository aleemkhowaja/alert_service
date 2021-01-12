package com.path.alert.dao.subscriber.groups;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.alert.vo.subscriber.groups.AlrtEvtParamsetListCO;
import com.path.alert.vo.subscriber.groups.GroupPackageCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberInGroupsSubscriberListCO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_GRP_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_TMPVO;
import com.path.lib.common.exception.DAOException;

public interface GroupsSubscriberDAO
{

    /**
     * get the count of the initial search grid
     */
    Integer grpSubscriberCount(GroupsSubscriberSC grpSubSC) throws DAOException;

    /**
     * get the list of the initial search grid
     */
    List<GroupsSubscriberListCO> grpSubscriberList(GroupsSubscriberSC grpSubSC) throws DAOException;

    /**
     * get the count of the subscriber not in group grid
     */
    Integer subGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws DAOException;

    /**
     * get the list of the subscriber not in group grid
     */
    List<SubscriberGroupsSubscriberListCO> subGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws DAOException;

    /**
     * get the count of the subscriber in group grid
     */
    Integer subInGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws DAOException;

    /**
     * get the list of the subscriber in group grid
     */
    List<SubscriberInGroupsSubscriberListCO> subInGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws DAOException;

    /**
     * get the details of the selected group to be populated on the screen upon
     * double click
     */
    GroupsSubscriberCO returnGroupById(GroupsSubscriberSC grpSubSC) throws DAOException;

    /**
     * get the status by group id
     */
    String getStatusByGroup(GroupsSubscriberSC grpSubSC) throws DAOException;

    /**
     * get the group_package details by group id used while using the save
     * button
     */
    List<GroupPackageCO> returnGroupPkgByGrpId(ALRT_GRPVO alrtGrpVO) throws DAOException;

    /**
     * get the event_package details by package id used while using the save
     * button
     */
    List<ALRT_EVT_PKGVOKey> returnEventByPkgId(GroupPackageCO groupPackageCO) throws DAOException;

    /**
     * get the subscription ID of the subscriber event used while using the save
     * button
     */
    BigDecimal returnSubscriptionId(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;

    /**
     * get the event list by group id used while using the save button
     */
    List<ALRT_EVT_GRPVO> returnEventByGrpId(ALRT_GRPVO alrtGrpVO) throws DAOException;

    /**
     * delete subscriber group used upon removing a subscriber from a group
     */
    void deleteSubGrp(ALRT_SUB_GRPVOKey alrtSubGrpVOKey) throws DAOException;

    /**
     * get the event_paramset by event ID used while using the save button
     */
    List<AlrtEvtParamsetListCO> returnEventParamsetById(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException;

    /**
     * get the line and status of the group_package by group id
     */
    ALRT_GRP_PKGVO returnLineGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

    /**
     * get the line and status of the event_groupe by group id
     */
    ALRT_EVT_GRPVO returnLineEvtGrp(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException;

    /**
     * update the alert_sub_evt table
     */
    void updateAlrtSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;

    /**
     * get the group_package count to check it before proceed the deleting
     * process
     */
    BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

    /**
     * get the event_group count to check it before proceed the deleting process
     */
    BigDecimal returnEvtGrpCount(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException;

    /**
     * delete subscription param table
     */
    void deleteSbtParam(GroupPackageCO groupPackageCO) throws DAOException;

    /**
     * update the sub_evt table
     */
    void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException;

    /**
     * update the group package table
     */
    void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;
    
    /**
     * update the event group table
     */
    void updateEvtGrp(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException;

    /**
     * get the data to the flipping page functionality for subscriber not in group
     * @param subGrpSubSC
     * @return
     * @throws DAOException
     */
    ArrayList<LinkedHashMap> subGrpSubscriberData(SubscriberGroupsSubscriberSC subGrpSubSC) throws DAOException;
    
    /**
     * get the data to the flipping page functionality for subscriber in group
     * @param subGrpSubSC
     * @return
     * @throws DAOException
     */
    ArrayList<LinkedHashMap> subInGrpSubscriberData(SubscriberGroupsSubscriberSC subInGrpSubSC) throws DAOException;
        
    /**
     * insert the temporary table for the subscriber not in group
     * @param alrtSubGrpTmpVO
     * @throws DAOException
     */
    void insertAlrtSubTmp (ALRT_SUB_TMPVO alrtSubTmpVO) throws DAOException;
    
    /**
     * delete not subscriber temp table
     * @throws DAOException
     */
    void deleteAlrtSubTmp () throws DAOException;
    
    /**
     * delete subscriber temp table
     * @throws DAOException
     */
//    void deleteAlrtSubGrpTmp () throws DAOException;
    
    /**
     * delete not subscriber temp table by subscriber ID
     * @throws DAOException
     */
    void deleteAlrtSubTmpById (ALRT_SUB_GRP_TMPVO alrtSubGrpTmpVO) throws DAOException;
    
    /**
     * get all new subscriber to be remove from the physical table
     * @throws DAOException
     */
    ArrayList<ALRT_SUB_TMPVO> getAlrtSubTmp (GroupsSubscriberCO groupsSubscriberCO) throws DAOException;
    
    /**
     * get all subscribers related to a group
     * @throws DAOException
     */
    ArrayList<BigDecimal> getAlrtInGrp (GroupsSubscriberCO groupsSubscriberCO) throws DAOException;
    
    /**
     * delete subscription param by subscription ID
     * @throws DAOException
     */
    void deleteSbtParam2 (ALRT_SUBSCRIPTION_PARAMVO alrtSbtParamVO) throws DAOException;
    
    /**
     * 
     * delete alert subscriber param ALRT_SUB_PKG
     */
    void deleteAlrtSubscParam(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

    /**
     * 
     * delete alert subscriber event ALRT_GRP_PKG
     */
    void deleteAlrtSubEvt(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;
    
    /**
     * 
     * delete alert subscriber param ALRT_SUB_PKG
     */
    void deleteAlrtSubscParam2(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

    /**
     * 
     * delete alert subscriber event ALRT_GRP_PKG
     */
    void deleteAlrtSubEvt2(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

    /**
     * 
     * delete alert event package
     */
    void deleteAlrtSubGrp(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

    public void deleteAlrtGrpById(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

    /**
     * method to Insert/Delete Subscriptions of the Group
     * @param GroupsSubscriberCO
     * @return
     * @throws DAOException
     */
    public Integer updateSubscriptionsByGroupId(GroupsSubscriberCO groupsSubscriberCO) throws DAOException;

}
