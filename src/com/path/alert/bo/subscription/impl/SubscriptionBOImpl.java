package com.path.alert.bo.subscription.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.common.AlrtCommonConstants;
import com.path.alert.bo.engine.AlertEngineBO;
import com.path.alert.bo.subscription.SubscriptionBO;
import com.path.alert.bo.subscription.SubscriptionConstant;
import com.path.alert.dao.subscription.SubscriptionDAO;
import com.path.alert.vo.notification.AlertNotificationCO;
import com.path.alert.vo.subscription.SubscriptionCO;
import com.path.alert.vo.subscription.SubscriptionSC;
import com.path.alert.vo.subscription.SubscriptionWsCO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_COMM_MODE_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.DBSequenceSC;
import com.path.vo.common.RequiredFieldsSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class SubscriptionBOImpl extends BaseBO implements SubscriptionBO
{
    private SubscriptionDAO subscriptionDAO;
    private AlertCommonLibBO alertCommonLibBO;
    private AlertEngineBO alertEngineBO; 
            
	public void setAlertEngineBO(AlertEngineBO alertEngineBO) 
    {
		this.alertEngineBO = alertEngineBO;
	}

	@Override
    public SubscriptionCO returnAllSelectedRow(SubscriptionSC sc) throws BaseException
    {
	SubscriptionCO subscriptionCO = new SubscriptionCO();
	String columnName, variableName, allSelRows;
	ArrayList<LinkedHashMap> ListColData = new ArrayList<LinkedHashMap>();
	StringBuffer sb = new StringBuffer();
	if(SubscriptionConstant.SUBSCRIBER_TYPE.equals(sc.getGridType()))
	{
	    columnName = "ID";
	    variableName = "SUB_ID";
	    ListColData = subscriptionDAO.subscriberData(sc);

	}
	else if(SubscriptionConstant.EVENT_TYPE.equals(sc.getGridType()))
	{
	    columnName = "EVT_ID";
	    variableName = "EVT_ID";
	    ListColData = subscriptionDAO.eventData(sc);

	}
	else if(SubscriptionConstant.GROUP_TYPE.equals(sc.getGridType()))
	{
	    columnName = "GRP_ID";
	    variableName = "GRP_ID";
	    ListColData = subscriptionDAO.groupsData(sc);

	}
	else
	{
	    columnName = "PKG_ID";
	    variableName = "PKG_ID";
	    ListColData = subscriptionDAO.packagesData(sc);
	}

	for(int i = 0; i < ListColData.size(); i++)
	{

	    LinkedHashMap dynamicGridRec = ListColData.get(i);
	    Iterator it = dynamicGridRec.entrySet().iterator();
	    while(it.hasNext())
	    {
		Map.Entry element = (Map.Entry) it.next();
		if(columnName.equals(element.getKey()))
		{
		    sb.append("\"varId_").append(element.getValue()).append("\":");
		    sb.append("{\"" + variableName + "\":\"").append(element.getValue()).append("\"},");
		}

	    }
	}

	if(sb.length() > 0)
	{
	    allSelRows = "{" + sb.substring(0, sb.length() - 1).toString() + "}";
	}
	else
	{
	    allSelRows = "";
	}
	subscriptionCO.setAllRows(allSelRows);
	return subscriptionCO;
    }

    @Override
    public SubscriptionCO returnAllSelectedRowDet(SubscriptionSC sc) throws BaseException
    {
	SubscriptionCO subscriptionCO = new SubscriptionCO();
	String columnName = "", variableName = "", allSelRows, columnName2 = "";
	ArrayList<LinkedHashMap> ListColData = new ArrayList<LinkedHashMap>();
	StringBuffer sb = new StringBuffer();
	variableName = "SUB_ID-EVT_ID";
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(sc.getGridType()))
	{
	    columnName = "SUB_ID";
	    columnName2 = "EVT_ID";
	    // variableName = "SUB_ID-EVT_ID";
	    sc.setType(SubscriptionConstant.SUB_EVENT_TYPE);

	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(sc.getGridType()))
	{
	    columnName = "SUB_ID";
	    columnName2 = "EVT_ID";
	    // variableName = "SUB_ID-EVT_ID";
	    sc.setType(SubscriptionConstant.SUB_PCKG_TYPE);
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(sc.getGridType()))
	{
	    columnName = "EVT_ID";
	    columnName2 = "SUB_ID";
	    // variableName = "EVT_ID-GRP_ID";
	    sc.setType(SubscriptionConstant.EVENT_GRP_TYPE);
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(sc.getGridType()))
	{
	    columnName = "SUB_ID";
	    columnName2 = "EVT_ID";
	    // variableName = "GRP_ID-PKG_ID";
	    sc.setType(SubscriptionConstant.GRP_PCKG_TYPE);
	}
	ListColData = subscriptionDAO.subEvtData(sc);
	for(int i = 0; i < ListColData.size(); i++)
	{

	    LinkedHashMap dynamicGridRec = ListColData.get(i);
	    String val1 = returnValueFromHashMap(dynamicGridRec, columnName);
	    String val2 = returnValueFromHashMap(dynamicGridRec, columnName2);

	    sb.append("\"varId_").append(val1).append("-").append(val2).append("\":");
	    sb.append("{\"" + variableName + "\":\"").append(val1).append("~").append(val2).append("\"},");

	}

	if(sb.length() > 0)
	{
	    allSelRows = "{" + sb.substring(0, sb.length() - 1).toString() + "}";
	}
	else
	{
	    allSelRows = "";
	}
	subscriptionCO.setAllRows(allSelRows);
	return subscriptionCO;
    }

    private String returnValueFromHashMap(LinkedHashMap dynamicGridRec, String key)
    {
	Iterator it = dynamicGridRec.entrySet().iterator();
	while(it.hasNext())
	{
	    Map.Entry element = (Map.Entry) it.next();
	    if(key.equals(element.getKey()))
	    {
		return element.getValue().toString();
	    }
	}
	return "";
    }

    @Override
    public SubscriptionCO hideFromValueFields(SubscriptionSC sc) throws BaseException
    {
	SubscriptionCO subscriptionCO = new SubscriptionCO();

	int evtParamCount = subscriptionDAO.eventParamsCount(sc);
	BigDecimal fixedEvtId = subscriptionDAO.selectFixedEventId(sc);
	subscriptionCO.setFixedEventId(fixedEvtId);
	subscriptionCO.setEvtParamCount(evtParamCount);
	return subscriptionCO;

    }

    @Override
    public List<SubscriptionCO> loadEventsParamsGrid(SubscriptionSC sc) throws BaseException
    {
	SubscriptionSC subsc = new SubscriptionSC();
	BigDecimal fixed_event_id = subscriptionDAO.selectFixedEventId(sc);
	List<SubscriptionCO> fixedEvtParamsetList = new ArrayList<SubscriptionCO>();
	List<SubscriptionCO> evtParamsList = new ArrayList<SubscriptionCO>();
	List<SubscriptionCO> subEvtParamsList = new ArrayList<SubscriptionCO>();
	List<SubscriptionCO> fixedParamsList = new ArrayList<SubscriptionCO>();

	fixedEvtParamsetList = subscriptionDAO.loadFixedEvtParamsSet(sc);

	if(fixedEvtParamsetList.size() == 0)
	{
	    throw new BOException(MessageCodes.NO_PARAMS_TO_BE_SET);
	}
	else
	{
	    evtParamsList = subscriptionDAO.loadEventParams(sc);

	    if(evtParamsList == null || evtParamsList.size() == 0)
	    {
		evtParamsList.clear();
		for(int i = 0; i < fixedEvtParamsetList.size(); i++)
		{

		    SubscriptionCO newRowCO = new SubscriptionCO();

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setFIXED_CODE(fixedEvtParamsetList.get(i).getAlrtEvtParamSetVO().getFIXED_CODE());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setFIXED_OPERATOR(fixedEvtParamsetList.get(i).getAlrtEvtParamSetVO().getFIXED_OPERATOR());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setTO_VALUE(fixedEvtParamsetList.get(i).getAlrtEvtParamSetVO().getTO_VALUE());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setFROM_VALUE(fixedEvtParamsetList.get(i).getAlrtEvtParamSetVO().getFROM_VALUE());

		    evtParamsList.add(newRowCO);
		}

	    }
	    else
	    {
		subEvtParamsList = subscriptionDAO.loadSubEvtParam(sc);
		evtParamsList.clear();
		for(int i = 0; i < subEvtParamsList.size(); i++)
		{

		    SubscriptionCO newRowCO = new SubscriptionCO();

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setFIXED_CODE(subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getFIXED_CODE());

		    newRowCO.getAlrtSubscriptionParamVO().setFIXED_OPERATOR(
			    subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setTO_VALUE(subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setFROM_VALUE(subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setID(subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getID());

		    newRowCO.getAlrtSubscriptionParamVO()
			    .setOLD_TO_VALUE(subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getOLD_TO_VALUE());

		    newRowCO.getAlrtSubscriptionParamVO().setOLD_FROM_VALUE(
			    subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getOLD_FROM_VALUE());

		    newRowCO.getAlrtSubscriptionParamVO().setOLD_FIXED_OPERATOR(
			    subEvtParamsList.get(i).getAlrtSubscriptionParamVO().getOLD_FIXED_OPERATOR());

		    newRowCO.setFixedFlag(subEvtParamsList.get(i).getAlrtFixedParamVO().getFIXED_FLAG());

		    newRowCO.setFixedLabel(subEvtParamsList.get(i).getAlrtFixedParamVO().getFIXED_LABEL());

		    newRowCO.setParamType(subEvtParamsList.get(i).getAlrtFixedParamVO().getPARAM_TYPE());

		    evtParamsList.add(newRowCO);
		}

		// subscriptionDAO.deleteSubEvtParam(sc);
		subEvtParamsList.clear();
	    }

	    subsc.setEvt_id(fixed_event_id);
	    fixedParamsList = subscriptionDAO.loadFixedParamsList(subsc);
	    for(int i = 0; i < fixedParamsList.size(); i++)
	    {
		SubscriptionCO evtParamsCO = evtParamsList.get(i);
		evtParamsCO.setFixedFlag(fixedParamsList.get(i).getAlrtFixedParamVO().getFIXED_FLAG());
		evtParamsCO.setFixedLabel(fixedParamsList.get(i).getAlrtFixedParamVO().getFIXED_LABEL());
		evtParamsCO.setParamType(fixedParamsList.get(i).getAlrtFixedParamVO().getPARAM_TYPE());

	    }

	}

	return evtParamsList;
    }

    @Override
    public SubscriptionCO populateSubscription(SubscriptionSC sc,  SubscriptionCO subscriptionCO, String selSerialNoSG,
	    String selSerialNoEP) throws BaseException
    {
	
	List<SubscriptionCO> subGrpList = null;
	List<SubscriptionCO> evtPckgList = null;

	if(StringUtil.nullToEmpty(subscriptionCO.getSubscriptionType()).equals(SubscriptionConstant.SUB_EVENT_TYPE))
	{
	    populateSubscriberEvent(sc, subscriptionCO, selSerialNoSG, selSerialNoEP);
	    
	}
	else
	{
	    subscriptionDAO.deletePopulatedFromTmp();
	    
	    if(SubscriptionConstant.SUBSCRIBER_TYPE.equals(subscriptionCO.getGridTypeSG()))
		{
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsSG()))
		    {
			sc.setSubTypeLovId(SubscriptionConstant.subTypeLovId);
			sc.setLangCode(subscriptionCO.getLanguage());
			sc.setNbRec(-1);
			subGrpList = subscriptionDAO.loadSubscribersGrid(sc);
			// subGrpList = subscriptionDAO.loadSubscribersGrid(sc);

		    }
		    else
		    {
			selSerialNoSG = selSerialNoSG.replace("\\", "");
			String[] array = selSerialNoSG.split("SUB_ID");

			for(int i = 1; i < array.length; i++)
			{
			    SubscriptionSC sc1 = new SubscriptionSC();

			    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

			    sc1.setSUB_ID(new BigDecimal(array[i]));

			    sc.getArrayListSG().add(sc1);

			}

			sc.setSubTypeLovId(SubscriptionConstant.subTypeLovId);
			sc.setLangCode(subscriptionCO.getLanguage());
			sc.setEnable_omni(AlrtCommonConstants.isOmniInstalled);
			subGrpList = subscriptionDAO.subscribersListSelected(sc);
		    }
		}
		else if(SubscriptionConstant.GROUP_TYPE.equals(subscriptionCO.getGridTypeSG()))
		{
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsSG()))
		    {

			sc.setLangCode(subscriptionCO.getLanguage());
			sc.setNbRec(-1);
			subGrpList = subscriptionDAO.loadGroupsGrid(sc);
			// subGrpList = subscriptionDAO.loadSubscribersGrid(sc);

		    }
		    else
		    {
			selSerialNoSG = selSerialNoSG.replace("\\", "");
			String[] array = selSerialNoSG.split("GRP_ID");

			for(int i = 1; i < array.length; i++)
			{
			    SubscriptionSC sc1 = new SubscriptionSC();

			    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

			    sc1.setGRP_ID(new BigDecimal(array[i]));

			    sc.getArrayListSG().add(sc1);

			}

			sc.setLangCode(subscriptionCO.getLanguage());
			subGrpList = subscriptionDAO.groupsListSelected(sc);
		    }
		}
		if(SubscriptionConstant.EVENT_TYPE.equals(subscriptionCO.getGridTypeEP()))
		{
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsEP()))
		    {

			sc.setEventModeLovId(SubscriptionConstant.EventModeLovId);
			sc.setEventTypeLovId(SubscriptionConstant.EventTypeLovIds);
			sc.setSuspendedLovType(SubscriptionConstant.SuspendedLovType);
			sc.setSubStatus(SubscriptionConstant.subStatus);
			sc.setEvtLovTypeId(SubscriptionConstant.EventTypeLovIds);
			sc.setLangCode(subscriptionCO.getLanguage());
			sc.setNbRec(-1);
			evtPckgList = subscriptionDAO.loadEventsGrid(sc);
			// subGrpList = subscriptionDAO.loadSubscribersGrid(sc);

		    }
		    else
		    {
			selSerialNoEP = selSerialNoEP.replace("\\", "");
			String[] array = selSerialNoEP.split("EVT_ID");

			for(int i = 1; i < array.length; i++)
			{
			    SubscriptionSC sc1 = new SubscriptionSC();

			    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

			    sc1.setEVT_ID(new BigDecimal(array[i]));

			    sc.getArrayListSG().add(sc1);

			}
			sc.setEventModeLovId(SubscriptionConstant.EventModeLovId);
			sc.setEventTypeLovId(SubscriptionConstant.EventTypeLovIds);
			sc.setSuspendedLovType(SubscriptionConstant.SuspendedLovType);
			sc.setSubStatus(SubscriptionConstant.subStatus);
			sc.setLangCode(subscriptionCO.getLanguage());
			evtPckgList = subscriptionDAO.loadSelectedEventsGrid(sc);
		    }
		}
		else if(SubscriptionConstant.PACKAGE_TYPE.equals(subscriptionCO.getGridTypeEP()))
		{
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsEP()))
		    {

			sc.setNbRec(-1);
			evtPckgList = subscriptionDAO.loadPackageGrid(sc);
			// subGrpList = subscriptionDAO.loadSubscribersGrid(sc);

		    }
		    else
		    {
			selSerialNoEP = selSerialNoEP.replace("\\", "");
			String[] array = selSerialNoEP.split("PKG_ID");

			for(int i = 1; i < array.length; i++)
			{
			    SubscriptionSC sc1 = new SubscriptionSC();

			    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

			    sc1.setPKG_ID(new BigDecimal(array[i]));

			    sc.getArrayListSG().add(sc1);

			}
			sc.setLangCode(subscriptionCO.getLanguage());
			sc.setNbRec(-1);
			evtPckgList = subscriptionDAO.loadSelectedPckgGrid(sc);
		    }
		}
		// if(allRowsG ==1 ){

		BigDecimal subId = null, grpId = null;
		String subType = null, subDesc = null, grpDesc = null;
		int k = 0;
		List<ALRT_SUB_EVT_TMPVO> listAlrtSubEvtTmp = new ArrayList<ALRT_SUB_EVT_TMPVO>();
		for(int i = 0; i < subGrpList.size(); i++)
		{

		    if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType())
			    || SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
		    {

			subId = subGrpList.get(i).getAlrtSubVO().getID();
			subType = subGrpList.get(i).getSubType();
			subDesc = subGrpList.get(i).getSubDesc();

		    }
		    else
		    {
			grpId = subGrpList.get(i).getAlrtGrpVO().getGRP_ID();
			grpDesc = subGrpList.get(i).getAlrtGrpVO().getBRIEF_DESC_ENG();
		    }
		    ALRT_SUB_EVT_TMPVO alrtSubEvtTmpVO = new ALRT_SUB_EVT_TMPVO();

		    if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType())
			    || SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
		    {
			
			//in sub-evt
			for(int j = 0; j < evtPckgList.size(); j++)
			{

			    if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
			    {

				alrtSubEvtTmpVO.setSUB_ID(subId);
				
				//get the details related to this subscriber ID
				sc.setSUB_ID(subId);
				sc.setLangCode(subscriptionCO.getLanguage());
				//SubscriptionCO subscriberDetailsCO = subscriptionDAO.returnDetailsForSubscriber(sc);
				alrtSubEvtTmpVO.setUSR_ID(subGrpList.get(i).getAlrtSubVO().getUSR_ID());
				alrtSubEvtTmpVO.setCIF_NO(subGrpList.get(i).getAlrtSubVO().getCIF_NO());
				alrtSubEvtTmpVO.setMOBILE_PHONE(subGrpList.get(i).getAlrtSubVO().getMOBILE_PHONE());
				alrtSubEvtTmpVO.setEMAIL_ID(subGrpList.get(i).getAlrtSubVO().getEMAIL_ID());
				alrtSubEvtTmpVO.setCHANNEL_END_USR_ID(subGrpList.get(i).getAlrtSubVO().getCHANNEL_END_USR_ID());
				alrtSubEvtTmpVO.setFULL_NAME_ENG(subGrpList.get(i).getAlrtSubLangVO().getBRIEF_NAME());
			    }
			    else
			    {
				alrtSubEvtTmpVO.setSUB_ID(grpId);
				alrtSubEvtTmpVO.setFULL_NAME_ENG(grpDesc);
			    }

			    alrtSubEvtTmpVO.setEVT_ID(evtPckgList.get(j).getAlrtEvtVO().getEVT_ID());
			    alrtSubEvtTmpVO.setEVT_DESC_ENG(evtPckgList.get(j).getAlrtEvtVO().getDESC_ENG());
			    alrtSubEvtTmpVO.setEVT_TYPE(evtPckgList.get(j).getEvtType());
			    alrtSubEvtTmpVO.setSRC_CONTACT_TYPE(evtPckgList.get(j).getAlrtEvtVO().getSOURCE_OF_CONTACT());
			    alrtSubEvtTmpVO.setSUB_EVT_STATUS(AlertConstant.STATUS_NEW_CREADTED);
			    // alrtSubEvtTmpVO.setREL_ID(evtPckgList.get(j).getAlrtSubEvtTmpVO().getREL_ID());

			    // alrtSubEvtTmpVO.setREL_ID(new BigDecimal(k));
			    alrtSubEvtTmpVO.setREL_TYPE(subscriptionCO.getSubscriptionType());
			    alrtSubEvtTmpVO.setID(new BigDecimal(k));
//			    int row = genericDAO.insert(alrtSubEvtTmpVO);
			    genericDAO.insert(alrtSubEvtTmpVO);
			    listAlrtSubEvtTmp.add(alrtSubEvtTmpVO);
			    k++;
			}
			// alrtSubEvtTmpVO
		    }
		    else
		    {
			for(int j = 0; j < evtPckgList.size(); j++)
			{
			    if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
			    {

				alrtSubEvtTmpVO.setSUB_ID(subId);
				alrtSubEvtTmpVO.setSUB_TYPE(subType);
				alrtSubEvtTmpVO.setFULL_NAME_ENG(subDesc);
			    }
			    else
			    {
				alrtSubEvtTmpVO.setSUB_ID(grpId);
				alrtSubEvtTmpVO.setFULL_NAME_ENG(grpDesc);
			    }

			    alrtSubEvtTmpVO.setEVT_ID(evtPckgList.get(j).getAlrtPkgVO().getPKG_ID());
			    alrtSubEvtTmpVO.setEVT_DESC_ENG(evtPckgList.get(j).getAlrtPkgVO().getBRIEF_DESC_ENG());
			    alrtSubEvtTmpVO.setSUB_EVT_STATUS(AlertConstant.STATUS_NEW_CREADTED);
			    // alrtSubEvtTmpVO.setREL_ID(evtPckgList.get(j).getAlrtSubEvtTmpVO().getREL_ID());

			    // alrtSubEvtTmpVO.setREL_ID(new BigDecimal(k));
			    alrtSubEvtTmpVO.setREL_TYPE(subscriptionCO.getSubscriptionType());
			    alrtSubEvtTmpVO.setID(new BigDecimal(k));
//			    int row = genericDAO.insert(alrtSubEvtTmpVO);
			    genericDAO.insert(alrtSubEvtTmpVO);
			    listAlrtSubEvtTmp.add(alrtSubEvtTmpVO);
			    k++;
			}
		    }

		}
	}
	
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    //subscriptionCO.setRow(subscriptionDAO.updateExistingSubEvt(subscriptionCO));
	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setRow(subscriptionDAO.updateExistingSubPckg(subscriptionCO));
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setRow(subscriptionDAO.updateExistingEvtGrp(subscriptionCO));
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setRow(subscriptionDAO.updateExistingGrpPckg(subscriptionCO));
	}
	return subscriptionCO;
    }

    private SubscriptionCO populateSubscriberEvent(SubscriptionSC sc, SubscriptionCO subscriptionCO, String selSerialNoSG,
	    String selSerialNoEP) throws BaseException
    {
	StringBuilder subIds = new StringBuilder();
	StringBuilder eventIds = new StringBuilder();
	
	if(!ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsSG()))
	{
	    /**
	     * 
	     * Add Subscriber Ids to SC
	     */
	    selSerialNoSG = selSerialNoSG.replace("\\", "");
	    String[] array = selSerialNoSG.split("SUB_ID");

	    for(int i = 1; i < array.length; i++)
	    {
		    SubscriptionSC sc1 = new SubscriptionSC();

		    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

		    sc1.setSUB_ID(new BigDecimal(array[i]));

		    sc.getArrayListSG().add(sc1);
	    }
	}
	

	if(!ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsEP()))
	{
	    /**
	     * Add Event Ids to SC
	     */
	    selSerialNoEP = selSerialNoEP.replace("\\", "");
	    String[] array = selSerialNoEP.split("EVT_ID");

	    for(int i = 1; i < array.length; i++)
	    {
		    SubscriptionSC sc1 = new SubscriptionSC();

		    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);

		    sc1.setEVT_ID(new BigDecimal(array[i]));

		    sc.getArrayListEP().add(sc1);

	    }
	}
	
	sc.setSubIds(StringUtil.isEmptyString(subIds.toString()) ? null : subIds.toString());
	sc.setEvtIds(StringUtil.isEmptyString(eventIds.toString()) ? null : eventIds.toString());
	sc.setRelType(subscriptionCO.getSubscriptionType());
	sc.setSubTypeLovId(SubscriptionConstant.subTypeLovId);
	sc.setLangCode(subscriptionCO.getLanguage());
	sc.setCompCode(subscriptionCO.getCompCode());
	sc.setUserId(subscriptionCO.getUserID());
	sc.setNbRec(-1);
	sc.setAllRowsSub(subscriptionCO.getAllRowsSG());
	sc.setAllRowsEvt(subscriptionCO.getAllRowsEP());
	
	deletePopulatedFromTmp();
	
	int rows = subscriptionDAO.saveALRT_SUB_EVT_TMP(sc);
	
//	if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsSG()) && ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsEP()))
//	{
//	     rows = subscriptionDAO.saveBulkINALRT_SUB_EVT_TEMP(sc);
//	}
//	else
//	{
//	    rows = subscriptionDAO.saveALRT_SUB_EVT_TMP(sc);
//	}
	
	return subscriptionCO;
    }
    
    @Override
    public List<SubscriptionCO> loadSubscriptionDetailsGrid(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.loadSubscriptionDetailsGrid(sc);
    }

    @Override 
    public Integer subscriptionDetailsCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscriptionDetailsCount(sc);
    }

    @Override
    public SubscriptionCO viewStatusDetail(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.viewStatusDetail(sc);
    }

    @Override
    public List<SubscriptionCO> loadGroupsGrid(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.loadGroupsGrid(sc);
    }

    @Override
    public Integer groupsCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.groupsCount(sc);
    }

    @Override
    public List<SubscriptionCO> loadPackageGrid(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.loadPackageGrid(sc);
    }

    @Override
    public Integer packageCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.packageCount(sc);
    }

    @Override
    public List<SubscriptionCO> loadSubscribersGrid(SubscriptionSC sc) throws BaseException
    {
    sc.setEnable_omni(AlrtCommonConstants.isOmniInstalled);
	return subscriptionDAO.loadSubscribersGrid(sc);
    }

    @Override
    public Integer subscribersCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscribersCount(sc);
    }

    @Override
    public List<SubscriptionCO> loadEventsGrid(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.loadEventsGrid(sc);
    }

    @Override
    public Integer eventsCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.eventsCount(sc);
    }

    public SubscriptionDAO getSubscriptionDAO()
    {
	return subscriptionDAO;
    }

    public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO)
    {
	this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public Integer subscriberEvtCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscriberEvtCount(sc);
    }
    
    @Override
    public Integer subscriberAllEvtCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscriberAllEvtCount(sc);
    }

    @Override
    public List subscriberEvtList(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscriberEvtList(sc);
    }
    
    @Override
    public List subscriberAllEvtList(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.subscriberAllEvtList(sc);
    }
    
    @Override
    public void deletePopulatedFromTmp() throws BaseException
    {
		SubscriptionSC sc = new SubscriptionSC();
		/**
		 * Truncate Table
		 */
		subscriptionDAO.truncateTableALRT_SUB_EVT_TMP(sc);
    }

    @Override
    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> onInitializeVisibilities(
	    SubscriptionCO subscriptionCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(subscriptionCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(subscriptionCO.getAppName(), subscriptionCO.getProgRef()));
	reqFieldSC.setAppName(subscriptionCO.getAppName());
	reqFieldSC.setBranchCode(subscriptionCO.getBranchCode());

	applyDynScreenDisplay(
		new String[] { "subscriptionMaint_view_sub_details", "subscriptionMaint_view_status_details",
			"subscriptionMaint_delete_selected", "subscriptionMaint_save_populated" },
		ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(), reqFieldSC);

	if(AlertConstant.CRUD_R.equals(subscriptionCO.getIvCrud()))
	{
	    applyDynScreenDisplay(
		    new String[] { "subscriptionMaint_approve", "subscriptionMaint_toBeDeleted","subscriptionMaint_updateAfterApprove",
			    "subscriptionMaint_reject","subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
		    reqFieldSC);
	}
	else if(AlertConstant.CRUD_UP.equals(subscriptionCO.getIvCrud()))
	{
	    applyDynScreenDisplay(new String[] {"subscriptionMaint_approve", "subscriptionMaint_toBeDeleted",
		    "subscriptionMaint_reject","subscriptionMaint_save_populated","subscriptionMaint_toBeSuspend","subscriptionMaint_suspend",
		    "subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_updateAfterApprove" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);
	}
	else
	{

	    if(AlertConstant.CRUD_P.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_view_sub_details" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_approve", "subscriptionMaint_reject","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_D.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_approve","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_delete_selected","subscriptionMaint_reject" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_TS.equals(subscriptionCO.getIvCrud()) || AlertConstant.CRUD_TS_SUBS_PKG.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_approve","subscriptionMaint_updateAfterApprove",
			   	    	 	     "subscriptionMaint_suspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeSuspend"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_S.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_approve","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_toBeReactivate","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_suspend"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_TR.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_approve","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_reactivate" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeReactivate"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else if(AlertConstant.CRUD_RA.equals(subscriptionCO.getIvCrud()))
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject","subscriptionMaint_approve","subscriptionMaint_updateAfterApprove",
						     "subscriptionMaint_toBeSuspend","subscriptionMaint_suspend","subscriptionMaint_toBeReactivate"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
			reqFieldSC);
		applyDynScreenDisplay(new String[] {"subscriptionMaint_reactivate"},
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

	    }
	    else
	    {
		applyDynScreenDisplay(new String[] { "subscriptionMaint_toBeDeleted", "subscriptionMaint_reject" },
			ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(),
			reqFieldSC);

		applyDynScreenDisplay(new String[] { "subscriptionMaint_approve" }, ConstantsCommon.ACTION_TYPE_VISIBLE,
			BigDecimal.ZERO.toString(), subscriptionCO.getHm(), reqFieldSC);
	    }
	    applyDynScreenDisplay(new String[] { "subscriptionMaint_populate_sub", "subscriptionMaint_retrieve_sub","subscriptionMaint_updateAfterApprove" },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), subscriptionCO.getHm(),
		    reqFieldSC);

	}
	return subscriptionCO.getHm();
    }

    @Override
    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> afterPopulateVisibility(
	    SubscriptionCO subscriptionCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(subscriptionCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(subscriptionCO.getAppName(), subscriptionCO.getProgRef()));
	reqFieldSC.setAppName(subscriptionCO.getAppName());
	reqFieldSC.setBranchCode(subscriptionCO.getBranchCode());

	applyDynScreenDisplay(
		new String[] { "subscriptionMaint_view_sub_details", "subscriptionMaint_view_status_details", "subscriptionMaint_save_populated" },
		ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), subscriptionCO.getHm(), reqFieldSC);

	BigDecimal disabled = BigDecimal.ZERO;
	if(NumberUtil.nullToZero(subscriptionCO.getRow()) > 0)
	{
	    disabled = BigDecimal.ZERO;
	}
	else
	{
	    disabled = BigDecimal.ONE;
	}

	applyDynScreenDisplay(
		new String[] { "subscriptionMaint_view_sub_details", "subscriptionMaint_view_status_details"},
		ConstantsCommon.ACTION_TYPE_READONLY, disabled.toString(), subscriptionCO.getHm(), reqFieldSC);

	return subscriptionCO.getHm();

    }

    @Override
    public Map<? extends String, ? extends SYS_PARAM_SCREEN_DISPLAYVO> afterUpdateVisibility(
	    SubscriptionCO subscriptionCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(subscriptionCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(subscriptionCO.getAppName(), subscriptionCO.getProgRef()));
	reqFieldSC.setAppName(subscriptionCO.getAppName());
	reqFieldSC.setBranchCode(subscriptionCO.getBranchCode());

	BigDecimal disabled = BigDecimal.ZERO;
	if(NumberUtil.nullToZero(subscriptionCO.getRow()) > 0)
	{
	    disabled = BigDecimal.ZERO;
	}
	else
	{
	    disabled = BigDecimal.ONE;
	}

	applyDynScreenDisplay(
		new String[] { "subscriptionMaint_view_sub_details", "subscriptionMaint_view_status_details",
			"subscriptionMaint_delete_selected" },
		ConstantsCommon.ACTION_TYPE_READONLY, disabled.toString(), subscriptionCO.getHm(), reqFieldSC);

	return subscriptionCO.getHm();

    }

    @Override
    public SubscriptionCO deleteSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
    	SubscriptionSC subscriptionSC = new SubscriptionSC();
    	//WS required
    	if(subscriptionCO.getSelSerialNoDet() == null)
    	{
    		subscriptionSC.setToBeStatus("");
    		subscriptionSC.setToBeStatusBy("");
    		subscriptionSC.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
    		subscriptionSC.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
    		subscriptionSC.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
    		subscriptionSC.setStatus(AlertConstant.STATUS_DELETED);
    		subscriptionSC.setUserId(subscriptionCO.getUserID());
    		subscriptionSC.setRunningDate(commonLibBO.returnSystemDateNoTime());
    		//to be delete subscribtions
    		subscriptionDAO.toBeDeletedSubscription(subscriptionSC);
    		
    		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
    		{
    			subscriptionSC.setType(SubscriptionConstant.SUB_EVENT_TYPE);
    			subscriptionSC.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
    			//to be delete subscribtions
    			subscriptionDAO.toBeDeletedSubscription(subscriptionSC);
    		}
    		return subscriptionCO;
    	}
    	
    	if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
    			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
    			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			alrt_SUB_PKGVO = (ALRT_SUB_PKGVO) genericDAO.selectByPK(alrt_SUB_PKGVO);
    			alrt_SUB_PKGVO.setSTATUS(AlertConstant.STATUS_DELETED);
    			alrt_SUB_PKGVO.setDELETED_BY(subscriptionCO.getUserID());
    			alrt_SUB_PKGVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtSubPkgVO().setCREATED_BY(alrt_SUB_PKGVO.getTO_BE_STATUS_BY());
    			//clear to be status
    			alrt_SUB_PKGVO.setTO_BE_STATUS("");
    			alrt_SUB_PKGVO.setTO_BE_STATUS_BY("");
    			continueToProcessSubPkg(subscriptionCO, alrt_SUB_PKGVO, null);
    			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
    		}
    		return subscriptionCO;
    	}
    	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
    			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
    			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			alrt_EVT_GRPVO = (ALRT_EVT_GRPVO) genericDAO.selectByPK(alrt_EVT_GRPVO);
    			alrt_EVT_GRPVO.setSTATUS(AlertConstant.STATUS_DELETED);
    			alrt_EVT_GRPVO.setDELETED_BY(subscriptionCO.getUserID());
    			alrt_EVT_GRPVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtEvtGrpVO().setCREATED_BY(alrt_EVT_GRPVO.getTO_BE_STATUS_BY());
    			//Clear To be status
    			alrt_EVT_GRPVO.setTO_BE_STATUS("");
    			alrt_EVT_GRPVO.setTO_BE_STATUS_BY("");
    			continueToProcessGrpEvt(subscriptionCO, alrt_EVT_GRPVO, null);
    			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
    		}
    		return subscriptionCO;
    	}
    	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
    			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
    			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			alrt_GRP_PKGVO = (ALRT_GRP_PKGVO) genericDAO.selectByPK(alrt_GRP_PKGVO);
    			alrt_GRP_PKGVO.setSTATUS(AlertConstant.STATUS_DELETED);
    			alrt_GRP_PKGVO.setDELETED_BY(subscriptionCO.getUserID());
    			alrt_GRP_PKGVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtGrpPkgVO().setCREATED_BY(alrt_GRP_PKGVO.getTO_BE_STATUS_BY());
    			//clear to be status
    			alrt_GRP_PKGVO.setTO_BE_STATUS("");
    			alrt_GRP_PKGVO.setTO_BE_STATUS_BY("");
    			continueToProcessGrpPkg(subscriptionCO, alrt_GRP_PKGVO, null);
    			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
    		}
    		return subscriptionCO;
    	}
    	
		if(ConstantsCommon.ONE.equals(subscriptionCO.getPopulatedYN()))
		{
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsDet()))
		    {
		    	subscriptionDAO.deleteSubEvtTmp();
		    }
		    else
		    {
				SubscriptionSC sc = new SubscriptionSC();
				subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
				String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		
				for(int i = 1; i < array.length; i++)
				{
				    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				    String[] innerArray = array[i].split("~");
				    sc.setSUB_ID(new BigDecimal(innerArray[0]));
				    sc.setEVT_ID(new BigDecimal(innerArray[1]));
				    subscriptionDAO.deleteSubEvtTmpByID(sc);
				}
		    }
		}
		else
		{
		    SubscriptionSC sc = new SubscriptionSC();
		    sc.setType(subscriptionCO.getSubscriptionType());
		    
		    if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsDet()))
		    {
		    	subscriptionDAO.deleteSubscriptions(sc);
		    }
		    else
		    {
				subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
				String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		
				ALRT_SUB_EVTVO alertSubEvtVo = null;
				for(int i = 1; i < array.length; i++)
				{
				    array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				    String[] innerArray = array[i].split("~");
				    sc.setSUB_ID(new BigDecimal(innerArray[0]));
				    sc.setEVT_ID(new BigDecimal(innerArray[1]));
				    sc.setPKG_ID(new BigDecimal(innerArray[1]));
				    sc.setGRP_ID(new BigDecimal(innerArray[0]));
				    List<SubscriptionCO> list = subscriptionDAO.returnEvtSubDetails(sc);
				    if(list != null && !list.isEmpty())
				    {
				    	alertSubEvtVo = list.get(0).getAlrtSubEvtVO();
				    	alertSubEvtVo.setSTATUS(AlertConstant.STATUS_DELETED);
				    	alertSubEvtVo.setDELETED_BY(subscriptionCO.getUserID());
				    	alertSubEvtVo.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
				    	//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
		    			subscriptionCO.getAlrtSubEvtVO().setCREATED_BY(alertSubEvtVo.getTO_BE_STATUS_BY());
		    			//clear to be status 
		    			alertSubEvtVo.setTO_BE_STATUS("");
		    			alertSubEvtVo.setTO_BE_STATUS_BY("");
				    	continueToProcessEvtSub(subscriptionCO, alertSubEvtVo, null);
				    }//end list if
				}//end for loop
		    }//end else
		}//end outer else
		return subscriptionCO;
    }

    @Override
    public SubscriptionCO updateSubDetailsParams(SubscriptionCO subscriptionCO,
	    ArrayList<SubscriptionCO> toBeUpdatedParamList) throws BaseException
    {
	BigDecimal from, to = null;
	for(int i = 0; i < toBeUpdatedParamList.size(); i++)
	{
	    if(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE().isEmpty())
	    {
		to = AlertConstant.MINUS_ONE;
	    }
	    else
	    {
		to = new BigDecimal(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE());
	    }
	    if(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE().isEmpty())
	    {
		from = AlertConstant.MINUS_ONE;
	    }
	    else
	    {
		from = new BigDecimal(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE());
	    }
	    if(AlertConstant.PARAM_TYPE_3.equals(toBeUpdatedParamList.get(i).getParamType())
		    || AlertConstant.PARAM_TYPE_4.equals(toBeUpdatedParamList.get(i).getParamType()))
	    {
		if(!NumberUtil.isNumber(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())
			&& StringUtil
				.isNotEmpty(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())
			&& null != toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())
		{
		    throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_NUMBER_FROM_VALUE);
		}
		else if(!NumberUtil.isNumber(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
			&& StringUtil.isNotEmpty(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
			&& null != toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
		{
		    throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_NUMBER_TO_VALUE);
		}

		if(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE() != ""
			&& !ConstantsCommon.ZERO
				.equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())

			&& (from.compareTo(BigDecimal.ZERO) <= 0 || from.compareTo(new BigDecimal("2147483647")) > 0))
		{
		    throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_FROM_VALUE);
		}
		if(StringUtil.isNotEmpty(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
			&& !ConstantsCommon.ZERO
				.equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())

			&& (BigDecimal.ZERO.compareTo(to) > 0 || (new BigDecimal("2147483647")).compareTo(to) <= 0))
		{
		    throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID__TO_VALUE);
		}
	    }

	    if(!AlertConstant.EVT_MODE_B.equals(toBeUpdatedParamList.get(i).getFixedFlag())
		    && !AlertConstant.EVT_MODE_S.equals(toBeUpdatedParamList.get(i).getFixedFlag()))
	    {

		if(!AlertConstant.FixedOperator_B
			.equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR())
			|| !StringUtil.isNotEmpty(
				toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR())
			|| toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR() == null)
		{
		    toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().setTO_VALUE("");

		    if(!(ConstantsCommon.ZERO
			    .equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())
			    || !StringUtil.isNotEmpty(
				    toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE()))
			    && (toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR().isEmpty()
				    || toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO()
					    .getFIXED_OPERATOR() == null))
		    {
			throw new BOException(MessageCodes.PLEASE_ENTER_THE_OPERATOR_VALUE);
		    }
		}
		else if(AlertConstant.FixedOperator_B
			.equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFIXED_OPERATOR()))
		{
		    if(ConstantsCommon.ZERO
			    .equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())
			    || toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE().isEmpty())
		    {
			throw new BOException(MessageCodes.PLEASE_ENTER_THE_FROM_VALUE);
		    }
		    else if(ConstantsCommon.ZERO
			    .equals(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
			    || toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE().isEmpty())
		    {
			throw new BOException(MessageCodes.PLEASE_ENTER_THE_TO_VALUE);
		    }
		    else if(new BigDecimal(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE())
			    .compareTo(new BigDecimal(
				    toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE())) < 0)
		    {
			throw new BOException(MessageCodes.TO_VAL_MUST_BE_GREATER_THAN_FROM_VAL);
		    }
		}
		if(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE().isEmpty()
			&& toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getTO_VALUE().isEmpty())
		{
		    toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().setFIXED_OPERATOR("");
		}

		if(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO().getFROM_VALUE().isEmpty())
		{
		    throw new BOException(MessageCodes.YOU_MUST_ENT_AT_LEAST_ONE_VAL);
		}

		toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO()
			.setID(subscriptionCO.getAlrtSubEvtTmpVO().getID());
	    }
	    int row = genericDAO.update(toBeUpdatedParamList.get(i).getAlrtSubscriptionParamVO());
	    if(row >= 1)
	    {
		subscriptionCO.getAlrtSubEvtTmpVO().setSUB_EVT_STATUS(AlertConstant.STATUS_ACTIVE);
		genericDAO.update(subscriptionCO.getAlrtSubEvtTmpVO());
		subscriptionCO.getAlrtSubEvtVO().setSTATUS(AlertConstant.STATUS_ACTIVE);
		subscriptionCO.getAlrtSubEvtVO().setID(subscriptionCO.getAlrtSubEvtTmpVO().getID());
		genericDAO.update(subscriptionCO.getAlrtSubEvtVO());
		// ALRT_SUB_EVTVO subEvtVo = new ALRT_SUB_EVTVO();
		// subEvtVo.setSUB_ID(subscriptionCO.getAlrtSubEvtTmpVO().getSUB_ID());
		// subEvtVo.setEVT_ID(subscriptionCO.getAlrtSubEvtTmpVO().getEVT_ID());
		// subEvtVo.setSTATUS(AlertConstant.STATUS_ACTIVE);
		// subEvtVo.setMODIFIED_BY(subscriptionCO.getUserID());
		// subEvtVo.setDATE_MODIFIED(subscriptionCO.getRunningDate());
		// subEvtVo.setREL_TYPE();
		// subscriptionDAO.updateSubEvt(subEvtVo);
	    }
	}
	return subscriptionCO;
    }

    @Override
    public void updateExcludeTable(ArrayList<SubscriptionCO> subscriptionCOlst) throws BaseException
    {
	ALRT_SUB_EVT_COMM_MODE_EXCLVO alrtComModeExclVO;
	SubscriptionCO subsCO;
	BigDecimal relID;
	SubscriptionSC sc;
	// update exclude table
	if(subscriptionCOlst != null && !subscriptionCOlst.isEmpty())
	{
	    alrtComModeExclVO = new ALRT_SUB_EVT_COMM_MODE_EXCLVO();
	    for(int i = 0; i < subscriptionCOlst.size(); i++)
	    {
		subsCO = subscriptionCOlst.get(i);
		sc = new SubscriptionSC();
		sc.setSUB_ID(subsCO.getAlrtSubEvtTmpVO().getSUB_ID());
		sc.setEVT_ID(subsCO.getAlrtSubEvtTmpVO().getEVT_ID());
		relID = subscriptionDAO.returnRelID(sc);
		sc.setREL_ID(relID);
		ArrayList<String> excludedModesList = subsCO.getExcludedModesList();
		//delete all exclude mode before the insert
		subscriptionDAO.deleteExcludedModesListByID(sc);
		
		for(int j = 0; j < excludedModesList.size(); j++)
		{
		    alrtComModeExclVO.setSUBSCRIPTION_ID(relID);
		    alrtComModeExclVO.setCOMMUNICATION_TYPE(excludedModesList.get(j));
		    genericDAO.insert(alrtComModeExclVO);
		}
	    }
	}
    }
    
    //update SRC_CONTACT_TYPE in ALRT_SUB_EVT_TMP table for subscriptions of type SE
    public void updateTempTable(ArrayList lstMod) throws BaseException
    {
    	if(lstMod!=null) {
    		SubscriptionCO subCO;
    		ALRT_SUB_EVT_TMPVO lVO;
    		Iterator<SubscriptionCO> itMod = lstMod.iterator();
    		while(itMod.hasNext())
    		{
    			subCO = itMod.next();
    			lVO = subCO.getAlrtSubEvtTmpVO();
    			lVO.setID(null);
    			lVO.setSRC_CONTACT_TYPE(subCO.getAlrtSubEvtVO().getSRC_CONTACT_TYPE());
    			genericDAO.update(lVO);
    		}
    	}
    }
    
    @Override
    public SubscriptionCO saveSubscription(SubscriptionCO subscriptionCO, ArrayList lstMod) throws BaseException
    {
	
	    
	    if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType())
		    && BigDecimal.ONE.equals(subscriptionCO.getAllRowsSE()))
	    {
		saveBulkSubEventSubscription(subscriptionCO);
		return subscriptionCO;
	    }
	    
	    updateTempTable(lstMod);
	    SubscriptionSC sc = new SubscriptionSC();
	    SubscriptionCO subsCO;
	    ALRT_SUB_EVT_COMM_MODE_EXCLVO alrtComModeExclVO;
	    JSONObject jsonFilter,jsonGridArrayModel;
	    JSONArray jsonGridArray;
	    String excludeYn;
	    if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	    {
		sc.setType(SubscriptionConstant.SUB_EVENT_TYPE);
	    }
	    else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	    {
		sc.setType(SubscriptionConstant.SUB_PCKG_TYPE);
	    }
	    else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	    {
		sc.setType(SubscriptionConstant.EVENT_GRP_TYPE);
	    }
	    else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	    {
		sc.setType(SubscriptionConstant.GRP_PCKG_TYPE);
	    }
		
	    subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
	    String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
	    SubscriptionSC tempSc = new SubscriptionSC();
	    tempSc.setType(sc.getType());
	    for(int a = 1; a < array.length; a++)
	    {
		array[a] = array[a].substring(3, array[a].indexOf("}") - 1);
		String[] innerArray = array[a].split("~");
		tempSc.setSUB_ID(new BigDecimal(innerArray[0]));
		tempSc.setEVT_ID(new BigDecimal(innerArray[1]));
		tempSc.setPKG_ID(new BigDecimal(innerArray[1]));
		tempSc.setGRP_ID(new BigDecimal(innerArray[0]));
		tempSc.setNbRec(-1);
		tempSc.setSubStatus(SubscriptionConstant.subStatus);
		tempSc.setEventModeLovId(SubscriptionConstant.EventModeLovId);
		tempSc.setEventTypeLovId(SubscriptionConstant.EventTypeLovIds);
		tempSc.setSuspendedLovType(SubscriptionConstant.SuspendedLovType);
		tempSc.setLangCode(subscriptionCO.getLanguage());
		List<SubscriptionCO> ListColData = subscriptionDAO.subscriberEvtListAll(tempSc);
		if(ListColData != null && !ListColData.isEmpty())
		{
		    for(int i = 0; i < ListColData.size(); i++)
		    {
			sc.setSUB_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
			sc.setEVT_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
			sc.setPKG_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
			sc.setGRP_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
			sc.setUserId(subscriptionCO.getUserID());
			sc.setRunningDate(commonLibBO.returnSystemDateNoTime());
			
			if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
			{
			    if(AlertConstant.STATUS_DELETED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
			    {
				subscriptionDAO.removeSubEvt(sc);
			    }
			    ALRT_SUB_EVTVO subEvtVO = new ALRT_SUB_EVTVO();
			    if(AlertConstant.STATUS_NEW_CREADTED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
			    {
				subEvtVO.setREL_TYPE(subscriptionCO.getSubscriptionType());
				subEvtVO.setSUB_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
				subEvtVO.setEVT_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
				subEvtVO.setSRC_CONTACT_TYPE(ListColData.get(i).getAlrtSubEvtVO().getSRC_CONTACT_TYPE());
				subEvtVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
				subEvtVO.setCREATED_BY(subscriptionCO.getUserID());
				subEvtVO.setDATE_CREATED(commonLibBO.returnSystemDateNoTime());

				int row = genericDAO.insert(subEvtVO);
				subscriptionCO.setRow(row);
				if(row < 1)
				{
				    throw new BOException(MessageCodes.RECORD_CHANGED);
				}
					//required for WS Added by Alim
					subscriptionCO.setAlrtSubEvtVO(subEvtVO);
					// auditBO.callAudit(null, subEvtVO,
					// subscriptionCO.getAuditRefCO());
					// auditBO.insertAudit(subscriptionCO.getAuditRefCO());
			    }
			    else
			    {
				subEvtVO.setID(ListColData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
			    }
			    //UPDATE flag
			    subscriptionCO.setPwsRelId(subEvtVO.getID());
			    subEvtVO.setREL_ID(subEvtVO.getID());
			    subEvtVO.setID(subEvtVO.getID());
			    subEvtVO.setSUB_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
			    subEvtVO.setEVT_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
			    subEvtVO.setSRC_CONTACT_TYPE(ListColData.get(i).getAlrtSubEvtVO().getSRC_CONTACT_TYPE());
					    
			    //Integer update = genericDAO.update(subEvtVO);
			    Integer update = subscriptionDAO.updateALRT_SUB_EVT(subEvtVO);
			    subscriptionCO.setRow(update);
			    
			    if(update == null || update < 1)
			    {
				throw new BOException(MessageCodes.RECORD_CHANGED);
			    }
					
			    // update exclude table
			    if(lstMod != null && !lstMod.isEmpty())
			    {
				Iterator<SubscriptionCO> itMod = lstMod.iterator();
				while(itMod.hasNext())
				{
				    subsCO = itMod.next();
				    alrtComModeExclVO = new ALRT_SUB_EVT_COMM_MODE_EXCLVO();
				    alrtComModeExclVO.setSUBSCRIPTION_ID(subEvtVO.getID());
				    if(!StringUtil.nullToEmpty(subsCO.getCustomDetails()).isEmpty())
				    {
					jsonFilter = (JSONObject) JSONSerializer.toJSON(subsCO.getCustomDetails());
					if(jsonFilter != null)
					{
					    jsonGridArray = jsonFilter.getJSONArray("root");
					    for(int j = 0; j < jsonGridArray.size(); j++)
					    {
						jsonGridArrayModel = (JSONObject) jsonGridArray.getJSONObject(j);
						alrtComModeExclVO.setCOMMUNICATION_TYPE((String) jsonGridArrayModel.get("alrtEvtCommModeVO.COMMUNICATION_TYPE"));
						excludeYn = (String) jsonGridArrayModel.get("EXCLUDE_YN");
						genericDAO.delete(alrtComModeExclVO);
						if("0".equals(excludeYn))
						{
						    genericDAO.insert(alrtComModeExclVO);
						}//End Id
					    }//End For Loop
					}//End If jsonFilter
				    }//end If custom details
				}//End iterator
			    }//end If list
			}//End If REL_TYPE
			else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
			{
			    if(AlertConstant.STATUS_DELETED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
			    {
				sc.setLineNO(ListColData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
				// subscriptionDAO.removeSubPkg(sc);
				subscriptionDAO.updateSubPkg(sc);
				subscriptionDAO.updateSubEvtStatus(sc);
			    }
			    else if(AlertConstant.STATUS_NEW_CREADTED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
			    {
				sc.setType("ALRT_SUB_PKG");
				subscriptionDAO.updateAlrtCounter(sc);
				int count = subscriptionDAO.returnSubPkgCount(sc);
				if(count > 0)
				{
				    throw new BOException(MessageCodes.SUB_PKG_SUBS_ALR_EXIST_THIS_REC_CHANG_BY_ANOTHER_USR_RETREIVE_REC_BEF_SAVE);
				}
				
				ALRT_SUB_PKGVO subPkgVO = new ALRT_SUB_PKGVO();
				
				if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
				{
				    DBSequenceSC dbSeqSC = new DBSequenceSC();
				    dbSeqSC.setSequenceName("ALRT_SUB_PKG_SEQ");
				    subPkgVO.setLINE_NO(commonLibBO.returnTableSequence(dbSeqSC));
				    //Added in order to return subscriptionId for createSingleSubscribtionSP WS
				    subscriptionCO.getAlrtSubPkgVO().setLINE_NO(subPkgVO.getLINE_NO());
				}
				
				subPkgVO.setPKG_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
				subPkgVO.setSUB_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
				subPkgVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
						    subPkgVO.setCREATED_BY(subscriptionCO.getUserID());
						    subPkgVO.setDATE_CREATED(commonLibBO.returnSystemDateNoTime());
				
						    int row = genericDAO.insert(subPkgVO);
						    subscriptionCO.setRow(row);
						    if(row < 1)
						    {
						    	throw new BOException(MessageCodes.RECORD_CHANGED);
						    }
						    //required for WS Added by Alim
						    subscriptionCO.setAlrtSubPkgVO(subPkgVO);
						    // auditBO.callAudit(null, subPkgVO,
						    // subscriptionCO.getAuditRefCO());
						    // auditBO.insertAudit(subscriptionCO.getAuditRefCO());				
						}
						int rows = subscriptionDAO.updateExistingSubPckg(subscriptionCO);
						subscriptionCO.setRow(rows);
				    }
				    else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
				    {
						if(AlertConstant.STATUS_DELETED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
						{
						    sc.setLineNO(ListColData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
						    // subscriptionDAO.removeEvtGrp(sc);
						    subscriptionDAO.updateEvtGrp(sc);
						    subscriptionDAO.updateEvtGrpStatus(sc);
						}
						else if(AlertConstant.STATUS_NEW_CREADTED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
						{
						    sc.setType("ALRT_EVT_GRP");
						    subscriptionDAO.updateAlrtCounter(sc);
						    int count = subscriptionDAO.returnEvtGrpCount(sc);
						    if(count > 0)
						    {
						    	throw new BOException(MessageCodes.GRP_EVT_SUBS_ALR_EXIST_THIS_REC_CHANG_BY_ANOTHER_USR_RETREIVE_REC_BEF_SAVE);
						    }
						    ALRT_EVT_GRPVO evtGrpVO = new ALRT_EVT_GRPVO();				
						    
						    if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
						    {
							    DBSequenceSC dbSeqSC = new DBSequenceSC();
								dbSeqSC.setSequenceName("ALRT_EVT_GRP_SEQ");
								evtGrpVO.setLINE_NO(commonLibBO.returnTableSequence(dbSeqSC));
						    }
								
						    evtGrpVO.setEVT_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
						    evtGrpVO.setGRP_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
						    evtGrpVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
						    evtGrpVO.setCREATED_BY(subscriptionCO.getUserID());
						    evtGrpVO.setDATE_CREATED(commonLibBO.returnSystemDateNoTime());
				
						    int row = genericDAO.insert(evtGrpVO);
						    subscriptionCO.setRow(row);
						    if(row < 1)
						    {
						    	throw new BOException(MessageCodes.RECORD_CHANGED);
						    }
						    //required for WS Added by Alim
						    subscriptionCO.setAlrtEvtGrpVO(evtGrpVO);
						    // auditBO.callAudit(null, evtGrpVO,
						    // subscriptionCO.getAuditRefCO());
						    // auditBO.insertAudit(subscriptionCO.getAuditRefCO());
						}
						int rows = subscriptionDAO.updateExistingEvtGrp(subscriptionCO);
						subscriptionCO.setRow(rows);
				    }
				    else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
				    {
						if(AlertConstant.STATUS_DELETED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
						{
						    sc.setLineNO(ListColData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
						    // subscriptionDAO.removeEvtGrp(sc);
						    subscriptionDAO.updateGrpPkg(sc);
						    subscriptionDAO.updateGrpPkgStatus(sc);
						}
						else if(AlertConstant.STATUS_NEW_CREADTED.equals(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS()))
						{
						    sc.setType("ALRT_GRP_PKG");
						    subscriptionDAO.updateAlrtCounter(sc);
						    int count = subscriptionDAO.returnGrpPkgCount(sc);
						    if(count > 0)
						    {
						    	throw new BOException(MessageCodes.GRP_PKG_SUBS_ALR_EXIST_THIS_REC_CHANG_BY_ANOTHER_USR_RETREIVE_REC_BEF_SAVE);
						    }
						    ALRT_GRP_PKGVO grpPkgVO = new ALRT_GRP_PKGVO();

						    if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
						    {
							    DBSequenceSC dbSeqSC = new DBSequenceSC();
								dbSeqSC.setSequenceName("ALRT_GRP_PKG_SEQ");
								grpPkgVO.setLINE_NO(commonLibBO.returnTableSequence(dbSeqSC));
						    }
						    grpPkgVO.setPKG_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
						    grpPkgVO.setGRP_ID(ListColData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
						    grpPkgVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
						    grpPkgVO.setCREATED_BY(subscriptionCO.getUserID());
						    grpPkgVO.setDATE_CREATED(commonLibBO.returnSystemDateNoTime());
				
						    int row = genericDAO.insert(grpPkgVO);
						    subscriptionCO.setRow(row);
						    if(row < 1)
						    {
						    	throw new BOException(MessageCodes.RECORD_CHANGED);
						    }
						    //required for WS Added by Alim
						    subscriptionCO.setAlrtGrpPkgVO(grpPkgVO);
						    // auditBO.callAudit(null, grpPkgVO,
						    // subscriptionCO.getAuditRefCO());
						    // auditBO.insertAudit(subscriptionCO.getAuditRefCO());
						}
						int rows = subscriptionDAO.updateExistingGrpPckg(subscriptionCO);
						subscriptionCO.setRow(rows);
				    }
				}
		    }
		}
		if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		int rows = subscriptionDAO.updateExistingSubEvt(subscriptionCO);
    		subscriptionCO.setRow(rows);
    	}
		return subscriptionCO;
    }

    private void saveBulkSubEventSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {

	SubscriptionSC sc = new SubscriptionSC();
	sc.setRelType(subscriptionCO.getSubscriptionType());
	sc.setUserId(subscriptionCO.getUserID());
	int rows = subscriptionDAO.saveBulkINALRT_SUB_EVT(sc);
	subscriptionCO.setRow(rows);
	/**
	 * truncate from temp table
	 */
	deletePopulatedFromTmp();
    }

    @Override
    public SubscriptionCO updateAfterApproveSubscription(SubscriptionCO subscriptionCO, ArrayList lstMod) throws BaseException
    {
		SubscriptionSC sc = new SubscriptionSC();
		SubscriptionCO subsCO;
		ALRT_SUB_EVT_COMM_MODE_EXCLVO alrtComModeExclVO;
		ALRT_SUB_EVTVO alrtSubEvtVO;
		JSONObject jsonFilter,jsonGridArrayModel;
		JSONArray jsonGridArray;
		String excludeYn;
		BigDecimal relID;
		if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
		{
		    // update exclude table
		    if(lstMod != null && !lstMod.isEmpty())
		    {
				Iterator<SubscriptionCO> itMod = lstMod.iterator();
				while(itMod.hasNext())
				{
				    subsCO = itMod.next();
				    alrtComModeExclVO = new ALRT_SUB_EVT_COMM_MODE_EXCLVO();
				    alrtComModeExclVO.setSUBSCRIPTION_ID(subsCO.getAlrtSubEvtTmpVO().getID());
				    //update alrt_sub_evt table
					
				    alrtSubEvtVO = new ALRT_SUB_EVTVO();
				    alrtSubEvtVO.setID(subsCO.getAlrtSubEvtTmpVO().getID());
				    alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
				    alrtSubEvtVO.setMODIFIED_BY(subscriptionCO.getUserID());
				    alrtSubEvtVO.setDATE_MODIFIED(commonLibBO.returnSystemDateNoTime());
				    alrtSubEvtVO.setSRC_CONTACT_TYPE(subsCO.getAlrtSubEvtVO().getSRC_CONTACT_TYPE());
				    genericDAO.update(alrtSubEvtVO);
				    
				    if(!StringUtil.nullToEmpty(subsCO.getCustomDetails()).isEmpty())
				    {
						//update ALRT_SUB_EVT_COMM_MODE_EXCLVO table
						jsonFilter = (JSONObject) JSONSerializer.toJSON(subsCO.getCustomDetails());
						if(jsonFilter != null)
						{
						    jsonGridArray = jsonFilter.getJSONArray("root");
						    for(int j = 0; j < jsonGridArray.size(); j++)
						    {
								jsonGridArrayModel = (JSONObject) jsonGridArray.getJSONObject(j);
								alrtComModeExclVO.setCOMMUNICATION_TYPE((String) jsonGridArrayModel.get("alrtEvtCommModeVO.COMMUNICATION_TYPE"));
								excludeYn = (String) jsonGridArrayModel.get("EXCLUDE_YN");
								genericDAO.delete(alrtComModeExclVO);
								if("0".equals(excludeYn))
								{
								    genericDAO.insert(alrtComModeExclVO);
								}//end If
						    }//end For loop
						}//end IF JSON filter
				    }//end if customdetails
				}//end while loop
		    }//end if
		}//end If 
		return subscriptionCO;
    }
    
      public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    @Override
    public SubscriptionCO approveSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
		subscriptionCO = continueToApprove(subscriptionCO);
		return subscriptionCO;
    }

    /** Method used to Call Alert Engine and send Notification to Subscriber
     * @Author ShahNawaz
     */
    private void sendAlertNotificationMessage(ALRT_SUBVO alrt_SUBVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	//If Activation service flag, 1 = Yes and Notified = 0
    	if(alrt_CONTROLVO !=null && BigDecimal.ONE.equals(alrt_CONTROLVO.getCTRL_VALUE()))
    	{
    		if(AlertConstant.ACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
    		{	/* Approve Event It Is mandatory to check NOTIFIED for Approval Notification */
    			alrt_SUBVO = (ALRT_SUBVO) genericDAO.selectByPK(alrt_SUBVO);
    			if(alrt_SUBVO != null && (alrt_SUBVO.getNOTIFIED() == null ||!BigDecimal.ONE.equals(alrt_SUBVO.getNOTIFIED())))
    			{
    				continueToSendAlertNotification(alrt_SUBVO, alrt_CONTROLVO);
    				//Set NOTIFIED as 1
            		alrt_SUBVO.setNOTIFIED(BigDecimal.ONE);
            		genericDAO.update(alrt_SUBVO);
    			}
    		}
    		else if(AlertConstant.SUSPEND_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()) 
    				|| AlertConstant.REACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
    		{
    			ALRT_CONTROLVO controlvo = new ALRT_CONTROLVO();
    			
    			if(AlertConstant.SUSPEND_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
        		{	//Suspend Event
    				controlvo.setCTRL_REFERENCE(AlertConstant.SUSPEND_EVT);
        		}
    			else if(AlertConstant.REACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
        		{	//Reactivate Event
    				controlvo.setCTRL_REFERENCE(AlertConstant.REACTIV_EVT);
        		}
    			
    			continueToSendAlertNotification(alrt_SUBVO, alrt_CONTROLVO);
    		}//End Else
    	}//End ALRT_CONTROL IF
    }//End Method
    
    private void continueToSendAlertNotification(ALRT_SUBVO alrt_SUBVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {    	
    	ALRT_CONTROLVO controlvo = new ALRT_CONTROLVO();
		if(AlertConstant.ACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
		{
			controlvo.setCTRL_REFERENCE(AlertConstant.ACTIV_EVT);
		}
		else if(AlertConstant.SUSPEND_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
		{
			controlvo.setCTRL_REFERENCE(AlertConstant.SUSPEND_EVT);
		}
		else if(AlertConstant.REACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
		{
			controlvo.setCTRL_REFERENCE(AlertConstant.REACTIV_EVT);
		}
			
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
			alertEngineBO.sendMessage(alertNotificationCO);
		} catch (Exception e) 
		{
			log.error("Error in continueToSendAlertNotification method inside SubscriberBoImpl "+e.getMessage());
		}
    }
    
    private void continueToSendAlertsToGroups(SubscriptionSC sc, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	ALRT_SUBVO alrt_SUBVO = new ALRT_SUBVO();
	    List<SubscriptionCO> subscribersInGroupList = null;
	    subscribersInGroupList = subscriptionDAO.retSubscriberLineNo(sc);
		if(subscribersInGroupList != null && !subscribersInGroupList.isEmpty())
		{
			for (int j = 0; j < subscribersInGroupList.size(); j++) 
			{
				alrt_SUBVO.setID(subscribersInGroupList.get(j).getAlrtSubEvtTmpVO().getSUB_ID());						
				
				sendAlertNotificationMessage(alrt_SUBVO, alrt_CONTROLVO);
			}//End for loop
		}//End Subscribers if
    }//End Method
    
    private void sendAlertNotificationbyGroup(ArrayList<BigDecimal> groupIdsList, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
	ALRT_CONTROLVO controlvo = new ALRT_CONTROLVO();
	if(AlertConstant.ACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
	{
		controlvo.setCTRL_REFERENCE(AlertConstant.ACTIV_EVT);
	}
	else if(AlertConstant.SUSPEND_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
	{
		controlvo.setCTRL_REFERENCE(AlertConstant.SUSPEND_EVT);
	}
	else if(AlertConstant.REACTIV_FLAG.equals(alrt_CONTROLVO.getCTRL_REFERENCE()))
	{
		controlvo.setCTRL_REFERENCE(AlertConstant.REACTIV_EVT);
	}
		
	/*Load the Event ID As Proceeding event*/
	controlvo = (ALRT_CONTROLVO) genericDAO.selectByPK(controlvo);
	BigDecimal eventId = controlvo.getCTRL_VALUE();
	
	
	AlertNotificationCO alertNotificationCO = new AlertNotificationCO();
	alertNotificationCO.setGroupIdsList(groupIdsList);
	alertNotificationCO.setEventId(eventId);
	try 
	{
		alertEngineBO.sendMessage(alertNotificationCO);
	} catch (Exception e) 
	{
		log.error("Error in continueToSendAlertNotification method inside SubscriberBoImpl "+e.getMessage());
	}
    }
    
    
    
    /**Method to Process ALRT_SUB_EVT after checking maker checker validation*/
    private SubscriptionCO continueToProcessEvtSub(SubscriptionCO subscriptionCO, ALRT_SUB_EVTVO alrtSubEvtVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	// validate if user is allowed to take this action
		int result = commonLibBO.validateMakerChecker(subscriptionCO.getAlrtSubEvtVO().getCREATED_BY(), subscriptionCO.getAlrtSubEvtVO().getMODIFIED_BY(), subscriptionCO.getUserID());
		if(result <= 0)
		{
			// if No result returned then continue to approve
			int row = genericDAO.update(alrtSubEvtVO);
			if(row > 0)
			{
				/** Added to send Alert Notification*/
		    	ALRT_SUBVO alrt_SUBVO = new ALRT_SUBVO();
		    	alrt_SUBVO.setID(alrtSubEvtVO.getSUB_ID());
		    	sendAlertNotificationMessage(alrt_SUBVO, alrt_CONTROLVO);
			}
		}
		else
		{
			//set Row to throw Error Message
			subscriptionCO.setRow(result);
		}
    	return subscriptionCO;
    }
    
    /**Method to Process ALRT_SUB_PKGVO after checking maker checker validation*/
    private SubscriptionCO continueToProcessSubPkg(SubscriptionCO subscriptionCO, ALRT_SUB_PKGVO alrt_SUB_PKGVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	// validate if user is allowed to take this action
		int result = commonLibBO.validateMakerChecker(subscriptionCO.getAlrtSubPkgVO().getCREATED_BY(), subscriptionCO.getAlrtSubPkgVO().getMODIFIED_BY(), subscriptionCO.getUserID());
		if(result <= 0)
		{
			// if No result returned then continue to approve
			int row = genericDAO.update(alrt_SUB_PKGVO);
			if(row > 0)
			{
				/** Added to send Alert Notification*/
			    ALRT_SUBVO alrt_SUBVO = new ALRT_SUBVO();
			    alrt_SUBVO.setID(alrt_SUB_PKGVO.getSUB_ID());
				sendAlertNotificationMessage(alrt_SUBVO, alrt_CONTROLVO);
			}
		}
		else
		{
			//set Row to throw Error Message
			subscriptionCO.setRow(result);
		}
    	return subscriptionCO;
    }
    
    /**Method to Process ALRT_EVT_GRPVO after checking maker checker validation*/
    private SubscriptionCO continueToProcessGrpEvt(SubscriptionCO subscriptionCO, ALRT_EVT_GRPVO alrt_EVT_GRPVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	// validate if user is allowed to take this action
		int result = commonLibBO.validateMakerChecker(subscriptionCO.getAlrtEvtGrpVO().getCREATED_BY(), subscriptionCO.getAlrtEvtGrpVO().getMODIFIED_BY(), subscriptionCO.getUserID());
		if(result <= 0)
		{
			// if No result returned then continue to approve
			int row = genericDAO.update(alrt_EVT_GRPVO);
		}
		else
		{
			//set Row to throw Error Message
			subscriptionCO.setRow(result);
		}
    	return subscriptionCO;
    }
    
    /**Method to Process ALRT_GRP_PKGVO after checking maker checker validation*/
    private SubscriptionCO continueToProcessGrpPkg(SubscriptionCO subscriptionCO, ALRT_GRP_PKGVO alrt_GRP_PKGVO, ALRT_CONTROLVO alrt_CONTROLVO) throws BaseException
    {
    	// validate if user is allowed to take this action
		int result = commonLibBO.validateMakerChecker(subscriptionCO.getAlrtGrpPkgVO().getCREATED_BY(), subscriptionCO.getAlrtGrpPkgVO().getMODIFIED_BY(), subscriptionCO.getUserID());
		if(result <= 0)
		{
			// if No result returned then continue to approve
			int row = genericDAO.update(alrt_GRP_PKGVO);
			/*if(row > 0 && !AlertConstant.STATUS_DELETED.equals(alrt_GRP_PKGVO.getSTATUS()))
			{
				*//** Added to send Alert Notification starts*//*
			    SubscriptionSC sc = new SubscriptionSC();
			    sc.setGRP_ID(alrt_GRP_PKGVO.getGRP_ID());
				sc.setType(SubscriptionConstant.SUBSCRIBER_TYPE);
				continueToSendAlertsToGroups(sc, alrt_CONTROLVO);
			}//End If row count
*/		}
		else
		{
			//set Row to throw Error Message
			subscriptionCO.setRow(result);
		}
    	return subscriptionCO;
    }
    
    /**Method to Process ALRT_SUB_EVT STATUS On the bases of Subscriber-Package*/
    private void processAlertSubscriptionByPackage(ALRT_SUB_PKGVO alrt_SUB_PKGVO, SubscriptionCO subscriptionCO) throws BaseException
    {
    	if(subscriptionCO.getRow() <= 0)
	    {
    		if(StringUtil.isEmptyString(alrt_SUB_PKGVO.getTO_BE_STATUS()))
    	    {
        		subscriptionCO.setStatusDesc(alrt_SUB_PKGVO.getSTATUS());
        		subscriptionCO.setToBeStatusDesc("");
    	    }
        	else
        	{
        		subscriptionCO.setToBeStatusDesc(alrt_SUB_PKGVO.getTO_BE_STATUS());
        		subscriptionCO.setStatusDesc("");
        	}
        	
        	subscriptionCO.setSubType(SubscriptionConstant.SUB_PCKG_TYPE);
        	subscriptionCO.setSubscriberId(alrt_SUB_PKGVO.getSUB_ID());
        	subscriptionCO.setPackageId(alrt_SUB_PKGVO.getPKG_ID());
        	subscriptionCO.setRelId(alrt_SUB_PKGVO.getLINE_NO());
        	subscriptionDAO.updateSubscriptionsStatus(subscriptionCO);
	    }
    }
    
    /**Method to Process ALRT_SUB_EVT STATUS On the bases of Group-event*/
    private void processAlertSubscriptionByGroup(ALRT_EVT_GRPVO alrt_EVT_GRPVO, SubscriptionCO subscriptionCO) throws BaseException
    {
    	if(subscriptionCO.getRow() <= 0)
	    {
    		if(StringUtil.isEmptyString(alrt_EVT_GRPVO.getTO_BE_STATUS()))
    	    {
        		subscriptionCO.setStatusDesc(alrt_EVT_GRPVO.getSTATUS());
        		subscriptionCO.setToBeStatusDesc("");
    	    }
        	else
        	{
        		subscriptionCO.setToBeStatusDesc(alrt_EVT_GRPVO.getTO_BE_STATUS());
        		subscriptionCO.setStatusDesc("");
        	}
        	
        	subscriptionCO.setSubType(SubscriptionConstant.EVENT_GRP_TYPE);
        	subscriptionCO.setEventId(alrt_EVT_GRPVO.getEVT_ID());
        	subscriptionCO.setGroupId(alrt_EVT_GRPVO.getGRP_ID());
        	subscriptionCO.setRelId(alrt_EVT_GRPVO.getLINE_NO());
        	subscriptionDAO.updateSubscriptionsStatus(subscriptionCO);
	    }
    }
    
    /**Method to Process ALRT_SUB_EVT STATUS On the bases of Group-Package*/
    private void processAlertSubscriptionWithGroupPackage(ALRT_GRP_PKGVO alrt_GRP_PKGVO, SubscriptionCO subscriptionCO) throws BaseException
    {
    	if(subscriptionCO.getRow() <= 0)
	    {
    		if(StringUtil.isEmptyString(alrt_GRP_PKGVO.getTO_BE_STATUS()))
    	    {
        		subscriptionCO.setStatusDesc(alrt_GRP_PKGVO.getSTATUS());
        		subscriptionCO.setToBeStatusDesc("");
    	    }
        	else
        	{
        		subscriptionCO.setToBeStatusDesc(alrt_GRP_PKGVO.getTO_BE_STATUS());
        		subscriptionCO.setStatusDesc("");
        	}
        	
        	subscriptionCO.setSubType(SubscriptionConstant.GRP_PCKG_TYPE);
        	subscriptionCO.setPackageId(alrt_GRP_PKGVO.getPKG_ID());
        	subscriptionCO.setGroupId(alrt_GRP_PKGVO.getGRP_ID());
        	subscriptionCO.setRelId(alrt_GRP_PKGVO.getLINE_NO());
        	subscriptionDAO.updateSubscriptionsStatus(subscriptionCO);
	    }
    }
    
    @Override
    public SubscriptionCO continueToApprove(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC sc = new SubscriptionSC();
	
	//***************************Start****************************************************
	/**
	 * Approve bulk Subscriver event Subscription
	 */
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()) && 
		NumberUtil.nullToZero(subscriptionCO.getAllRowsSE()).equals(BigDecimal.ONE) )
    	{
	    subscriptionDAO.approveBulkALRT_SUB_EVT(sc);
	    return subscriptionCO;
    	}
	//*************************End********************************************************
	
    	
    	ALRT_SUB_EVTVO alrtSubEvtVO = null;
    	
    	ALRT_CONTROLVO alrt_CONTROLVO = new ALRT_CONTROLVO();
    	alrt_CONTROLVO.setCTRL_REFERENCE(AlertConstant.ACTIV_FLAG);
    	alrt_CONTROLVO = (ALRT_CONTROLVO) genericDAO.selectByPK(alrt_CONTROLVO);
    	
    	if(subscriptionCO.getSelSerialNoDet() == null)
    	{
    		sc = new SubscriptionSC();
    		sc.setStatus(AlertConstant.STATUS_P);
    		sc.setSubsStatus(AlertConstant.STATUS_P);
    		sc.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
    		sc.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
    		sc.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
    		sc.setUserId(subscriptionCO.getUserID());
    		sc.setRunningDate(subscriptionCO.getRunningDate());

    		//to be update subscribtions
    		subscriptionDAO.updateStatusSubscription(sc);
    		
    		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
    		{
    			sc.setType(SubscriptionConstant.SUB_EVENT_TYPE);
    			//to be delete subscribtions
    			subscriptionDAO.updateStatusSubscription(sc);
    		}
    		return subscriptionCO;
    	}
    	
    	
    	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    	    subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    	    String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    	    
    	    for(int i = 1; i < array.length; i++)
    	    {
    	    	sc = new SubscriptionSC();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			sc.setSUB_ID(new BigDecimal(innerArray[0]));
    			sc.setEVT_ID(new BigDecimal(innerArray[1]));
    			
    			//Load full object to validate maker checker
    			List<SubscriptionCO> list = subscriptionDAO.returnEvtSubDetails(sc);
			    if(list != null && !list.isEmpty())
			    {
			    	alrtSubEvtVO = list.get(0).getAlrtSubEvtVO();
			    	alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_APPROVED);
					alrtSubEvtVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
					alrtSubEvtVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
					//Just for checking in validation passing CREATED_BY in co.vo.CREATED_BY
					subscriptionCO.getAlrtSubEvtVO().setCREATED_BY(alrtSubEvtVO.getCREATED_BY());
					subscriptionCO.getAlrtSubEvtVO().setMODIFIED_BY(alrtSubEvtVO.getMODIFIED_BY());
			    	continueToProcessEvtSub(subscriptionCO, alrtSubEvtVO, alrt_CONTROLVO);
			    }//end list if
    	    }//end for loop
    	}
    	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
    			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
    			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			//Load full object to validate maker checker
    			alrt_SUB_PKGVO = (ALRT_SUB_PKGVO) genericDAO.selectByPK(alrt_SUB_PKGVO);
    			alrt_SUB_PKGVO.setSTATUS(AlertConstant.STATUS_APPROVED);
    			alrt_SUB_PKGVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
    			alrt_SUB_PKGVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing CREATED_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtSubPkgVO().setCREATED_BY(alrt_SUB_PKGVO.getCREATED_BY());
    			subscriptionCO.getAlrtSubPkgVO().setMODIFIED_BY(alrt_SUB_PKGVO.getMODIFIED_BY());
    			continueToProcessSubPkg(subscriptionCO, alrt_SUB_PKGVO, alrt_CONTROLVO);
    			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
    		}
    	}
    	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
    		ArrayList<BigDecimal> groupIdsList = new ArrayList<BigDecimal>();
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
    			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
    			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			//Load full object to validate maker checker
    			alrt_EVT_GRPVO = (ALRT_EVT_GRPVO) genericDAO.selectByPK(alrt_EVT_GRPVO);
    			alrt_EVT_GRPVO.setSTATUS(AlertConstant.STATUS_APPROVED);
    			alrt_EVT_GRPVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
    			alrt_EVT_GRPVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing CREATED_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtEvtGrpVO().setCREATED_BY(alrt_EVT_GRPVO.getCREATED_BY());
    			subscriptionCO.getAlrtEvtGrpVO().setMODIFIED_BY(alrt_EVT_GRPVO.getMODIFIED_BY());
    			continueToProcessGrpEvt(subscriptionCO, alrt_EVT_GRPVO, alrt_CONTROLVO);
    			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
    			
    			/**
    			 * Add Group Ids in ArrayList for sending the notification
    			 */
    			groupIdsList.add(alrt_EVT_GRPVO.getGRP_ID());
    		}
    		/**
    		 * Send Notification by Group Ids
    		 */
    		sendAlertNotificationbyGroup(groupIdsList, alrt_CONTROLVO);
    	}
    	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
    	{
    		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
    		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
    		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
    		ArrayList<BigDecimal> groupIdsList = new ArrayList<BigDecimal>();
    		for(int i = 1; i < array.length; i++)
    		{
    			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
    			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
    			String[] innerArray = array[i].split("~");
    			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
    			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
    			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
    			
    			//Load full object to validate maker checker
    			alrt_GRP_PKGVO = (ALRT_GRP_PKGVO) genericDAO.selectByPK(alrt_GRP_PKGVO);
    			alrt_GRP_PKGVO.setSTATUS(AlertConstant.STATUS_APPROVED);
    			alrt_GRP_PKGVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
    			alrt_GRP_PKGVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
    			//Just for checking in validation passing CREATED_BY in co.vo.CREATED_BY
    			subscriptionCO.getAlrtGrpPkgVO().setCREATED_BY(alrt_GRP_PKGVO.getCREATED_BY());
    			subscriptionCO.getAlrtEvtGrpVO().setMODIFIED_BY(alrt_GRP_PKGVO.getMODIFIED_BY());
    			continueToProcessGrpPkg(subscriptionCO, alrt_GRP_PKGVO, alrt_CONTROLVO);
    			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
    			
    			/**
    			 * Add Group Ids in ArrayList for sending the notification
    			 */
    			groupIdsList.add(alrt_GRP_PKGVO.getGRP_ID());
    		}
    		
    		/**
    		 * Send Notification by Group Ids
    		 */
    		sendAlertNotificationbyGroup(groupIdsList, alrt_CONTROLVO);
    	}
		return subscriptionCO;
    }
    
    @Override
    public SubscriptionCO toBeDeletedSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC subscriptionSC = new SubscriptionSC();

	subscriptionSC.setCompCode(subscriptionCO.getCompCode());
	subscriptionSC.setBranchCode(subscriptionCO.getBranchCode());
	subscriptionSC.setAppName(subscriptionCO.getAppName());
	subscriptionSC.setProgRef(subscriptionCO.getProgRef());
	subscriptionSC.setSubStatus(SubscriptionConstant.subStatus);
	subscriptionSC.setEventModeLovId(SubscriptionConstant.EventModeLovId);
	subscriptionSC.setEventTypeLovId(SubscriptionConstant.EventTypeLovIds);
	subscriptionSC.setSuspendedLovType(SubscriptionConstant.SuspendedLovType);
	subscriptionSC.setSubTypeLovId(AlertConstant.subscriberTypeDropDown);
	subscriptionSC.setLangCode(subscriptionCO.getLanguage());
	subscriptionSC.setCrud(subscriptionCO.getIvCrud());
	if(AlertConstant.CRUD_P.equals(subscriptionCO.getIvCrud()))
	{
	    subscriptionSC.setStatus(AlertConstant.STATUS_ACTIVE);
	}
	else if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud()))
	{
	    subscriptionSC.setStatus(AlertConstant.STATUS_ACTIVE);
	    subscriptionSC.setToBeStatus(AlertConstant.STATUS_TO_BE_DELETED);
	}
	else if(AlertConstant.CRUD_D.equals(subscriptionCO.getIvCrud()))
	{
	    subscriptionSC.setStatus(AlertConstant.STATUS_TO_BE_DELETED);
	}
	
	//WS required
	if(subscriptionCO.getSelSerialNoDet() == null)
	{
		subscriptionSC.setToBeStatus(AlertConstant.STATUS_TO_BE_DELETED);
		subscriptionSC.setToBeStatusBy(subscriptionCO.getUserID());
		subscriptionSC.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
		subscriptionSC.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		subscriptionSC.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		subscriptionSC.setUserId("");
		subscriptionSC.setRunningDate(null);
		if(subscriptionCO.getIsReject() != null && subscriptionCO.getIsReject().equals(BigDecimal.ONE))
		{
			subscriptionSC.setStatus(AlertConstant.STATUS_ACTIVE);
			subscriptionSC.setToBeStatus(null);
			subscriptionSC.setToBeStatusBy(null);
		}
		//to be delete subscribtions
		subscriptionDAO.toBeDeletedSubscription(subscriptionSC);
		
		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
		{
			subscriptionSC.setType(SubscriptionConstant.SUB_EVENT_TYPE);
			//to be delete subscribtions
			subscriptionDAO.toBeDeletedSubscription(subscriptionSC);
		}
		return subscriptionCO;
	}
	//To be deleted Code By ShahNawaz
	if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		ALRT_SUB_PKGVO alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
		if(subscriptionCO.getSelSerialNoDet() != null)
		{
			subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
			String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
			for(int i = 1; i < array.length; i++)
			{
				alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
				array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				String[] innerArray = array[i].split("~");
				alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
				alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
				alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
				if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud()))
				{
					alrt_SUB_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_DELETED);
					alrt_SUB_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
				}
				else if(AlertConstant.CRUD_D.equals(subscriptionCO.getIvCrud()))
				{
					alrt_SUB_PKGVO.setTO_BE_STATUS("");
					alrt_SUB_PKGVO.setTO_BE_STATUS_BY("");
				}
				genericDAO.update(alrt_SUB_PKGVO);
				processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
			}
		}
		return subscriptionCO;
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		if(subscriptionCO.getSelSerialNoDet() != null)
		{
			subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
			String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
			ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
			for(int i = 1; i < array.length; i++)
			{
				alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
				array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				String[] innerArray = array[i].split("~");
				alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
				alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
				alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
				
				if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud()))
				{
					alrt_EVT_GRPVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_DELETED);
					alrt_EVT_GRPVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
				}
				else if(AlertConstant.CRUD_D.equals(subscriptionCO.getIvCrud()))
				{
					alrt_EVT_GRPVO.setTO_BE_STATUS("");
					alrt_EVT_GRPVO.setTO_BE_STATUS_BY("");
				}
				genericDAO.update(alrt_EVT_GRPVO);
				processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
			}
		}
		return subscriptionCO;
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		if(subscriptionCO.getSelSerialNoDet() != null)
		{
			subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
			String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
			ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
			for(int i = 1; i < array.length; i++)
			{
				alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
				array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				String[] innerArray = array[i].split("~");
				alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
				alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
				alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
				
				if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud()))
				{
					alrt_GRP_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_DELETED);
					alrt_GRP_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
				}
				else if(AlertConstant.CRUD_D.equals(subscriptionCO.getIvCrud()))
				{
					alrt_GRP_PKGVO.setTO_BE_STATUS("");
					alrt_GRP_PKGVO.setTO_BE_STATUS_BY("");
				}
				genericDAO.update(alrt_GRP_PKGVO);
				processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
			}
		}
		return subscriptionCO;
	}
		
	subscriptionSC.setType(subscriptionCO.getSubscriptionType());
	List<SubscriptionCO> ListAllData = null;
	if(ConstantsCommon.ONE.equals(subscriptionCO.getAllRowsDet()))
	{
	    subscriptionSC.setNbRec(-1);
	    ListAllData = subscriberEvtList(subscriptionSC);
	}
	else
	{
		if(subscriptionCO.getSelSerialNoDet()!=null) 
		{//from screen

			subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));

			String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
			subscriptionSC.setIDlist(new ArrayList<>());
			for(int i = 1; i < array.length; i++)
			{
				SubscriptionSC sc1 = new SubscriptionSC();
				array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				String[] innerArray = array[i].split("~");
				sc1.setSUB_ID(new BigDecimal(innerArray[0]));
				sc1.setGRP_ID(new BigDecimal(innerArray[0]));
				sc1.setEVT_ID(new BigDecimal(innerArray[1]));
				sc1.setPKG_ID(new BigDecimal(innerArray[1]));
				sc1.setLineNO(new BigDecimal(innerArray[2]));
				subscriptionSC.getArrayListSG().add(sc1);
				subscriptionSC.getIDlist().add(new BigDecimal(innerArray[2]));
			}
			
			 ListAllData = subscriptionDAO.subscriberEvtListSelected(subscriptionSC);
			 subscriptionCO.setListAllData(ListAllData);
	    }
	}

	if(null != ListAllData)
	{

	    for(int i = 0; i < ListAllData.size(); i++)
	    {

		ALRT_SUB_EVTVO sub_EVTVO = new ALRT_SUB_EVTVO();
		if(AlertConstant.CRUD_TD.equals(subscriptionCO.getIvCrud())&&AlertConstant.SE.equals(subscriptionCO.getSubscriptionType()))
		{
		    sub_EVTVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_DELETED);
		    sub_EVTVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
		    sub_EVTVO.setSTATUS(ListAllData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS());
		}
		else
		{
		    sub_EVTVO.setSTATUS(AlertConstant.STATUS_DELETED);
		    sub_EVTVO.setDELETED_BY(subscriptionCO.getUserID());
		    sub_EVTVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
		}
		sub_EVTVO.setID(ListAllData.get(i).getAlrtSubEvtTmpVO().getID());
		sub_EVTVO.setREL_TYPE(subscriptionCO.getSubscriptionType());
		sub_EVTVO.setREL_ID(ListAllData.get(i).getAlrtSubEvtTmpVO().getREL_ID());

		ALRT_SUBSCRIPTION_PARAMVO subParamVO = new ALRT_SUBSCRIPTION_PARAMVO();
		subParamVO.setID(ListAllData.get(i).getAlrtSubEvtTmpVO().getID());

		if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
		{
		    if(BigDecimal.ONE.equals(subscriptionCO.getIsReject()))
		    {
			sub_EVTVO.setOLD_STATUS(ListAllData.get(i).getAlrtSubEvtTmpVO().getSUB_EVT_STATUS());
			sub_EVTVO.setSUB_ID(ListAllData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
			sub_EVTVO.setEVT_ID(ListAllData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
			subscriptionDAO.rejectAlrtSubEvt(sub_EVTVO);

		    }
		    else
		    {
			subscriptionDAO.deleteAlrtSubEvt(sub_EVTVO);

			subscriptionDAO.deleteAlrtSubParam(subParamVO);
		    }

		}
		else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
		{
		    ALRT_SUB_PKGVO subPkgVO = new ALRT_SUB_PKGVO();
		    subPkgVO.setLINE_NO(ListAllData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
		    if(BigDecimal.ONE.equals(subscriptionCO.getIsReject()))
		    {
			subscriptionDAO.rejectAlrtSubEvtSP(sub_EVTVO);
			subscriptionDAO.rejectAlrtSubPkg(subPkgVO);
		    }
		    else
		    {
			subscriptionDAO.deleteAlrtSubEvtSP(sub_EVTVO);

			subPkgVO.setDELETED_BY(subscriptionCO.getUserID());
			subPkgVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
			subPkgVO.setLINE_NO(ListAllData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
			subscriptionDAO.deleteAlrtSubPkg(subPkgVO);
			sub_EVTVO.setSUB_ID(ListAllData.get(i).getAlrtSubEvtTmpVO().getSUB_ID());
			sub_EVTVO.setEVT_ID(ListAllData.get(i).getAlrtSubEvtTmpVO().getEVT_ID());
			subscriptionDAO.deleteAlrtSubParamSP(sub_EVTVO);
		    }
		}
		else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
		{
		    ALRT_EVT_GRPVO evtGrpVO = new ALRT_EVT_GRPVO();
		    evtGrpVO.setLINE_NO(ListAllData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
		    if(BigDecimal.ONE.equals(subscriptionCO.getIsReject()))
		    {
			subscriptionDAO.rejectAlrtSubEvtSP(sub_EVTVO);

			subscriptionDAO.rejectAlrtEvtGrp(evtGrpVO);

		    }
		    else
		    {
			subscriptionDAO.deleteAlrtSubEvtSP(sub_EVTVO);

			evtGrpVO.setDELETED_BY(subscriptionCO.getUserID());
			evtGrpVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());
			subscriptionDAO.delteAlrtEvtGrp(evtGrpVO);
			subscriptionDAO.deleteAlrtSubParamSP(sub_EVTVO);
		    }

		}
		else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
		{
		    ALRT_GRP_PKGVO alrtGrpPkgVO = new ALRT_GRP_PKGVO();
		    alrtGrpPkgVO.setLINE_NO(ListAllData.get(i).getAlrtSubEvtTmpVO().getREL_ID());
		    if(BigDecimal.ONE.equals(subscriptionCO.getIsReject()))
		    {
			subscriptionDAO.rejectAlrtSubEvtSP(sub_EVTVO);
			subscriptionDAO.rejectAlrtGrpPkg(alrtGrpPkgVO);
		    }
		    else
		    {
			subscriptionDAO.deleteAlrtSubEvtSP(sub_EVTVO);

			alrtGrpPkgVO.setDELETED_BY(subscriptionCO.getUserID());
			alrtGrpPkgVO.setDATE_DELETED(commonLibBO.returnSystemDateNoTime());

			subscriptionDAO.deleteAlrtGrpPkg(alrtGrpPkgVO);

			subscriptionDAO.updateAlrtSubParamSP(sub_EVTVO);
		    }
		}

	    }

	}
	return subscriptionCO;

    }

    @Override
    public void checkIfFixedEvtParamExist(SubscriptionSC sc) throws BaseException
    {
	List<SubscriptionCO> fixedEvtParamsetList = new ArrayList<SubscriptionCO>();

	fixedEvtParamsetList = subscriptionDAO.loadFixedEvtParamsSet(sc);

	if(fixedEvtParamsetList.size() == 0)
	{
	    throw new BOException(MessageCodes.NO_PARAMS_TO_BE_SET);
	}

    }
    
    @Override
    public SubscriptionCO checkEventModeFlags(SubscriptionCO subscriptionCO) throws BaseException
    {
    	return subscriptionDAO.checkEventModeFlags(subscriptionCO);
    }

	@Override
	public SubscriptionCO returnSubscriptionDetailsById(SubscriptionSC sc) throws BaseException 
	{
		return subscriptionDAO.returnSubscriptionDetailsById(sc);
	}
	
    @Override
    public int returnCommunicationTypeCnt(SubscriptionSC criteria) throws BaseException
    {
	return subscriptionDAO.returnCommunicationTypeCnt(criteria);
    }

    @Override
    public List<SubscriptionCO> returnCommunicationTypeList(SubscriptionSC criteria) throws BaseException
    {
	return subscriptionDAO.returnCommunicationTypeList(criteria);
    }
    
    @Override
    public SubscriptionCO toBeSuspendSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC sc1;
	ALRT_SUB_EVTVO alrtSubEvtVO;
	
	/**
	 * WS required code
	 * @author Alim
	 */
	if(subscriptionCO.getSelSerialNoDet() == null )
	{
		sc1 = new SubscriptionSC();
		sc1.setToBeStatus(AlertConstant.STATUS_TO_BE_SUSPENDED);
		sc1.setSubsStatus(AlertConstant.STATUS_TO_BE_SUSPENDED);
		sc1.setToBeStatusBy(subscriptionCO.getUserID());
		sc1.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
		sc1.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		sc1.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());

		//to be update subscribtions
		subscriptionDAO.updateStatusSubscription(sc1);
		
		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
		{
			sc1.setType(SubscriptionConstant.SUB_EVENT_TYPE);
			//to be delete subscribtions
			subscriptionDAO.updateStatusSubscription(sc1);
		}
		
		return subscriptionCO;
	}
	
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		if(subscriptionCO.getSelSerialNoDet()!=null) {//from screen
			subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
			String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");

			for(int i = 1; i < array.length; i++)
			{
				sc1 = new SubscriptionSC();
				alrtSubEvtVO = new ALRT_SUB_EVTVO();
				array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
				String[] innerArray = array[i].split("~");
				sc1.setSUB_ID(new BigDecimal(innerArray[0]));
				sc1.setEVT_ID(new BigDecimal(innerArray[1]));
				alrtSubEvtVO = subscriptionDAO.returnEvtSubDetails(sc1).get(0).getAlrtSubEvtVO();
				alrtSubEvtVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_SUSPENDED);
				alrtSubEvtVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
				genericDAO.update(alrtSubEvtVO);
			}
	    }else {//from web service
	    	alrtSubEvtVO = new ALRT_SUB_EVTVO();
	    	alrtSubEvtVO.setID(subscriptionCO.getAlrtSubEvtVO().getID());
			alrtSubEvtVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_SUSPENDED);
			alrtSubEvtVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrtSubEvtVO);
	    }
	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_SUB_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_SUSPENDED);
			alrt_SUB_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_SUB_PKGVO);
			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_EVT_GRPVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_SUSPENDED);
			alrt_EVT_GRPVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_EVT_GRPVO);
			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_GRP_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_SUSPENDED);
			alrt_GRP_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_GRP_PKGVO);
			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
		}
	}
	return subscriptionCO;
    }
    
    @Override
    public SubscriptionCO suspendSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC sc;
	
	/**
	 * WS required code
	 * @author Alim
	 */
	if(subscriptionCO.getSelSerialNoDet() == null )
	{
		sc = new SubscriptionSC();
		sc.setToBeStatus(null);
		sc.setToBeStatusBy(null);
		sc.setSubsStatus(AlertConstant.STATUS_SUSPEND);
		sc.setStatus(AlertConstant.STATUS_SUSPEND);
		sc.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
		sc.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		sc.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		sc.setUserId(subscriptionCO.getUserID());
		sc.setRunningDate(subscriptionCO.getRunningDate());
		//to be update subscribtions
		subscriptionDAO.updateStatusSubscription(sc);
		
		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
		{
			sc.setType(SubscriptionConstant.SUB_EVENT_TYPE);
			//to be delete subscribtions
			subscriptionDAO.updateStatusSubscription(sc);
		}
		
		return subscriptionCO;
	}
	
	
	ALRT_SUB_EVTVO alrtSubEvtVO;
	
	ALRT_CONTROLVO alrt_CONTROLVO = new ALRT_CONTROLVO();
	alrt_CONTROLVO.setCTRL_REFERENCE(AlertConstant.SUSPEND_FLAG);
	alrt_CONTROLVO = (ALRT_CONTROLVO) genericDAO.selectByPK(alrt_CONTROLVO);
	
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
	    String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");

	    for(int i = 1; i < array.length; i++)
	    {
			sc = new SubscriptionSC();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			sc.setSUB_ID(new BigDecimal(innerArray[0]));
			sc.setEVT_ID(new BigDecimal(innerArray[1]));
			// update alrt_sub_evt table
			List<SubscriptionCO> list = subscriptionDAO.returnEvtSubDetails(sc);
			if(list != null && !list.isEmpty())
			{
				alrtSubEvtVO = list.get(0).getAlrtSubEvtVO();
				alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_SUSPEND);
				alrtSubEvtVO.setSUSPENDED_BY(subscriptionCO.getUserID());
				alrtSubEvtVO.setDATE_SUSPENDED(commonLibBO.returnSystemDateNoTime());
				//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
				subscriptionCO.getAlrtSubEvtVO().setCREATED_BY(alrtSubEvtVO.getTO_BE_STATUS_BY());
				//Clear To Be Status
				alrtSubEvtVO.setTO_BE_STATUS("");
				alrtSubEvtVO.setTO_BE_STATUS_BY("");
				continueToProcessEvtSub(subscriptionCO, alrtSubEvtVO, alrt_CONTROLVO);
			}//end if
	    }
	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_SUB_PKGVO = (ALRT_SUB_PKGVO) genericDAO.selectByPK(alrt_SUB_PKGVO);
			alrt_SUB_PKGVO.setSTATUS(AlertConstant.STATUS_SUSPEND);
			alrt_SUB_PKGVO.setSUSPENDED_BY(subscriptionCO.getUserID());
			alrt_SUB_PKGVO.setDATE_SUSPENDED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtSubPkgVO().setCREATED_BY(alrt_SUB_PKGVO.getTO_BE_STATUS_BY());
			//Clear To Be status
			alrt_SUB_PKGVO.setTO_BE_STATUS("");
			alrt_SUB_PKGVO.setTO_BE_STATUS_BY("");
			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
			continueToProcessSubPkg(subscriptionCO, alrt_SUB_PKGVO, alrt_CONTROLVO);
		}
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_EVT_GRPVO = (ALRT_EVT_GRPVO) genericDAO.selectByPK(alrt_EVT_GRPVO);
			alrt_EVT_GRPVO.setSTATUS(AlertConstant.STATUS_SUSPEND);
			alrt_EVT_GRPVO.setSUSPENDED_BY(subscriptionCO.getUserID());
			alrt_EVT_GRPVO.setDATE_SUSPENDED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtEvtGrpVO().setCREATED_BY(alrt_EVT_GRPVO.getTO_BE_STATUS_BY());
			//Clear To Be status
			alrt_EVT_GRPVO.setTO_BE_STATUS("");
			alrt_EVT_GRPVO.setTO_BE_STATUS_BY("");
			continueToProcessGrpEvt(subscriptionCO, alrt_EVT_GRPVO, alrt_CONTROLVO);
			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_GRP_PKGVO = (ALRT_GRP_PKGVO) genericDAO.selectByPK(alrt_GRP_PKGVO);
			alrt_GRP_PKGVO.setSTATUS(AlertConstant.STATUS_SUSPEND);
			alrt_GRP_PKGVO.setSUSPENDED_BY(subscriptionCO.getUserID());
			alrt_GRP_PKGVO.setDATE_SUSPENDED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtGrpPkgVO().setCREATED_BY(alrt_GRP_PKGVO.getTO_BE_STATUS_BY());
			//Clear To Be status
			alrt_GRP_PKGVO.setTO_BE_STATUS("");
			alrt_GRP_PKGVO.setTO_BE_STATUS_BY("");
			continueToProcessGrpPkg(subscriptionCO, alrt_GRP_PKGVO, alrt_CONTROLVO);
			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
		}
		return subscriptionCO;
	}
	return subscriptionCO;
    }
    
    @Override
    public SubscriptionCO toBeReactivateSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC sc1;
	ALRT_SUB_EVTVO alrtSubEvtVO;
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
	    String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
	    
	    for(int i = 1; i < array.length; i++)
	    {
		sc1 = new SubscriptionSC();
		alrtSubEvtVO = new ALRT_SUB_EVTVO();
		array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
		String[] innerArray = array[i].split("~");
		sc1.setSUB_ID(new BigDecimal(innerArray[0]));
		sc1.setEVT_ID(new BigDecimal(innerArray[1]));
		alrtSubEvtVO = subscriptionDAO.returnEvtSubDetails(sc1).get(0).getAlrtSubEvtVO();
		alrtSubEvtVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_REACTIVATE);
		alrtSubEvtVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
		genericDAO.update(alrtSubEvtVO);
	    }
	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_SUB_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_REACTIVATE);
			alrt_SUB_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_SUB_PKGVO);
			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_EVT_GRPVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_REACTIVATE);
			alrt_EVT_GRPVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_EVT_GRPVO);
			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			alrt_GRP_PKGVO.setTO_BE_STATUS(AlertConstant.STATUS_TO_BE_REACTIVATE);
			alrt_GRP_PKGVO.setTO_BE_STATUS_BY(subscriptionCO.getUserID());
			genericDAO.update(alrt_GRP_PKGVO);
			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
		}
	}
	return subscriptionCO;
    }
    
    @Override
    public SubscriptionCO reactivateSubscription(SubscriptionCO subscriptionCO) throws BaseException
    {
	SubscriptionSC sc;
	
	/**
	 * WS required code
	 * @author Alim
	 */
	if(subscriptionCO.getSelSerialNoDet() == null )
	{
		sc = new SubscriptionSC();
		sc.setToBeStatus(null);
		sc.setToBeStatusBy(null);
		sc.setSubsStatus(AlertConstant.STATUS_APPROVED);
		sc.setStatus(AlertConstant.STATUS_APPROVED);
		sc.setRelId(subscriptionCO.getAlrtSubEvtVO().getREL_ID());
		sc.setRelType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		sc.setType(subscriptionCO.getAlrtSubEvtVO().getREL_TYPE());
		sc.setUserId(subscriptionCO.getUserID());
		sc.setRunningDate(subscriptionCO.getRunningDate());

		//to be update subscribtions
		subscriptionDAO.updateStatusSubscription(sc);
		
		if(!subscriptionCO.getAlrtSubEvtVO().getREL_TYPE().equals(SubscriptionConstant.SUB_EVENT_TYPE))
		{
			sc.setType(SubscriptionConstant.SUB_EVENT_TYPE);
			//to be delete subscribtions
			subscriptionDAO.updateStatusSubscription(sc);
		}
		
		return subscriptionCO;
	}
	ALRT_SUB_EVTVO alrtSubEvtVO;
	
	ALRT_CONTROLVO alrt_CONTROLVO = new ALRT_CONTROLVO();
	alrt_CONTROLVO.setCTRL_REFERENCE(AlertConstant.REACTIV_FLAG);
	alrt_CONTROLVO = (ALRT_CONTROLVO) genericDAO.selectByPK(alrt_CONTROLVO);
	
	if(SubscriptionConstant.SUB_EVENT_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
	    subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
	    String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
	    
	    for(int i = 1; i < array.length; i++)
	    {
	    	sc = new SubscriptionSC();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			sc.setSUB_ID(new BigDecimal(innerArray[0]));
			sc.setEVT_ID(new BigDecimal(innerArray[1]));
			
			// update alrt_sub_evt table
			List<SubscriptionCO> list = subscriptionDAO.returnEvtSubDetails(sc);
			if(list != null && !list.isEmpty())
			{
				alrtSubEvtVO = list.get(0).getAlrtSubEvtVO();
				alrtSubEvtVO.setSTATUS(AlertConstant.STATUS_APPROVED);
				alrtSubEvtVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
				alrtSubEvtVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
				//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
				subscriptionCO.getAlrtSubEvtVO().setCREATED_BY(alrtSubEvtVO.getTO_BE_STATUS_BY());
				//Clear to be status
				alrtSubEvtVO.setTO_BE_STATUS("");
				alrtSubEvtVO.setTO_BE_STATUS_BY("");
				continueToProcessEvtSub(subscriptionCO, alrtSubEvtVO, alrt_CONTROLVO);
			}//end if
	    }
	}
	else if(SubscriptionConstant.SUB_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_SUB_PKGVO alrt_SUB_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_SUB_PKGVO = new ALRT_SUB_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_SUB_PKGVO.setSUB_ID(new BigDecimal(innerArray[0]));
			alrt_SUB_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_SUB_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_SUB_PKGVO = (ALRT_SUB_PKGVO) genericDAO.selectByPK(alrt_SUB_PKGVO);
			alrt_SUB_PKGVO.setSTATUS(AlertConstant.STATUS_APPROVED);
			alrt_SUB_PKGVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
			alrt_SUB_PKGVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtSubPkgVO().setCREATED_BY(alrt_SUB_PKGVO.getTO_BE_STATUS_BY());
			//clear to be status
			alrt_SUB_PKGVO.setTO_BE_STATUS("");
			alrt_SUB_PKGVO.setTO_BE_STATUS_BY("");
			processAlertSubscriptionByPackage(alrt_SUB_PKGVO, subscriptionCO);
			continueToProcessSubPkg(subscriptionCO, alrt_SUB_PKGVO, alrt_CONTROLVO);
		}
	}
	else if(SubscriptionConstant.EVENT_GRP_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_EVT_GRPVO alrt_EVT_GRPVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_EVT_GRPVO = new ALRT_EVT_GRPVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_EVT_GRPVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_EVT_GRPVO.setEVT_ID(new BigDecimal(innerArray[1]));
			alrt_EVT_GRPVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_EVT_GRPVO = (ALRT_EVT_GRPVO) genericDAO.selectByPK(alrt_EVT_GRPVO);
			alrt_EVT_GRPVO.setSTATUS(AlertConstant.STATUS_APPROVED);
			alrt_EVT_GRPVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
			alrt_EVT_GRPVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtEvtGrpVO().setCREATED_BY(alrt_EVT_GRPVO.getTO_BE_STATUS_BY());
			//clear to be status
			alrt_EVT_GRPVO.setTO_BE_STATUS("");
			alrt_EVT_GRPVO.setTO_BE_STATUS_BY("");
			continueToProcessGrpEvt(subscriptionCO, alrt_EVT_GRPVO, alrt_CONTROLVO);
			processAlertSubscriptionByGroup(alrt_EVT_GRPVO, subscriptionCO);
		}
	}
	else if(SubscriptionConstant.GRP_PCKG_TYPE.equals(subscriptionCO.getSubscriptionType()))
	{
		subscriptionCO.setSelSerialNoDet(subscriptionCO.getSelSerialNoDet().replace("\\", ""));
		String[] array = subscriptionCO.getSelSerialNoDet().split("SUB_ID-EVT_ID");
		ALRT_GRP_PKGVO alrt_GRP_PKGVO =null;
		for(int i = 1; i < array.length; i++)
		{
			alrt_GRP_PKGVO = new ALRT_GRP_PKGVO();
			array[i] = array[i].substring(3, array[i].indexOf("}") - 1);
			String[] innerArray = array[i].split("~");
			alrt_GRP_PKGVO.setGRP_ID(new BigDecimal(innerArray[0]));
			alrt_GRP_PKGVO.setPKG_ID(new BigDecimal(innerArray[1]));
			alrt_GRP_PKGVO.setLINE_NO(new BigDecimal(innerArray[2]));
			
			alrt_GRP_PKGVO = (ALRT_GRP_PKGVO) genericDAO.selectByPK(alrt_GRP_PKGVO);
			alrt_GRP_PKGVO.setSTATUS(AlertConstant.STATUS_APPROVED);
			alrt_GRP_PKGVO.setAUTHORIZED_BY(subscriptionCO.getUserID());
			alrt_GRP_PKGVO.setDATE_AUTHORIZED(commonLibBO.returnSystemDateNoTime());
			//Just for checking in validation passing TO_BE_STATUS_BY in co.vo.CREATED_BY
			subscriptionCO.getAlrtGrpPkgVO().setCREATED_BY(alrt_GRP_PKGVO.getTO_BE_STATUS_BY());
			//clear to be status
			alrt_GRP_PKGVO.setTO_BE_STATUS("");
			alrt_GRP_PKGVO.setTO_BE_STATUS_BY("");
			continueToProcessGrpPkg(subscriptionCO, alrt_GRP_PKGVO, alrt_CONTROLVO);
			processAlertSubscriptionWithGroupPackage(alrt_GRP_PKGVO, subscriptionCO);
		}
	}
	return subscriptionCO;
    }
    
    @Override
    public List<SubscriptionCO> retrieveSubEvtWSList(SubscriptionSC sc) throws 	BaseException
    {
	return subscriptionDAO.retrieveSubEvtWSList(sc);
    }
    
    @Override
    public SubscriptionCO updateTempSubscription(SubscriptionCO subscriptionCO) throws BaseException 
    {
	ALRT_SUB_EVT_TMPVO alrt_SUB_EVT_TMPVO = subscriptionCO.getAlrtSubEvtTmpVO();
	genericDAO.update(alrt_SUB_EVT_TMPVO);
	return subscriptionCO;
    }
    
    @Override
    public Integer returnSubscriptionWsCount(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.returnSubscriptionWsCount(sc);
    }

    @Override
    public List<SubscriptionWsCO> returnSubscriptionWsList(SubscriptionSC sc) throws BaseException
    {
	return subscriptionDAO.returnSubscriptionWsList(sc); 
    } 
}
