package com.path.alert.bo.events.eventpackage.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.events.eventpackage.PackageEventBO;
import com.path.alert.dao.events.eventpackage.PackageEventDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.events.eventpackage.EventInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.EventInPackageEventSC;
import com.path.alert.vo.events.eventpackage.EventNotInPackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventCO;
import com.path.alert.vo.events.eventpackage.PackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventSC;
import com.path.alert.vo.subscriber.groups.GroupPackageCO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.ALRT_NOT_IN_PKG_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.DBSequenceSC;
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
public class PackageEventBOImpl extends BaseBO implements PackageEventBO
{
    private AlertCommonLibBO alertCommonLibBO;
    private PackageEventDAO alertPackageEventDAO;

    public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    public void setalertPackageEventDAO(PackageEventDAO alertPackageEventDAO)
    {
	this.alertPackageEventDAO = alertPackageEventDAO;
    }

    public Integer pkgEventCount(PackageEventSC pkgEvtSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.pkgEventCount(pkgEvtSC);
    }

    public List<PackageEventListCO> pkgEventList(PackageEventSC pkgEvtSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.pkgEventList(pkgEvtSC);
    }
    @Override
    public PackageEventListCO pkgEventListById(PackageEventSC pkgEvtSC) throws BaseException
    {
	return alertPackageEventDAO.pkgEventListById(pkgEvtSC);
    }

    public Integer evtNotInPackageCount(EventInPackageEventSC evtNotInPkgSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.evtNotInPackageCount(evtNotInPkgSC);
    }

    public List<EventNotInPackageEventListCO> evtNotInPackageList(EventInPackageEventSC evtNotInPkgSC)
	    throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.evtNotInPackageList(evtNotInPkgSC);
    }

    public Integer evtInPackageCount(EventInPackageEventSC evtInPkgSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.evtInPackageCount(evtInPkgSC);
    }

    public List<EventInPackageEventListCO> evtInPackageList(EventInPackageEventSC evtInPkgSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertPackageEventDAO.evtInPackageList(evtInPkgSC);
    }

    public PackageEventCO returnPackageById(PackageEventSC pkgEvtSC) throws BaseException
    {
	return alertPackageEventDAO.returnPackageById(pkgEvtSC);
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    PackageEventCO packageEventCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(packageEventCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(packageEventCO.getAppName(), packageEventCO.getProgRef()));
	reqFieldSC.setAppName(packageEventCO.getAppName());
	reqFieldSC.setBranchCode(packageEventCO.getBranchCode());
	String[] listIds, listIds2, listIds3, listNames;

	listIds = new String[] { "briefDescEng", "longDescEng", "briefDescAra", "longDescAra", "lookuptxt_package_event" };

	listIds2 = new String[] { "pkgEvtApp" };

	listIds3 = new String[] { "pkgEvtSave", "pkgEvtDel", "addEvtToPkg", "removeEvtFromPkg" };

	listNames = new String[] { "packageEventCO.alrtPkgVO.BRIEF_DESC_ENG", "packageEventCO.alrtPkgVO.LONG_DESC_ENG",
		"packageEventCO.alrtPkgVO.BRIEF_DESC_ARAB", "packageEventCO.alrtPkgVO.LONG_DESC_ARAB", "packageEventCO.alrtPkgVO.INCLUDE_ALL_EVT_YN" };

	commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		packageEventCO.getHm(), reqFieldSC, Boolean.TRUE);

	commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		packageEventCO.getHm(), reqFieldSC);

	commonLibBO.applyDynScreenDisplay(listIds3, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		packageEventCO.getHm(), reqFieldSC);

	return packageEventCO.getHm();
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeApproveVisibilities(
	    PackageEventCO packageEventCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(packageEventCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(packageEventCO.getAppName(), packageEventCO.getProgRef()));
	reqFieldSC.setAppName(packageEventCO.getAppName());
	reqFieldSC.setBranchCode(packageEventCO.getBranchCode());
	String[] listIds, listIds2, listIds3, listNames;

	listIds2 = new String[] { "pkgEvtSave", "pkgEvtDel" };

	listIds = new String[] { "briefDescEng", "longDescEng", "briefDescAra", "longDescAra", "lookuptxt_package_event" };

	listNames = new String[] { "packageEventCO.alrtPkgVO.BRIEF_DESC_ENG", "packageEventCO.alrtPkgVO.LONG_DESC_ENG",
		"packageEventCO.alrtPkgVO.BRIEF_DESC_ARAB", "packageEventCO.alrtPkgVO.LONG_DESC_ARAB", "packageEventCO.alrtPkgVO.INCLUDE_ALL_EVT_YN" };

	if(BigDecimal.ZERO.equals(NumberUtil.nullToZero(packageEventCO.getAlrtPkgVO().getPKG_ID())))
	{
	    listIds3 = new String[] { "addEvtToPkg", "removeEvtFromPkg", "pkgEvtApp" };
	}
	else
	{
	    listIds3 = new String[] { "addEvtToPkg", "removeEvtFromPkg" };
	}

	commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		packageEventCO.getHm(), reqFieldSC, Boolean.TRUE);

	commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		packageEventCO.getHm(), reqFieldSC);

	commonLibBO.applyDynScreenDisplay(listIds3, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		packageEventCO.getHm(), reqFieldSC);

	return packageEventCO.getHm();
    }

    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeMaintVisibilities(
	    PackageEventCO packageEventCO, String iv_crud) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(packageEventCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(packageEventCO.getAppName(), packageEventCO.getProgRef()));
	reqFieldSC.setAppName(packageEventCO.getAppName());
	reqFieldSC.setBranchCode(packageEventCO.getBranchCode());
	String[] listIds, listIds2;

	if(AlertConstant.CRUD_R.equals(iv_crud))
	{
	    listIds = new String[] { "pkgEvtApp" };
	    if(NumberUtil.nullToZero(packageEventCO.getAlrtPkgVO().getPKG_ID()).equals(BigDecimal.ZERO))
	    {
		listIds2 = new String[] { "pkgEvtDel" };
		commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ONE.toString(), packageEventCO.getHm(), reqFieldSC);
	    }
	    else
	    {
		if(!packageEventCO.getAlrtPkgVO().getSTATUS().equals(AlertConstant.Active) && StringUtil.isNotEmpty(packageEventCO.getAlrtPkgVO().getSTATUS()))
		{
		    listIds2 = new String[] { "pkgEvtSave", "pkgEvtDel" };
		    commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE.toString(), packageEventCO.getHm(), reqFieldSC);
		}
	    }
	}
	else
	{
	    listIds = new String[] { "pkgEvtApp", "pkgEvtDel" };
	    if(NumberUtil.nullToZero(packageEventCO.getAlrtPkgVO().getPKG_ID()).equals(BigDecimal.ZERO))
	    {
		listIds2 = new String[] { "pkgEvtSave" };
		commonLibBO.applyDynScreenDisplay(listIds2, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ONE.toString(), packageEventCO.getHm(), reqFieldSC);
	    }
	}

	commonLibBO.applyDynScreenDisplay(listIds, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
		packageEventCO.getHm(), reqFieldSC);

	return packageEventCO.getHm();
    }

    public String getStatusByPackage(PackageEventSC pkgEvtSC) throws BaseException
    {
	return alertPackageEventDAO.getStatusByPackage(pkgEvtSC);
    }

    public void saveRecord(ArrayList<EventNotInPackageEventListCO> evtNotInPkgList,ArrayList<EventInPackageEventListCO> evtInPkgList, PackageEventCO packageEventCO) throws BaseException
    {
		if(packageEventCO.getAlrtPkgVO().getBRIEF_DESC_ENG().isEmpty())
		{
		    throw new BOException(MessageCodes.Brief_Name_English_Is_Missing);
		}
		
		/**
		 * check condition if 
		 * select specific subscribers
		 */
		if(null != evtInPkgList && evtInPkgList.isEmpty())
		{
		    	//@todo  check if this code is stating that no message exist 
			throw new BOException(MessageCodes.ERROR_WHILE_SAVING_PACKAGE);
		}

		packageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
		
		if(NumberUtil.isEmptyDecimal(packageEventCO.getAlrtPkgVO().getPKG_ID()))
		{
		    packageEventCO.getAlrtPkgVO().setCREATED_BY(packageEventCO.getTraceUserId());
			packageEventCO.getAlrtPkgVO().setDATE_CREATED(packageEventCO.getRunningDate());
		    Integer row = genericDAO.insert(packageEventCO.getAlrtPkgVO());
		    if(row == null || row < 1)
		    {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		    }
		    
		    auditBO.callAudit(null, packageEventCO.getAlrtPkgVO(), packageEventCO.getAuditRefCO());
		}
		else
		{
		    packageEventCO.getAlrtPkgVO().setMODIFIED_BY(packageEventCO.getTraceUserId());
		    packageEventCO.getAlrtPkgVO().setDATE_MODIFIED(packageEventCO.getRunningDate());
		    Integer row = genericDAO.update(packageEventCO.getAlrtPkgVO());
		    if(row == null || row < 1)
		    {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		    }
		    
		    
		    PackageEventCO oldpackageEventCO = (PackageEventCO) packageEventCO.getAuditObj();
		    if (null != oldpackageEventCO) 
		    {
			oldpackageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
			oldpackageEventCO.getAlrtPkgVO().setDATE_CREATED(packageEventCO.getAlrtPkgVO().getDATE_CREATED());
			auditBO.callAudit(oldpackageEventCO.getAlrtPkgVO(), packageEventCO.getAlrtPkgVO(),packageEventCO.getAuditRefCO());
		    }
		}
		
		packageEventCO.setPkgId(packageEventCO.getAlrtPkgVO().getPKG_ID());

		/**
		 * check if  include all selected
		 * delete events by current package id id
		 */
//		if(StringUtil.nullToEmpty(packageEventCO.getAlrtPkgVO().getINCLUDE_ALL_EVT_YN()).equals(ConstantsCommon.YES))
//		{
//		    saveIncludedAllEvent(packageEventCO);
//		    
//		}
		/**
		 * else
		 * save specific selected subscribers
		 * if not checked checkbox
		 */
		//else
		//{
		    saveIncludedSpecificEvent(evtInPkgList, packageEventCO);
		//}
		//insert audit
		auditBO.insertAudit(packageEventCO.getAuditRefCO());

    }
    
    /**
     * Save specific Events
     * @param evtInPkgList
     * @param packageEventCO
     * @throws BaseException
     */
    private void saveIncludedSpecificEvent(ArrayList<EventInPackageEventListCO> evtInPkgList,
	    PackageEventCO packageEventCO) throws BaseException
    {
	
	alertPackageEventDAO.deleteAlrtEvtPk(packageEventCO);
	PackageEventSC pkgEvtSC = new PackageEventSC();
	pkgEvtSC.setPkgId(packageEventCO.getAlrtPkgVO().getPKG_ID());
	ALRT_EVT_PKGVOKey alrtEvntPkg;
	for(int i = 0; i<evtInPkgList.size();i++)
	{
		alrtEvntPkg = new ALRT_EVT_PKGVOKey();
		if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
	    {
		    DBSequenceSC dbSeqSC = new DBSequenceSC();
			dbSeqSC.setSequenceName("ALRT_EVT_PKG_SEQ");
			alrtEvntPkg.setLINE_NO(commonLibBO.returnTableSequence(dbSeqSC));
	    }
//		alrtEvntPkg.setLINE_NO(evtInPkgList.get(i).getLINE_NO());
		alrtEvntPkg.setEVT_ID(evtInPkgList.get(i).getEVT_ID());
		alrtEvntPkg.setPKG_ID(packageEventCO.getPkgId());
		genericDAO.insert(alrtEvntPkg);
	}
	
    }

    /**
     * Save All Events
     * @param packageEventCO
     * @throws BaseException
     */
    private void saveIncludedAllEvent(PackageEventCO packageEventCO) throws BaseException
    {
	alertPackageEventDAO.deleteAlrtEvtPk(packageEventCO);
    }

    public void approveRecord(PackageEventCO packageEventCO) throws BaseException
    {
		List<GroupPackageCO> groupPackageList;
		List<ALRT_SUB_PKGVO> alrtSubPkgList;
		List<ALRT_SUB_GRPVOKey> alrtSubGrpList;
		ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
		alrtGrpPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(), packageEventCO.getProgRef());
		packageEventCO.setPkgId(packageEventCO.getAlrtPkgVO().getPKG_ID());
		BigDecimal pkgId = packageEventCO.getAlrtPkgVO().getPKG_ID();
		packageEventCO.setPkgId(pkgId);
	
		packageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_APPROVED);
		packageEventCO.getAlrtPkgVO().setAUTHORIZED_BY(packageEventCO.getTraceUserId());
		packageEventCO.getAlrtPkgVO().setDATE_AUTHORIZED(commonLibBO.returnSystemDateWithTime());
	
		Integer row = genericDAO.update(packageEventCO.getAlrtPkgVO());
		if(row == null || row < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		
		groupPackageList = returnGroupPkgByPkgId(packageEventCO);
		alrtSubPkgList = returnSubPkgByPkgId(packageEventCO);
	
		if(!(groupPackageList == null))
		{
		    for(int i = 0; i < groupPackageList.size(); i++)
		    {
				alrtGrpPkgVO.setPKG_ID(pkgId);
				alrtGrpPkgVO.setGRP_ID(groupPackageList.get(i).getGrpId());
		
				alrtSubGrpList = returnSubByGrpId(groupPackageList.get(i));
				alrtGrpPkgVO = alertPackageEventDAO.returnLineGrpPkg(alrtGrpPkgVO);
		
				if(!(alrtSubGrpList == null))
				{
				    for(int j = 0; j < alrtSubGrpList.size(); j++)
				    {
				    	ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
					    alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(), packageEventCO.getProgRef());
					    alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE);
					    alrtSubEvtVO.setREL_ID(alrtGrpPkgVO.getLINE_NO());
					    alrtSubEvtVO.setSTATUS(alrtGrpPkgVO.getSTATUS());
					    alrtSubEvtVO.setAUTHORIZED_BY(packageEventCO.getTraceUserId());
					    alrtSubEvtVO.setDATE_AUTHORIZED(packageEventCO.getRunningDate());
		
					    alertPackageEventDAO.updateAlrtSubEvt(alrtSubEvtVO);
				    }
				}
		    }
		}
	
		if(!(alrtSubPkgList == null))
		{
		    for(int i = 0; i < alrtSubPkgList.size(); i++)
		    {
				ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		
				alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(), packageEventCO.getProgRef());
				alrtSubEvtVO.setREL_TYPE(AlertConstant.SUB_PARAM);
				alrtSubEvtVO.setREL_ID(alrtSubPkgList.get(i).getLINE_NO());
				alrtSubEvtVO.setSTATUS(alrtSubPkgList.get(i).getSTATUS());
				alrtSubEvtVO.setSUB_ID(alrtSubPkgList.get(i).getSUB_ID());
				alrtSubEvtVO.setAUTHORIZED_BY(packageEventCO.getTraceUserId());
				alrtSubEvtVO.setDATE_AUTHORIZED(packageEventCO.getRunningDate());
		
				alertPackageEventDAO.updateAlrtSubEvt1(alrtSubEvtVO);
		    }
		}
		PackageEventCO oldpackageEventCO = (PackageEventCO) packageEventCO.getAuditObj();
		oldpackageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
		oldpackageEventCO.getAlrtPkgVO().setDATE_MODIFIED(packageEventCO.getAlrtPkgVO().getDATE_MODIFIED());
		oldpackageEventCO.getAlrtPkgVO().setDATE_CREATED(packageEventCO.getAlrtPkgVO().getDATE_CREATED());
		auditBO.callAudit(oldpackageEventCO.getAlrtPkgVO(), packageEventCO.getAlrtPkgVO(), packageEventCO.getAuditRefCO());
		auditBO.insertAudit(packageEventCO.getAuditRefCO());
		
		alertPackageEventDAO.updateSubscriptionsByPackageId(packageEventCO);
    }

    public void removeEvtPkg(PackageEventCO packageEventCO) throws BaseException
    {

	packageEventCO.setRelType(AlertConstant.SUB_PARAM);
	alertPackageEventDAO.deleteAlrtSubscParam(packageEventCO);

	packageEventCO.setRelType(AlertConstant.GROUP_PACKAGE);
	alertPackageEventDAO.deleteAlrtSubscParam2(packageEventCO);

	packageEventCO.setRelType(AlertConstant.SUB_PARAM);
	alertPackageEventDAO.deleteAlrtSubEvt(packageEventCO);

	packageEventCO.setRelType(AlertConstant.GROUP_PACKAGE);
	alertPackageEventDAO.deleteAlrtSubEvt2(packageEventCO);

	alertPackageEventDAO.deleteAlrtEvtPk(packageEventCO);
    }

    public void addEvtPkg(PackageEventCO packageEventCO) throws BaseException
    {
	AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
	alertCommonLibSC.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
		packageEventCO.getProgRef());
	ALRT_EVT_PKGVOKey alrtEvtPkgVO = new ALRT_EVT_PKGVOKey();
	alrtEvtPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
		packageEventCO.getProgRef());
	List<GroupPackageCO> groupPackageList;
	List<ALRT_SUB_PKGVO> alrtSubPkgList;
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	BigDecimal eventParamsetCount;
	BigDecimal pkgId = packageEventCO.getAlrtPkgVO().getPKG_ID();
	packageEventCO.setPkgId(pkgId);
	BigDecimal evtId = packageEventCO.getEvtId();
//	alertCommonLibSC.setTrxType(AlertConstant.ALRT_EVT_PKG);
	List<ALRT_SUB_GRPVOKey> alrtSubGrpList;

	eventParamsetCount = returnEventParamsetById(packageEventCO);

//	alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

//	if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
//	{
//	    alrtEvtPkgVO.setLINE_NO(alertCommonLibSC.getArCode());
//	}
	
	if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
    {
	    DBSequenceSC dbSeqSC = new DBSequenceSC();
		dbSeqSC.setSequenceName("ALRT_EVT_PKG_SEQ");
		alrtEvtPkgVO.setLINE_NO(commonLibBO.returnTableSequence(dbSeqSC));
    }
	alrtEvtPkgVO.setPKG_ID(pkgId);
	alrtEvtPkgVO.setEVT_ID(evtId);
	Integer row = genericDAO.insert(alrtEvtPkgVO);
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	groupPackageList = returnGroupPkgByPkgId(packageEventCO);

	alrtSubPkgList = returnSubPkgByPkgId(packageEventCO);

	if(!(groupPackageList == null))
	{
	    for(int i = 0; i < groupPackageList.size(); i++)
	    {
		alrtGrpPkgVO.setPKG_ID(pkgId);
		alrtGrpPkgVO.setGRP_ID(groupPackageList.get(i).getGrpId());

		alrtSubGrpList = returnSubByGrpId(groupPackageList.get(i));

		alrtGrpPkgVO = alertPackageEventDAO.returnLineGrpPkg(alrtGrpPkgVO);

		if(!(alrtSubGrpList == null))
		{
		    for(int j = 0; j < alrtSubGrpList.size(); j++)
		    {
			ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
			alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
				packageEventCO.getProgRef());
			alertCommonLibSC.setTrxType(AlertConstant.ALRT_SUB_EVT);

			alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

			if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
			{
			    alrtSubEvtVO.setID(alertCommonLibSC.getArCode());
			}

			alrtSubEvtVO.setEVT_ID(evtId);
			alrtSubEvtVO.setSUB_ID(alrtSubGrpList.get(j).getSUB_ID());
			alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE);
			alrtSubEvtVO.setREL_ID(alrtGrpPkgVO.getLINE_NO());
			alrtSubEvtVO.setSTATUS(alrtGrpPkgVO.getSTATUS());
			alrtSubEvtVO.setCREATED_BY(packageEventCO.getTraceUserId());
			alrtSubEvtVO.setDATE_CREATED(packageEventCO.getRunningDate());

			row = genericDAO.insert(alrtSubEvtVO);
			if(row == null || row < 1)
			{
			    throw new BOException(MessageCodes.RECORD_CHANGED);
			}

			if(!(BigDecimal.ZERO.equals(NumberUtil.nullToZero(eventParamsetCount))))
			{
			    alertPackageEventDAO.insertAlrtEvtParamset(alrtSubEvtVO);
			}
		    }
		}
	    }
	}

	if(!(alrtSubPkgList == null))
	{
	    for(int i = 0; i < alrtSubPkgList.size(); i++)
	    {
		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
			packageEventCO.getProgRef());
		alertCommonLibSC.setTrxType(AlertConstant.ALRT_SUB_EVT);

		alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

		if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
		{
		    alrtSubEvtVO.setID(alertCommonLibSC.getArCode());
		}

		alrtSubEvtVO.setEVT_ID(evtId);
		alrtSubEvtVO.setSUB_ID(alrtSubPkgList.get(i).getSUB_ID());
		alrtSubEvtVO.setREL_TYPE(AlertConstant.SUB_PARAM);
		alrtSubEvtVO.setREL_ID(alrtSubPkgList.get(i).getLINE_NO());
		alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		alrtSubEvtVO.setCREATED_BY(packageEventCO.getTraceUserId());
		alrtSubEvtVO.setDATE_CREATED(packageEventCO.getRunningDate());

		row = genericDAO.insert(alrtSubEvtVO);
		if(row == null || row < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		if(!(BigDecimal.ZERO.equals(NumberUtil.nullToZero(eventParamsetCount))))
		{
		    alertPackageEventDAO.insertAlrtEvtParamset(alrtSubEvtVO);
		}
	    }
	}
    }

    public PackageEventCO checkSubscription(PackageEventCO packageEventCO)
	    throws BaseException
    {
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
		packageEventCO.getProgRef());
	ALRT_SUB_PKGVO alrtSubPkgVO = new ALRT_SUB_PKGVO();
	alrtSubPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
		packageEventCO.getProgRef());
	BigDecimal grpPkgCount, subPkgCount;

	alrtGrpPkgVO.setPKG_ID(packageEventCO.getPkgId());
	alrtGrpPkgVO.setSTATUS(AlertConstant.STATUS_APPROVED);
	grpPkgCount = returnGrpPkgCount(alrtGrpPkgVO);

	alrtSubPkgVO.setPKG_ID(packageEventCO.getPkgId());
	alrtSubPkgVO.setSTATUS(AlertConstant.STATUS_APPROVED);
	subPkgCount = returnSubPkgCount(alrtSubPkgVO);
	if(!BigDecimal.ZERO.equals(grpPkgCount) || !BigDecimal.ZERO.equals(subPkgCount))
	{
	    packageEventCO.setCheckFlag(true);
	}
	else
	{
	    packageEventCO.setCheckFlag(false);
	}
	return packageEventCO;
    }

    public void deleteRecord(PackageEventCO packageEventCO)
	    throws BaseException
    {
	List<GroupPackageCO> groupPackageList;
	List<ALRT_SUB_PKGVO> alrtSubPkgList;
	/*List<ALRT_EVT_GRPVO> evtGroupList;
	ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	alrtGrpPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
		packageEventCO.getProgRef());*/
	
	packageEventCO.setPkgId(packageEventCO.getAlrtPkgVO().getPKG_ID());
	groupPackageList = returnGroupPkgByPkgId(packageEventCO);
	if(!(groupPackageList == null))
	{
	    for(int i = 0; i < groupPackageList.size(); i++)
	    {
		deleteSbtParam(groupPackageList.get(i));

		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
			packageEventCO.getProgRef());
		alrtSubEvtVO.setREL_ID(groupPackageList.get(i).getLineNo());
		alrtSubEvtVO.setREL_TYPE(AlertConstant.GROUP_PACKAGE);
		alrtSubEvtVO.setDELETED_BY(packageEventCO.getTraceUserId());
		alrtSubEvtVO.setDATE_DELETED(packageEventCO.getRunningDate());
		updateSubEvt(alrtSubEvtVO);

		ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
		alrtGrpPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
			packageEventCO.getProgRef());
		alrtGrpPkgVO.setLINE_NO(groupPackageList.get(i).getLineNo());
		alrtGrpPkgVO.setDELETED_BY(packageEventCO.getTraceUserId());
		alrtGrpPkgVO.setDATE_DELETED(packageEventCO.getRunningDate());
		updateGrpPkg(alrtGrpPkgVO);
	    }
	}
	alrtSubPkgList = returnSubPkgByPkgId(packageEventCO);
	if(!(alrtSubPkgList == null))
	{
	    for(int i = 0; i < alrtSubPkgList.size(); i++)
	    {
		GroupPackageCO groupPackageCO = new GroupPackageCO();
		groupPackageCO.setLineNo(alrtSubPkgList.get(i).getLINE_NO());
		groupPackageCO.setPkgId(alrtSubPkgList.get(i).getPKG_ID());
		deleteSbtParam(groupPackageCO);

		ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
		alrtSubEvtVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
			packageEventCO.getProgRef());
		alrtSubEvtVO.setREL_ID(alrtSubPkgList.get(i).getLINE_NO());
		alrtSubEvtVO.setREL_TYPE(AlertConstant.EVENT_GROUP);
		alrtSubEvtVO.setDELETED_BY(packageEventCO.getTraceUserId());
		alrtSubEvtVO.setDATE_DELETED(packageEventCO.getRunningDate());
		updateSubEvt(alrtSubEvtVO);

		ALRT_SUB_PKGVO alrtSubPkgVO = new ALRT_SUB_PKGVO();
		alrtSubPkgVO.applyTraceProps(packageEventCO.getAppName(), packageEventCO.getTraceUserId(),
			packageEventCO.getProgRef());
		alrtSubPkgVO.setLINE_NO(alrtSubPkgList.get(i).getLINE_NO());
		alrtSubPkgVO.setDELETED_BY(packageEventCO.getTraceUserId());
		alrtSubPkgVO.setDATE_DELETED(packageEventCO.getRunningDate());
		updateSubPkg(alrtSubPkgVO);
	    }
	}
	packageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_DELETED);
	packageEventCO.getAlrtPkgVO().setDELETED_BY(packageEventCO.getTraceUserId());
	packageEventCO.getAlrtPkgVO().setDATE_DELETED(packageEventCO.getRunningDate());

	Integer row = genericDAO.update(packageEventCO.getAlrtPkgVO());
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	PackageEventCO oldPackageEventCO = (PackageEventCO) packageEventCO.getAuditObj();
	oldPackageEventCO.getAlrtPkgVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
	oldPackageEventCO.getAlrtPkgVO().setDATE_MODIFIED(packageEventCO.getAlrtPkgVO().getDATE_MODIFIED());
	oldPackageEventCO.getAlrtPkgVO().setDATE_CREATED(packageEventCO.getAlrtPkgVO().getDATE_CREATED());
	auditBO.callAudit(oldPackageEventCO.getAlrtPkgVO(), packageEventCO.getAlrtPkgVO(),
		packageEventCO.getAuditRefCO());
	auditBO.insertAudit(packageEventCO.getAuditRefCO());
    }
    
    public BigDecimal returnEventParamsetById(PackageEventCO packageEventCO) throws BaseException
    {
	return alertPackageEventDAO.returnEventParamsetById(packageEventCO);
    }

    public List<GroupPackageCO> returnGroupPkgByPkgId(PackageEventCO packageEventCO) throws BaseException
    {
	return alertPackageEventDAO.returnGroupPkgByPkgId(packageEventCO);
    }

    public List<ALRT_SUB_PKGVO> returnSubPkgByPkgId(PackageEventCO packageEventCO) throws BaseException
    {
	return alertPackageEventDAO.returnSubPkgByPkgId(packageEventCO);
    }

    public List<ALRT_SUB_GRPVOKey> returnSubByGrpId(GroupPackageCO groupPackageCO) throws BaseException
    {
	return alertPackageEventDAO.returnSubByGrpId(groupPackageCO);
    }
    
    public BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws BaseException
    {
	return alertPackageEventDAO.returnGrpPkgCount(alrtGrpPkgVO);
    }

    public BigDecimal returnSubPkgCount(ALRT_SUB_PKGVO alrtSubPkgVO) throws BaseException
    {
	return alertPackageEventDAO.returnSubPkgCount(alrtSubPkgVO);
    }
    
    public void deleteSbtParam(GroupPackageCO groupPackageCO) throws BaseException
    {
	alertPackageEventDAO.deleteSbtParam(groupPackageCO);
    }
    
    public void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws BaseException
    {
	alertPackageEventDAO.updateSubEvt(alrtSubEvtVO);
    }
    
    public void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws BaseException
    {
	alertPackageEventDAO.updateGrpPkg(alrtGrpPkgVO);
    }
    
    public void updateSubPkg(ALRT_SUB_PKGVO alrtSubPkgVO) throws BaseException
    {
	alertPackageEventDAO.updateSubPkg(alrtSubPkgVO);
    }
    
    
    public void insertAlrtInPkgTmp(PackageEventCO packageEventCO) throws BaseException{
	ALRT_IN_PKG_TMPVO alrtInPkgTmpVO = new ALRT_IN_PKG_TMPVO();
	alrtInPkgTmpVO.setID(packageEventCO.getEvtId());
	alrtInPkgTmpVO.setSESSION_ID(packageEventCO.getHttpSessionIdForLink());
	alertPackageEventDAO.insertAlrtInPkgTmp(alrtInPkgTmpVO);
	deleteAlrtNotInPkgTmpById(alrtInPkgTmpVO);
    }
    
    public void insertAlrtNotInPkgTmp(PackageEventCO packageEventCO) throws BaseException{
	ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO = new ALRT_NOT_IN_PKG_TMPVO();
	alrtNotInPkgTmpVO.setEVT_ID(packageEventCO.getEvtId());
	alrtNotInPkgTmpVO.setSESSION_ID(packageEventCO.getHttpSessionIdForLink());
	alertPackageEventDAO.insertAlrtNotInPkgTmp(alrtNotInPkgTmpVO);
	deleteAlrtInPkgTmpById(alrtNotInPkgTmpVO);
    }
    
    public void deleteAlrtInPkgTmp() throws BaseException{
	alertPackageEventDAO.deleteAlrtInPkgTmp();
    }
    
    public void deleteAlrtNotInPkgTmp() throws BaseException{
	alertPackageEventDAO.deleteAlrtNotInPkgTmp();
    }
    
    public void deleteAlrtInPkgTmpById(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws BaseException{
	alertPackageEventDAO.deleteAlrtInPkgTmpById(alrtNotInPkgTmpVO);
    }
    
    public void deleteAlrtNotInPkgTmpById(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws BaseException{
	alertPackageEventDAO.deleteAlrtNotInPkgTmpById(alrtInPkgTmpVO);
    }

//    @Override
//    public PackageEventCO applyDisplaySettingByIncludeAllSub(PackageEventCO packageEventCO) throws BaseException
//    {
//	String sendToVisibility = StringUtil
//		.nullEmptyToValue(packageEventCO.getAlrtPkgVO().getINCLUDE_ALL_EVT_YN(), ConstantsCommon.NO)
//		.equals(ConstantsCommon.NO) ? ConstantsCommon.ONE : ConstantsCommon.ZERO;
//	
//	applyDynScreenDisplay(new String[] { "lookuptxt_package_event" },ConstantsCommon.ACTION_TYPE_VISIBLE, sendToVisibility, packageEventCO.getHm(), null);
//	
//	return packageEventCO;
//    }

    
}
