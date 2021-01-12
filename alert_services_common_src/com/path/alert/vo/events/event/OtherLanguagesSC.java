package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: suhail.shoukathali
 *
 *          CommonLanguagesSC.java used to
 */
public class OtherLanguagesSC extends GridParamsSC
{
    private BigDecimal lovTypeId;
    
    private BigDecimal tableCode;
    
    private BigDecimal evtId;
    
    public BigDecimal getEvtId() {
		return evtId;
	}

	public void setEvtId(BigDecimal evtId) {
		this.evtId = evtId;
	}

	private String columnKey;
    
    private String columnName;
    
    private String excludeLang;
    
    //for adminparameters
    
    private String parameterId;
    
    private String parameterStatus;
    
    private String columnKeyInclude,codesExclude,codesInclude;
    
    public String getCodesInclude() {
		return codesInclude;
	}

	public void setCodesInclude(String codesInclude) {
		this.codesInclude = codesInclude;
	}

	public String getCodesExclude() 
    {
		return codesExclude;
	}

	public void setCodesExclude(String codesExclude) 
	{
		this.codesExclude = codesExclude;
	}

	public String getColumnKey()
    {
        return columnKey;
    }

    public void setColumnKey(String columnKey)
    {
        this.columnKey = columnKey;
    }

    public BigDecimal getLovTypeId()
    {
        return lovTypeId;
    }

    public void setLovTypeId(BigDecimal lovTypeId)
    {
        this.lovTypeId = lovTypeId;
    }

    public BigDecimal getTableCode()
    {
        return tableCode;
    }

    public void setTableCode(BigDecimal tableCode)
    {
        this.tableCode = tableCode;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getExcludeLang()
    {
        return excludeLang;
    }

    public void setExcludeLang(String excludeLang)
    {
        this.excludeLang = excludeLang;
    }

    public String getParameterId()
    {
        return parameterId;
    }

    public void setParameterId(String parameterId)
    {
        this.parameterId = parameterId;
    }

    public String getParameterStatus()
    {
        return parameterStatus;
    }

    public void setParameterStatus(String parameterStatus)
    {
        this.parameterStatus = parameterStatus;
    }

    public String getColumnKeyInclude()
    {
        return columnKeyInclude;
    }

    public void setColumnKeyInclude(String columnKeyInclude)
    {
        this.columnKeyInclude = columnKeyInclude;
    }

}
