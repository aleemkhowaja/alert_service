package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndividualMemoListCO extends BaseVO {

	private BigDecimal CODE;
	private String briefDescEng;
	private String longDescEng;
	private String type;
	public BigDecimal getCODE() {
		return CODE;
	}
	public void setCODE(BigDecimal cODE) {
		CODE = cODE;
	}
	public String getBriefDescEng() {
		return briefDescEng;
	}
	public void setBriefDescEng(String briefDescEng) {
		this.briefDescEng = briefDescEng;
	}
	public String getLongDescEng() {
		return longDescEng;
	}
	public void setLongDescEng(String longDescEng) {
		this.longDescEng = longDescEng;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}