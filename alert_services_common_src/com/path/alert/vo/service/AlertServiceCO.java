package com.path.alert.vo.service;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.math.BigDecimal;
import java.util.List;

import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_QUEUEVO;

public class AlertServiceCO{

	private BigDecimal lovType;
	private ALRT_EVTVO alertEVTVO = new ALRT_EVTVO();
	private ALRT_QUEUEVO alertQueVO = new ALRT_QUEUEVO();
	private List<IndividualEventListCO> lstIndvEventCO; 
	

	public ALRT_EVTVO getAlertEVTVO() {
		return alertEVTVO;
	}

	public void setAlertEVTVO(ALRT_EVTVO alertEVTVO) {
		this.alertEVTVO = alertEVTVO;
	}

	public List<IndividualEventListCO> getLstIndvEventCO() {
		return lstIndvEventCO;
	}

	public void setLstIndvEventCO(List<IndividualEventListCO> lstIndvEventCO) {
		this.lstIndvEventCO = lstIndvEventCO;
	}

	public BigDecimal getLovType() {
		return lovType;
	}

	public void setLovType(BigDecimal lovType) {
		this.lovType = lovType;
	}

	public ALRT_QUEUEVO getAlertQueVO() {
		return alertQueVO;
	}

	public void setAlertQueVO(ALRT_QUEUEVO alertQueVO) {
		this.alertQueVO = alertQueVO;
	}
		
}
