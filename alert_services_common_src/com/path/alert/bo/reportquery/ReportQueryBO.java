package com.path.alert.bo.reportquery;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.alert.vo.reportquery.ReportQueryCO;
import com.path.alert.vo.reportquery.ReportQuerySC;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryBO.java used to
 */
public interface ReportQueryBO
{
    public int returnReportQueryListCount(ReportQuerySC criteria) throws BaseException;
    public List<ReportQueryCO> returnReportQueryList(ReportQuerySC criteria) throws BaseException;
    public ReportQueryCO retrieveSelecetdQueryId(ReportQuerySC sc) throws BaseException;
    public int getQueriesCount(ReportQuerySC sc) throws BaseException;
    public List<IRP_AD_HOC_QUERYVO> getQueriesList(ReportQuerySC sc) throws BaseException;
    public ReportQueryCO returnQueryById(BigDecimal queryId, boolean generateSyntax) throws BaseException, IOException, ClassNotFoundException;
    public void save(ReportQueryCO reportQueryCO,ArrayList lstMod) throws BaseException;
    public int returnReportQueryArgCount(ReportQuerySC sc) throws BaseException;
    public List<ReportQueryCO> returnReportQueryArgList(ReportQuerySC sc) throws BaseException;
    public void approve(ReportQueryCO reportQueryCO) throws BaseException;
    public void deleteReportQueryId(ReportQueryCO reportQueryCO) throws BaseException;
}