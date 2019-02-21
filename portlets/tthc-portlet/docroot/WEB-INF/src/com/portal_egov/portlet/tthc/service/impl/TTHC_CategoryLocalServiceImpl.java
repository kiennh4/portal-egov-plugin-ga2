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

package com.portal_egov.portlet.tthc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.service.base.TTHC_CategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_CategoryFinderUtil;

/**
 * The implementation of the t t h c_ category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their 
 * definitions into the {@link com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials 
 * because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.tthc.service.base.TTHC_CategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil
 */
public class TTHC_CategoryLocalServiceImpl
	extends TTHC_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil} 
	 * to access the t t h c_ category local service.
	 */
	
	public int countAll() throws SystemException{
		return tthc_CategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return tthc_CategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return tthc_CategoryPersistence.countByGroup(groupId);
	}
	
	public int countByParentAndCompany(long parentId,long companyId) throws SystemException{
		return tthc_CategoryPersistence.countByParentAndCompany(parentId, companyId);
	}
	
	public int countByParentAndGroup(long parentId,long groupId) throws SystemException{
		return tthc_CategoryPersistence.countByParentAndGroup(parentId, groupId);
	}
	
	public int countByTypeAndCompany(int categoryTypeId,long companyId) throws SystemException{
		return tthc_CategoryPersistence.countByTypeAndCompany(categoryTypeId, companyId);
	}
	
	public int countByTypeAndGroup(int categoryTypeId,long groupId) throws SystemException{
		return tthc_CategoryPersistence.countByTypeAndGroup(categoryTypeId, groupId);
	}
	
	public List<TTHC_Category> findByCompany(long companyId) throws SystemException{
		return tthc_CategoryPersistence.findByCompany(companyId);
	}
	
	public List<TTHC_Category> findByCompany(long companyId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByCompany(companyId,start,end);
	}
		
	public List<TTHC_Category> findByGroup(long groupId) throws SystemException{
		return tthc_CategoryPersistence.findByGroup(groupId);
	}
	
	public List<TTHC_Category> findByGroup(long groupId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByGroup(groupId, start, end);
	}
	
	public List<TTHC_Category> findByParentAndCompany(long parentId,long companyId) throws SystemException{
		return tthc_CategoryPersistence.findByParentAndCompany(parentId, companyId);
	}
	
	public List<TTHC_Category> findByParentAndCompany(long parentId,long companyId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByParentAndCompany(parentId, companyId, start, end);
	}
	
	public List<TTHC_Category> findByParentAndGroup(long parentId,long groupId) throws SystemException{
		return tthc_CategoryPersistence.findByParentAndGroup(parentId, groupId);
	}
	
	public List<TTHC_Category> findByParentAndGroup(long parentId,long groupId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByParentAndGroup(parentId, groupId, start, end);
	}
	
	public List<TTHC_Category> findByTypeAndCompany(int categoryTypeId,long companyId) throws SystemException{
		return tthc_CategoryPersistence.findByTypeAndCompany(categoryTypeId, companyId);
	}
	
	public List<TTHC_Category> findByTypeAndCompany(int categoryTypeId,long companyId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByTypeAndCompany(categoryTypeId, companyId, start, end);
	}
	
	public List<TTHC_Category> findByTypeAndGroup(int categoryTypeId,long groupId) throws SystemException{
		return tthc_CategoryPersistence.findByTypeAndGroup(categoryTypeId, groupId);
	}
	
	public List<TTHC_Category> findByTypeAndGroup(int categoryTypeId,long groupId,int start,int end) throws SystemException{
		return tthc_CategoryPersistence.findByTypeAndGroup(categoryTypeId, groupId, start, end);
	}
	
	public List<TTHC_Category> findByKeyword(long groupId,int categoryTypeId,String keyword,int start,int end){
		return TTHC_CategoryFinderUtil.findByKeyword(groupId, categoryTypeId, keyword, start, end);
	}
	
	
	public TTHC_Category addTTHCCategory(long companyId,long groupId,long userId,long parentId,int categoryTypeId
									,String categoryName,String categoryDesc,int displayPriority,ServiceContext serviceContext) 
													throws SystemException, PortalException{
		
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		TTHC_Category tthcCategory = tthc_CategoryPersistence.create(categoryId);
		
		tthcCategory.setCompanyId(companyId);
		tthcCategory.setGroupId(groupId);
		tthcCategory.setUserId(userId);
		tthcCategory.setParentId(parentId);
		tthcCategory.setCategoryTypeId(categoryTypeId);
		tthcCategory.setCategoryName(categoryName);
		tthcCategory.setCategoryDesc(categoryDesc);
		tthcCategory.setCreateDate(now);
		tthcCategory.setModifiedDate(now);
		tthcCategory.setDisplayPriority(displayPriority);
		tthc_CategoryPersistence.update(tthcCategory, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addVBPQCategoryResources(tthcCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addVBPQCategoryResources(tthcCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
				
		return tthcCategory;
		
	}
		
	public TTHC_Category updateTTHCCategory(long categoryId,long companyId,long groupId,long userId,long parentId,int categoryTypeId
									,String categoryName,String categoryDesc,int displayPriority) throws SystemException{
		
		Date now = new Date();
		
		TTHC_Category tthcCategory = tthc_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		tthcCategory.setCompanyId(companyId);
		tthcCategory.setGroupId(groupId);
		tthcCategory.setUserId(userId);
		tthcCategory.setParentId(parentId);
		tthcCategory.setCategoryTypeId(categoryTypeId);
		tthcCategory.setCategoryName(categoryName);
		tthcCategory.setCategoryDesc(categoryDesc);
		tthcCategory.setModifiedDate(now);
		tthcCategory.setDisplayPriority(displayPriority);
		
		tthc_CategoryPersistence.update(tthcCategory, false);
		
		return tthcCategory;
	}
	
	
	public void deleteTTHCCategory(long categoryId) throws SystemException, PortalException{
		
		TTHC_Category tthcCategory = tthc_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(tthcCategory != null){
			
			tthc_CategoryPersistence.remove(tthcCategory);
			resourceLocalService.deleteResource(tthcCategory.getCompanyId(), TTHC_Category.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, tthcCategory.getCategoryId());
		}
	}
	
	private void addVBPQCategoryResources(TTHC_Category tthcCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(tthcCategory.getCompanyId(), tthcCategory.getGroupId(), 
			tthcCategory.getUserId(), TTHC_Category.class.getName(),
			tthcCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addVBPQCategoryResources(TTHC_Category tthcCategory,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(tthcCategory.getCompanyId(), tthcCategory.getGroupId(),
			tthcCategory.getUserId(), TTHC_Category.class.getName(),
			tthcCategory.getCategoryId(), groupPermissions, guestPermissions);
	}	
}