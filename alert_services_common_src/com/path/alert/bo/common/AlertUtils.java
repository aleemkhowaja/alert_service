package com.path.alert.bo.common;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.BaseSC;
import com.path.struts2.lib.common.ConnectionCO;

public class AlertUtils
{
    /**
     * Connection co for core db
     */
    private static ConnectionCO connCO;
    
    
    /**
     * Static block to initiate the conx
     */
    static {
    	prepareConnectionCo();
    }

    /**
     * prepare the connection for core db
     * 
     * @return
     */
    public static void prepareConnectionCo()
    {
    	// get manual wire the BO
    	CommonLibBO commonLibBO = (CommonLibBO) ApplicationContextProvider
    									.getApplicationContext().getBean("commonLibBO");
    	//@todo @alim add stringutils null to empty
    	try {
			if(StringUtil.nullToEmpty(commonLibBO.returnPthCtrl1().getCORE_IMAL_YN()).equals(ConstantsCommon.NO))
			{
				//@todo @alim it should be synchronized
				// or we need to call it once at the start of the server
				if(connCO == null)
				{
				    BaseSC sc = new BaseSC();
				    String jndiname = "services.jndi";
				    sc.setUseConnection(Boolean.TRUE);
				    CommonMethods.applyConnectionJNDIToSC(sc, jndiname);
				    connCO = sc.getConnCO();
				}
			}
		} catch (BaseException e) {
			e.printStackTrace();
		}
    }

    /**
     * @return the connCO
     */
    public static ConnectionCO returnConnectionCo()
    {
        return connCO;
    }

}
