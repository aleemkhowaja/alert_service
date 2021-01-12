package com.path.alert.bo.events.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.alert.vo.events.event.AlrtTagsCO;
import com.path.alert.vo.events.event.IndFixedParamListCO;
import com.path.alert.vo.events.event.IndividualEventCO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.alert.vo.events.event.IndividualFixedEventListCO;
import com.path.alert.vo.events.event.IndividualReportIdEventCO;
import com.path.alert.vo.service.AlertServiceCO;
import com.path.dbmaps.vo.ALRT_TAGS_DEFVO;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.select.SelectCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface IndividualEventBO {

	Integer indEventCount(IndividualEventSC indEventSC) throws BaseException;

	List<IndividualEventListCO> indEventList(IndividualEventSC indEventSC) throws BaseException;
	
	List<IndFixedParamListCO> indParamList(IndividualEventSC indEventSC) throws BaseException;
	Integer indParamCount(IndividualEventSC indEventSC) throws BaseException;
	List<IndFixedParamListCO> loadParamDetails(IndividualEventSC individualEventSC)	 throws BaseException;
	Integer fixedEventCount(IndividualEventSC indEventSC) throws BaseException;
	List<IndividualFixedEventListCO> fixedEventList(IndividualEventSC indEventSC) throws BaseException;
	
	List<SelectCO> fixedEventListSelectCO(IndividualEventSC indEventSC) throws BaseException;
	
	Integer reportEventCount(IndividualEventSC indEventSC) throws BaseException;
	
	List<IndividualReportIdEventCO> reportList(IndividualEventSC indEventSC) throws BaseException;
	
	IndividualEventCO dependencyByFixedEvtId(IndividualEventCO individualEventCO) throws BaseException; 
	
	String fixedEventDescription(IndividualEventSC indEventSC) throws BaseException ;
	
    Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
			IndividualEventCO individualEventCO,String iv_crud) throws BaseException;

	
	IndividualEventCO dependencyByReportId(IndividualEventCO individualEventCO) throws BaseException;
	

	IndividualEventCO save(IndividualEventCO individualEventCO) throws BaseException;
	
	/**
	 * validate Fixed Event Value
	 * @param individualEventCO
	 * @return
	 * @throws BaseException
	 */
	public IndividualEventCO validateFixedEventValue(IndividualEventCO individualEventCO)  throws BaseException;
	
	IndividualEventCO returnIndividualEventByEventId(IndividualEventSC indEventSC) throws BaseException;
	
	IndividualEventCO delete(IndividualEventCO individualEventCO) throws BaseException;
	
	
	void approveRecord (IndividualEventCO individualEventCO,String sLanguage,String userName) throws BaseException;
	

	public  AlertServiceCO getAlertEvents(AlertServiceCO alertServiceCO) throws BaseException;
	
	/**
	 * 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	public void suspend(IndividualEventCO individualEventCO) throws BaseException;
	
	/**
	 * 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	public void reactivate(IndividualEventCO individualEventCO) throws BaseException;
		
	
	/**
	 * 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	public void toSuspend(IndividualEventCO individualEventCO) throws BaseException;
	
	/**
	 * 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	public void reject(IndividualEventCO individualEventCO) throws BaseException;

	/**
	 * 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	public void toReactivate(IndividualEventCO individualEventCO) throws BaseException;
	/**
	 * return report details by report id
	 * @param indEventSC
	 * @return
	 * @throws Exception
	 */
	public IndividualEventCO returnReportDetailsById(IndividualEventSC indEventSC) throws Exception;
	/**
	 * return queries list
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public List<IRP_AD_HOC_QUERYVO> returnQueryList(IndividualEventSC indEventSC) throws Exception;
	
	/**
	 * return queries list count
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public Integer returnQueryListCount(IndividualEventSC indEventSC) throws Exception;
	
	/**
	 * 
	 * @param indEventSC
	 * @return
	 * @throws Exception
	 */
	public IndividualEventCO returnQueryDetailsById(IndividualEventSC indEventSC) throws Exception;
	
	
	/**
	 * 
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	//public List<AlrtTagsCO> returnAlertTagList(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * return IndEventCustomDefaultTagList
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public ArrayList<ALRT_TAGS_DEFVO> returnIndEventCustomDefaultTagList(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * return IndEventCustomDefaultTagListCount
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public int returnIndEventCustomDefaultTagListCount(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ALRT_TAGS_DEFVO> returnColumnListByQueryId(String queryId) throws Exception;
	
	/**
	 * 
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public List<IndividualEventListCO> returnIndividualEventListForGrid(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * 
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public Integer returnIndividualEventCountForGrid(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * check if Event description unique
	 * @param indEventSC
	 * @return
	 * @throws DAOException
	 */
	public Integer returnCheckIsUniqueEventDescription(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * return Alert Tags Select count
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public Integer returnAlertTagsSelectCount(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * return Alert Tags Select
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public List<AlrtTagsCO> returnAlertTagsSelect(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 * return Attach report mapping argument
	 * @param sc
	 * @return
	 * @throws BaseException
	 */
	public IndividualEventCO returnAttachReportMappingArgument(IndividualEventSC sc) throws Exception;
	
	/**
	 * return Events list for Specific Package
	 * @param indEventSC
	 * @return
	 * @throws BaseException
	 */
	public List<IndividualEventListCO> returnIndividualEventListForPackageList(IndividualEventSC indEventSC) throws BaseException;
	
	/**
	 *  return Events count for Specific Package
	 * @param sc
	 * @return
	 * @throws BaseException
	 */
	public Integer returnIndividualEventListForPackageCount(IndividualEventSC sc) throws BaseException;
	
	/**
	 * Apply Display Fields
	 * @param individualEventCO
	 * @return
	 * @throws BaseException
	 */
	public IndividualEventCO applySysParamSettings(IndividualEventCO individualEventCO) throws BaseException;
}
