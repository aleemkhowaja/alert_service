package com.path.alert.vo.statusmngmnt;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntSC.java used to
 */
public class StatusMngmntSC extends GridParamsSC

{

    private String alrtSubEvtRelTypeDesc; // 935 //subscriber type u,c,o,a
    private String alrtSubTypeDesc; // 933 //subscription type all,se,gp ...
    private String alrtEvtTypeDesc; // 936 event type f

    private String alrtevtModeTypeDesc; // 937 event mode mail,sms ,both
    private String StatusmodeTypeDesc;
    private String relType;
    private String raRelId;

    public String getAlrtSubEvtRelTypeDesc()
    {
	return alrtSubEvtRelTypeDesc;
    }

    public void setAlrtSubEvtRelTypeDesc(String alrtSubEvtRelTypeDesc)
    {
	this.alrtSubEvtRelTypeDesc = alrtSubEvtRelTypeDesc;
    }

    public String getAlrtSubTypeDesc()
    {
	return alrtSubTypeDesc;
    }

    public void setAlrtSubTypeDesc(String alrtSubTypeDesc)
    {
	this.alrtSubTypeDesc = alrtSubTypeDesc;
    }

    public String getAlrtEvtTypeDesc()
    {
	return alrtEvtTypeDesc;
    }

    public void setAlrtEvtTypeDesc(String alrtEvtTypeDesc)
    {
	this.alrtEvtTypeDesc = alrtEvtTypeDesc;
    }

    public String getAlrtevtModeTypeDesc()
    {
	return alrtevtModeTypeDesc;
    }

    public void setAlrtevtModeTypeDesc(String alrtevtModeTypeDesc)
    {
	this.alrtevtModeTypeDesc = alrtevtModeTypeDesc;
    }

    public String getStatusmodeTypeDesc()
    {
	return StatusmodeTypeDesc;
    }

    public void setStatusmodeTypeDesc(String statusmodeTypeDesc)
    {
	StatusmodeTypeDesc = statusmodeTypeDesc;
    }

    public String getRelType()
    {
	return relType;
    }

    public void setRelType(String relType)
    {
	this.relType = relType;
    }

    public String getRaRelId()
    {
	return raRelId;
    }

    public void setRaRelId(String raRelId)
    {
	this.raRelId = raRelId;
    }

}
