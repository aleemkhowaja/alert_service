package com.path.alert.dao.reportquery;

import java.math.BigDecimal;
import java.util.List;

import com.path.alert.vo.reportquery.ReportQueryCO;
import com.path.alert.vo.reportquery.ReportQuerySC;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryDAO.java used to
 */
public interface ReportQueryDAO
{
    public int returnReportQueryListCount(ReportQuerySC criteria) throws DAOException;
    public List<ReportQueryCO> returnReportQueryList(ReportQuerySC criteria) throws DAOException;
    public ReportQueryCO retrieveSelecetdQueryId(ReportQuerySC sc) throws DAOException;
    public int getQueriesCount(ReportQuerySC sc) throws DAOException;
    public List<IRP_AD_HOC_QUERYVO> getQueriesList(ReportQuerySC sc) throws DAOException;
    public ReportQueryCO returnQueryById(BigDecimal queryId) throws DAOException;
    public int returnReportQueryArgCount(ReportQuerySC sc)throws DAOException;
    public List<ReportQueryCO> returnReportQueryArgList(ReportQuerySC sc) throws DAOException;
    public int returnReportQueryId() throws DAOException;
}