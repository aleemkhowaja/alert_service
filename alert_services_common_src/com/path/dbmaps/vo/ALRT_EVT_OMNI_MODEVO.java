package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class ALRT_EVT_OMNI_MODEVO extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.EVENT_ID
     */
    private BigDecimal EVENT_ID;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.EVENT_MODE
     */
    private String EVENT_MODE;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column ALRT_EVT_OMNI_MODE.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.COMP_CODE
     *
     * @return the value of ALRT_EVT_OMNI_MODE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.COMP_CODE
     *
     * @param COMP_CODE the value for ALRT_EVT_OMNI_MODE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.EVENT_ID
     *
     * @return the value of ALRT_EVT_OMNI_MODE.EVENT_ID
     */
    public BigDecimal getEVENT_ID() {
        return EVENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.EVENT_ID
     *
     * @param EVENT_ID the value for ALRT_EVT_OMNI_MODE.EVENT_ID
     */
    public void setEVENT_ID(BigDecimal EVENT_ID) {
        this.EVENT_ID = EVENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.EVENT_MODE
     *
     * @return the value of ALRT_EVT_OMNI_MODE.EVENT_MODE
     */
    public String getEVENT_MODE() {
        return EVENT_MODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.EVENT_MODE
     *
     * @param EVENT_MODE the value for ALRT_EVT_OMNI_MODE.EVENT_MODE
     */
    public void setEVENT_MODE(String EVENT_MODE) {
        this.EVENT_MODE = EVENT_MODE == null ? null : EVENT_MODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.CREATED_BY
     *
     * @return the value of ALRT_EVT_OMNI_MODE.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.CREATED_BY
     *
     * @param CREATED_BY the value for ALRT_EVT_OMNI_MODE.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.CREATED_DATE
     *
     * @return the value of ALRT_EVT_OMNI_MODE.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.CREATED_DATE
     *
     * @param CREATED_DATE the value for ALRT_EVT_OMNI_MODE.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.MODIFIED_BY
     *
     * @return the value of ALRT_EVT_OMNI_MODE.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for ALRT_EVT_OMNI_MODE.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT_OMNI_MODE.MODIFIED_DATE
     *
     * @return the value of ALRT_EVT_OMNI_MODE.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT_OMNI_MODE.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for ALRT_EVT_OMNI_MODE.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}