package com.path.alert.bo.todoalert;

import java.util.List;

import com.path.alert.vo.common.ProgRefSC;
import com.path.alert.vo.common.TodoAlertSC;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * TodoAlertBO.java used to
 */
public interface TodoAlertBO {

    /**
     * return todoAlert list by application and todoAlertType
     * @param TodoAlertSC
     * @return
     * @throws BaseException
     */
    public List<SYS_PARAM_TODO_ALERT_TYPEVO> returnTodoAlertList(TodoAlertSC criteria) throws BaseException;

    /**
     * return todoAlert count  by application and todoAlertType
     * @param ProgRefSC
     * @return
     * @throws BaseException
     */
    public Integer returnTodoAlertCount(TodoAlertSC criteria) throws BaseException;
    
    /**
     * return todAlert details by id
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public SYS_PARAM_TODO_ALERT_TYPEVO returnTodoAlertById(TodoAlertSC criteria) throws BaseException;
	
}
