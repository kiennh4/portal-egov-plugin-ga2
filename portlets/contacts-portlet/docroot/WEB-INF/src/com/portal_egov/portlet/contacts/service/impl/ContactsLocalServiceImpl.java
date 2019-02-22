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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.contacts.NoSuchContactsException;
import com.portal_egov.portlet.contacts.comparator.ContactPriorityComparator;
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.service.base.ContactsLocalServiceBaseImpl;
import com.portal_egov.portlet.contacts.service.persistence.ContactsFinderUtil;

/**
 * The implementation of the contacts local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added,
 *  rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.contacts.service.ContactsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS 
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil
 */
public class ContactsLocalServiceImpl extends ContactsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil}
	 *  to access the contacts local service.
	 */
	
	public int countAll() throws SystemException{
		return contactsPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return contactsPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return contactsPersistence.countByGroup(groupId);
	}
	
	public int countByCompanyAndStatus(long companyId,int contactStatus) throws SystemException{
		return contactsPersistence.countByCompanyAndStatus(companyId,contactStatus);
	}
	
	public int countByGroupAndStatus(long groupId,int contactStatus) throws SystemException{
		return contactsPersistence.countByGroupAndStatus(groupId,contactStatus);
	}
	
	public int countByDepartmentAndCompany(long companyId,long departmentId) throws SystemException{
		return contactsPersistence.countByDepartmentAndCompany(companyId,departmentId);
	}
	
	public int countByDepartmentAndGroup(long groupId,long departmentId) throws SystemException{
		return contactsPersistence.countByDepartmentAndGroup(groupId,departmentId);
	}
	
	public int countByCompanyAndDepartmentAndStatus(long companyId,long departmentId,int contactStatus) throws SystemException{
		return contactsPersistence.countByCompanyAndDepartmentAndStatus(companyId,departmentId,contactStatus);
	}
	
	public int countByGroupAndDepartmentAndStatus(long groupId,long departmentId,int contactStatus) throws SystemException{
		return contactsPersistence.countByGroupAndDepartmentAndStatus(groupId,departmentId,contactStatus);
	}
	
	public List<Contacts> findAll() throws SystemException{
		return contactsPersistence.findAll();
	}
	
	public List<Contacts> findByCompany(long companyId) throws SystemException{
		return contactsPersistence.findByCompany(companyId);
	}
	
	public List<Contacts> findByCompany(long companyId,int start,int end) throws SystemException{
		return contactsPersistence.findByCompany(companyId,start,end);
	}

	public List<Contacts> findByGroup(long groupId) throws SystemException{
		return contactsPersistence.findByGroup(groupId);
	}
	
	public List<Contacts> findByGroup(long groupId,int start,int end) throws SystemException{
		return contactsPersistence.findByGroup(groupId,start,end);
	}

	public List<Contacts> findByDepartmentAndCompany(long companyId,long departmentId) throws SystemException{
		return contactsPersistence.findByDepartmentAndCompany(companyId,departmentId);
	}
	
	public List<Contacts> findByDepartmentAndCompany(long companyId,long departmentId,int start,int end) throws SystemException{
		return contactsPersistence.findByDepartmentAndCompany(companyId,departmentId,start,end);
	}

	public List<Contacts> findByDepartmentAndGroup(long groupId,long departmentId) throws SystemException{
		
		return contactsPersistence.findByDepartmentAndGroup(groupId,departmentId);
	}
	
	public List<Contacts> findByDepartmentAndGroup(long groupId,long departmentId,int start,int end) throws SystemException{
		return contactsPersistence.findByDepartmentAndGroup(groupId,departmentId,start,end);
	}

	public List<Contacts> findByCompanyAndDepartmentAndStatus(long companyId,long departmentId,int contactStatus) throws SystemException{
		return contactsPersistence.findByCompanyAndDepartmentAndStatus(companyId,departmentId,contactStatus);
	}
	
	public List<Contacts> findByCompanyAndDepartmentAndStatus(long companyId,long departmentId,int contactStatus,int start,int end) throws SystemException{
		return contactsPersistence.findByCompanyAndDepartmentAndStatus(companyId,departmentId,contactStatus,start,end);
	}

	public List<Contacts> findByGroupAndDepartmentAndStatus(long groupId,long departmentId,int contactStatus) throws SystemException{
		return contactsPersistence.findByGroupAndDepartmentAndStatus(groupId,departmentId,contactStatus);
	}
	
	public List<Contacts> findByGroupAndDepartmentAndStatus(long groupId,long departmentId,int contactStatus,int start,int end) throws SystemException{
		return contactsPersistence.findByGroupAndDepartmentAndStatus(groupId,departmentId,contactStatus,start,end);
	}
	
	public List<Contacts> findByKeyword(long groupId, String keyword, int contactStatus, int start, int end){
		return ContactsFinderUtil.findByKeyword(groupId, keyword, contactStatus, start, end);
	}
	
	public List<Contacts> findByKeywordAndDepartment(long groupId,long departmentId, String keyword, int contactStatus, int start, int end){
		return ContactsFinderUtil.findByKeywordAndDepartment(groupId, departmentId, keyword, contactStatus, start, end);
	}
	
	
	public Contacts addContact(long groupId,long companyId,long userId,String userName,long departmentId,String contactName,
		long avatarImageId,String jobTitle,String phoneNumbers,String homePhone,String mobile,String email,
		int displayPriority,int contactStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long contactId = counterLocalService.increment();
		
		Contacts contacts = contactsPersistence.create(contactId);
		
		contacts.setGroupId(groupId);
		contacts.setCompanyId(companyId);
		contacts.setUserId(userId);
		contacts.setUserName(userName);
		contacts.setDepartmentId(departmentId);
		contacts.setContactName(contactName);
		contacts.setImageId(avatarImageId);
		contacts.setJobTitle(jobTitle);
		contacts.setPhoneNumbers(phoneNumbers);
		contacts.setHomePhone(homePhone);
		contacts.setMobile(mobile);
		contacts.setEmail(email);
		contacts.setDisplayPriority(displayPriority);
		contacts.setContactStatus(contactStatus);
		contacts.setCreateDate(now);
		contacts.setModifiedDate(now);
		
		contactsPersistence.update(contacts, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addContactsResources(contacts, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addContactsResources(contacts, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return contacts;
	}
	
	
	public Contacts updateContact(long contactId,long groupId,long companyId,long userId,String userName,long departmentId,
		String contactName,long avatarImageId,String jobTitle,String phoneNumbers,String homePhone,String mobile,String email,
		int displayPriority,int contactStatus) throws SystemException, PortalException{
		
		Date now = new Date();
		
		Contacts contacts = contactsPersistence.fetchByPrimaryKey(contactId);
		
		contacts.setGroupId(groupId);
		contacts.setCompanyId(companyId);
		contacts.setUserId(userId);
		contacts.setUserName(userName);
		contacts.setDepartmentId(departmentId);
		contacts.setContactName(contactName);
		contacts.setImageId(avatarImageId);
		contacts.setJobTitle(jobTitle);
		contacts.setPhoneNumbers(phoneNumbers);
		contacts.setHomePhone(homePhone);
		contacts.setMobile(mobile);
		contacts.setEmail(email);
		contacts.setDisplayPriority(displayPriority);
		contacts.setContactStatus(contactStatus);
		contacts.setModifiedDate(now);
		
		contactsPersistence.update(contacts, false);
		
		return contacts;
	}
	
	public void updateContactState(long contactId,int displayPriority) throws SystemException{
		
		Contacts contacts = contactsPersistence.fetchByPrimaryKey(contactId);
		
		if(contacts != null){
			
			Date now = new Date();
			
			boolean lessThan = false;

			if (contacts.getDisplayPriority() < displayPriority) {
				lessThan = true;
			}
			
			contacts.setModifiedDate(now);
			contacts.setDisplayPriority(displayPriority);
			
			contactsPersistence.update(contacts, false);
			
			if(contacts.getDepartmentId() > 0){
				
				displayPriority = 0;
				
				List<Contacts> departmentContactList = findByDepartmentAndGroup(contacts.getGroupId(), contacts.getDepartmentId());
				
				OrderByComparator contactPriorityComparator = new ContactPriorityComparator(contacts, lessThan);
				
				ListUtil.sort(departmentContactList, contactPriorityComparator);
				
				for(Contacts departmentContact : departmentContactList){
					
					departmentContact.setModifiedDate(now);
					departmentContact.setDisplayPriority(displayPriority++);
					
					contactsPersistence.update(contacts, false);
				}
			}
		}
	}
	
	public void updateContactDepartment(long contactId,long departmentId) throws SystemException{
		
		Contacts contacts = contactsPersistence.fetchByPrimaryKey(contactId);
		
		if(contacts != null){
			
			Date now = new Date();
			
			contacts.setModifiedDate(now);
			contacts.setDepartmentId(contactId);
			
			contactsPersistence.update(contacts, false);
		}
	}
	
	public void deleteContact(long contactId) throws SystemException, NoSuchContactsException{
		
		contactsPersistence.remove(contactId);
	}
	
	
	private void addContactsResources(Contacts contacts ,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(contacts.getCompanyId(), contacts.getGroupId(), 
			contacts.getUserId(), Contacts.class.getName(),
			contacts.getContactId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addContactsResources(Contacts contacts ,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(contacts.getCompanyId(), contacts.getGroupId(),
			contacts.getUserId(), Contacts.class.getName(),
			contacts.getContactId(), groupPermissions, guestPermissions);
	}
}
