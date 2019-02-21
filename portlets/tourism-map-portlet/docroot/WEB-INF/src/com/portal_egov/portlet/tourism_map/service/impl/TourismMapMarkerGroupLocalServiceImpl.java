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
import com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;
import com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerGroupLocalServiceBaseImpl;

/**
 * The implementation of the tourism map marker group local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerGroupLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalServiceUtil
 */
public class TourismMapMarkerGroupLocalServiceImpl extends TourismMapMarkerGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.tourism_map.service.
	 * TourismMapMarkerGroupLocalServiceUtil} to access the tourism map marker
	 * group local service.
	 */

	public List<TourismMapMarkerGroup> findByCompany(long companyId) throws SystemException{
		return tourismMapMarkerGroupPersistence.findByCompany(companyId);
	}
	 
	public List<TourismMapMarkerGroup> findByGroup(long groupId) throws SystemException{
		return tourismMapMarkerGroupPersistence.findByGroup(groupId);
	}
	 
	public TourismMapMarkerGroup getMarkerGroup(long markerGroupId) throws SystemException{
		return tourismMapMarkerGroupPersistence.fetchByPrimaryKey(markerGroupId);
	}
	
	public TourismMapMarkerGroup addMarkerGroup(long companyId,long groupId,long userId,String userName,
		String markerGroupName,String markerGroupInfo,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long markerGroupId = counterLocalService.increment();
		
		TourismMapMarkerGroup markerGroup = tourismMapMarkerGroupPersistence.create(markerGroupId);
		
		markerGroup.setCompanyId(companyId);
		markerGroup.setGroupId(groupId);
		markerGroup.setUserId(userId);
		markerGroup.setUserName(userName);
		markerGroup.setMarkerGroupName(markerGroupName);
		markerGroup.setMarkerGroupInfo(markerGroupInfo);
		markerGroup.setCreateDate(now);
		markerGroup.setModifiedDate(now);
		
		tourismMapMarkerGroupPersistence.update(markerGroup, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addMarkerGroupResources(markerGroup, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addMarkerGroupResources(markerGroup, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return markerGroup;
	}
	
	public TourismMapMarkerGroup updateMarkerGroup(long markerGroupId,long companyId,long groupId,long userId,
		String userName,String markerGroupName,String markerGroupInfo) throws SystemException, PortalException{
		
		Date now = new Date();
		
		TourismMapMarkerGroup markerGroup = tourismMapMarkerGroupPersistence.fetchByPrimaryKey(markerGroupId);
		
		markerGroup.setCompanyId(companyId);
		markerGroup.setGroupId(groupId);
		markerGroup.setUserId(userId);
		markerGroup.setUserName(userName);
		markerGroup.setMarkerGroupName(markerGroupName);
		markerGroup.setMarkerGroupInfo(markerGroupInfo);
		markerGroup.setModifiedDate(now);
		
		tourismMapMarkerGroupPersistence.update(markerGroup, false);
		
		return markerGroup;
	}
	
	public void deleteMarkerGroup(long markerGroupId) throws NoSuchTourismMapMarkerGroupException, SystemException{
		tourismMapMarkerGroupPersistence.remove(markerGroupId);
	}
	
	private void addMarkerGroupResources(TourismMapMarkerGroup markerGroup,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(markerGroup.getCompanyId(), markerGroup.getGroupId(), 
			markerGroup.getUserId(), TourismMapMarkerGroup.class.getName(),
			markerGroup.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addMarkerGroupResources(TourismMapMarkerGroup markerGroup,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(markerGroup.getCompanyId(), markerGroup.getGroupId(),
			markerGroup.getUserId(), TourismMapMarkerGroup.class.getName(),
			markerGroup.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
