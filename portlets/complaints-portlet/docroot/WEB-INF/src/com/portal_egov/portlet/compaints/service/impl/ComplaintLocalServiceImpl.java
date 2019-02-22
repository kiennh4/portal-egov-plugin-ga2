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

package com.portal_egov.portlet.compaints.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.compaints.model.Complaint;
import com.portal_egov.portlet.compaints.service.base.ComplaintLocalServiceBaseImpl;
import com.portal_egov.portlet.compaints.service.persistence.ComplaintFinderUtil;

/**
 * The implementation of the complaint local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.compaints.service.ComplaintLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.compaints.service.base.ComplaintLocalServiceBaseImpl
 * @see com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil
 */
public class ComplaintLocalServiceImpl extends ComplaintLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil} to
	 * access the complaint local service.
	 */
	
	public Complaint getComplaint(long complaintId) throws SystemException{
		
		return complaintPersistence.fetchByPrimaryKey(complaintId);
	}
	
	public List<Complaint> findByGroup(long groupId) throws SystemException{
		
		return complaintPersistence.findByGroup(groupId);
	}
	
	public List<Complaint> findByKeyword(long groupId,String keyword,int status,int start,int end,OrderByComparator obc){
		
		return ComplaintFinderUtil.findByKeyword(groupId, keyword,status, start, end, obc);
	}
	
	public Complaint addComplaint(long companyId,long groupId,long userId,String userName,
		String complaintTitle,String complaintDescription,String complaintContent,String fileAttachmentURL,
		int complaintStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long complaintId = counterLocalService.increment();
		
		Complaint complaint = complaintPersistence.create(complaintId);
		
		complaint.setCompanyId(companyId);
		complaint.setGroupId(groupId);
		complaint.setUserId(userId);
		complaint.setUserName(userName);
		complaint.setCreateDate(now);
		complaint.setModifiedDate(now);
		
		complaint.setComplaintTitle(complaintTitle);
		complaint.setComplaintDescription(complaintDescription);
		complaint.setComplaintContent(complaintContent);
		complaint.setFileAttachmentURL(fileAttachmentURL);
		complaint.setComplaintStatus(complaintStatus);
		
		complaintPersistence.update(complaint, false);
		
		resourceLocalService.addModelResources(complaint, serviceContext);
		
		return complaint;
	}
	
	
	public Complaint updateComplaint(long complaintId,long companyId,long groupId,long userId,String userName,
		String complaintTitle,String complaintDescription,String complaintContent,String fileAttachmentURL,
		int complaintStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		Complaint complaint = complaintPersistence.fetchByPrimaryKey(complaintId);
		
		complaint.setCompanyId(companyId);
		complaint.setGroupId(groupId);
		complaint.setUserId(userId);
		complaint.setUserName(userName);
		complaint.setModifiedDate(now);
		
		complaint.setComplaintTitle(complaintTitle);
		complaint.setComplaintDescription(complaintDescription);
		complaint.setComplaintContent(complaintContent);
		complaint.setFileAttachmentURL(fileAttachmentURL);
		complaint.setComplaintStatus(complaintStatus);
		
		complaintPersistence.update(complaint, false);
		
		updateObjectResources(complaint, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return complaint;
	}
	
	public Complaint deleteComplaint(long complaintId) throws SystemException, PortalException{
		
		if(complaintId > 0L){
			
			Complaint complaint = complaintPersistence.fetchByPrimaryKey(complaintId);
			
			if(complaint != null){
				
				resourceLocalService.deleteResource(
					complaint.getCompanyId(), Complaint.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, complaint.getPrimaryKey());
				
			}
		}
		
		return complaintPersistence.remove(complaintId);
	}
	
	protected void updateObjectResources(Complaint complaint,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(complaint.getCompanyId(),
			complaint.getGroupId(), Complaint.class.getName(),
			complaint.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
