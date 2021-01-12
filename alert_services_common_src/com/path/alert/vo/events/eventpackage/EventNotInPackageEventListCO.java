package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class EventNotInPackageEventListCO extends BaseVO {

	private BigDecimal EVT_ID;
	private String EVT_TYPE;
	private String DESCRIPTION;
	private String EVT_MODE;
	private BigDecimal LINE_NO;
	private String STATUS;
	public BigDecimal getEVT_ID()
	{
	    return EVT_ID;
	}
	public void setEVT_ID(BigDecimal eVT_ID)
	{
	    EVT_ID = eVT_ID;
	}
	public String getEVT_TYPE()
	{
	    return EVT_TYPE;
	}
	public void setEVT_TYPE(String eVT_TYPE)
	{
	    EVT_TYPE = eVT_TYPE;
	}
	public String getDESCRIPTION()
	{
	    return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION)
	{
	    DESCRIPTION = dESCRIPTION;
	}
	public String getEVT_MODE()
	{
	    return EVT_MODE;
	}
	public void setEVT_MODE(String eVT_MODE)
	{
	    EVT_MODE = eVT_MODE;
	}
	public BigDecimal getLINE_NO()
	{
	    return LINE_NO;
	}
	public void setLINE_NO(BigDecimal lINE_NO)
	{
	    LINE_NO = lINE_NO;
	}
	public String getSTATUS()
	{
	    return STATUS;
	}
	public void setSTATUS(String sTATUS)
	{
	    STATUS = sTATUS;
	}
	
	
	
}