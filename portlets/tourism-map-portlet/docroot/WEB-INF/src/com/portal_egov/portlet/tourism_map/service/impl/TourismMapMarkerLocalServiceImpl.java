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

package com.portal_egov.portlet.tourism_map.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;
import com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerLocalServiceBaseImpl;

/**
 * The implementation of the tourism map marker local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil
 */
public class TourismMapMarkerLocalServiceImpl extends TourismMapMarkerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil
	 * } to access the tourism map marker local service.
	 */
	
	
	public List<TourismMapMarker> findByCompany(long companyId) throws SystemException{
		return tourismMapMarkerPersistence.findByCompany(companyId);
	}
	
	public List<TourismMapMarker> findByGroup(long groupId) throws SystemException{
		return tourismMapMarkerPersistence.findByGroup(groupId);
	}
	
	public List<TourismMapMarker> findByMarkerGroup(long markerGroupId) throws SystemException{
		return tourismMapMarkerPersistence.findByLocationGroup(markerGroupId);
	}
	
	public TourismMapMarker getMarker(long markerId) throws SystemException{
		return tourismMapMarkerPersistence.fetchByPrimaryKey(markerId);
	}
	
	public TourismMapMarker addMarker(long companyId,long groupId,long userId,String userName,long markerGroupId,
		String markerTitle,String markerInfo,String markerAddress,long markerImageId,String markerLongitude,
		String markerLatitude,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long markerId = counterLocalService.increment();
		
		TourismMapMarker marker = tourismMapMarkerPersistence.create(markerId);
		
		marker.setCompanyId(companyId);
		marker.setGroupId(groupId);
		marker.setUserId(userId);
		marker.setUserName(userName);
		
		marker.setMarkerGroupId(markerGroupId);
		marker.setMarkerTitle(markerTitle);
		marker.setMarkerInfo(markerInfo);
		marker.setMarkerAddress(markerAddress);
		marker.setMarkerImageId(markerImageId);
		marker.setMarkerLongitude(markerLongitude);
		marker.setMarkerLatitude(markerLatitude);
		marker.setCreateDate(now);
		marker.setModifiedDate(now);
		
		tourismMapMarkerPersistence.update(marker, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addMarkerResources(marker, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addMarkerResources(marker, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		return marker;
	}
	
	public TourismMapMarker updateMarker(long markerId,long companyId,long groupId,long userId,String userName,long markerGroupId,
		String markerTitle,String markerInfo,String markerAddress,long markerImageId,String markerLongitude,
		String markerLatitude) throws SystemException, PortalException{
		
		Date now = new Date();
		
		TourismMapMarker marker = tourismMapMarkerPersistence.fetchByPrimaryKey(markerId);
		
		marker.setCompanyId(companyId);
		marker.setGroupId(groupId);
		marker.setUserId(userId);
		marker.setUserName(userName);
		
		marker.setMarkerGroupId(markerGroupId);
		marker.setMarkerTitle(markerTitle);
		marker.setMarkerInfo(markerInfo);
		marker.setMarkerAddress(markerAddress);
		marker.setMarkerImageId(markerImageId);
		marker.setMarkerLongitude(markerLongitude);
		marker.setMarkerLatitude(markerLatitude);
		marker.setModifiedDate(now);
		
		tourismMapMarkerPersistence.update(marker, false);
		
		return marker;
	}
	
	public void deleteMarker(long markerId) throws NoSuchTourismMapMarkerException, SystemException{
		tourismMapMarkerPersistence.remove(markerId);
	}
	
	private void addMarkerResources(TourismMapMarker marker,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(marker.getCompanyId(), marker.getGroupId(), 
			marker.getUserId(), TourismMapMarker.class.getName(),
			marker.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addMarkerResources(TourismMapMarker marker,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(marker.getCompanyId(), marker.getGroupId(),
			marker.getUserId(), TourismMapMarker.class.getName(),
			marker.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
