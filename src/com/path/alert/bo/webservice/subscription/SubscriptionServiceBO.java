package com.path.alert.bo.webservice.subscription;

import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ApproveSingleSubscriptionResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGEReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGEResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGPReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionGPResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSEReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSEResp;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSPReq;
import com.path.vo.alert.subscription.CreateSingleSubscriptionSPResp;
import com.path.vo.alert.subscription.DeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.DeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionReq;
import com.path.vo.alert.subscription.ReactiveSingleSubscriptionResp;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionReq;
import com.path.vo.alert.subscription.RejectDeleteSingleSubscriptionResp;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsReq;
import com.path.vo.alert.subscription.ReturnSubscriptionDetailsResp;
import com.path.vo.alert.subscription.ReturnSubscriptionListReq;
import com.path.vo.alert.subscription.ReturnSubscriptionListResp;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionReq;
import com.path.vo.alert.subscription.SuspendSingleSubscriptionResp;

public interface SubscriptionServiceBO {	
	
	/**
	 * 
	 * @param createSingleSubscriptionSEReq
	 * @return
	 * @throws Exception
	 */
	public CreateSingleSubscriptionSEResp createSingleSubscribtionSE(CreateSingleSubscriptionSEReq createSingleSubscriptionSEReq)throws Exception;
	
	/**
	 * 
	 * @param createSingleSubscriptionSPReq
	 * @param autoApproveFlag
	 * @return
	 * @throws Exception
	 */
	public CreateSingleSubscriptionSPResp createSingleSubscribtionSP(CreateSingleSubscriptionSPReq  createSingleSubscriptionSPReq, String autoApproveFlag)throws Exception;
	
	/**
	 * 
	 * @param createSingleSubscriptionGPReq
	 * @return
	 * @throws Exception
	 */
	public CreateSingleSubscriptionGPResp createSingleSubscribtionGP(CreateSingleSubscriptionGPReq createSingleSubscriptionGPReq)throws Exception;
	
	/**
	 * 
	 * @param createSingleSubscriptionGEReq
	 * @return
	 * @throws Exception
	 */
	public CreateSingleSubscriptionGEResp createSingleSubscribtionGE(CreateSingleSubscriptionGEReq createSingleSubscriptionGEReq)throws Exception;
	
	/**
	 * 
	 * @param approveSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public ApproveSingleSubscriptionResp approveSingleSubscribtion(ApproveSingleSubscriptionReq approveSingleSubscriptionReq)throws Exception;
	
	/**
	 * to be deleted
	 * @param deleteSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public DeleteSingleSubscriptionResp deleteSingleSubscribtion(DeleteSingleSubscriptionReq deleteSingleSubscriptionReq)throws Exception;
	
	/**
	 * reject to be deleted
	 * @param rejectDeleteSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public RejectDeleteSingleSubscriptionResp rejectDeleteSingleSubscription(RejectDeleteSingleSubscriptionReq rejectDeleteSingleSubscriptionReq) throws Exception;
	
	/**
	 * 
	 * @param suspendSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public SuspendSingleSubscriptionResp suspandSingleSubscribtion(SuspendSingleSubscriptionReq suspendSingleSubscriptionReq)throws Exception;
	
	/**
	 * 
	 * @param reactiveSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public ReactiveSingleSubscriptionResp reactiveSingleSubscribtion(ReactiveSingleSubscriptionReq reactiveSingleSubscriptionReq)throws Exception;
	
	/**
	 * 
	 * @param approveDeleteSingleSubscriptionReq
	 * @return
	 * @throws Exception
	 */
	public ApproveDeleteSingleSubscriptionResp approveDeletedSingleSubscribtion(ApproveDeleteSingleSubscriptionReq approveDeleteSingleSubscriptionReq)throws Exception;
	
	/**
	 * 
	 * @param returnSubscriptionDetailsReq
	 * @return
	 * @throws Exception
	 */
	public ReturnSubscriptionDetailsResp viewSubsCriptionDetails(ReturnSubscriptionDetailsReq returnSubscriptionDetailsReq)throws Exception;
	
	/**
	 * return Subscription List
	 * @param returnSubscriptionListReq
	 * @return
	 * @throws Exception
	 */
	public ReturnSubscriptionListResp returnSubscriptionList(ReturnSubscriptionListReq returnSubscriptionListReq) throws Exception; 
	
	
}
