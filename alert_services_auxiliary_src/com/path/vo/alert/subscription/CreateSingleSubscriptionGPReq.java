package com.path.vo.alert.subscription;
import java.math.BigDecimal;
import com.path.vo.common.header.ServiceContextAllVO;
import javax.xml.bind.annotation.XmlElement;
import com.path.vo.common.ImBaseRequest;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class CreateSingleSubscriptionGPReq extends ImBaseRequest
 */

@XmlType(propOrder={})
public class CreateSingleSubscriptionGPReq extends ImBaseRequest
{
	private ServiceContextAllVO serviceContext = new ServiceContextAllVO();
	private BigDecimal companyCode;
	private BigDecimal groupId;
	private BigDecimal subscriptionPackageId;
	private String autoApproveFlag;

	public void setServiceContext(ServiceContextAllVO serviceContext)
	{
	   this.serviceContext = serviceContext;
	}
	public ServiceContextAllVO getServiceContext()
	{
	   return serviceContext;
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
	public void setGroupId(BigDecimal groupId)
	{
	   this.groupId = groupId;
	}
	@XmlElement(required = true)
	public BigDecimal getGroupId()
	{
	   return groupId;
	}
	public void setSubscriptionPackageId(BigDecimal subscriptionPackageId)
	{
	   this.subscriptionPackageId = subscriptionPackageId;
	}
	@XmlElement(required = true)
	public BigDecimal getSubscriptionPackageId()
	{
	   return subscriptionPackageId;
	}
	public void setAutoApproveFlag(String autoApproveFlag)
	{
	   this.autoApproveFlag = autoApproveFlag;
	}
	public String getAutoApproveFlag()
	{
	   return autoApproveFlag;
	}
}