package com.path.alert.vo.events.event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.ALRT_EVT_OL_DATA_TRANSVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: suhail.shoukathali
 *
 * OtherLanguagesCO.java used to
 */
public class OtherLanguagesCO extends BaseVO
{
    private String langDesc;
    private String fieldName;
    private BigDecimal tableCode;
    private String columnKey;
    private Boolean isDefaultField = false;
    private String defaultFieldDesc;
    private Integer isDeleted = new Integer(0);
    private ALRT_EVT_OL_DATA_TRANSVO otherLanguagesVO = new ALRT_EVT_OL_DATA_TRANSVO();
    private List<OtherLanguagesCO> otherLanguagesList = new ArrayList<OtherLanguagesCO>();

    public ALRT_EVT_OL_DATA_TRANSVO getOtherLanguagesVO()
    {
        return otherLanguagesVO;
    }

    public void setOtherLanguagesVO(ALRT_EVT_OL_DATA_TRANSVO otherLanguagesVO)
    {
        this.otherLanguagesVO = otherLanguagesVO;
    }

    public String getLangDesc()
    {
        return langDesc;
    }

    public void setLangDesc(String langDesc)
    {
        this.langDesc = langDesc;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getColumnKey()
    {
        return columnKey;
    }

    public void setColumnKey(String columnKey)
    {
        this.columnKey = columnKey;
    }

    public BigDecimal getTableCode()
    {
        return tableCode;
    }

    public void setTableCode(BigDecimal tableCode)
    {
        this.tableCode = tableCode;
    }

    public Integer getIsDeleted()
    {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public List<OtherLanguagesCO> getOtherLanguagesList()
    {
        return otherLanguagesList;
    }

    public void setOtherLanguagesList(List<OtherLanguagesCO> otherLanguagesList)
    {
        this.otherLanguagesList = otherLanguagesList;
    }

    public Boolean getIsDefaultField()
    {
        return isDefaultField;
    }

    public void setIsDefaultField(Boolean isDefaultField)
    {
        this.isDefaultField = isDefaultField;
    }

    public String getDefaultFieldDesc()
    {
        return defaultFieldDesc;
    }

    public void setDefaultFieldDesc(String defaultFieldDesc)
    {
        this.defaultFieldDesc = defaultFieldDesc;
    }
    
    public String getOtherLanguagesLangCode()
    {
	return this.getOtherLanguagesVO().getLANG_CODE();
    }
}
