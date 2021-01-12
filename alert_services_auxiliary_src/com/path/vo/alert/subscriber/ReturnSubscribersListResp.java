package com.path.vo.alert.subscriber;
import java.math.BigDecimal;
import com.path.vo.common.header.ServiceResponseVO;
import com.path.vo.common.header.ResponseContextVO;
import com.path.vo.common.header.ResponseServiceContextVO;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;
import com.path.vo.alert.subscriber.Subscriber;
import com.path.vo.common.DynamicFilter;
import com.path.vo.common.ImBaseRequest;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class ReturnSubscribersListResp extends ImBaseRequest
 */

@XmlType(propOrder={})
public class ReturnSubscribersListResp extends ImBaseRequest
{
	private ServiceResponseVO serviceResponse = new ServiceResponseVO();
	private ResponseContextVO responseContext = new ResponseContextVO();
	private ResponseServiceContextVO responseServiceContext = new ResponseServiceContextVO();
	private BigDecimal companyCode;
	private BigDecimal cifNo;
	private String imalUserId;
	private String channelEndUserId;
	private String briefNameEnglish;
	private String status;
	private DynamicFilter dynamicFilter = new DynamicFilter();
	private List<Subscriber> subscriberList = new ArrayList<Subscriber>();

	public void setServiceResponse(ServiceResponseVO serviceResponse)
	{
	   this.serviceResponse = serviceResponse;
	}
	public ServiceResponseVO getServiceResponse()
	{
	   return serviceResponse;
	}
	public void setResponseContext(ResponseContextVO responseContext)
	{
	   this.responseContext = responseContext;
	}
	public ResponseContextVO getResponseContext()
	{
	   return responseContext;
	}
	public void setResponseServiceContext(ResponseServiceContextVO responseServiceContext)
	{
	   this.responseServiceContext = responseServiceContext;
	}
	public ResponseServiceContextVO getResponseServiceContext()
	{
	   return responseServiceContext;
	}
	public void setCompanyCode(BigDecimal companyCode)
	{
	   this.companyCode = companyCode;
	}
	public BigDecimal getCompanyCode()
	{
	   return companyCode;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	   this.cifNo = cifNo;
	}
	public BigDecimal getCifNo()
	{
	   return cifNo;
	}
	public void setImalUserId(String imalUserId)
	{
	   this.imalUserId = imalUserId;
	}
	public String getImalUserId()
	{
	   return imalUserId;
	}
	public void setChannelEndUserId(String channelEndUserId)
	{
	   this.channelEndUserId = channelEndUserId;
	}
	public String getChannelEndUserId()
	{
	   return channelEndUserId;
	}
	public void setBriefNameEnglish(String briefNameEnglish)
	{
	   this.briefNameEnglish = briefNameEnglish;
	}
	public String getBriefNameEnglish()
	{
	   return briefNameEnglish;
	}
	public void setStatus(String status)
	{
	   this.status = status;
	}
	public String getStatus()
	{
	   return status;
	}
	public void setDynamicFilter(DynamicFilter dynamicFilter)
	{
	   this.dynamicFilter = dynamicFilter;
	}
	public DynamicFilter getDynamicFilter()
	{
	   return dynamicFilter;
	}
	public void setSubscriberList(List<Subscriber> subscriberList)
	{
	   this.subscriberList = subscriberList;
	}
	@XmlElementWrapper(name = "subscriberList")
  	@XmlElement(name = "subscriber")
	public List<Subscriber> getSubscriberList()
	{
	   return subscriberList;
	}
}
