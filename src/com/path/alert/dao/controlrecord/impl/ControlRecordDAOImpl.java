package com.path.alert.dao.controlrecord.impl;

import java.util.List;

import com.path.alert.dao.controlrecord.ControlRecordDAO;
import com.path.alert.vo.controlrecord.ControlRecordCO;
import com.path.alert.vo.controlrecord.ControlRecordSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: freddymbarak
 * 
 *          .java used to
 */
public class ControlRecordDAOImpl extends BaseDAO implements ControlRecordDAO {

	@Override
	public Integer returnSystemEventCount(ControlRecordSC sc) throws DAOException {
		// TODO Auto-generated method stub
		return ((Integer) getSqlMap().queryForObject("controlRecordMapper.returnSystemEventCount", sc)).intValue();
	}

	@Override
	public Integer returnRepInfoCount(ControlRecordSC sc) throws DAOException {
		// TODO Auto-generated method stub
		return ((Integer) getSqlMap().queryForObject("controlRecordMapper.returnRepInfoCount", sc)).intValue();
	}

	@Override
	public Integer returnAlrtCtrlCount(ControlRecordSC sc) throws DAOException {
		// TODO Auto-generated method stub
		return ((Integer) getSqlMap().queryForObject("controlRecordMapper.returnAlrtCtrlCount", sc)).intValue();
	}

	@Override
	public Integer systemEvtLookupQueryCount(ControlRecordSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "controlRecordMapper.systemEvtLookupQueryListMap");
		return ((Integer) getSqlMap().queryForObject("controlRecordMapper.systemEvtLookupQueryCount", criteria))
				.intValue();
	}

	@Override
	public List systemEvtLookupQueryList(ControlRecordSC criteria) throws DAOException {	    
		if (criteria.getNbRec() == -1) {
			return getSqlMap().queryForList("controlRecordMapper.systemEvtLookupQueryList", criteria);
		} else {
			DAOHelper.fixGridMaps(criteria, getSqlMap(), "controlRecordMapper.systemEvtLookupQueryListMap");
			return getSqlMap().queryForList("controlRecordMapper.systemEvtLookupQueryList", criteria,
					criteria.getRecToskip(), criteria.getNbRec());
		}
	}

	@Override
	public List returnAlrtCtrl(ControlRecordSC criteria) throws DAOException {
		return getSqlMap().queryForList("controlRecordMapper.returnAlrtCtrl", criteria);
	}

	@Override
	public void updateAlrtCtrl(ControlRecordCO controlRecordCO) throws DAOException {
		getSqlMap().update("controlRecordMapper.updateAlrtCtrl", controlRecordCO);
	}

}
