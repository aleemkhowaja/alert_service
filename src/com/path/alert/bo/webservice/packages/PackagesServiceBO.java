package com.path.alert.bo.webservice.packages;

import java.util.Map;

import com.path.lib.common.exception.BaseException;
import com.path.vo.alert.packages.ReturnPackageListReq;
import com.path.vo.alert.packages.ReturnPackageListResp;

public interface PackagesServiceBO {
	/**
	 * 
	 * @param ReturnPackageListReq
	 * @return
	 * @throws Exception
	 */
	public ReturnPackageListResp returnPackageList(ReturnPackageListReq returnPackageListReq) throws Exception;

	/**
	 * Return list of all Package Count
	 * 
	 * @param criteria
	 * @return
	 * @throws BaseException By Muneer Ahmed
	 */
	public Map<String, Object> returnPackageListCount(Map<String, Object> criteria) throws Exception;

	/**
	 * Return list of all Package
	 * 
	 * @param criteria
	 * @return
	 * @throws BaseException By Muneer Ahmed
	 */
	public Map<String, Object> returnPackageList(Map<String, Object> criteria) throws Exception;
}
