package com.path.alert.dao.subscriber.individual.impl;

import java.util.List;

import com.path.alert.dao.subscriber.individual.IndividualSubscriberDAO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberListCO;
import com.path.alert.vo.subscriber.individual.IndividualSubscriberSC;
import com.path.dbmaps.vo.ALRT_EVTVO;
import com.path.dbmaps.vo.ALRT_SUBVO;
import com.path.dbmaps.vo.ALRT_SUB_LANGVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.core.cif.CifSC;

public class IndividualSubscriberDAOImpl extends BaseDAO implements IndividualSubscriberDAO
{

    @Override
    public Integer indSubscriberCount(IndividualSubscriberSC indSubSC) throws DAOException
    {
		
		DAOHelper.fixGridMaps(indSubSC, getSqlMap(), "individualSubscriberMapper.IndividualSubscriberResMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.returnIndividualSubscriberCount",
			indSubSC)).intValue();
		// return nb;
    }

    @Override
    public List<IndividualSubscriberListCO> indSubscriberList(IndividualSubscriberSC indSubSC) throws DAOException
    {
		DAOHelper.fixGridMaps(indSubSC, getSqlMap(), "individualSubscriberMapper.IndividualSubscriberResMap");
		List<IndividualSubscriberListCO> lst;
		if(indSubSC.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.returnIndividualSubscriberList", indSubSC);
		}
		else
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.returnIndividualSubscriberList", indSubSC, indSubSC.getRecToskip(), indSubSC.getNbRec());
		}
		return lst;
    }

    @Override
    public int returnCifCount(IndividualSubscriberSC criteria) throws DAOException
    {
		
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.returnCifCount", criteria))
			.intValue();
    }

    @Override
    public int retrieveCifDetailsCount(IndividualSubscriberSC criteria) throws DAOException
    {
		
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.CifDetailsResMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.retrieveCifDetailsCount",
			criteria)).intValue();
		// return nb;
    }

    @Override
    public IndividualSubscriberCO retrieveCifDetailsList(IndividualSubscriberSC criteria) throws DAOException
    {
		return (IndividualSubscriberCO) getSqlMap().queryForObject("individualSubscriberMapper.retrieveCifDetailsList",
			criteria);
    }

    @Override
    public CIF_ADDRESSVO returnCifAddressDetails(IndividualSubscriberSC criteria) throws DAOException
    {
		return (CIF_ADDRESSVO) getSqlMap().queryForObject("individualSubscriberMapper.returnCifAddressDetails",
			criteria);

    }

    @Override
    public int cifIsSubscriberCount(IndividualSubscriberSC criteria) throws DAOException
    {
		
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.cifIsSubscriberCount", criteria))
			.intValue();
    }

    @Override
    public int returnUsrCount(IndividualSubscriberSC criteria) throws DAOException
    {
		
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.returnUsrCount", criteria))
			.intValue();
    }

    @Override
    public int retrieveUsrDetailsCount(IndividualSubscriberSC criteria) throws DAOException
    {
		
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.UserDetailsResMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.retrieveUsrDetailsCount",
			criteria)).intValue();
		// return nb;
    }

    @Override
    public IndividualSubscriberCO retrieveUsrDetails(IndividualSubscriberSC criteria) throws DAOException
    {
		return (IndividualSubscriberCO) getSqlMap().queryForObject("individualSubscriberMapper.retrieveUsrDetails",
			criteria);
    }

    public int cifLookupQueryListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.cifLookupQueryListMap");
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.cifLookupQueryListCount", criteria))
		.intValue();
    }

    public List cifLookupQueryList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("individualSubscriberMapper.cifLookupQueryList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.cifLookupQueryListMap");
	    return getSqlMap().queryForList("individualSubscriberMapper.cifLookupQueryList", criteria,criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public int usrStatusCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.usrStatusCount", criteria))
		.intValue();
    }

    @Override
    public int usrIsSubscriberCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.usrIsSubscriberCount", criteria))
		.intValue();
    }

    @Override
    public int amfSubscriberCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.amfSubscriberCount", criteria))
		.intValue();
    }

    @Override
    public int checkIfSubscriberCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.checkIfSubscriberCount",
		criteria)).intValue();
    }

    @Override
    public String returnAddRef(IndividualSubscriberSC criteria) throws DAOException
    {
	return (String) getSqlMap().queryForObject("individualSubscriberMapper.returnAddRef", criteria);
    }

    @Override
    public int retrieveAccDetailsCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.AccDetailsResMap");
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.retrieveAccDetailsCount",
		criteria)).intValue();
	// return nb;
    }

    @Override
    public IndividualSubscriberCO retrieveAccDetails(IndividualSubscriberSC criteria) throws DAOException
    {
	return (IndividualSubscriberCO) getSqlMap().queryForObject("individualSubscriberMapper.retrieveAccDetails",
		criteria);
    }

    @Override
    public int amfCifSubscriberCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.amfCifSubscriberCount", criteria))
		.intValue();

    }

    @Override
    public int genLedgerCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.genLedgerCount", criteria))
		.intValue();
    }

    @Override
    public int currencySubCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.currencySubCount", criteria))
		.intValue();
    }

    @Override
    public int branchSubCount(IndividualSubscriberSC criteria) throws DAOException
    {
	
	return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.branchSubCount", criteria))
		.intValue();
    }

    @Override
    public IndividualSubscriberCO loadDataFromDb(IndividualSubscriberSC criteria) throws DAOException
    {
		return (IndividualSubscriberCO) getSqlMap().queryForObject("individualSubscriberMapper.returnIndividualSubscriberById",
			criteria);
    }

    @Override
    public int relatedSubscriptionsCount(IndividualSubscriberSC sc) throws DAOException
    {
		
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.relatedSubscriptionsCount", sc))
			.intValue();
    }

    @Override
    public IndividualSubscriberCO loadRelatedForm(IndividualSubscriberSC criteria) throws DAOException
    {
		return (IndividualSubscriberCO) getSqlMap().queryForObject("individualSubscriberMapper.loadRelatedForm",
			criteria);
    }

    @Override
    public IndividualSubscriberSC selectMobileDetails(IndividualSubscriberSC sc) throws DAOException
    {
		// TODO Auto-generated method stub
		return (IndividualSubscriberSC) getSqlMap().queryForObject("individualSubscriberMapper.selectMobileDetails",
			sc);
    }

    @Override
    public ALRT_EVTVO selectEvtParameters(IndividualSubscriberSC sc) throws DAOException
    {
    	return (ALRT_EVTVO) getSqlMap().queryForObject("individualSubscriberMapper.selectEvtParameters", sc);
    }

    @Override
    public ALRT_SUBVO selectCentralizedDetails(IndividualSubscriberSC sc) throws DAOException
    {
    	return (ALRT_SUBVO) getSqlMap().queryForObject("individualSubscriberMapper.selectCentralizedDetails", sc);
    }

    @Override
    public String selectCifLanguage(IndividualSubscriberSC sc) throws DAOException
    {
    	return (String) getSqlMap().queryForObject("individualSubscriberMapper.selectCifLanguage", sc);
    }

    @Override
    public String selectUsrLanguage(IndividualSubscriberSC sc) throws DAOException
    {
    	return (String) getSqlMap().queryForObject("individualSubscriberMapper.selectUsrLanguage", sc);
    }

    @Override
    public Integer accountListCount(CifSC criteria) throws DAOException
    {
		
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.accountLookupResMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.accountListCount", criteria)).intValue();
    }

    @Override
    public List accountList(CifSC criteria) throws DAOException
    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.accountLookupResMap");
		List<IndividualSubscriberListCO> lst;
		if(criteria.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.accountList", criteria);
		}
		else
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.accountList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
		return lst;
    }

    @Override
    public Integer getUserLookupCount(UsrSC usrSC) throws DAOException
    {
		
		DAOHelper.fixGridMaps(usrSC, getSqlMap(), "individualSubscriberMapper.userLookupResMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.userLookupCount", usrSC))
			.intValue();
    }

    @Override
    public List<IndividualSubscriberListCO> getUserLookupList(UsrSC usrSC) throws DAOException
    {
		DAOHelper.fixGridMaps(usrSC, getSqlMap(), "individualSubscriberMapper.userLookupResMap");
		List<IndividualSubscriberListCO> lst;
		if(usrSC.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.userLookupList", usrSC);
		}
		else
		{
		    lst = getSqlMap().queryForList("individualSubscriberMapper.userLookupList", usrSC, usrSC.getRecToskip(),
			    usrSC.getNbRec());
		}
		return lst;
    }

    @Override
	public void deleteOtherLanguageDetails(IndividualSubscriberSC sc) throws DAOException
	{
		getSqlMap().delete("individualSubscriberMapper.deleteOtherLanguageDetails", sc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ALRT_SUB_LANGVO> returnIndividualSubscriberOtherLanguageList(IndividualSubscriberSC criteria) throws DAOException 
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.individualSubscriberOtherLanguageListMap");
		List<ALRT_SUB_LANGVO> individualSubscriberOtherLanguageList = null;
		if(criteria.getNbRec() == -1)
		{
			individualSubscriberOtherLanguageList = getSqlMap().queryForList("individualSubscriberMapper.returnIndividualSubscriberOtherLanguageList", criteria);
		}
		else
		{
			individualSubscriberOtherLanguageList = getSqlMap().queryForList("individualSubscriberMapper.returnIndividualSubscriberOtherLanguageList", criteria, 
		    		criteria.getRecToskip(), criteria.getNbRec());
		}
		return individualSubscriberOtherLanguageList;
	}

	@Override
	public Integer returnIndividualSubscriberOtherLanguageListCount(IndividualSubscriberSC criteria) throws DAOException 
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "individualSubscriberMapper.individualSubscriberOtherLanguageListMap");
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.returnIndividualSubscriberOtherLanguageListCount", criteria)).intValue();
	}
	
	@Override
	public void deleteAlertSubAccounts(IndividualSubscriberSC sc) throws DAOException
	{
		getSqlMap().delete("individualSubscriberMapper.deleteAlertSubAccounts", sc);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List returnIndividualSubscriberMultipleAccountsList(IndividualSubscriberSC criteria) throws DAOException 
	{
		List<IndividualSubscriberCO> individualSubscriberOtherLanguageList = getSqlMap().queryForList("individualSubscriberMapper.returnIndividualSubscriberMultipleAccountList", criteria);
		return individualSubscriberOtherLanguageList;
	}
	
	@Override
	public Integer returnSubscriberByCifCount(IndividualSubscriberSC individualSubscriberSC) throws DAOException {
		return ((Integer) getSqlMap().queryForObject("individualSubscriberMapper.returnSubscriberByCifCount",
			individualSubscriberSC)).intValue();
	}
	
    @Override
    public Integer saveALRT_SUBVO(ALRT_SUBVO alrt_SUBVO) throws DAOException
    {
    	return (Integer) getSqlMap().insert("individualSubscriberMapper.saveALRT_SUBVO", alrt_SUBVO);
    }
}
