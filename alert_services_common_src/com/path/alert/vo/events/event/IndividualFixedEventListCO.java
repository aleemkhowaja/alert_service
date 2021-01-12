package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.dbmaps.vo.ALRT_EMAIL_TEMPLATEVOWithBLOBs;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndividualFixedEventListCO extends BaseVO {

	private BigDecimal ID;
	private String DESCRIPTION;
	private ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO = new ALRT_EMAIL_TEMPLATEVOWithBLOBs();
	
	
	public ALRT_EMAIL_TEMPLATEVOWithBLOBs getEmailTemplateVO()
	{
		return emailTemplateVO;
	}
	
	public void setEmailTemplateVO(ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO) 
	{
		this.emailTemplateVO = emailTemplateVO;
	}
	
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