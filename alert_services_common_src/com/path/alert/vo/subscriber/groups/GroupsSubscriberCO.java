package com.path.alert.vo.subscriber.groups;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class GroupsSubscriberCO extends BaseVO {

	private ALRT_GRPVO alrtGrpVO = new ALRT_GRPVO();
	private List<SubscriberGroupsSubscriberListCO> subscriberNotInGroupList = new ArrayList<SubscriberGroupsSubscriberListCO>();
	private List<SubscriberInGroupsSubscriberListCO> subscriberInGroupList = new ArrayList<SubscriberInGroupsSubscriberListCO>();
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private Date runningDate;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private Boolean checkFlag;
	private BigDecimal grpId;
	private String relType;
	private BigDecimal subId;
	private String userID;
	
	public String getUserID() 
	{
		return userID;
	}
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
	
	public ALRT_GRPVO getAlrtGrpVO() {
		return alrtGrpVO;
	}
	public void setAlrtGrpVO(ALRT_GRPVO alrtGrpVO) {
		this.alrtGrpVO = alrtGrpVO;
	}
	public List<SubscriberGroupsSubscriberListCO> getSubscriberNotInGroupList() {
		return subscriberNotInGroupList;
	}
	public void setSubscriberNotInGroupList(List<SubscriberGroupsSubscriberListCO> subscriberNotInGroupList) {
		this.subscriberNotInGroupList = subscriberNotInGroupList;
	}
	public List<SubscriberInGroupsSubscriberListCO> getSubscriberInGroupList() {
		return subscriberInGroupList;
	}
	public void setSubscriberInGroupList(List<SubscriberInGroupsSubscriberListCO> subscriberInGroupList) {
		this.subscriberInGroupList = subscriberInGroupList;
	}
	public BigDecimal getCompCode() {
		return compCode;
	}
	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}
	public BigDecimal getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
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
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}
	public Boolean getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(Boolean checkFlag) {
		this.checkFlag = checkFlag;
	}
	public Date getRunningDate() {
		return runningDate;
	}
	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}
	public BigDecimal getGrpId()
	{
	    return grpId;
	}
	public void setGrpId(BigDecimal grpId)
	{
	    this.grpId = grpId;
	}
	public String getRelType()
	{
	    return relType;
	}
	public void setRelType(String relType)
	{
	    this.relType = relType;
	}
	public BigDecimal getSubId()
	{
	    return subId;
	}
	public void setSubId(BigDecimal subId)
	{
	    this.subId = subId;
	}
	
	
}