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

import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.service.base.AudioFileLocalServiceBaseImpl;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioFileFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the audio file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.audioplayer.service.AudioFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.audioplayer.service.base.AudioFileLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil
 */
public class AudioFileLocalServiceImpl extends AudioFileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil} to access the audio file local service.
	 */
	public List<AudioFile> findAll () throws Exception {
		return audioFilePersistence.findAll();
	}
	
	public List<AudioFile> findByCompany(long companyId) throws SystemException{
		
		return audioFilePersistence.findByCompanyId(companyId);
	}
	
	public List<AudioFile> findByGroup(long groupId) throws SystemException{
		
		return audioFilePersistence.findByGroupId(groupId);
	}
	
	public AudioFile getAudioFile(long AudioFileId) throws SystemException{
		return audioFilePersistence.fetchByPrimaryKey(AudioFileId);
	}
	
	public List<AudioFile> findByAudioName (long groupId, String key, int start, int end, OrderByComparator obc)
	{
		return AudioFileFinderUtil.findByAudioName(groupId, key, start, end, obc);
	}
	
	public AudioFile getAudioFileCounter(long AudioFileId) throws SystemException{
		
		if(AudioFileId > 0){
			
			AudioFile audio = audioFilePersistence.fetchByPrimaryKey(AudioFileId);
			
			if(audio != null){
				
				audio.setViewCounter(audio.getViewCounter() + 1);
				audioFilePersistence.update(audio, false);
				
				return audio;
			}else{
				
				return null;
			}
		}else{
			
			return null;
		}
	}
	
	public AudioFile addAudioFile (long companyId,long groupId,long userId,String userName,String audioName,
			String audioInfo, long audioFileId, long viewCounter
			,String audioType
			,ServiceContext serviceContext) throws SystemException, PortalException{
			
			Date now = new Date();
			
			long audioId = counterLocalService.increment();
			
			AudioFile audio = audioFilePersistence.create(audioId);
			
			audio.setCompanyId(companyId);
			audio.setGroupId(groupId);
			audio.setUserId(userId);
			audio.setUserName(userName);
			audio.setAudioName(audioName);
			audio.setAudioInfo(audioInfo);
			audio.setAudioType(audioType);
			audio.setAudioFileId(audioFileId);
			audio.setViewCounter(viewCounter);
			audio.setCreateDate(now);
			audio.setModifyDate(now);
			
			audioFilePersistence.update(audio, false);
			
			if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
			
				addAudioFileResources(audio, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
			}else{
				
				addAudioFileResources(audio, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			}
			
			return audio;
	}
	
	public AudioFile updateAudioFile (String audioName, String audioInfo, long audioFileId
			, long viewCounter, long audioId, String audioType ) throws SystemException, PortalException{
			
			Date now = new Date();
		
			AudioFile audio = audioFilePersistence.fetchByPrimaryKey(audioId);
			
			audio.setAudioInfo(audioInfo);
			audio.setAudioType(audioType);
			audio.setAudioFileId(audioFileId);
			audio.setViewCounter(viewCounter);
			audio.setModifyDate(now);
			
			audioFilePersistence.update(audio, false);
			
			return audio;
	}
	
	
	private void addAudioFileResources(AudioFile audio,boolean addGroupPermissions,boolean addGuestPermissions) 
			throws PortalException, SystemException{

		resourceLocalService.addResources(audio.getCompanyId(), audio.getGroupId(), 
				audio.getUserId(), AudioFile.class.getName(),
				audio.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
	
	private void addAudioFileResources(AudioFile audio,String[] groupPermissions,String[] guestPermissions) 
			throws PortalException, SystemException{

	resourceLocalService.addModelResources(audio.getCompanyId(), audio.getGroupId(),
			audio.getUserId(), AudioFile.class.getName(),
			audio.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}