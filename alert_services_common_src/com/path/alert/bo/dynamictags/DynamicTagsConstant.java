package com.path.alert.bo.dynamictags;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTagsConstant.java used to define Constant variables 
 */
public class DynamicTagsConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(871);
	public static final String STATUS_status_columns= "0_C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "0_M";
	public static final String STATUS_APPROVED = "P";

	public static final List<String> dynamicTagsStatusLst = new ArrayList<String>();
    	static{
    		dynamicTagsStatusLst.add("status_columns=CREATED_BY,"+STATUS_status_columns+",CREATED_DATE");
    		dynamicTagsStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED");
    		dynamicTagsStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		dynamicTagsStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
