package com.path.alert.dao.progref.impl;

import java.util.List;
import com.path.alert.dao.progref.ProgRefDAO;
import com.path.alert.vo.common.ProgRefSC;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class ProgRefDAOImpl extends BaseDAO implements ProgRefDAO
{

    /**
     * return rows count of "ProgRef" from OPT table on specified criteria
     */
    @Override
    public Integer returnProgRefCount(ProgRefSC criteria) throws DAOException
    {

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "progRefMapper.progRefResultMap");
	return ((Integer) getSqlMap().queryForObject("progRefMapper.returnProgRefCount", criteria)).intValue();
    }

    /**
     * return list of "ProgRef" from OPT table on specified criteria
     */
    @Override
    public List<OPTVO> returnProgRefList(ProgRefSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "progRefMapper.progRefResultMap");
	List<OPTVO> lst;

	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("progRefMapper.returnProgRefList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("progRefMapper.returnProgRefList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
	return lst;
    }
}
