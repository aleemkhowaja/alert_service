package com.path.alert.bo.emailtemplate.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.emailtemplate.EmailTemplateBO;
import com.path.alert.dao.emailtemplate.EmailTemplateDAO;
import com.path.alert.vo.emailtemplate.EmailTemplateCO;
import com.path.alert.vo.emailtemplate.EmailTemplateSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.dbmaps.vo.ALRT_EMAIL_TEMPLATEVOWithBLOBs;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.common.audit.AuditRefCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateBOImpl.java used to
 */
public class EmailTemplateBOImpl extends BaseBO implements EmailTemplateBO
{
    EmailTemplateDAO emailTemplateDAO;

    public EmailTemplateDAO getEmailTemplateDAO()
    {
	return emailTemplateDAO;
    }

    public void setEmailTemplateDAO(EmailTemplateDAO emailTemplateDAO)
    {
	this.emailTemplateDAO = emailTemplateDAO;
    }

    @Override
    public int returnEmailTemplateListCount(EmailTemplateSC criteria) throws BaseException
    {
	return emailTemplateDAO.returnEmailTemplateListCount(criteria);
    }

    @Override
    public List<EmailTemplateCO> returnEmailTemplateList(EmailTemplateSC criteria) throws BaseException
    {
	return emailTemplateDAO.returnEmailTemplateList(criteria);
    }

    @Override
    public void save(EmailTemplateCO emailtemplateCO) throws BaseException
    {
	AuditRefCO refCO = emailtemplateCO.getAuditRefCO();
	emailtemplateCO.getEmailTemplateVO().setSTATUS(AlertConstant.STATUS_NEW);
	// add
	if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals(emailtemplateCO.getEmailTemplateVO().getTEMPLATE_ID()))
	{
	    emailtemplateCO.getEmailTemplateVO().setCREATED_BY(emailtemplateCO.getUserID());
	    emailtemplateCO.getEmailTemplateVO().setCREATED_DATE(emailtemplateCO.getRunningDate());
	    emailtemplateCO.getEmailTemplateVO().setSERVER_CREATED_DATE(commonLibBO.returnSystemDateWithTime());

	    // get the counter
	    emailtemplateCO.getEmailTemplateVO()
		    .setTEMPLATE_ID(new BigDecimal(emailTemplateDAO.returnEmailTemplateId()));

	    // insert into Email Template
	    genericDAO.insert(emailtemplateCO.getEmailTemplateVO());

	    // apply audit
	    refCO.setOperationType(AuditConstant.CREATED);
	    auditBO.callAudit(null, emailtemplateCO.getEmailTemplateVO(), refCO);
	}
	// update
	else
	{
	    emailtemplateCO.getEmailTemplateVO().setMODIFIED_BY(emailtemplateCO.getUserID());
	    emailtemplateCO.getEmailTemplateVO().setMODIFIED_DATE(emailtemplateCO.getRunningDate());
	    emailtemplateCO.getEmailTemplateVO().setSERVER_MODIFIED_DATE(commonLibBO.returnSystemDateWithTime());
	    Integer row = genericDAO.update(emailtemplateCO.getEmailTemplateVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }

	    // apply audit
	    refCO.setOperationType(AuditConstant.UPDATE);
	    EmailTemplateCO oldemailTemplateCO = (EmailTemplateCO) emailtemplateCO.getAuditObj();
	    auditBO.callAudit(oldemailTemplateCO.getEmailTemplateVO(), emailtemplateCO.getEmailTemplateVO(), refCO);
	    auditBO.insertAudit(refCO);
	}
    }

    @Override
    public void deleteEmailTemplateId(EmailTemplateCO emailtemplateCO) throws BaseException
    {
	emailtemplateCO.getEmailTemplateVO().setDELETED_BY(emailtemplateCO.getUserID());
	emailtemplateCO.getEmailTemplateVO().setDELETED_DATE(emailtemplateCO.getRunningDate());
	Date serverDate = commonLibBO.returnSystemDateWithTime();
	emailtemplateCO.getEmailTemplateVO().setSERVER_DELETED_DATE(serverDate);
	emailtemplateCO.getEmailTemplateVO().setSTATUS(AlertConstant.STATUS_DELETED);

	ALRT_EMAIL_TEMPLATEVOWithBLOBs oldAuditVO = (ALRT_EMAIL_TEMPLATEVOWithBLOBs) genericDAO
		.selectByPK(emailtemplateCO.getEmailTemplateVO());
	Integer update = genericDAO.update(emailtemplateCO.getEmailTemplateVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	ALRT_EMAIL_TEMPLATEVOWithBLOBs newAuditVO = new ALRT_EMAIL_TEMPLATEVOWithBLOBs();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setDELETED_BY(emailtemplateCO.getUserID());
	newAuditVO.setDELETED_DATE(emailtemplateCO.getRunningDate());
	newAuditVO.setSTATUS(AlertConstant.STATUS_DELETED);
	newAuditVO.setSERVER_DELETED_DATE(serverDate);

	auditBO.callAudit(oldAuditVO, newAuditVO, emailtemplateCO.getAuditRefCO());
	auditBO.insertAudit(emailtemplateCO.getAuditRefCO());

    }

    @Override
    public void approveEmailTemplateId(EmailTemplateCO emailtemplateCO) throws BaseException
    {
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	emailtemplateCO.getEmailTemplateVO().setAPPROVED_BY(emailtemplateCO.getUserID());
	emailtemplateCO.getEmailTemplateVO().setAPPROVED_DATE(emailtemplateCO.getRunningDate());
	emailtemplateCO.getEmailTemplateVO().setSTATUS(AlertConstant.STATUS_APPROVED);
	emailtemplateCO.getEmailTemplateVO().setSERVER_APPROVED_DATE(systemDate);

	ALRT_EMAIL_TEMPLATEVOWithBLOBs oldAuditVO = (ALRT_EMAIL_TEMPLATEVOWithBLOBs) genericDAO
		.selectByPK(emailtemplateCO.getEmailTemplateVO());
	Integer update = genericDAO.update(emailtemplateCO.getEmailTemplateVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	ALRT_EMAIL_TEMPLATEVOWithBLOBs newAuditVO = new ALRT_EMAIL_TEMPLATEVOWithBLOBs();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);

	newAuditVO.setAPPROVED_BY(emailtemplateCO.getUserID());
	newAuditVO.setAPPROVED_DATE(emailtemplateCO.getRunningDate());
	newAuditVO.setSERVER_APPROVED_DATE(systemDate);
	newAuditVO.setSTATUS(AlertConstant.STATUS_APPROVED);

	auditBO.callAudit(oldAuditVO, newAuditVO, emailtemplateCO.getAuditRefCO());
	auditBO.insertAudit(emailtemplateCO.getAuditRefCO());
    }

    @Override
    public EmailTemplateCO retrieveSelectedTemplateId(EmailTemplateSC sc) throws BaseException
    {
	return emailTemplateDAO.retrieveSelectedTemplateId(sc);
    }
}
