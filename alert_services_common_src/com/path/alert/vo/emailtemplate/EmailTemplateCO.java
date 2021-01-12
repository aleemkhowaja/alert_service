package com.path.alert.vo.emailtemplate;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.ALRT_EMAIL_TEMPLATEVOWithBLOBs;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateCO.java used to
 */
public class EmailTemplateCO extends BaseVO
{
    private ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO = new ALRT_EMAIL_TEMPLATEVOWithBLOBs();
    private String statusDesc;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String appName;
    private String progRef;
    private String userID;
    private Date runningDate;
    private String ivCrud;
    private String language;

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

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public ALRT_EMAIL_TEMPLATEVOWithBLOBs getEmailTemplateVO()
    {
	return emailTemplateVO;
    }

    public void setEmailTemplateVO(ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO)
    {
	this.emailTemplateVO = emailTemplateVO;
    }
}
