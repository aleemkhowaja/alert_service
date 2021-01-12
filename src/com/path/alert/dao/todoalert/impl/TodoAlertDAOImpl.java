package com.path.alert.dao.todoalert.impl;

import java.util.List;

import com.path.alert.dao.todoalert.TodoAlertDAO;
import com.path.alert.vo.common.TodoAlertSC;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class TodoAlertDAOImpl extends BaseDAO implements TodoAlertDAO
{

    @Override
    public Integer returnTodoAlertCount(TodoAlertSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "SYS_PARAM_TODO_ALERT_TYPE.BaseResultMap");
	return ((Integer) getSqlMap().queryForObject("todoAlertMapper.returnTodoAlertCount", criteria)).intValue();
    }

    @Override
    public List<SYS_PARAM_TODO_ALERT_TYPEVO> returnTodoAlertList(TodoAlertSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "SYS_PARAM_TODO_ALERT_TYPE.BaseResultMap");
	List<SYS_PARAM_TODO_ALERT_TYPEVO> lst;

	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("todoAlertMapper.returnTodoAlertList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("todoAlertMapper.returnTodoAlertList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
	return lst;
    }

    
   
}
