
package com.path.alert.bo.subscriber.individual.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.engine.AlertEngineBO;
import com.path.alert.bo.events.event.IndividualEventConstant;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberBO;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberConstant;
import com.path.alert.bo.subscription.SubscriptionConstant;
import com.path.alert.dao.subscriber.individual.IndividualSubscriberDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.notification.AlertNotificationCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberListCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.alert.vo.subscriber.individual.OmniUserCO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.customization.button.ButtonCustomizationRmiCallerBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_QUEUEVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.remote.RmiServiceCaller;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.cif.CifSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: freddymbarak
 * 
 * 
 */
@SuppressWarnings("serial")
public class IndividualSubscriberBOImpl extends BaseBO implements IndividualSubscriberBO
{
    // private SmartBO smartBO;
    private AlertCommonLibBO alertCommonLibBO;

    private CoreCommonBO coreCommonBO;
    
    private AlertEngineBO alertEngineBO; 
    
	public void setAlertEngineBO(AlertEngineBO alertEngineBO) 
    {
		this.alertEngineBO = alertEngineBO;
	}

    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
	this.coreCommonBO = coreCommonBO;
    }

    public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    private IndividualSubscriberDAO alertIndividualSubscriberDAO;

    public IndividualSubscriberDAO getAlertIndividualSubscriberDAO()
    {
	return alertIndividualSubscriberDAO;
    }

    public void setAlertIndividualSubscriberDAO(IndividualSubscriberDAO alertIndividualSubscriberDAO)
    {
	this.alertIndividualSubscriberDAO = alertIndividualSubscriberDAO;
    }

    @Override
    public Integer indSubscriberCount(IndividualSubscriberSC indSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertIndividualSubscriberDAO.indSubscriberCount(indSubSC);
    }

    @Override
    public List<IndividualSubscriberListCO> indSubscriberList(IndividualSubscriberSC indSubSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return alertIndividualSubscriberDAO.indSubscriberList(indSubSC);
    }

    @Override
    public IndividualSubscriberCO dependencyBySubType(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
		String[] listIds = new String[] {}, listNames = new String[] {}, listIdsToHide = new String[] {},
			listNamesToHide = new String[] {};
		if(AlertConstant.TYPE_A.equals(individualSubscriberCO.getAlrtSubVO().getSUB_TYPE()))
		{
	
		    listIds = new String[] { "tbl_pathAccount_indSubAccount", "accBr", "accCy", "accGl", "accCif",
			    "lookuptxt_accSl", "accAddRef" };
		    listNames = new String[] { "individualSubscriberCO.alrtSubVO.BRANCH_CODE",
			    "individualSubscriberCO.alrtSubVO.CURRENCY_CODE", "individualSubscriberCO.alrtSubVO.GL_CODE",
			    "individualSubscriberCO.alrtSubVO.CIF_SUB_NO", "individualSubscriberCO.alrtSubVO.SL_NO",
			    "individualSubscriberCO.addRef" };
	
		    listIdsToHide = new String[] { "lookuptxt_cifNumber", "lookuptxt_userId" };
		    
		   
	
		}
		else if(AlertConstant.TYPE_C.equals(individualSubscriberCO.getAlrtSubVO().getSUB_TYPE()))
		{
		    listIds = new String[] { "lookuptxt_cifNumber" };
		    listNames = new String[] { "individualSubscriberCO.alrtSubVO.CIF_NO" };
		    listIdsToHide = new String[] { "accBr", "accCy", "accGl", "accCif", "accSl", "addRef", "lookuptxt_userId" };
	
		}
		else if(AlertConstant.TYPE_U.equals(individualSubscriberCO.getAlrtSubVO().getSUB_TYPE()))
		{
		    listIds = new String[] { "lookuptxt_userId" };
		    listNames = new String[] { "individualSubscriberCO.alrtSubVO.USR_ID" };
		    listIdsToHide = new String[] { "accBr", "accCy", "accGl", "accCif", "accSl", "addRef",
			    "lookuptxt_cifNumber" };
		}
		else if(AlertConstant.TYPE_O.equals(individualSubscriberCO.getAlrtSubVO().getSUB_TYPE()))
		{
		    listIds = new String[] { "individualSubscriberTabs" };
		    listNames = new String[] { "" };
		    listIdsToHide = new String[] { "accBr", "accCy", "accGl", "accCif", "accSl", "addRef",
			    "lookuptxt_cifNumber", "lookuptxt_userId" };
		}
	
		applyDynScreenDisplay(listIds, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(),
			individualSubscriberCO.getHm(), reqFieldSC);
		applyDynScreenDisplay(listIdsToHide, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(),
			individualSubscriberCO.getHm(), reqFieldSC);
	
		return individualSubscriberCO;

    }

    @Override
    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
	
		String[] listIds = new String[] { "accBr", "accCy", "accGl", "accCif", "accSl", "addRef", "lookuptxt_cifNumber",
			"lookuptxt_userId" };
		String[] listNames = new String[] { "individualSubscriberCO.alrtSubVO.BRANCH_CODE",
			"individualSubscriberCO.alrtSubVO.CURRENCY_CODE", "individualSubscriberCO.alrtSubVO.GL_CODE",
			"individualSubscriberCO.alrtSubVO.CIF_SUB_NO", "individualSubscriberCO.alrtSubVO.SL_NO",
			"individualSubscriberCO.addRef", "individualSubscriberCO.alrtSubVO.CIF_NO",
			"individualSubscriberCO.alrtSubVO.USR_ID" };
		if(AlertConstant.STATUS_ACTIVE.equals(individualSubscriberCO.getHiddenStatus())
			&& AlertConstant.CRUD_R.equals(individualSubscriberCO.getIvCrud()))
		{
		    applyDynScreenDisplay(new String[] { "IndividualSubscriberDeleteBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			    BigDecimal.ONE.toString(), individualSubscriberCO.getHm(), reqFieldSC);
		}
		else
		{
		    applyDynScreenDisplay(new String[] { "IndividualSubscriberDeleteBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			    BigDecimal.ZERO.toString(), individualSubscriberCO.getHm(), reqFieldSC);
		}
		if(AlertConstant.CRUD_P.equals(individualSubscriberCO.getIvCrud()))
		{
		    applyDynScreenDisplay(new String[] { "IndividualSubscriberUpdateBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			    BigDecimal.ZERO.toString(), individualSubscriberCO.getHm(), reqFieldSC);
	
		    applyDynScreenDisplay(new String[] { "subscriber_approve_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			    BigDecimal.ONE.toString(), individualSubscriberCO.getHm(), reqFieldSC);
	
		}
		else
		{
		    applyDynScreenDisplay(new String[] { "subscriber_approve_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			    BigDecimal.ZERO.toString(), individualSubscriberCO.getHm(), reqFieldSC);
		}
	
		if(AlertConstant.CRUD_F.equals(individualSubscriberCO.getIvCrud()))
		{
		    applyDynScreenDisplay(new String[] { "subscriber_type" }, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE.toString(), individualSubscriberCO.getHm(), reqFieldSC);
		}
	
		commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO,
			individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		return individualSubscriberCO.getHm();
    }

    @Override
    public IndividualSubscriberCO dependencyByCifNumber(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
	 	criteria.setCompCode(individualSubscriberCO.getCompCode());
	 	
		/**
		 * set connection object for core db
		 */
		criteria.setConnCO(AlertUtils.returnConnectionCo());
		
		IndividualSubscriberCO individualSubscriberCO2 = alertIndividualSubscriberDAO.retrieveCifDetailsList(criteria);
		if(individualSubscriberCO2 == null)
		{
		    individualSubscriberCO.getCifVO().setCIF_NO(null);
		    individualSubscriberCO.setCifType(null);
		    throw new BOException(MessageCodes.MISSING_INVALID_CIF);
		}
		else
		{
		    /**
		     * Checks if this CIF is already a Subscriber
		     */
		    IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
		    individualSubscriberSC.setCompCode(criteria.getCompCode());
		    individualSubscriberSC.setCif(criteria.getCif());
		    if(StringUtil.isEmptyString(criteria.getPageRef()))
		    {
			int cifCount = alertIndividualSubscriberDAO.returnSubscriberByCifCount(individualSubscriberSC);
			if(cifCount > 0)
			{
			    individualSubscriberCO.getCifVO().setCIF_NO(null);
			    individualSubscriberCO.setCifType(null);
			    throw new BOException(MessageCodes.CIF_ALREADY_SUBSCRIBER);
			    // "Cannot Proceed ,This CIF is Already a Subscriber"
			}
		    }
	
		    CIF_ADDRESSVO addressVO = new CIF_ADDRESSVO();
		    addressVO = alertIndividualSubscriberDAO.returnCifAddressDetails(criteria);
	
		    individualSubscriberCO.setCifVO(individualSubscriberCO2.getCifVO());
		    individualSubscriberCO.setCifType(individualSubscriberCO2.getCifType());
		    if(null != addressVO)
		    {
			individualSubscriberCO.setEmailId(addressVO.getEMAIL());
			individualSubscriberCO.setTel(addressVO.getMOBILE());
		    }
		    // f_get_memo('CIF',istr_teller ,ll_getciftext,lstr_acc)
		    individualSubscriberCO.setOpenMemo(BigDecimal.ONE);
	}

	individualSubscriberCO.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
	return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO dependencyByUserID(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {

	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());

	criteria.setCompCode(individualSubscriberCO.getCompCode());
	/**
	 * validate and retrieve user details if the user doesn't exist then
	 * show error
	 */
	IndividualSubscriberCO individualSubscriberCO2 = alertIndividualSubscriberDAO.retrieveUsrDetails(criteria);
	if(individualSubscriberCO2 != null)
	{

	    individualSubscriberCO.setUsrVO(individualSubscriberCO2.getUsrVO());
	    individualSubscriberCO.setEmailId(individualSubscriberCO2.getEmailId());
	    individualSubscriberCO.setTel(individualSubscriberCO2.getTel());

	    // Check user status
	    int usrStatusCount = alertIndividualSubscriberDAO.usrStatusCount(criteria);

	    if(usrStatusCount != 1)
	    {
		throw new BOException(MessageCodes.USER_TELLER_INACTIVE);
	    }
	    else
	    {
		/**
		 * if user dependancy call from event then no need to validate
		 * from subscriber
		 */
		if(IndividualEventConstant.EVENT_MAINT_PROG_REF.equals(individualSubscriberCO.getProgRef())
			|| IndividualEventConstant.EVENT_UPDATE_AFTER_APPROVE_PROG_REF
				.equals(individualSubscriberCO.getProgRef()))
		{
		    return individualSubscriberCO;
		}

		// Checks if this User is already a Subscriber
		criteria.setConnCO(null);
		int usrIsSubscriberCount = alertIndividualSubscriberDAO.returnSubscriberByCifCount(criteria);

		if(usrIsSubscriberCount > 0)
		{
		    throw new BOException(MessageCodes.USER_ALREADY_SUBSCRIBER);
		}
	    }
	}
	else
	{
	    throw new BOException(MessageCodes.USER_NOT_EXIST_RIGHT_CLICK_USER_SELECT);
	}

	individualSubscriberCO.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
	return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO loadCifDetails(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {

	IndividualSubscriberCO individualSubscriberCO1 = alertIndividualSubscriberDAO.retrieveCifDetailsList(criteria);
	if(individualSubscriberCO1 == null) {
		individualSubscriberCO1 = new IndividualSubscriberCO();
	}
	loadCifDetailsDisplay(individualSubscriberCO);
	individualSubscriberCO1.setHm(individualSubscriberCO.getHm());
	individualSubscriberCO1.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
	return individualSubscriberCO1;
    }

    private void loadCifDetailsDisplay(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
	
		String[] listIds = new String[] { "shortNameEng", "longNameEng", "cifType", "shortNameArab", "longNameArab",
			"ADDRESS1_ENG", "ADDRESS2_ENG", "ADDRESS3_ENG", "ADDRESS1_ARAB", "ADDRESS2_ARAB", "ADDRESS3_ARAB" };
		String[] listNames = new String[] { "individualSubscriberCO.cifVO.SHORT_NAME_ENG",
			"individualSubscriberCO.cifVO.LONG_NAME_ENG", "individualSubscriberCO.rifCttVO.BRIEF_DESC_ENG",
			"individualSubscriberCO.cifVO.SHORT_NAME_ARAB", "individualSubscriberCO.cifVO.LONG_NAME_ARAB",
			"individualSubscriberCO.cifVO.ADDRESS1_ENG", "individualSubscriberCO.cifVO.ADDRESS2_ENG",
			"individualSubscriberCO.cifVO.ADDRESS3_ENG", "individualSubscriberCO.cifVO.ADDRESS1_ARAB",
			"individualSubscriberCO.cifVO.ADDRESS2_ARAB", "individualSubscriberCO.cifVO.ADDRESS3_ARAB" };
	
		commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
			individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
		ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		ctrlVO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
		ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);
	
		if(BigDecimal.ONE.equals(ctrlVO.getCTRL_VALUE()))
		{
	
		    String[] list1Ids = new String[] { "email", "tel" };
		    String[] list1Names = new String[] { "individualSubscriberCO.emailId", "individualSubscriberCO.tel" };
	
		    commonLibBO.applyDynScreenDisplay(list1Ids, list1Names, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE, individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		}
    }

    @Override
    public IndividualSubscriberCO loadUsrDetails(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {

		IndividualSubscriberCO individualSubscriberCO1 = alertIndividualSubscriberDAO.retrieveUsrDetails(criteria);
		loadUsrDetailsDisplay(individualSubscriberCO);
		individualSubscriberCO1.setHm(individualSubscriberCO.getHm());
		individualSubscriberCO1.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
		return individualSubscriberCO1;
    }

    private void loadUsrDetailsDisplay(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
	
		String[] listIds = new String[] { "firstNameEng", "middleName", "lastName", "homePhone", "firstNameArab",
			"middleNameArab", "lastNameArab" };
		String[] listNames = new String[] { "individualSubscriberCO.usrVO.FIRST_NAME",
			"individualSubscriberCO.usrVO.MIDDLE_NAME", "individualSubscriberCO.usrVO.LAST_NAME",
			"individualSubscriberCO.usrVO.HOME_PHONE", "individualSubscriberCO.usrVO.FIRST_NAME_ARAB",
			"individualSubscriberCO.usrVO.MIDDLE_NAME_ARAB", "individualSubscriberCO.usrVO.LAST_NAME_ARAB" };
	
		commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
			individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		//ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
		//ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		//ctrlVO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
		//ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);
	
	/*	if(BigDecimal.ONE.equals(ctrlVO.getCTRL_VALUE()))
		{
	
		    String[] list1Ids = new String[] { "email", "mobile" };
		    String[] list1Names = new String[] { "individualSubscriberCO.usrVO.EMAIL",
			    "individualSubscriberCO.usrVO.MOBILE" };
	
		    commonLibBO.applyDynScreenDisplay(list1Ids, list1Names, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE, individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		}*/

    }

    @Override
    public IndividualSubscriberCO dependencyByAccSl(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {

		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getCIF_SUB_NO()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		}
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getGL_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_GENERAL_LEDGER);
		}
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getBRANCH_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_BRANCH_CODE);
		}
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getCURRENCY_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
		}
		// ll_counter_sub
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setAccBr(individualSubscriberCO.getAlrtSubVO().getBRANCH_CODE());
		criteria.setAccCy(individualSubscriberCO.getAlrtSubVO().getCURRENCY_CODE());
		criteria.setAccCif(individualSubscriberCO.getAlrtSubVO().getCIF_SUB_NO());
		criteria.setAccGl(individualSubscriberCO.getAlrtSubVO().getGL_CODE());
		criteria.setAccSl(individualSubscriberCO.getAlrtSubVO().getSL_NO());
	
		int counter = alertIndividualSubscriberDAO.amfSubscriberCount(criteria);
		if(counter > 0)
		{
		    int countSub = alertIndividualSubscriberDAO.checkIfSubscriberCount(criteria);
	
		    if(countSub != 1)
		    {
			throw new BOException(MessageCodes.ACC_ALREADY_SUBSCRIBER);
		    }
	
		    String addRef = alertIndividualSubscriberDAO.returnAddRef(criteria);
	
		    individualSubscriberCO.setAddRef(addRef);
	
		    int ret = alertIndividualSubscriberDAO.retrieveAccDetailsCount(criteria);
		    if(ret > 0)
		    {
			individualSubscriberCO.setEmail(null);
	
		    }
	
		}
		else
		{
		    throw new BOException(MessageCodes.SN_NOT_MATCH_ANY_ACC_RCLK_ACC_SELECT);
	
		}
	
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO dependencyByAccCif(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getGL_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_GENERAL_LEDGER);
		}
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getBRANCH_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_BRANCH_CODE);
		}
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO.getAlrtSubVO().getCURRENCY_CODE()))
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
		}
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setAccBr(individualSubscriberCO.getAlrtSubVO().getBRANCH_CODE());
		criteria.setAccCy(individualSubscriberCO.getAlrtSubVO().getCURRENCY_CODE());
		criteria.setAccCif(individualSubscriberCO.getAlrtSubVO().getCIF_SUB_NO());
		criteria.setAccGl(individualSubscriberCO.getAlrtSubVO().getGL_CODE());
	
		int counter = alertIndividualSubscriberDAO.amfCifSubscriberCount(criteria);
	
		if(counter == 0)
		{
		    throw new BOException(MessageCodes.ENTER_VALID_CIF_SUB_NO);
		}
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO dependencyByAccGl(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setAccGl(individualSubscriberCO.getAlrtSubVO().getGL_CODE());
		int counter = alertIndividualSubscriberDAO.genLedgerCount(criteria);
		if(counter == 0)
		{
		    throw new BOException(MessageCodes.ENTER_VALID_GENERAL_LEDGER_CODE);
		}
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO dependencyByAccCy(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setAccCy(individualSubscriberCO.getAlrtSubVO().getCURRENCY_CODE());
		int counter = alertIndividualSubscriberDAO.currencySubCount(criteria);
		if(counter == 0)
		{
		    throw new BOException(MessageCodes.ENTER_VALID_CUR_CODE);
		}
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO dependencyByAccBr(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setAccBr(individualSubscriberCO.getAlrtSubVO().getBRANCH_CODE());
		int counter = alertIndividualSubscriberDAO.branchSubCount(criteria);
		if(counter == 0)
		{
		    throw new BOException(MessageCodes.ENTER_VALIR_BR_CODE);
		}
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO loadAccDetailsForm(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
	IndividualSubscriberCO individualSubscriberCO1 = new IndividualSubscriberCO();
	// if(!NumberUtil.isEmptyDecimal(criteria.getSubID()))
	// {
	individualSubscriberCO1 = alertIndividualSubscriberDAO.retrieveAccDetails(criteria);
	individualSubscriberCO.setIsOpen(ConstantsCommon.ZERO);
	// }
	// if(number)
	loadAccDetailsDisplay(individualSubscriberCO);
	individualSubscriberCO1.setHm(individualSubscriberCO.getHm());
	individualSubscriberCO1.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
	return individualSubscriberCO1;
    }

    private void loadAccDetailsDisplay(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
		if(ConstantsCommon.ZERO.equals(individualSubscriberCO.getIsOpen()))
		{
		    String[] listIds = new String[] { "briefNameEng", "longName", "homePhone", "briefNameArab",
			    "longNameArab" };
		    String[] listNames = new String[] { "individualSubscriberCO.amfVO.BRIEF_NAME_ENG",
			    "individualSubscriberCO.amfVO.LONG_NAME_ENG", "individualSubscriberCO.amfAddressVO.HOME_TEL",
			    "individualSubscriberCO.amfVO.BRIEF_NAME_ARAB", "individualSubscriberCO.amfVO.LONG_NAME_ARAB" };
	
		    commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
			    individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		}
		// else
		// {
		ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
		ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		//ctrlVO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
		ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);
	
		if(BigDecimal.ONE.equals(ctrlVO.getCTRL_VALUE()))
		{
	
		    String[] list1Ids = new String[] { "email", "mobile" };
		    String[] list1Names = new String[] { "individualSubscriberCO.email", "individualSubscriberCO.tel" };
	
		    commonLibBO.applyDynScreenDisplay(list1Ids, list1Names, ConstantsCommon.ACTION_TYPE_READONLY,
			    BigDecimal.ONE, individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		}
		// }

    }
    

    @Override
    public IndividualSubscriberCO updateindividualSubscriber(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException
    {
	NumberUtil.resetEmptyValues(individualSubscriberCO);
	AuditRefCO refCO = individualSubscriberCO.getAuditRefCO();
	individualSubscriberCO.getAlrtSubVO().setCOMP_CODE(individualSubscriberCO.getCompCode());
	
	/**
	 * add email and mobile numbers 
	 */
	individualSubscriberCO = emailIdsAndMobilePhoneNumberFormat(individualSubscriberCO);

	// validation of Email and Mobile
	checkData(individualSubscriberCO);
	
	
	if(AlertConstant.TYPE_A.equals(individualSubscriberCO.getIsValidMobileFrom())
		|| AlertConstant.TYPE_U.equals(individualSubscriberCO.getIsValidMobileFrom())
		|| AlertConstant.TYPE_O.equals(individualSubscriberCO.getIsValidMobileFrom())
		|| AlertConstant.TYPE_C.equals(individualSubscriberCO.getIsValidMobileFrom()))
	{
	    return individualSubscriberCO;
	}
	
	individualSubscriberCO = continueUpdateAfterValidation(individualSubscriberCO);

	/**
	 * Smart Management
	 */
	SmartSC smartSC = new SmartSC();
	smartSC.setAppName(refCO.getAppName());
	smartSC.setCompCode(individualSubscriberCO.getCompCode());
	smartSC.setBranchCode(individualSubscriberCO.getBranchCode());
	smartSC.setRunningDate(refCO.getRunningDate());
	smartSC.setUserId(refCO.getUserID());
	smartSC.setProgRef(refCO.getProgRef());
	smartSC.setTrxNbr(refCO.getTrxNbr());
	smartBO.validateAndUpdateSmartDetails(individualSubscriberCO.getSmartCOList(), smartSC, refCO, individualSubscriberCO.getAlrtSubVO());

	return individualSubscriberCO;
    }

    public IndividualSubscriberCO continueUpdateAfterValidation(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException
    {
	AuditRefCO refCO = individualSubscriberCO.getAuditRefCO();
	ALRT_SUBVO newALRT_SUBVO = individualSubscriberCO.getAlrtSubVO();

	Date date = commonLibBO.addSystemTimeToDate(individualSubscriberCO.getRunningDate());
	if((null != individualSubscriberCO.getFacebookSocialId()
		&& individualSubscriberCO.getFacebookSocialId().intValue() == 0)
		|| null == individualSubscriberCO.getFacebookSocialId())
	{
	    newALRT_SUBVO.setFACEBOOK_SOCIAL_ID("");
	}
	if((null != individualSubscriberCO.getTwitterSocialId()
		&& individualSubscriberCO.getTwitterSocialId().intValue() == 0)
		|| null == individualSubscriberCO.getTwitterSocialId())
	{
	    newALRT_SUBVO.setTWITTER_SOCIAL_ID("");
	}

	if(NumberUtil.isEmptyDecimal(newALRT_SUBVO.getID()))
	{
	    newALRT_SUBVO.setCREATED_BY(individualSubscriberCO.getUserID());
	    newALRT_SUBVO.setDATE_CREATED(individualSubscriberCO.getRunningDate());

	    newALRT_SUBVO.setSTATUS(AlertConstant.STATUS_ACTIVE);

	    // prevent duplication of cif no
	    validateCif(individualSubscriberCO.getAlrtSubVO());

	    /**
	     * Checked if the suspendAllSubscription empty or null then set 0
	     * SInce it is not null in db
	     */
	    if(null == newALRT_SUBVO.getSUSPEND_ALL_SUBSCRIPTIONS()
		    || NumberUtil.isEmptyDecimal(newALRT_SUBVO.getSUSPEND_ALL_SUBSCRIPTIONS()))
		newALRT_SUBVO.setSUSPEND_ALL_SUBSCRIPTIONS(BigDecimal.ZERO);

	    // save Individual Subscriber
	    Integer mainRow = alertIndividualSubscriberDAO.saveALRT_SUBVO(newALRT_SUBVO);
	    individualSubscriberCO.setAlrtSubVO(newALRT_SUBVO);

	    if(mainRow == null || mainRow < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }
	    // refCO.setOperationType(AuditConstant.CREATED);
	    auditBO.callAudit(null, individualSubscriberCO.getAlrtSubVO(), refCO);
	}
	else
	{
	    newALRT_SUBVO.setMODIFIED_BY(individualSubscriberCO.getUserID());
	    newALRT_SUBVO.setDATE_MODIFIED(date);

	    // set old mobile number if something change in mobile no
	    ALRT_SUBVO oldAlrt_SUBVO = (ALRT_SUBVO) genericDAO.selectByPK(newALRT_SUBVO);
	    if(oldAlrt_SUBVO != null
		    && !StringUtil.nullToEmpty(oldAlrt_SUBVO.getMOBILE_PHONE()).equals(newALRT_SUBVO.getMOBILE_PHONE()))
	    {
		newALRT_SUBVO.setOLD_MOBILE_PHONE(oldAlrt_SUBVO.getMOBILE_PHONE());
	    }

	    /**
	     * set Active status while calling from update after approve screen
	     */
	    if(StringUtil.nullToEmpty(individualSubscriberCO.getProgRef())
		    .equals(IndividualSubscriberConstant.SUBSCRIBER_UPDATE_AFTER_APPROVE_PROG_REF))
	    {
		newALRT_SUBVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
	    }

	    // Update Individual Subscriber Details
	    Integer MainRowUpdate = genericDAO.update(newALRT_SUBVO);

	    if(MainRowUpdate == null || MainRowUpdate < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }

	    // prevent below fields from appearing in Audit Report Details
	    // dialog
	    newALRT_SUBVO.setDATE_UPDATED(date);

	    if(newALRT_SUBVO.getSUSPEND_ALL_SUBSCRIPTIONS() == null)
	    {
		newALRT_SUBVO.setSUSPEND_ALL_SUBSCRIPTIONS(new BigDecimal(0));
	    }
	    auditBO.callAudit(oldAlrt_SUBVO, newALRT_SUBVO, refCO);
	}

	// call other language Dialog operations insert/update/delete
	otherLanguageOperations(individualSubscriberCO);

	// call exclude accounts
	excludeAccounts(individualSubscriberCO, newALRT_SUBVO);

	auditBO.insertAudit(refCO);
	return individualSubscriberCO;
    }
    
    /**
     * Validate if Cif number already used
     * @param alrtSubVO
     * @throws BaseException
     */
    private void validateCif(ALRT_SUBVO alrtSubVO) throws BaseException {
		
    	if(alrtSubVO.getCIF_NO() != null && !alrtSubVO.getCIF_NO().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
    	{
    		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
        	individualSubscriberSC.setCif(alrtSubVO.getCIF_NO());
    		
    		int count = alertIndividualSubscriberDAO.returnSubscriberByCifCount(individualSubscriberSC);
    		if(count > 0) {
    			throw new BOException(MessageCodes.CIF_ALREADY_SUBSCRIBER);
    		}
    	}	
    }
    
    
    
    /**
     * Validate cif check it is available in CIF table or not
     * if availble then check this cif is used by another subscriber or not
     * @param individualSubscriberSC
     * @return
     * @throws BaseException
     */
    @Override
    public int validateIfCifExist(IndividualSubscriberSC individualSubscriberSC) throws BaseException
    {
	return alertIndividualSubscriberDAO.returnSubscriberByCifCount(individualSubscriberSC);
    }
    
    /**
     * validate the imal user check it is availble in usr table or not
     * If availble in usr table then check this user is used by another subscriber or not
     * @param individualSubscriberSC
     * @return
     * @throws BaseException
     */
    @Override
    public int validateIfUserExist(IndividualSubscriberSC individualSubscriberSC) throws BaseException
    {
	return alertIndividualSubscriberDAO.returnSubscriberByCifCount(individualSubscriberSC);
    }
    

    private IndividualSubscriberCO emailIdsAndMobilePhoneNumberFormat(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
	    //For Wrapper WS Deleted emails
	    if(individualSubscriberCO.getDeletedEmailIds() != null)
	    {
	    	String deletedEmails = "";
	    	String newEmails = "";
	    	for(int i=0; i<individualSubscriberCO.getDeletedEmailIds().size(); i++)
	    	{
	    		deletedEmails +=individualSubscriberCO.getDeletedEmailIds().get(i)+"<<->>";
	    	}
	    	  
	    	if(!StringUtil.isEmptyString(individualSubscriberCO.getOldEmailIds()))
	    	{
	    		String emailSplittdData[] = individualSubscriberCO.getOldEmailIds().split("<<->>");
	    		String deletedEmailSplittdData[] = deletedEmails.split("<<->>");
	    		Boolean isDeletedEmail = false;
	    		for(int i=0; i<emailSplittdData.length; i++)
	    		{
	    			isDeletedEmail = false;
	    			for(int j=0; j<deletedEmailSplittdData.length; j++)
		    		{
		    			if( emailSplittdData[i].trim().equals(deletedEmailSplittdData[j].trim()) )
		    			{
		    				isDeletedEmail = true;
		    				break;
		    			}
		    		}
	    			if(!isDeletedEmail && !emailSplittdData[i].isEmpty())
	    			{
	    				newEmails +=  emailSplittdData[i].trim()+"<<->>";
	    			}
	    		}
	    	}
	    	individualSubscriberCO.getAlrtSubVO().setEMAIL_ID(newEmails);
	    }
	    
    	//For Wrapper WS New Emails
	    if(individualSubscriberCO.getNewEmailIds() != null)
	    {
	    	String newEmails = "";
	    	for(int i=0; i<individualSubscriberCO.getNewEmailIds().size(); i++)
	    	{
	    	    if(StringUtil.isEmptyString(individualSubscriberCO.getNewEmailIds().get(i))) continue;
	    	    
	    	    newEmails +=individualSubscriberCO.getNewEmailIds().get(i)+"<<->>";
	    	}
	    	if(!StringUtil.isEmptyString(individualSubscriberCO.getAlrtSubVO().getEMAIL_ID()))
	    	{
	    		individualSubscriberCO.getAlrtSubVO().setEMAIL_ID(individualSubscriberCO.getAlrtSubVO().getEMAIL_ID()+newEmails);
	    	}
	    	else
	    	{
	    		individualSubscriberCO.getAlrtSubVO().setEMAIL_ID(newEmails);
	    	}
	    }
	    
	    //For Wrapper WS delete Mobiles
	    if(individualSubscriberCO.getDeletedMobilePhoneList() != null)
	    {
	    	  String deletedMobileNos = "";
	    	  String newMobileNo = "";
	    	  for(int i=0; i<individualSubscriberCO.getDeletedMobilePhoneList().size(); i++)
	    	  {
	    		  deletedMobileNos +=individualSubscriberCO.getDeletedMobilePhoneList().get(i)+"<<->>";
	    	  }
	    	  
	    	if(!StringUtil.isEmptyString(individualSubscriberCO.getOldMobilePhoneList()))
	    	{
	    		String mobileSplittdData[] = individualSubscriberCO.getOldMobilePhoneList().split("<<->>");
	    		String deletedMobileSplittdData[] = deletedMobileNos.split("<<->>");
	    		Boolean isDeletedMobile = false;
	    		for(int i=0; i<mobileSplittdData.length; i++)
	    		{
	    			isDeletedMobile = false;
	    			for(int j=0; j<deletedMobileSplittdData.length; j++)
		    		{
		    			if( mobileSplittdData[i].trim().equals(deletedMobileSplittdData[j].trim()) )
		    			{
		    				isDeletedMobile = true;
		    				break;
		    			}
		    		}
	    			if(!isDeletedMobile && !mobileSplittdData[i].isEmpty())
	    			{
	    				newMobileNo +=  mobileSplittdData[i].trim()+"<<->>";
	    			}
	    		}
	    	}
	    	individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(newMobileNo);
	    }
	    
	    //For Wrapper WS new Mobile Phones
	    if(individualSubscriberCO.getNewMobilePhoneList() != null)
	    {
	    	String mobilePhoneNos = "";
	    	for(int i=0; i<individualSubscriberCO.getNewMobilePhoneList().size(); i++)
	    	{
	    	    if(StringUtil.isEmptyString(individualSubscriberCO.getNewMobilePhoneList().get(i))) continue;
	    	    
	    	    mobilePhoneNos +=individualSubscriberCO.getNewMobilePhoneList().get(i)+"<<->>";
	    	}
	    	if(!StringUtil.isEmptyString(individualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE()))
	    	{
	    		individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(individualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE()+mobilePhoneNos);
	    	}
	    	else
	    	{
	    		individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(mobilePhoneNos);
	    	}
	    }
	    
	    //For Wrapper WS: check for duplicate email
	    if(!StringUtil.isEmptyString(individualSubscriberCO.getAlrtSubVO().getEMAIL_ID()))
    	{
	    	String emailSplittdData[] = individualSubscriberCO.getAlrtSubVO().getEMAIL_ID().split("<<->>");
	    	Set<String> emails = new HashSet<String>();
	    	for(int i=0; i<emailSplittdData.length; i++)
    		{
	    		if(emails.contains(emailSplittdData[i].trim())) {
	    			throw new BOException("Duplicate emails");
	    		}
	    		emails.add(emailSplittdData[i]);
    		}
    	}
	    
	    //For Wrapper WS: check for duplicate mobile
	    if(!StringUtil.isEmptyString(individualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE()))
    	{
	    	String mobileSplittdData[] = individualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE().split("<<->>");
	    	Set<String> mobiles = new HashSet<String>();
	    	for(int i=0; i<mobileSplittdData.length; i++)
    		{
	    		if(mobiles.contains(mobileSplittdData[i].trim())) {
	    			throw new BOException("Duplicate mobile");
	    		}
	    		mobiles.add(mobileSplittdData[i]);
    		}
    	}
	    
	    return individualSubscriberCO;
    }
   
    private IndividualSubscriberCO otherLanguageOperations(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
    	List addOtherLanguages = individualSubscriberCO.getNewOtherLanguageList();
    	List updateOtherLanguages = individualSubscriberCO.getUpdateOtherLanguageList();
    	List deleteOtherLanguages = individualSubscriberCO.getDeleteOtherLanguageList();
    	List allOtherLanguages = individualSubscriberCO.getOtherLanguageList();
    	
    	AuditRefCO refCO = individualSubscriberCO.getAuditRefCO();
    	
    	if(allOtherLanguages != null && allOtherLanguages.size() > 0)
    	{
    		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
    		individualSubscriberSC.setSubscriberID(individualSubscriberCO.getAlrtSubVO().getID());
    		// delete all languages
    		alertIndividualSubscriberDAO.deleteOtherLanguageDetails(individualSubscriberSC);
    		//add all language related to Alert Subscriber
    		
    		for(int i=0; i<allOtherLanguages.size(); i++)
    		{
    			ALRT_SUB_LANGVO newAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO) allOtherLanguages.get(i);
    			if(StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getLANG_CODE()) && StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getBRIEF_NAME()))
    			{
    				newAlrt_SUB_LANGVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
    				newAlrt_SUB_LANGVO.setCREATED_BY(individualSubscriberCO.getUserID());
    				newAlrt_SUB_LANGVO.setCREATED_DATE(individualSubscriberCO.getRunningDate());
        			genericDAO.insert(newAlrt_SUB_LANGVO);
    			}
    			
    		}
    	}
    	else
    	{
    		if(addOtherLanguages != null && addOtherLanguages.size() > 0)
        	{
        		for(int i=0; i<addOtherLanguages.size(); i++)
        		{
        			ALRT_SUB_LANGVO newAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO) addOtherLanguages.get(i);
        			if(newAlrt_SUB_LANGVO != null && StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getLANG_CODE()) && StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getBRIEF_NAME()))
        			{
        				IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
            			individualSubscriberSC.setSubscriberID(individualSubscriberCO.getAlrtSubVO().getID());
                		individualSubscriberSC.setIndSubLangCode(newAlrt_SUB_LANGVO.getLANG_CODE());
                		// delete all languages
                		alertIndividualSubscriberDAO.deleteOtherLanguageDetails(individualSubscriberSC);

                		newAlrt_SUB_LANGVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
                		newAlrt_SUB_LANGVO.setCREATED_BY(individualSubscriberCO.getUserID());
                		newAlrt_SUB_LANGVO.setCREATED_DATE(individualSubscriberCO.getRunningDate());
                		
                		//insert subscriber other language
            			genericDAO.insert(newAlrt_SUB_LANGVO);
            			
            			//Apply Audit
                		//refCO.setOperationType(AuditConstant.CREATED);
            			//apply insert audit
            			auditBO.callAudit(new ALRT_SUB_LANGVO(), newAlrt_SUB_LANGVO , refCO);
            		//	auditBO.insertAudit(refCO);
        			}
        		}
        	}
        	
        	if(updateOtherLanguages != null && updateOtherLanguages.size() > 0)
        	{
        		ALRT_SUB_LANGVO oldAlrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
        		for(int i=0; i<updateOtherLanguages.size(); i++)
        		{
        			ALRT_SUB_LANGVO newAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO) updateOtherLanguages.get(i);
        			if(StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getLANG_CODE()) && StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getBRIEF_NAME()))
        			{
        				newAlrt_SUB_LANGVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
        				
        				//return old object
        				oldAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO)genericDAO.selectByPK(newAlrt_SUB_LANGVO);
        				
        				/**
        				 * if old languages not exist and sent from webservices it should be return
        				 */
        				if(oldAlrt_SUB_LANGVO != null 
            					&& StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getLANG_CODE()) 
            					&& StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getBRIEF_NAME()))
            			{
        					// update subscriber other language
                			genericDAO.update(newAlrt_SUB_LANGVO);
                			
                			//apply insert audit
                			auditBO.callAudit(oldAlrt_SUB_LANGVO, newAlrt_SUB_LANGVO , refCO);
                			//auditBO.insertAudit(refCO);
        				}
        			}
        		}
        	}
        	
        	if(deleteOtherLanguages != null && deleteOtherLanguages.size() > 0) 
        	{
        		ALRT_SUB_LANGVO oldAlrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
        		IndividualSubscriberSC individualSubscriberSC = new IndividualSubscriberSC();
        		for(int i=0; i<deleteOtherLanguages.size(); i++)
        		{
        			individualSubscriberSC = new IndividualSubscriberSC();
        			ALRT_SUB_LANGVO newAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO) deleteOtherLanguages.get(i);
        			
        			newAlrt_SUB_LANGVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
        			//return old object
    				oldAlrt_SUB_LANGVO = (ALRT_SUB_LANGVO)genericDAO.selectByPK(newAlrt_SUB_LANGVO);
        			
        			if(oldAlrt_SUB_LANGVO != null 
        					&& StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getLANG_CODE()) 
        					&& StringUtil.isNotEmpty(newAlrt_SUB_LANGVO.getBRIEF_NAME()))
        			{
        				individualSubscriberSC.setSubscriberID(individualSubscriberCO.getAlrtSubVO().getID());
            			individualSubscriberSC.setIndSubLangCode(newAlrt_SUB_LANGVO.getLANG_CODE());
            			alertIndividualSubscriberDAO.deleteOtherLanguageDetails(individualSubscriberSC);
            			
            			//apply insert audit
            			auditBO.callAudit(oldAlrt_SUB_LANGVO, new ALRT_SUB_LANGVO() , refCO);
        			}
        		}
        	}
    	}
    	return individualSubscriberCO;
    }
    
    private void excludeAccounts(IndividualSubscriberCO individualSubscriberCO, ALRT_SUBVO newALRT_SUBVO) throws BaseException
    {
    	IndividualSubscriberSC criteria = new IndividualSubscriberSC();
    	criteria.setSubscriberID(individualSubscriberCO.getAlrtSubVO().getID());
		criteria.setCompCode(individualSubscriberCO.getCompCode());
		criteria.setLangCode(IndividualSubscriberConstant.LANG_CODE_EN);
		ALRT_SUB_ACC_EXCLVO newALRT_SUB_ACCOUNTSVO;
		
		// delete exluded Accounts
		alertIndividualSubscriberDAO.deleteAlertSubAccounts(criteria);
		
    	if(individualSubscriberCO.getExcludedAccountList() != null && individualSubscriberCO.getExcludedAccountList().size() > 0)
    	{
			for(int i=0; i< individualSubscriberCO.getExcludedAccountList().size(); i++)
			{
				newALRT_SUB_ACCOUNTSVO = (ALRT_SUB_ACC_EXCLVO) individualSubscriberCO.getExcludedAccountList().get(i);
				newALRT_SUB_ACCOUNTSVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
				newALRT_SUB_ACCOUNTSVO.setREL_TYPE(SubscriptionConstant.SUB_EVENT_TYPE);
				newALRT_SUB_ACCOUNTSVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
				newALRT_SUB_ACCOUNTSVO.setCREATED_BY(individualSubscriberCO.getUserID());
				newALRT_SUB_ACCOUNTSVO.setCREATED_DATE(individualSubscriberCO.getRunningDate());
				genericDAO.insert(newALRT_SUB_ACCOUNTSVO);
				
			}
    	}
    	
    	if(individualSubscriberCO.getExcludedPackageAccountList() != null && individualSubscriberCO.getExcludedPackageAccountList().size() > 0)
    	{
			for(int i=0; i< individualSubscriberCO.getExcludedPackageAccountList().size(); i++)
			{
				newALRT_SUB_ACCOUNTSVO = (ALRT_SUB_ACC_EXCLVO) individualSubscriberCO.getExcludedPackageAccountList().get(i);
				newALRT_SUB_ACCOUNTSVO.setALRT_SUB_ID(individualSubscriberCO.getAlrtSubVO().getID());
				newALRT_SUB_ACCOUNTSVO.setREL_TYPE(SubscriptionConstant.SUB_PCKG_TYPE);
				newALRT_SUB_ACCOUNTSVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
				newALRT_SUB_ACCOUNTSVO.setCREATED_BY(individualSubscriberCO.getUserID());
				newALRT_SUB_ACCOUNTSVO.setCREATED_DATE(individualSubscriberCO.getRunningDate());
				genericDAO.insert(newALRT_SUB_ACCOUNTSVO);
				
			}
    	}
    }
    
    private IndividualSubscriberCO checkData(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		String email 	= individualSubscriberCO.getAlrtSubVO().getEMAIL_ID();
		String mobile = individualSubscriberCO.getAlrtSubVO().getMOBILE_PHONE();
		
		/**
		 * There is one Contact Source required 
		 * Either email or mobile
		 */
		if(StringUtil.isEmptyString(email) && StringUtil.isEmptyString(mobile))
		    throw new BOException(MessageCodes.PLEASE_ENTER_THE_EMAIL_ADDR_OR_MOBILE_NO);
		
		
		//validate Email and Mobile
		validateMobileEmail(email, mobile, individualSubscriberCO);
		
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO validateMobileEmail(String email, String mobile,IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
    	
	if(email != null && !StringUtil.isEmptyString(email))
	{
	    String emailIds[] = email.split("<<->>");
	    for(int i = 0; i < emailIds.length; i++)
	    {
		if(!StringUtil.isNotEmpty(emailIds[i]))
		{
		    throw new BOException(MessageCodes.PLEASE_ENTER_THE_EMAIL_ADDR_OR_MOBILE_NO);
		}
		else
		{
		    int indexOfAt, indexOfDot, indexOfSpace;
		    indexOfAt = emailIds[i].indexOf("@");
		    indexOfDot = emailIds[i].indexOf(".");
		    indexOfSpace = emailIds[i].indexOf(" ");
		    if(indexOfDot <= 0 || indexOfAt <= 0)
		    {
			throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_EMAIL_ADDR);
		    }
		    else if(indexOfSpace != 0 && indexOfSpace != -1)
		    {
			throw new BOException(MessageCodes.THE_EMAIL_ADDR_CAN_NOT_CONTAIN_SPACES);

		    }
		}
	    }
	}
	if(mobile != null && !mobile.isEmpty())
	{
	    String mobileIds[] = mobile.split("<<->>");
	    StringBuilder unformated = new StringBuilder();
	    for(int i = 0; i < mobileIds.length; i++)
	    {
		//remove all special characters from mobile number
		mobileIds[i] = mobileIds[i].replaceAll("[^a-zA-Z0-9]", "");
		
		Pattern numericPattern = Pattern.compile("[0-9]*");
		Matcher matcherNumeric = numericPattern.matcher(mobileIds[i]);
		if(!matcherNumeric.matches())
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "invalid_mobile_no_key" });
		}
		//add unformatted mobile number
		unformated.append(mobileIds[i]).append("<<->>");
	    }
	    individualSubscriberCO.getAlrtSubVO().setMOBILE_PHONE(unformated.toString());
	}
	return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO loadDataFromDb(IndividualSubscriberCO individualSubscriberCO, IndividualSubscriberSC criteria) throws BaseException
    {

		/*ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
		ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		ctrlVO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
		ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);*/
		criteria.setLovType(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
		criteria.setLangCode(individualSubscriberCO.getLanguage());
		//criteria.setCentralized(ctrlVO.getCTRL_VALUE());
		criteria.setIndSubLangCode(IndividualSubscriberConstant.LANG_CODE_EN);
		//return data from db 
		individualSubscriberCO = alertIndividualSubscriberDAO.loadDataFromDb(criteria);
		
		//set emails and mobiles of subsciber
	    if(individualSubscriberCO != null && individualSubscriberCO.getAlrtSubVO() != null)
	    {
	    	ALRT_SUBVO alrt_SUBVO = individualSubscriberCO.getAlrtSubVO();
	    	String emails[] = null;
	    	String mobileNos[] = null;
	    	if(null != alrt_SUBVO.getEMAIL_ID())
	    	{
	    		emails = alrt_SUBVO.getEMAIL_ID().split("<<->>");
	    	}
	    	if(null != alrt_SUBVO.getMOBILE_PHONE())
	    	{
	    		mobileNos = alrt_SUBVO.getMOBILE_PHONE().split("<<->>"); 
	    	}
	    	if(null != emails)
	    	{
		    	individualSubscriberCO.setEmailsCount(new BigDecimal(emails.length));
	    	}
	    	if(null != mobileNos)
	    	{
	    		individualSubscriberCO.setMobileNosCount(new BigDecimal(mobileNos.length));
	    	}
	    	if(alrt_SUBVO.getFACEBOOK_SOCIAL_ID() != null && !alrt_SUBVO.getFACEBOOK_SOCIAL_ID().equals(""))
	    	{
	    		individualSubscriberCO.setFacebookSocialId(new BigDecimal(1));
	    	}
	    	else
	    	{
	    		individualSubscriberCO.setFacebookSocialId(new BigDecimal(0));
	    	}
	    	
	    	if(alrt_SUBVO.getTWITTER_SOCIAL_ID() != null && !alrt_SUBVO.getTWITTER_SOCIAL_ID().equals(""))
	    	{
	    		individualSubscriberCO.setTwitterSocialId(new BigDecimal(1));
	    	}
	    	else
	    	{
	    		individualSubscriberCO.setTwitterSocialId(new BigDecimal(0));
	    	}
	    }
		return individualSubscriberCO;
    }

    @Override
    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> detailsEditOption(
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
	
		String[] listIds = new String[] { "email" };
		String[] listNames = new String[] { "individualSubscriberCO.emailId" };// ,
	
		commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
			individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
	
		return individualSubscriberCO.getHm();
    }

    @Override
    public IndividualSubscriberCO deleteIndSubscriber(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException
    {
		IndividualSubscriberSC sc = new IndividualSubscriberSC();
		sc.setSubID(individualSubscriberCO.getAlrtSubVO().getID());
		int count = alertIndividualSubscriberDAO.relatedSubscriptionsCount(sc);
		if(count > 0)
		{
		    throw new BOException(MessageCodes.THIS_SUBSCRIBER_HAS_SUBSCRIPTIONS_DELETE_THEN_RETRY);
	
		}
		individualSubscriberCO.getAlrtSubVO().setSTATUS(AlertConstant.STATUS_DELETED);
		individualSubscriberCO.getAlrtSubVO().setDELETED_BY(individualSubscriberCO.getUserID());
		individualSubscriberCO.getAlrtSubVO().setDATE_DELETED(individualSubscriberCO.getRunningDate());
	
		NumberUtil.resetEmptyValues(individualSubscriberCO.getAlrtSubVO());
	
		genericDAO.update(individualSubscriberCO.getAlrtSubVO());
	
		/*IndividualSubscriberCO oldIndividualSubscriberCO = (IndividualSubscriberCO) individualSubscriberCO
			.getAuditObj();
		auditBO.callAudit(oldIndividualSubscriberCO.getAlrtSubVO(), individualSubscriberCO.getAlrtSubVO(),
			individualSubscriberCO.getAuditRefCO());
	
		auditBO.insertAudit(individualSubscriberCO.getAuditRefCO());*/
	
		return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO loadRelatedForm(IndividualSubscriberCO individualSubscriberCO,
	    IndividualSubscriberSC criteria) throws BaseException
    {

		IndividualSubscriberCO individualSubscriberCO1 = alertIndividualSubscriberDAO.loadRelatedForm(criteria);
		// loadCifDetailsDisplay(individualSubscriberCO);
		// individualSubscriberCO1.setHm(individualSubscriberCO.getHm());
		if(NumberUtil.isEmptyDecimal(individualSubscriberCO1.getAlrtSubDetVO().getID()))
		{
		    individualSubscriberCO1.getAlrtSubVO().setLANG(AlertConstant.DEFAULT);
		}
		else
		{
		    individualSubscriberCO1.setHiddenEMAIL_ID(individualSubscriberCO1.getAlrtSubDetVO().getEMAIL_ID());
		    individualSubscriberCO1
			    .setHiddenOLD_MOBILE_PHONE(individualSubscriberCO1.getAlrtSubDetVO().getMOBILE_PHONE());
		}
		individualSubscriberCO.getAlrtSubVO().setSTATUS(individualSubscriberCO1.getAlrtSubVO().getSTATUS());
		loadOthersDetailsDisplay(individualSubscriberCO);
		individualSubscriberCO1.setHm(individualSubscriberCO.getHm());
		return individualSubscriberCO1;
    }

    private void loadOthersDetailsDisplay(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualSubscriberCO.getCompCode());
		reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(individualSubscriberCO.getAppName(),
			individualSubscriberCO.getProgRef()));
		reqFieldSC.setAppName(individualSubscriberCO.getAppName());
		reqFieldSC.setBranchCode(individualSubscriberCO.getBranchCode());
		if(AlertConstant.CRUD_P.equals(individualSubscriberCO.getIvCrud())
			|| (AlertConstant.CRUD_R.equals(individualSubscriberCO.getIvCrud())
				&& AlertConstant.STATUS_APPROVED.equals(individualSubscriberCO.getAlrtSubVO().getSTATUS())))
		{
		    String[] listIds = new String[] { "shortNameEng", "longNameEng", "shortNameArab", "longNameArab",
			    "telNumber1", "telNumber2", "ADDRESS1_ENG", "ADDRESS2_ENG", "ADDRESS3_ENG", "ADDRESS1_ARAB",
			    "ADDRESS2_ARAB", "ADDRESS3_ARAB", "email", "tel" };
		    String[] listNames = new String[] { "individualSubscriberCO.alrtSubDetVO.SHORT_NAME_ENG",
			    "individualSubscriberCO.alrtSubDetVO.LONG_NAME_ENG",
			    "individualSubscriberCO.alrtSubDetVO.SHORT_NAME_ARAB",
			    "individualSubscriberCO.alrtSubDetVO.LONG_NAME_ARAB",
			    "individualSubscriberCO.alrtSubDetVO.TEL1_NUM", "individualSubscriberCO.alrtSubDetVO.TEL2_NUM",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS1_ENG",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS2_ENG",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS3_ENG",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS1_ARAB",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS2_ARAB",
			    "individualSubscriberCO.alrtSubDetVO.ADDRESS3_ARAB", "individualSubscriberCO.alrtSubDetVO.EMAIL_ID",
			    "individualSubscriberCO.alrtSubDetVO.MOBILE_PHONE" };
	
		    commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
			    individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
		}
		/*
		 * ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
		 * ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		 * ctrlVO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE); ctrlVO =
		 * (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);
		 * 
		 * if(BigDecimal.ONE.equals(ctrlVO.getCTRL_VALUE())) {
		 * 
		 * String[] list1Ids = new String[] { "email", "tel" }; String[]
		 * list1Names = new String[] {
		 * "individualSubscriberCO.alrtSubDetVO.EMAIL_ID",
		 * "individualSubscriberCO.alrtSubDetVO.MOBILE_PHONE" };
		 * 
		 * commonLibBO.applyDynScreenDisplay(list1Ids, list1Names,
		 * ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE,
		 * individualSubscriberCO.getHm(), reqFieldSC, Boolean.TRUE);
		 * 
		 * }
		 */

    }

    @Override
    public IndividualSubscriberCO approveIndSubscriber(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException
    {

		individualSubscriberCO.getAlrtSubVO().setSTATUS(AlertConstant.STATUS_APPROVED);
		individualSubscriberCO.getAlrtSubVO().setAUTHORIZED_BY(individualSubscriberCO.getUserID());
		individualSubscriberCO.getAlrtSubVO().setDATE_AUTHORIZED(individualSubscriberCO.getRunningDate());
		IndividualSubscriberSC sc = new IndividualSubscriberSC();
		sc.setSubID(individualSubscriberCO.getAlrtSubVO().getID());
		sc = alertIndividualSubscriberDAO.selectMobileDetails(sc);
		individualSubscriberCO = continueToApprove(individualSubscriberCO);
		return individualSubscriberCO;
    }

    /**
     * send Alert Notification once the data has changed in Individual subscriber screen
     * @param alrt_SUBVO
     * @param alrt_CONTROLVO
     * @throws BaseException
     */
    @Override
    public Boolean sendAlertNotification(ALRT_SUBVO alrt_SUBVO) throws BaseException
    {    	
    	
    	boolean result = false;
    	
    	ALRT_CONTROLVO  alrt_CONTROLVO = new ALRT_CONTROLVO();
    	alrt_CONTROLVO.setCTRL_REFERENCE(AlertConstant.MOBILE_FLAG);
    	alrt_CONTROLVO = (ALRT_CONTROLVO) genericDAO.selectByPK(alrt_CONTROLVO);
		
    	//If Activation service flag, 1 = Yes and Notified = 0
    	if(alrt_CONTROLVO !=null && BigDecimal.ONE.equals(alrt_CONTROLVO.getCTRL_VALUE()))
    	{
    		ALRT_CONTROLVO controlvo = new ALRT_CONTROLVO();
    		if(AlertConstant.MOBILE_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
    		{
    			controlvo.setCTRL_REFERENCE(AlertConstant.MOBILE_EVT);
    		}
    		
    		//return old ALRT_SUBVO object
    		ALRT_SUBVO oldAlrt_SUBVO = (ALRT_SUBVO) genericDAO.selectByPK(alrt_SUBVO);
    		
    		if(StringUtil.isNotEmpty(oldAlrt_SUBVO.getOLD_MOBILE_PHONE()) && !oldAlrt_SUBVO.getOLD_MOBILE_PHONE().equals(oldAlrt_SUBVO.getMOBILE_PHONE()))
    		{
    			/*Load the Event ID As Proceeding event*/
    			controlvo = (ALRT_CONTROLVO) genericDAO.selectByPK(controlvo);
    			BigDecimal eventId = controlvo.getCTRL_VALUE();
    			
    			ArrayList<BigDecimal> subscriberIdsList = new ArrayList<>();
    			subscriberIdsList.add(alrt_SUBVO.getID());
    			
    			AlertNotificationCO alertNotificationCO = new AlertNotificationCO();
    			alertNotificationCO.setSubscriberIdsList(subscriberIdsList);
    			alertNotificationCO.setEventId(eventId);
    			try 
    			{
    				result = alertEngineBO.sendMessage(alertNotificationCO);
    				return true;
    			} catch (Exception e) 
    			{
    				log.error("Error in continueToSendAlertNotification method inside SubscriberBoImpl "+e.getMessage());
    			}
    		}
    	}
    	return result;
    }
    
    private IndividualSubscriberCO checkSubFunc(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {

	ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
	ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
	ctrlVO.setCTRL_REFERENCE(AlertConstant.MOBILE_FLAG);
	ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);

	if(BigDecimal.ONE.equals(ctrlVO.getCTRL_VALUE()))
	{

	    ALRT_CONTROLVO ctrl1VO = new ALRT_CONTROLVO();
	    ctrl1VO.setCOMP_CODE(individualSubscriberCO.getCompCode());
	    ctrl1VO.setCTRL_REFERENCE(AlertConstant.MOBILE_EVT);
	    ctrl1VO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrl1VO);

	    IndividualSubscriberSC sc = new IndividualSubscriberSC();
	    sc.setEvtID(ctrl1VO.getCTRL_VALUE());
	    ALRT_EVTVO evtVo = alertIndividualSubscriberDAO.selectEvtParameters(sc);

	    if(null == evtVo)
	    {
		individualSubscriberCO.setRaiseApproveConfirmation(BigDecimal.ONE);
		return individualSubscriberCO;
	    }
	    else
	    {
		/*ALRT_CONTROLVO ctrl2VO = new ALRT_CONTROLVO();
		ctrl2VO.setCOMP_CODE(individualSubscriberCO.getCompCode());
		ctrl2VO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
		ctrl2VO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrl2VO);*/
		ALRT_SUBVO subVo = new ALRT_SUBVO();
		sc.setSubID(individualSubscriberCO.getAlrtSubVO().getID());
		/*if(BigDecimal.ONE.equals(ctrl2VO.getCTRL_VALUE()))
		{

		    subVo = alertIndividualSubscriberDAO.selectCentralizedDetails(sc);

		}
		else
		{*/

		    subVo = new ALRT_SUBVO();
		    subVo.setCOMP_CODE(individualSubscriberCO.getCompCode());
		    subVo.setID(sc.getSubID());
		    subVo = (ALRT_SUBVO) genericDAO.selectByPK(subVo);

		//}

		if(AlertConstant.DEFAULT.equals(subVo.getLANG()))
		{
		    subVo.setLANG(AlertConstant.ENGLISH);
		    if((AlertConstant.TYPE_A.equals(subVo.getSUB_TYPE())
			    && BigDecimal.ZERO.compareTo(subVo.getCIF_SUB_NO()) != 0)
			    || (AlertConstant.TYPE_C.equals(subVo.getSUB_TYPE())))
		    {
			sc.setSubType(subVo.getSUB_TYPE());
			sc.setSubCif(subVo.getCIF_SUB_NO());
			sc.setCif(subVo.getCIF_NO());
			sc.setCompCode(subVo.getCOMP_CODE());
			subVo.setLANG(alertIndividualSubscriberDAO.selectCifLanguage(sc));

		    }
		    else if(AlertConstant.TYPE_U.equals(subVo.getSUB_TYPE()))
		    {
			sc.setUserId(subVo.getUSR_ID());
			subVo.setLANG(alertIndividualSubscriberDAO.selectUsrLanguage(sc));
		    }

		}
		if(AlertConstant.ARABIC.equals(subVo.getLANG()))
		{

		    evtVo.setMESSAGE_SUBJECT_ENG(evtVo.getMESSAGE_SUBJECT_ARAB());
		    evtVo.setMESSAGE_TEXT_ENG(evtVo.getMESSAGE_TEXT_ARAB());
		}
		AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
		alertCommonLibSC.setEngMsg(evtVo.getMESSAGE_TEXT_ENG());
		// alertCommonLibSC.setEngMsg("<ACC_BRIEF_NAME_AR>");
		alertCommonLibSC.setSubID(individualSubscriberCO.getAlrtSubVO().getID());
		alertCommonLibSC.setEvt(ctrl1VO.getCTRL_VALUE());
		// ll_return = f_parce_msg(ls_msg_eng, ad_sub_id, ll_evt)
		alertCommonLibSC = alertCommonLibBO.parseAlertMessage(alertCommonLibSC);
		// alertCommonLibSC.setEngMsg("r4edfsgyh");
		if(null != alertCommonLibSC.getEngMsg() && !alertCommonLibSC.getEngMsg().isEmpty())
		{

		    ALRT_QUEUEVO queueVo = new ALRT_QUEUEVO();

		    queueVo.setMESSAGE_SUBJECT_ENG(evtVo.getMESSAGE_SUBJECT_ENG());
		    queueVo.setMESSAGE_TEXT_ENG(alertCommonLibSC.getEngMsg());
		    queueVo.setALRT_DATE(individualSubscriberCO.getRunningDate());
		    queueVo.setSTOP_AFTER(BigDecimal.ZERO);
		    queueVo.setMOBILE_PHONE(subVo.getMOBILE_PHONE());
		    queueVo.setEMAIL_ID(subVo.getEMAIL_ID());
		    queueVo.setEVT_MODE(evtVo.getEVT_MODE());
		    queueVo.setEVT_ID(evtVo.getEVT_ID());
		    queueVo.setMSG_LANG(subVo.getLANG());// (subVo.getID());
		    queueVo.setSUB_ID(subVo.getID());
		    alertCommonLibSC.setTrxType("ALRT_QUEUE");
		    if(!("B").equals(evtVo.getEVT_MODE()))
		    {
			if(!(evtVo.getEVT_MODE().equals("E")
				&& (subVo.getEMAIL_ID() == null || subVo.getEMAIL_ID().isEmpty()))
				&& !(evtVo.getEVT_MODE().equals("S")
					&& (null == subVo.getMOBILE_PHONE() || subVo.getMOBILE_PHONE().isEmpty())))
			{

			    alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
			    queueVo.setID(alertCommonLibSC.getAlrtCount());

			    int ii = genericDAO.insert(queueVo);
			    if(ii < 0)
			    {
				individualSubscriberCO.setErrorInsertQueue(BigDecimal.ONE);
				return individualSubscriberCO;
			    }

			}
		    }
		    else
		    {
			if(null != subVo.getEMAIL_ID() && !subVo.getEMAIL_ID().isEmpty())
			{
			    alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
			    queueVo.setID(alertCommonLibSC.getAlrtCount());
			    queueVo.setEVT_MODE("E");

			    int i = genericDAO.insert(queueVo);

			    if(i < 0)
			    {
				individualSubscriberCO.setErrorInsertQueue(BigDecimal.ONE);
				return individualSubscriberCO;
			    }
			}

			if(null != subVo.getMOBILE_PHONE() && !subVo.getMOBILE_PHONE().isEmpty())
			{
			    alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
			    queueVo.setID(alertCommonLibSC.getAlrtCount());
			    queueVo.setEVT_MODE("S");

			    int i = genericDAO.insert(queueVo);
			    if(i < 0)
			    {
				individualSubscriberCO.setErrorInsertQueue(BigDecimal.ONE);
				return individualSubscriberCO;
			    }
			}
		    }
		}
	    }

	}

	continueToApprove(individualSubscriberCO);
	return individualSubscriberCO;
    }

    @Override
    public IndividualSubscriberCO continueToApprove(IndividualSubscriberCO individualSubscriberCO) throws BaseException
    {
		// TODO Auto-generated method stub
	
		individualSubscriberCO.getAlrtSubVO().setSTATUS(AlertConstant.STATUS_APPROVED);
		individualSubscriberCO.getAlrtSubVO().setAUTHORIZED_BY(individualSubscriberCO.getUserID());
		individualSubscriberCO.getAlrtSubVO().setDATE_AUTHORIZED(individualSubscriberCO.getRunningDate());
		NumberUtil.resetEmptyValues(individualSubscriberCO.getAlrtSubVO());
		
		ALRT_SUBVO alrtSubVO =individualSubscriberCO.getAlrtSubVO();
		alrtSubVO.setSTATUS(AlertConstant.STATUS_APPROVED);
		/**
		 * Approve record
		 */
		Integer row = genericDAO.update(alrtSubVO);
		if(row < 0)
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_APPROVING_SUBSCRIBER);
		}	
		if(row == null || row < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		individualSubscriberCO.setAlrtSubVO(alrtSubVO);
		
		IndividualSubscriberCO oldIndividualSubscriberCO = (IndividualSubscriberCO) individualSubscriberCO
			.getAuditObj();
		auditBO.callAudit(oldIndividualSubscriberCO.getAlrtSubVO(), individualSubscriberCO.getAlrtSubVO(),
			individualSubscriberCO.getAuditRefCO());
	
		auditBO.insertAudit(individualSubscriberCO.getAuditRefCO());
	
		return individualSubscriberCO;
    }

    public int cifLookupQueryListCount(CifSC criteria) throws BaseException
    {
    	/**
		 * set connection object for core db
		 */
    	criteria.setConnCO(AlertUtils.returnConnectionCo());
    	
		cifLkpParamPreparation(criteria);
		return alertIndividualSubscriberDAO.cifLookupQueryListCount(criteria);
    }

    public List cifLookupQueryList(CifSC criteria) throws BaseException
    {
    	/**
    	 * set connection object for core db
    	 */
    	criteria.setConnCO(AlertUtils.returnConnectionCo());
    	
    	cifLkpParamPreparation(criteria);
    	return alertIndividualSubscriberDAO.cifLookupQueryList(criteria);
    }

    private void cifLkpParamPreparation(CifSC criteria) throws BaseException
    {
		BigDecimal forbidAccount = new BigDecimal(TrxMgntConstant.FORBID_ACCOUNT);
		BigDecimal forbidCash = new BigDecimal(TrxMgntConstant.FORBID_CASH);

	/**
	 * @author marwanmaddah: In case transaction type not null ...
	 */
	if(!NumberUtil.isEmptyDecimal(criteria.getTrxType())
		&& "true".equals(StringUtil.nullToEmpty(criteria.getBanksLkp())))
	{
	    CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
	    ctstrxtypeVO.setCOMP_CODE(criteria.getComp_code());
	    ctstrxtypeVO.setCODE(criteria.getTrxType());
	    ctstrxtypeVO.setSTATUS(TrxMgntConstant.STATUS_APPROVE);
	    ctstrxtypeVO = coreCommonBO.findTrxType(ctstrxtypeVO);

	    /**
	     * @author marwanmaddah: Corr Bank LookUp management
	     */
	    if("true".equals(StringUtil.nullToEmpty(criteria.getCorrBankLkp())))
	    {
			if("0".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSHOW_ALL_BANK_CIF())))
			{
			    if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
				    && (forbidAccount.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))
					    || forbidCash.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
			    {
				criteria.setLookupCorrBank("true");
			    }
			    else
			    {
				criteria.setLookupBankCif("true");
			    }
			}
			else
			{
			    criteria.setLookupBankCif("true");
			}
		    }
		    /**
		     * @author marwanmaddah: Bank Cif Lookup in transaction screen ...
		     */
		    if("true".equals(StringUtil.nullToEmpty(criteria.getBankCifLkp())))
		    {
			if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
				&& "1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getUTILITY_PAYMENT())))
			{
			    criteria.setLookupCorrBank("true");
			}
			else
			{
			    criteria.setClearingHouse(ctstrxtypeVO.getCLEARING_HOUSE());
			    criteria.setLookupBankCifAib("true");
			}
		    }
	
		    /**
		     * @author marwanmaddah: benef Bank lookup in transaction screen ...
		     */
		    if("true".equals(StringUtil.nullToEmpty(criteria.getBenefBankLkp())))
		    {
				if((TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
					&& (forbidAccount.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))
						|| forbidCash.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
					|| "1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())))
				{
				    if("1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())))
				    {
					if(!TrxMgntConstant.SEND_SWIFT.equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSEND_SWIFT())))
					{
					    criteria.setLookupBankCif("true");
					}
				    }
				    else
				    {
					criteria.setTrxType(null);
					criteria.setCurrencyCode(null);
				    }
				    if(!"1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())) || ("1"
					    .equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF()))
					    && TrxMgntConstant.SEND_SWIFT.equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSEND_SWIFT()))))
				    {
					criteria.setLookupCorrBank("true");
				    }
				}
				else
				{
				    criteria.setLookupBankCif("true");
				}
		    }
	
		    /**
		     * @author marwanmaddah: intermediary bank lookup in non financial
		     *         information section in transaction screen ...
		     */
		    if("true".equals(StringUtil.nullToEmpty(criteria.getIntermBankLkp())))
		    {
			if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
				&& (forbidAccount.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))
					|| forbidCash.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
			{
			    criteria.setTrxType(null);
			    criteria.setCurrencyCode(null);
			    criteria.setLookupCorrBank("true");
			}
			else
			{
			    criteria.setLookupBankCif("true");
			}
		    }
		}
    }

    @Override
    public Integer accountListCount(CifSC criteria) throws BaseException
    {
    	return alertIndividualSubscriberDAO.accountListCount(criteria);
    }

    @Override
    public List accountList(CifSC criteria) throws BaseException
    {
    	return alertIndividualSubscriberDAO.accountList(criteria);
    }

    @Override
    public Integer getUserLookupCount(UsrSC usrSC) throws BaseException
    {
    	/**
		 * set connection object for core db
		 */
    	usrSC.setConnCO(AlertUtils.returnConnectionCo());
    	
    	return alertIndividualSubscriberDAO.getUserLookupCount(usrSC);
    }

    @Override
    public List getUserLookupList(UsrSC usrSC) throws BaseException
    {
    	/**
		 * set connection object for core db
		 */
    	usrSC.setConnCO(AlertUtils.returnConnectionCo());
    	
    	return alertIndividualSubscriberDAO.getUserLookupList(usrSC);
    }

	@Override
	public List<ALRT_SUB_LANGVO> returnIndividualSubscriberOtherLanguageList(IndividualSubscriberSC criteria) throws BaseException 
	{
		return alertIndividualSubscriberDAO.returnIndividualSubscriberOtherLanguageList(criteria);
	}

	@Override
	public Integer returnIndividualSubscriberOtherLanguageListCount(IndividualSubscriberSC criteria) throws BaseException 
	{
		return alertIndividualSubscriberDAO.returnIndividualSubscriberOtherLanguageListCount(criteria);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<OmniUserCO> returnOmniUserList(IndividualSubscriberSC criteria)  throws Exception
	{
			String serviceRmi = IndividualSubscriberConstant.returnOmniApplicationRmi();
			ButtonCustomizationRmiCallerBO rmiCallerBO = (ButtonCustomizationRmiCallerBO ) RmiServiceCaller.returnRmiInterface(serviceRmi, 
					ButtonCustomizationRmiCallerBO.class, "buttonCustomizationRmiCallerBOService");
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			Map<String, Object> rmiObjectInputParamMap = fillObjInputParam(criteria);
			Map<String, Object> map = rmiCallerBO.executeBoMethod("omniUserBO", "returnOmniUserListRec", rmiObjectInputParamMap);
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) map.get("omniUsers");
			List<OmniUserCO> omniUserCOs = new ArrayList<OmniUserCO>();
			for(HashMap<String, Object> hashMap : result)
			{
				OmniUserCO omniUserCO = (OmniUserCO) PathPropertyUtil.convertToObject(hashMap, OmniUserCO.class);
				omniUserCOs.add(omniUserCO);
			}
			return omniUserCOs;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public Integer returnOmniUserListCount(IndividualSubscriberSC criteria)  throws Exception
	{
		String serviceRmi = IndividualSubscriberConstant.returnOmniApplicationRmi();
		ButtonCustomizationRmiCallerBO rmiCallerBO = (ButtonCustomizationRmiCallerBO ) RmiServiceCaller.returnRmiInterface(serviceRmi, 
			ButtonCustomizationRmiCallerBO.class, "buttonCustomizationRmiCallerBOService");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, Object> rmiObjectInputParamMap = fillObjInputParam(criteria);
		//sortOrder whereQuery searchFilter _search
		Map<String, Object> map = rmiCallerBO.executeBoMethod("omniUserBO", "returnOmniUserListCount", rmiObjectInputParamMap);
		Integer omniChannelUserCount = (Integer) map.get("omniUsersCount");
		return omniChannelUserCount;
	}
	
	private Map<String, Object> fillObjInputParam(IndividualSubscriberSC criteria)
	{
		Map<String, Object> rmiObjectInputParamMap = new HashMap<String, Object>();
		rmiObjectInputParamMap.put("ocApplication", IndividualSubscriberConstant.OC_APPLICATION);
		rmiObjectInputParamMap.put("compCode", criteria.getCompCode());
		rmiObjectInputParamMap.put("language", criteria.getPreferredLanguage());
		rmiObjectInputParamMap.put("nbRec", criteria.getNbRec());
		rmiObjectInputParamMap.put("searchField", criteria.getSearchField());
		rmiObjectInputParamMap.put("searchOpr", criteria.getSearchOper());
		rmiObjectInputParamMap.put("searchString", criteria.getSearchString());
		rmiObjectInputParamMap.put("recToskip", criteria.getRecToskip());
		rmiObjectInputParamMap.put("srchMapFldsOnly", criteria.getSrchMapFldsOnly());
		rmiObjectInputParamMap.put("sortOrder", criteria.getSortOrder());
		rmiObjectInputParamMap.put("whereQuery", criteria.getWhereQuery());
		rmiObjectInputParamMap.put("searchFilter", criteria.getSearchFilter());
		rmiObjectInputParamMap.put("_search", criteria.get_search());
		rmiObjectInputParamMap.put("sord", criteria.getSord());
		rmiObjectInputParamMap.put("colSearchQuery", criteria.getColSearchQuery());
		return rmiObjectInputParamMap;
	}

	@Override
	public List returnIndividualSubscriberMultipleAccountsList(IndividualSubscriberSC criteria) throws BaseException {
		List individualSubscriberCOs = alertIndividualSubscriberDAO.returnIndividualSubscriberMultipleAccountsList(criteria);
		return individualSubscriberCOs;
	}

	@Override
	public List returnExcludedAccountsList(IndividualSubscriberSC criteria,  CifSC cifCriteria) throws BaseException {
		List<AMFVO> excludedAmfvos = alertIndividualSubscriberDAO.returnIndividualSubscriberMultipleAccountsList(criteria);
		List<AMFVO> accountList = alertIndividualSubscriberDAO.accountList(cifCriteria);
		List<AMFVO> amfvos = new ArrayList<AMFVO>();
		AMFVO amfvo = new AMFVO();

		if(accountList != null && accountList.size() > 0)
		{
			Boolean isExist = false;
			for(int i=0; i<accountList.size(); i++)
			{
				AMFVO newAmfvo = accountList.get(i);
				//add all account of individual subscription
				if(excludedAmfvos != null && excludedAmfvos.size() > 0)
				{
					isExist = false;
					//insert into ALRT_EVT_OL_DATA_TRANS
					Iterator<AMFVO>  iterator = excludedAmfvos.iterator();
					
					while(iterator.hasNext())
					{
						amfvo = iterator.next();
						if(amfvo.getBRANCH_CODE().equals(newAmfvo.getBRANCH_CODE()) && amfvo.getCIF_SUB_NO().equals(newAmfvo.getCIF_SUB_NO())
								&& amfvo.getGL_CODE().equals(newAmfvo.getGL_CODE()) && amfvo.getSL_NO().equals(newAmfvo.getSL_NO()))
						{
							isExist = true;
							break;
							
						}
					}
				}
				if(!isExist) 
				{
					amfvos.add(newAmfvo);
				}
			}
		}
		return amfvos;
	}

}