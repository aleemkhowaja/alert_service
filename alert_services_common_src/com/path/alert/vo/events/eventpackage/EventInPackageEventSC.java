package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class EventInPackageEventSC extends GridParamsSC {

	private BigDecimal pkgId;
	private BigDecimal evtId;
	private BigDecimal lineNo;
	private String evtType;
	private String description;
	private String langCode;
	private BigDecimal evtLovTypeId;
	private String evtMode;
	private List<EventNotInPackageEventListCO> list;
	
	public BigDecimal getPkgId()
	{
	    return pkgId;
	}
	public void setPkgId(BigDecimal pkgId)
	{
	    this.pkgId = pkgId;
	}
	public BigDecimal getEvtId()
	{
	    return evtId;
	}
	public void setEvtId(BigDecimal evtId)
	{
	    this.evtId = evtId;
	}
	public BigDecimal getLineNo()
	{
	    return lineNo;
	}
	public void setLineNo(BigDecimal lineNo)
	{
	    this.lineNo = lineNo;
	}
	public String getEvtType()
	{
	    return evtType;
	}
	public void setEvtType(String evtType)
	{
	    this.evtType = evtType;
	}
	public String getDescription()
	{
	    return description;
	}
	public void setDescription(String description)
	{
	    this.description = description;
	}
	public String getLangCode()
	{
	    return langCode;
	}
	public void setLangCode(String langCode)
	{
	    this.langCode = langCode;
	}
	public BigDecimal getEvtLovTypeId()
	{
	    return evtLovTypeId;
	}
	public void setEvtLovTypeId(BigDecimal evtLovTypeId)
	{
	    this.evtLovTypeId = evtLovTypeId;
	}
	public String getEvtMode() {
		return evtMode;
	}
	public void setEvtMode(String evtMode) {
		this.evtMode = evtMode;
	}
	public List<EventNotInPackageEventListCO> getList() {
		return list;
	}
	public void setList(List<EventNotInPackageEventListCO> list) {
		this.list = list;
	}
	
	
}