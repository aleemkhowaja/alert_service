package com.path.alert.bo.common;

import java.math.BigDecimal;

import com.path.bo.common.CommonLibBO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;

public class AlrtCommonConstants
{
	
	// LOV ID
    public static final BigDecimal LOV_TYPE_CONS_COMMON_STATUS = new BigDecimal(949);
    
    public static final BigDecimal LANGUAGES_LOV_TYPE = new BigDecimal(412);
    
    public static final String OMNI_ADMIN_APP_NAME = "OADM";
    
    /**
     * is Omni Installed flag
     */
    public static Boolean isOmniInstalled;
    
    static
	{
		/**
		 * Check if isOmniInstalled = null then check the omniodmin installed
		 */
		if (AlrtCommonConstants.isOmniInstalled == null) {
			try {
				checkOMNIInstalled();
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}
		
	}

    /**
     * get omni installed by checkinf from S_APP table
     * @throws BaseException
     */
	private static void checkOMNIInstalled() throws BaseException 
	{
		// get manual wire the BO
		CommonLibBO commonLibBO = (CommonLibBO) ApplicationContextProvider
								.getApplicationContext().getBean("commonLibBO");
		S_APPVO sAppVO = new S_APPVO();
		sAppVO.setAPP_NAME(AlrtCommonConstants.OMNI_ADMIN_APP_NAME);
		AlrtCommonConstants.isOmniInstalled = commonLibBO.returnApplication(sAppVO) != null;
	}
    
    
}
