package com.path.alert.dao.events.event.impl;

import java.util.List;

import com.path.alert.dao.events.event.OtherLanguagesDAO;
import com.path.alert.vo.events.event.OtherLanguagesCO;
import com.path.alert.vo.events.event.OtherLanguagesSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class OtherLanguagesDAOImpl extends BaseDAO implements OtherLanguagesDAO
{

    @Override
    public int returnOtherLanguagesListCount(OtherLanguagesSC otherLanguagesSC) throws DAOException
    {
		DAOHelper.fixGridMaps(otherLanguagesSC, getSqlMap(), "otherLanguagesMapper.otherLanguagesMap");
		return (Integer) getSqlMap().queryForObject("otherLanguagesMapper.returnOtherLanguagesListCount", otherLanguagesSC);
    }
    
    @Override
    public List<OtherLanguagesCO> returnOtherLanguagesListRec(OtherLanguagesSC otherLanguagesSC) throws DAOException
    {
		DAOHelper.fixGridMaps(otherLanguagesSC, getSqlMap(), "otherLanguagesMapper.otherLanguagesMap");
		if(otherLanguagesSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("otherLanguagesMapper.returnOtherLanguagesListRec", otherLanguagesSC);
		}
		else
		{
		    return getSqlMap().queryForList("otherLanguagesMapper.returnOtherLanguagesListRec", otherLanguagesSC,
			    otherLanguagesSC.getRecToskip(), otherLanguagesSC.getNbRec());
		}
    }
}
