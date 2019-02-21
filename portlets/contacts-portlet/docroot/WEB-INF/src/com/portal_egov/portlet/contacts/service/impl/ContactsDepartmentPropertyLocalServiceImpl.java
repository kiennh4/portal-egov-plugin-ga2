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

package com.portal_egov.portlet.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;
import com.portal_egov.portlet.contacts.service.base.ContactsDepartmentPropertyLocalServiceBaseImpl;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentPropertyFinderUtil;

/**
 * The implementation of the contacts department property local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, 
 * rerun ServiceBuilder to copy their definitions 
 * into the {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on
 *  the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentPropertyLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil
 */
public class ContactsDepartmentPropertyLocalServiceImpl extends ContactsDepartmentPropertyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly.
	 *  Always use {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil} 
	 *  to access the contacts department property local service.
	 */
	
	public int countAll() throws SystemException{
		return contactsDepartmentPropertyPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return contactsDepartmentPropertyPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return contactsDepartmentPropertyPersistence.countByCompany(groupId);
	}
	
	public int countByContactsDepartment(long contactDepartmentId) throws SystemException{
		return contactsDepartmentPropertyPersistence.countByContactsDepartment(contactDepartmentId);
	}
	
	public List<ContactsDepartmentProperty> findAll() throws SystemException{
		return contactsDepartmentPropertyPersistence.findAll();
	}
	
	public List<ContactsDepartmentProperty> findByCompany(long companyId) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByCompany(companyId);
	}
	
	public List<ContactsDepartmentProperty> findByCompany(long companyId,int start,int end) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByCompany(companyId,start,end);
	}
	
	public List<ContactsDepartmentProperty> findByGroup(long groupId) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByGroup(groupId);
	}
	
	public List<ContactsDepartmentProperty> findByGroup(long groupId,int start,int end) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByGroup(groupId,start,end);
	}
	
	public List<ContactsDepartmentProperty> findByContactsDepartment(long departmentId) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByContactsDepartment(departmentId);
	}
	
	public List<ContactsDepartmentProperty> findByContactsDepartment(long departmentId,int start,int end) throws SystemException{
		return contactsDepartmentPropertyPersistence.findByContactsDepartment(departmentId,start,end);
	}
	
	public List<ContactsDepartmentProperty> findByPropertyKey(long groupId, long departmentId, String propertyKey){
		return ContactsDepartmentPropertyFinderUtil.findByPropertyKey(groupId, departmentId, propertyKey);
	}
	
	public ContactsDepartmentProperty addDepartmentProperty(long companyId,long groupId,long userId,String userName,long departmentId,
		String propertyKey,String propertyValue,String propertyType) throws SystemException{
		
		Date now = new Date();
		
		long propertyId = counterLocalService.increment();
		
		ContactsDepartmentProperty departmentProperty = contactsDepartmentPropertyPersistence.create(propertyId);
		
		departmentProperty.setCompanyId(companyId);
		departmentProperty.setGroupId(groupId);
		departmentProperty.setUserId(userId);
		departmentProperty.setUserName(userName);
		departmentProperty.setDepartmentId(departmentId);
		departmentProperty.setPropertyKey(propertyKey);
		departmentProperty.setPropertyValue(propertyValue);
		departmentProperty.setPropertyType(propertyType);
		departmentProperty.setCreateDate(now);
		departmentProperty.setModifiedDate(now);
		
		contactsDepartmentPropertyPersistence.update(departmentProperty, false);
		
		return departmentProperty;
	}
	
	public ContactsDepartmentProperty addDepartmentProperty(long propertyId,long companyId,long groupId,long userId,String userName,long departmentId,
		String propertyKey,String propertyValue,String propertyType) throws SystemException{
		
		Date now = new Date();
		
		ContactsDepartmentProperty departmentProperty = contactsDepartmentPropertyPersistence.fetchByPrimaryKey(propertyId);
		
		departmentProperty.setCompanyId(companyId);
		departmentProperty.setGroupId(groupId);
		departmentProperty.setUserId(userId);
		departmentProperty.setUserName(userName);
		departmentProperty.setDepartmentId(departmentId);
		departmentProperty.setPropertyKey(propertyKey);
		departmentProperty.setPropertyValue(propertyValue);
		departmentProperty.setPropertyType(propertyType);
		departmentProperty.setModifiedDate(now);
		
		contactsDepartmentPropertyPersistence.update(departmentProperty, false);
		
		return departmentProperty;
	}
	
	public void deleteDepartmentProperty(long propertyId) throws NoSuchContactsDepartmentPropertyException, SystemException{
		
		contactsDepartmentPropertyPersistence.remove(propertyId);
	}
}


