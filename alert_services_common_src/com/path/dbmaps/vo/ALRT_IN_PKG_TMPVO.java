package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class ALRT_IN_PKG_TMPVO extends ALRT_IN_PKG_TMPVOKey {
    /**
     * This field corresponds to the database column ALRT_IN_PKG_TMP.EVT_TYPE
     */
    private String EVT_TYPE;

    /**
     * This field corresponds to the database column ALRT_IN_PKG_TMP.PKG_ID
     */
    private BigDecimal PKG_ID;

    /**
     * This field corresponds to the database column ALRT_IN_PKG_TMP.DESCRIPTION
     */
    private String DESCRIPTION;

    /**
     * This field corresponds to the database column ALRT_IN_PKG_TMP.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_IN_PKG_TMP.EVT_TYPE
     *
     * @return the value of ALRT_IN_PKG_TMP.EVT_TYPE
     */
    public String getEVT_TYPE() {
        return EVT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_IN_PKG_TMP.EVT_TYPE
     *
     * @param EVT_TYPE the value for ALRT_IN_PKG_TMP.EVT_TYPE
     */
    public void setEVT_TYPE(String EVT_TYPE) {
        this.EVT_TYPE = EVT_TYPE == null ? null : EVT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_IN_PKG_TMP.PKG_ID
     *
     * @return the value of ALRT_IN_PKG_TMP.PKG_ID
     */
    public BigDecimal getPKG_ID() {
        return PKG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_IN_PKG_TMP.PKG_ID
     *
     * @param PKG_ID the value for ALRT_IN_PKG_TMP.PKG_ID
     */
    public void setPKG_ID(BigDecimal PKG_ID) {
        this.PKG_ID = PKG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_IN_PKG_TMP.DESCRIPTION
     *
     * @return the value of ALRT_IN_PKG_TMP.DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_IN_PKG_TMP.DESCRIPTION
     *
     * @param DESCRIPTION the value for ALRT_IN_PKG_TMP.DESCRIPTION
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_IN_PKG_TMP.LINE_NO
     *
     * @return the value of ALRT_IN_PKG_TMP.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_IN_PKG_TMP.LINE_NO
     *
     * @param LINE_NO the value for ALRT_IN_PKG_TMP.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}