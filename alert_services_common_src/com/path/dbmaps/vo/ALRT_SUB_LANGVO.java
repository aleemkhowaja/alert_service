package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class ALRT_SUB_LANGVO extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_SUB_LANG.ALRT_SUB_ID
     */
    private BigDecimal ALRT_SUB_ID;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.LANG_CODE
     */
    private String LANG_CODE;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.BRIEF_NAME
     */
    private String BRIEF_NAME;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.MIDDLE_NAME
     */
    private String MIDDLE_NAME;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.LONG_NAME
     */
    private String LONG_NAME;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.ADDRESS
     */
    private String ADDRESS;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column ALRT_SUB_LANG.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.ALRT_SUB_ID
     *
     * @return the value of ALRT_SUB_LANG.ALRT_SUB_ID
     */
    public BigDecimal getALRT_SUB_ID() {
        return ALRT_SUB_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.ALRT_SUB_ID
     *
     * @param ALRT_SUB_ID the value for ALRT_SUB_LANG.ALRT_SUB_ID
     */
    public void setALRT_SUB_ID(BigDecimal ALRT_SUB_ID) {
        this.ALRT_SUB_ID = ALRT_SUB_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.LANG_CODE
     *
     * @return the value of ALRT_SUB_LANG.LANG_CODE
     */
    public String getLANG_CODE() {
        return LANG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.LANG_CODE
     *
     * @param LANG_CODE the value for ALRT_SUB_LANG.LANG_CODE
     */
    public void setLANG_CODE(String LANG_CODE) {
        this.LANG_CODE = LANG_CODE == null ? null : LANG_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.BRIEF_NAME
     *
     * @return the value of ALRT_SUB_LANG.BRIEF_NAME
     */
    public String getBRIEF_NAME() {
        return BRIEF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.BRIEF_NAME
     *
     * @param BRIEF_NAME the value for ALRT_SUB_LANG.BRIEF_NAME
     */
    public void setBRIEF_NAME(String BRIEF_NAME) {
        this.BRIEF_NAME = BRIEF_NAME == null ? null : BRIEF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.MIDDLE_NAME
     *
     * @return the value of ALRT_SUB_LANG.MIDDLE_NAME
     */
    public String getMIDDLE_NAME() {
        return MIDDLE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.MIDDLE_NAME
     *
     * @param MIDDLE_NAME the value for ALRT_SUB_LANG.MIDDLE_NAME
     */
    public void setMIDDLE_NAME(String MIDDLE_NAME) {
        this.MIDDLE_NAME = MIDDLE_NAME == null ? null : MIDDLE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.LONG_NAME
     *
     * @return the value of ALRT_SUB_LANG.LONG_NAME
     */
    public String getLONG_NAME() {
        return LONG_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.LONG_NAME
     *
     * @param LONG_NAME the value for ALRT_SUB_LANG.LONG_NAME
     */
    public void setLONG_NAME(String LONG_NAME) {
        this.LONG_NAME = LONG_NAME == null ? null : LONG_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.ADDRESS
     *
     * @return the value of ALRT_SUB_LANG.ADDRESS
     */
    public String getADDRESS() {
        return ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.ADDRESS
     *
     * @param ADDRESS the value for ALRT_SUB_LANG.ADDRESS
     */
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.CREATED_BY
     *
     * @return the value of ALRT_SUB_LANG.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.CREATED_BY
     *
     * @param CREATED_BY the value for ALRT_SUB_LANG.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.CREATED_DATE
     *
     * @return the value of ALRT_SUB_LANG.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.CREATED_DATE
     *
     * @param CREATED_DATE the value for ALRT_SUB_LANG.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.MODIFIED_BY
     *
     * @return the value of ALRT_SUB_LANG.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for ALRT_SUB_LANG.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_SUB_LANG.MODIFIED_DATE
     *
     * @return the value of ALRT_SUB_LANG.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_SUB_LANG.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for ALRT_SUB_LANG.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}