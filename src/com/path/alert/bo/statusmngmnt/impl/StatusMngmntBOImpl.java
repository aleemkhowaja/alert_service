package com.path.alert.bo.statusmngmnt.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.ALRTMessageCodes;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.statusmngmnt.StatusMngmntBO;
import com.path.alert.dao.statusmngmnt.StatusMngmntDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.statusmngmnt.StatusMngmntCO;
import com.path.alert.vo.statusmngmnt.StatusMngmntSC;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_CONTROLVOKey;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVTVOKey;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_QUEUEVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUBVOKey;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVOKey;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMFVOKey;
import com.path.dbmaps.vo.CIFVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.RequiredFieldsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusMngmntBOImpl.java used to
 */
public class StatusMngmntBOImpl extends BaseBO implements StatusMngmntBO
{
    StatusMngmntDAO statusMngmntDAO;
    private AlertCommonLibBO alertCommonLibBO;

    StatusMngmntSC criteria = new StatusMngmntSC();
    private final static String ALRT_SUB_SUB_TYPE = "A";

    /**
     * Method used to return Count of StatusMngmnt
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     * 
     * 
     * 
     */

    @Override
    public StatusMngmntCO processSuspend(StatusMngmntCO stmgmtco) throws BaseException
    {

	int d = 0;
	int flag = 0;

	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {

		d++;

	    }
	}
	if(d == 0)
	{

	    throw new BOException(ALRTMessageCodes.PLEASE_SELECT_A_SUBSCRIPTION);
	}

	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{

	    ALRT_SUB_EVTVO alertSubEvtVO = stMngmntCO.getAlrt_sub_evtvo();
	    ALRT_EVT_GRPVO alertEvtGrpVO = stMngmntCO.getAlertEvtGrpVO();

	    ALRT_GRP_PKGVO alertGrpPkgVO = stMngmntCO.getAlertGrpPkgVO();
	    ALRT_SUB_PKGVO alrtSubPkg = stMngmntCO.getAlertSubPkgVO();

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {

		if("A".equals(stmgmtco.getStatus()))
		{

		    if(!"S".equals(alertSubEvtVO.getSTATUS()))

		    {

			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
			flag = 1;
		    }
		}

		if("SE".equals(stmgmtco.getStatus()))
		{

		    if(!"S".equals(alertSubEvtVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
		    }
		}

		else if("GP".equals(stmgmtco.getStatus()))
		{
		    if(!"S".equals(alertGrpPkgVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
		    }

		}

		else if("EG".equals(stmgmtco.getStatus()))
		{
		    if(!"S".equals(alertEvtGrpVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
		    }

		}
		else if("SP".equals(stmgmtco.getStatus()))
		{
		    if(!"S".equals(alrtSubPkg.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
		    }

		}

	    }

	}
	if(flag == 0)
	{

	    throw new BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
	}
	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{
	    ALRT_SUB_EVTVO alertSubEvtVO = stMngmntCO.getAlrt_sub_evtvo();

	    ALRT_EVT_GRPVO alertEvtGrpVO = stMngmntCO.getAlertEvtGrpVO();
	    ALRT_EVTVO alertEvtVo = stMngmntCO.getAlrt_evtvo();
	    ALRT_GRPVO alertGrpVO = stMngmntCO.getAlertGrpVO();
	    ALRT_GRP_PKGVO alertGrpPkgVO = stMngmntCO.getAlertGrpPkgVO();
	    ALRT_SUB_PKGVO alrtSubPkg = stMngmntCO.getAlertSubPkgVO();

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {

		if("SE".equals(stmgmtco.getStatus()) || "A".equals(stmgmtco.getStatus()))
		{
		    ALRT_SUB_EVTVO alertSubEvt = new ALRT_SUB_EVTVO();
		    alertSubEvt.setID(alertSubEvtVO.getID());
		    alertSubEvt.setSTATUS("S");
		    alertSubEvt.setSUSPENDED_BY(stmgmtco.getUserId()); // TODO
		    // Where
		    // the
		    // li_line_no
		    // and
		    // is_rel_type
		    // need
		    // to be
		    // check
		    alertSubEvt.setDATE_SUSPENDED(stmgmtco.getRunningDate());

		    // alertSubEvtVO.setREL_TYPE(stmgmtco.getStatus());

		    genericDAO.update(alertSubEvt);

		    // StatusMngmntSC criteria =new StatusMngmntSC();
		    // statusMngmntDAO.processSuspend( criteria );

		}
		else
		{

		    if("GP".equals(stmgmtco.getStatus()) || "EG".equals(stmgmtco.getStatus()))
		    {

			// statusMngmntDAO.retriveData(criteria); //line
			// number
			// and rel
			// for(StatusMngmntCO statusMngmntCO :
			// stmgmtco.getStatusGridList())
			// {
			//
			// BigDecimal ld_sub_id = alertSubEvtVO.getSUB_ID();
			//
			// // wfchecksub("SUSPEND", ld_sub_id,
			// BigDecimal.ZERO,
			// BigDecimal.ZERO, stmgmtco);
			//
			// }

			if("GP".equals(stmgmtco.getStatus()))
			{
			    ALRT_GRP_PKGVO alertGrpPkg = new ALRT_GRP_PKGVO();
			    alertGrpPkg.setLINE_NO(alertGrpPkgVO.getLINE_NO());
			    alertGrpPkg.setGRP_ID(alertGrpPkgVO.getGRP_ID());
			    alertGrpPkg.setPKG_ID(alertGrpPkgVO.getPKG_ID());
			    alertGrpPkg.setSTATUS("S");
			    // alertSubEvtVO.setREL_TYPE(stmgmtco.getStatus());
			    alertGrpPkg.setSUSPENDED_BY(stmgmtco.getUserId());

			    alertGrpPkg.setDATE_SUSPENDED(stmgmtco.getRunningDate());
			    genericDAO.update(alertGrpPkg);
			    // ALRT_SUB_EVTVOKey evtkey = new
			    // ALRT_SUB_EVTVOKey();
			    // evtkey.setID(alertEvtVo.getEVT_ID());
			}

			else
			{

			    ALRT_EVT_GRPVO alertevtgrpVO = new ALRT_EVT_GRPVO();
			    alertevtgrpVO.setLINE_NO(alertEvtGrpVO.getLINE_NO());
			    alertevtgrpVO.setGRP_ID(alertGrpVO.getGRP_ID());
			    alertevtgrpVO.setEVT_ID(alertEvtVo.getEVT_ID());
			    alertevtgrpVO.setSTATUS("S");
			    alertevtgrpVO.setSUSPENDED_BY(stmgmtco.getUserId());

			    alertevtgrpVO.setDATE_SUSPENDED(stmgmtco.getRunningDate());

			    genericDAO.update(alertevtgrpVO);

			    ALRT_SUB_EVTVOKey evtkey = new ALRT_SUB_EVTVOKey();
			    evtkey.setID(alertEvtVo.getEVT_ID());
			    ALRT_SUB_EVTVO alrtSubEvtVO = (ALRT_SUB_EVTVO) genericDAO.selectByPK(evtkey);
			    
			    if(alrtSubEvtVO != null)
			    {
				    alrtSubEvtVO.setSTATUS("S");
				    genericDAO.update(alrtSubEvtVO);
			    }

			}

		    }

		    if("SP".equals(stmgmtco.getStatus()))
		    {
			ALRT_SUB_PKGVO alertSubPkg = new ALRT_SUB_PKGVO();
			alertSubPkg.setSUB_ID(alrtSubPkg.getSUB_ID());
			alertSubPkg.setLINE_NO(alrtSubPkg.getLINE_NO());
			alertSubPkg.setPKG_ID(alrtSubPkg.getPKG_ID());
			alertSubPkg.setSTATUS("S");

			genericDAO.update(alertSubPkg);

			ALRT_SUB_EVTVOKey evtkey = new ALRT_SUB_EVTVOKey();
			// ALRT_SUB_EVTVO alertSubEvtVO = new ALRT_SUB_EVTVO();
			evtkey.setID(alrtSubPkg.getSUB_ID());
			ALRT_SUB_EVTVO alrtSubEvtupVO = (ALRT_SUB_EVTVO) genericDAO.selectByPK(evtkey);

			if(alrtSubEvtupVO != null)
		    {
				alrtSubEvtupVO.setSTATUS("S");
				genericDAO.update(alrtSubEvtupVO);
		    }

			// BigDecimal ld_sub_id = alertSubEvtVO.getSUB_ID();
			// wfchecksub("SUSPEND", ld_sub_id, BigDecimal.ZERO,
			// BigDecimal.ZERO, stmgmtco);

			/*
			 * ld_sub_id = dw_main.GetItemNumber(ll_row,'sub_id')
			 * ll_pkg_id=dw_main.GetItemNumber(ll_row,' pkg_id')
			 * li_return = wf_check_sub('SUSPEND', ld_sub_id, 0,0)
			 */
		    }
		    // else
		    // {
		    // BigDecimal ll_evt_id = alertSubEvtVO.getEVT_ID();
		    // BigDecimal ld_sub_id = alertSubEvtVO.getSUB_ID();
		    // BigDecimal ld_sbt_id = alertSubEvtVO.getID();
		    // // wfchecksub("SUSPEND", ld_sub_id, ll_evt_id,
		    // // ld_sbt_id, stmgmtco);
		    // /*
		    // * ll_evt_id = dw_main.GetItemNumber(ll_row,'evt_id')
		    // * ld_sub_id= dw_main.GetItemNumber(ll_row,'sub_id')
		    // * ld_sbt_id=
		    // dw_main.GetItemNumber(ll_row,'sub_evt_id')
		    // *
		    // * li_return = wf_check_sub('SUSPEND', ld_sub_id,
		    // * ll_evt_id,ld_sbt_id)
		    // */
		    // }
		}

	    }

	}
	//
	// if(flag == 1)
	// {
	//
	// throw new
	// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_SUSPENDED);
	// }

	return stmgmtco;

    }

    private void wfchecksub(String string, BigDecimal ld_sub_id, BigDecimal i, BigDecimal j, StatusMngmntCO stmgmtco)
	    throws BaseException
    {

	// TODO Auto-generated method stub

	for(StatusMngmntCO value : stmgmtco.getStatusGridList())
	{
	    // ALRT_EVTVO alertevtVO = value.getAlrt_evtvo();
	    ALRT_EVTVOKey evtkey = new ALRT_EVTVOKey();
	    evtkey.setEVT_ID(value.getAlrt_evtvo().getEVT_ID());
	    ALRT_EVTVO alertevtVO = (ALRT_EVTVO) genericDAO.selectByPK(evtkey);

	    StatusMngmntCO stmgmtCO = new StatusMngmntCO();
	    stmgmtCO.setLsFlag(string + "_FLAG");
	    stmgmtCO.setLsEvt(string + "_EVT");
	    ALRT_CONTROLVOKey key = new ALRT_CONTROLVOKey();
	    key.setCTRL_REFERENCE(stmgmtCO.getLsFlag());

	    ALRT_CONTROLVO alrtctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(key);
	    stmgmtCO.setLiActive(alrtctrlVO.getCTRL_VALUE());
	    // stmgmtCO.setLiActive(BigDecimal.ONE);

	    if(stmgmtCO.getLiActive().compareTo(BigDecimal.ONE) == 0)
	    {

		key.setCTRL_REFERENCE(stmgmtCO.getLsEvt());
		stmgmtCO.setLiEvt(alrtctrlVO.getCTRL_VALUE());
		statusMngmntDAO.alertevtmethod(stmgmtCO);

		//key.setCTRL_REFERENCE("CENTRALIZE_CORE");
		stmgmtCO.setLiCentralized(alrtctrlVO.getCTRL_VALUE());

		if(stmgmtCO.getLiCentralized().compareTo(BigDecimal.ONE) == 0)
		{
		    stmgmtCO.setLdSubId(ld_sub_id);
		    statusMngmntDAO.alertCentralizedMethod(stmgmtCO);
		}

		else
		{
		    stmgmtCO.setLdSubId(ld_sub_id);
		    statusMngmntDAO.subscriberDetails(stmgmtCO); // get
								 // subscriber
		    // details
		}
		// ALRT_SUBVO alertSubVO = new ALRT_SUBVO();
		ALRT_SUBVOKey alertsubVOkey = new ALRT_SUBVOKey();
		alertsubVOkey.setID(ld_sub_id);
		ALRT_SUBVO alertSubVO = (ALRT_SUBVO) genericDAO.selectByPK(alertsubVOkey);

		CIFVOKey cifkey = new CIFVOKey();
		cifkey.setCOMP_CODE(alertSubVO.getCOMP_CODE());
		if(StringUtil.nullToEmpty(alertSubVO.getSUB_TYPE()).equals('A'))
		{
		    cifkey.setCIF_NO(alertSubVO.getCIF_SUB_NO());
		}
		else
		{
		    cifkey.setCIF_NO(alertSubVO.getCIF_NO());
		}

		if(alertSubVO.getLANG().equals("AR"))
		{

		    alertevtVO.setMESSAGE_SUBJECT_ENG(alertevtVO.getMESSAGE_SUBJECT_ARAB());
		    alertevtVO.setMESSAGE_TEXT_ENG(alertevtVO.getMESSAGE_TEXT_ARAB());
		}

//		StatusMngmntCO x = fParceMsg(stmgmtco);
		fParceMsg(stmgmtco);
		if(alertevtVO.getMESSAGE_TEXT_ENG() != null && alertevtVO.getEVT_MODE() != "B")
		{
		    if(alertevtVO.getEVT_MODE() != "E"
			    && (alertSubVO.getEMAIL_ID() != null || !StringUtil.isNotEmpty(alertSubVO.getEMAIL_ID()))
			    && (alertevtVO.getEVT_MODE() != "S" && alertSubVO.getMOBILE_PHONE() != null))
		    {
			// f_get_alrtsequence('ALRT_QUEUE', ld_max)
			AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
			alertCommonLibSC.setTrxType(AlertConstant.ALRT_QUEUE);
			alertCommonLibSC.setLanguage(stmgmtCO.getLsLang());
			alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

			ALRT_QUEUEVO alertqueueVO = new ALRT_QUEUEVO();
			alertqueueVO.setID(alertCommonLibSC.getAlrtCount());
			alertqueueVO.setMESSAGE_SUBJECT_ENG(alertevtVO.getMESSAGE_SUBJECT_ENG());
			alertqueueVO.setMESSAGE_TEXT_ENG(alertevtVO.getMESSAGE_TEXT_ENG());
			alertqueueVO.setALRT_DATE(stmgmtCO.getRunningDate());
			alertqueueVO.setSTOP_AFTER(null);
			alertqueueVO.setMOBILE_PHONE(alertSubVO.getMOBILE_PHONE());
			alertqueueVO.setEMAIL_ID(alertSubVO.getEMAIL_ID());
			alertqueueVO.setEVT_MODE(alertevtVO.getEVT_MODE());
			alertqueueVO.setEVT_ID(alertevtVO.getEVT_ID());
			alertqueueVO.setSUB_ID(alertSubVO.getID());
			alertqueueVO.setMSG_LANG(alertSubVO.getLANG());
			alertqueueVO.setEVT_PRIORITY(alertevtVO.getPRIORITY());

//			int q = genericDAO.insert(alertqueueVO);
			genericDAO.insert(alertqueueVO);
			// if(q != 1)
			// {
			// throw new BOException("Error sending activation
			// service",
			// "Failed to insert activation service alert into
			// queue.
			// ");
			// }

		    }

		}

		else
		{
		    if((alertSubVO.getEMAIL_ID() != null || !StringUtil.isNotEmpty(alertSubVO.getEMAIL_ID())))
		    {
			AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
			alertCommonLibSC.setTrxType(AlertConstant.ALRT_QUEUE);
			alertCommonLibSC.setLanguage(alertSubVO.getLANG());
			alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
			// f_get_alrtsequence('ALRT_QUEUE', ld_max)
			ALRT_QUEUEVO alertqueueVO = new ALRT_QUEUEVO();
			alertqueueVO.setID(alertCommonLibSC.getAlrtCount());
			alertqueueVO.setMESSAGE_SUBJECT_ENG(alertevtVO.getMESSAGE_SUBJECT_ENG());
			alertqueueVO.setMESSAGE_TEXT_ENG(alertevtVO.getMESSAGE_TEXT_ENG());
			alertqueueVO.setALRT_DATE(stmgmtCO.getRunningDate());
			alertqueueVO.setSTOP_AFTER(null);
			alertqueueVO.setMOBILE_PHONE(alertSubVO.getMOBILE_PHONE());
			alertqueueVO.setEMAIL_ID(alertSubVO.getEMAIL_ID());
			alertqueueVO.setEVT_MODE("E");
			alertqueueVO.setEVT_ID(alertevtVO.getEVT_ID());
			alertqueueVO.setSUB_ID(alertSubVO.getID());
			alertqueueVO.setMSG_LANG(alertSubVO.getLANG());

			genericDAO.insert(alertqueueVO);

		    }

		    if((alertSubVO.getMOBILE_PHONE() != null || !StringUtil.isNotEmpty(alertSubVO.getMOBILE_PHONE())))
		    {
			// f_get_alrtsequence('ALRT_QUEUE', ld_max)
			AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();
			alertCommonLibSC.setTrxType(AlertConstant.ALRT_QUEUE);
			alertCommonLibSC.setLanguage(stmgmtCO.getLsLang());
			alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);

			ALRT_QUEUEVO alertqueueVO = new ALRT_QUEUEVO();
			alertqueueVO.setID(alertCommonLibSC.getAlrtCount());
			alertqueueVO.setMESSAGE_SUBJECT_ENG(alertevtVO.getMESSAGE_SUBJECT_ENG());
			alertqueueVO.setMESSAGE_TEXT_ENG(alertevtVO.getMESSAGE_TEXT_ENG());
			alertqueueVO.setALRT_DATE(stmgmtCO.getRunningDate());
			alertqueueVO.setSTOP_AFTER(null);
			alertqueueVO.setMOBILE_PHONE(alertSubVO.getMOBILE_PHONE());
			alertqueueVO.setEMAIL_ID(alertSubVO.getEMAIL_ID());
			alertqueueVO.setEVT_MODE("S");
			alertqueueVO.setEVT_ID(alertevtVO.getEVT_ID());
			alertqueueVO.setSUB_ID(alertSubVO.getID());
			alertqueueVO.setMSG_LANG(alertSubVO.getLANG());
			alertqueueVO.setEVT_PRIORITY(alertevtVO.getPRIORITY());

			genericDAO.insert(alertqueueVO);
		    }

		}

	    }

	    else
	    {

		// throw new
		// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		break; /*
		        * If li_return <= 0 Then Exit End If
		        */

	    }

	}

    }

    private StatusMngmntCO fParceMsg(StatusMngmntCO stmgmtco) throws BaseException
    {
	// TODO Auto-generated method stub

	for(StatusMngmntCO stmntco : stmgmtco.getStatusGridList())
	{
	    // ALRT_SUBVO alertSubVo =stmntco.getAlrt_subvo();
	    ALRT_EVTVO alertevtVO = stmntco.getAlrt_evtvo();
	    ALRT_SUB_EVTVO alertsubevtVO = stmntco.getAlrt_sub_evtvo();

	    ALRT_SUBVOKey alertsubVOkey = new ALRT_SUBVOKey();
	    alertsubVOkey.setID(alertsubevtVO.getSUB_ID());
	    ALRT_SUBVO alertSubVO = (ALRT_SUBVO) genericDAO.selectByPK(alertsubVOkey);
	    String SubType = (alertSubVO.getSUB_TYPE());

	    // stmgmtco.setLsSubType(stmgmtco.getAlrt_subvo().getSUB_TYPE());
	    if(ALRT_SUB_SUB_TYPE.equals(SubType))	    
	    {
		AMFVOKey key = new AMFVOKey();
		key.setCOMP_CODE(alertSubVO.getCOMP_CODE());
		key.setBRANCH_CODE(alertSubVO.getBRANCH_CODE());
		key.setCURRENCY_CODE(alertSubVO.getCURRENCY_CODE());
		key.setGL_CODE(alertSubVO.getGL_CODE());
		key.setCIF_SUB_NO(alertSubVO.getCIF_SUB_NO());
		key.setSL_NO(alertSubVO.getSL_NO());
//		AMFVO amfVO = (AMFVO) genericDAO.selectByPK(key);		
		genericDAO.selectByPK(key);
	    }

//	    String asMessage = alertevtVO.getMESSAGE_SUBJECT_ENG();
	    alertevtVO.getMESSAGE_SUBJECT_ENG();

	    // TODO

	    // Ll_f_tag = Pos ( as_message, '>' )
	    // Ll_s_tag = Pos ( as_message, '<' )
	    // Ls_tag_name = Mid ( as_message, Ll_s_tag + 1, Ll_f_tag - Ll_s_tag
	    // - 1 )
	    //
	    // If Ll_f_tag > 0 AND Ll_s_tag > 0 Then
	    // DO WHILE Ll_f_tag > 0 AND Ll_s_tag > 0
	    //
	    // Choose Case Ls_tag_name
	    // Case 'ADD_REF'
	    // If IsNull(ls_additional_reference) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_additional_reference
	    // End If
	    // Case 'ACC_BRIEF_NAME_AR'
	    // If IsNull(ls_brief_name_arab) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_brief_name_arab
	    // End if
	    // Case 'ACC_BRIEF_NAME_EN'
	    // If IsNull(ls_brief_name_eng) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_brief_name_eng
	    // End If
	    // Case 'ACC_LONG_NAME_AR'
	    // If IsNull(ls_long_name_arab) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_long_name_arab
	    // End If
	    // Case 'ACC_LONG_NAME_EN'
	    // If IsNull(ls_long_name_eng) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_long_name_eng
	    // End If
	    // Case 'OLD_MOBILE_NUM'
	    // If IsNull(ls_old_mobile_phone) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_old_mobile_phone
	    // End If
	    // Case 'MOBILE_NUM'
	    // If IsNull(ls_mobile_phone) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_mobile_phone
	    // End If
	    // Case 'SERVER_DATE'
	    // If IsNull(ldt_sysdate) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = String(ldt_sysdate)
	    // End If
	    // Case 'EVT_SUBJECT_EN'
	    // If IsNull(ls_message_subject_eng) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_message_subject_eng
	    // End If
	    // Case 'EVT_SUBJECT_AR'
	    // If IsNull(ls_message_subject_arab) Then
	    // Ls_value = ''
	    // Else
	    // Ls_value = ls_message_subject_arab
	    // End If
	    // End Choose
	    //
	    // //ls_message = ls_message + Ls_value
	    // as_message = Replace ( as_message, Ll_s_tag, Ll_f_tag - Ll_s_tag
	    // +1, Ls_value )
	    //
	    // //Ls_msg = Mid( Ls_msg, Ll_f_tag + Len(Ls_value) +
	    // Len(Ls_tag_name) + 4)
	    // //Ls_msg = Mid( Ls_msg, Ll_f_tag + 1)
	    // Ll_f_tag = Pos ( as_message, '>' )
	    // Ll_s_tag = Pos ( as_message, '<' )
	    //
	    // Ls_tag_name = Mid ( as_message,Ll_s_tag + 1, Ll_f_tag -Ll_s_tag -
	    // 1 )
	    //
	    // LOOP
	    // End If

	    // throw new BOException("message is :" + asMessage);

	}
	return stmgmtco;
    }

    @Override
    public int returnStatusMngmntListCount(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "A"));
	return statusMngmntDAO.returnStatusMngmntListCount(criteria);
    }

    /**
     * Method used to return List of StatusMngmnt
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BOException
     */
    @Override
    public List returnStatusMngmntList(StatusMngmntSC criteria) throws BaseException
    {

	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "A"));
	return statusMngmntDAO.returnStatusMngmntList(criteria);
    }

    public StatusMngmntDAO getStatusMngmntDAO()
    {
	return statusMngmntDAO;
    }

    public void setStatusMngmntDAO(StatusMngmntDAO statusMngmntDAO)
    {
	this.statusMngmntDAO = statusMngmntDAO;
    }

    @Override
    public StatusMngmntCO processApprove(StatusMngmntCO stmgmtco) throws BaseException
    {
	int e = 0;
	int flag = 0;

	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {

		e++;

	    }
	}
	if(e == 0)
	{
	    throw new BOException(ALRTMessageCodes.PLEASE_SELECT_A_SUBSCRIPTION);
	}

	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{

	    ALRT_SUB_EVTVO alertSubEvtVO = stMngmntCO.getAlrt_sub_evtvo();

	    ALRT_EVT_GRPVO alertEvtGrpVO = stMngmntCO.getAlertEvtGrpVO();

	    ALRT_GRP_PKGVO alertGrpPkgVO = stMngmntCO.getAlertGrpPkgVO();
	    ALRT_SUB_PKGVO alrtSubPkgVO = stMngmntCO.getAlertSubPkgVO();

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {
		if("A".equals(stmgmtco.getStatus()))
		{

		    if(!"P".equals(alertSubEvtVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		    }
		}

		if("SE".equals(stmgmtco.getStatus()))
		{

		    if(!"P".equals(alertSubEvtVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		    }

		}

		else if("GP".equals(stmgmtco.getStatus()))
		{
		    if(!"P".equals(alertGrpPkgVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		    }

		}

		else if("EG".equals(stmgmtco.getStatus()))
		{
		    if(!"P".equals(alertEvtGrpVO.getSTATUS())) // alertEvtGrpVO

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		    }

		}
		else if("SP".equals(stmgmtco.getStatus()))
		{
		    if(!"P".equals(alrtSubPkgVO.getSTATUS()))

		    {
			flag = 1;
			// throw new
			// BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
		    }

		}

	    }

	}

	if(flag == 0)
	{

	    throw new BOException(ALRTMessageCodes.THESE_SUBSCRIPTIONS_ARE_ALREADY_ACTIVATED);
	}

	for(StatusMngmntCO stMngmntCO : stmgmtco.getStatusGridList())
	{

	    ALRT_EVT_GRPVO alertEvtGrpVO = stMngmntCO.getAlertEvtGrpVO();
	    ALRT_EVTVO alertEvtVo = stMngmntCO.getAlrt_evtvo();
	    ALRT_GRPVO alertGrpVO = stMngmntCO.getAlertGrpVO();
	    ALRT_GRP_PKGVO alertGrpPkgVO = stMngmntCO.getAlertGrpPkgVO();
	    ALRT_SUB_PKGVO alrtSubPkgVO = stMngmntCO.getAlertSubPkgVO();
	    ALRT_SUB_EVTVO alertSubEvtVO = stMngmntCO.getAlrt_sub_evtvo();

	    if(ConstantsCommon.YES.equals(stMngmntCO.getStatuschck()))
	    {

		if("SE".equals(stmgmtco.getStatus()) || "A".equals(stmgmtco.getStatus()))
		{

		    ALRT_SUB_EVTVO alertSubEvt = new ALRT_SUB_EVTVO();
		    alertSubEvt.setID(alertSubEvtVO.getID());
		    alertSubEvt.setSTATUS(ConstantsCommon.STATUS_APPROVED);

		    genericDAO.update(alertSubEvt);
		    // StatusMngmntSC criteria =new StatusMngmntSC();
		    // statusMngmntDAO.processSuspend( criteria );
		}
		else
		{

		    if("GP".equals(stmgmtco.getStatus()) || "EG".equals(stmgmtco.getStatus()))
		    {

			if("GP".equals(stmgmtco.getStatus()))
			{
			    ALRT_GRP_PKGVO alertGrpPkg = new ALRT_GRP_PKGVO();
			    alertGrpPkg.setLINE_NO(alertGrpPkgVO.getLINE_NO());
			    alertGrpPkg.setGRP_ID(alertGrpPkgVO.getGRP_ID());
			    alertGrpPkg.setPKG_ID(alertGrpPkgVO.getPKG_ID());
			    alertGrpPkg.setSTATUS(ConstantsCommon.STATUS_APPROVED);
			    // alertSubEvtVO.setREL_TYPE(stmgmtco.getStatus());

			    genericDAO.update(alertGrpPkg);
			}

			else
			{

			    ALRT_EVT_GRPVO alertevtgrpVO = new ALRT_EVT_GRPVO();
			    alertevtgrpVO.setLINE_NO(alertEvtGrpVO.getLINE_NO());
			    alertevtgrpVO.setGRP_ID(alertGrpVO.getGRP_ID());
			    alertevtgrpVO.setEVT_ID(alertEvtVo.getEVT_ID());
			    alertevtgrpVO.setSTATUS(ConstantsCommon.STATUS_APPROVED);

			    genericDAO.update(alertevtgrpVO);

			    ALRT_SUB_EVTVOKey evtkey = new ALRT_SUB_EVTVOKey();
			    evtkey.setID(alertEvtVo.getEVT_ID());
			    ALRT_SUB_EVTVO alrtSubEvtVO = (ALRT_SUB_EVTVO) genericDAO.selectByPK(evtkey);
			    
			    if(alrtSubEvtVO != null)
			    {
				    alrtSubEvtVO.setSTATUS(ConstantsCommon.STATUS_APPROVED);
				    genericDAO.update(alrtSubEvtVO);
			    }
			}
		    }
		    else
		    {

			if("SP".equals(stmgmtco.getStatus()))
			{
			    ALRT_SUB_PKGVO alertSubPkg = new ALRT_SUB_PKGVO();
			    alertSubPkg.setSUB_ID(alrtSubPkgVO.getSUB_ID());
			    alertSubPkg.setLINE_NO(alrtSubPkgVO.getLINE_NO());
			    alertSubPkg.setPKG_ID(alrtSubPkgVO.getPKG_ID());
			    alertSubPkg.setSTATUS(ConstantsCommon.STATUS_APPROVED);

			    genericDAO.update(alertSubPkg);

			    ALRT_SUB_EVTVOKey evtkey = new ALRT_SUB_EVTVOKey();
			    evtkey.setID(alrtSubPkgVO.getSUB_ID());
			    ALRT_SUB_EVTVO alrtSubEvtVO = (ALRT_SUB_EVTVO) genericDAO.selectByPK(evtkey);
			    if(alrtSubEvtVO != null)
			    {
				    alrtSubEvtVO.setSTATUS(ConstantsCommon.STATUS_APPROVED);
				    genericDAO.update(alrtSubEvtVO);
			    }

			}

		    }

		}

	    }
	}

	return stmgmtco;

    }

    public AlertCommonLibBO getAlertCommonLibBO()
    {
	return alertCommonLibBO;
    }

    public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.alert.bo.statusmngmnt.StatusMngmntBO#
     * returnSubscriberPackageListCount(com.path.alert.vo.statusmngmnt.
     * StatusMngmntSC)
     */
    @Override
    public int returnSubscriberPackageListCount(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "SP"));
	return statusMngmntDAO.returnSubscriberPackageListCount(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnSubscriberPackageList
     * (com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public List returnSubscriberPackageList(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "SP"));
	return statusMngmntDAO.returnSubscriberPackageList(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnGroupPackageListCount
     * (com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public Integer returnGroupPackageListCount(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "GP"));
	return statusMngmntDAO.returnGroupPackageListCount(criteria);
    }

    @Override
    public List returnGroupPackageList(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "GP"));
	return statusMngmntDAO.returnGroupPackageList(criteria);
    }

    @Override
    public StatusMngmntCO loadStatusMngmntPage(StatusMngmntCO stmgmtco) throws BaseException
    {
    	
    	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
    	reqFieldSC.setCompCode(stmgmtco.getCompCode());
    	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(stmgmtco.getAppName(), stmgmtco.getProgRef()));
    	reqFieldSC.setAppName(stmgmtco.getAppName());
    	reqFieldSC.setBranchCode(stmgmtco.getBranchCode());

    	applyDynScreenDisplay(
    		new String[] { "Suspend" , "Reactivate" },
    		ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), stmgmtco.getHm(), reqFieldSC);

    	
    	
	return stmgmtco;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnsubScriberEventCount(
     * com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public Integer returnsubScriberEventCount(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "SE"));
	return statusMngmntDAO.returnsubScriberEventCount(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnSubscriberEventList(
     * com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public List returnSubscriberEventList(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "SE"));
	return statusMngmntDAO.returnSubscriberEventList(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnGroupEventListCount(
     * com.path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public Integer returnGroupEventListCount(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "EG"));
	return statusMngmntDAO.returnGroupEventListCount(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.alert.bo.statusmngmnt.StatusMngmntBO#returnGroupEventList(com.
     * path.alert.vo.statusmngmnt.StatusMngmntSC)
     */
    @Override
    public List returnGroupEventList(StatusMngmntSC criteria) throws BaseException
    {
	criteria.setRelType(StringUtil.nullEmptyToValue(criteria.getRelType(), "EG"));
	return statusMngmntDAO.returnGroupEventList(criteria);
    }

}
