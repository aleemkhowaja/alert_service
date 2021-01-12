package com.path.alert.bo.subscriber.multiple.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.common.AlertCommonLibBO;
import com.path.alert.bo.subscriber.individual.IndividualSubscriberBO;
import com.path.alert.bo.subscriber.multiple.MultipleSubscriberBO;
import com.path.alert.dao.subscriber.multiple.MultipleSubscriberDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberCO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberSC;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.audit.AuditRefCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * 
 */
@SuppressWarnings("serial")
public class MultipleSubscriberBOImpl extends BaseBO implements MultipleSubscriberBO
{
    // private SmartBO smartBO;
    // private AlertCommonLibBO alertCommonLibBO;

    private MultipleSubscriberDAO alertMultipleSubscriberDAO;
    private AlertCommonLibBO alertCommonLibBO;
    private IndividualSubscriberBO individualSubscriberBO;
    private CommonLibBO commonLibBO;

    public void setCommonLibBO(CommonLibBO commonLibBO)
    {
	this.commonLibBO = commonLibBO;
    }

    @Override
    public List<MultipleSubscriberCO> returnMultiSubscriberListForGrid(MultipleSubscriberSC multipleSubscriberSC)
	    throws BaseException
    {
	return alertMultipleSubscriberDAO.returnMultiSubscriberListForGrid(multipleSubscriberSC);
    }

    @Override
    public Integer returnMultiSubscriberCountForGrid(MultipleSubscriberSC multipleSubscriberSC) throws BaseException
    {
	return alertMultipleSubscriberDAO.returnMultiSubscriberCountForGrid(multipleSubscriberSC);
    }

    @Override
    public void save(MultipleSubscriberCO multipleSubscriberCO) throws BaseException
    {
	List<MultipleSubscriberCO> newMultipleSubscriberCOs = multipleSubscriberCO.getNewMultipleSubscriberCOs();
	List<MultipleSubscriberCO> updatedMultipleSubscriberCOs = multipleSubscriberCO
		.getUpdatedMultipleSubscriberCOs();
//		List<MultipleSubscriberCO> deletdMultipleSubscriberCOs = multipleSubscriberCO.getDeletedMultipleSubscriberCOs();
	if(newMultipleSubscriberCOs != null && newMultipleSubscriberCOs.size() > 0)
	{
	    MultipleSubscriberCO multipleSubscriberCO2 = new MultipleSubscriberCO();
//			AuditRefCO refCO = multipleSubscriberCO.getAuditRefCO();
	    AlertCommonLibSC alertCommonLibSC = new AlertCommonLibSC();

	    for(int i = 0; i < newMultipleSubscriberCOs.size(); i++)
	    {
		multipleSubscriberCO2 = newMultipleSubscriberCOs.get(i);
		ALRT_SUBVO newALRT_SUBVO = multipleSubscriberCO2.getAlrtSubVO();

		newALRT_SUBVO.setCOMP_CODE(multipleSubscriberCO.getCompCode());
		newALRT_SUBVO.setCREATED_BY(multipleSubscriberCO.getUserID());
		newALRT_SUBVO.setDATE_CREATED(multipleSubscriberCO.getRunningDate());
		alertCommonLibSC.setTrxType("ALRT_SUB");
		alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
		if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
		{
		    newALRT_SUBVO.setID(alertCommonLibSC.getArCode());
		    multipleSubscriberCO2.setSubscriberId(alertCommonLibSC.getArCode());
		}
		newALRT_SUBVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		// prevent duplication of cif no
//			    Integer mainRow = genericDAO.insert(newALRT_SUBVO);
		genericDAO.insert(newALRT_SUBVO);
		// save other language details
		multipleSubscriberCO2.setUserID(multipleSubscriberCO.getUserID());
		multipleSubscriberCO2.setRunningDate(multipleSubscriberCO.getRunningDate());
		saveOtherLanguageDetails(multipleSubscriberCO2);
	    }

	    for(int i = 0; i < updatedMultipleSubscriberCOs.size(); i++)
	    {
		multipleSubscriberCO2 = updatedMultipleSubscriberCOs.get(i);
		ALRT_SUBVO newALRT_SUBVO = multipleSubscriberCO2.getAlrtSubVO();

		newALRT_SUBVO.setCOMP_CODE(multipleSubscriberCO.getCompCode());
		newALRT_SUBVO.setMODIFIED_BY(multipleSubscriberCO.getUserID());
		newALRT_SUBVO.setDATE_MODIFIED(multipleSubscriberCO.getRunningDate());
		alertCommonLibSC.setTrxType("ALRT_SUB");
		alertCommonLibSC = alertCommonLibBO.returnAlertSequence(alertCommonLibSC);
		if(BigDecimal.ZERO.compareTo(alertCommonLibSC.getArCode()) <= 0)
		{
		    newALRT_SUBVO.setID(alertCommonLibSC.getArCode());
		    multipleSubscriberCO2.setSubscriberId(alertCommonLibSC.getArCode());
		}
		newALRT_SUBVO.setSTATUS(AlertConstant.STATUS_ACTIVE);
		// prevent duplication of cif no
//			    Integer mainRow = genericDAO.update(newALRT_SUBVO);
		genericDAO.update(newALRT_SUBVO);
		// save other language details
		multipleSubscriberCO2.setUserID(multipleSubscriberCO.getUserID());
		multipleSubscriberCO2.setRunningDate(multipleSubscriberCO.getRunningDate());
		saveOtherLanguageDetails(multipleSubscriberCO2);
	    }

	}
    }

    private void saveOtherLanguageDetails(MultipleSubscriberCO multipleSubscriberCO) throws BaseException
    {
	List allOtherLanguages = multipleSubscriberCO.getAlrt_SUB_LANGVOs();

	if(allOtherLanguages != null && allOtherLanguages.size() > 0)
	{
	    Iterator<MultipleSubscriberCO> otherLanguages = allOtherLanguages.iterator();
	    MultipleSubscriberCO multipleSubscriberCO2 = null;
	    ALRT_SUB_LANGVO alrt_SUB_LANGVO = new ALRT_SUB_LANGVO();
	    while(otherLanguages.hasNext())
	    {
		multipleSubscriberCO2 = otherLanguages.next();
		alrt_SUB_LANGVO = multipleSubscriberCO2.getAlrt_SUB_LANGVO();
		if(StringUtil.isNotEmpty(alrt_SUB_LANGVO.getLANG_CODE())
			&& StringUtil.isNotEmpty(alrt_SUB_LANGVO.getBRIEF_NAME()))
		{
		    alrt_SUB_LANGVO.setALRT_SUB_ID(multipleSubscriberCO.getSubscriberId());
		    alrt_SUB_LANGVO.setCREATED_BY(multipleSubscriberCO.getUserID());
		    alrt_SUB_LANGVO.setCREATED_DATE(multipleSubscriberCO.getRunningDate());
		    genericDAO.insert(alrt_SUB_LANGVO);
		}
	    }
	}
    }

    @Override
    public MultipleSubscriberCO approve(MultipleSubscriberCO multipleSubscriberCO) throws BaseException
    {
	BigDecimal[] subscriberIds = multipleSubscriberCO.getSubscriberIds();
	IndividualSubscriberCO individualSubscriberCO = new IndividualSubscriberCO();
	ALRT_SUBVO alrt_SUBVO = null;
	ALRT_SUBVO oldAlrt_SUBVO = null;

	if(multipleSubscriberCO.getAllrows() != null && multipleSubscriberCO.getAllrows().equals(BigDecimal.ONE))
	{
	    multipleSubscriberCO.setRunningDate(commonLibBO.addSystemTimeToDate(multipleSubscriberCO.getRunningDate()));
	    this.alertMultipleSubscriberDAO.updateMultipleSubscriber(multipleSubscriberCO);
	}
	else
	{
	    if(subscriberIds != null && subscriberIds.length > 0)
	    {
		for(int i = 0; i < subscriberIds.length; i++)
		{
		    alrt_SUBVO = new ALRT_SUBVO();
		    alrt_SUBVO.setID(subscriberIds[i]);

		    oldAlrt_SUBVO = (ALRT_SUBVO) genericDAO.selectByPK(alrt_SUBVO);
		    int result = commonLibBO.validateMakerChecker(oldAlrt_SUBVO.getCREATED_BY(),
			    oldAlrt_SUBVO.getMODIFIED_BY(), multipleSubscriberCO.getUserID());
		    if(result <= 0)
		    {
			alrt_SUBVO.setSTATUS(ConstantsCommon.APPROVED_RECORD);
			alrt_SUBVO.setDATE_MODIFIED(
				commonLibBO.addSystemTimeToDate(multipleSubscriberCO.getRunningDate()));
			alrt_SUBVO.setMODIFIED_BY(multipleSubscriberCO.getUserID());

			// Audit Setting
			IndividualSubscriberCO oldIndividualSubscriberCO = new IndividualSubscriberCO();
			AuditRefCO refCO = multipleSubscriberCO.getAuditRefCO();
			oldIndividualSubscriberCO.setAlrtSubVO(oldAlrt_SUBVO);
			individualSubscriberCO.setAuditObj(oldIndividualSubscriberCO);
			individualSubscriberCO.setAuditRefCO(refCO);

			individualSubscriberCO.setAlrtSubVO(alrt_SUBVO);
			// approve individual Subscriber
			individualSubscriberBO.approveIndSubscriber(individualSubscriberCO);
		    }
		    else
		    {
			multipleSubscriberCO.setAllApproved(result);
		    }
		}
	    }
	}
	return multipleSubscriberCO;
    }

    public void setAlertCommonLibBO(AlertCommonLibBO alertCommonLibBO)
    {
	this.alertCommonLibBO = alertCommonLibBO;
    }

    public MultipleSubscriberDAO getAlertMultipleSubscriberDAO()
    {
	return alertMultipleSubscriberDAO;
    }

    public void setAlertMultipleSubscriberDAO(MultipleSubscriberDAO alertMultipleSubscriberDAO)
    {
	this.alertMultipleSubscriberDAO = alertMultipleSubscriberDAO;
    }

    public IndividualSubscriberBO getIndividualSubscriberBO()
    {
	return individualSubscriberBO;
    }

    public void setIndividualSubscriberBO(IndividualSubscriberBO individualSubscriberBO)
    {
	this.individualSubscriberBO = individualSubscriberBO;
    }

}
