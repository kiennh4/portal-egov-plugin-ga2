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

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.service.base.VideoEntryLocalServiceBaseImpl;
import com.bkav.portal.portlet.video.service.persistence.VideoEntryFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the video entry local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.video.service.VideoEntryLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author hungdx
 * @see com.bkav.portal.portlet.video.service.base.VideoEntryLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil
 */
public class VideoEntryLocalServiceImpl extends VideoEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil} to
	 * access the video entry local service.
	 */
	
	public List<VideoEntry> findByGroup(long groupId) throws SystemException{
		return videoEntryPersistence.findByGroup(groupId);
	}
	
	public List<VideoEntry> findByGroup(long groupId,int start,int end) throws SystemException{
		return videoEntryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<VideoEntry> findByKeyword(long groupId,String keyword, int start, int end)
			throws SystemException{
		
		return VideoEntryFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public List<VideoEntry> findByCategoryId(long groupId,long categoryId, int start, int end)
			throws SystemException{
		
		return VideoEntryFinderUtil.findByCategoryId(groupId, categoryId, start, end);
	}
	
	public VideoEntry addVideo(long companyId,long groupId,long userId,String userName,
			String name,String description,String videoType,String videoUrl,long videoFileId,boolean thumbnailImage,
			long thumbnailImageId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long entryId = counterLocalService.increment();
		
		VideoEntry video = videoEntryPersistence.create(entryId);
		
		video.setGroupId(groupId);
		video.setCompanyId(companyId);
		video.setUserId(userId);
		video.setUserName(userName);
		video.setCreateDate(now);
		video.setModifiedDate(now);
		video.setName(name);
		video.setDescription(description);
		video.setVideoType(videoType);
		video.setVideoUrl(videoUrl);
		video.setVideoFileId(videoFileId);
		video.setThumbnailImage(thumbnailImage);
		video.setThumbnailImageId(thumbnailImageId);
		
		resourceLocalService.addModelResources(video, serviceContext);
		
		return videoEntryPersistence.update(video, false);
	}
	
	public VideoEntry updateVideo(long entryId,long companyId,long groupId,long userId,String userName,
			String name,String description,String videoType,String videoUrl,long videoFileId,boolean thumbnailImage,
			long thumbnailImageId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		VideoEntry video = videoEntryPersistence.fetchByPrimaryKey(entryId);
		
		video.setGroupId(groupId);
		video.setCompanyId(companyId);
		video.setUserId(userId);
		video.setUserName(userName);
		video.setModifiedDate(now);
		video.setName(name);
		video.setDescription(description);
		video.setVideoType(videoType);
		video.setVideoUrl(videoUrl);
		video.setVideoFileId(videoFileId);
		video.setThumbnailImage(thumbnailImage);
		video.setThumbnailImageId(thumbnailImageId);
		
		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateVideoResource(
				video, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		
		return videoEntryPersistence.update(video, false);
	}
	
	protected void updateVideoResource(VideoEntry video, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(video.getCompanyId(),
				video.getGroupId(), VideoEntry.class.getName(),
				video.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}