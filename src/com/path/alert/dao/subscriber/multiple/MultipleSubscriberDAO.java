package com.path.alert.dao.subscriber.multiple;

import java.util.List;

import com.path.alert.vo.subscriber.multiple.MultipleSubscriberCO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberSC;
import com.path.lib.common.exception.DAOException;

public interface MultipleSubscriberDAO
{
	
	/**
     * 
     * @param indSubSC
     * @return
     * @throws DAOException
     */
    public List<MultipleSubscriberCO> returnMultiSubscriberListForGrid(MultipleSubscriberSC  multipleSubscriberSC) throws DAOException;
    
	/**
	 * 
	 * @param indSubSC
	 * @return
	 * @throws DAOException
	 */
	public Integer returnMultiSubscriberCountForGrid(MultipleSubscriberSC multipleSubscriberSC) throws DAOException;
    
	/**
	 * Update Multiple Subscriber
	 * @param multipleSubscriberCO
	 * @throws DAOException
	 */
	public void updateMultipleSubscriber(MultipleSubscriberCO multipleSubscriberCO) throws DAOException;
    
}
