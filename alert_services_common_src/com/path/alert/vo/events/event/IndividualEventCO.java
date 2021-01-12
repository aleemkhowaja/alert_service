package com.path.alert.vo.events.event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.path.dbmaps.vo.ALRT_EMAIL_TEMPLATEVOWithBLOBs;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_BATCH_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_INTRNLVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODE_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_OL_DATA_TRANSVO;
import com.path.dbmaps.vo.ALRT_EVT_OMNI_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_PARAMSETVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_EVT_REPORT_ATTACHVO;
import com.path.dbmaps.vo.ALRT_FIXED_EVT_PARAM_CONDVO;
import com.path.dbmaps.vo.ALRT_REPORT_QUERYVO;
import com.path.dbmaps.vo.ALRT_REPORT_QUERY_ARGVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_TAGSVO;
import com.path.dbmaps.vo.ALRT_TAGS_DEFVO;
import com.path.dbmaps.vo.IRP_REP_ARGUMENTSVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.reporting.IRP_AD_HOC_QUERYCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_QUERY_ARG_MAPPINGVO;

@SuppressWarnings("serial")
public class IndividualEventCO extends BaseVO
{

    private ALRT_EVTVO alrtEvtVO = new ALRT_EVTVO();
    private ALRT_TAGSVO alrtTagsVO = new ALRT_TAGSVO();
    private ALRT_EVT_GRPVO alrtEvtGrpVO = new ALRT_EVT_GRPVO();
    private ALRT_FIXED_EVT_PARAM_CONDVO alrt_FIXED_EVT_PARAM_CONDVO = new ALRT_FIXED_EVT_PARAM_CONDVO();
    private ALRT_EVT_PARAMSETVO alrtEvtParamSetVO = new ALRT_EVT_PARAMSETVO();
    private ALRT_SUB_EVTVO alrtSubEvtVO = new ALRT_SUB_EVTVO();
    private ALRT_EVT_PKGVOKey alrtEvtPkgVO = new ALRT_EVT_PKGVOKey();

    private ALRT_REPORT_QUERYVO alrt_REPORT_QUERYVO = new ALRT_REPORT_QUERYVO();
    private ALRT_REPORT_QUERY_ARGVO alrt_REPORT_QUERY_ARGVO = new ALRT_REPORT_QUERY_ARGVO();

    private IRP_AD_HOC_REPORTCO irp_AD_HOC_REPORTCO = new IRP_AD_HOC_REPORTCO();
    private IRP_REP_ARGUMENTSVO rep_ARGUMENTSVO = new IRP_REP_ARGUMENTSVO();
    private IRP_QUERY_ARG_MAPPINGVO query_ARG_MAPPINGVO = new IRP_QUERY_ARG_MAPPINGVO();

    /*
     * private ALRT_SUB_DETVO alrtSubDetVO = new ALRT_SUB_DETVO(); private CIFVO
     * cifVO = new CIFVO(); private RIFCTTVO rifCttVO = new RIFCTTVO(); private
     * USRVO usrVO = new USRVO(); private AMFVO amfVO = new AMFVO(); private
     * AMF_ADDRESSVO amfAddressVO = new AMF_ADDRESSVO(); private String
     * statusDesc; private String subscriberType; private String addRef;
     */
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String appName;
    private String progRef;
    private String statusDesc;
    private String briefDescEng;
    private String briefDescEng1;
    private String briefDescEng2;
    private String messagebody;
    private String hr;
    private String hr1;
    private String times;
    private String invalidfixedevtid;
    private String isYesNoMessage;
    private String isYesNoSuspendMessage;
    private String ivCrud;
    private String yesNo;
    private BigDecimal isReadOnlyDet;
    private boolean checkFlag;
    private BigDecimal evtID;
    private BigDecimal pkgID;
    private String relType;
    private String Changed;
    private String briefDescEngBranch;
    private ALRT_EVT_OL_DATA_TRANSVO otherLanguagesVO = new ALRT_EVT_OL_DATA_TRANSVO();
    private String userID, batchTypeQueryCol;
    private Date runningDate;
    private String JsonOtherLangArray, jsonMultiselectArray, JsonOtherLangBodyArray;
    private BigDecimal oldFixedEvent, langLength;
    private ALRT_EVT_OMNI_MODEVO alrtEvtOmniModeVO = new ALRT_EVT_OMNI_MODEVO();
    private SYS_PARAM_LOV_TRANSVO sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
    private ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO = new ALRT_EMAIL_TEMPLATEVOWithBLOBs();
    private List<IndFixedParamListCO> paramList = new ArrayList<IndFixedParamListCO>();
    private List<AlrtTagsCO> alrtTagsCOList = new ArrayList<AlrtTagsCO>();

    // new requirments

    private IRP_AD_HOC_QUERYCO irp_AD_HOC_QUERYCO;

    private ALRT_EVT_COMM_MODEVO email_EVT_COMM_MODEVO;
    private ALRT_EVT_COMM_MODEVO sms_EVT_COMM_MODEVO;
    private ALRT_EVT_COMM_MODEVO omniInbox_EVT_COMM_MODEVO;

    private ALRT_EVT_COMM_MODEVO email_Report_EVT_COMM_MODEVO;
    private ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO;

    private ALRT_EVT_OL_DATA_TRANSVO email_EVT_OL_DATA_TRANSVO;
    private ALRT_EVT_OL_DATA_TRANSVO sms_EVT_OL_DATA_TRANSVO;
    private ALRT_EVT_OL_DATA_TRANSVO omniInbox_EVT_OL_DATA_TRANSVO;

    private ALRT_EVT_REPORT_ATTACHVO emailALRT_EVT_REPORT_ATTACHVO;
    private ALRT_EVT_REPORT_ATTACHVO smsALRT_EVT_REPORT_ATTACHVO;
    private ALRT_EVT_REPORT_ATTACHVO omniInboxALRT_EVT_REPORT_ATTACHVO;

    private ALRT_TAGS_DEFVO alrt_TAGS_DEFVO;

    private String batchActivate;
    private String emailActivate;
    private String smsActivate;
    private String omniInboxActivate;
    private String imalInternalAlrtActivate;

    private String emailLanguageCode;
    private String emailMessageSubject;
    private String batchMessageBody;
    private String emailMessageBody;

    private String smsLanguageCode;
    private String smsMessageSubject;
    private String smsMessageBody;

    private String omniInboxLanguageCode;
    private String omniInboxMessageSubject;
    private String omniInboxMessageBody;

    private BigDecimal batchQueryId;
    private BigDecimal emailQueryId;
    private BigDecimal smsQueryId;
    private BigDecimal omniInboxQueryId;

    private String tagDescription;

    private String eventDynamicBatchMessageDetailsTemp;
    private String eventStaticBatchOtherLanguageHidden;
    private String eventStaticBatchParamMappingGridDataHidden;

    private String eventDynamicEmailMessageDetailsTemp;
    private String eventStaticEmailOtherLanguageHidden;
    private String eventStaticEmailParamMappingGridDataHidden;

    private String eventDynamicSmsMessageDetailsTemp;
    private String eventStaticSmsOtherLanguageHidden;
    private String eventStaticSmsQueryParamMappingGridDataHidden;

    private String eventDynamicOmniInboxMessageDetailsTemp;
    private String eventStaticOmniInboxOtherLanguageHidden;
    private String eventStaticOmniInboxQueryParamMappingGridDataHidden;

    // private List<ALRT_EVT_COMM_MODEVO> alrt_EVT_COMM_MODE_ARG_MAPVOs = new
    // ArrayList<ALRT_EVT_COMM_MODEVO>();
    // eventStaticEmailParamMappingGridDataHidden
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allQueryMappingParameterList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allReportMappingParameterList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allSmsQueryMappingParameterList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allOmniInboxQueryMappingParameterList = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();

    // list of returns all languages message Data
    private List<ALRT_EVT_OL_DATA_TRANSVO> emailAlrt_EVT_OL_DATA_TRANSVOs = new ArrayList<ALRT_EVT_OL_DATA_TRANSVO>();
    private List<ALRT_EVT_OL_DATA_TRANSVO> smsAlrt_EVT_OL_DATA_TRANSVOs = new ArrayList<ALRT_EVT_OL_DATA_TRANSVO>();
    private List<ALRT_EVT_OL_DATA_TRANSVO> omniInboxAlrt_EVT_OL_DATA_TRANSVOs = new ArrayList<ALRT_EVT_OL_DATA_TRANSVO>();

    /**
     * Communication Mode Argument Mappings
     */
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> emailAlrt_EVT_COMM_MODE_ARG_MAPVOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> smsAlrt_EVT_COMM_MODE_ARG_MAPVOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> omniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    /**
     * Report Attachments and Details
     */
    private Map<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>> alrt_EVT_COMM_MODE_ARG_MAPVOs = new HashMap<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> individualEventSmsReportAttachmentCOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();
    private List<ALRT_EVT_COMM_MODE_ARG_MAPVO> individualEventOmniInboxReportAttachmentCOs = new ArrayList<ALRT_EVT_COMM_MODE_ARG_MAPVO>();

    private List<IndividualEventReportAttachmentCO> emailEventReportAttachmentCOs = new ArrayList<IndividualEventReportAttachmentCO>();
    private List<IndividualEventReportAttachmentCO> omniEventReportAttachmentCOs = new ArrayList<IndividualEventReportAttachmentCO>();

    private String batchReportParameterListJson;
    private String batchQueryParameterListJson;
    private String batchQueryColumnListJson;

    private BigDecimal[] emailReportArray;
    private String[] emailReportAttachementParameterArray;
    private String emailReportParameterListJson;
    private String emailQueryParameterListJson;
    private String emailQueryColumnListJson;

    private String batchQueryBriefDescription;
    private String batchReportBriefDescription;

    private String emailQueryBriefDescription;
    private String emailReportBriefDescription;
    private String emailReportAttachmentBriefDescription;

    private String smsReportParameterListJson;
    private String smsQueryParameterListJson;
    private String smsQueryColumnListJson;
    private String smsQueryBriefDescription;
    private String smsReportAttachmentBriefDescription;

    private BigDecimal[] omniReportArray;
    private String[] omniReportAttachementParameterArray;
    private String omniInboxReportParameterListJson;
    private String omniInboxQueryParameterListJson;
    private String omniInboxQueryColumnListJson;
    private String omniInboxQueryBriefDescription;
    private String omniInboxReportAttachmentBriefDescription;

    private String eventStaticBatchMessageARHidden;
    private String eventStaticBatchMessageENHidden;
    private String eventStaticBatchMessageFRHidden;
    private String eventStaticBatchMessageRUHidden;
    private String eventStaticBatchMessageTKHidden;
    private String eventStaticBatchMessageFAHidden;

    private String eventStaticEmailMessageARHidden;
    private String eventStaticEmailMessageENHidden;
    private String eventStaticEmailMessageFRHidden;
    private String eventStaticEmailMessageRUHidden;
    private String eventStaticEmailMessageTKHidden;
    private String eventStaticEmailMessageFAHidden;

    private String eventStaticSmsMessageARHidden;
    private String eventStaticSmsMessageENHidden;
    private String eventStaticSmsMessageFRHidden;
    private String eventStaticSmsMessageRUHidden;
    private String eventStaticSmsMessageTKHidden;
    private String eventStaticSmsMessageFAHidden;

    private String eventStaticOmniInboxMessageARHidden;
    private String eventStaticOmniInboxMessageENHidden;
    private String eventStaticOmniInboxMessageFRHidden;
    private String eventStaticOmniInboxMessageRUHidden;
    private String eventStaticOmniInboxMessageTKHidden;
    private String eventStaticOmniInboxMessageFAHidden;

    private String eventStatiBatchNewCustomTagsHidden;
    private String eventStatiEmailNewCustomTagsHidden;
    private String eventStaticSmsNewCustomTagsHidden;
    private String eventStaticOmniInboxNewCustomTagsHidden;

    private List<ALRT_TAGS_DEFVO> newEmailCustomTagList = new ArrayList<ALRT_TAGS_DEFVO>();
    private List<ALRT_TAGS_DEFVO> deleteEmailCustomTagList = new ArrayList<ALRT_TAGS_DEFVO>();
    private List<ALRT_TAGS_DEFVO> newSmsCustomTagList = new ArrayList<ALRT_TAGS_DEFVO>();
    private List<ALRT_EVT_BATCH_ARG_MAPVO> newBatchCustomTagList = new ArrayList<ALRT_EVT_BATCH_ARG_MAPVO>();
    private List<ALRT_TAGS_DEFVO> newOmniInboxCustomTagList = new ArrayList<ALRT_TAGS_DEFVO>();

    private String eventStaticBatchStaticReportAttachmentDataHidden;
    private String eventStaticEmailStaticReportAttachmentDataHidden;
    private String eventStaticSmsStaticReportAttachmentDataHidden;
    private String eventStaticOmniInboxStaticReportAttachmentDataHidden;

    private BigDecimal emailEventStaticReportAttachCount;
    private BigDecimal omniInboxEventStaticReportAttachCount;
    private String eventEmailRemovedReportAttachmentIds;
    private String eventOmniRemovedReportAttachmentIds;

    private BigDecimal fixedEventId;

    private String fixedParamList;

    private String result;

    private IndFixedParamListCO indFixedParamListCO;

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementMap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private ALRT_EVT_COMM_INTRNLVO alrt_EVT_COMM_INTRNLVO = new ALRT_EVT_COMM_INTRNLVO();
    
    private HashMap<String, Object> screenDisplaySeting = new HashMap<String, Object>();


    public ALRT_EMAIL_TEMPLATEVOWithBLOBs getEmailTemplateVO()
    {
	return emailTemplateVO;
    }

    public void setEmailTemplateVO(ALRT_EMAIL_TEMPLATEVOWithBLOBs emailTemplateVO)
    {
	this.emailTemplateVO = emailTemplateVO;
    }

    public BigDecimal getLangLength()
    {
	return langLength;
    }

    public void setLangLength(BigDecimal langLength)
    {
	this.langLength = langLength;
    }

    public String getJsonOtherLangBodyArray()
    {
	return JsonOtherLangBodyArray;
    }

    public void setJsonOtherLangBodyArray(String jsonOtherLangBodyArray)
    {
	JsonOtherLangBodyArray = jsonOtherLangBodyArray;
    }

    public SYS_PARAM_LOV_TRANSVO getSysParamLovVO()
    {
	return sysParamLovVO;
    }

    public void setSysParamLovVO(SYS_PARAM_LOV_TRANSVO sysParamLovVO)
    {
	this.sysParamLovVO = sysParamLovVO;
    }

    public ALRT_EVT_OMNI_MODEVO getAlrtEvtOmniModeVO()
    {
	return alrtEvtOmniModeVO;
    }

    public void setAlrtEvtOmniModeVO(ALRT_EVT_OMNI_MODEVO alrtEvtOmniModeVO)
    {
	this.alrtEvtOmniModeVO = alrtEvtOmniModeVO;
    }

    public String getJsonMultiselectArray()
    {
	return jsonMultiselectArray;
    }

    public void setJsonMultiselectArray(String jsonMultiselectArray)
    {
	this.jsonMultiselectArray = jsonMultiselectArray;
    }

    public BigDecimal getOldFixedEvent()
    {
	return oldFixedEvent;
    }

    public void setOldFixedEvent(BigDecimal oldFixedEvent)
    {
	this.oldFixedEvent = oldFixedEvent;
    }

    public String getJsonOtherLangArray()
    {
	return JsonOtherLangArray;
    }

    public void setJsonOtherLangArray(String jsonOtherLangArray)
    {
	JsonOtherLangArray = jsonOtherLangArray;
    }

    public String getUserID()
    {
	return userID;
    }

    public void setUserID(String userID)
    {
	this.userID = userID;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public ALRT_EVT_OL_DATA_TRANSVO getOtherLanguagesVO()
    {
	return otherLanguagesVO;
    }

    public void setOtherLanguagesVO(ALRT_EVT_OL_DATA_TRANSVO otherLanguagesVO)
    {
	this.otherLanguagesVO = otherLanguagesVO;
    }

    public String getBriefDescEngBranch()
    {
	return briefDescEngBranch;
    }

    public void setBriefDescEngBranch(String briefDescEngBranch)
    {
	this.briefDescEngBranch = briefDescEngBranch;
    }

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    /*
     * private String emailId; private String email; private String tel;
     */
    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public ALRT_EVTVO getAlrtEvtVO()
    {
	return alrtEvtVO;
    }

    public void setAlrtEvtVO(ALRT_EVTVO alrtEvtVO)
    {
	this.alrtEvtVO = alrtEvtVO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public String getBriefDescEng()
    {
	return briefDescEng;
    }

    public void setBriefDescEng(String briefDescEng)
    {
	this.briefDescEng = briefDescEng;
    }

    public String getMessagebody()
    {
	return messagebody;
    }

    public void setMessagebody(String messagebody)
    {
	this.messagebody = messagebody;
    }

    public String getBriefDescEng1()
    {
	return briefDescEng1;
    }

    public void setBriefDescEng1(String briefDescEng1)
    {
	this.briefDescEng1 = briefDescEng1;
    }

    public String getBriefDescEng2()
    {
	return briefDescEng2;
    }

    public void setBriefDescEng2(String briefDescEng2)
    {
	this.briefDescEng2 = briefDescEng2;
    }

    public String getHr()
    {
	return hr;
    }

    public void setHr(String hr)
    {
	this.hr = hr;
    }

    public String getHr1()
    {
	return hr1;
    }

    public void setHr1(String hr1)
    {
	this.hr1 = hr1;
    }

    public String getTimes()
    {
	return times;
    }

    public void setTimes(String times)
    {
	this.times = times;
    }

    public ALRT_TAGSVO getAlrtTagsVO()
    {
	return alrtTagsVO;
    }

    public void setAlrtTagsVO(ALRT_TAGSVO alrtTagsVO)
    {
	this.alrtTagsVO = alrtTagsVO;
    }

    public String getIsYesNoMessage()
    {
	return isYesNoMessage;
    }

    public void setIsYesNoMessage(String isYesNoMessage)
    {
	this.isYesNoMessage = isYesNoMessage;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public String getYesNo()
    {
	return yesNo;
    }

    public void setYesNo(String yesNo)
    {
	this.yesNo = yesNo;
    }

    public String getInvalidfixedevtid()
    {
	return invalidfixedevtid;
    }

    public void setInvalidfixedevtid(String invalidfixedevtid)
    {
	this.invalidfixedevtid = invalidfixedevtid;
    }

    public BigDecimal getIsReadOnlyDet()
    {
	return isReadOnlyDet;
    }

    public void setIsReadOnlyDet(BigDecimal isReadOnlyDet)
    {
	this.isReadOnlyDet = isReadOnlyDet;
    }

    public String getIsYesNoSuspendMessage()
    {
	return isYesNoSuspendMessage;
    }

    public void setIsYesNoSuspendMessage(String isYesNoSuspendMessage)
    {
	this.isYesNoSuspendMessage = isYesNoSuspendMessage;
    }

    public boolean isCheckFlag()
    {
	return checkFlag;
    }

    public void setCheckFlag(boolean checkFlag)
    {
	this.checkFlag = checkFlag;
    }

    public ALRT_EVT_GRPVO getAlrtEvtGrpVO()
    {
	return alrtEvtGrpVO;
    }

    public ALRT_FIXED_EVT_PARAM_CONDVO getAlrt_FIXED_EVT_PARAM_CONDVO()
    {
	return alrt_FIXED_EVT_PARAM_CONDVO;
    }

    public void setAlrt_FIXED_EVT_PARAM_CONDVO(ALRT_FIXED_EVT_PARAM_CONDVO alrt_FIXED_EVT_PARAM_CONDVO)
    {
	this.alrt_FIXED_EVT_PARAM_CONDVO = alrt_FIXED_EVT_PARAM_CONDVO;
    }

    public void setAlrtEvtGrpVO(ALRT_EVT_GRPVO alrtEvtGrpVO)
    {
	this.alrtEvtGrpVO = alrtEvtGrpVO;
    }

    public ALRT_EVT_PARAMSETVO getAlrtEvtParamSetVO()
    {
	return alrtEvtParamSetVO;
    }

    public void setAlrtEvtParamSetVO(ALRT_EVT_PARAMSETVO alrtEvtParamSetVO)
    {
	this.alrtEvtParamSetVO = alrtEvtParamSetVO;
    }

    public ALRT_SUB_EVTVO getAlrtSubEvtVO()
    {
	return alrtSubEvtVO;
    }

    public void setAlrtSubEvtVO(ALRT_SUB_EVTVO alrtSubEvtVO)
    {
	this.alrtSubEvtVO = alrtSubEvtVO;
    }

    public ALRT_EVT_PKGVOKey getAlrtEvtPkgVO()
    {
	return alrtEvtPkgVO;
    }

    public void setAlrtEvtPkgVO(ALRT_EVT_PKGVOKey alrtEvtPkgVO)
    {
	this.alrtEvtPkgVO = alrtEvtPkgVO;
    }

    public BigDecimal getEvtID()
    {
	return evtID;
    }

    public void setEvtID(BigDecimal evtID)
    {
	this.evtID = evtID;
    }

    public BigDecimal getPkgID()
    {
	return pkgID;
    }

    public void setPkgID(BigDecimal pkgID)
    {
	this.pkgID = pkgID;
    }

    public String getRelType()
    {
	return relType;
    }

    public void setRelType(String relType)
    {
	this.relType = relType;
    }

    public String getChanged()
    {
	return Changed;
    }

    public void setChanged(String changed)
    {
	Changed = changed;
    }

    public ALRT_REPORT_QUERYVO getAlrt_REPORT_QUERYVO()
    {
	return alrt_REPORT_QUERYVO;
    }

    public ALRT_REPORT_QUERY_ARGVO getAlrt_REPORT_QUERY_ARGVO()
    {
	return alrt_REPORT_QUERY_ARGVO;
    }

    public void setAlrt_REPORT_QUERYVO(ALRT_REPORT_QUERYVO alrt_REPORT_QUERYVO)
    {
	this.alrt_REPORT_QUERYVO = alrt_REPORT_QUERYVO;
    }

    public void setAlrt_REPORT_QUERY_ARGVO(ALRT_REPORT_QUERY_ARGVO alrt_REPORT_QUERY_ARGVO)
    {
	this.alrt_REPORT_QUERY_ARGVO = alrt_REPORT_QUERY_ARGVO;
    }

    public IRP_AD_HOC_REPORTCO getIrp_AD_HOC_REPORTCO()
    {
	return irp_AD_HOC_REPORTCO;
    }

    public void setIrp_AD_HOC_REPORTCO(IRP_AD_HOC_REPORTCO irp_AD_HOC_REPORTCO)
    {
	this.irp_AD_HOC_REPORTCO = irp_AD_HOC_REPORTCO;
    }

    public IRP_REP_ARGUMENTSVO getRep_ARGUMENTSVO()
    {
	return rep_ARGUMENTSVO;
    }

    public void setRep_ARGUMENTSVO(IRP_REP_ARGUMENTSVO rep_ARGUMENTSVO)
    {
	this.rep_ARGUMENTSVO = rep_ARGUMENTSVO;
    }

    public IRP_QUERY_ARG_MAPPINGVO getQuery_ARG_MAPPINGVO()
    {
	return query_ARG_MAPPINGVO;
    }

    public void setQuery_ARG_MAPPINGVO(IRP_QUERY_ARG_MAPPINGVO query_ARG_MAPPINGVO)
    {
	this.query_ARG_MAPPINGVO = query_ARG_MAPPINGVO;
    }

    public ALRT_EVT_COMM_MODEVO getEmail_EVT_COMM_MODEVO()
    {
	return email_EVT_COMM_MODEVO;
    }

    public ALRT_EVT_COMM_MODEVO getSms_EVT_COMM_MODEVO()
    {
	return sms_EVT_COMM_MODEVO;
    }

    public void setEmail_EVT_COMM_MODEVO(ALRT_EVT_COMM_MODEVO email_EVT_COMM_MODEVO)
    {
	this.email_EVT_COMM_MODEVO = email_EVT_COMM_MODEVO;
    }

    public void setSms_EVT_COMM_MODEVO(ALRT_EVT_COMM_MODEVO sms_EVT_COMM_MODEVO)
    {
	this.sms_EVT_COMM_MODEVO = sms_EVT_COMM_MODEVO;
    }

    public ALRT_EVT_COMM_MODE_ARG_MAPVO getAlrt_EVT_COMM_MODE_ARG_MAPVO()
    {
	return alrt_EVT_COMM_MODE_ARG_MAPVO;
    }

    public void setAlrt_EVT_COMM_MODE_ARG_MAPVO(ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO)
    {
	this.alrt_EVT_COMM_MODE_ARG_MAPVO = alrt_EVT_COMM_MODE_ARG_MAPVO;
    }

    public ALRT_EVT_OL_DATA_TRANSVO getEmail_EVT_OL_DATA_TRANSVO()
    {
	return email_EVT_OL_DATA_TRANSVO;
    }

    public ALRT_EVT_OL_DATA_TRANSVO getSms_EVT_OL_DATA_TRANSVO()
    {
	return sms_EVT_OL_DATA_TRANSVO;
    }

    public void setEmail_EVT_OL_DATA_TRANSVO(ALRT_EVT_OL_DATA_TRANSVO email_EVT_OL_DATA_TRANSVO)
    {
	this.email_EVT_OL_DATA_TRANSVO = email_EVT_OL_DATA_TRANSVO;
    }

    public void setSms_EVT_OL_DATA_TRANSVO(ALRT_EVT_OL_DATA_TRANSVO sms_EVT_OL_DATA_TRANSVO)
    {
	this.sms_EVT_OL_DATA_TRANSVO = sms_EVT_OL_DATA_TRANSVO;
    }

    public ALRT_TAGS_DEFVO getAlrt_TAGS_DEFVO()
    {
	return alrt_TAGS_DEFVO;
    }

    public void setAlrt_TAGS_DEFVO(ALRT_TAGS_DEFVO alrt_TAGS_DEFVO)
    {
	this.alrt_TAGS_DEFVO = alrt_TAGS_DEFVO;
    }

    public String getEmailActivate()
    {
	return emailActivate;
    }

    public String getSmsActivate()
    {
	return smsActivate;
    }

    public void setEmailActivate(String emailActivate)
    {
	this.emailActivate = emailActivate;
    }

    public void setSmsActivate(String smsActivate)
    {
	this.smsActivate = smsActivate;
    }

    public String getTagDescription()
    {
	return tagDescription;
    }

    public void setTagDescription(String tagDescription)
    {
	this.tagDescription = tagDescription;
    }

    public String getEventDynamicEmailMessageDetailsTemp()
    {
	return eventDynamicEmailMessageDetailsTemp;
    }

    public String getEventStaticEmailOtherLanguageHidden()
    {
	return eventStaticEmailOtherLanguageHidden;
    }

    public String getEventStaticEmailParamMappingGridDataHidden()
    {
	return eventStaticEmailParamMappingGridDataHidden;
    }

    public void setEventDynamicEmailMessageDetailsTemp(String eventDynamicEmailMessageDetailsTemp)
    {
	this.eventDynamicEmailMessageDetailsTemp = eventDynamicEmailMessageDetailsTemp;
    }

    public void setEventStaticEmailOtherLanguageHidden(String eventStaticEmailOtherLanguageHidden)
    {
	this.eventStaticEmailOtherLanguageHidden = eventStaticEmailOtherLanguageHidden;
    }

    public void setEventStaticEmailParamMappingGridDataHidden(String eventStaticEmailParamMappingGridDataHidden)
    {
	this.eventStaticEmailParamMappingGridDataHidden = eventStaticEmailParamMappingGridDataHidden;
    }

    public String getEmailLanguageCode()
    {
	return emailLanguageCode;
    }

    public String getEmailMessageSubject()
    {
	return emailMessageSubject;
    }

    public String getEmailMessageBody()
    {
	return emailMessageBody;
    }

    public String getSmsLanguageCode()
    {
	return smsLanguageCode;
    }

    public String getSmsMessageSubject()
    {
	return smsMessageSubject;
    }

    public String getSmsMessageBody()
    {
	return smsMessageBody;
    }

    public BigDecimal getEmailQueryId()
    {
	return emailQueryId;
    }

    public BigDecimal getSmsQueryId()
    {
	return smsQueryId;
    }

    public String getEventDynamicSmsMessageDetailsTemp()
    {
	return eventDynamicSmsMessageDetailsTemp;
    }

    public String getEventStaticSmsOtherLanguageHidden()
    {
	return eventStaticSmsOtherLanguageHidden;
    }

    public String getEventStaticSmsQueryParamMappingGridDataHidden()
    {
	return eventStaticSmsQueryParamMappingGridDataHidden;
    }

    public void setEmailLanguageCode(String emailLanguageCode)
    {
	this.emailLanguageCode = emailLanguageCode;
    }

    public void setEmailMessageSubject(String emailMessageSubject)
    {
	this.emailMessageSubject = emailMessageSubject;
    }

    public void setEmailMessageBody(String emailMessageBody)
    {
	this.emailMessageBody = emailMessageBody;
    }

    public void setSmsLanguageCode(String smsLanguageCode)
    {
	this.smsLanguageCode = smsLanguageCode;
    }

    public void setSmsMessageSubject(String smsMessageSubject)
    {
	this.smsMessageSubject = smsMessageSubject;
    }

    public void setSmsMessageBody(String smsMessageBody)
    {
	this.smsMessageBody = smsMessageBody;
    }

    public void setEmailQueryId(BigDecimal emailQueryId)
    {
	this.emailQueryId = emailQueryId;
    }

    public void setSmsQueryId(BigDecimal smsQueryId)
    {
	this.smsQueryId = smsQueryId;
    }

    public void setEventDynamicSmsMessageDetailsTemp(String eventDynamicSmsMessageDetailsTemp)
    {
	this.eventDynamicSmsMessageDetailsTemp = eventDynamicSmsMessageDetailsTemp;
    }

    public void setEventStaticSmsOtherLanguageHidden(String eventStaticSmsOtherLanguageHidden)
    {
	this.eventStaticSmsOtherLanguageHidden = eventStaticSmsOtherLanguageHidden;
    }

    public void setEventStaticSmsQueryParamMappingGridDataHidden(String eventStaticSmsQueryParamMappingGridDataHidden)
    {
	this.eventStaticSmsQueryParamMappingGridDataHidden = eventStaticSmsQueryParamMappingGridDataHidden;
    }

    public IRP_AD_HOC_QUERYCO getIrp_AD_HOC_QUERYCO()
    {
	return irp_AD_HOC_QUERYCO;
    }

    public void setIrp_AD_HOC_QUERYCO(IRP_AD_HOC_QUERYCO irp_AD_HOC_QUERYCO)
    {
	this.irp_AD_HOC_QUERYCO = irp_AD_HOC_QUERYCO;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getAllQueryMappingParameterList()
    {
	return allQueryMappingParameterList;
    }

    public void setAllQueryMappingParameterList(List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allQueryMappingParameterList)
    {
	this.allQueryMappingParameterList = allQueryMappingParameterList;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getAllReportMappingParameterList()
    {
	return allReportMappingParameterList;
    }

    public void setAllReportMappingParameterList(List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allReportMappingParameterList)
    {
	this.allReportMappingParameterList = allReportMappingParameterList;
    }

    public String getEmailQueryParameterListJson()
    {
	return emailQueryParameterListJson;
    }

    public String getEmailQueryColumnListJson()
    {
	return emailQueryColumnListJson;
    }

    public String getSmsQueryParameterListJson()
    {
	return smsQueryParameterListJson;
    }

    public String getSmsQueryColumnListJson()
    {
	return smsQueryColumnListJson;
    }

    public String getEmailReportParameterListJson()
    {
	return emailReportParameterListJson;
    }

    public void setEmailReportParameterListJson(String emailReportParameterListJson)
    {
	this.emailReportParameterListJson = emailReportParameterListJson;
    }

    public void setEmailQueryParameterListJson(String emailQueryParameterListJson)
    {
	this.emailQueryParameterListJson = emailQueryParameterListJson;
    }

    public void setEmailQueryColumnListJson(String emailQueryColumnListJson)
    {
	this.emailQueryColumnListJson = emailQueryColumnListJson;
    }

    public void setSmsQueryParameterListJson(String smsQueryParameterListJson)
    {
	this.smsQueryParameterListJson = smsQueryParameterListJson;
    }

    public void setSmsQueryColumnListJson(String smsQueryColumnListJson)
    {
	this.smsQueryColumnListJson = smsQueryColumnListJson;
    }

    /*
     * public List<ALRT_EVT_COMM_MODEVO> getAlrt_EVT_COMM_MODE_ARG_MAPVOs() {
     * return alrt_EVT_COMM_MODE_ARG_MAPVOs; }
     * 
     * public void setAlrt_EVT_COMM_MODE_ARG_MAPVOs(List<ALRT_EVT_COMM_MODEVO>
     * alrt_EVT_COMM_MODE_ARG_MAPVOs) { this.alrt_EVT_COMM_MODE_ARG_MAPVOs =
     * alrt_EVT_COMM_MODE_ARG_MAPVOs; }
     */

    public ALRT_EVT_COMM_MODEVO getEmail_Report_EVT_COMM_MODEVO()
    {
	return email_Report_EVT_COMM_MODEVO;
    }

    public void setEmail_Report_EVT_COMM_MODEVO(ALRT_EVT_COMM_MODEVO email_Report_EVT_COMM_MODEVO)
    {
	this.email_Report_EVT_COMM_MODEVO = email_Report_EVT_COMM_MODEVO;
    }

    public String getEmailQueryBriefDescription()
    {
	return emailQueryBriefDescription;
    }

    public String getSmsQueryBriefDescription()
    {
	return smsQueryBriefDescription;
    }

    public String getEmailReportBriefDescription()
    {
	return emailReportBriefDescription;
    }

    public void setEmailQueryBriefDescription(String emailQueryBriefDescription)
    {
	this.emailQueryBriefDescription = emailQueryBriefDescription;
    }

    public void setSmsQueryBriefDescription(String smsQueryBriefDescription)
    {
	this.smsQueryBriefDescription = smsQueryBriefDescription;
    }

    public void setEmailReportBriefDescription(String emailReportBriefDescription)
    {
	this.emailReportBriefDescription = emailReportBriefDescription;
    }

    public String getEventStaticEmailMessageARHidden()
    {
	return eventStaticEmailMessageARHidden;
    }

    public String getEventStaticEmailMessageENHidden()
    {
	return eventStaticEmailMessageENHidden;
    }

    public String getEventStaticEmailMessageFRHidden()
    {
	return eventStaticEmailMessageFRHidden;
    }

    public String getEventStaticEmailMessageRUHidden()
    {
	return eventStaticEmailMessageRUHidden;
    }

    public String getEventStaticEmailMessageTKHidden()
    {
	return eventStaticEmailMessageTKHidden;
    }

    public String getEventStaticSmsMessageARHidden()
    {
	return eventStaticSmsMessageARHidden;
    }

    public String getEventStaticSmsMessageENHidden()
    {
	return eventStaticSmsMessageENHidden;
    }

    public String getEventStaticSmsMessageFRHidden()
    {
	return eventStaticSmsMessageFRHidden;
    }

    public String getEventStaticSmsMessageRUHidden()
    {
	return eventStaticSmsMessageRUHidden;
    }

    public String getEventStaticSmsMessageTKHidden()
    {
	return eventStaticSmsMessageTKHidden;
    }

    public String getEventStaticEmailMessageFAHidden()
    {
	return eventStaticEmailMessageFAHidden;
    }

    public String getEventStaticSmsMessageFAHidden()
    {
	return eventStaticSmsMessageFAHidden;
    }

    public void setEventStaticEmailMessageFAHidden(String eventStaticEmailMessageFAHidden)
    {
	this.eventStaticEmailMessageFAHidden = eventStaticEmailMessageFAHidden;
    }

    public void setEventStaticSmsMessageFAHidden(String eventStaticSmsMessageFAHidden)
    {
	this.eventStaticSmsMessageFAHidden = eventStaticSmsMessageFAHidden;
    }

    public void setEventStaticEmailMessageARHidden(String eventStaticEmailMessageARHidden)
    {
	this.eventStaticEmailMessageARHidden = eventStaticEmailMessageARHidden;
    }

    public void setEventStaticEmailMessageENHidden(String eventStaticEmailMessageENHidden)
    {
	this.eventStaticEmailMessageENHidden = eventStaticEmailMessageENHidden;
    }

    public void setEventStaticEmailMessageFRHidden(String eventStaticEmailMessageFRHidden)
    {
	this.eventStaticEmailMessageFRHidden = eventStaticEmailMessageFRHidden;
    }

    public void setEventStaticEmailMessageRUHidden(String eventStaticEmailMessageRUHidden)
    {
	this.eventStaticEmailMessageRUHidden = eventStaticEmailMessageRUHidden;
    }

    public void setEventStaticEmailMessageTKHidden(String eventStaticEmailMessageTKHidden)
    {
	this.eventStaticEmailMessageTKHidden = eventStaticEmailMessageTKHidden;
    }

    public void setEventStaticSmsMessageARHidden(String eventStaticSmsMessageARHidden)
    {
	this.eventStaticSmsMessageARHidden = eventStaticSmsMessageARHidden;
    }

    public void setEventStaticSmsMessageENHidden(String eventStaticSmsMessageENHidden)
    {
	this.eventStaticSmsMessageENHidden = eventStaticSmsMessageENHidden;
    }

    public void setEventStaticSmsMessageFRHidden(String eventStaticSmsMessageFRHidden)
    {
	this.eventStaticSmsMessageFRHidden = eventStaticSmsMessageFRHidden;
    }

    public void setEventStaticSmsMessageRUHidden(String eventStaticSmsMessageRUHidden)
    {
	this.eventStaticSmsMessageRUHidden = eventStaticSmsMessageRUHidden;
    }

    public void setEventStaticSmsMessageTKHidden(String eventStaticSmsMessageTKHidden)
    {
	this.eventStaticSmsMessageTKHidden = eventStaticSmsMessageTKHidden;
    }

    public List<ALRT_EVT_OL_DATA_TRANSVO> getEmailAlrt_EVT_OL_DATA_TRANSVOs()
    {
	return emailAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public void setEmailAlrt_EVT_OL_DATA_TRANSVOs(List<ALRT_EVT_OL_DATA_TRANSVO> emailAlrt_EVT_OL_DATA_TRANSVOs)
    {
	this.emailAlrt_EVT_OL_DATA_TRANSVOs = emailAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public List<ALRT_EVT_OL_DATA_TRANSVO> getSmsAlrt_EVT_OL_DATA_TRANSVOs()
    {
	return smsAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public void setSmsAlrt_EVT_OL_DATA_TRANSVOs(List<ALRT_EVT_OL_DATA_TRANSVO> smsAlrt_EVT_OL_DATA_TRANSVOs)
    {
	this.smsAlrt_EVT_OL_DATA_TRANSVOs = smsAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getEmailAlrt_EVT_COMM_MODE_ARG_MAPVOs()
    {
	return emailAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getSmsAlrt_EVT_COMM_MODE_ARG_MAPVOs()
    {
	return smsAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public void setEmailAlrt_EVT_COMM_MODE_ARG_MAPVOs(
	    List<ALRT_EVT_COMM_MODE_ARG_MAPVO> emailAlrt_EVT_COMM_MODE_ARG_MAPVOs)
    {
	this.emailAlrt_EVT_COMM_MODE_ARG_MAPVOs = emailAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public void setSmsAlrt_EVT_COMM_MODE_ARG_MAPVOs(List<ALRT_EVT_COMM_MODE_ARG_MAPVO> smsAlrt_EVT_COMM_MODE_ARG_MAPVOs)
    {
	this.smsAlrt_EVT_COMM_MODE_ARG_MAPVOs = smsAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public String getEventStatiEmailNewCustomTagsHidden()
    {
	return eventStatiEmailNewCustomTagsHidden;
    }

    public String getEventStaticSmsNewCustomTagsHidden()
    {
	return eventStaticSmsNewCustomTagsHidden;
    }

    public void setEventStatiEmailNewCustomTagsHidden(String eventStatiEmailNewCustomTagsHidden)
    {
	this.eventStatiEmailNewCustomTagsHidden = eventStatiEmailNewCustomTagsHidden;
    }

    public void setEventStaticSmsNewCustomTagsHidden(String eventStaticSmsNewCustomTagsHidden)
    {
	this.eventStaticSmsNewCustomTagsHidden = eventStaticSmsNewCustomTagsHidden;
    }

    public List<ALRT_TAGS_DEFVO> getNewEmailCustomTagList()
    {
	return newEmailCustomTagList;
    }

    public List<ALRT_TAGS_DEFVO> getNewSmsCustomTagList()
    {
	return newSmsCustomTagList;
    }

    public void setNewEmailCustomTagList(List<ALRT_TAGS_DEFVO> newEmailCustomTagList)
    {
	this.newEmailCustomTagList = newEmailCustomTagList;
    }

    public void setNewSmsCustomTagList(List<ALRT_TAGS_DEFVO> newSmsCustomTagList)
    {
	this.newSmsCustomTagList = newSmsCustomTagList;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getAllSmsQueryMappingParameterList()
    {
	return allSmsQueryMappingParameterList;
    }

    public void setAllSmsQueryMappingParameterList(List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allSmsQueryMappingParameterList)
    {
	this.allSmsQueryMappingParameterList = allSmsQueryMappingParameterList;
    }

    public String getEventStaticEmailStaticReportAttachmentDataHidden()
    {
	return eventStaticEmailStaticReportAttachmentDataHidden;
    }

    public String getEventStaticSmsStaticReportAttachmentDataHidden()
    {
	return eventStaticSmsStaticReportAttachmentDataHidden;
    }

    public Map<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>> getAlrt_EVT_COMM_MODE_ARG_MAPVOs()
    {
	return alrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public void setAlrt_EVT_COMM_MODE_ARG_MAPVOs(
	    Map<String, List<ALRT_EVT_COMM_MODE_ARG_MAPVO>> alrt_EVT_COMM_MODE_ARG_MAPVOs)
    {
	this.alrt_EVT_COMM_MODE_ARG_MAPVOs = alrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getIndividualEventSmsReportAttachmentCOs()
    {
	return individualEventSmsReportAttachmentCOs;
    }

    public void setIndividualEventSmsReportAttachmentCOs(
	    List<ALRT_EVT_COMM_MODE_ARG_MAPVO> individualEventSmsReportAttachmentCOs)
    {
	this.individualEventSmsReportAttachmentCOs = individualEventSmsReportAttachmentCOs;
    }

    public void setEventStaticEmailStaticReportAttachmentDataHidden(
	    String eventStaticEmailStaticReportAttachmentDataHidden)
    {
	this.eventStaticEmailStaticReportAttachmentDataHidden = eventStaticEmailStaticReportAttachmentDataHidden;
    }

    public void setEventStaticSmsStaticReportAttachmentDataHidden(String eventStaticSmsStaticReportAttachmentDataHidden)
    {
	this.eventStaticSmsStaticReportAttachmentDataHidden = eventStaticSmsStaticReportAttachmentDataHidden;
    }

    public String getBatchActivate()
    {
	return batchActivate;
    }

    public void setBatchActivate(String batchActivate)
    {
	this.batchActivate = batchActivate;
    }

    public String getBatchQueryBriefDescription()
    {
	return batchQueryBriefDescription;
    }

    public void setBatchQueryBriefDescription(String batchQueryBriefDescription)
    {
	this.batchQueryBriefDescription = batchQueryBriefDescription;
    }

    public String getBatchMessageBody()
    {
	return batchMessageBody;
    }

    public void setBatchMessageBody(String batchMessageBody)
    {
	this.batchMessageBody = batchMessageBody;
    }

    public BigDecimal getBatchQueryId()
    {
	return batchQueryId;
    }

    public void setBatchQueryId(BigDecimal batchQueryId)
    {
	this.batchQueryId = batchQueryId;
    }

    public String getEventDynamicBatchMessageDetailsTemp()
    {
	return eventDynamicBatchMessageDetailsTemp;
    }

    public void setEventDynamicBatchMessageDetailsTemp(String eventDynamicBatchMessageDetailsTemp)
    {
	this.eventDynamicBatchMessageDetailsTemp = eventDynamicBatchMessageDetailsTemp;
    }

    public String getEventStaticBatchOtherLanguageHidden()
    {
	return eventStaticBatchOtherLanguageHidden;
    }

    public void setEventStaticBatchOtherLanguageHidden(String eventStaticBatchOtherLanguageHidden)
    {
	this.eventStaticBatchOtherLanguageHidden = eventStaticBatchOtherLanguageHidden;
    }

    public String getEventStaticBatchParamMappingGridDataHidden()
    {
	return eventStaticBatchParamMappingGridDataHidden;
    }

    public void setEventStaticBatchParamMappingGridDataHidden(String eventStaticBatchParamMappingGridDataHidden)
    {
	this.eventStaticBatchParamMappingGridDataHidden = eventStaticBatchParamMappingGridDataHidden;
    }

    public String getBatchReportParameterListJson()
    {
	return batchReportParameterListJson;
    }

    public void setBatchReportParameterListJson(String batchReportParameterListJson)
    {
	this.batchReportParameterListJson = batchReportParameterListJson;
    }

    public String getBatchQueryParameterListJson()
    {
	return batchQueryParameterListJson;
    }

    public void setBatchQueryParameterListJson(String batchQueryParameterListJson)
    {
	this.batchQueryParameterListJson = batchQueryParameterListJson;
    }

    public String getBatchQueryColumnListJson()
    {
	return batchQueryColumnListJson;
    }

    public void setBatchQueryColumnListJson(String batchQueryColumnListJson)
    {
	this.batchQueryColumnListJson = batchQueryColumnListJson;
    }

    public String getBatchReportBriefDescription()
    {
	return batchReportBriefDescription;
    }

    public void setBatchReportBriefDescription(String batchReportBriefDescription)
    {
	this.batchReportBriefDescription = batchReportBriefDescription;
    }

    public String getEventStaticBatchMessageARHidden()
    {
	return eventStaticBatchMessageARHidden;
    }

    public void setEventStaticBatchMessageARHidden(String eventStaticBatchMessageARHidden)
    {
	this.eventStaticBatchMessageARHidden = eventStaticBatchMessageARHidden;
    }

    public String getEventStaticBatchMessageENHidden()
    {
	return eventStaticBatchMessageENHidden;
    }

    public void setEventStaticBatchMessageENHidden(String eventStaticBatchMessageENHidden)
    {
	this.eventStaticBatchMessageENHidden = eventStaticBatchMessageENHidden;
    }

    public String getEventStaticBatchMessageFRHidden()
    {
	return eventStaticBatchMessageFRHidden;
    }

    public void setEventStaticBatchMessageFRHidden(String eventStaticBatchMessageFRHidden)
    {
	this.eventStaticBatchMessageFRHidden = eventStaticBatchMessageFRHidden;
    }

    public String getEventStaticBatchMessageRUHidden()
    {
	return eventStaticBatchMessageRUHidden;
    }

    public void setEventStaticBatchMessageRUHidden(String eventStaticBatchMessageRUHidden)
    {
	this.eventStaticBatchMessageRUHidden = eventStaticBatchMessageRUHidden;
    }

    public String getEventStaticBatchMessageTKHidden()
    {
	return eventStaticBatchMessageTKHidden;
    }

    public void setEventStaticBatchMessageTKHidden(String eventStaticBatchMessageTKHidden)
    {
	this.eventStaticBatchMessageTKHidden = eventStaticBatchMessageTKHidden;
    }

    public String getEventStaticBatchMessageFAHidden()
    {
	return eventStaticBatchMessageFAHidden;
    }

    public void setEventStaticBatchMessageFAHidden(String eventStaticBatchMessageFAHidden)
    {
	this.eventStaticBatchMessageFAHidden = eventStaticBatchMessageFAHidden;
    }

    public String getEventStatiBatchNewCustomTagsHidden()
    {
	return eventStatiBatchNewCustomTagsHidden;
    }

    public void setEventStatiBatchNewCustomTagsHidden(String eventStatiBatchNewCustomTagsHidden)
    {
	this.eventStatiBatchNewCustomTagsHidden = eventStatiBatchNewCustomTagsHidden;
    }

    public String getEventStaticBatchStaticReportAttachmentDataHidden()
    {
	return eventStaticBatchStaticReportAttachmentDataHidden;
    }

    public void setEventStaticBatchStaticReportAttachmentDataHidden(
	    String eventStaticBatchStaticReportAttachmentDataHidden)
    {
	this.eventStaticBatchStaticReportAttachmentDataHidden = eventStaticBatchStaticReportAttachmentDataHidden;
    }

    public List<ALRT_EVT_BATCH_ARG_MAPVO> getNewBatchCustomTagList()
    {
	return newBatchCustomTagList;
    }

    public void setNewBatchCustomTagList(List<ALRT_EVT_BATCH_ARG_MAPVO> newBatchCustomTagList)
    {
	this.newBatchCustomTagList = newBatchCustomTagList;
    }

    public String getBatchTypeQueryCol()
    {
	return batchTypeQueryCol;
    }

    public void setBatchTypeQueryCol(String batchTypeQueryCol)
    {
	this.batchTypeQueryCol = batchTypeQueryCol;
    }

    public List<IndFixedParamListCO> getParamList()
    {
	return paramList;
    }

    public void setParamList(List<IndFixedParamListCO> paramList)
    {
	this.paramList = paramList;
    }

    public String getEventStaticOmniInboxMessageARHidden()
    {
	return eventStaticOmniInboxMessageARHidden;
    }

    public String getEventStaticOmniInboxMessageENHidden()
    {
	return eventStaticOmniInboxMessageENHidden;
    }

    public String getEventStaticOmniInboxMessageFRHidden()
    {
	return eventStaticOmniInboxMessageFRHidden;
    }

    public String getEventStaticOmniInboxMessageRUHidden()
    {
	return eventStaticOmniInboxMessageRUHidden;
    }

    public String getEventStaticOmniInboxMessageTKHidden()
    {
	return eventStaticOmniInboxMessageTKHidden;
    }

    public String getEventStaticOmniInboxMessageFAHidden()
    {
	return eventStaticOmniInboxMessageFAHidden;
    }

    public void setEventStaticOmniInboxMessageARHidden(String eventStaticOmniInboxMessageARHidden)
    {
	this.eventStaticOmniInboxMessageARHidden = eventStaticOmniInboxMessageARHidden;
    }

    public void setEventStaticOmniInboxMessageENHidden(String eventStaticOmniInboxMessageENHidden)
    {
	this.eventStaticOmniInboxMessageENHidden = eventStaticOmniInboxMessageENHidden;
    }

    public void setEventStaticOmniInboxMessageFRHidden(String eventStaticOmniInboxMessageFRHidden)
    {
	this.eventStaticOmniInboxMessageFRHidden = eventStaticOmniInboxMessageFRHidden;
    }

    public void setEventStaticOmniInboxMessageRUHidden(String eventStaticOmniInboxMessageRUHidden)
    {
	this.eventStaticOmniInboxMessageRUHidden = eventStaticOmniInboxMessageRUHidden;
    }

    public void setEventStaticOmniInboxMessageTKHidden(String eventStaticOmniInboxMessageTKHidden)
    {
	this.eventStaticOmniInboxMessageTKHidden = eventStaticOmniInboxMessageTKHidden;
    }

    public void setEventStaticOmniInboxMessageFAHidden(String eventStaticOmniInboxMessageFAHidden)
    {
	this.eventStaticOmniInboxMessageFAHidden = eventStaticOmniInboxMessageFAHidden;
    }

    public ALRT_EVT_COMM_MODEVO getOmniInbox_EVT_COMM_MODEVO()
    {
	return omniInbox_EVT_COMM_MODEVO;
    }

    public void setOmniInbox_EVT_COMM_MODEVO(ALRT_EVT_COMM_MODEVO omniInbox_EVT_COMM_MODEVO)
    {
	this.omniInbox_EVT_COMM_MODEVO = omniInbox_EVT_COMM_MODEVO;
    }

    public ALRT_EVT_OL_DATA_TRANSVO getOmniInbox_EVT_OL_DATA_TRANSVO()
    {
	return omniInbox_EVT_OL_DATA_TRANSVO;
    }

    public String getOmniInboxActivate()
    {
	return omniInboxActivate;
    }

    public String getOmniInboxLanguageCode()
    {
	return omniInboxLanguageCode;
    }

    public String getOmniInboxMessageSubject()
    {
	return omniInboxMessageSubject;
    }

    public String getOmniInboxMessageBody()
    {
	return omniInboxMessageBody;
    }

    public BigDecimal getOmniInboxQueryId()
    {
	return omniInboxQueryId;
    }

    public String getEventDynamicOmniInboxMessageDetailsTemp()
    {
	return eventDynamicOmniInboxMessageDetailsTemp;
    }

    public String getEventStaticOmniInboxOtherLanguageHidden()
    {
	return eventStaticOmniInboxOtherLanguageHidden;
    }

    public String getEventStaticOmniInboxQueryParamMappingGridDataHidden()
    {
	return eventStaticOmniInboxQueryParamMappingGridDataHidden;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getAllOmniInboxQueryMappingParameterList()
    {
	return allOmniInboxQueryMappingParameterList;
    }

    public List<ALRT_EVT_OL_DATA_TRANSVO> getOmniInboxAlrt_EVT_OL_DATA_TRANSVOs()
    {
	return omniInboxAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getOmniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs()
    {
	return omniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> getIndividualEventOmniInboxReportAttachmentCOs()
    {
	return individualEventOmniInboxReportAttachmentCOs;
    }

    public String getOmniInboxQueryParameterListJson()
    {
	return omniInboxQueryParameterListJson;
    }

    public String getOmniInboxQueryColumnListJson()
    {
	return omniInboxQueryColumnListJson;
    }

    public String getOmniInboxQueryBriefDescription()
    {
	return omniInboxQueryBriefDescription;
    }

    public List<ALRT_TAGS_DEFVO> getNewOmniInboxCustomTagList()
    {
	return newOmniInboxCustomTagList;
    }

    public String getEventStaticOmniInboxStaticReportAttachmentDataHidden()
    {
	return eventStaticOmniInboxStaticReportAttachmentDataHidden;
    }

    public void setOmniInbox_EVT_OL_DATA_TRANSVO(ALRT_EVT_OL_DATA_TRANSVO omniInbox_EVT_OL_DATA_TRANSVO)
    {
	this.omniInbox_EVT_OL_DATA_TRANSVO = omniInbox_EVT_OL_DATA_TRANSVO;
    }

    public void setOmniInboxActivate(String omniInboxActivate)
    {
	this.omniInboxActivate = omniInboxActivate;
    }

    public void setOmniInboxLanguageCode(String omniInboxLanguageCode)
    {
	this.omniInboxLanguageCode = omniInboxLanguageCode;
    }

    public void setOmniInboxMessageSubject(String omniInboxMessageSubject)
    {
	this.omniInboxMessageSubject = omniInboxMessageSubject;
    }

    public void setOmniInboxMessageBody(String omniInboxMessageBody)
    {
	this.omniInboxMessageBody = omniInboxMessageBody;
    }

    public void setOmniInboxQueryId(BigDecimal omniInboxQueryId)
    {
	this.omniInboxQueryId = omniInboxQueryId;
    }

    public void setEventDynamicOmniInboxMessageDetailsTemp(String eventDynamicOmniInboxMessageDetailsTemp)
    {
	this.eventDynamicOmniInboxMessageDetailsTemp = eventDynamicOmniInboxMessageDetailsTemp;
    }

    public void setEventStaticOmniInboxOtherLanguageHidden(String eventStaticOmniInboxOtherLanguageHidden)
    {
	this.eventStaticOmniInboxOtherLanguageHidden = eventStaticOmniInboxOtherLanguageHidden;
    }

    public void setEventStaticOmniInboxQueryParamMappingGridDataHidden(
	    String eventStaticOmniInboxQueryParamMappingGridDataHidden)
    {
	this.eventStaticOmniInboxQueryParamMappingGridDataHidden = eventStaticOmniInboxQueryParamMappingGridDataHidden;
    }

    public void setAllOmniInboxQueryMappingParameterList(
	    List<ALRT_EVT_COMM_MODE_ARG_MAPVO> allOmniInboxQueryMappingParameterList)
    {
	this.allOmniInboxQueryMappingParameterList = allOmniInboxQueryMappingParameterList;
    }

    public void setOmniInboxAlrt_EVT_OL_DATA_TRANSVOs(List<ALRT_EVT_OL_DATA_TRANSVO> omniInboxAlrt_EVT_OL_DATA_TRANSVOs)
    {
	this.omniInboxAlrt_EVT_OL_DATA_TRANSVOs = omniInboxAlrt_EVT_OL_DATA_TRANSVOs;
    }

    public void setOmniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs(
	    List<ALRT_EVT_COMM_MODE_ARG_MAPVO> omniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs)
    {
	this.omniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs = omniInboxAlrt_EVT_COMM_MODE_ARG_MAPVOs;
    }

    public void setIndividualEventOmniInboxReportAttachmentCOs(
	    List<ALRT_EVT_COMM_MODE_ARG_MAPVO> individualEventOmniInboxReportAttachmentCOs)
    {
	this.individualEventOmniInboxReportAttachmentCOs = individualEventOmniInboxReportAttachmentCOs;
    }

    public void setOmniInboxQueryParameterListJson(String omniInboxQueryParameterListJson)
    {
	this.omniInboxQueryParameterListJson = omniInboxQueryParameterListJson;
    }

    public void setOmniInboxQueryColumnListJson(String omniInboxQueryColumnListJson)
    {
	this.omniInboxQueryColumnListJson = omniInboxQueryColumnListJson;
    }

    public void setOmniInboxQueryBriefDescription(String omniInboxQueryBriefDescription)
    {
	this.omniInboxQueryBriefDescription = omniInboxQueryBriefDescription;
    }

    public void setNewOmniInboxCustomTagList(List<ALRT_TAGS_DEFVO> newOmniInboxCustomTagList)
    {
	this.newOmniInboxCustomTagList = newOmniInboxCustomTagList;
    }

    public void setEventStaticOmniInboxStaticReportAttachmentDataHidden(
	    String eventStaticOmniInboxStaticReportAttachmentDataHidden)
    {
	this.eventStaticOmniInboxStaticReportAttachmentDataHidden = eventStaticOmniInboxStaticReportAttachmentDataHidden;
    }

    public String getEventStaticOmniInboxNewCustomTagsHidden()
    {
	return eventStaticOmniInboxNewCustomTagsHidden;
    }

    public void setEventStaticOmniInboxNewCustomTagsHidden(String eventStaticOmniInboxNewCustomTagsHidden)
    {
	this.eventStaticOmniInboxNewCustomTagsHidden = eventStaticOmniInboxNewCustomTagsHidden;
    }

    public ALRT_EVT_REPORT_ATTACHVO getEmailALRT_EVT_REPORT_ATTACHVO()
    {
	return emailALRT_EVT_REPORT_ATTACHVO;
    }

    public ALRT_EVT_REPORT_ATTACHVO getSmsALRT_EVT_REPORT_ATTACHVO()
    {
	return smsALRT_EVT_REPORT_ATTACHVO;
    }

    public ALRT_EVT_REPORT_ATTACHVO getOmniInboxALRT_EVT_REPORT_ATTACHVO()
    {
	return omniInboxALRT_EVT_REPORT_ATTACHVO;
    }

    public void setEmailALRT_EVT_REPORT_ATTACHVO(ALRT_EVT_REPORT_ATTACHVO emailALRT_EVT_REPORT_ATTACHVO)
    {
	this.emailALRT_EVT_REPORT_ATTACHVO = emailALRT_EVT_REPORT_ATTACHVO;
    }

    public void setSmsALRT_EVT_REPORT_ATTACHVO(ALRT_EVT_REPORT_ATTACHVO smsALRT_EVT_REPORT_ATTACHVO)
    {
	this.smsALRT_EVT_REPORT_ATTACHVO = smsALRT_EVT_REPORT_ATTACHVO;
    }

    public void setOmniInboxALRT_EVT_REPORT_ATTACHVO(ALRT_EVT_REPORT_ATTACHVO omniInboxALRT_EVT_REPORT_ATTACHVO)
    {
	this.omniInboxALRT_EVT_REPORT_ATTACHVO = omniInboxALRT_EVT_REPORT_ATTACHVO;
    }

    public String getSmsReportParameterListJson()
    {
	return smsReportParameterListJson;
    }

    public String getOmniInboxReportParameterListJson()
    {
	return omniInboxReportParameterListJson;
    }

    public void setSmsReportParameterListJson(String smsReportParameterListJson)
    {
	this.smsReportParameterListJson = smsReportParameterListJson;
    }

    public void setOmniInboxReportParameterListJson(String omniInboxReportParameterListJson)
    {
	this.omniInboxReportParameterListJson = omniInboxReportParameterListJson;
    }

    public String getEmailReportAttachmentBriefDescription()
    {
	return emailReportAttachmentBriefDescription;
    }

    public String getSmsReportAttachmentBriefDescription()
    {
	return smsReportAttachmentBriefDescription;
    }

    public String getOmniInboxReportAttachmentBriefDescription()
    {
	return omniInboxReportAttachmentBriefDescription;
    }

    public void setEmailReportAttachmentBriefDescription(String emailReportAttachmentBriefDescription)
    {
	this.emailReportAttachmentBriefDescription = emailReportAttachmentBriefDescription;
    }

    public void setSmsReportAttachmentBriefDescription(String smsReportAttachmentBriefDescription)
    {
	this.smsReportAttachmentBriefDescription = smsReportAttachmentBriefDescription;
    }

    public void setOmniInboxReportAttachmentBriefDescription(String omniInboxReportAttachmentBriefDescription)
    {
	this.omniInboxReportAttachmentBriefDescription = omniInboxReportAttachmentBriefDescription;
    }

    public List<AlrtTagsCO> getAlrtTagsCOList()
    {
	return alrtTagsCOList;
    }

    public void setAlrtTagsCOList(List<AlrtTagsCO> alrtTagsCOList)
    {
	this.alrtTagsCOList = alrtTagsCOList;
    }

    public BigDecimal getEmailEventStaticReportAttachCount()
    {
	return emailEventStaticReportAttachCount;
    }

    public void setEmailEventStaticReportAttachCount(BigDecimal emailEventStaticReportAttachCount)
    {
	this.emailEventStaticReportAttachCount = emailEventStaticReportAttachCount;
    }

    public String[] getEmailReportAttachementParameterArray()
    {
	return emailReportAttachementParameterArray;
    }

    public String[] getOmniReportAttachementParameterArray()
    {
	return omniReportAttachementParameterArray;
    }

    public void setEmailReportAttachementParameterArray(String[] emailReportAttachementParameterArray)
    {
	this.emailReportAttachementParameterArray = emailReportAttachementParameterArray;
    }

    public void setOmniReportAttachementParameterArray(String[] omniReportAttachementParameterArray)
    {
	this.omniReportAttachementParameterArray = omniReportAttachementParameterArray;
    }

    public BigDecimal[] getEmailReportArray()
    {
	return emailReportArray;
    }

    public BigDecimal[] getOmniReportArray()
    {
	return omniReportArray;
    }

    public void setEmailReportArray(BigDecimal[] emailReportArray)
    {
	this.emailReportArray = emailReportArray;
    }

    public void setOmniReportArray(BigDecimal[] omniReportArray)
    {
	this.omniReportArray = omniReportArray;
    }

    public List<IndividualEventReportAttachmentCO> getEmailEventReportAttachmentCOs()
    {
	return emailEventReportAttachmentCOs;
    }

    public void setEmailEventReportAttachmentCOs(List<IndividualEventReportAttachmentCO> emailEventReportAttachmentCOs)
    {
	this.emailEventReportAttachmentCOs = emailEventReportAttachmentCOs;
    }

    public List<IndividualEventReportAttachmentCO> getOmniEventReportAttachmentCOs()
    {
	return omniEventReportAttachmentCOs;
    }

    public void setOmniEventReportAttachmentCOs(List<IndividualEventReportAttachmentCO> omniEventReportAttachmentCOs)
    {
	this.omniEventReportAttachmentCOs = omniEventReportAttachmentCOs;
    }

    public String getEventEmailRemovedReportAttachmentIds()
    {
	return eventEmailRemovedReportAttachmentIds;
    }

    public void setEventEmailRemovedReportAttachmentIds(String eventEmailRemovedReportAttachmentIds)
    {
	this.eventEmailRemovedReportAttachmentIds = eventEmailRemovedReportAttachmentIds;
    }

    public String getEventOmniRemovedReportAttachmentIds()
    {
	return eventOmniRemovedReportAttachmentIds;
    }

    public void setEventOmniRemovedReportAttachmentIds(String eventOmniRemovedReportAttachmentIds)
    {
	this.eventOmniRemovedReportAttachmentIds = eventOmniRemovedReportAttachmentIds;
    }

    public BigDecimal getOmniInboxEventStaticReportAttachCount()
    {
	return omniInboxEventStaticReportAttachCount;
    }

    public void setOmniInboxEventStaticReportAttachCount(BigDecimal omniInboxEventStaticReportAttachCount)
    {
	this.omniInboxEventStaticReportAttachCount = omniInboxEventStaticReportAttachCount;
    }

    public String getFixedParamList()
    {
	return fixedParamList;
    }

    public void setFixedParamList(String fixedParamList)
    {
	this.fixedParamList = fixedParamList;
    }

    public BigDecimal getFixedEventId()
    {
	return fixedEventId;
    }

    public void setFixedEventId(BigDecimal fixedEventId)
    {
	this.fixedEventId = fixedEventId;
    }

    public List<ALRT_TAGS_DEFVO> getDeleteEmailCustomTagList()
    {
	return deleteEmailCustomTagList;
    }

    public void setDeleteEmailCustomTagList(List<ALRT_TAGS_DEFVO> deleteEmailCustomTagList)
    {
	this.deleteEmailCustomTagList = deleteEmailCustomTagList;
    }

    public IndFixedParamListCO getIndFixedParamListCO()
    {
	return indFixedParamListCO;
    }

    public void setIndFixedParamListCO(IndFixedParamListCO indFixedParamListCO)
    {
	this.indFixedParamListCO = indFixedParamListCO;
    }

    public String getResult()
    {
	return result;
    }

    public void setResult(String result)
    {
	this.result = result;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementMap()
    {
	return elementMap;
    }

    public void setElementMap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementMap)
    {
	this.elementMap = elementMap;
    }

    /**
     * @return the alrt_EVT_COMM_INTRNLVO
     */
    public ALRT_EVT_COMM_INTRNLVO getAlrt_EVT_COMM_INTRNLVO()
    {
        return alrt_EVT_COMM_INTRNLVO;
    }

    /**
     * @param alrt_EVT_COMM_INTRNLVO the alrt_EVT_COMM_INTRNLVO to set
     */
    public void setAlrt_EVT_COMM_INTRNLVO(ALRT_EVT_COMM_INTRNLVO alrt_EVT_COMM_INTRNLVO)
    {
        this.alrt_EVT_COMM_INTRNLVO = alrt_EVT_COMM_INTRNLVO;
    }

    /**
     * @return the imalInternalAlrtActivate
     */
    public String getImalInternalAlrtActivate()
    {
        return imalInternalAlrtActivate;
    }

    /**
     * @param imalInternalAlrtActivate the imalInternalAlrtActivate to set
     */
    public void setImalInternalAlrtActivate(String imalInternalAlrtActivate)
    {
        this.imalInternalAlrtActivate = imalInternalAlrtActivate;
    }

    /**
     * @return the screenDisplaySeting
     */
    public HashMap<String, Object> getScreenDisplaySeting()
    {
        return screenDisplaySeting;
    }

    /**
     * @param screenDisplaySeting the screenDisplaySeting to set
     */
    public void setScreenDisplaySeting(HashMap<String, Object> screenDisplaySeting)
    {
        this.screenDisplaySeting = screenDisplaySeting;
    }
    
}