package com.path.alert.vo.controlrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class ControlRecordSC extends GridParamsSC {
	private String keyRef;
	private BigDecimal evtID;
	private BigDecimal repID;
	private BigDecimal compCode;
	private String ctrlReference;
	private Integer result;
	private Integer count;
	private String langCode;
	private List<String> ctrlReferenceList  = new ArrayList<String>();
	private String eventType;
	
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getCompCode() {
		return compCode;
	}

	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public String getCtrlReference() {
		return ctrlReference;
	}

	public void setCtrlReference(String ctrlReference) {
		this.ctrlReference = ctrlReference;
	}

	public BigDecimal getRepID() {
		return repID;
	}

	public void setRepID(BigDecimal repID) {
		this.repID = repID;
	}

	public BigDecimal getEvtID() {
		return evtID;
	}

	public void setEvtID(BigDecimal evtID) {
		this.evtID = evtID;
	}
	public String getKeyRef() {
		return keyRef;
	}

	public void setKeyRef(String keyRef) {
		this.keyRef = keyRef;
	}

	public List<String> getCtrlReferenceList() {
		return ctrlReferenceList;
	}

	public void setCtrlReferenceList(List<String> ctrlReferenceList) {
		this.ctrlReferenceList = ctrlReferenceList;
	}
	
	public String getEventType()
	{
	    return eventType;
	}

	public void setEventType(String eventType)
	{
	    this.eventType = eventType;
	}

}
