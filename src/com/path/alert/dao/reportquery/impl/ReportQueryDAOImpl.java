package com.path.alert.dao.reportquery.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.alert.dao.reportquery.ReportQueryDAO;
import com.path.alert.vo.reportquery.ReportQueryCO;
import com.path.alert.vo.reportquery.ReportQuerySC;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryDAOImpl.java used to
 */
public class ReportQueryDAOImpl extends BaseDAO implements ReportQueryDAO
{
    @Override
    public int returnReportQueryListCount(ReportQuerySC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "reportQueryMapper.resReportQueryListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reportQueryMapper.returnReportQueryListCount", criteria))
		.intValue();
	return nb;
    }

    @Override
    public List<ReportQueryCO> returnReportQueryList(ReportQuerySC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "reportQueryMapper.resReportQueryListMap");
	if(criteria.getSortOrder() == null)
	{
	    criteria.setSortOrder(" ORDER BY REP_QUER_ID");
	}
	if(criteria.getNbRec() == -1)
	{
	    return (List<ReportQueryCO>) getSqlMap().queryForList("reportQueryMapper.returnReportQueryList", criteria);
	}
	else
	{
	    return (List<ReportQueryCO>) getSqlMap().queryForList("reportQueryMapper.returnReportQueryList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public ReportQueryCO retrieveSelecetdQueryId(ReportQuerySC sc) throws DAOException
    {
	return ((ReportQueryCO) getSqlMap().queryForObject("reportQueryMapper.retrieveSelecetdQueryId", sc));
    }

    @Override
    public int getQueriesCount(ReportQuerySC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "reportQueryMapper.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reportQueryMapper.queriesCnt", sc)).intValue();
	return nb;
    }

    @Override
    public List<IRP_AD_HOC_QUERYVO> getQueriesList(ReportQuerySC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "reportQueryMapper.BaseResultMap");
	if(sc.getSortOrder() == null)
	{
	    sc.setSortOrder(" ORDER BY QUERY_ID ");
	}
	return getSqlMap().queryForList("reportQueryMapper.selectQueries", sc, sc.getRecToskip(), sc.getNbRec());
    }

    @Override
    public ReportQueryCO returnQueryById(BigDecimal queryId) throws DAOException 
    {
	return (ReportQueryCO) getSqlMap().queryForObject("reportQueryMapper.selectQueryById", queryId);
    }
    
    @Override
    public int returnReportQueryArgCount(ReportQuerySC sc)throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "reportQueryMapper.resReportQueryArgListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reportQueryMapper.returnReportQueryArgCount", sc))
		.intValue();
	return nb;
    }
    
    @Override
    public List<ReportQueryCO> returnReportQueryArgList(ReportQuerySC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "reportQueryMapper.resReportQueryArgListMap");
	return getSqlMap().queryForList("reportQueryMapper.returnReportQueryArgList", sc, sc.getRecToskip(), sc.getNbRec());
    }
    
    @Override
    public int returnReportQueryId() throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reportQueryMapper.returnReportQueryId",null ))
		.intValue();
	return nb;
    }
}
