package com.path.alert.bo.todoalert.impl;

import java.util.List;

import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.todoalert.TodoAlertBO;
import com.path.alert.dao.todoalert.TodoAlertDAO;
import com.path.alert.vo.common.TodoAlertSC;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * TodoAlertBOImpl.java used to
 */
public class TodoAlertBOImpl extends BaseBO implements TodoAlertBO
{

    private TodoAlertDAO todoAlertDAO;

    @Override
    public List<SYS_PARAM_TODO_ALERT_TYPEVO> returnTodoAlertList(TodoAlertSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());
	
	return todoAlertDAO.returnTodoAlertList(criteria);
    }

    @Override
    public Integer returnTodoAlertCount(TodoAlertSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());
	
	return todoAlertDAO.returnTodoAlertCount(criteria);
    }

    @Override
    public SYS_PARAM_TODO_ALERT_TYPEVO returnTodoAlertById(TodoAlertSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	SYS_PARAM_TODO_ALERT_TYPEVO alert_TYPEVO = new SYS_PARAM_TODO_ALERT_TYPEVO();
	alert_TYPEVO.setAPP_NAME(criteria.getAppName());
	alert_TYPEVO.setTODO_ALERT(criteria.getTodoAlert());
	
	/*
	 * Set Connection Object
	 */
	alert_TYPEVO.setConnCO(AlertUtils.returnConnectionCo());
	
	alert_TYPEVO = (SYS_PARAM_TODO_ALERT_TYPEVO) genericDAO.selectByPK(alert_TYPEVO);
	
	return alert_TYPEVO;
    }

    /**
     * @param todoAlertDAO the todoAlertDAO to set
     */
    public void setTodoAlertDAO(TodoAlertDAO todoAlertDAO)
    {
        this.todoAlertDAO = todoAlertDAO;
    }


    
}