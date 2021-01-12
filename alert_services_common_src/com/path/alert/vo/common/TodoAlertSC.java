package com.path.alert.vo.common;

import com.path.struts2.lib.common.GridParamsSC;

public class TodoAlertSC extends GridParamsSC
{
    private String appName;
    private String todoAlert;
    private String todoAlertType;

    /**
     * @return the toAlert
     */
    public String getTodoAlert()
    {
	return todoAlert;
    }

    /**
     * @param toAlert the toAlert to set
     */
    public void setTodoAlert(String todoAlert)
    {
	this.todoAlert = todoAlert;
    }

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
     * @return the todoAlertType
     */
    public String getTodoAlertType()
    {
	return todoAlertType;
    }

    /**
     * @param todoAlertType the todoAlertType to set
     */
    public void setTodoAlertType(String todoAlertType)
    {
	this.todoAlertType = todoAlertType;
    }
}