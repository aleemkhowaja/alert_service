package com.path.alert.bo.webservice.events.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.events.event.IndividualEventBO;
import com.path.alert.bo.events.event.IndividualEventConstant;
import com.path.alert.bo.webservice.AlertServiceUtilBO;
import com.path.alert.bo.webservice.events.EventsServiceBO;
import com.path.alert.vo.events.event.IndividualEventCO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.alert.event.CommunicationMode;
import com.path.vo.alert.event.Event;
import com.path.vo.alert.event.ReturnEventDetailsReq;
import com.path.vo.alert.event.ReturnEventDetailsResp;
import com.path.vo.alert.event.ReturnEventsListReq;
import com.path.vo.alert.event.ReturnEventsListResp;


public class EventsServiceBOImpl extends BaseBO implements EventsServiceBO {
	
	//Individual Events BoImpl
	private IndividualEventBO individualEventBO;
	
	//Alert Service BoImpl
	private AlertServiceUtilBO alertServiceUtilBo;


	@Override
	public ReturnEventsListResp returnEventsList(ReturnEventsListReq returnEventsListReq) throws Exception {

		ReturnEventsListResp returnEventsListResp = new ReturnEventsListResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(returnEventsListReq, returnEventsListResp);
	    PathPropertyUtil.copyProperties(returnEventsListReq.getServiceContext(),returnEventsListResp.getResponseServiceContext());
		
		IndividualEventSC indEventSC = new IndividualEventSC();
		
		AlertCommonWSSC alertCommonWSSC = new AlertCommonWSSC();
		
		String[] searchCol = {"STATUS", "EVT_TYPE", "COMP_CODE", "DESC_ENG", "DESC_ARAB"};
		indEventSC.setSearchCols(searchCol);
	    
	    //fill map for search same as assets
	  	HashMap<String, Object> colSearchMap = new HashMap<>();
	  	colSearchMap.put("DESC_ENG", returnEventsListReq.getDescriptionEnglish());
		colSearchMap.put("DESC_ARAB", returnEventsListReq.getDescriptionArabic());
	  	colSearchMap.put("COMP_CODE", returnEventsListReq.getCompanyCode());
	  	colSearchMap.put("EVT_TYPE", returnEventsListReq.getEventType());
	  	colSearchMap.put("STATUS", returnEventsListReq.getStatus());
		
	  		
	  	// HashMap contains all key with value "number" or "text" For DynamicFilter
	  	HashMap<String, String> colTypeMap = new HashMap<>();
	  	colTypeMap.put("DESC_ENG", "text");
	  	colTypeMap.put("DESC_ARAB", "text");
	  	colTypeMap.put("COMP_CODE", "number");
	  	colTypeMap.put("EVT_TYPE", "text");
	  	colTypeMap.put("STATUS", "text");
	  	
	  	alertCommonWSSC.setSearchCols(searchCol);
	  	alertCommonWSSC.setColSearchMap(colSearchMap);
	  	alertCommonWSSC.setColTypeMap(colTypeMap);
	  	alertCommonWSSC.setDynamicFilter(returnEventsListReq.getDynamicFilter());
	  	
	  	
	  	//function to validate operator and return search query
	  	alertCommonWSSC = alertServiceUtilBo.FilterAndValidateList(alertCommonWSSC);
	  	
	  	//copying all alertCommonWSSC properties to individualSubscriberSC
	  	PathPropertyUtil.copyMainNotNullProperties(alertCommonWSSC, indEventSC);
	  	
		indEventSC.setCompCode(returnEventsListReq.getCompanyCode());
	    indEventSC.setLangCode(returnEventsListReq.getRequesterContext().getLangId());
	    indEventSC.setLovType(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
	    indEventSC.setEvtType(AlertConstant.eventTypeDropDown);
	    indEventSC.setModeType(AlertConstant.eventModeDropDown);
	    
	    /**
	     * retrieve event based on communication mode
	     * following parameters have recieved from webservice request
	     * E = Only Email records will be retrieve
	     * S = Only SMS records will be retrieve
	     * B = Both Email and SMS records will be retrieve
	     * 
	     * Date = 13/02/2020 By Aleem
	     * Requested by Patricia
	     */
	    indEventSC.setCommunicationModeLovType(IndividualEventConstant.COMMUNICATION_TYPE_LOV_TYPE);
	    indEventSC.setCommType(returnEventsListReq.getCommunicationType());
	    
	    //indEventSC.setPriorityType(AlertConstant.eventPriorityDropDown);
	    indEventSC.setFixedEventId(AlertConstant.FIX_EVENT_CHANNEL_SERVICE_ID);
	    indEventSC.setEventType(returnEventsListReq.getEventType());
	    indEventSC.setStatus(returnEventsListReq.getStatus());
	    indEventSC.setNbRec(AlertConstant.INT_MINUS_ONE);
	    List<IndividualEventListCO> indEventList = individualEventBO.indEventList(indEventSC);
	    
	    if(null != indEventList && !indEventList.isEmpty())
		{
	    	List<Event> eventsList = new ArrayList<Event>();
			for(IndividualEventListCO individualEventListCO : indEventList)
			{
				Event event = new Event();
				event.setEventId(individualEventListCO.getEVT_ID());
				event.setEventType(individualEventListCO.getEVT_TYPE());
				event.setDescriptionEnglish(individualEventListCO.getDESC_ENG());
				event.setDescriptionArabic(individualEventListCO.getDESC_ARAB());
				event.setCommunicationDescription(individualEventListCO.getCommunicationDescription());
				event.setStatus(individualEventListCO.getSTATUS());
				eventsList.add(event);					
			}
			returnEventsListResp.setEventsList(eventsList);
		}
		return returnEventsListResp;
	}
	
	public void setIndividualEventBO(IndividualEventBO individualEventBO) {
		this.individualEventBO = individualEventBO;
	}

	public void setAlertServiceUtilBo(AlertServiceUtilBO alertServiceUtilBo) 
	{
		this.alertServiceUtilBo = alertServiceUtilBo;
	}
	
	@Override
	public Map<String, Object> returnIndividualEventListCount(Map<String, Object> criteria) throws BaseException
	{
		IndividualEventSC indEventSC = (IndividualEventSC) PathPropertyUtil.convertToObject((HashMap<String, Object>) criteria, IndividualEventSC.class);
	    indEventSC.setCompCode((BigDecimal) criteria.get("COMP_CODE"));
	    indEventSC.setLovType(AlertConstant.EVENT_STATUS_LOV_TYPE);
	    indEventSC.setEventType(AlertConstant.EVT_MODE_B);
	    indEventSC.setLangCode(ConstantsCommon.LANGUAGE_ENGLISH);
	    
	    Map<String, Object> result = new HashMap<String, Object>();
	    result.put("count", individualEventBO.indEventCount(indEventSC));
	    return result;	    
	}

	@Override
	public Map<String, Object> returnIndividualEventList(Map<String, Object> criteria) throws BaseException 
	{
		IndividualEventSC indEventSC = (IndividualEventSC) PathPropertyUtil.convertToObject((HashMap<String, Object>) criteria, IndividualEventSC.class);
	    indEventSC.setLovType(AlertConstant.EVENT_STATUS_LOV_TYPE);
	    indEventSC.setEventType(AlertConstant.EVT_MODE_B);
	    indEventSC.setLangCode(ConstantsCommon.LANGUAGE_ENGLISH);
	    //Wrap this list in Msap 
	    Map<String, Object> listMap = new HashMap<>();
	    List<IndividualEventListCO> individualEventListCOs = individualEventBO.indEventList(indEventSC);
	    
	    List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

	    for(IndividualEventListCO batch : individualEventListCOs )
	    {
		    HashMap<String, Object> map = PathPropertyUtil.convertToMap(batch);
		    result.add(map);
	    }
	    listMap.put("eventList", result);
	    return  listMap;
	}

	@Override
	public ReturnEventDetailsResp returnEventDetails(ReturnEventDetailsReq returnEventDetailsReq)
		throws BaseException
	{
	    ReturnEventDetailsResp returnEventDetailsResp = new ReturnEventDetailsResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(returnEventDetailsReq, returnEventDetailsResp);
	    PathPropertyUtil.copyProperties(returnEventDetailsReq.getServiceContext(),returnEventDetailsResp.getResponseServiceContext());
		
	    IndividualEventSC indEventSC = new IndividualEventSC();
	    indEventSC.setEventID(returnEventDetailsReq.getEventId());
	    indEventSC.setCompCode(returnEventDetailsReq.getCompanyCode());
	    indEventSC.setLangCode(returnEventDetailsReq.getRequesterContext().getLangId());
	    indEventSC.setLovType(AlertConstant.EVENT_STATUS_LOV_TYPE);
	    indEventSC.setEmailCommunicationType(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE);
	    indEventSC.setSmsCommunicationType(IndividualEventConstant.SMS_COMMUNICATION_TYPE);
	    indEventSC.setOmniInboxCommunicationType(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE);
	    
	    /**
	     * return Event Details
	     * with all communication Type Details
	     */
	    IndividualEventCO individualEventCO =  individualEventBO.returnIndividualEventByEventId(indEventSC);
	    
	    if(null == individualEventCO)
	    {
		throw new BOException(MessageCodes.NO_RECORD_FOUND);
	    }
	    
	    returnEventDetailsResp.setEventId(individualEventCO.getAlrtEvtVO().getEVT_ID());
	    returnEventDetailsResp.setCompanyCode(individualEventCO.getAlrtEvtVO().getCOMP_CODE());
	    returnEventDetailsResp.setDescriptionArabic(individualEventCO.getAlrtEvtVO().getDESC_ARAB());
	    returnEventDetailsResp.setDescriptionEnglish(individualEventCO.getAlrtEvtVO().getDESC_ENG());
	    returnEventDetailsResp.setEventType(individualEventCO.getAlrtEvtVO().getEVT_TYPE());
	    returnEventDetailsResp.setStatus(individualEventCO.getAlrtEvtVO().getSTATUS());
		
	    /**
	     * get Communication modes from eventCO
	     */
	    ALRT_EVT_COMM_MODEVO  emailCommMode =  individualEventCO.getEmail_EVT_COMM_MODEVO();
	    ALRT_EVT_COMM_MODEVO smsCommMode = individualEventCO.getSms_EVT_COMM_MODEVO();
	    ALRT_EVT_COMM_MODEVO pushNotCommMode = individualEventCO.getOmniInbox_EVT_COMM_MODEVO();
	    
	    List<CommunicationMode> communicationModeList = new ArrayList<CommunicationMode>();
		
	    /**
	     * Email Communication Mode Details
	     */
	    if(null != emailCommMode)
	    {
		CommunicationMode emailComm = new CommunicationMode();
		emailComm.setCommunicationType(emailCommMode.getCOMMUNICATION_TYPE());
		emailComm.setDefaultSubject(emailCommMode.getDEFAULT_MESSAGE_SUBJECT());
		emailComm.setDefaultBody(emailCommMode.getDEFAULT_MESSAGE_BODY());
		emailComm.setQueryId(emailCommMode.getQUERY_ID());
		emailComm.setReportId(emailCommMode.getREPORT_ID());
		emailComm.setActivatedYN(emailCommMode.getACTIVATED_YN());
		communicationModeList.add(emailComm);
	    }
	    
		
	    /**
	     * Sms Communication Mode Details
	     */
	    if(null != smsCommMode)
	    {
		CommunicationMode smsComm = new CommunicationMode();
		smsComm.setCommunicationType(smsCommMode.getCOMMUNICATION_TYPE());
		smsComm.setDefaultSubject(smsCommMode.getDEFAULT_MESSAGE_SUBJECT());
		smsComm.setDefaultBody(smsCommMode.getDEFAULT_MESSAGE_BODY());
		smsComm.setQueryId(smsCommMode.getQUERY_ID());
		smsComm.setReportId(smsCommMode.getREPORT_ID());
		smsComm.setActivatedYN(smsCommMode.getACTIVATED_YN());
		communicationModeList.add(smsComm);
	    }
	    
		
		
	    /**
	     * Omni Push Notfications Communication Mode Details
	     */
	    
	    if(null != pushNotCommMode)
	    {
		CommunicationMode pushNotifComm = new CommunicationMode();
		pushNotifComm.setCommunicationType(pushNotCommMode.getCOMMUNICATION_TYPE());
		pushNotifComm.setDefaultSubject(pushNotCommMode.getDEFAULT_MESSAGE_SUBJECT());
		pushNotifComm.setDefaultBody(pushNotCommMode.getDEFAULT_MESSAGE_BODY());
		pushNotifComm.setQueryId(pushNotCommMode.getQUERY_ID());
		pushNotifComm.setReportId(pushNotCommMode.getREPORT_ID());
		pushNotifComm.setActivatedYN(pushNotCommMode.getACTIVATED_YN());
		communicationModeList.add(pushNotifComm);
	    }
	    
	    returnEventDetailsResp.setCommunicationModeList(communicationModeList);
	    
	    return returnEventDetailsResp;
	}
	
	
}
