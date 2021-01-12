package com.path.alert.dao.enginecontrol.impl;

import java.util.List;

import com.path.alert.dao.enginecontrol.EngineControlDAO;
import com.path.alert.vo.enginecontrol.EngineControlCO;
import com.path.alert.vo.enginecontrol.EngineControlSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class EngineControlDAOImpl extends BaseDAO implements EngineControlDAO {

	/**
	 * return rows count of "ALRT_ENG_REQUEST" table on specified criteria
	 */
	public Integer returnAlertEngineRequestCount(EngineControlSC criteria) throws DAOException {

		DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.alertEngineRequestResultMap");

		return ((Integer) getSqlMap().queryForObject("alertEngineRequest.returnAlertEngineRequestCount", criteria))
				.intValue();
	}

	/**
	 * return rows data of last updated "ALRT_ENG_REQUEST" table on specified
	 * criteria
	 */
	public List<EngineControlCO> returnAlertEngineRequest(EngineControlSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.alertEngineRequestResultMap");
		List<EngineControlCO> lst;

		if (criteria.getNbRec() == -1) {
			lst = getSqlMap().queryForList("alertEngineRequest.returnAlertEngineRequest", criteria);
		} else {
			lst = getSqlMap().queryForList("alertEngineRequest.returnAlertEngineRequest", criteria,
					criteria.getRecToskip(), criteria.getNbRec());
		}
		return lst;
	}

	/**
	 * return subscriber id rows count, it's get APPROVED records from ALRT_SUB
	 * table
	 */
	@Override
	public Integer subIdLookupQueryCount(EngineControlSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.subIdLookupResultMap");

		return ((Integer) getSqlMap().queryForObject("alertEngineRequest.subIdLookupCount", criteria)).intValue();
	}

	/**
	 * return subscriber lookup rows. this lookup show in Engine Control screen,
	 * it's get APPROVED records from ALRT_SUB table
	 */
	@Override
	public List<EngineControlCO> subIdLookupQueryList(EngineControlSC criteria) throws DAOException {
		if (criteria.getNbRec() == -1) {
			return getSqlMap().queryForList("alertEngineRequest.subIdLookupList", criteria);
		} else {
			DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.subIdLookupResultMap");
			return getSqlMap().queryForList("alertEngineRequest.subIdLookupList", criteria, criteria.getRecToskip(),
					criteria.getNbRec());
		}
	}

	/**
	 * return alert user id rows count, it's get APPROVED records from ALRT_SUB
	 * table which are not NULL
	 */
	@Override
	public Integer alertUserLookupQueryCount(EngineControlSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.userLookupResultMap");

		return ((Integer) getSqlMap().queryForObject("alertEngineRequest.userLookupCount", criteria)).intValue();
	}

	/**
	 * return Alert user id lookup rows.this lookup show in Engine Control screen,
	 * it's get APPROVED records from ALRT_SUB table which are not NULL
	 */
	@Override
	public List<EngineControlCO> alertUserLookupQueryList(EngineControlSC criteria) throws DAOException {
		if (criteria.getNbRec() == -1) {
			return getSqlMap().queryForList("alertEngineRequest.userLookupList", criteria);
		} else {
			DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.userLookupResultMap");
			return getSqlMap().queryForList("alertEngineRequest.userLookupList", criteria, criteria.getRecToskip(),
					criteria.getNbRec());
		}
	}

	/**
	 * return Channel id rows count, it's get DISTINCT channel end user from
	 * 'ALRT_SUB' table
	 */
	@Override
	public Integer channelIdLookupQueryCount(EngineControlSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.channelIdLookupResultMap");

		return ((Integer) getSqlMap().queryForObject("alertEngineRequest.channelIdLookupCount", criteria)).intValue();
	}

	/**
	 * returnChannel End User lookup rows.this lookup show in Engine Control screen,
	 * it's get DISTINCT channel end user from 'ALRT_SUB' table
	 */
	@Override
	public List<EngineControlCO> channelIdLookupQueryList(EngineControlSC criteria) throws DAOException {
		if (criteria.getNbRec() == -1) {
			return getSqlMap().queryForList("alertEngineRequest.channelIdLookupList", criteria);
		} else {
			DAOHelper.fixGridMaps(criteria, getSqlMap(), "alertEngineRequest.channelIdLookupResultMap");
			return getSqlMap().queryForList("alertEngineRequest.channelIdLookupList", criteria, criteria.getRecToskip(),
					criteria.getNbRec());
		}
	}

}
