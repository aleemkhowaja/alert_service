package com.path.alert.bo.subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.alert.vo.subscription.SubscriptionCO;
import com.path.alert.vo.subscription.SubscriptionSC;
import com.path.alert.vo.subscription.SubscriptionWsCO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;

public interface SubscriptionBO
{
    List<SubscriptionCO> loadGroupsGrid(SubscriptionSC sc) throws BaseException;

    Integer groupsCount(SubscriptionSC sc) throws BaseException;

    List<SubscriptionCO> loadPackageGrid(SubscriptionSC sc) throws BaseException;

    Integer packageCount(SubscriptionSC sc) throws BaseException;

    List<SubscriptionCO> loadSubscribersGrid(SubscriptionSC sc) throws BaseException;

    Integer subscribersCount(SubscriptionSC sc) throws BaseException;

    List<SubscriptionCO> loadEventsGrid(SubscriptionSC sc) throws BaseException;

    Integer eventsCount(SubscriptionSC sc) throws BaseException;

    SubscriptionCO viewStatusDetail(SubscriptionSC sc) throws BaseException;

    List<SubscriptionCO> loadSubscriptionDetailsGrid(SubscriptionSC sc) throws BaseException;

    Integer subscriptionDetailsCount(SubscriptionSC sc) throws BaseException;

    List<SubscriptionCO> loadEventsParamsGrid(SubscriptionSC sc) throws BaseException;

    SubscriptionCO hideFromValueFields(SubscriptionSC sc) throws BaseException;

    SubscriptionCO returnAllSelectedRow(SubscriptionSC sc) throws BaseException;

    SubscriptionCO populateSubscription(SubscriptionSC sc, SubscriptionCO subscriptionCO, String selSerialNoSG, String selSerialNoEP)
	    throws BaseException;

    Integer subscriberEvtCount(SubscriptionSC subscriptionSC) throws BaseException;

    List subscriberEvtList(SubscriptionSC subscriptionSC) throws BaseException;
    
    Integer subscriberAllEvtCount(SubscriptionSC subscriptionSC) throws BaseException;
    
    List subscriberAllEvtList(SubscriptionSC subscriptionSC) throws BaseException;

    void deletePopulatedFromTmp() throws BaseException;

    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(SubscriptionCO subscriptionCO)
	    throws BaseException;

    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> afterPopulateVisibility(SubscriptionCO subscriptionCO)
	    throws BaseException;

    SubscriptionCO returnAllSelectedRowDet(SubscriptionSC sc) throws BaseException;

    SubscriptionCO deleteSubscription(SubscriptionCO subscriptionCO) throws BaseException;

    SubscriptionCO updateSubDetailsParams(SubscriptionCO subscriptionCO, ArrayList<SubscriptionCO> toBeUpdatedParamList)
	    throws BaseException;

    SubscriptionCO saveSubscription(SubscriptionCO subscriptionCO,ArrayList lstMod) throws BaseException;

    SubscriptionCO approveSubscription(SubscriptionCO subscriptionCO) throws BaseException;

    SubscriptionCO continueToApprove(SubscriptionCO subscriptionCO) throws BaseException;

    SubscriptionCO toBeDeletedSubscription(SubscriptionCO subscriptionCO) throws BaseException;


    void checkIfFixedEvtParamExist(SubscriptionSC subscriptionSC) throws BaseException;
    
    void updateExcludeTable(ArrayList<SubscriptionCO> subscriptionCOlst) throws BaseException;
    
    SubscriptionCO checkEventModeFlags(SubscriptionCO subscriptionCO) throws BaseException;

    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> afterUpdateVisibility(SubscriptionCO subscriptionCO)
	    throws BaseException;

    /**
	 * Method used to return Subscription Details by id
	 * @param criteria
	 * Search Criteria Parameter
	 * @return SubscriptionCO Result
	 * @throws BaseException
	 */
    SubscriptionCO returnSubscriptionDetailsById(SubscriptionSC sc) throws BaseException;
    
    /**
     * return Communication Type Cnt
     * @param criteria
     * @return
     * @throws BaseException
     */
    int returnCommunicationTypeCnt(SubscriptionSC  criteria) throws BaseException;
    
    /**
     * return Communication Type List
     * @param criteria
     * @return
     * @throws BaseException
     */
    List<SubscriptionCO> returnCommunicationTypeList(SubscriptionSC  criteria) throws BaseException;
    
    /**
     * update After Approve Subscription
     * @param lstMod
     * @return
     * @throws BaseException
     */
    SubscriptionCO updateAfterApproveSubscription(SubscriptionCO subscriptionCO,ArrayList lstMod) throws BaseException;
    
    /**
     * to Be Suspend Subscription
     * @param subscriptionCO
     * @return
     * @throws BaseException
     */
    SubscriptionCO toBeSuspendSubscription(SubscriptionCO subscriptionCO) throws BaseException;
    
    /**
     * suspend Subscription
     * @param subscriptionCO
     * @return
     * @throws BaseException
     */
    SubscriptionCO suspendSubscription(SubscriptionCO subscriptionCO) throws BaseException;
    
    /**
     * to Be Reactivate Subscription
     * @param subscriptionCO
     * @return
     * @throws BaseException
     */
    SubscriptionCO toBeReactivateSubscription(SubscriptionCO subscriptionCO) throws BaseException;
    
    /**
     *reactivate Subscription
     * @param subscriptionCO
     * @return
     * @throws BaseException
     */
    SubscriptionCO reactivateSubscription(SubscriptionCO subscriptionCO) throws BaseException;
    
    /**
     * retrieve Subscriber Event WS List
     * @param sc
     * @return
     * @throws BaseException
     */
    public List<SubscriptionCO> retrieveSubEvtWSList(SubscriptionSC sc) throws 	BaseException;
    
    /**
     *Update Subscription in Temp table
     * @param subscriptionCO
     * @return
     * @throws BaseException
     */
    SubscriptionCO updateTempSubscription(SubscriptionCO subscriptionCO) throws BaseException;
    
    /**
     * return Subscription Count for web services
     * @param sc
     * @return
     * @throws DAOException
     */
    public Integer returnSubscriptionWsCount(SubscriptionSC sc) throws BaseException;

    /**
     * return Subscription List for web services
     * @param sc
     * @return
     * @throws DAOException
     */
    public List<SubscriptionWsCO> returnSubscriptionWsList(SubscriptionSC sc) throws BaseException;
}
