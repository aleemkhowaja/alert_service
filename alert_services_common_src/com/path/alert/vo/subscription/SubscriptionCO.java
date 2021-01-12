package com.path.alert.vo.subscription;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PARAMSETVO;
import com.path.dbmaps.vo.ALRT_FIXED_PARAMVOWithBLOBs;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_COMM_MODE_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

public class SubscriptionCO extends BaseVO {
	private String subscriptionTypeFlag;
	private String subscriptionType;
	private ALRT_GRPVO alrtGrpVO = new ALRT_GRPVO();
	private ALRT_PKGVO alrtPkgVO = new ALRT_PKGVO();
	private ALRT_SUBVO alrtSubVO = new ALRT_SUBVO();
	private ALRT_EVT_COMM_MODEVO alrtEvtCommModeVO = new ALRT_EVT_COMM_MODEVO();
	private ALRT_SUB_EVT_COMM_MODE_EXCLVO alrtSubEvtCommModeExclVO = new ALRT_SUB_EVT_COMM_MODE_EXCLVO();
	private ALRT_SUB_LANGVO alrtSubLangVO = new ALRT_SUB_LANGVO();
	private ALRT_EVTVO alrtEvtVO = new ALRT_EVTVO();
	private ALRT_SUB_EVT_TMPVO alrtSubEvtTmpVO = new ALRT_SUB_EVT_TMPVO();
	private ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
	private ALRT_SUB_PKGVO alrtSubPkgVO = new ALRT_SUB_PKGVO();
	private ALRT_EVT_GRPVO alrtEvtGrpVO = new ALRT_EVT_GRPVO();
	private ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
	private ALRT_EVT_PARAMSETVO alrtEvtParamSetVO = new ALRT_EVT_PARAMSETVO();
	private ALRT_SUBSCRIPTION_PARAMVO alrtSubscriptionParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
	private ALRT_FIXED_PARAMVOWithBLOBs alrtFixedParamVO = new ALRT_FIXED_PARAMVOWithBLOBs();
	private String subDesc;
	private String subEmail;
	private String subMobile;
	private String subIdentification;
	private String eventAddInfo;
	private String statusDesc;
	private String toBeStatusDesc;
	private String fixedFlag;
	private String fixedLabel;
	private String paramType;
	private String fromValueFlag;
	private String COMMUNICATION_TYPE_DESC;
	private BigDecimal fixedEventId;
	private int evtParamCount;
	private ArrayList<LinkedHashMap> ReturnGridRowsData;
	private String allRows;
	ArrayList<SubscriptionCO> subGrpList = new ArrayList<SubscriptionCO>();
	ArrayList<SubscriptionCO> evtPckgList = new ArrayList<SubscriptionCO>();
	private String evtType;
	private String subType;
	private String language;
	private String allRowsSG;
	private String allRowsEP;
	private String gridTypeSG;
	private String gridTypeEP;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private String userID;
	private Date runningDate;
	private String ivCrud;
	private String selSerialNoDet;
	private String allRowsDet;
	private String paramAllRecList;
	private BigDecimal confirmation;
	private BigDecimal errorInsertQueue;
	private int iterator;
	List<SubscriptionCO> ListAllData;
	private BigDecimal relId,pwsRelId;
	private BigDecimal isReject;
	private BigDecimal doAudit;
	private int row;
	private String populatedYN;
	private String allRowsSubscription;
    private ArrayList<SubscriptionCO> subscriptionCOList;
    private ArrayList<String> excludedModesList;
    private String eventCifMultiselectedAccounts;
    private String packageCifMultiselectedAccounts;
    private String eventAccountNumber;
    private String packageAccountNumber,checked,readOnly,customDetails;
    private Boolean isDisableAccounts;
    private BigDecimal cifNo;
    private String cifType;
    
    private BigDecimal subscriberId;
    private BigDecimal packageId;
    private BigDecimal groupId;
    private BigDecimal eventId;
    private List<ALRT_EVT_COMM_MODEVO> alrt_EVT_COMM_MODEVOs = new ArrayList<ALRT_EVT_COMM_MODEVO>();
    private List<ALRT_SUB_ACC_EXCLVO> alrt_SUB_ACC_EXCLVOs = new ArrayList<ALRT_SUB_ACC_EXCLVO>();
    private BigDecimal allRowsSE;
        
    public String getCOMMUNICATION_TYPE_DESC()
    {
		return COMMUNICATION_TYPE_DESC;
	}

	public void setCOMMUNICATION_TYPE_DESC(String cOMMUNICATION_TYPE_DESC) 
	{
		COMMUNICATION_TYPE_DESC = cOMMUNICATION_TYPE_DESC;
	}

	public BigDecimal getPackageId()
    {
		return packageId;
	}

	public void setPackageId(BigDecimal packageId) 
	{
		this.packageId = packageId;
	}

	public BigDecimal getGroupId()
	{
		return groupId;
	}

	public void setGroupId(BigDecimal groupId)
	{
		this.groupId = groupId;
	}

	public BigDecimal getEventId() 
	{
		return eventId;
	}

	public void setEventId(BigDecimal eventId) 
	{
		this.eventId = eventId;
	}

	public BigDecimal getPwsRelId()
    {
        return pwsRelId;
    }

    public void setPwsRelId(BigDecimal pwsRelId)
    {
        this.pwsRelId = pwsRelId;
    }

    public ArrayList<String> getExcludedModesList()
    {
        return excludedModesList;
    }

    public void setExcludedModesList(ArrayList<String> excludedModesList)
    {
        this.excludedModesList = excludedModesList;
    }

    public String getCustomDetails()
    {
        return customDetails;
    }

    public void setCustomDetails(String customDetails)
    {
        this.customDetails = customDetails;
    }

    public String getChecked()
    {
        return checked;
    }

    public void setChecked(String checked)
    {
        this.checked = checked;
    }

    public String getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(String readOnly)
    {
        this.readOnly = readOnly;
    }

    public ALRT_EVT_COMM_MODEVO getAlrtEvtCommModeVO()
    {
	return alrtEvtCommModeVO;
    }

    public void setAlrtEvtCommModeVO(ALRT_EVT_COMM_MODEVO alrtEvtCommModeVO)
    {
	this.alrtEvtCommModeVO = alrtEvtCommModeVO;
    }

    public ALRT_SUB_EVT_COMM_MODE_EXCLVO getAlrtSubEvtCommModeExclVO()
    {
	return alrtSubEvtCommModeExclVO;
    }

    public void setAlrtSubEvtCommModeExclVO(ALRT_SUB_EVT_COMM_MODE_EXCLVO alrtSubEvtCommModeExclVO)
    {
	this.alrtSubEvtCommModeExclVO = alrtSubEvtCommModeExclVO;
    }
    
    public ArrayList<SubscriptionCO> getSubscriptionCOList() {
		return subscriptionCOList;
	}

	public void setSubscriptionCOList(ArrayList<SubscriptionCO> subscriptionCOList) {
		this.subscriptionCOList = subscriptionCOList;
	}

	public String getAllRowsSubscription() {
		return allRowsSubscription;
	}

	public void setAllRowsSubscription(String allRowsSubscription) {
		this.allRowsSubscription = allRowsSubscription;
	}

	public String getPopulatedYN() {
		return populatedYN;
	}

	public void setPopulatedYN(String populatedYN) {
		this.populatedYN = populatedYN;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public ALRT_SUB_PKGVO getAlrtSubPkgVO() {
		return alrtSubPkgVO;
	}

	public void setAlrtSubPkgVO(ALRT_SUB_PKGVO alrtSubPkgVO) {
		this.alrtSubPkgVO = alrtSubPkgVO;
	}

	public ALRT_EVT_GRPVO getAlrtEvtGrpVO() {
		return alrtEvtGrpVO;
	}

	public void setAlrtEvtGrpVO(ALRT_EVT_GRPVO alrtEvtGrpVO) {
		this.alrtEvtGrpVO = alrtEvtGrpVO;
	}

	public ALRT_GRP_PKGVO getAlrtGrpPkgVO() {
		return alrtGrpPkgVO;
	}

	public void setAlrtGrpPkgVO(ALRT_GRP_PKGVO alrtGrpPkgVO) {
		this.alrtGrpPkgVO = alrtGrpPkgVO;
	}

	public BigDecimal getDoAudit() {
		return doAudit;
	}

	public void setDoAudit(BigDecimal doAudit) {
		this.doAudit = doAudit;
	}

	public BigDecimal getIsReject() {
		return isReject;
	}

	public void setIsReject(BigDecimal isReject) {
		this.isReject = isReject;
	}

	public BigDecimal getRelId() {
		return relId;
	}

	public void setRelId(BigDecimal relId) {
		this.relId = relId;
	}

	public List<SubscriptionCO> getListAllData() {
		return ListAllData;
	}

	public void setListAllData(List<SubscriptionCO> listAllData) {
		ListAllData = listAllData;
	}

	public int getIterator() {
		return iterator;
	}

	public void setIterator(int iterator) {
		this.iterator = iterator;
	}

	public BigDecimal getErrorInsertQueue() {
		return errorInsertQueue;
	}

	public void setErrorInsertQueue(BigDecimal errorInsertQueue) {
		this.errorInsertQueue = errorInsertQueue;
	}

	public BigDecimal getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(BigDecimal confirmation) {
		this.confirmation = confirmation;
	}

	public String getParamAllRecList() {
		return paramAllRecList;
	}

	public void setParamAllRecList(String paramAllRecList) {
		this.paramAllRecList = paramAllRecList;
	}

	public String getSelSerialNoDet() {
		return selSerialNoDet;
	}

	public void setSelSerialNoDet(String selSerialNoDet) {
		this.selSerialNoDet = selSerialNoDet;
	}

	public String getAllRowsDet() {
		return allRowsDet;
	}

	public void setAllRowsDet(String allRowsDet) {
		this.allRowsDet = allRowsDet;
	}

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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getRunningDate() {
		return runningDate;
	}

	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}

	public String getIvCrud() {
		return ivCrud;
	}

	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}

	public String getGridTypeSG() {
		return gridTypeSG;
	}

	public void setGridTypeSG(String gridTypeSG) {
		this.gridTypeSG = gridTypeSG;
	}

	public String getGridTypeEP() {
		return gridTypeEP;
	}

	public void setGridTypeEP(String gridTypeEP) {
		this.gridTypeEP = gridTypeEP;
	}

	public String getAllRowsSG() {
		return allRowsSG;
	}

	public void setAllRowsSG(String allRowsSG) {
		this.allRowsSG = allRowsSG;
	}

	public String getAllRowsEP() {
		return allRowsEP;
	}

	public void setAllRowsEP(String allRowsEP) {
		this.allRowsEP = allRowsEP;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getEvtType() {
		return evtType;
	}

	public void setEvtType(String evtType) {
		this.evtType = evtType;
	}

	public String getFromValueFlag() {
		return fromValueFlag;
	}

	public void setFromValueFlag(String fromValueFlag) {
		this.fromValueFlag = fromValueFlag;
	}

	public String getFixedFlag() {
		return fixedFlag;
	}

	public void setFixedFlag(String fixedFlag) {
		this.fixedFlag = fixedFlag;
	}

	public String getFixedLabel() {
		return fixedLabel;
	}

	public void setFixedLabel(String fixedLabel) {
		this.fixedLabel = fixedLabel;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public ALRT_GRPVO getAlrtGrpVO() {
		return alrtGrpVO;
	}

	public void setAlrtGrpVO(ALRT_GRPVO alrtGrpVO) {
		this.alrtGrpVO = alrtGrpVO;
	}

	public ALRT_PKGVO getAlrtPkgVO() {
		return alrtPkgVO;
	}

	public void setAlrtPkgVO(ALRT_PKGVO alrtPkgVO) {
		this.alrtPkgVO = alrtPkgVO;
	}

	public ALRT_SUBVO getAlrtSubVO() {
		return alrtSubVO;
	}

	public void setAlrtSubVO(ALRT_SUBVO alrtSubVO) {
		this.alrtSubVO = alrtSubVO;
	}

	public ALRT_EVTVO getAlrtEvtVO() {
		return alrtEvtVO;
	}

	public void setAlrtEvtVO(ALRT_EVTVO alrtEvtVO) {
		this.alrtEvtVO = alrtEvtVO;
	}

	public ALRT_SUB_EVT_TMPVO getAlrtSubEvtTmpVO() {
		return alrtSubEvtTmpVO;
	}

	public void setAlrtSubEvtTmpVO(ALRT_SUB_EVT_TMPVO alrtSubEvtTmpVO) {
		this.alrtSubEvtTmpVO = alrtSubEvtTmpVO;
	}

	public ALRT_SUB_EVTVO getAlrtSubEvtVO() {
		return alrtSubEvtVO;
	}

	public void setAlrtSubEvtVO(ALRT_SUB_EVTVO alrtSubEvtVO) {
		this.alrtSubEvtVO = alrtSubEvtVO;
	}

	public ALRT_EVT_PARAMSETVO getAlrtEvtParamSetVO() {
		return alrtEvtParamSetVO;
	}

	public void setAlrtEvtParamSetVO(ALRT_EVT_PARAMSETVO alrtEvtParamSetVO) {
		this.alrtEvtParamSetVO = alrtEvtParamSetVO;
	}

	public ALRT_SUBSCRIPTION_PARAMVO getAlrtSubscriptionParamVO() {
		return alrtSubscriptionParamVO;
	}

	public void setAlrtSubscriptionParamVO(ALRT_SUBSCRIPTION_PARAMVO alrtSubscriptionParamVO) {
		this.alrtSubscriptionParamVO = alrtSubscriptionParamVO;
	}

	public String getSubscriptionTypeFlag() {
		return subscriptionTypeFlag;
	}

	public void setSubscriptionTypeFlag(String subscriptionTypeFlag) {
		this.subscriptionTypeFlag = subscriptionTypeFlag;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getSubDesc() {
		return subDesc;
	}

	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}

	public String getSubEmail() {
		return subEmail;
	}

	public void setSubEmail(String subEmail) {
		this.subEmail = subEmail;
	}

	public String getSubMobile() {
		return subMobile;
	}

	public void setSubMobile(String subMobile) {
		this.subMobile = subMobile;
	}

	public String getSubIdentification() {
		return subIdentification;
	}

	public void setSubIdentification(String subIdentification) {
		this.subIdentification = subIdentification;
	}

	public String getEventAddInfo() {
		return eventAddInfo;
	}

	public void setEventAddInfo(String eventAddInfo) {
		this.eventAddInfo = eventAddInfo;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getToBeStatusDesc() {
		return toBeStatusDesc;
	}

	public void setToBeStatusDesc(String toBeStatusDesc) {
		this.toBeStatusDesc = toBeStatusDesc;
	}

	public ALRT_FIXED_PARAMVOWithBLOBs getAlrtFixedParamVO() {
		return alrtFixedParamVO;
	}

	public void setAlrtFixedParamVO(ALRT_FIXED_PARAMVOWithBLOBs alrtFixedParamVO) {
		this.alrtFixedParamVO = alrtFixedParamVO;
	}

	public BigDecimal getFixedEventId() {
		return fixedEventId;
	}

	public void setFixedEventId(BigDecimal fixedEventId) {
		this.fixedEventId = fixedEventId;
	}

	public int getEvtParamCount() {
		return evtParamCount;
	}

	public void setEvtParamCount(int evtParamCount) {
		this.evtParamCount = evtParamCount;
	}

	public ArrayList<LinkedHashMap> getReturnGridRowsData() {
		return ReturnGridRowsData;
	}

	public void setReturnGridRowsData(ArrayList<LinkedHashMap> returnGridRowsData) {
		ReturnGridRowsData = returnGridRowsData;
	}

	public String getAllRows() {
		return allRows;
	}

	public void setAllRows(String allRows) {
		this.allRows = allRows;
	}

	public ArrayList<SubscriptionCO> getSubGrpList() {
		return subGrpList;
	}

	public void setSubGrpList(ArrayList<SubscriptionCO> subGrpList) {
		this.subGrpList = subGrpList;
	}

	public ArrayList<SubscriptionCO> getEvtPckgList() {
		return evtPckgList;
	}

	public void setEvtPckgList(ArrayList<SubscriptionCO> evtPckgList) {
		this.evtPckgList = evtPckgList;
	}

	public String getEventCifMultiselectedAccounts() {
		return eventCifMultiselectedAccounts;
	}

	public String getPackageCifMultiselectedAccounts() {
		return packageCifMultiselectedAccounts;
	}

	public String getEventAccountNumber() {
		return eventAccountNumber;
	}

	public String getPackageAccountNumber() {
		return packageAccountNumber;
	}

	public void setEventCifMultiselectedAccounts(String eventCifMultiselectedAccounts) {
		this.eventCifMultiselectedAccounts = eventCifMultiselectedAccounts;
	}

	public void setPackageCifMultiselectedAccounts(String packageCifMultiselectedAccounts) {
		this.packageCifMultiselectedAccounts = packageCifMultiselectedAccounts;
	}

	public void setEventAccountNumber(String eventAccountNumber) {
		this.eventAccountNumber = eventAccountNumber;
	}

	public void setPackageAccountNumber(String packageAccountNumber) {
		this.packageAccountNumber = packageAccountNumber;
	}

	public Boolean getIsDisableAccounts() {
		return isDisableAccounts;
	}

	public void setIsDisableAccounts(Boolean isDisableAccounts) {
		this.isDisableAccounts = isDisableAccounts;
	}

	public BigDecimal getCifNo() {
		return cifNo;
	}

	public void setCifNo(BigDecimal cifNo) {
		this.cifNo = cifNo;
	}

	public ALRT_SUB_LANGVO getAlrtSubLangVO()
	{
	    return alrtSubLangVO;
	}

	public void setAlrtSubLangVO(ALRT_SUB_LANGVO alrtSubLangVO)
	{
	    this.alrtSubLangVO = alrtSubLangVO;
	}

	public BigDecimal getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(BigDecimal subscriberId) {
		this.subscriberId = subscriberId;
	}

	public List<ALRT_SUB_ACC_EXCLVO> getAlrt_SUB_ACC_EXCLVOs() {
		return alrt_SUB_ACC_EXCLVOs;
	}

	public void setAlrt_SUB_ACC_EXCLVOs(List<ALRT_SUB_ACC_EXCLVO> alrt_SUB_ACC_EXCLVOs) {
		this.alrt_SUB_ACC_EXCLVOs = alrt_SUB_ACC_EXCLVOs;
	}

	public List<ALRT_EVT_COMM_MODEVO> getAlrt_EVT_COMM_MODEVOs() {
		return alrt_EVT_COMM_MODEVOs;
	}

	public void setAlrt_EVT_COMM_MODEVOs(List<ALRT_EVT_COMM_MODEVO> alrt_EVT_COMM_MODEVOs) {
		this.alrt_EVT_COMM_MODEVOs = alrt_EVT_COMM_MODEVOs;
	}

	public String getCifType() {
		return cifType;
	}

	public void setCifType(String cifType) {
		this.cifType = cifType;
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
	
	
}
