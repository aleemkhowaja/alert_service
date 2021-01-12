package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class PackageEventListCO extends BaseVO {

	private BigDecimal PKG_ID;
	private String BRIEF_DESC_ENG;
	private String BRIEF_DESC_ARAB;
	private String LONG_DESC_ENG;
	private String LONG_DESC_ARAB;
	private String STATUS;
	private String INCLUDE_ALL_EVT_YN;
	private String CREATED_BY;
	private Date DATE_CREATED;
	private String MODIFIED_BY;
	private Date DATE_MODIFIED;
	private String AUTHORIZED_BY;
	private Date DATE_AUTHORIZED;
	private String DELETED_BY;
	private Date DATE_DELETED;
	
	public BigDecimal getPKG_ID()
	{
	    return PKG_ID;
	}
	public void setPKG_ID(BigDecimal pKG_ID)
	{
	    PKG_ID = pKG_ID;
	}
	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}
	public void setBRIEF_DESC_ENG(String bRIEF_DESC_ENG) {
		BRIEF_DESC_ENG = bRIEF_DESC_ENG;
	}
	public String getBRIEF_DESC_ARAB() {
		return BRIEF_DESC_ARAB;
	}
	public void setBRIEF_DESC_ARAB(String bRIEF_DESC_ARAB) {
		BRIEF_DESC_ARAB = bRIEF_DESC_ARAB;
	}
	public String getLONG_DESC_ENG() {
		return LONG_DESC_ENG;
	}
	public void setLONG_DESC_ENG(String lONG_DESC_ENG) {
		LONG_DESC_ENG = lONG_DESC_ENG;
	}
	public String getLONG_DESC_ARAB() {
		return LONG_DESC_ARAB;
	}
	public void setLONG_DESC_ARAB(String lONG_DESC_ARAB) {
		LONG_DESC_ARAB = lONG_DESC_ARAB;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getINCLUDE_ALL_EVT_YN()
	{
	    return INCLUDE_ALL_EVT_YN;
	}
	public void setINCLUDE_ALL_EVT_YN(String iNCLUDE_ALL_EVT_YN)
	{
	    INCLUDE_ALL_EVT_YN = iNCLUDE_ALL_EVT_YN;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getDATE_CREATED() {
		return DATE_CREATED;
	}
	public void setDATE_CREATED(Date dATE_CREATED) {
		DATE_CREATED = dATE_CREATED;
	}
	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}
	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}
	public Date getDATE_MODIFIED() {
		return DATE_MODIFIED;
	}
	public void setDATE_MODIFIED(Date dATE_MODIFIED) {
		DATE_MODIFIED = dATE_MODIFIED;
	}
	public String getAUTHORIZED_BY() {
		return AUTHORIZED_BY;
	}
	public void setAUTHORIZED_BY(String aUTHORIZED_BY) {
		AUTHORIZED_BY = aUTHORIZED_BY;
	}
	public Date getDATE_AUTHORIZED() {
		return DATE_AUTHORIZED;
	}
	public void setDATE_AUTHORIZED(Date dATE_AUTHORIZED) {
		DATE_AUTHORIZED = dATE_AUTHORIZED;
	}
	public String getDELETED_BY() {
		return DELETED_BY;
	}
	public void setDELETED_BY(String dELETED_BY) {
		DELETED_BY = dELETED_BY;
	}
	public Date getDATE_DELETED() {
		return DATE_DELETED;
	}
	public void setDATE_DELETED(Date dATE_DELETED) {
		DATE_DELETED = dATE_DELETED;
	}
}