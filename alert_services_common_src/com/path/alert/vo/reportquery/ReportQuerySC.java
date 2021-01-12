package com.path.alert.vo.reportquery;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ReportQuerySC.java used to
 */
public class ReportQuerySC extends GridParamsSC
{
    private String menuRef;
    private BigDecimal queryID;
    private BigDecimal repQueryID;
    private String oldStatus;
    private BigDecimal lovTypeSubsc;
    
    public ReportQuerySC()
    {
		super.setSearchCols(new String[]{"REP_QUER_ID","QUERY_ID","STATUS_DESC", "QUERY_DESC", "SUBSCR_DESC"});
    }
    public String getMenuRef()
    {
        return menuRef;
    }
    public void setMenuRef(String menuRef)
    {
        this.menuRef = menuRef;
    }
    public BigDecimal getQueryID()
    {
        return queryID;
    }
    public void setQueryID(BigDecimal queryID)
    {
        this.queryID = queryID;
    }
    public String getOldStatus()
    {
        return oldStatus;
    }
    public void setOldStatus(String oldStatus)
    {
        this.oldStatus = oldStatus;
    }
    public BigDecimal getLovTypeSubsc()
    {
        return lovTypeSubsc;
    }
    public void setLovTypeSubsc(BigDecimal lovTypeSubsc)
    {
        this.lovTypeSubsc = lovTypeSubsc;
    }
    public BigDecimal getRepQueryID()
    {
        return repQueryID;
    }
    public void setRepQueryID(BigDecimal repQueryID)
    {
        this.repQueryID = repQueryID;
    }
}
