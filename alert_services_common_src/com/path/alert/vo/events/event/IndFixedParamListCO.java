package com.path.alert.vo.events.event;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndFixedParamListCO extends BaseVO {

	private BigDecimal ID;
	private BigDecimal COLUMN_ID;
	private BigDecimal FIXED_EVENT_ID;
	private String PARAM_COLUMN_TYPE;
	private String PARAM_COLUMN_TYPE_DESC;
	private String PARAM_COLUMN_NAME;
	private String COLUMN_NAME;
	private String PARAM_LABEL;
	private String OLD_COLUMN_ID;
	private String PARAM_VALUE;
	private String  OPERATOR_TYPE;
	private String  OLD_OPERATOR_TYPE;
	private String  OLD_NEW_VAL_LIST;
	
	private String FROM_VALUE;
	private String FROM_VALUE1;
	private String FROM_VALUE2;
	private String TO_VALUE;
	private String FIXED_OPERATOR;
	private String fixedOperatorDesc;
	private String FIXED_LABEL;
	private String FIXED_FLAG;
	private String OperatorDesc;
	private String cardsparam;
	private BigDecimal FIXED_CODE;
	private String PARAMETER_TYPE;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	
	
	public BigDecimal getFIXED_EVENT_ID() {
		return FIXED_EVENT_ID;
	}
	public String getPARAM_COLUMN_TYPE() {
		return PARAM_COLUMN_TYPE;
	}
	public String getPARAM_COLUMN_NAME() {
		return PARAM_COLUMN_NAME;
	}
	public String getPARAM_VALUE() {
		return PARAM_VALUE;
	}
	public String getOPERATOR_TYPE() {
		return OPERATOR_TYPE;
	}
	public String getOLD_NEW_VAL_LIST() {
		return OLD_NEW_VAL_LIST;
	}
	public void setPARAM_VALUE(String pARAM_VALUE) {
		PARAM_VALUE = pARAM_VALUE;
	}
	public void setOPERATOR_TYPE(String oPERATOR_TYPE) {
		OPERATOR_TYPE = oPERATOR_TYPE;
	}
	public void setOLD_NEW_VAL_LIST(String oLD_NEW_VAL_LIST) {
		OLD_NEW_VAL_LIST = oLD_NEW_VAL_LIST;
	}
	public void setFIXED_EVENT_ID(BigDecimal fIXED_EVENT_ID) {
		FIXED_EVENT_ID = fIXED_EVENT_ID;
	}
	public void setPARAM_COLUMN_TYPE(String pARAM_COLUMN_TYPE) {
		PARAM_COLUMN_TYPE = pARAM_COLUMN_TYPE;
	}
	public void setPARAM_COLUMN_NAME(String pARAM_COLUMN_NAME) {
		PARAM_COLUMN_NAME = pARAM_COLUMN_NAME;
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
	public String getFixedOperatorDesc() {
		return fixedOperatorDesc;
	}
	public void setFixedOperatorDesc(String fixedOperatorDesc) {
		this.fixedOperatorDesc = fixedOperatorDesc;
	}
	public String getOperatorDesc() {
		return OperatorDesc;
	}
	public void setOperatorDesc(String operatorDesc) {
		OperatorDesc = operatorDesc;
	}
	public String getCardsparam() {
		return cardsparam;
	}
	public void setCardsparam(String cardsparam) {
		this.cardsparam = cardsparam;
	}
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
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}
	public String getPARAMETER_TYPE() {
		return PARAMETER_TYPE;
	}
	public void setPARAMETER_TYPE(String pARAMETER_TYPE) {
		PARAMETER_TYPE = pARAMETER_TYPE;
	}
	public String getFROM_VALUE1() {
		return FROM_VALUE1;
	}
	public void setFROM_VALUE1(String fROM_VALUE1) {
		FROM_VALUE1 = fROM_VALUE1;
	}
	public String getFROM_VALUE2() {
		return FROM_VALUE2;
	}
	public void setFROM_VALUE2(String fROM_VALUE2) {
		FROM_VALUE2 = fROM_VALUE2;
	}
	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}
	public void setCOLUMN_NAME(String cOLUMN_NAME) {
		COLUMN_NAME = cOLUMN_NAME;
	}
	public BigDecimal getCOLUMN_ID() {
		return COLUMN_ID;
	}
	public void setCOLUMN_ID(BigDecimal cOLUMN_ID) {
		COLUMN_ID = cOLUMN_ID;
	}
	public String getOLD_COLUMN_ID() {
		return OLD_COLUMN_ID;
	}
	public String getOLD_OPERATOR_TYPE() {
		return OLD_OPERATOR_TYPE;
	}
	public void setOLD_COLUMN_ID(String oLD_COLUMN_ID) {
		OLD_COLUMN_ID = oLD_COLUMN_ID;
	}
	public void setOLD_OPERATOR_TYPE(String oLD_OPERATOR_TYPE) {
		OLD_OPERATOR_TYPE = oLD_OPERATOR_TYPE;
	}
	public String getPARAM_COLUMN_TYPE_DESC() {
		return PARAM_COLUMN_TYPE_DESC;
	}
	public void setPARAM_COLUMN_TYPE_DESC(String pARAM_COLUMN_TYPE_DESC) {
		PARAM_COLUMN_TYPE_DESC = pARAM_COLUMN_TYPE_DESC;
	}
	public String getPARAM_LABEL() {
		return PARAM_LABEL;
	}
	public void setPARAM_LABEL(String pARAM_LABEL) {
		PARAM_LABEL = pARAM_LABEL;
	}
	
}

