package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ALRT_REPORT_QUERY_ARGVOKey extends BaseVO {
    /**
     * This field corresponds to the database column ALRT_REPORT_QUERY_ARG.ARG_ID
     */
    private BigDecimal ARG_ID;

    /**
     * This field corresponds to the database column ALRT_REPORT_QUERY_ARG.REP_QUER_ID
     */
    private BigDecimal REP_QUER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_REPORT_QUERY_ARG.ARG_ID
     *
     * @return the value of ALRT_REPORT_QUERY_ARG.ARG_ID
     */
    public BigDecimal getARG_ID() {
        return ARG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_REPORT_QUERY_ARG.ARG_ID
     *
     * @param ARG_ID the value for ALRT_REPORT_QUERY_ARG.ARG_ID
     */
    public void setARG_ID(BigDecimal ARG_ID) {
        this.ARG_ID = ARG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_REPORT_QUERY_ARG.REP_QUER_ID
     *
     * @return the value of ALRT_REPORT_QUERY_ARG.REP_QUER_ID
     */
    public BigDecimal getREP_QUER_ID() {
        return REP_QUER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_REPORT_QUERY_ARG.REP_QUER_ID
     *
     * @param REP_QUER_ID the value for ALRT_REPORT_QUERY_ARG.REP_QUER_ID
     */
    public void setREP_QUER_ID(BigDecimal REP_QUER_ID) {
        this.REP_QUER_ID = REP_QUER_ID;
    }
}