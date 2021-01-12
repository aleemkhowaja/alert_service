package com.path.alert.dao.todoalert;

import java.util.List;

import com.path.alert.vo.common.TodoAlertSC;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * TodoAlertDAO.java used to used Todo Alert
 */
public interface TodoAlertDAO
{
    /**
     * return rows count of todo Alerts
     * @param criteria
     * @return
     * @throws DAOException
     */
    public Integer returnTodoAlertCount(TodoAlertSC criteria) throws DAOException;

    /**
     *  return list of todo Alerts
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<SYS_PARAM_TODO_ALERT_TYPEVO> returnTodoAlertList(TodoAlertSC criteria) throws DAOException;

}
