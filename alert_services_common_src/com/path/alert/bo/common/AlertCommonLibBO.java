package com.path.alert.bo.common;

import com.path.alert.vo.common.AlertCommonLibSC;
import com.path.dbmaps.vo.ALRT_CONTROLVO;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface AlertCommonLibBO
{

    AlertCommonLibSC returnAlertSequence(AlertCommonLibSC alertCommonLibSC) throws BaseException;

    AlertCommonLibSC parseAlertMessage(AlertCommonLibSC alertCommonLibSC) throws BaseException;

    ALRT_CONTROLVO returnAlrtCtrl(String reference) throws BaseException;
   
}
