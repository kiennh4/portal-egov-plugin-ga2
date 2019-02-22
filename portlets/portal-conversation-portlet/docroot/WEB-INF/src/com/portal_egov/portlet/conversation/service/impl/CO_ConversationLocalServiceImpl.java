/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.conversation.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.conversation.model.CO_Category;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.service.base.CO_ConversationLocalServiceBaseImpl;
import com.portal_egov.portlet.conversation.service.persistence.CO_ConversationFinderUtil;
import com.portal_egov.portlet.conversation.util.CO_Constants;

/**
 * The implementation of the c o_ conversation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.conversation.service.CO_ConversationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.conversation.service.base.CO_ConversationLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil
 */
public class CO_ConversationLocalServiceImpl
	extends CO_ConversationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil} to access the c o_ conversation local service.
	 */
	
	public int countAll() throws SystemException{
		return co_ConversationPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return co_ConversationPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return co_ConversationPersistence.countByGroup(groupId);
	}
	
	public int coutByStatusAndCompany(int conversationStatus,long companyId) throws SystemException{
		return co_ConversationPersistence.countByStatusAndCompany(conversationStatus, companyId);
	}
	
	public int countByStatusAndGroup(int conversationStatus,long groupId) throws SystemException{
		return co_ConversationPersistence.countByStatusAndGroup(conversationStatus, groupId);
	}
	
	public int coutByThreadAndCompany(long threadId,long companyId) throws SystemException{
		return co_ConversationPersistence.countByThreadAndCompany(threadId, companyId);
	}
	
	public int countByThreadAndGroup(long threadId,long groupId) throws SystemException{
		return co_ConversationPersistence.countByThreadAndGroup(threadId, groupId);
	}
	
	public int coutByThreadAndCompanyAndStatus(long threadId,long companyId,int conversationStatus) throws SystemException{
		return co_ConversationPersistence.countByThreadAndCompanyAndStatus(threadId, companyId, conversationStatus);
	}
	
	public int countByThreadAndGroupAndStatus(long threadId,long groupId,int conversationStatus) throws SystemException{
		return co_ConversationPersistence.countByThreadAndGroupAndStatus(threadId, groupId, conversationStatus);
	}
	
	public List<CO_Conversation> findByCompany(long companyId) throws SystemException{
		return co_ConversationPersistence.findByCompany(companyId);
	}
	
	public List<CO_Conversation> findByCompany(long companyId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByCompany(companyId,start,end);
	}
	
	public List<CO_Conversation> findByGroup(long groupId) throws SystemException{
		return co_ConversationPersistence.findByGroup(groupId);
	}
	
	public List<CO_Conversation> findByGroup(long groupId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByGroup(groupId,start,end);
	}
	
	public List<CO_Conversation> findByStatusAndCompany(int conversationStatus,long companyId) throws SystemException{
		return co_ConversationPersistence.findByStatusAndCompany(conversationStatus, companyId);
	}
	
	public List<CO_Conversation> findByStatusAndCompany(int conversationStatus,long companyId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByStatusAndCompany(conversationStatus, companyId, start, end);
	}
	
	public List<CO_Conversation> findByStatusAndGroup(int conversationStatus,long groupId) throws SystemException{
		return co_ConversationPersistence.findByStatusAndGroup(conversationStatus, groupId);
	}
	
	public List<CO_Conversation> findByStatusAndGroup(int conversationStatus,long groupId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByStatusAndGroup(conversationStatus,groupId,start,end);
	}
	
	public List<CO_Conversation> findByThreadAndCompany(long threadId,long companyId) throws SystemException{
		return co_ConversationPersistence.findByThreadAndCompany(threadId, companyId);
	}
	
	public List<CO_Conversation> findByThreadAndCompany(long threadId,long companyId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByThreadAndCompany(threadId, companyId, start, end);
	}
	
	public List<CO_Conversation> findByThreadAndCompanyAndStatus(long threadId,long companyId,int conversationStatus) throws SystemException{
		return co_ConversationPersistence.findByThreadAndCompanyAndStatus(threadId, companyId,conversationStatus);
	}
	
	public List<CO_Conversation> findByThreadAndCompanyAndStatus(long threadId,long companyId,int conversationStatus,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByThreadAndCompanyAndStatus(threadId, companyId,conversationStatus, start, end);
	}
	
	public List<CO_Conversation> findByThreadAndGroup(long threadId,long groupId) throws SystemException{
		return co_ConversationPersistence.findByThreadAndGroup(threadId, groupId);
	}
	
	public List<CO_Conversation> findByThreadAndGroup(long threadId,long groupId,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByThreadAndGroup(threadId, groupId, start, end);
	}
	
	public List<CO_Conversation> findByThreadAndGroupAndStatus(long threadId,long groupId,int conversationStatus) throws SystemException{
		return co_ConversationPersistence.findByThreadAndGroupAndStatus(threadId, groupId,conversationStatus);
	}
	
	public List<CO_Conversation> findByThreadAndGroupAndStatus(long threadId,long groupId,int conversationStatus,int start,int end) throws SystemException{
		return co_ConversationPersistence.findByThreadAndGroupAndStatus(threadId, groupId,conversationStatus, start, end);
	}
	
	public List<CO_Conversation> findByKeywordAndStatus(long companyId,String keyword,int conversationStatus){
		return CO_ConversationFinderUtil.findByKeywordAndStatus(companyId, keyword, conversationStatus);
	}
	
	public List<CO_Conversation> findUnpublishEntry(long groupId,String searchKeyword){
		return CO_ConversationFinderUtil.findUnpublishEntry(groupId, searchKeyword);
	}
	
	public CO_Conversation addCOConversation(long companyId,long groupId,long userId,long threadId,String title,String askUserName,
										String askUserInfo,String askContent,String answerUserName,String answerUserInfo,String answerContent,Date askDate,
										Date answerDate,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long conversationId = counterLocalService.increment();
		
		CO_Conversation coConversation = co_ConversationPersistence.create(conversationId);
		
		coConversation.setCompanyId(companyId);
		coConversation.setGroupId(groupId);
		coConversation.setUserId(userId);
		coConversation.setThreadId(threadId);
		coConversation.setTitle(title);
		coConversation.setAskUserName(askUserName);
		coConversation.setAskUserInfo(askUserInfo);
		coConversation.setAskContent(askContent);
		coConversation.setAskDate(askDate);
		coConversation.setAnswerUserName(answerUserName);
		coConversation.setAnswerUserInfo(answerUserInfo);
		coConversation.setAnswerContent(answerContent);
		coConversation.setAnswerDate(answerDate);
		coConversation.setCreateDate(now);
		coConversation.setModifiedDate(now);
		coConversation.setStatus(CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE);
		coConversation.setStatusByUserId(userId);
		coConversation.setStatusDate(now);
		
		co_ConversationPersistence.update(coConversation, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCOConversationResources(coConversation, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCOConversationResources(coConversation, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return coConversation;
	}
	
	
	public CO_Conversation updateCOConversation(long conversationId,long companyId,long groupId,long userId,long threadId,String title,String askUserName,
													String askUserInfo,String askContent,String answerUserName,String answerUserInfo,String answerContent
													,Date askDate,Date answerDate,int conversationStatus) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CO_Conversation coConversation = co_ConversationPersistence.fetchByPrimaryKey(conversationId);
		
		coConversation.setCompanyId(companyId);
		coConversation.setGroupId(groupId);
		coConversation.setUserId(userId);
		coConversation.setThreadId(threadId);
		coConversation.setTitle(title);
		coConversation.setAskUserName(askUserName);
		coConversation.setAskUserInfo(askUserInfo);
		coConversation.setAskContent(askContent);
		coConversation.setAskDate(askDate);
		coConversation.setAnswerUserName(answerUserName);
		coConversation.setAnswerUserInfo(answerUserInfo);
		coConversation.setAnswerContent(answerContent);
		coConversation.setAnswerDate(answerDate);
		coConversation.setModifiedDate(now);
		
		Date statusDate = coConversation.getStatusDate();
		
		if(conversationStatus != coConversation.getStatus()){
			statusDate = new Date();
		}
		coConversation.setStatus(conversationStatus);
		coConversation.setStatusByUserId(userId);
		coConversation.setStatusDate(statusDate);
		
		co_ConversationPersistence.update(coConversation, false);

		return coConversation;
	}
	
	
	public CO_Conversation updateConversationStatus(long conversationId,long userId,int conversationStatus) throws SystemException{
		
		CO_Conversation coConversation = co_ConversationPersistence.fetchByPrimaryKey(conversationId);
		
		if(coConversation != null){
			
			Date now = new Date();
			
			coConversation.setStatus(conversationStatus);
			coConversation.setStatusByUserId(userId);
			coConversation.setStatusDate(now);
			
			co_ConversationPersistence.update(coConversation, false);
		}
		
		return coConversation;
	}
	
	public void deleteCoConversation(long conversationId) throws SystemException, PortalException{
		
		CO_Conversation coConversation = co_ConversationPersistence.fetchByPrimaryKey(conversationId);
		
		if(coConversation != null){
		
			co_ThreadPersistence.remove(coConversation);
			resourceLocalService.deleteResource(coConversation.getCompanyId(), CO_Category.class.getName(),
													ResourceConstants.SCOPE_INDIVIDUAL, coConversation.getConversationId());
		}
	}
	

	private void addCOConversationResources(CO_Conversation coConversation,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(coConversation.getCompanyId(), coConversation.getGroupId(), 
			coConversation.getUserId(), CO_Conversation.class.getName(),
			coConversation.getConversationId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCOConversationResources(CO_Conversation coConversation,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(coConversation.getCompanyId(), coConversation.getGroupId(),
			coConversation.getUserId(), CO_Conversation.class.getName(),
			coConversation.getConversationId(), groupPermissions, guestPermissions);
	}	
}