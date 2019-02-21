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

package com.portal_egov.portlet.citizen_inquiry.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;
import com.portal_egov.portlet.citizen_inquiry.service.base.CitizenInquiryCategoryLocalServiceBaseImpl;

/**
 * The implementation of the citizen inquiry category local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.citizen_inquiry.service.base.CitizenInquiryCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryLocalServiceUtil
 */
public class CitizenInquiryCategoryLocalServiceImpl extends CitizenInquiryCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.citizen_inquiry.service.
	 * CitizenInquiryCategoryLocalServiceUtil} to access the citizen inquiry
	 * category local service.
	 */
	
	public List<CitizenInquiryCategory> getGroupCategories(long groupId) throws SystemException{
		
		return citizenInquiryCategoryPersistence.findByGroup(groupId);
	}
	
	public void addInquiryCategory(long companyId,long groupId,long userId,String userName,
		String categoryName,String categoryDesc,ServiceContext serviceContext) throws SystemException, PortalException{
		
		long categoryId = counterLocalService.increment();
		
		Date now = new Date();
		
		CitizenInquiryCategory inquiryCategory = citizenInquiryCategoryPersistence.create(categoryId);
		
		inquiryCategory.setCompanyId(companyId);
		inquiryCategory.setGroupId(groupId);
		inquiryCategory.setUserId(userId);
		inquiryCategory.setUserName(userName);
		inquiryCategory.setCreateDate(now);
		inquiryCategory.setModifiedDate(now);
		inquiryCategory.setCategoryName(categoryName);
		inquiryCategory.setCategoryDesc(categoryDesc);
		
		citizenInquiryCategoryPersistence.update(inquiryCategory, false);
		
		resourceLocalService.addModelResources(inquiryCategory, serviceContext);
	}
	
	public void updateInquiryCategory(long categoryId,long companyId,long groupId,long userId,String userName,
		String categoryName,String categoryDesc,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CitizenInquiryCategory inquiryCategory = citizenInquiryCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		inquiryCategory.setCompanyId(companyId);
		inquiryCategory.setGroupId(groupId);
		inquiryCategory.setUserId(userId);
		inquiryCategory.setUserName(userName);
		inquiryCategory.setModifiedDate(now);
		inquiryCategory.setCategoryName(categoryName);
		inquiryCategory.setCategoryDesc(categoryDesc);
		
		citizenInquiryCategoryPersistence.update(inquiryCategory, false);
		
		updateObjectResources(inquiryCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
	}
	
	public void deleteInquiryCategory(long categoryId) throws SystemException, PortalException{
		
		if(categoryId > 0L){
			
			CitizenInquiryCategory inquiryCategory = citizenInquiryCategoryPersistence.fetchByPrimaryKey(categoryId);
			
			if(inquiryCategory != null){
				
				
				resourceLocalService.deleteResource(
					inquiryCategory.getCompanyId(), CitizenInquiryCategory.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, inquiryCategory.getPrimaryKey());
				
				citizenInquiryCategoryPersistence.remove(inquiryCategory);
			}
		}
	}
	
	protected void updateObjectResources(CitizenInquiryCategory inquiryCategory,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(inquiryCategory.getCompanyId(),
			inquiryCategory.getGroupId(), CitizenInquiryCategory.class.getName(),
			inquiryCategory.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
