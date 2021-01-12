package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class IndividualReportIdEventCO extends BaseVO{
	
	private BigDecimal ID;
	private String DESCRIPTION;
	
	public BigDecimal getID() {
		return ID;
	}
	public void setID(BigDecimal iD) {
		ID = iD;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

}
