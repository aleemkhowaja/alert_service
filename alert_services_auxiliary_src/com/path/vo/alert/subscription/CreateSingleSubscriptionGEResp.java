package com.path.vo.alert.subscription;
import java.math.BigDecimal;
import com.path.vo.common.header.ServiceResponseVO;
import com.path.vo.common.header.ResponseContextVO;
import com.path.vo.common.header.ResponseServiceContextVO;
import com.path.vo.common.ImBaseRequest;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class CreateSingleSubscriptionGEResp extends ImBaseRequest
 */

@XmlType(propOrder={})
public class CreateSingleSubscriptionGEResp extends ImBaseRequest
{
	private ServiceResponseVO serviceResponse = new ServiceResponseVO();
	private ResponseContextVO responseContext = new ResponseContextVO();
	private ResponseServiceContextVO responseServiceContext = new ResponseServiceContextVO();
	private BigDecimal companyCode;
	private BigDecimal groupId;
	private BigDecimal subscriptionEventId;
	private String autoApproveFlag;
	private BigDecimal subscriptionId;

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
	public void setGroupId(BigDecimal groupId)
	{
	   this.groupId = groupId;
	}
	public BigDecimal getGroupId()
	{
	   return groupId;
	}
	public void setSubscriptionEventId(BigDecimal subscriptionEventId)
	{
	   this.subscriptionEventId = subscriptionEventId;
	}
	public BigDecimal getSubscriptionEventId()
	{
	   return subscriptionEventId;
	}
	public void setAutoApproveFlag(String autoApproveFlag)
	{
	   this.autoApproveFlag = autoApproveFlag;
	}
	public String getAutoApproveFlag()
	{
	   return autoApproveFlag;
	}
	public void setSubscriptionId(BigDecimal subscriptionId)
	{
	   this.subscriptionId = subscriptionId;
	}
	public BigDecimal getSubscriptionId()
	{
	   return subscriptionId;
	}
}
