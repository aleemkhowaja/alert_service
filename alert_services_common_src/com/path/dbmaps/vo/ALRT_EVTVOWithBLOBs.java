package com.path.dbmaps.vo;

public class ALRT_EVTVOWithBLOBs extends ALRT_EVTVO {
    /**
     * This field corresponds to the database column ALRT_EVT.MESSAGE_TEXT_ENG
     */
    private String MESSAGE_TEXT_ENG;

    /**
     * This field corresponds to the database column ALRT_EVT.MESSAGE_TEXT_ARAB
     */
    private String MESSAGE_TEXT_ARAB;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT.MESSAGE_TEXT_ENG
     *
     * @return the value of ALRT_EVT.MESSAGE_TEXT_ENG
     */
    public String getMESSAGE_TEXT_ENG() {
        return MESSAGE_TEXT_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT.MESSAGE_TEXT_ENG
     *
     * @param MESSAGE_TEXT_ENG the value for ALRT_EVT.MESSAGE_TEXT_ENG
     */
    public void setMESSAGE_TEXT_ENG(String MESSAGE_TEXT_ENG) {
        this.MESSAGE_TEXT_ENG = MESSAGE_TEXT_ENG == null ? null : MESSAGE_TEXT_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ALRT_EVT.MESSAGE_TEXT_ARAB
     *
     * @return the value of ALRT_EVT.MESSAGE_TEXT_ARAB
     */
    public String getMESSAGE_TEXT_ARAB() {
        return MESSAGE_TEXT_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ALRT_EVT.MESSAGE_TEXT_ARAB
     *
     * @param MESSAGE_TEXT_ARAB the value for ALRT_EVT.MESSAGE_TEXT_ARAB
     */
    public void setMESSAGE_TEXT_ARAB(String MESSAGE_TEXT_ARAB) {
        this.MESSAGE_TEXT_ARAB = MESSAGE_TEXT_ARAB == null ? null : MESSAGE_TEXT_ARAB.trim();
    }
}