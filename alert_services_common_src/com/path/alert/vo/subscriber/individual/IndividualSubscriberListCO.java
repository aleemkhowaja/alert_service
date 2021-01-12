package com.path.alert.vo.subscriber.individual;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndividualSubscriberListCO extends BaseVO
{

    private BigDecimal ID;
    private String SUB_TYPE;
    private BigDecimal CIF_NO;
    private String USR_ID;
    private String STATUS_DESC;
    private String DESCRIPTION;
    private String STATUS;
    private String SUB_TYPE_DESC;
    private String BRIEF_NAME;
    private String CHANNEL_END_USR_ID;
    private BigDecimal COMP_CODE;
    private String MOBILE_PHONE;
    private String EMAIL_ID ;
    private Date DATE_CREATED;
    private String CREATED_BY ;
    private Date DATE_MODIFIED ;
    private String MODIFIED_BY;
    private Date DATE_DELETED;
    private String DELETED_BY;
    private String AUTHORIZED_BY;
    private Date DATE_AUTHORIZED;
    private BigDecimal NOTIFIED;
    private String LANG;
    private Date DATE_UPDATED; 
    
    public String getSUB_TYPE_DESC()
    {
    	return SUB_TYPE_DESC;
    }

    public void setSUB_TYPE_DESC(String sUB_TYPE_DESC)
    {
    	SUB_TYPE_DESC = sUB_TYPE_DESC;
    }

    public String getSTATUS()
    {
    	return STATUS;
    }

    public void setSTATUS(String sTATUS)
    {
    	STATUS = sTATUS;
    }

    public BigDecimal getID()
    {
    	return ID;
    }

    public void setID(BigDecimal iD)
    {
    	ID = iD;
    }

    public String getSUB_TYPE()
    {
    	return SUB_TYPE;
    }

    public void setSUB_TYPE(String sUB_TYPE)
    {
    	SUB_TYPE = sUB_TYPE;
    }

    public BigDecimal getCIF_NO()
    {
    	return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIF_NO)
    {
    	CIF_NO = cIF_NO;
    }

    public String getUSR_ID()
    {
    	return USR_ID;
    }

    public void setUSR_ID(String uSR_ID)
    {
    	USR_ID = uSR_ID;
    }

    public String getSTATUS_DESC()
    {
    	return STATUS_DESC;
    }

    public void setSTATUS_DESC(String sTATUS_DESC)
    {
    	STATUS_DESC = sTATUS_DESC;
    }

    public String getDESCRIPTION()
    {
    	return DESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION)
    {
    	DESCRIPTION = dESCRIPTION;
    }

	public String getBRIEF_NAME() 
	{
		return BRIEF_NAME;
	}

	public void setBRIEF_NAME(String bRIEF_NAME) 
	{
		BRIEF_NAME = bRIEF_NAME;
	}

	public String getCHANNEL_END_USR_ID() {
		return CHANNEL_END_USR_ID;
	}

	public void setCHANNEL_END_USR_ID(String cHANNEL_END_USR_ID) {
		CHANNEL_END_USR_ID = cHANNEL_END_USR_ID;
	}

	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}

	public void setCOMP_CODE(BigDecimal cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}

	public String getMOBILE_PHONE() {
		return MOBILE_PHONE;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public Date getDATE_CREATED() {
		return DATE_CREATED;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public Date getDATE_MODIFIED() {
		return DATE_MODIFIED;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public Date getDATE_DELETED() {
		return DATE_DELETED;
	}

	public String getDELETED_BY() {
		return DELETED_BY;
	}

	public String getAUTHORIZED_BY() {
		return AUTHORIZED_BY;
	}

	public Date getDATE_AUTHORIZED() {
		return DATE_AUTHORIZED;
	}

	public BigDecimal getNOTIFIED() {
		return NOTIFIED;
	}

	public String getLANG() {
		return LANG;
	}

	public Date getDATE_UPDATED() {
		return DATE_UPDATED;
	}

	public void setMOBILE_PHONE(String mOBILE_PHONE) {
		MOBILE_PHONE = mOBILE_PHONE;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public void setDATE_CREATED(Date dATE_CREATED) {
		DATE_CREATED = dATE_CREATED;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public void setDATE_MODIFIED(Date dATE_MODIFIED) {
		DATE_MODIFIED = dATE_MODIFIED;
	}

	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public void setDATE_DELETED(Date dATE_DELETED) {
		DATE_DELETED = dATE_DELETED;
	}

	public void setDELETED_BY(String dELETED_BY) {
		DELETED_BY = dELETED_BY;
	}

	public void setAUTHORIZED_BY(String aUTHORIZED_BY) {
		AUTHORIZED_BY = aUTHORIZED_BY;
	}

	public void setDATE_AUTHORIZED(Date dATE_AUTHORIZED) {
		DATE_AUTHORIZED = dATE_AUTHORIZED;
	}

	public void setNOTIFIED(BigDecimal nOTIFIED) {
		NOTIFIED = nOTIFIED;
	}

	public void setLANG(String lANG) {
		LANG = lANG;
	}

	public void setDATE_UPDATED(Date dATE_UPDATED) {
		DATE_UPDATED = dATE_UPDATED;
	}
}