package com.path.alert.dao.subscriber.groups.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.alert.dao.subscriber.groups.GroupsSubscriberDAO;
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
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;

public class GroupsSubscriberDAOImpl extends BaseDAO implements GroupsSubscriberDAO
{

    @Override
    public Integer grpSubscriberCount(GroupsSubscriberSC grpSubSC) throws DAOException
    {
	
	DAOHelper.fixGridMaps(grpSubSC, getSqlMap(), "groupsSubscriberMapper.GroupsSubscriberResMap");
	return ((Integer) getSqlMap().queryForObject("groupsSubscriberMapper.grpSubscriberCount", grpSubSC))
		.intValue();
    }

    @Override
    public List<GroupsSubscriberListCO> grpSubscriberList(GroupsSubscriberSC grpSubSC) throws DAOException
    {
	// check if no order Specified then Order by GRP_ID descending
	if(StringUtil.nullToEmpty(grpSubSC.getSidx()).isEmpty())
	{
	    grpSubSC.setSidx("GRP_ID");
	    grpSubSC.setSord("DESC");
	}
	DAOHelper.fixGridMaps(grpSubSC, getSqlMap(), "groupsSubscriberMapper.GroupsSubscriberResMap");
	List<GroupsSubscriberListCO> lst;
	if(grpSubSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.grpSubscriberList", grpSubSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.grpSubscriberList", grpSubSC,
		    grpSubSC.getRecToskip(), grpSubSC.getNbRec());
	}
	return lst;
    }

    @Override
    public Integer subGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws DAOException
    {
	
	DAOHelper.fixGridMaps(subGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberGroupsSubscriberResMap");
	return ((Integer) getSqlMap().queryForObject("groupsSubscriberMapper.subGrpSubscriberCount", subGrpSubSC))
		.intValue();
    }

    @Override
    public List<SubscriberGroupsSubscriberListCO> subGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws DAOException
    {
	// check if no order Specified then Order by SUB_ID ascending
/*	if(StringUtil.nullToEmpty(subGrpSubSC.getSidx()).isEmpty())
	{
	    subGrpSubSC.setSidx("SUB_ID");
	    subGrpSubSC.setSord("ASC");
	}*/
	DAOHelper.fixGridMaps(subGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberGroupsSubscriberResMap");
	List<SubscriberGroupsSubscriberListCO> lst;
	if(subGrpSubSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.subGrpSubscriberList", subGrpSubSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.subGrpSubscriberList", subGrpSubSC,
		    subGrpSubSC.getRecToskip(), subGrpSubSC.getNbRec());
	}
	return lst;
    }

    @Override
    public Integer subInGrpSubscriberCount(SubscriberGroupsSubscriberSC subGrpSubSC) throws DAOException
    {
	
	DAOHelper.fixGridMaps(subGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberInGroupsSubscriberResMap");
	return ((Integer) getSqlMap().queryForObject("groupsSubscriberMapper.subInGrpSubscriberCount",
		subGrpSubSC)).intValue();
    }

    @Override
    public List<SubscriberInGroupsSubscriberListCO> subInGrpSubscriberList(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws DAOException
    {
	// check if no order Specified then Order by SUB_ID ascending
	if(StringUtil.nullToEmpty(subGrpSubSC.getSidx()).isEmpty())
	{
		    subGrpSubSC.setSidx("SUB_ID");
		    subGrpSubSC.setSord("ASC");
	}
	DAOHelper.fixGridMaps(subGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberGroupsSubscriberResMap");
	List<SubscriberInGroupsSubscriberListCO> lst;
	if(subGrpSubSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.subInGrpSubscriberList", subGrpSubSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("groupsSubscriberMapper.subInGrpSubscriberList", subGrpSubSC,
		    subGrpSubSC.getRecToskip(), subGrpSubSC.getNbRec());
	}
	return lst;
    }

    @Override
    public GroupsSubscriberCO returnGroupById(GroupsSubscriberSC grpSubSC) throws DAOException
    {
	return ((GroupsSubscriberCO) getSqlMap().queryForObject("groupsSubscriberMapper.returnGroupById", grpSubSC));
    }

    @Override
    public String getStatusByGroup(GroupsSubscriberSC grpSubSC) throws DAOException
    {
	return ((String) getSqlMap().queryForObject("groupsSubscriberMapper.getStatusByGroup", grpSubSC));
    }

    @Override
    public List<GroupPackageCO> returnGroupPkgByGrpId(ALRT_GRPVO alrtGrpVO) throws DAOException
    {
	return ((List<GroupPackageCO>) getSqlMap().queryForList("groupsSubscriberMapper.returnGroupPkgByGrpId",
		alrtGrpVO));
    }

    @Override
    public List<ALRT_EVT_PKGVOKey> returnEventByPkgId(GroupPackageCO groupPackageCO) throws DAOException
    {
	return (List<ALRT_EVT_PKGVOKey>) getSqlMap().queryForList("groupsSubscriberMapper.returnEventByPkgId",
		groupPackageCO);
    }

    @Override
    public BigDecimal returnSubscriptionId(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("groupsSubscriberMapper.returnSubscriptionId", alrtSubEvtVO);

    }

    @Override
    public List<ALRT_EVT_GRPVO> returnEventByGrpId(ALRT_GRPVO alrtGrpVO) throws DAOException
    {
	return ((List<ALRT_EVT_GRPVO>) getSqlMap().queryForList("groupsSubscriberMapper.returnEventByGrpId",
		alrtGrpVO));
    }

    @Override
    public void deleteSubGrp(ALRT_SUB_GRPVOKey alrtSubGrpVOKey) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteSubGrp", alrtSubGrpVOKey);
    }

    @Override
    public List<AlrtEvtParamsetListCO> returnEventParamsetById(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException
    {
	return ((List<AlrtEvtParamsetListCO>) getSqlMap()
		.queryForList("groupsSubscriberMapper.returnEventParamsetById", alrtEvtGrpVO));
    }

    @Override
    public ALRT_GRP_PKGVO returnLineGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	return (ALRT_GRP_PKGVO) getSqlMap().queryForObject("groupsSubscriberMapper.returnLineGrpPkg", alrtGrpPkgVO);
    }

    @Override
    public ALRT_EVT_GRPVO returnLineEvtGrp(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException
    {
	return (ALRT_EVT_GRPVO) getSqlMap().queryForObject("groupsSubscriberMapper.returnLineEvtGrp", alrtEvtGrpVO);
    }

    @Override
    public void updateAlrtSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.updateAlrtSubEvt", alrtSubEvtVO);
    }

    @Override
    public BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("groupsSubscriberMapper.returnGrpPkgCount", alrtGrpPkgVO));
    }

    @Override
    public BigDecimal returnEvtGrpCount(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("groupsSubscriberMapper.returnEvtGrpCount", alrtEvtGrpVO));
    }

    @Override
    public void deleteSbtParam(GroupPackageCO groupPackageCO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteSbtParam", groupPackageCO);
    }

    @Override
    public void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.updateSubEvt", alrtSubEvtVO);
    }

    @Override
    public void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.updateGrpPkg", alrtGrpPkgVO);
    }
    
    @Override
    public void updateEvtGrp(ALRT_EVT_GRPVO alrtEvtGrpVO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.updateEvtGrp", alrtEvtGrpVO);
    }
    
    @Override
    public ArrayList<LinkedHashMap> subGrpSubscriberData(SubscriberGroupsSubscriberSC subGrpSubSC)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(subGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberGroupsSubscriberResMap");
	if(subGrpSubSC.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("groupsSubscriberMapper.subGrpSubscriberData", subGrpSubSC);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("groupsSubscriberMapper.subGrpSubscriberData", subGrpSubSC,
		    subGrpSubSC.getRecToskip(), subGrpSubSC.getNbRec());
	}
    }
    
    @Override
    public ArrayList<LinkedHashMap> subInGrpSubscriberData(SubscriberGroupsSubscriberSC subInGrpSubSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subInGrpSubSC, getSqlMap(), "groupsSubscriberMapper.SubscriberInGroupsSubscriberResMap");
	if(subInGrpSubSC.getNbRec() == -1)
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("groupsSubscriberMapper.subInGrpSubscriberData", subInGrpSubSC);
	}
	else
	{
	    return (ArrayList<LinkedHashMap>) getSqlMap().queryForList("groupsSubscriberMapper.subInGrpSubscriberData", subInGrpSubSC,
		    subInGrpSubSC.getRecToskip(), subInGrpSubSC.getNbRec());
	}
    }
        
    @Override
    public void insertAlrtSubTmp (ALRT_SUB_TMPVO alrtSubTmpVO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.insertAlrtSubTmp", alrtSubTmpVO);
    }
    
    @Override
    public void deleteAlrtSubTmp () throws DAOException{
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubTmp", null);
    }
    
    @Override
    public void deleteAlrtSubTmpById (ALRT_SUB_GRP_TMPVO alrtSubGrpTmpVO) throws DAOException{
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubTmpById", alrtSubGrpTmpVO);
    }
    
    @Override
    public ArrayList<ALRT_SUB_TMPVO> getAlrtSubTmp (GroupsSubscriberCO groupsSubscriberCO) throws DAOException{
	return (ArrayList<ALRT_SUB_TMPVO>) getSqlMap().queryForList("groupsSubscriberMapper.getAlrtSubTmp", groupsSubscriberCO);
    }
    
    @Override
    public ArrayList<BigDecimal> getAlrtInGrp (GroupsSubscriberCO groupsSubscriberCO) throws DAOException{
	return (ArrayList<BigDecimal>) getSqlMap().queryForList("groupsSubscriberMapper.getAlrtInGrp", groupsSubscriberCO);
    }
    
    @Override
    public void deleteSbtParam2 (ALRT_SUBSCRIPTION_PARAMVO alrtSbtParamVO) throws DAOException{
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteSbtParam2", alrtSbtParamVO);
    }
    
    @Override
    public void deleteAlrtSubscParam(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubscParam", groupsSubscriberCO);
    }

    @Override
    public void deleteAlrtSubEvt(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubEvt", groupsSubscriberCO);
    }
    
    @Override
    public void deleteAlrtSubscParam2(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubscParam2", groupsSubscriberCO);
    }

    @Override
    public void deleteAlrtSubEvt2(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
    {
	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubEvt2", groupsSubscriberCO);
    }

    @Override
    public void deleteAlrtSubGrp(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
    {
    	getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtSubGrp", groupsSubscriberCO);
    }

	@Override
	public void deleteAlrtGrpById(GroupsSubscriberCO groupsSubscriberCO) throws DAOException
	{
		getSqlMap().queryForObject("groupsSubscriberMapper.deleteAlrtGrpById", groupsSubscriberCO);
	}

	@Override
	public Integer updateSubscriptionsByGroupId(GroupsSubscriberCO groupsSubscriberCO) throws DAOException 
	{
		return getSqlMap().update("groupsSubscriberMapper.updateSubscriptionsByGroupId", groupsSubscriberCO);
	}
}
