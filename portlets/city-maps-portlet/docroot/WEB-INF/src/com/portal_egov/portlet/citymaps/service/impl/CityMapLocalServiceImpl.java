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

package com.portal_egov.portlet.citymaps.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.citymaps.NoSuchCityMapException;
import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.service.base.CityMapLocalServiceBaseImpl;
import com.portal_egov.portlet.citymaps.service.persistence.CityMapFinderUtil;

/**
 * The implementation of the city map local service.
 *
 * <p>
 * All custom service methods should be put in this class. 
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions into the 
 * {@link com.portal_egov.portlet.citymaps.service.CityMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based 
 * on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.citymaps.service.base.CityMapLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil
 */
public class CityMapLocalServiceImpl extends CityMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly.
	 *  Always use {@link com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil} to access the city map local service.
	 */
	
	public int countAll() throws SystemException{
		return cityMapPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return cityMapPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return cityMapPersistence.countByGroup(groupId);
	}
	
	public int countByType(long typeId) throws SystemException{
		return cityMapPersistence.countByType(typeId);
	}
	
	public List<CityMap> findByCompany(long companyId) throws SystemException{
		return cityMapPersistence.findByCompany(companyId);
	}
	
	public List<CityMap> findByCompany(long companyId,int start,int end) throws SystemException{
		return cityMapPersistence.findByCompany(companyId,start,end);
	}
	
	public List<CityMap> findByGroup(long groupId) throws SystemException{
		return cityMapPersistence.findByGroup(groupId);
	}
	
	public List<CityMap> findByGroup(long groupId,int start,int end) throws SystemException{
		return cityMapPersistence.findByGroup(groupId,start,end);
	}
	
	public List<CityMap> findByType(long typeId) throws SystemException{
		return cityMapPersistence.findByType(typeId);
	}
	
	public List<CityMap> findByType(long typeId,int start,int end) throws SystemException{
		return cityMapPersistence.findByType(typeId,start,end);
	}
	
	public List<CityMap> findByKeyword(long groupId,long mapTypeId,String keyword,int start,int end,OrderByComparator obc) throws SystemException{
		return CityMapFinderUtil.findByKeyword(groupId, mapTypeId, keyword, start, end, obc);
	}
	
	
	public CityMap addMap(long companyId,long groupId,long userId,String userName,long mapTypeId,long mapImageId,String mapName,
		String mapDesc, String mapSumary,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long mapId = counterLocalService.increment();
		
		CityMap cityMap = cityMapPersistence.create(mapId);
		
		cityMap.setCompanyId(companyId);
		cityMap.setGroupId(groupId);
		cityMap.setUserId(userId);
		cityMap.setUserName(userName);
		cityMap.setMapTypeId(mapTypeId);
		cityMap.setMapImageId(mapImageId);
		cityMap.setMapName(mapName);
		cityMap.setMapDesc(mapDesc);
		cityMap.setCreateDate(now);
		cityMap.setModifiedDate(now);
		cityMap.setMapSumary(mapSumary);
		
		cityMapPersistence.update(cityMap, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCityMapResources(cityMap, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCityMapResources(cityMap, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return cityMap;
	}
	
	public CityMap updateMap(long companyId,long groupId,long userId,String userName,long mapId,long mapTypeId,long mapImageId,
		String mapName,String mapDesc, String mapSumary) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CityMap cityMap = cityMapPersistence.fetchByPrimaryKey(mapId);
		
		cityMap.setCompanyId(companyId);
		cityMap.setGroupId(groupId);
		cityMap.setUserId(userId);
		cityMap.setUserName(userName);
		cityMap.setMapTypeId(mapTypeId);
		cityMap.setMapImageId(mapImageId);
		cityMap.setMapName(mapName);
		cityMap.setMapDesc(mapDesc);
		cityMap.setMapSumary(mapSumary);
		cityMap.setModifiedDate(now);
		
		cityMapPersistence.update(cityMap, false);
		
		return cityMap;
	}
	
	public void deleteMap(long mapId) throws NoSuchCityMapException, SystemException{
		cityMapPersistence.remove(mapId);
	}
	
	private void addCityMapResources(CityMap cityMap,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(cityMap.getCompanyId(), cityMap.getGroupId(), 
			cityMap.getUserId(), CityMap.class.getName(),
			cityMap.getMapId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCityMapResources(CityMap cityMap,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(cityMap.getCompanyId(), cityMap.getGroupId(),
			cityMap.getUserId(), CityMap.class.getName(),
			cityMap.getMapId(), groupPermissions, guestPermissions);
	}
}
