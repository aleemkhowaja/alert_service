package com.path.alert.bo.subscriber.groups.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.common.AlrtCommonConstants;
import com.path.alert.bo.subscriber.groups.GroupsSubscriberBO;
import com.path.alert.dao.subscriber.groups.GroupsSubscriberDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.subscriber.groups.AlrtEvtParamsetListCO;
import com.path.alert.vo.subscriber.groups.GroupPackageCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.GroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberListCO;
import com.path.alert.vo.subscriber.groups.SubscriberGroupsSubscriberSC;
import com.path.alert.vo.subscriber.groups.SubscriberInGroupsSubscriberListCO;
import com.path.bo.common.CachedConstantsCommon;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_GRP_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_TMPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.RequiredFieldsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: eliasfarah
 * 
 * 
 */
@SuppressWarnings("serial")
public class GroupsSubscriberBOImpl extends BaseBO implements GroupsSubscriberBO
{
    private AlertCommonLibBO alertCommonLibBO;
    private GroupsSubscriberDAO alertGroupsSubscriberDAO;

    public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    public void setAlertGroupsSubscriberDAO(GroupsSubscriberDAO alertGroupsSubscriberDAO)
    {
	this.alertGroupsSubscriberDAO = alertGroupsSubscriberDAO;
    }

    public Integer grpSubscriberCount(GroupsSubscriberSC grpSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertGroupsSubscriberDAO.grpSubscriberCount(grpSubSC);
    }

    public List<GroupsSubscriberListCO> grpSubscriberList(GroupsSubscriberSC grpSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertGroupsSubscriberDAO.grpSubscriberList(grpSubSC);
    }

    public Integer subGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertGroupsSubscriberDAO.subGrpSubscriberCount(subGrpSubSC);
    }

    public List<SubscriberGroupsSubscriberListCO> subGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws BaseException
    {
	// TODO Auto-generated method stub
	ALRT_SUB_GRP_TMPVO alrtSubGrpTmpVO = new ALRT_SUB_GRP_TMPVO();
	alrtSubGrpTmpVO.setSESSION_ID(subGrpSubSC.getHttpSessionIdForLink());
	alrtSubGrpTmpVO.setSUB_ID(BigDecimal.ZERO);
	genericDAO.delete(alrtSubGrpTmpVO);
	subGrpSubSC.setEnable_omni(AlrtCommonConstants.isOmniInstalled);
	return alertGroupsSubscriberDAO.subGrpSubscriberList(subGrpSubSC);
    }

    public Integer subInGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertGroupsSubscriberDAO.subInGrpSubscriberCount(subGrpSubSC);
    }

    public List<SubscriberInGroupsSubscriberListCO> subInGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws BaseException
    {
	// TODO Auto-generated method stub
	ALRT_SUB_TMPVO alrtSubTmpVO = new ALRT_SUB_TMPVO();
	alrtSubTmpVO.setSESSION_ID(subGrpSubSC.getHttpSessionIdForLink());
	alrtSubTmpVO.setID(BigDecimal.ZERO);
	genericDAO.delete(alrtSubTmpVO);
	subGrpSubSC.setEnable_omni(AlrtCommonConstants.isOmniInstalled);
	
	/**
	 * set Core Imal YN
	 */
	subGrpSubSC.setCoreImalYN(commonLibBO.returnPthCtrl1().getCORE_IMAL_YN());

	return alertGroupsSubscriberDAO.subInGrpSubscriberList(subGrpSubSC);
    }

    public GroupsSubscriberCO returnGroupById(GroupsSubscriberSC grpSubSC) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnGroupById(grpSubSC);
    }

    public String getStatusByGroup(GroupsSubscriberSC grpSubSC) throws BaseException
    {
	return alertGroupsSubscriberDAO.getStatusByGroup(grpSubSC);
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(groupsSubscriberCO.getCompCode());
	reqFieldSC.setProgRef(
		commonLibBO.returnOrginProgRef(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getProgRef()));
	reqFieldSC.setAppName(groupsSubscriberCO.getAppName());
	reqFieldSC.setBranchCode(groupsSubscriberCO.getBranchCode());
	String[] listIds, listIds2, listIds3, listNames;

	listIds = new String[] { "briefDescEng", "longDescEng", "briefDescAra", "longDescAra" };

	listIds2 = new String[] { "grpSubApp" };

	listIds3 = new String[] { "grpSubSave", "grpSubDel", "addSubToGrp", "removeSubFromGrp" };

	listNames = new String[] { "groupsSubscriberCO.alrtGrpVO.BRIEF_DESC_ENG",
		"groupsSubscriberCO.alrtGrpVO.LONG_DESC_ENG", "groupsSubscriberCO.alrtGrpVO.BRIEF_DESC_ARAB",
		"groupsSubscriberCO.alrtGrpVO.LONG_DESC_ARAB" };

	commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		groupsSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);

	commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		groupsSubscriberCO.getHm(), reqFieldSC);

	commonLibBO.applyDynScreenDisplay(listIds3, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		groupsSubscriberCO.getHm(), reqFieldSC);

	return groupsSubscriberCO.getHm();
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeApproveVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(groupsSubscriberCO.getCompCode());
	reqFieldSC.setProgRef(
		commonLibBO.returnOrginProgRef(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getProgRef()));
	reqFieldSC.setAppName(groupsSubscriberCO.getAppName());
	reqFieldSC.setBranchCode(groupsSubscriberCO.getBranchCode());
	String[] listIds, listIds2, listIds3, listNames;

	listIds2 = new String[] { "grpSubSave", "grpSubDel" };

	listIds = new String[] { "briefDescEng", "longDescEng", "briefDescAra", "longDescAra" };

	listNames = new String[] { "groupsSubscriberCO.alrtGrpVO.BRIEF_DESC_ENG",
		"groupsSubscriberCO.alrtGrpVO.LONG_DESC_ENG", "groupsSubscriberCO.alrtGrpVO.BRIEF_DESC_ARAB",
		"groupsSubscriberCO.alrtGrpVO.LONG_DESC_ARAB" };
	if(BigDecimal.ZERO.equals(NumberUtil.nullToZero(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID())))
	{
	    listIds3 = new String[] { "addSubToGrp", "removeSubFromGrp", "grpSubApp" };
	}
	else
	{
	    listIds3 = new String[] { "addSubToGrp", "removeSubFromGrp" };
	}

	commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		groupsSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);

	commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		groupsSubscriberCO.getHm(), reqFieldSC);

	commonLibBO.applyDynScreenDisplay(listIds3, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		groupsSubscriberCO.getHm(), reqFieldSC);

	return groupsSubscriberCO.getHm();
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeMaintVisibilities(
	    GroupsSubscriberCO groupsSubscriberCO, String iv_crud) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(groupsSubscriberCO.getCompCode());
	reqFieldSC.setProgRef(
		commonLibBO.returnOrginProgRef(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getProgRef()));
	reqFieldSC.setAppName(groupsSubscriberCO.getAppName());
	reqFieldSC.setBranchCode(groupsSubscriberCO.getBranchCode());
	String[] listIds, listIds2;

	if(AlertConstant.CRUD_R.equals(iv_crud))
	{
	    listIds = new String[] { "grpSubApp" };
	    if(BigDecimal.ZERO.equals(NumberUtil.nullToZero(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID())))
	    {
		listIds2 = new String[] { "grpSubDel" };
		commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ONE.toString(), groupsSubscriberCO.getHm(), reqFieldSC);
	    }
	    else
	    {
		if(!AlertConstant.Active.equals(groupsSubscriberCO.getAlrtGrpVO().getSTATUS())
			&& !"".equals(groupsSubscriberCO.getAlrtGrpVO().getSTATUS()))
		{
		    listIds2 = new String[] { "grpSubSave", "grpSubDel" };
		    commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE.toString(), groupsSubscriberCO.getHm(), reqFieldSC);
		}
	    }
	}
	else
	{
	    listIds = new String[] { "grpSubApp", "grpSubDel" };
	    if(BigDecimal.ZERO.equals(NumberUtil.nullToZero(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID())))
	    {
		listIds2 = new String[] { "grpSubSave" };
		commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ONE.toString(), groupsSubscriberCO.getHm(), reqFieldSC);
	    }
	}

	commonLibBO.applyDynScreenDisplay(listIds, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		groupsSubscriberCO.getHm(), reqFieldSC);

	return groupsSubscriberCO.getHm();
    }

    /**
     * Save New Group Record
     * 
     */
    @Override
    public void saveRecord(ArrayList<SubscriberInGroupsSubscriberListCO> subInGrpList1,
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	if(groupsSubscriberCO.getAlrtGrpVO().getBRIEF_DESC_ENG().isEmpty())
	{
	    throw new BOException(MessageCodes.Brief_Name_English_Is_Missing);
	}

	/**
	 * check condition if select specific subscribers
	 */
	if(!StringUtil.nullToEmpty(groupsSubscriberCO.getAlrtGrpVO().getINCLUDE_ALL_SUB_YN())
		.equals(ConstantsCommon.YES))
	{
	    if(subInGrpList1.isEmpty())
	    {
		throw new BOException(MessageCodes.ERROR_WHILE_SAVING_GROUP);
	    }
	}

	// add Status for newly created record and update one
	groupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_ACTIVE);

	/**
	 * Create New Record
	 */
	if(NumberUtil.isEmptyDecimal(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID()))
	{
	    groupsSubscriberCO.getAlrtGrpVO().setCREATED_BY(groupsSubscriberCO.getTraceUserId());
	    groupsSubscriberCO.getAlrtGrpVO().setDATE_CREATED(groupsSubscriberCO.getRunningDate());

	    Integer row = genericDAO.insert(groupsSubscriberCO.getAlrtGrpVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }

	    /**
	     * Call Audit for Insert new record
	     */
	    auditBO.callAudit(null, groupsSubscriberCO.getAlrtGrpVO(), groupsSubscriberCO.getAuditRefCO());

	}
	/**
	 * Update current record
	 */
	else
	{
	    groupsSubscriberCO.getAlrtGrpVO().setMODIFIED_BY(groupsSubscriberCO.getTraceUserId());
	    groupsSubscriberCO.getAlrtGrpVO().setDATE_MODIFIED(groupsSubscriberCO.getRunningDate());

	    Integer row = genericDAO.update(groupsSubscriberCO.getAlrtGrpVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }

	    GroupsSubscriberCO oldgroupsSubscriberCO = (GroupsSubscriberCO) groupsSubscriberCO.getAuditObj();
	    oldgroupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
	    oldgroupsSubscriberCO.getAlrtGrpVO().setDATE_CREATED(groupsSubscriberCO.getAlrtGrpVO().getDATE_CREATED());
	    auditBO.callAudit(oldgroupsSubscriberCO.getAlrtGrpVO(), groupsSubscriberCO.getAlrtGrpVO(),
		    groupsSubscriberCO.getAuditRefCO());

	}
	groupsSubscriberCO.setGrpId(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID());

	/**
	 * check if include all selected delete subscribers by current group id
	 */
	if(StringUtil.nullToEmpty(groupsSubscriberCO.getAlrtGrpVO().getINCLUDE_ALL_SUB_YN())
		.equals(ConstantsCommon.YES))
	{
	    saveIncludedAllSubscriber(groupsSubscriberCO);

	}
	/**
	 * else save specific selected subscribers if not checked checkbox
	 */
	else
	{
	    saveIncludedSpecificSubscriber(subInGrpList1, groupsSubscriberCO);
	}
	/**
	 * Insert the Audit
	 */
	auditBO.insertAudit(groupsSubscriberCO.getAuditRefCO());
    }

    private void saveIncludedAllSubscriber(GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	alertGroupsSubscriberDAO.deleteAlrtGrpById(groupsSubscriberCO);
    }

    /**
     * Save Specific Subscribers
     * 
     * @param subInGrpList1
     * @param groupsSubscriberCO
     * @return
     * @throws BaseException
     */
    private Integer saveIncludedSpecificSubscriber(ArrayList<SubscriberInGroupsSubscriberListCO> subInGrpList1,
	    GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	alertGroupsSubscriberDAO.deleteAlrtGrpById(groupsSubscriberCO);
	ALRT_SUB_GRPVOKey alrtSubGrpVO;
	int rows = 0;
	for(int i = 0; i < subInGrpList1.size(); i++)
	{
	    alrtSubGrpVO = new ALRT_SUB_GRPVOKey();
	    alrtSubGrpVO.setLINE_NO(new BigDecimal(i));
	    alrtSubGrpVO.setGRP_ID(groupsSubscriberCO.getAlrtGrpVO().getGRP_ID());
	    alrtSubGrpVO.setSUB_ID(subInGrpList1.get(i).getAlertSubVO().getID());
	    rows += genericDAO.insert(alrtSubGrpVO);
	}
	return rows;
    }
    /*
     * public void removeSubGrp(BigDecimal subId, GroupsSubscriberCO
     * groupsSubscriberCO) throws BaseException { List<GroupPackageCO>
     * groupPackageList; List<ALRT_EVT_PKGVOKey> evtPackageList;
     * List<ALRT_EVT_GRPVO> evtGroupList; ALRT_SUB_EVTVO alrtSubEvtVO = new
     * ALRT_SUB_EVTVO();
     * alrtSubEvtVO.applyTraceProps(groupsSubscriberCO.getAppName(),
     * groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
     * ALRT_SUB_GRPVOKey alrtSubGrpVO = new ALRT_SUB_GRPVOKey();
     * alrtSubGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(),
     * groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
     * BigDecimal grpId = groupsSubscriberCO.getAlrtGrpVO().getGRP_ID();
     * 
     * groupPackageList =
     * returnGroupPkgByGrpId(groupsSubscriberCO.getAlrtGrpVO());
     * if(!(groupPackageList == null)) { for(int i = 0; i <
     * groupPackageList.size(); i++) { evtPackageList =
     * returnEventByPkgId(groupPackageList.get(i)); for(int j = 0; j <
     * evtPackageList.size(); j++) {
     * alrtSubEvtVO.setEVT_ID(evtPackageList.get(j).getEVT_ID());
     * alrtSubEvtVO.setSUB_ID(subId);
     * alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE); BigDecimal sbtId =
     * returnSubscriptionId(alrtSubEvtVO); ALRT_SUBSCRIPTION_PARAMVO
     * alrtSbtParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
     * alrtSbtParamVO.applyTraceProps(groupsSubscriberCO.getAppName(),
     * groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
     * alrtSubEvtVO.setID(sbtId); alrtSbtParamVO.setID(sbtId);
     * 
     * alertGroupsSubscriberDAO.deleteSbtParam2(alrtSbtParamVO); int row =
     * genericDAO.delete(alrtSubEvtVO); if(row == -1) { throw new
     * BOException(MessageCodes.RECORDS_WAS_NOT_UPDATED); } } } }
     * 
     * evtGroupList = returnEventByGrpId(groupsSubscriberCO.getAlrtGrpVO());
     * if(!(evtGroupList == null)) { for(int i = 0; i < evtGroupList.size();
     * i++) { alrtSubEvtVO.setEVT_ID(evtGroupList.get(i).getEVT_ID());
     * alrtSubEvtVO.setSUB_ID(subId);
     * alrtSubEvtVO.setREL_TYPE(AlertConstant.EVENT_GROUP); BigDecimal sbtId =
     * returnSubscriptionId(alrtSubEvtVO); ALRT_SUBSCRIPTION_PARAMVO
     * alrtSbtParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
     * alrtSbtParamVO.applyTraceProps(groupsSubscriberCO.getAppName(),
     * groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
     * alrtSubEvtVO.setID(sbtId); alrtSbtParamVO.setID(sbtId);
     * alertGroupsSubscriberDAO.deleteSbtParam2(alrtSbtParamVO); int row =
     * genericDAO.delete(alrtSubEvtVO); if(row == -1) { throw new
     * BOException(MessageCodes.RECORDS_WAS_NOT_UPDATED); } } }
     * alrtSubGrpVO.setGRP_ID(grpId); alrtSubGrpVO.setSUB_ID(subId);
     * deleteSubGrp(alrtSubGrpVO); }
     */

    public void removeSubGrp(GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	groupsSubscriberCO.setRelType(AlertConstant.EVENT_GROUP);
	alertGroupsSubscriberDAO.deleteAlrtSubscParam(groupsSubscriberCO);

	groupsSubscriberCO.setRelType(AlertConstant.GROUP_PACKAGE);
	alertGroupsSubscriberDAO.deleteAlrtSubscParam2(groupsSubscriberCO);

	groupsSubscriberCO.setRelType(AlertConstant.EVENT_GROUP);
	alertGroupsSubscriberDAO.deleteAlrtSubEvt(groupsSubscriberCO);

	groupsSubscriberCO.setRelType(AlertConstant.GROUP_PACKAGE);
	alertGroupsSubscriberDAO.deleteAlrtSubEvt2(groupsSubscriberCO);

	alertGroupsSubscriberDAO.deleteAlrtSubGrp(groupsSubscriberCO);
    }

    public void addSubGrp(BigDecimal subId, GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
	alertCommonLibSC.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	ALRT_SUB_GRPVOKey alrtSubGrpVO = new ALRT_SUB_GRPVOKey();
	alrtSubGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	List<GroupPackageCO> groupPackageList;
	List<ALRT_EVT_PKGVOKey> evtPackageList;
	List<ALRT_EVT_GRPVO> evtGroupList;
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	ALRT_EVT_GRPVO alrtEvtGrpVO = new ALRT_EVT_GRPVO();
	alrtEvtGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	List<AlrtEvtParamsetListCO> alrtEvtParamsetList;
	BigDecimal grpId = groupsSubscriberCO.getAlrtGrpVO().getGRP_ID();

	alertCommonLibSC.setTrxType(AlertConstant.ALRT_SUB_GRP);

	alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

	if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
	{
	    alrtSubGrpVO.setLINE_NO(alertCommonLibSC.getArCode());
	}
	alrtSubGrpVO.setGRP_ID(grpId);
	alrtSubGrpVO.setSUB_ID(subId);
	Integer row = genericDAO.insert(alrtSubGrpVO);
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	groupPackageList = returnGroupPkgByGrpId(groupsSubscriberCO.getAlrtGrpVO());
	if(!(groupPackageList == null))
	{
	    for(int i = 0; i < groupPackageList.size(); i++)
	    {
		alrtGrpPkgVO.setGRP_ID(grpId);
		alrtGrpPkgVO.setPKG_ID(groupPackageList.get(i).getPkgId());
		alrtGrpPkgVO = alertGroupsSubscriberDAO.returnLineGrpPkg(alrtGrpPkgVO);
		evtPackageList = returnEventByPkgId(groupPackageList.get(i));
		for(int j = 0; j < evtPackageList.size(); j++)
		{
		    ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		    alrtSubEvtVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			    groupsSubscriberCO.getProgRef());
		    alertCommonLibSC.setTrxType(AlertConstant.ALRT_SUB_EVT);

		    alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

		    if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
		    {
			alrtSubEvtVO.setID(alertCommonLibSC.getArCode());
		    }

		    alrtSubEvtVO.setEVT_ID(evtPackageList.get(j).getEVT_ID());
		    alrtSubEvtVO.setSUB_ID(subId);
		    alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE);
		    alrtSubEvtVO.setREL_ID(alrtGrpPkgVO.getLINE_NO());
		    alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		    alrtSubEvtVO.setCREATED_BY(groupsSubscriberCO.getTraceUserId());
		    alrtSubEvtVO.setDATE_CREATED(groupsSubscriberCO.getRunningDate());

		    row = genericDAO.insert(alrtSubEvtVO);
		    if(row == null || row < 1)
		    {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		    }
		    alrtEvtGrpVO.setEVT_ID(evtPackageList.get(j).getEVT_ID());
		    alrtEvtParamsetList = returnEventParamsetById(alrtEvtGrpVO);

		    for(int t = 0; t < alrtEvtParamsetList.size(); t++)
		    {
			ALRT_SUBSCRIPTION_PARAMVO alrtSubtParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
			alrtSubtParamVO.applyTraceProps(groupsSubscriberCO.getAppName(),
				groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
			alrtSubtParamVO.setFIXED_CODE(alrtEvtParamsetList.get(t).getFIXED_CODE());
			alrtSubtParamVO.setFIXED_OPERATOR(alrtEvtParamsetList.get(t).getFIXED_OPERATOR());
			alrtSubtParamVO.setFROM_VALUE(alrtEvtParamsetList.get(t).getFROM_VALUE());
			alrtSubtParamVO.setTO_VALUE(alrtEvtParamsetList.get(t).getTO_VALUE());
			alrtSubtParamVO.setID(alertCommonLibSC.getArCode());
			row = genericDAO.insert(alrtSubtParamVO);
			if(row == null || row < 1)
			{
			    throw new BOException(MessageCodes.RECORD_CHANGED);
			}
		    }
		}
	    }
	}

	evtGroupList = returnEventByGrpId(groupsSubscriberCO.getAlrtGrpVO());
	if(!(evtGroupList == null))
	{
	    for(int i = 0; i < evtGroupList.size(); i++)
	    {
		alrtEvtGrpVO = new ALRT_EVT_GRPVO();
		alrtEvtGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alrtEvtGrpVO.setGRP_ID(grpId);
		alrtEvtGrpVO.setEVT_ID(evtGroupList.get(i).getEVT_ID());
		alrtEvtGrpVO = alertGroupsSubscriberDAO.returnLineEvtGrp(alrtEvtGrpVO);

		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alertCommonLibSC.setTrxType(AlertConstant.ALRT_SUB_EVT);

		alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

		if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
		{
		    alrtSubEvtVO.setID(alertCommonLibSC.getArCode());
		}

		alrtSubEvtVO.setEVT_ID(evtGroupList.get(i).getEVT_ID());
		alrtSubEvtVO.setSUB_ID(subId);
		alrtSubEvtVO.setREL_TYPE(AlertConstant.EVENT_GROUP);
		alrtSubEvtVO.setREL_ID(alrtEvtGrpVO.getLINE_NO());
		alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		alrtSubEvtVO.setCREATED_BY(groupsSubscriberCO.getTraceUserId());
		alrtSubEvtVO.setDATE_CREATED(groupsSubscriberCO.getRunningDate());

		row = genericDAO.insert(alrtSubEvtVO);
		if(row == null || row < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		alrtEvtParamsetList = returnEventParamsetById(evtGroupList.get(i));

		for(int j = 0; j < alrtEvtParamsetList.size(); j++)
		{
		    ALRT_SUBSCRIPTION_PARAMVO alrtSubtParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
		    alrtSubtParamVO.applyTraceProps(groupsSubscriberCO.getAppName(),
			    groupsSubscriberCO.getTraceUserId(), groupsSubscriberCO.getProgRef());
		    alrtSubtParamVO.setFIXED_CODE(alrtEvtParamsetList.get(j).getFIXED_CODE());
		    alrtSubtParamVO.setFIXED_OPERATOR(alrtEvtParamsetList.get(j).getFIXED_OPERATOR());
		    alrtSubtParamVO.setFROM_VALUE(alrtEvtParamsetList.get(j).getFROM_VALUE());
		    alrtSubtParamVO.setTO_VALUE(alrtEvtParamsetList.get(j).getTO_VALUE());
		    alrtSubtParamVO.setID(alertCommonLibSC.getArCode());

		    row = genericDAO.insert(alrtSubtParamVO);
		    if(row == null || row < 1)
		    {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		    }
		}
	    }
	}
    }

    public void approveRecord(GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	List<GroupPackageCO> groupPackageList;
	List<ALRT_EVT_PKGVOKey> evtPackageList;
	List<ALRT_EVT_GRPVO> evtGroupList;
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	BigDecimal grpId;

	grpId = groupsSubscriberCO.getAlrtGrpVO().getGRP_ID();
	groupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_APPROVED);
	groupsSubscriberCO.getAlrtGrpVO().setAUTHORIZED_BY(groupsSubscriberCO.getTraceUserId());
	groupsSubscriberCO.getAlrtGrpVO().setDATE_AUTHORIZED(commonLibBO.returnSystemDateWithTime());

	Integer row = genericDAO.update(groupsSubscriberCO.getAlrtGrpVO());
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	GroupsSubscriberCO oldgroupsSubscriberCO = (GroupsSubscriberCO) groupsSubscriberCO.getAuditObj();
	oldgroupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
	oldgroupsSubscriberCO.getAlrtGrpVO().setDATE_MODIFIED(groupsSubscriberCO.getAlrtGrpVO().getDATE_MODIFIED());
	oldgroupsSubscriberCO.getAlrtGrpVO().setDATE_CREATED(groupsSubscriberCO.getAlrtGrpVO().getDATE_CREATED());
	auditBO.callAudit(oldgroupsSubscriberCO.getAlrtGrpVO(), groupsSubscriberCO.getAlrtGrpVO(),
		groupsSubscriberCO.getAuditRefCO());
	auditBO.insertAudit(groupsSubscriberCO.getAuditRefCO());
    }

    public GroupsSubscriberCO checkSubscription(BigDecimal grpId, GroupsSubscriberCO groupsSubscriberCO)
	    throws BaseException
    {
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	ALRT_EVT_GRPVO alrtEvtGrpVO = new ALRT_EVT_GRPVO();
	alrtEvtGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());
	BigDecimal grpPkgCount, evtGrpCount;

	alrtGrpPkgVO.setGRP_ID(grpId);
	alrtGrpPkgVO.setSTATUS(AlertConstant.STATUS_APPROVED);
	grpPkgCount = returnGrpPkgCount(alrtGrpPkgVO);

	alrtEvtGrpVO.setGRP_ID(grpId);
	alrtEvtGrpVO.setSTATUS(AlertConstant.STATUS_APPROVED);
	evtGrpCount = returnEvtGrpCount(alrtEvtGrpVO);
	if(!BigDecimal.ZERO.equals(grpPkgCount) || !BigDecimal.ZERO.equals(evtGrpCount))
	{
	    groupsSubscriberCO.setCheckFlag(true);
	}
	else
	{
	    groupsSubscriberCO.setCheckFlag(false);
	}
	return groupsSubscriberCO;
    }

    public void deleteRecord(GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	List<GroupPackageCO> groupPackageList;
	List<ALRT_EVT_GRPVO> evtGroupList;
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
		groupsSubscriberCO.getProgRef());

	groupPackageList = returnGroupPkgByGrpId(groupsSubscriberCO.getAlrtGrpVO());
	if(!(groupPackageList == null))
	{
	    for(int i = 0; i < groupPackageList.size(); i++)
	    {
		deleteSbtParam(groupPackageList.get(i));

		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alrtSubEvtVO.setREL_ID(groupPackageList.get(i).getLineNo());
		alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE);
		alrtSubEvtVO.setDELETED_BY(groupsSubscriberCO.getTraceUserId());
		alrtSubEvtVO.setDATE_DELETED(groupsSubscriberCO.getRunningDate());
		updateSubEvt(alrtSubEvtVO);

		alrtGrpPkgVO = new ALRT_GRP_PKGVO();
		alrtGrpPkgVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alrtGrpPkgVO.setLINE_NO(groupPackageList.get(i).getLineNo());
		alrtGrpPkgVO.setDELETED_BY(groupsSubscriberCO.getTraceUserId());
		alrtGrpPkgVO.setDATE_DELETED(groupsSubscriberCO.getRunningDate());
		updateGrpPkg(alrtGrpPkgVO);
	    }
	}

	evtGroupList = returnEventByGrpId(groupsSubscriberCO.getAlrtGrpVO());
	if(!(evtGroupList == null))
	{
	    for(int i = 0; i < evtGroupList.size(); i++)
	    {
		GroupPackageCO groupPackageCO = new GroupPackageCO();
		groupPackageCO.setLineNo(evtGroupList.get(i).getLINE_NO());
		groupPackageCO.setGrpId(evtGroupList.get(i).getGRP_ID());
		deleteSbtParam(groupPackageCO);

		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alrtSubEvtVO.setREL_ID(evtGroupList.get(i).getLINE_NO());
		alrtSubEvtVO.setREL_TYPE(AlertConstant.EVENT_GROUP);
		alrtSubEvtVO.setDELETED_BY(groupsSubscriberCO.getTraceUserId());
		alrtSubEvtVO.setDATE_DELETED(groupsSubscriberCO.getRunningDate());
		updateSubEvt(alrtSubEvtVO);

		ALRT_EVT_GRPVO alrtEvtGrpVO = new ALRT_EVT_GRPVO();
		alrtEvtGrpVO.applyTraceProps(groupsSubscriberCO.getAppName(), groupsSubscriberCO.getTraceUserId(),
			groupsSubscriberCO.getProgRef());
		alrtEvtGrpVO.setLINE_NO(evtGroupList.get(i).getLINE_NO());
		alrtEvtGrpVO.setDELETED_BY(groupsSubscriberCO.getTraceUserId());
		alrtEvtGrpVO.setDATE_DELETED(groupsSubscriberCO.getRunningDate());
		updateEvtGrp(alrtEvtGrpVO);
	    }
	}
	groupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_DELETED);
	groupsSubscriberCO.getAlrtGrpVO().setDELETED_BY(groupsSubscriberCO.getTraceUserId());
	groupsSubscriberCO.getAlrtGrpVO().setDATE_DELETED(groupsSubscriberCO.getRunningDate());

	Integer row = genericDAO.update(groupsSubscriberCO.getAlrtGrpVO());
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	GroupsSubscriberCO oldgroupsSubscriberCO = (GroupsSubscriberCO) groupsSubscriberCO.getAuditObj();
	oldgroupsSubscriberCO.getAlrtGrpVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
	oldgroupsSubscriberCO.getAlrtGrpVO().setDATE_MODIFIED(groupsSubscriberCO.getAlrtGrpVO().getDATE_MODIFIED());
	oldgroupsSubscriberCO.getAlrtGrpVO().setDATE_CREATED(groupsSubscriberCO.getAlrtGrpVO().getDATE_CREATED());
	auditBO.callAudit(oldgroupsSubscriberCO.getAlrtGrpVO(), groupsSubscriberCO.getAlrtGrpVO(),
		groupsSubscriberCO.getAuditRefCO());
	auditBO.insertAudit(groupsSubscriberCO.getAuditRefCO());
    }

    public List<GroupPackageCO> returnGroupPkgByGrpId(ALRT_GRPVO alrtGrpVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnGroupPkgByGrpId(alrtGrpVO);
    }

    public List<ALRT_EVT_PKGVOKey> returnEventByPkgId(GroupPackageCO groupPackageCO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnEventByPkgId(groupPackageCO);
    }

    public BigDecimal returnSubscriptionId(ALRT_SUB_EVTVO alrtSubEvtVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnSubscriptionId(alrtSubEvtVO);
    }

    public List<ALRT_EVT_GRPVO> returnEventByGrpId(ALRT_GRPVO alrtGrpVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnEventByGrpId(alrtGrpVO);
    }

    public void deleteSubGrp(ALRT_SUB_GRPVOKey alrtSubGrpVO) throws BaseException
    {
	alertGroupsSubscriberDAO.deleteSubGrp(alrtSubGrpVO);
    }

    public List<AlrtEvtParamsetListCO> returnEventParamsetById(ALRT_EVT_GRPVO alrtEvtGrpVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnEventParamsetById(alrtEvtGrpVO);
    }

    public BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnGrpPkgCount(alrtGrpPkgVO);
    }

    public BigDecimal returnEvtGrpCount(ALRT_EVT_GRPVO alrtEvtGrpVO) throws BaseException
    {
	return alertGroupsSubscriberDAO.returnEvtGrpCount(alrtEvtGrpVO);
    }

    public void deleteSbtParam(GroupPackageCO groupPackageCO) throws BaseException
    {
	alertGroupsSubscriberDAO.deleteSbtParam(groupPackageCO);
    }

    public void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws BaseException
    {
	alertGroupsSubscriberDAO.updateSubEvt(alrtSubEvtVO);
    }

    public void updateEvtGrp(ALRT_EVT_GRPVO alrtEvtGrpVO) throws BaseException
    {
	alertGroupsSubscriberDAO.updateEvtGrp(alrtEvtGrpVO);
    }

    public void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws BaseException
    {
	alertGroupsSubscriberDAO.updateGrpPkg(alrtGrpPkgVO);
    }

    public SubscriberGroupsSubscriberListCO returnNotInGroupData(SubscriberGroupsSubscriberSC SubGrpSubSC)
	    throws BaseException
    {
	SubscriberGroupsSubscriberListCO notInGroupCO = new SubscriberGroupsSubscriberListCO();

	ArrayList<LinkedHashMap> ListColData = alertGroupsSubscriberDAO.subGrpSubscriberData(SubGrpSubSC);

	notInGroupCO.setReturnGridRowsData(ListColData);
	return notInGroupCO;
    }

    public SubscriberInGroupsSubscriberListCO returnInGroupData(SubscriberGroupsSubscriberSC SubInGrpSubSC)
	    throws BaseException
    {
	SubscriberInGroupsSubscriberListCO inGrpCO = new SubscriberInGroupsSubscriberListCO();
	ArrayList<LinkedHashMap> ListColData = alertGroupsSubscriberDAO.subInGrpSubscriberData(SubInGrpSubSC);

	inGrpCO.setReturnGridRowsData(ListColData);
	return inGrpCO;
    }

    public void removeSubFromGrp(String lstSerialNo, SubscriberGroupsSubscriberSC subInGrpSubSC) throws BaseException
    {
	ALRT_SUB_TMPVO alrtSubTmpVO = new ALRT_SUB_TMPVO();
	lstSerialNo = lstSerialNo.replace("\\", "");
	String[] array = lstSerialNo.split("alertSubVO.ID");
	for(int i = 1; i < array.length; i++)
	{
	    array[i] = array[i].substring(3, array[i].indexOf(",") - 2);
	    alrtSubTmpVO.setSESSION_ID(subInGrpSubSC.getHttpSessionIdForLink());
	    alrtSubTmpVO.setID(new BigDecimal(array[i]));
	    alertGroupsSubscriberDAO.insertAlrtSubTmp(alrtSubTmpVO);
	}
    }

    public void deleteAlrtSubTmp() throws BaseException
    {
	alertGroupsSubscriberDAO.deleteAlrtSubTmp();
    }

    public void deleteAlrtGrpById(GroupsSubscriberCO groupsSubscriberCO) throws BaseException
    {
	alertGroupsSubscriberDAO.deleteAlrtGrpById(groupsSubscriberCO);
    }

    @Override
    public GroupsSubscriberCO applyDisplaySettingByIncludeAllSub(GroupsSubscriberCO groupsSubscriberCO)
	    throws BaseException
    {
	String sendToVisibility = ConstantsCommon.ZERO;
	if(!StringUtil.nullToEmpty(groupsSubscriberCO.getAlrtGrpVO().getINCLUDE_ALL_SUB_YN())
		.equals(ConstantsCommon.YES))
	{
	    sendToVisibility = ConstantsCommon.ONE;
	}
	applyDynScreenDisplay(new String[] { "lookuptxt_group_subscribers" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
		sendToVisibility, groupsSubscriberCO.getHm(), null);

	return groupsSubscriberCO;
    }

}
