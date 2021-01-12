package com.path.alert.dao.emailtemplate;

import java.util.List;

import com.path.alert.vo.emailtemplate.EmailTemplateCO;
import com.path.alert.vo.emailtemplate.EmailTemplateSC;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateDAO.java used to
 */
public interface EmailTemplateDAO
{
    /**
     * return Email TemplateList Count
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int returnEmailTemplateListCount(EmailTemplateSC criteria) throws DAOException;

    /**
     * return Email Template List
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<EmailTemplateCO> returnEmailTemplateList(EmailTemplateSC criteria) throws DAOException;

    /**
     * return Email Template Id
     * 
     * @return
     * @throws DAOException
     */
    public int returnEmailTemplateId() throws DAOException;

    /**
     * retrieve Selected Template Id
     * 
     * @param sc
     * @return
     * @throws DAOException
     */
    public EmailTemplateCO retrieveSelectedTemplateId(EmailTemplateSC sc) throws DAOException;
}