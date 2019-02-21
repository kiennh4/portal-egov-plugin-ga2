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

package com.portal_egov.portlet.inquiry.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.inquiry.model.OnlineInquiry;
import com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil;
import com.portal_egov.portlet.inquiry.service.base.OnlineInquiryLocalServiceBaseImpl;
import com.portal_egov.portlet.inquiry.service.persistence.OnlineInquiryFinderUtil;

/**
 * The implementation of the online inquiry local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.inquiry.service.base.OnlineInquiryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil
 */
public class OnlineInquiryLocalServiceImpl extends OnlineInquiryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil} to
	 * access the online inquiry local service.
	 */
	
	public List<OnlineInquiry> findByGroup(long groupId) throws SystemException{
		
		return onlineInquiryPersistence.findByGroup(groupId);
	}
	
	public List<OnlineInquiry> findByKeyword(long groupId,String keyword,int start,int end,OrderByComparator obc){
		
		return OnlineInquiryFinderUtil.findByKeyword(groupId, keyword, start, end, obc);
	}
	
	public void addInquiry(long companyId,long groupId,long userId,String userName,
		String fullName,String phoneNumbers,String emailAddress,String inquiryContent,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		long inquiryId = counterLocalService.increment();
		
		Date now = new Date();
		
		OnlineInquiry inquiry = onlineInquiryPersistence.create(inquiryId);
		
		inquiry.setCompanyId(companyId);
		inquiry.setGroupId(groupId);
		inquiry.setUserId(userId);
		inquiry.setUserName(userName);
		inquiry.setCreateDate(now);
		inquiry.setModifiedDate(now);
		
		inquiry.setFullName(fullName);
		inquiry.setPhoneNumbers(phoneNumbers);
		inquiry.setEmailAddress(emailAddress);
		inquiry.setInquiryContent(inquiryContent);
		
		inquiry.setInquiryStatus(0);
		
		onlineInquiryPersistence.update(inquiry, false);
		
		resourceLocalService.addModelResources(inquiry, serviceContext);
		
	}
	
	public void updateInquiry(long inquiryId,long companyId,long groupId,long userId,String userName,
		String fullName,String phoneNumbers,String emailAddress,String inquiryContent,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		OnlineInquiry inquiry = onlineInquiryPersistence.create(inquiryId);
		
		inquiry.setCompanyId(companyId);
		inquiry.setGroupId(groupId);
		inquiry.setUserId(userId);
		inquiry.setUserName(userName);
		inquiry.setModifiedDate(now);
		
		
		inquiry.setFullName(fullName);
		inquiry.setPhoneNumbers(phoneNumbers);
		inquiry.setEmailAddress(emailAddress);
		inquiry.setInquiryContent(inquiryContent);
		
		inquiry.setInquiryStatus(0);
		
		onlineInquiryPersistence.update(inquiry, false);
		
		updateObjectResources(inquiry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
	}
	
	public void deleteInquiry(long inquiryId) throws SystemException, PortalException{
		
		if(inquiryId > 0L){
			
			OnlineInquiry inquiry = OnlineInquiryLocalServiceUtil.fetchOnlineInquiry(inquiryId);
			
			if(inquiry != null){
				
				resourceLocalService.deleteResource(
					inquiry.getCompanyId(), OnlineInquiry.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, inquiry.getPrimaryKey());
				
				onlineInquiryPersistence.remove(inquiry);
			}
		}
	}
	
	
	protected void updateObjectResources(OnlineInquiry inquiry,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(inquiry.getCompanyId(),
			inquiry.getGroupId(), OnlineInquiry.class.getName(),
			inquiry.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
