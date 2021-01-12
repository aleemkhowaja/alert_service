package com.path.alert.vo.events.event;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class AlrtTagsCO extends BaseVO {
    
	private BigDecimal ID;
	private BigDecimal TAG_ID;
	private String TAG_NAME;
	private String TAG_DESCRIPTION;
	
	public BigDecimal getID() {
		return ID;
	}
	public void setID(BigDecimal iD) {
		ID = iD;
	}
	public String getTAG_NAME() {
		return TAG_NAME;
	}
	public void setTAG_NAME(String tAG_NAME) {
		TAG_NAME = tAG_NAME;
	}
	public String getTAG_DESCRIPTION() {
		return TAG_DESCRIPTION;
	}
	public void setTAG_DESCRIPTION(String tAG_DESCRIPTION) {
		TAG_DESCRIPTION = tAG_DESCRIPTION;
	}
	public BigDecimal getTAG_ID() {
		return TAG_ID;
	}
	public void setTAG_ID(BigDecimal tAG_ID) {
		TAG_ID = tAG_ID;
	}
	
}

