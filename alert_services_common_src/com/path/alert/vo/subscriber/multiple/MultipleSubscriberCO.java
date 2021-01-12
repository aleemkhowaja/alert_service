package com.path.alert.vo.subscriber.multiple;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class MultipleSubscriberCO extends BaseVO {

	private List<MultipleSubscriberCO> newMultipleSubscriberCOs;
	private List<MultipleSubscriberCO> updatedMultipleSubscriberCOs;
	private List<MultipleSubscriberCO> deletedMultipleSubscriberCOs;
	private List<MultipleSubscriberCO> alrt_SUB_LANGVOs;
	
	private ALRT_SUBVO alrtSubVO = new ALRT_SUBVO();
	private ALRT_SUB_LANGVO alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String appName;
	private String progRef;
	private String userID;
	private Date runningDate;
	private String ivCrud;
	private String language;
	private String multpleSubscribersJson;
	private BigDecimal[] subscriberIds;
	private BigDecimal[] excludeSubscriberIds;
	private String fullPath;
	private String otherLanguagesJson;
	private BigDecimal subscriberId;
	private int allApproved;
	private String statusDesc;
	private BigDecimal allrows;

	public int getAllApproved() 
	{
		return allApproved;
	}

	public void setAllApproved(int allApproved) 
	{
		this.allApproved = allApproved;
	}

	public BigDecimal getCompCode() {
		return compCode;
	}

	public List<MultipleSubscriberCO> getNewMultipleSubscriberCOs() {
		return newMultipleSubscriberCOs;
	}

	public List<MultipleSubscriberCO> getUpdatedMultipleSubscriberCOs() {
		return updatedMultipleSubscriberCOs;
	}

	public List<MultipleSubscriberCO> getDeletedMultipleSubscriberCOs() {
		return deletedMultipleSubscriberCOs;
	}

	public void setNewMultipleSubscriberCOs(List<MultipleSubscriberCO> newMultipleSubscriberCOs) {
		this.newMultipleSubscriberCOs = newMultipleSubscriberCOs;
	}

	public void setUpdatedMultipleSubscriberCOs(List<MultipleSubscriberCO> updatedMultipleSubscriberCOs) {
		this.updatedMultipleSubscriberCOs = updatedMultipleSubscriberCOs;
	}

	public void setDeletedMultipleSubscriberCOs(List<MultipleSubscriberCO> deletedMultipleSubscriberCOs) {
		this.deletedMultipleSubscriberCOs = deletedMultipleSubscriberCOs;
	}

	public List<MultipleSubscriberCO> getAlrt_SUB_LANGVOs() {
		return alrt_SUB_LANGVOs;
	}

	public void setAlrt_SUB_LANGVOs(List<MultipleSubscriberCO> alrt_SUB_LANGVOs) {
		this.alrt_SUB_LANGVOs = alrt_SUB_LANGVOs;
	}

	public BigDecimal getBranchCode() {
		return branchCode;
	}

	public String getAppName() {
		return appName;
	}

	public String getProgRef() {
		return progRef;
	}

	public String getUserID() {
		return userID;
	}

	public Date getRunningDate() {
		return runningDate;
	}

	public String getIvCrud() {
		return ivCrud;
	}

	public String getLanguage() {
		return language;
	}

	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}

	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getMultpleSubscribersJson() {
		return multpleSubscribersJson;
	}

	public void setMultpleSubscribersJson(String multpleSubscribersJson) {
		this.multpleSubscribersJson = multpleSubscribersJson;
	}

	/*public BigDecimal getSelectedRowCount() {
		return selectedRowCount;
	}

	public void setSelectedRowCount(BigDecimal selectedRowCount) {
		this.selectedRowCount = selectedRowCount;
	}

	public CIF_ADDRESSVO getCifAddressVO() {
		return cifAddressVO;
	}

	public void setCifAddressVO(CIF_ADDRESSVO cifAddressVO) {
		this.cifAddressVO = cifAddressVO;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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
*/
	public ALRT_SUBVO getAlrtSubVO() {
		return alrtSubVO;
	}

	public void setAlrtSubVO(ALRT_SUBVO alrtSubVO) {
		this.alrtSubVO = alrtSubVO;
	}

	/*public ALRT_CONTROLVO getAlrt_ctrlVO() {
		return alrt_ctrlVO;
	}

	public void setAlrt_ctrlVO(ALRT_CONTROLVO alrt_ctrlVO) {
		this.alrt_ctrlVO = alrt_ctrlVO;
	}
*/
	public ALRT_SUB_LANGVO getAlrt_SUB_LANGVO() {
		return alrt_SUB_LANGVO;
	}

	public void setAlrt_SUB_LANGVO(ALRT_SUB_LANGVO alrt_SUB_LANGVO) {
		this.alrt_SUB_LANGVO = alrt_SUB_LANGVO;
	}

	public BigDecimal[] getSubscriberIds() {
		return subscriberIds;
	}

	public void setSubscriberIds(BigDecimal[] subscriberIds) {
		this.subscriberIds = subscriberIds;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getOtherLanguagesJson() {
		return otherLanguagesJson;
	}

	public void setOtherLanguagesJson(String otherLanguagesJson) {
		this.otherLanguagesJson = otherLanguagesJson;
	}

	public BigDecimal getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(BigDecimal subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public BigDecimal getAllrows() {
		return allrows;
	}

	public void setAllrows(BigDecimal allrows) {
		this.allrows = allrows;
	}

	public BigDecimal[] getExcludeSubscriberIds() {
		return excludeSubscriberIds;
	}

	public void setExcludeSubscriberIds(BigDecimal[] excludeSubscriberIds) {
		this.excludeSubscriberIds = excludeSubscriberIds;
	}
}