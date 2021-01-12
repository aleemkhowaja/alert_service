package com.path.alert.bo.webservice;

import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.lib.common.exception.BaseException;

public interface AlertServiceUtilBO
{
	public AlertCommonWSSC FilterAndValidateList(AlertCommonWSSC alertCommonWSSC) throws BaseException;
}
