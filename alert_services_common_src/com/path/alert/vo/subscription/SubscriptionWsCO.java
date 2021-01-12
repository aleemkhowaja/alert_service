package com.path.alert.vo.subscription;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODEVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PARAMSETVO;
import com.path.dbmaps.vo.ALRT_FIXED_PARAMVOWithBLOBs;
import com.path.dbmaps.vo.ALRT_GRPVO;
import com.path.dbmaps.vo.ALRT_GRP_PKGVO;
import com.path.dbmaps.vo.ALRT_PKGVO;
import com.path.dbmaps.vo.ALRT_SUBSCRIPTION_PARAMVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_ACC_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVTVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_COMM_MODE_EXCLVO;
import com.path.dbmaps.vo.ALRT_SUB_EVT_TMPVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.ALRT_SUB_PKGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

public class SubscriptionWsCO extends BaseVO {

    private BigDecimal compCode;
    private BigDecimal eventId;
    private BigDecimal subscriberId;
    private BigDecimal packageId;
    private String packageName;
    private String eventDescription;
    private String subscriberDescription;
    private String communicationType;
    private BigDecimal groupId;
    private String groupName;
    private String subscriptionType;
    private String status;
    
    
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public BigDecimal getEventId()
    {
        return eventId;
    }
    public BigDecimal getSubscriberId()
    {
        return subscriberId;
    }
    public BigDecimal getPackageId()
    {
        return packageId;
    }
    public String getPackageName()
    {
        return packageName;
    }
    public String getEventDescription()
    {
        return eventDescription;
    }
    public String getSubscriberDescription()
    {
        return subscriberDescription;
    }
    public String getCommunicationType()
    {
        return communicationType;
    }
    public BigDecimal getGroupId()
    {
        return groupId;
    }
    public String getGroupName()
    {
        return groupName;
    }
    public String getSubscriptionType()
    {
        return subscriptionType;
    }
    public void setEventId(BigDecimal eventId)
    {
        this.eventId = eventId;
    }
    public void setSubscriberId(BigDecimal subscriberId)
    {
        this.subscriberId = subscriberId;
    }
    public void setPackageId(BigDecimal packageId)
    {
        this.packageId = packageId;
    }
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }
    public void setEventDescription(String eventDescription)
    {
        this.eventDescription = eventDescription;
    }
    public void setSubscriberDescription(String subscriberDescription)
    {
        this.subscriberDescription = subscriberDescription;
    }
    public void setCommunicationType(String communicationType)
    {
        this.communicationType = communicationType;
    }
    public void setGroupId(BigDecimal groupId)
    {
        this.groupId = groupId;
    }
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }
    public void setSubscriptionType(String subscriptionType)
    {
        this.subscriptionType = subscriptionType;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}