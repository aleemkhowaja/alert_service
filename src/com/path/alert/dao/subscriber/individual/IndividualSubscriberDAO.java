package com.path.alert.dao.subscriber.individual;

import java.util.List;

import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberListCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.core.cif.CifSC;

public interface IndividualSubscriberDAO
{

    public int cifLookupQueryListCount(CifSC criteria) throws DAOException;

    public List cifLookupQueryList(CifSC criteria) throws DAOException;

    Integer indSubscriberCount(IndividualSubscriberSC indSubSC) throws DAOException;

    List<IndividualSubscriberListCO> indSubscriberList(IndividualSubscriberSC indSubSC) throws DAOException;

    int returnCifCount(IndividualSubscriberSC criteria) throws DAOException;

    int retrieveCifDetailsCount(IndividualSubscriberSC criteria) throws DAOException;

    IndividualSubscriberCO retrieveCifDetailsList(IndividualSubscriberSC criteria) throws DAOException;

    CIF_ADDRESSVO returnCifAddressDetails(IndividualSubscriberSC indSubSC) throws DAOException;

    int cifIsSubscriberCount(IndividualSubscriberSC criteria) throws DAOException;

    int returnUsrCount(IndividualSubscriberSC criteria) throws DAOException;

    int retrieveUsrDetailsCount(IndividualSubscriberSC criteria) throws DAOException;

    IndividualSubscriberCO retrieveUsrDetails(IndividualSubscriberSC criteria) throws DAOException;

    int usrStatusCount(IndividualSubscriberSC criteria) throws DAOException;

    int usrIsSubscriberCount(IndividualSubscriberSC criteria) throws DAOException;

    int amfSubscriberCount(IndividualSubscriberSC criteria) throws DAOException;

    int checkIfSubscriberCount(IndividualSubscriberSC criteria) throws DAOException;

    String returnAddRef(IndividualSubscriberSC criteria) throws DAOException;

    int retrieveAccDetailsCount(IndividualSubscriberSC criteria) throws DAOException;

    IndividualSubscriberCO retrieveAccDetails(IndividualSubscriberSC criteria) throws DAOException;

    int amfCifSubscriberCount(IndividualSubscriberSC criteria) throws DAOException;

    int genLedgerCount(IndividualSubscriberSC criteria) throws DAOException;

    int currencySubCount(IndividualSubscriberSC criteria) throws DAOException;

    int branchSubCount(IndividualSubscriberSC criteria) throws DAOException;

    IndividualSubscriberCO loadDataFromDb(IndividualSubscriberSC criteria) throws DAOException;

    int relatedSubscriptionsCount(IndividualSubscriberSC sc) throws DAOException;

    IndividualSubscriberCO loadRelatedForm(IndividualSubscriberSC criteria) throws DAOException;

    IndividualSubscriberSC selectMobileDetails(IndividualSubscriberSC sc) throws DAOException;

    ALRT_EVTVO selectEvtParameters(IndividualSubscriberSC sc) throws DAOException;

    ALRT_SUBVO selectCentralizedDetails(IndividualSubscriberSC sc) throws DAOException;

    String selectCifLanguage(IndividualSubscriberSC sc) throws DAOException;

    String selectUsrLanguage(IndividualSubscriberSC sc) throws DAOException;

    public Integer accountListCount(CifSC criteria) throws DAOException;

    public List accountList(CifSC criteria) throws DAOException;

    public Integer getUserLookupCount(UsrSC usrSC) throws DAOException;

    public List<IndividualSubscriberListCO> getUserLookupList(UsrSC usrSC) throws DAOException;
    
    
    /**
     * returnIndividualSubscriberOtherLanguageListGrid
     * @param criteria
     * @return
     * @throws DAOException
     */
	public List<ALRT_SUB_LANGVO> returnIndividualSubscriberOtherLanguageList(IndividualSubscriberSC criteria) throws DAOException;
	
	/**
	 * returnIndividualSubscriberOtherLanguageListCount
	 * @param criteria
	 * @return
	 * @throws DAOException
	 */
	public Integer returnIndividualSubscriberOtherLanguageListCount(IndividualSubscriberSC criteria) throws DAOException;
	  
	/**
	 * deleteOtherLanguageDetails
	 * @param sc
	 * @throws DAOException
	 */
    public void deleteOtherLanguageDetails(IndividualSubscriberSC sc) throws DAOException;
    
    /**
     * delete Alert subscripction multiple accounts
     * @param sc
     * @throws DAOException
     */
    public void deleteAlertSubAccounts(IndividualSubscriberSC sc) throws DAOException;
    
    /**
    * returnIndividualSubscriberMultipleAccountListGrid
    * @param criteria
    * @return
    * @throws DAOException
    */
	public List returnIndividualSubscriberMultipleAccountsList(IndividualSubscriberSC criteria) throws DAOException;
	
	/**
	 * @param individualSubscriberSC
	 * @return
	 * @throws DAOException
	 */
    public Integer returnSubscriberByCifCount(IndividualSubscriberSC individualSubscriberSC) throws DAOException;
    
    /**
     * 
     * @param alrt_SUBVO
     * @return
     * @throws DAOException
     */
    public Integer saveALRT_SUBVO(ALRT_SUBVO alrt_SUBVO) throws DAOException;

}
