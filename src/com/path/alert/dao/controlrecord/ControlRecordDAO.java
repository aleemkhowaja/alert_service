package com.path.alert.dao.controlrecord;

import java.util.List;

import com.path.alert.vo.controlrecord.ControlRecordCO;
import com.path.alert.vo.controlrecord.ControlRecordSC;
import com.path.lib.common.exception.DAOException;

public interface ControlRecordDAO {

	Integer returnSystemEventCount(ControlRecordSC sc) throws DAOException;

	Integer returnRepInfoCount(ControlRecordSC sc) throws DAOException;

	Integer returnAlrtCtrlCount(ControlRecordSC sc) throws DAOException;

	Integer systemEvtLookupQueryCount(ControlRecordSC criteria) throws DAOException;

	List systemEvtLookupQueryList(ControlRecordSC criteria) throws DAOException;
	
	List returnAlrtCtrl(ControlRecordSC criteria) throws DAOException;
	
	void updateAlrtCtrl(ControlRecordCO controlRecordCO) throws DAOException;

}
