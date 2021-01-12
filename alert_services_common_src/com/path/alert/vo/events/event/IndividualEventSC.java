package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_TAGSVO;
import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class IndividualEventSC extends GridParamsSC {
	private String status;
	private String ivCrud;
	private BigDecimal lovType;
	private BigDecimal evtType;
	private BigDecimal modeType;
	private BigDecimal periodType;
	private BigDecimal dayinmonth;
	private  BigDecimal fixedOperator;
	private String langCode;
	private BigDecimal eventID;
	private BigDecimal fixedCode;
	private BigDecimal fixedEventId;
	private String pageRef;
	private String userName;
	private BigDecimal companyCode;
	private BigDecimal branchCode;
	private String currAppName;
	private BigDecimal control;
	private ALRT_EVTVO alrtEvtVO = new ALRT_EVTVO();
	private ALRT_TAGSVO alrtTagsVO = new ALRT_TAGSVO();
	private String operatorDesc;
	private String toValue;
	private String fromValue;
	private BigDecimal centralized;
	private String haschanges;
	private BigDecimal priorityType;
	private String eventType;
	private String commType;
	private String appName;
	
	
	private BigDecimal reportId;
	private BigDecimal queryId;
	private BigDecimal oldQueryId;
	private String query;
	private String isCustomYN;
	
	private String emailCommunicationType;
	private String smsCommunicationType;
	private String omniInboxCommunicationType;
	
	private String reportAttachmentParameters;
	private String eventEnglishDescription;
	private BigDecimal[] emailReportArray;
	private BigDecimal reportAttachmentId;
	private String lookupOf;
	
	private String columnType;
	private BigDecimal paramColumnType;
	private BigDecimal fixedColumnId;
	private BigDecimal packageId;
	private String reportRef;
	private String profType;
	
	private String language;
	private String eventStaticMessageDFHidden;
    private String eventStaticMessageARHidden;
    private String eventStaticMessageENHidden;
    private String eventStaticMessageFRHidden;
    private String eventStaticMessageRUHidden;
    private String eventStaticMessageTKHidden;
    private String eventStaticMessageFAHidden;
    private String queryColumnJson;
    
    private BigDecimal communicationModeLovType;
	
	public BigDecimal getPackageId() {
		return packageId;
	}
	public void setPackageId(BigDecimal packageId) {
		this.packageId = packageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public BigDecimal getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(BigDecimal companyCode) {
		this.companyCode = companyCode;
	}
	public BigDecimal getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}
	public String getCurrAppName() {
		return currAppName;
	}
	public void setCurrAppName(String currAppName) {
		this.currAppName = currAppName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIvCrud() {
		return ivCrud;
	}
	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}
	public BigDecimal getLovType() {
		return lovType;
	}
	public void setLovType(BigDecimal lovType) {
		this.lovType = lovType;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public BigDecimal getEventID() {
		return eventID;
	}
	public void setEventID(BigDecimal eventID) {
		this.eventID = eventID;
	}
	public String getPageRef() {
		return pageRef;
	}
	public void setPageRef(String pageRef) {
		this.pageRef = pageRef;
	}

	public BigDecimal getEvtType() {
		return evtType;
	}
	public void setEvtType(BigDecimal evtType) {
		this.evtType = evtType;
	}
	public BigDecimal getModeType() {
		return modeType;
	}
	public void setModeType(BigDecimal modeType) {
		this.modeType = modeType;
	}
	
	public BigDecimal getFixedOperator() {
		return fixedOperator;
	}
	public void setFixedOperator(BigDecimal fixedOperator) {
		this.fixedOperator = fixedOperator;
	}
	public ALRT_EVTVO getAlrtEvtVO() {
		return alrtEvtVO;
	}
	public void setAlrtEvtVO(ALRT_EVTVO alrtEvtVO) {
		this.alrtEvtVO = alrtEvtVO;
	}
	public BigDecimal getControl() {
		return control;
	}
	public void setControl(BigDecimal control) {
		this.control = control;
	}
	public ALRT_TAGSVO getAlrtTagsVO() {
		return alrtTagsVO;
	}
	public void setAlrtTagsVO(ALRT_TAGSVO alrtTagsVO) {
		this.alrtTagsVO = alrtTagsVO;
	}
	public String getOperatorDesc() {
		return operatorDesc;
	}
	public void setOperatorDesc(String operatorDesc) {
		this.operatorDesc = operatorDesc;
	}
	public String getToValue() {
		return toValue;
	}
	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
	public String getFromValue() {
		return fromValue;
	}
	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}
	public BigDecimal getCentralized() {
		return centralized;
	}
	public void setCentralized(BigDecimal centralized) {
		this.centralized = centralized;
	}
	public BigDecimal getPeriodType() {
		return periodType;
	}
	public void setPeriodType(BigDecimal periodType) {
		this.periodType = periodType;
	}
	public BigDecimal getDayinmonth() {
		return dayinmonth;
	}
	public void setDayinmonth(BigDecimal dayinmonth) {
		this.dayinmonth = dayinmonth;
	}
	public BigDecimal getFixedCode() {
		return fixedCode;
	}
	public void setFixedCode(BigDecimal fixedCode) {
		this.fixedCode = fixedCode;
	}
	public BigDecimal getFixedEventId() {
		return fixedEventId;
	}
	public void setFixedEventId(BigDecimal fixedEventId) {
		this.fixedEventId = fixedEventId;
	}
	public String getHaschanges() {
		return haschanges;
	}
	public void setHaschanges(String haschanges) {
		this.haschanges = haschanges;
	}
	public BigDecimal getPriorityType() {
		return priorityType;
	}
	public void setPriorityType(BigDecimal priorityType) {
		this.priorityType = priorityType;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public BigDecimal getQueryId() {
		return queryId;
	}
	public void setQueryId(BigDecimal queryId) {
		this.queryId = queryId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getIsCustomYN() {
		return isCustomYN;
	}
	public void setIsCustomYN(String isCustomYN) {
		this.isCustomYN = isCustomYN;
	}
	public BigDecimal getReportId() {
		return reportId;
	}
	public void setReportId(BigDecimal reportId) {
		this.reportId = reportId;
	}
	public String getEmailCommunicationType() {
		return emailCommunicationType;
	}
	public String getSmsCommunicationType() {
		return smsCommunicationType;
	}
	public void setEmailCommunicationType(String emailCommunicationType) {
		this.emailCommunicationType = emailCommunicationType;
	}
	public void setSmsCommunicationType(String smsCommunicationType) {
		this.smsCommunicationType = smsCommunicationType;
	}
	public String getReportAttachmentParameters() {
		return reportAttachmentParameters;
	}
	public void setReportAttachmentParameters(String reportAttachmentParameters) {
		this.reportAttachmentParameters = reportAttachmentParameters;
	}
	public String getEventEnglishDescription() {
		return eventEnglishDescription;
	}
	public void setEventEnglishDescription(String eventEnglishDescription) {
		this.eventEnglishDescription = eventEnglishDescription;
	}
	public String getCommType()
	{
	    return commType;
	}
	public void setCommType(String commType)
	{
	    this.commType = commType;
	}
	public String getOmniInboxCommunicationType() {
		return omniInboxCommunicationType;
	}
	public void setOmniInboxCommunicationType(String omniInboxCommunicationType) {
		this.omniInboxCommunicationType = omniInboxCommunicationType;
	}
	public BigDecimal[] getEmailReportArray() {
		return emailReportArray;
	}
	public void setEmailReportArray(BigDecimal[] emailReportArray) {
		this.emailReportArray = emailReportArray;
	}
	public BigDecimal getReportAttachmentId() {
		return reportAttachmentId;
	}
	public void setReportAttachmentId(BigDecimal reportAttachmentId) {
		this.reportAttachmentId = reportAttachmentId;
	}
	public String getLookupOf() {
		return lookupOf;
	}
	public void setLookupOf(String lookupOf) {
		this.lookupOf = lookupOf;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public BigDecimal getFixedColumnId() {
		return fixedColumnId;
	}
	public void setFixedColumnId(BigDecimal fixedColumnId) {
		this.fixedColumnId = fixedColumnId;
	}
	public BigDecimal getParamColumnType() {
		return paramColumnType;
	}
	public void setParamColumnType(BigDecimal paramColumnType) {
		this.paramColumnType = paramColumnType;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getProfType() {
		return profType;
	}
	public void setProfType(String profType) {
		this.profType = profType;
	}
	public String getReportRef() {
		return reportRef;
	}
	public void setReportRef(String reportRef) {
		this.reportRef = reportRef;
	}
	public BigDecimal getOldQueryId() {
		return oldQueryId;
	}
	public void setOldQueryId(BigDecimal oldQueryId) {
		this.oldQueryId = oldQueryId;
	}
	public String getEventStaticMessageARHidden() {
		return eventStaticMessageARHidden;
	}
	public String getEventStaticMessageENHidden() {
		return eventStaticMessageENHidden;
	}
	public String getEventStaticMessageFRHidden() {
		return eventStaticMessageFRHidden;
	}
	public String getEventStaticMessageRUHidden() {
		return eventStaticMessageRUHidden;
	}
	public String getEventStaticMessageTKHidden() {
		return eventStaticMessageTKHidden;
	}
	public String getEventStaticMessageFAHidden() {
		return eventStaticMessageFAHidden;
	}
	public void setEventStaticMessageARHidden(String eventStaticMessageARHidden) {
		this.eventStaticMessageARHidden = eventStaticMessageARHidden;
	}
	public void setEventStaticMessageENHidden(String eventStaticMessageENHidden) {
		this.eventStaticMessageENHidden = eventStaticMessageENHidden;
	}
	public void setEventStaticMessageFRHidden(String eventStaticMessageFRHidden) {
		this.eventStaticMessageFRHidden = eventStaticMessageFRHidden;
	}
	public void setEventStaticMessageRUHidden(String eventStaticMessageRUHidden) {
		this.eventStaticMessageRUHidden = eventStaticMessageRUHidden;
	}
	public void setEventStaticMessageTKHidden(String eventStaticMessageTKHidden) {
		this.eventStaticMessageTKHidden = eventStaticMessageTKHidden;
	}
	public void setEventStaticMessageFAHidden(String eventStaticMessageFAHidden) {
		this.eventStaticMessageFAHidden = eventStaticMessageFAHidden;
	}
	public String getEventStaticMessageDFHidden() {
		return eventStaticMessageDFHidden;
	}
	public void setEventStaticMessageDFHidden(String eventStaticMessageDFHidden) {
		this.eventStaticMessageDFHidden = eventStaticMessageDFHidden;
	}
	public String getLanguage() {
		return language;
	}
	public String getQueryColumnJson() {
		return queryColumnJson;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setQueryColumnJson(String queryColumnJson) {
		this.queryColumnJson = queryColumnJson;
	}
	public BigDecimal getCommunicationModeLovType() {
		return communicationModeLovType;
	}
	public void setCommunicationModeLovType(BigDecimal communicationModeLovType) {
		this.communicationModeLovType = communicationModeLovType;
	}
}