package com.path.alert.bo.emailtemplate;

import java.util.List;

import com.path.alert.vo.emailtemplate.EmailTemplateCO;
import com.path.alert.vo.emailtemplate.EmailTemplateSC;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * EmailTemplateBO.java used to
 */
public interface EmailTemplateBO
{
    /**
     * return Email TemplateList Count
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnEmailTemplateListCount(EmailTemplateSC criteria) throws BaseException;

    /**
     * return Email TemplateList
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<EmailTemplateCO> returnEmailTemplateList(EmailTemplateSC criteria) throws BaseException;

    /**
     * save
     * 
     * @param emailtemplateCO
     * @throws BaseException
     */
    public void save(EmailTemplateCO emailtemplateCO) throws BaseException;

    /**
     * retrieve Selected Template Id
     * 
     * @param sc
     * @return
     * @throws BaseException
     */
    public EmailTemplateCO retrieveSelectedTemplateId(EmailTemplateSC sc) throws BaseException;

    /**
     * 
     * @param emailtemplateCO
     * @throws BaseException
     */
    public void deleteEmailTemplateId(EmailTemplateCO emailtemplateCO) throws BaseException;

    /**
     * approve Email TemplateId
     * 
     * @param emailtemplateCO
     * @throws BaseException
     */
    public void approveEmailTemplateId(EmailTemplateCO emailtemplateCO) throws BaseException;
}