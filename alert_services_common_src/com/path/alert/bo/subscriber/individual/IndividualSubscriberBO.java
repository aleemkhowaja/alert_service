package com.path.alert.bo.subscriber.individual;

import java.util.List;
import java.util.Map;

import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberListCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.core.cif.CifSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface IndividualSubscriberBO
{

    Integer indSubscriberCount(IndividualSubscriberSC indSubSC) throws BaseException;

    List<IndividualSubscriberListCO> indSubscriberList(IndividualSubscriberSC indSubSC) throws BaseException;

    IndividualSubscriberCO dependencyBySubType(IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByCifNumber(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO loadCifDetails(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByUserID(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO loadUsrDetails(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByAccSl(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO loadAccDetailsForm(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByAccCif(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByAccGl(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByAccCy(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO dependencyByAccBr(IndividualSubscriberSC criteria,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO updateindividualSubscriber(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException;

    IndividualSubscriberCO continueUpdateAfterValidation(IndividualSubscriberCO individualSubscriberCO)
	    throws BaseException;

    IndividualSubscriberCO loadDataFromDb(IndividualSubscriberCO individualSubscriberCO,
	    IndividualSubscriberSC criteria) throws BaseException;

    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> detailsEditOption(
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO deleteIndSubscriber(IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO loadRelatedForm(IndividualSubscriberCO individualSubscriberCO,
	    IndividualSubscriberSC criteria) throws BaseException;

    IndividualSubscriberCO approveIndSubscriber(IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    IndividualSubscriberCO continueToApprove(IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    public int cifLookupQueryListCount(CifSC criteria) throws BaseException;

    public List cifLookupQueryList(CifSC criteria) throws BaseException;

    Integer accountListCount(CifSC criteria) throws BaseException;

    List accountList(CifSC criteria) throws BaseException;

    Integer getUserLookupCount(UsrSC usrSC) throws BaseException;

    List<UsrCO> getUserLookupList(UsrSC usrSC) throws BaseException;
    
    public List<ALRT_SUB_LANGVO> returnIndividualSubscriberOtherLanguageList(IndividualSubscriberSC criteria) throws BaseException;
    
    public Integer returnIndividualSubscriberOtherLanguageListCount(IndividualSubscriberSC criteria) throws BaseException ;

    public List returnOmniUserList(IndividualSubscriberSC criteria) throws Exception;
    
    public Integer returnOmniUserListCount(IndividualSubscriberSC criteria) throws Exception;
       
    public List returnIndividualSubscriberMultipleAccountsList(IndividualSubscriberSC criteria) throws BaseException;
    
    
    public List returnExcludedAccountsList(IndividualSubscriberSC criteria,  CifSC cifCriteria) throws BaseException;
    
    public Boolean sendAlertNotification(ALRT_SUBVO alrt_SUBVO) throws BaseException;
    
    /**
     * Validate cid check it is available in CIF table or not
     * @param individualSubscriberSC
     * @return
     * @throws BaseException
     */
    public int validateIfCifExist(IndividualSubscriberSC individualSubscriberSC) throws BaseException;

    /**
     * 
     * @param email
     * @param mobile
     * @param individualSubscriberCO
     * @return
     * @throws BaseException
     */
    public IndividualSubscriberCO validateMobileEmail(String email, String mobile,
	    IndividualSubscriberCO individualSubscriberCO) throws BaseException;

    /**
     * Validate the given user to check if it is available in user table or not
     * If the user is available in user table then check this user is used by another subscriber or not
     * @param individualSubscriberSC
     * @return
     * @throws BaseException
     */
    public int validateIfUserExist(IndividualSubscriberSC individualSubscriberSC) throws BaseException;
    
}
