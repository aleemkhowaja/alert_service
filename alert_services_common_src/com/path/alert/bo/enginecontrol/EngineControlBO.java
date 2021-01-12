package com.path.alert.bo.enginecontrol;

import java.util.List;

import com.path.alert.vo.enginecontrol.EngineControlCO;
import com.path.alert.vo.enginecontrol.EngineControlSC;
import com.path.lib.common.exception.BaseException;

/**
 * This will hold the engine Control
 * 
 */
public interface EngineControlBO
{

    /**
     * 
     * start alert engine node via call RMI of alert engine
     */
    public void start(EngineControlCO engineControlCO) throws BaseException;

    /**
     * shutdown alert engine node via call RMI of alert engine
     */
    public void shutdown(EngineControlCO engineControlCO) throws BaseException;

    /**
     * return alert engine node status via call RMI of alert engine
     */
    public String returnEngineStatus(EngineControlCO engineControlCO) throws BaseException;

    /**
     * return rows count of "ALRT_ENG_REQUEST" table on specified criteria
     */
    public Integer returnAlertEngineRequestCount(EngineControlSC criteria) throws BaseException;

    /**
     * return rows data of last updated "ALRT_ENG_REQUEST" table on specified
     * criteria
     */
    public List<EngineControlCO> returnAlertEngineRequest(EngineControlSC criteria) throws BaseException;
    
    /**
     * return subscriber id rows count, it's use to build 'Subscriber Id' Lookup 
     */    
	public Integer subIdLookupQueryCount(EngineControlSC criteria) throws BaseException;
	
	/**
     * return subscriber lookup rows. this lookup show in Engine Control screen
     */    	
	public List<EngineControlCO> subIdLookupQueryList(EngineControlSC criteria) throws BaseException;
	
	/**
     * return alert user id rows count, it's use to build 'User Id' Lookup 
     */
	public Integer alertUserLookupQueryCount(EngineControlSC criteria) throws BaseException;

	/**
     * return Alert user id lookup rows.this lookup show in Engine Control screen 
     */    	
	public List<EngineControlCO> alertUserLookupQueryList(EngineControlSC criteria) throws BaseException;
		
	/**
     * return Channel id rows count, it's use to build 'Channel End User' Lookup 
     */
	public Integer channelIdLookupQueryCount(EngineControlSC criteria) throws BaseException;

	/**
     * returnChannel End User lookup rows.this lookup show in Engine Control screen 
     */    
	public List<EngineControlCO> channelIdLookupQueryList(EngineControlSC criteria) throws BaseException;

}
