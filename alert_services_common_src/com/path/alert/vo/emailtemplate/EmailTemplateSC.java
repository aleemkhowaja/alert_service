package com.path.alert.vo.emailtemplate;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateSC.java used to
 */
public class EmailTemplateSC extends GridParamsSC
{
    private String menuRef;
    private String oldStatus;
    private BigDecimal lovTypeSubsc, lovLkTypeId, emailTemplate;

    public EmailTemplateSC()
    {
	super.setSearchCols(new String[] { "TEMPLATE_ID", "TEMPLATE_DESC", "TEMPLATE_FILE_NAME", "STATUS_DESC" });
    }

    public BigDecimal getEmailTemplate()
    {
	return emailTemplate;
    }

    public void setEmailTemplate(BigDecimal emailTemplate)
    {
	this.emailTemplate = emailTemplate;
    }

    public BigDecimal getLovLkTypeId()
    {
	return lovLkTypeId;
    }

    public void setLovLkTypeId(BigDecimal lovLkTypeId)
    {
	this.lovLkTypeId = lovLkTypeId;
    }

    public String getMenuRef()
    {
	return menuRef;
    }

    public void setMenuRef(String menuRef)
    {
	this.menuRef = menuRef;
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
}
