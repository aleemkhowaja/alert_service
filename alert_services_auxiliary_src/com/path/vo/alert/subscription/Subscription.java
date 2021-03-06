package com.path.vo.alert.subscription;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class Subscription
 */

@XmlType(propOrder={})
public class Subscription 
{
	private BigDecimal subscriberId;
	private BigDecimal eventId;
	private BigDecimal packageId;
	private String pacakgeName;
	private String eventDescription;
	private String subscriberBriefName;
	private String communicationMode;
	private BigDecimal groupId;
	private String groupName;
	private String subscriptionType;
	private String status;

	public void setSubscriberId(BigDecimal subscriberId)
	{
	   this.subscriberId = subscriberId;
	}
	public BigDecimal getSubscriberId()
	{
	   return subscriberId;
	}
	public void setEventId(BigDecimal eventId)
	{
	   this.eventId = eventId;
	}
	public BigDecimal getEventId()
	{
	   return eventId;
	}
	public void setPackageId(BigDecimal packageId)
	{
	   this.packageId = packageId;
	}
	public BigDecimal getPackageId()
	{
	   return packageId;
	}
	public void setPacakgeName(String pacakgeName)
	{
	   this.pacakgeName = pacakgeName;
	}
	public String getPacakgeName()
	{
	   return pacakgeName;
	}
	public void setEventDescription(String eventDescription)
	{
	   this.eventDescription = eventDescription;
	}
	public String getEventDescription()
	{
	   return eventDescription;
	}
	public void setSubscriberBriefName(String subscriberBriefName)
	{
	   this.subscriberBriefName = subscriberBriefName;
	}
	public String getSubscriberBriefName()
	{
	   return subscriberBriefName;
	}
	public void setCommunicationMode(String communicationMode)
	{
	   this.communicationMode = communicationMode;
	}
	public String getCommunicationMode()
	{
	   return communicationMode;
	}
	public void setGroupId(BigDecimal groupId)
	{
	   this.groupId = groupId;
	}
	public BigDecimal getGroupId()
	{
	   return groupId;
	}
	public void setGroupName(String groupName)
	{
	   this.groupName = groupName;
	}
	public String getGroupName()
	{
	   return groupName;
	}
	public void setSubscriptionType(String subscriptionType)
	{
	   this.subscriptionType = subscriptionType;
	}
	public String getSubscriptionType()
	{
	   return subscriptionType;
	}
	public void setStatus(String status)
	{
	   this.status = status;
	}
	public String getStatus()
	{
	   return status;
	}
}
