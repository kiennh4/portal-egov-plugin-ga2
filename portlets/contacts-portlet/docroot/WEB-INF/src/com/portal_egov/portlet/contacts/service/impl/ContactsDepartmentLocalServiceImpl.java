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
import com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;
import com.portal_egov.portlet.contacts.comparator.DepartmentPriorityComparator;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.service.base.ContactsDepartmentLocalServiceBaseImpl;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentFinderUtil;

/**
 * The implementation of the contacts department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added,
 *  rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 *  credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil
 */
public class ContactsDepartmentLocalServiceImpl extends ContactsDepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. 
	 * Always use {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil} to access the contacts department local service.
	 */
	
	public int countAll() throws SystemException{
		return contactsDepartmentPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return contactsDepartmentPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return contactsDepartmentPersistence.countByGroup(groupId);
	}
	
	public int countByParentAndCompany(long companyId,long parentId) throws SystemException{
		return contactsDepartmentPersistence.countByParentAndCompany(companyId, parentId);
	}
	
	public int countByParentAndGroup(long groupId,long parentId) throws SystemException{
		return contactsDepartmentPersistence.countByParentAndGroup(groupId, parentId);
	}
	
	public int countByStatusAndCompany(long companyId,int departmentStatus) throws SystemException{
		return contactsDepartmentPersistence.countByStatusAndCompany(companyId, departmentStatus);
	}
	
	public int countByStatusAndGroup(long groupId,int departmentStatus) throws SystemException{
		return contactsDepartmentPersistence.countByStatusAndGroup(groupId, departmentStatus);
	}
	
	public List<ContactsDepartment> findAll() throws SystemException{
		return contactsDepartmentPersistence.findAll();
	}
	
	public List<ContactsDepartment> findByCompany(long companyId) throws SystemException{
		return contactsDepartmentPersistence.findByCompany(companyId);
	}
	
	public List<ContactsDepartment> findByCompany(long companyId,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByCompany(companyId,start,end);
	}
	
	public List<ContactsDepartment> findByGroup(long groupId) throws SystemException{
		return contactsDepartmentPersistence.findByGroup(groupId);
	}
	
	public List<ContactsDepartment> findByGroup(long groupId,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByGroup(groupId,start,end);
	}
	
	public List<ContactsDepartment> findByParentAndCompany(long companyId,long parentId) throws SystemException{
		return contactsDepartmentPersistence.findByParentAndCompany(companyId, parentId);
	}
	
	public List<ContactsDepartment> findByParentAndCompany(long companyId,long parentId,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByParentAndCompany(companyId, parentId,start,end);
	}
	
	public List<ContactsDepartment> findByParentAndGroup(long groupId,long parentId) throws SystemException{
		return contactsDepartmentPersistence.findByParentAndGroup(groupId, parentId);
	}
	
	public List<ContactsDepartment> findByParentAndGroup(long groupId,long parentId,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByParentAndGroup(groupId, parentId,start,end);
	}
	
	public List<ContactsDepartment> findByStatusAndCompany(long companyId,int departmentStatus) throws SystemException{
		return contactsDepartmentPersistence.findByStatusAndCompany(companyId, departmentStatus);
	}
	
	public List<ContactsDepartment> findByStatusAndCompany(long companyId,int departmentStatus,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByStatusAndCompany(companyId, departmentStatus,start,end);
	}
	
	public List<ContactsDepartment> findByStatusAndGroup(long groupId,int departmentStatus) throws SystemException{
		return contactsDepartmentPersistence.findByStatusAndGroup(groupId, departmentStatus);
	}
	
	public List<ContactsDepartment> findByStatusAndGroup(long groupId,int departmentStatus,int start,int end) throws SystemException{
		return contactsDepartmentPersistence.findByStatusAndGroup(groupId, departmentStatus,start,end);
	}
	
	public List<ContactsDepartment> findByKeyword(long groupId, long parentId, String keyword,int departmentStatus,int start,int end){
		return ContactsDepartmentFinderUtil.findByKeyword(groupId, parentId, keyword, departmentStatus, start, end);
	}
	
	public ContactsDepartment addDepartment(long groupId,long companyId,long userId,String userName,long parentId,String departmentName,
		String departmentAddress,String departmentPhone,String departmentWebsite,String departmentEmail,
		int displayPriority,int departmentStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long departmentId = counterLocalService.increment();
		
		ContactsDepartment contactDepartment = contactsDepartmentPersistence.create(departmentId);
		
		contactDepartment.setGroupId(groupId);
		contactDepartment.setCompanyId(companyId);
		contactDepartment.setUserId(userId);
		contactDepartment.setUserName(userName);
		contactDepartment.setParentId(parentId);
		contactDepartment.setDepartmentName(departmentName);
		contactDepartment.setDepartmentAddress(departmentAddress);
		contactDepartment.setDepartmentPhone(departmentPhone);
		contactDepartment.setDepartmentWebsite(departmentWebsite);
		contactDepartment.setDepartmentEmail(departmentEmail);
		contactDepartment.setDisplayPriority(displayPriority);
		contactDepartment.setDepartmentStatus(departmentStatus);
		contactDepartment.setCreateDate(now);
		contactDepartment.setModifiedDate(now);
		
		contactsDepartmentPersistence.update(contactDepartment, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addContactsDepartmentResources(contactDepartment, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addContactsDepartmentResources(contactDepartment, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
			
		return contactDepartment;
		
	}
	
	
	public ContactsDepartment updateDepartment(long departmentId,long groupId,long companyId,long userId,String userName,long parentId,
		String departmentName,String departmentAddress,String departmentPhone,String departmentWebsite,String departmentEmail,
		int displayPriority,int departmentStatus) throws SystemException{
		
		Date now = new Date();
		
		ContactsDepartment contactDepartment = contactsDepartmentPersistence.fetchByPrimaryKey(departmentId);
		
		contactDepartment.setGroupId(groupId);
		contactDepartment.setCompanyId(companyId);
		contactDepartment.setUserId(userId);
		contactDepartment.setUserName(userName);
		contactDepartment.setParentId(parentId);
		contactDepartment.setDepartmentName(departmentName);
		contactDepartment.setDepartmentAddress(departmentAddress);
		contactDepartment.setDepartmentPhone(departmentPhone);
		contactDepartment.setDepartmentWebsite(departmentWebsite);
		contactDepartment.setDepartmentEmail(departmentEmail);
		contactDepartment.setDisplayPriority(displayPriority);
		contactDepartment.setDepartmentStatus(departmentStatus);
		contactDepartment.setModifiedDate(now);
		
		contactsDepartmentPersistence.update(contactDepartment, false);
		
		return contactDepartment;
	}
	
	public void updateDepartmentState(long departmentId,int displayPriority) throws SystemException{
		
		ContactsDepartment contactDepartment = contactsDepartmentPersistence.fetchByPrimaryKey(departmentId);
		
		if(contactDepartment != null){
			
			Date now = new Date();
			
			boolean lessThan = false;

			if (contactDepartment.getDisplayPriority() < displayPriority) {
				lessThan = true;
			}
			
			contactDepartment.setModifiedDate(now);
			contactDepartment.setDisplayPriority(displayPriority);
			
			contactsDepartmentPersistence.update(contactDepartment, false);
			
			if(contactDepartment.getParentId() > 0){
				
				displayPriority = 0;
				
				List<ContactsDepartment> childDepartmentList = findByParentAndGroup(contactDepartment.getGroupId(), contactDepartment.getParentId());
				
				OrderByComparator departmentPriorityComparator = new DepartmentPriorityComparator(contactDepartment, lessThan);
				
				ListUtil.sort(childDepartmentList, departmentPriorityComparator);
				
				for(ContactsDepartment childDepartment : childDepartmentList){
					
					childDepartment.setModifiedDate(now);
					childDepartment.setDisplayPriority(displayPriority++);
					
					contactsDepartmentPersistence.update(childDepartment, false);
				}
			}
		}
	}
	
	public void updateDepartmentParent(long departmentId,long parentDepartmentId) throws SystemException{
		
		ContactsDepartment contactDepartment = contactsDepartmentPersistence.fetchByPrimaryKey(departmentId);
		
		if(contactDepartment != null){
			
			Date now = new Date();
			
			contactDepartment.setModifiedDate(now);
			contactDepartment.setParentId(parentDepartmentId);
			
			contactsDepartmentPersistence.update(contactDepartment, false);
			
		}
	}
	
	public void deleteDepartment(long departmentId) throws NoSuchContactsDepartmentException, SystemException{
		
		contactsDepartmentPersistence.remove(departmentId);
		
	}
	
	
	private void addContactsDepartmentResources(ContactsDepartment contactDepartment,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(contactDepartment.getCompanyId(), contactDepartment.getGroupId(), 
			contactDepartment.getUserId(), ContactsDepartment.class.getName(),
			contactDepartment.getDepartmentId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addContactsDepartmentResources(ContactsDepartment contactDepartment,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(contactDepartment.getCompanyId(), contactDepartment.getGroupId(),
			contactDepartment.getUserId(), ContactsDepartment.class.getName(),
			contactDepartment.getDepartmentId(), groupPermissions, guestPermissions);
	}
}
