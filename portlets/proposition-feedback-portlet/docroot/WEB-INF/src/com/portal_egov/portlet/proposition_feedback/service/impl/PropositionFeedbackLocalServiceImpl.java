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

package com.portal_egov.portlet.proposition_feedback.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.service.base.PropositionFeedbackLocalServiceBaseImpl;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFeedbackFinderUtil;

/**
 * The implementation of the proposition feedback local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun 
 * ServiceBuilder to copy their definitions into the 
 * {@link com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 *  propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.proposition_feedback.service.base.PropositionFeedbackLocalServiceBaseImpl
 * @see com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil
 */
public class PropositionFeedbackLocalServiceImpl
	extends PropositionFeedbackLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use 
	 * {@link com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil} 
	 * to access the proposition feedback local service.
	 */
	
	
	public int countAll() throws SystemException{
		return propositionFeedbackPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return propositionFeedbackPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return propositionFeedbackPersistence.countByGroup(groupId);
	}
	
	public int countByPropositionAndCompany(long companyId,long propositionId) throws SystemException{
		return propositionFeedbackPersistence.countByPropositionAndCompany(companyId, propositionId);
	}
	
	public int countByPropositionAndGroup(long groupId,long propositionId) throws SystemException{
		return propositionFeedbackPersistence.countByPropositionAndGroup(groupId, propositionId);
	}
	
	public int countByPropositionAndStatusAndCompany(long companyId,long propositionId,int status) throws SystemException{
		return propositionFeedbackPersistence.countByPropositionAndStatusAndCompany(companyId, propositionId,status);
	}
	
	public int countByPropositionAndStatusAndGroup(long groupId,long propositionId,int status) throws SystemException{
		return propositionFeedbackPersistence.countByPropositionAndStatusAndGroup(groupId, propositionId,status);
	}
	
	public List<PropositionFeedback> findAll() throws SystemException{
		return propositionFeedbackPersistence.findAll();
	}
	
	public List<PropositionFeedback> findByCompany(long companyId) throws SystemException{
		return propositionFeedbackPersistence.findByCompany(companyId);
	}
	
	public List<PropositionFeedback> findByCompany(long companyId,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByCompany(companyId,start,end);
	}
	
	public List<PropositionFeedback> findByGroup(long groupId) throws SystemException{
		return propositionFeedbackPersistence.findByGroup(groupId);
	}
	
	public List<PropositionFeedback> findByGroup(long groupId,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByGroup(groupId, start, end);
	}
	
	public List<PropositionFeedback> findByStatusAndCompany(long companyId,int feedbackStatus) throws SystemException{
		return propositionFeedbackPersistence.findByStatusAndCompany(companyId, feedbackStatus);
	}
	
	public List<PropositionFeedback> findByStatusAndCompany(long companyId,int feedbackStatus,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByStatusAndCompany(companyId,feedbackStatus,start,end);
	}
	
	public List<PropositionFeedback> findByStatusAndGroup(long groupId,int feedbackStatus) throws SystemException{
		return propositionFeedbackPersistence.findByStatusAndGroup(groupId, feedbackStatus);
	}
	
	public List<PropositionFeedback> findByStatusAndGroup(long groupId,int feedbackStatus,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByStatusAndGroup(groupId,feedbackStatus, start, end);
	}
	
	public List<PropositionFeedback> findByPropositionAndCompany(long companyId,long propositionId) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndCompany(companyId,propositionId);
	}
	
	public List<PropositionFeedback> findByPropositionAndCompany(long companyId,long propositionId,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndCompany(companyId,propositionId,start,end);
	}
	
	public List<PropositionFeedback> findByPropositionAndGroup(long groupId,long propositionId) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndGroup(groupId,propositionId);
	}
	
	public List<PropositionFeedback> findByPropositionAndGroup(long groupId,long propositionId,int start,int end) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndGroup(groupId,propositionId, start, end);
	}
	
	public List<PropositionFeedback> findByPropositionAndStatusAndCompany(long companyId,long propositionId,int status) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndStatusAndCompany(companyId,propositionId,status);
	}
	
	public List<PropositionFeedback> findByPropositionAndStatusAndCompany(long companyId,long propositionId,int status,int start,int end) 
					throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndStatusAndCompany(companyId,propositionId,status,start,end);
	}
	
	public List<PropositionFeedback> findByPropositionAndStatusAndGroup(long groupId,long propositionId,int status) throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndStatusAndGroup(groupId,propositionId,status);
	}
	
	public List<PropositionFeedback> findByPropositionAndStatusAndGroup(long groupId,long propositionId,int status,int start,int end) 
					throws SystemException{
		return propositionFeedbackPersistence.findByPropositionAndStatusAndGroup(groupId,propositionId,status, start, end);
	}
	
	public List<PropositionFeedback> findByKeyword(long groupId,long propositionId,String keyword,int feedbackStatus,int start,int end,OrderByComparator obc) 
					throws SystemException{
		
		return PropositionFeedbackFinderUtil.findByKeyword(groupId, propositionId, keyword, feedbackStatus, start, end, obc);
	}
	
	public PropositionFeedback addPropositionFeedback(long companyId,long groupId,long userId,long propositionId,long feedbackFileAttId,String feedbackTitle,
												String feedbackContent,String citizenName,String citizenEmail,String citizenPhone,String citizenAddress,
												int feedbackStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long feedbackId = counterLocalService.increment();
		
		PropositionFeedback feedback = propositionFeedbackPersistence.create(feedbackId);
		
		feedback.setCompanyId(companyId);
		feedback.setGroupId(groupId);
		feedback.setUserId(userId);
		feedback.setPropositionId(propositionId);
		feedback.setFeedbackFileAttId(feedbackFileAttId);
		feedback.setFeedbackTitle(feedbackTitle);
		feedback.setFeedbackContent(feedbackContent);
		feedback.setCitizenName(citizenName);
		feedback.setCitizenEmail(citizenEmail);
		feedback.setCitizenPhone(citizenPhone);
		feedback.setCitizenAddress(citizenAddress);
		feedback.setCreateDate(now);
		feedback.setModifiedDate(now);
		feedback.setStatus(feedbackStatus);
		feedback.setStatusByUserId(userId);
		feedback.setStatusDate(now);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addPropositionFeedbackResources(feedback, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addPropositionFeedbackResources(feedback, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		propositionFeedbackPersistence.update(feedback, false);
		
		PropositionLocalServiceUtil.incrementFeedbackCounter(propositionId);
		
		return feedback;
	}
	
	public PropositionFeedback updatePropositionFeedback(long feedbackId,long companyId,long groupId,long userId,long propositionId,long feedbackFileAttId,
													String feedbackTitle,String feedbackContent,String citizenName,String citizenEmail,String citizenPhone,
													String citizenAddress,int feedbackStatus) throws SystemException, PortalException{
		
		Date now = new Date();
		
		PropositionFeedback feedback = propositionFeedbackPersistence.fetchByPrimaryKey(feedbackId);
		
		feedback.setCompanyId(companyId);
		feedback.setGroupId(groupId);
		feedback.setUserId(userId);
		feedback.setPropositionId(propositionId);
		feedback.setFeedbackFileAttId(feedbackFileAttId);
		feedback.setFeedbackTitle(feedbackTitle);
		feedback.setFeedbackContent(feedbackContent);
		feedback.setCitizenName(citizenName);
		feedback.setCitizenEmail(citizenEmail);
		feedback.setCitizenPhone(citizenPhone);
		feedback.setCitizenAddress(citizenAddress);
		feedback.setModifiedDate(now);
		feedback.setStatus(feedbackStatus);
		feedback.setStatusByUserId(userId);
		feedback.setStatusDate(now);
		
		propositionFeedbackPersistence.update(feedback, false);
		
		return feedback;
	}
	
	public PropositionFeedback deletePropositionFeedback(long feedbackId) throws SystemException, NoSuchPropositionFeedbackException{
		
		if(feedbackId > 0){
			
			PropositionFeedback feedback = propositionFeedbackPersistence.fetchByPrimaryKey(feedbackId);
			
			if(feedback != null){
				
				PropositionLocalServiceUtil.descrementFeedbackCounter(feedback.getPropositionId());
			}
		}
		
		return propositionFeedbackPersistence.remove(feedbackId);
	}
	
	private void addPropositionFeedbackResources(PropositionFeedback propositionFeedback,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(propositionFeedback.getCompanyId(), propositionFeedback.getGroupId(), 
			propositionFeedback.getUserId(), PropositionFeedback.class.getName(),
			propositionFeedback.getFeedbackId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addPropositionFeedbackResources(PropositionFeedback propositionFeedback,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(propositionFeedback.getCompanyId(), propositionFeedback.getGroupId(),
			propositionFeedback.getUserId(), PropositionFeedback.class.getName(),
			propositionFeedback.getFeedbackId(), groupPermissions, guestPermissions);
	}	
}