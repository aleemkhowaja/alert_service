package com.path.alert.vo.service;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.dbmaps.vo.ALRT_EVTVO;

public class AlertServiceSC {	
	private IndividualEventSC indEventSC = new IndividualEventSC();
	private ALRT_EVTVO alertEVTVO = new ALRT_EVTVO();

	public IndividualEventSC getIndEventSC() {
		return indEventSC;
	}

	public void setIndEventSC(IndividualEventSC indEventSC) {
		this.indEventSC = indEventSC;
	}

	public ALRT_EVTVO getAlertEVTVO() {
		return alertEVTVO;
	}

	public void setAlertEVTVO(ALRT_EVTVO alertEVTVO) {
		this.alertEVTVO = alertEVTVO;
	}
}
