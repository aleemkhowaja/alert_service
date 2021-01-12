package com.path.alert.vo.dynamictags;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsSC.java used to
 */
public class DynamicTagsSC extends GridParamsSC
{
	
	private BigDecimal dynTagID;
	private String progRef;
	private BigDecimal dynTagType;
	private String dynSessionLang;
	
	
	/*Getter and Setter dynTagType */
	public BigDecimal getDynTagType() {
		return dynTagType;
	}

	public void setDynTagType(BigDecimal dynTagType) {
		this.dynTagType = dynTagType;
	}

	
	/*Getter and Setter dynSessionLang */
	public String getDynSessionLang() {
		return dynSessionLang;
	}

	public void setDynSessionLang(String dynSessionLang) {
		this.dynSessionLang = dynSessionLang;
	}

	/*Getter & Setter for prog_ref  */
	public String getProgRef() {
		return progRef;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
	}


	/*Getter & Setter for DynTagID */
	public BigDecimal getDynTagID() {
		return dynTagID;
	}

	public void setDynTagID(BigDecimal dynTagID) {
		this.dynTagID = dynTagID;
	}


	public DynamicTagsSC()
	{
		super.setSearchCols(new String[] {"TAG_ID", "TAG_TYPE", "FIXED_EVT_ID", "TAG_NAME","TAG_DESCRIPTION","TAG_TYPE_DESC","FIXED_EVT_DESC"});
	}
	
}
