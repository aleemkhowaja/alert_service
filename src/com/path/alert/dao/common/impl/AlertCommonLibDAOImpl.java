package com.path.alert.dao.common.impl;

import java.math.BigDecimal;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.dao.common.AlertCommonLibDAO;
import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: freddymbarak
 * 
 *          .java used to
 */
public class AlertCommonLibDAOImpl extends BaseDAO implements AlertCommonLibDAO {

	@Override
	public AlertCommonLibSC returnALertCounter(AlertCommonLibSC sc1) throws DAOException {
		AlertCommonLibSC sc = sc1;
		insertTempSessionDetails(sc1.getLanguage());
		try {
			getSqlMap().update("alertCommonLibMapper.returnALertCounter", sc);
		} catch (Exception e) {
			log.info(e.getMessage());
			sc = getProcedureErrorMsg(sc, e);
		}
		return sc;
	}

	private AlertCommonLibSC getProcedureErrorMsg(AlertCommonLibSC sc, Exception e) {
		String msg = e.getMessage();
		String prefix, suffix = "&"; // for sybase and oracle the character '&'
		// follows ther user error
		int fromIndex, endIndex;

		if (AlertConstant.INT_ONE.equals(sc.getIsOracle())) {
			// for oracle the part that precede the user error contains the
			// below string
			prefix = "ORA-20000: #";

		} else {
			// for sybase it contains the below string
			prefix = ": # ";

		}

		fromIndex = msg.indexOf(prefix);

		if (fromIndex >= 0) {
			endIndex = msg.indexOf(suffix, fromIndex);
			// extracting the user error with the prefix
			msg = msg.substring(fromIndex, endIndex);
			// replacing the prefix with empty string
			sc.setErrText(msg.replace(prefix, ""));
		} else {
			sc.setErrText(msg);
		}

		sc.setErrCode(AlertConstant.MINUS_ONE);

		return sc;
	}

	@Override
	public int alrtCounterCount(AlertCommonLibSC sc) throws DAOException {

		return ((Integer) getSqlMap().queryForObject("alertCommonLibMapper.alrtCounterCount", sc)).intValue();
	}

	@Override
	public void insertAlrtCounter(AlertCommonLibSC sc) throws DAOException {
		getSqlMap().queryForObject("alertCommonLibMapper.insertAlrtCounter", sc);
	}

	@Override
	public void updateAlrtCounter(AlertCommonLibSC sc) throws DAOException {
		getSqlMap().queryForObject("alertCommonLibMapper.updateAlrtCounter", sc);

	}

	@Override
	public BigDecimal selectLastNo(AlertCommonLibSC sc) throws DAOException {


		return ((BigDecimal) getSqlMap().queryForObject("alertCommonLibMapper.selectLastNo", sc));
	}

	@Override
	public void updateLastAlrtCntr(AlertCommonLibSC sc) throws DAOException {
		getSqlMap().queryForObject("alertCommonLibMapper.updateLastAlrtCntr", sc);

	}

	@Override
	public AMFVO returnAmfDetails(AlertCommonLibSC alertCommonLibSC) throws DAOException {
		return (AMFVO) getSqlMap().queryForObject("alertCommonLibMapper.returnAmfDetails", alertCommonLibSC);
	}

}
