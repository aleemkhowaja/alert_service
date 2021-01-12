package com.path.alert.vo.reportquery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.ALRT_REPORT_QUERYVO;
import com.path.dbmaps.vo.ALRT_REPORT_QUERY_ARGVO;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.vo.reporting.SQL_OBJECT;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryCO.java used to
 */
public class ReportQueryCO extends IRP_AD_HOC_QUERYVO
{
    private ALRT_REPORT_QUERYVO reportQueryVO = new ALRT_REPORT_QUERYVO();
    private ALRT_REPORT_QUERY_ARGVO reportQueryArgVO = new ALRT_REPORT_QUERY_ARGVO();
    private String queryDesc;
    private String statusDesc;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String appName;
    private String progRef;
    private String userID;
    private Date runningDate;
    private String ivCrud;
    private String language;
    private String argumentName;
    private String qryArgName;
    private SQL_OBJECT sqlObject = new SQL_OBJECT();
    //private String isQryArg;
    private BigDecimal isQryArg;
    private String querySyntax;
    private String UserId;
    private String subscrDesc;
    
    
    private HashMap<String, String> qryColumnsList;

    public String getQueryDesc()
    {
        return queryDesc;
    }

    public void setQueryDesc(String queryDesc)
    {
        this.queryDesc = queryDesc;
    }

    public ALRT_REPORT_QUERYVO getReportQueryVO()
    {
        return reportQueryVO;
    }

    public void setReportQueryVO(ALRT_REPORT_QUERYVO reportQueryVO)
    {
        this.reportQueryVO = reportQueryVO;
    }

    public ALRT_REPORT_QUERY_ARGVO getReportQueryArgVO()
    {
        return reportQueryArgVO;
    }

    public void setReportQueryArgVO(ALRT_REPORT_QUERY_ARGVO reportQueryArgVO)
    {
        this.reportQueryArgVO = reportQueryArgVO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public BigDecimal getCompCode()
    {
        return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getIvCrud()
    {
        return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public HashMap<String, String> getQryColumnsList()
    {
        return qryColumnsList;
    }

    public void setQryColumnsList(HashMap<String, String> qryColumnsList)
    {
        this.qryColumnsList = qryColumnsList;
    }

    public String getQryArgName()
    {
        return qryArgName;
    }

    public void setQryArgName(String qryArgName)
    {
        this.qryArgName = qryArgName;
    }

    public String getArgumentName()
    {
        return argumentName;
    }

    public void setArgumentName(String argumentName)
    {
        this.argumentName = argumentName;
    }

    public String getQuerySyntax()
    {
        return querySyntax;
    }

    public void setQuerySyntax(String querySyntax)
    {
        this.querySyntax = querySyntax;
    }

    public SQL_OBJECT getSqlObject()
    {
        return sqlObject;
    }

    public void setSqlObject(SQL_OBJECT sqlObject)
    {
        this.sqlObject = sqlObject;
    }

    public BigDecimal getIsQryArg()
    {
        return isQryArg;
    }

    public void setIsQryArg(BigDecimal isQryArg)
    {
        this.isQryArg = isQryArg;
    }

    public String getUserId()
    {
        return UserId;
    }

    public void setUserId(String userId)
    {
        UserId = userId;
    }

    public String getSubscrDesc()
    {
        return subscrDesc;
    }

    public void setSubscrDesc(String subscrDesc)
    {
        this.subscrDesc = subscrDesc;
    }
    
}
