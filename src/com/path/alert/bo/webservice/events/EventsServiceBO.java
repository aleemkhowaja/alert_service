package com.path.alert.bo.webservice.events;
import java.util.Map;

import com.path.lib.common.exception.BaseException;
import com.path.vo.alert.event.ReturnEventDetailsReq;
import com.path.vo.alert.event.ReturnEventDetailsResp;
import com.path.vo.alert.event.ReturnEventsListReq;
import com.path.vo.alert.event.ReturnEventsListResp;

public interface EventsServiceBO {	
	
	/**
	 * 
	 * @param ReturnEventsListReq
	 * @return
	 * @throws Exception
	 */
	public ReturnEventsListResp returnEventsList(ReturnEventsListReq returnEventsListReq)throws Exception;
	
	/** Return list of all  IndividualEvent
	* @param criteria
	* @return
	* @throws BaseException
	* By Shahnawaz
	*/
	public Map<String, Object> returnIndividualEventListCount(Map<String, Object> criteria) throws BaseException;
	
	/**
	* Return list of all  IndividualEvent
	* @param criteria
	* @return
	* @throws BaseException
	* By Shahnawaz
	*/
	public Map<String, Object> returnIndividualEventList(Map<String, Object> criteria) throws BaseException;
	
	/**
	 * return Event Details
	 * @param returnEventDetailsReq
	 * @return
	 * @throws BaseException
	 */
	public ReturnEventDetailsResp returnEventDetails(ReturnEventDetailsReq  returnEventDetailsReq) throws BaseException;
	
}
