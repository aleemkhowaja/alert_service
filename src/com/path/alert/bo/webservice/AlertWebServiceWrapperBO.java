package com.path.alert.bo.webservice;
//Raed Saad - User Story #592675 Get Alert Events - 14.1

import java.util.HashMap;
import java.util.Map;

import com.path.lib.common.exception.BaseException;

public interface AlertWebServiceWrapperBO {	
	
	public HashMap<String,Object>getAlertEvents(HashMap<String,Object> hashIn)throws Exception;	
	
	public HashMap<String,Object>insertAlertQue(HashMap<String,Object> hashIn)throws Exception;
	
	/** By Shahnawaz
	USER STORY #686023 REQ10: Adding 'Alerts and Notifications' at end users interface */
	public HashMap<String,Object> viewSubsCriptionDetails(HashMap<String,Object> hashIn)throws Exception;	
	
	/** By Shahnawaz
	USER STORY #628993 REQ-3: "Channels Services" Fixed Event Type - R14.1*/
	public HashMap<String,Object> returnEventsList(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 * return Event Details
	 * @param hashIn
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Object> returnEventDetails(HashMap<String, Object> hashIn) throws Exception;
	
	/**
	 *  By Alim Khowaja
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> createSubscriber(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> updateSubscriber(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> approveSubscriber(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> deleteSubscriber(HashMap<String,Object> hashIn)throws Exception;
	
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> returnSubscriberList(HashMap<String,Object> hashIn)throws Exception;
	
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> returnSubscriberDetails(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 * Return Subscriber Id by Cif Number or Omni Users
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> returnSubscriberIdByCifOrOmniUser(Map<String, Object> criteria) throws BaseException;
	
	/**
	 * 
	 * USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	 */
	public HashMap<String, Object> createSingleSubscribtionSE(HashMap<String, Object> hashIn) throws Exception; 
	
	/**
	 * 
	 * USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	 */
	public HashMap<String, Object> createSingleSubscribtionSP(HashMap<String, Object> hashIn) throws Exception; 
	
	/**
	 * 
	 * USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	 */
	public HashMap<String, Object> createSingleSubscribtionGP(HashMap<String, Object> hashIn) throws Exception;
	
	/**
	 * 
	 * USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	 */
	public HashMap<String, Object> createSingleSubscribtionGE(HashMap<String, Object> hashIn) throws Exception; 
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> approveSingleSubscribtion(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> deleteSingleSubscribtion(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> suspandSingleSubscribtion(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> reactiveSingleSubscribtion(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> approveDeletedSingleSubscribtion(HashMap<String,Object> hashIn) throws Exception;
	
	/**
	 *  
	 *  USER STORY #686018 REQ-9 : Automatic Creation of Subscriber/Subscriptions based on application event packages
	*/
	public HashMap<String,Object> rejectDeletedSingleSubscription(HashMap<String,Object> hashIn) throws Exception;
	
	/**
	 * 
	 */
	public HashMap<String,Object> returnPackageList(HashMap<String,Object> hashIn)throws Exception;
	
	/**
	 * return all sunsscription SE, GE, SP, GP
	 * @param hashIn
	 * @return
	 * @throws Exception
	 */
	public HashMap<String,Object> returnSubscriptionList(HashMap<String,Object> hashIn)throws Exception;
	
}
