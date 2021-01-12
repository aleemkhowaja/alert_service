package com.path.alert.vo.subscriber.individual;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class IndividualSubscriberSC extends GridParamsSC
{
    private String status;
    private String ivCrud;
    private BigDecimal lovType;
    private String langCode;
    private BigDecimal subscriberID;
    private String pageRef;
    private BigDecimal cif;
    private String cifEmail;
    private String cifMobile;
    private String userID;
    private BigDecimal accBr;
    private BigDecimal accSl;
    private BigDecimal accCif;
    private BigDecimal accGl;
    private BigDecimal accCy;
    private String accAddRef;
    private BigDecimal chargeable;
    private BigDecimal subID;
    private BigDecimal centralized;
    private String mobile;
    private String oldMobile;
    private BigDecimal evtID;
    private BigDecimal pckgID;
    private String relType;
    private String subType;
    private BigDecimal subCif;
    private BigDecimal subTypeLov;
    private BigDecimal suspendAllSubscriptions;
    private String indSubLangCode;
    private BigDecimal groupId;
    
    public BigDecimal getGroupId() 
    {
		return groupId;
	}

	public void setGroupId(BigDecimal groupId) 
	{
		this.groupId = groupId;
	}

	public BigDecimal getSubTypeLov()
    {
	return subTypeLov;
    }

    public void setSubTypeLov(BigDecimal subTypeLov)
    {
	this.subTypeLov = subTypeLov;
    }

    public BigDecimal getSubCif()
    {
	return subCif;
    }

    public void setSubCif(BigDecimal subCif)
    {
	this.subCif = subCif;
    }

    public String getSubType()
    {
	return subType;
    }

    public void setSubType(String subType)
    {
	this.subType = subType;
    }

    public BigDecimal getEvtID()
    {
	return evtID;
    }

    public void setEvtID(BigDecimal evtID)
    {
	this.evtID = evtID;
    }

    public String getMobile()
    {
	return mobile;
    }

    public void setMobile(String mobile)
    {
	this.mobile = mobile;
    }

    public String getOldMobile()
    {
	return oldMobile;
    }

    public void setOldMobile(String oldMobile)
    {
	this.oldMobile = oldMobile;
    }

    public BigDecimal getCentralized()
    {
	return centralized;
    }

    public void setCentralized(BigDecimal centralized)
    {
	this.centralized = centralized;
    }

    public BigDecimal getSubID()
    {
	return subID;
    }

    public void setSubID(BigDecimal subID)
    {
	this.subID = subID;
    }

    public BigDecimal getChargeable()
    {
	return chargeable;
    }

    public void setChargeable(BigDecimal chargeable)
    {
	this.chargeable = chargeable;
    }

    public String getAccAddRef()
    {
	return accAddRef;
    }

    public void setAccAddRef(String accAddRef)
    {
	this.accAddRef = accAddRef;
    }

    public BigDecimal getAccBr()
    {
	return accBr;
    }

    public void setAccBr(BigDecimal accBr)
    {
	this.accBr = accBr;
    }

    public BigDecimal getAccSl()
    {
	return accSl;
    }

    public void setAccSl(BigDecimal accSl)
    {
	this.accSl = accSl;
    }

    public BigDecimal getAccCif()
    {
	return accCif;
    }

    public void setAccCif(BigDecimal accCif)
    {
	this.accCif = accCif;
    }

    public BigDecimal getAccGl()
    {
	return accGl;
    }

    public void setAccGl(BigDecimal accGl)
    {
	this.accGl = accGl;
    }

    public BigDecimal getAccCy()
    {
	return accCy;
    }

    public void setAccCy(BigDecimal accCy)
    {
	this.accCy = accCy;
    }

    public String getUserID()
    {
	return userID;
    }

    public void setUserID(String userID)
    {
	this.userID = userID;
    }

    public String getCifEmail()
    {
	return cifEmail;
    }

    public void setCifEmail(String cifEmail)
    {
	this.cifEmail = cifEmail;
    }

    public String getCifMobile()
    {
	return cifMobile;
    }

    public void setCifMobile(String cifMobile)
    {
	this.cifMobile = cifMobile;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public BigDecimal getSubscriberID()
    {
	return subscriberID;
    }

    public void setSubscriberID(BigDecimal subscriberID)
    {
	this.subscriberID = subscriberID;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

	public BigDecimal getSuspendAllSubscriptions() {
		return suspendAllSubscriptions;
	}

	public void setSuspendAllSubscriptions(BigDecimal suspendAllSubscriptions) {
		this.suspendAllSubscriptions = suspendAllSubscriptions;
	}

	public String getIndSubLangCode() {
		return indSubLangCode;
	}

	public void setIndSubLangCode(String indSubLangCode) {
		this.indSubLangCode = indSubLangCode;
	}

	public BigDecimal getPckgID() {
		return pckgID;
	}

	public String getRelType() {
		return relType;
	}

	public void setPckgID(BigDecimal pckgID) {
		this.pckgID = pckgID;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

}
