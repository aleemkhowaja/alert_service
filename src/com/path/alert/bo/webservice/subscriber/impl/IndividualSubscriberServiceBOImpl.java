package com.path.alert.bo.webservice.subscriber.impl;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberBO;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberConstant;
import com.path.alert.bo.webservice.AlertServiceUtilBO;
import com.path.alert.bo.webservice.AlertWebServiceWrapperConstant;
import com.path.alert.bo.webservice.subscriber.IndividualSubscriberServiceBO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberListCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.alert.subscriber.ApproveSubscriberReq;
import com.path.vo.alert.subscriber.ApproveSubscriberResp;
import com.path.vo.alert.subscriber.CreateSubscriberReq;
import com.path.vo.alert.subscriber.CreateSubscriberResp;
import com.path.vo.alert.subscriber.DeleteSubscriberReq;
import com.path.vo.alert.subscriber.DeleteSubscriberResp;
import com.path.vo.alert.subscriber.OtherLanguage;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsReq;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsResp;
import com.path.vo.alert.subscriber.ReturnSubscribersListReq;
import com.path.vo.alert.subscriber.ReturnSubscribersListResp;
import com.path.vo.alert.subscriber.Subscriber;
import com.path.vo.alert.subscriber.UpdateSubscriberReq;
import com.path.vo.alert.subscriber.UpdateSubscriberResp;
import com.path.vo.common.audit.AuditRefCO;


public class IndividualSubscriberServiceBOImpl extends BaseBO implements IndividualSubscriberServiceBO {
	//Individual Subscriber BoImpl
	private IndividualSubscriberBO individualSubscriberBO;
	
	//Alert Service BoImpl
	private AlertServiceUtilBO alertServiceUtilBo;


	@Override
	public CreateSubscriberResp createSubscriber(CreateSubscriberReq createSubscriberReq) throws Exception 
	{
		CreateSubscriberResp createSubscriberResp = new CreateSubscriberResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(createSubscriberReq, createSubscriberResp);
	    PathPropertyUtil.copyProperties(createSubscriberReq.getServiceContext(),createSubscriberResp.getResponseServiceContext());
	    
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		List<ALRT_SUB_LANGVO> otherLanguageList = new ArrayList<ALRT_SUB_LANGVO>();
		List<ALRT_SUB_ACC_EXCLVO> accountList = new ArrayList<ALRT_SUB_ACC_EXCLVO>();
		ALRT_SUB_LANGVO alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
		OtherLanguage otherLanguage = new OtherLanguage();
		
		individualSubscriberCO.getAlrtSubVO().setCIF_NO(createSubscriberReq.getCifNo());
		individualSubscriberCO.getAlrtSubVO().setUSR_ID(createSubscriberReq.getImalUserId());
		individualSubscriberCO.setCompCode(createSubscriberReq.getCompanyCode());
		//individualSubscriberCO.setBranchCode(createSubscriberReq.getBranchCode());
		
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_BRIEF_NAME(createSubscriberReq.getDefaultBriefName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_MIDDLE_NAME(createSubscriberReq.getDefaultMiddleName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_LONG_NAME(createSubscriberReq.getDefaultLongName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_ADDRESS(createSubscriberReq.getDefaultAddress());
		individualSubscriberCO.getAlrtSubVO().setLANG(createSubscriberReq.getDefaultLanguage());
		
		
	//	individualSubscriberCO.getAlrtSubVO().setNB_MSG(createSubscriberReq.getNumberMessages());
	//	individualSubscriberCO.getAlrtSubVO().setCHARGEABLE(createSubscriberReq.getChargeable());
		individualSubscriberCO.getAlrtSubVO().setCHANNEL_END_USR_ID(createSubscriberReq.getChannelEndUserId());
		   
		//get other language list 
		if(createSubscriberReq.getOtherLanguagesList() != null && createSubscriberReq.getOtherLanguagesList().size() > 0)
		{
			for(int i=0; i<createSubscriberReq.getOtherLanguagesList().size(); i++)
			{
				alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
				otherLanguage = createSubscriberReq.getOtherLanguagesList().get(i);
				alrt_SUB_LANGVO.setLANG_CODE(otherLanguage.getLanguage());
				alrt_SUB_LANGVO.setBRIEF_NAME(otherLanguage.getBriefName());
				alrt_SUB_LANGVO.setMIDDLE_NAME(otherLanguage.getMiddleName());
				alrt_SUB_LANGVO.setLONG_NAME(otherLanguage.getLongName());
				alrt_SUB_LANGVO.setADDRESS(otherLanguage.getAddress());
				otherLanguageList.add(alrt_SUB_LANGVO);
			}
		}
		
		
		individualSubscriberCO.setExcludedAccountList(accountList);
		individualSubscriberCO.setOtherLanguageList(otherLanguageList);
		// get userid and running date
		individualSubscriberCO.setUserID(createSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setRunningDate(createSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		
		IndividualSubscriberCO individualSubscriberCO2 = new IndividualSubscriberCO();
		PathPropertyUtil.copyMainNotNullProperties(individualSubscriberCO, individualSubscriberCO2);
		PathPropertyUtil.copyMainNotNullProperties(individualSubscriberCO.getAlrtSubVO(), individualSubscriberCO2.getAlrtSubVO());
		
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(createSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		auditRefCO.setUserID(createSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setAuditRefCO(auditRefCO);
		individualSubscriberCO.setAuditObj(individualSubscriberCO2);
		
		/**
		 * validate the Cif
		 */
		if(!NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getCIF_NO()))
		{
		    /**
		     * Check request cif is available in CIF table or not
		     */
		    validateCifIfExist(individualSubscriberCO);
		}
		
		/**
		 * validate the User
		 */
		if(StringUtil.isNotEmpty(individualSubscriberCO.getAlrtSubVO().getUSR_ID()))
		{
		    validateUserIfExist(individualSubscriberCO);
		}
		
		/**
		 * Email or Mobile should be mandatory
		 */
		if((createSubscriberReq.getEmailIdsList() == null || createSubscriberReq.getEmailIdsList().size() <= 0) && 
			 (createSubscriberReq.getMobilePhonesList() == null || createSubscriberReq.getMobilePhonesList().size() <= 0))
		{
		     throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"email_or_mobile_number_should_be_mandatory_key"});
		}
			
		
		/**
		 * Validate Email and Prepare from List to text
		 */
		validateAndPrepareEmail(createSubscriberReq, individualSubscriberCO);
		
		/**
		 * Validate mobile and Prepare from List to text
		 */
		validateAndPrepareMobile(createSubscriberReq, individualSubscriberCO);
		
		//create subscriber
		individualSubscriberCO = individualSubscriberBO.updateindividualSubscriber(individualSubscriberCO);
		
		createSubscriberResp.setSubscriberId(individualSubscriberCO.getAlrtSubVO().getID());

		//584652 - PBSS160068 : approve the record based on autoApproveFlag
		String autoApproveFlag = StringUtil.nullEmptyToValue(createSubscriberResp.getAutoApproveFlag(), ConstantsCommon.ZERO);
		if(ConstantsCommon.ONE.equals(autoApproveFlag))
		{
		    ApproveSubscriberReq approveSubscriberReq = new ApproveSubscriberReq();
		    approveSubscriberReq.setCompanyCode(createSubscriberResp.getCompanyCode());
		    approveSubscriberReq.setSubscriberId(createSubscriberResp.getSubscriberId());
		    approveSubscriber(approveSubscriberReq);
		}
		
		return createSubscriberResp;
	}
	
	/**
	 * Validate if User is exist or not in User Table
	 * if exist then check if the current user will use by other subscriber
	 * @param individualSubscriberCO
	 * @throws BaseException
	 */
	private void validateUserIfExist(IndividualSubscriberCO individualSubscriberCO) throws BaseException
	{
	    IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
	    individualSubscriberSC.setUserID(individualSubscriberCO.getAlrtSubVO().getUSR_ID());
	    individualSubscriberSC.setCompCode(individualSubscriberCO.getCompCode());
	    
	    /**
	     * Validate the User
	     */
	    int count = individualSubscriberBO.validateIfUserExist(individualSubscriberSC);
	    
	    if(count > 0)
		throw new BOException(MessageCodes.USER_ALREADY_SUBSCRIBER);
	    
	    
	}

	/**
	 * Validate if Cif is exist or not in CIF Table
	 * if exist then check if the current cif will use by other subscriber
	 * @param individualSubscriberSC
	 * @throws BaseException
	 */
	private void validateCifIfExist(IndividualSubscriberCO co) throws BaseException
	{
	    IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
	    individualSubscriberSC.setCif(co.getAlrtSubVO().getCIF_NO());
	    individualSubscriberSC.setCompCode(co.getCompCode());
	    
	    /**
	     * validate the cif from CIF table
	     */
	    int count = individualSubscriberBO.validateIfCifExist(individualSubscriberSC);
	    
	    if(count > 0)
		throw new BOException(MessageCodes.CIF_ALREADY_SUBSCRIBER);
	}

	/*
	 * return true or false if OMNI admin installed
	 */
	private boolean isOMNIAdminInstalled() throws BaseException
	{
	    S_APPVO sAppVO = new S_APPVO();
	    sAppVO.setAPP_NAME(AlertConstant.OMNI_ADMIN_APP_NAME);
	    return commonLibBO.returnApplication(sAppVO) != null;
	}

	/**
	 * Validate and Prepare Emails
	 * @param createSubscriberReq
	 * @param individualSubscriberCO
	 * @throws BaseException
	 */
	private void validateAndPrepareEmail(CreateSubscriberReq createSubscriberReq, IndividualSubscriberCO individualSubscriberCO) throws BaseException
	{
	    ArrayList<String> emailListForDuplication = new ArrayList<String>();
        
	    // get email list
	    if(createSubscriberReq.getEmailIdsList() != null)
	    {
		String emailIds = "";
		for(int i = 0; i < createSubscriberReq.getEmailIdsList().size(); i++)
		{
		    /**
		     * Check if email number is already available in list
		     */
		    if(!emailListForDuplication.isEmpty()
			    && emailListForDuplication.contains(createSubscriberReq.getEmailIdsList().get(i)))
		    {
			throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"duplicate_entry_of_email"});
		    }
        
		    /**
		     * Check Email Id Char It should be less then and equal to 256
		     */
		    if(createSubscriberReq.getEmailIdsList().get(i).length() > 256)
		    {
			throw new BOException("Email Should Contains 250 Alpha Numeric");
		    }
        
		    if(StringUtil.isEmptyString(createSubscriberReq.getEmailIdsList().get(i))) continue;
		    
		    if(i < createSubscriberReq.getEmailIdsList().size())
		    {
			emailIds += createSubscriberReq.getEmailIdsList().get(i) + "<<->>";
		    }
		    else
		    {
			emailIds += createSubscriberReq.getEmailIdsList().get(i);
		    }
        
		    /**
		     * Add email in List for checking the duplication
		     */
		    emailListForDuplication.add(createSubscriberReq.getEmailIdsList().get(i));
		}
		individualSubscriberCO.getAlrtSubVO().setEMAIL_ID(emailIds);
	    }
	}
	
	/**
	 * Validate and Prepare Mobile Phones
	 * @param createSubscriberReq
	 * @param individualSubscriberCO
	 * @throws BaseException
	 */
	private void validateAndPrepareMobile(CreateSubscriberReq createSubscriberReq, IndividualSubscriberCO individualSubscriberCO) throws BaseException
	{
	    ArrayList<String> mobileListForDuplication = new ArrayList<String>();
	  
	    //get mobile list
        	if(createSubscriberReq.getMobilePhonesList() != null)
        	{
        	    String mobilePhones = "";
        	    for(int i = 0; i < createSubscriberReq.getMobilePhonesList().size(); i++)
        	    {
        		/**
        		 * Check if mobile number is already available in list
        		 */
        		if(!mobileListForDuplication.isEmpty()
        			&& mobileListForDuplication.contains(createSubscriberReq.getMobilePhonesList().get(i)))
        		{
        		    throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"duplicate_entry_of_mobile_key"});
        		}
        
        		/**
        		 * Check Mobile Number Digits It should be less then and equal
        		 * to 15
        		 */
        		if(createSubscriberReq.getMobilePhonesList().get(i).length() > 23)
        		{
        		    throw new BOException("Mobile Phone Should Contains 23 Digits");
        		}
        
        		if(StringUtil.isEmptyString(createSubscriberReq.getMobilePhonesList().get(i))) continue;
        		
        		if(i < createSubscriberReq.getMobilePhonesList().size())
        		{
        		    mobilePhones += createSubscriberReq.getMobilePhonesList().get(i) + "<<->>";
        		}
        		else
        		{
        		    mobilePhones += createSubscriberReq.getMobilePhonesList().get(i);
        		}
        		/**
        		 * Add mobile in List for checking the duplication
        		 */
        		mobileListForDuplication.add(createSubscriberReq.getMobilePhonesList().get(i));
        	    }
        	    individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(mobilePhones);
        	}
        }
	@Override
	public UpdateSubscriberResp updateSubscriber(UpdateSubscriberReq updateSubscriberReq) throws Exception
	{
		UpdateSubscriberResp updateSubscriberResp = new UpdateSubscriberResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(updateSubscriberReq, updateSubscriberResp);
	    PathPropertyUtil.copyProperties(updateSubscriberReq.getServiceContext(),updateSubscriberResp.getResponseServiceContext());
	    
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberCO oldIndividualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
		List<ALRT_SUB_ACC_EXCLVO> accountList = new ArrayList<ALRT_SUB_ACC_EXCLVO>();
//		ALRT_SUB_ACC_EXCLVO sub_ACCOUNTSVO = new ALRT_SUB_ACC_EXCLVO();
		List newOtherLanguageList = new ArrayList<>();
		List updateOtherLanguageList = new ArrayList<>();
		List deleteOtherLanguageList = new ArrayList<>();
		ALRT_SUB_LANGVO alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
		individualSubscriberCO.getAlrtSubVO().setID(updateSubscriberReq.getSubscriberId());
		individualSubscriberCO.getAlrtSubVO().setCOMP_CODE(updateSubscriberReq.getCompanyCode());
		
		individualSubscriberCO.setCompCode(updateSubscriberReq.getCompanyCode());
	//	individualSubscriberCO.setBranchCode(updateSubscriberReq.getBranchCode());
		//set new mobile list
		individualSubscriberCO.setNewMobilePhoneList(updateSubscriberReq.getNewMobilePhonesList());
		//set delete mobile list
		individualSubscriberCO.setDeletedMobilePhoneList(updateSubscriberReq.getDeletedMobilePhonesList());
		//set new email list
		individualSubscriberCO.setNewEmailIds(updateSubscriberReq.getNewEmailIdsList());

		//set deleted emails list
		individualSubscriberCO.setDeletedEmailIds(updateSubscriberReq.getDeletedEmailIdsList());
	//	individualSubscriberCO.getAlrtSubVO().setNB_MSG(updateSubscriberReq.getNumberMessages());
	//	individualSubscriberCO.getAlrtSubVO().setCHARGEABLE(updateSubscriberReq.getChargeable());
		individualSubscriberCO.getAlrtSubVO().setCHANNEL_END_USR_ID(updateSubscriberReq.getChannelEndUserId());
//		individualSubscriberCO.getAlrtSubVO().setFACEBOOK_SOCIAL_ID(updateSubscriberReq.getActivateFacebook());
	//	individualSubscriberCO.getAlrtSubVO().setTWITTER_SOCIAL_ID(updateSubscriberReq.getActivateTwitter());
		
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_BRIEF_NAME(updateSubscriberReq.getDefaultBriefName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_MIDDLE_NAME(updateSubscriberReq.getDefaultMiddleName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_LONG_NAME(updateSubscriberReq.getDefaultLongName());
		individualSubscriberCO.getAlrtSubVO().setDEFAULT_ADDRESS(updateSubscriberReq.getDefaultAddress());
		individualSubscriberCO.getAlrtSubVO().setLANG(updateSubscriberReq.getDefaultLanguage());
		
		//get mobile list
		/*if(updateSubscriberReq.getNewMobilePhonesList() != null )
		{
			String mobilePhones = "";
			for(int i=0; i<updateSubscriberReq.getNewMobilePhonesList().size(); i++)
			{
				if(i < updateSubscriberReq.getNewMobilePhonesList().size())
				{
					mobilePhones+=updateSubscriberReq.getNewMobilePhonesList().get(i)+"<<->>";
				}
				else
				{
					mobilePhones+=updateSubscriberReq.getNewMobilePhonesList().get(i);
				}
					
			}
			individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(((mobilePhones.isEmpty()) ? null : mobilePhones));
		}
		
		//get email list
		if(updateSubscriberReq.getNewEmailIdsList() != null )
		{
			String emailIds = "";
			for(int i=0; i<updateSubscriberReq.getNewEmailIdsList().size(); i++)
			{
				if(i < updateSubscriberReq.getNewEmailIdsList().size())
				{
					emailIds+=updateSubscriberReq.getNewEmailIdsList().get(i)+"<<->>";
				}
				else
				{
					emailIds+=updateSubscriberReq.getNewEmailIdsList().get(i);
				}
				
			}
			individualSubscriberCO.getAlrtSubVO().setEMAIL_ID(((emailIds.isEmpty()) ? null : emailIds));
		}*/
		//Add New Other Lnaguages
	    if(updateSubscriberReq.getNewOtherLanguagesList() != null)
	    {
	    	for(int i=0; i<updateSubscriberReq.getNewOtherLanguagesList().size(); i++)
	    	{
	    		OtherLanguage otherLanguage = updateSubscriberReq.getNewOtherLanguagesList().get(i);
	    		alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	    		alrt_SUB_LANGVO.setLANG_CODE(otherLanguage.getLanguage());
	    		alrt_SUB_LANGVO.setBRIEF_NAME(otherLanguage.getBriefName());
	    		alrt_SUB_LANGVO.setMIDDLE_NAME(otherLanguage.getMiddleName());
	    		alrt_SUB_LANGVO.setLONG_NAME(otherLanguage.getLongName());
	    		alrt_SUB_LANGVO.setADDRESS(otherLanguage.getAddress());
	    		newOtherLanguageList.add(alrt_SUB_LANGVO);
	    	}
	    }
	    
	    //Update Other Languages
	    if(updateSubscriberReq.getUpdatedOtherLanguagesList() != null)
	    {
	    	for(int i=0; i<updateSubscriberReq.getUpdatedOtherLanguagesList().size(); i++)
	    	{
	    		OtherLanguage otherLanguage = updateSubscriberReq.getUpdatedOtherLanguagesList().get(i);
	    		alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	    		alrt_SUB_LANGVO.setLANG_CODE(otherLanguage.getLanguage());
	    		alrt_SUB_LANGVO.setBRIEF_NAME(otherLanguage.getBriefName());
	    		alrt_SUB_LANGVO.setMIDDLE_NAME(otherLanguage.getMiddleName());
	    		alrt_SUB_LANGVO.setLONG_NAME(otherLanguage.getLongName());
	    		alrt_SUB_LANGVO.setADDRESS(otherLanguage.getAddress());
	    		updateOtherLanguageList.add(alrt_SUB_LANGVO);
	    	}
	    }
	    
	    //Delete Other Languages
	    if(updateSubscriberReq.getDeletedOtherLanguagesList() != null)
	    {
	    	for(int i=0; i<updateSubscriberReq.getDeletedOtherLanguagesList().size(); i++)
	    	{
	    		OtherLanguage otherLanguage = updateSubscriberReq.getDeletedOtherLanguagesList().get(i);
	    		alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	    		alrt_SUB_LANGVO.setLANG_CODE(otherLanguage.getLanguage());
	    		alrt_SUB_LANGVO.setBRIEF_NAME(otherLanguage.getBriefName());
	    		alrt_SUB_LANGVO.setMIDDLE_NAME(otherLanguage.getMiddleName());
	    		alrt_SUB_LANGVO.setLONG_NAME(otherLanguage.getLongName());
	    		alrt_SUB_LANGVO.setADDRESS(otherLanguage.getAddress());
	    		deleteOtherLanguageList.add(alrt_SUB_LANGVO);
	    	}
	    }
	    
	    //Add/Update/Delete Other languages list
	    individualSubscriberCO.setNewOtherLanguageList(newOtherLanguageList);
	    individualSubscriberCO.setUpdateOtherLanguageList(updateOtherLanguageList);
	    individualSubscriberCO.setDeleteOtherLanguageList(deleteOtherLanguageList);
	    
		/*if(updateSubscriberReq.getExcludedAccountsList() != null && updateSubscriberReq.getExcludedAccountsList().size() > 0)
		{
			Account account2 = new Account();
			CifSC cifCriteria = new CifSC();
			for(int i=0; i<updateSubscriberReq.getExcludedAccountsList().size(); i++)
			{
				account2 = updateSubscriberReq.getExcludedAccountsList().get(i);
				cifCriteria = new CifSC();
				cifCriteria.setComp_code(individualSubscriberCO.getCompCode());
				cifCriteria.setCif_no(account2.getCifNo());
				cifCriteria.setBranchCode(account2.getBranch());
				cifCriteria.setCurrencyCode(account2.getCurrency());
				cifCriteria.setSlNbr(account2.getSerialNo());
				cifCriteria.setGlCode(account2.getAccGl());
				cifCriteria.setNbRec(-1);
				List<AMFVO> amfvoList = individualSubscriberBO.accountList(cifCriteria);
				if(amfvoList != null && amfvoList.size() > 0)
				{
					ALRT_SUB_ACC_EXCLVO newALRT_SUB_ACCOUNTSVO = new ALRT_SUB_ACC_EXCLVO();
					newALRT_SUB_ACCOUNTSVO.setBRANCH_CODE(account2.getBranch());
					newALRT_SUB_ACCOUNTSVO.setCIF_SUB_NO(account2.getCifNo());
					newALRT_SUB_ACCOUNTSVO.setSL_NO(account2.getSerialNo());
					newALRT_SUB_ACCOUNTSVO.setGL_CODE(account2.getAccGl());
					newALRT_SUB_ACCOUNTSVO.setCURRENCY_CODE(account2.getCurrency());
					accountList.add(newALRT_SUB_ACCOUNTSVO);
				}
			}
		}*/
		individualSubscriberCO.setExcludedAccountList(accountList);
		
		//set UserId/language/running date
		individualSubscriberCO.setLanguage(IndividualSubscriberConstant.LANG_CODE_EN);
		individualSubscriberCO.setUserID(updateSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setRunningDate(updateSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		
		//For Audit related params
		individualSubscriberSC.setCompCode(updateSubscriberReq.getCompanyCode());
		//individualSubscriberSC.setBranchCode(updateSubscriberReq.getBranchCode());
		individualSubscriberSC.setSubID(updateSubscriberReq.getSubscriberId());
		
		//retrieve old object of subscriber
		oldIndividualSubscriberCO = individualSubscriberBO.loadDataFromDb(individualSubscriberCO, individualSubscriberSC);
		
		IndividualSubscriberCO individualSubscriberCO2 = new IndividualSubscriberCO();
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO, individualSubscriberCO2);
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO.getAlrtSubVO(), individualSubscriberCO2.getAlrtSubVO());
		
		individualSubscriberCO.setOldEmailIds(oldIndividualSubscriberCO.getAlrtSubVO().getEMAIL_ID());
		individualSubscriberCO.setOldMobilePhoneList(oldIndividualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE());
		
		individualSubscriberCO.getAlrtSubVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
		auditRefCO.setAuditEnabled(false);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.UPDATE);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(individualSubscriberCO.getRunningDate());
		auditRefCO.setUserID(individualSubscriberCO.getUserID());
		individualSubscriberCO.setAuditRefCO(auditRefCO);
		individualSubscriberCO.setAuditObj(oldIndividualSubscriberCO.getAlrtSubVO());
		
		/**
		 * set Subscriber status = Approve
		 * if user send AutoApproveFlag=1
		 */
		String autoApproveFlag = StringUtil.nullEmptyToValue(updateSubscriberReq.getAutoApproveFlag(), ConstantsCommon.ZERO);
		if(ConstantsCommon.ONE.equals(autoApproveFlag))
		{
		    individualSubscriberCO.getAlrtSubVO().setSTATUS(AlertConstant.STATUS_APPROVED);
		}
		
		individualSubscriberBO.updateindividualSubscriber(individualSubscriberCO);
		return updateSubscriberResp;
	}

	@Override
	public ApproveSubscriberResp approveSubscriber(ApproveSubscriberReq approveSubscriberReq) throws Exception 
	{
		ApproveSubscriberResp approveSubscriberResp = new ApproveSubscriberResp();
		
		PathPropertyUtil.copyProperties(approveSubscriberReq , approveSubscriberResp);
	    PathPropertyUtil.copyProperties(approveSubscriberReq.getServiceContext(),approveSubscriberResp.getResponseServiceContext());
	    
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberCO oldIndividualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
		individualSubscriberSC.setSubID(approveSubscriberReq.getSubscriberId());
		individualSubscriberSC.setCompCode(approveSubscriberReq.getCompanyCode());
	//	individualSubscriberSC.setBranchCode(approveSubscriberReq.getBranchCode());
				
		individualSubscriberCO.getAlrtSubVO().setID(approveSubscriberReq.getSubscriberId());
		individualSubscriberCO.setCompCode(approveSubscriberReq.getCompanyCode());
	//	individualSubscriberCO.setBranchCode(approveSubscriberReq.getBranchCode());
		individualSubscriberCO.setUserID(approveSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setRunningDate(approveSubscriberReq.getRequesterContext().getRequesterTimeStamp());
//		individualSubscriberCO.getAlrtSubVO().setDATE_UPDATED(approveSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		individualSubscriberCO.getAlrtSubVO().setDATE_AUTHORIZED(approveSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		individualSubscriberCO.getAlrtSubVO().setAUTHORIZED_BY(approveSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setLanguage(IndividualSubscriberConstant.LANG_CODE_EN);
		individualSubscriberCO.getAlrtSubVO().setIsSybase(1);
				
		// retrieve old object of subscriber
		oldIndividualSubscriberCO = individualSubscriberBO.loadDataFromDb(individualSubscriberCO, individualSubscriberSC);
				
		IndividualSubscriberCO individualSubscriberCO2 = new IndividualSubscriberCO();
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO, individualSubscriberCO2);
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO.getAlrtSubVO(), individualSubscriberCO2.getAlrtSubVO());
			
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(individualSubscriberCO.getRunningDate());
		auditRefCO.setUserID(individualSubscriberCO.getUserID());
		individualSubscriberCO.setAuditRefCO(auditRefCO);
		individualSubscriberCO.setAuditObj(individualSubscriberCO2);
		
		// approve subscriber
		individualSubscriberBO.approveIndSubscriber(individualSubscriberCO);
		
		return approveSubscriberResp;
	}
	
	@Override
	public DeleteSubscriberResp deleteSubscriber(DeleteSubscriberReq deleteSubscriberReq) throws Exception 
	{
		DeleteSubscriberResp deleteSubscriberResp = new DeleteSubscriberResp();
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(deleteSubscriberReq , deleteSubscriberResp);
	    PathPropertyUtil.copyProperties(deleteSubscriberReq.getServiceContext(),deleteSubscriberResp.getResponseServiceContext());
	    
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
		IndividualSubscriberCO oldIndividualSubscriberCO = new IndividualSubscriberCO();

		individualSubscriberCO.getAlrtSubVO().setID(deleteSubscriberReq.getSubscriberId());
		individualSubscriberCO.setCompCode(deleteSubscriberReq.getCompanyCode());
		//individualSubscriberCO.setBranchCode(deleteSubscriberReq.getBranchCode());
		individualSubscriberCO.setUserID(deleteSubscriberReq.getRequesterContext().getUserID());
		individualSubscriberCO.setRunningDate(deleteSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		
		//individualSubscriberCO.getAlrtSubVO().setDATE_UPDATED(deleteSubscriberReq.getRequesterContext().getRequesterTimeStamp());
		individualSubscriberCO.setLanguage(IndividualSubscriberConstant.LANG_CODE_EN);
		
		//For Audit related params
		individualSubscriberSC.setCompCode(deleteSubscriberReq.getCompanyCode());
	//	individualSubscriberSC.setBranchCode(deleteSubscriberReq.getBranchCode());
		individualSubscriberSC.setSubID(deleteSubscriberReq.getSubscriberId());
			
		//retrieve old object of subscriber
		oldIndividualSubscriberCO = individualSubscriberBO.loadDataFromDb(individualSubscriberCO, individualSubscriberSC);
			
		IndividualSubscriberCO individualSubscriberCO2 = new IndividualSubscriberCO();
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO, individualSubscriberCO2);
		PathPropertyUtil.copyMainNotNullProperties(oldIndividualSubscriberCO.getAlrtSubVO(), individualSubscriberCO2.getAlrtSubVO());
			
		// Set Audit
		AuditRefCO auditRefCO = new AuditRefCO();
		auditRefCO.setDisableSmart(true);
		auditRefCO.setAuditEnabled(false);
		auditRefCO.setProgRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
		auditRefCO.setAppName(AlertConstant.ALRT_APP_NAME);
		auditRefCO.setOperationType(AuditConstant.CREATED);
		auditRefCO.setKeyRef(AuditConstant.ALERT_SUBSCRIBER_KEY_REF);
		auditRefCO.setRunningDate(individualSubscriberCO.getRunningDate());
		auditRefCO.setUserID(individualSubscriberCO.getUserID());
		individualSubscriberCO.setAuditRefCO(auditRefCO);
		individualSubscriberCO.setAuditObj(individualSubscriberCO2);
		
		//delete subscriber
		individualSubscriberBO.deleteIndSubscriber(individualSubscriberCO);
		return deleteSubscriberResp;
	}
	
	@Override
	public ReturnSubscribersListResp returnSubscriberList(ReturnSubscribersListReq returnSubscribersListReq) throws Exception 
	{
		ReturnSubscribersListResp returnSubscribersListResp = new ReturnSubscribersListResp();
		
		//copy all request input to the response
	    PathPropertyUtil.copyProperties(returnSubscribersListReq, returnSubscribersListResp);
	    PathPropertyUtil.copyProperties(returnSubscribersListReq.getServiceContext(),returnSubscribersListResp.getResponseServiceContext());
	    
	    
		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
		String[] searchCol = { "CIF_NO",  "USR_ID", "COMP_CODE", "BRIEF_NAME", "CHANNEL_END_USR_ID", "STATUS_DESC", "STATUS"};
		
		
	    individualSubscriberSC.setSearchCols(searchCol);
	    AlertCommonWSSC alertCommonWSSC = new AlertCommonWSSC();
	    
	    //fill map for search same as assets
	  	HashMap<String, Object> colSearchMap = new HashMap<>();
	  	colSearchMap.put("CIF_NO", returnSubscribersListReq.getCifNo());
	  	colSearchMap.put("USR_ID", returnSubscribersListReq.getImalUserId());
	  	colSearchMap.put("COMP_CODE", returnSubscribersListReq.getCompanyCode());
	  	colSearchMap.put("BRIEF_NAME", returnSubscribersListReq.getBriefNameEnglish());
	  	colSearchMap.put("CHANNEL_END_USR_ID", returnSubscribersListReq.getChannelEndUserId());
	  	colSearchMap.put("STATUS_DESC", returnSubscribersListReq.getStatus());
	  	
	  	// HashMap contains all key with value "number" or "text" For DynamicFilter
	  	HashMap<String, String> colTypeMap = new HashMap<>();
	  	colTypeMap.put("CIF_NO", "number");
	  	colTypeMap.put("USR_ID", "text");
	  	colTypeMap.put("COMP_CODE", "number");
	  	colTypeMap.put("BRIEF_NAME", "text");
	  	colTypeMap.put("CHANNEL_END_USR_ID", "number");
	  	colTypeMap.put("STATUS_DESC", "text");
	  	colTypeMap.put("MOBILE_PHONE", "text");
	  	colTypeMap.put("EMAIL_ID", "text");
	  	colTypeMap.put("LANG", "text");
	  	colTypeMap.put("NOTIFIED", "number");
	  	colTypeMap.put("CREATED_BY", "text");
	  	colTypeMap.put("DATE_CREATED", "date");
	  	colTypeMap.put("MODIFIED_BY", "text");
	  	colTypeMap.put("DATE_MODIFIED", "date");
	  	colTypeMap.put("DELETED_BY", "text");
	  	colTypeMap.put("DATE_DELETED", "date");
	  	colTypeMap.put("AUTHORIZED_BY", "text");
	  	colTypeMap.put("DATE_AUTHORIZED", "date");
	  	colTypeMap.put("DATE_UPDATED", "date");
	  	
	  	alertCommonWSSC.setSearchCols(searchCol);
	  	alertCommonWSSC.setColSearchMap(colSearchMap);
	  	alertCommonWSSC.setColTypeMap(colTypeMap);
	  	alertCommonWSSC.setDynamicFilter(returnSubscribersListReq.getDynamicFilter());
  		
	  	//function to validate operator and return search query
	  	alertCommonWSSC = alertServiceUtilBo.FilterAndValidateList(alertCommonWSSC);
	  	
	  	//copying all alertCommonWSSC properties to individualSubscriberSC
	  	PathPropertyUtil.copyMainNotNullProperties(alertCommonWSSC, individualSubscriberSC);
	  	
	  	individualSubscriberSC.setIvCrud(AlertConstant.CRUD_R);
	  	individualSubscriberSC.setNbRec(AlertConstant.INT_MINUS_ONE);
	  	
	  	individualSubscriberSC.setLovTypeId(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
	  	individualSubscriberSC.setLangCode(returnSubscribersListReq.getRequesterContext().getLangId());
	  	individualSubscriberSC.setSubTypeLov(AlertConstant.subscriberTypeDropDown);
	  	individualSubscriberSC.setIndSubLangCode(IndividualSubscriberConstant.LANG_CODE_EN);
	  	individualSubscriberSC.setPageRef(IndividualSubscriberConstant.SUBSCRIBER_PROG_REF);
	  	individualSubscriberSC.setCurrAppName(AlertConstant.ALRT_APP_NAME);
	  	individualSubscriberSC.setCompCode(returnSubscribersListReq.getCompanyCode());
	  	
	  	List<IndividualSubscriberListCO> individualSubscriberCOs =  individualSubscriberBO.indSubscriberList(individualSubscriberSC);
	  	
	  	Subscriber subscriber = new Subscriber();
	  	IndividualSubscriberListCO individualSubscriberListCO = new IndividualSubscriberListCO();
	  	for(int i=0; i<individualSubscriberCOs.size(); i++)
	  	{
	  		individualSubscriberListCO = individualSubscriberCOs.get(i);
	  		subscriber = new Subscriber();
	  		subscriber.setSubscriberId(individualSubscriberListCO.getID());
	  		subscriber.setCifNo(individualSubscriberListCO.getCIF_NO());
	  		subscriber.setImalUserId(individualSubscriberListCO.getUSR_ID());
	  		subscriber.setBriefNameEnglish(individualSubscriberListCO.getBRIEF_NAME());
	  		subscriber.setStatus(individualSubscriberListCO.getSTATUS_DESC());
	  		subscriber.setChannelEndUserId(individualSubscriberListCO.getCHANNEL_END_USR_ID());
	  		returnSubscribersListResp.getSubscriberList().add(subscriber);
	  	}
	  	
	  	return returnSubscribersListResp;
	}

	@Override
	public ReturnSubscriberDetailsResp returnSubscriberDetails(ReturnSubscriberDetailsReq returnSubscriberDetailsReq) throws Exception 
	{
		ReturnSubscriberDetailsResp returnSubscriberDetailsResp = new ReturnSubscriberDetailsResp();

		//copy all request input to the response
		PathPropertyUtil.copyProperties(returnSubscriberDetailsReq, returnSubscriberDetailsResp);
	    PathPropertyUtil.copyProperties(returnSubscriberDetailsReq.getServiceContext(), returnSubscriberDetailsResp.getResponseServiceContext());
		    
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
			
		individualSubscriberCO.getAlrtSubVO().setID(returnSubscriberDetailsReq.getSubscriberId());
		
		//set CuserId/Running Date/Language
		individualSubscriberCO.setUserID(returnSubscriberDetailsReq.getRequesterContext().getUserID());
		individualSubscriberCO.setRunningDate(returnSubscriberDetailsReq.getRequesterContext().getRequesterTimeStamp());
		individualSubscriberCO.getAlrtSubVO().setDATE_UPDATED(returnSubscriberDetailsReq.getRequesterContext().getRequesterTimeStamp());
		individualSubscriberCO.setLanguage(IndividualSubscriberConstant.LANG_CODE_EN);
		//For Audit related params
		individualSubscriberSC.setCompCode(returnSubscriberDetailsReq.getCompanyCode());
//		individualSubscriberSC.setBranchCode(returnSubscriberDetailsReq.getBranchCode());
		individualSubscriberSC.setSubID(returnSubscriberDetailsReq.getSubscriberId());
		//return Subscriber CO
		individualSubscriberCO = individualSubscriberBO.loadDataFromDb(individualSubscriberCO, individualSubscriberSC);
		if(individualSubscriberCO != null)
		{
			ALRT_SUBVO alrt_SUBVO = individualSubscriberCO.getAlrtSubVO();
			returnSubscriberDetailsResp.setSubscriberId(alrt_SUBVO.getID());
			returnSubscriberDetailsResp.setImalUserId(alrt_SUBVO.getUSR_ID());
		//	returnSubscriberDetailsResp.setNumberMessages(alrt_SUBVO.getNB_MSG());
		//	returnSubscriberDetailsResp.setChargeable(alrt_SUBVO.getCHARGEABLE());
			returnSubscriberDetailsResp.setChannelEndUserId(alrt_SUBVO.getCHANNEL_END_USR_ID());
		//	returnSubscriberDetailsResp.setActivateFacebook(alrt_SUBVO.getFACEBOOK_SOCIAL_ID());
		//	returnSubscriberDetailsResp.setActivateTwitter(alrt_SUBVO.getTWITTER_SOCIAL_ID());
			returnSubscriberDetailsResp.setCifNo(alrt_SUBVO.getCIF_NO());
			returnSubscriberDetailsResp.setDefaultBriefName(alrt_SUBVO.getDEFAULT_BRIEF_NAME());
			returnSubscriberDetailsResp.setDefaultMiddleName(alrt_SUBVO.getDEFAULT_MIDDLE_NAME());
			returnSubscriberDetailsResp.setDefaultLongName(alrt_SUBVO.getDEFAULT_LONG_NAME());
			returnSubscriberDetailsResp.setDefaultAddress(alrt_SUBVO.getDEFAULT_ADDRESS());
			returnSubscriberDetailsResp.setDefaultLanguage(alrt_SUBVO.getLANG());
			
			individualSubscriberSC.setLangCode(null);
			individualSubscriberSC.setIndSubLangCode(null);
			individualSubscriberSC.setNbRec(AlertConstant.INT_MINUS_ONE);
			
			//set Email Ids
			List<String> emailIdsList = new ArrayList<String>(); 
			if(alrt_SUBVO.getEMAIL_ID() != null && !alrt_SUBVO.getEMAIL_ID().isEmpty())
			{
				String emails[] = alrt_SUBVO.getEMAIL_ID().split("<<->>");
				for(String email : emails)
				{
					if(!email.trim().isEmpty())
					{
						emailIdsList.add(email);
					}
				}
			}
			returnSubscriberDetailsResp.setEmailIdsList(emailIdsList);
			
			//set Mobile Phone Numbers
			List<String> mobilePhonesList = new ArrayList<String>(); 
			if(alrt_SUBVO.getMOBILE_PHONE() != null && !alrt_SUBVO.getMOBILE_PHONE().isEmpty())
			{
				String mobileNos[] = alrt_SUBVO.getMOBILE_PHONE().split("<<->>");
				for(String mobileNo : mobileNos)
				{
					if(!mobileNo.trim().isEmpty())
					{
						mobilePhonesList.add(mobileNo);
					}
				}
			}
			returnSubscriberDetailsResp.setMobilePhonesList(mobilePhonesList);
				
			
			//return other languages of subscriber
			List<ALRT_SUB_LANGVO> subscriberOtherLanguageList = individualSubscriberBO.returnIndividualSubscriberOtherLanguageList(individualSubscriberSC);
			List<OtherLanguage> otherLanguageList = new ArrayList<OtherLanguage>();
			OtherLanguage otherLanguage = new OtherLanguage();
			
			if(subscriberOtherLanguageList != null)
			{
				for(int i=0; i<subscriberOtherLanguageList.size(); i++)
				{
					ALRT_SUB_LANGVO alrt_SUB_LANGVO = subscriberOtherLanguageList.get(i);
					otherLanguage = new OtherLanguage();
					otherLanguage.setLanguage(alrt_SUB_LANGVO.getLANG_CODE());
					otherLanguage.setBriefName(alrt_SUB_LANGVO.getBRIEF_NAME());
					otherLanguage.setMiddleName(alrt_SUB_LANGVO.getMIDDLE_NAME());
					otherLanguage.setLongName(alrt_SUB_LANGVO.getLONG_NAME());
					otherLanguage.setAddress(alrt_SUB_LANGVO.getADDRESS());
					otherLanguageList.add(otherLanguage);
				}
			}
				
			/*//return all multple Accounts of Subscriber
			List<AMFVO> accountsList =  individualSubscriberBO.returnIndividualSubscriberMultipleAccountsList(individualSubscriberSC);
			List<Account> excludedAccountsList = new ArrayList<Account>();
			Account accounts = new Account();
			
			if(excludedAccountsList != null)
			{
				for(int i=0; i<accountsList.size(); i++)
				{
					AMFVO amfvo = accountsList.get(i);
					accounts = new Account();
					accounts.setCurrency(amfvo.getCURRENCY_CODE());
					accounts.setAccGl(amfvo.getGL_CODE());
					accounts.setCifNo(amfvo.getCIF_SUB_NO());
					accounts.setSerialNo(amfvo.getSL_NO());
					accounts.setBranch(amfvo.getBRANCH_CODE());
					excludedAccountsList.add(accounts);
				}
			}*/
			
			returnSubscriberDetailsResp.setOtherLanguagesList(otherLanguageList);
			//returnSubscriberDetailsResp.setExcludedAccountsList(excludedAccountsList);
		}
		return returnSubscriberDetailsResp;
	}
	
	
	@Override
	public Map<String, Object> returnSubscriberIdByCifOrOmniUser(Map<String, Object> criteria) throws BaseException
	{
		IndividualSubscriberSC subscriberSC = (IndividualSubscriberSC) PathPropertyUtil.convertToObject((HashMap<String, Object>) criteria, IndividualSubscriberSC.class);
		
		IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
		
		subscriberSC.setCompCode((BigDecimal) criteria.get("compCode"));
		individualSubscriberCO.setLanguage(IndividualSubscriberConstant.LANG_CODE_EN);
		subscriberSC.setCif((BigDecimal) criteria.get("cif"));
		subscriberSC.setUserID((String) criteria.get("omniUser"));
		
       
		Map<String, Object> result = new HashMap<String, Object>();
		 
		/**
		 * Check Parameters
		 * 1 -cif
		 * 2 - omni user id
		 * 
		 */
		if(NumberUtil.isEmptyDecimal(subscriberSC.getCif()) && StringUtil.isEmptyString(subscriberSC.getUserID()))
		{
			result.put("status", AlertWebServiceWrapperConstant.ERROR_STATUS_CODE);
			result.put("msg", AlertWebServiceWrapperConstant.INVALID_PARAM_ERROR_DESC);
			
			return result;
		}
		
		/**
		 * Check Company Code
		 */
		if(NumberUtil.isEmptyDecimal(subscriberSC.getCompCode()))
		{
			result.put("status", AlertWebServiceWrapperConstant.ERROR_STATUS_CODE);
			result.put("msg", AlertWebServiceWrapperConstant.MISSING_COMP_CODE_DESC);
			
			return result;
		}
		
		/**
		 * return data by channel id or cif
		 */
		individualSubscriberCO = individualSubscriberBO.loadDataFromDb(individualSubscriberCO, subscriberSC);
		
	   
	    if(individualSubscriberCO != null && individualSubscriberCO.getAlrtSubVO() != null && !NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getID()))
	    {
	    	result.put("subscriberId", individualSubscriberCO.getAlrtSubVO().getID());
	    	result.put("status", AlertWebServiceWrapperConstant.RECORD_SUCCESS);
			result.put("msg", AlertWebServiceWrapperConstant.RECORD_SUCCESS_DESC);
	    }
	    else
	    {
	    	result.put("status", AlertWebServiceWrapperConstant.RECORD_NOT_FOUND);
			result.put("msg", AlertWebServiceWrapperConstant.RECORD_NOT_FOUND_DESC);
	    }
	    return result;	    
	}
	
	public void setIndividualSubscriberBO(IndividualSubscriberBO individualSubscriberBO) 
	{
		this.individualSubscriberBO = individualSubscriberBO;
	}

	public void setAlertServiceUtilBo(AlertServiceUtilBO alertServiceUtilBo) 
	{
		this.alertServiceUtilBo = alertServiceUtilBo;
	}

}
