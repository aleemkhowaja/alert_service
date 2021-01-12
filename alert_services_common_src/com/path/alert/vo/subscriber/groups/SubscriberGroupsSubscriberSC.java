package com.path.alert.vo.subscriber.groups;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class SubscriberGroupsSubscriberSC extends GridParamsSC {

	private BigDecimal subId;
	private String subType;
	private String description;
	private String email;
	private String mobile;
	private String langCode;
	private BigDecimal grpId;
	private List<SubscriberGroupsSubscriberListCO> list;
	private String lstSerialNoParam;
	private String status;
	private BigDecimal subscriberLovType;
	// enable or disable based on OMNI flag
	private boolean enable_omni = false;
	private BigDecimal lineNo;
	
	private String coreImalYN;
	
	public BigDecimal getGrpId() {
		return grpId;
	}
	public void setGrpId(BigDecimal grpId) {
		this.grpId = grpId;
	}
	public BigDecimal getSubId() {
		return subId;
	}
	public void setSubId(BigDecimal subId) {
		this.subId = subId;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public List<SubscriberGroupsSubscriberListCO> getList() {
		return list;
	}
	public void setList(List<SubscriberGroupsSubscriberListCO> list) {
		this.list = list;
	}
	public String getLstSerialNoParam()
	{
	    return lstSerialNoParam;
	}
	public void setLstSerialNoParam(String lstSerialNoParam)
	{
	    this.lstSerialNoParam = lstSerialNoParam;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getSubscriberLovType() {
		return subscriberLovType;
	}
	public void setSubscriberLovType(BigDecimal subscriberLovType) {
		this.subscriberLovType = subscriberLovType;
	}
	public boolean isEnable_omni() {
		return enable_omni;
	}
	public void setEnable_omni(boolean enable_omni) {
		this.enable_omni = enable_omni;
	}
	public BigDecimal getLineNo() {
		return lineNo;
	}
	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}
	public String getCoreImalYN() {
		return coreImalYN;
	}
	public void setCoreImalYN(String coreImalYN) {
		this.coreImalYN = coreImalYN;
	}
	
	
}