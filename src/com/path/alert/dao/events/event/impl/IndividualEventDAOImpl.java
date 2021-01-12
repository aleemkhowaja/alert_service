package com.path.alert.dao.events.event.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.path.alert.bo.reportquery.ReportQueryConstant;
import com.path.alert.dao.events.event.IndividualEventDAO;
import com.path.alert.vo.events.event.AlrtTagsCO;
import com.path.alert.vo.events.event.IndFixedParamListCO;
import com.path.alert.vo.events.event.IndividualEventCO;
import com.path.alert.vo.events.event.IndividualEventListCO;
import com.path.alert.vo.events.event.IndividualEventSC;
import com.path.alert.vo.events.event.IndividualFixedEventListCO;
import com.path.alert.vo.events.event.IndividualMemoListCO;
import com.path.alert.vo.events.event.IndividualReportIdEventCO;
import com.path.alert.vo.reportquery.ReportQueryCO;
import com.path.alert.vo.service.AlertServiceSC;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_EVT_BATCH_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_INTRNLVO;
import com.path.dbmaps.vo.ALRT_EVT_COMM_MODE_ARG_MAPVO;
import com.path.dbmaps.vo.ALRT_EVT_GRPVO;
import com.path.dbmaps.vo.ALRT_EVT_PKGVOKey;
import com.path.dbmaps.vo.ALRT_TAGS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;
import com.path.vo.reporting.SQL_OBJECT;

public class IndividualEventDAOImpl extends BaseDAO implements IndividualEventDAO
{

    @Override
    public Integer indEventCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.IndividualEventResMap");
	return ((Integer) getSqlMap().queryForObject("individualEventMapper.individualEventCount", indEventSC))
		.intValue();
	// return nb;
    }

    @Override
    public List<IndividualEventListCO> indEventList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.IndividualEventResMap");
	List<IndividualEventListCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("individualEventMapper.individualEventList", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("individualEventMapper.individualEventList", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
	return lst;
    }

    @Override
    public String fixedEventDescription(IndividualEventSC indEventSC) throws DAOException
    {

	return ((String) getSqlMap().queryForObject("individualFixedEventMapper.fixedEventDescription",
		indEventSC));
    }

    @Override
    public String reportEventDesc(IndividualEventSC indEventSC) throws DAOException
    {

	return ((String) getSqlMap().queryForObject("individualReportEventMapper.reportDescEvent", indEventSC));
    }

    @Override
    public Integer returnevtsubCount(IndividualEventSC indEventSC) throws DAOException
    {

	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.returnevtsubCount", indEventSC))
		.intValue();
	// return nb;
    }

    @Override
    public Integer evtsubCount(IndividualEventSC indEventSC) throws DAOException
    {

	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.evtsubCount", indEventSC))
		.intValue();
    }

    @Override
    public String fixedEventDescriptionMemo(IndividualEventSC indEventSC) throws DAOException
    {
	String desc;
	desc = ((String) getSqlMap().queryForObject("individualFixedEventMapper.fixedEventDescriptionMemo",
		indEventSC));
	return desc;
    }

    @Override
    public String fixedEventDescriptionReport(IndividualEventSC indEventSC) throws DAOException
    {

	return ((String) getSqlMap().queryForObject("individualFixedEventMapper.fixedEventDescriptionReport",
		indEventSC));
    }

    @Override
    public String returnTagName(IndividualEventSC indEventSC) throws DAOException
    {

	return ((String) getSqlMap().queryForObject("individualEventMapper.returnTagName", indEventSC));
    }

    @Override
    public Integer fixedEventCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.IndividualFixedEventResMap");
	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.fixedEventCount", indEventSC))
		.intValue();
	// return nb;
    }

    @Override
    public Integer reportEventCount(IndividualEventSC indEventSC) throws DAOException
    {
	int nb;
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualReportEventMapper.IndividualReportEventResMap");
	nb = ((Integer) getSqlMap().queryForObject("individualReportEventMapper.reportEventCount", indEventSC))
		.intValue();
	return nb;
    }

    @Override
    public Integer returnfixedIdCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.IndividualFixedEventResMap");
	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.returnfixedIdCount", indEventSC))
		.intValue();
	// return nb;
    }

    @Override
    public Integer returnmemoIdCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.IndividualFixedEventResMap");
	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.returnmemoIdCount", indEventSC))
		.intValue();
	// return nb;
    }

    @Override
    public List<IndividualFixedEventListCO> fixedEventList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.IndividualFixedEventResMap");
	List<IndividualFixedEventListCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("individualFixedEventMapper.fixedEventList", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("individualFixedEventMapper.fixedEventList", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
	return lst;
    }
    
    @Override
    public List<SelectCO> fixedEventListSelectCO(IndividualEventSC indEventSC) throws DAOException
    {
	if(indEventSC.getSortOrder() == null)
	{
	    indEventSC.setSortOrder(" ORDER BY ID ASC");
	}
	return getSqlMap().queryForList("individualFixedEventMapper.fixedEventListSelectCO", indEventSC);
    }

    @Override
    public List<IndividualReportIdEventCO> reportEventList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualReportEventMapper.IndividualReportEventResMap");
	List<IndividualReportIdEventCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("individualReportEventMapper.reportIdEvent", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("individualReportEventMapper.reportIdEvent", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
	return lst;
    }

    @Override
    public Integer memoCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "memoEventMapper.MemoEventResMap");
	return ((Integer) getSqlMap().queryForObject("memoEventMapper.memoCount", indEventSC)).intValue();
	// return nb;
    }

    @Override
    public List<IndividualMemoListCO> memoList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "memoEventMapper.MemoEventResMap");
	List<IndividualMemoListCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("memoEventMapper.memoList", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("memoEventMapper.memoList", indEventSC, indEventSC.getRecToskip(),
		    indEventSC.getNbRec());
	}
	return lst;
    }

    @Override
    public Integer indParamCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.IndFixedParamResMap");
	return ((Integer) getSqlMap().queryForObject("individualEventMapper.indParamCount", indEventSC))
		.intValue();
	// return nb;
    }

    public List<IndFixedParamListCO> indParamList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.IndFixedParamResMap");
	List<IndFixedParamListCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("individualEventMapper.indFixedParamList", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("individualEventMapper.indFixedParamList", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
	return lst;
    }

    public ArrayList<AlrtTagsCO> alrttagList(IndividualEventSC indEventSC) throws DAOException
    {
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.AlrtTagsResMap");
		if(indEventSC.getNbRec() == -1)
		{
		    return (ArrayList<AlrtTagsCO>) getSqlMap().queryForList("individualEventMapper.arltTagsList", indEventSC);
		}
		else
		{
		    return (ArrayList<AlrtTagsCO>) getSqlMap().queryForList("individualEventMapper.arltTagsList", indEventSC,
			    indEventSC.getRecToskip(), indEventSC.getNbRec());
		}
    }

    @Override
    public Integer indTagsCount(IndividualEventSC indEventSC) throws DAOException
    {

	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.AlrtTagsResMap");
	return ((Integer) getSqlMap().queryForObject("individualEventMapper.indTagsCount", indEventSC)).intValue();
	// return nb;
    }

    public void updatesubscriptions(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.updatesubscriptions", individualEventCO);
    }

    public IndividualEventCO loadDataFromDb(IndividualEventSC indEventSC) throws DAOException
    {
	return (IndividualEventCO) getSqlMap().queryForObject("individualEventMapper.loadDataFromDb", indEventSC);
    }

    public List<IndFixedParamListCO> retrieveFixedParam(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.indParamResMap");
	return (List<IndFixedParamListCO>) getSqlMap().queryForList("individualEventMapper.retrieveFixedParam",
		indEventSC);
    }

    public IndFixedParamListCO RetrievefixedEvent(IndividualEventSC indEventSC) throws DAOException
    {
	return (IndFixedParamListCO) getSqlMap().queryForObject("individualEventMapper.retrievefixedEvent", indEventSC);
    }

    @Override
    public int relatedSubCount(IndividualEventSC indEventSC) throws DAOException
    {

	return ((Integer) getSqlMap().queryForObject("individualEventMapper.relatedSubCount", indEventSC))
		.intValue();
    }

    @Override
    public List<ALRT_EVT_GRPVO> returnEventByGrpId(IndividualEventCO individualEventCO) throws DAOException
    {
	return ((List<ALRT_EVT_GRPVO>) getSqlMap().queryForList("individualEventMapper.returnEventByGrpId",
		individualEventCO));
    }

    @Override
    public List<ALRT_EVT_PKGVOKey> returnEventByPkgId(IndividualEventCO individualEventCO) throws DAOException
    {
	return ((List<ALRT_EVT_PKGVOKey>) getSqlMap().queryForList("individualEventMapper.returnEventByPkgId",
		individualEventCO));
    }

    @Override
    public void deleteSbtParam(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.deleteSbtParam", individualEventCO);
    }

    @Override
    public void deleteSubParam(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.deleteSubParam", individualEventCO);
    }

    @Override
    public void deleteSubEvt(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.deleteSubEvt", individualEventCO);
    }

    @Override
    public void deleteSubEvtSE(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.deleteSubEvtSE", individualEventCO);
    }

    @Override
    public void updateSubEvt(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.updateSubEvt", individualEventCO);
    }

    @Override
    public void updateGrpEvt(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.updateGrpEvt", individualEventCO);
    }

    @Override
    public void deleteEvtPkg(IndividualEventCO individualEventCO) throws DAOException
    {
	getSqlMap().queryForObject("individualEventMapper.deleteEvtPkg", individualEventCO);
    }

    @Override
    public Integer returnreportIdCount(IndividualEventSC indEventSC) throws DAOException
    {
	int nb;
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualReportEventMapper.IndividualReportEventResMap");
	nb = ((Integer) getSqlMap().queryForObject("individualReportEventMapper.returnreportIdCount", indEventSC))
		.intValue();
	return nb;
    }

	@Override
	public List<String> returnEventReportColumns(IndividualEventCO individualEventCO) throws DAOException 
	{
		List<String> listOfColumns = new ArrayList<String>();
		try {
				ReportQueryCO quer = ((ReportQueryCO) getSqlMap().queryForObject("individualReportEventMapper.reportQueryEvent", individualEventCO));
				if (quer == null) 
				{
					return listOfColumns;
				} 
				else 
				{
					try {
							fillSqlObj(quer);
						} 
						catch (ClassNotFoundException e) 
						{
							throw new DAOException(e.getMessage());
						} 
						catch (IOException e) 
						{
							throw new DAOException(e.getMessage());
						}
						// return query;
	
						String query = quer.getSqlObject().getSqbSyntax().toString();
						int ind = query.toUpperCase().indexOf("where".toUpperCase(), 1);
						if (ind != -1) 
						{
							query = query.substring(0, query.toUpperCase().indexOf("where".toUpperCase()));
						}
						Connection con =getSqlMap().returnConnection();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnCount = rsmd.getColumnCount();
						
						if (columnCount > 0)
			            {
			                for (int i = 1; i <= columnCount; i++)
			                {
			                	listOfColumns.add(rsmd.getColumnLabel(i));
			                }
			            }
				}
			} 
			catch (SQLException e) 
			{
				throw new DAOException(e.getMessage());
			}
			return listOfColumns;
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

		    // fill arguments
		    parentNodeLst = qryElem.getElementsByTagName("args");
		    parentNode = parentNodeLst.item(0);
		    if(parentNode.getNodeType() == Node.ELEMENT_NODE)
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
		    if(parentNode.getNodeType() == Node.ELEMENT_NODE)
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

    //Raed Saad - User Story #592675 Get Alert Events - 14.1
	@Override
	public List<IndividualEventListCO> getAlertEvents(AlertServiceSC alertServiceSC) throws BaseException {
		return ((List<IndividualEventListCO>) getSqlMap().queryForObject("individualEventMapper.selectServiceIndividualEvent",
				alertServiceSC));
	}
	//Raed Saad -END- User Story #592675 Get Alert Events - 14.1
	
	@Override
	public void deleteAllOtherLang(IndividualEventCO individualEventCO) throws DAOException
	{
		getSqlMap().delete("individualEventMapper.deleteAllOtherLang", individualEventCO);
	}
	
	@Override
	public List<IndividualEventCO> loadOtherLangListGrid(IndividualEventCO individualEventCO) throws DAOException
	{
		return getSqlMap().queryForList("individualEventMapper.loadOtherLangListGrid", individualEventCO);
	}
	
	@Override
	public List<IndividualEventCO> loadOtherLangBodyListGrid(IndividualEventCO individualEventCO) throws DAOException
	{
		return getSqlMap().queryForList("individualEventMapper.loadOtherLangBodyListGrid", individualEventCO);
	}
	
	@Override
	public void deleteAllEventParamSet(IndividualEventCO individualEventCO) throws DAOException
	{
		getSqlMap().delete("individualEventMapper.deleteAllEventParamSet", individualEventCO);
	}
	
	@Override
	public int returnEventModeListCount(IndividualEventSC sc) throws DAOException
	{
		DAOHelper.fixGridMaps(sc, getSqlMap(), "individualEventMapper.resEventModeLkupMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("individualEventMapper.returnEventModeListCount", sc)).intValue();
		return nb;
	}

	@Override
    public List<SYS_PARAM_LOV_TRANSVO> returnEventModeList(IndividualEventSC sc) throws DAOException
    {
		DAOHelper.fixGridMaps(sc, getSqlMap(), "individualEventMapper.resEventModeLkupMap");
		return getSqlMap().queryForList("individualEventMapper.returnEventModeList", sc,
			sc.getRecToskip(), sc.getNbRec());
    }
    
    @Override
    public List<SYS_PARAM_LOV_TRANSVO> loadAssignedModeListGrid(IndividualEventCO individualEventCO) throws DAOException
    {
    	return getSqlMap().queryForList("individualEventMapper.loadAssignedModeListGrid", individualEventCO);
    }
    
    @Override
    public void deleteRelatedAlertEventOmniMode(IndividualEventCO individualEventCO) throws DAOException
    {
    	getSqlMap().delete("individualEventMapper.deleteRelatedAlertEventOmniMode", individualEventCO);
    }
    
    @Override
    public List individualEventServiceList(IndividualEventSC sc) throws DAOException
    {
	return getSqlMap().queryForList("individualEventMapper.individualEventServiceList", sc);
    }
    
    @Override
    public Integer emailTemplateCount(IndividualEventSC indEventSC) throws DAOException
    {
    	
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.EmailTemplateResMap");
	return ((Integer) getSqlMap().queryForObject("individualFixedEventMapper.emailTemplateCount", indEventSC))
		.intValue();
    }

    @Override
    public List<IndividualFixedEventListCO> emailTemplateList(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualFixedEventMapper.EmailTemplateResMap");
	List<IndividualFixedEventListCO> lst;
	if(indEventSC.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("individualFixedEventMapper.emailTemplateList", indEventSC);
	}
	else
	{
	    lst = getSqlMap().queryForList("individualFixedEventMapper.emailTemplateList", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
	return lst;
    }

    
    
    @Override
    public IndividualEventCO dependencyByEmailTemplateId(IndividualEventCO individualEventCO) throws DAOException
    {
	return (IndividualEventCO) getSqlMap().queryForObject("individualFixedEventMapper.dependencyByEmailTemplateId",
		individualEventCO);
    }
    
    /**
     * @author Alim Khowaja
     */
    
    @Override
    public Integer returnIndividualEventCountForGrid(IndividualEventSC indEventSC) throws DAOException
    {
		int nb;
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.individualEventListResultMap");
		nb = ((Integer) getSqlMap().queryForObject("individualEventMapper.returnIndividualEventSelectCount", indEventSC)).intValue();
		return nb;
    }

    @Override
    public List<IndividualEventListCO> returnIndividualEventListForGrid(IndividualEventSC indEventSC) throws DAOException
    {
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.individualEventListResultMap");
		List<IndividualEventListCO> lst;
		if(indEventSC.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("individualEventMapper.returnIndividualEventSelectList", indEventSC);
		}
		else
		{
		    lst = getSqlMap().queryForList("individualEventMapper.returnIndividualEventSelectList", indEventSC,
			    indEventSC.getRecToskip(), indEventSC.getNbRec());
		}
		return lst;
    }
    
    @Override
    public IndividualEventCO returnIndividualEventByEventId(IndividualEventSC indEventSC) throws DAOException
    {
    	return (IndividualEventCO) getSqlMap().queryForObject("individualEventMapper.returnIndividualEventByEventIdSelect",	indEventSC);
    }
    
    @Override
	public Integer saveAlrtTagsDef(ALRT_TAGS_DEFVO alrt_TAGS_DEFVO) throws DAOException
    {
    	return (Integer) getSqlMap().insert("individualEventMapper.insertIndividualEvent", alrt_TAGS_DEFVO);
	}

	@Override
    public ArrayList<ALRT_TAGS_DEFVO> returnIndEventCustomDefaultTagList(IndividualEventSC indEventSC) throws DAOException
    {
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.indEventCustomDefaultTagsMap");
		if(indEventSC.getNbRec() == -1)
		{
		    return (ArrayList<ALRT_TAGS_DEFVO>) getSqlMap().queryForList("individualEventMapper.returnIndEventCustomDefaultTagList", indEventSC);
		}
		else
		{
		    return (ArrayList<ALRT_TAGS_DEFVO>) getSqlMap().queryForList("individualEventMapper.returnIndEventCustomDefaultTagList", indEventSC,
			    indEventSC.getRecToskip(), indEventSC.getNbRec());
		}
    }
    
    @Override
   	public int returnIndEventCustomDefaultTagListCount(IndividualEventSC sc) throws DAOException
   	{
   		DAOHelper.fixGridMaps(sc, getSqlMap(), "individualEventMapper.indEventCustomDefaultTagsMap");
   		int rows =  ((Integer) getSqlMap().queryForObject("individualEventMapper.returnIndEventCustomDefaultTagListCount", sc)).intValue();
   		return rows;
   	}
    
    @Override
    public void deleteAlrtEventCommModeArgMap(IndividualEventSC sc) throws DAOException
    {
    	getSqlMap().delete("individualEventMapper.deleteAlrtEventCommModeArgMap", sc);
    }

	@Override
	public Integer returnCheckIsUniqueEventDescription(IndividualEventSC indEventSC) throws DAOException {
		Integer rows =  ((Integer) getSqlMap().queryForObject("individualEventMapper.returnCheckIsUniqueEventDescriptionSelect", indEventSC)).intValue();
   		return rows;
	}
    
    @Override
    public void deleteAllBatchArgMap(IndividualEventSC sc) throws DAOException
    {
	getSqlMap().delete("individualEventMapper.deleteAllBatchArgMap", sc);
    }
    @Override
    public List<ALRT_EVT_BATCH_ARG_MAPVO> returnAlrtEvtBatchArg(IndividualEventSC sc) throws DAOException
    {
	return (List<ALRT_EVT_BATCH_ARG_MAPVO>) getSqlMap().queryForList("individualEventMapper.returnAlrtEvtBatchArg", sc);
    }
    
    @Override
    public Integer returnAlertTagsSelectCount(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.AlrtTagsResMap");
	int rows = ((Integer) getSqlMap().queryForObject("individualEventMapper.returnAlertTagsSelectCount", indEventSC))
		.intValue();
	return rows;
    }
    
    @Override
    public List<AlrtTagsCO> returnAlertTagsSelect(IndividualEventSC indEventSC) throws DAOException
    {
	DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.AlrtTagsResMap");
	if(indEventSC.getNbRec() == -1)
	{
	    return (ArrayList<AlrtTagsCO>) getSqlMap().queryForList("individualEventMapper.returnAlertTagsSelect", indEventSC);
	}
	else
	{
	    return (ArrayList<AlrtTagsCO>) getSqlMap().queryForList("individualEventMapper.returnAlertTagsSelect", indEventSC,
		    indEventSC.getRecToskip(), indEventSC.getNbRec());
	}
    }
    
    @Override
	public List<ALRT_EVT_COMM_MODE_ARG_MAPVO> returnAttachReportMappingArgument(IndividualEventSC sc) throws DAOException 
    {
		return (List<ALRT_EVT_COMM_MODE_ARG_MAPVO>) getSqlMap().queryForList("individualEventMapper.individualEventAttachReportParamMappingSelectList", sc);
	}
    
	@Override
	public Integer saveCommunicationModeMappingArguments(ALRT_EVT_COMM_MODE_ARG_MAPVO alrt_EVT_COMM_MODE_ARG_MAPVO) throws DAOException
    {
    	return (Integer) getSqlMap().insert("individualEventMapper.insertIndividualEventParameterMaping", alrt_EVT_COMM_MODE_ARG_MAPVO);
	}
	
	
    @Override
	public List<UsrCO> returnIndividualEventUsrReportsListForEvent(IndividualEventSC sc) throws DAOException 
    {
		return (List<UsrCO>) getSqlMap().queryForList("individualEventMapper.individualEventUsrReportsListForEvent", sc);
	}
    
    @Override
    public Integer returnIndividualEventListForPackageCount(IndividualEventSC indEventSC) throws DAOException
    {
		int nb;
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.individualEventListResultMap");
		nb = ((Integer) getSqlMap().queryForObject("individualEventMapper.returnIndividualEventListForPackageCount", indEventSC)).intValue();
		return nb;
    }

    @Override
    public List<IndividualEventListCO> returnIndividualEventListForPackageList(IndividualEventSC indEventSC) throws DAOException
    {
		DAOHelper.fixGridMaps(indEventSC, getSqlMap(), "individualEventMapper.individualEventListResultMap");
		List<IndividualEventListCO> lst;
		if(indEventSC.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("individualEventMapper.returnIndividualEventListForPackageList", indEventSC);
		}
		else
		{
		    lst = getSqlMap().queryForList("individualEventMapper.returnIndividualEventListForPackageList", indEventSC,
			    indEventSC.getRecToskip(), indEventSC.getNbRec());
		}
		return lst;
    }
    
    @Override
    public Integer saveALRT_EVT(ALRT_EVTVO alrt_EVTVO) throws DAOException
    {
    	return (Integer) getSqlMap().insert("individualEventMapper.saveALRT_EVT", alrt_EVTVO);
    }


    @Override
    public ALRT_EVT_COMM_INTRNLVO returnInternalEventDetailsByEvtId(IndividualEventSC indEventSC) throws DAOException
    {
	return (ALRT_EVT_COMM_INTRNLVO) getSqlMap().queryForObject("individualEventMapper.internalEventAlertlist", indEventSC);
    }
    
    
}
