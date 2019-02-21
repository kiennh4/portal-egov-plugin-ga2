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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.service.base.CitizenInquiryLocalServiceBaseImpl;
import com.portal_egov.portlet.citizen_inquiry.service.persistence.CitizenInquiryFinderUtil;

/**
 * The implementation of the citizen inquiry local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.citizen_inquiry.service.base.CitizenInquiryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil
 */
public class CitizenInquiryLocalServiceImpl extends CitizenInquiryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.citizen_inquiry.service.
	 * CitizenInquiryLocalServiceUtil} to access the citizen inquiry local
	 * service.
	 */
	
	public List<CitizenInquiry> getGroupInquiries(long groupId) throws SystemException{
		
		return citizenInquiryPersistence.findByGroup(groupId);
	}
	
	
	public int countCategoryInquiries(long categoryId) throws SystemException{
		
		return citizenInquiryPersistence.countByCategory(categoryId);
	}
	
	public List<CitizenInquiry> getCategoryInquiries(long categoryId) throws SystemException{
		
		return citizenInquiryPersistence.findByCategory(categoryId);
	}
	
	public List<CitizenInquiry> findByKeyword(long groupId,long categoryId,String keyword,int start,int end,boolean allInquiry,OrderByComparator obc){
		
		return CitizenInquiryFinderUtil.findByKeyword(groupId, categoryId, keyword, start, end, allInquiry, obc);
	}
	
	public void addInquiry(long companyId,long groupId,long userId,String userName,long categoryId,String citizenName,
		String citizenPhone,String citizenEmail,String citizenAddress,String inquiryTitle,String inquiryContent,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		long inquiryId = counterLocalService.increment();
		
		Date now = new Date();
		
		CitizenInquiry inquiry = citizenInquiryPersistence.create(inquiryId);
		
		inquiry.setCompanyId(companyId);
		inquiry.setGroupId(groupId);
		inquiry.setUserId(userId);
		inquiry.setUserName(userName);
		inquiry.setCreateDate(now);
		inquiry.setModifiedDate(now);
		inquiry.setCategoryId(categoryId);
		inquiry.setCitizenName(citizenName);
		inquiry.setCitizenPhone(citizenPhone);
		inquiry.setCitizenEmail(citizenEmail);
		inquiry.setCitizenAddress(citizenAddress);
		inquiry.setInquiryTitle(inquiryTitle);
		inquiry.setInquiryContent(inquiryContent);
		inquiry.setInquiryFeedback(StringPool.BLANK);
		inquiry.setInquiryFeedbackUser(StringPool.BLANK);
		inquiry.setInquiryFeedbackDate(null);
		inquiry.setInquiryStatus(0);
		inquiry.setApproved(false);
		
		citizenInquiryPersistence.update(inquiry, false);
		
		resourceLocalService.addModelResources(inquiry, serviceContext);
		
	}
	
	public void updateInquiry(long inquiryId,long companyId,long groupId,long userId,String userName,long categoryId,String citizenName,
		String citizenPhone,String citizenEmail,String citizenAddress,String inquiryTitle,String inquiryContent,
		String inquiryFeedback,String inquiryFeedbackUser,Date inquiryFeedbackDate,boolean approved,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		CitizenInquiry inquiry = citizenInquiryPersistence.fetchByPrimaryKey(inquiryId);
		
		inquiry.setCompanyId(companyId);
		inquiry.setGroupId(groupId);
		inquiry.setUserId(userId);
		inquiry.setUserName(userName);
		inquiry.setModifiedDate(now);
		inquiry.setCategoryId(categoryId);
		inquiry.setCitizenName(citizenName);
		inquiry.setCitizenPhone(citizenPhone);
		inquiry.setCitizenEmail(citizenEmail);
		inquiry.setCitizenAddress(citizenAddress);
		inquiry.setInquiryTitle(inquiryTitle);
		inquiry.setInquiryContent(inquiryContent);
		inquiry.setInquiryFeedback(inquiryFeedback);
		inquiry.setInquiryFeedbackUser(inquiryFeedbackUser);
		inquiry.setInquiryFeedbackDate(inquiryFeedbackDate);
		inquiry.setApproved(approved);
		
		citizenInquiryPersistence.update(inquiry, false);
		
		updateObjectResources(inquiry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
	}
	
	public void updateInquiryFeedbackContent(long inquiryId,String feedbackContent,String feedbackUserName,
		Date feedbackDate,boolean approved) throws SystemException{
		
		CitizenInquiry inquiry = citizenInquiryPersistence.fetchByPrimaryKey(inquiryId);
		
		if(inquiry != null){
			
			inquiry.setInquiryFeedback(feedbackContent);
			inquiry.setInquiryFeedbackUser(feedbackUserName);
			inquiry.setInquiryFeedbackDate(feedbackDate);
			inquiry.setApproved(approved);
			
			citizenInquiryPersistence.update(inquiry, false);
		}
	}
	
	public void updateInquiryApprovedStatus(long inquiryId,boolean approvedStatus) throws SystemException{
		
		CitizenInquiry inquiry = citizenInquiryPersistence.fetchByPrimaryKey(inquiryId);
		
		if(inquiry != null){
			
			inquiry.setApproved(approvedStatus);
			
			citizenInquiryPersistence.update(inquiry, false);
		}
	}
	
	public void deleteInquiry(long inquiryId) throws SystemException, PortalException{
		
		if(inquiryId > 0L){
			
			CitizenInquiry inquiry = citizenInquiryPersistence.fetchByPrimaryKey(inquiryId);
			
			if(inquiry != null){
				
				resourceLocalService.deleteResource(
					inquiry.getCompanyId(), CitizenInquiry.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, inquiry.getPrimaryKey());
				
				citizenInquiryPersistence.remove(inquiry);
			}
		}
	}
	
	
	protected void updateObjectResources(CitizenInquiry inquiry,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(inquiry.getCompanyId(),
			inquiry.getGroupId(), CitizenInquiry.class.getName(),
			inquiry.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
