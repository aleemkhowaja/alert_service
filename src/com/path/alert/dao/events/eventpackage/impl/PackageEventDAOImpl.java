package com.path.alert.dao.events.eventpackage.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.alert.dao.events.eventpackage.PackageEventDAO;
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
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;

public class PackageEventDAOImpl extends BaseDAO implements PackageEventDAO
{

    @Override
    public Integer pkgEventCount(PackageEventSC pkgEvtSC) throws DAOException
    {
	DAOHelper.fixGridMaps(pkgEvtSC, getSqlMap(), "packageEventMapper.PackageEventResMap");
	return ((Integer) getSqlMap().queryForObject("packageEventMapper.pkgEventCount", pkgEvtSC)).intValue();
    }

    @Override
    public List<PackageEventListCO> pkgEventList(PackageEventSC pkgEvtSC) throws DAOException
    {
	// check if no order Specified then Order by PKG_ID Descending
	if(StringUtil.nullToEmpty(pkgEvtSC.getSidx()).isEmpty())
	{
	    pkgEvtSC.setSidx("PKG_ID");
	    pkgEvtSC.setSord("DESC");
	}
	DAOHelper.fixGridMaps(pkgEvtSC, getSqlMap(), "packageEventMapper.PackageEventResMap");
	List<PackageEventListCO> lst;
	if(pkgEvtSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("packageEventMapper.pkgEventList", pkgEvtSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("packageEventMapper.pkgEventList", pkgEvtSC, pkgEvtSC.getRecToskip(),
		    pkgEvtSC.getNbRec());
	}
	return lst;
    }

    @Override
    public PackageEventListCO pkgEventListById(PackageEventSC pkgEvtSC) throws DAOException
    {
	
	DAOHelper.fixGridMaps(pkgEvtSC, getSqlMap(), "packageEventMapper.PackageEventResMap");
	
	return (PackageEventListCO) getSqlMap().queryForObject("packageEventMapper.pkgEventListById", pkgEvtSC);
	
    }

    @Override
    public Integer evtNotInPackageCount(EventInPackageEventSC evtNotInPkgSC) throws DAOException
    {
	DAOHelper.fixGridMaps(evtNotInPkgSC, getSqlMap(), "packageEventMapper.EventNotInPackageEventResMap");
	return ((Integer) getSqlMap().queryForObject("packageEventMapper.evtNotInPackageCount", evtNotInPkgSC))
		.intValue();
    }

    @Override
    public List<EventNotInPackageEventListCO> evtNotInPackageList(EventInPackageEventSC evtNotInPkgSC)
	    throws DAOException
    {
	// check if no order Specified then Order by EVT_ID ascending
	if(StringUtil.nullToEmpty(evtNotInPkgSC.getSidx()).isEmpty())
	{
	    evtNotInPkgSC.setSidx("EVT_ID");
	    evtNotInPkgSC.setSord("ASC");
	}
	DAOHelper.fixGridMaps(evtNotInPkgSC, getSqlMap(), "packageEventMapper.EventNotInPackageEventResMap");
	List<EventNotInPackageEventListCO> lst;
	if(evtNotInPkgSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("packageEventMapper.evtNotInPackageList", evtNotInPkgSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("packageEventMapper.evtNotInPackageList", evtNotInPkgSC,
		    evtNotInPkgSC.getRecToskip(), evtNotInPkgSC.getNbRec());
	}
	return lst;
    }

    @Override
    public Integer evtInPackageCount(EventInPackageEventSC evtInPkgSC) throws DAOException
    {
	DAOHelper.fixGridMaps(evtInPkgSC, getSqlMap(), "packageEventMapper.EventInPackageEventResMap");
	return ((Integer) getSqlMap().queryForObject("packageEventMapper.evtInPackageCount", evtInPkgSC))
		.intValue();
    }

    @Override
    public List<EventInPackageEventListCO> evtInPackageList(EventInPackageEventSC evtInPkgSC) throws DAOException
    {
	// check if no order Specified then Order by EVT_ID ascending
	if(StringUtil.nullToEmpty(evtInPkgSC.getSidx()).isEmpty())
	{
	    evtInPkgSC.setSidx("EVT_ID");
	    evtInPkgSC.setSord("ASC");
	}
	DAOHelper.fixGridMaps(evtInPkgSC, getSqlMap(), "packageEventMapper.EventInPackageEventResMap");
	List<EventInPackageEventListCO> lst;
	if(evtInPkgSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("packageEventMapper.evtInPackageList", evtInPkgSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("packageEventMapper.evtInPackageList", evtInPkgSC, evtInPkgSC.getRecToskip(),
		    evtInPkgSC.getNbRec());
	}
	return lst;
    }

    @Override
    public PackageEventCO returnPackageById(PackageEventSC pkgEvtSC) throws DAOException
    {
	return ((PackageEventCO) getSqlMap().queryForObject("packageEventMapper.returnPackageById", pkgEvtSC));
    }

    @Override
    public String getStatusByPackage(PackageEventSC pkgEvtSC) throws DAOException
    {
	return ((String) getSqlMap().queryForObject("packageEventMapper.getStatusByPackage", pkgEvtSC));
    }

    @Override
    public void deleteAlrtSubscParam(PackageEventCO packageEventCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtSubscParam", packageEventCO);
    }

    @Override
    public void deleteAlrtSubEvt(PackageEventCO packageEventCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtSubEvt", packageEventCO);
    }
    
    @Override
    public void deleteAlrtSubscParam2(PackageEventCO packageEventCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtSubscParam2", packageEventCO);
    }

    @Override
    public void deleteAlrtSubEvt2(PackageEventCO packageEventCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtSubEvt2", packageEventCO);
    }

    @Override
    public void deleteAlrtEvtPk(PackageEventCO packageEventCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtEvtPk", packageEventCO);
    }

    @Override
    public ALRT_GRP_PKGVO returnLineGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	return (ALRT_GRP_PKGVO) getSqlMap().queryForObject("groupsSubscriberMapper.returnLineGrpPkg", alrtGrpPkgVO);
    }
    
    @Override
    public BigDecimal returnEventParamsetById(PackageEventCO packageEventCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("packageEventMapper.returnEventParamsetById", packageEventCO);
    }
    
    @Override
    public List<GroupPackageCO> returnGroupPkgByPkgId(PackageEventCO packageEventCO)throws DAOException
    {
	return (List<GroupPackageCO>) getSqlMap().queryForList("packageEventMapper.returnGroupPkgByPkgId", packageEventCO);
    }

    @Override
    public List<ALRT_SUB_PKGVO> returnSubPkgByPkgId(PackageEventCO packageEventCO)throws DAOException{
	return (List<ALRT_SUB_PKGVO>) getSqlMap().queryForList("packageEventMapper.returnSubPkgByPkgId", packageEventCO);
    }
    
    @Override
    public List<ALRT_SUB_GRPVOKey> returnSubByGrpId(GroupPackageCO groupPackageCO)throws DAOException
    {
	return (List<ALRT_SUB_GRPVOKey>) getSqlMap().queryForList("packageEventMapper.returnSubByGrpId", groupPackageCO);
    }
    
    @Override
    public void insertAlrtEvtParamset(ALRT_SUB_EVTVO alrtSubEvtVO)throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.insertAlrtEvtParamset", alrtSubEvtVO);
    }
    
    @Override
    public BigDecimal returnGrpPkgCount(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException{
	return (BigDecimal) getSqlMap().queryForObject("packageEventMapper.returnGrpPkgCount", alrtGrpPkgVO);
    }
    
    @Override
    public BigDecimal returnSubPkgCount(ALRT_SUB_PKGVO alrtSubPkgVO) throws DAOException{
	return (BigDecimal) getSqlMap().queryForObject("packageEventMapper.returnSubPkgCount", alrtSubPkgVO);
    }
    
    @Override
    public void deleteSbtParam(GroupPackageCO groupPackageCO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.deleteSbtParam", groupPackageCO);
    }

    @Override
    public void updateSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.updateSubEvt", alrtSubEvtVO);
    }

    @Override
    public void updateGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.updateGrpPkg", alrtGrpPkgVO);
    }

    @Override
    public void updateSubPkg(ALRT_SUB_PKGVO alrtSubPkgVO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.updateSubPkg", alrtSubPkgVO);
    }
    
    @Override
    public void updateAlrtSubEvt(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.updateAlrtSubEvt", alrtSubEvtVO);
    }
    
    @Override
    public void updateAlrtSubEvt1(ALRT_SUB_EVTVO alrtSubEvtVO) throws DAOException
    {
	getSqlMap().queryForObject("packageEventMapper.updateAlrtSubEvt1", alrtSubEvtVO);
    }
    
    @Override
    public void insertAlrtInPkgTmp(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.insertAlrtInPkgTmp", alrtInPkgTmpVO);
    }
    
    @Override
    public void insertAlrtNotInPkgTmp(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.insertAlrtNotInPkgTmp", alrtNotInPkgTmpVO);
    }
    
    @Override
    public void deleteAlrtInPkgTmp() throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtInPkgTmp", null);
    }
    
    @Override
    public void deleteAlrtNotInPkgTmp() throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtNotInPkgTmp", null);
    }
    
    @Override
    public void deleteAlrtInPkgTmpById(ALRT_NOT_IN_PKG_TMPVO alrtNotInPkgTmpVO) throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtInPkgTmpById", alrtNotInPkgTmpVO);
    }
    
    @Override
    public void deleteAlrtNotInPkgTmpById(ALRT_IN_PKG_TMPVO alrtInPkgTmpVO) throws DAOException{
	getSqlMap().queryForObject("packageEventMapper.deleteAlrtNotInPkgTmpById", alrtInPkgTmpVO);
    }
    
    @Override
    public ArrayList<ALRT_IN_PKG_TMPVO> getAlrtInPkgTmp (PackageEventCO packageEventCO) throws DAOException{
	return (ArrayList<ALRT_IN_PKG_TMPVO>) getSqlMap().queryForList("packageEventMapper.getAlrtInPkgTmp", packageEventCO);
    }
    
    @Override
    public ArrayList<ALRT_NOT_IN_PKG_TMPVO> getAlrtNotInPkgTmp (PackageEventCO packageEventCO) throws DAOException{
	return (ArrayList<ALRT_NOT_IN_PKG_TMPVO>) getSqlMap().queryForList("packageEventMapper.getAlrtNotInPkgTmp", packageEventCO);
    }
    
    @Override
    public ArrayList<BigDecimal> getAlrtInPkg (PackageEventCO packageEventCO) throws DAOException{
	return (ArrayList<BigDecimal>) getSqlMap().queryForList("packageEventMapper.getAlrtInPkg", packageEventCO);
    }

	@Override
	public Integer updateSubscriptionsByPackageId(PackageEventCO packageEventCO) throws DAOException 
	{
		return getSqlMap().update("packageEventMapper.updateSubscriptionsByPackageId", packageEventCO);
	}
}
