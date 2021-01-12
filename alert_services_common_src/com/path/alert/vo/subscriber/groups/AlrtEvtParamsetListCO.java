package com.path.alert.vo.subscriber.groups;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class AlrtEvtParamsetListCO extends BaseVO {

	private BigDecimal ID;
	private BigDecimal FIXED_CODE;
	private String FROM_VALUE;
	private String TO_VALUE;
	private String FIXED_OPERATOR;
	private String FIXED_LABEL;
	private String FIXED_FLAG;
	private String PARAM_TYPE;
	
	public BigDecimal getID() {
		return ID;
	}
	public void setID(BigDecimal iD) {
		ID = iD;
	}
	public BigDecimal getFIXED_CODE() {
		return FIXED_CODE;
	}
	public void setFIXED_CODE(BigDecimal fIXED_CODE) {
		FIXED_CODE = fIXED_CODE;
	}
	public String getFROM_VALUE() {
		return FROM_VALUE;
	}
	public void setFROM_VALUE(String fROM_VALUE) {
		FROM_VALUE = fROM_VALUE;
	}
	public String getTO_VALUE() {
		return TO_VALUE;
	}
	public void setTO_VALUE(String tO_VALUE) {
		TO_VALUE = tO_VALUE;
	}
	public String getFIXED_OPERATOR() {
		return FIXED_OPERATOR;
	}
	public void setFIXED_OPERATOR(String fIXED_OPERATOR) {
		FIXED_OPERATOR = fIXED_OPERATOR;
	}
	public String getFIXED_LABEL() {
		return FIXED_LABEL;
	}
	public void setFIXED_LABEL(String fIXED_LABEL) {
		FIXED_LABEL = fIXED_LABEL;
	}
	public String getFIXED_FLAG() {
		return FIXED_FLAG;
	}
	public void setFIXED_FLAG(String fIXED_FLAG) {
		FIXED_FLAG = fIXED_FLAG;
	}
	public String getPARAM_TYPE() {
		return PARAM_TYPE;
	}
	public void setPARAM_TYPE(String pARAM_TYPE) {
		PARAM_TYPE = pARAM_TYPE;
	}
}