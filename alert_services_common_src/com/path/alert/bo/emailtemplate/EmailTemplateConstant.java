package com.path.alert.bo.emailtemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryConstant.java used to define Constant variables
 */
public class EmailTemplateConstant
{
    public static BigDecimal LOV_TYPE = new BigDecimal(871);
    public static BigDecimal LOV_LK_OPT = new BigDecimal(1392);
    public static final String STATUS_NEW_CREADTED = "C";
    public static final String STATUS_MODIFIED = "M";
    public static final String STATUS_DELETED = "D";
    public static final String STATUS_APPROVED = "P";

    public static final List<String> emailTemplateStatusLst = new ArrayList<String>();
    static
    {
	emailTemplateStatusLst.add("CREATED_BY," + STATUS_NEW_CREADTED + ",CREATED_DATE,SERVER_CREATED_DATE");
	emailTemplateStatusLst.add("MODIFIED_BY," + STATUS_MODIFIED + ",MODIFIED_DATE,SERVER_MODIFIED_DATE");
	emailTemplateStatusLst.add("DELETED_BY," + STATUS_DELETED + ",DELETED_DATE,SERVER_DELETED_DATE");
	emailTemplateStatusLst.add("APPROVED_BY," + STATUS_APPROVED + ",APPROVED_DATE,SERVER_APPROVED_DATE");
    }
}
