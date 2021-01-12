package com.path.alert.vo.dynamictags;

import com.path.dbmaps.vo.ALRT_TAGSVO;
import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsCO.java used to
 */
public class DynamicTagsCO extends BaseVO
{
	
	private ALRT_TAGSVO  alrtTagsVO= new ALRT_TAGSVO();
	private String TAG_TYPE_DESC;
	private String FIXED_EVT_DESC; 
	
	/*Getter and Setter for TAG_TYPE_DESC*/
	public String getTAG_TYPE_DESC() {
		return TAG_TYPE_DESC;
	}
	public String getFIXED_EVT_DESC() {
		return FIXED_EVT_DESC;
	}
	
	/*Getter and Setter for FIXED_EVT_DESC*/
	public void setFIXED_EVT_DESC(String fIXED_EVT_DESC) {
		FIXED_EVT_DESC = fIXED_EVT_DESC;
	}
	public void setTAG_TYPE_DESC(String tAG_TYPE_DESC) {
		TAG_TYPE_DESC = tAG_TYPE_DESC;
	}
	
	/*Getter and Setter for alrtTagsVO*/
	public ALRT_TAGSVO getAlrtTagsVO() {
		return alrtTagsVO;
	}
	public void setAlrtTagsVO(ALRT_TAGSVO alrtTagsVO) {
		this.alrtTagsVO = alrtTagsVO;
	}

}
