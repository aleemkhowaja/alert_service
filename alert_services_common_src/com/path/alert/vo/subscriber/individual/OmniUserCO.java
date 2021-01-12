package com.path.alert.vo.subscriber.individual;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.dbmaps.vo.OC_USRVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.select.SelectCO;


public class OmniUserCO extends BaseVO
{
    private String deleteMsg;
    private String statusDesc;
    private String statusColorCode;
    private BigDecimal businessProfileCode;
    private String businessProfileName;
    private BigDecimal subProfileCode;
    private String subProfileName;
    private BigDecimal customerCode;
    private String customerName;
    private String cifName;
    private String customerCifNo;
    private ArrayList<SelectCO> channelDropDown = new ArrayList<>();
    private OC_USRVO omniUserVO = new OC_USRVO();
    private String appList;
    private String channelList;
    private Date systemDate;
    private String notificationMsg;
    private String redirectPage;
    private String multipleUserApp;
    private String message;
    private String reason;
    private Boolean isUpdate = false;
    private BigDecimal userCode;
    private String deliverOptionCode;
    private String deliveryOption;
    private BigDecimal userPkId;
    private BigDecimal customerId;
    private BigDecimal businessProfileId;
    private BigDecimal subProfileId;
    
    
    public String getDeleteMsg()
    {
        return deleteMsg;
    }
    public void setDeleteMsg(String deleteMsg)
    {
        this.deleteMsg = deleteMsg;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    public String getStatusColorCode()
    {
        return statusColorCode;
    }
    public void setStatusColorCode(String statusColorCode)
    {
        this.statusColorCode = statusColorCode;
    }
    public BigDecimal getBusinessProfileCode()
    {
        return businessProfileCode;
    }
    public void setBusinessProfileCode(BigDecimal businessProfileCode)
    {
        this.businessProfileCode = businessProfileCode;
    }
    public OC_USRVO getOmniUserVO()
    {
        return omniUserVO;
    }
    public void setOmniUserVO(OC_USRVO omniUserVO)
    {
        this.omniUserVO = omniUserVO;
    }
    public ArrayList<SelectCO> getChannelDropDown()
    {
        return channelDropDown;
    }
    public void setChannelDropDown(ArrayList<SelectCO> channelDropDown)
    {
        this.channelDropDown = channelDropDown;
    }
    public String getCifName()
    {
        return cifName;
    }
    public void setCifName(String cifName)
    {
        this.cifName = cifName;
    }
    public BigDecimal getSubProfileCode()
    {
        return subProfileCode;
    }
    public void setSubProfileCode(BigDecimal subProfileCode)
    {
        this.subProfileCode = subProfileCode;
    }
    public BigDecimal getCustomerCode()
    {
        return customerCode;
    }
    public void setCustomerCode(BigDecimal customerCode)
    {
        this.customerCode = customerCode;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    public String getSubProfileName()
    {
        return subProfileName;
    }
    public void setSubProfileName(String subProfileName)
    {
        this.subProfileName = subProfileName;
    }
    public String getAppList()
    {
        return appList;
    }
    public void setAppList(String appList)
    {
        this.appList = appList;
    }
    public String getChannelList()
    {
        return channelList;
    }
    public void setChannelList(String channelList)
    {
        this.channelList = channelList;
    }
    
    public Date getSystemDate()
    {
        return systemDate;
    }
    public void setSystemDate(Date systemDate)
    {
        this.systemDate = systemDate;
    }
    public String getNotificationMsg()
    {
        return notificationMsg;
    }
    public void setNotificationMsg(String notificationMsg)
    {
        this.notificationMsg = notificationMsg;
    }
    public String getRedirectPage()
    {
        return redirectPage;
    }
    public void setRedirectPage(String redirectPage)
    {
        this.redirectPage = redirectPage;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public Boolean getIsUpdate()
    {
        return isUpdate;
    }
    public void setIsUpdate(Boolean isUpdate)
    {
        this.isUpdate = isUpdate;
    }
    public BigDecimal getUserCode()
    {
        return userCode;
    }
    public void setUserCode(BigDecimal userCode)
    {
        this.userCode = userCode;
    }
    public String getBusinessProfileName()
    {
        return businessProfileName;
    }
    public void setBusinessProfileName(String businessProfileName)
    {
        this.businessProfileName = businessProfileName;
    }
    public String getReason()
    {
        return reason;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    public String getDeliverOptionCode()
    {
        return deliverOptionCode;
    }
    public void setDeliverOptionCode(String deliverOptionCode)
    {
        this.deliverOptionCode = deliverOptionCode;
    }
    public String getDeliveryOption()
    {
        return deliveryOption;
    }
    public void setDeliveryOption(String deliveryOption)
    {
        this.deliveryOption = deliveryOption;
    }
    
    public String getMultipleUserApp()
    {
        return multipleUserApp;
    }
    public void setMultipleUserApp(String multipleUserApp)
    {
        this.multipleUserApp = multipleUserApp;
    }
    public BigDecimal getUserPkId()
    {
        return userPkId;
    }
    public void setUserPkId(BigDecimal userPkId)
    {
        this.userPkId = userPkId;
    }
    public BigDecimal getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(BigDecimal customerId)
    {
        this.customerId = customerId;
    }
    public BigDecimal getBusinessProfileId()
    {
        return businessProfileId;
    }
    public void setBusinessProfileId(BigDecimal businessProfileId)
    {
        this.businessProfileId = businessProfileId;
    }
    public BigDecimal getSubProfileId()
    {
        return subProfileId;
    }
    public void setSubProfileId(BigDecimal subProfileId)
    {
        this.subProfileId = subProfileId;
    }
    public String getCustomerCifNo()
    {
        return customerCifNo;
    }
    public void setCustomerCifNo(String customerCifNo)
    {
        this.customerCifNo = customerCifNo;
    }
    
}
