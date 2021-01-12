package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class ALRT_TAGSVO extends ALRT_TAGSVOKey {
    /**
     * This field corresponds to the database column ALRT_TAGS.TAG_TYPE
     */
    private String TAG_TYPE;

    /**
     * This field corresponds to the database column ALRT_TAGS.FIXED_EVT_ID
     */
    private BigDecimal FIXED_EVT_ID;

    /**
     * This field corresponds to the database column ALRT_TAGS.TAG_NAME
     */
    private String TAG_NAME;

    /**
     * This field corresponds to the database column ALRT_TAGS.TAG_DESCRIPTION
     */
    private String TAG_DESCRIPTION;
    
    
    /**
     * This field corresponds to the database column CP2_IIAB_O11.ALRT_TAGS.DYNAMIC_TYPE_YN
     */
    private String DYNAMIC_TYPE_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_TAGS.TAG_TYPE
     *
     * @return the value of ALRT_TAGS.TAG_TYPE
     */
    public String getTAG_TYPE() {
        return TAG_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_TAGS.TAG_TYPE
     *
     * @param TAG_TYPE the value for ALRT_TAGS.TAG_TYPE
     */
    public void setTAG_TYPE(String TAG_TYPE) {
        this.TAG_TYPE = TAG_TYPE == null ? null : TAG_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_TAGS.FIXED_EVT_ID
     *
     * @return the value of ALRT_TAGS.FIXED_EVT_ID
     */
    public BigDecimal getFIXED_EVT_ID() {
        return FIXED_EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_TAGS.FIXED_EVT_ID
     *
     * @param FIXED_EVT_ID the value for ALRT_TAGS.FIXED_EVT_ID
     */
    public void setFIXED_EVT_ID(BigDecimal FIXED_EVT_ID) {
        this.FIXED_EVT_ID = FIXED_EVT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_TAGS.TAG_NAME
     *
     * @return the value of ALRT_TAGS.TAG_NAME
     */
    public String getTAG_NAME() {
        return TAG_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_TAGS.TAG_NAME
     *
     * @param TAG_NAME the value for ALRT_TAGS.TAG_NAME
     */
    public void setTAG_NAME(String TAG_NAME) {
        this.TAG_NAME = TAG_NAME == null ? null : TAG_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_TAGS.TAG_DESCRIPTION
     *
     * @return the value of ALRT_TAGS.TAG_DESCRIPTION
     */
    public String getTAG_DESCRIPTION() {
        return TAG_DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_TAGS.TAG_DESCRIPTION
     *
     * @param TAG_DESCRIPTION the value for ALRT_TAGS.TAG_DESCRIPTION
     */
    public void setTAG_DESCRIPTION(String TAG_DESCRIPTION) {
        this.TAG_DESCRIPTION = TAG_DESCRIPTION == null ? null : TAG_DESCRIPTION.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_TAGS.DYNAMIC_TYPE_YN
     *
     * @return the value of ALRT_TAGS.DYNAMIC_TYPE_YN
     */
    public String getDYNAMIC_TYPE_YN() {
        return DYNAMIC_TYPE_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_TAGS.DYNAMIC_TYPE_YN
     *
     * @param DYNAMIC_TYPE_YN the value for ALRT_TAGS.DYNAMIC_TYPE_YN
     */
    public void setDYNAMIC_TYPE_YN(String DYNAMIC_TYPE_YN) {
        this.DYNAMIC_TYPE_YN = DYNAMIC_TYPE_YN == null ? null : DYNAMIC_TYPE_YN.trim();
    }
}