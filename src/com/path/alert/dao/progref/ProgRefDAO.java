package com.path.alert.dao.progref;

import java.util.List;

import com.path.alert.vo.common.ProgRefSC;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ProgRefDAO.java used to return prog reference
 */
public interface ProgRefDAO {

    /**
     * return rows count of "ProgRef" from OPT table on specified criteria
     * @param criteria
     * @return
     * @throws DAOException
     */
    public Integer returnProgRefCount(ProgRefSC criteria) throws DAOException;

    /**
     *  return list of "ProgRef" from OPT table on specified criteria
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<OPTVO> returnProgRefList(ProgRefSC criteria) throws DAOException;

	
}
