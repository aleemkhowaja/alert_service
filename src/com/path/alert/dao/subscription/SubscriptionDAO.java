package com.path.alert.dao.subscription;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.alert.vo.subscription.SubscriptionCO;
import com.path.alert.vo.subscription.SubscriptionSC;
import com.path.alert.vo.subscription.SubscriptionWsCO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_GRPVOKey;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.DAOException;

public interface SubscriptionDAO {
	List<SubscriptionCO> loadGroupsGrid(SubscriptionSC sc) throws DAOException;

	Integer groupsCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadPackageGrid(SubscriptionSC sc) throws DAOException;

	Integer packageCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadSubscribersGrid(SubscriptionSC sc) throws DAOException;

	Integer subscribersCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadEventsGrid(SubscriptionSC sc) throws DAOException;

	Integer eventsCount(SubscriptionSC sc) throws DAOException;

	SubscriptionCO viewStatusDetail(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadSubscriptionDetailsGrid(SubscriptionSC sc) throws DAOException;

	Integer subscriptionDetailsCount(SubscriptionSC sc) throws DAOException;

	BigDecimal selectFixedEventId(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadFixedEvtParamsSet(SubscriptionSC sc) throws DAOException;

	Integer fixedEvtParamCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadEventParams(SubscriptionSC sc) throws DAOException;

	Integer eventParamsCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadSubEvtParam(SubscriptionSC sc) throws DAOException;

	void deleteSubEvtParam(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadFixedParamsList(SubscriptionSC sc) throws DAOException;

	ArrayList<LinkedHashMap> subscriberData(SubscriptionSC sc) throws DAOException;

	ArrayList<LinkedHashMap> eventData(SubscriptionSC sc) throws DAOException;

	ArrayList<LinkedHashMap> groupsData(SubscriptionSC sc) throws DAOException;

	ArrayList<LinkedHashMap> packagesData(SubscriptionSC sc) throws DAOException;

	Integer updateExistingSubEvt(SubscriptionCO subscriptionCO) throws DAOException;

	Integer updateExistingSubPckg(SubscriptionCO co) throws DAOException;

	Integer updateExistingEvtGrp(SubscriptionCO co) throws DAOException;

	Integer updateExistingGrpPckg(SubscriptionCO co) throws DAOException;

	Integer subscriberEvtCount(SubscriptionSC sc) throws DAOException;	
	
	List subscriberEvtList(SubscriptionSC sc) throws DAOException;

	Integer subscriberAllEvtCount(SubscriptionSC sc) throws DAOException;

	List subscriberAllEvtList(SubscriptionSC sc) throws DAOException;

	void deletePopulatedFromTmp() throws DAOException;

	List<SubscriptionCO> subscribersListSelected(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> groupsListSelected(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadSelectedEventsGrid(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> loadSelectedPckgGrid(SubscriptionSC sc) throws DAOException;

	ArrayList<LinkedHashMap> subEvtData(SubscriptionSC sc) throws DAOException;

	void deleteSubEvtTmp() throws DAOException;

	void deleteSubEvtTmpByID(SubscriptionSC sc) throws DAOException;
	
	void deleteExcludedModesListByID(SubscriptionSC sc) throws DAOException;

	void updateSubEvt(ALRT_SUB_EVTVO subEvtVo) throws DAOException;

	int returnSubEvtCount(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> subscriberEvtListAll(SubscriptionSC sc) throws DAOException;

	void removeSubEvt(SubscriptionSC sc) throws DAOException;

	void removeSubPkg(SubscriptionSC sc) throws DAOException;

	int returnSubPkgCount(SubscriptionSC sc) throws DAOException;

	List<ALRT_EVT_PKGVOKey> returnEvtPkgList(SubscriptionSC sc) throws DAOException;

	void updateSubPkg(SubscriptionSC sc) throws DAOException;

	void updateSubEvtStatus(SubscriptionSC sc) throws DAOException;

	void updateEvtGrpStatus(SubscriptionSC sc) throws DAOException;

	void updateEvtGrp(SubscriptionSC sc) throws DAOException;

	void updateAlrtCounter(SubscriptionSC sc) throws DAOException;

	int returnEvtGrpCount(SubscriptionSC sc) throws DAOException;

	List<ALRT_SUB_GRPVOKey> returnSubGrpList(SubscriptionSC sc) throws DAOException;

	void updateGrpPkg(SubscriptionSC sc) throws DAOException;

	void updateGrpPkgStatus(SubscriptionSC sc) throws DAOException;

	int returnGrpPkgCount(SubscriptionSC sc) throws DAOException;

	BigDecimal returnNotified(BigDecimal sub_ID) throws DAOException;

	int returnIfFirstApproved(BigDecimal sub_ID) throws DAOException;

	ALRT_EVTVO selectEvtDetails(BigDecimal ctrl_VALUE) throws DAOException;

	// ALRT_SUBVO selectSubDetails(BigDecimal ctrl_VALUE) throws DAOException;

	String selectCifLanguage(ALRT_SUBVO subVo) throws DAOException;

	String selectUsrLanguage(USRVO usrVO) throws DAOException;

	Integer updateAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void updateAlrtSubParam(ALRT_SUBSCRIPTION_PARAMVO subParamVO) throws DAOException;

	List<SubscriptionCO> subscriberEvtListSelected(SubscriptionSC subscriptionSC) throws DAOException;

	void updateAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void updateAlrtSubParamSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void approveAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException;

	List<ALRT_SUB_GRPVOKey> returnAlrtGrp(SubscriptionSC subscriptionSC) throws DAOException;

	void updateAlrtSubEvtEG(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void approveAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException;

	void approveAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

	void deleteAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void deleteAlrtSubParam(ALRT_SUBSCRIPTION_PARAMVO subParamVO) throws DAOException;

	void deleteAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void deleteAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException;

	void deleteAlrtSubParamSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void delteAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException;

	void deleteAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

	void rejectAlrtSubEvt(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void rejectAlrtSubEvtSP(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

	void rejectAlrtSubPkg(ALRT_SUB_PKGVO subPkgVO) throws DAOException;

	void rejectAlrtEvtGrp(ALRT_EVT_GRPVO evtGrpVO) throws DAOException;

	void rejectAlrtGrpPkg(ALRT_GRP_PKGVO alrtGrpPkgVO) throws DAOException;

	List<SubscriptionCO> returnSubEvtList(SubscriptionCO co) throws DAOException;

	BigDecimal returnRelID(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> retrieveSubEvtList(SubscriptionSC sc) throws DAOException;

	List<SubscriptionCO> returnSubPkgList(SubscriptionCO subscriptionCO) throws DAOException;

	List<SubscriptionCO> returnEvtGrpList(SubscriptionCO subscriptionCO) throws DAOException;

	List<SubscriptionCO> returngrpPkgList(SubscriptionCO subscriptionCO) throws DAOException;

	BigDecimal returnSPRelID(SubscriptionSC sc) throws DAOException;

	BigDecimal returnEGRelID(SubscriptionSC sc) throws DAOException;

	BigDecimal returnGPRelID(SubscriptionSC sc) throws DAOException;

	List<ALRT_SUBSCRIPTION_PARAMVO> returnAlrtSubParam(SubscriptionSC sc) throws DAOException;

	void deleteSubscriptions(SubscriptionSC sc) throws DAOException;
	
	SubscriptionCO checkEventModeFlags(SubscriptionCO subscriptionCO) throws DAOException;

	/**
	 * Method used to return Subscription Details by id
	 * @param criteria
	 * Search Criteria Parameter
	 * @return SubscriptionCO Result
	 * @throws DAOException
	 */
    SubscriptionCO returnSubscriptionDetailsById(SubscriptionSC sc) throws DAOException;
    
    /**
     * return Details For Subscriber
     * @param sc
     * @return
     * @throws DAOException
     */
    SubscriptionCO returnDetailsForSubscriber(SubscriptionSC sc) throws DAOException;
    
    /**
     * return Communication Type Cnt
     * @param criteria
     * @return
     * @throws DAOException
     */
    int returnCommunicationTypeCnt(SubscriptionSC  criteria) throws DAOException;
    
    /**
     * return Communication Type List
     * @param criteria
     * @return
     * @throws DAOException
     */
    List<SubscriptionCO> returnCommunicationTypeList(SubscriptionSC  criteria) throws DAOException;
    
    /**
     * return subEvnt for WS
     * @param sc
     * @return
     * @throws DAOException
     */
    public List<SubscriptionCO> retrieveSubEvtWSList(SubscriptionSC sc) throws DAOException;
    
    /**
     * Methods used to get Subscriber ID and Send Notification
     * @param sc
     * @return List
     * @throws DAOException
     */
    public List<SubscriptionCO> retSubscriberLineNo(SubscriptionSC sc) throws DAOException;
    
    /**
     * Methods used to get Subscriber Details for maker checker
     * @param sc
     * @return List
     * @throws DAOException
     */
    public List<SubscriptionCO> returnEvtSubDetails(SubscriptionSC sc) throws DAOException;
    
    
    /**
     * Methods used to Update Subscriptions available in Package-Event, Group-Package and Group-Event
     * @param SubscriptionCO
     * @return Integer
     * @throws DAOException
     */
    public Integer updateSubscriptionsStatus(SubscriptionCO subscriptionCO) throws DAOException;
    
    /**
     * @author Alim
     * method to be delete sub event
     * @param subscriptionSC
     * @return
     * @throws DAOException
     */
    public Integer toBeDeletedSubEvents(SubscriptionSC subscriptionSC) throws DAOException;
    
    /**
     * @author Alim
     * method to be deleted subscription
     * @param subscriptionSC
     * @return
     * @throws DAOException
     */
    public Integer toBeDeletedSubscription(SubscriptionSC subscriptionSC) throws DAOException;
    
    /**
     * 
     * @param subscriptionSC
     * @return
     * @throws DAOException
     */
    public Integer updateStatusSubscription(SubscriptionSC subscriptionSC) throws DAOException;
    
    /**
     * return Subscription Count for web services
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer returnSubscriptionWsCount(SubscriptionSC sc) throws DAOException;

    /**
     * return Subscription List for web services
     * @param sc
     * @return
     * @throws DAOException
     */
    public List<SubscriptionWsCO> returnSubscriptionWsList(SubscriptionSC sc) throws DAOException;
    
    
    /**
     * Save selected Sub - Evt in temp table
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer saveALRT_SUB_EVT_TMP(SubscriptionSC sc) throws DAOException;
    
    /**
     * save all sub-evt in temp table by calling proc
     * P_ALRT_SUB_EVT_TMP_ENHANCE
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer saveBulkINALRT_SUB_EVT_TEMP(SubscriptionSC sc) throws DAOException;
    
    /**
     * Save bulk in ALRT_SUB_EVT table
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer saveBulkINALRT_SUB_EVT(SubscriptionSC sc) throws DAOException;
    
    /**
     * truncate ALRT SUB EVT temp table
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer truncateTableALRT_SUB_EVT_TMP(SubscriptionSC sc) throws DAOException;
    
    /**
     * Approve sub alrt sub event subscription
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer approveBulkALRT_SUB_EVT(SubscriptionSC sc) throws DAOException;
    
    /**
     * update Alrt Subscriber Event
     * @param sub_EVTVO
     * @return
     * @throws DAOException
     */
    public Integer updateALRT_SUB_EVT(ALRT_SUB_EVTVO sub_EVTVO) throws DAOException;

    /**
     * Commit all transaction before truncate
     * @return
     * @throws DAOException
     */
    public Integer commitTransBeforeTruncate() throws DAOException;
}
