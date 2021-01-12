package com.path.vo.alert.subscription;
import java.math.BigDecimal;
import com.path.vo.common.header.ServiceContextAllVO;
import javax.xml.bind.annotation.XmlElement;
import com.path.vo.common.ImBaseRequest;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class ApproveSingleSubscriptionReq extends ImBaseRequest
 */

@XmlType(propOrder={})
public class ApproveSingleSubscriptionReq extends ImBaseRequest
{
	private ServiceContextAllVO serviceContext = new ServiceContextAllVO();
	private BigDecimal subscriptionId;
	private String subscriptionType;
	private BigDecimal companyCode;

	public void setServiceContext(ServiceContextAllVO serviceContext)
	{
	   this.serviceContext = serviceContext;
	}
	public ServiceContextAllVO getServiceContext()
	{
	   return serviceContext;
	}
	public void setSubscriptionId(BigDecimal subscriptionId)
	{
	   this.subscriptionId = subscriptionId;
	}
	@XmlElement(required = true)
	public BigDecimal getSubscriptionId()
	{
	   return subscriptionId;
	}
	public void setSubscriptionType(String subscriptionType)
	{
	   this.subscriptionType = subscriptionType;
	}
	@XmlElement(required = true)
	public String getSubscriptionType()
	{
	   return subscriptionType;
	}
	public void setCompanyCode(BigDecimal companyCode)
	{
	   this.companyCode = companyCode;
	}
	@XmlElement(required = true)
	public BigDecimal getCompanyCode()
	{
	   return companyCode;
	}
}
