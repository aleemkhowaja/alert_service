package com.path.alert.bo.progref;

import java.util.List;

import com.path.alert.vo.common.ProgRefSC;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2020, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ProgRefBO.java used to
 */
public interface ProgRefBO {

    /**
     * return progref list by application
     * @param ProgRefSC
     * @return
     * @throws BaseException
     */
    public List<OPTVO> returnProgRefList(ProgRefSC criteria) throws BaseException;

    /**
     * return progRef count  by application
     * @param ProgRefSC
     * @return
     * @throws BaseException
     */
    public Integer returnProgRefCount(ProgRefSC criteria) throws BaseException;
    
    /**
     * return progRm ef details by progRef
     * @param companiesSC
     * @return
     * @throws BaseException
     */
    public OPTVO returnProgRefDetailsByProgRef(ProgRefSC criteria) throws BaseException;
	
}
