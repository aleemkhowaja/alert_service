package com.path.alert.dao.events.event;

import java.util.ArrayList;
import java.util.List;

import com.path.alert.vo.events.event.AlrtTagsCO;
import com.path.alert.vo.events.event.IndFixedParamListCO;
import com.path.alert.vo.events.event.IndividualEventCO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.alert.vo.events.event.IndividualFixedEventListCO;
import com.path.alert.vo.events.event.IndividualMemoListCO;
import com.path.alert.vo.events.event.IndividualReportIdEventCO;
import com.path.alert.vo.service.AlertServiceSC;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_BATCH_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_INTRNLVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODE_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_TAGS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.select.SelectCO;

public interface IndividualEventDAO
{

    Integer indEventCount(IndividualEventSC indEventSC) throws DAOException;

    List<IndividualEventListCO> indEventList(IndividualEventSC indEventSC) throws DAOException;

    Integer returnevtsubCount(IndividualEventSC indEventSC) throws DAOException;

    Integer evtsubCount(IndividualEventSC indEventSC) throws DAOException;

    Integer fixedEventCount(IndividualEventSC indEventSC) throws DAOException;

    Integer reportEventCount(IndividualEventSC indEventSC) throws DAOException;

    Integer returnfixedIdCount(IndividualEventSC indEventSC) throws DAOException;

    Integer returnmemoIdCount(IndividualEventSC indEventSC) throws DAOException;

    Integer returnreportIdCount(IndividualEventSC indEventSC) throws DAOException;

    List<IndividualFixedEventListCO> fixedEventList(IndividualEventSC indEventSC) throws DAOException;
    
    List<SelectCO> fixedEventListSelectCO(IndividualEventSC indEventSC) throws DAOException;

    // Mohamad Hojeij 03/04/2017
    List<IndividualReportIdEventCO> reportEventList(IndividualEventSC indEventSC) throws DAOException;

    Integer memoCount(IndividualEventSC indEventSC) throws DAOException;

    List<IndividualMemoListCO> memoList(IndividualEventSC indEventSC) throws DAOException;

    Integer indParamCount(IndividualEventSC indEventSC) throws DAOException;

    List<IndFixedParamListCO> indParamList(IndividualEventSC indEventSC) throws DAOException;

    List<AlrtTagsCO> alrttagList(IndividualEventSC indEventSC) throws DAOException;

    Integer indTagsCount(IndividualEventSC indEventSC) throws DAOException;

    String fixedEventDescription(IndividualEventSC indEventSC) throws DAOException;

    String reportEventDesc(IndividualEventSC indEventSC) throws DAOException;

    String fixedEventDescriptionMemo(IndividualEventSC indEventSC) throws DAOException;

    String fixedEventDescriptionReport(IndividualEventSC indEventSC) throws DAOException;

    String returnTagName(IndividualEventSC indEventSC) throws DAOException;

    void updatesubscriptions(IndividualEventCO individualEventCO) throws DAOException;


    List<IndFixedParamListCO> retrieveFixedParam(IndividualEventSC indEventSC) throws DAOException;

    IndFixedParamListCO RetrievefixedEvent(IndividualEventSC indEventSC) throws DAOException;

    int relatedSubCount(IndividualEventSC indEventSC) throws DAOException;

    List<ALRT_EVT_GRPVO> returnEventByGrpId(IndividualEventCO individualEventCO) throws DAOException;

    void deleteSbtParam(IndividualEventCO individualEventCO) throws DAOException;

    void updateSubEvt(IndividualEventCO individualEventCO) throws DAOException;

    void updateGrpEvt(IndividualEventCO individualEventCO) throws DAOException;

    List<ALRT_EVT_PKGVOKey> returnEventByPkgId(IndividualEventCO individualEventCO) throws DAOException;

    void deleteSubParam(IndividualEventCO individualEventCO) throws DAOException;

    void deleteSubEvt(IndividualEventCO individualEventCO) throws DAOException;

    void deleteSubEvtSE(IndividualEventCO individualEventCO) throws DAOException;

    void deleteEvtPkg(IndividualEventCO individualEventCO) throws DAOException;

    List<String> returnEventReportColumns(IndividualEventCO individualEventCO) throws DAOException;

    /*
     * int returnCifCount(IndividualSubscriberSC criteria) throws DAOException;
     * 
     * int retrieveCifDetailsCount(IndividualSubscriberSC criteria) throws
     * DAOException;
     * 
     * List<IndividualSubscriberListCO>
     * retrieveCifDetailsList(IndividualSubscriberSC criteria) throws
     * DAOException;
     * 
     * IndividualSubscriberSC returnCifAddressDetails(IndividualSubscriberSC
     * indSubSC) throws DAOException;
     * 
     * int cifIsSubscriberCount(IndividualSubscriberSC criteria) throws
     * DAOException;
     */
   //Raed Saad - User Story #592675 Get Alert Events - 14.1
	public List<IndividualEventListCO> getAlertEvents(AlertServiceSC alertServiceSC) throws BaseException;
	
	/**
	 * delete All Other Languages
	 * @param individualEventCO
	 * @throws DAOException
	 */
	public void deleteAllOtherLang(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * load Other Lang ListGrid
	 * @param individualEventCO
	 * @return
	 * @throws DAOException
	 */
	public List<IndividualEventCO> loadOtherLangListGrid(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * load Other Lang Body ListGrid
	 * @param individualEventCO
	 * @return
	 * @throws DAOException
	 */
	public List<IndividualEventCO> loadOtherLangBodyListGrid(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * delete All Event ParamSet
	 * @param individualEventCO
	 * @throws DAOException
	 */
	public void deleteAllEventParamSet(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * return Event List Count
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public int returnEventModeListCount(IndividualEventSC sc) throws DAOException;
	
	/**
	 * return Event List
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public List<SYS_PARAM_LOV_TRANSVO> returnEventModeList(IndividualEventSC sc) throws DAOException;
	
	/**
	 * load Assigned Mode ListGrid
	 * @param individualEventCO
	 * @return
	 * @throws BaseException
	 */
	public List<SYS_PARAM_LOV_TRANSVO> loadAssignedModeListGrid(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * delete AlertEventOmni Mode
	 * @param individualEventCO
	 * @throws DAOException
	 */
	public void deleteRelatedAlertEventOmniMode(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * return Event Service List 
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public List individualEventServiceList(IndividualEventSC sc) throws DAOException;
	
	/**
	 * email Template Count
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public Integer emailTemplateCount(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 * email Template List
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public List<IndividualFixedEventListCO> emailTemplateList(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 * dependency By Email TemplateId
	 * @param individualEventCO
	 * @return
	 * @throws BaseException
	 */
	public IndividualEventCO dependencyByEmailTemplateId(IndividualEventCO individualEventCO) throws DAOException;
	
	/**
	 * return Report List
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 *//*
	public List<IndividualReportIdEventCO> returnReportList(IndividualEventSC indEventSC) throws DAOException;
	
	*//**
	 * return report list count
	 * @param sc
	 * @return
	 * @throws DAOException
	 *//*
	public int returnReportListCount(IndividualEventSC sc) throws DAOException;
	
	*//**
	 * return all queries
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 *//*
	public List<IndividualReportIdEventCO> returnQueryList(IndividualEventSC indEventSC) throws DAOException;
	
	*//**
	 * return queries count
	 * @param sc
	 * @return
	 * @throws DAOException
	 *//*
	public int returnQueryListCount(IndividualEventSC sc) throws DAOException;
	 
	*//**
	 * return alert query arguments list by query id
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 *//*
	public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> returnQueryArgumentListByQueryId(IndividualEventSC indEventSC) throws DAOException;
	
	*//**
	 * return alert query arguments count by query id
	 * @param sc
	 * @return
	 * @throws DAOException
	 *//*
	public int returnQueryArgumentListByQueryIdCount(IndividualEventSC sc) throws DAOException;
	
	
	*//**
	 * return arguments list by report id
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 *//*
    public List<IndividualEventCO> returnArgumentListByReportId(IndividualEventSC indEventSC) throws DAOException;
    
    *//**
     * return arguments count by report id
     * @param sc
     * @return
     * @throws DAOException
     *//*
	public int returnArgumentListByReportIdCount(IndividualEventSC sc) throws DAOException;
	
	*//**
	 * return Alert Tags List
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 *//*
	public ArrayList<AlrtTagsCO> returnAlertTagList(IndividualEventSC indEventSC) throws DAOException;*/
	
	/**
	 * return Individual Event List For Grid
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public List<IndividualEventListCO> returnIndividualEventListForGrid(IndividualEventSC indEventSC) throws DAOException;
	 
	/**
	 * return Individual Event Count For Grid
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public Integer returnIndividualEventCountForGrid(IndividualEventSC indEventSC) throws DAOException;
	 
	/**
	 * return Event CO By Event Id 
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public IndividualEventCO returnIndividualEventByEventId(IndividualEventSC indEventSC) throws DAOException;	
	
	/**
	 * 
	 * @param alrt_TAGS_DEFVO
	 * @return
	 */
	public Integer saveAlrtTagsDef(ALRT_TAGS_DEFVO alrt_TAGS_DEFVO) throws DAOException;
	
	/**
	 * return customn/default tag list
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public ArrayList<ALRT_TAGS_DEFVO> returnIndEventCustomDefaultTagList(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 *  return customn/default tag count
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public int returnIndEventCustomDefaultTagListCount(IndividualEventSC sc) throws DAOException;
	
	/**
	 * Delete all mmaping arguments
	 * @param sc
	 * @throws DAOException
	 */
	public void deleteAlrtEventCommModeArgMap(IndividualEventSC sc) throws DAOException;
	
	/**
	 * check duplicate Event Desction
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public Integer returnCheckIsUniqueEventDescription(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 * delete All Batch Arg Map
	 * @param sc
	 * @throws DAOException
	 */
	public void deleteAllBatchArgMap(IndividualEventSC sc) throws DAOException;
	
	/**
	 * return Alrt Evt Batch Arg Map
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public List<ALRT_EVT_BATCH_ARG_MAPVO> returnAlrtEvtBatchArg(IndividualEventSC sc) throws DAOException;
	
	/**
	 * return Alert Tags Select
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public Integer returnAlertTagsSelectCount(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 * return Alert Tags Select
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public List<AlrtTagsCO> returnAlertTagsSelect(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 * return Attach repport mapping argument
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> returnAttachReportMappingArgument(IndividualEventSC sc) throws DAOException;
	
	/**
	 * 
	 * @param alrt_TAGS_DEFVO
	 * @return
	 */
	public Integer saveCommunicationModeMappingArguments(ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO) throws DAOException;
	
	/**
	 * 
	 * @param usrCO
	 * @return
	 * @throws DAOException
	 */
	public List<UsrCO> returnIndividualEventUsrReportsListForEvent(IndividualEventSC sc) throws DAOException;

	/**
	 * return Events list for Specific Package
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public List<IndividualEventListCO> returnIndividualEventListForPackageList(IndividualEventSC indEventSC) throws DAOException;
	
	/**
	 *  return Events count for Specific Package
	 * @param sc
	 * @return
	 * @throws DAOException
	 */
	public Integer returnIndividualEventListForPackageCount(IndividualEventSC sc) throws DAOException;
	
	/**
	 * save Alert Event
	 * @param alrt_EVTVO
	 * @return
	 * @throws DAOException
	 */
	public Integer saveALRT_EVT(ALRT_EVTVO alrt_EVTVO) throws DAOException;
	
	
	/**
	 * return List of Internal alert in event
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public ALRT_EVT_COMM_INTRNLVO returnInternalEventDetailsByEvtId(IndividualEventSC indEventSC) throws DAOException;
	
}
