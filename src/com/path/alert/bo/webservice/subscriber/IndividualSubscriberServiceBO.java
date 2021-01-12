package com.path.alert.bo.webservice.subscriber;
import java.util.Map;

import com.path.lib.common.exception.BaseException;
/**
 *  By Alim Khowaja
 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
*/
import com.path.vo.alert.subscriber.ApproveSubscriberReq;
import com.path.vo.alert.subscriber.ApproveSubscriberResp;
import com.path.vo.alert.subscriber.CreateSubscriberReq;
import com.path.vo.alert.subscriber.CreateSubscriberResp;
import com.path.vo.alert.subscriber.DeleteSubscriberReq;
import com.path.vo.alert.subscriber.DeleteSubscriberResp;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsReq;
import com.path.vo.alert.subscriber.ReturnSubscriberDetailsResp;
import com.path.vo.alert.subscriber.ReturnSubscribersListReq;
import com.path.vo.alert.subscriber.ReturnSubscribersListResp;
import com.path.vo.alert.subscriber.UpdateSubscriberReq;
import com.path.vo.alert.subscriber.UpdateSubscriberResp;

public interface IndividualSubscriberServiceBO {	
	
	/**
	 * 
	 * @param createSubscriberReq
	 * @return BigDecimal
	 * @throws Exception
	 */
	public CreateSubscriberResp createSubscriber(CreateSubscriberReq createSubscriberReq)throws Exception;
	
	/**
	 * 
	 * @param updateSubscriberReq
	 * @return
	 * @throws Exception
	 */
	public UpdateSubscriberResp updateSubscriber(UpdateSubscriberReq updateSubscriberReq)throws Exception;
	
	/**
	 * 
	 * @param approveSubscriberReq
	 * @return
	 * @throws Exception
	 */
	public ApproveSubscriberResp approveSubscriber(ApproveSubscriberReq approveSubscriberReq)throws Exception;
	
	/**
	 * 
	 * @param deleteSubscriberReq
	 * @return
	 * @throws Exception
	 */
	public DeleteSubscriberResp deleteSubscriber(DeleteSubscriberReq deleteSubscriberReq)throws Exception;
	
	/**
	 * 
	 * @param returnSubscribersListReq
	 * @return
	 * @throws Exception
	 */
	public ReturnSubscribersListResp returnSubscriberList(ReturnSubscribersListReq returnSubscribersListReq)throws Exception;
	
	/**
	 * 
	 * @param returnSubscriberDetailsReq
	 * @return
	 * @throws Exception
	 */
	public ReturnSubscriberDetailsResp returnSubscriberDetails(ReturnSubscriberDetailsReq returnSubscriberDetailsReq)throws Exception;
	
	/**
	 * return Subscriber id and details by userid and cif
	 * @param criteria
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> returnSubscriberIdByCifOrOmniUser(Map<String, Object> criteria) throws BaseException;
	
}
