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

package com.bkav.portal.portlet.topic.service.impl;

import java.util.Date;
import java.util.List;
import com.bkav.portal.portlet.topic.model.Topic;
import com.bkav.portal.portlet.topic.service.base.TopicLocalServiceBaseImpl;
import com.bkav.portal.portlet.topic.service.persistence.TopicFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the topic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.topic.service.TopicLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.topic.service.base.TopicLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil
 */
public class TopicLocalServiceImpl extends TopicLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil} to access the topic local service.
	 */
	public List<Topic> findByGroup (long groupId) throws Exception, PortalException {
		return topicPersistence.findByGroup(groupId);
	}
	
	public List<Topic> findByTopicName (String topicName, long groupId, int start, int end, OrderByComparator obc) throws Exception, PortalException {
		return TopicFinderUtil.findByTopicName(groupId, topicName, start, end, obc);
	}
	
	public Topic addTopic (long groupId, long companyId, long userId, String userName, String categoryIds, String topicName, ServiceContext serviceContext) throws Exception, PortalException {
	
		long topicId = counterLocalService.increment();
		
		Date now = new Date();
		
		Topic newTopic = topicPersistence.create(topicId);
		
		newTopic.setGroupId(groupId);
		newTopic.setCompanyId(companyId);
		newTopic.setUserId(userId);
		newTopic.setUserName(userName);
		newTopic.setTopicName(topicName);
		newTopic.setCategoryIds(categoryIds);
		newTopic.setCreateDate(now);
		newTopic.setModifiedDate(now);
		
		topicPersistence.update(newTopic, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			addTopicResources(newTopic, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addTopicResources(newTopic, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return newTopic;
	}
	
	public Topic updateTopic (long topicId, long groupId, long companyId, long userId, String userName, String categoryIds, String topicName, ServiceContext serviceContext) throws Exception, PortalException {
		
		Date now = new Date();
		
		Topic newTopic = topicPersistence.fetchByPrimaryKey(topicId);
		
		newTopic.setGroupId(groupId);
		newTopic.setCompanyId(companyId);
		newTopic.setUserId(userId);
		newTopic.setUserName(userName);
		newTopic.setTopicName(topicName);
		newTopic.setCategoryIds(categoryIds);
		newTopic.setModifiedDate(now);
		
		topicPersistence.update(newTopic, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			addTopicResources(newTopic, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addTopicResources(newTopic, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return newTopic;
	}
	
	public Topic updateTopicCategoryIds (long topicId, String categoryIds) throws Exception, PortalException {
		
		Date now = new Date();
		
		Topic newTopic = topicPersistence.fetchByPrimaryKey(topicId);
		
		newTopic.setCategoryIds(categoryIds);
		newTopic.setModifiedDate(now);
		
		topicPersistence.update(newTopic, false);
		
		return newTopic;
	}
	
	private void addTopicResources(Topic topic,boolean addGroupPermissions,boolean addGuestPermissions) 
			throws PortalException, SystemException{

		resourceLocalService.addResources(topic.getCompanyId(), topic.getGroupId(), 
				topic.getUserId(), Topic.class.getName(),
				topic.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
	
	private void addTopicResources(Topic topic,String[] groupPermissions,String[] guestPermissions) 
			throws PortalException, SystemException{

	resourceLocalService.addModelResources(topic.getCompanyId(), topic.getGroupId(),
			topic.getUserId(), Topic.class.getName(),
			topic.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
}