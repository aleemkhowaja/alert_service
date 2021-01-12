package com.path.alert.vo.subscriber.groups;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class SubscriberGroupsSubscriberListCO extends BaseVO {
	private ALRT_SUBVO alertSubVO;
	private ALRT_SUB_LANGVO alertSubLangVO;
	private ALRT_SUB_GRPVOKey alertSubGrp;
	private String description;
	private String CIF_TYPE;


	private ArrayList<LinkedHashMap> ReturnGridRowsData;

	public ArrayList<LinkedHashMap> getReturnGridRowsData()
	{
	    return ReturnGridRowsData;
	}
	public void setReturnGridRowsData(ArrayList<LinkedHashMap> returnGridRowsData)
	{
	    ReturnGridRowsData = returnGridRowsData;
	}
	public ALRT_SUBVO getAlertSubVO() {
		return alertSubVO;
	}
	public void setAlertSubVO(ALRT_SUBVO alertSubVO) {
		this.alertSubVO = alertSubVO;
	}
	public ALRT_SUB_LANGVO getAlertSubLangVO() {
		return alertSubLangVO;
	}
	public void setAlertSubLangVO(ALRT_SUB_LANGVO alertSubLangVO) {
		this.alertSubLangVO = alertSubLangVO;
	}
	public ALRT_SUB_GRPVOKey getAlertSubGrp() {
		return alertSubGrp;
	}
	public void setAlertSubGrp(ALRT_SUB_GRPVOKey alertSubGrp) {
		this.alertSubGrp = alertSubGrp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCIF_TYPE() {
		return CIF_TYPE;
	}
	public void setCIF_TYPE(String cIF_TYPE) {
		CIF_TYPE = cIF_TYPE;
	}
	
}