package com.path.alert.vo.statusmngmnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntCO.java used to
 */
public class StatusMngmntCO extends BaseVO {

	private String status;
	private String statuschck;
	private String subDescription;
	private String sublastname;
	private String alrtSubEvtRelTypeDesc; // 935 //subscriber type u,c,o,a
	private String alrtSubTypeDesc; // 933 //subscription type all,se,gp ...
	private String alrtEvtTypeDesc; // 936 event type f

	private String alrtevtModeTypeDesc; // 937 event mode mail,sms ,both
	private String statusmodeTypeDesc;
	private List<StatusMngmntCO> statusGridList = new ArrayList<>();
	private String statusGridListString;
	private String groupEventListString;
	private String groupPkgListString;
	private String subPkgListString;
	private String subevtListString;
	private String raRelType;
	private String alrtSubId;
	private String raRelId;
	private BigDecimal ldSubId;

	private ALRT_EVTVO alrt_evtvo;
	private ALRT_SUB_EVTVO alrt_sub_evtvo;
	private ALRT_SUBVO alrt_subvo;
	private ALRT_CONTROLVO alert_controlVO;
	private ALRT_PKGVO alert_pkgVO;
	private ALRT_SUB_PKGVO alertSubPkgVO;
	private ALRT_GRP_PKGVO alertGrpPkgVO;
	private ALRT_GRPVO alertGrpVO;
	private ALRT_EVT_GRPVO alertEvtGrpVO;

	private BigDecimal pkgGroupId;
	private BigDecimal groupPkgId;

	private String userId;
	private Date runningDate;

	BigDecimal liCif, liSubCif, liActive, liEvt, liCompcode, liNotified, liCentralized;

	String lsMode, lsSubEng, lsSubArab, lsMsgEng, lsMsgArab, lsSubType, lsLang, lsMail, lsMobile, lsUsrId;
	String lsFlag, lsEvt;

	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
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

	public ALRT_EVTVO getAlrt_evtvo() {
		return alrt_evtvo;
	}

	public void setAlrt_evtvo(ALRT_EVTVO alrt_evtvo) {
		this.alrt_evtvo = alrt_evtvo;
	}

	public ALRT_SUB_EVTVO getAlrt_sub_evtvo() {
		return alrt_sub_evtvo;
	}

	public void setAlrt_sub_evtvo(ALRT_SUB_EVTVO alrt_sub_evtvo) {
		this.alrt_sub_evtvo = alrt_sub_evtvo;
	}

	public ALRT_SUBVO getAlrt_subvo() {
		return alrt_subvo;
	}

	public void setAlrt_subvo(ALRT_SUBVO alrt_subvo) {
		this.alrt_subvo = alrt_subvo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatuschck() {
		return statuschck;
	}

	public void setStatuschck(String statuschck) {
		this.statuschck = statuschck;
	}

	public String getAlrtSubEvtRelTypeDesc() {
		return alrtSubEvtRelTypeDesc;
	}

	public void setAlrtSubEvtRelTypeDesc(String alrtSubEvtRelTypeDesc) {
		this.alrtSubEvtRelTypeDesc = alrtSubEvtRelTypeDesc;
	}

	public String getAlrtSubTypeDesc() {
		return alrtSubTypeDesc;
	}

	public void setAlrtSubTypeDesc(String alrtSubTypeDesc) {
		this.alrtSubTypeDesc = alrtSubTypeDesc;
	}

	public String getAlrtEvtTypeDesc() {
		return alrtEvtTypeDesc;
	}

	public void setAlrtEvtTypeDesc(String alrtEvtTypeDesc) {
		this.alrtEvtTypeDesc = alrtEvtTypeDesc;
	}

	public String getAlrtevtModeTypeDesc() {
		return alrtevtModeTypeDesc;
	}

	public void setAlrtevtModeTypeDesc(String alrtevtModeTypeDesc) {
		this.alrtevtModeTypeDesc = alrtevtModeTypeDesc;
	}

	public List<StatusMngmntCO> getStatusGridList() {
		return statusGridList;
	}

	public void setStatusGridList(List<StatusMngmntCO> statusGridList) {
		this.statusGridList = statusGridList;
	}

	public String getStatusGridListString() {
		return statusGridListString;
	}

	public void setStatusGridListString(String statusGridListString) {
		this.statusGridListString = statusGridListString;
	}

	public String getStatusmodeTypeDesc() {
		return statusmodeTypeDesc;
	}

	public void setStatusmodeTypeDesc(String statusmodeTypeDesc) {
		this.statusmodeTypeDesc = statusmodeTypeDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRunningDate() {
		return runningDate;
	}

	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}

	public String getRaRelId() {
		return raRelId;
	}

	public void setRaRelId(String raRelId) {
		this.raRelId = raRelId;
	}

	public BigDecimal getLiCif() {
		return liCif;
	}

	public void setLiCif(BigDecimal liCif) {
		this.liCif = liCif;
	}

	public BigDecimal getLiSubCif() {
		return liSubCif;
	}

	public void setLiSubCif(BigDecimal liSubCif) {
		this.liSubCif = liSubCif;
	}

	public BigDecimal getLiActive() {
		return liActive;
	}

	public void setLiActive(BigDecimal liActive) {
		this.liActive = liActive;
	}

	public BigDecimal getLiEvt() {
		return liEvt;
	}

	public void setLiEvt(BigDecimal liEvt) {
		this.liEvt = liEvt;
	}

	public BigDecimal getLiCompcode() {
		return liCompcode;
	}

	public void setLiCompcode(BigDecimal liCompcode) {
		this.liCompcode = liCompcode;
	}

	public BigDecimal getLiNotified() {
		return liNotified;
	}

	public void setLiNotified(BigDecimal liNotified) {
		this.liNotified = liNotified;
	}

	public BigDecimal getLiCentralized() {
		return liCentralized;
	}

	public void setLiCentralized(BigDecimal liCentralized) {
		this.liCentralized = liCentralized;
	}

	public String getLsMode() {
		return lsMode;
	}

	public void setLsMode(String lsMode) {
		this.lsMode = lsMode;
	}

	public String getLsSubEng() {
		return lsSubEng;
	}

	public void setLsSubEng(String lsSubEng) {
		this.lsSubEng = lsSubEng;
	}

	public String getLsSubArab() {
		return lsSubArab;
	}

	public void setLsSubArab(String lsSubArab) {
		this.lsSubArab = lsSubArab;
	}

	public String getLsMsgEng() {
		return lsMsgEng;
	}

	public void setLsMsgEng(String lsMsgEng) {
		this.lsMsgEng = lsMsgEng;
	}

	public String getLsMsgArab() {
		return lsMsgArab;
	}

	public void setLsMsgArab(String lsMsgArab) {
		this.lsMsgArab = lsMsgArab;
	}

	public String getLsSubType() {
		return lsSubType;
	}

	public void setLsSubType(String lsSubType) {
		this.lsSubType = lsSubType;
	}

	public String getLsLang() {
		return lsLang;
	}

	public void setLsLang(String lsLang) {
		this.lsLang = lsLang;
	}

	public String getLsMail() {
		return lsMail;
	}

	public void setLsMail(String lsMail) {
		this.lsMail = lsMail;
	}

	public String getLsMobile() {
		return lsMobile;
	}

	public void setLsMobile(String lsMobile) {
		this.lsMobile = lsMobile;
	}

	public String getLsUsrId() {
		return lsUsrId;
	}

	public void setLsUsrId(String lsUsrId) {
		this.lsUsrId = lsUsrId;
	}

	public String getLsFlag() {
		return lsFlag;
	}

	public void setLsFlag(String lsFlag) {
		this.lsFlag = lsFlag;
	}

	public String getLsEvt() {
		return lsEvt;
	}

	public void setLsEvt(String lsEvt) {
		this.lsEvt = lsEvt;
	}

	public ALRT_CONTROLVO getAlert_controlVO() {
		return alert_controlVO;
	}

	public void setAlert_controlVO(ALRT_CONTROLVO alert_controlVO) {
		this.alert_controlVO = alert_controlVO;
	}

	public BigDecimal getLdSubId() {
		return ldSubId;
	}

	public void setLdSubId(BigDecimal ldSubId) {
		this.ldSubId = ldSubId;
	}

	public String getRaRelType() {
		return raRelType;
	}

	public void setRaRelType(String raRelType) {
		this.raRelType = raRelType;
	}

	public String getSubDescription() {
		return subDescription;
	}

	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}

	public String getSublastname() {
		return sublastname;
	}

	public void setSublastname(String sublastname) {
		this.sublastname = sublastname;
	}

	public String getAlrtSubId() {
		return alrtSubId;
	}

	public void setAlrtSubId(String alrtSubId) {
		this.alrtSubId = alrtSubId;
	}

	public ALRT_PKGVO getAlert_pkgVO() {
		return alert_pkgVO;
	}

	public void setAlert_pkgVO(ALRT_PKGVO alert_pkgVO) {
		this.alert_pkgVO = alert_pkgVO;
	}

	public ALRT_SUB_PKGVO getAlertSubPkgVO() {
		return alertSubPkgVO;
	}

	public void setAlertSubPkgVO(ALRT_SUB_PKGVO alertSubPkgVO) {
		this.alertSubPkgVO = alertSubPkgVO;
	}

	public ALRT_GRP_PKGVO getAlertGrpPkgVO() {
		return alertGrpPkgVO;
	}

	public void setAlertGrpPkgVO(ALRT_GRP_PKGVO alertGrpPkgVO) {
		this.alertGrpPkgVO = alertGrpPkgVO;
	}

	public ALRT_GRPVO getAlertGrpVO() {
		return alertGrpVO;
	}

	public void setAlertGrpVO(ALRT_GRPVO alertGrpVO) {
		this.alertGrpVO = alertGrpVO;
	}

	public BigDecimal getPkgGroupId() {
		return pkgGroupId;
	}

	public void setPkgGroupId(BigDecimal pkgGroupId) {
		this.pkgGroupId = pkgGroupId;
	}

	public BigDecimal getGroupPkgId() {
		return groupPkgId;
	}

	public void setGroupPkgId(BigDecimal groupPkgId) {
		this.groupPkgId = groupPkgId;
	}

	public String getGroupEventListString() {
		return groupEventListString;
	}

	public void setGroupEventListString(String groupEventListString) {
		this.groupEventListString = groupEventListString;
	}

	public String getGroupPkgListString() {
		return groupPkgListString;
	}

	public void setGroupPkgListString(String groupPkgListString) {
		this.groupPkgListString = groupPkgListString;
	}

	public String getSubPkgListString() {
		return subPkgListString;
	}

	public void setSubPkgListString(String subPkgListString) {
		this.subPkgListString = subPkgListString;
	}

	public String getSubevtListString() {
		return subevtListString;
	}

	public void setSubevtListString(String subevtListString) {
		this.subevtListString = subevtListString;
	}

	public ALRT_EVT_GRPVO getAlertEvtGrpVO() {
		return alertEvtGrpVO;
	}

	public void setAlertEvtGrpVO(ALRT_EVT_GRPVO alertEvtGrpVO) {
		this.alertEvtGrpVO = alertEvtGrpVO;
	}

}
