package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class EventInPackageEventListCO extends BaseVO {

	private BigDecimal EVT_ID;
	private BigDecimal PKG_ID;
	private BigDecimal LINE_NO;
	private String EVT_TYPE;
	private String DESCRIPTION;
	private String STATUS;
	public BigDecimal getEVT_ID()
	{
	    return EVT_ID;
	}
	public void setEVT_ID(BigDecimal eVT_ID)
	{
	    EVT_ID = eVT_ID;
	}
	public BigDecimal getPKG_ID()
	{
	    return PKG_ID;
	}
	public void setPKG_ID(BigDecimal pKG_ID)
	{
	    PKG_ID = pKG_ID;
	}
	public BigDecimal getLINE_NO()
	{
	    return LINE_NO;
	}
	public void setLINE_NO(BigDecimal lINE_NO)
	{
	    LINE_NO = lINE_NO;
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
	public String getSTATUS()
	{
	    return STATUS;
	}
	public void setSTATUS(String sTATUS)
	{
	    STATUS = sTATUS;
	}
	
	
	
}