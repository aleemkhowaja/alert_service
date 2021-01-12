package com.path.alert.bo.reportquery.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.path.alert.bo.base.AlertConstant;
import com.path.alert.bo.reportquery.ReportQueryBO;
import com.path.alert.bo.reportquery.ReportQueryConstant;
import com.path.alert.dao.reportquery.ReportQueryDAO;
import com.path.alert.vo.reportquery.ReportQueryCO;
import com.path.alert.vo.reportquery.ReportQuerySC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.dbmaps.vo.ALRT_REPORT_QUERYVO;
import com.path.dbmaps.vo.ALRT_REPORT_QUERY_ARGVO;
import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.log.Log;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;
import com.path.vo.reporting.SQL_OBJECT;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ReportQueryBOImpl.java used to
 */
public class ReportQueryBOImpl extends BaseBO implements ReportQueryBO
{
    ReportQueryDAO reportQueryDAO;
    
    private static final Log log = Log.getInstance();

    public ReportQueryDAO getReportQueryDAO()
    {
	return reportQueryDAO;
    }

    public void setReportQueryDAO(ReportQueryDAO reportQueryDAO)
    {
	this.reportQueryDAO = reportQueryDAO;
    }

    @Override
    public int returnReportQueryListCount(ReportQuerySC criteria) throws BaseException
    {
	return reportQueryDAO.returnReportQueryListCount(criteria);
    }

    @Override
    public List<ReportQueryCO> returnReportQueryList(ReportQuerySC criteria) throws BaseException
    {
	return reportQueryDAO.returnReportQueryList(criteria);
    }

    @Override
    public ReportQueryCO retrieveSelecetdQueryId(ReportQuerySC sc) throws BaseException
    {
	return reportQueryDAO.retrieveSelecetdQueryId(sc);
    }

    @Override
    public int getQueriesCount(ReportQuerySC sc) throws BaseException
    {
	return reportQueryDAO.getQueriesCount(sc);
    }

    @Override
    public List<IRP_AD_HOC_QUERYVO> getQueriesList(ReportQuerySC sc) throws BaseException
    {
	return reportQueryDAO.getQueriesList(sc);
    }
    
    @Override
    public ReportQueryCO returnQueryById(BigDecimal queryId, boolean generateSyntax)
	    throws BaseException, IOException, ClassNotFoundException
    {
	ReportQueryCO query = reportQueryDAO.returnQueryById(queryId);
	if(query == null)
	{
	    return query;
	}
	else
	{
	    fillSqlObj(query);
	    return query;
	}
    }

    public void fillSqlObj(ReportQueryCO query) throws ClassNotFoundException, IOException
    {
	byte[] sqlObj = query.getQUERY_OBJECT();
	StringBuffer xml;
	String xmlStr = new String(sqlObj, "UTF-8");
	xml = new StringBuffer(xmlStr);
	// if the sqlObj is saved as object in the db (old version)
	if(xml.indexOf("<?xml version=\"1.0\" encoding=\"UTF-8\"?>") == -1)
	{
	    query.setSqlObject((SQL_OBJECT) objectFromBytes(query.getQUERY_OBJECT()));
	}
	// if the sqlObj is saved as xml
	else
	{
	    query.setSqlObject(xmlToSqlObject(query.getQUERY_OBJECT()));
	}
    }
    
    public static Serializable objectFromBytes(byte[] bytes) throws IOException, ClassNotFoundException 
    {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Serializable obj = (Serializable) in.readObject();
        in.close();
        return obj;
    }
    
    public SQL_OBJECT xmlToSqlObject(byte[] qryObj)
    {
	SQL_OBJECT sqlObj = new SQL_OBJECT();
	try
	{
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(new ByteArrayInputStream(qryObj));

	    NodeList qryLst = doc.getElementsByTagName("qry");

	    NodeList parentNodeLst;
	    NodeList childNodeLst;
	    NodeList ch1NodeLst;
	    NodeList ch2NodeLst;
	    
	    Node qry;
	    Node childNode;
	    Node parentNode;
	    Node argLblNode;
	    Node argValNode;
		   
	    Element parentElem;
	    Element qryElem;
	    Element childElem;

	    NamedNodeMap attrs;

	    String str;
	    IRP_REP_ARGUMENTSCO argCO;
	    int j;

	    for(int i = 0; i < qryLst.getLength(); i++)
	    {
		qry = qryLst.item(i);

		// fill qryName and outputLayout
		attrs = qry.getAttributes();
		if(attrs.getNamedItem("name") == null)
		{
		    qryElem = (Element) qry;
		    childNodeLst = qryElem.getElementsByTagName("name");
		    childNode = childNodeLst.item(0);
		    sqlObj.setQUERY_NAME(childNode.getChildNodes().item(0).getNodeValue());

		}
		else
		{

		    sqlObj.setQUERY_NAME(attrs.getNamedItem("name").getNodeValue());
		}
		sqlObj.setOutputLayout(attrs.getNamedItem("outputLayout").getNodeValue());
		str = attrs.getNamedItem("type").getNodeValue();

		if(qry.getNodeType() == Node.ELEMENT_NODE)
		{
		    qryElem = (Element) qry;

		  //fill arguments
		  parentNodeLst = qryElem.getElementsByTagName("args");
		  parentNode=parentNodeLst.item(0);
		  if(parentNode.getNodeType()==Node.ELEMENT_NODE)
		    {
			parentElem = (Element) parentNode;
			childNodeLst = parentElem.getElementsByTagName("arg");
			for(j = 0; j < childNodeLst.getLength(); j++)
			{
			    childNode = childNodeLst.item(j);
			    attrs = childNode.getAttributes();

			    argCO = new IRP_REP_ARGUMENTSCO();
			    argCO.setIndex(Long.parseLong(attrs.getNamedItem("id").getNodeValue()));
			    argCO.setARGUMENT_NAME(attrs.getNamedItem("name").getNodeValue());
			    argCO.setARGUMENT_TYPE(attrs.getNamedItem("type").getNodeValue());
			    argCO.setARGUMENT_SOURCE(new BigDecimal(attrs.getNamedItem("src").getNodeValue()));
			    argCO.setSESSION_ATTR_NAME(attrs.getNamedItem("sess").getNodeValue());
			    if(attrs.getNamedItem("qryId") != null
				    && !"null".equals(attrs.getNamedItem("qryId").getNodeValue()))
			    {
				argCO.setQUERY_ID(new BigDecimal(attrs.getNamedItem("qryId").getNodeValue()));
			    }
			    if(attrs.getNamedItem("linkRepQryArg") != null)// &&
									   // !"null".equals(attrs.getNamedItem("linkRepQryArg").getNodeValue()))
			    {
				argCO.setLINK_REP_QRY_ARG(attrs.getNamedItem("linkRepQryArg").getNodeValue());
			    }
			    // else
			    // {
			    // argCO.setLINK_REP_QRY_ARG("");
			    // }
			    argCO.getARGUMENT_ID();
			    if("null".equals(sqlObj.getOutputLayout()))// to
								       // link
								       // the
								       // qry
								       // arg to
								       // rep
								       // arg on
								       // creation
								       // of a
								       // new
								       // rep
								       // from
								       // designer
			    {
				argCO.setLINK_REP_QRY_ARG(argCO.getARGUMENT_NAME());
			    }
			    argCO.setQUERY_NAME(attrs.getNamedItem("qryName").getNodeValue());
			    str = attrs.getNamedItem("col").getNodeValue();
			    if("null".equalsIgnoreCase(str))
			    {
				str = null;
			    }
			    argCO.setCOLUMN_NAME(str);
			    argCO.setValueFlag(Boolean.valueOf(attrs.getNamedItem("valFlg").getNodeValue()));
			    argCO.setARGUMENT_ORDER(new BigDecimal(attrs.getNamedItem("order").getNodeValue()));
			    argCO.setDISPLAY_FLAG(attrs.getNamedItem("displ").getNodeValue());
			    argCO.setENABLE_FLAG(attrs.getNamedItem("enable").getNodeValue());
			    if(attrs.getNamedItem(ReportQueryConstant.REP_MULTISEL) != null)
			    {
				argCO.setMULTISELECT_YN(new BigDecimal(
					attrs.getNamedItem(ReportQueryConstant.REP_MULTISEL).getNodeValue()));
			    }
			    if(childNode.getNodeType() == Node.ELEMENT_NODE)
			    {
				childElem = (Element) childNode;
				ch1NodeLst = childElem.getElementsByTagName("lbl");
				ch2NodeLst = childElem.getElementsByTagName("val");
				String argLabel = "";
				String argValue = "";
				argLblNode = ch1NodeLst.item(0).getFirstChild();
				argValNode = ch2NodeLst.item(0).getFirstChild();
				if(argLblNode != null)
				{
				    argLabel = argLblNode.getNodeValue();
				}
				if(argValNode != null)
				{
				    argValue = argValNode.getNodeValue();
				}
				argCO.setARGUMENT_LABEL(argLabel);
				argCO.setARGUMENT_VALUE(argValue);
			    }
			    sqlObj.getArgumentsList().put(argCO.getIndex(), argCO);
			}
		    }
		    // fill syntax
		    parentNodeLst = qryElem.getElementsByTagName("syntax");
		    parentNode = parentNodeLst.item(0);
		    if(parentNode != null && parentNode.getNodeType() == Node.ELEMENT_NODE)
		    {
			parentElem = (Element) parentNode;
			childNodeLst = parentElem.getElementsByTagName("val");
			childNode = childNodeLst.item(0);
			sqlObj.setSqbSyntax(new StringBuffer(childNode.getChildNodes().item(0).getNodeValue()));
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, e.getMessage());
	}

	return sqlObj;
    }
    
    @Override
    public void save(ReportQueryCO reportQueryCO,ArrayList lstMod) throws BaseException
    {
	ReportQueryCO repCO;
	ALRT_REPORT_QUERY_ARGVO lVO;
	AuditRefCO refCO = reportQueryCO.getAuditRefCO();
	reportQueryCO.getReportQueryVO().setSTATUS(AlertConstant.STATUS_NEW);
	// add
	if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals(reportQueryCO.getReportQueryVO().getREP_QUER_ID()))
	{
	    reportQueryCO.getReportQueryVO().setCREATED_BY(reportQueryCO.getUserID());
	    reportQueryCO.getReportQueryVO().setCREATED_DATE(reportQueryCO.getRunningDate());
	    reportQueryCO.getReportQueryVO().setSERVER_CREATED_DATE(commonLibBO.returnSystemDateWithTime());
	    
	    //get the counter
	    reportQueryCO.getReportQueryVO().setREP_QUER_ID(new BigDecimal(reportQueryDAO.returnReportQueryId()));
	    
	    //insert into ReportQuery
	    genericDAO.insert(reportQueryCO.getReportQueryVO());
	    
	    //insert into ReportQueryArg
	    // update records grid
	    Iterator<ReportQueryCO> itMod = lstMod.iterator();
	    int argId = 1;
	    while(itMod.hasNext())
	    {	
		repCO = itMod.next();
		lVO = repCO.getReportQueryArgVO();
		lVO.setDATE_UPDATED(reportQueryCO.getRunningDate());
		lVO.setCREATED_BY(reportQueryCO.getUserID());
		lVO.setCREATED_DATE(reportQueryCO.getRunningDate());
		lVO.setSERVER_CREATED_DATE(commonLibBO.returnSystemDateWithTime());
		lVO.setQUERY_ID(reportQueryCO.getReportQueryVO().getQUERY_ID());
		lVO.setARG_ID(new BigDecimal(argId));
		lVO.setREP_QUER_ID(reportQueryCO.getReportQueryVO().getREP_QUER_ID());
		genericDAO.insert(lVO);
		argId += 1;
	    }
	    // apply audit
	    refCO.setOperationType(AuditConstant.CREATED);
	    auditBO.callAudit(null, reportQueryCO.getReportQueryVO(), refCO);
	}
	// update
	else
	{
	    reportQueryCO.getReportQueryVO().setMODIFIED_BY(reportQueryCO.getUserID());
	    reportQueryCO.getReportQueryVO().setMODIFIED_DATE(reportQueryCO.getRunningDate());
	    reportQueryCO.getReportQueryVO().setSERVER_MODIFIED_DATE(commonLibBO.returnSystemDateWithTime());
	    Integer row = genericDAO.update(reportQueryCO.getReportQueryVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }
	  
	    //update ReportQueryArg
	    // update records grid
	    Iterator<ReportQueryCO> itMod = lstMod.iterator();
	    while(itMod.hasNext())
	    {	
		repCO = itMod.next();
		lVO = repCO.getReportQueryArgVO();
		lVO.setREP_QUER_ID(reportQueryCO.getReportQueryVO().getREP_QUER_ID());
		row = genericDAO.update(lVO);
		if (row == null || row < 1) {
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
	    }
	    // apply audit
	    refCO.setOperationType(AuditConstant.UPDATE);
	    ReportQueryCO oldreportQueryCO = (ReportQueryCO) reportQueryCO.getAuditObj();
	    auditBO.callAudit(oldreportQueryCO.getReportQueryVO(), reportQueryCO.getReportQueryVO(), refCO);
	    auditBO.insertAudit(refCO);
	}
    }
    
    @Override
    public int returnReportQueryArgCount(ReportQuerySC sc) throws BaseException
    {
	return reportQueryDAO.returnReportQueryArgCount(sc);
    }
    
    @Override
    public List<ReportQueryCO> returnReportQueryArgList(ReportQuerySC sc) throws BaseException
    {
	return reportQueryDAO.returnReportQueryArgList(sc);
    }
	
    @Override
    public void approve(ReportQueryCO reportQueryCO) throws BaseException
    {
//	ReportQueryCO repCO;
//	ALRT_REPORT_QUERY_ARGVO lVO;
//	AuditRefCO refCO = reportQueryCO.getAuditRefCO();
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	reportQueryCO.getReportQueryVO().setAPPROVED_BY(reportQueryCO.getUserID());
	reportQueryCO.getReportQueryVO().setAPPROVED_DATE(reportQueryCO.getRunningDate());
	reportQueryCO.getReportQueryVO().setSTATUS(AlertConstant.STATUS_APPROVED);
	reportQueryCO.getReportQueryVO().setSERVER_APPROVED_DATE(systemDate);
	
	ALRT_REPORT_QUERYVO oldAuditVO = (ALRT_REPORT_QUERYVO) genericDAO.selectByPK(reportQueryCO.getReportQueryVO());
	Integer update = genericDAO.update(reportQueryCO.getReportQueryVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	
	ALRT_REPORT_QUERYVO newAuditVO = new ALRT_REPORT_QUERYVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);

	newAuditVO.setAPPROVED_BY(reportQueryCO.getUserID());
	newAuditVO.setAPPROVED_DATE(reportQueryCO.getRunningDate());
	newAuditVO.setSERVER_APPROVED_DATE(systemDate);
	newAuditVO.setSTATUS(AlertConstant.STATUS_APPROVED);
	
	auditBO.callAudit(oldAuditVO, newAuditVO, reportQueryCO.getAuditRefCO());
	auditBO.insertAudit(reportQueryCO.getAuditRefCO());

    }
    
    @Override
    public void deleteReportQueryId(ReportQueryCO reportQueryCO) throws BaseException
    {
	{
	    reportQueryCO.getReportQueryVO().setDELETED_BY(reportQueryCO.getUserID());
	    reportQueryCO.getReportQueryVO().setDELETED_DATE(reportQueryCO.getRunningDate());
	    Date serverDate = commonLibBO.returnSystemDateWithTime();
	    reportQueryCO.getReportQueryVO().setSERVER_DELETED_DATE(serverDate);
	    reportQueryCO.getReportQueryVO().setSTATUS(AlertConstant.STATUS_DELETED);

	    ALRT_REPORT_QUERYVO oldAuditVO = (ALRT_REPORT_QUERYVO) genericDAO.selectByPK(reportQueryCO.getReportQueryVO());
	    Integer update = genericDAO.update(reportQueryCO.getReportQueryVO());
	    if(update == null || update < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }
	    ALRT_REPORT_QUERYVO newAuditVO = new ALRT_REPORT_QUERYVO();
	    PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	    newAuditVO.setDELETED_BY(reportQueryCO.getUserID());
	    newAuditVO.setDELETED_DATE(reportQueryCO.getRunningDate());
	    newAuditVO.setSTATUS(AlertConstant.STATUS_DELETED);
	    newAuditVO.setSERVER_DELETED_DATE(serverDate);

	    auditBO.callAudit(oldAuditVO, newAuditVO, reportQueryCO.getAuditRefCO());
	    auditBO.insertAudit(reportQueryCO.getAuditRefCO());

	}
    }
}
