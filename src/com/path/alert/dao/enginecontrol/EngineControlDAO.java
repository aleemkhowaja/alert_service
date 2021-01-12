package com.path.alert.dao.enginecontrol;

import java.util.List;

import com.path.alert.vo.enginecontrol.EngineControlCO;
import com.path.alert.vo.enginecontrol.EngineControlSC;
import com.path.lib.common.exception.DAOException;

public interface EngineControlDAO {

	/*
	 * return rows count of "ALRT_ENG_REQUEST" table on specified criteria
	 */
	public Integer returnAlertEngineRequestCount(EngineControlSC criteria) throws DAOException;

	/*
	 * return rows data of last updated "ALRT_ENG_REQUEST" table on specified
	 * criteria
	 */
	public List<EngineControlCO> returnAlertEngineRequest(EngineControlSC criteria) throws DAOException;

	/**
	 * return subscriber id rows count, it's get APPROVED records from ALRT_SUB table
	 */
	public Integer subIdLookupQueryCount(EngineControlSC criteria) throws DAOException;

	/**
	 * return subscriber lookup rows. this lookup show in Engine Control screen, it's get APPROVED records from ALRT_SUB table
	 */
	public List<EngineControlCO> subIdLookupQueryList(EngineControlSC criteria) throws DAOException;

	/**
	 * return alert user id rows count, it's get APPROVED records from ALRT_SUB table which are not NULL  
	 */
	public Integer alertUserLookupQueryCount(EngineControlSC criteria) throws DAOException;

	/**
	 * return Alert user id lookup rows.this lookup show in Engine Control screen, it's get APPROVED records from ALRT_SUB table which are not NULL  
	 */
	public List<EngineControlCO> alertUserLookupQueryList(EngineControlSC criteria) throws DAOException;

	/**
	 * return Channel id rows count, it's get DISTINCT channel end user from 'ALRT_SUB' table 
	 */
	public Integer channelIdLookupQueryCount(EngineControlSC criteria) throws DAOException;

	/**
	 * returnChannel End User lookup rows.this lookup show in Engine Control screen, it's get DISTINCT channel end user from 'ALRT_SUB' table 
	 */
	public List<EngineControlCO> channelIdLookupQueryList(EngineControlSC criteria) throws DAOException;

}
