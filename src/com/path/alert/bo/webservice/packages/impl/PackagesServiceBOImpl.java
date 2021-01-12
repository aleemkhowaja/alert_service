package com.path.alert.bo.webservice.packages.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
//Alim Khowaja - User Story #735012 Package
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.events.eventpackage.PackageEventBO;
import com.path.alert.bo.webservice.AlertServiceUtilBO;
import com.path.alert.bo.webservice.packages.PackagesServiceBO;
import com.path.alert.vo.events.eventpackage.PackageEventListCO;
import com.path.alert.vo.events.eventpackage.PackageEventSC;
import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.alert.packages.Packages;
import com.path.vo.alert.packages.ReturnPackageListReq;
import com.path.vo.alert.packages.ReturnPackageListResp;


public class PackagesServiceBOImpl extends BaseBO implements PackagesServiceBO {
	
	//Package Event Bo
	private PackageEventBO packageEventBO;
	
	//Alert Service BoImpl
	private AlertServiceUtilBO alertServiceUtilBo;

	@Override
	public ReturnPackageListResp returnPackageList(ReturnPackageListReq returnPackageListReq) throws Exception 
	{
		ReturnPackageListResp returnPackageListResp = new ReturnPackageListResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(returnPackageListReq, returnPackageListResp);
	    PathPropertyUtil.copyProperties(returnPackageListReq.getServiceContext(),returnPackageListResp.getResponseServiceContext());
	    
		PackageEventSC packageEventSC = new PackageEventSC();
		AlertCommonWSSC alertCommonWSSC = new AlertCommonWSSC();
		
		String[] searchCol = {"BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", "STATUS"};
	    
	    //fill map for search same as assets
	  	HashMap<String, Object> colSearchMap = new HashMap<>();
	  	colSearchMap.put("BRIEF_DESC_ENG", returnPackageListReq.getBriefDescriptionEnglish());
	  	colSearchMap.put("BRIEF_DESC_ARAB", returnPackageListReq.getBriefDescriptionArabic());
	  	colSearchMap.put("LONG_DESC_ENG", returnPackageListReq.getLongDescriptionEnglish());
	  	colSearchMap.put("LONG_DESC_ARAB", returnPackageListReq.getLongDescriptionArabic());
		colSearchMap.put("STATUS", returnPackageListReq.getStatus());
	  		
	  	// HashMap contains all key with value "number" or "text" For DynamicFilter
	  	HashMap<String, String> colTypeMap = new HashMap<>();
	  	colTypeMap.put("BRIEF_DESC_ENG", "text");
	  	colTypeMap.put("BRIEF_DESC_ARAB", "text");
	  	colTypeMap.put("LONG_DESC_ENG", "text");
	  	colTypeMap.put("LONG_DESC_ARAB", "text");
	  	colTypeMap.put("STATUS", "text");
	  	
	  	alertCommonWSSC.setSearchCols(searchCol);
	  	alertCommonWSSC.setColSearchMap(colSearchMap);
	  	alertCommonWSSC.setColTypeMap(colTypeMap);
	  	alertCommonWSSC.setDynamicFilter(returnPackageListReq.getDynamicFilter());
	  		
	  	//function to validate operator and return search query
	  	alertCommonWSSC = alertServiceUtilBo.FilterAndValidateList(alertCommonWSSC);
	  	
	    //copying all alertCommonWSSC properties to individualSubscriberSC
	  	PathPropertyUtil.copyMainNotNullProperties(alertCommonWSSC, packageEventSC);

	  	packageEventSC.setLangCode(returnPackageListReq.getRequesterContext().getLangId());
	  	packageEventSC.setIvCrud(AlertConstant.CRUD_R);
	  	packageEventSC.setNbRec(AlertConstant.INT_MINUS_ONE);
	  	packageEventSC.setLovTypeId(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
	  	
	  	//return Package List from PackageEventBoImpl
	  	List<PackageEventListCO> packageEventListCOs =  packageEventBO.pkgEventList(packageEventSC);
	  	
	  	PackageEventListCO packageEventListCO = new PackageEventListCO();
	  	Packages packages = new Packages();
	  	for(int i=0; i<packageEventListCOs.size(); i++)
	  	{
	  		packageEventListCO = packageEventListCOs.get(i);
	  		packages = new Packages();
	  		packages.setPackageId(packageEventListCO.getPKG_ID());
	  		packages.setBriefDescriptionEnglish(packageEventListCO.getBRIEF_DESC_ENG());
	  		packages.setBriefDescriptionArabic(packageEventListCO.getBRIEF_DESC_ARAB());
	  		packages.setLongDescriptionEnglish(packageEventListCO.getLONG_DESC_ENG());
	  		packages.setLongDescriptionArabic(packageEventListCO.getLONG_DESC_ARAB());
	  		packages.setStatus(packageEventListCO.getSTATUS());
	  		
	  		returnPackageListResp.getPackageEventList().add(packages);
	  	}
	  	return returnPackageListResp;
	}

	public void setPackageEventBO(PackageEventBO packageEventBO) {
		this.packageEventBO = packageEventBO;
	}

	public void setAlertServiceUtilBo(AlertServiceUtilBO alertServiceUtilBo) 
	{
		this.alertServiceUtilBo = alertServiceUtilBo;
	}

	@Override
	public Map<String, Object> returnPackageListCount(Map<String, Object> reqMap) throws Exception {
			PackageEventSC pkgEventSC = (PackageEventSC) PathPropertyUtil.convertToObject((HashMap<String, Object>) reqMap, PackageEventSC.class);
		    pkgEventSC.setCompCode((BigDecimal) reqMap.get("COMP_CODE"));
		    pkgEventSC.setLovTypeId(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);					   
		    pkgEventSC.setLangCode(ConstantsCommon.LANGUAGE_ENGLISH);
		    
		    pkgEventSC.setIvCrud("F");
		    
		    Map<String, Object> result = new HashMap<String, Object>();
		    result.put("count", packageEventBO.pkgEventCount(pkgEventSC));
		    return result;	    
	}

	@Override
	public Map<String, Object> returnPackageList(Map<String, Object> reqMap) throws Exception {
		PackageEventSC pkgEventSC = (PackageEventSC) PathPropertyUtil.convertToObject((HashMap<String, Object>) reqMap, PackageEventSC.class);

		pkgEventSC.setCompCode((BigDecimal) reqMap.get("COMP_CODE"));
	    pkgEventSC.setLovTypeId(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);					   
	    pkgEventSC.setLangCode(ConstantsCommon.LANGUAGE_ENGLISH);
	    pkgEventSC.setIvCrud("F");
	    
		//Wrap this list in HashMap 
		Map<String, Object> listMap = new HashMap<>();
		List<PackageEventListCO> packageListCOs = new ArrayList<>();
		if (NumberUtil.isEmptyDecimal(pkgEventSC.getPkgId())) {
			packageListCOs = packageEventBO.pkgEventList(pkgEventSC);
		} else {
			PackageEventListCO co = packageEventBO.pkgEventListById(pkgEventSC);
			if (null != co) {
				packageListCOs.add(co);
			}
		}
	    List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

	    for(PackageEventListCO co : packageListCOs )
	    {
		    HashMap<String, Object> map = PathPropertyUtil.convertToMap(co);
		    result.add(map);
	    }
	    listMap.put("packageList", result);
	    return  listMap;
	}

}
