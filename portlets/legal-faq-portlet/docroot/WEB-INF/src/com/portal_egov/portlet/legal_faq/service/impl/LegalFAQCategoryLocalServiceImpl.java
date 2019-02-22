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

package com.portal_egov.portlet.legal_faq.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;
import com.portal_egov.portlet.legal_faq.service.base.LegalFAQCategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryFinderUtil;

/**
 * The implementation of the legal f a q category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.legal_faq.service.base.LegalFAQCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil
 */
public class LegalFAQCategoryLocalServiceImpl extends LegalFAQCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil} to access the legal f a q category local service.
	 */
	
	public int countAll() throws SystemException{
		return legalFAQCategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return legalFAQCategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return legalFAQCategoryPersistence.countByGroup(groupId);
	}
	
	public int countByParent(long companyId,long parentId) throws SystemException{
		return legalFAQCategoryPersistence.countByParent(companyId, parentId);
	}
	
	public List<LegalFAQCategory> findByCompany(long companyId) throws SystemException{
		return legalFAQCategoryPersistence.findByCompany(companyId);
	}
	
	public List<LegalFAQCategory> findByCompany(long companyId,int start,int end) throws SystemException{
		return legalFAQCategoryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<LegalFAQCategory> findByGroup(long groupId) throws SystemException{
		return legalFAQCategoryPersistence.findByGroup(groupId);
	}
	
	public List<LegalFAQCategory> findByGroup(long groupId,int start,int end) throws SystemException{
		return legalFAQCategoryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<LegalFAQCategory> findByParent(long companyId,long parentId) throws SystemException{
		return legalFAQCategoryPersistence.findByParent(companyId, parentId);
	}
	
	public List<LegalFAQCategory> findByParent(long companyId,long parentId,int start,int end) throws SystemException{
		return legalFAQCategoryPersistence.findByParent(companyId,parentId,start,end);
	}
	
	public List<LegalFAQCategory> findByKeyword(long groupId,String keyword,int start,int end) throws SystemException{
		return LegalFAQCategoryFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public LegalFAQCategory getCategory(long categoryId) throws SystemException{
		return legalFAQCategoryPersistence.fetchByPrimaryKey(categoryId);
	}
	
	public LegalFAQCategory addCategory(long companyId,long groupId,long userId,long parentId,String categoryName,
										String categoryDesc,ServiceContext serviceContext) throws SystemException, PortalException{
				
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		LegalFAQCategory legalFAQCategory = legalFAQCategoryPersistence.create(categoryId);
		
		legalFAQCategory.setCompanyId(companyId);
		legalFAQCategory.setGroupId(groupId);
		legalFAQCategory.setUserId(userId);
		legalFAQCategory.setParentId(parentId);
		legalFAQCategory.setCategoryName(categoryName);
		legalFAQCategory.setCategoryDesc(categoryDesc);
		legalFAQCategory.setCreateDate(now);
		legalFAQCategory.setModifiedDate(now);
		
		legalFAQCategoryPersistence.update(legalFAQCategory, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addLegalFAQCategoryResources(legalFAQCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addLegalFAQCategoryResources(legalFAQCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
				
		return legalFAQCategory;
	}
	
	
	public LegalFAQCategory updateCategory(long categoryId,long companyId,long groupId,long userId,long parentId,String categoryName,
										String categoryDesc) throws SystemException, PortalException{
				
		Date now = new Date();
		
		LegalFAQCategory legalFAQCategory = legalFAQCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		legalFAQCategory.setCompanyId(companyId);
		legalFAQCategory.setGroupId(groupId);
		legalFAQCategory.setUserId(userId);
		legalFAQCategory.setParentId(parentId);
		legalFAQCategory.setCategoryName(categoryName);
		legalFAQCategory.setCategoryDesc(categoryDesc);
		legalFAQCategory.setModifiedDate(now);
		
		legalFAQCategoryPersistence.update(legalFAQCategory, false);
				
		return legalFAQCategory;
	}
	
	
	public void deleteCategory(long categoryId) throws SystemException, PortalException{
		
		LegalFAQCategory legalFAQCategory = legalFAQCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(legalFAQCategory != null){
			
			legalFAQCategoryPersistence.remove(legalFAQCategory);
			resourceLocalService.deleteResource(legalFAQCategory.getCompanyId(), LegalFAQCategory.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, legalFAQCategory.getCategoryId());
		}
	}
	
	private void addLegalFAQCategoryResources(LegalFAQCategory legalFAQCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(legalFAQCategory.getCompanyId(), legalFAQCategory.getGroupId(), 
			legalFAQCategory.getUserId(), LegalFAQCategory.class.getName(),
			legalFAQCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addLegalFAQCategoryResources(LegalFAQCategory legalFAQCategory,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(legalFAQCategory.getCompanyId(), legalFAQCategory.getGroupId(),
			legalFAQCategory.getUserId(), LegalFAQCategory.class.getName(),
			legalFAQCategory.getCategoryId(), groupPermissions, guestPermissions);
	}
} 