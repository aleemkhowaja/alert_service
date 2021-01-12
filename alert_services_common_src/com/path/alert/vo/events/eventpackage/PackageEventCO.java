package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ALRT_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class PackageEventCO extends BaseVO {

	private ALRT_PKGVO alrtPkgVO = new ALRT_PKGVO();
	private List<EventNotInPackageEventListCO> eventNotInPackageEventList = new ArrayList<EventNotInPackageEventListCO>();
	private List<EventInPackageEventListCO> eventInPackageEventList = new ArrayList<EventInPackageEventListCO>();
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private Date runningDate;
	private String relType;
	private BigDecimal evtId;
	private BigDecimal pkgId;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private Boolean checkFlag;
	private String userID;
	
	public String getUserID() 
	{
		return userID;
	}
	
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
	
	public ALRT_PKGVO getAlrtPkgVO()
	{
	    return alrtPkgVO;
	}
	public void setAlrtPkgVO(ALRT_PKGVO alrtPkgVO)
	{
	    this.alrtPkgVO = alrtPkgVO;
	}
	public List<EventNotInPackageEventListCO> getEventNotInPackageEventList()
	{
	    return eventNotInPackageEventList;
	}
	public void setEventNotInPackageEventList(List<EventNotInPackageEventListCO> eventNotInPackageEventList)
	{
	    this.eventNotInPackageEventList = eventNotInPackageEventList;
	}
	public List<EventInPackageEventListCO> getEventInPackageEventList()
	{
	    return eventInPackageEventList;
	}
	public void setEventInPackageEventList(List<EventInPackageEventListCO> eventInPackageEventList)
	{
	    this.eventInPackageEventList = eventInPackageEventList;
	}
	public BigDecimal getCompCode()
	{
	    return compCode;
	}
	public void setCompCode(BigDecimal compCode)
	{
	    this.compCode = compCode;
	}
	public BigDecimal getBranchCode()
	{
	    return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode)
	{
	    this.branchCode = branchCode;
	}
	public String getAppName()
	{
	    return appName;
	}
	public void setAppName(String appName)
	{
	    this.appName = appName;
	}
	public String getProgRef()
	{
	    return progRef;
	}
	public void setProgRef(String progRef)
	{
	    this.progRef = progRef;
	}
	public Date getRunningDate()
	{
	    return runningDate;
	}
	public void setRunningDate(Date runningDate)
	{
	    this.runningDate = runningDate;
	}
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
	{
	    return hm;
	}
	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
	{
	    this.hm = hm;
	}
	public Boolean getCheckFlag()
	{
	    return checkFlag;
	}
	public void setCheckFlag(Boolean checkFlag)
	{
	    this.checkFlag = checkFlag;
	}
	public String getRelType()
	{
	    return relType;
	}
	public void setRelType(String relType)
	{
	    this.relType = relType;
	}
	public BigDecimal getEvtId()
	{
	    return evtId;
	}
	public void setEvtId(BigDecimal evtId)
	{
	    this.evtId = evtId;
	}
	public BigDecimal getPkgId()
	{
	    return pkgId;
	}
	public void setPkgId(BigDecimal pkgId)
	{
	    this.pkgId = pkgId;
	}
	
	
}