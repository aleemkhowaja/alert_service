package com.path.alert.vo.enginecontrol;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class EngineControlSC extends GridParamsSC
{

    // The monitoring grid searching criteria
    private BigDecimal cif;
    private BigDecimal eventID;
    private Date startDate;
    private Date endDate;
    private String status;
    private BigDecimal subId;
    private String userId;
    private String channelEndUserId;

    // Maximum rows limit to return record from database
    private BigDecimal rowsLimit;

    // Common Use
    private String langCode;    
    private BigDecimal lovTypeID;

	public BigDecimal getCif() {
		return cif;
	}

	public void setCif(BigDecimal cif) {
		this.cif = cif;
	}

	public BigDecimal getEventID() {
		return eventID;
	}

	public void setEventID(BigDecimal eventID) {
		this.eventID = eventID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getLovTypeID() {
		return lovTypeID;
	}

	public void setLovTypeID(BigDecimal lovTypeID) {
		this.lovTypeID = lovTypeID;
	}

	public BigDecimal getRowsLimit() {
		return rowsLimit;
	}

	public void setRowsLimit(BigDecimal rowsLimit) {
		this.rowsLimit = rowsLimit;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public BigDecimal getSubId() {
		return subId;
	}

	public void setSubId(BigDecimal subId) {
		this.subId = subId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChannelEndUserId() {
		return channelEndUserId;
	}

	public void setChannelEndUserId(String channelEndUserId) {
		this.channelEndUserId = channelEndUserId;
	}


}