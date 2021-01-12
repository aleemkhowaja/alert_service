package com.path.alert.vo.events.event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.ALRT_EVT_REPORT_ATTACH_ARG_MAPVO;
import com.path.lib.vo.BaseVO;

@SuppressWarnings("serial")
public class IndividualEventReportAttachmentCO extends BaseVO {

	private BigDecimal reportId;
	private String reportDescription;
	private String eventReportParameterLink;
	private String reportAttachmentParameter;
	private String reportAttachmentParameterMappings;
	private String reportAttachmentStatus;
	
	private List<ALRT_EVT_REPORT_ATTACH_ARG_MAPVO> alrt_EVT_REPORT_ATTACH_ARG_MAPVOs = new ArrayList<ALRT_EVT_REPORT_ATTACH_ARG_MAPVO>();
	
	public BigDecimal getReportId() {
		return reportId;
	}
	public String getEventReportParameterLink() {
		return eventReportParameterLink;
	}
	public String getReportAttachmentParameter() {
		return reportAttachmentParameter;
	}
	public String getReportAttachmentParameterMappings() {
		return reportAttachmentParameterMappings;
	}
	public void setReportId(BigDecimal reportId) {
		this.reportId = reportId;
	}
	public void setEventReportParameterLink(String eventReportParameterLink) {
		this.eventReportParameterLink = eventReportParameterLink;
	}
	public void setReportAttachmentParameter(String reportAttachmentParameter) {
		this.reportAttachmentParameter = reportAttachmentParameter;
	}
	public void setReportAttachmentParameterMappings(String reportAttachmentParameterMappings) {
		this.reportAttachmentParameterMappings = reportAttachmentParameterMappings;
	}
	public List<ALRT_EVT_REPORT_ATTACH_ARG_MAPVO> getAlrt_EVT_REPORT_ATTACH_ARG_MAPVOs() {
		return alrt_EVT_REPORT_ATTACH_ARG_MAPVOs;
	}
	public void setAlrt_EVT_REPORT_ATTACH_ARG_MAPVOs(
			List<ALRT_EVT_REPORT_ATTACH_ARG_MAPVO> alrt_EVT_REPORT_ATTACH_ARG_MAPVOs) {
		this.alrt_EVT_REPORT_ATTACH_ARG_MAPVOs = alrt_EVT_REPORT_ATTACH_ARG_MAPVOs;
	}
	public String getReportDescription() {
		return reportDescription;
	}
	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}
	public String getReportAttachmentStatus() {
		return reportAttachmentStatus;
	}
	public void setReportAttachmentStatus(String reportAttachmentStatus) {
		this.reportAttachmentStatus = reportAttachmentStatus;
	}
	
}