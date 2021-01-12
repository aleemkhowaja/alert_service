package com.path.alert.bo.subscriber.groups;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.alert.vo.subscriber.groups.GroupsSubscriberCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberInGroupsSubscriberListCO;
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
public interface GroupsSubscriberBO
{

    /**
     * get the count of the initial search grid
     */
    Integer grpSubscriberCount(GroupsSubscriberSC grpSubSC) throws BaseException;

    /**
     * get the list of the initial search grid
     */
    List<GroupsSubscriberListCO> grpSubscriberList(GroupsSubscriberSC grpSubSC) throws BaseException;

    /**
     * get the count of the subscriber not in group grid
     */
    Integer subGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws BaseException;

    /**
     * get the list of the subscriber not in group grid
     */
    List<SubscriberGroupsSubscriberListCO> subGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws BaseException;

    /**
     * get the count of the subscriber in group grid
     */
    Integer subInGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws BaseException;

    /**
     * get the list of the subscriber not in group grid
     */
    List<SubscriberInGroupsSubscriberListCO> subInGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws BaseException;

    /**
     * get the group details by group Id for the double click on the initial
     * search grid
     */
    GroupsSubscriberCO returnGroupById(GroupsSubscriberSC grpSubSC) throws BaseException;

    /**
     * get status by group id
     */
    String getStatusByGroup(GroupsSubscriberSC grpSubSC) throws BaseException;

    /**
     * apply visibility on the delete screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * apply visibility on the approve screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeApproveVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * apply visibility on the maintenance screen
     */
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeMaintVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO, String iv_crud) throws BaseException;

    /**
     * save the new group or add new subscriber to an existing group if the
     * status of the record is new
     */
    void saveRecord(ArrayList<SubscriberInGroupsSubscriberListCO> subInGrpList,GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * approve the group only if the status is new
     */
    void approveRecord(GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * delete group only from maintenance screen having for status new
     */
    void deleteRecord(GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * check if there subscription related to subscribers in this group before
     * proceed in the delete process
     */
    GroupsSubscriberCO checkSubscription(BigDecimal grpId, GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * return not in group subscriber list for flipping functionality
     * @param SubGrpSubSC
     * @return
     * @throws BaseException
     */
    SubscriberGroupsSubscriberListCO returnNotInGroupData(SubscriberGroupsSubscriberSC SubGrpSubSC)
	    throws BaseException;

    /**
     * return in group subscriber list for flipping functionality
     * @param SubGrpSubSC
     * @return
     * @throws BaseException
     */
    SubscriberInGroupsSubscriberListCO returnInGroupData(SubscriberGroupsSubscriberSC SubInGrpSubSC)
	    throws BaseException;

    /**
     * remove the subscribers from the group
     * @param lstSerialNo
     * @param subGrpSubSC
     * @throws BaseException
     */
    void removeSubFromGrp(String lstSerialNo, SubscriberGroupsSubscriberSC subInGrpSubSC) throws BaseException;

    /**
     * delete the temporary table
     * @throws BaseException
     */
    void deleteAlrtSubTmp() throws BaseException;
        
    public void deleteAlrtGrpById(GroupsSubscriberCO groupsSubscriberCO) throws BaseException;

    /**
     * show/hide subscriber livesearch based on
     * check box of include all
     * @param groupsSubscriberCO
     * @return
     * @throws BaseException 
     */
    public GroupsSubscriberCO applyDisplaySettingByIncludeAllSub(GroupsSubscriberCO groupsSubscriberCO) throws BaseException;
}
