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

package com.portal_egov.portlet.landprice.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.landprice.NoSuchLandLocationException;
import com.portal_egov.portlet.landprice.model.LandLocation;
import com.portal_egov.portlet.landprice.service.base.LandLocationLocalServiceBaseImpl;
import com.portal_egov.portlet.landprice.service.persistence.LandLocationFinderUtil;

/**
 * The implementation of the land location local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.landprice.service.LandLocationLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.landprice.service.base.LandLocationLocalServiceBaseImpl
 * @see com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil
 */
public class LandLocationLocalServiceImpl extends LandLocationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil}
	 * to access the land location local service.
	 */
	
	public List<LandLocation> findByGroup(long groupId) throws SystemException{
		
		return landLocationPersistence.findByGroup(groupId);
	}
	
	public List<LandLocation> findByParentLocation(long parentLocationId) throws SystemException{
		
		return landLocationPersistence.findByParentLocation(parentLocationId);
	}
	
	public List<LandLocation> findByKeyword(long groupId,long parentLocationId,String keyword,int start,int end,OrderByComparator obc){
		
		return LandLocationFinderUtil.findByKeyword(groupId,parentLocationId, keyword, start, end, obc);
	}
	
	public LandLocation addLocation(long companyId,long groupId,long userId,String userName,
		long parentLocationId,String locationName,String locationInfo,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long locationId = counterLocalService.increment();
		
		LandLocation location = landLocationPersistence.create(locationId);
		
		location.setCompanyId(companyId);
		location.setGroupId(groupId);
		location.setUserId(userId);
		location.setUserName(userName);
		location.setCreateDate(now);
		location.setModifiedDate(now);
		
		location.setParentLocationId(parentLocationId);
		location.setLocationName(locationName);
		location.setLocationInfo(locationInfo);
		
		landLocationPersistence.update(location, false);
		
		resourceLocalService.addModelResources(location, serviceContext);
		
		return location;
	}
	
	public LandLocation updateLocation(long locationId,long companyId,long groupId,long userId,String userName,
		long parentLocationId,String locationName,String locationInfo,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		LandLocation location = landLocationPersistence.fetchByPrimaryKey(locationId);
		
		location.setCompanyId(companyId);
		location.setGroupId(groupId);
		location.setUserId(userId);
		location.setUserName(userName);
		location.setModifiedDate(now);
		
		location.setParentLocationId(parentLocationId);
		location.setLocationName(locationName);
		location.setLocationInfo(locationInfo);
		
		landLocationPersistence.update(location, false);
		
		updateObjectResources(location, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return location;
	}
	
	public void deleteLocation(long locationId) throws NoSuchLandLocationException, SystemException{
		
		landLocationPersistence.remove(locationId);
	}
	
	protected void updateObjectResources(LandLocation landLocation,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(landLocation.getCompanyId(),
			landLocation.getGroupId(), LandLocation.class.getName(),
			landLocation.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
