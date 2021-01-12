package com.path.alert.bo.subscriber.individual;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.math.BigDecimal;

import com.path.lib.common.util.PathPropertyUtil;

public class IndividualSubscriberConstant {
	
	public static final String SUBSCRIBER_PROG_REF = "IND00MT";
	public static final String SUBSCRIBER_UPDATE_AFTER_APPROVE_PROG_REF = "IND00MA";
	public static final String MAINTENANCE_IV_CRUD = "R";
	
	public static final BigDecimal OMNI_USER_CUSTOMER  = BigDecimal.valueOf(1101);
	public static final BigDecimal CON_BUSINESS_PROFILE = BigDecimal.valueOf(22);
	public static final BigDecimal OC_APPLICATION       = BigDecimal.valueOf(101);
	public static final String ERROR_CODE_SEPARATOR = "~#~";
	public static final String LANG_CODE_EN = "EN";
	
	public static final String OADM_SERVICE_URL = "oadm.serviceURL";
	public static final String OMNI_SERVICE_EXPORTER = "omniUserBOService";
	public static final String OMNI_SERVICE_REMOTING = "PathOADMRemoting.properties";
	
	public static String returnOmniApplicationRmi()
    {
		String rmiUrl = null;
		try
		{
		    rmiUrl = PathPropertyUtil.returnPathPropertyFromFile(IndividualSubscriberConstant.OMNI_SERVICE_REMOTING, IndividualSubscriberConstant.OADM_SERVICE_URL);
		    rmiUrl = (rmiUrl == null) ? "" : rmiUrl;
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		return rmiUrl;
    }
	
}
