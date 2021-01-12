package com.path.alert.bo.progref.impl;

import java.util.List;

import com.path.alert.bo.common.AlertUtils;
import com.path.alert.bo.progref.ProgRefBO;
import com.path.alert.dao.progref.ProgRefDAO;
import com.path.alert.vo.common.ProgRefSC;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * CompaniesBOImpl.java used to
 */
public class ProgRefBOImpl extends BaseBO implements ProgRefBO
{

    private ProgRefDAO progRefDAO;

    @Override
    public List returnProgRefList(ProgRefSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());
	
	return progRefDAO.returnProgRefList(criteria);
    }

    @Override
    public Integer returnProgRefCount(ProgRefSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	criteria.setConnCO(AlertUtils.returnConnectionCo());
	
	return progRefDAO.returnProgRefCount(criteria);
    }

    @Override
    public OPTVO returnProgRefDetailsByProgRef(ProgRefSC criteria) throws BaseException
    {
	/**
	 * set connection object for core db
	 */
	OPTVO optvo = new OPTVO();
	optvo.setConnCO(AlertUtils.returnConnectionCo());
	optvo.setAPP_NAME(criteria.getAppName());
	optvo.setPROG_REF(criteria.getProgRef());
	
	optvo = (OPTVO) genericDAO.selectByPK(optvo);
	
	return optvo;
    }

    /**
     * @param progRefDAO the progRefDAO to set
     */
    public void setProgRefDAO(ProgRefDAO progRefDAO)
    {
        this.progRefDAO = progRefDAO;
    }
    
}