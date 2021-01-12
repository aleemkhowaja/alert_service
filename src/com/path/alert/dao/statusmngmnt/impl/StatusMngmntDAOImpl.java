package com.path.alert.dao.statusmngmnt.impl;

import java.util.List;

import com.path.alert.dao.statusmngmnt.StatusMngmntDAO;
import com.path.alert.vo.statusmngmnt.StatusMngmntCO;
import com.path.alert.vo.statusmngmnt.StatusMngmntSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntDAOImpl.java used to
 */
public class StatusMngmntDAOImpl extends BaseDAO implements StatusMngmntDAO
{
    /**
     * Method used to return Count of StatusMngmnt
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    @Override
    public int returnStatusMngmntListCount(StatusMngmntSC criteria) throws DAOException
    {
	// criteria.setRelType("SE");
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resStatusMngmntListMap");
	return ((Integer) getSqlMap().queryForObject("statusMngmntMapper.returnStatusMngmntListCount", criteria))
		.intValue();
    }

    /**
     * Method used to return List of StatusMngmnt
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    @Override
    public List returnStatusMngmntList(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resStatusMngmntListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnStatusMngmntList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnStatusMngmntList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public StatusMngmntCO processSuspend(StatusMngmntSC criteria) throws DAOException
    {
	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.returnProcessSuspend", criteria);

    }

    @Override
    public StatusMngmntCO retriveData(StatusMngmntSC criteria) throws DAOException
    {
	// TODO Auto-generated method stub

	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.retriveData", criteria);
    }

    @Override
    public StatusMngmntCO alertevtmethod(StatusMngmntCO stmgmtCO) throws DAOException
    {
	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.alertevtmethod", stmgmtCO);

    }

    @Override
    public StatusMngmntCO alertCentralizedMethod(StatusMngmntCO stmgmtCO) throws DAOException
    {
	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.alertCentralizedMethod", stmgmtCO);
    }

    @Override
    public StatusMngmntCO subscriberDetails(StatusMngmntCO stmgmtCO) throws DAOException
    {
	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.subscriberDetails", stmgmtCO);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.alert.dao.statusmngmnt.StatusMngmntDAO#
     * returnSubscriberPackageListCount(com.path.alert.vo.statusmngmnt.
     * StatusMngmntSC)
     */
    @Override
    public int returnSubscriberPackageListCount(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resSubscriberPackageListMap");
	return ((Integer) getSqlMap().queryForObject("statusMngmntMapper.returnSubscriberPackageListCount", criteria))
		.intValue();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.alert.dao.statusmngmnt.StatusMngmntDAO#
     * returnSubscriberPackageList(com.path.alert.vo.statusmngmnt.
     * StatusMngmntSC)
     */
    @Override
    public List returnSubscriberPackageList(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resSubscriberPackageListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnSubscriberPackageList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnSubscriberPackageList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.alert.dao.statusmngmnt.StatusMngmntDAO#
     * returnGroupPackageListCount(com.path.alert.vo.statusmngmnt.
     * StatusMngmntSC)
     */
    @Override
    public Integer returnGroupPackageListCount(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resGroupPackageListMap");
	return ((Integer) getSqlMap().queryForObject("statusMngmntMapper.returnGroupPackageListCount", criteria))
		.intValue();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.dao.statusmngmnt.StatusMngmntDAO#returnGroupPackageList(
     * com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public List returnGroupPackageList(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resGroupPackageListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnGroupPackageList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnGroupPackageList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.dao.statusmngmnt.StatusMngmntDAO#returnSubscriberEventList
     * (com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public List returnSubscriberEventList(StatusMngmntSC criteria) throws DAOException
    {
	// DAOHelper.fixGridMaps(criteria, getSqlMap(),
	// "statusMngmntMapper.resSubscriberEventListMap");
	// if(criteria.getNbRec() == -1)
	// {
	// return
	// getSqlMap().queryForList("statusMngmntMapper.returnSubscriberEventList",
	// criteria);
	// }
	// else
	// {
	// return
	// getSqlMap().queryForList("statusMngmntMapper.returnSubscriberEventList",
	// criteria,
	// criteria.getRecToskip(), criteria.getNbRec());
	// }

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resStatusMngmntListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnSubscriberEventList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnSubscriberEventList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.alert.dao.statusmngmnt.StatusMngmntDAO#
     * returnsubScriberEventCount(com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public Integer returnsubScriberEventCount(StatusMngmntSC criteria) throws DAOException
    {
	// DAOHelper.fixGridMaps(criteria, getSqlMap(),
	// "statusMngmntMapper.resSubscriberEventListMap");
	// return ((Integer)
	// getSqlMap().queryForObject("statusMngmntMapper.returnSubscriberEventListCount",
	// criteria))
	// .intValue();
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resStatusMngmntListMap");
	return ((Integer) getSqlMap().queryForObject("statusMngmntMapper.returnSubscriberEventListCount", criteria))
		.intValue();
    }

    @Override
    public Integer returnGroupEventListCount(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resGroupEventListMap");
	return ((Integer) getSqlMap().queryForObject("statusMngmntMapper.returnGroupEventListCount", criteria))
		.intValue();
    }

    @Override
    public List returnGroupEventList(StatusMngmntSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "statusMngmntMapper.resGroupEventListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnGroupEventList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("statusMngmntMapper.returnGroupEventList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.dao.statusmngmnt.StatusMngmntDAO#updateAlrtSubEvtStatus(
     * com.path.alert.vo.statusmngmnt.StatusMngmntCO)
     */
    @Override
    public StatusMngmntCO updateAlrtSubEvtStatus(StatusMngmntCO stmgmtco) throws DAOException
    {
	return (StatusMngmntCO) getSqlMap().queryForObject("statusMngmntMapper.updateAlrtSubEvtStatus", stmgmtco);
    }

}
