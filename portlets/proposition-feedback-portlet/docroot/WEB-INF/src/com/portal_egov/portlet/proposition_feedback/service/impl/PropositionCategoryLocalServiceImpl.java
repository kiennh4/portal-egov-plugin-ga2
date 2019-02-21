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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;
import com.portal_egov.portlet.proposition_feedback.service.base.PropositionCategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.proposition_feedback.util.PropositionConstants;

/**
 * The implementation of the proposition category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.proposition_feedback.service.base.PropositionCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil
 */
public class PropositionCategoryLocalServiceImpl
	extends PropositionCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil} to access the proposition category local service.
	 */
	
	public int countAll() throws SystemException{
		return propositionCategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return propositionCategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return propositionCategoryPersistence.countByGroup(groupId);
	}
	
	public int countByTypeAndCompany(long companyId,int categoryTypeId) throws SystemException{
		return propositionCategoryPersistence.countByTypeAndCompany(companyId, categoryTypeId);
	}
	
	public int countByTypeAndGroup(long groupId,int categoryTypeId) throws SystemException{
		return propositionCategoryPersistence.countByTypeAndGroup(groupId, categoryTypeId);
	}
	
	public int countByParentAndCompany(long companyId,long parentId) throws SystemException{
		return propositionCategoryPersistence.countByParentAndCompany(companyId, parentId);
	}
	
	public int countByParentAndGroup(long groupId,long parentId) throws SystemException{
		return propositionCategoryPersistence.countByParentAndGroup(groupId, parentId);
	}
	
	public List<PropositionCategory> findAll() throws SystemException{
		return propositionCategoryPersistence.findAll();
	}
	
	public List<PropositionCategory> findByCompany(long companyId) throws SystemException{
		return propositionCategoryPersistence.findByCompany(companyId);
	}
	
	public List<PropositionCategory> findByCompany(long companyId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<PropositionCategory> findByGroup(long groupId) throws SystemException{
		return propositionCategoryPersistence.findByGroup(groupId);
	}
	
	public List<PropositionCategory> findByGroup(long groupId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByGroup(groupId, start, end);
	}
	
	public List<PropositionCategory> findByTypeAndCompany(long companyId,int categoryTypeId) throws SystemException{
		return propositionCategoryPersistence.findByTypeAndCompany(companyId, categoryTypeId);
	}
	
	public List<PropositionCategory> findByTypeAndCompany(long companyId,int categoryTypeId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByTypeAndCompany(companyId,categoryTypeId,start,end);
	}
	
	public List<PropositionCategory> findByTypeAndGroup(long groupId,int categoryTypeId) throws SystemException{
		return propositionCategoryPersistence.findByTypeAndGroup(groupId, categoryTypeId);
	}
	
	public List<PropositionCategory> findByTypeAndGroup(long groupId,int categoryTypeId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByTypeAndGroup(groupId,categoryTypeId,start,end);
	}
	
	public List<PropositionCategory> findByParentAndCompany(long companyId,long parentId) throws SystemException{
		return propositionCategoryPersistence.findByParentAndCompany(companyId, parentId);
	}
	
	public List<PropositionCategory> findByParentAndCompany(long companyId,long parentId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByParentAndCompany(companyId,parentId,start,end);
	}
	
	public List<PropositionCategory> findByParentAndGroup(long groupId,long parentId) throws SystemException{
		return propositionCategoryPersistence.findByParentAndGroup(groupId, parentId);
	}
	
	public List<PropositionCategory> findByParentAndGroup(long groupId,long parentId,int start,int end) throws SystemException{
		return propositionCategoryPersistence.findByParentAndGroup(groupId,parentId,start,end);
	}
	
	public PropositionCategory addCategory(long companyId,long groupId,long userId,int categoryTypeId,long parentId,
										String categoryName,String categoryDesc,ServiceContext serviceContext) throws PortalException, SystemException{
		
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		PropositionCategory category = propositionCategoryPersistence.create(categoryId);
		
		category.setCompanyId(companyId);
		category.setGroupId(groupId);
		category.setUserId(userId);
		category.setCategoryTypeId(categoryTypeId);
		category.setParentId(parentId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		category.setPropositionCount(PropositionConstants.DEFAULT_PROPOSITION_COUNT);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCategoryResources(category, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCategoryResources(category, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		propositionCategoryPersistence.update(category, false);
		
		return category;
	}
	
	public PropositionCategory updateCategory(long categoryId,long companyId,long groupId,long userId,int categoryTypeId,long parentId,
										String categoryName,String categoryDesc) throws SystemException{
		
		Date now = new Date();
		
		PropositionCategory category = propositionCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		category.setCompanyId(companyId);
		category.setGroupId(groupId);
		category.setUserId(userId);
		category.setCategoryTypeId(categoryTypeId);
		category.setParentId(parentId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		category.setModifiedDate(now);
		
		propositionCategoryPersistence.update(category, false);
		
		return category;
	}
	
	public void incrementPropositionCounter(long categoryId) throws SystemException{
		
		if(categoryId > 0){
			
			PropositionCategory category = propositionCategoryPersistence.fetchByPrimaryKey(categoryId);
			
			if(category != null){
				
				int oldPropositionCount = category.getPropositionCount();
				
				category.setPropositionCount(oldPropositionCount + 1);
				
				propositionCategoryPersistence.update(category, false);
			}
		}
	}
	
	public void descrementPropositionCounter(long categoryId) throws SystemException{
		
		if(categoryId > 0){
			
			PropositionCategory category = propositionCategoryPersistence.fetchByPrimaryKey(categoryId);
			
			if(category != null){
				
				int oldPropositionCount = category.getPropositionCount();
				
				category.setPropositionCount(oldPropositionCount - 1);
				
				propositionCategoryPersistence.update(category, false);
			}
		}
	}
	
	public void deleteCategory(long categoryId) throws SystemException, PortalException{
		
		if(categoryId > 0){
			
			PropositionCategory category = propositionCategoryPersistence.fetchByPrimaryKey(categoryId);
			
			if(category != null){
				
				propositionCategoryPersistence.remove(category);
				resourceLocalService.deleteResource(category.getCompanyId(), PropositionCategory.class.getName(),
														ResourceConstants.SCOPE_INDIVIDUAL, category.getCategoryId());
			}
		}
	}
	
	private void addCategoryResources(PropositionCategory category,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(category.getCompanyId(), category.getGroupId(), 
			category.getUserId(), PropositionCategory.class.getName(),
			category.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCategoryResources(PropositionCategory category,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(category.getCompanyId(), category.getGroupId(),
			category.getUserId(), PropositionCategory.class.getName(),
			category.getCategoryId(), groupPermissions, guestPermissions);
	}		
}