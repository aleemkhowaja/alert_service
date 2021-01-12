package com.path.alert.vo.webservice;

import java.util.HashMap;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.DynamicFilter;

@SuppressWarnings("serial")
public class AlertCommonWSSC extends GridParamsSC {

	private String langCode;
	//private BigDecimal compCode;
	//private BigDecimal branchCode;

	HashMap<String, Object> colSearchMap = new HashMap<>();
	HashMap<String, String> colTypeMap = new HashMap<>();
	private DynamicFilter dynamicFilter = new DynamicFilter();
	 
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/*public BigDecimal getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}*/
	/*public BigDecimal getCompCode() {
		return compCode;
	}

	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	*/
	public HashMap<String, Object> getColSearchMap() {
		return colSearchMap;
	}
	
	public HashMap<String, String> getColTypeMap() {
		return colTypeMap;
	}
	
	public DynamicFilter getDynamicFilter() {
		return dynamicFilter;
	}
	
	public void setColSearchMap(HashMap<String, Object> colSearchMap) {
		this.colSearchMap = colSearchMap;
	}
	
	public void setColTypeMap(HashMap<String, String> colTypeMap) {
		this.colTypeMap = colTypeMap;
	}
	
	public void setDynamicFilter(DynamicFilter dynamicFilter) {
		this.dynamicFilter = dynamicFilter;
	}
}
