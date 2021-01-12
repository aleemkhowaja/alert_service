package com.path.vo.alert.event;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;

/**
 * @AutoGenerated Code
 * @description class Event
 */

@XmlType(propOrder={})
public class Event 
{
	private BigDecimal eventId;
	private String status;
	private String eventType;
	private String descriptionEnglish;
	private String communicationDescription;
	private String descriptionArabic;

	public void setEventId(BigDecimal eventId)
	{
	   this.eventId = eventId;
	}
	public BigDecimal getEventId()
	{
	   return eventId;
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
	public void setCommunicationDescription(String communicationDescription)
	{
	   this.communicationDescription = communicationDescription;
	}
	public String getCommunicationDescription()
	{
	   return communicationDescription;
	}
	public void setDescriptionArabic(String descriptionArabic)
	{
	   this.descriptionArabic = descriptionArabic;
	}
	public String getDescriptionArabic()
	{
	   return descriptionArabic;
	}
}
