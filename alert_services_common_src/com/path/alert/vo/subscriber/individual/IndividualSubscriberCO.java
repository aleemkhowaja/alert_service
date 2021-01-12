package com.path.alert.vo.subscriber.individual;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_DETVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMF_ADDRESSVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.smart.SmartCO;

@SuppressWarnings("serial")
public class IndividualSubscriberCO extends BaseVO {

	private ALRT_SUBVO alrtSubVO = new ALRT_SUBVO();
	private ALRT_SUB_LANGVO alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	private ALRT_SUB_DETVO alrtSubDetVO = new ALRT_SUB_DETVO();
	private ALRT_SUB_ACC_EXCLVO alrt_SUB_ACCOUNTSVO = new ALRT_SUB_ACC_EXCLVO();
	private ALRT_SUB_EVT_TMPVO alrtSubEvtTmpVO = new ALRT_SUB_EVT_TMPVO();
	private ALRT_EVTVO alrtEvtVO = new ALRT_EVTVO();
	private CIFVO cifVO = new CIFVO();
	private RIFCTTVO rifCttVO = new RIFCTTVO();
	private USRVO usrVO = new USRVO();
	private AMFVO amfVO = new AMFVO();
	private AMF_ADDRESSVO amfAddressVO = new AMF_ADDRESSVO();
	private String statusDesc;
	private String subscriberType;
	private String addRef;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String emailId;
	private String email;
	private String tel;
	private BigDecimal openMemo;
	private String isValidMobileFrom;
	private BigDecimal isYesNoMessage;
	private String userID;
	private Date runningDate;
	private String ivCrud;
	private String language;
	private String hiddenEMAIL_ID;
	private String hiddenCHARGEABLE;
	private BigDecimal hiddenNB_MSG;
	private String hiddenLANG;
	private String hiddenOLD_MOBILE_PHONE;
	private String hiddenStatus;
	private BigDecimal isReadOnlyDet;
	private String isOpen;
	private BigDecimal raiseApproveConfirmation;
	private String hiddenMOBILE_PHONE;
	private BigDecimal errorInsertQueue;
	
	private String jsonOtherLangArray;
	private String cifAccountsMultiselectArray;
	private String jsonOtherLangBodyArray;
	private String jsonOtherLangSavedArray;
	private String cifType;
	private String cifCountryDesc;
	private BigDecimal emailsCount;
	private BigDecimal mobileNosCount;
	private BigDecimal facebookSocialId;
	private BigDecimal twitterSocialId;
	private String cifCode;

	//Start Wrapper WS required fields
	private String oldEmailIds;
	private List<String> newEmailIds;
	private List<String> deletedEmailIds;
	private String oldMobilePhoneList;
	private List<String> newMobilePhoneList;
	private List<String> deletedMobilePhoneList;
	
	private List otherLanguageList = new ArrayList<>();
	private List newOtherLanguageList = new ArrayList<>();
	private List updateOtherLanguageList = new ArrayList<>();
	private List deleteOtherLanguageList = new ArrayList<>();
	//End Wrapper WS required fields
	
	List accountList = new ArrayList<>();
	List excludedAccountList = new ArrayList<>();
	List excludedPackageAccountList = new ArrayList<>();
	
	//DASI190152 
    private ArrayList<SmartCO> smartCOList = new ArrayList<>();
    
    private Boolean forMultipleSubscriber;
	
	public String getCifCountryDesc() {
		return cifCountryDesc;
	}

	public void setCifCountryDesc(String cifCountryDesc) {
		this.cifCountryDesc = cifCountryDesc;
	}

	public BigDecimal getErrorInsertQueue() {
		return errorInsertQueue;
	}

	public void setErrorInsertQueue(BigDecimal errorInsertQueue) {
		this.errorInsertQueue = errorInsertQueue;
	}

	public String getHiddenMOBILE_PHONE() {
		return hiddenMOBILE_PHONE;
	}

	public void setHiddenMOBILE_PHONE(String hiddenMOBILE_PHONE) {
		this.hiddenMOBILE_PHONE = hiddenMOBILE_PHONE;
	}

	public BigDecimal getRaiseApproveConfirmation() {
		return raiseApproveConfirmation;
	}

	public void setRaiseApproveConfirmation(BigDecimal raiseApproveConfirmation) {
		this.raiseApproveConfirmation = raiseApproveConfirmation;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public BigDecimal getIsReadOnlyDet() {
		return isReadOnlyDet;
	}

	public void setIsReadOnlyDet(BigDecimal isReadOnlyDet) {
		this.isReadOnlyDet = isReadOnlyDet;
	}

	public String getHiddenStatus() {
		return hiddenStatus;
	}

	public void setHiddenStatus(String hiddenStatus) {
		this.hiddenStatus = hiddenStatus;
	}

	public String getHiddenEMAIL_ID() {
		return hiddenEMAIL_ID;
	}

	public void setHiddenEMAIL_ID(String hiddenEMAIL_ID) {
		this.hiddenEMAIL_ID = hiddenEMAIL_ID;
	}

	public String getHiddenCHARGEABLE() {
		return hiddenCHARGEABLE;
	}

	public void setHiddenCHARGEABLE(String hiddenCHARGEABLE) {
		this.hiddenCHARGEABLE = hiddenCHARGEABLE;
	}

	public BigDecimal getHiddenNB_MSG() {
		return hiddenNB_MSG;
	}

	public void setHiddenNB_MSG(BigDecimal hiddenNB_MSG) {
		this.hiddenNB_MSG = hiddenNB_MSG;
	}

	public String getHiddenLANG() {
		return hiddenLANG;
	}

	public void setHiddenLANG(String hiddenLANG) {
		this.hiddenLANG = hiddenLANG;
	}

	public String getHiddenOLD_MOBILE_PHONE() {
		return hiddenOLD_MOBILE_PHONE;
	}

	public void setHiddenOLD_MOBILE_PHONE(String hiddenOLD_MOBILE_PHONE) {
		this.hiddenOLD_MOBILE_PHONE = hiddenOLD_MOBILE_PHONE;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIvCrud() {
		return ivCrud;
	}

	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}

	public Date getRunningDate() {
		return runningDate;
	}

	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public BigDecimal getIsYesNoMessage() {
		return isYesNoMessage;
	}

	public void setIsYesNoMessage(BigDecimal isYesNoMessage) {
		this.isYesNoMessage = isYesNoMessage;
	}

	public String getIsValidMobileFrom() {
		return isValidMobileFrom;
	}

	public void setIsValidMobileFrom(String isValidMobileFrom) {
		this.isValidMobileFrom = isValidMobileFrom;
	}

	public BigDecimal getOpenMemo() {
		return openMemo;
	}

	public void setOpenMemo(BigDecimal openMemo) {
		this.openMemo = openMemo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public ALRT_SUB_DETVO getAlrtSubDetVO() {
		return alrtSubDetVO;
	}

	public void setAlrtSubDetVO(ALRT_SUB_DETVO alrtSubDetVO) {
		this.alrtSubDetVO = alrtSubDetVO;
	}

	public AMF_ADDRESSVO getAmfAddressVO() {
		return amfAddressVO;
	}

	public void setAmfAddressVO(AMF_ADDRESSVO amfAddressVO) {
		this.amfAddressVO = amfAddressVO;
	}

	public AMFVO getAmfVO() {
		return amfVO;
	}

	public void setAmfVO(AMFVO amfVO) {
		this.amfVO = amfVO;
	}

	public USRVO getUsrVO() {
		return usrVO;
	}

	public void setUsrVO(USRVO usrVO) {
		this.usrVO = usrVO;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public RIFCTTVO getRifCttVO() {
		return rifCttVO;
	}

	public void setRifCttVO(RIFCTTVO rifCttVO) {
		this.rifCttVO = rifCttVO;
	}

	public CIFVO getCifVO() {
		return cifVO;
	}

	public void setCifVO(CIFVO cifVO) {
		this.cifVO = cifVO;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}

	public String getProgRef() {
		return progRef;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
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

	public String getAddRef() {
		return addRef;
	}

	public void setAddRef(String addRef) {
		this.addRef = addRef;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public ALRT_SUBVO getAlrtSubVO() {
		return alrtSubVO;
	}

	public void setAlrtSubVO(ALRT_SUBVO alrtSubVO) {
		this.alrtSubVO = alrtSubVO;
	}

	public ALRT_SUB_LANGVO getAlrt_SUB_LANGVO() {
		return alrt_SUB_LANGVO;
	}

	public void setAlrt_SUB_LANGVO(ALRT_SUB_LANGVO alrt_SUB_LANGVO) {
		this.alrt_SUB_LANGVO = alrt_SUB_LANGVO;
	}

	public ALRT_SUB_ACC_EXCLVO getAlrt_SUB_ACCOUNTSVO() {
		return alrt_SUB_ACCOUNTSVO;
	}

	public void setAlrt_SUB_ACCOUNTSVO(ALRT_SUB_ACC_EXCLVO alrt_SUB_ACCOUNTSVO) {
		this.alrt_SUB_ACCOUNTSVO = alrt_SUB_ACCOUNTSVO;
	}

	public String getJsonOtherLangArray() {
		return jsonOtherLangArray;
	}

	public void setJsonOtherLangArray(String jsonOtherLangArray) {
		this.jsonOtherLangArray = jsonOtherLangArray;
	}

	public String getCifAccountsMultiselectArray() {
		return cifAccountsMultiselectArray;
	}

	public void setCifAccountsMultiselectArray(String cifAccountsMultiselectArray) {
		this.cifAccountsMultiselectArray = cifAccountsMultiselectArray;
	}

	public String getJsonOtherLangBodyArray() {
		return jsonOtherLangBodyArray;
	}

	public void setJsonOtherLangBodyArray(String jsonOtherLangBodyArray) {
		this.jsonOtherLangBodyArray = jsonOtherLangBodyArray;
	}

	public String getJsonOtherLangSavedArray() {
		return jsonOtherLangSavedArray;
	}

	public void setJsonOtherLangSavedArray(String jsonOtherLangSavedArray) {
		this.jsonOtherLangSavedArray = jsonOtherLangSavedArray;
	}

	public String getCifType() {
		return cifType;
	}

	public void setCifType(String cifType) {
		this.cifType = cifType;
	}

	public BigDecimal getEmailsCount() {
		return emailsCount;
	}

	public void setEmailsCount(BigDecimal emailsCount) {
		this.emailsCount = emailsCount;
	}

	public BigDecimal getMobileNosCount() {
		return mobileNosCount;
	}

	public void setMobileNosCount(BigDecimal mobileNosCount) {
		this.mobileNosCount = mobileNosCount;
	}

	public BigDecimal getFacebookSocialId() {
		return facebookSocialId;
	}

	public BigDecimal getTwitterSocialId() {
		return twitterSocialId;
	}

	public void setFacebookSocialId(BigDecimal facebookSocialId) {
		this.facebookSocialId = facebookSocialId;
	}

	public void setTwitterSocialId(BigDecimal twitterSocialId) {
		this.twitterSocialId = twitterSocialId;
	}

	public String getCifCode() {
		return cifCode;
	}

	public void setCifCode(String cifCode) {
		this.cifCode = cifCode;
	}

	public List<String> getNewEmailIds() {
		return newEmailIds;
	}

	public List<String> getDeletedEmailIds() {
		return deletedEmailIds;
	}

	public List<String> getNewMobilePhoneList() {
		return newMobilePhoneList;
	}

	public List<String> getDeletedMobilePhoneList() {
		return deletedMobilePhoneList;
	}

	public void setNewEmailIds(List<String> newEmailIds) {
		this.newEmailIds = newEmailIds;
	}

	public void setDeletedEmailIds(List<String> deletedEmailIds) {
		this.deletedEmailIds = deletedEmailIds;
	}

	public void setNewMobilePhoneList(List<String> newMobilePhoneList) {
		this.newMobilePhoneList = newMobilePhoneList;
	}

	public void setDeletedMobilePhoneList(List<String> deletedMobilePhoneList) {
		this.deletedMobilePhoneList = deletedMobilePhoneList;
	}

	public String getOldEmailIds() {
		return oldEmailIds;
	}

	public String getOldMobilePhoneList() {
		return oldMobilePhoneList;
	}

	public void setOldEmailIds(String oldEmailIds) {
		this.oldEmailIds = oldEmailIds;
	}

	public void setOldMobilePhoneList(String oldMobilePhoneList) {
		this.oldMobilePhoneList = oldMobilePhoneList;
	}

	public List getOtherLanguageList() {
		return otherLanguageList;
	}

	public void setOtherLanguageList(List otherLanguageList) {
		this.otherLanguageList = otherLanguageList;
	}

	public List getNewOtherLanguageList() {
		return newOtherLanguageList;
	}

	public void setNewOtherLanguageList(List newOtherLanguageList) {
		this.newOtherLanguageList = newOtherLanguageList;
	}

	public List getUpdateOtherLanguageList() {
		return updateOtherLanguageList;
	}

	public List getDeleteOtherLanguageList() {
		return deleteOtherLanguageList;
	}

	public void setUpdateOtherLanguageList(List updateOtherLanguageList) {
		this.updateOtherLanguageList = updateOtherLanguageList;
	}

	public void setDeleteOtherLanguageList(List deleteOtherLanguageList) {
		this.deleteOtherLanguageList = deleteOtherLanguageList;
	}

	public List getAccountList() {
		return accountList;
	}

	public void setAccountList(List accountList) {
		this.accountList = accountList;
	}

	public List getExcludedAccountList() {
		return excludedAccountList;
	}

	public void setExcludedAccountList(List excludedAccountList) {
		this.excludedAccountList = excludedAccountList;
	}

	public List getExcludedPackageAccountList() {
		return excludedPackageAccountList;
	}

	public void setExcludedPackageAccountList(List excludedPackageAccountList) {
		this.excludedPackageAccountList = excludedPackageAccountList;
	}

	public ALRT_SUB_EVT_TMPVO getAlrtSubEvtTmpVO() {
		return alrtSubEvtTmpVO;
	}

	public void setAlrtSubEvtTmpVO(ALRT_SUB_EVT_TMPVO alrtSubEvtTmpVO) {
		this.alrtSubEvtTmpVO = alrtSubEvtTmpVO;
	}

	public ALRT_EVTVO getAlrtEvtVO() {
		return alrtEvtVO;
	}

	public void setAlrtEvtVO(ALRT_EVTVO alrtEvtVO) {
		this.alrtEvtVO = alrtEvtVO;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
	    return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
	    this.smartCOList = smartCOList;
	}

	public Boolean getForMultipleSubscriber() {
		return forMultipleSubscriber;
	}

	public void setForMultipleSubscriber(Boolean forMultipleSubscriber) {
		this.forMultipleSubscriber = forMultipleSubscriber;
	}
}