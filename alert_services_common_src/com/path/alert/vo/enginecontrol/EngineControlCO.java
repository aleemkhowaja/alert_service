package com.path.alert.vo.enginecontrol;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.ALRT_ENG_MSGVO;
import com.path.dbmaps.vo.ALRT_ENG_REQUESTVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class EngineControlCO extends BaseVO
{

    // Common Use
    private String langCode;
    private BigDecimal lovTypeID;

    // Alert Engine status grid column
    private String IP;
    private String STATUS;  
    private String response;

    // Monitor filter record 
    private Date startDate;
    private Date endDate;
    private BigDecimal eventID;
    private BigDecimal cifNumber;
    private String statusDesc;    
    private BigDecimal subId;
    private String userId;
    private String channelEndUserId;
    
    // Monitoring grid record
    private ALRT_ENG_REQUESTVO alertEngineRequestVO = new ALRT_ENG_REQUESTVO();
    private ALRT_ENG_MSGVO alertEngineMessageVO = new ALRT_ENG_MSGVO();
    
    //
    private ALRT_SUBVO alertSubVo = new ALRT_SUBVO();
    
    private String omniAdminInstalledYN;
    
    

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public BigDecimal getLovTypeID() {
		return lovTypeID;
	}

	public void setLovTypeID(BigDecimal lovTypeID) {
		this.lovTypeID = lovTypeID;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public BigDecimal getEventID() {
		return eventID;
	}

	public void setEventID(BigDecimal eventID) {
		this.eventID = eventID;
	}

	public BigDecimal getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(BigDecimal cifNumber) {
		this.cifNumber = cifNumber;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public ALRT_ENG_REQUESTVO getAlertEngineRequestVO() {
		return alertEngineRequestVO;
	}

	public void setAlertEngineRequestVO(ALRT_ENG_REQUESTVO alertEngineRequestVO) {
		this.alertEngineRequestVO = alertEngineRequestVO;
	}

	public ALRT_ENG_MSGVO getAlertEngineMessageVO() {
		return alertEngineMessageVO;
	}

	public void setAlertEngineMessageVO(ALRT_ENG_MSGVO alertEngineMessageVO) {
		this.alertEngineMessageVO = alertEngineMessageVO;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
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

	public ALRT_SUBVO getAlertSubVo() {
		return alertSubVo;
	}

	public void setAlertSubVo(ALRT_SUBVO alertSubVo) {
		this.alertSubVo = alertSubVo;
	}

	public String getOmniAdminInstalledYN() {
		return omniAdminInstalledYN;
	}

	public void setOmniAdminInstalledYN(String omniAdminInstalledYN) {
		this.omniAdminInstalledYN = omniAdminInstalledYN;
	}

	

}