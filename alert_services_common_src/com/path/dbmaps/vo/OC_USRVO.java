package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class OC_USRVO  extends BaseVO {
	
	 /**
     * This field corresponds to the database column OC_USR.USR_ID
     */
    private BigDecimal USR_ID;

    /**
     * This field corresponds to the database column OC_USR.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    public BigDecimal getUSR_ID() {
		return USR_ID;
	}

	public void setUSR_ID(BigDecimal uSR_ID) {
		USR_ID = uSR_ID;
	}

	/**
     * This field corresponds to the database column OC_USR.USR_CODE
     */
    private BigDecimal USR_CODE;

    /**
     * This field corresponds to the database column OC_USR.CIF_NO
     */
    private String CIF_NO;

    /**
     * This field corresponds to the database column OC_USR.NAME
     */
    private String NAME;

    /**
     * This field corresponds to the database column OC_USR.PASSWORD
     */
    private String PASSWORD;

    /**
     * This field corresponds to the database column OC_USR.PWD_LAST_MODIFIED
     */
    private Date PWD_LAST_MODIFIED;

    /**
     * This field corresponds to the database column OC_USR.PWD_HASHING_ALGORITHM
     */
    private BigDecimal PWD_HASHING_ALGORITHM;

    /**
     * This field corresponds to the database column OC_USR.PIN_PASSWORD
     */
    private String PIN_PASSWORD;

    /**
     * This field corresponds to the database column OC_USR.PIN_LAST_MODIFIED
     */
    private Date PIN_LAST_MODIFIED;

    /**
     * This field corresponds to the database column OC_USR.PIN_HASHING_ALGORITHM
     */
    private BigDecimal PIN_HASHING_ALGORITHM;

    /**
     * This field corresponds to the database column OC_USR.LOGIN_CTR_HIT
     */
    private BigDecimal LOGIN_CTR_HIT;

    /**
     * This field corresponds to the database column OC_USR.CTR_PIN_HIT
     */
    private BigDecimal CTR_PIN_HIT;

    /**
     * This field corresponds to the database column OC_USR.CTR_OTP_HIT
     */
    private BigDecimal CTR_OTP_HIT;

    /**
     * This field corresponds to the database column OC_USR.FIRST_LOGIN_DATE
     */
    private Date FIRST_LOGIN_DATE;

    /**
     * This field corresponds to the database column OC_USR.LAST_ACCESS_TIME
     */
    private Date LAST_ACCESS_TIME;

    /**
     * This field corresponds to the database column OC_USR.SESSION_ID
     */
    private String SESSION_ID;

    /**
     * This field corresponds to the database column OC_USR.EMAIL
     */
    private String EMAIL;

    /**
     * This field corresponds to the database column OC_USR.BUSINESS_PROFILE_ID
     */
    private BigDecimal BUSINESS_PROFILE_ID;

    /**
     * This field corresponds to the database column OC_USR.REMOTE_HOST
     */
    private String REMOTE_HOST;

    /**
     * This field corresponds to the database column OC_USR.PASSWORD_RESET_YN
     */
    private String PASSWORD_RESET_YN;

    /**
     * This field corresponds to the database column OC_USR.PIN_RESET_YN
     */
    private String PIN_RESET_YN;

    /**
     * This field corresponds to the database column OC_USR.RESET_DELIVERY_TYPE
     */
    private BigDecimal RESET_DELIVERY_TYPE;

    /**
     * This field corresponds to the database column OC_USR.FUNCTION_KIT_CODE
     */
    private BigDecimal FUNCTION_KIT_CODE;

    /**
     * This field corresponds to the database column OC_USR.SUSPENDED_BY
     */
    private String SUSPENDED_BY;

    /**
     * This field corresponds to the database column OC_USR.SUSPENDED_DATE
     */
    private Date SUSPENDED_DATE;

    /**
     * This field corresponds to the database column OC_USR.OC_ACTIVATED_BY
     */
    private BigDecimal OC_ACTIVATED_BY;

    /**
     * This field corresponds to the database column OC_USR.ACTIVATED_BY
     */
    private String ACTIVATED_BY;

    /**
     * This field corresponds to the database column OC_USR.ACTIVATED_DATE
     */
    private Date ACTIVATED_DATE;

    /**
     * This field corresponds to the database column OC_USR.OC_DELIVERED_BY
     */
    private BigDecimal OC_DELIVERED_BY;

    /**
     * This field corresponds to the database column OC_USR.DELIVERED_BY
     */
    private String DELIVERED_BY;

    /**
     * This field corresponds to the database column OC_USR.DELIVERED_DATE
     */
    private Date DELIVERED_DATE;

    /**
     * This field corresponds to the database column OC_USR.SECURITY_ID
     */
    private BigDecimal SECURITY_ID;

    /**
     * This field corresponds to the database column OC_USR.SEC_ANSWER
     */
    private String SEC_ANSWER;

    /**
     * This field corresponds to the database column OC_USR.IMAGE_URL
     */
    private String IMAGE_URL;

    /**
     * This field corresponds to the database column OC_USR.CHARGE_REFERENCE_ACC
     */
    private String CHARGE_REFERENCE_ACC;

    /**
     * This field corresponds to the database column OC_USR.PASS_PHRASE
     */
    private String PASS_PHRASE;

    /**
     * This field corresponds to the database column OC_USR.CTR_SEC_QUESTION_UPDATED
     */
    private BigDecimal CTR_SEC_QUESTION_UPDATED;

    /**
     * This field corresponds to the database column OC_USR.CTR_SEC_ANSWER_UPDATED
     */
    private BigDecimal CTR_SEC_ANSWER_UPDATED;

    /**
     * This field corresponds to the database column OC_USR.SEC_QUESTION_LAST_UPDATED
     */
    private Date SEC_QUESTION_LAST_UPDATED;

    /**
     * This field corresponds to the database column OC_USR.SEC_ANSWER_LAST_UPDATED
     */
    private Date SEC_ANSWER_LAST_UPDATED;

    /**
     * This field corresponds to the database column OC_USR.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column OC_USR.APPROVAL_DATE
     */
    private Date APPROVAL_DATE;

    /**
     * This field corresponds to the database column OC_USR.WAIVE_CHARGES_YN
     */
    private String WAIVE_CHARGES_YN;

    /**
     * This field corresponds to the database column OC_USR.CHARGES_DEDUCTED_YN
     */
    private String CHARGES_DEDUCTED_YN;

    /**
     * This field corresponds to the database column OC_USR.ONLINE_REG_YN
     */
    private String ONLINE_REG_YN;

    /**
     * This field corresponds to the database column OC_USR.JOINT_CIF_YN
     */
    private String JOINT_CIF_YN;

    /**
     * This field corresponds to the database column OC_USR.CTR_CAPTCHA_REQUESTED
     */
    private BigDecimal CTR_CAPTCHA_REQUESTED;

    /**
     * This field corresponds to the database column OC_USR.OTP_TRS_ACTIVATION
     */
    private BigDecimal OTP_TRS_ACTIVATION;

    /**
     * This field corresponds to the database column OC_USR.MOBILE_NUMBER
     */
    private String MOBILE_NUMBER;

    /**
     * This field corresponds to the database column OC_USR.CANCEL_REASON
     */
    private String CANCEL_REASON;

    /**
     * This field corresponds to the database column OC_USR.REACTIVATE_REASON
     */
    private String REACTIVATE_REASON;

    /**
     * This field corresponds to the database column OC_USR.OC_AUTH_MODIFED_BY
     */
    private BigDecimal OC_AUTH_MODIFED_BY;

    /**
     * This field corresponds to the database column OC_USR.AUTH_MODIFED_BY
     */
    private String AUTH_MODIFED_BY;

    /**
     * This field corresponds to the database column OC_USR.AUTH_MODIFIED_DATE
     */
    private Date AUTH_MODIFIED_DATE;

    /**
     * This field corresponds to the database column OC_USR.OC_AUTH_ACTIVATED_BY
     */
    private BigDecimal OC_AUTH_ACTIVATED_BY;

    /**
     * This field corresponds to the database column OC_USR.AUTH_ACTIVATED_BY
     */
    private String AUTH_ACTIVATED_BY;

    /**
     * This field corresponds to the database column OC_USR.AUTH_ACTIVATED_DATE
     */
    private Date AUTH_ACTIVATED_DATE;

    /**
     * This field corresponds to the database column OC_USR.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column OC_USR.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column OC_USR.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column OC_USR.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column OC_USR.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column OC_USR.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column OC_USR.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column OC_USR.DELETED_DATE
     */
    private Date DELETED_DATE;

    /**
     * This field corresponds to the database column OC_USR.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column OC_USR.REJECTED_DATE
     */
    private Date REJECTED_DATE;

    /**
     * This field corresponds to the database column OC_USR.REACTIVATED_BY
     */
    private String REACTIVATED_BY;

    /**
     * This field corresponds to the database column OC_USR.REACTIVATED_DATE
     */
    private Date REACTIVATED_DATE;

    /**
     * This field corresponds to the database column OC_USR.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column OC_USR.BLOCK_REASON
     */
    private String BLOCK_REASON;

    /**
     * This field corresponds to the database column OC_USR.SUSPENDED_REASON
     */
    private String SUSPENDED_REASON;

    /**
     * This field corresponds to the database column OC_USR.REF_CODE
     */
    private BigDecimal REF_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.COMP_CODE
     *
     * @return the value of OC_USR.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.COMP_CODE
     *
     * @param COMP_CODE the value for OC_USR.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.USR_CODE
     *
     * @return the value of OC_USR.USR_CODE
     */
    public BigDecimal getUSR_CODE() {
        return USR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.USR_CODE
     *
     * @param USR_CODE the value for OC_USR.USR_CODE
     */
    public void setUSR_CODE(BigDecimal USR_CODE) {
        this.USR_CODE = USR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CIF_NO
     *
     * @return the value of OC_USR.CIF_NO
     */
    public String getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CIF_NO
     *
     * @param CIF_NO the value for OC_USR.CIF_NO
     */
    public void setCIF_NO(String CIF_NO) {
        this.CIF_NO = CIF_NO == null ? null : CIF_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.NAME
     *
     * @return the value of OC_USR.NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.NAME
     *
     * @param NAME the value for OC_USR.NAME
     */
    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PASSWORD
     *
     * @return the value of OC_USR.PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PASSWORD
     *
     * @param PASSWORD the value for OC_USR.PASSWORD
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PWD_LAST_MODIFIED
     *
     * @return the value of OC_USR.PWD_LAST_MODIFIED
     */
    public Date getPWD_LAST_MODIFIED() {
        return PWD_LAST_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PWD_LAST_MODIFIED
     *
     * @param PWD_LAST_MODIFIED the value for OC_USR.PWD_LAST_MODIFIED
     */
    public void setPWD_LAST_MODIFIED(Date PWD_LAST_MODIFIED) {
        this.PWD_LAST_MODIFIED = PWD_LAST_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PWD_HASHING_ALGORITHM
     *
     * @return the value of OC_USR.PWD_HASHING_ALGORITHM
     */
    public BigDecimal getPWD_HASHING_ALGORITHM() {
        return PWD_HASHING_ALGORITHM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PWD_HASHING_ALGORITHM
     *
     * @param PWD_HASHING_ALGORITHM the value for OC_USR.PWD_HASHING_ALGORITHM
     */
    public void setPWD_HASHING_ALGORITHM(BigDecimal PWD_HASHING_ALGORITHM) {
        this.PWD_HASHING_ALGORITHM = PWD_HASHING_ALGORITHM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PIN_PASSWORD
     *
     * @return the value of OC_USR.PIN_PASSWORD
     */
    public String getPIN_PASSWORD() {
        return PIN_PASSWORD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PIN_PASSWORD
     *
     * @param PIN_PASSWORD the value for OC_USR.PIN_PASSWORD
     */
    public void setPIN_PASSWORD(String PIN_PASSWORD) {
        this.PIN_PASSWORD = PIN_PASSWORD == null ? null : PIN_PASSWORD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PIN_LAST_MODIFIED
     *
     * @return the value of OC_USR.PIN_LAST_MODIFIED
     */
    public Date getPIN_LAST_MODIFIED() {
        return PIN_LAST_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PIN_LAST_MODIFIED
     *
     * @param PIN_LAST_MODIFIED the value for OC_USR.PIN_LAST_MODIFIED
     */
    public void setPIN_LAST_MODIFIED(Date PIN_LAST_MODIFIED) {
        this.PIN_LAST_MODIFIED = PIN_LAST_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PIN_HASHING_ALGORITHM
     *
     * @return the value of OC_USR.PIN_HASHING_ALGORITHM
     */
    public BigDecimal getPIN_HASHING_ALGORITHM() {
        return PIN_HASHING_ALGORITHM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PIN_HASHING_ALGORITHM
     *
     * @param PIN_HASHING_ALGORITHM the value for OC_USR.PIN_HASHING_ALGORITHM
     */
    public void setPIN_HASHING_ALGORITHM(BigDecimal PIN_HASHING_ALGORITHM) {
        this.PIN_HASHING_ALGORITHM = PIN_HASHING_ALGORITHM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.LOGIN_CTR_HIT
     *
     * @return the value of OC_USR.LOGIN_CTR_HIT
     */
    public BigDecimal getLOGIN_CTR_HIT() {
        return LOGIN_CTR_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.LOGIN_CTR_HIT
     *
     * @param LOGIN_CTR_HIT the value for OC_USR.LOGIN_CTR_HIT
     */
    public void setLOGIN_CTR_HIT(BigDecimal LOGIN_CTR_HIT) {
        this.LOGIN_CTR_HIT = LOGIN_CTR_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CTR_PIN_HIT
     *
     * @return the value of OC_USR.CTR_PIN_HIT
     */
    public BigDecimal getCTR_PIN_HIT() {
        return CTR_PIN_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CTR_PIN_HIT
     *
     * @param CTR_PIN_HIT the value for OC_USR.CTR_PIN_HIT
     */
    public void setCTR_PIN_HIT(BigDecimal CTR_PIN_HIT) {
        this.CTR_PIN_HIT = CTR_PIN_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CTR_OTP_HIT
     *
     * @return the value of OC_USR.CTR_OTP_HIT
     */
    public BigDecimal getCTR_OTP_HIT() {
        return CTR_OTP_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CTR_OTP_HIT
     *
     * @param CTR_OTP_HIT the value for OC_USR.CTR_OTP_HIT
     */
    public void setCTR_OTP_HIT(BigDecimal CTR_OTP_HIT) {
        this.CTR_OTP_HIT = CTR_OTP_HIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.FIRST_LOGIN_DATE
     *
     * @return the value of OC_USR.FIRST_LOGIN_DATE
     */
    public Date getFIRST_LOGIN_DATE() {
        return FIRST_LOGIN_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.FIRST_LOGIN_DATE
     *
     * @param FIRST_LOGIN_DATE the value for OC_USR.FIRST_LOGIN_DATE
     */
    public void setFIRST_LOGIN_DATE(Date FIRST_LOGIN_DATE) {
        this.FIRST_LOGIN_DATE = FIRST_LOGIN_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.LAST_ACCESS_TIME
     *
     * @return the value of OC_USR.LAST_ACCESS_TIME
     */
    public Date getLAST_ACCESS_TIME() {
        return LAST_ACCESS_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.LAST_ACCESS_TIME
     *
     * @param LAST_ACCESS_TIME the value for OC_USR.LAST_ACCESS_TIME
     */
    public void setLAST_ACCESS_TIME(Date LAST_ACCESS_TIME) {
        this.LAST_ACCESS_TIME = LAST_ACCESS_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SESSION_ID
     *
     * @return the value of OC_USR.SESSION_ID
     */
    public String getSESSION_ID() {
        return SESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SESSION_ID
     *
     * @param SESSION_ID the value for OC_USR.SESSION_ID
     */
    public void setSESSION_ID(String SESSION_ID) {
        this.SESSION_ID = SESSION_ID == null ? null : SESSION_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.EMAIL
     *
     * @return the value of OC_USR.EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.EMAIL
     *
     * @param EMAIL the value for OC_USR.EMAIL
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.BUSINESS_PROFILE_ID
     *
     * @return the value of OC_USR.BUSINESS_PROFILE_ID
     */
    public BigDecimal getBUSINESS_PROFILE_ID() {
        return BUSINESS_PROFILE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.BUSINESS_PROFILE_ID
     *
     * @param BUSINESS_PROFILE_ID the value for OC_USR.BUSINESS_PROFILE_ID
     */
    public void setBUSINESS_PROFILE_ID(BigDecimal BUSINESS_PROFILE_ID) {
        this.BUSINESS_PROFILE_ID = BUSINESS_PROFILE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REMOTE_HOST
     *
     * @return the value of OC_USR.REMOTE_HOST
     */
    public String getREMOTE_HOST() {
        return REMOTE_HOST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REMOTE_HOST
     *
     * @param REMOTE_HOST the value for OC_USR.REMOTE_HOST
     */
    public void setREMOTE_HOST(String REMOTE_HOST) {
        this.REMOTE_HOST = REMOTE_HOST == null ? null : REMOTE_HOST.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PASSWORD_RESET_YN
     *
     * @return the value of OC_USR.PASSWORD_RESET_YN
     */
    public String getPASSWORD_RESET_YN() {
        return PASSWORD_RESET_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PASSWORD_RESET_YN
     *
     * @param PASSWORD_RESET_YN the value for OC_USR.PASSWORD_RESET_YN
     */
    public void setPASSWORD_RESET_YN(String PASSWORD_RESET_YN) {
        this.PASSWORD_RESET_YN = PASSWORD_RESET_YN == null ? null : PASSWORD_RESET_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PIN_RESET_YN
     *
     * @return the value of OC_USR.PIN_RESET_YN
     */
    public String getPIN_RESET_YN() {
        return PIN_RESET_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PIN_RESET_YN
     *
     * @param PIN_RESET_YN the value for OC_USR.PIN_RESET_YN
     */
    public void setPIN_RESET_YN(String PIN_RESET_YN) {
        this.PIN_RESET_YN = PIN_RESET_YN == null ? null : PIN_RESET_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.RESET_DELIVERY_TYPE
     *
     * @return the value of OC_USR.RESET_DELIVERY_TYPE
     */
    public BigDecimal getRESET_DELIVERY_TYPE() {
        return RESET_DELIVERY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.RESET_DELIVERY_TYPE
     *
     * @param RESET_DELIVERY_TYPE the value for OC_USR.RESET_DELIVERY_TYPE
     */
    public void setRESET_DELIVERY_TYPE(BigDecimal RESET_DELIVERY_TYPE) {
        this.RESET_DELIVERY_TYPE = RESET_DELIVERY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.FUNCTION_KIT_CODE
     *
     * @return the value of OC_USR.FUNCTION_KIT_CODE
     */
    public BigDecimal getFUNCTION_KIT_CODE() {
        return FUNCTION_KIT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.FUNCTION_KIT_CODE
     *
     * @param FUNCTION_KIT_CODE the value for OC_USR.FUNCTION_KIT_CODE
     */
    public void setFUNCTION_KIT_CODE(BigDecimal FUNCTION_KIT_CODE) {
        this.FUNCTION_KIT_CODE = FUNCTION_KIT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SUSPENDED_BY
     *
     * @return the value of OC_USR.SUSPENDED_BY
     */
    public String getSUSPENDED_BY() {
        return SUSPENDED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SUSPENDED_BY
     *
     * @param SUSPENDED_BY the value for OC_USR.SUSPENDED_BY
     */
    public void setSUSPENDED_BY(String SUSPENDED_BY) {
        this.SUSPENDED_BY = SUSPENDED_BY == null ? null : SUSPENDED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SUSPENDED_DATE
     *
     * @return the value of OC_USR.SUSPENDED_DATE
     */
    public Date getSUSPENDED_DATE() {
        return SUSPENDED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SUSPENDED_DATE
     *
     * @param SUSPENDED_DATE the value for OC_USR.SUSPENDED_DATE
     */
    public void setSUSPENDED_DATE(Date SUSPENDED_DATE) {
        this.SUSPENDED_DATE = SUSPENDED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.OC_ACTIVATED_BY
     *
     * @return the value of OC_USR.OC_ACTIVATED_BY
     */
    public BigDecimal getOC_ACTIVATED_BY() {
        return OC_ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.OC_ACTIVATED_BY
     *
     * @param OC_ACTIVATED_BY the value for OC_USR.OC_ACTIVATED_BY
     */
    public void setOC_ACTIVATED_BY(BigDecimal OC_ACTIVATED_BY) {
        this.OC_ACTIVATED_BY = OC_ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.ACTIVATED_BY
     *
     * @return the value of OC_USR.ACTIVATED_BY
     */
    public String getACTIVATED_BY() {
        return ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.ACTIVATED_BY
     *
     * @param ACTIVATED_BY the value for OC_USR.ACTIVATED_BY
     */
    public void setACTIVATED_BY(String ACTIVATED_BY) {
        this.ACTIVATED_BY = ACTIVATED_BY == null ? null : ACTIVATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.ACTIVATED_DATE
     *
     * @return the value of OC_USR.ACTIVATED_DATE
     */
    public Date getACTIVATED_DATE() {
        return ACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.ACTIVATED_DATE
     *
     * @param ACTIVATED_DATE the value for OC_USR.ACTIVATED_DATE
     */
    public void setACTIVATED_DATE(Date ACTIVATED_DATE) {
        this.ACTIVATED_DATE = ACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.OC_DELIVERED_BY
     *
     * @return the value of OC_USR.OC_DELIVERED_BY
     */
    public BigDecimal getOC_DELIVERED_BY() {
        return OC_DELIVERED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.OC_DELIVERED_BY
     *
     * @param OC_DELIVERED_BY the value for OC_USR.OC_DELIVERED_BY
     */
    public void setOC_DELIVERED_BY(BigDecimal OC_DELIVERED_BY) {
        this.OC_DELIVERED_BY = OC_DELIVERED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.DELIVERED_BY
     *
     * @return the value of OC_USR.DELIVERED_BY
     */
    public String getDELIVERED_BY() {
        return DELIVERED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.DELIVERED_BY
     *
     * @param DELIVERED_BY the value for OC_USR.DELIVERED_BY
     */
    public void setDELIVERED_BY(String DELIVERED_BY) {
        this.DELIVERED_BY = DELIVERED_BY == null ? null : DELIVERED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.DELIVERED_DATE
     *
     * @return the value of OC_USR.DELIVERED_DATE
     */
    public Date getDELIVERED_DATE() {
        return DELIVERED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.DELIVERED_DATE
     *
     * @param DELIVERED_DATE the value for OC_USR.DELIVERED_DATE
     */
    public void setDELIVERED_DATE(Date DELIVERED_DATE) {
        this.DELIVERED_DATE = DELIVERED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SECURITY_ID
     *
     * @return the value of OC_USR.SECURITY_ID
     */
    public BigDecimal getSECURITY_ID() {
        return SECURITY_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SECURITY_ID
     *
     * @param SECURITY_ID the value for OC_USR.SECURITY_ID
     */
    public void setSECURITY_ID(BigDecimal SECURITY_ID) {
        this.SECURITY_ID = SECURITY_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SEC_ANSWER
     *
     * @return the value of OC_USR.SEC_ANSWER
     */
    public String getSEC_ANSWER() {
        return SEC_ANSWER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SEC_ANSWER
     *
     * @param SEC_ANSWER the value for OC_USR.SEC_ANSWER
     */
    public void setSEC_ANSWER(String SEC_ANSWER) {
        this.SEC_ANSWER = SEC_ANSWER == null ? null : SEC_ANSWER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.IMAGE_URL
     *
     * @return the value of OC_USR.IMAGE_URL
     */
    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.IMAGE_URL
     *
     * @param IMAGE_URL the value for OC_USR.IMAGE_URL
     */
    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL == null ? null : IMAGE_URL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CHARGE_REFERENCE_ACC
     *
     * @return the value of OC_USR.CHARGE_REFERENCE_ACC
     */
    public String getCHARGE_REFERENCE_ACC() {
        return CHARGE_REFERENCE_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CHARGE_REFERENCE_ACC
     *
     * @param CHARGE_REFERENCE_ACC the value for OC_USR.CHARGE_REFERENCE_ACC
     */
    public void setCHARGE_REFERENCE_ACC(String CHARGE_REFERENCE_ACC) {
        this.CHARGE_REFERENCE_ACC = CHARGE_REFERENCE_ACC == null ? null : CHARGE_REFERENCE_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.PASS_PHRASE
     *
     * @return the value of OC_USR.PASS_PHRASE
     */
    public String getPASS_PHRASE() {
        return PASS_PHRASE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.PASS_PHRASE
     *
     * @param PASS_PHRASE the value for OC_USR.PASS_PHRASE
     */
    public void setPASS_PHRASE(String PASS_PHRASE) {
        this.PASS_PHRASE = PASS_PHRASE == null ? null : PASS_PHRASE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CTR_SEC_QUESTION_UPDATED
     *
     * @return the value of OC_USR.CTR_SEC_QUESTION_UPDATED
     */
    public BigDecimal getCTR_SEC_QUESTION_UPDATED() {
        return CTR_SEC_QUESTION_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CTR_SEC_QUESTION_UPDATED
     *
     * @param CTR_SEC_QUESTION_UPDATED the value for OC_USR.CTR_SEC_QUESTION_UPDATED
     */
    public void setCTR_SEC_QUESTION_UPDATED(BigDecimal CTR_SEC_QUESTION_UPDATED) {
        this.CTR_SEC_QUESTION_UPDATED = CTR_SEC_QUESTION_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CTR_SEC_ANSWER_UPDATED
     *
     * @return the value of OC_USR.CTR_SEC_ANSWER_UPDATED
     */
    public BigDecimal getCTR_SEC_ANSWER_UPDATED() {
        return CTR_SEC_ANSWER_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CTR_SEC_ANSWER_UPDATED
     *
     * @param CTR_SEC_ANSWER_UPDATED the value for OC_USR.CTR_SEC_ANSWER_UPDATED
     */
    public void setCTR_SEC_ANSWER_UPDATED(BigDecimal CTR_SEC_ANSWER_UPDATED) {
        this.CTR_SEC_ANSWER_UPDATED = CTR_SEC_ANSWER_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SEC_QUESTION_LAST_UPDATED
     *
     * @return the value of OC_USR.SEC_QUESTION_LAST_UPDATED
     */
    public Date getSEC_QUESTION_LAST_UPDATED() {
        return SEC_QUESTION_LAST_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SEC_QUESTION_LAST_UPDATED
     *
     * @param SEC_QUESTION_LAST_UPDATED the value for OC_USR.SEC_QUESTION_LAST_UPDATED
     */
    public void setSEC_QUESTION_LAST_UPDATED(Date SEC_QUESTION_LAST_UPDATED) {
        this.SEC_QUESTION_LAST_UPDATED = SEC_QUESTION_LAST_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SEC_ANSWER_LAST_UPDATED
     *
     * @return the value of OC_USR.SEC_ANSWER_LAST_UPDATED
     */
    public Date getSEC_ANSWER_LAST_UPDATED() {
        return SEC_ANSWER_LAST_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SEC_ANSWER_LAST_UPDATED
     *
     * @param SEC_ANSWER_LAST_UPDATED the value for OC_USR.SEC_ANSWER_LAST_UPDATED
     */
    public void setSEC_ANSWER_LAST_UPDATED(Date SEC_ANSWER_LAST_UPDATED) {
        this.SEC_ANSWER_LAST_UPDATED = SEC_ANSWER_LAST_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.STATUS
     *
     * @return the value of OC_USR.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.STATUS
     *
     * @param STATUS the value for OC_USR.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.APPROVAL_DATE
     *
     * @return the value of OC_USR.APPROVAL_DATE
     */
    public Date getAPPROVAL_DATE() {
        return APPROVAL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.APPROVAL_DATE
     *
     * @param APPROVAL_DATE the value for OC_USR.APPROVAL_DATE
     */
    public void setAPPROVAL_DATE(Date APPROVAL_DATE) {
        this.APPROVAL_DATE = APPROVAL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.WAIVE_CHARGES_YN
     *
     * @return the value of OC_USR.WAIVE_CHARGES_YN
     */
    public String getWAIVE_CHARGES_YN() {
        return WAIVE_CHARGES_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.WAIVE_CHARGES_YN
     *
     * @param WAIVE_CHARGES_YN the value for OC_USR.WAIVE_CHARGES_YN
     */
    public void setWAIVE_CHARGES_YN(String WAIVE_CHARGES_YN) {
        this.WAIVE_CHARGES_YN = WAIVE_CHARGES_YN == null ? null : WAIVE_CHARGES_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CHARGES_DEDUCTED_YN
     *
     * @return the value of OC_USR.CHARGES_DEDUCTED_YN
     */
    public String getCHARGES_DEDUCTED_YN() {
        return CHARGES_DEDUCTED_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CHARGES_DEDUCTED_YN
     *
     * @param CHARGES_DEDUCTED_YN the value for OC_USR.CHARGES_DEDUCTED_YN
     */
    public void setCHARGES_DEDUCTED_YN(String CHARGES_DEDUCTED_YN) {
        this.CHARGES_DEDUCTED_YN = CHARGES_DEDUCTED_YN == null ? null : CHARGES_DEDUCTED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.ONLINE_REG_YN
     *
     * @return the value of OC_USR.ONLINE_REG_YN
     */
    public String getONLINE_REG_YN() {
        return ONLINE_REG_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.ONLINE_REG_YN
     *
     * @param ONLINE_REG_YN the value for OC_USR.ONLINE_REG_YN
     */
    public void setONLINE_REG_YN(String ONLINE_REG_YN) {
        this.ONLINE_REG_YN = ONLINE_REG_YN == null ? null : ONLINE_REG_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.JOINT_CIF_YN
     *
     * @return the value of OC_USR.JOINT_CIF_YN
     */
    public String getJOINT_CIF_YN() {
        return JOINT_CIF_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.JOINT_CIF_YN
     *
     * @param JOINT_CIF_YN the value for OC_USR.JOINT_CIF_YN
     */
    public void setJOINT_CIF_YN(String JOINT_CIF_YN) {
        this.JOINT_CIF_YN = JOINT_CIF_YN == null ? null : JOINT_CIF_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CTR_CAPTCHA_REQUESTED
     *
     * @return the value of OC_USR.CTR_CAPTCHA_REQUESTED
     */
    public BigDecimal getCTR_CAPTCHA_REQUESTED() {
        return CTR_CAPTCHA_REQUESTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CTR_CAPTCHA_REQUESTED
     *
     * @param CTR_CAPTCHA_REQUESTED the value for OC_USR.CTR_CAPTCHA_REQUESTED
     */
    public void setCTR_CAPTCHA_REQUESTED(BigDecimal CTR_CAPTCHA_REQUESTED) {
        this.CTR_CAPTCHA_REQUESTED = CTR_CAPTCHA_REQUESTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.OTP_TRS_ACTIVATION
     *
     * @return the value of OC_USR.OTP_TRS_ACTIVATION
     */
    public BigDecimal getOTP_TRS_ACTIVATION() {
        return OTP_TRS_ACTIVATION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.OTP_TRS_ACTIVATION
     *
     * @param OTP_TRS_ACTIVATION the value for OC_USR.OTP_TRS_ACTIVATION
     */
    public void setOTP_TRS_ACTIVATION(BigDecimal OTP_TRS_ACTIVATION) {
        this.OTP_TRS_ACTIVATION = OTP_TRS_ACTIVATION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.MOBILE_NUMBER
     *
     * @return the value of OC_USR.MOBILE_NUMBER
     */
    public String getMOBILE_NUMBER() {
        return MOBILE_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.MOBILE_NUMBER
     *
     * @param MOBILE_NUMBER the value for OC_USR.MOBILE_NUMBER
     */
    public void setMOBILE_NUMBER(String MOBILE_NUMBER) {
        this.MOBILE_NUMBER = MOBILE_NUMBER == null ? null : MOBILE_NUMBER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CANCEL_REASON
     *
     * @return the value of OC_USR.CANCEL_REASON
     */
    public String getCANCEL_REASON() {
        return CANCEL_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CANCEL_REASON
     *
     * @param CANCEL_REASON the value for OC_USR.CANCEL_REASON
     */
    public void setCANCEL_REASON(String CANCEL_REASON) {
        this.CANCEL_REASON = CANCEL_REASON == null ? null : CANCEL_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REACTIVATE_REASON
     *
     * @return the value of OC_USR.REACTIVATE_REASON
     */
    public String getREACTIVATE_REASON() {
        return REACTIVATE_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REACTIVATE_REASON
     *
     * @param REACTIVATE_REASON the value for OC_USR.REACTIVATE_REASON
     */
    public void setREACTIVATE_REASON(String REACTIVATE_REASON) {
        this.REACTIVATE_REASON = REACTIVATE_REASON == null ? null : REACTIVATE_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.OC_AUTH_MODIFED_BY
     *
     * @return the value of OC_USR.OC_AUTH_MODIFED_BY
     */
    public BigDecimal getOC_AUTH_MODIFED_BY() {
        return OC_AUTH_MODIFED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.OC_AUTH_MODIFED_BY
     *
     * @param OC_AUTH_MODIFED_BY the value for OC_USR.OC_AUTH_MODIFED_BY
     */
    public void setOC_AUTH_MODIFED_BY(BigDecimal OC_AUTH_MODIFED_BY) {
        this.OC_AUTH_MODIFED_BY = OC_AUTH_MODIFED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.AUTH_MODIFED_BY
     *
     * @return the value of OC_USR.AUTH_MODIFED_BY
     */
    public String getAUTH_MODIFED_BY() {
        return AUTH_MODIFED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.AUTH_MODIFED_BY
     *
     * @param AUTH_MODIFED_BY the value for OC_USR.AUTH_MODIFED_BY
     */
    public void setAUTH_MODIFED_BY(String AUTH_MODIFED_BY) {
        this.AUTH_MODIFED_BY = AUTH_MODIFED_BY == null ? null : AUTH_MODIFED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.AUTH_MODIFIED_DATE
     *
     * @return the value of OC_USR.AUTH_MODIFIED_DATE
     */
    public Date getAUTH_MODIFIED_DATE() {
        return AUTH_MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.AUTH_MODIFIED_DATE
     *
     * @param AUTH_MODIFIED_DATE the value for OC_USR.AUTH_MODIFIED_DATE
     */
    public void setAUTH_MODIFIED_DATE(Date AUTH_MODIFIED_DATE) {
        this.AUTH_MODIFIED_DATE = AUTH_MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.OC_AUTH_ACTIVATED_BY
     *
     * @return the value of OC_USR.OC_AUTH_ACTIVATED_BY
     */
    public BigDecimal getOC_AUTH_ACTIVATED_BY() {
        return OC_AUTH_ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.OC_AUTH_ACTIVATED_BY
     *
     * @param OC_AUTH_ACTIVATED_BY the value for OC_USR.OC_AUTH_ACTIVATED_BY
     */
    public void setOC_AUTH_ACTIVATED_BY(BigDecimal OC_AUTH_ACTIVATED_BY) {
        this.OC_AUTH_ACTIVATED_BY = OC_AUTH_ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.AUTH_ACTIVATED_BY
     *
     * @return the value of OC_USR.AUTH_ACTIVATED_BY
     */
    public String getAUTH_ACTIVATED_BY() {
        return AUTH_ACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.AUTH_ACTIVATED_BY
     *
     * @param AUTH_ACTIVATED_BY the value for OC_USR.AUTH_ACTIVATED_BY
     */
    public void setAUTH_ACTIVATED_BY(String AUTH_ACTIVATED_BY) {
        this.AUTH_ACTIVATED_BY = AUTH_ACTIVATED_BY == null ? null : AUTH_ACTIVATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.AUTH_ACTIVATED_DATE
     *
     * @return the value of OC_USR.AUTH_ACTIVATED_DATE
     */
    public Date getAUTH_ACTIVATED_DATE() {
        return AUTH_ACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.AUTH_ACTIVATED_DATE
     *
     * @param AUTH_ACTIVATED_DATE the value for OC_USR.AUTH_ACTIVATED_DATE
     */
    public void setAUTH_ACTIVATED_DATE(Date AUTH_ACTIVATED_DATE) {
        this.AUTH_ACTIVATED_DATE = AUTH_ACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CREATED_BY
     *
     * @return the value of OC_USR.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CREATED_BY
     *
     * @param CREATED_BY the value for OC_USR.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.CREATED_DATE
     *
     * @return the value of OC_USR.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.CREATED_DATE
     *
     * @param CREATED_DATE the value for OC_USR.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.MODIFIED_BY
     *
     * @return the value of OC_USR.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for OC_USR.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.MODIFIED_DATE
     *
     * @return the value of OC_USR.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for OC_USR.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.APPROVED_BY
     *
     * @return the value of OC_USR.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.APPROVED_BY
     *
     * @param APPROVED_BY the value for OC_USR.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.APPROVED_DATE
     *
     * @return the value of OC_USR.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for OC_USR.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.DELETED_BY
     *
     * @return the value of OC_USR.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.DELETED_BY
     *
     * @param DELETED_BY the value for OC_USR.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.DELETED_DATE
     *
     * @return the value of OC_USR.DELETED_DATE
     */
    public Date getDELETED_DATE() {
        return DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.DELETED_DATE
     *
     * @param DELETED_DATE the value for OC_USR.DELETED_DATE
     */
    public void setDELETED_DATE(Date DELETED_DATE) {
        this.DELETED_DATE = DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REJECTED_BY
     *
     * @return the value of OC_USR.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REJECTED_BY
     *
     * @param REJECTED_BY the value for OC_USR.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REJECTED_DATE
     *
     * @return the value of OC_USR.REJECTED_DATE
     */
    public Date getREJECTED_DATE() {
        return REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REJECTED_DATE
     *
     * @param REJECTED_DATE the value for OC_USR.REJECTED_DATE
     */
    public void setREJECTED_DATE(Date REJECTED_DATE) {
        this.REJECTED_DATE = REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REACTIVATED_BY
     *
     * @return the value of OC_USR.REACTIVATED_BY
     */
    public String getREACTIVATED_BY() {
        return REACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REACTIVATED_BY
     *
     * @param REACTIVATED_BY the value for OC_USR.REACTIVATED_BY
     */
    public void setREACTIVATED_BY(String REACTIVATED_BY) {
        this.REACTIVATED_BY = REACTIVATED_BY == null ? null : REACTIVATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REACTIVATED_DATE
     *
     * @return the value of OC_USR.REACTIVATED_DATE
     */
    public Date getREACTIVATED_DATE() {
        return REACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REACTIVATED_DATE
     *
     * @param REACTIVATED_DATE the value for OC_USR.REACTIVATED_DATE
     */
    public void setREACTIVATED_DATE(Date REACTIVATED_DATE) {
        this.REACTIVATED_DATE = REACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.DATE_UPDATED
     *
     * @return the value of OC_USR.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for OC_USR.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.BLOCK_REASON
     *
     * @return the value of OC_USR.BLOCK_REASON
     */
    public String getBLOCK_REASON() {
        return BLOCK_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.BLOCK_REASON
     *
     * @param BLOCK_REASON the value for OC_USR.BLOCK_REASON
     */
    public void setBLOCK_REASON(String BLOCK_REASON) {
        this.BLOCK_REASON = BLOCK_REASON == null ? null : BLOCK_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.SUSPENDED_REASON
     *
     * @return the value of OC_USR.SUSPENDED_REASON
     */
    public String getSUSPENDED_REASON() {
        return SUSPENDED_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.SUSPENDED_REASON
     *
     * @param SUSPENDED_REASON the value for OC_USR.SUSPENDED_REASON
     */
    public void setSUSPENDED_REASON(String SUSPENDED_REASON) {
        this.SUSPENDED_REASON = SUSPENDED_REASON == null ? null : SUSPENDED_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OC_USR.REF_CODE
     *
     * @return the value of OC_USR.REF_CODE
     */
    public BigDecimal getREF_CODE() {
        return REF_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OC_USR.REF_CODE
     *
     * @param REF_CODE the value for OC_USR.REF_CODE
     */
    public void setREF_CODE(BigDecimal REF_CODE) {
        this.REF_CODE = REF_CODE;
    }
}