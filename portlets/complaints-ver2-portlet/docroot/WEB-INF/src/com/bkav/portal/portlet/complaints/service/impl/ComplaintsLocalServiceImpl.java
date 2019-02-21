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

package com.bkav.portal.portlet.complaints.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.complaints.model.Complaints;
import com.bkav.portal.portlet.complaints.service.base.ComplaintsLocalServiceBaseImpl;
import com.bkav.portal.portlet.complaints.service.persistence.ComplaintsFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the complaints local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.complaints.service.ComplaintsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see com.bkav.portal.portlet.complaints.service.base.ComplaintsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil
 */
public class ComplaintsLocalServiceImpl extends ComplaintsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil} to access the complaints local service.
	 */
	
	public List<Complaints> findByKeyWord (long groupId, String keyword, int start, int end, OrderByComparator obc) throws PortalException, SystemException
	{
		return ComplaintsFinderUtil.findByKeyword(groupId, keyword, start, end, obc);
	}
	
	public List<Complaints> findByGroupId (long groupId) throws PortalException, SystemException
	{
		return complaintsPersistence.findByGroupId(groupId);
	}
	
	public List<Complaints> findByCompanyId (long companyId) throws PortalException, SystemException
	{
		return complaintsPersistence.findByCompanyId(companyId);
	}
	
	public Complaints addComplaint (long groupId, long companyId, long userId, String complaintNumber, String complaintName
			, String complaintDesc, String complaintContent, Date signingDate, String replyDocument, ServiceContext serviceContext) throws PortalException, SystemException
	{
		long complaintId = counterLocalService.increment();
		Date now = new Date();
		
		Complaints complaint = complaintsPersistence.create(complaintId);
		complaint.setGroupId(groupId);
		complaint.setCompanyId(companyId);
		complaint.setUserId(userId);
		complaint.setCreateDate(now);
		complaint.setModifiedDate(now);
		complaint.setComplaintNumber(complaintNumber);
		complaint.setComplaintName(complaintName);
		complaint.setComplaintContent(complaintContent);
		complaint.setComplaintDesc(complaintDesc);
		complaint.setReplyDocument(replyDocument);
		complaint.setSigningDate(signingDate);
		
		complaintsPersistence.update(complaint, false);
		
		if(serviceContext.isAddGroupPermissions()
				|| serviceContext.isAddGuestPermissions()){
			
				addComplaintResources(complaint, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
			}else{
				
				addComplaintResources(complaint, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			}
		
		return complaint;
	}
	
	public Complaints updateComplaint (long complaintId, String complaintNumber, String complaintName
			, String complaintDesc, String complaintContent, Date signingDate, String replyDocument, ServiceContext serviceContext) throws PortalException, SystemException
	{
		Date now = new Date();
		
		Complaints complaint = complaintsPersistence.fetchByPrimaryKey(complaintId);
		complaint.setModifiedDate(now);
		complaint.setComplaintNumber(complaintNumber);
		complaint.setComplaintName(complaintName);
		complaint.setComplaintContent(complaintContent);
		complaint.setComplaintDesc(complaintDesc);
		complaint.setReplyDocument(replyDocument);
		complaint.setSigningDate(signingDate);
		
		complaintsPersistence.update(complaint, false);
		
		return complaint;
	}
	
	private void addComplaintResources(Complaints complaint,boolean addGroupPermissions,boolean addGuestPermissions) throws PortalException, SystemException{
		
		resourceLocalService.addResources(complaint.getCompanyId(), complaint.getGroupId(), 
				complaint.getUserId(), Complaints.class.getName(),
				complaint.getComplaintId(), false, addGroupPermissions, addGuestPermissions);
	}
	
	
	private void addComplaintResources(Complaints complaint,String[] groupPermissions,String[] guestPermissions) throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(complaint.getCompanyId(), complaint.getGroupId(),
				complaint.getUserId(), Complaints.class.getName(),
				complaint.getComplaintId(), groupPermissions, guestPermissions);
	}
}