package com.path.alert.vo.events.eventpackage;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class PackageEventSC extends GridParamsSC {
	private BigDecimal pkgId;
	private String ivCrud;
	private String briefDescEng;
	private String briefDescArab;
	private String longDescEng;
	private String longDescArab;
	private String status;
	private String langCode;
	
	public BigDecimal getPkgId() {
		return pkgId;
	}
	public void setPkgId(BigDecimal pkgId) {
		this.pkgId = pkgId;
	}
	public String getIvCrud() {
		return ivCrud;
	}
	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}
	public String getBriefDescEng() {
		return briefDescEng;
	}
	public void setBriefDescEng(String briefDescEng) {
		this.briefDescEng = briefDescEng;
	}
	public String getBriefDescArab() {
		return briefDescArab;
	}
	public void setBriefDescArab(String briefDescArab) {
		this.briefDescArab = briefDescArab;
	}
	public String getLongDescEng() {
		return longDescEng;
	}
	public void setLongDescEng(String longDescEng) {
		this.longDescEng = longDescEng;
	}
	public String getLongDescArab() {
		return longDescArab;
	}
	public void setLongDescArab(String longDescArab) {
		this.longDescArab = longDescArab;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
}
