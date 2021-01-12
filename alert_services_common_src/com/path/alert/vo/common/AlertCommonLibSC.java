package com.path.alert.vo.common;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class AlertCommonLibSC extends GridParamsSC {
	private String trxType;
	private String errText;
	private BigDecimal errCode;
	private String language;
	private BigDecimal alrtCount;
	private BigDecimal arCode;
	private String engMsg;
	private BigDecimal subID;
	private BigDecimal evt;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private BigDecimal accSl;
	private BigDecimal accCif;
	private BigDecimal accGl;
	private BigDecimal accCy;

	public BigDecimal getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}

	public BigDecimal getAccSl() {
		return accSl;
	}

	public void setAccSl(BigDecimal accSl) {
		this.accSl = accSl;
	}

	public BigDecimal getAccCif() {
		return accCif;
	}

	public void setAccCif(BigDecimal accCif) {
		this.accCif = accCif;
	}

	public BigDecimal getAccGl() {
		return accGl;
	}

	public void setAccGl(BigDecimal accGl) {
		this.accGl = accGl;
	}

	public BigDecimal getAccCy() {
		return accCy;
	}

	public void setAccCy(BigDecimal accCy) {
		this.accCy = accCy;
	}

	public BigDecimal getCompCode() {
		return compCode;
	}

	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public String getEngMsg() {
		return engMsg;
	}

	public void setEngMsg(String engMsg) {
		this.engMsg = engMsg;
	}

	public BigDecimal getSubID() {
		return subID;
	}

	public void setSubID(BigDecimal subID) {
		this.subID = subID;
	}

	public BigDecimal getEvt() {
		return evt;
	}

	public void setEvt(BigDecimal evt) {
		this.evt = evt;
	}

	public BigDecimal getArCode() {
		return arCode;
	}

	public void setArCode(BigDecimal arCode) {
		this.arCode = arCode;
	}

	public BigDecimal getAlrtCount() {
		return alrtCount;
	}

	public void setAlrtCount(BigDecimal alrtCount) {
		this.alrtCount = alrtCount;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getErrText() {
		return errText;
	}

	public void setErrText(String errText) {
		this.errText = errText;
	}

	public BigDecimal getErrCode() {
		return errCode;
	}

	public void setErrCode(BigDecimal errCode) {
		this.errCode = errCode;
	}

	public String getTrxType() {
		return trxType;
	}

	public void setTrxType(String trxType) {
		this.trxType = trxType;
	}

}
