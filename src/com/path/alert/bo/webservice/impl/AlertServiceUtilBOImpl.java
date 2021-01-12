package com.path.alert.bo.webservice.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.path.alert.bo.webservice.AlertServiceUtilBO;
import com.path.alert.vo.webservice.AlertCommonWSSC;
import com.path.alert.vo.webservice.AlertServiceConstant;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AlertServiceUtilBOImpl extends BaseBO implements AlertServiceUtilBO
{

    /**
     * Author: Alim Khowaja
     */
    @Override
    public AlertCommonWSSC FilterAndValidateList(AlertCommonWSSC alertCommonWSSC) throws BaseException
    {

	Object[][] array = new Object[alertCommonWSSC.getDynamicFilter().getFilters().size()][4];
	for(int i = 0; i < alertCommonWSSC.getDynamicFilter().getFilters().size(); i++)
	{
	    // added if condition by bahaa
	    if(!(alertCommonWSSC.getDynamicFilter().getFilters().get(i).getKey() == null
		    && alertCommonWSSC.getDynamicFilter().getFilters().get(i).getOperator() == null
		    && alertCommonWSSC.getDynamicFilter().getFilters().get(i).getValue() == null))
	    {
		String type = alertCommonWSSC.getColTypeMap().get(
			StringUtil.nullToEmpty(alertCommonWSSC.getDynamicFilter().getFilters().get(i).getKey()));
		// added StringUtil.nullToEmpty by bahaa for #bug 726837
		String column = StringUtil
			.nullToEmpty(alertCommonWSSC.getDynamicFilter().getFilters().get(i).getKey());
		String operator = StringUtil
			.nullToEmpty(alertCommonWSSC.getDynamicFilter().getFilters().get(i).getOperator());
		String value = nullToEmpty(alertCommonWSSC.getDynamicFilter().getFilters().get(i).getValue());

		if("date".equals(type))
		{
		    value = AlertServiceConstant.convertFormatDateTime(value);
		}
		// commented if condition by bahaa for #BUG 726837
		// if(column != null && operator != null && value != null)
		// {
		// validate column name
		if(!"number".equals(type) && !"text".equals(type) && !"date".equals(type))
		{
		    // need to use ctsmessage instead this
		    throw new BOException("Invalid column Name " + column);
		}

		// validate on operator of every column type
		if((("number".equals(type) || "date".equals(type))
			&& (!"eq".equals(operator) && !"ne".equals(operator) && !"lt".equals(operator)
				&& !"le".equals(operator) && !"gt".equals(operator) && !"ge".equals(operator)))
			|| ("text".equals(type) && (!"eq".equals(operator) && !"ne".equals(operator)
				&& !"bw".equals(operator) && !"bn".equals(operator) && !"ew".equals(operator)
				&& !"en".equals(operator) && !"cn".equals(operator) && !"nc".equals(operator)
				&& !"nn".equals(operator) && !"nu".equals(operator))))
		{
		    // need to use ctsmessage instead this
		    throw new BOException("Invalid Operator " + operator + " For Type " + type);
		}

		// added by bahaa for #BUG 726982
		if("number".equals(type) && !NumberUtil.isNumber(value))
		{
		    // need to use ctsmessage instead this
		    throw new BOException("Invalid value for key with type Numeric");
		}
		
		if("number".equals(type) && NumberUtil.isNumber(value))
		{
		    value = removeLeadingZeros(value);
		}

		if("nu".equals(operator) || "nn".equals(operator))
		{
		    array[i][1] = "";
		}

		else
		{
		    array[i][1] = value;
		}

		array[i][0] = column;
		array[i][2] = operator;
		array[i][3] = type;
		// }
	    }
	}

	alertCommonWSSC.setFilters(fillAdvancedFilterMap(array, alertCommonWSSC.getDynamicFilter().getAllAny()));
	GridBaseAction baseAction = new GridBaseAction();
	HashMap<String, Integer> addionalParams = new HashMap<>();
	// we send the flag isSybase because in this case we do not have an
	// instance of baseServices
	addionalParams.put("isSybase", commonLibBO.returnIsSybase());

	// assets Search
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap = fillFilterMap(alertCommonWSSC.getSearchCols(), alertCommonWSSC.getColSearchMap());
	baseAction.copysearchgridproperties(alertCommonWSSC, paramMap, addionalParams);

	return alertCommonWSSC;
    }

    /**
     * Author: Alim Khowaja
     */
    public Map<String, Object> fillFilterMap(String[] searchCol, HashMap<String, Object> filtersMap)
    {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	for(int i = 0; i < searchCol.length; i++)
	{
	    String columnName = searchCol[i];
	    String[] value = new String[1];
	    if(filtersMap.get(columnName) != null)
	    {
		String[] value1 = new String[1];
		// in case of number
		if(filtersMap.get(columnName) instanceof BigDecimal || filtersMap.get(columnName) instanceof Integer
			|| filtersMap.get(columnName) instanceof Double || filtersMap.get(columnName) instanceof Float)
		{
		    value[0] = filtersMap.get(columnName).toString();
		    paramMap.put(columnName, value);
		    value1[0] = "1";
		    paramMap.put(columnName + "_isNbr", value1);

		}
		else
		{
		    // in case of text
		    if(filtersMap.get(columnName) instanceof String)
		    {
			if(filtersMap.get(columnName).toString().length() > 0)
			{
			    value[0] = filtersMap.get(columnName).toString();
			    paramMap.put(columnName, value);
			    value1[0] = "0";
			    paramMap.put(columnName + "_isNbr", value1);
			}
		    }
		    else
		    {
			value[0] = filtersMap.get(columnName).toString();
			paramMap.put(columnName, value);
			value1[0] = "0";
			paramMap.put(columnName + "_isNbr", value1);
		    }
		}
	    }
	}
	return paramMap;
    }

    /**
     * Author: Alim Khowaja
     */
    public String fillAdvancedFilterMap(Object[][] objArr, String anyAll)
    {
	JSONArray array = new JSONArray();
	JSONObject item;
	for(Object[] row : objArr)
	{
	    // in case the value is null, which mean it is not sent,
	    // then do not send it as filter parameter
	    // GridBaseAction.getRuleQuery()
	    if(row[1] == null || row[3] == null)
	    {
		continue;
	    }
	    item = new JSONObject();
	    item.put("field", row[0].toString());
	    item.put("data", row[1]);
	    item.put("op", row[2].toString());
	    item.put("colType", row[3].toString());

	    array.add(item);
	}
	if("Any".equals(anyAll))
	{
	    anyAll = "OR";
	}
	else
	{
	    anyAll = "AND";
	}
	JSONObject filters = new JSONObject();
	filters.put("groupOp", anyAll);
	filters.put("rules", array);
	return filters.toString();
    }

    /**
     * Author Alim Khowaja
     */
    public static String nullToEmpty(String nullString)
    {
		if(nullString == null || "null".equals(nullString))
		{
		    return "";
		}
		else
		{
		    return nullString;
		}
    }
    
    /**
     * Author Alim Khowaja
     */
    public String removeLeadingZeros(String str)
    {
		String strPattern = "^0+(?!$)"; 
		return str.replaceAll(strPattern, "");
    }

}
