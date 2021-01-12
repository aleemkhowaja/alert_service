package com.path.alert.bo.controlrecord.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.controlrecord.ControlRecordBO;
import com.path.alert.dao.controlrecord.ControlRecordDAO;
import com.path.alert.vo.controlrecord.ControlRecordCO;
import com.path.alert.vo.controlrecord.ControlRecordSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.customexpression.ExpressionParamCO;

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
public class ControlRecordBOImpl extends BaseBO implements ControlRecordBO
{
    // private SmartBO smartBO;
    private ControlRecordDAO alertControlRecordDAO;

    @Override
    public ControlRecordCO initialize(ControlRecordCO CO1) throws BaseException
    {
	// TODO Auto-generated method stub

	ControlRecordCO controlRecordCO = new ControlRecordCO();

	//ALRT_CONTROLVO alrtcontrol = new ALRT_CONTROLVO();
	/*alrtcontrol.setCTRL_REFERENCE(AlertConstant.ACC_REP_ID);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null != alrtcontrol)
	{
	    controlRecordCO.setAccRepID(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}
	//////////////////////////////////////////////////////////////
	// ALRT_CONTROLVO alrtcontrol = new ALRT_CONTROLVO();
	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.PRINT_FLAG);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setPrintFlag(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setPrintFlag(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}

	/*
	 * if (null != alrtcontrol) {
	 * controlRecordCO.setPrintFlag(NumberUtil.emptyDecimalToNull(
	 * alrtcontrol.getCTRL_VALUE())); }
	 */
	///////////////////////////////////////////////////////////
	/// ALRT_CONTROLVO alrtcontrol = new ALRT_CONTROLVO();
	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.ACTIV_FLAG);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setActivFlag(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setActivFlag(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}

	/*
	 * if (null != alrtcontrol) {
	 * controlRecordCO.setActivFlag(NumberUtil.emptyDecimalToNull(
	 * alrtcontrol.getCTRL_VALUE())); }
	 */

	///////////////////////////////////////////////////////////
	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.ACTIV_EVT);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null != alrtcontrol)
	{
	    controlRecordCO.setActivEvt(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}
	///////////////////////////////////////////////////////////
	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.REACTIV_FLAG);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setReactivFlag(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setReactivFlag(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}

	/*
	 * if (null != alrtcontrol) {
	 * controlRecordCO.setReactivFlag(NumberUtil.emptyDecimalToNull(
	 * alrtcontrol.getCTRL_VALUE())); }
	 */

	///////////////////////////////////////////////////////////
	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.REACTIV_EVT);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null != alrtcontrol)
	{
	    controlRecordCO.setReactivEvt(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}
	///////////////////////////////////////////////////////////
	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SUSPEND_FLAG);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setSuspendFlag(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setSuspendFlag(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}
	/*
	 * if (null != alrtcontrol) {
	 * controlRecordCO.setSuspendFlag(NumberUtil.emptyDecimalToNull(
	 * alrtcontrol.getCTRL_VALUE())); }
	 * 
	 */

	///////////////////////////////////////////////////////////
	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SUSPEND_EVT);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null != alrtcontrol)
	{
	    controlRecordCO.setSuspendEvt(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}
	///////////////////////////////////////////////////////////
	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.MOBILE_FLAG);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setMobileFlag(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setMobileFlag(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}

	/*
	 * if (null != alrtcontrol) {
	 * controlRecordCO.setMobileFlag(NumberUtil.emptyDecimalToNull(
	 * alrtcontrol.getCTRL_VALUE())); }
	 */

	///////////////////////////////////////////////////////////
	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.MOBILE_EVT);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null != alrtcontrol)
	{
	    controlRecordCO.setMobileEvt(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}

	///////////////////////////////////////////////////////////
	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	/*if(null == alrtcontrol)
	{
	    controlRecordCO.setCentralizeCore(BigDecimal.ZERO);

	}
	else
	{
	    controlRecordCO.setCentralizeCore(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}*/

	/*alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.PROTOCOL_TYPE);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setProtocolType(AlertConstant.SMTP);
	}
	else
	{
	    controlRecordCO.setProtocolType(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}

	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SMTP_IP);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setIpAddress("");
	}
	else
	{
	    controlRecordCO.setIpAddress(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}

	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SMTP_PORT);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setPortNumber("");
	}
	else
	{
	    controlRecordCO.setPortNumber(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}

	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SMTP_SENDER);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	controlRecordCO.setSenderEmail(alrtcontrol.getCTRL_VALUE_CHARACTER());
	if(null == alrtcontrol)
	{
	    controlRecordCO.setSenderEmail("");
	}
	else
	{
	    controlRecordCO.setSenderEmail(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}

	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SMTP_USER);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setUserId("");
	}
	else
	{
	    controlRecordCO.setUserId(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}

	alrtcontrol = new ALRT_CONTROLVO();

	alrtcontrol.setCTRL_REFERENCE(AlertConstant.SMTP_PASSWORD);
	alrtcontrol.setCOMP_CODE(CO1.getCompCode());
	alrtcontrol = (ALRT_CONTROLVO) genericDAO.selectByPK(alrtcontrol);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setPassword("");
	}
	else
	{
	    controlRecordCO.setPassword(alrtcontrol.getCTRL_VALUE_CHARACTER());
	}*/
	
	//outlook option is not available anymore
	controlRecordCO.setProtocolType(AlertConstant.SMTP);

	PTH_CTRLVO pth = commonLibBO.returnPthCtrl();
	
	controlRecordCO.setIpAddress(StringUtil.nullToEmpty(pth.getSMTP_IP()));
	controlRecordCO.setPortNumber(StringUtil.nullToEmpty(pth.getSMPT_PORT()));
	controlRecordCO.setSenderEmail(StringUtil.nullToEmpty(pth.getSMTP_SENDER()));
	controlRecordCO.setUserId(StringUtil.nullToEmpty(pth.getSMTP_USER()));
	controlRecordCO.setPassword(StringUtil.nullToEmpty(pth.getSMTP_PASSWORD()));
	
	ControlRecordSC criteria = new ControlRecordSC();
	List<String> ctrlReferenceList  = new ArrayList<String>();
	ctrlReferenceList.add(AlertConstant.EMAIL_CONFIG_TYPE);
	ctrlReferenceList.add(AlertConstant.ACTIV_FLAG);
	ctrlReferenceList.add(AlertConstant.ACTIV_EVT);
	ctrlReferenceList.add(AlertConstant.REACTIV_FLAG);
	ctrlReferenceList.add(AlertConstant.REACTIV_EVT);
	ctrlReferenceList.add(AlertConstant.SUSPEND_FLAG);
	ctrlReferenceList.add(AlertConstant.SUSPEND_EVT);
	ctrlReferenceList.add(AlertConstant.MOBILE_EVT);
	ctrlReferenceList.add(AlertConstant.MOBILE_FLAG);
	ctrlReferenceList.add(AlertConstant.SMS_CONFIG_TYPE);
	
	criteria.setCtrlReferenceList(ctrlReferenceList);
	
	List<ALRT_CONTROLVO> alrtCtrlList = alertControlRecordDAO.returnAlrtCtrl(criteria);
	
	//HashMap<String,ALRT_CONTROLVO> alrtCtrlMap = new HashMap<String,ALRT_CONTROLVO>();
	for(int i=0;i<alrtCtrlList.size();i++) {
		if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.EMAIL_CONFIG_TYPE))
		{
			if(alrtCtrlList.get(i).getCTRL_VALUE() == null)
			{
				 controlRecordCO.setEmailConfigType(BigDecimal.ZERO);
			}
			else
			{
				controlRecordCO.setEmailConfigType(alrtCtrlList.get(i).getCTRL_VALUE());
			}
			
		}
		else
			if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.SMS_CONFIG_TYPE))
			{
				if(alrtCtrlList.get(i).getCTRL_VALUE() == null)
				{
					 controlRecordCO.setSmsConfigType(BigDecimal.ZERO);
				}
				else
				{
					controlRecordCO.setSmsConfigType(alrtCtrlList.get(i).getCTRL_VALUE());
				}
				
			}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.ACTIV_FLAG))
		{
			controlRecordCO.setActivFlag(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.ACTIV_EVT))
		{
			controlRecordCO.setActivEvt(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.REACTIV_FLAG))
		{
			controlRecordCO.setReactivFlag(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.REACTIV_EVT))
		{
			controlRecordCO.setReactivEvt(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.SUSPEND_FLAG))
		{
			controlRecordCO.setSuspendFlag(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.SUSPEND_EVT))
		{
			controlRecordCO.setSuspendEvt(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.MOBILE_FLAG))
		{
			controlRecordCO.setMobileFlag(alrtCtrlList.get(i).getCTRL_VALUE());
		}
		else if(alrtCtrlList.get(i).getCTRL_REFERENCE().equals(AlertConstant.MOBILE_EVT))
		{
			controlRecordCO.setMobileEvt(alrtCtrlList.get(i).getCTRL_VALUE());
		}
	}
	
/*	alrtcontrol = alrtCtrlMap.get(AlertConstant.EMAIL_CONFIG_TYPE);
	if(null == alrtcontrol)
	{
	    controlRecordCO.setEmailConfigType(BigDecimal.ZERO);
	}
	else
	{
	    controlRecordCO.setEmailConfigType(NumberUtil.emptyDecimalToNull(alrtcontrol.getCTRL_VALUE()));
	}*/
	
	//dependencyByProtType(controlRecordCO);
	dependencyByEmailConfigType(controlRecordCO);
	this.dependencySmsConfigType(controlRecordCO);
	return controlRecordCO;
    }

    @Override
    public ControlRecordCO updateControlRecord(ControlRecordCO controlRecordCO) throws BaseException
    {

	validateMandatoryFields(controlRecordCO);

	alertControlRecordDAO.updateAlrtCtrl(controlRecordCO);
	
	ControlRecordSC criteria = new ControlRecordSC();
	List<String> ctrlReferenceList  = new ArrayList<String>();
	ctrlReferenceList.add(AlertConstant.EMAIL_CONFIG_TYPE);
	criteria.setCtrlReferenceList(ctrlReferenceList);
	List<ALRT_CONTROLVO> alrtCtrlList = alertControlRecordDAO.returnAlrtCtrl(criteria);
	
	ControlRecordCO oldControlRecordCO = (ControlRecordCO) controlRecordCO.getAuditObj();
	ALRT_CONTROLVO oldAlrtControl;
	ALRT_CONTROLVO newAlrtControl;
	
	for(int i=0; i<alrtCtrlList.size();i++) {
		newAlrtControl = alrtCtrlList.get(i);
		
		oldAlrtControl = new ALRT_CONTROLVO();
		oldAlrtControl.setCTRL_REFERENCE(newAlrtControl.getCTRL_REFERENCE());
		if(AlertConstant.EMAIL_CONFIG_TYPE.equals(newAlrtControl.getCTRL_REFERENCE())) {
			oldAlrtControl.setCTRL_VALUE(oldControlRecordCO.getEmailConfigType());
		}
		
	//	AuditRefCO refCO=controlRecordCO.getAuditRefCO();
		//refCO.setTrxNbr(controlRecordCO.getProgRef());
	//	auditBO.callAudit(oldAlrtControl, newAlrtControl, refCO);
		//auditBO.insertAudit(controlRecordCO.getAuditRefCO());
	}
	
	/*validateBusinessCheckings(controlRecordCO);

	// Integer result = 0;

	ControlRecordSC sc = new ControlRecordSC();
	for(int i = 0; i < controlRecordCO.getAlrtCtrlVoList().size(); i++)
	{
	    sc = updateAlrtCtrl(controlRecordCO, controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_VALUE(),
		    controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE(), i, refCO);
	    if(null == sc.getResult() || 1 > sc.getResult())
	    {

		if(AlertConstant.ACTIV_FLAG.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_ACTIV_FLAG_PARAMETER);
		}
		else if(AlertConstant.ACTIV_EVT.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_ACTIV_EVENT_PARAMETER);
		}
		else if(AlertConstant.REACTIV_FLAG
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_REACTIVATION_FLAG_PARAMETER);
		}
		else if(AlertConstant.REACTIV_EVT
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_REACTIVATION_EVENT_PARAMETER);
		}
		else if(AlertConstant.SUSPEND_FLAG
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SUSPEND_FLAG_PARAMETER);
		}
		else if(AlertConstant.SUSPEND_EVT
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SUSPEND_EVENT_PARAMETER);
		}
		else if(AlertConstant.MOBILE_FLAG
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_MOBILE_FLAG_PARAMETER);
		}
		else if(AlertConstant.MOBILE_EVT.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_MOBILE_ENVENT_PARAMETER);
		}
		else if(AlertConstant.PRINT_FLAG.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_PRINT_FLAG_PARAMETER);
		}
		else if(AlertConstant.ACC_REP_ID.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_REPORT_ID_PARAMETER);
		}
		/*else if(AlertConstant.CENTRALIZE_CORE
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_CENTRALIZE_WITH_CORE_PARAMETER);
		}*//*
		else if(AlertConstant.PROTOCOL_TYPE
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_PROTOCOL_TYPE);
		}
		else if(AlertConstant.SMTP_IP.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SMTP_IP);
		}
		else if(AlertConstant.SMTP_PORT.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SMTP_PORT);
		}
		else if(AlertConstant.SMTP_SENDER
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SMTP_SENDER);
		}
		else if(AlertConstant.SMTP_USER.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SMTP_USER);
		}
		else if(AlertConstant.SMTP_PASSWORD
			.equals(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_REFERENCE()))
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_UPDATING_SMTP_PASS);
		}
	    }
	    if(sc.getCount().compareTo(1) == 0)
	    {
		refCO.setTrxNbr(controlRecordCO.getProgRef());
		// refCO.setTrxNbr(auditBO.checkAuditKey(controlRecordCO.getAlrtCtrlVoList().get(i),
		// refCO));
		// controlRecordCO.getAuditRefCO().getAuditCO().getAuditVO().setTRX_NBR(refCO.getTrxNbr());
		auditBO.callAudit(controlRecordCO.getOldAlrtCtrlVoList().get(i),
			controlRecordCO.getAlrtCtrlVoList().get(i), refCO);
		// controlRecordCO.getAuditRefCO().setTrxNbr("00000000000000000000000000000000000CENTRALIZE_CORE");
		auditBO.insertAudit(controlRecordCO.getAuditRefCO());

	    }
	    else
	    {

		refCO.setTrxNbr(controlRecordCO.getProgRef());
		auditBO.callAudit(controlRecordCO.getOldAlrtCtrlVoList().get(i),
			controlRecordCO.getAlrtCtrlVoList().get(i), refCO);
		// controlRecordCO.getAuditRefCO().setTrxNbr("00000000000000000000000000000000000CENTRALIZE_CORE");
		auditBO.insertAudit(controlRecordCO.getAuditRefCO());
	    }

	}*/

	/*
	 * controlRecordCO.getAlrtCtrlVO().setCTRL_VALUE(controlRecordCO.
	 * getCentralizeCore());
	 * controlRecordCO.getAlrtCtrlVO().setCTRL_REFERENCE(AlertConstant.
	 * CENTRALIZE_CORE); auditBO.callAudit(auditCO10.getAlrtCtrlVO(),
	 * controlRecordCO.getAlrtCtrlVO(), refCO); auditBO.insertAudit(refCO);
	 */

	return controlRecordCO;
    }

    private ControlRecordSC updateAlrtCtrl(ControlRecordCO controlRecordCO, BigDecimal value, String reference,
	    Integer i, AuditRefCO refCO) throws BaseException
    {

	ControlRecordSC sc = new ControlRecordSC();
	sc.setCompCode(controlRecordCO.getCompCode());
	sc.setCtrlReference(reference);
	sc.setCount(alertControlRecordDAO.returnAlrtCtrlCount(sc));

	ALRT_CONTROLVO alrtCtrl = new ALRT_CONTROLVO();
	alrtCtrl.setCTRL_VALUE(value);
	alrtCtrl.setCTRL_REFERENCE(reference);
	alrtCtrl.setCOMP_CODE(controlRecordCO.getCompCode());
	alrtCtrl.setCTRL_VALUE_CHARACTER(controlRecordCO.getAlrtCtrlVoList().get(i).getCTRL_VALUE_CHARACTER());
//	Integer result = 0;
	if(sc.getCount().compareTo(1) == 0)
	{
	    sc.setResult(genericDAO.update(alrtCtrl));

	    /*
	     * ControlRecordCO auditCO = (ControlRecordCO)
	     * controlRecordCO.getAuditObj();
	     * auditBO.callAudit(auditCO.getAlrtCtrlVoList().get(i),
	     * controlRecordCO.getAlrtCtrlVoList().get(i), refCO);
	     * auditBO.insertAudit(refCO);
	     */

	}
	else
	{

	    sc.setResult(genericDAO.insert(alrtCtrl));

	}

	return sc;

    }

    @Override
    public ControlRecordCO dependencyByBoxes(ControlRecordCO controlRecordCO) throws BaseException
    {

	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(controlRecordCO.getCompCode());
	reqFieldSC
		.setProgRef(commonLibBO.returnOrginProgRef(controlRecordCO.getAppName(), controlRecordCO.getProgRef()));
	reqFieldSC.setAppName(controlRecordCO.getAppName());
	reqFieldSC.setBranchCode(controlRecordCO.getBranchCode());

	commonLibBO.applyDynScreenDisplay(
		new String[] { controlRecordCO
			.getId() }/* new String[]{"sle_evt_id"} */,
		/* new String[]{"controlRecordCO.activEvt"} */
		new String[] { controlRecordCO.getName() }, ConstantsCommon.ACTION_TYPE_MANDATORY,
		controlRecordCO.getIsRequired().toString(), controlRecordCO.getRequiredHm(), reqFieldSC, Boolean.TRUE);

	return controlRecordCO;
    }

    private void validateBusinessCheckings(ControlRecordCO controlRecCO) throws BaseException
    {
	ControlRecordSC sc = new ControlRecordSC();
	Integer nb = 0;
	if(BigDecimal.ONE.equals(controlRecCO.getActivFlag()))
	{
	    if(NumberUtil.emptyDecimalToNull(controlRecCO.getActivEvt()) == null
		    || BigDecimal.ZERO.equals(controlRecCO.getActivEvt()))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_SYSTEM_EVENT_ID);
	    }
	}
	if(null != NumberUtil.emptyDecimalToNull(controlRecCO.getActivEvt()))
	{

	    sc.setEvtID(NumberUtil.emptyDecimalToNull(controlRecCO.getActivEvt()));
	    nb = alertControlRecordDAO.returnSystemEventCount(sc);

	    if(nb.compareTo(0) == 0)
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_SYSTEM_EVENT_ID);
	    }
	}

	if(BigDecimal.ONE.equals(controlRecCO.getReactivFlag()))
	{
	    if(NumberUtil.emptyDecimalToNull(controlRecCO.getReactivEvt()) == null
		    || BigDecimal.ZERO.equals(controlRecCO.getReactivEvt()))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_SYSTEM_REACTIVATION_EVENT_ID);
	    }
	}
	// Integer nb = 0;
	if(null != NumberUtil.emptyDecimalToNull(controlRecCO.getReactivEvt()))
	{
	    // ControlRecordSC sc = new ControlRecordSC();
	    sc.setEvtID(NumberUtil.emptyDecimalToNull(controlRecCO.getReactivEvt()));
	    nb = alertControlRecordDAO.returnSystemEventCount(sc);

	    if(nb.compareTo(0) == 0)
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_SYSTEM_REACTIVATION_EVENT_ID);
	    }

	}

	if(BigDecimal.ONE.equals(controlRecCO.getSuspendFlag()))
	{
	    if(NumberUtil.emptyDecimalToNull(controlRecCO.getSuspendEvt()) == null
		    || BigDecimal.ZERO.equals(controlRecCO.getSuspendEvt()))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_SYSTEM_SUSPEND_EVENT_ID);
	    }
	}
	// Integer nb = 0;

	// ControlRecordSC sc = new ControlRecordSC();
	if(null != NumberUtil.emptyDecimalToNull(controlRecCO.getSuspendEvt()))
	{
	    sc.setEvtID(NumberUtil.emptyDecimalToNull(controlRecCO.getSuspendEvt()));
	    nb = alertControlRecordDAO.returnSystemEventCount(sc);

	    if(nb.compareTo(0) == 0)
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_SYSTEM_SUSPEND_EVENT_ID);
	    }

	}

	if(BigDecimal.ONE.equals(controlRecCO.getMobileFlag()))
	{
	    if(NumberUtil.emptyDecimalToNull(controlRecCO.getMobileEvt()) == null
		    || BigDecimal.ZERO.equals(controlRecCO.getMobileEvt()))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_SYSTEM_MOBILE_UPDATE_EVENT_ID);
	    }
	}
	// Integer nb = 0;
	if(null != NumberUtil.emptyDecimalToNull(controlRecCO.getMobileEvt()))
	{
	    // ControlRecordSC sc = new ControlRecordSC();
	    sc.setEvtID(NumberUtil.emptyDecimalToNull(controlRecCO.getMobileEvt()));
	    nb = alertControlRecordDAO.returnSystemEventCount(sc);

	    if(nb.compareTo(0) == 0)
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_SYSTEM_MOBILE_UPDATE_EVENT_ID);
	    }

	}

	if(BigDecimal.ONE.equals(controlRecCO.getPrintFlag()))
	{
	    if(NumberUtil.emptyDecimalToNull(controlRecCO.getAccRepID()) == null
		    || BigDecimal.ZERO.equals(controlRecCO.getAccRepID()))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_THE_ID_OF_THE_REPORT_U_WANT_TO_PRINT);
	    }
	}
	// Integer nb = 0;

	// ControlRecordSC sc = new ControlRecordSC();
	if(null != NumberUtil.emptyDecimalToNull(controlRecCO.getAccRepID()))
	{
	    sc.setRepID(NumberUtil.emptyDecimalToNull(controlRecCO.getAccRepID()));
	    nb = alertControlRecordDAO.returnRepInfoCount(sc);

	    if(nb.compareTo(0) == 0)
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_REPORT_ID);
	    }

	}
	if(AlertConstant.SMTP.equals(controlRecCO.getProtocolType()))
	{
	    if(controlRecCO.getIpAddress() == null || controlRecCO.getIpAddress().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_IP_ADDRESS);
	    }
	    if(controlRecCO.getPortNumber() == null || controlRecCO.getPortNumber().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_PORT_NUMBER);
	    }
	    if(controlRecCO.getSenderEmail() == null || controlRecCO.getSenderEmail().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_ENTER_SENDER_EMAIL);
	    }
	}

    }

    private void validateMandatoryFields(ControlRecordCO controlRecCO) throws BaseException
    {
	CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
	checkRequiredCO.setCompCode(controlRecCO.getCompCode());
	checkRequiredCO.setObj_value(controlRecCO);
	checkRequiredCO.setOpt(controlRecCO.getProgRef());
	checkRequiredCO.setLanguage(controlRecCO.getLang());
	checkRequiredCO.setApp(controlRecCO.getAppName());

	commonLibBO.checkRequired(checkRequiredCO);

    }

    public ControlRecordDAO getAlertControlRecordDAO()
    {
	return alertControlRecordDAO;
    }

    public void setAlertControlRecordDAO(ControlRecordDAO alertControlRecordDAO)
    {
	this.alertControlRecordDAO = alertControlRecordDAO;
    }

    @Override
    public ControlRecordCO dependencyByProtType(ControlRecordCO controlRecordCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(controlRecordCO.getCompCode());
	reqFieldSC
		.setProgRef(commonLibBO.returnOrginProgRef(controlRecordCO.getAppName(), controlRecordCO.getProgRef()));
	reqFieldSC.setAppName(controlRecordCO.getAppName());
	reqFieldSC.setBranchCode(controlRecordCO.getBranchCode());
	String[] listIdsToHide = new String[] {};
	String[] listNames = new String[] {};

	listIdsToHide = new String[] { "sle_sender_email", "sle_ip", "sle_port", "sle_user", "sle_pass" };
	listNames = new String[] { "controlRecordCO.senderEmail", "controlRecordCO.ipAddress",
		"controlRecordCO.portNumber", "controlRecordCO.userId", "controlRecordCO.password" };
	if(AlertConstant.SMTP.equals(controlRecordCO.getProtocolType()))
	{
	    commonLibBO.applyDynScreenDisplay(listIdsToHide, listNames, ConstantsCommon.ACTION_TYPE_VISIBLE,
		    BigDecimal.ONE.toString(), controlRecordCO.getRequiredHm(), reqFieldSC, Boolean.TRUE);
	}
	else if(AlertConstant.OUTLOOK_CLIENT.equals(controlRecordCO.getProtocolType()))
	{
	    commonLibBO.applyDynScreenDisplay(listIdsToHide, listNames, ConstantsCommon.ACTION_TYPE_VISIBLE,
		    BigDecimal.ZERO.toString(), controlRecordCO.getRequiredHm(), reqFieldSC, Boolean.TRUE);
	}
	return controlRecordCO;
    }
    
    @Override
	public ControlRecordCO dependencyByEmailConfigType(ControlRecordCO controlRecordCO) throws BaseException {
    	
    	BigDecimal visibility = BigDecimal.ZERO;
    	BigDecimal customVisibility = BigDecimal.ONE;
    	if(BigDecimal.ZERO.equals(controlRecordCO.getEmailConfigType()))
    	{
    		visibility = BigDecimal.ONE;
    		customVisibility = BigDecimal.ZERO;
    		
    	}
    	
    	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    	
    	// custom Config elements
    	SYS_PARAM_SCREEN_DISPLAYVO customEmailBtn = new SYS_PARAM_SCREEN_DISPLAYVO();
    	customEmailBtn.setIS_VISIBLE(customVisibility);
		hm.put("custom_email_btn", customEmailBtn);
		
    	// default input elements
		SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo.setIS_VISIBLE(visibility);
		hm.put("sle_sender_email", vo);
		
		SYS_PARAM_SCREEN_DISPLAYVO vo2 = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo2.setIS_VISIBLE(visibility);
		hm.put("sle_ip", vo2);
		
		SYS_PARAM_SCREEN_DISPLAYVO vo3 = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo3.setIS_VISIBLE(visibility);
		hm.put("sle_port", vo3);
		
		SYS_PARAM_SCREEN_DISPLAYVO vo4 = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo4.setIS_VISIBLE(visibility);
		hm.put("sle_user", vo4);
		
		SYS_PARAM_SCREEN_DISPLAYVO vo5 = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo5.setIS_VISIBLE(visibility);
		hm.put("sle_pass", vo5);
		
		controlRecordCO.setRequiredHm(hm);
    	
		return controlRecordCO;
	}
    
    @Override
	public ControlRecordCO dependencySmsConfigType(ControlRecordCO controlRecordCO) throws BaseException {
    	
    	BigDecimal visibility = BigDecimal.ZERO;
//    	BigDecimal customVisibility = BigDecimal.ONE;
    	if(BigDecimal.ONE.equals(controlRecordCO.getSmsConfigType()))
    	{
    		visibility = BigDecimal.ONE;
//    		customVisibility = BigDecimal.ZERO;
    	}
    	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = null;
    	if(null == controlRecordCO.getRequiredHm())
    	{
    		hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();	
    	}
    	else{
    		hm = controlRecordCO.getRequiredHm();
    	}
    	SYS_PARAM_SCREEN_DISPLAYVO vo6 = new SYS_PARAM_SCREEN_DISPLAYVO();
		vo6.setIS_VISIBLE(visibility);
		hm.put("custom_sms_btn", vo6);
		controlRecordCO.setRequiredHm(hm);
		return controlRecordCO;
	}

    @Override
    public Integer systemEvtLookupQueryCount(ControlRecordSC criteria) throws BaseException
    {
	return alertControlRecordDAO.systemEvtLookupQueryCount(criteria);
    }

    @Override
    public List systemEvtLookupQueryList(ControlRecordSC criteria) throws BaseException
    {
	return alertControlRecordDAO.systemEvtLookupQueryList(criteria);
    }
    
    
    public List<ExpressionParamCO> fillSmsExpressionVariables(ControlRecordSC controlRecordSC) throws BaseException
    {
    	List<ExpressionParamCO> lst = new ArrayList<ExpressionParamCO>();
    	ExpressionParamCO mobiles = new ExpressionParamCO();
    	mobiles.setParameterName("mobile Number");
    	mobiles.setParameterValue("as_mobile_phone");
    	lst.add(mobiles);
    	
    	ExpressionParamCO smsBody = new ExpressionParamCO();
    	smsBody.setParameterName("SMS Body");
    	smsBody.setParameterValue("as_message_body");
    	lst.add(smsBody);
    	fillExpressionVariables(lst, controlRecordSC);
    	return lst;

    }
    public List<ExpressionParamCO> fillEmailExpressionVariables(ControlRecordSC controlRecordSC) throws BaseException
    {
    	List<ExpressionParamCO> lst = new ArrayList<ExpressionParamCO>();
    	ExpressionParamCO emails = new ExpressionParamCO();
    	emails.setParameterName("Email");
    	emails.setParameterValue("emails");
    	lst.add(emails);
    	
    	ExpressionParamCO emailSubj = new ExpressionParamCO();
    	emailSubj.setParameterName("Email Subject");
    	emailSubj.setParameterValue("messageSubject");
    	lst.add(emailSubj);
    	
    	ExpressionParamCO emailBody = new ExpressionParamCO();
    	emailBody.setParameterName("Email Body");
    	emailBody.setParameterValue("messageBody");
    	lst.add(emailBody);
    	
    	fillExpressionVariables(lst, controlRecordSC);
    	return lst;
    }
    private List<ExpressionParamCO> fillExpressionVariables(List<ExpressionParamCO> lst , ControlRecordSC controlRecordSC) throws BaseException
    {
    	ExpressionParamCO subId = new ExpressionParamCO();
    	subId.setParameterName("Subscriber ID");
    	subId.setParameterValue("subId");
    	lst.add(subId);
    	
    	ExpressionParamCO evtId = new ExpressionParamCO();
    	evtId.setParameterName("Event ID");
    	evtId.setParameterValue("eventId");
    	lst.add(evtId);
    	
    	ExpressionParamCO subscId = new ExpressionParamCO();
    	subscId.setParameterName("Subscription ID");
    	subscId.setParameterValue("subscriptionId");
    	lst.add(subscId);
    	
    	ExpressionParamCO msgId = new ExpressionParamCO();
    	msgId.setParameterName("Message ID");
    	msgId.setParameterValue("msgId");
    	lst.add(msgId);
    	return lst;
    }

}
