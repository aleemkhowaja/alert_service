package com.path.alert.bo.reportquery;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ReportQueryConstant.java used to define Constant variables 
 */
public class ReportQueryConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(871);
	public static BigDecimal LOV_TYPE_DESC = new BigDecimal(872);
	public static final String STATUS_NEW_CREADTED = "C";
	public static final String STATUS_MODIFIED = "M";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_APPROVED = "P";
	public static final String REP_MULTISEL="multiSel";

	public static final List<String> reportQueryStatusLst = new ArrayList<String>();
    	static{
    		reportQueryStatusLst.add("CREATED_BY,"+STATUS_NEW_CREADTED+",CREATED_DATE,SERVER_CREATED_DATE");
    		reportQueryStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE,SERVER_MODIFIED_DATE");
    		reportQueryStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE,SERVER_DELETED_DATE");
    		reportQueryStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE,SERVER_APPROVED_DATE");
		}
}
