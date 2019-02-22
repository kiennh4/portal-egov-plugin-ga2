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

import java.util.List;

import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil;
import com.bkav.portal.portlet.audioplayer.service.base.AlbumAudioMapLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the album audio map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.audioplayer.service.base.AlbumAudioMapLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil
 */
public class AlbumAudioMapLocalServiceImpl
	extends AlbumAudioMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil} to access the album audio map local service.
	 */
	public List<AlbumAudioMap> findAll () throws Exception {
		return albumAudioMapPersistence.findAll();
	}
	
	public List<AlbumAudioMap> findByAlbumId (long albumId) throws Exception {
		return albumAudioMapPersistence.findByAlbum(albumId);
	}
	
	
	public AlbumAudioMap getAlbumAudioMap(long AlbumAudioMapId) throws SystemException{
		return albumAudioMapPersistence.fetchByPrimaryKey(AlbumAudioMapId);
	}
	
	public List<AlbumAudioMap> findByAlbumAudio (long albumId, long audioId) throws Exception {
		return albumAudioMapPersistence.findByAudioAlbum(audioId, albumId);
	}
	
	public AlbumAudioMap addAlbumAudioMap (long audioId, long albumId) throws SystemException, PortalException{
			
			
			long relId = counterLocalService.increment();
			
			AlbumAudioMap rel = albumAudioMapPersistence.create(relId);
			
			
			rel.setAlbumId(albumId);
			rel.setAudioId(audioId);
			
			
			albumAudioMapPersistence.update(rel, false);
			
			
			return rel;
	}
	
	public AlbumAudioMap updateAlbumAudioMap (long audioId, long albumId, long relId
			,ServiceContext serviceContext) throws SystemException, PortalException{
		
			AlbumAudioMap rel = albumAudioMapPersistence.fetchByPrimaryKey(relId);
			
			rel.setAlbumId(albumId);
			rel.setAudioId(audioId);
			
			albumAudioMapPersistence.update(rel, false);
			
			return rel;
	}
	
	public void deleteAlbumAudioMapByAlbumId (long albumId) throws SystemException, PortalException {
		
		List<AlbumAudioMap> aamList = albumAudioMapPersistence.findByAlbum(albumId);
		for (int i = 0;i< aamList.size();i++)
			AlbumAudioMapLocalServiceUtil.deleteAlbumAudioMap(aamList.get(i).getMapId());
	}
	
	public void deleteAlbumAudioMapByAudioId (long audioId) throws SystemException, PortalException {
		
		List<AlbumAudioMap> aamList = albumAudioMapPersistence.findByAudio(audioId);
		for (int i = 0;i< aamList.size();i++)
			AlbumAudioMapLocalServiceUtil.deleteAlbumAudioMap(aamList.get(i).getMapId());
	}
	
	
}