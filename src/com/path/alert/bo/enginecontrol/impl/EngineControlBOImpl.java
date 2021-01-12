package com.path.alert.bo.enginecontrol.impl;

import java.util.List;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.engine.AlertEngineBO;
import com.path.alert.bo.enginecontrol.EngineControlBO;
import com.path.alert.dao.enginecontrol.EngineControlDAO;
import com.path.alert.vo.enginecontrol.EngineControlCO;
import com.path.alert.vo.enginecontrol.EngineControlSC;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.remote.RmiServiceCaller;

/**
 * 
 * @author Muneer Ahmed
 * 
 */

public class EngineControlBOImpl extends BaseBO implements EngineControlBO {
	private EngineControlDAO engineControlDAO;

	/*
	 * start alert engine node via call RMI of alert engine
	 */
	@Override
	public void start(EngineControlCO engineControlCO) throws BaseException {
		try {

			AlertEngineBO alertEngineBO = returnAlertEngineBO(engineControlCO);
			alertEngineBO.start();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(e);
		}
	}

	/*
	 * shutdown alert engine node via call RMI of alert engine
	 */
	@Override
	public void shutdown(EngineControlCO engineControlCO) throws BaseException {
		try {

			AlertEngineBO alertEngineBO = returnAlertEngineBO(engineControlCO);
			alertEngineBO.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(e);
		}

	}

	/*
	 * return alert engine node status via call RMI of alert engine
	 */
	@Override
	public String returnEngineStatus(EngineControlCO engineControlCO) throws BaseException {
		try {

			AlertEngineBO alertEngineBO = returnAlertEngineBO(engineControlCO);
			return alertEngineBO.returnEngineStatus();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(e);
		}
	}

	/*
	 * return RMI service proxy object
	 */
	public AlertEngineBO returnAlertEngineBO(EngineControlCO engineControlCO) throws BaseException {
		AlertEngineBO alertEngineBO;
		try {
			alertEngineBO = (AlertEngineBO) RmiServiceCaller.returnRmiInterface(engineControlCO.getIP(),
					AlertEngineBO.class, AlertConstant.ALERT_ENGINE_SERVICE_NAME);
		} catch (Exception e) {
			throw new BaseException(e);
		}
		return alertEngineBO;
	}

	/*
	 * return rows count of "ALRT_ENG_REQUEST" table on specified criteria
	 */
	@Override
	public Integer returnAlertEngineRequestCount(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.returnAlertEngineRequestCount(criteria);
	}

	/*
	 * return rows data of last updated "ALRT_ENG_REQUEST" table on specified
	 * criteria
	 */
	@Override
	public List<EngineControlCO> returnAlertEngineRequest(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.returnAlertEngineRequest(criteria);
	}

	/**
	 * return subscriber id rows count, it's use to build 'Subscriber Id' Lookup
	 */
	@Override
	public Integer subIdLookupQueryCount(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.subIdLookupQueryCount(criteria);
	}

	/**
	 * return subscriber lookup rows. this lookup show in Engine Control screen
	 */
	@Override
	public List<EngineControlCO> subIdLookupQueryList(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.subIdLookupQueryList(criteria);
	}

	/**
	 * return alert user id rows count, it's use to build 'User Id' Lookup
	 */
	@Override
	public Integer alertUserLookupQueryCount(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.alertUserLookupQueryCount(criteria);
	}

	/**
	 * return Alert user id lookup rows.this lookup show in Engine Control screen
	 */
	@Override
	public List<EngineControlCO> alertUserLookupQueryList(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.alertUserLookupQueryList(criteria);
	}

	/**
	 * return Channel id rows count, it's use to build 'Channel End User' Lookup
	 */
	@Override
	public Integer channelIdLookupQueryCount(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.channelIdLookupQueryCount(criteria);
	}

	/**
	 * returnChannel End User lookup rows.this lookup show in Engine Control screen
	 */
	@Override
	public List<EngineControlCO> channelIdLookupQueryList(EngineControlSC criteria) throws BaseException {
		return engineControlDAO.channelIdLookupQueryList(criteria);
	}

	public EngineControlDAO getEngineControlDAO() {
		return engineControlDAO;
	}

	public void setEngineControlDAO(EngineControlDAO engineControlDAO) {
		this.engineControlDAO = engineControlDAO;
	}
}
