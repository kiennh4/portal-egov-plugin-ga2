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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;
import com.portal_egov.portlet.citymaps.model.CityMapType;
import com.portal_egov.portlet.citymaps.service.base.CityMapTypeLocalServiceBaseImpl;

/**
 * The implementation of the city map type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, 
 * rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.citymaps.service.CityMapTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated 
 * JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.citymaps.service.base.CityMapTypeLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil
 */
public class CityMapTypeLocalServiceImpl extends CityMapTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. 
	 * Always use {@link com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil} to access the city map type local service.
	 */
	
	public int countAll() throws SystemException{
		
		return cityMapTypePersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		
		return cityMapTypePersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		
		return cityMapTypePersistence.countByGroup(groupId);
	}
	
	public List<CityMapType> findByCompany(long companyId) throws SystemException{
		return cityMapTypePersistence.findByCompany(companyId);
	}
	
	public List<CityMapType> findByCompany(long companyId,int start,int end) throws SystemException{
		return cityMapTypePersistence.findByCompany(companyId,start,end);
	}
	
	public List<CityMapType> findByGroup(long groupId) throws SystemException{
		return cityMapTypePersistence.findByGroup(groupId);
	}
	
	public List<CityMapType> findByGroup(long groupId,int start,int end) throws SystemException{
		return cityMapTypePersistence.findByGroup(groupId,start,end);
	}
	
	public CityMapType addMapType(long companyId,long groupId,long userId,String userName,String typeName,String typeDesc,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long typeId = counterLocalService.increment();
		
		CityMapType mapType = cityMapTypePersistence.create(typeId);
		
		mapType.setCompanyId(companyId);
		mapType.setGroupId(groupId);
		mapType.setUserId(userId);
		mapType.setUserName(userName);
		mapType.setTypeName(typeName);
		mapType.setTypeDesc(typeDesc);
		mapType.setCreateDate(now);
		mapType.setModifiedDate(now);
		
		cityMapTypePersistence.update(mapType, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addMapTypeResources(mapType, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addMapTypeResources(mapType, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return mapType;
	}
	
	
	public CityMapType updateMapType(long typeId,long companyId,long groupId,long userId,String userName,String typeName,
		String typeDesc) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CityMapType mapType = cityMapTypePersistence.fetchByPrimaryKey(typeId);
		
		mapType.setCompanyId(companyId);
		mapType.setGroupId(groupId);
		mapType.setUserId(userId);
		mapType.setUserName(userName);
		mapType.setTypeName(typeName);
		mapType.setTypeDesc(typeDesc);
		mapType.setModifiedDate(now);
		
		cityMapTypePersistence.update(mapType, false);
		
		return mapType;
	}
	
	
	public String getMapTypeName(String typeId){
		try {
			
			CityMapType mapType = cityMapTypePersistence.fetchByPrimaryKey(typeId);
			
			if(mapType != null){
				return mapType.getTypeName();
			}else{
				return StringPool.BLANK;
			}
		}
		catch (SystemException e) {
			return StringPool.BLANK;
		}
	}
	
	public void deleteMapType(long typeId) throws NoSuchCityMapTypeException, SystemException{
		
		if(typeId > 0){
			cityMapTypePersistence.remove(typeId);
		}
	}
	
	private void addMapTypeResources(CityMapType cityMapType,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(cityMapType.getCompanyId(), cityMapType.getGroupId(), 
			cityMapType.getUserId(), CityMapType.class.getName(),
			cityMapType.getTypeId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addMapTypeResources(CityMapType cityMapType,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(cityMapType.getCompanyId(), cityMapType.getGroupId(),
			cityMapType.getUserId(), CityMapType.class.getName(),
			cityMapType.getTypeId(), groupPermissions, guestPermissions);
	}
}