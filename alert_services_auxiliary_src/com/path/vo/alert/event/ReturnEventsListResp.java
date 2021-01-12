package com.path.vo.alert.event;
import com.path.vo.common.header.ServiceResponseVO;
import com.path.vo.common.header.ResponseContextVO;
import com.path.vo.common.header.ResponseServiceContextVO;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import com.path.vo.alert.event.Event;
import com.path.vo.common.DynamicFilter;
import com.path.vo.common.ImBaseRequest;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class ReturnEventsListResp extends ImBaseRequest
 */

@XmlType(propOrder={})
public class ReturnEventsListResp extends ImBaseRequest
{
	private ServiceResponseVO serviceResponse = new ServiceResponseVO();
	private ResponseContextVO responseContext = new ResponseContextVO();
	private ResponseServiceContextVO responseServiceContext = new ResponseServiceContextVO();
	private BigDecimal companyCode;
	private String status;
	private String eventType;
	private String descriptionEnglish;
	private String communicationType;
	private String descriptionArabic;
	private DynamicFilter dynamicFilter = new DynamicFilter();
	private List<Event> eventsList = new ArrayList<Event>();

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
	public void setStatus(String status)
	{
	   this.status = status;
	}
	public String getStatus()
	{
	   return status;
	}
	public void setEventType(String eventType)
	{
	   this.eventType = eventType;
	}
	public String getEventType()
	{
	   return eventType;
	}
	public void setDescriptionEnglish(String descriptionEnglish)
	{
	   this.descriptionEnglish = descriptionEnglish;
	}
	public String getDescriptionEnglish()
	{
	   return descriptionEnglish;
	}
	public void setCommunicationType(String communicationType)
	{
	   this.communicationType = communicationType;
	}
	public String getCommunicationType()
	{
	   return communicationType;
	}
	public void setDescriptionArabic(String descriptionArabic)
	{
	   this.descriptionArabic = descriptionArabic;
	}
	public String getDescriptionArabic()
	{
	   return descriptionArabic;
	}
	public void setDynamicFilter(DynamicFilter dynamicFilter)
	{
	   this.dynamicFilter = dynamicFilter;
	}
	public DynamicFilter getDynamicFilter()
	{
	   return dynamicFilter;
	}
	public void setEventsList(List<Event> eventsList)
	{
	   this.eventsList = eventsList;
	}
	@XmlElementWrapper(name = "eventsList")
  	@XmlElement(name = "event")
	public List<Event> getEventsList()
	{
	   return eventsList;
	}
}