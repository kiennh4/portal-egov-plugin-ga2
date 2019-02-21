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

package com.bkav.portal.portlet.video.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.video.model.VideoCategory;
import com.bkav.portal.portlet.video.service.base.VideoCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the video category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.video.service.VideoCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.video.service.base.VideoCategoryLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil
 */
public class VideoCategoryLocalServiceImpl
	extends VideoCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil} to access the video category local service.
	 */
	public List<VideoCategory> findByGroup(long groupId) throws SystemException{
		return videoCategoryPersistence.findByGroup(groupId);
	}
	
	public List<VideoCategory> findByGroup(long groupId,int start,int end) throws SystemException{
		return videoCategoryPersistence.findByGroup(groupId,start,end);
	}
	
	public VideoCategory addVideoCategory(long companyId,long groupId,long userId,String userName,
			String categoryName,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		VideoCategory videoCate = videoCategoryPersistence.create(categoryId);
		
		videoCate.setGroupId(groupId);
		videoCate.setCompanyId(companyId);
		videoCate.setUserId(userId);
		videoCate.setUserName(userName);
		videoCate.setCreateDate(now);
		videoCate.setModifiedDate(now);
		videoCate.setCategoryName(categoryName);
		videoCate.setCategoryId(categoryId);
		
		
		resourceLocalService.addModelResources(videoCate, serviceContext);
		
		return videoCategoryPersistence.update(videoCate, false);
	}
	
	public VideoCategory updateVideoCategory(long categoryId,long companyId,long groupId,long userId,String userName,
			String categoryName,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		VideoCategory videoCate = videoCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		videoCate.setGroupId(groupId);
		videoCate.setCompanyId(companyId);
		videoCate.setUserId(userId);
		videoCate.setUserName(userName);
		videoCate.setCreateDate(now);
		videoCate.setModifiedDate(now);
		videoCate.setCategoryName(categoryName);
		
		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateVideoCategoryResource(
					videoCate, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		
		return videoCategoryPersistence.update(videoCate, false);
	}
	
	protected void updateVideoCategoryResource(VideoCategory videoCate, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(videoCate.getCompanyId(),
				videoCate.getGroupId(), VideoCategory.class.getName(),
				videoCate.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}