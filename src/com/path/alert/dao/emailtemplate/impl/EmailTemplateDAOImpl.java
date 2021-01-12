package com.path.alert.dao.emailtemplate.impl;

import java.util.List;

import com.path.alert.dao.emailtemplate.EmailTemplateDAO;
import com.path.alert.vo.emailtemplate.EmailTemplateCO;
import com.path.alert.vo.emailtemplate.EmailTemplateSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateDAOImpl.java used to
 */
public class EmailTemplateDAOImpl extends BaseDAO implements EmailTemplateDAO
{
    @Override
    public int returnEmailTemplateListCount(EmailTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "emailTemplateMapper.resEmailTemplateListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("emailTemplateMapper.returnEmailTemplateListCount", criteria))
		.intValue();
	return nb;
    }

    @Override
    public List<EmailTemplateCO> returnEmailTemplateList(EmailTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "emailTemplateMapper.resEmailTemplateListMap");
	if(criteria.getSortOrder() == null)
	{
	    criteria.setSortOrder(" ORDER BY TEMPLATE_ID");
	}
	if(criteria.getNbRec() == -1)
	{
	    return (List<EmailTemplateCO>) getSqlMap().queryForList("emailTemplateMapper.returnEmailTemplateList",
		    criteria);
	}
	else
	{
	    return (List<EmailTemplateCO>) getSqlMap().queryForList("emailTemplateMapper.returnEmailTemplateList",
		    criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public int returnEmailTemplateId() throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("emailTemplateMapper.returnEmailTemplateId", null)).intValue();
	return nb;
    }

    @Override
    public EmailTemplateCO retrieveSelectedTemplateId(EmailTemplateSC sc) throws DAOException
    {
	return ((EmailTemplateCO) getSqlMap().queryForObject("emailTemplateMapper.retrieveSelectedTemplateId", sc));
    }
}
