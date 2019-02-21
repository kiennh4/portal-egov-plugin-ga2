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

package com.bkav.portal.portlet.audioplayer.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;
import com.bkav.portal.portlet.audioplayer.service.base.AudioAlbumLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the audio album local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.audioplayer.service.base.AudioAlbumLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil
 */
public class AudioAlbumLocalServiceImpl extends AudioAlbumLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil} to access the audio album local service.
	 */
	public List<AudioAlbum> findAll () throws Exception {
		return audioAlbumPersistence.findAll();
	}
	
	public List<AudioAlbum> findByCompany(long companyId) throws SystemException{
		
		return audioAlbumPersistence.findByCompanyId(companyId);
	}
	
	public List<AudioAlbum> findByGroup(long groupId) throws SystemException{
		
		return audioAlbumPersistence.findByGroupId(groupId);
	}
	
	public AudioAlbum getAudioAlbum(long albumId) throws SystemException{
		return audioAlbumPersistence.fetchByPrimaryKey(albumId);
	}
	
	
	public AudioAlbum getAudioAlbumCounter(long albumId) throws SystemException{
		
		if(albumId > 0){
			
			AudioAlbum album = audioAlbumPersistence.fetchByPrimaryKey(albumId);
			
			if(album != null){
				
				album.setViewCounter(album.getViewCounter() + 1);
				audioAlbumPersistence.update(album, false);
				
				return album;
			}else{
				
				return null;
			}
		}else{
			
			return null;
		}
	}
	
	public AudioAlbum addAudioAlbum (long companyId,long groupId,long userId,String userName,String albumName,
			String albumInfo, long albumCoverId, long viewCounter
			,ServiceContext serviceContext) throws SystemException, PortalException{
			
			Date now = new Date();
			
			long albumId = counterLocalService.increment();
			
			AudioAlbum album = audioAlbumPersistence.create(albumId);
			
			album.setCompanyId(companyId);
			album.setGroupId(groupId);
			album.setUserId(userId);
			album.setUserName(userName);
			album.setAlbumName(albumName);
			album.setAlbumInfo(albumInfo);
			album.setAlbumCoverId(albumCoverId);
			album.setViewCounter(viewCounter);
			album.setCreateDate(now);
			album.setModifyDate(now);
			
			audioAlbumPersistence.update(album, false);
			
			if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			
				addAudioAlbumResources(album, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
			}else{
				
				addAudioAlbumResources(album, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			}
			
			return album;
	}
	
	public AudioAlbum updateAudioAlbum (String albumName, String albumInfo, long albumCoverId, long viewCounter, long albumId 
			) throws SystemException, PortalException{
			
			Date now = new Date();
		
			AudioAlbum album = audioAlbumPersistence.fetchByPrimaryKey(albumId);
			
			album.setAlbumName(albumName);
			album.setAlbumInfo(albumInfo);
			album.setAlbumCoverId(albumCoverId);
			album.setViewCounter(viewCounter);
			album.setModifyDate(now);
			
			audioAlbumPersistence.update(album, false);
			
			return album;
	}
	
	public AudioAlbum updateAlbumView (long albumId) throws SystemException, PortalException{
		
		AudioAlbum album = audioAlbumPersistence.fetchByPrimaryKey(albumId);
		long numView = 0;
		if (Validator.isNotNull(album))
			numView = album.getViewCounter();
		
		album.setViewCounter(numView+1);
		
		audioAlbumPersistence.update(album, false);
		
		return album;
	}
	
	private void addAudioAlbumResources(AudioAlbum album,boolean addGroupPermissions,boolean addGuestPermissions) 
			throws PortalException, SystemException{

		resourceLocalService.addResources(album.getCompanyId(), album.getGroupId(), 
				album.getUserId(), AudioAlbum.class.getName(),
				album.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
	
	private void addAudioAlbumResources(AudioAlbum album,String[] groupPermissions,String[] guestPermissions) 
			throws PortalException, SystemException{

	resourceLocalService.addModelResources(album.getCompanyId(), album.getGroupId(),
			album.getUserId(), AudioAlbum.class.getName(),
			album.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}