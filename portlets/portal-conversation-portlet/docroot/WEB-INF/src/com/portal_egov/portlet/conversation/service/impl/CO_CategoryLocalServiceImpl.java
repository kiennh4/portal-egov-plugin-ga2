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

package com.portal_egov.portlet.conversation.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.conversation.model.CO_Category;
import com.portal_egov.portlet.conversation.service.base.CO_CategoryLocalServiceBaseImpl;

/**
 * The implementation of the c o_ category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.conversation.service.CO_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.conversation.service.base.CO_CategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil
 */
public class CO_CategoryLocalServiceImpl extends CO_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil} to access the c o_ category local service.
	 */
	
	public int countAll() throws SystemException{
		return co_CategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return co_CategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return co_CategoryPersistence.countByGroup(groupId);
	}
	
	public int countByParentAndCompany(long companyId,long parentCategoryId) throws SystemException{
		return co_CategoryPersistence.countByParentAndCompany(companyId, parentCategoryId);
	}
	
	public int countByParentAndGroup(long groupId,long parentCategoryId) throws SystemException{
		return co_CategoryPersistence.countByParentAndGroup(groupId, parentCategoryId);
	}
	
	public List<CO_Category> findAll() throws SystemException{
		return co_CategoryPersistence.findAll();
	}
	
	public List<CO_Category> findByCompany(long companyId) throws SystemException{
		return co_CategoryPersistence.findByCompany(companyId);
	}
	
	public List<CO_Category> findByCompany(long companyId,int start,int end) throws SystemException{
		return co_CategoryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<CO_Category> findByGroup(long groupId) throws SystemException{
		return co_CategoryPersistence.findByGroup(groupId);
	}
	
	public List<CO_Category> findByGroup(long groupId,int start,int end) throws SystemException{
		return co_CategoryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<CO_Category> findByParentAndCompany(long companyId,long parentCategoryId) throws SystemException{
		return co_CategoryPersistence.findByParentAndCompany(companyId, parentCategoryId);
	}
	
	public List<CO_Category> findByParentAndCompany(long companyId,long parentCategoryId,int start,int end) throws SystemException{
		return co_CategoryPersistence.findByParentAndCompany(companyId, parentCategoryId,start,end);
	}
	
	public List<CO_Category> findByParentAndGroup(long groupId,long parentCategoryId) throws SystemException{
		return co_CategoryPersistence.findByParentAndGroup(groupId, parentCategoryId);
	}
	
	public List<CO_Category> findByParentAndGroup(long groupId,long parentCategoryId,int start,int end) throws SystemException{
		return co_CategoryPersistence.findByParentAndGroup(groupId, parentCategoryId,start,end);
	}
	
	
	public CO_Category addCOCategory(long companyId,long groupId,long userId,long parentCategoryId,String categoryName,
										String categoryDesc,ServiceContext serviceContext) throws SystemException, PortalException{
				
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		CO_Category coCategory = co_CategoryPersistence.create(categoryId);
		
		coCategory.setCompanyId(companyId);
		coCategory.setGroupId(groupId);
		coCategory.setUserId(userId);
		coCategory.setParentCategoryId(parentCategoryId);
		coCategory.setCategoryName(categoryName);
		coCategory.setCategoryDesc(categoryDesc);
		coCategory.setThreadCount(0);
		coCategory.setCreateDate(now);
		coCategory.setModifiedDate(now);
		
		co_CategoryPersistence.update(coCategory, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCOCategoryResources(coCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCOCategoryResources(coCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
				
		return coCategory;
	}
	
	public CO_Category updateCOCategory(long categoryId,long companyId,long groupId,long userId,long parentCategoryId,String categoryName,
		String categoryDesc) throws SystemException, PortalException{

		Date now = new Date();
		
		CO_Category coCategory = co_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		coCategory.setCompanyId(companyId);
		coCategory.setGroupId(groupId);
		coCategory.setUserId(userId);
		coCategory.setParentCategoryId(parentCategoryId);
		coCategory.setCategoryName(categoryName);
		coCategory.setCategoryDesc(categoryDesc);
		coCategory.setModifiedDate(now);
		
		co_CategoryPersistence.update(coCategory, false);
		
		return coCategory;
	}
		
		
	public void deleteCOCategory(long categoryId) throws SystemException, PortalException{
		
		CO_Category coCategory = co_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(coCategory != null){
		
			co_CategoryPersistence.remove(coCategory);
			resourceLocalService.deleteResource(coCategory.getCompanyId(), CO_Category.class.getName(),
													ResourceConstants.SCOPE_INDIVIDUAL, coCategory.getCategoryId());
		}
	}

	public void incrementThreadCount(long categoryId) throws SystemException{
	
		CO_Category coCategory = co_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(coCategory != null){
			
			int oldThreadCountValue = coCategory.getThreadCount();
			
			coCategory.setThreadCount(oldThreadCountValue + 1);
			
			co_CategoryPersistence.update(coCategory, false);
		}
	}
	
	
	private void addCOCategoryResources(CO_Category coCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(coCategory.getCompanyId(), coCategory.getGroupId(), 
			coCategory.getUserId(), CO_Category.class.getName(),
			coCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCOCategoryResources(CO_Category coCategory,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(coCategory.getCompanyId(), coCategory.getGroupId(),
			coCategory.getUserId(), CO_Category.class.getName(),
			coCategory.getCategoryId(), groupPermissions, guestPermissions);
	}
}