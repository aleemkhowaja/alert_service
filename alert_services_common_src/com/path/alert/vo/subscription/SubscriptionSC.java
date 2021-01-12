package com.path.alert.vo.subscription;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class SubscriptionSC extends GridParamsSC {
	private String langCode;
	private String appName;
	private String progRef;
	private BigDecimal eventTypeLovId;
	private BigDecimal eventModeLovId;
	private BigDecimal suspendedLovType;
	private BigDecimal subTypeLovId;
	private String type;
	private BigDecimal lineNumber;
	private BigDecimal subStatus;
	private BigDecimal evt_id;
	private BigDecimal fixedEventId;
	private String gridType;
	private BigDecimal SUB_ID;
	private BigDecimal GRP_ID;
	private BigDecimal EVT_ID;
	private BigDecimal PKG_ID;
	private List<SubscriptionSC> arrayListSG = new ArrayList<SubscriptionSC>();
	private List<SubscriptionSC> arrayListEP = new ArrayList<SubscriptionSC>();
	private BigDecimal lineNO;
	private String crud;
	private String status,subsStatus,toBeStatus;
	private String toBeStatusBy;
	private String relType;
	private BigDecimal relId;
	private BigDecimal REL_ID;
	private String retreiveCrud;
	private BigDecimal evtLovTypeId;
	private BigDecimal ID;
	//Subscriber Event List required variable
	private BigDecimal cif;
	private BigDecimal subscriberId;
	private String subscribedEvTAndPack;
	private ArrayList<BigDecimal> IDlist;

	private String imalUserId;
	private String channelEndUserId;
	private BigDecimal lovType;	
	// enable or disable based on OMNI flag
	private boolean enable_omni = false;
	private BigDecimal aoError;
	private String aoErrorDesc;
	private String subIds;
	private String evtIds;
	
	private BigDecimal allRowsSE;
	private String allRowsSub;
	private String allRowsEvt;
	private String sessionId;
	
	
	public ArrayList<BigDecimal> getIDlist()
	{
	    return IDlist;
	}

	public void setIDlist(ArrayList<BigDecimal> iDlist)
	{
	    IDlist = iDlist;
	}

	public String getToBeStatus()
	{
	    return toBeStatus;
	}

	public void setToBeStatus(String toBeStatus)
	{
	    this.toBeStatus = toBeStatus;
	}

	public String getSubsStatus()
	{
	    return subsStatus;
	}

	public void setSubsStatus(String subsStatus)
	{
	    this.subsStatus = subsStatus;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public String getRetreiveCrud() {
		return retreiveCrud;
	}

	public void setRetreiveCrud(String retreiveCrud) {
		this.retreiveCrud = retreiveCrud;
	}

	public BigDecimal getREL_ID() {
		return REL_ID;
	}

	public void setREL_ID(BigDecimal rEL_ID) {
		REL_ID = rEL_ID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCrud() {
		return crud;
	}

	public void setCrud(String crud) {
		this.crud = crud;
	}

	public BigDecimal getLineNO() {
		return lineNO;
	}

	public void setLineNO(BigDecimal lineNO) {
		this.lineNO = lineNO;
	}

	public BigDecimal getPKG_ID() {
		return PKG_ID;
	}

	public void setPKG_ID(BigDecimal pKG_ID) {
		PKG_ID = pKG_ID;
	}

	public BigDecimal getEVT_ID() {
		return EVT_ID;
	}

	public void setEVT_ID(BigDecimal eVT_ID) {
		EVT_ID = eVT_ID;
	}

	public BigDecimal getGRP_ID() {
		return GRP_ID;
	}

	public void setGRP_ID(BigDecimal gRP_ID) {
		GRP_ID = gRP_ID;
	}

	public BigDecimal getSUB_ID() {
		return SUB_ID;
	}

	public void setSUB_ID(BigDecimal sUB_ID) {
		SUB_ID = sUB_ID;
	}

	public List<SubscriptionSC> getArrayListSG() {
		return arrayListSG;
	}

	public void setArrayListSG(List<SubscriptionSC> arrayListSG) {
		this.arrayListSG = arrayListSG;
	}
	
	public BigDecimal getEvt_id() {
		return evt_id;
	}

	public void setEvt_id(BigDecimal evt_id) {
		this.evt_id = evt_id;
	}

	public BigDecimal getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(BigDecimal subStatus) {
		this.subStatus = subStatus;
	}

	public BigDecimal getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(BigDecimal lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getSubTypeLovId() {
		return subTypeLovId;
	}

	public void setSubTypeLovId(BigDecimal subTypeLovId) {
		this.subTypeLovId = subTypeLovId;
	}

	public BigDecimal getEventTypeLovId() {
		return eventTypeLovId;
	}

	public void setEventTypeLovId(BigDecimal eventTypeLovId) {
		this.eventTypeLovId = eventTypeLovId;
	}

	public BigDecimal getEventModeLovId() {
		return eventModeLovId;
	}

	public void setEventModeLovId(BigDecimal eventModeLovId) {
		this.eventModeLovId = eventModeLovId;
	}

	public BigDecimal getSuspendedLovType() {
		return suspendedLovType;
	}

	public void setSuspendedLovType(BigDecimal suspendedLovType) {
		this.suspendedLovType = suspendedLovType;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getProgRef() {
		return progRef;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
	}

	public BigDecimal getFixedEventId() {
		return fixedEventId;
	}

	public void setFixedEventId(BigDecimal fixedEventId) {
		this.fixedEventId = fixedEventId;
	}

	public String getGridType() {
		return gridType;
	}

	public void setGridType(String gridType) {
		this.gridType = gridType;
	}

	public BigDecimal getEvtLovTypeId()
	{
	    return evtLovTypeId;
	}

	public void setEvtLovTypeId(BigDecimal evtLovTypeId)
	{
	    this.evtLovTypeId = evtLovTypeId;
	}

	public BigDecimal getCif() {
		return cif;
	}

	public void setCif(BigDecimal cif) {
		this.cif = cif;
	}

	public BigDecimal getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(BigDecimal subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getSubscribedEvTAndPack() {
		return subscribedEvTAndPack;
	}

	public void setSubscribedEvTAndPack(String subscribedEvTAndPack) {
		this.subscribedEvTAndPack = subscribedEvTAndPack;
	}

	public String getImalUserId() {
		return imalUserId;
	}

	public String getChannelEndUserId() {
		return channelEndUserId;
	}

	public void setImalUserId(String imalUserId) {
		this.imalUserId = imalUserId;
	}

	public void setChannelEndUserId(String channelEndUserId) {
		this.channelEndUserId = channelEndUserId;
	}

	public BigDecimal getLovType() {
		return lovType;
	}

	public void setLovType(BigDecimal lovType) {
		this.lovType = lovType;
	}

	public String getToBeStatusBy() {
		return toBeStatusBy;
	}

	public String getRelType() {
		return relType;
	}

	public BigDecimal getRelId() {
		return relId;
	}

	public void setToBeStatusBy(String toBeStatusBy) {
		this.toBeStatusBy = toBeStatusBy;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public void setRelId(BigDecimal relId) {
		this.relId = relId;
	}

	public boolean isEnable_omni() {
		return enable_omni;
	}

	public void setEnable_omni(boolean enable_omni) {
		this.enable_omni = enable_omni;
	}

	/**
	 * @return the aoError
	 */
	public BigDecimal getAoError()
	{
	    return aoError;
	}

	/**
	 * @return the aoErrorDesc
	 */
	public String getAoErrorDesc()
	{
	    return aoErrorDesc;
	}

	/**
	 * @param aoError the aoError to set
	 */
	public void setAoError(BigDecimal aoError)
	{
	    this.aoError = aoError;
	}

	/**
	 * @param aoErrorDesc the aoErrorDesc to set
	 */
	public void setAoErrorDesc(String aoErrorDesc)
	{
	    this.aoErrorDesc = aoErrorDesc;
	}

	/**
	 * @return the subIds
	 */
	public String getSubIds()
	{
	    return subIds;
	}

	/**
	 * @return the evtIds
	 */
	public String getEvtIds()
	{
	    return evtIds;
	}

	/**
	 * @param subIds the subIds to set
	 */
	public void setSubIds(String subIds)
	{
	    this.subIds = subIds;
	}

	/**
	 * @param evtIds the evtIds to set
	 */
	public void setEvtIds(String evtIds)
	{
	    this.evtIds = evtIds;
	}

	/**
	 * @return the arrayListEP
	 */
	public List<SubscriptionSC> getArrayListEP()
	{
	    return arrayListEP;
	}

	/**
	 * @param arrayListEP the arrayListEP to set
	 */
	public void setArrayListEP(List<SubscriptionSC> arrayListEP)
	{
	    this.arrayListEP = arrayListEP;
	}

	/**
	 * @return the allRowsSE
	 */
	public BigDecimal getAllRowsSE()
	{
	    return allRowsSE;
	}

	/**
	 * @param allRowsSE the allRowsSE to set
	 */
	public void setAllRowsSE(BigDecimal allRowsSE)
	{
	    this.allRowsSE = allRowsSE;
	}

	/**
	 * @return the allRowsSub
	 */
	public String getAllRowsSub()
	{
	    return allRowsSub;
	}

	/**
	 * @return the allRowsEvt
	 */
	public String getAllRowsEvt()
	{
	    return allRowsEvt;
	}

	/**
	 * @param allRowsSub the allRowsSub to set
	 */
	public void setAllRowsSub(String allRowsSub)
	{
	    this.allRowsSub = allRowsSub;
	}

	/**
	 * @param allRowsEvt the allRowsEvt to set
	 */
	public void setAllRowsEvt(String allRowsEvt)
	{
	    this.allRowsEvt = allRowsEvt;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId()
	{
	    return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId)
	{
	    this.sessionId = sessionId;
	}
}