package com.path.alert.bo.events.event;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.common.util.PathPropertyUtil;

public class IndividualEventConstant
{

    public static final BigDecimal EXPRESSION_CONDITIONS = BigDecimal.valueOf(502);
    public static final BigDecimal DATA_TYPE_LOV_TYPE = new BigDecimal(1409);
    public static final BigDecimal METHOD_BODY_BY_LOV_TYPE = new BigDecimal(1543);

    public static final BigDecimal EVENT_TYPE_LOV_TYPE = new BigDecimal(883);
    public static final BigDecimal SEND_TO_LOV_TYPE = new BigDecimal(1913);
    public static final BigDecimal SUBSCRIBER_TYPE_LOV_TYPE = new BigDecimal(1632);
    public static final BigDecimal EXPRESSION_LOV_TYPE = new BigDecimal(502);
    public static final BigDecimal COMMUNICATION_TYPE_LOV_TYPE = new BigDecimal(1544);

    public static final String REPORTING_SERVICE_URL = "reporting.serviceURL";
    public static final String REPORTING_SERVICE_EXPORTER = "commonReportingBOService";
    public static final String REPORTING_SERVICE_REMOTING = "PathAlertRemoting.properties";

    public static final String SMS_COMMUNICATION_MODE = "Sms";
    public static final String EMAIL_COMMUNICATION_MODE = "Email";
    public static final String DEFAULT_TAGS = "Default";
    public static final String CUSTOM_TAGS = "Custom";
    public static final String QUERY_TAGS = "Query";

    public static final String SMS_COMMUNICATION_TYPE = "S";
    public static final String EMAIL_COMMUNICATION_TYPE = "E";
    public static final String OMNI_INBOX_COMMUNICATION_TYPE = "OI";
    public static final String ALRT_INTERNAL = "AI";

    public static final String STATIC_TEMPLATE_TYPE = "S";
    public static final String DYNAMIC_TEMPLATE_TYPE = "D";

    public static final String REPORT_ATTACH_STATUS_NEW = "N";
    public static final String REPORT_ATTACH_STATUS_OLD = "O";

    public static final String STATUS_NEW_CREADTED = "C";
    public static final String STATUS_MODIFIED = "M";
    public static final String STATUS_DELETED = "D";
    public static final String STATUS_APPROVED = "P";
    public static final String STATUS_TO_SUSPEND = "T";
    public static final String STATUS_TO_REACTIVATE = "R";
    public static final String STATUS_SUSPEND = "S";
    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_REACTIVATED = "RA";

    public static final String DEFAULT_LANG = "DF";
    public static final String ENGLISH_LANG = "EN";
    public static final String ARABIC_LANG = "AR";
    public static final String FRENCH_LANG = "FR";
    public static final String RUSSIAN_LANG = "RU";
    public static final String TURKISH_LANG = "TK";
    public static final String PERSION_LANG = "FA";

    public static final String ACTIVATE = "1";
    public static final String DEACTIVATE = "0";
    public static final String YES = "Y";
    public static final String NO = "N";

    public static final String BATCH_EVT_TYPE = "B";
    public static final String IMAL_FIXED_EVT_TYPE = "F";
    public static final String SYSTEM_EVENT_TYPE = "S";
    public static final BigDecimal CARD_SMS_SERVICE = new BigDecimal(6);

    public static final String NUMERIC = "N";
    public static final String VARCHAR = "V";
    public static final String IN = "IN";
    public static final String NOT_IN = "NOT IN";
    public static final String INVALID_NUMERIC = "500";
    public static final String INVALID_SEPARATED_NUMERIC = "501";
    public static final String INVALID_VARCHAR = "502";
    public static final String INVALID_SEPARATED_VARCHAR = "503";
    
    /**
     * Event Screen Page ref
     */
    public static final String EVENT_MAINT_PROG_REF = "EVT01MT";
    public static final String EVENT_UPDATE_AFTER_APPROVE_PROG_REF = "EVT01MA";
    
    /**
     * return rmi url of reporting
     * @return
     */
    public static String returnReportingRmi()
    {
	String serviceURL = IndividualEventConstant.REPORTING_SERVICE_URL;
	String rmiUrl = null;
	try
	{
	    rmiUrl = PathPropertyUtil.returnPathPropertyFromFile(IndividualEventConstant.REPORTING_SERVICE_REMOTING,
		    serviceURL);
	    rmiUrl = (rmiUrl == null) ? "" : rmiUrl;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return rmiUrl;
    }

    public static final List<String> getStatusFields = new ArrayList<String>();
    static
    {
	getStatusFields.add("CREATED_BY," + STATUS_NEW_CREADTED + ",DATE_CREATED");
	getStatusFields.add("MODIFIED_BY," + STATUS_MODIFIED + ",DATE_MODIFIED");
	getStatusFields.add("DELETED_BY," + STATUS_DELETED + ",DATE_DELETED");
	getStatusFields.add("AUTHORIZED_BY," + STATUS_APPROVED + ",DATE_AUTHORIZED");
	getStatusFields.add("TOBE_SUSPENDED_BY," + STATUS_TO_SUSPEND + ",TOBE_SUSPENDED_DATE");
	getStatusFields.add("TOBE_REACTIVATED_BY," + STATUS_TO_REACTIVATE + ",TOBE_REACTIVATED_DATE");
	getStatusFields.add("SUSPENDED_BY," + STATUS_SUSPEND + ",DATE_SUSPENDED");
	getStatusFields.add("REACTIVATED_BY," + STATUS_REACTIVATED + ",DATE_REACTIVATED");
    }

}
