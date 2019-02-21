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

package com.bkav.portal.portlet.contentsharing.service.impl;

import java.util.List;

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;
import com.bkav.portal.portlet.contentsharing.service.base.ContentSharingLocalServiceBaseImpl;
import com.bkav.portal.portlet.contentsharing.service.persistence.ContentSharingFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the content sharing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.contentsharing.service.base.ContentSharingLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil
 */
public class ContentSharingLocalServiceImpl
	extends ContentSharingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil} to access the content sharing local service.
	 */
	public List<ContentSharing> findAll () throws SystemException, PortalException
	{
		return contentSharingPersistence.findAll();
	}
	
	public ContentSharing findByCompanyAndGroup (long companyId, long groupId) throws SystemException, PortalException {
		return contentSharingPersistence.fetchBycompanyIdAndGroupId(companyId, groupId);
	}
	
	public String getContentSharingByCompanyExceptRoot (long companyId) throws SystemException, PortalException {
	
		ContentSharing contentSharing = contentSharingPersistence.fetchBycompanyId(companyId);
		
		if ((contentSharing!=null)&&(contentSharing.getContentId()==0))
		{
			return StringPool.BLANK;
		}
		else
		{
			return contentSharing.getContentSharing();
		}
		
		 
	}
	
	public ContentSharing addRootContentSharing (long companyId, long groupId, long userId, String content, ServiceContext serviceContext) throws SystemException, PortalException
	{
		long contentId = 0;
		
		ContentSharing contentSharing = contentSharingPersistence.create(contentId);
		
		contentSharing.setCompanyId(companyId);
		contentSharing.setGroupId(groupId);
		contentSharing.setUserId(userId);
		contentSharing.setContentSharing(content);
		
		contentSharingPersistence.update(contentSharing, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			
			addContentSharingResources(contentSharing, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addContentSharingResources(contentSharing, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return contentSharing;
		
	}
	
	public ContentSharing addContentSharing (long companyId, long groupId, long userId, String content, ServiceContext serviceContext) throws SystemException, PortalException
	{
		long contentId = counterLocalService.increment();
		
		ContentSharing contentSharing = contentSharingPersistence.create(contentId);
		
		contentSharing.setCompanyId(companyId);
		contentSharing.setGroupId(groupId);
		contentSharing.setUserId(userId);
		contentSharing.setContentSharing(content);
		
		contentSharingPersistence.update(contentSharing, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			
			addContentSharingResources(contentSharing, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addContentSharingResources(contentSharing, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return contentSharing;
		
	}
	
	public ContentSharing updateContentSharing (long contentId, long companyId, long groupId, long userId, String content) throws SystemException, PortalException
	{
		ContentSharing contentSharing = contentSharingPersistence.findByPrimaryKey(contentId);
		
		contentSharing.setCompanyId(companyId);
		contentSharing.setGroupId(groupId);
		contentSharing.setUserId(userId);
		contentSharing.setContentSharing(content);
		
		contentSharingPersistence.update(contentSharing, false);
		
		return contentSharing;
		
	}
	
	private void addContentSharingResources(ContentSharing contentSharing,boolean addGroupPermissions,boolean addGuestPermissions) 
			throws PortalException, SystemException{

		resourceLocalService.addResources(contentSharing.getCompanyId(), contentSharing.getGroupId(), 
				contentSharing.getUserId(), ContentSharing.class.getName(),
				contentSharing.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
	
	private void addContentSharingResources(ContentSharing contentSharing,String[] groupPermissions,String[] guestPermissions) 
			throws PortalException, SystemException{

	resourceLocalService.addModelResources(contentSharing.getCompanyId(), contentSharing.getGroupId(),
			contentSharing.getUserId(), ContentSharing.class.getName(),
			contentSharing.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
}