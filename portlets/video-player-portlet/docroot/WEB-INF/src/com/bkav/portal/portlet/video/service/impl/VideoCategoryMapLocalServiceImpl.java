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

import java.util.List;

import com.bkav.portal.portlet.video.model.VideoCategoryMap;
import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil;
import com.bkav.portal.portlet.video.service.base.VideoCategoryMapLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the video category map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.video.service.VideoCategoryMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hungdx
 * @see com.bkav.portal.portlet.video.service.base.VideoCategoryMapLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil
 */
public class VideoCategoryMapLocalServiceImpl
	extends VideoCategoryMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil} to access the video category map local service.
	 */
	public List<VideoCategoryMap> findByCategory(long categoryId) throws SystemException{
		return videoCategoryMapPersistence.findByCategory(categoryId);
	}
	
	public List<VideoCategoryMap> findByEntry(long entryId) throws SystemException{
		return videoCategoryMapPersistence.findByEntry(entryId);
	}
	
	public VideoCategoryMap addVideoCategoryMap(long categoryId, long entryId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		long mapId = counterLocalService.increment();
		
		VideoCategoryMap videoCateMap = videoCategoryMapPersistence.create(mapId);
		
		videoCateMap.setCategoryId(categoryId);
		videoCateMap.setEntryId(entryId);
		
		return videoCategoryMapPersistence.update(videoCateMap, false);
	}
	
	public VideoCategoryMap updateVideoCategoryMap(long mapId, long categoryId, long entryId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		VideoCategoryMap videoCateMap = videoCategoryMapPersistence.fetchByPrimaryKey(mapId);
		
		videoCateMap.setCategoryId(categoryId);
		videoCateMap.setEntryId(entryId);
		
		return videoCategoryMapPersistence.update(videoCateMap, false);
	}
	
	
	public void deleteVideoCategoryMapByCategory (long categoryId) throws SystemException, PortalException{
		
		List<VideoCategoryMap> listEntries = videoCategoryMapPersistence.findByCategory(categoryId);
		if (listEntries!=null)
			for (int i = 0;i<listEntries.size();i++)
			{
				VideoCategoryMap entryMap = listEntries.get(i);
				VideoCategoryMapLocalServiceUtil.deleteVideoCategoryMap(entryMap.getMapId());
			}
		
	}
}