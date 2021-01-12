package com.path.alert.vo.subscriber.groups;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class SubscriberInGroupsSubscriberListCO extends BaseVO {

	private ALRT_SUBVO alertSubVO;
	private ALRT_SUB_LANGVO alertSubLangVO;
	private ALRT_GRPVO alertGroupVO;
	private List<ALRT_GRPVO>lstAlertGroupVO;
	private BigDecimal selectedRow;
	private ArrayList<LinkedHashMap> ReturnGridRowsData;
	private String CIF_TYPE;
	private String STATUS;
	
	public BigDecimal getSelectedRow()
	{
	    return selectedRow;
	}
	public void setSelectedRow(BigDecimal selectedRow)
	{
	    this.selectedRow = selectedRow;
	}
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
	public ALRT_GRPVO getAlertGroupVO() {
		return alertGroupVO;
	}
	public void setAlertGroupVO(ALRT_GRPVO alertGroupVO) {
		this.alertGroupVO = alertGroupVO;
	}
	public List<ALRT_GRPVO> getLstAlertGroupVO() {
		return lstAlertGroupVO;
	}
	public void setLstAlertGroupVO(List<ALRT_GRPVO> lstAlertGroupVO) {
		this.lstAlertGroupVO = lstAlertGroupVO;
	}
	public String getCIF_TYPE() {
		return CIF_TYPE;
	}
	public void setCIF_TYPE(String cIF_TYPE) {
		CIF_TYPE = cIF_TYPE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
}