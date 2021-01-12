package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndividualEventListCO extends BaseVO {

	private BigDecimal EVT_ID;
	private String STATUS;
	private String EVT_TYPE;
	private String EVT_MODE;
	private String DESC_ENG;
	private String DESC_ARAB;
	private BigDecimal COMP_CODE;
	private String cifAccountsMultiselectArray;
	private String TO_BE_STATUS_BY;
	private String TO_BE_STATUS;
	private String communicationDescription;
	
	public BigDecimal getEVT_ID() {
		return EVT_ID;
	}
	public void setEVT_ID(BigDecimal eVT_ID) {
		EVT_ID = eVT_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getEVT_TYPE() {
		return EVT_TYPE;
	}
	public void setEVT_TYPE(String eVT_TYPE) {
		EVT_TYPE = eVT_TYPE;
	}
	public String getEVT_MODE() {
		return EVT_MODE;
	}
	public void setEVT_MODE(String eVT_MODE) {
		EVT_MODE = eVT_MODE;
	}
	public String getDESC_ENG() {
		return DESC_ENG;
	}
	public void setDESC_ENG(String dESC_ENG) {
		DESC_ENG = dESC_ENG;
	}
	public String getDESC_ARAB() {
		return DESC_ARAB;
	}
	public void setDESC_ARAB(String dESC_ARAB) {
		DESC_ARAB = dESC_ARAB;
	}
	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}
	public String getCifAccountsMultiselectArray() {
		return cifAccountsMultiselectArray;
	}
	public void setCifAccountsMultiselectArray(String cifAccountsMultiselectArray) {
		this.cifAccountsMultiselectArray = cifAccountsMultiselectArray;
	}
	public String getTO_BE_STATUS_BY() {
		return TO_BE_STATUS_BY;
	}
	public void setTO_BE_STATUS_BY(String tO_BE_STATUS_BY) {
		TO_BE_STATUS_BY = tO_BE_STATUS_BY;
	}
	public String getTO_BE_STATUS() {
		return TO_BE_STATUS;
	}
	public void setTO_BE_STATUS(String tO_BE_STATUS) {
		TO_BE_STATUS = tO_BE_STATUS;
	}
	public String getCommunicationDescription() {
		return communicationDescription;
	}
	public void setCommunicationDescription(String communicationDescription) {
		this.communicationDescription = communicationDescription;
	}
}