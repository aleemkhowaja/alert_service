package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ALRT_FIXED_EVT_PARAMVO extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_PARAM.FIXED_EVENT_ID
     */
    private BigDecimal FIXED_EVENT_ID;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_PARAM.ID
     */
    private BigDecimal ID;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_TYPE
     */
    private String PARAM_COLUMN_TYPE;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_NAME
     */
    private String PARAM_COLUMN_NAME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_PARAM.FIXED_EVENT_ID
     *
     * @return the value of ALRT_FIXED_EVT_PARAM.FIXED_EVENT_ID
     */
    public BigDecimal getFIXED_EVENT_ID() {
        return FIXED_EVENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_PARAM.FIXED_EVENT_ID
     *
     * @param FIXED_EVENT_ID the value for ALRT_FIXED_EVT_PARAM.FIXED_EVENT_ID
     */
    public void setFIXED_EVENT_ID(BigDecimal FIXED_EVENT_ID) {
        this.FIXED_EVENT_ID = FIXED_EVENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_PARAM.ID
     *
     * @return the value of ALRT_FIXED_EVT_PARAM.ID
     */
    public BigDecimal getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_PARAM.ID
     *
     * @param ID the value for ALRT_FIXED_EVT_PARAM.ID
     */
    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_TYPE
     *
     * @return the value of ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_TYPE
     */
    public String getPARAM_COLUMN_TYPE() {
        return PARAM_COLUMN_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_TYPE
     *
     * @param PARAM_COLUMN_TYPE the value for ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_TYPE
     */
    public void setPARAM_COLUMN_TYPE(String PARAM_COLUMN_TYPE) {
        this.PARAM_COLUMN_TYPE = PARAM_COLUMN_TYPE == null ? null : PARAM_COLUMN_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_NAME
     *
     * @return the value of ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_NAME
     */
    public String getPARAM_COLUMN_NAME() {
        return PARAM_COLUMN_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_NAME
     *
     * @param PARAM_COLUMN_NAME the value for ALRT_FIXED_EVT_PARAM.PARAM_COLUMN_NAME
     */
    public void setPARAM_COLUMN_NAME(String PARAM_COLUMN_NAME) {
        this.PARAM_COLUMN_NAME = PARAM_COLUMN_NAME == null ? null : PARAM_COLUMN_NAME.trim();
    }
}