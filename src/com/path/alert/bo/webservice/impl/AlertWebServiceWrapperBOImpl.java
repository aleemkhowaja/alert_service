package com.path.alert.bo.webservice.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.events.event.IndividualEventBO;
import com.path.alert.bo.webservice.AlertWebServiceWrapperBO;
import com.path.alert.bo.webservice.AlertWebServiceWrapperConstant;
import com.path.alert.bo.webservice.events.EventsServiceBO;
import com.path.alert.bo.webservice.packages.PackagesServiceBO;
import com.path.alert.bo.webservice.subscriber.IndividualSubscriberServiceBO;
import com.path.alert.bo.webservice.subscription.SubscriptionServiceBO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.service.AlertServiceCO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.WebServiceBaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.vo.alert.event.ReturnEventDetailsReq;
import com.path.vo.alert.event.ReturnEventDetailsResp;
import com.path.vo.alert.event.ReturnEventsListReq;
import com.path.vo.alert.event.ReturnEventsListResp;
import com.path.vo.alert.packages.ReturnPackageListReq;
import com.path.vo.alert.packages.ReturnPackageListResp;
import com.path.vo.alert.subscriber.ApproveSubscriberReq;
import com.path.vo.alert.subscriber.ApproveSubscriberResp;
import com.path.vo.alert.subscriber.CreateSubscriberReq;
import com.path.vo.alert.subscriber.CreateSubscriberResp;
import com.path.vo.alert.subscriber.DeleteSubscriberReq;
import com.path.vo.alert.subscriber.DeleteSubscriberResp;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsReq;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsResp;
import com.path.vo.alert.subscriber.ReturnSubscribersListReq;
import com.path.vo.alert.subscriber.ReturnSubscribersListResp;
import com.path.vo.alert.subscriber.UpdateSubscriberReq;
import com.path.vo.alert.subscriber.UpdateSubscriberResp;
import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGEReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGEResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGPReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGPResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSEReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSEResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSPReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSPResp;
import com.path.vo.alert.subscription.DeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.DeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionResp;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsReq;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsResp;
import com.path.vo.alert.subscription.ReturnSubscriptionListReq;
import com.path.vo.alert.subscription.ReturnSubscriptionListResp;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionReq;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionResp;
import com.path.vo.common.ImBaseRequest;


public class AlertWebServiceWrapperBOImpl extends WebServiceBaseBO implements AlertWebServiceWrapperBO {
	
	//Individual Events BoImpl
	private IndividualEventBO individualEventBO;
	
	//Individual Subscriber Service Bo
	private IndividualSubscriberServiceBO individualSubscriberServiceBO;
	
	//Event Service Bo
	private EventsServiceBO eventsServiceBO;
	
	//Packages Service BO
	private PackagesServiceBO packagesServiceBO;
	
	//Subscription Service BO
	private SubscriptionServiceBO subscriptionServiceBO;
	
	//LoginBo fo authenticate user
	private LoginBO loginBO;
	

	@Override
	public HashMap<String, Object> getAlertEvents(HashMap<String, Object> hashIn) throws Exception 
	{
		initializeServiceCall(hashIn);
		try {
			AlertServiceCO alertServiceCO = new AlertServiceCO();
			alertServiceCO.getAlertEVTVO().setEVT_MODE((String)hashIn.get("as_evnt_mode"));
			alertServiceCO.getAlertEVTVO().setEVT_TYPE((String)hashIn.get("as_evnt_type"));
			alertServiceCO = individualEventBO.getAlertEvents(alertServiceCO);
			HashMap<String,Object> hashOut = new HashMap<String,Object>();
			List<HashMap<String,Object>> lstOut = new ArrayList();
			if(null != alertServiceCO.getLstIndvEventCO() && !alertServiceCO.getLstIndvEventCO().isEmpty())
			{
				HashMap<String,Object> hashOutRow;
				for(IndividualEventListCO individualEventListCO : alertServiceCO.getLstIndvEventCO())
				{
					hashOutRow = new HashMap<String,Object>();
					hashOutRow.put("al_evnt_id", individualEventListCO.getEVT_ID());
					hashOutRow.put("as_status", individualEventListCO.getSTATUS());
					hashOutRow.put("as_evnt_type", individualEventListCO.getEVT_TYPE());
					hashOutRow.put("as_evnt_mode", individualEventListCO.getEVT_MODE());
					hashOutRow.put("as_desc_eng", individualEventListCO.getDESC_ENG());
					hashOutRow.put("as_desc_arab", individualEventListCO.getDESC_ARAB());
					lstOut.add(hashOutRow);					
				}
			}
			hashOut.put("Individual_List", lstOut);
		}
		catch (Exception ex) 
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> insertAlertQue(HashMap<String, Object> hashIn) throws Exception 
	{
		// TODO Auto-generated method stub
		initializeServiceCall(hashIn);
		try{
			AlertServiceCO alertServiceCO = new AlertServiceCO();
			alertServiceCO.getAlertQueVO().setMESSAGE_SUBJECT_ENG((String)hashIn.get("as_message_subject_eng"));
			alertServiceCO.getAlertQueVO().setMESSAGE_TEXT_ENG((String)hashIn.get("as_message_text_eng"));
			alertServiceCO.getAlertQueVO().setALRT_DATE((Date)hashIn.get("adt_alrt_date"));
			alertServiceCO.getAlertQueVO().setSTOP_AFTER((BigDecimal)hashIn.get("al_stop_after"));
			alertServiceCO.getAlertQueVO().setMOBILE_PHONE((String)hashIn.get("as_mobile_phone"));
			alertServiceCO.getAlertQueVO().setEMAIL_ID((String)hashIn.get("as_email_id"));
			alertServiceCO.getAlertQueVO().setEVT_MODE((String)hashIn.get("as_evt_mode"));
			alertServiceCO.getAlertQueVO().setEVT_ID((BigDecimal)hashIn.get("al_evt_id"));
			alertServiceCO.getAlertQueVO().setMSG_LANG((String)hashIn.get("as_msg_lang"));
			alertServiceCO.getAlertQueVO().setSUB_ID((BigDecimal)hashIn.get("al_sub_id"));
			
//		   // alertCommonLibSC.setTrxType("ALRT_QUEUE");
//		    if(!("B").equals(alertServiceCO.getAlertQueVO().getEVT_MODE()))
//		    {
//			if(!(evtVo.getEVT_MODE().equals("E")
//				&& (subVo.getEMAIL_ID() == null || subVo.getEMAIL_ID().isEmpty()))
//				&& !(evtVo.getEVT_MODE().equals("S")
//					&& (null == subVo.getMOBILE_PHONE() || subVo.getMOBILE_PHONE().isEmpty())))
//			{
//
//			    alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
//			    queueVo.setID(alertCommonLibSC.getAlrtCount());
			    
			
			/*
			 *    
			 * 
			 * */
			
			genericDAO.insert(alertServiceCO.getAlertQueVO());
		}
		catch (Exception ex) 
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> viewSubsCriptionDetails(HashMap<String, Object> hashIn) throws Exception 
	{
		ReturnSubscriptionDetailsResp returnSubscriptionDetailsResp = new ReturnSubscriptionDetailsResp();
		try 
		{
			
			//initialize service call
		    initializeServiceCall(hashIn);
		    
			//convert map to subscription request object
			ReturnSubscriptionDetailsReq returnSubscriptionDetailsReq = (ReturnSubscriptionDetailsReq) PathPropertyUtil.convertToObject(hashIn, ReturnSubscriptionDetailsReq.class);
			
			//Authenticate User
			authenticateUser(returnSubscriptionDetailsReq, hashIn);
			
		    //view Subscription Details
		    returnSubscriptionDetailsResp = subscriptionServiceBO.viewSubsCriptionDetails(returnSubscriptionDetailsReq);
		    //convert object to map
		    hashIn = PathPropertyUtil.convertToMap(returnSubscriptionDetailsResp);
		}
		catch (Exception ex) 
		{
			handleServiceException(ex, hashIn);
			returnSubscriptionDetailsResp.getServiceResponse().setStatusCode(AlertWebServiceWrapperConstant.ERROR_STATUS_CODE);
			returnSubscriptionDetailsResp.getServiceResponse().setStatusDesc(AlertWebServiceWrapperConstant.TECHNICAL_ERROR_DESC);
		}
		return hashIn;
	}
	
	//wrapper methods of event
	@Override
	public HashMap<String, Object> returnEventsList(HashMap<String, Object> hashIn) throws Exception 
	{
		ReturnEventsListResp returnEventsListResp = new ReturnEventsListResp();
		try 
		{
			//initialize service call
		    initializeServiceCall(hashIn);
		    
		    //convert hashin to object
			ReturnEventsListReq returnEventsListReq = (ReturnEventsListReq) PathPropertyUtil.convertToObject(hashIn, ReturnEventsListReq.class);
			
			//Authenticate User
			authenticateUser(returnEventsListReq, hashIn);
			
			//return response from service
		    returnEventsListResp = eventsServiceBO.returnEventsList(returnEventsListReq);
		    
		    //convert from response object to hashmap
		    hashIn = PathPropertyUtil.convertToMap(returnEventsListResp);
		}
		catch (Exception ex) 
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	public HashMap<String, Object> returnEventDetails(HashMap<String, Object> hashIn) throws Exception
	{
        	ReturnEventDetailsResp returnEventDetailsResp = new ReturnEventDetailsResp();
        	try
        	{
        	    // initialize service call
        	    initializeServiceCall(hashIn);
        
        	    // convert from Hashmap to Request object
        	    ReturnEventDetailsReq returnEventDetailsReq = (ReturnEventDetailsReq) PathPropertyUtil
        		    .convertToObject(hashIn, ReturnEventDetailsReq.class);
        
        	    // Authenticate User
        	    authenticateUser(returnEventDetailsReq, hashIn);
        
        	    // return Subscriber Details
        	    returnEventDetailsResp = eventsServiceBO.returnEventDetails(returnEventDetailsReq);
        
        	    // convert response object to Hashmap
        	    hashIn = PathPropertyUtil.convertToMap(returnEventDetailsResp);
        	}
        	catch(Exception ex)
        	{
        	    handleServiceException(ex, hashIn);
        	}
        	return hashIn;
	}
	
	/**
	 * this service stands only to fill the common outputs for all services
	 */
	/*private void initializeServiceCall(HashMap<String, Object> hashIn) {
		hashIn.put("ol_error_code", 0);
		hashIn.put("ol_error_desc", null);

		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		String methodName = ste[2].getMethodName();

		log.error("hashIn: " + methodName + " " + hashIn);
	}*/

	/**
	 * this method will handle the exception for every service calling
	 * 
	 * @return ol_error_code, ol_error_desc
	 * @param ex
	 * @param hashIn
	 */
/*	private void handleServiceException(Exception ex, HashMap<String, Object> hashIn) throws BaseException {
		// info log used for trace log files (on production)
		log.error(" \n\n BEGIN handleServiceException  ex: " + ex);
		ex.printStackTrace();
		String errorDesc = "";
		Integer errorCode = -1;
		if (ex instanceof BOException) {
			ArrayList<BaseException> exceptionList = ((BOException) ex).getExceptionsLst();
			if (exceptionList != null && !exceptionList.isEmpty()) {
				for (BaseException baseEx : exceptionList) {
					Object[] errorObject = handleErrorException(baseEx);
					errorCode = (Integer) errorObject[0];
					errorDesc += (String) errorObject[1];
				}
			} else {
				Object[] errorObject = handleErrorException(ex);
				errorCode = (Integer) errorObject[0];
				errorDesc = (String) errorObject[1];
			}
		} else if (ex instanceof BaseException) {
			Object[] errorObject = handleErrorException(ex);
			errorCode = (Integer) errorObject[0];
			errorDesc = (String) errorObject[1];
		}

		StackTraceElement[] arr = ((Throwable) ex).getStackTrace();
		String stackTrace = "";
		if (arr != null && arr.length > 0) {
			for (StackTraceElement err : arr) {
				stackTrace += err.toString() + "\n";
			}
		}
		// in case of unhandled exception
		if (errorDesc == "") {
			errorDesc = stackTrace;
		}

		hashIn.put("ol_error_code", errorCode);
		hashIn.put("ol_error_desc", errorDesc);

		log.error("\n\n ol_error_code: " + errorCode);
		log.error("\n\n ol_error_desc: " + errorDesc);
		log.error("\n\n END handleServiceException stackTrace: " + stackTrace);
	}*/

	private Object[] handleErrorException(Exception ex) throws BaseException {
		String msg = ex.getMessage();
		String[] msgArr = msg.split(AlertWebServiceWrapperConstant.ERROR_CODE_SEPARATOR);
		String[] msgParams = null;
		if (ex instanceof BaseException) {
			msgParams = ((BaseException) ex).getParams();
		}
		if (ex instanceof BOException) {
			msgParams = ((BOException) ex).getParams();
		}
		Integer errorCode = -1;
		String errorMsg = "";

		// in case when the error msg is returned from a procedure, e.g:
		// TrxMgntBOImpl.checkTransData()
		if (msgArr.length > 1) {
			errorCode = new Integer(msgArr[0]);
			errorMsg = msgArr[1];
		}
		// otherwise in case of normal msg exception
		else {
			if (ex instanceof BaseException) {
				errorCode = ((BaseException) ex).getErrorCode();
			}
			if (ex instanceof BOException) {
				errorCode = ((BOException) ex).getErrorCode();
			}
			errorMsg = ex.getMessage();
		}
		//
		if (null == errorCode) {
			errorCode = -1;
		}
		// in case when msg is not translated we should translate it
		if (errorMsg != null && errorMsg.contains("Message To be Retrieved from CTS Messages")) {
			S_APPVO sappVO = new S_APPVO();
			sappVO.setAPP_NAME(ConstantsCommon.RET_APP_NAME);
			sappVO = commonLibBO.returnApplicationDetails(sappVO);
			errorMsg = commonLibBO.returnTranslMessageOnly(errorCode, msgParams,
					StringUtil.nullEmptyToValue(sappVO.getENABLE_LANGUAGE(), ConstantsCommon.LANGUAGE_ENGLISH));
		}

		// errorCode should be always sent as negative
		if (errorCode > 0) {
			errorCode = errorCode * -1;
		}
		return new Object[] { errorCode, errorMsg };
	}

	/**
	 * this function just convert BigDecimal values to Integer (to hold null
	 * value) because it is easier to manipulate Integer variables in java than
	 * BigDecimal (in case not used in database)
	 */
	public static Integer bigDecimalToInteger(BigDecimal value) {
		if (value == null) {
			return null;
		}
		return value.intValue();
	}

	//wrapper methods of Subscriber
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> createSubscriber(HashMap<String, Object> hashIn) throws Exception 
	{
		CreateSubscriberResp createSubscriberResp = new CreateSubscriberResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert Hashmap to Request Object
			CreateSubscriberReq createSubscriberReq = (CreateSubscriberReq) PathPropertyUtil.convertToObject(hashIn, CreateSubscriberReq.class);
			
			//Authenticate User
			authenticateUser(createSubscriberReq, hashIn);
					
			//Create Subscriber
			createSubscriberResp = individualSubscriberServiceBO.createSubscriber(createSubscriberReq);
		    
		    //convert Response Object to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(createSubscriberResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		
		return hashIn;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> updateSubscriber(HashMap<String, Object> hashIn) throws Exception 
	{
		UpdateSubscriberResp updateSubscriberResp = new UpdateSubscriberResp();
		try
	    {
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert Hashmap to Request Object
			UpdateSubscriberReq updateSubscriberReq = (UpdateSubscriberReq) PathPropertyUtil.convertToObject(hashIn, UpdateSubscriberReq.class);
			
			//Authenticate User
			authenticateUser(updateSubscriberReq, hashIn);
			
			//Update Subscriber 
	    	updateSubscriberResp = individualSubscriberServiceBO.updateSubscriber(updateSubscriberReq);
	    	
	    	//convert Response Object to Hashmap
		    hashIn =  PathPropertyUtil.convertToMap(updateSubscriberResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		
		return hashIn;
	}

	
	@Override
	public HashMap<String, Object> approveSubscriber(HashMap<String, Object> hashIn) throws Exception 
	{
		ApproveSubscriberResp approveSubscriberResp = new ApproveSubscriberResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert Hashmap to Request Object
			ApproveSubscriberReq approveSubscriberReq = (ApproveSubscriberReq) PathPropertyUtil.convertToObject(hashIn, ApproveSubscriberReq.class);
			
			//Authenticate User
			authenticateUser(approveSubscriberReq, hashIn);
			
			//Approve Subscriber
			approveSubscriberResp = individualSubscriberServiceBO.approveSubscriber(approveSubscriberReq);
			
			//convert Response Object to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(approveSubscriberResp);
			
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	
	@Override
	public HashMap<String, Object> deleteSubscriber(HashMap<String, Object> hashIn) throws Exception 
	{
		DeleteSubscriberResp deleteSubscriberResp = new DeleteSubscriberResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert Hashmap to Request Object
			DeleteSubscriberReq deleteSubscriberReq = (DeleteSubscriberReq) PathPropertyUtil.convertToObject(hashIn, DeleteSubscriberReq.class);
			
			//Authenticate User
			authenticateUser(deleteSubscriberReq, hashIn);
			
			//delete subscriber
			deleteSubscriberResp = individualSubscriberServiceBO.deleteSubscriber(deleteSubscriberReq);
			
			//converts Response object to hashmap
			hashIn =  PathPropertyUtil.convertToMap(deleteSubscriberResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	
	@Override
	public HashMap<String, Object> returnSubscriberList(HashMap<String, Object> hashIn) throws Exception 
	{
		ReturnSubscribersListResp returnSubscribersListResp = new ReturnSubscribersListResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert Hashmap to Request Object
			ReturnSubscribersListReq returnSubscribersListReq = (ReturnSubscribersListReq) PathPropertyUtil.convertToObject(hashIn, ReturnSubscribersListReq.class);
		    
			//Authenticate User
			authenticateUser(returnSubscribersListReq, hashIn);
			
		    //return Subscriber List
		    returnSubscribersListResp = individualSubscriberServiceBO.returnSubscriberList(returnSubscribersListReq);
		    
		    //convert Response Object to Hashmap
		  	hashIn =  PathPropertyUtil.convertToMap(returnSubscribersListResp);
		    
		}
		catch (Exception ex) 
		{
			handleServiceException(ex, hashIn);
		}
	  	return hashIn;
	}
	
	@Override
	public HashMap<String, Object> returnSubscriberDetails(HashMap<String, Object> hashIn) throws Exception 
	{
		ReturnSubscriberDetailsResp returnSubscriberDetailsResp = new ReturnSubscriberDetailsResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert from Hashmap to Request object
			ReturnSubscriberDetailsReq returnSubscriberDetailsReq = (ReturnSubscriberDetailsReq) PathPropertyUtil.convertToObject(hashIn, ReturnSubscriberDetailsReq.class);
			
			//Authenticate User
			authenticateUser(returnSubscriberDetailsReq, hashIn);
			
			//return Subscriber Details
			returnSubscriberDetailsResp = individualSubscriberServiceBO.returnSubscriberDetails(returnSubscriberDetailsReq);
			
			//convert response object to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(returnSubscriberDetailsResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	@Override
	public Map<String, Object> returnSubscriberIdByCifOrOmniUser(Map<String, Object> criteria) throws BaseException
	{
		return individualSubscriberServiceBO.returnSubscriberIdByCifOrOmniUser(criteria);
	}
	
	//wrapper methods of Packages
	@Override
	public HashMap<String, Object> returnPackageList(HashMap<String, Object> hashIn)  throws Exception
	{
		ReturnPackageListResp returnPackageListResp = new ReturnPackageListResp();
		//ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
		try
		{
			//initialize service call
		    initializeServiceCall(hashIn);
		    
			//convert from object to Hashmap
			ReturnPackageListReq returnPackageListReq = (ReturnPackageListReq) PathPropertyUtil.convertToObject(hashIn, ReturnPackageListReq.class);
			
			//Authenticate User
			authenticateUser(returnPackageListReq, hashIn);
		    
		    //return List of packages
		    returnPackageListResp = packagesServiceBO.returnPackageList(returnPackageListReq);
		    
		    //convert from packageEventResp to Hashmap
		  	hashIn =  PathPropertyUtil.convertToMap(returnPackageListResp);
		}
		catch(Exception ex) {
			handleServiceException(ex, hashIn);
		}
	  	return hashIn;
	}
	
	//wrapper methods of subscription
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> createSingleSubscribtionSE(HashMap<String, Object> hashIn) throws Exception 
	{
		CreateSingleSubscriptionSEResp createSubscriptionSEResp = new CreateSingleSubscriptionSEResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			CreateSingleSubscriptionSEReq createSingleSubscriptionSEReq = (CreateSingleSubscriptionSEReq) PathPropertyUtil.convertToObject(hashIn, CreateSingleSubscriptionSEReq.class);
			
			//Authenticate User
			authenticateUser(createSingleSubscriptionSEReq, hashIn);

			//call create SE subscription
			createSubscriptionSEResp =  subscriptionServiceBO.createSingleSubscribtionSE(createSingleSubscriptionSEReq);
			
			//convert response object to hashmap
			hashIn = PathPropertyUtil.convertToMap(createSubscriptionSEResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	@Override
	public HashMap<String, Object> createSingleSubscribtionSP(HashMap<String, Object> hashIn) throws Exception 
	{
		CreateSingleSubscriptionSPResp createSubscriptionSPResp = new CreateSingleSubscriptionSPResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			CreateSingleSubscriptionSPReq createSingleSubscriptionSPReq = (CreateSingleSubscriptionSPReq) PathPropertyUtil.convertToObject(hashIn, CreateSingleSubscriptionSPReq.class);
			
			//Authenticate User
			authenticateUser(createSingleSubscriptionSPReq, hashIn);
			
			/**
			 * Add Auto Approve flag for approve the subscription
			 */
			String autoApproveFlag = "";
			if(hashIn.containsKey("autoApproveFlag"))
			{
				autoApproveFlag = (String) hashIn.get("autoApproveFlag");
			}
			//call create SP subscription
			createSubscriptionSPResp = subscriptionServiceBO.createSingleSubscribtionSP(createSingleSubscriptionSPReq, autoApproveFlag);
			
			//convert response object to hashmap
			hashIn =  PathPropertyUtil.convertToMap(createSubscriptionSPResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> createSingleSubscribtionGP(HashMap<String, Object> hashIn) throws Exception 
	{
		CreateSingleSubscriptionGPResp  createSingleSubscriptionGPResp = new CreateSingleSubscriptionGPResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			CreateSingleSubscriptionGPReq createSingleSubscriptionGPReq = (CreateSingleSubscriptionGPReq) 
																			PathPropertyUtil.convertToObject(hashIn, CreateSingleSubscriptionGPReq.class);
			//Authenticate User
			authenticateUser(createSingleSubscriptionGPReq, hashIn);
			
			//call create GP subscription
			createSingleSubscriptionGPResp = subscriptionServiceBO.createSingleSubscribtionGP(createSingleSubscriptionGPReq);
			
			//convert response object to hashmap
			hashIn = PathPropertyUtil.convertToMap(createSingleSubscriptionGPResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> createSingleSubscribtionGE(HashMap<String, Object> hashIn) throws Exception 
	{
		CreateSingleSubscriptionGEResp createSingleSubscriptionGEResp = new CreateSingleSubscriptionGEResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			CreateSingleSubscriptionGEReq createSingleSubscriptionGEReq = (CreateSingleSubscriptionGEReq) 
																		  PathPropertyUtil.convertToObject(hashIn, CreateSingleSubscriptionGEReq.class);
			//Authenticate User
			authenticateUser(createSingleSubscriptionGEReq, hashIn);
			
			//call create GE subscription
			createSingleSubscriptionGEResp = subscriptionServiceBO.createSingleSubscribtionGE(createSingleSubscriptionGEReq);
			
			//convert response object to hashmap
			hashIn = PathPropertyUtil.convertToMap(createSingleSubscriptionGEResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	@Override
	public HashMap<String, Object> approveSingleSubscribtion(HashMap<String, Object> hashIn) throws Exception 
	{
		ApproveSingleSubscriptionResp approveSingleSubscriptionResp = new ApproveSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			ApproveSingleSubscriptionReq approveSingleSubscriptionReq = (ApproveSingleSubscriptionReq) 
																		PathPropertyUtil.convertToObject(hashIn, ApproveSingleSubscriptionReq.class);
			//Authenticate User
			authenticateUser(approveSingleSubscriptionReq, hashIn);
			
			//call create Approve Subscription subscription
			approveSingleSubscriptionResp = subscriptionServiceBO.approveSingleSubscribtion(approveSingleSubscriptionReq);	
			
			//convert response object to hashmap
			hashIn =  PathPropertyUtil.convertToMap(approveSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> deleteSingleSubscribtion(HashMap<String, Object> hashIn) throws Exception 
	{
		DeleteSingleSubscriptionResp deleteSingleSubscriptionResp = new DeleteSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			DeleteSingleSubscriptionReq deleteSingleSubscriptionReq = (DeleteSingleSubscriptionReq) 
																	   PathPropertyUtil.convertToObject(hashIn, DeleteSingleSubscriptionReq.class);
			
			//Authenticate User
			authenticateUser(deleteSingleSubscriptionReq, hashIn);
			
			//convert response object to hashmap
			deleteSingleSubscriptionResp = subscriptionServiceBO.deleteSingleSubscribtion(deleteSingleSubscriptionReq);
			
			//convert response object to hashmap
			hashIn =  PathPropertyUtil.convertToMap(deleteSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> suspandSingleSubscribtion(HashMap<String, Object> hashIn) throws Exception 
	{	
		SuspendSingleSubscriptionResp suspendSingleSubscriptionResp = new SuspendSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			SuspendSingleSubscriptionReq suspendSingleSubscriptionReq = (SuspendSingleSubscriptionReq) 
																		PathPropertyUtil.convertToObject(hashIn, SuspendSingleSubscriptionReq.class);
			//Authenticate User
			authenticateUser(suspendSingleSubscriptionReq, hashIn);
			
			//call create suspend subscription
			suspendSingleSubscriptionResp = subscriptionServiceBO.suspandSingleSubscribtion(suspendSingleSubscriptionReq);
			
			//convert response to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(suspendSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}

	@Override
	public HashMap<String, Object> reactiveSingleSubscribtion(HashMap<String, Object> hashIn) throws Exception {
		
		ReactiveSingleSubscriptionResp reactiveSingleSubscriptionResp = new ReactiveSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			ReactiveSingleSubscriptionReq reactiveSingleSubscriptionReq = (ReactiveSingleSubscriptionReq) 
																		   PathPropertyUtil.convertToObject(hashIn, ReactiveSingleSubscriptionReq.class);
			//Authenticate User
			authenticateUser(reactiveSingleSubscriptionReq, hashIn);
			
			//call create suspend subscription
			reactiveSingleSubscriptionResp = subscriptionServiceBO.reactiveSingleSubscribtion(reactiveSingleSubscriptionReq);
			
			//convert response to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(reactiveSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		
		return hashIn;
	}

	@Override
	public HashMap<String, Object> rejectDeletedSingleSubscription(HashMap<String, Object> hashIn) throws Exception 
	{
		RejectDeleteSingleSubscriptionResp rejectDeleteSingleSubscriptionResp = new RejectDeleteSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			RejectDeleteSingleSubscriptionReq rejectDeleteSingleSubscriptionReq =  (RejectDeleteSingleSubscriptionReq) 
					PathPropertyUtil.convertToObject(hashIn, RejectDeleteSingleSubscriptionReq.class);
			
			//Authenticate User
			authenticateUser(rejectDeleteSingleSubscriptionReq, hashIn);
			
			//call create approve delete subscription
			rejectDeleteSingleSubscriptionResp = subscriptionServiceBO.rejectDeleteSingleSubscription(rejectDeleteSingleSubscriptionReq);
			
			//convert response to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(rejectDeleteSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
	@Override
	public HashMap<String, Object> approveDeletedSingleSubscribtion(HashMap<String, Object> hashIn) throws Exception 
	{
		ApproveDeleteSingleSubscriptionResp approveDeleteSingleSubscriptionResp = new ApproveDeleteSingleSubscriptionResp();
		try
		{
			//initialize service call
			initializeServiceCall(hashIn);
			
			//convert hashmap to request object
			ApproveDeleteSingleSubscriptionReq  approveDeleteSingleSubscriptionReq = (ApproveDeleteSingleSubscriptionReq) 
																					PathPropertyUtil.convertToObject(hashIn, ApproveDeleteSingleSubscriptionReq.class);
			//Authenticate User
			authenticateUser(approveDeleteSingleSubscriptionReq, hashIn);
			
			//call create approve delete subscription
			approveDeleteSingleSubscriptionResp = subscriptionServiceBO.approveDeletedSingleSubscribtion(approveDeleteSingleSubscriptionReq);
			
			//convert response to Hashmap
			hashIn =  PathPropertyUtil.convertToMap(approveDeleteSingleSubscriptionResp);
		}
		catch(Exception ex)
		{
			handleServiceException(ex, hashIn);
		}
		return hashIn;
	}
	
    /**
     * authenticate user
     * no need for user authentication in case of rmi call, so send skipUsrAuth = true, otherwise validate the user
     * @param baseRequest
     * @param hashIn
     * @return
     */
    private void authenticateUser(ImBaseRequest baseRequest, HashMap<String, Object> hashIn) throws Exception
    {
	if(hashIn.get("skipUsrAuth") == null || "false".equals(hashIn.get("skipUsrAuth")))
	{
	    int isAuthenticateUser = 0;
	    String user = (String) baseRequest.getRequesterContext().getUserID();
	    String password = SecurityUtils.decodeB64((String) baseRequest.getRequesterContext().getPassword());
	    // return 1 in case of success
	    isAuthenticateUser = loginBO.authenticateUserAndPass(user, password);
	    if(isAuthenticateUser == 0)
	    {
		throw new BOException(MessageCodes.ENTER_A_VALID_AUTHORISED_USER);
	    }
	}
    }
    
    @Override
    public HashMap<String, Object> returnSubscriptionList(HashMap<String, Object> hashIn) throws Exception
    {
	ReturnSubscriptionListResp returnSubscriptionListResp = new ReturnSubscriptionListResp();
	try
	{
	
	    //initialize service call
	    initializeServiceCall(hashIn);
		
	    //convert Hashmap to Request Object
	    ReturnSubscriptionListReq returnSubscriptionListReq = (ReturnSubscriptionListReq) PathPropertyUtil.convertToObject(hashIn, ReturnSubscriptionListReq.class);
	    
	    //Authenticate User
	    authenticateUser(returnSubscriptionListReq, hashIn);
		
	    //return Subscription List
	    returnSubscriptionListResp = subscriptionServiceBO.returnSubscriptionList(returnSubscriptionListReq);
	    
	    //convert Response Object to Hashmap
	    hashIn =  PathPropertyUtil.convertToMap(returnSubscriptionListResp);
	    
	}
	catch (Exception ex) 
	{
		handleServiceException(ex, hashIn);
	}
  	return hashIn;
    }

    public void setIndividualEventBO(IndividualEventBO individualEventBO)
    {
	this.individualEventBO = individualEventBO;
    }

    public void setIndividualSubscriberServiceBO(IndividualSubscriberServiceBO individualSubscriberServiceBO)
    {
	this.individualSubscriberServiceBO = individualSubscriberServiceBO;
    }

    public void setEventsServiceBO(EventsServiceBO eventsServiceBO)
    {
	this.eventsServiceBO = eventsServiceBO;
    }

    public void setPackagesServiceBO(PackagesServiceBO packagesServiceBO)
    {
	this.packagesServiceBO = packagesServiceBO;
    }

    public void setSubscriptionServiceBO(SubscriptionServiceBO subscriptionServiceBO)
    {
	this.subscriptionServiceBO = subscriptionServiceBO;
    }

    public void setLoginBO(LoginBO loginBO)
    {
	this.loginBO = loginBO;
    }
	
}
