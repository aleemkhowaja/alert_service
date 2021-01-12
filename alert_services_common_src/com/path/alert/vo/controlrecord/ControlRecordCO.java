package com.path.alert.vo.controlrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class ControlRecordCO extends BaseVO {
	// private GEN_LEDGERVO genLedgerVO = new GEN_LEDGERVO();

	// private ArrayList<SmartCO> smartCOList;
	// private BigDecimal code;

	private BigDecimal accRepID;
	private BigDecimal printFlag;
	private BigDecimal activFlag;
	private BigDecimal ActivEvt;
	private BigDecimal reactivFlag;
	private BigDecimal reactivEvt;
	private BigDecimal suspendFlag;
	private BigDecimal suspendEvt;
	private BigDecimal mobileFlag;
	private BigDecimal mobileEvt;
	//private BigDecimal centralizeCore;
	private BigDecimal isRequired;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String appName;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String progRef;
	private int isRTLDir;
	private String id;
	private String name;
	private BigDecimal checkBoxFlag;
	private String lang;
	private ALRT_CONTROLVO alrtCtrlVO = new ALRT_CONTROLVO();
	private List<ALRT_CONTROLVO> alrtCtrlVoList = new ArrayList<ALRT_CONTROLVO>();
	private List<ALRT_CONTROLVO> oldAlrtCtrlVoList = new ArrayList<ALRT_CONTROLVO>();
	private String protocolType;
	private String senderEmail;
	private String ipAddress;
	private String portNumber;
	private String userId;
	private String password;
	private String passwordChanged;
	private BigDecimal emailConfigType;
	private BigDecimal smsConfigType;
	
	public String getPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(String passwordChanged) {
		this.passwordChanged = passwordChanged;
	}
	
	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<ALRT_CONTROLVO> getAlrtCtrlVoList() {
		return alrtCtrlVoList;
	}

	public void setAlrtCtrlVoList(List<ALRT_CONTROLVO> alrtCtrlVoList) {
		this.alrtCtrlVoList = alrtCtrlVoList;
	}

	public ALRT_CONTROLVO getAlrtCtrlVO() {
		return alrtCtrlVO;
	}

	public void setAlrtCtrlVO(ALRT_CONTROLVO alrtCtrlVO) {
		this.alrtCtrlVO = alrtCtrlVO;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public BigDecimal getCheckBoxFlag() {
		return checkBoxFlag;
	}

	public void setCheckBoxFlag(BigDecimal checkBoxFlag) {
		this.checkBoxFlag = checkBoxFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getRequiredHm() {
		return requiredHm;
	}

	public void setRequiredHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredHm) {
		this.requiredHm = requiredHm;
	}

	public BigDecimal getAccRepID() {
		return accRepID;
	}

	public void setAccRepID(BigDecimal accRepID) {
		this.accRepID = accRepID;
	}

	public BigDecimal getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(BigDecimal printFlag) {
		this.printFlag = printFlag;
	}

	public BigDecimal getActivFlag() {
		return activFlag;
	}

	public void setActivFlag(BigDecimal activFlag) {
		this.activFlag = activFlag;
	}

	public BigDecimal getActivEvt() {
		return ActivEvt;
	}

	public void setActivEvt(BigDecimal activEvt) {
		ActivEvt = activEvt;
	}

	public BigDecimal getReactivFlag() {
		return reactivFlag;
	}

	public void setReactivFlag(BigDecimal reactivFlag) {
		this.reactivFlag = reactivFlag;
	}

	public BigDecimal getReactivEvt() {
		return reactivEvt;
	}

	public void setReactivEvt(BigDecimal reactivEvt) {
		this.reactivEvt = reactivEvt;
	}

	public BigDecimal getSuspendFlag() {
		return suspendFlag;
	}

	public void setSuspendFlag(BigDecimal suspendFlag) {
		this.suspendFlag = suspendFlag;
	}

	public BigDecimal getSuspendEvt() {
		return suspendEvt;
	}

	public void setSuspendEvt(BigDecimal suspendEvt) {
		this.suspendEvt = suspendEvt;
	}

	public BigDecimal getMobileFlag() {
		return mobileFlag;
	}

	public void setMobileFlag(BigDecimal mobileFlag) {
		this.mobileFlag = mobileFlag;
	}

	public BigDecimal getMobileEvt() {
		return mobileEvt;
	}

	public void setMobileEvt(BigDecimal mobileEvt) {
		this.mobileEvt = mobileEvt;
	}

	/*public BigDecimal getCentralizeCore() {
		return centralizeCore;
	}

	public void setCentralizeCore(BigDecimal centralizeCore) {
		this.centralizeCore = centralizeCore;
	}*/

	public BigDecimal getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(BigDecimal isRequired) {
		this.isRequired = isRequired;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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

	public String getProgRef() {
		return progRef;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
	}

	public int getIsRTLDir() {
		return isRTLDir;
	}

	public void setIsRTLDir(int isRTLDir) {
		this.isRTLDir = isRTLDir;
	}

	public List<ALRT_CONTROLVO> getOldAlrtCtrlVoList() {
		return oldAlrtCtrlVoList;
	}

	public void setOldAlrtCtrlVoList(List<ALRT_CONTROLVO> oldAlrtCtrlVoList) {
		this.oldAlrtCtrlVoList = oldAlrtCtrlVoList;
	}

	public BigDecimal getEmailConfigType() {
		return emailConfigType;
	}

	public void setEmailConfigType(BigDecimal emailConfigType) {
		this.emailConfigType = emailConfigType;
	}

	public BigDecimal getSmsConfigType() {
		return smsConfigType;
	}

	public void setSmsConfigType(BigDecimal smsConfigType) {
		this.smsConfigType = smsConfigType;
	}

}