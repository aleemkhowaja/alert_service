package com.path.alert.vo.webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: mariaChamieh
 * @category: AssetsAuxServiceConstant.java used to hold the constant variables
 *            to be used in the trade screen
 * 
 * 
 * 
 */
public class AlertServiceConstant
{

    /**
     * Author: Bilal Hayek
    */
	public static String convertDateTimeToString(Date date) throws BaseException{
		String pattern = "dd/MM/yyyy";
		if(date == null)
			return null;
		return new SimpleDateFormat(pattern).format(date);
	}
	
	/**
     * Author: Bilal Hayek
    */
	public static String convertFormatDateTime(String dateString) throws BaseException
	{
		String pattern = "";
		pattern = "yyyy-MM-dd";
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date date = (Date) sdf.parse(dateString);
			sdf.setLenient(false);
			date = (Date) sdf.parse(dateString);
			return DateUtil.format(date,"dd/MM/yyyy");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateString;
	}
	
}
