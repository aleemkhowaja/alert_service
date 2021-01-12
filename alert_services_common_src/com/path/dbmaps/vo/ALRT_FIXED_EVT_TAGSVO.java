package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ALRT_FIXED_EVT_TAGSVO extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_TAGS.FIXED_EVT_ID
     */
    private BigDecimal FIXED_EVT_ID;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_TAGS.ID
     */
    private BigDecimal ID;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_TAGS.TAG_NAME
     */
    private String TAG_NAME;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_TAGS.TABLE_NAME
     */
    private String TABLE_NAME;

    /**
     * This field corresponds to the database column ALRT_FIXED_EVT_TAGS.COLUMN_NAME
     */
    private String COLUMN_NAME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_TAGS.FIXED_EVT_ID
     *
     * @return the value of ALRT_FIXED_EVT_TAGS.FIXED_EVT_ID
     */
    public BigDecimal getFIXED_EVT_ID() {
        return FIXED_EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_TAGS.FIXED_EVT_ID
     *
     * @param FIXED_EVT_ID the value for ALRT_FIXED_EVT_TAGS.FIXED_EVT_ID
     */
    public void setFIXED_EVT_ID(BigDecimal FIXED_EVT_ID) {
        this.FIXED_EVT_ID = FIXED_EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_TAGS.ID
     *
     * @return the value of ALRT_FIXED_EVT_TAGS.ID
     */
    public BigDecimal getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_TAGS.ID
     *
     * @param ID the value for ALRT_FIXED_EVT_TAGS.ID
     */
    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_TAGS.TAG_NAME
     *
     * @return the value of ALRT_FIXED_EVT_TAGS.TAG_NAME
     */
    public String getTAG_NAME() {
        return TAG_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_TAGS.TAG_NAME
     *
     * @param TAG_NAME the value for ALRT_FIXED_EVT_TAGS.TAG_NAME
     */
    public void setTAG_NAME(String TAG_NAME) {
        this.TAG_NAME = TAG_NAME == null ? null : TAG_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_TAGS.TABLE_NAME
     *
     * @return the value of ALRT_FIXED_EVT_TAGS.TABLE_NAME
     */
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_TAGS.TABLE_NAME
     *
     * @param TABLE_NAME the value for ALRT_FIXED_EVT_TAGS.TABLE_NAME
     */
    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME == null ? null : TABLE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_FIXED_EVT_TAGS.COLUMN_NAME
     *
     * @return the value of ALRT_FIXED_EVT_TAGS.COLUMN_NAME
     */
    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_FIXED_EVT_TAGS.COLUMN_NAME
     *
     * @param COLUMN_NAME the value for ALRT_FIXED_EVT_TAGS.COLUMN_NAME
     */
    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME == null ? null : COLUMN_NAME.trim();
    }
}