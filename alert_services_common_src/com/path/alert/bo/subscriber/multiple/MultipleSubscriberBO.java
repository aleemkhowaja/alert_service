package com.path.alert.bo.subscriber.multiple;

import java.util.List;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberCO;
import com.path.alert.vo.subscriber.multiple.MultipleSubscriberSC;
import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:
 * 
 * 
 */
public interface MultipleSubscriberBO {

	/**
	 * 
	 * @param multipleSubscriberSC
	 * @return
	 * @throws BaseException
	 */
    public List<MultipleSubscriberCO> returnMultiSubscriberListForGrid(MultipleSubscriberSC  multipleSubscriberSC) throws BaseException;
    
	/**
	 * 
	 * @param multipleSubscriberSC
	 * @return
	 * @throws BaseException
	 */
	public Integer returnMultiSubscriberCountForGrid(MultipleSubscriberSC multipleSubscriberSC) throws BaseException;
	
	/**
	 * save multiple subscribers
	 * @param multipleSubscriberCO
	 * @throws BaseException
	 */
	public void save(MultipleSubscriberCO multipleSubscriberCO) throws BaseException;
	
	/**
	 * approve multiple subscribers
	 * @param multipleSubscriberCO
	 * @throws BaseException
	 */
	public MultipleSubscriberCO approve(MultipleSubscriberCO multipleSubscriberCO) throws BaseException;
	
}
