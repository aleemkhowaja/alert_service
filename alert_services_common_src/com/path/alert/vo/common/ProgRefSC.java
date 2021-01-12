package com.path.alert.vo.common;

import com.path.struts2.lib.common.GridParamsSC;

public class ProgRefSC extends GridParamsSC
{
    private String appName;
    private String progRef;

    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
}