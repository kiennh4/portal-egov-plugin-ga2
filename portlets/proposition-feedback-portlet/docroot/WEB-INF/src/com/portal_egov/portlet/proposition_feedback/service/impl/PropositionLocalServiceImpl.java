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
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;
import com.portal_egov.portlet.proposition_feedback.service.base.PropositionLocalServiceBaseImpl;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFinderUtil;
import com.portal_egov.portlet.proposition_feedback.util.PropositionConstants;

/**
 * The implementation of the proposition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder
 *  to copy their definitions into the {@link com.portal_egov.portlet.proposition_feedback.service.PropositionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated 
 * JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.proposition_feedback.service.base.PropositionLocalServiceBaseImpl
 * @see com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil
 */
public class PropositionLocalServiceImpl extends PropositionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use 
	 * {@link com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil} to access the proposition local service.
	 */
	
	public int countAll() throws SystemException{
		return propositionPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return propositionPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return propositionPersistence.countByGroup(groupId);
	}
	
	public int countByCategoryAndCompany(long companyId,long categoryId) throws SystemException{
		return propositionPersistence.countByCategoryAndCompany(companyId, categoryId);
	}
	
	public int countByCategoryAndGroup(long groupId,long categoryId) throws SystemException{
		return propositionPersistence.countByCategoryAndGroup(groupId, categoryId);
	}
	
	public int countByStatusAndCompany(long companyId,int propositionStatus) throws SystemException{
		return propositionPersistence.countByStatusAndCompany(companyId, propositionStatus);
	}
	
	public int countByStatusAndGroup(long groupId,int propositionStatus) throws SystemException{
		return propositionPersistence.countByStatusAndGroup(groupId, propositionStatus);
	}
	
	public int countByCategoryAndStatusAndCompany(long companyId,long categoryId,int propositionStatus) throws SystemException{
		return propositionPersistence.countByCategoryAndStatusAndCompany(companyId, categoryId, propositionStatus);
	}
	
	public int countByCategoryAndStatusAndGroup(long groupId,long categoryId,int propositionStatus) throws SystemException{
		return propositionPersistence.countByCategoryAndStatusAndGroup(groupId, categoryId, propositionStatus);
	}
	
	public List<Proposition> findAll() throws SystemException{
		return propositionPersistence.findAll();
	}
	
	public List<Proposition> findByCompany(long companyId) throws SystemException{
		return propositionPersistence.findByCompany(companyId);
	}
	
	public List<Proposition> findByCompany(long companyId,int start,int end) throws SystemException{
		return propositionPersistence.findByCompany(companyId,start,end);
	}
	
	public List<Proposition> findByGroup(long groupId) throws SystemException{
		return propositionPersistence.findByGroup(groupId);
	}
	
	public List<Proposition> findByGroup(long groupId,int start,int end) throws SystemException{
		return propositionPersistence.findByGroup(groupId, start, end);
	}
	
	public List<Proposition> findByCategoryAndCompany(long companyId,long categoryId) throws SystemException{
		return propositionPersistence.findByCategoryAndCompany(companyId,categoryId);
	}
	
	public List<Proposition> findByCategoryAndCompany(long companyId,long categoryId,int start,int end) throws SystemException{
		return propositionPersistence.findByCategoryAndCompany(companyId,categoryId,start,end);
	}
	
	public List<Proposition> findByCategoryAndGroup(long groupId,long categoryId) throws SystemException{
		return propositionPersistence.findByCategoryAndGroup(groupId,categoryId);
	}
	
	public List<Proposition> findByCategoryAndGroup(long groupId,long categoryId,int start,int end) throws SystemException{
		return propositionPersistence.findByCategoryAndGroup(groupId,categoryId, start, end);
	}
	
	public List<Proposition> findByStatusAndCompany(long companyId,int status) throws SystemException{
		return propositionPersistence.findByStatusAndCompany(companyId,status);
	}
	
	public List<Proposition> findByStatusAndCompany(long companyId,int status,int start,int end) throws SystemException{
		return propositionPersistence.findByStatusAndCompany(companyId,status,start,end);
	}
	
	public List<Proposition> findByStatusAndGroup(long groupId,int status) throws SystemException{
		return propositionPersistence.findByStatusAndGroup(groupId,status);
	}
	
	public List<Proposition> findByStatusAndGroup(long groupId,int status,int start,int end) throws SystemException{
		return propositionPersistence.findByStatusAndGroup(groupId,status, start, end);
	}
	
	public List<Proposition> findByCategoryAndStatusAndCompany(long companyId,long categoryId,int status) throws SystemException{
		return propositionPersistence.findByCategoryAndStatusAndCompany(companyId,categoryId,status);
	}
	
	public List<Proposition> findByCategoryAndStatusAndCompany(long companyId,long categoryId,int status,int start,int end) throws SystemException{
		return propositionPersistence.findByCategoryAndStatusAndCompany(companyId,categoryId,status,start,end);
	}
	
	public List<Proposition> findByCategoryAndStatusAndGroup(long groupId,long categoryId,int status) throws SystemException{
		return propositionPersistence.findByCategoryAndStatusAndGroup(groupId,categoryId,status);
	}
	
	public List<Proposition> findByCategoryAndStatusAndGroup(long groupId,long categoryId,int status,int start,int end) throws SystemException{
		return propositionPersistence.findByCategoryAndStatusAndGroup(groupId,categoryId,status, start, end);
	}
	
	public List<Proposition> findByMultiCondition(long groupId,long categoryId,long compilationDepartmentId,
		long verificationDepartmentId,String keyword,int propositionStatus,int start,int end){
		
		return PropositionFinderUtil.findByMultiCondition(groupId, categoryId, compilationDepartmentId,
											verificationDepartmentId, keyword, propositionStatus,start,end);
	}
	
	public List<Proposition> findByMultiCondition(long groupId,long categoryId,long compilationDepartmentId,
		long verificationDepartmentId,String keyword,int propositionStatus,int start,int end,OrderByComparator obc){
		
		return PropositionFinderUtil.findByMultiCondition(groupId, categoryId, compilationDepartmentId,
											verificationDepartmentId, keyword, propositionStatus,start,end,obc);
	}
	
	public List<Proposition> findByPropositionStatus(long groupId,int propositionStatus,String orderByColumn,String orderByType,int start,int end){
		
		return PropositionFinderUtil.findByPropositionStatus(groupId, propositionStatus, orderByColumn, orderByType, start, end);
	}
	
	public Proposition addProposition(long companyId,long groupId,long userId,long categoryId,long compilationDepartmentId,
						long verificationDepartmentId,String propositionName,String propositionDesc,String propositionContent,
						long documentFileId,int status,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		
		long propositionId = counterLocalService.increment();
		
		Proposition proposition = propositionPersistence.create(propositionId);
		
		proposition.setCompanyId(companyId);
		proposition.setGroupId(groupId);
		proposition.setUserId(userId);
		proposition.setUserName(userName);
		proposition.setCategoryId(categoryId);
		proposition.setCompilationDepartmentId(compilationDepartmentId);
		proposition.setVerificationDepartmentId(verificationDepartmentId);
		proposition.setPropositionName(propositionName);
		proposition.setPropositionDesc(propositionDesc);
		proposition.setPropositionContent(propositionContent);
		proposition.setDocumentFileId(documentFileId);
		proposition.setCreateDate(now);
		proposition.setModifiedDate(now);
		proposition.setViewCount(PropositionConstants.DEFAULT_PROPOSITION_VIEW_COUNT);
		proposition.setFeedbackCount(PropositionConstants.DEFAULT_PROPOSITION_FEEDBACK_COUNT);
		proposition.setStatus(status);
		proposition.setStatusByUserId(userId);
		proposition.setStatusDate(now);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addPropositionResources(proposition, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addPropositionResources(proposition, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		propositionPersistence.update(proposition, false);
		
		//Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(Proposition.class);

		if(indexer != null){
			
			indexer.reindex(proposition);
		}
	
		return proposition;
	}
	
	public Proposition updateProposition(long propositionId, long companyId,long groupId,long userId,long categoryId,long compilationDepartmentId,
						long verificationDepartmentId,String propositionName,String propositionDesc,String propositionContent,
						long documentFileId,int status) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		Proposition proposition = propositionPersistence.fetchByPrimaryKey(propositionId);
		
		proposition.setCompanyId(companyId);
		proposition.setGroupId(groupId);
		proposition.setUserId(userId);
		proposition.setUserName(userName);
		proposition.setCategoryId(categoryId);
		proposition.setCompilationDepartmentId(compilationDepartmentId);
		proposition.setVerificationDepartmentId(verificationDepartmentId);
		proposition.setPropositionName(propositionName);
		proposition.setPropositionDesc(propositionDesc);
		proposition.setPropositionContent(propositionContent);
		proposition.setDocumentFileId(documentFileId);
		proposition.setModifiedDate(now);
		proposition.setStatus(status);
		proposition.setStatusByUserId(userId);
		proposition.setStatusDate(now);
		
		propositionPersistence.update(proposition, false);
		
		//Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(Proposition.class);


		if(indexer != null){
			
			indexer.reindex(proposition);
		}
		
		return proposition;
	}
	
	public Proposition incrementViewCounter(long propositionId) throws SystemException{
		
		Proposition proposition = propositionPersistence.fetchByPrimaryKey(propositionId);
		
		if(proposition != null){
			
			int oldViewCount = proposition.getViewCount();
			proposition.setViewCount(oldViewCount + 1);
			
			propositionPersistence.update(proposition, false);
		}
		return proposition;
	}
	
	public void incrementFeedbackCounter(long propositionId) throws SystemException{
		
		Proposition proposition = propositionPersistence.fetchByPrimaryKey(propositionId);
		
		if(proposition != null){
			
			int oldFeedbackCount = proposition.getFeedbackCount();
			proposition.setFeedbackCount(oldFeedbackCount + 1);
			
			propositionPersistence.update(proposition, false);
		}
	}
	
	public void descrementFeedbackCounter(long propositionId) throws SystemException{
		
		Proposition proposition = propositionPersistence.fetchByPrimaryKey(propositionId);
		
		if(proposition != null){
			
			int oldFeedbackCount = proposition.getFeedbackCount();
			proposition.setFeedbackCount(oldFeedbackCount - 1);
			
			propositionPersistence.update(proposition, false);
		}
	}
	
	public Proposition deleteProposition(long propositionId) throws SystemException, PortalException{
		
		if(propositionId > 0){
			
			Proposition proposition = propositionPersistence.fetchByPrimaryKey(propositionId);
			
			if(proposition!= null){
				resourceLocalService.deleteResource(proposition.getCompanyId(), PropositionCategory.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, proposition.getPropositionId());
				
				//Expando
				ExpandoValueLocalServiceUtil.deleteValues(Proposition.class.getName(), propositionId);
				
				// Indexer
				Indexer indexer = IndexerRegistryUtil.getIndexer(Proposition.class);
				
				if (indexer!=null)
				{
					indexer.delete(proposition);
				}
			}
		}
		
		return propositionPersistence.remove(propositionId);
	}
	
	private void addPropositionResources(Proposition proposition,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(proposition.getCompanyId(), proposition.getGroupId(), 
			proposition.getUserId(), Proposition.class.getName(),
			proposition.getPropositionId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addPropositionResources(Proposition proposition,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(proposition.getCompanyId(), proposition.getGroupId(),
			proposition.getUserId(), Proposition.class.getName(),
			proposition.getPropositionId(), groupPermissions, guestPermissions);
	}
	
}