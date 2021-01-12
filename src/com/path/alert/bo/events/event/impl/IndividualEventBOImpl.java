package com.path.alert.bo.events.event.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONException;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.common.AlrtCommonConstants;
import com.path.alert.bo.events.event.IndividualEventBO;
import com.path.alert.bo.events.event.IndividualEventConstant;
import com.path.alert.dao.events.event.IndividualEventDAO;
import com.path.alert.vo.events.event.AlrtTagsCO;
import com.path.alert.vo.events.event.IndFixedParamListCO;
import com.path.alert.vo.events.event.IndividualEventCO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.events.event.IndividualEventReportAttachmentCO;
import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.alert.vo.events.event.IndividualFixedEventListCO;
import com.path.alert.vo.events.event.IndividualReportIdEventCO;
import com.path.alert.vo.service.AlertServiceCO;
import com.path.alert.vo.service.AlertServiceSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.reporting.CommonReportingBO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_BATCH_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_INTRNLVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODE_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_OL_DATA_TRANSVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_EVT_REPORT_ATTACHVO;
import com.path.dbmaps.vo.ALRT_FIXED_EVT_PARAM_CONDVO;
import com.path.dbmaps.vo.ALRT_TAGS_DEFVO;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.reporting.IRP_AD_HOC_QUERYCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_FIELDSCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;

/**
 * 
 * @author Aleem
 *
 */
@SuppressWarnings("serial")
public class IndividualEventBOImpl extends BaseBO implements IndividualEventBO {

	private IndividualEventDAO alertIndividualEventDAO;
	private AlertCommonLibBO alertCommonLibBO;
	private CommonReportingBO commonReportingBO;


	@Override
	public Integer fixedEventCount(IndividualEventSC indEventSC) throws BaseException {
		return alertIndividualEventDAO.fixedEventCount(indEventSC);
	}
	
	@Override
	public List<IndividualFixedEventListCO> fixedEventList(IndividualEventSC indEventSC) throws BaseException {
		return alertIndividualEventDAO.fixedEventList(indEventSC);
	}
	
	@Override
	public List<SelectCO> fixedEventListSelectCO(IndividualEventSC indEventSC) throws BaseException 
	{
	    return alertIndividualEventDAO.fixedEventListSelectCO(indEventSC);
	}
	
	@Override
	public Integer indEventCount(IndividualEventSC indEventSC) throws BaseException 
	{
		return alertIndividualEventDAO.indEventCount(indEventSC);
	}

	@Override
	public List<IndividualEventListCO> indEventList(IndividualEventSC indEventSC) throws BaseException 
	{
		return alertIndividualEventDAO.indEventList(indEventSC);
	}

	@Override
	public Integer indParamCount(IndividualEventSC indEventSC) throws BaseException {
		return alertIndividualEventDAO.indParamCount(indEventSC);
	}

	@Override
	public List<IndFixedParamListCO> indParamList(IndividualEventSC indEventSC) throws BaseException {
		return alertIndividualEventDAO.indParamList(indEventSC);

	}
	
	@Override
	public IndividualEventCO dependencyByReportId(IndividualEventCO individualEventCO) throws BaseException {
		/*IndividualEventSC criteria = new IndividualEventSC();
		criteria.getAlrtEvtVO().setREPORT_ID(individualEventCO.getAlrtEvtVO().getREPORT_ID());
		criteria.setCompCode(individualEventCO.getCompCode());
		int count = alertIndividualEventDAO.returnreportIdCount(criteria);

		if (count == 0 || count == -1) {
			individualEventCO.getAlrtEvtVO().setMEMO_ID(null);
			throw new BOException("Cannot Proceed','Invalid or Missing Report ID");
		}
*/
		return individualEventCO;

	}


	@Override
	public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
			IndividualEventCO individualEventCO, String iv_crud) throws BaseException {

		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualEventCO.getCompCode());
		reqFieldSC.setProgRef(
				commonLibBO.returnOrginProgRef(individualEventCO.getAppName(), individualEventCO.getProgRef()));
		reqFieldSC.setAppName(individualEventCO.getAppName());
		reqFieldSC.setBranchCode(individualEventCO.getBranchCode());

		String[] listIds = new String[] { "lookuptxt_fixedEventid", "lookuptxt_memoId", "lookuptxt_reportId",
				"briefdesceng", "briefdesceng1", "briefdesceng2", "MessageText", "MessageSMS", "MessageEmail",
				"dayInMonth", "filterButton" };
		String[] listNames = new String[] { "individualEventCO.alrtEvtVO.FIXED_EVENT_ID",
				"individualEventCO.alrtEvtVO.MEMO_ID", "individualEventCO.alrtEvtVO.REPORT_ID",
				"individualEventCO.briefDescEng", "individualEventCO.briefDescEng1", "individualEventCO.briefDescEng2",
				"individualEventCO.alrtEvtVO.QUERY_MESSAGE", "individualEventCO.alrtEvtVO.SUBSCRIBER_COL2",
				"individualEventCO.alrtEvtVO.SUBSCRIBER_COL1", "individualEventCO.alrtEvtVO.DAY_IN_MONTH", "filterButton" };

		commonLibBO.applyDynScreenDisplay(listIds, listNames, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO,
				individualEventCO.getHm(), reqFieldSC, Boolean.TRUE);

		if (AlertConstant.STATUS_NEW.equals(individualEventCO.getAlrtEvtVO().getSTATUS())
				&& AlertConstant.CRUD_R.equals(iv_crud)) {

			individualEventCO.getAlrtEvtVO().setFIXED_EVENT_ID(null);
			individualEventCO.getAlrtEvtVO().setDESC_ENG(null);
			individualEventCO.getAlrtEvtVO().setEVT_MODE(null);
			individualEventCO.getAlrtEvtVO().setDESC_ARAB(null);
			individualEventCO.getAlrtEvtVO().setSUSPENDED(null);
			individualEventCO.getAlrtEvtVO().setMESSAGE_SUBJECT_ENG(null);
			individualEventCO.getAlrtEvtVO().setMESSAGE_SUBJECT_ARAB(null);
			individualEventCO.getAlrtEvtVO().setMESSAGE_TEXT_ENG(null);
			individualEventCO.getAlrtEvtVO().setMESSAGE_TEXT_ARAB(null);
			individualEventCO.getAlrtEvtVO().setQUERY_MESSAGE(null);
			individualEventCO.getAlrtEvtVO().setSUBSCRIBER_COL1(null);
			individualEventCO.getAlrtEvtVO().setSUBSCRIBER_COL2(null);
			individualEventCO.getAlrtEvtVO().setALRT_DATE(null);
			individualEventCO.getAlrtEvtVO().setPERIOD(null);
			individualEventCO.getAlrtEvtVO().setPERIOD_TYPE(null);
			individualEventCO.getAlrtEvtVO().setSTOP_AFTER(null);

			/*
			 * if ((null != individualEventCO.getAlrtEvtVO().getSTATUS())){ &&
			 * (("").equals(individualEventCO.getAlrtEvtVO().getSTATUS().isEmpty
			 * ()))){
			 */ applyDynScreenDisplay(new String[] { "IndividualEventDeleteBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ONE.toString(), individualEventCO.getHm(), reqFieldSC);
			// }
		} else {
			applyDynScreenDisplay(new String[] { "IndividualEventDeleteBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ZERO.toString(), individualEventCO.getHm(), reqFieldSC);

		}
		if (AlertConstant.CRUD_P.equals(iv_crud)) {
			applyDynScreenDisplay(new String[] { "IndividualEventUpdateBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ZERO.toString(), individualEventCO.getHm(), reqFieldSC);

			applyDynScreenDisplay(new String[] { "event_approve_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ONE.toString(), individualEventCO.getHm(), reqFieldSC);

		} else {
			applyDynScreenDisplay(new String[] { "event_approve_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ZERO.toString(), individualEventCO.getHm(), reqFieldSC);

			applyDynScreenDisplay(new String[] { "IndividualEventUpdateBtn" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
					BigDecimal.ONE.toString(), individualEventCO.getHm(), reqFieldSC);
		}

		return individualEventCO.getHm();

	}
	
	@Override
	public Integer returnIndividualEventCountForGrid(IndividualEventSC indEventSC) throws BaseException
	{
		return alertIndividualEventDAO.returnIndividualEventCountForGrid(indEventSC);
	}
	
	@Override
	public List<IndividualEventListCO> returnIndividualEventListForGrid(IndividualEventSC indEventSC) throws BaseException
	{
		return alertIndividualEventDAO.returnIndividualEventListForGrid(indEventSC);
	}
	
    @Override
    public IndividualEventCO save(IndividualEventCO individualEventCO) throws BaseException
    {
	AuditRefCO refCO = individualEventCO.getAuditRefCO();
	//AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
	ALRT_EVTVO newAlrt_EVTVO = individualEventCO.getAlrtEvtVO();
	try
	{
	    if(NumberUtil.isEmptyDecimal(newAlrt_EVTVO.getEVT_ID()))
	    {
		newAlrt_EVTVO.setCOMP_CODE(individualEventCO.getCompCode());
		newAlrt_EVTVO.setCREATED_BY(individualEventCO.getUserID());
		newAlrt_EVTVO.setDATE_CREATED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
		newAlrt_EVTVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
		newAlrt_EVTVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
			
		Integer mainRow = alertIndividualEventDAO.saveALRT_EVT(newAlrt_EVTVO);
		
		/**
		 * save Event in Core db with same event id which is available in alert
		 * @Note identity column is off by default
		 * so set on/off manually in vo mapper
		 */
        	if(null != AlertUtils.returnConnectionCo() && !AlrtCommonConstants.isOmniInstalled)
        	{
        	    newAlrt_EVTVO.setConnCO(AlertUtils.returnConnectionCo());
        	    genericDAO.insert(newAlrt_EVTVO);
	        }
        	
		individualEventCO.setAlrtEvtVO(newAlrt_EVTVO);
		individualEventCO.setEvtID(newAlrt_EVTVO.getEVT_ID());
		if(mainRow == null || mainRow < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		// insert Audit
		auditBO.callAudit(null, newAlrt_EVTVO, refCO);
	    }
	    else
	    {
		individualEventCO.setEvtID(newAlrt_EVTVO.getEVT_ID());
		newAlrt_EVTVO.setCOMP_CODE(individualEventCO.getCompCode());
		newAlrt_EVTVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		newAlrt_EVTVO.setMODIFIED_BY(individualEventCO.getUserID());
		newAlrt_EVTVO.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));

		// Update Individual Subscriber Details
		Integer MainRowUpdate = genericDAO.update(newAlrt_EVTVO);
		if(MainRowUpdate == null || MainRowUpdate < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		/**
		 * save in core db
		 */
		/**
		 * save Event in Core db with same event id which is available
		 * in alert
		 * 
		 * @Note identity column is off by default so set on/off
		 *       manually in vo mapper
		 */
		syncEventWithCoreDb_save(newAlrt_EVTVO, individualEventCO);

		// return old object vo
		ALRT_EVTVO oldAlrt_EVTVO = (ALRT_EVTVO) individualEventCO.getAuditObj();

		if(newAlrt_EVTVO.getREPORT_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
		{
		    newAlrt_EVTVO.setREPORT_ID(null);
		    oldAlrt_EVTVO.setREPORT_ID(null);
		}

		if(newAlrt_EVTVO.getFIXED_EVENT_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
		{
		    oldAlrt_EVTVO.setFIXED_EVENT_ID(null);
		    newAlrt_EVTVO.setFIXED_EVENT_ID(null);
		}

		// update Audit
		auditBO.callAudit(oldAlrt_EVTVO, newAlrt_EVTVO, refCO);
	    }

	    if(AlertConstant.TYPE_EVT_F.equals(individualEventCO.getAlrtEvtVO().getEVT_TYPE()))
	    {
		individualEventCO.setStatusDesc(newAlrt_EVTVO.getSTATUS());
		/**
		 * save Fixed Event Details
		 */
		saveFixedEventDetails(individualEventCO);
	    }

	    /**
	     * insert record of Alert Event Communication Mode
	     */
	    saveCommunicationMode(individualEventCO);

	    /**
	     * insert Internal Alerts
	     */
	    saveInternalAlertEvent(individualEventCO);

	    /**
	     * insert record of static message Details in multiple languages
	     */
	    saveStaticMessageDetails(individualEventCO);

	    /**
	     * insert new custom tags
	     */
	    saveNewCustomTags(individualEventCO);

	    /**
	     * insert report attachments and parameters
	     */
	    saveReportAttachments(individualEventCO);

	    auditBO.insertAudit(refCO);
	}
	catch(BaseException e)
	{
	    throw new BaseException(e.getMessage(), e);
	}
	return individualEventCO;
    }

    /**
     * Synch Data With Core DB
     * if the flag CORE_IMAL_YN = 'N' in pthCtrl1 table 
     * @param newAlrt_EVTVO
     * @param individualEventCO
     * @throws BaseException 
     */
	private void syncEventWithCoreDb_save(ALRT_EVTVO newAlrt_EVTVO, IndividualEventCO individualEventCO) throws BaseException
	{
		
		if (null == AlertUtils.returnConnectionCo() || AlrtCommonConstants.isOmniInstalled) {
			return;
		}
		/**
		 * set the connection co
		 */
		newAlrt_EVTVO.setConnCO(AlertUtils.returnConnectionCo());
		individualEventCO.setEvtID(newAlrt_EVTVO.getEVT_ID());
		/**
		 * get date updated according to db
		 */
		ALRT_EVTVO evtvo = (ALRT_EVTVO) genericDAO.selectByPK(newAlrt_EVTVO);
		if (evtvo != null) {
			newAlrt_EVTVO.setDATE_UPDATED(evtvo.getDATE_UPDATED());
			/**
			 * update in core db
			 */
			genericDAO.update(newAlrt_EVTVO);
		} else {
			newAlrt_EVTVO.setCREATED_BY(individualEventCO.getUserID());
			newAlrt_EVTVO.setDATE_CREATED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
			newAlrt_EVTVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));

			/**
			 * insert in core db
			 */
			genericDAO.insert(newAlrt_EVTVO);
		}
		individualEventCO.setStatusDesc(newAlrt_EVTVO.getSTATUS());
		/**
		 * enable for Maintenance screen
		 */
		if(!StringUtil.nullToEmpty(newAlrt_EVTVO.getSTATUS()).equals(AlertConstant.STATUS_ACTIVE))
		{
			/**
			 * set the connection co
			 */
			saveFixedEventDetails(individualEventCO);
		}
		
	}
	
	/*
	 * 
	 * Save Fixed Event Details
	 */
	private void saveFixedEventDetails(IndividualEventCO individualEventCO) throws BaseException 
	{
		/**
		 * if there is no fixed parameters then return
		 */
		if(individualEventCO.getParamList() == null || individualEventCO.getParamList().size() <= 0)  return;
		
		AuditRefCO refCO = individualEventCO.getAuditRefCO();

		/**
		 * validate the Fixed Event Params
		 */
		validateFixedEventValue(individualEventCO);

		/**
		 * enable for Maintenance screen
		 */
		if(StringUtil.nullToEmpty(individualEventCO.getStatusDesc()).equals(AlertConstant.STATUS_ACTIVE))
		{
			// delete all record in alrt param set table
			individualEventCO.setConnCO(null);
			alertIndividualEventDAO.deleteAllEventParamSet(individualEventCO);
		}

		/**
		 * delete record related to fixed event condition from core db if the flag
		 * CORE_IMAL_YN = 'Y' in pthCtrl1 table
		 */
		syncFixedEventWithCoreDb_delete(individualEventCO);

		
		// insert AlrtEvtParamSet
		ALRT_FIXED_EVT_PARAM_CONDVO alrt_FIXED_EVT_PARAM_CONDVO = new ALRT_FIXED_EVT_PARAM_CONDVO();
		for (int i = 0; i < individualEventCO.getParamList().size(); i++) {
			if (StringUtil.isNotEmpty(individualEventCO.getParamList().get(i).getCOLUMN_NAME())
					&& StringUtil.isNotEmpty(individualEventCO.getParamList().get(i).getPARAM_VALUE())) {
				alrt_FIXED_EVT_PARAM_CONDVO = new ALRT_FIXED_EVT_PARAM_CONDVO();
				alrt_FIXED_EVT_PARAM_CONDVO.setEVT_ID(individualEventCO.getEvtID());
				alrt_FIXED_EVT_PARAM_CONDVO
						.setOLD_NEW_VAL_LIST(individualEventCO.getParamList().get(i).getOLD_NEW_VAL_LIST());
				alrt_FIXED_EVT_PARAM_CONDVO
						.setOPERATOR_TYPE(individualEventCO.getParamList().get(i).getOPERATOR_TYPE());
				alrt_FIXED_EVT_PARAM_CONDVO
						.setPARAM_COLUMN_NAME(individualEventCO.getParamList().get(i).getCOLUMN_NAME());
				alrt_FIXED_EVT_PARAM_CONDVO.setPARAM_VALUE(individualEventCO.getParamList().get(i).getPARAM_VALUE());
				alrt_FIXED_EVT_PARAM_CONDVO.setCREATED_BY(individualEventCO.getUserID());
				alrt_FIXED_EVT_PARAM_CONDVO
						.setCREATED_DATE(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));

				/**
				 * enable for Maintenance screen
				 */
				if(StringUtil.nullToEmpty(individualEventCO.getStatusDesc()).equals(AlertConstant.STATUS_ACTIVE))
				{
					Integer insertrow = genericDAO.insert(alrt_FIXED_EVT_PARAM_CONDVO);
					if (insertrow == null || insertrow < 1) {
						throw new BOException(MessageCodes.RECORD_CHANGED);
					}
				}
				

				/**
				 * save Fixed Event in Core DB
				 */
				syncFixedEventWithCoreDb_save(alrt_FIXED_EVT_PARAM_CONDVO);

				/**
				 * enable for Maintenance screen
				 */
				if(StringUtil.nullToEmpty(individualEventCO.getStatusDesc()).equals(AlertConstant.STATUS_ACTIVE))
				{
					// insert fixed event audtit
					ALRT_FIXED_EVT_PARAM_CONDVO oldALRT_FIXED_EVT_PARAM_CONDVO = new ALRT_FIXED_EVT_PARAM_CONDVO();
					oldALRT_FIXED_EVT_PARAM_CONDVO.setCREATED_BY(individualEventCO.getUserID());
					oldALRT_FIXED_EVT_PARAM_CONDVO.setCREATED_DATE(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
					auditBO.callAudit(new ALRT_FIXED_EVT_PARAM_CONDVO(), alrt_FIXED_EVT_PARAM_CONDVO, refCO);
				}
				

			}
		}
	}

	/**
	 * delete records from core db
	 * if the flag CORE_IMAL_YN = 'Y' in pthCtrl1 table 
	 * @param individualEventCO
	 * @throws BaseException
	 */
	private void syncFixedEventWithCoreDb_delete(IndividualEventCO individualEventCO) throws BaseException
	{
		/**
		 * check if connection co is not null
		 */
		if (null == AlertUtils.returnConnectionCo() || AlrtCommonConstants.isOmniInstalled)
			return;
		/**
		 * set the connection co
		 */
		individualEventCO.setConnCO(AlertUtils.returnConnectionCo());
	    alertIndividualEventDAO.deleteAllEventParamSet(individualEventCO);
	}
	
	/**
	 * save records in core db
	 * if the flag CORE_IMAL_YN = 'Y' in pthCtrl1 table 
	 * @param alrt_FIXED_EVT_PARAM_CONDVO
	 * @throws BaseException
	 */
	private void syncFixedEventWithCoreDb_save(ALRT_FIXED_EVT_PARAM_CONDVO alrt_FIXED_EVT_PARAM_CONDVO) throws BaseException
	{
		/**
		 * check if connection co is not null
		 */
		if (null == AlertUtils.returnConnectionCo() || AlrtCommonConstants.isOmniInstalled)
			return;
		/**
	   	 * set the connection co
	   	 */
	   	  alrt_FIXED_EVT_PARAM_CONDVO.setConnCO(AlertUtils.returnConnectionCo());
	   	  genericDAO.insert(alrt_FIXED_EVT_PARAM_CONDVO);
	}
	
	
	/**
	 * Save Message Details in multiple language
	 * @param individualEventCO
	 * @throws BaseException
	 */
	private void saveStaticMessageDetails(IndividualEventCO individualEventCO) throws BaseException 
	{
		//return AuditRefCo
		AuditRefCO refCO = individualEventCO.getAuditRefCO();
		
		ALRT_EVT_OL_DATA_TRANSVO alrt_EVT_OL_DATA_TRANSVO = null;
		/**
		 * Start Save Email Static Message Details retrieve from Hidden Field
		 */
		if(StringUtil.isNotEmpty(individualEventCO.getEventDynamicEmailMessageDetailsTemp()))
		{
			String staticMessageSplittedData[] = individualEventCO.getEventDynamicEmailMessageDetailsTemp().split("<---->");
			for(int i=0; i<staticMessageSplittedData.length; i++)
			{
				String seprateStaticMessageSplittedData[] = staticMessageSplittedData[i].split("<-->");
				if(seprateStaticMessageSplittedData != null && seprateStaticMessageSplittedData.length > 3)
				{
					alrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
					alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
					alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(seprateStaticMessageSplittedData[0]);
					alrt_EVT_OL_DATA_TRANSVO.setLANG_CODE(seprateStaticMessageSplittedData[1]);
					
					ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
					if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
					{
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
						genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
						
						//update audit of Message in diffrent languages
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
					else
					{
						if(individualEventCO.getEmailActivate().equals(IndividualEventConstant.ACTIVATE))
						{
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
							
							//insert audit of Message in diffrent languages
							oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
							oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
							alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
							auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
						}
					}
				}
			}
		}
		/**
		 * Start Email Static Message which not set on hidden field
		 */
		alrt_EVT_OL_DATA_TRANSVO = individualEventCO.getEmail_EVT_OL_DATA_TRANSVO();
		if(alrt_EVT_OL_DATA_TRANSVO != null)
		{
			if(StringUtil.isNotEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT()) && !alrt_EVT_OL_DATA_TRANSVO .getLANG_CODE().equals("DF"))
			{
				alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
				alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE);
				ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
				if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
				{
					
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
					genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
					
					//update audit of Message in diffrent languages
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
					
					auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
				}
				else
				{
					if(individualEventCO.getEmailActivate().equals(IndividualEventConstant.ACTIVATE))
					{
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
						
						//insert audit of Message in diffrent languages
						oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
						oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
				}
			}
		}
		
		 /**
		  * Start Sms Static Message Details
		  */
		/**
		* Start Save Sms Static Message Details retrieve from Hidden Field
		*/
		if(StringUtil.isNotEmpty(individualEventCO.getEventDynamicSmsMessageDetailsTemp()))
		{
			String staticMessageSplittedData[] = individualEventCO.getEventDynamicSmsMessageDetailsTemp().split("<---->");
			for(int i=0; i<staticMessageSplittedData.length; i++)
			{
				String seprateStaticMessageSplittedData[] = staticMessageSplittedData[i].split("<-->");
				if(seprateStaticMessageSplittedData != null && seprateStaticMessageSplittedData.length > 3)
				{
					alrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
					alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
					alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(seprateStaticMessageSplittedData[0]);
					alrt_EVT_OL_DATA_TRANSVO.setLANG_CODE(seprateStaticMessageSplittedData[1]);
					
					ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
					if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
					{
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
						genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
				        	
						//update audit of Message in diffrent languages
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
					else
					{
						// if Sms is activated
						if(individualEventCO.getSmsActivate().equals(IndividualEventConstant.ACTIVATE))
						{
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
							
							//insert audit of Message in diffrent languages
							oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
							oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
						}
					}
				}
			}
		}	
		/**
		 * Start Sms Static Message which not set on hidden field
		 */
		alrt_EVT_OL_DATA_TRANSVO = individualEventCO.getSms_EVT_OL_DATA_TRANSVO();
		if(alrt_EVT_OL_DATA_TRANSVO != null)
		{
			alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT("-");
			if(!alrt_EVT_OL_DATA_TRANSVO .getLANG_CODE().equals(IndividualEventConstant.DEFAULT_LANG))
			{
				alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
				alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(IndividualEventConstant.SMS_COMMUNICATION_TYPE);
				ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
				if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
				{
					
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
					genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
					
					//update audit of Message in diffrent languages
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
					auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
				}
				else
				{
					// if Sms is activated
					if(individualEventCO.getSmsActivate().equals(IndividualEventConstant.ACTIVATE))
					{
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
						
						//insert audit of Message in diffrent languages
						oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
						oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
					
				}
			}
		}
		
		/**
		  * Start Omni Inbox Static Message Details
		  */
		/**
		* Start Save Omni Inbox Static Message Details retrieve from Hidden Field
		*/
		if(StringUtil.isNotEmpty(individualEventCO.getEventDynamicOmniInboxMessageDetailsTemp()))
		{
			String staticMessageSplittedData[] = individualEventCO.getEventDynamicOmniInboxMessageDetailsTemp().split("<---->");
			for(int i=0; i<staticMessageSplittedData.length; i++)
			{
				String seprateStaticMessageSplittedData[] = staticMessageSplittedData[i].split("<-->");
				if(seprateStaticMessageSplittedData != null && seprateStaticMessageSplittedData.length > 3)
				{
					alrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
					alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
					alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(seprateStaticMessageSplittedData[0]);
					alrt_EVT_OL_DATA_TRANSVO.setLANG_CODE(seprateStaticMessageSplittedData[1]);
					
					ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
					if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
					{
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
						alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
						genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
						
						//update audit of Message in diffrent languages
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
						alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
					else
					{
						// if OmniInbox is activated
						if(individualEventCO.getOmniInboxActivate().equals(IndividualEventConstant.ACTIVATE))
						{
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(seprateStaticMessageSplittedData[2]);
							alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(seprateStaticMessageSplittedData[3]);
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
							
							//insert audit of Message in diffrent languages
							oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
							oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
							oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
							auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
						}
						
					}
				}
			}
		}	
		/**
		 * Start Omni Inbox Static Message which not set on hidden field
		 */
		alrt_EVT_OL_DATA_TRANSVO = individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO();
		if(alrt_EVT_OL_DATA_TRANSVO != null)
		{
			alrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
			if(!alrt_EVT_OL_DATA_TRANSVO .getLANG_CODE().equals(IndividualEventConstant.DEFAULT_LANG))
			{
				alrt_EVT_OL_DATA_TRANSVO.setEVT_ID(individualEventCO.getEvtID());
				alrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE);
				ALRT_EVT_OL_DATA_TRANSVO oldAlrt_EVT_OL_DATA_TRANSVO = (ALRT_EVT_OL_DATA_TRANSVO) genericDAO.selectByPK(alrt_EVT_OL_DATA_TRANSVO);
					
				if(oldAlrt_EVT_OL_DATA_TRANSVO != null)
				{
					
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_SUBJECT(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMESSAGE_BODY(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(individualEventCO.getUserID());
					oldAlrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
					genericDAO.update(alrt_EVT_OL_DATA_TRANSVO);
			        	
					//update audit of Message in diffrent languages
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getCREATED_DATE());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_BY(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_BY());
					alrt_EVT_OL_DATA_TRANSVO.setMODIFIED_DATE(oldAlrt_EVT_OL_DATA_TRANSVO.getMODIFIED_DATE());
					auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
				}
				else
				{
					// if OmniInbox is activated
					if(individualEventCO.getOmniInboxActivate().equals(IndividualEventConstant.ACTIVATE))
					{
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						alrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						genericDAO.insert(alrt_EVT_OL_DATA_TRANSVO);
						
						//insert audit of Message in diffrent languages
						oldAlrt_EVT_OL_DATA_TRANSVO = new ALRT_EVT_OL_DATA_TRANSVO();
						oldAlrt_EVT_OL_DATA_TRANSVO.setEVT_ID(alrt_EVT_OL_DATA_TRANSVO.getEVT_ID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCOMMUNICATION_TYPE(alrt_EVT_OL_DATA_TRANSVO.getCOMMUNICATION_TYPE());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_BY(individualEventCO.getUserID());
						oldAlrt_EVT_OL_DATA_TRANSVO.setCREATED_DATE(individualEventCO.getRunningDate());
						auditBO.callAudit(oldAlrt_EVT_OL_DATA_TRANSVO, alrt_EVT_OL_DATA_TRANSVO, refCO);
					}
					
				}
			}
		}
	}	

    /**
     * Save Communication Mode
     * 
     * @param individualEventCO
     * @throws BaseException
     */
    private void saveCommunicationMode(IndividualEventCO individualEventCO) throws BaseException
    {
	AuditRefCO refCO = individualEventCO.getAuditRefCO();

	ALRT_EVT_COMM_MODEVO email_EVT_COMM_MODEVO = individualEventCO.getEmail_EVT_COMM_MODEVO();
	if(email_EVT_COMM_MODEVO != null)
	{
	    email_EVT_COMM_MODEVO.setEVT_ID(individualEventCO.getEvtID());
	    email_EVT_COMM_MODEVO.setCOMMUNICATION_TYPE(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE);

	    // check id communication model already exist and Update
	    ALRT_EVT_COMM_MODEVO oldAlrt_EVT_COMM_MODEVO = (ALRT_EVT_COMM_MODEVO) genericDAO
		    .selectByPK(email_EVT_COMM_MODEVO);

	    // Check if Email Not Activated
	    if(StringUtil.isEmptyString(individualEventCO.getEmailActivate())
		    || individualEventCO.getEmailActivate().equals(IndividualEventConstant.DEACTIVATE))
	    {
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    email_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.NO);
		    genericDAO.update(email_EVT_COMM_MODEVO);

		    // Update Audit for Email Communication Type.
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(email_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(email_EVT_COMM_MODEVO.getCREATED_DATE());
		    if(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
		    {
			oldAlrt_EVT_COMM_MODEVO.setREPORT_ID(null);
			email_EVT_COMM_MODEVO.setREPORT_ID(null);
		    }
		    else
		    {
			oldAlrt_EVT_COMM_MODEVO.setQUERY_ID(null);
			email_EVT_COMM_MODEVO.setQUERY_ID(null);
		    }

		    // Update Audit of Communication Mode
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, email_EVT_COMM_MODEVO, refCO);
		}
	    }
	    // Else for When Email Activated
	    else
	    {
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    if(StringUtil.isNotEmpty(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE()))
		    {
			if(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE()
				.equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
			{
			    // oldElrt_EVT_COMM_MODEVO.setQUERY_ID(email_EVT_COMM_MODEVO.getQUERY_ID());
			    email_EVT_COMM_MODEVO.setREPORT_ID(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE);
			    // oldElrt_EVT_COMM_MODEVO.setTEMPLATE_TYPE(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE());

			    // check if default is not set hidden fields
			    if(StringUtil.isNotEmpty(individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getLANG_CODE())
				    && individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getLANG_CODE()
					    .equals(IndividualEventConstant.DEFAULT_LANG))
			    {
				email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
					individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
				email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
					individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
			    }
			    else
			    {
				// oldElrt_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(email_EVT_COMM_MODEVO.getDEFAULT_MESSAGE_SUBJECT());
				// oldElrt_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(email_EVT_COMM_MODEVO.getDEFAULT_MESSAGE_BODY());
			    }

			    oldAlrt_EVT_COMM_MODEVO.setREPORT_ID(null);
			    email_EVT_COMM_MODEVO.setREPORT_ID(null);
			}
			else
			{
			    // oldElrt_EVT_COMM_MODEVO.setQUERY_ID(email_EVT_COMM_MODEVO.getQUERY_ID());
			    // oldElrt_EVT_COMM_MODEVO.setREPORT_ID(email_EVT_COMM_MODEVO.getREPORT_ID());
			    // oldElrt_EVT_COMM_MODEVO.setTEMPLATE_TYPE(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE());
			    email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
				    individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
			    email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY("-");
			}
		    }
		    email_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);
		    email_EVT_COMM_MODEVO.setMODIFIED_BY(individualEventCO.getUserID());
		    email_EVT_COMM_MODEVO.setMODIFIED_DATE(individualEventCO.getRunningDate());

		    // Delete Mapped Argument on the time report
		    // IndividualEventSC individualEventSC = new
		    // IndividualEventSC();
		    // individualEventSC.setEventID(email_EVT_COMM_MODEVO.getEVT_ID());
		    // individualEventSC.setEmailCommunicationType(email_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE());
		    // alertIndividualEventDAO.deleteAlrtEventCommModeArgMap(individualEventSC);

		    // update Communication Mode
		    genericDAO.update(email_EVT_COMM_MODEVO);

		    // update audit of Email communication mode
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(email_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(email_EVT_COMM_MODEVO.getCREATED_DATE());

		    if(email_EVT_COMM_MODEVO.getQUERY_ID() == null)
		    {
			email_EVT_COMM_MODEVO.setQUERY_ID(null);
		    }
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, email_EVT_COMM_MODEVO, refCO);
		}
		else
		{
		    if(StringUtil.isNotEmpty(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE()))
		    {
			// check id S(Static)
			if(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE()
				.equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
			{
			    // check if default is not set hidden fields
			    if(StringUtil.isNotEmpty(individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getLANG_CODE())
				    && individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getLANG_CODE()
					    .equals(IndividualEventConstant.DEFAULT_LANG))
			    {
				email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
					individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
				email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
					individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
			    }
			    email_EVT_COMM_MODEVO.setREPORT_ID(null);
			}
			// otherwise Dynamic
			else
			{
			    email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
				    individualEventCO.getEmail_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
			    email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY("-");
			    // email_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(individualEventCO.getEmail_Report_EVT_COMM_MODEVO().getDEFAULT_MESSAGE_SUBJECT());
			    // mail_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(individualEventCO.getEmail_Report_EVT_COMM_MODEVO().getDEFAULT_MESSAGE_SUBJECT());
			    // email_EVT_COMM_MODEVO.setQUERY_ID(null);
			}

			email_EVT_COMM_MODEVO.setCREATED_BY(individualEventCO.getUserID());
			email_EVT_COMM_MODEVO.setCREATED_DATE(individualEventCO.getRunningDate());
			email_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);
			// insert Email Communication Mode
			genericDAO.insert(email_EVT_COMM_MODEVO);

			// insert audit of Email communication mode
			ALRT_EVT_COMM_MODEVO newEmailALRT_EVT_COMM_MODEVO = new ALRT_EVT_COMM_MODEVO();
			newEmailALRT_EVT_COMM_MODEVO.setEVT_ID(email_EVT_COMM_MODEVO.getEVT_ID());
			auditBO.callAudit(newEmailALRT_EVT_COMM_MODEVO, email_EVT_COMM_MODEVO, refCO);
		    }
		}
	    }

	    if(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
	    {
		// save Query Arguments mapping
		saveAlrtEvtCommModeArgemntsMapping(individualEventCO, email_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE(),
			IndividualEventConstant.STATIC_TEMPLATE_TYPE);
	    }
	    else
	    {
		// save Query Arguments mapping
		saveAlrtEvtCommModeArgemntsMapping(individualEventCO, email_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE(),
			IndividualEventConstant.STATIC_TEMPLATE_TYPE);
		// save Query Arguments mapping
		saveAlrtEvtCommModeArgemntsMapping(individualEventCO, email_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE(),
			IndividualEventConstant.DYNAMIC_TEMPLATE_TYPE);
	    }
	    // if(email_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals("S"))
	    // {

	    // }
	}

	/**
	 * CHeck For Sms if Not Activated
	 */

	ALRT_EVT_COMM_MODEVO sms_EVT_COMM_MODEVO = individualEventCO.getSms_EVT_COMM_MODEVO();
	if(sms_EVT_COMM_MODEVO != null)
	{
	    sms_EVT_COMM_MODEVO.setEVT_ID(individualEventCO.getEvtID());
	    // Set Communication Type S(Sms)
	    sms_EVT_COMM_MODEVO.setCOMMUNICATION_TYPE(IndividualEventConstant.SMS_COMMUNICATION_TYPE);
	    // Set Communication Type S(Static)
	    sms_EVT_COMM_MODEVO.setTEMPLATE_TYPE(IndividualEventConstant.STATIC_TEMPLATE_TYPE);
	    sms_EVT_COMM_MODEVO.setREPORT_ID(null);

	    // check id communication model already exist
	    ALRT_EVT_COMM_MODEVO oldAlrt_EVT_COMM_MODEVO = (ALRT_EVT_COMM_MODEVO) genericDAO
		    .selectByPK(sms_EVT_COMM_MODEVO);
	    // Check if Email Not Activated
	    if(StringUtil.isEmptyString(individualEventCO.getSmsActivate())
		    || individualEventCO.getSmsActivate().equals(IndividualEventConstant.DEACTIVATE))
	    {
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    // set Activate N(Not)
		    sms_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.NO);
		    genericDAO.update(sms_EVT_COMM_MODEVO);

		    // update Audit for Deactivate Communication mode
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(sms_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(sms_EVT_COMM_MODEVO.getCREATED_DATE());
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, sms_EVT_COMM_MODEVO, refCO);
		}
	    }
	    // Else if Sms is activated
	    else
	    {
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    // check if default is not set hidden fields
		    if(StringUtil.isNotEmpty(individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getLANG_CODE())
			    && individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getLANG_CODE()
				    .equals(IndividualEventConstant.DEFAULT_LANG))
		    {
			sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT("-");
			sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
				individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
		    }
		    else
		    {
			sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT("-");
//				    	sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(sms_EVT_COMM_MODEVO.getDEFAULT_MESSAGE_BODY());
		    }
		    sms_EVT_COMM_MODEVO.setQUERY_ID(individualEventCO.getSms_EVT_COMM_MODEVO().getQUERY_ID());
		    sms_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);
		    sms_EVT_COMM_MODEVO.setMODIFIED_BY(individualEventCO.getUserID());
		    sms_EVT_COMM_MODEVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
		    // update Communication Mode
		    genericDAO.update(sms_EVT_COMM_MODEVO);

		    // update Audit for Activate Sms Communication mode
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(sms_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(sms_EVT_COMM_MODEVO.getCREATED_DATE());
		    if(sms_EVT_COMM_MODEVO.getQUERY_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
		    {
			sms_EVT_COMM_MODEVO.setQUERY_ID(null);
		    }
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, sms_EVT_COMM_MODEVO, refCO);
		}
		else
		{
		    // check if default is not set hidden fields
		    if(StringUtil.isNotEmpty(individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getLANG_CODE())
			    && individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getLANG_CODE()
				    .equals(IndividualEventConstant.DEFAULT_LANG))
		    {
			sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT("-");
			sms_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
				individualEventCO.getSms_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
		    }
		    sms_EVT_COMM_MODEVO.setCREATED_BY(individualEventCO.getUserID());
		    sms_EVT_COMM_MODEVO.setCREATED_DATE(individualEventCO.getRunningDate());
		    sms_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);

		    // insert new Communication Mode
		    genericDAO.insert(sms_EVT_COMM_MODEVO);

		    // insert Sms Communication Mode Audit
		    ALRT_EVT_COMM_MODEVO newSmsALRT_EVT_COMM_MODEVO = new ALRT_EVT_COMM_MODEVO();
		    newSmsALRT_EVT_COMM_MODEVO.setEVT_ID(sms_EVT_COMM_MODEVO.getEVT_ID());
		    auditBO.callAudit(newSmsALRT_EVT_COMM_MODEVO, sms_EVT_COMM_MODEVO, refCO);
		}
	    }
	    // save Query Arguments mapping
	    saveAlrtEvtCommModeArgemntsMapping(individualEventCO, sms_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE(),
		    IndividualEventConstant.STATIC_TEMPLATE_TYPE);
	}

	/**
	 * CHeck For OmniInbox if Not Activated
	 */
	ALRT_EVT_COMM_MODEVO omniInbox_EVT_COMM_MODEVO = individualEventCO.getOmniInbox_EVT_COMM_MODEVO();
	if(omniInbox_EVT_COMM_MODEVO != null)
	{
	    omniInbox_EVT_COMM_MODEVO.setEVT_ID(individualEventCO.getEvtID());
	    // Set Communication Type OI(Sms)
	    omniInbox_EVT_COMM_MODEVO.setCOMMUNICATION_TYPE(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE);
	    // Set Communication Type S(Static)
	    omniInbox_EVT_COMM_MODEVO.setTEMPLATE_TYPE(IndividualEventConstant.STATIC_TEMPLATE_TYPE);
	    omniInbox_EVT_COMM_MODEVO.setREPORT_ID(null);

	    // check id communication model already exist
	    ALRT_EVT_COMM_MODEVO oldAlrt_EVT_COMM_MODEVO = (ALRT_EVT_COMM_MODEVO) genericDAO
		    .selectByPK(omniInbox_EVT_COMM_MODEVO);

	    // Check if Omni Inbox Not Activated
	    if(StringUtil.isEmptyString(individualEventCO.getOmniInboxActivate())
		    || individualEventCO.getOmniInboxActivate().equals(IndividualEventConstant.DEACTIVATE))
	    {
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    // set Activate N(Not)
		    omniInbox_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.NO);
		    genericDAO.update(omniInbox_EVT_COMM_MODEVO);

		    // update Audit for Deactivate Communication mode
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(omniInbox_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(omniInbox_EVT_COMM_MODEVO.getCREATED_DATE());
		    if(omniInbox_EVT_COMM_MODEVO.getQUERY_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
		    {
			omniInbox_EVT_COMM_MODEVO.setQUERY_ID(null);
		    }
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, omniInbox_EVT_COMM_MODEVO, refCO);
		}
	    }
	    // Else if Omni Inbox is activated
	    else
	    {
		// check id communication model already exist
		if(oldAlrt_EVT_COMM_MODEVO != null)
		{
		    // check if default is not set hidden fields
		    if(StringUtil.isNotEmpty(individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getLANG_CODE())
			    && individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getLANG_CODE()
				    .equals(IndividualEventConstant.DEFAULT_LANG))
		    {
			omniInbox_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
				individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
			omniInbox_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
				individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
		    }
		    else
		    {
			omniInbox_EVT_COMM_MODEVO
				.setDEFAULT_MESSAGE_SUBJECT(omniInbox_EVT_COMM_MODEVO.getDEFAULT_MESSAGE_SUBJECT());
			omniInbox_EVT_COMM_MODEVO
				.setDEFAULT_MESSAGE_BODY(omniInbox_EVT_COMM_MODEVO.getDEFAULT_MESSAGE_BODY());
		    }
		    omniInbox_EVT_COMM_MODEVO
			    .setQUERY_ID(individualEventCO.getOmniInbox_EVT_COMM_MODEVO().getQUERY_ID());
		    omniInbox_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);
		    omniInbox_EVT_COMM_MODEVO.setMODIFIED_BY(individualEventCO.getUserID());
		    omniInbox_EVT_COMM_MODEVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
		    // update Communication Mode

		    genericDAO.update(omniInbox_EVT_COMM_MODEVO);

		    // update Audit for Activate Sms Communication mode
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_BY(omniInbox_EVT_COMM_MODEVO.getCREATED_BY());
		    oldAlrt_EVT_COMM_MODEVO.setCREATED_DATE(omniInbox_EVT_COMM_MODEVO.getCREATED_DATE());
		    auditBO.callAudit(oldAlrt_EVT_COMM_MODEVO, omniInbox_EVT_COMM_MODEVO, refCO);
		}
		else
		{
		    // check if default is not set hidden fields
		    if(StringUtil.isNotEmpty(individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getLANG_CODE())
			    && individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getLANG_CODE()
				    .equals(IndividualEventConstant.DEFAULT_LANG))
		    {
			omniInbox_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_SUBJECT(
				individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getMESSAGE_SUBJECT());
			omniInbox_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY(
				individualEventCO.getOmniInbox_EVT_OL_DATA_TRANSVO().getMESSAGE_BODY());
		    }
		    omniInbox_EVT_COMM_MODEVO.setCREATED_BY(individualEventCO.getUserID());
		    omniInbox_EVT_COMM_MODEVO.setCREATED_DATE(individualEventCO.getRunningDate());
		    omniInbox_EVT_COMM_MODEVO.setACTIVATED_YN(IndividualEventConstant.YES);
		    // insert new Communication Mode
		    genericDAO.insert(omniInbox_EVT_COMM_MODEVO);

		    // update Audit for Activate Sms Communication mode
		    ALRT_EVT_COMM_MODEVO newOmniALRT_EVT_COMM_MODEVO = new ALRT_EVT_COMM_MODEVO();
		    newOmniALRT_EVT_COMM_MODEVO.setEVT_ID(omniInbox_EVT_COMM_MODEVO.getEVT_ID());
		    auditBO.callAudit(newOmniALRT_EVT_COMM_MODEVO, omniInbox_EVT_COMM_MODEVO, refCO);
		}
	    }
	    // save Query Arguments mapping
	    saveAlrtEvtCommModeArgemntsMapping(individualEventCO, omniInbox_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE(),
		    IndividualEventConstant.STATIC_TEMPLATE_TYPE);
	}
    }

    /**
     * save Internal Alerts
     * @param individualEventCO
     * @throws BaseException
     */
    private void saveInternalAlertEvent(IndividualEventCO individualEventCO) throws BaseException
    {
	AuditRefCO refCO = individualEventCO.getAuditRefCO();
	
	ALRT_EVT_COMM_INTRNLVO alrt_EVT_COMM_INTRNLVO =  individualEventCO.getAlrt_EVT_COMM_INTRNLVO();
	
	if(alrt_EVT_COMM_INTRNLVO == null) return;
	
	alrt_EVT_COMM_INTRNLVO.setEVT_ID(individualEventCO.getEvtID());
	
	/**
	 * check internal Alert event already exist and Update
	 */
	ALRT_EVT_COMM_INTRNLVO oldALRT_EVT_COMM_INTRNLVO = (ALRT_EVT_COMM_INTRNLVO) genericDAO.selectByPK(alrt_EVT_COMM_INTRNLVO);
	
	/**
	 * Check if Internal Alert Not Activated
	 */
	if(StringUtil.nullEmptyToValue(individualEventCO.getImalInternalAlrtActivate(), IndividualEventConstant.DEACTIVATE).equals(IndividualEventConstant.DEACTIVATE))
	{
	    /**
	     * if there no record already available
	     * then return and no need to update
	     */
	    if(null == oldALRT_EVT_COMM_INTRNLVO) return;
	    
	    alrt_EVT_COMM_INTRNLVO.setACTIVATED_YN(ConstantsCommon.NO);
	    //update the Alrt internal event record
	    genericDAO.update(alrt_EVT_COMM_INTRNLVO);
	    return;
	}
	alrt_EVT_COMM_INTRNLVO.setACTIVATED_YN(ConstantsCommon.YES);
	
	/**
	 * check if there is record in db
	 * then update the record in ALRT_EVT_COMM_INTRNL table
	 */
	if(oldALRT_EVT_COMM_INTRNLVO != null)
	{
	    genericDAO.update(alrt_EVT_COMM_INTRNLVO);
	    return;
	}
	
	/**
	 * insert record in alrt_EVT_COMM_INTRNL 
	 */
	genericDAO.insert(alrt_EVT_COMM_INTRNLVO);
    }
	
	/**
	 * Save Communication Mode Arguments Mapping
	 * @param individualEventCO
	 * @param communicationType
	 * @throws BaseException
	 */
	private void saveAlrtEvtCommModeArgemntsMapping(IndividualEventCO individualEventCO, String communicationType, String templateType) throws BaseException
	{
		AuditRefCO refCO = individualEventCO.getAuditRefCO();
		
	    BigDecimal reportQueryId = null;
		List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allQueryMappingArgumentList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
		// retrieve Email Communication Mapped Arguments
		if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE))
		{
			ALRT_EVT_COMM_MODEVO email_EVT_COMM_MODEVO = individualEventCO.getEmail_EVT_COMM_MODEVO();
			if(email_EVT_COMM_MODEVO != null && email_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
    		{
				if(email_EVT_COMM_MODEVO != null && email_EVT_COMM_MODEVO.getQUERY_ID() != null)
				{
					reportQueryId = email_EVT_COMM_MODEVO.getQUERY_ID();
				}
				allQueryMappingArgumentList = individualEventCO.getAllQueryMappingParameterList();
    		}
			
			else
			{
				if(templateType.equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
				{
					if(email_EVT_COMM_MODEVO != null && email_EVT_COMM_MODEVO.getQUERY_ID() != null)
					{
						reportQueryId = email_EVT_COMM_MODEVO.getQUERY_ID();
						allQueryMappingArgumentList = individualEventCO.getAllQueryMappingParameterList();
					}
				}
				else
				{
					if(email_EVT_COMM_MODEVO != null && email_EVT_COMM_MODEVO.getREPORT_ID() != null)
					{
						reportQueryId = email_EVT_COMM_MODEVO.getREPORT_ID();
						allQueryMappingArgumentList = individualEventCO.getAllReportMappingParameterList();
					}
				}
				
			}
			//allQueryMappingArgumentList = individualEventCO.getAllQueryMappingParameterList();
		}
		// retrieve Sms Communication Mapped Arguments
		else
			if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.SMS_COMMUNICATION_TYPE))
			{
				ALRT_EVT_COMM_MODEVO sms_EVT_COMM_MODEVO = individualEventCO.getSms_EVT_COMM_MODEVO();
				if(sms_EVT_COMM_MODEVO != null && sms_EVT_COMM_MODEVO.getQUERY_ID() != null)
				{
					reportQueryId = sms_EVT_COMM_MODEVO.getQUERY_ID();
				}
				allQueryMappingArgumentList = individualEventCO.getAllSmsQueryMappingParameterList();
			}
		// retrieve omni Communication Mapped Arguments
		else
			if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE))
			{
				ALRT_EVT_COMM_MODEVO oi_EVT_COMM_MODEVO = individualEventCO.getOmniInbox_EVT_COMM_MODEVO();
				if(oi_EVT_COMM_MODEVO != null && oi_EVT_COMM_MODEVO.getQUERY_ID() != null)
				{
					reportQueryId = oi_EVT_COMM_MODEVO.getQUERY_ID();
				}
				allQueryMappingArgumentList = individualEventCO.getAllOmniInboxQueryMappingParameterList();
			}
		
		if(allQueryMappingArgumentList != null && !allQueryMappingArgumentList.isEmpty())
		{
			for(int i=0; i<allQueryMappingArgumentList.size(); i++)
			{
				
				ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO = allQueryMappingArgumentList.get(i);
				
					if(StringUtil.isNotEmpty(alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME()) && (alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME().equals("Select Tag") || 
							alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME().equals("0")))
					{
						alrt_EVT_COMM_MODE_ARG_MAPVO.setMAPPING_TAG_NAME("");
					}
					alrt_EVT_COMM_MODE_ARG_MAPVO.setEVT_ID(individualEventCO.getEvtID());
					alrt_EVT_COMM_MODE_ARG_MAPVO.setCOMMUNICATION_TYPE(communicationType);
					alrt_EVT_COMM_MODE_ARG_MAPVO.setQUERY_REPORT_ID(reportQueryId);
					if(alrt_EVT_COMM_MODE_ARG_MAPVO.getID() != null && !alrt_EVT_COMM_MODE_ARG_MAPVO.getID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
					{
						alrt_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_BY(individualEventCO.getUserID());
						alrt_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
						//update Query mapping arguments
						genericDAO.update(alrt_EVT_COMM_MODE_ARG_MAPVO);
						
					}
					else
					{
						alrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_BY(individualEventCO.getUserID());
						alrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_DATE(individualEventCO.getRunningDate());
						
						//add query mapping arguments
						alertIndividualEventDAO.saveCommunicationModeMappingArguments(alrt_EVT_COMM_MODE_ARG_MAPVO);
						
						//update audit of Message in diffrent languages
						ALRT_EVT_COMM_MODE_ARG_MAPVO newAlrt_EVT_COMM_MODE_ARG_MAPVO = new ALRT_EVT_COMM_MODE_ARG_MAPVO();
						newAlrt_EVT_COMM_MODE_ARG_MAPVO.setEVT_ID(alrt_EVT_COMM_MODE_ARG_MAPVO.getEVT_ID());
						newAlrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_BY(alrt_EVT_COMM_MODE_ARG_MAPVO.getCREATED_BY());
						newAlrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_DATE(alrt_EVT_COMM_MODE_ARG_MAPVO.getCREATED_DATE());
						newAlrt_EVT_COMM_MODE_ARG_MAPVO.setCOMMUNICATION_TYPE(alrt_EVT_COMM_MODE_ARG_MAPVO.getCOMMUNICATION_TYPE());
						newAlrt_EVT_COMM_MODE_ARG_MAPVO.setATTACH_REPORT_ID(null);
						alrt_EVT_COMM_MODE_ARG_MAPVO.setATTACH_REPORT_ID(null);
						auditBO.callAudit(newAlrt_EVT_COMM_MODE_ARG_MAPVO, alrt_EVT_COMM_MODE_ARG_MAPVO, refCO);
					}
			}
		}
	}
	
	/**
	 * Save New Custom Tags
	 * @param individualEventCO
	 * @throws BaseException
	 */
    private void saveNewCustomTags(IndividualEventCO individualEventCO) throws BaseException
    {
    	AuditRefCO refCO = individualEventCO.getAuditRefCO();
    	
		ALRT_EVT_BATCH_ARG_MAPVO alrtEvtBatchArgMapVO;
		IndividualEventSC indEvtsc;
		//Add custom tags list
	    List<ALRT_TAGS_DEFVO> newEmailCustomTagList = individualEventCO.getNewEmailCustomTagList();
	    if(newEmailCustomTagList != null && newEmailCustomTagList.size() > 0)
	    {
	    	for(int i = 0; i < newEmailCustomTagList.size(); i++)
		    {
				ALRT_TAGS_DEFVO alrt_TAGS_DEFVO = newEmailCustomTagList.get(i);
				if(StringUtil.isNotEmpty(alrt_TAGS_DEFVO.getTAG_NAME()))
				{
				    if(alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID() != null
					    && !alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
				    {
				    	ALRT_TAGS_DEFVO oldArt_TAGS_DEFVO = (ALRT_TAGS_DEFVO) genericDAO.selectByPK(alrt_TAGS_DEFVO);
				    	oldArt_TAGS_DEFVO.setTAG_NAME(alrt_TAGS_DEFVO.getTAG_NAME());
				    	genericDAO.update(oldArt_TAGS_DEFVO);
				    }
				    else
				    {
						alrt_TAGS_DEFVO.setIS_CUSTOM_YN(IndividualEventConstant.YES);
						alrt_TAGS_DEFVO.setEVT_ID(individualEventCO.getEvtID());
						alertIndividualEventDAO.saveAlrtTagsDef(alrt_TAGS_DEFVO);
					
						//insert audit of Custom Tags
						auditBO.callAudit(new ALRT_TAGS_DEFVO() , alrt_TAGS_DEFVO, refCO);
				    }
				}
		    }
	    }
		    
	    //delete custom tags list
	    List<ALRT_TAGS_DEFVO> removeEmailCustomTagList = individualEventCO.getDeleteEmailCustomTagList();
	    if(removeEmailCustomTagList != null && removeEmailCustomTagList.size() > 0)
	    {
	    	for(int i = 0; i < removeEmailCustomTagList.size(); i++)
		    {
	    		ALRT_TAGS_DEFVO alrt_TAGS_DEFVO = removeEmailCustomTagList.get(i);
	    		if(alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID() != null
					    && !alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
			{
	    		    ALRT_TAGS_DEFVO oldArt_TAGS_DEFVO = (ALRT_TAGS_DEFVO) genericDAO.selectByPK(alrt_TAGS_DEFVO);
	    		    genericDAO.delete(oldArt_TAGS_DEFVO);
	    			
	    		    //delete audit of Custom Tags
	    		    auditBO.callAudit(alrt_TAGS_DEFVO, new ALRT_TAGS_DEFVO(), refCO);
			}
		    }
	    }
	
		/**
		 * Save sms Custom tags
		 */
		/*if(individualEventCO.getSmsActivate().equals(IndividualEventConstant.ACTIVATE))
		{
		    List<ALRT_TAGS_DEFVO> newSmsCustomTagList = individualEventCO.getNewSmsCustomTagList();
		    for(int i = 0; i < newSmsCustomTagList.size(); i++)
		    {
			ALRT_TAGS_DEFVO alrt_TAGS_DEFVO = newSmsCustomTagList.get(i);
			if(StringUtil.isNotEmpty(alrt_TAGS_DEFVO.getTAG_NAME()))
			{
			    if(alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID() != null
				    && !alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
			    {
				ALRT_TAGS_DEFVO oldArt_TAGS_DEFVO = (ALRT_TAGS_DEFVO) genericDAO.selectByPK(alrt_TAGS_DEFVO);
				oldArt_TAGS_DEFVO.setTAG_NAME(alrt_TAGS_DEFVO.getTAG_NAME());
				genericDAO.update(oldArt_TAGS_DEFVO);
			    }
			    else
			    {
				alrt_TAGS_DEFVO.setIS_CUSTOM_YN("Y");
				alrt_TAGS_DEFVO.setEVT_ID(individualEventCO.getEvtID());
				Integer rows = alertIndividualEventDAO.saveAlrtTagsDef(alrt_TAGS_DEFVO);
			    }
			}
		    }
		}*/
		
		/**
		 * Save Omni Inbox Custom tags
		 */
	/*	if(individualEventCO.getOmniInboxActivate().equals(IndividualEventConstant.ACTIVATE))
		{
		    List<ALRT_TAGS_DEFVO> newOmniInboxCustomTagList = individualEventCO.getNewOmniInboxCustomTagList();
		    for(int i = 0; i < newOmniInboxCustomTagList.size(); i++)
		    {
			ALRT_TAGS_DEFVO alrt_TAGS_DEFVO = newOmniInboxCustomTagList.get(i);
			if(StringUtil.isNotEmpty(alrt_TAGS_DEFVO.getTAG_NAME()))
			{
			    if(alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID() != null
				    && !alrt_TAGS_DEFVO.getALRT_TAGS_DEF_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
			    {
				ALRT_TAGS_DEFVO oldArt_TAGS_DEFVO = (ALRT_TAGS_DEFVO) genericDAO.selectByPK(alrt_TAGS_DEFVO);
				oldArt_TAGS_DEFVO.setTAG_NAME(alrt_TAGS_DEFVO.getTAG_NAME());
				genericDAO.update(oldArt_TAGS_DEFVO);
			    }
			    else
			    {
				alrt_TAGS_DEFVO.setIS_CUSTOM_YN(IndividualEventConstant.YES);
				alrt_TAGS_DEFVO.setEVT_ID(individualEventCO.getEvtID());
				Integer rows = alertIndividualEventDAO.saveAlrtTagsDef(alrt_TAGS_DEFVO);
			    }
			}
		    }
		}*/
	
		if(IndividualEventConstant.BATCH_EVT_TYPE.equals(individualEventCO.getAlrtEvtVO().getEVT_TYPE())&&!individualEventCO.getNewBatchCustomTagList().isEmpty())
		{
		    indEvtsc = new IndividualEventSC();
		    if(!NumberUtil.nullToZero(individualEventCO.getEvtID()).equals(BigDecimal.ZERO))
		    {
				indEvtsc.setEventID(individualEventCO.getEvtID());
				alertIndividualEventDAO.deleteAllBatchArgMap(indEvtsc);
		    }
		    for(int j = 0; j < individualEventCO.getNewBatchCustomTagList().size(); j++)
		    {
				alrtEvtBatchArgMapVO = new ALRT_EVT_BATCH_ARG_MAPVO();
				alrtEvtBatchArgMapVO = individualEventCO.getNewBatchCustomTagList().get(j);
				alrtEvtBatchArgMapVO.setEVT_ID(individualEventCO.getEvtID());
				alrtEvtBatchArgMapVO.setCREATED_BY(individualEventCO.getUserID());
				alrtEvtBatchArgMapVO.setCREATED_DATE(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
				genericDAO.insert(alrtEvtBatchArgMapVO);
				
				//insert Audit of Batch
				ALRT_EVT_BATCH_ARG_MAPVO oldALRT_EVT_BATCH_ARG_MAPVO = new ALRT_EVT_BATCH_ARG_MAPVO();
				oldALRT_EVT_BATCH_ARG_MAPVO.setCREATED_BY(alrtEvtBatchArgMapVO.getCREATED_BY());
				oldALRT_EVT_BATCH_ARG_MAPVO.setCREATED_DATE(alrtEvtBatchArgMapVO.getCREATED_DATE());
				auditBO.callAudit(oldALRT_EVT_BATCH_ARG_MAPVO, alrtEvtBatchArgMapVO, refCO);
		    }
		}
    }
	
	/**
	 * Save Report Attachments
	 * @param individualEventCO
	 */
	private void saveReportAttachments(IndividualEventCO individualEventCO) throws BaseException
	{
		AuditRefCO refCO = individualEventCO.getAuditRefCO();
		/*
		 * Save Report Attachment for Email Communication Type
		 */
		if(individualEventCO.getEmailActivate().equals(IndividualEventConstant.ACTIVATE))
		{
			ALRT_EVT_REPORT_ATTACHVO report_ATTACHVO = new ALRT_EVT_REPORT_ATTACHVO();
			report_ATTACHVO.setCOMMUNICATION_TYPE(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE);
			report_ATTACHVO.setEVT_ID(individualEventCO.getEvtID());
			if(individualEventCO.getEventEmailRemovedReportAttachmentIds() != null && StringUtil.isNotEmpty(individualEventCO.getEventEmailRemovedReportAttachmentIds()))
			{
				//delete reports attachments
				String removeRAIds[] = individualEventCO.getEventEmailRemovedReportAttachmentIds().split(",");
				for(int i=0; i<removeRAIds.length; i++)
				{
					if(StringUtil.isNotEmpty(removeRAIds[i]))
					{
						report_ATTACHVO.setREPORT_ID(new BigDecimal(removeRAIds[i]));
						genericDAO.delete(report_ATTACHVO);
						
						//delete Audit of Report Attachment
						auditBO.callAudit(report_ATTACHVO , new ALRT_EVT_REPORT_ATTACHVO(), refCO);
						
						//Delete Mapped Argument on the time report
						IndividualEventSC individualEventSC = new IndividualEventSC();
						individualEventSC.setEventID(individualEventCO.getEvtID());
						individualEventSC.setEmailCommunicationType(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE);
						individualEventSC.setReportAttachmentId(new BigDecimal(removeRAIds[i]));
						alertIndividualEventDAO.deleteAlrtEventCommModeArgMap(individualEventSC);
					}
				}
			}
			
			if(individualEventCO.getEmailReportArray() != null && individualEventCO.getEmailReportArray().length > 0 )
			{
				for(int i=0; i<individualEventCO.getEmailReportArray().length; i++)
				{
					if(!individualEventCO.getEmailReportArray()[i].equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
					{
						report_ATTACHVO.setREPORT_ID(individualEventCO.getEmailReportArray()[i]);
						ALRT_EVT_REPORT_ATTACHVO oldAeport_ATTACHVO = (ALRT_EVT_REPORT_ATTACHVO) genericDAO.selectByPK(report_ATTACHVO);
						if(oldAeport_ATTACHVO != null)
						{
							report_ATTACHVO.setMODIFIED_BY(individualEventCO.getUserID());
							report_ATTACHVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
							genericDAO.update(report_ATTACHVO);
							
							//update Audit of Report Attachment
							oldAeport_ATTACHVO.setMODIFIED_BY(report_ATTACHVO.getMODIFIED_BY());
							oldAeport_ATTACHVO.setMODIFIED_DATE(report_ATTACHVO.getMODIFIED_DATE());
							auditBO.callAudit(oldAeport_ATTACHVO, report_ATTACHVO, refCO);
						}
						else
						{
							report_ATTACHVO.setCREATED_BY(individualEventCO.getUserID());
							report_ATTACHVO.setCREATED_DATE(individualEventCO.getRunningDate());
							genericDAO.insert(report_ATTACHVO);
							
							//insert Audit of Report Attachment
							ALRT_EVT_REPORT_ATTACHVO oldAlrt_EVT_REPORT_ATTACHVO = new ALRT_EVT_REPORT_ATTACHVO();
							oldAlrt_EVT_REPORT_ATTACHVO.setCREATED_BY(report_ATTACHVO.getCREATED_BY());
							oldAlrt_EVT_REPORT_ATTACHVO.setCREATED_DATE(report_ATTACHVO.getCREATED_DATE());
							oldAlrt_EVT_REPORT_ATTACHVO.setEVT_ID(report_ATTACHVO.getEVT_ID());
							oldAlrt_EVT_REPORT_ATTACHVO.setCOMMUNICATION_TYPE(report_ATTACHVO.getCOMMUNICATION_TYPE());
							auditBO.callAudit(oldAlrt_EVT_REPORT_ATTACHVO, report_ATTACHVO, refCO);
						}
					}
				}
			}
			validateReportAttachmentMappingParameter(individualEventCO, report_ATTACHVO.getCOMMUNICATION_TYPE());
		}
		
	
		
		/*
		 * Save Report Attachment for Omni Inbox  Communication Type
		 */
		if(individualEventCO.getOmniInboxActivate().equals(IndividualEventConstant.ACTIVATE))
		{
			ALRT_EVT_REPORT_ATTACHVO report_ATTACHVO = new ALRT_EVT_REPORT_ATTACHVO();
			report_ATTACHVO.setCOMMUNICATION_TYPE(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE);
			report_ATTACHVO.setEVT_ID(individualEventCO.getEvtID());
			if(individualEventCO.getEventOmniRemovedReportAttachmentIds() != null && StringUtil.isNotEmpty(individualEventCO.getEventOmniRemovedReportAttachmentIds()))
			{
				//delete reports attachments
				String removeRAIds[] = individualEventCO.getEventOmniRemovedReportAttachmentIds().split(",");
				for(int i=0; i<removeRAIds.length; i++)
				{
					if(StringUtil.isNotEmpty(removeRAIds[i]))
					{
						report_ATTACHVO.setREPORT_ID(new BigDecimal(removeRAIds[i]));
						genericDAO.delete(report_ATTACHVO);
						
						//delete Audit of Report Attachment
						auditBO.callAudit(report_ATTACHVO , new ALRT_EVT_REPORT_ATTACHVO(), refCO);
						
						//Delete Mapped Argument on the time report
						IndividualEventSC individualEventSC = new IndividualEventSC();
						individualEventSC.setEventID(individualEventCO.getEvtID());
						individualEventSC.setEmailCommunicationType(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE);
						individualEventSC.setReportAttachmentId(new BigDecimal(removeRAIds[i]));
						alertIndividualEventDAO.deleteAlrtEventCommModeArgMap(individualEventSC);
					}
				}
			}
			
			if(individualEventCO.getOmniReportArray() != null && individualEventCO.getOmniReportArray().length > 0 )
			{
				for(int i=0; i<individualEventCO.getOmniReportArray().length; i++)
				{
					if(!individualEventCO.getOmniReportArray()[i].equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
					{
						report_ATTACHVO.setREPORT_ID(individualEventCO.getOmniReportArray()[i]);
						ALRT_EVT_REPORT_ATTACHVO oldAeport_ATTACHVO = (ALRT_EVT_REPORT_ATTACHVO) genericDAO.selectByPK(report_ATTACHVO);
						if(oldAeport_ATTACHVO != null)
						{
							report_ATTACHVO.setMODIFIED_BY(individualEventCO.getUserID());
							report_ATTACHVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
							genericDAO.update(report_ATTACHVO);
							
							//update Audit of Report Attachment
							oldAeport_ATTACHVO.setMODIFIED_BY(report_ATTACHVO.getMODIFIED_BY());
							oldAeport_ATTACHVO.setMODIFIED_DATE(report_ATTACHVO.getMODIFIED_DATE());
							auditBO.callAudit(oldAeport_ATTACHVO, report_ATTACHVO, refCO);
						}
						else
						{
							report_ATTACHVO.setCREATED_BY(individualEventCO.getUserID());
							report_ATTACHVO.setCREATED_DATE(individualEventCO.getRunningDate());
							genericDAO.insert(report_ATTACHVO);
							
							//insert Audit of Report Attachment
							ALRT_EVT_REPORT_ATTACHVO oldAlrt_EVT_REPORT_ATTACHVO = new ALRT_EVT_REPORT_ATTACHVO();
							oldAlrt_EVT_REPORT_ATTACHVO.setCREATED_BY(report_ATTACHVO.getCREATED_BY());
							oldAlrt_EVT_REPORT_ATTACHVO.setCREATED_DATE(report_ATTACHVO.getCREATED_DATE());
							oldAlrt_EVT_REPORT_ATTACHVO.setEVT_ID(report_ATTACHVO.getEVT_ID());
							oldAlrt_EVT_REPORT_ATTACHVO.setCOMMUNICATION_TYPE(report_ATTACHVO.getCOMMUNICATION_TYPE());
							auditBO.callAudit(oldAlrt_EVT_REPORT_ATTACHVO, report_ATTACHVO, refCO);
						}
					}
				}
			}
			validateReportAttachmentMappingParameter(individualEventCO, report_ATTACHVO.getCOMMUNICATION_TYPE());
		}
	}
	
	/**
	 * Save Report Attachments Mapping Parameters
	 */
	private void validateReportAttachmentMappingParameter(IndividualEventCO individualEventCO, String communicationType)  throws BaseException
	{
//		List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allQueryMappingArgumentList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
		Map<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>> map = new HashMap<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>>();
		// retrieve Email Communication Mapped Arguments
		map = individualEventCO.getAlrt_EVT_COMM_MODE_ARG_MAPVOs();
		List<ALRT_EVT_COMM_MODE_ARG_MAPVO> alrt_EVT_COMM_MODE_ARG_MAPVOs = null;
		
		/**
		 * retrieve Email report attachment mapping parameters
		 */
		if(null != individualEventCO.getEmailReportAttachementParameterArray() && individualEventCO.getEmailReportAttachementParameterArray().length > 0)
		{
			for(int i=0; i<individualEventCO.getEmailReportAttachementParameterArray().length; i++)
			{
				if(StringUtil.isNotEmpty(individualEventCO.getEmailReportAttachementParameterArray()[i]))
	    	    {
					if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE))
					{
						alrt_EVT_COMM_MODE_ARG_MAPVOs = map.get("emailRA_"+i);
					}
					saveReportAttachmentMappingParameter(alrt_EVT_COMM_MODE_ARG_MAPVOs,individualEventCO, communicationType);
	    	    }
			}
		}
		
		
		/**
		 * retrieve omni inbox report attachment mapping parameters
		 * Disabled for Omni Push Notification 
		 */
		if(null != individualEventCO.getOmniReportAttachementParameterArray() && individualEventCO.getOmniReportAttachementParameterArray().length > 0)
		{
			for(int i=0; i<individualEventCO.getOmniReportAttachementParameterArray().length; i++)
			{
				if(StringUtil.isNotEmpty(individualEventCO.getOmniReportAttachementParameterArray()[i]))
	    	    {
					if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE))
					{
						alrt_EVT_COMM_MODE_ARG_MAPVOs = map.get("omniInboxRA_"+i);
					}
					saveReportAttachmentMappingParameter(alrt_EVT_COMM_MODE_ARG_MAPVOs,individualEventCO, communicationType);
	    	    }
			}
		}

		
		
		/*for(int i=0; i<map.size(); i++)
		{
			if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.EMAIL_COMMUNICATION_TYPE))
			{
				alrt_EVT_COMM_MODE_ARG_MAPVOs = map.get("emailRA_"+i);
			}
			else
			if(StringUtil.isNotEmpty(communicationType) && communicationType.equals(IndividualEventConstant.OMNI_INBOX_COMMUNICATION_TYPE))
			{
				alrt_EVT_COMM_MODE_ARG_MAPVOs = map.get("omniInboxRA_"+i);
			}
			saveReportAttachmentMappingParameter(alrt_EVT_COMM_MODE_ARG_MAPVOs,individualEventCO, communicationType);
		}*/
	}
	
	/**
	 * 
	 * @param alrt_EVT_COMM_MODE_ARG_MAPVOs
	 * @param individualEventCO
	 * @param communicationType
	 * @throws DAOException
	 */
	private void saveReportAttachmentMappingParameter( List<ALRT_EVT_COMM_MODE_ARG_MAPVO> alrt_EVT_COMM_MODE_ARG_MAPVOs, 
			IndividualEventCO individualEventCO, String communicationType) throws BaseException
	{
		AuditRefCO refCO = individualEventCO.getAuditRefCO();
		
		if(alrt_EVT_COMM_MODE_ARG_MAPVOs != null && !alrt_EVT_COMM_MODE_ARG_MAPVOs.isEmpty())
		{
			for(int i=0; i<alrt_EVT_COMM_MODE_ARG_MAPVOs.size(); i++)
			{
				ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO = alrt_EVT_COMM_MODE_ARG_MAPVOs.get(i);
				
				if(StringUtil.isNotEmpty(alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME()) && (alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME().equals("Select Tag") || 
						alrt_EVT_COMM_MODE_ARG_MAPVO.getMAPPING_TAG_NAME().equals("0")))
				{
					alrt_EVT_COMM_MODE_ARG_MAPVO.setMAPPING_TAG_NAME("");
				}
				alrt_EVT_COMM_MODE_ARG_MAPVO.setEVT_ID(individualEventCO.getEvtID());
				alrt_EVT_COMM_MODE_ARG_MAPVO.setCOMMUNICATION_TYPE(communicationType);
				
				if(alrt_EVT_COMM_MODE_ARG_MAPVO.getID() != null && !alrt_EVT_COMM_MODE_ARG_MAPVO.getID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
				{
					alrt_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_BY(individualEventCO.getUserID());
					alrt_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_DATE(individualEventCO.getRunningDate());
					//update Query mapping arguments
					genericDAO.update(alrt_EVT_COMM_MODE_ARG_MAPVO);
					
				}
				else
				{
					alrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_BY(individualEventCO.getUserID());
					alrt_EVT_COMM_MODE_ARG_MAPVO.setCREATED_DATE(individualEventCO.getRunningDate());
					//add query mapping arguments
					alertIndividualEventDAO.saveCommunicationModeMappingArguments(alrt_EVT_COMM_MODE_ARG_MAPVO);
					
					//update Audit of Report Attachment
					ALRT_EVT_COMM_MODE_ARG_MAPVO oldALRT_EVT_COMM_MODE_ARG_MAPVO = new ALRT_EVT_COMM_MODE_ARG_MAPVO();
					
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setEVT_ID(alrt_EVT_COMM_MODE_ARG_MAPVO.getEVT_ID());
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setCOMMUNICATION_TYPE(alrt_EVT_COMM_MODE_ARG_MAPVO.getCOMMUNICATION_TYPE());
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setCREATED_BY(alrt_EVT_COMM_MODE_ARG_MAPVO.getCREATED_BY());
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setCREATED_DATE(alrt_EVT_COMM_MODE_ARG_MAPVO.getCREATED_DATE());
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_BY(alrt_EVT_COMM_MODE_ARG_MAPVO.getMODIFIED_BY());
					oldALRT_EVT_COMM_MODE_ARG_MAPVO.setMODIFIED_DATE(alrt_EVT_COMM_MODE_ARG_MAPVO.getMODIFIED_DATE());
					auditBO.callAudit(oldALRT_EVT_COMM_MODE_ARG_MAPVO, alrt_EVT_COMM_MODE_ARG_MAPVO, refCO);
				}
			}
		}
	}
	
	@Override
	public IndividualEventCO validateFixedEventValue(IndividualEventCO individualEventCO)  throws BaseException
	{
		List<IndFixedParamListCO> fixedParamListCOs =  individualEventCO.getParamList();
		IndFixedParamListCO indFixedParamListCO = null;
		if(fixedParamListCOs != null && fixedParamListCOs.size() > 0)
		{
			for(int i=0; i<fixedParamListCOs.size(); i++)
			{
				indFixedParamListCO = checkFixedNumericAndVarcharValues(fixedParamListCOs.get(i));
				individualEventCO.setIndFixedParamListCO(indFixedParamListCO);
			};
			return individualEventCO;
		}
		else
		{
			indFixedParamListCO =  individualEventCO.getIndFixedParamListCO();
			indFixedParamListCO = checkFixedNumericAndVarcharValues(indFixedParamListCO);
			individualEventCO.setIndFixedParamListCO(indFixedParamListCO);
			return individualEventCO;
		}
	}
	
	/**
	 * CHECK VARCHAR AND NUMERIC VALUES
	 * @param indFixedParamListCO
	 * @return
	 * @throws BOException 
	 */
	private IndFixedParamListCO checkFixedNumericAndVarcharValues(IndFixedParamListCO indFixedParamListCO) throws BaseException
	{
		String numericRegex = "^[-]?((\\d+(\\.\\d*)?)|(\\.\\d+))$";
		//String numberCommaSepratedRegix = "[1-9][\\,\\d]*(,\\d+)?$";
		String numberCommaSepratedRegix = "^([(][-]?(0|[1-9]\\d*)(\\.\\d+)?(\\,[-]?(0|[1-9]\\d*)(\\.\\d+)?)*[)])$";
		
		String normalTextRegix= "^((')([0-9a-zA-Z_ ]*)(')*)$";
		String alphabetsCommaSepratedRegix = "^([(](')([0-9a-zA-Z_ ]*)(')([,](')[0-9a-zA-Z_ ]*('))*)[)]$";
		
		
		String key = null;
		if(indFixedParamListCO != null && StringUtil.isNotEmpty(indFixedParamListCO.getPARAM_VALUE()))
		{
			//check if Operator type is empty
			if(StringUtil.nullToEmpty(indFixedParamListCO.getOPERATOR_TYPE()).equals("0") ) return indFixedParamListCO;
			
			/**
			 * check if parameter type is numeric
			 */
			if(StringUtil.nullToEmpty(indFixedParamListCO.getPARAM_COLUMN_TYPE()).equalsIgnoreCase(IndividualEventConstant.NUMERIC))
			{
				if(StringUtil.nullToEmpty(indFixedParamListCO.getOPERATOR_TYPE()).equals(IndividualEventConstant.IN) || 
						StringUtil.nullToEmpty(indFixedParamListCO.getOPERATOR_TYPE()).equals(IndividualEventConstant.NOT_IN) )
				{
					if(!indFixedParamListCO.getPARAM_VALUE().matches(numberCommaSepratedRegix))
					{
						key = "invalid_comma_separated_numeric_value_key";
					}
				}
				else
				{
					if(!indFixedParamListCO.getPARAM_VALUE().matches(numericRegex))
					{
						key = "invalid_numeric_value_key";
					}
				}
				
			}
			/**
			 * Check if parameter type is varchar
			 */
			else if(StringUtil.nullToEmpty(indFixedParamListCO.getPARAM_COLUMN_TYPE()).equalsIgnoreCase(IndividualEventConstant.VARCHAR))
			{
				if(StringUtil.nullToEmpty(indFixedParamListCO.getOPERATOR_TYPE()).equals(IndividualEventConstant.IN) || 
						StringUtil.nullToEmpty(indFixedParamListCO.getOPERATOR_TYPE()).equals(IndividualEventConstant.NOT_IN) )
				{
					if(!indFixedParamListCO.getPARAM_VALUE().matches(alphabetsCommaSepratedRegix))
					{
						key = "invalid_comma_separated_varchar_value_key";
					}
				}
				else
				{
					if(!indFixedParamListCO.getPARAM_VALUE().matches(normalTextRegix))
					{
						key = "invalid_varchar_value_key";
					}
				}
			}
			if(key != null)
			{
			    throw new BOException(MessageCodes.INVALID_MISSING, new String[]{key});
			}
		}
		return indFixedParamListCO;
	}
	
	public IndividualEventCO continueUpdateAfterValidation(ArrayList<AlrtTagsCO> tagsList, IndividualEventCO individualEventCO, String sLanguage,
			String userName, IndividualEventSC criteria) throws BaseException 
	{
		return individualEventCO;
	}

	public IndividualEventCO continueUpdateSuspenseValidation(ArrayList<AlrtTagsCO> tagsList,
			/*ArrayList<IndFixedParamListCO> paramList,*/ IndividualEventCO individualEventCO, String sLanguage,
			String userName) throws BaseException {

		boolean lbUpdate = false;
//		AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();

		if ((null == individualEventCO.getAlrtEvtVO().getSTATUS())
				|| (individualEventCO.getAlrtEvtVO().getSTATUS().isEmpty())) {
			individualEventCO.getAlrtEvtVO().setCREATED_BY(userName);
			individualEventCO.getAlrtEvtVO().setDATE_CREATED(commonLibBO.returnSystemDateWithTime());
			individualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_NEW);
		} else {
			lbUpdate = true;
			individualEventCO.getAlrtEvtVO().setMODIFIED_BY(userName);
			individualEventCO.getAlrtEvtVO().setDATE_MODIFIED(commonLibBO.returnSystemDateWithTime());
		}

		if (AlertConstant.CRUD_F.equals(individualEventCO.getIvCrud())) {
			individualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_NEW);
		}

		NumberUtil.resetEmptyValues(individualEventCO.getAlrtEvtVO());
		individualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_NEW);
		if (lbUpdate == true) {
			Integer row = genericDAO.update(individualEventCO.getAlrtEvtVO());
			if (row == null || row < 1) {
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			if (AlertConstant.TYPE_EVT_F.equals(individualEventCO.getAlrtEvtVO().getEVT_TYPE())
					&& (!(AlertConstant.Fixed_EVT_O).equals(individualEventCO.getAlrtEvtVO().getFIXED_EVENT_ID()))&& individualEventCO.getAlrtEvtVO().getFIXED_EVENT_ID().compareTo(new BigDecimal(9)) != 0)/*REQ-3: Channels Services Fixed Event Type - R14.1*/{
				//delete all record related to this event ID in case the old fix event id = 9
				if(individualEventCO.getOldFixedEvent().compareTo(new BigDecimal(9)) == 0)
				{
					alertIndividualEventDAO.deleteAllEventParamSet(individualEventCO);
				}
			}
		} else {
			Integer row = genericDAO.insert(individualEventCO.getAlrtEvtVO());
			if (row == null || row < 1) {
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
		}

		if (StringUtil.nullToEmpty(individualEventCO.getAlrtEvtVO().getMODIFIED_BY()).isEmpty()) {
			auditBO.callAudit(null, individualEventCO.getAlrtEvtVO(), individualEventCO.getAuditRefCO());
		} else {
			IndividualEventCO oldindividualEventCO = (IndividualEventCO) individualEventCO.getAuditObj();
			oldindividualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_NEW);
			oldindividualEventCO.getAlrtEvtVO().setDATE_CREATED(individualEventCO.getAlrtEvtVO().getDATE_CREATED());
			auditBO.callAudit(oldindividualEventCO.getAlrtEvtVO(), individualEventCO.getAlrtEvtVO(),
					individualEventCO.getAuditRefCO());
		}
		auditBO.insertAudit(individualEventCO.getAuditRefCO());

		return individualEventCO;
	}

	public IndividualEventCO deleteIndEvent(IndividualEventCO individualEventCO) throws BaseException 
	{
		IndividualEventSC criteria = new IndividualEventSC();
		criteria.getAlrtEvtVO().setEVT_ID(individualEventCO.getAlrtEvtVO().getEVT_ID());
		//int count = alertIndividualEventDAO.relatedSubCount(criteria);

		if (ConstantsCommon.ZERO.equals(individualEventCO.getAlrtEvtVO().getSUSPENDED())) {
			individualEventCO.getAlrtEvtVO().setSUSPENDED(IndividualEventConstant.NO);
		} else {
			individualEventCO.getAlrtEvtVO().setSUSPENDED(IndividualEventConstant.YES);
		}

		/*if ((!BigDecimal.ZERO.equals(count))
				&& (AlertConstant.NOTSUSPENDED.equals(individualEventCO.getAlrtEvtVO().getSUSPENDED()))) {
			individualEventCO.setCheckFlag(true);
		} else {
			individualEventCO.setCheckFlag(false);
		}*/
		return individualEventCO;
	}

	public void checkSubEvt(IndividualEventCO individualEventCO, String sLanguage, String userName)
			throws BaseException {
		List<ALRT_EVT_GRPVO> evtGroupList;
		List<ALRT_EVT_PKGVOKey> evtPackageList;
//		ALRT_SUBSCRIPTION_PARAMVO AlrtSubParam = new ALRT_SUBSCRIPTION_PARAMVO();

		if (ConstantsCommon.ZERO.equals(individualEventCO.getAlrtEvtVO().getSUSPENDED())) {
			individualEventCO.getAlrtEvtVO().setSUSPENDED(IndividualEventConstant.NO);
		} else {
			individualEventCO.getAlrtEvtVO().setSUSPENDED(IndividualEventConstant.YES);
		}

		evtGroupList = alertIndividualEventDAO.returnEventByGrpId(individualEventCO);

		alertIndividualEventDAO.deleteSbtParam(individualEventCO);
		if (!(evtGroupList == null)) {
			for (int i = 0; i < evtGroupList.size(); i++) {
				individualEventCO.getAlrtSubEvtVO().setREL_ID(evtGroupList.get(i).getLINE_NO());
				individualEventCO.getAlrtSubEvtVO().setREL_TYPE(AlertConstant.EVENT_GROUP);
				alertIndividualEventDAO.updateSubEvt(individualEventCO);
				individualEventCO.getAlrtSubEvtVO().setDELETED_BY(userName);
				individualEventCO.getAlrtSubEvtVO().setDATE_DELETED(commonLibBO.returnSystemDateWithTime());

				individualEventCO.getAlrtEvtGrpVO().setLINE_NO(evtGroupList.get(i).getLINE_NO());
				alertIndividualEventDAO.updateGrpEvt(individualEventCO);
				individualEventCO.getAlrtEvtGrpVO().setDELETED_BY(userName);
				individualEventCO.getAlrtEvtGrpVO().setDATE_DELETED(commonLibBO.returnSystemDateWithTime());
			}
		}

		evtPackageList = alertIndividualEventDAO.returnEventByPkgId(individualEventCO);
		if (!(evtPackageList == null)) {
			for (int i = 0; i < evtPackageList.size(); i++) {
				individualEventCO.setEvtID(evtPackageList.get(i).getEVT_ID());
				individualEventCO.setPkgID(evtPackageList.get(i).getPKG_ID());
				individualEventCO.setRelType(AlertConstant.SUB_PARAM);
				alertIndividualEventDAO.deleteSubParam(individualEventCO);

				individualEventCO.setRelType(AlertConstant.GROUP_PACKAGE);
				alertIndividualEventDAO.deleteSubParam(individualEventCO);

				individualEventCO.setRelType(AlertConstant.SUB_PARAM);
				alertIndividualEventDAO.deleteSubEvt(individualEventCO);

				individualEventCO.setRelType(AlertConstant.GROUP_PACKAGE);
				alertIndividualEventDAO.deleteSubEvt(individualEventCO);

				alertIndividualEventDAO.deleteEvtPkg(individualEventCO);

				alertIndividualEventDAO.updateSubEvt(individualEventCO);
				individualEventCO.getAlrtSubEvtVO().setDELETED_BY(userName);
				individualEventCO.getAlrtSubEvtVO().setDATE_DELETED(commonLibBO.returnSystemDateWithTime());
			}
		}

		individualEventCO.setRelType(AlertConstant.SE);
		alertIndividualEventDAO.deleteSubEvtSE(individualEventCO);

		NumberUtil.resetEmptyValues(individualEventCO.getAlrtEvtVO());

		individualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_DELETED);
		individualEventCO.getAlrtEvtVO().setDELETED_BY(userName);
		individualEventCO.getAlrtEvtVO().setDATE_DELETED(commonLibBO.returnSystemDateWithTime());

		Integer row = genericDAO.update(individualEventCO.getAlrtEvtVO());
		if (row == null || row < 1) {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		IndividualEventCO oldindividualEventCO = (IndividualEventCO) individualEventCO.getAuditObj();
		oldindividualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_NEW);
		oldindividualEventCO.getAlrtEvtVO().setDATE_MODIFIED(individualEventCO.getAlrtEvtVO().getDATE_MODIFIED());
		oldindividualEventCO.getAlrtEvtVO().setDATE_CREATED(individualEventCO.getAlrtEvtVO().getDATE_CREATED());
		auditBO.callAudit(oldindividualEventCO.getAlrtEvtVO(), individualEventCO.getAlrtEvtVO(),
				individualEventCO.getAuditRefCO());
		auditBO.insertAudit(individualEventCO.getAuditRefCO());

	}

	@Override
	public IndividualEventCO returnIndividualEventByEventId(IndividualEventSC indEventSC) throws BaseException 
	{
	    List<ALRT_EVT_BATCH_ARG_MAPVO> alrtEvtBatchArgMapVOList;
		IndividualEventCO individualEventCO = alertIndividualEventDAO.returnIndividualEventByEventId(indEventSC);
		
		if(null == individualEventCO) return individualEventCO;
		
		individualEventCO.setEmailEventStaticReportAttachCount(new BigDecimal(1));
		individualEventCO.setOmniInboxEventStaticReportAttachCount(new BigDecimal(1));
		//batch
		if(!NumberUtil.isEmptyDecimal(individualEventCO.getAlrtEvtVO().getREPORT_ID()))
		{
		    IndividualEventSC individualEventSC = new IndividualEventSC();
		    alrtEvtBatchArgMapVOList = new ArrayList<ALRT_EVT_BATCH_ARG_MAPVO>();
		    
		    individualEventSC.setQueryId(individualEventCO.getAlrtEvtVO().getREPORT_ID());
		    individualEventSC.setEventType(individualEventCO.getAlrtEvtVO().getEVT_TYPE());
		    individualEventSC.setEventID(individualEventCO.getAlrtEvtVO().getEVT_ID());
		    try
			{
		    	IndividualEventCO individualBatchEventCO =  returnQueryDetailsById(individualEventSC);
		    	individualEventCO.setBatchQueryColumnListJson(individualBatchEventCO.getBatchQueryColumnListJson());
				individualEventCO.setBatchQueryBriefDescription(individualBatchEventCO.getBatchQueryBriefDescription());
			}
			catch(Exception ex)
			{
				individualEventCO.getAlrtEvtVO().setREPORT_ID(null);
				log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
			}
		    alrtEvtBatchArgMapVOList = alertIndividualEventDAO.returnAlrtEvtBatchArg(individualEventSC);
		    if(!alrtEvtBatchArgMapVOList.isEmpty())
		    {
			try
			{
			    individualEventCO.setBatchQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrtEvtBatchArgMapVOList, null, null, false, true)).concat("}"));
			}
			catch(JSONException e)
			{
			    log.error("Error in serializing batch Query Parameters inside individualEventBoImpl "+e.getMessage());
			    throw new BaseException(e);
			}
		    }
			individualEventCO.setBatchTypeQueryCol(individualEventCO.getAlrtEvtVO().getBATCH_TYPE_QUERY_COL());
		   
		}
			
		//Event Email Communication Type
		ALRT_EVT_COMM_MODEVO emailAlrt_EVT_COMM_MODEVO = individualEventCO.getEmail_EVT_COMM_MODEVO();
		List<IndividualEventReportAttachmentCO> emailEventReportAttachmentCOs = individualEventCO.getEmailEventReportAttachmentCOs();
		if(emailAlrt_EVT_COMM_MODEVO != null)
		{
			individualEventCO.setEmailQueryId(emailAlrt_EVT_COMM_MODEVO.getQUERY_ID());
			//get all arguments of Email Communication Mode
			//List<ALRT_EVT_COMM_MODE_ARG_MAPVO> emailAlrt_EVT_COMM_MODE_ARG_MAPVOs = individualEventCO.getEmailAlrt_EVT_COMM_MODE_ARG_MAPVOs();
			if(emailAlrt_EVT_COMM_MODEVO.getACTIVATED_YN().equals(IndividualEventConstant.YES))
			{
				individualEventCO.setEmailActivate(IndividualEventConstant.ACTIVATE);
			}
			else
			{
				individualEventCO.setEmailActivate(IndividualEventConstant.DEACTIVATE);
			}
			
			/**
			 * Set Report Attachments
			 */
			if(emailEventReportAttachmentCOs != null && emailEventReportAttachmentCOs.size() > 0)
			{
				List<IndividualEventReportAttachmentCO> eventEmailReportAttachmentCOs = new  ArrayList<IndividualEventReportAttachmentCO>();
				for(int i=0; i<emailEventReportAttachmentCOs.size(); i++)
				{
					IndividualEventReportAttachmentCO individualEventReportAttachmentCO = emailEventReportAttachmentCOs .get(i);
					// return Attachment Report Details From Reporting through RMI
					indEventSC.setReportId(individualEventReportAttachmentCO.getReportId());
					IndividualEventCO individualEventCO2 = returnReportDetailsById(indEventSC);
					String reportName = individualEventCO2.getIrp_AD_HOC_REPORTCO().getREPORT_NAME();

					if(!StringUtil.isEmptyString(reportName))
					{
						individualEventReportAttachmentCO.setReportDescription(reportName);
						individualEventReportAttachmentCO.setReportAttachmentStatus(IndividualEventConstant.REPORT_ATTACH_STATUS_OLD);
						eventEmailReportAttachmentCOs.add(i, individualEventReportAttachmentCO);
					}
				}
				

				individualEventCO.setEmailEventReportAttachmentCOs(eventEmailReportAttachmentCOs);
				individualEventCO.setEmailEventStaticReportAttachCount(new BigDecimal(emailEventReportAttachmentCOs.size()));
			}
		
			if(emailAlrt_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals(IndividualEventConstant.STATIC_TEMPLATE_TYPE))
			{
				//get email query details from reporting application through RMI
				IndividualEventSC individualEventSC = new IndividualEventSC();
				if(!NumberUtil.isEmptyDecimal(emailAlrt_EVT_COMM_MODEVO.getQUERY_ID()))
				{
					individualEventSC.setQueryId(emailAlrt_EVT_COMM_MODEVO.getQUERY_ID());
					try
					{
						IndividualEventCO individualEventCO2 =  returnQueryDetailsById(individualEventSC);
						individualEventCO.setEmailQueryColumnListJson(individualEventCO2.getEmailQueryColumnListJson());
						individualEventCO.setEmailQueryBriefDescription(individualEventCO2.getIrp_AD_HOC_QUERYCO().getQUERY_NAME());
					}
					catch(Exception ex)
					{
						emailAlrt_EVT_COMM_MODEVO.setQUERY_ID(null);
						log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
					}
				}
			}
			else if(emailAlrt_EVT_COMM_MODEVO.getTEMPLATE_TYPE().equals(IndividualEventConstant.DYNAMIC_TEMPLATE_TYPE))
			{
				//get email query details from reporting application through RMI
				IndividualEventSC individualEventSC = new IndividualEventSC();
				
				individualEventCO.setEmail_Report_EVT_COMM_MODEVO(emailAlrt_EVT_COMM_MODEVO);
				if(!NumberUtil.isEmptyDecimal(emailAlrt_EVT_COMM_MODEVO.getREPORT_ID()))
				{
					// return Report Details From Reporting through RMI
					indEventSC.setReportId(emailAlrt_EVT_COMM_MODEVO.getREPORT_ID());
					try
					{
						IndividualEventCO individualEventCO2 = returnReportDetailsById(indEventSC);
						String reportName = individualEventCO2.getIrp_AD_HOC_REPORTCO().getREPORT_NAME();
						individualEventCO.setEmailReportBriefDescription(reportName);
					}
					catch(Exception ex)
					{
						emailAlrt_EVT_COMM_MODEVO.setREPORT_ID(null);
						log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
					}
					
					if(!NumberUtil.isEmptyDecimal(emailAlrt_EVT_COMM_MODEVO.getQUERY_ID()))
					{
						individualEventSC.setQueryId(emailAlrt_EVT_COMM_MODEVO.getQUERY_ID());
						try
						{
							IndividualEventCO individualEventCO3 =  returnQueryDetailsById(individualEventSC);
							individualEventCO.setEmailQueryColumnListJson(individualEventCO3.getEmailQueryColumnListJson());
							individualEventCO.setEmailQueryBriefDescription(individualEventCO3.getIrp_AD_HOC_QUERYCO().getQUERY_NAME());
						}
						catch(Exception ex)
						{
							emailAlrt_EVT_COMM_MODEVO.setQUERY_ID(null);
							log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
						}
					}
					emailAlrt_EVT_COMM_MODEVO.setDEFAULT_MESSAGE_BODY("");
				}
			}
		}
		else
		{
			emailAlrt_EVT_COMM_MODEVO = new ALRT_EVT_COMM_MODEVO();
			emailAlrt_EVT_COMM_MODEVO.setTEMPLATE_TYPE(IndividualEventConstant.STATIC_TEMPLATE_TYPE);
			individualEventCO.setEmail_EVT_COMM_MODEVO(emailAlrt_EVT_COMM_MODEVO);
		}
		
		//Set Sms Communication Type Details
		ALRT_EVT_REPORT_ATTACHVO smsAlrt_EVT_REPORT_ATTACHVO = individualEventCO.getSmsALRT_EVT_REPORT_ATTACHVO();
		ALRT_EVT_COMM_MODEVO smsAlrt_EVT_COMM_MODEVO = individualEventCO.getSms_EVT_COMM_MODEVO();
		if(smsAlrt_EVT_COMM_MODEVO != null)
		{
			if(smsAlrt_EVT_REPORT_ATTACHVO != null && !smsAlrt_EVT_REPORT_ATTACHVO.getREPORT_ID().equals(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE))
			{
				// return Sms Attachment Report Details From Reporting through RMI
				indEventSC.setReportId(smsAlrt_EVT_REPORT_ATTACHVO.getREPORT_ID());
				try
				{
					IndividualEventCO individualEventCO2 = returnReportDetailsById(indEventSC);
					String reportName = individualEventCO2.getIrp_AD_HOC_REPORTCO().getREPORT_NAME();
					individualEventCO.setSmsReportAttachmentBriefDescription(reportName);
				}
				catch(Exception ex)
				{
					smsAlrt_EVT_REPORT_ATTACHVO.setREPORT_ID(null);
					log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
				}
			}
			
						
			if(smsAlrt_EVT_COMM_MODEVO.getACTIVATED_YN().equals(IndividualEventConstant.YES))
			{
				individualEventCO.setSmsActivate(IndividualEventConstant.ACTIVATE);
			}
			else
			{
				individualEventCO.setSmsActivate(IndividualEventConstant.DEACTIVATE);
			}
			
			//get all arguments of Sms Communication Mode
			
			//get Sms query details from reporting application through RMI
			IndividualEventSC individualEventSC = new IndividualEventSC();
			if(!NumberUtil.isEmptyDecimal(smsAlrt_EVT_COMM_MODEVO.getQUERY_ID()))
			{
				individualEventSC.setQueryId(smsAlrt_EVT_COMM_MODEVO.getQUERY_ID());
				try
				{
					IndividualEventCO individualEventCO2 =  returnQueryDetailsById(individualEventSC);
					individualEventCO.setSmsQueryColumnListJson(individualEventCO2.getEmailQueryColumnListJson());
					individualEventCO.setSmsQueryBriefDescription(individualEventCO2.getIrp_AD_HOC_QUERYCO().getQUERY_NAME());
				}
				catch(Exception ex)
				{
					smsAlrt_EVT_COMM_MODEVO.setQUERY_ID(null);
					log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
				}
			}
		}
		
		
		//Set omni inbox Communication Type Details
		List<IndividualEventReportAttachmentCO> omniEventReportAttachmentCOs = individualEventCO.getOmniEventReportAttachmentCOs();
		
		ALRT_EVT_COMM_MODEVO omniInboxAlrt_EVT_COMM_MODEVO = individualEventCO.getOmniInbox_EVT_COMM_MODEVO();
		if(omniInboxAlrt_EVT_COMM_MODEVO != null)
		{
		
			if(omniInboxAlrt_EVT_COMM_MODEVO.getACTIVATED_YN().equals(IndividualEventConstant.YES))
			{
				individualEventCO.setOmniInboxActivate(IndividualEventConstant.ACTIVATE);
			}
			else
			{
				individualEventCO.setOmniInboxActivate(IndividualEventConstant.DEACTIVATE);
			}
			
			/**
			 * Set Report Attachments
			 */
			if(omniEventReportAttachmentCOs != null && omniEventReportAttachmentCOs.size() > 0)
			{
				List<IndividualEventReportAttachmentCO> eventOmniReportAttachmentCOs =new ArrayList<IndividualEventReportAttachmentCO>();
				for(int i=0; i<omniEventReportAttachmentCOs.size(); i++)
				{
					IndividualEventReportAttachmentCO individualEventReportAttachmentCO = omniEventReportAttachmentCOs .get(i);
					// return Attachment Report Details From Reporting through RMI
					indEventSC.setReportId(individualEventReportAttachmentCO.getReportId());
					try
					{
						IndividualEventCO individualEventCO2 = returnReportDetailsById(indEventSC);
						String reportName = individualEventCO2.getIrp_AD_HOC_REPORTCO().getREPORT_NAME();
						if(StringUtil.isNotEmpty(reportName))
						{
							individualEventReportAttachmentCO.setReportDescription(reportName);
							individualEventReportAttachmentCO.setReportAttachmentStatus(IndividualEventConstant.REPORT_ATTACH_STATUS_OLD);
							omniEventReportAttachmentCOs.remove(i);
							eventOmniReportAttachmentCOs.add(i, individualEventReportAttachmentCO);
						}
					}
					catch(Exception ex)
					{
						log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
					}
				}
				individualEventCO.setOmniEventReportAttachmentCOs(eventOmniReportAttachmentCOs);
				individualEventCO.setOmniInboxEventStaticReportAttachCount(new BigDecimal(omniEventReportAttachmentCOs.size()));
				
			}
			
			
			//get all arguments of Omni Inbox Communication Mode
			//get Sms query details from reporting application through RMI
			IndividualEventSC individualEventSC = new IndividualEventSC();
			if(!NumberUtil.isEmptyDecimal(omniInboxAlrt_EVT_COMM_MODEVO.getQUERY_ID()))
			{
				individualEventSC.setQueryId(omniInboxAlrt_EVT_COMM_MODEVO.getQUERY_ID());
				try
				{
					IndividualEventCO individualEventCO2 =  returnQueryDetailsById(individualEventSC);
					individualEventCO.setOmniInboxQueryColumnListJson(individualEventCO2.getOmniInboxQueryColumnListJson());
					individualEventCO.setOmniInboxQueryBriefDescription(individualEventCO2.getIrp_AD_HOC_QUERYCO().getQUERY_NAME());
				}
				catch(Exception ex)
				{
					omniInboxAlrt_EVT_COMM_MODEVO.setQUERY_ID(null);
					log.error("Error in returnIndividualEventByEventId method inside individualEventBoImpl "+ex.getMessage());
				}
			}
		}
		
		List<ALRT_EVT_OL_DATA_TRANSVO> emailAlrt_EVT_OL_DATA_TRANSVOs = individualEventCO.getEmailAlrt_EVT_OL_DATA_TRANSVOs();
		String emailMessageData = "";
		String smsMessageData = "";
		String omniInboxMessageData = "";
		
		if(emailAlrt_EVT_COMM_MODEVO != null && emailAlrt_EVT_OL_DATA_TRANSVOs != null && emailAlrt_EVT_OL_DATA_TRANSVOs.size() > 0)
		{
			for(int i=0; i<emailAlrt_EVT_OL_DATA_TRANSVOs.size(); i++)
			{
				ALRT_EVT_OL_DATA_TRANSVO alrt_EVT_OL_DATA_TRANSVO = emailAlrt_EVT_OL_DATA_TRANSVOs.get(i);
				if(StringUtil.isNotEmpty(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE()) )
				{
					emailMessageData = emailAlrt_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE();
					emailMessageData+="<-->"+alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE();
					emailMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					emailMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ENGLISH_LANG))
					{
						individualEventCO.setEventStaticEmailMessageENHidden(emailMessageData);
					}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ARABIC_LANG))
						{
							individualEventCO.setEventStaticEmailMessageARHidden(emailMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.FRENCH_LANG))
						{
							individualEventCO.setEventStaticEmailMessageFRHidden(emailMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.RUSSIAN_LANG))
						{
							individualEventCO.setEventStaticEmailMessageRUHidden(emailMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.TURKISH_LANG))
						{
							individualEventCO.setEventStaticEmailMessageTKHidden(emailMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.PERSION_LANG))
						{
							individualEventCO.setEventStaticEmailMessageFAHidden(emailMessageData);
						}
				}
			}
		}
		
		List<ALRT_EVT_OL_DATA_TRANSVO> smsAlrt_EVT_OL_DATA_TRANSVOs = individualEventCO.getSmsAlrt_EVT_OL_DATA_TRANSVOs();
		if(smsAlrt_EVT_COMM_MODEVO != null && smsAlrt_EVT_OL_DATA_TRANSVOs != null && smsAlrt_EVT_OL_DATA_TRANSVOs.size() > 0)
		{
			for(int i=0; i<smsAlrt_EVT_OL_DATA_TRANSVOs.size(); i++)
			{
				ALRT_EVT_OL_DATA_TRANSVO alrt_EVT_OL_DATA_TRANSVO = smsAlrt_EVT_OL_DATA_TRANSVOs.get(i);
				if(StringUtil.isNotEmpty(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE()) )
				{
					smsMessageData = smsAlrt_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE();
					smsMessageData+="<-->"+alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE();
					smsMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					smsMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ENGLISH_LANG))
					{
						individualEventCO.setEventStaticSmsMessageENHidden(smsMessageData);
					}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ARABIC_LANG))
						{
							individualEventCO.setEventStaticSmsMessageARHidden(smsMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.FRENCH_LANG))
						{
							individualEventCO.setEventStaticSmsMessageFRHidden(smsMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.RUSSIAN_LANG))
						{
							individualEventCO.setEventStaticSmsMessageRUHidden(smsMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.TURKISH_LANG))
						{
							individualEventCO.setEventStaticSmsMessageTKHidden(smsMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.PERSION_LANG))
						{
							individualEventCO.setEventStaticSmsMessageFAHidden(smsMessageData);
						}
				}
			}
		}
		
		List<ALRT_EVT_OL_DATA_TRANSVO> omniInboxAlrt_EVT_OL_DATA_TRANSVOs = individualEventCO.getOmniInboxAlrt_EVT_OL_DATA_TRANSVOs();
		if(omniInboxAlrt_EVT_COMM_MODEVO != null && omniInboxAlrt_EVT_OL_DATA_TRANSVOs != null && omniInboxAlrt_EVT_OL_DATA_TRANSVOs.size() > 0)
		{
			for(int i=0; i<omniInboxAlrt_EVT_OL_DATA_TRANSVOs.size(); i++)
			{
				ALRT_EVT_OL_DATA_TRANSVO alrt_EVT_OL_DATA_TRANSVO = omniInboxAlrt_EVT_OL_DATA_TRANSVOs.get(i);
				if(StringUtil.isNotEmpty(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE()) )
				{
					omniInboxMessageData = omniInboxAlrt_EVT_COMM_MODEVO.getCOMMUNICATION_TYPE();
					omniInboxMessageData+="<-->"+alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE();
					omniInboxMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_SUBJECT());
					omniInboxMessageData+="<-->"+StringUtil.nullToEmpty(alrt_EVT_OL_DATA_TRANSVO.getMESSAGE_BODY());
					if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ENGLISH_LANG))
					{
						individualEventCO.setEventStaticOmniInboxMessageENHidden(omniInboxMessageData);
					}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.ARABIC_LANG))
						{
							individualEventCO.setEventStaticOmniInboxMessageARHidden(omniInboxMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.FRENCH_LANG))
						{
							individualEventCO.setEventStaticOmniInboxMessageFRHidden(omniInboxMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.RUSSIAN_LANG))
						{
							individualEventCO.setEventStaticOmniInboxMessageRUHidden(omniInboxMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.TURKISH_LANG))
						{
							individualEventCO.setEventStaticOmniInboxMessageTKHidden(omniInboxMessageData);
						}
					else
						if(alrt_EVT_OL_DATA_TRANSVO.getLANG_CODE().equals(IndividualEventConstant.PERSION_LANG))
						{
							individualEventCO.setEventStaticOmniInboxMessageFAHidden(omniInboxMessageData);
						}
				}
			}
		}
		
		/**
		 * set internal Alert based on event
		 */
		ALRT_EVT_COMM_INTRNLVO intrnlvo = returnInternalEventAlertlist(indEventSC);
		
		individualEventCO.setAlrt_EVT_COMM_INTRNLVO(intrnlvo == null ? new ALRT_EVT_COMM_INTRNLVO() 
									     : intrnlvo);

		/**
		 * set the set
		 */
		if(individualEventCO.getAlrt_EVT_COMM_INTRNLVO() != null)
		    individualEventCO.setImalInternalAlrtActivate(
			    StringUtil.nullToEmpty(
				    individualEventCO.
				    getAlrt_EVT_COMM_INTRNLVO().getACTIVATED_YN()).equals(ConstantsCommon.YES) ? 
				    ConstantsCommon.ONE : ConstantsCommon.ZERO);
		
		return individualEventCO;
	}

	/**
	 * 
	 * @throws BaseException
	 */
	private ALRT_EVT_COMM_INTRNLVO returnInternalEventAlertlist(IndividualEventSC indEventSC) throws BaseException
	{
	    return alertIndividualEventDAO.returnInternalEventDetailsByEvtId(indEventSC);
	}
	
	@Override
	public IndividualEventCO delete(IndividualEventCO individualEventCO) throws BaseException 
	{
		ALRT_EVTVO alrt_EVTVO = individualEventCO.getAlrtEvtVO();
		
		alrt_EVTVO.setSTATUS(AlertConstant.STATUS_DELETED);
		alrt_EVTVO.setDELETED_BY(individualEventCO.getUserID());
		alrt_EVTVO.setDATE_DELETED(individualEventCO.getRunningDate());
		genericDAO.update(alrt_EVTVO);
		
		/**
         * delete event from core db
       	 */
		syncEventWithCoreDb_save(alrt_EVTVO, individualEventCO);
		
		//Apply Audit
		auditBO.callAudit(individualEventCO.getAuditObj(), alrt_EVTVO, individualEventCO.getAuditRefCO());
		auditBO.insertAudit(individualEventCO.getAuditRefCO());
				
		return individualEventCO;
	}
	
	public List<IndFixedParamListCO> loadParamDetails(IndividualEventSC individualEventSC) throws BaseException {

		IndFixedParamListCO indFixedParamListCO = new IndFixedParamListCO();
		List<IndFixedParamListCO> indFixedParamList = null;
//		IndividualEventCO individualEventCO = new IndividualEventCO();
		if (!NumberUtil.isEmptyDecimal(individualEventSC.getAlrtEvtVO().getEVT_ID())) {
			indFixedParamList = alertIndividualEventDAO.retrieveFixedParam(individualEventSC);
			// individualEventCO.setIsOpen(ConstantsCommon.ZERO);
			// individualEventSC.setFixedEventId(individualEventCO.getAlrtEvtVO().getFIXED_EVENT_ID());
			for (int i = 0; i < indFixedParamList.size(); i++) {
				individualEventSC.setFixedCode(indFixedParamList.get(i).getFIXED_CODE());
				indFixedParamList.get(i).setFixedOperatorDesc(indFixedParamList.get(i).getFIXED_OPERATOR());
				indFixedParamListCO = alertIndividualEventDAO.RetrievefixedEvent(individualEventSC);
				indFixedParamList.get(i).setFIXED_LABEL(indFixedParamListCO.getFIXED_LABEL());
				indFixedParamList.get(i).setFIXED_FLAG(indFixedParamListCO.getFIXED_FLAG());
				indFixedParamList.get(i).setPARAMETER_TYPE(indFixedParamListCO.getPARAMETER_TYPE());
			}

		}

		return indFixedParamList;
	}

	public void approveRecord(IndividualEventCO individualEventCO, String sLanguage, String userName)
			throws BaseException {

		individualEventCO.getAlrtEvtVO().setSTATUS(AlertConstant.STATUS_APPROVED);
		individualEventCO.getAlrtEvtVO().setAUTHORIZED_BY(userName);
		individualEventCO.getAlrtEvtVO().setDATE_AUTHORIZED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
		individualEventCO.setRunningDate(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
		individualEventCO.setUserID(userName);
		
		NumberUtil.resetEmptyValues(individualEventCO.getAlrtEvtVO());

		if (ConstantsCommon.ZERO.equals(individualEventCO.getAlrtEvtVO().getSUSPENDED())) {
			individualEventCO.getAlrtEvtVO().setSUSPENDED("N");
		} else if (ConstantsCommon.ONE.equals(individualEventCO.getAlrtEvtVO().getSUSPENDED())) {
			individualEventCO.getAlrtEvtVO().setSUSPENDED("Y");
		}

		Integer row = genericDAO.update(individualEventCO.getAlrtEvtVO());
		if (row == null || row < 1) {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		
		/**
                 * Approve event from core db
               	 */
		syncEventWithCoreDb_save(individualEventCO.getAlrtEvtVO(), individualEventCO);
		
		ALRT_EVTVO alrtVO =  null;
		IndividualEventCO oldIndividualEventCO = (IndividualEventCO) individualEventCO.getAuditObj();
		if(null!= oldIndividualEventCO)
		{
			alrtVO = oldIndividualEventCO.getAlrtEvtVO();
		}
		else{
			alrtVO = (ALRT_EVTVO)genericDAO.selectByPK(individualEventCO.getAlrtEvtVO());
		}			
		auditBO.callAudit(alrtVO, individualEventCO.getAlrtEvtVO(),individualEventCO.getAuditRefCO());	
		auditBO.insertAudit(individualEventCO.getAuditRefCO());
	}

	@Override
	public List<IndividualReportIdEventCO> reportList(IndividualEventSC indEventSC) throws BaseException {
		return /*alertIndividualEventDAO.reportEventList(indEventSC);*/ null;
	}

	@Override
    public IndividualEventCO dependencyByFixedEvtId(IndividualEventCO individualEventCO) throws BaseException
    {
	IndividualEventSC criteria = new IndividualEventSC();
	criteria.getAlrtEvtVO().setFIXED_EVENT_ID(individualEventCO.getAlrtEvtVO().getFIXED_EVENT_ID());
	int count = alertIndividualEventDAO.returnfixedIdCount(criteria);

	if(count == 0 || count == -1)
	{
	    individualEventCO.setInvalidfixedevtid("1");
	    // criteria.getAlrtEvtVO().setFIXED_EVENT_ID(null);
	    // individualEventCO.getAlrtEvtVO().setFIXED_EVENT_ID(null);

	    RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	    reqFieldSC.setCompCode(individualEventCO.getCompCode());
	    reqFieldSC.setProgRef(
		    commonLibBO.returnOrginProgRef(individualEventCO.getAppName(), individualEventCO.getProgRef()));
	    reqFieldSC.setAppName(individualEventCO.getAppName());
	    reqFieldSC.setBranchCode(individualEventCO.getBranchCode());

	    String[] listIds = new String[] { "lookuptxt_fixedEventid" };

	    commonLibBO.applyDynScreenDisplay(listIds, ConstantsCommon.EMPTY_BIGDECIMAL_VALUE.toString(),
		    BigDecimal.ZERO, individualEventCO.getHm(), reqFieldSC);

	}

	return individualEventCO;

    }
    
    @Override
    public String fixedEventDescription(IndividualEventSC indEventSC) throws BaseException
    {
	return alertIndividualEventDAO.fixedEventDescription(indEventSC);
    }

	
	public Integer reportEventCount(IndividualEventSC indEventSC) throws BaseException {
		return /*alertIndividualEventDAO.reportEventCount(indEventSC);*/ null;
	}

	public IndividualEventCO columnsVisible(IndividualEventCO individualEventCO) throws BaseException {
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(individualEventCO.getCompCode());
		reqFieldSC.setProgRef(
				commonLibBO.returnOrginProgRef(individualEventCO.getAppName(), individualEventCO.getProgRef()));
		reqFieldSC.setAppName(individualEventCO.getAppName());
		reqFieldSC.setBranchCode(individualEventCO.getBranchCode());
		applyDynScreenDisplay(new String[] { "MessageText", "MessageEmail", "MessageSMS" },
				ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ZERO.toString(), individualEventCO.getHm(),
				reqFieldSC);
		return individualEventCO;
	}

    public void callStatusUpdate(IndividualEventCO individualEventCO, ALRT_EVTVO alrtEvtVO) throws BaseException
    {
		alrtEvtVO.setSTATUS(individualEventCO.getAlrtEvtVO().getSTATUS());
		alrtEvtVO.setDATE_UPDATED(individualEventCO.getAlrtEvtVO().getDATE_UPDATED());
		
		IndividualEventCO oldIndEventCO = (IndividualEventCO) individualEventCO.getAuditObj();
		ALRT_EVTVO oldAlrtVO = null;
		if(null == oldIndEventCO)
		{
			oldAlrtVO = (ALRT_EVTVO) genericDAO.selectByPK(alrtEvtVO);
		}
		else{
			oldAlrtVO = oldIndEventCO.getAlrtEvtVO();
		}
		/*
		 * Update
		 */
		Integer row = genericDAO.update(alrtEvtVO);
		/*
		 * Record Changed between retrieve and update
		 */
		if(row == null || row < 1)
		{
		    throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		/**
         * Change Status of  event in core db
       	 */
		syncEventWithCoreDb_save(alrtEvtVO, individualEventCO);
		
		auditBO.callAudit(oldAlrtVO, individualEventCO.getAlrtEvtVO(),individualEventCO.getAuditRefCO());
		auditBO.insertAudit(individualEventCO.getAuditRefCO());
    }
    
	@Override
	public void toSuspend(IndividualEventCO individualEventCO) throws BaseException 
	{
		ALRT_EVTVO alrtEvtVO = individualEventCO.getAlrtEvtVO();
		alrtEvtVO.setTOBE_SUSPENDED_BY(individualEventCO.getUserID());
		alrtEvtVO.setTOBE_SUSPENDED_DATE(individualEventCO.getRunningDate());
		alrtEvtVO.setTO_BE_STATUS(AlertConstant.CRUD_SP);
		alrtEvtVO.setTO_BE_STATUS_BY(individualEventCO.getUserID());
		genericDAO.update(alrtEvtVO);
		
		/**
         * Change Status to be suspend of  event in core db
       	 */
		syncEventWithCoreDb_save(alrtEvtVO, individualEventCO);
	}
    
    @Override
    public void suspend(IndividualEventCO individualEventCO) throws BaseException
    {
    	ALRT_EVTVO alrtEvtVO = individualEventCO.getAlrtEvtVO();
		alrtEvtVO.setSUSPENDED_BY(individualEventCO.getUserID());
		alrtEvtVO.setDATE_SUSPENDED(commonLibBO.addSystemTimeToDate(individualEventCO.getRunningDate()));
		alrtEvtVO.setSTATUS(AlertConstant.STATUS_SUSPEND);
		alrtEvtVO.setTO_BE_STATUS("E");
		alrtEvtVO.setTO_BE_STATUS_BY(null);
		alrtEvtVO.setEVT_ID(individualEventCO.getAlrtEvtVO().getEVT_ID());
		callStatusUpdate(individualEventCO, alrtEvtVO);
    }

    @Override
	public void toReactivate(IndividualEventCO individualEventCO) throws BaseException 
    {
		ALRT_EVTVO alrtEvtVO = individualEventCO.getAlrtEvtVO();
		alrtEvtVO.setTOBE_REACTIVATED_BY(individualEventCO.getUserID());
		alrtEvtVO.setTOBE_REACTIVATED_DATE(individualEventCO.getRunningDate());
		alrtEvtVO.setTO_BE_STATUS(AlertConstant.CRUD_TR);
		alrtEvtVO.setTO_BE_STATUS_BY(individualEventCO.getUserID());
		genericDAO.update(alrtEvtVO);

		syncEventWithCoreDb_save(alrtEvtVO, individualEventCO);
	}
    
    @Override
    public void reactivate(IndividualEventCO individualEventCO) throws BaseException
    {
		Date dateToSetTime = individualEventCO.getAlrtEvtVO().getDATE_REACTIVATED();
		individualEventCO.getAlrtEvtVO().setDATE_REACTIVATED(commonLibBO.addSystemTimeToDate(dateToSetTime));
		ALRT_EVTVO alrtEvtVO = individualEventCO.getAlrtEvtVO();
		alrtEvtVO.setDATE_REACTIVATED(individualEventCO.getAlrtEvtVO().getDATE_REACTIVATED());
		alrtEvtVO.setREACTIVATED_BY(individualEventCO.getAlrtEvtVO().getREACTIVATED_BY());
		alrtEvtVO.setEVT_ID(individualEventCO.getAlrtEvtVO().getEVT_ID());
		alrtEvtVO.setTO_BE_STATUS("E");
		alrtEvtVO.setTO_BE_STATUS_BY(null);
		callStatusUpdate(individualEventCO, alrtEvtVO);
    }
    
	@Override
	public void reject(IndividualEventCO individualEventCO) throws BaseException 
	{
		ALRT_EVTVO alrt_EVTVO = individualEventCO.getAlrtEvtVO();
		alrt_EVTVO.setTO_BE_STATUS("E");
		alrt_EVTVO.setTO_BE_STATUS_BY(null);
		genericDAO.update(alrt_EVTVO);
		
		/**
         * Change Status to be suspend of  event in core db
       	 */
		syncEventWithCoreDb_save(alrt_EVTVO, individualEventCO);
	}
    
    @Override
    public IndividualEventCO returnReportDetailsById(IndividualEventSC indEventSC) 
    {
    	IndividualEventCO individualEventCO = new IndividualEventCO();
    	try
    	{
    		if(!NumberUtil.isEmptyDecimal(indEventSC.getReportId()))
        	{
        		List<ALRT_EVT_COMM_MODE_ARG_MAPVO> alrt_EVT_COMM_MODE_ARG_MAPVOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
            	ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO = new  ALRT_EVT_COMM_MODE_ARG_MAPVO();
            	
            	indEventSC.setAppName(indEventSC.getCurrAppName());
            	indEventSC.setCompCode(indEventSC.getCompanyCode());
            	indEventSC.setProfType("1");
            	List<UsrCO> cos =  alertIndividualEventDAO.returnIndividualEventUsrReportsListForEvent(indEventSC);
            	if(cos != null && cos.size() > 0)
            	{
            		HashMap<String, Object> reportsHashmap = commonReportingBO.returnReportById(indEventSC.getReportId());
                   	IRP_AD_HOC_REPORTCO ad_HOC_REPORTCO = (IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(reportsHashmap, IRP_AD_HOC_REPORTCO.class);
                   	individualEventCO.setIrp_AD_HOC_REPORTCO(ad_HOC_REPORTCO);
            		LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>  hashMap = ad_HOC_REPORTCO.getArgumentsList();
            		// set all arguments of query
            		for(Map.Entry<Long, IRP_REP_ARGUMENTSCO> queryArgumentsMap : hashMap.entrySet())
            		{
            			alrt_EVT_COMM_MODE_ARG_MAPVO = new  ALRT_EVT_COMM_MODE_ARG_MAPVO();
            			IRP_REP_ARGUMENTSCO  irp_REP_ARGUMENTSCO = queryArgumentsMap.getValue();
            			if(StringUtil.isNotEmpty(indEventSC.getLookupOf() ) && indEventSC.getLookupOf().equals("RA"))
        			    {
            				alrt_EVT_COMM_MODE_ARG_MAPVO.setATTACH_REPORT_ID(indEventSC.getReportId());
        			    }
            			alrt_EVT_COMM_MODE_ARG_MAPVO.setARG_NAME(irp_REP_ARGUMENTSCO.getARGUMENT_NAME());
            			alrt_EVT_COMM_MODE_ARG_MAPVOs.add(alrt_EVT_COMM_MODE_ARG_MAPVO);
            		}
            		individualEventCO.setEmailReportParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
            		individualEventCO.setOmniInboxReportParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
            	}
        	}
    	}
    	catch(Exception ex)
    	{
    		log.error("Error in returnReportDetailsById method inside individualEventBoImpl "+ex.getMessage());
    	}
    	
       	return individualEventCO;
    }
    
    @Override
	public List<IRP_AD_HOC_QUERYVO> returnQueryList(IndividualEventSC indEventSC)
    {
		List<IRP_AD_HOC_QUERYVO> irp_AD_HOC_QUERYVOs = new ArrayList<IRP_AD_HOC_QUERYVO>();
		try
    	{
			HashMap<String,Object> paramsMap = (HashMap<String,Object>) PathPropertyUtil.convertToMap(indEventSC);
	    	
	    	HashMap<String, Object> queriesHashmap = commonReportingBO.returnQueriesList(paramsMap);
	    	
	    	List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) queriesHashmap.get("queriesList");
	    	
			for(HashMap<String, Object> hashMap : result)
			{
				IRP_AD_HOC_QUERYVO irp_AD_HOC_QUERYVO = (IRP_AD_HOC_QUERYVO) PathPropertyUtil.convertToObject(hashMap, IRP_AD_HOC_QUERYVO.class);
				irp_AD_HOC_QUERYVOs.add(irp_AD_HOC_QUERYVO);
			}
    	}
		catch(Exception ex)
		{
			log.error("Error in returnQueryList method inside individualEventBoImpl "+ex.getMessage());
		}
    	
    	return irp_AD_HOC_QUERYVOs;
	}
    
    @Override
	public Integer returnQueryListCount(IndividualEventSC indEventSC) 
    {
    	int queriesCount = 0;
    	try
    	{
    		HashMap<String,Object> inputParamsMap = (HashMap<String,Object>) PathPropertyUtil.convertToMap(indEventSC);
        	HashMap<String,Object> outputMap= commonReportingBO.returnQueriesListCount(inputParamsMap);
        	queriesCount = (int) outputMap.get("queriesListCount");
    	}
		catch(Exception ex)
		{
			log.error("Error in returnQueryListCount method inside individualEventBoImpl "+ex.getMessage());
		}
    	
		return queriesCount;
	}
    
    @Override
   	public IndividualEventCO returnQueryDetailsById(IndividualEventSC indEventSC) 
    {
    	IndividualEventCO individualEventCO = new IndividualEventCO();
    	try
    	{
        	if(!NumberUtil.isEmptyDecimal(indEventSC.getQueryId()))
        	{
               	HashMap<String, Object> queriesHashmap = commonReportingBO.returnQueryById(indEventSC.getQueryId(), false);
              	IRP_AD_HOC_QUERYCO irp_AD_HOC_QUERYCO = (IRP_AD_HOC_QUERYCO) PathPropertyUtil.convertToObject(queriesHashmap, IRP_AD_HOC_QUERYCO.class);
              	
              	List<ALRT_EVT_COMM_MODE_ARG_MAPVO> alrt_EVT_COMM_MODE_ARG_MAPVOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
              	ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO = new  ALRT_EVT_COMM_MODE_ARG_MAPVO();
              	if(irp_AD_HOC_QUERYCO != null)
              	{
              		if(irp_AD_HOC_QUERYCO.getSqlObject()!= null)
              		{
              			LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>  hashMap = irp_AD_HOC_QUERYCO.getSqlObject().getArgumentsList();
              			List<IRP_FIELDSCO> irp_FIELDSCOs =  irp_AD_HOC_QUERYCO.getSqlObject().getAllFields();
              			
              			// set all arguments of query
              			for(Map.Entry<Long, IRP_REP_ARGUMENTSCO> queryArgumentsMap : hashMap.entrySet())
              			{
              				alrt_EVT_COMM_MODE_ARG_MAPVO = new  ALRT_EVT_COMM_MODE_ARG_MAPVO();
              				IRP_REP_ARGUMENTSCO  irp_REP_ARGUMENTSCO = queryArgumentsMap.getValue();
              				alrt_EVT_COMM_MODE_ARG_MAPVO.setARG_NAME(irp_REP_ARGUMENTSCO.getARGUMENT_NAME());
              				alrt_EVT_COMM_MODE_ARG_MAPVOs.add(alrt_EVT_COMM_MODE_ARG_MAPVO);
              			} 
              			
              			
                  		individualEventCO.setIrp_AD_HOC_QUERYCO(irp_AD_HOC_QUERYCO);
                  		if(alrt_EVT_COMM_MODE_ARG_MAPVOs != null && alrt_EVT_COMM_MODE_ARG_MAPVOs.size() > 0)
                  		{
                  			individualEventCO.setBatchQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
                  			individualEventCO.setEmailQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
                  			individualEventCO.setSmsQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
                  			individualEventCO.setOmniInboxQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
                  		}
                  		
                  		if(irp_FIELDSCOs != null && irp_FIELDSCOs.size() > 0)
                  		{
                  			individualEventCO.setBatchQueryColumnListJson("{\"root\":".concat(PathJSONUtil.serialize(irp_FIELDSCOs, null, null, false, true)).concat("}"));
                      		individualEventCO.setEmailQueryColumnListJson("{\"root\":".concat(PathJSONUtil.serialize(irp_FIELDSCOs, null, null, false, true)).concat("}"));
                      		individualEventCO.setSmsQueryColumnListJson("{\"root\":".concat(PathJSONUtil.serialize(irp_FIELDSCOs, null, null, false, true)).concat("}"));
                      		individualEventCO.setOmniInboxQueryColumnListJson("{\"root\":".concat(PathJSONUtil.serialize(irp_FIELDSCOs, null, null, false, true)).concat("}"));
                  		}
                  		       
                  		//batch
                  		if("B".equals(indEventSC.getEventType()))
                  		{
                  		    individualEventCO.setBatchQueryBriefDescription(irp_AD_HOC_QUERYCO.getQUERY_NAME());
                  		}

              		}
              	}
        	}
    	}
		catch(Exception ex)
		{
			log.error("Error in returnQueryDetailsById method inside individualEventBoImpl "+ex.getMessage());
		}
       	return individualEventCO;
   	}
	
	@Override
	public ArrayList<ALRT_TAGS_DEFVO> returnIndEventCustomDefaultTagList(IndividualEventSC indEventSC) throws BaseException
	{
		return alertIndividualEventDAO.returnIndEventCustomDefaultTagList(indEventSC);
	}
	
	@Override
	public int returnIndEventCustomDefaultTagListCount(IndividualEventSC indEventSC) throws BaseException
	{
		return alertIndividualEventDAO.returnIndEventCustomDefaultTagListCount(indEventSC);
	}
	
	@Override
	public List<ALRT_TAGS_DEFVO> returnColumnListByQueryId(String queryId)
	{
		List<ALRT_TAGS_DEFVO> alrt_TAGS_DEFVOs = new ArrayList<ALRT_TAGS_DEFVO>();
		try
    	{
			if(StringUtil.isNotEmpty(queryId))
			{
				ALRT_TAGS_DEFVO alrt_TAGS_DEFVO = null;
				List<String[]> list = commonReportingBO.returnColsList(queryId);
				
				if(list != null && list.size() > 0)
				{
					for(int i=0; i<list.size(); i++)
					{
						alrt_TAGS_DEFVO = new ALRT_TAGS_DEFVO();
						String columns[] = list.get(i);
						alrt_TAGS_DEFVO.setCOLUMN_NAME(columns[0]);
						alrt_TAGS_DEFVOs.add(alrt_TAGS_DEFVO);
					}
				}
			}
    	}
		catch(Exception ex)
		{
			log.error("Error in returnColumnListByQueryId method inside individualEventBoImpl "+ex.getMessage());
		}
		return alrt_TAGS_DEFVOs;
	}
	
	
	@Override
	public Integer returnCheckIsUniqueEventDescription(IndividualEventSC indEventSC) throws BaseException {
		
		return this.alertIndividualEventDAO.returnCheckIsUniqueEventDescription(indEventSC);
	}
	
	//Raed Saad - User Story #592675 Get Alert Events - 14.1
	@Override
	public AlertServiceCO getAlertEvents(AlertServiceCO alertServiceCO) throws BaseException 
	{
		AlertServiceSC alertServiceSC = new AlertServiceSC();	    
		alertServiceSC.getIndEventSC().setLovType(AlertConstant.SUBSCRIBER_STATUS_LOV_TYPE);
		alertServiceSC.getIndEventSC().setLangCode("EN");		
		alertServiceSC.getIndEventSC().setEvtType(AlertConstant.eventModeDropDown);
		alertServiceSC.getIndEventSC().setModeType(AlertConstant.eventTypeDropDown);
		alertServiceSC.setAlertEVTVO(alertServiceCO.getAlertEVTVO());		
		alertServiceCO.setLstIndvEventCO(alertIndividualEventDAO.getAlertEvents(alertServiceSC));		
		return alertServiceCO;
	}
	
	@Override
	public IndividualEventCO returnAttachReportMappingArgument(IndividualEventSC sc) throws Exception 
	{
		IndividualEventCO individualEventCO = new IndividualEventCO();
		List<ALRT_EVT_COMM_MODE_ARG_MAPVO> alrt_EVT_COMM_MODE_ARG_MAPVOs = alertIndividualEventDAO.returnAttachReportMappingArgument(sc);
		//check if retrieve parameters for Report Attachment by open mapping parameters dialog
		if(sc.getLookupOf().equals("RA"))
		{
			//if mapping parameters already exist in mapping table
			if(alrt_EVT_COMM_MODE_ARG_MAPVOs != null && alrt_EVT_COMM_MODE_ARG_MAPVOs.size() > 0)
			{
				if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("E"))
				{
					individualEventCO.setEventStaticEmailStaticReportAttachmentDataHidden("{\"root\":".concat(PathJSONUtil.serialize(
							alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
				}
				else
					if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("OI"))
					{
						individualEventCO.setEventStaticOmniInboxStaticReportAttachmentDataHidden("{\"root\":".concat(PathJSONUtil.serialize(
								alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
					}
			}
			//otherwise retrieve parameters from reporting application
			else
			{
				individualEventCO = returnReportDetailsById(sc);
				if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("E"))
				{
					individualEventCO.setEventStaticEmailStaticReportAttachmentDataHidden(individualEventCO.getEmailReportParameterListJson());
				}
				else
					if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("OI"))
					{
						individualEventCO.setEventStaticOmniInboxStaticReportAttachmentDataHidden(individualEventCO.getOmniInboxReportParameterListJson());
					}
			}
		}
		//check if retrieve parameters for Query by open mapping parameters dialog
		else if(sc.getLookupOf().equals("Query"))
		{
			//if mapping parameters already exist in mapping table
			if(alrt_EVT_COMM_MODE_ARG_MAPVOs != null && alrt_EVT_COMM_MODE_ARG_MAPVOs.size() > 0)
			{
				if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("E"))
				{
					individualEventCO.setEmailQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(
							alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
				}
				else if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("S"))
					{
						individualEventCO.setSmsQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(
							alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
					}
				else
					if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("OI"))
					{
						individualEventCO.setOmniInboxQueryParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(
								alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
					}
			}
			//otherwise retrieve parameters from reporting application
			else
			{
				sc.setQueryId(sc.getReportId());
				individualEventCO =  returnQueryDetailsById(sc);
			}
		}
		
		//check if retrieve parameters for Report by open mapping parameters dialog
		else if(sc.getLookupOf().equals("Report"))
		{
			//if mapping parameters already exist in mapping table
			if(alrt_EVT_COMM_MODE_ARG_MAPVOs != null && alrt_EVT_COMM_MODE_ARG_MAPVOs.size() > 0)
			{
				if(StringUtil.isNotEmpty(sc.getEmailCommunicationType()) && sc.getEmailCommunicationType().equals("E"))
				{
					individualEventCO.setEmailReportParameterListJson("{\"root\":".concat(PathJSONUtil.serialize(alrt_EVT_COMM_MODE_ARG_MAPVOs, null, null, false, true)).concat("}"));
				}
			}
			//otherwise retrieve parameters from reporting application
			else
			{
				individualEventCO =  returnReportDetailsById(sc);
			}
		}
		return individualEventCO;
	}

	@Override
	public Integer returnAlertTagsSelectCount(IndividualEventSC indEventSC) throws BaseException
	{
	    return alertIndividualEventDAO.returnAlertTagsSelectCount(indEventSC);
	}
	
	@Override
	public List<AlrtTagsCO> returnAlertTagsSelect(IndividualEventSC indEventSC) throws BaseException
	{
	    return alertIndividualEventDAO.returnAlertTagsSelect(indEventSC);
	}
	
    @Override
    public IndividualEventCO applySysParamSettings(IndividualEventCO individualEventCO) throws BaseException
    {
	if(null == individualEventCO.getScreenDisplaySeting() || individualEventCO.getScreenDisplaySeting().size() <= 0)
	    return individualEventCO;

	individualEventCO.getScreenDisplaySeting().forEach((key, value) -> {

	    try
	    {
		if(StringUtil.nullToEmpty(key).equals("skipSubscription"))
		{
		    /**
		     * disable the user Expression field when User has selected
		     * from
		     */
		    if(StringUtil.nullToEmpty(value).equals(IndividualEventConstant.SYSTEM_EVENT_TYPE))
		    {

			applyDynScreenDisplay(new String[] { key }, ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
				individualEventCO.getElementMap(), null);

		    }
		    else
		    {
			applyDynScreenDisplay(new String[] { key }, ConstantsCommon.ACTION_TYPE_VISIBLE, "1",
				individualEventCO.getElementMap(), null);
		    }
		}
		else
		{
		    /**
		     * disable the company Expression field when Company has
		     * selected from
		     */
		    if(StringUtil.isEmptyString(StringUtil.nullToEmpty(value).toString()))
		    {
			applyDynScreenDisplay(new String[] { key }, ConstantsCommon.ACTION_TYPE_READONLY,
				ConstantsCommon.ZERO, individualEventCO.getElementMap(), null);
		    }
		    else
		    {
			applyDynScreenDisplay(new String[] { key }, ConstantsCommon.ACTION_TYPE_READONLY,
				ConstantsCommon.ONE, individualEventCO.getElementMap(), null);
		    }
		}
	    }
	    catch(BaseException e)
	    {
		e.printStackTrace();
		log.error("Error in apply dispaly setting by skip subscription and inernal alert "+e.getMessage());
	    }

	});
	return individualEventCO;
    }
	
	public AlertCommonLibBO getAlertCommonLibBO() {
		return alertCommonLibBO;
	}

	public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO) {
		this.alertCommonLibBO = alertCommonLibBO;
	}

	public IndividualEventDAO getAlertIndividualEventDAO() {
		return alertIndividualEventDAO;
	}

	public void setAlertIndividualEventDAO(IndividualEventDAO alertIndividualEventDAO) {
		this.alertIndividualEventDAO = alertIndividualEventDAO;
	}

	public CommonReportingBO getCommonReportingBO() {
		return commonReportingBO;
	}

	public void setCommonReportingBO(CommonReportingBO commonReportingBO) {
		this.commonReportingBO = commonReportingBO;
	}

	@Override
	public List<IndividualEventListCO> returnIndividualEventListForPackageList(IndividualEventSC indEventSC) throws BaseException 
	{
		return alertIndividualEventDAO.returnIndividualEventListForPackageList(indEventSC);
	}

	@Override
	public Integer returnIndividualEventListForPackageCount(IndividualEventSC sc) throws BaseException 
	{
		return alertIndividualEventDAO.returnIndividualEventListForPackageCount(sc);
	}
}