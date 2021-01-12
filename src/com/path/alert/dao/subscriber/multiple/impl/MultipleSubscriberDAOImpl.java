package com.path.alert.dao.subscriber.multiple.impl;

import java.util.List;

import com.path.alert.dao.subscriber.multiple.MultipleSubscriberDAO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberCO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberSC;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;

public class MultipleSubscriberDAOImpl extends BaseDAO implements MultipleSubscriberDAO
{
	
	@Override
	 public List<MultipleSubscriberCO> returnMultiSubscriberListForGrid(MultipleSubscriberSC multipleSubscriberSC) throws DAOException
	 {
		DAOHelper.fixGridMaps(multipleSubscriberSC, getSqlMap(), "multipleSubscriberMapper.multipleSubscriberResMap");
		List<MultipleSubscriberCO> lst;
		
		if(multipleSubscriberSC.getSortOrder() == null)
		{
			multipleSubscriberSC.setSortOrder(" ORDER BY ID DESC");
		}
		
		
		if(multipleSubscriberSC.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("multipleSubscriberMapper.returnMultiSubscriberListForGrid", multipleSubscriberSC);
		}
		else
		{
		    lst = getSqlMap().queryForList("multipleSubscriberMapper.returnMultiSubscriberListForGrid", multipleSubscriberSC, 
		    		multipleSubscriberSC.getRecToskip(), multipleSubscriberSC.getNbRec());
		}
		return lst;
	 }
	 

    @Override
    public Integer returnMultiSubscriberCountForGrid(MultipleSubscriberSC multipleSubscriberSC) throws DAOException
    {
		
		DAOHelper.fixGridMaps(multipleSubscriberSC, getSqlMap(), "multipleSubscriberMapper.multipleSubscriberResMap");
		return ((Integer) getSqlMap().queryForObject("multipleSubscriberMapper.returnMultiSubscriberCountForGrid",
				multipleSubscriberSC)).intValue();
		// return nb;
    }


	@Override
	public void updateMultipleSubscriber(MultipleSubscriberCO multipleSubscriberCO) throws DAOException
	{
		getSqlMap().update("multipleSubscriberMapper.updateMultipleSubscriber", multipleSubscriberCO);
	}
}