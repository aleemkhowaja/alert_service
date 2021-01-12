package com.path.alert.bo.common.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.dao.common.AlertCommonLibDAO;
import com.path.alert.dao.subscriber.individual.IndividualSubscriberDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;

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
public class AlertCommonLibBOImpl extends BaseBO implements AlertCommonLibBO
{
    // private SmartBO smartBO;

	private AlertCommonLibDAO alertCommonLibDAO;
    private IndividualSubscriberDAO alertIndividualSubscriberDAO;

    public IndividualSubscriberDAO getAlertIndividualSubscriberDAO()
    {
	return alertIndividualSubscriberDAO;
    }

    public void setAlertIndividualSubscriberDAO(IndividualSubscriberDAO alertIndividualSubscriberDAO)
    {
	this.alertIndividualSubscriberDAO = alertIndividualSubscriberDAO;
    }

    public AlertCommonLibDAO getAlertCommonLibDAO()
    {
	return alertCommonLibDAO;
    }

    public void setAlertCommonLibDAO(AlertCommonLibDAO alertCommonLibDAO)
    {
	this.alertCommonLibDAO = alertCommonLibDAO;
    }

    public AlertCommonLibSC returnAlertSequence(AlertCommonLibSC sc) throws BaseException
    {
	try
	{
	    sc.setIsSybase(commonLibBO.returnIsSybase());
	    if(AlertConstant.ALRT_QUEUE.equals(sc.getTrxType().toLowerCase()))
	    {
		sc = alertCommonLibDAO.returnALertCounter(sc);
		if(sc.getErrCode() != null && (BigDecimal.ZERO.compareTo(sc.getErrCode()) > 0))
		{
		    throw new BOException(MessageCodes.CANNOT_PROCEED,
			    new String[] { replaceProcedureMessage(sc.getErrText()) });
		}

	    }
	    else
	    {

		int count = alertCommonLibDAO.alrtCounterCount(sc);
		if(count <= 0)
		{
		    sc.setArCode(BigDecimal.ONE);
		    alertCommonLibDAO.insertAlrtCounter(sc);
		}
		else
		{

		    alertCommonLibDAO.updateAlrtCounter(sc);

		    sc.setArCode(alertCommonLibDAO.selectLastNo(sc));

		}
		if(NumberUtil.isEmptyDecimal(sc.getArCode()) || null == sc.getArCode())
		{
		    sc.setArCode(BigDecimal.ZERO);
		}
		alertCommonLibDAO.updateLastAlrtCntr(sc);

	    }
	}
	catch(Exception e)
	{
	    sc.setArCode(AlertConstant.MINUS_ONE);
	    e.printStackTrace();
	}

	return sc;
    }

    public String replaceProcedureMessage(String errText)
    {

	if(errText == null)
	{
	    return null;
	}
	// replace <#anyThing#> by Empty
	return errText.replaceAll("<#.*#>", "");
    }

    @Override
    public AlertCommonLibSC parseAlertMessage(AlertCommonLibSC alertCommonLibSC) throws BaseException
    {
	IndividualSubscriberSC sc = new IndividualSubscriberSC();
	ALRT_CONTROLVO ctrl2VO = new ALRT_CONTROLVO();
	ctrl2VO.setCOMP_CODE(alertCommonLibSC.getCompCode());
	//ctrl2VO.setCTRL_REFERENCE(AlertConstant.CENTRALIZE_CORE);
	ctrl2VO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrl2VO);
	ALRT_SUBVO subVo = new ALRT_SUBVO();
	sc.setSubID(alertCommonLibSC.getSubID());
	if(BigDecimal.ONE.equals(ctrl2VO.getCTRL_VALUE()))
	{

	    subVo = alertIndividualSubscriberDAO.selectCentralizedDetails(sc);

	}
	else
	{

	    subVo = new ALRT_SUBVO();
	    subVo.setCOMP_CODE(alertCommonLibSC.getCompCode());
	    subVo.setID(sc.getSubID());
	    subVo = (ALRT_SUBVO) genericDAO.selectByPK(subVo);

	}
	AMFVO amfVo = new AMFVO();
	if(AlertConstant.TYPE_A.equals(subVo.getSUB_TYPE()))
	{

	    alertCommonLibSC.setCompCode(subVo.getCOMP_CODE());
	    alertCommonLibSC.setBranchCode(subVo.getBRANCH_CODE());
	    alertCommonLibSC.setAccCif(subVo.getCIF_SUB_NO());
	    alertCommonLibSC.setAccCy(subVo.getCURRENCY_CODE());
	    alertCommonLibSC.setAccGl(subVo.getGL_CODE());
	    alertCommonLibSC.setAccSl(subVo.getSL_NO());
	    amfVo = alertCommonLibDAO.returnAmfDetails(alertCommonLibSC);
	}

	ALRT_EVTVO alrtEvtVo = new ALRT_EVTVO();
	// alrtEvtVo.setCOMP_CODE(alertCommonLibSC.getCompCode());
	alrtEvtVo.setEVT_ID(alertCommonLibSC.getEvt());
	alrtEvtVo = (ALRT_EVTVO) genericDAO.selectByPK(alrtEvtVo);

	Date systemDate = commonLibBO.returnSystemDateNoTime();
	if(null != amfVo)
	{
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<ADD_REF>",
		    StringUtil.nullToEmpty(amfVo.getADDITIONAL_REFERENCE())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg())
		    .replace("<ACC_BRIEF_NAME_AR>", StringUtil.nullToEmpty(amfVo.getBRIEF_NAME_ARAB())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg())
		    .replace("<ACC_BRIEF_NAME_EN>", StringUtil.nullToEmpty(amfVo.getBRIEF_NAME_ENG())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg())
		    .replace("<ACC_LONG_NAME_AR>", StringUtil.nullToEmpty(amfVo.getLONG_NAME_ARAB())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg())
		    .replace("<ACC_LONG_NAME_EN>", StringUtil.nullToEmpty(amfVo.getLONG_NAME_ENG())));
	}
	if(null != subVo)
	{
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<OLD_MOBILE_NUM>",
		    StringUtil.nullToEmpty(subVo.getOLD_MOBILE_PHONE())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<MOBILE_NUM>",
		    StringUtil.nullToEmpty(subVo.getMOBILE_PHONE())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<SERVER_DATE>",
		    StringUtil.nullToEmpty(systemDate.toString())));
	}
	if(null != alrtEvtVo)
	{
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<EVT_SUBJECT_EN>",
		    StringUtil.nullToEmpty(alrtEvtVo.getMESSAGE_SUBJECT_ENG())));
	    alertCommonLibSC.setEngMsg(StringUtil.nullToEmpty(alertCommonLibSC.getEngMsg()).replace("<EVT_SUBJECT_AR>",
		    StringUtil.nullToEmpty(alrtEvtVo.getMESSAGE_SUBJECT_ARAB())));
	}
	return alertCommonLibSC;
    }

    public ALRT_CONTROLVO returnAlrtCtrl(String reference) throws BaseException
    {

	ALRT_CONTROLVO ctrlVO = new ALRT_CONTROLVO();
	// ctrlVO.setCOMP_CODE(individualSubscriberCO.getCompCode());
	ctrlVO.setCTRL_REFERENCE(reference);
	ctrlVO = (ALRT_CONTROLVO) genericDAO.selectByPK(ctrlVO);
	return ctrlVO;
    }
}
