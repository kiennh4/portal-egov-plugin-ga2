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
import com.portal_egov.portlet.contacts.NoSuchContactsPropertyException;
import com.portal_egov.portlet.contacts.model.ContactsProperty;
import com.portal_egov.portlet.contacts.service.base.ContactsPropertyLocalServiceBaseImpl;
import com.portal_egov.portlet.contacts.service.persistence.ContactsPropertyFinderUtil;

/**
 * The implementation of the contacts property local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added,
 *  rerun ServiceBuilder to copy their definitions into the 
 *  {@link com.portal_egov.portlet.contacts.service.ContactsPropertyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security 
 * checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsPropertyLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsPropertyLocalServiceUtil
 */
public class ContactsPropertyLocalServiceImpl
	extends ContactsPropertyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. 
	 * Always use {@link com.portal_egov.portlet.contacts.service.ContactsPropertyLocalServiceUtil} 
	 * to access the contacts property local service.
	 */
	
	public int countAll() throws SystemException{
		return contactsPropertyPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return contactsPropertyPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return contactsPropertyPersistence.countByGroup(groupId);
	}
	
	public int countByContact(long contactId) throws SystemException{
		return contactsPropertyPersistence.countByContact(contactId);
	}
	
	public List<ContactsProperty> findByCompany(long companyId) throws SystemException{
		return contactsPropertyPersistence.findByCompany(companyId);
	}
	
	public List<ContactsProperty> findByCompany(long companyId,int start,int end) throws SystemException{
		return contactsPropertyPersistence.findByCompany(companyId,start,end);
	}
	
	public List<ContactsProperty> findByGroup(long groupId) throws SystemException{
		return contactsPropertyPersistence.findByGroup(groupId);
	}
	
	public List<ContactsProperty> findByGroup(long groupId,int start,int end) throws SystemException{
		return contactsPropertyPersistence.findByGroup(groupId,start,end);
	}
	
	public List<ContactsProperty> findByContact(long contactId) throws SystemException{
		return contactsPropertyPersistence.findByContact(contactId);
	}
	
	public List<ContactsProperty> findByContact(long contactId,int start,int end) throws SystemException{
		return contactsPropertyPersistence.findByContact(contactId,start,end);
	}
	
	public List<ContactsProperty> findByContactAndPropertyKey(long contactId,String propertyKey) throws SystemException{
		return contactsPropertyPersistence.findByContactAndPropertyKey(contactId, propertyKey);
	}
	
	public List<ContactsProperty> findByContactAndPropertyKey(long contactId,String propertyKey,int start,int end) throws SystemException{
		return contactsPropertyPersistence.findByContactAndPropertyKey(contactId, propertyKey,start,end);
	}
	
	public List<ContactsProperty> findByPropertyKey(long groupId, long contactId, String propertyKey){
		return ContactsPropertyFinderUtil.findByPropertyKey(groupId, contactId, propertyKey);
	}
	
	public ContactsProperty addContactProperty(long groupId,long companyId,long userId,String userName,long contactId,
		String propertyKey,String propertyValue,String propertyType) throws SystemException{
		
		Date now = new Date();
		
		long propertyId = counterLocalService.increment();
		
		ContactsProperty contactsProperty = contactsPropertyPersistence.create(propertyId);
		
		contactsProperty.setCompanyId(companyId);
		contactsProperty.setGroupId(groupId);
		contactsProperty.setUserId(userId);
		contactsProperty.setUserName(userName);
		contactsProperty.setContactId(contactId);
		contactsProperty.setPropertyKey(propertyKey);
		contactsProperty.setPropertyValue(propertyValue);
		contactsProperty.setPropertyType(propertyType);
		contactsProperty.setCreateDate(now);
		contactsProperty.setModifiedDate(now);
		
		contactsPropertyPersistence.update(contactsProperty, false);
		
		return contactsProperty;
	}
	
	public ContactsProperty updateContactProperty(long propertyId,long groupId,long companyId,long userId,String userName,long contactId,
		String propertyKey,String propertyValue,String propertyType) throws SystemException{
		
		Date now = new Date();
		
		ContactsProperty contactsProperty = contactsPropertyPersistence.fetchByPrimaryKey(propertyId);
		
		contactsProperty.setCompanyId(companyId);
		contactsProperty.setGroupId(groupId);
		contactsProperty.setUserId(userId);
		contactsProperty.setUserName(userName);
		contactsProperty.setContactId(contactId);
		contactsProperty.setPropertyKey(propertyKey);
		contactsProperty.setPropertyValue(propertyValue);
		contactsProperty.setPropertyType(propertyType);
		contactsProperty.setModifiedDate(now);
		
		contactsPropertyPersistence.update(contactsProperty, false);
		
		return contactsProperty;
	}
	
	public void deleteContactProperty(long propertyId) throws NoSuchContactsPropertyException, SystemException{
		contactsPropertyPersistence.remove(propertyId);
	}
}