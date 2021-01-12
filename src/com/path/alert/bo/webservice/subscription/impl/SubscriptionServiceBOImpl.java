package com.path.alert.bo.webservice.subscription.impl;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.ALRTMessageCodes;
import com.path.alert.bo.statusmngmnt.StatusMngmntBO;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberConstant;
import com.path.alert.bo.subscription.SubscriptionBO;
import com.path.alert.bo.subscription.SubscriptionConstant;
import com.path.alert.bo.webservice.AlertServiceUtilBO;
import com.path.alert.bo.webservice.subscription.SubscriptionServiceBO;
import com.path.alert.vo.subscription.SubscriptionCO;
import com.path.alert.vo.subscription.SubscriptionSC;
import com.path.alert.vo.subscription.SubscriptionWsCO;
import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.alert.subscription.Account;
import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionResp;
import com.path.vo.alert.subscription.CommunicationMode;
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
import com.path.vo.alert.subscription.Event;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionResp;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsReq;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsResp;
import com.path.vo.alert.subscription.ReturnSubscriptionListReq;
import com.path.vo.alert.subscription.ReturnSubscriptionListResp;
import com.path.vo.alert.subscription.Subscription;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionReq;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionResp;
import com.path.vo.common.audit.AuditRefCO;


public class SubscriptionServiceBOImpl extends BaseBO implements SubscriptionServiceBO {
	
	//Individual Subscriber Bo
	private SubscriptionBO subscriptionBO;
	
	//Status Management BO
	private StatusMngmntBO statusMngmntBO; 
	
	//Alert Service Bo
	private AlertServiceUtilBO alertServiceUtilBo;


	@Override
	public CreateSingleSubscriptionSEResp createSingleSubscribtionSE(CreateSingleSubscriptionSEReq createSingleSubscriptionSEReq) throws Exception 
	{
		
		CreateSingleSubscriptionSEResp createSingleSubscriptionSEResp = new CreateSingleSubscriptionSEResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(createSingleSubscriptionSEReq, createSingleSubscriptionSEResp);
	    PathPropertyUtil.copyProperties(createSingleSubscriptionSEReq.getServiceContext(),createSingleSubscriptionSEResp.getResponseServiceContext());
	    
		ArrayList subscriptionCOs = new ArrayList();
	    
		SubscriptionCO subscriptionCO = new SubscriptionCO();
		ALRT_SUB_EVTVO alrt_SUB_EVTVO = new ALRT_SUB_EVTVO(); 
		ALRT_SUB_EVT_TMPVO alrt_SUB_EVT_TMPVO = new ALRT_SUB_EVT_TMPVO(); 
		
		subscriptionCO.setCompCode(createSingleSubscriptionSEReq.getCompanyCode());
	//	subscriptionCO.setBranchCode(createSingleSubscriptionSEReq.getBranchCode());
		subscriptionCO.setSubscriptionType(SubscriptionConstant.SUB_EVENT_TYPE);
		subscriptionCO.setUserID(createSingleSubscriptionSEReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(createSingleSubscriptionSEReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setGridTypeEP(SubscriptionConstant.EVENT_TYPE);
		subscriptionCO.setGridTypeSG(SubscriptionConstant.SUBSCRIBER_TYPE);
		subscriptionCO.setAllRowsEP("0");
		String  selSerialNoSG = "{\"varId_"+createSingleSubscriptionSEReq.getSubscriberId()+"\":\"{\\\"SUB_ID\\\":\\\""+createSingleSubscriptionSEReq.getSubscriberId()+"\\\"}\"}";
		String selSerialNoEP = "{\"varId_"+createSingleSubscriptionSEReq.getSubscriptionEventId()+"\":\"{\\\"EVT_ID\\\":\\\""+createSingleSubscriptionSEReq.getSubscriptionEventId()+"\\\"}\"}";
		String selSeralNoDetail = "{\"varId_"+createSingleSubscriptionSEReq.getSubscriberId()+"-"+createSingleSubscriptionSEReq.getSubscriptionEventId()+""
									+ "\":\"{\\\"SUB_ID-EVT_ID\\\":\\\""
									+ ""+createSingleSubscriptionSEReq.getSubscriberId()+"~"+createSingleSubscriptionSEReq.getSubscriptionEventId()+"~"+"\\\"}\"}";
		
		//subscriptionCO.selSerialNoDet: {"varId_10-16":"{\"SUB_ID-EVT_ID\":\"10~16~\"}"}
		
		subscriptionCO.setLanguage(createSingleSubscriptionSEReq.getRequesterContext().getLangId());
		
		alrt_SUB_EVT_TMPVO.setSUB_ID(createSingleSubscriptionSEReq.getSubscriberId());
		alrt_SUB_EVT_TMPVO.setEVT_ID(createSingleSubscriptionSEReq.getSubscriptionEventId());
		//alrt_SUB_EVTVO.setEMAIL_YN(createSingleSubscriptionSEReq.getActivateEmail());
	//	alrt_SUB_EVTVO.setFILE_YN(createSingleSubscriptionSEReq.getActivateFile());
		//alrt_SUB_EVTVO.setFACEBOOK_PRIVATE_WALL_YN(createSingleSubscriptionSEReq.getActivateFacebook());
	//	alrt_SUB_EVTVO.setINBOX_YN(createSingleSubscriptionSEReq.getActivateInbox());
		//alrt_SUB_EVTVO.setMOBILE_PUSH_NOTIFICATION_YN(createSingleSubscriptionSEReq.getActivateMobilePushNotification());
	//	alrt_SUB_EVTVO.setSMS_YN(createSingleSubscriptionSEReq.getActivateSms());
	//	alrt_SUB_EVTVO.setTWITTER_DIRECT_MESSAGE_YN(createSingleSubscriptionSEReq.getActivateTwitterDirectMessage());
	//	alrt_SUB_EVTVO.setSRC_CONTACT_TYPE(createSingleSubscriptionSEReq.getSourceOfContact());
		
		subscriptionCO.setAlrtSubEvtVO(alrt_SUB_EVTVO);
		subscriptionCO.setAlrtSubEvtTmpVO(alrt_SUB_EVT_TMPVO);
		
		SubscriptionCO subscriptionCO2 = new SubscriptionCO();
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO, subscriptionCO2);
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO.getAlrtSubEvtVO(), subscriptionCO2.getAlrtSubEvtVO());
		
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
//		auditRefCO.setDisableSmart(true);
//		auditRefCO.setAuditEnabled(false);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(createSingleSubscriptionSEReq.getRequesterContext().getRequesterTimeStamp());
		auditRefCO.setUserID(createSingleSubscriptionSEReq.getRequesterContext().getUserID());
		subscriptionCO.setAuditRefCO(auditRefCO);
		
		//subscriptionCO.setAuditObj(subscriptionCO2);
		 SubscriptionSC subscriptionSC = new SubscriptionSC();
		//insert data in ALRT_SUB_EVT_TEMP table
		subscriptionBO.populateSubscription(subscriptionSC, subscriptionCO, selSerialNoSG, selSerialNoEP);
		
		//add Subscriber and event ids
		subscriptionCO.setSelSerialNoDet(selSeralNoDetail);
		
		
		//save data in ALRT_SUB_EVT
		subscriptionCO = subscriptionBO.saveSubscription(subscriptionCO,null);
		
		//check invalid record
		if(subscriptionCO.getRow() <= 0)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"sub_or_event_doesnot_exist_key"});
		}
				
		/**
		 * Exclude Communication modes for subscription
		 */
		if(null != createSingleSubscriptionSEReq.getExcludedModesList() && 0 < createSingleSubscriptionSEReq.getExcludedModesList().size())
		{
		    subscriptionCO.setExcludedModesList((ArrayList<String>) createSingleSubscriptionSEReq.getExcludedModesList());
		    subscriptionCOs.add(subscriptionCO);
		    //update data into ALRT_SUB_EVT_TEMP table
		    subscriptionBO.updateExcludeTable(subscriptionCOs);
		}
		
		
		
		createSingleSubscriptionSEResp.setSubscriptionId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
		
		//584652 - PBSS160068 : approve the record based on autoApproveFlag
		String autoApproveFlag = StringUtil.nullEmptyToValue(createSingleSubscriptionSEResp.getAutoApproveFlag(), "0");
		if("1".equals(autoApproveFlag))
		{
		    ApproveSingleSubscriptionReq approveSingleSubscriptionReq = new ApproveSingleSubscriptionReq();
		    approveSingleSubscriptionReq.setCompanyCode(createSingleSubscriptionSEResp.getCompanyCode());
		    approveSingleSubscriptionReq.setSubscriptionId(createSingleSubscriptionSEResp.getSubscriptionId());
		    approveSingleSubscriptionReq.setSubscriptionType( SubscriptionConstant.SUB_EVENT_TYPE);//SE
		    
		    approveSingleSubscribtion(approveSingleSubscriptionReq);
		}
		
		return createSingleSubscriptionSEResp;
	}

	@Override
	public CreateSingleSubscriptionSPResp createSingleSubscribtionSP(CreateSingleSubscriptionSPReq createSingleSubscriptionSPReq, String autoApproveFlag) throws Exception 
	{
		
		CreateSingleSubscriptionSPResp createSingleSubscriptionSPResp = new CreateSingleSubscriptionSPResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(createSingleSubscriptionSPReq, createSingleSubscriptionSPResp);
	    PathPropertyUtil.copyProperties(createSingleSubscriptionSPReq.getServiceContext(),createSingleSubscriptionSPResp.getResponseServiceContext());
		//ArrayList subscriptionCOs = new ArrayList();
		SubscriptionCO subscriptionCO = new SubscriptionCO();
		ALRT_SUB_PKGVO alrt_SUB_PKGVO = new ALRT_SUB_PKGVO(); 
		ALRT_SUB_EVT_TMPVO sub_EVT_TMPVO = new ALRT_SUB_EVT_TMPVO();
		
		subscriptionCO.setCompCode(createSingleSubscriptionSPReq.getCompanyCode());
	//	subscriptionCO.setBranchCode(createSingleSubscriptionSPReq.getBranchCode());
		subscriptionCO.setSubscriptionType(SubscriptionConstant.SUB_PCKG_TYPE);
		subscriptionCO.setUserID(createSingleSubscriptionSPReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(createSingleSubscriptionSPReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setGridTypeEP(SubscriptionConstant.PACKAGE_TYPE);
		subscriptionCO.setGridTypeSG(SubscriptionConstant.SUBSCRIBER_TYPE);
		String  selSerialNoSG = "{\"varId_"+createSingleSubscriptionSPReq.getSubscriberId()+"\":\"{\\\"SUB_ID\\\":\\\""+createSingleSubscriptionSPReq.getSubscriberId()+"\\\"}\"}";
		String selSerialNoEP = "{\"varId_"+createSingleSubscriptionSPReq.getSubscriptionPackageId()+"\":\"{\\\"PKG_ID\\\":\\\""+createSingleSubscriptionSPReq.getSubscriptionPackageId()+"\\\"}\"}";
		
		String selSeralNoDetail = "{\"varId_"+createSingleSubscriptionSPReq.getSubscriberId()+"-"+createSingleSubscriptionSPReq.getSubscriptionPackageId()+""
				+ "\":\"{\\\"SUB_ID-EVT_ID\\\":\\\""
				+ ""+createSingleSubscriptionSPReq.getSubscriberId()+"~"+createSingleSubscriptionSPReq.getSubscriptionPackageId()+"~"+"\\\"}\"}";

		
		
		subscriptionCO.setLanguage(createSingleSubscriptionSPReq.getRequesterContext().getLangId());
		
		sub_EVT_TMPVO.setSUB_ID(createSingleSubscriptionSPReq.getSubscriberId());
		sub_EVT_TMPVO.setEVT_ID(createSingleSubscriptionSPReq.getSubscriptionPackageId());
		alrt_SUB_PKGVO.setSUB_ID(createSingleSubscriptionSPReq.getSubscriberId());
		alrt_SUB_PKGVO.setPKG_ID(createSingleSubscriptionSPReq.getSubscriptionPackageId());
		
		subscriptionCO.setAlrtSubPkgVO(alrt_SUB_PKGVO);
		subscriptionCO.setAlrtSubEvtTmpVO(sub_EVT_TMPVO);
		
		/*alrt_SUB_PKGVO.setEMAIL_YN(createSingleSubscriptionSPReq.getActivateEmail());
		alrt_SUB_PKGVO.setFILE_YN(createSingleSubscriptionSPReq.getActivateFile());
		alrt_SUB_PKGVO.setFACEBOOK_PRIVATE_WALL_YN(createSingleSubscriptionSPReq.getActivateFacebook());
		alrt_SUB_PKGVO.setINBOX_YN(createSingleSubscriptionSPReq.getActivateInbox());
		alrt_SUB_PKGVO.setMOBILE_PUSH_NOTIFICATION_YN(createSingleSubscriptionSPReq.getActivateMobilePushNotification());
		alrt_SUB_PKGVO.setSMS_YN(createSingleSubscriptionSPReq.getActivateSms());
		alrt_SUB_PKGVO.setTWITTER_DIRECT_MESSAGE_YN(createSingleSubscriptionSPReq.getActivateTwitterDirectMessage());
*/			
		SubscriptionCO subscriptionCO2 = new SubscriptionCO();
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO, subscriptionCO2);
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO.getAlrtSubEvtVO(), subscriptionCO2.getAlrtSubEvtVO());
		
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
//		auditRefCO.setAuditEnabled(false);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(createSingleSubscriptionSPReq.getRequesterContext().getRequesterTimeStamp());
		auditRefCO.setUserID(createSingleSubscriptionSPReq.getRequesterContext().getUserID());
		subscriptionCO.setAuditRefCO(auditRefCO);
		subscriptionCO.setAuditObj(subscriptionCO2);
		
		 SubscriptionSC subscriptionSC = new SubscriptionSC();
		 
		//insert data in ALRT_SUB_EVT_TEMP table
		subscriptionBO.populateSubscription(subscriptionSC, subscriptionCO, selSerialNoSG, selSerialNoEP);

		//update data into ALRT_SUB_EVT_TEMP table
//		subscriptionCOs.add(subscriptionCO);
//		subscriptionBO.updateTempTable(subscriptionCOs);
		
		//add Subscriber and pacakge id
		subscriptionCO.setSelSerialNoDet(selSeralNoDetail);
				
		//save data in ALRT_SUB_EVT
		subscriptionCO = subscriptionBO.saveSubscription(subscriptionCO,null);
		
        	// check record already Exist
        	if(subscriptionCO.getRow() <= 0)
        	{
        	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "sub_or_package_doesnot_exist_key" });
        	}
        	
		//set subscription id to response
		createSingleSubscriptionSPResp.setSubscriberId(subscriptionCO.getAlrtSubPkgVO().getLINE_NO());
		createSingleSubscriptionSPResp.setSubscriptionId(subscriptionCO.getAlrtSubPkgVO().getLINE_NO());
		
		//584652 - PBSS160068 : approve the record based on autoApproveFlag
		 autoApproveFlag = StringUtil.nullEmptyToValue( autoApproveFlag, "0");
		if("1".equals(autoApproveFlag))
		{
		    ApproveSingleSubscriptionReq approveSingleSubscriptionReq = new ApproveSingleSubscriptionReq();
		    approveSingleSubscriptionReq.setCompanyCode(createSingleSubscriptionSPResp.getCompanyCode());
		    approveSingleSubscriptionReq.setSubscriptionId(createSingleSubscriptionSPResp.getSubscriptionId());
		    approveSingleSubscriptionReq.setSubscriptionType( SubscriptionConstant.SUB_PCKG_TYPE);//SE
		    
		    approveSingleSubscribtion(approveSingleSubscriptionReq);
		}
		
		
		return createSingleSubscriptionSPResp;
	}

	@Override
	public CreateSingleSubscriptionGPResp createSingleSubscribtionGP(CreateSingleSubscriptionGPReq createSingleSubscriptionGPReq) throws Exception 
	{
		CreateSingleSubscriptionGPResp createSingleSubscriptionGPResp = new CreateSingleSubscriptionGPResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(createSingleSubscriptionGPReq, createSingleSubscriptionGPResp);
	    PathPropertyUtil.copyProperties(createSingleSubscriptionGPReq.getServiceContext(),createSingleSubscriptionGPResp.getResponseServiceContext());
	    
		SubscriptionCO subscriptionCO = new SubscriptionCO();
		ALRT_GRP_PKGVO alrt_GRP_PKGVO = new ALRT_GRP_PKGVO(); 
		ALRT_SUB_EVT_TMPVO sub_EVT_TMPVO = new ALRT_SUB_EVT_TMPVO();
		
		subscriptionCO.setCompCode(createSingleSubscriptionGPReq.getCompanyCode());
	//	subscriptionCO.setBranchCode(createSingleSubscriptionGPReq.getBranchCode());
		subscriptionCO.setSubscriptionType(SubscriptionConstant.GRP_PCKG_TYPE);
		subscriptionCO.setUserID(createSingleSubscriptionGPReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(createSingleSubscriptionGPReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setGridTypeEP(SubscriptionConstant.PACKAGE_TYPE);
		subscriptionCO.setGridTypeSG(SubscriptionConstant.GROUP_TYPE);
		String  selSerialNoSG = "{\"varId_"+createSingleSubscriptionGPReq.getGroupId()+"\":\"{\\\"GRP_ID\\\":\\\""+createSingleSubscriptionGPReq.getGroupId()+"\\\"}\"}";
		String selSerialNoEP = "{\"varId_"+createSingleSubscriptionGPReq.getSubscriptionPackageId()+"\":\"{\\\"PKG_ID\\\":\\\""+createSingleSubscriptionGPReq.getSubscriptionPackageId()+"\\\"}\"}";

		String selSeralNoDetail = "{\"varId_"+createSingleSubscriptionGPReq.getGroupId()+"-"+createSingleSubscriptionGPReq.getSubscriptionPackageId()+""
				+ "\":\"{\\\"SUB_ID-EVT_ID\\\":\\\""
				+ ""+createSingleSubscriptionGPReq.getGroupId()+"~"+createSingleSubscriptionGPReq.getSubscriptionPackageId()+"~"+"\\\"}\"}";

		
		subscriptionCO.setLanguage(createSingleSubscriptionGPReq.getRequesterContext().getLangId());
		
		sub_EVT_TMPVO.setSUB_ID(createSingleSubscriptionGPReq.getGroupId());
		sub_EVT_TMPVO.setEVT_ID(createSingleSubscriptionGPReq.getSubscriptionPackageId());
		alrt_GRP_PKGVO.setGRP_ID(createSingleSubscriptionGPReq.getGroupId());
		alrt_GRP_PKGVO.setPKG_ID(createSingleSubscriptionGPReq.getSubscriptionPackageId());
		
		subscriptionCO.setAlrtGrpPkgVO(alrt_GRP_PKGVO);
		subscriptionCO.setAlrtSubEvtTmpVO(sub_EVT_TMPVO);
		
		SubscriptionCO subscriptionCO2 = new SubscriptionCO();
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO, subscriptionCO2);
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO.getAlrtSubEvtVO(), subscriptionCO2.getAlrtSubEvtVO());
		
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(createSingleSubscriptionGPReq.getRequesterContext().getRequesterTimeStamp());
		auditRefCO.setUserID(createSingleSubscriptionGPReq.getRequesterContext().getUserID());
		subscriptionCO.setAuditRefCO(auditRefCO);
		subscriptionCO.setAuditObj(subscriptionCO2);

		SubscriptionSC sc = new SubscriptionSC();
		
		//insert data in ALRT_SUB_EVT_TEMP table
		subscriptionBO.populateSubscription(sc, subscriptionCO, selSerialNoSG, selSerialNoEP);

		//update data into ALRT_SUB_EVT_TEMP table
		//subscriptionCOs.add(subscriptionCO);
		//subscriptionBO.updateTempTable(subscriptionCOs);
		
		//add group and package ids
		subscriptionCO.setSelSerialNoDet(selSeralNoDetail);
		
		//save data in ALRT_SUB_EVT
		subscriptionCO = subscriptionBO.saveSubscription(subscriptionCO,null);
		
		// check record already Exist
        	if(subscriptionCO.getRow() <= 0)
        	{
        	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "group_or_package_doesnot_exist_key" });
        	}
		
		createSingleSubscriptionGPResp.setSubscriptionId(subscriptionCO.getAlrtGrpPkgVO().getLINE_NO());
		
		return createSingleSubscriptionGPResp;
	}

	@Override
	public CreateSingleSubscriptionGEResp createSingleSubscribtionGE(CreateSingleSubscriptionGEReq createSingleSubscriptionGEReq) throws Exception 
	{
	    
		
		CreateSingleSubscriptionGEResp createSingleSubscriptionGEResp = new CreateSingleSubscriptionGEResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(createSingleSubscriptionGEReq, createSingleSubscriptionGEResp);
	    PathPropertyUtil.copyProperties(createSingleSubscriptionGEReq.getServiceContext(),createSingleSubscriptionGEResp.getResponseServiceContext());
	    
	    ArrayList subscriptionCOs = new ArrayList();
	    
		SubscriptionCO subscriptionCO = new SubscriptionCO();
		ALRT_EVT_GRPVO alrt_EVT_GRPVO = new ALRT_EVT_GRPVO(); 
		ALRT_SUB_EVTVO alrt_SUB_EVTVO = new ALRT_SUB_EVTVO(); 
		ALRT_SUB_EVT_TMPVO sub_EVT_TMPVO = new ALRT_SUB_EVT_TMPVO();
		
		subscriptionCO.setCompCode(createSingleSubscriptionGEReq.getCompanyCode());
	//	subscriptionCO.setBranchCode(createSingleSubscriptionGEReq.getBranchCode());
		subscriptionCO.setSubscriptionType(SubscriptionConstant.EVENT_GRP_TYPE);
		subscriptionCO.setUserID(createSingleSubscriptionGEReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(createSingleSubscriptionGEReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setGridTypeEP(SubscriptionConstant.EVENT_TYPE);
		subscriptionCO.setGridTypeSG(SubscriptionConstant.GROUP_TYPE);
		String  selSerialNoSG = "{\"varId_"+createSingleSubscriptionGEReq.getGroupId()+"\":\"{\\\"GRP_ID\\\":\\\""+createSingleSubscriptionGEReq.getGroupId()+"\\\"}\"}";
		String selSerialNoEP = "{\"varId_"+createSingleSubscriptionGEReq.getSubscriptionEventId()+"\":\"{\\\"EVT_ID\\\":\\\""+createSingleSubscriptionGEReq.getSubscriptionEventId()+"\\\"}\"}";
		String selSeralNoDetail = "{\"varId_"+createSingleSubscriptionGEReq.getGroupId()+"-"+createSingleSubscriptionGEReq.getSubscriptionEventId()+""
				+ "\":\"{\\\"SUB_ID-EVT_ID\\\":\\\""
				+ ""+createSingleSubscriptionGEReq.getGroupId()+"~"+createSingleSubscriptionGEReq.getSubscriptionEventId()+"~"+"\\\"}\"}";

		
		subscriptionCO.setLanguage(createSingleSubscriptionGEReq.getRequesterContext().getLangId());
		
		sub_EVT_TMPVO.setSUB_ID(createSingleSubscriptionGEReq.getGroupId());
		sub_EVT_TMPVO.setEVT_ID(createSingleSubscriptionGEReq.getSubscriptionEventId());
		
		alrt_EVT_GRPVO.setGRP_ID(createSingleSubscriptionGEReq.getGroupId());
		alrt_EVT_GRPVO.setEVT_ID(createSingleSubscriptionGEReq.getSubscriptionEventId());
		
	//	alrt_SUB_EVTVO.setSRC_CONTACT_TYPE(createSingleSubscriptionGEReq.getSourceOfContact());
		
		subscriptionCO.setAlrtSubEvtVO(alrt_SUB_EVTVO);
		subscriptionCO.setAlrtEvtGrpVO(alrt_EVT_GRPVO);
		subscriptionCO.setAlrtSubEvtTmpVO(sub_EVT_TMPVO);
		
		SubscriptionCO subscriptionCO2 = new SubscriptionCO();
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO, subscriptionCO2);
		PathPropertyUtil.copyMainNotNullProperties(subscriptionCO.getAlrtSubEvtVO(), subscriptionCO2.getAlrtSubEvtVO());
		
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
		auditRefCO.setAuditEnabled(false);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(createSingleSubscriptionGEReq.getRequesterContext().getRequesterTimeStamp());
		auditRefCO.setUserID(createSingleSubscriptionGEReq.getRequesterContext().getUserID());
		subscriptionCO.setAuditRefCO(auditRefCO);
		subscriptionCO.setAuditObj(subscriptionCO2);
		
		SubscriptionSC sc = new SubscriptionSC();
		//insert data in ALRT_SUB_EVT_TEMP table
		subscriptionBO.populateSubscription(sc, subscriptionCO, selSerialNoSG, selSerialNoEP);

		//update data into ALRT_SUB_EVT_TEMP table
		subscriptionCOs.add(subscriptionCO);
//		subscriptionBO.updateTempTable(subscriptionCOs);//should be modified later as create subscription SE
				
		//add group and event ids
		subscriptionCO.setSelSerialNoDet(selSeralNoDetail);
				
		//save data in ALRT_SUB_EVT
		subscriptionCO = subscriptionBO.saveSubscription(subscriptionCO,null);
		
		//check record already Exist
		if(subscriptionCO.getRow() <= 0)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"group_or_event_doesnot_exist_key"});
		}
		
		createSingleSubscriptionGEResp.setSubscriptionId(subscriptionCO.getAlrtEvtGrpVO().getLINE_NO());
		return createSingleSubscriptionGEResp;
	}

	@Override
	public ApproveSingleSubscriptionResp approveSingleSubscribtion(ApproveSingleSubscriptionReq approveSingleSubscriptionReq) throws Exception 
	{
		ApproveSingleSubscriptionResp approveSingleSubscriptionResp = new ApproveSingleSubscriptionResp();
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(approveSingleSubscriptionReq , approveSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(approveSingleSubscriptionReq.getServiceContext(),approveSingleSubscriptionResp.getResponseServiceContext());
	
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
	    
		subscriptionCO.setCompCode(approveSingleSubscriptionReq.getCompanyCode());
		//subscriptionCO.setBranchCode(approveSingleSubscriptionReq.getBranchCode());
		subscriptionCO.setUserID(approveSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(approveSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(approveSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.setAppName(AlertConstant.ALRT_APP_NAME);
		subscriptionCO.setIvCrud(AlertConstant.STATUS_P);
		subscriptionCO.setProgRef(SubscriptionConstant.SUB_EVT_APPROVE_REF);
		
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(approveSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(approveSingleSubscriptionReq.getSubscriptionId());
		
		// approve Subscription
		subscriptionBO.approveSubscription(subscriptionCO);
		return approveSingleSubscriptionResp;
	}

	@Override
	public DeleteSingleSubscriptionResp deleteSingleSubscribtion(DeleteSingleSubscriptionReq deleteSingleSubscriptionReq) throws Exception 
	{
		DeleteSingleSubscriptionResp deleteSingleSubscriptionResp = new DeleteSingleSubscriptionResp();
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(deleteSingleSubscriptionReq , deleteSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(deleteSingleSubscriptionReq.getServiceContext(),deleteSingleSubscriptionResp.getResponseServiceContext());
	
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
		subscriptionCO.setCompCode(deleteSingleSubscriptionReq.getCompanyCode());
		subscriptionCO.setUserID(deleteSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(deleteSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(deleteSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.setIvCrud(AlertConstant.CRUD_TD);
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(deleteSingleSubscriptionReq.getSubscriptionId());
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(deleteSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.setSubscriptionType(deleteSingleSubscriptionReq.getSubscriptionType());
			
		// delete single subscription
		subscriptionBO.toBeDeletedSubscription(subscriptionCO);
		return deleteSingleSubscriptionResp;
	}
	
	@Override
	public RejectDeleteSingleSubscriptionResp rejectDeleteSingleSubscription(RejectDeleteSingleSubscriptionReq rejectDeleteSingleSubscriptionReq) throws Exception 
	{
		RejectDeleteSingleSubscriptionResp rejectDeleteSingleSubscriptionResp = new RejectDeleteSingleSubscriptionResp();
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(rejectDeleteSingleSubscriptionReq , rejectDeleteSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(rejectDeleteSingleSubscriptionReq.getServiceContext(),rejectDeleteSingleSubscriptionResp.getResponseServiceContext());
	
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
		subscriptionCO.setCompCode(rejectDeleteSingleSubscriptionReq.getCompanyCode());
		//subscriptionCO.setBranchCode(deleteSingleSubscriptionReq.getBranchCode());
		subscriptionCO.setUserID(rejectDeleteSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(rejectDeleteSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(rejectDeleteSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.setIvCrud(AlertConstant.CRUD_A);
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(rejectDeleteSingleSubscriptionReq.getSubscriptionId());
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(rejectDeleteSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.setSubscriptionType(rejectDeleteSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.setIsReject(BigDecimal.ONE);
			
		// reject delete single subscription
		subscriptionBO.toBeDeletedSubscription(subscriptionCO);
		
		return rejectDeleteSingleSubscriptionResp;
	}

	@Override
	public SuspendSingleSubscriptionResp suspandSingleSubscribtion(SuspendSingleSubscriptionReq suspendSingleSubscriptionReq) throws Exception 
	{
		SuspendSingleSubscriptionResp suspendSingleSubscriptionResp = new SuspendSingleSubscriptionResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(suspendSingleSubscriptionReq , suspendSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(suspendSingleSubscriptionReq.getServiceContext(),suspendSingleSubscriptionResp.getResponseServiceContext());
	
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
	    subscriptionCO.setCompCode(suspendSingleSubscriptionReq.getCompanyCode());
		//subscriptionCO.setBranchCode(deleteSingleSubscriptionReq.getBranchCode());
		subscriptionCO.setUserID(suspendSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(suspendSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(suspendSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.getAlrtSubEvtVO().setID(suspendSingleSubscriptionReq.getSubscriptionId());
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(suspendSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(suspendSingleSubscriptionReq.getSubscriptionId());
		
		//suspend subscription
		subscriptionBO.suspendSubscription(subscriptionCO);
		return suspendSingleSubscriptionResp;
	}

	@Override
	public ReactiveSingleSubscriptionResp reactiveSingleSubscribtion(ReactiveSingleSubscriptionReq reactiveSingleSubscriptionReq) throws Exception 
	{
		ReactiveSingleSubscriptionResp reactiveSingleSubscriptionResp = new ReactiveSingleSubscriptionResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(reactiveSingleSubscriptionReq , reactiveSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(reactiveSingleSubscriptionReq.getServiceContext(),reactiveSingleSubscriptionResp.getResponseServiceContext());
	    
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
	    subscriptionCO.setCompCode(reactiveSingleSubscriptionReq.getCompanyCode());
		//subscriptionCO.setBranchCode(deleteSingleSubscriptionReq.getBranchCode());
		subscriptionCO.setUserID(reactiveSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(reactiveSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(reactiveSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.getAlrtSubEvtVO().setID(reactiveSingleSubscriptionReq.getSubscriptionId());
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(reactiveSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(reactiveSingleSubscriptionReq.getSubscriptionId());
			
		//Reactive Subscription
		subscriptionBO.reactivateSubscription(subscriptionCO);
		return reactiveSingleSubscriptionResp;
	}

	@Override
	public ApproveDeleteSingleSubscriptionResp approveDeletedSingleSubscribtion(ApproveDeleteSingleSubscriptionReq approveDeleteSingleSubscriptionReq) throws Exception 
	{
		ApproveDeleteSingleSubscriptionResp approveDeleteSingleSubscriptionResp  = new ApproveDeleteSingleSubscriptionResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(approveDeleteSingleSubscriptionReq , approveDeleteSingleSubscriptionResp);
	    PathPropertyUtil.copyProperties(approveDeleteSingleSubscriptionReq.getServiceContext(),approveDeleteSingleSubscriptionResp.getResponseServiceContext());
	
	    SubscriptionCO subscriptionCO = new SubscriptionCO();
		subscriptionCO.setCompCode(approveDeleteSingleSubscriptionReq.getCompanyCode());
		//subscriptionCO.setBranchCode(approveDeleteSingleSubscriptionReq.getBranchCode());
		subscriptionCO.setUserID(approveDeleteSingleSubscriptionReq.getRequesterContext().getUserID());
		subscriptionCO.setRunningDate(approveDeleteSingleSubscriptionReq.getRequesterContext().getRequesterTimeStamp());
		subscriptionCO.setLanguage(approveDeleteSingleSubscriptionReq.getRequesterContext().getLangId());
		subscriptionCO.getAlrtSubEvtVO().setREL_ID(approveDeleteSingleSubscriptionReq.getSubscriptionId());
		subscriptionCO.getAlrtSubEvtVO().setREL_TYPE(approveDeleteSingleSubscriptionReq.getSubscriptionType());
		subscriptionCO.setSubscriptionType(approveDeleteSingleSubscriptionReq.getSubscriptionType());
		
		// Approve Subscription
		subscriptionBO.deleteSubscription(subscriptionCO);
		return approveDeleteSingleSubscriptionResp;
	}

	@Override
	public ReturnSubscriptionDetailsResp viewSubsCriptionDetails(ReturnSubscriptionDetailsReq returnSubscriptionDetailsReq) throws Exception 
	{
		ReturnSubscriptionDetailsResp returnSubscriptionDetailsResp = new ReturnSubscriptionDetailsResp();

		//copy all request input to the response
	    PathPropertyUtil.copyProperties(returnSubscriptionDetailsReq, returnSubscriptionDetailsResp);
	    PathPropertyUtil.copyProperties(returnSubscriptionDetailsReq.getServiceContext(),returnSubscriptionDetailsResp.getResponseServiceContext());
		
	    SubscriptionSC subscriptionSC = new SubscriptionSC();
	    
	    subscriptionSC.setCompCode(returnSubscriptionDetailsReq.getCompanyCode());
	    subscriptionSC.setSubscriberId(returnSubscriptionDetailsReq.getSubscriberId());
	    subscriptionSC.setCif(returnSubscriptionDetailsReq.getCifNumber());
	    subscriptionSC.setImalUserId(returnSubscriptionDetailsReq.getImalUserId());
	    subscriptionSC.setChannelEndUserId(returnSubscriptionDetailsReq.getChannelEndUserId());
	    
	    subscriptionSC.setLovType(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
	    //return all Subscriber events details
		List<SubscriptionCO> subscriptionCOs = subscriptionBO.retrieveSubEvtWSList(subscriptionSC);
	    List<Event> events = new ArrayList<Event>();
	    List<Account> accounts = null;
	    List<CommunicationMode> communicationModes = null;
	    
	    if(subscriptionCOs != null)
		{
	    	SubscriptionCO subscriptionCO = new SubscriptionCO();
	    	Event event = new Event();
	    	Account account = null;
	    	CommunicationMode communicationMode = null;
	    	
	    	for(int i=0; i<subscriptionCOs.size(); i++)
		  	{
	    		subscriptionCO = subscriptionCOs.get(i);
	    		event = new Event();
	    		accounts = new ArrayList<Account>();
	    		communicationModes = new ArrayList<CommunicationMode>();
	    		
	    		event.setEventId(subscriptionCO.getAlrtEvtVO().getEVT_ID());
	    		event.setEventDescription(subscriptionCO.getAlrtEvtVO().getDESC_ENG());
	    		event.setEventType(subscriptionCO.getAlrtEvtVO().getEVT_TYPE());
	    		event.setEventStatus(subscriptionCO.getStatusDesc());
	    		event.setSourceOfContact(subscriptionCO.getAlrtEvtVO().getSOURCE_OF_CONTACT());
	    		
	    		//retrieve Subscriber Exclude Accounts
	    		List<ALRT_SUB_ACC_EXCLVO> alrt_SUB_ACC_EXCLVOs = subscriptionCO.getAlrt_SUB_ACC_EXCLVOs();
	    		if(alrt_SUB_ACC_EXCLVOs != null)
	    		{
	    			for(int j=0; j<alrt_SUB_ACC_EXCLVOs.size(); j++)
	    		  	{
	    				ALRT_SUB_ACC_EXCLVO alrt_SUB_ACC_EXCLVO = alrt_SUB_ACC_EXCLVOs.get(j);
	    				account = new Account();
	    				account.setCurrency(alrt_SUB_ACC_EXCLVO.getCURRENCY_CODE());
	    				account.setBranch(alrt_SUB_ACC_EXCLVO.getBRANCH_CODE());
	    				account.setCifNo(alrt_SUB_ACC_EXCLVO.getCIF_SUB_NO());
	    				account.setSerialNo(alrt_SUB_ACC_EXCLVO.getSL_NO());
	    				account.setAccGl(alrt_SUB_ACC_EXCLVO.getGL_CODE());
	    				accounts.add(account);
	    		  	}
	    			event.setExcludedAccountsList(accounts);
	    		}
	    		
	    		//retrieve Communication mode
	    		List<ALRT_EVT_COMM_MODEVO> alrt_EVT_COMM_MODEVOs = subscriptionCO.getAlrt_EVT_COMM_MODEVOs();
	    		if(alrt_EVT_COMM_MODEVOs != null)
	    		{
	    			for(int j=0; j<alrt_EVT_COMM_MODEVOs.size(); j++)
	    		  	{
	    				ALRT_EVT_COMM_MODEVO alrt_SUB_ACC_EXCLVO = alrt_EVT_COMM_MODEVOs.get(j);
	    				communicationMode = new CommunicationMode();
	    				
	    				communicationMode.setMode(alrt_SUB_ACC_EXCLVO.getCOMMUNICATION_TYPE());
	    				communicationMode.setEnabled(alrt_SUB_ACC_EXCLVO.getACTIVATED_YN() != null ? 
	    											 alrt_SUB_ACC_EXCLVO.getACTIVATED_YN().equals("Y") ? 
	    													 new BigDecimal(1):new BigDecimal(0):
	    												     new BigDecimal(1));
	    				communicationModes.add(communicationMode);
	    		  	}
	    			event.setCommunicationModesList(communicationModes);
	    		}
	    		events.add(event);
	    		returnSubscriptionDetailsResp.setEventsList(events);
		  	}

		}
		return returnSubscriptionDetailsResp;
	}
	
	@Override
        public ReturnSubscriptionListResp returnSubscriptionList(ReturnSubscriptionListReq returnSubscriptionListReq)
    	    throws Exception
        {
        	ReturnSubscriptionListResp returnSubscriptionListResp = new ReturnSubscriptionListResp();
        
        	// copy all request input to the response
        	PathPropertyUtil.copyProperties(returnSubscriptionListReq, returnSubscriptionListResp);
        	PathPropertyUtil.copyProperties(returnSubscriptionListReq.getServiceContext(),
        		returnSubscriptionListResp.getResponseServiceContext());
        
        	SubscriptionSC subscriptionSC = new SubscriptionSC();
        
        	String[] searchCol = { "COMP_CODE", "EVT_ID", "SUB_ID", "PKG_ID", "PKG_DESC_ENG", "EVT_DESC_ENG",
        		"DEFAULT_BRIEF_NAME", "COMMUNICATION_TYPE", "GRP_ID", "GRP_DESC_ENG", "REL_TYPE", "STATUS" };
        
        	subscriptionSC.setSearchCols(searchCol);
        
        	AlertCommonWSSC alertCommonWSSC = new AlertCommonWSSC();
        
        	// fill map for search same as assets
        	HashMap<String, Object> colSearchMap = new HashMap<>();
        	colSearchMap.put("COMP_CODE", returnSubscriptionListReq.getCompanyCode());
        	colSearchMap.put("EVT_ID", returnSubscriptionListReq.getEventId());
        	colSearchMap.put("SUB_ID", returnSubscriptionListReq.getSubscriberId());
        	colSearchMap.put("PKG_ID", returnSubscriptionListReq.getPackageId());
        	colSearchMap.put("PKG_DESC_ENG", returnSubscriptionListReq.getPacakgeName());
        	colSearchMap.put("EVT_DESC_ENG", returnSubscriptionListReq.getEventDescription());
        	colSearchMap.put("DEFAULT_BRIEF_NAME", returnSubscriptionListReq.getSubscriberBriefName());
        	colSearchMap.put("COMMUNICATION_TYPE", returnSubscriptionListReq.getCommunicationMode());
        	colSearchMap.put("GRP_ID", returnSubscriptionListReq.getGroupId());
        	colSearchMap.put("GRP_DESC_ENG", returnSubscriptionListReq.getGroupName());
        	colSearchMap.put("REL_TYPE", returnSubscriptionListReq.getSubscriptionType());
        	colSearchMap.put("STATUS", returnSubscriptionListReq.getStatus());
        
        	// HashMap contains all key with value "number" or "text" For
        	// DynamicFilter
        	HashMap<String, String> colTypeMap = new HashMap<>();
        	colTypeMap.put("COMP_CODE", "number");
        	colTypeMap.put("EVT_ID", "number");
        	colTypeMap.put("SUB_ID", "number");
        	colTypeMap.put("PKG_ID", "number");
        	colTypeMap.put("PKG_DESC_ENG", "text");
        	colTypeMap.put("EVT_DESC_ENG", "text");
        	colTypeMap.put("DEFAULT_BRIEF_NAME", "text");
        	colTypeMap.put("COMMUNICATION_TYPE", "text");
        	colTypeMap.put("GRP_ID", "number");
        	colTypeMap.put("GRP_DESC_ENG", "text");
        	colTypeMap.put("REL_TYPE", "text");
        	colTypeMap.put("STATUS", "text");
        
        	
        	/**
        	 * check Status Filter if not exist then We need add
        	 * menually
        	 */
        	Boolean isStatusFilter = false;
        	if(null != returnSubscriptionListReq.getDynamicFilter() 
        		&& null != returnSubscriptionListReq.getDynamicFilter().getFilters()
        		&& returnSubscriptionListReq.getDynamicFilter().getFilters().size() > 0 )
        	{
        	    isStatusFilter = true;
        	}
        	
        	/**
        	 * check if filter is not send from request
        	 * and status parameter is empty
        	 * then add filter menually for approve
        	 */
        	if(StringUtil.isEmptyString(returnSubscriptionListReq.getStatus()) && !isStatusFilter)
        	{
        	    colSearchMap.put("STATUS", "P");
        	}
        	
        	/**
        	 * Add Search filters
        	 */
        	alertCommonWSSC.setSearchCols(searchCol);
        	alertCommonWSSC.setColSearchMap(colSearchMap);
        	alertCommonWSSC.setColTypeMap(colTypeMap);
        	alertCommonWSSC.setDynamicFilter(returnSubscriptionListReq.getDynamicFilter());
        	
        	//function to validate operator and return search query
	  	alertCommonWSSC = alertServiceUtilBo.FilterAndValidateList(alertCommonWSSC);
	  	
	  	//copying all alertCommonWSSC properties to individualSubscriberSC
	  	PathPropertyUtil.copyMainNotNullProperties(alertCommonWSSC, subscriptionSC);
	  	subscriptionSC.setCompCode(returnSubscriptionListReq.getCompanyCode());
	  	/**
	  	 * return all subscription
	  	 * i.e: SE, SP, EG, GP
	  	 */
	  	subscriptionSC.setNbRec(AlertConstant.INT_MINUS_ONE);
	  	List<SubscriptionWsCO> subscriptionWsCOs =  subscriptionBO.returnSubscriptionWsList(subscriptionSC);
	  	
	  	if(null != subscriptionWsCOs && subscriptionWsCOs.size() > 0)
	  	{
	  	    for(SubscriptionWsCO subscriptionWsCO : subscriptionWsCOs)
	  	    {
	  		Subscription subscription = new Subscription();
	  		subscription.setSubscriberId(subscriptionWsCO.getSubscriberId());
	  		subscription.setSubscriberBriefName(subscriptionWsCO.getSubscriberDescription());
	  		subscription.setEventId(subscriptionWsCO.getEventId());
	  		subscription.setEventDescription(subscriptionWsCO.getEventDescription());
	  		subscription.setPackageId(subscriptionWsCO.getPackageId());
	  		subscription.setPacakgeName(subscriptionWsCO.getPackageName());
	  		subscription.setGroupName(subscriptionWsCO.getGroupName());
	  		subscription.setCommunicationMode(subscriptionWsCO.getCommunicationType());
	  		subscription.setSubscriptionType(subscriptionWsCO.getSubscriptionType());
	  		subscription.setStatus(subscriptionWsCO.getStatus());
	  		returnSubscriptionListResp.getSubscriptionList().add(subscription);
	  	    }
	  	}
        	return returnSubscriptionListResp;
        }

	public void setSubscriptionBO(SubscriptionBO subscriptionBO) 
	{
		this.subscriptionBO = subscriptionBO;
	}

	public void setStatusMngmntBO(StatusMngmntBO statusMngmntBO) {
		this.statusMngmntBO = statusMngmntBO;
	}

	public void setAlertServiceUtilBo(AlertServiceUtilBO alertServiceUtilBo) 
	{
		this.alertServiceUtilBo = alertServiceUtilBo;
	}
}