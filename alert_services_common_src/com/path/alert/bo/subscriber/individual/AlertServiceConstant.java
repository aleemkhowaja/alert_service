package com.path.alert.bo.subscriber.individual;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import com.path.lib.common.util.PathPropertyUtil;

public class AlertServiceConstant {
	public static final String ERROR_CODE_SEPARATOR = "~#~";
	
	public static final String OMNI_SERVICE_URL = "alert.omni.serviceURL";
	public static final String OMNI_SERVICE_EXPORTER = "omniUserBOService";
	public static final String OMNI_SERVICE_REMOTING = "PathRemoting.properties";
	
	public static String returnApplicationRmi(String serviceURL)
    {
		String rmiUrl = null;
		try
		{
		    rmiUrl = PathPropertyUtil.returnPathPropertyFromFile(IndividualSubscriberConstant.OMNI_SERVICE_REMOTING, serviceURL);
		    rmiUrl = (rmiUrl == null) ? "" : rmiUrl;
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		return rmiUrl;
    }
	
}
