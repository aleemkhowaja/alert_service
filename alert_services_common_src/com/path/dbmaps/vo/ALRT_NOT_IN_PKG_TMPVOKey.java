package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ALRT_NOT_IN_PKG_TMPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_NOT_IN_PKG_TMP.EVT_ID
     */
    private BigDecimal EVT_ID;

    /**
     * This field corresponds to the database column ALRT_NOT_IN_PKG_TMP.SESSION_ID
     */
    private String SESSION_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_NOT_IN_PKG_TMP.EVT_ID
     *
     * @return the value of ALRT_NOT_IN_PKG_TMP.EVT_ID
     */
    public BigDecimal getEVT_ID() {
        return EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_NOT_IN_PKG_TMP.EVT_ID
     *
     * @param EVT_ID the value for ALRT_NOT_IN_PKG_TMP.EVT_ID
     */
    public void setEVT_ID(BigDecimal EVT_ID) {
        this.EVT_ID = EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_NOT_IN_PKG_TMP.SESSION_ID
     *
     * @return the value of ALRT_NOT_IN_PKG_TMP.SESSION_ID
     */
    public String getSESSION_ID() {
        return SESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_NOT_IN_PKG_TMP.SESSION_ID
     *
     * @param SESSION_ID the value for ALRT_NOT_IN_PKG_TMP.SESSION_ID
     */
    public void setSESSION_ID(String SESSION_ID) {
        this.SESSION_ID = SESSION_ID == null ? null : SESSION_ID.trim();
    }
}