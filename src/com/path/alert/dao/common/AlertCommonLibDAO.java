package com.path.alert.dao.common;

import java.math.BigDecimal;

import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.exception.DAOException;

public interface AlertCommonLibDAO {

	AlertCommonLibSC returnALertCounter(AlertCommonLibSC sc) throws DAOException;

	int alrtCounterCount(AlertCommonLibSC sc) throws DAOException;

	void insertAlrtCounter(AlertCommonLibSC sc) throws DAOException;

	void updateAlrtCounter(AlertCommonLibSC sc) throws DAOException;

	BigDecimal selectLastNo(AlertCommonLibSC sc) throws DAOException;

	void updateLastAlrtCntr(AlertCommonLibSC sc) throws DAOException;

	AMFVO returnAmfDetails(AlertCommonLibSC alertCommonLibSC) throws DAOException;

}
