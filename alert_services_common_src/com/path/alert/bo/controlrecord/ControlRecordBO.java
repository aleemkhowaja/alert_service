package com.path.alert.bo.controlrecord;

import java.util.List;

import com.path.alert.vo.controlrecord.ControlRecordCO;
import com.path.alert.vo.controlrecord.ControlRecordSC;
import com.path.lib.common.exception.BaseException;
import com.path.vo.customexpression.ExpressionParamCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface ControlRecordBO {

	ControlRecordCO initialize(ControlRecordCO controlRecordCO) throws BaseException;

	ControlRecordCO dependencyByBoxes(ControlRecordCO controlRecordCO) throws BaseException;

	ControlRecordCO updateControlRecord(ControlRecordCO controlRecordCO) throws BaseException;

	ControlRecordCO dependencyByProtType(ControlRecordCO controlRecordCO) throws BaseException;

	Integer systemEvtLookupQueryCount(ControlRecordSC criteria) throws BaseException;

	List systemEvtLookupQueryList(ControlRecordSC criteria) throws BaseException;
	
	ControlRecordCO dependencyByEmailConfigType(ControlRecordCO controlRecordCO) throws BaseException;
	
	ControlRecordCO dependencySmsConfigType(ControlRecordCO controlRecordCO) throws BaseException;

	List<ExpressionParamCO> fillSmsExpressionVariables(ControlRecordSC controlRecordSC) throws BaseException;
	
	List<ExpressionParamCO> fillEmailExpressionVariables(ControlRecordSC controlRecordSC) throws BaseException;
	
}
