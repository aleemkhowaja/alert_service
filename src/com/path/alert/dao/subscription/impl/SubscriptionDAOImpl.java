package com.path.alert.dao.subscription.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.alert.dao.subscription.SubscriptionDAO;
import com.path.alert.vo.subscription.SubscriptionCO;
import com.path.alert.vo.subscription.SubscriptionSC;
import com.path.alert.vo.subscription.SubscriptionWsCO;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class SubscriptionDAOImpl extends BaseDAO implements SubscriptionDAO
{

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<LinkedHashMap> packagesData(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.packageResMap");
	if(sc.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.packageData", sc);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.packageData", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<LinkedHashMap> groupsData(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.groupsResMap");
	if(sc.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.groupsData", sc);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.groupsData", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<LinkedHashMap> eventData(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.eventsResMap");
	if(sc.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.eventsData", sc);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.eventsData", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<LinkedHashMap> subscriberData(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersResMap");
	if(sc.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.subscribersData", sc);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.subscribersData", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }

    @Override
    public Integer eventParamsCount(SubscriptionSC sc) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.eventsParamsCount", sc)).intValue();
	return nb;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadFixedParamsList(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.fixedParamsList", sc);
    }

    @Override
    public void deleteSubEvtParam(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().delete("subscriptionMapper.deleteSubEvtParam", sc);

    }
    
    @Override
    public void deleteExcludedModesListByID(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().delete("subscriptionMapper.deleteExcludedModesListByID", sc);
	
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadSubEvtParam(SubscriptionSC subscriptionSC) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.subEvtParamsList", subscriptionSC);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadEventParams(SubscriptionSC subscriptionSC) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.eventsParamsList", subscriptionSC);
    }

    @Override
    public Integer fixedEvtParamCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.fixedEvtParamsCount", subscriptionSC))
		.intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadFixedEvtParamsSet(SubscriptionSC subscriptionSC) throws DAOException
    {

	return getSqlMap().queryForList("subscriptionMapper.fixedEvtParamsSet", subscriptionSC);
    }

    @Override
    public BigDecimal selectFixedEventId(SubscriptionSC sc) throws DAOException
    {
	BigDecimal fixed_event_id = new BigDecimal(0);
	fixed_event_id = ((BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnFixedEventId", sc));
	return fixed_event_id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadSubscriptionDetailsGrid(SubscriptionSC subscriptionSC) throws DAOException
    {

	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.subscriptionDetailsResMap");
	if(subscriptionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscriptionDetailsList", subscriptionSC);
	}
	else
	{

	    return getSqlMap().queryForList("subscriptionMapper.subscriptionDetailsList", subscriptionSC,
		    subscriptionSC.getRecToskip(), subscriptionSC.getNbRec());
	}
    }

    @Override
    public Integer subscriptionDetailsCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.subscriptionDetailsResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnsubscriptionDetailsCount", subscriptionSC))
		.intValue();
	return nb;
    }

    @Override
    public SubscriptionCO viewStatusDetail(SubscriptionSC sc) throws DAOException
    {
	return (SubscriptionCO) getSqlMap().queryForObject("subscriptionMapper.viewStatusDetails", sc);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadGroupsGrid(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.groupsResMap");
	if(subscriptionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.groupsList", subscriptionSC);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.groupsList", subscriptionSC,
		    subscriptionSC.getRecToskip(), subscriptionSC.getNbRec());
	}
    }

    @Override
    public Integer groupsCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.groupsResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnGroupsCount", subscriptionSC)).intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")

    @Override
    public List<SubscriptionCO> loadPackageGrid(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.packageResMap");
	if(subscriptionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.packageList", subscriptionSC);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.packageList", subscriptionSC,
		    subscriptionSC.getRecToskip(), subscriptionSC.getNbRec());
	}
    }

    @Override
    public Integer packageCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.packageResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnPackageCount", subscriptionSC)).intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadSubscribersGrid(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.subscribersResMap");
	if(subscriptionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscribersList", subscriptionSC);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscribersList", subscriptionSC,
		    subscriptionSC.getRecToskip(), subscriptionSC.getNbRec());
	}
    }

    @Override
    public Integer subscribersCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.subscribersResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubscribersCount", subscriptionSC))
		.intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> loadEventsGrid(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.eventsResMap");
	if(subscriptionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.eventsList", subscriptionSC);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.eventsList", subscriptionSC,
		    subscriptionSC.getRecToskip(), subscriptionSC.getNbRec());
	}
    }

    @Override
    public Integer eventsCount(SubscriptionSC subscriptionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subscriptionSC, getSqlMap(), "subscriptionMapper.eventsResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnEventsCount", subscriptionSC)).intValue();
	return nb;
    }

    @Override
    public Integer updateExistingSubEvt(SubscriptionCO co) throws DAOException
    {
	return getSqlMap().update("subscriptionMapper.updateExistingSubEvt", co);

    }

    @Override
    public Integer updateExistingSubPckg(SubscriptionCO co) throws DAOException
    {
	return getSqlMap().update("subscriptionMapper.updateExistingSubPckg", co);

    }

    @Override
    public Integer updateExistingEvtGrp(SubscriptionCO co) throws DAOException
    {
	return getSqlMap().update("subscriptionMapper.updateExistingEvtGrp", co);

    }

    @Override
    public Integer updateExistingGrpPckg(SubscriptionCO co) throws DAOException
    {
	return getSqlMap().update("subscriptionMapper.updateExistingGrpPckg", co);

    }

    @Override
    public Integer subscriberEvtCount(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersEventsResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubscriberEvtCount", sc)).intValue();
	return nb;
    }
    
    @Override
    public Integer subscriberAllEvtCount(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersEventsResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubscriberAllEvtCount", sc)).intValue();
	return nb;
    }

    @Override
    public List subscriberEvtList(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersEventsResMap");
	if(sc.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscriberEvtList", sc);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscriberEvtList", sc, sc.getRecToskip(),
		    sc.getNbRec());
	}
    }
    
    @Override
    public List subscriberAllEvtList(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersEventsResMap");
	if(sc.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscriberAllEvtList", sc);
	}
	else
	{
	    return getSqlMap().queryForList("subscriptionMapper.subscriberAllEvtList", sc, sc.getRecToskip(),
		    sc.getNbRec());
	}
    }

    @Override
    public void deletePopulatedFromTmp() throws DAOException
    {
    	if(ConstantsCommon.CURR_DBMS_SQLSERVER == 0){
            getSqlMap().update("coreCommonMapper.commitTrans", null);
        }
    	
    	getSqlMap().queryForObject("subscriptionMapper.deletePopulatedFromTmp", null);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubscriptionCO> subscribersListSelected(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.subscribersListSelected", sc);
    }

    @Override
    public List<SubscriptionCO> groupsListSelected(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.select_groupsListSelected", sc);
    }

    @Override
    public List<SubscriptionCO> loadSelectedEventsGrid(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.eventsListSelected", sc);
    }

    @Override
    public List<SubscriptionCO> loadSelectedPckgGrid(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.pckgListSelected", sc);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<LinkedHashMap> subEvtData(SubscriptionSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscribersEventsResMap");
	if(sc.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.subEvtData", sc);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("subscriptionMapper.subEvtData", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }

    @Override
    public void deleteSubEvtTmp() throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteSubEvtTmp", null);

    }

    @Override
    public void deleteSubEvtTmpByID(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteSubEvtTmpByID", sc);

    }

    @Override
    public void updateSubEvt(ALRT_SUB_EVTVO subEvtVo) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateSubEvt", subEvtVo);

    }

    @Override
    public int returnSubEvtCount(SubscriptionSC sc) throws DAOException
    {

	return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubEvtCount", sc)).intValue();

    }

    @Override
    public List<SubscriptionCO> subscriberEvtListAll(SubscriptionSC sc) throws DAOException
    {

	return getSqlMap().queryForList("subscriptionMapper.subscriberEvtListAll", sc);
    }

    @Override
    public void removeSubEvt(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.removeSubEvt", sc);

    }

    @Override
    public void removeSubPkg(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.removeSubPkg", sc);

    }

    @Override
    public int returnSubPkgCount(SubscriptionSC sc) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubPkgCount", sc)).intValue();
    }

    @Override
    public List<ALRT_EVT_PKGVOKey> returnEvtPkgList(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnEvtPkgList", sc);
    }

    @Override
    public void updateSubPkg(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateSubPkg", sc);

    }

    @Override
    public void updateSubEvtStatus(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateSubEvtStatus", sc);

    }

    @Override
    public void updateEvtGrpStatus(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateEvtGrpStatus", sc);

    }

    @Override
    public void updateEvtGrp(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateEvtGrp", sc);

    }

    @Override
    public void updateAlrtCounter(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateAlrtCounter", sc);

    }

    @Override
    public int returnEvtGrpCount(SubscriptionSC sc) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnEvtGrpCount", sc)).intValue();
    }

    @Override
    public List<ALRT_SUB_GRPVOKey> returnSubGrpList(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnSubGrpList", sc);
    }

    @Override
    public void updateGrpPkg(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateGrpPkg", sc);

    }

    @Override
    public void updateGrpPkgStatus(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateGrpPkgStatus", sc);

    }

    @Override
    public int returnGrpPkgCount(SubscriptionSC sc) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnGrpPkgCount", sc)).intValue();

    }

    @Override
    public BigDecimal returnNotified(BigDecimal sub_ID) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnNotified", sub_ID));
    }

    @Override
    public int returnIfFirstApproved(BigDecimal sub_ID) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnIfFirstApproved", sub_ID)).intValue();
    }

    @Override
    public ALRT_EVTVO selectEvtDetails(BigDecimal ctrl_VALUE) throws DAOException
    {
	return (ALRT_EVTVO) getSqlMap().queryForObject("subscriptionMapper.selectEvtDetails", ctrl_VALUE);
    }

    /*
     * @Override public ALRT_SUBVO selectSubDetails(BigDecimal subID) throws
     * DAOException { return (ALRT_SUBVO)
     * getSqlMap().queryForObject("tradingMapper.selectSubDetails", subID); }
     */

    @Override
    public String selectCifLanguage(ALRT_SUBVO subVo) throws DAOException
    {
	return (String) getSqlMap().queryForObject("subscriptionMapper.selectCifLanguage", subVo);
    }

    @Override
    public String selectUsrLanguage(USRVO usrVO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("subscriptionMapper.selectUsrLanguage", usrVO);
    }

    @Override
    public Integer updateAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {

	return (Integer) getSqlMap().update("subscriptionMapper.updateAlrtSubEvt", sub_EVTVO);
    }

    @Override
    public void updateAlrtSubParam(ALRT_SUBSCRIPTION_PARAMVO subParamVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateAlrtSubParam", subParamVO);

    }

    @Override
    public List<SubscriptionCO> subscriberEvtListSelected(SubscriptionSC subscriptionSC) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.subscriberEvtListSelected", subscriptionSC);
    }

    @Override
    public void updateAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateAlrtSubEvtSP", sub_EVTVO);

    }

    @Override
    public void approveAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.approveAlrtSubPkg", subPkgVO);

    }

    @Override
    public void updateAlrtSubParamSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateAlrtSubParamSP", sub_EVTVO);

    }

    @Override
    public List<ALRT_SUB_GRPVOKey> returnAlrtGrp(SubscriptionSC subscriptionSC) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnAlrtGrp", subscriptionSC);
    }

    @Override
    public void updateAlrtSubEvtEG(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.updateAlrtSubEvtEG", sub_EVTVO);

    }

    @Override
    public void approveAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.approveAlrtEvtGrp", evtGrpVO);

    }

    @Override
    public void approveAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.approveAlrtGrpPkg", alrtGrpPkgVO);

    }

    @Override
    public void deleteAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteAlrtSubEvt", sub_EVTVO);

    }

    @Override
    public void deleteAlrtSubParam(ALRT_SUBSCRIPTION_PARAMVO subParamVO) throws DAOException
    {
	getSqlMap().delete("subscriptionMapper.deleteAlrtSubParam", subParamVO);

    }

    public void deleteAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteAlrtSubEvtSP", sub_EVTVO);
    }

    @Override
    public void deleteAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteAlrtSubPkg", subPkgVO);

    }

    @Override
    public void deleteAlrtSubParamSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().delete("subscriptionMapper.deleteAlrtSubParamSP", sub_EVTVO);

    }

    @Override
    public void delteAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.delteAlrtEvtGrp", evtGrpVO);

    }

    @Override
    public void deleteAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteAlrtGrpPkg", alrtGrpPkgVO);

    }

    @Override
    public void rejectAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.rejectAlrtSubEvt", sub_EVTVO);
    }

    @Override
    public void rejectAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.rejectAlrtSubEvtSP", sub_EVTVO);

    }

    @Override
    public void rejectAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.rejectAlrtSubPkg", subPkgVO);

    }

    @Override
    public void rejectAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.rejectAlrtEvtGrp", evtGrpVO);

    }

    @Override
    public void rejectAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.rejectAlrtGrpPkg", alrtGrpPkgVO);

    }

    @Override
    public List<SubscriptionCO> returnSubEvtList(SubscriptionCO co) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnSubEvtList", co);
    }

    @Override
    public BigDecimal returnRelID(SubscriptionSC sc) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnRelID", sc);
    }

    @Override
    public List<SubscriptionCO> retrieveSubEvtList(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.retrieveSubEvtList", sc);
    }

    @Override
    public List<SubscriptionCO> returnSubPkgList(SubscriptionCO subscriptionCO) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnSubPkgList", subscriptionCO);
    }

    @Override
    public List<SubscriptionCO> returnEvtGrpList(SubscriptionCO subscriptionCO) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnEvtGrpList", subscriptionCO);
    }

    @Override
    public List<SubscriptionCO> returngrpPkgList(SubscriptionCO subscriptionCO) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returngrpPkgList", subscriptionCO);
    }

    @Override
    public BigDecimal returnSPRelID(SubscriptionSC sc) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnSPRelID", sc);
    }

    @Override
    public BigDecimal returnEGRelID(SubscriptionSC sc) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnEGRelID", sc);
    }

    @Override
    public BigDecimal returnGPRelID(SubscriptionSC sc) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("subscriptionMapper.returnGPRelID", sc);
    }

    @Override
    public List<ALRT_SUBSCRIPTION_PARAMVO> returnAlrtSubParam(SubscriptionSC sc) throws DAOException
    {
	return getSqlMap().queryForList("subscriptionMapper.returnAlrtSubParam", sc);
    }

    @Override
    public void deleteSubscriptions(SubscriptionSC sc) throws DAOException
    {
	getSqlMap().queryForObject("subscriptionMapper.deleteSubscriptions", sc);
	
    }

    @Override
    public SubscriptionCO checkEventModeFlags(SubscriptionCO subscriptionCO) throws DAOException
    {
    	return (SubscriptionCO) getSqlMap().queryForObject("subscriptionMapper.checkEventModeFlags", subscriptionCO);
    }

	@Override
	public SubscriptionCO returnSubscriptionDetailsById(SubscriptionSC sc) throws DAOException 
	{
		return (SubscriptionCO) getSqlMap().queryForObject("subscriptionMapper.retSubscriptionDetailsById", sc);
	}
    @Override
    public SubscriptionCO returnDetailsForSubscriber(SubscriptionSC sc) throws DAOException
    {
	return (SubscriptionCO) getSqlMap().queryForObject("subscriptionMapper.returnDetailsForSubscriber", sc);
    }
    
    @Override
    public int returnCommunicationTypeCnt(SubscriptionSC  criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "subscriptionMapper.resCommunicationTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnCommunicationTypeCnt", criteria))
		.intValue();
	return nb;
    }

    @Override
    public List<SubscriptionCO> returnCommunicationTypeList(SubscriptionSC  criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "subscriptionMapper.resCommunicationTypeListMap");
	if(criteria.getNbRec() == -1)
	{
	    return (List<SubscriptionCO>) getSqlMap().queryForList("subscriptionMapper.returnCommunicationTypeList", criteria);
	}
	else
	{
	    return (List<SubscriptionCO>) getSqlMap().queryForList("subscriptionMapper.returnCommunicationTypeList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    @Override
    public List<SubscriptionCO> retrieveSubEvtWSList(SubscriptionSC sc) throws DAOException
    {
    	return getSqlMap().queryForList("subscriptionMapper.retrieveSubEvtWSList", sc);
    }

	@Override
	public List<SubscriptionCO> retSubscriberLineNo(SubscriptionSC sc) throws DAOException 
	{
		return getSqlMap().queryForList("subscriptionMapper.retSubscriberLineNo", sc);
	}

	@Override
	public List<SubscriptionCO> returnEvtSubDetails(SubscriptionSC sc) throws DAOException 
	{
		return getSqlMap().queryForList("subscriptionMapper.returnEvtSubDetails", sc);
	}

	@Override
	public Integer updateSubscriptionsStatus(SubscriptionCO subscriptionCO) throws DAOException 
	{
		return getSqlMap().update("subscriptionMapper.updateSubscriptionsStatus", subscriptionCO);
	}
	
	@Override
	public Integer toBeDeletedSubEvents(SubscriptionSC subscriptionSC) throws DAOException 
	{
		return getSqlMap().update("subscriptionMapper.toBeDeletedSubEvents", subscriptionSC);
	}
	
	@Override
	public Integer toBeDeletedSubscription(SubscriptionSC subscriptionSC) throws DAOException 
	{
		return getSqlMap().update("subscriptionMapper.toBeDeletedSubscrption", subscriptionSC);
	}
	
	@Override
	public Integer updateStatusSubscription(SubscriptionSC subscriptionSC) throws DAOException 
	{
		return getSqlMap().update("subscriptionMapper.updateStatusSubscrption", subscriptionSC);
	}
	
        @Override
        public Integer returnSubscriptionWsCount(SubscriptionSC sc) throws DAOException
        {
           return ((Integer) getSqlMap().queryForObject("subscriptionMapper.returnSubscriptionWsCount", sc)).intValue();
        }
    
        @SuppressWarnings("unchecked")
        @Override
        public List<SubscriptionWsCO> returnSubscriptionWsList(SubscriptionSC sc) throws DAOException
        {
            DAOHelper.fixGridMaps(sc, getSqlMap(), "subscriptionMapper.subscriptionWSResultMap");
            return getSqlMap().queryForList("subscriptionMapper.returnSubscriptionWsList", sc);
        }
        
        @Override
        public Integer saveALRT_SUB_EVT_TMP(SubscriptionSC sc) throws DAOException
        {
        	return (Integer) getSqlMap().insert("subscriptionMapper.saveALRT_SUB_EVT_TMP", sc);
        }
        
        @Override
        public Integer saveBulkINALRT_SUB_EVT_TEMP(SubscriptionSC sc) throws DAOException
        {
        	return (Integer)  getSqlMap().update("subscriptionMapper.saveBulkALRT_SUB_EVT_TMP", sc);
        }
        
        @Override
        public Integer saveBulkINALRT_SUB_EVT(SubscriptionSC sc) throws DAOException
        {
        	return (Integer)  getSqlMap().update("subscriptionMapper.saveBulkALRT_SUB_EVT", sc);
        }
        
        @Override
        public Integer truncateTableALRT_SUB_EVT_TMP(SubscriptionSC sc) throws DAOException
        {
        	if(ConstantsCommon.CURR_DBMS_SQLSERVER == 0){
                getSqlMap().update("coreCommonMapper.commitTrans", null);
            }
        	return (Integer)  getSqlMap().update("subscriptionMapper.truncateTableALRT_SUB_EVT_TMP", sc);
	}
        
        @Override
        public Integer commitTransBeforeTruncate() throws DAOException
        {
        	return getSqlMap().update("subscriptionMapper.commitTrans", null);
	}
        
        @Override
        public Integer approveBulkALRT_SUB_EVT(SubscriptionSC sc) throws DAOException
        {
        	return (Integer)  getSqlMap().update("subscriptionMapper.approveBulkALRT_SUB_EVT", sc);
        }
        
        @Override
        public Integer updateALRT_SUB_EVT(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException
        {
        	return (Integer)  getSqlMap().update("subscriptionMapper.updateALRT_SUB_EVT", sub_EVTVO);
        }
}