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
import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.service.base.CO_ThreadLocalServiceBaseImpl;
import com.portal_egov.portlet.conversation.service.persistence.CO_ThreadFinderUtil;
import com.portal_egov.portlet.conversation.util.CO_Constants;

/**
 * The implementation of the c o_ thread local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.conversation.service.CO_ThreadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.conversation.service.base.CO_ThreadLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil
 */
public class CO_ThreadLocalServiceImpl extends CO_ThreadLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil} to access the c o_ thread local service.
	 */
	
	public int countAll() throws SystemException{
		return co_ThreadPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return co_ThreadPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return co_ThreadPersistence.countByGroup(groupId);
	}
	
	public int coutByStatusAndCompany(int threadStatus,long companyId) throws SystemException{
		return co_ThreadPersistence.countByStatusAndCompany(threadStatus, companyId);
	}
	
	public int countByStatusAndGroup(int threadStatus,long groupId) throws SystemException{
		return co_ThreadPersistence.countByStatusAndGroup(threadStatus, groupId);
	}
	
	public int coutByParentThreadAndCompany(long parentThreadId,long companyId) throws SystemException{
		return co_ThreadPersistence.countByParentThreadAndCompany(parentThreadId, companyId);
	}
	
	public int countByParentThreadAndGroup(long parentThreadId,long groupId) throws SystemException{
		return co_ThreadPersistence.countByParentThreadAndGroup(parentThreadId, groupId);
	}
	
	public int countByParentThreadAndCompanyAndStatus(long parentThreadId,long companyId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.countByParentThreadAndCompanyAndStatus(parentThreadId, companyId, threadStatus);
	}
	
	public int countByParentThreadAndGroupAndStatus(long parentThreadId,long groupId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.countByParentThreadAndGroupAndStatus(parentThreadId, groupId, threadStatus);
	}
	
	public int coutByCategoryAndCompany(long categoryId,long companyId) throws SystemException{
		return co_ThreadPersistence.countByCategoryAndCompany(categoryId, companyId);
	}
	
	public int countByCategoryAndGroup(long categoryId,long groupId) throws SystemException{
		return co_ThreadPersistence.countByCategoryAndGroup(categoryId, groupId);
	}
	
	public int countByCategoryAndCompanyAndStatus(long categoryId,long companyId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.countByCategoryAndCompanyAndStatus(categoryId, companyId, threadStatus);
	}
	
	public int countByCategoryAndGroupAndStatus(long categoryId,long groupId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.countByCategoryAndCompanyAndStatus(categoryId, groupId, threadStatus);
	}
	
	public List<CO_Thread> findAll() throws SystemException{
		return co_ThreadPersistence.findAll();
	}
	
	public List<CO_Thread> findByCompany(long companyId) throws SystemException{
		return co_ThreadPersistence.findByCompany(companyId);
	}
	
	public List<CO_Thread> findByCompany(long companyId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByCompany(companyId,start,end);
	}
	
	public List<CO_Thread> findByGroup(long groupId) throws SystemException{
		return co_ThreadPersistence.findByGroup(groupId);
	}
	
	public List<CO_Thread> findByGroup(long groupId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByGroup(groupId,start,end);
	}
	
	public List<CO_Thread> findByStatusAndCompany(int threadStatus,long companyId) throws SystemException{
		return co_ThreadPersistence.findByStatusAndCompany(threadStatus, companyId);
	}
	
	public List<CO_Thread> findByStatusAndCompany(int threadStatus,long companyId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByStatusAndCompany(threadStatus, companyId, start, end);
	}
	
	public List<CO_Thread> findByStatusAndGroup(int threadStatus,long groupId) throws SystemException{
		return co_ThreadPersistence.findByStatusAndGroup(threadStatus, groupId);
	}
	
	public List<CO_Thread> findByStatusAndGroup(int threadStatus,long groupId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByStatusAndGroup(threadStatus,groupId,start,end);
	}
	
	public List<CO_Thread> findByParentThreadAndCompany(long parentThreadId,long companyId) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndCompany(parentThreadId, companyId);
	}
	
	public List<CO_Thread> findByParentThreadAndCompany(long parentThreadId,long companyId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndCompany(parentThreadId, companyId, start, end);
	}
	
	public List<CO_Thread> findByParentThreadAndGroup(long parentThreadId,long groupId) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndGroup(parentThreadId, groupId);
	}
	
	public List<CO_Thread> findByParentThreadAndGroup(long parentThreadId,long groupId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndGroup(parentThreadId, groupId, start, end);
	}
	
	
	public List<CO_Thread> findByParentThreadAndCompanyAndStatus(long parentThreadId,long companyId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndCompanyAndStatus(parentThreadId, companyId, threadStatus);
	}
	
	public List<CO_Thread> findByParentThreadAndCompanyAndStatus(long parentThreadId,long companyId,int threadStatus,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndCompanyAndStatus(parentThreadId, companyId, threadStatus, start, end);
	}
	
	public List<CO_Thread> findByParentThreadAndGroupAndStatus(long parentThreadId,long groupId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndGroupAndStatus(parentThreadId, groupId, threadStatus);
	}
	
	public List<CO_Thread> findByParentThreadAndGroupAndStatus(long parentThreadId,long groupId,int threadStatus,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByParentThreadAndGroupAndStatus(parentThreadId, groupId, threadStatus, start, end);
	}
	
	public List<CO_Thread> findByCategoryAndCompany(long categoryId,long companyId) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndCompany(categoryId, companyId);
	}
	
	public List<CO_Thread> findByCategoryAndCompany(long categoryId,long companyId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndCompany(categoryId, companyId, start, end);
	}
	
	public List<CO_Thread> findByCategoryAndGroup(long categoryId,long groupId) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndGroup(categoryId, groupId);
	}
	
	public List<CO_Thread> findByCategoryAndGroup(long categoryId,long groupId,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndGroup(categoryId, groupId, start, end);
	}
	
	public List<CO_Thread> findByCategoryAndCompanyAndStatus(long categoryId,long companyId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndCompanyAndStatus(categoryId, companyId, threadStatus);
	}
	
	public List<CO_Thread> findByCategoryAndCompanyAndStatus(long categoryId,long companyId,int threadStatus,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndCompanyAndStatus(categoryId, companyId, threadStatus, start, end);
	}
	
	public List<CO_Thread> findByCategoryAndGroupAndStatus(long categoryId,long groupId,int threadStatus) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndGroupAndStatus(categoryId, groupId, threadStatus);
	}
	
	public List<CO_Thread> findByCategoryAndGroupAndStatus(long categoryId,long groupId,int threadStatus,int start,int end) throws SystemException{
		return co_ThreadPersistence.findByCategoryAndGroupAndStatus(categoryId, groupId, threadStatus, start, end);
	}
	
	public List<CO_Thread> findByKeywordAndStatus(long companyId,String keyword,int threadStatus){
		return CO_ThreadFinderUtil.findByKeywordAndStatus(companyId, keyword, threadStatus);
	}
	
	public CO_Thread addCOThread(long companyId,long groupId,long userId,long parentThreadId,long categoryId,String threadName
										,String threadDesc,String departmentName,String participants,Date startDate,Date endDate,int threadStatus
										,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long threadId = counterLocalService.increment();
		
		CO_Thread coThread = co_ThreadPersistence.create(threadId);
		
		coThread.setCompanyId(companyId);
		coThread.setGroupId(groupId);
		coThread.setUserId(userId);
		coThread.setParentThreadId(parentThreadId);
		coThread.setCategoryId(categoryId);
		coThread.setThreadName(threadName);
		coThread.setThreadDesc(threadDesc);
		coThread.setDepartmentName(departmentName);
		coThread.setParticipants(participants);
		coThread.setStartDate(startDate);
		coThread.setEndDate(endDate);
		coThread.setCreateDate(now);
		coThread.setModifiedDate(now);
		coThread.setViewCount(CO_Constants.THREAD_STARTED_VIEW_COUNT_VALUE);
		coThread.setConversationCount(CO_Constants.THREAD_STARTED_CONVERSATION_COUNT_VALUE);
		coThread.setStatus(threadStatus);
		coThread.setStatusByUserId(userId);
		coThread.setStatusDate(now);
		
		co_ThreadPersistence.update(coThread, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addCOThreadResources(coThread, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCOThreadResources(coThread, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return coThread;
	}
	
	
	public CO_Thread updateCOThread(long threadId,long companyId,long groupId,long userId,long parentThreadId,long categoryId,String threadName
										,String threadDesc,String departmentName,String participants,Date startDate,Date endDate
										,int threadStatus) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CO_Thread coThread = co_ThreadPersistence.fetchByPrimaryKey(threadId);
		
		coThread.setCompanyId(companyId);
		coThread.setGroupId(groupId);
		coThread.setUserId(userId);
		coThread.setParentThreadId(parentThreadId);
		coThread.setCategoryId(categoryId);
		coThread.setThreadName(threadName);
		coThread.setThreadDesc(threadDesc);
		coThread.setDepartmentName(departmentName);
		coThread.setParticipants(participants);
		coThread.setStartDate(startDate);
		coThread.setEndDate(endDate);
		coThread.setModifiedDate(now);
		
		Date statusDate = coThread.getStatusDate();
		
		if(threadStatus != coThread.getStatus()){
			statusDate = new Date();
		}
		
		coThread.setStatus(threadStatus);
		coThread.setStatusByUserId(userId);
		coThread.setStatusDate(statusDate);
		
		co_ThreadPersistence.update(coThread, false);
		
		return coThread;
	}
	
	public CO_Thread incrementThreadViewCounter(long threadId) throws SystemException{
		
		CO_Thread coThread = co_ThreadPersistence.fetchByPrimaryKey(threadId);
		
		if(coThread != null){
			
			int oldThreadViewCountValue = coThread.getViewCount();
			
			coThread.setViewCount(oldThreadViewCountValue + 1);
			
			co_ThreadPersistence.update(coThread, false);
		} 
		
		return coThread;
	}
	
	
	public void incrementConversationViewCounter(long threadId) throws SystemException{
		
		CO_Thread coThread = co_ThreadPersistence.fetchByPrimaryKey(threadId);
		
		if(coThread != null){
			
			int oldThreadConversationCountValue = coThread.getConversationCount();
			
			coThread.setConversationCount(oldThreadConversationCountValue + 1);
			
			co_ThreadPersistence.update(coThread, false);
		} 
		
	}
	
	public CO_Thread updateThreadStatus(long threadId,long userId,int newThreadStatus) throws SystemException{
		
		CO_Thread coThread = co_ThreadPersistence.fetchByPrimaryKey(threadId);
		
		if(coThread != null){
			
			Date now = new Date();
			
			coThread.setStatus(newThreadStatus);
			coThread.setStatusByUserId(userId);
			coThread.setStatusDate(now);
			
			co_ThreadPersistence.update(coThread, false);
		}
		
		return coThread;
	}
	
	public void deleteCOThread(long threadId) throws SystemException, PortalException{
		
		CO_Thread coThread = co_ThreadPersistence.fetchByPrimaryKey(threadId);
		
		if(coThread != null){
		
			co_ThreadPersistence.remove(coThread);
			resourceLocalService.deleteResource(coThread.getCompanyId(), CO_Category.class.getName(),
													ResourceConstants.SCOPE_INDIVIDUAL, coThread.getThreadId());
		}
	}
	
	
	private void addCOThreadResources(CO_Thread coThread,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(coThread.getCompanyId(), coThread.getGroupId(), 
			coThread.getUserId(), CO_Thread.class.getName(),
			coThread.getThreadId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCOThreadResources(CO_Thread coThread,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(coThread.getCompanyId(), coThread.getGroupId(),
			coThread.getUserId(), CO_Thread.class.getName(),
			coThread.getThreadId(), groupPermissions, guestPermissions);
	}
}