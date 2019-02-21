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

package com.portal_egov.portlet.vbpq.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.service.base.VBPQ_CategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.vbpq.service.persistence.VBPQ_CategoryFinderUtil;

/**
 * The implementation of the v b p q_ category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.vbpq.service.base.VBPQ_CategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil
 */
public class VBPQ_CategoryLocalServiceImpl
	extends VBPQ_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil} to access the v b p q_ category local service.
	 */
	
	public static final boolean DEFAULT_VBPQ_CATEGORY_ACTIVE_STATUS = true;
	

	public int countAll() throws SystemException{
		return vbpq_CategoryPersistence.countAll();
	}
	

	public int countByCompany(long companyId) throws SystemException{
		return vbpq_CategoryPersistence.countByCompany(companyId);
	}

	public int countByGroup(long groupId) throws SystemException{
		return vbpq_CategoryPersistence.countByGroup(groupId);
	}
	

	public int countByParentAndCompany(long companyId,long parentId) throws SystemException{
		return vbpq_CategoryPersistence.countByParentAndCompany(parentId, companyId);
	}
	

	public int countByParentAndGroup(long groupId,long parentId) throws SystemException{
		return vbpq_CategoryPersistence.countByParentAndGroup(parentId, groupId);
	}
	

	public List<VBPQ_Category> findAll() throws SystemException{
		return vbpq_CategoryPersistence.findAll();
	}
	

	public List<VBPQ_Category> findByCompany(long companyId) throws SystemException{
		return vbpq_CategoryPersistence.findByCompany(companyId);
	}

	public List<VBPQ_Category> findByCompany(long companyId,int start,int end) throws SystemException{
		return vbpq_CategoryPersistence.findByCompany(companyId,start,end);
	}

	public List<VBPQ_Category> findByGroup(long groupId) throws SystemException{
		return vbpq_CategoryPersistence.findByGroup(groupId);
	}
	
	public List<VBPQ_Category> findByGroup(long groupId,int start,int end) throws SystemException{
		return vbpq_CategoryPersistence.findByGroup(groupId,start,end);
	}
	

	public List<VBPQ_Category> findByParentAndCompany(long companyId,long parentId) throws SystemException{
		return vbpq_CategoryPersistence.findByParentAndCompany(parentId, companyId);
	}
	
	public List<VBPQ_Category> findByParentAndCompany(long companyId,long parentId,int start,int end) throws SystemException{
		return vbpq_CategoryPersistence.findByParentAndCompany(parentId, companyId,start,end);
	}
	

	public List<VBPQ_Category> findByParentAndGroup(long groupId,long parentId) throws SystemException{
		return vbpq_CategoryPersistence.findByParentAndGroup(parentId, groupId);
	}
	
	public List<VBPQ_Category> findByParentAndGroup(long groupId,long parentId,int start,int end) throws SystemException{
		return vbpq_CategoryPersistence.findByParentAndGroup(parentId, groupId,start,end);
	}

	public List<VBPQ_Category> findByTypeAndCompany(int typeId,long companyId) throws SystemException{
		
		return vbpq_CategoryPersistence.findByTypeAndCompany(typeId, companyId);
	}

	public List<VBPQ_Category> findByTypeAndCompany(int typeId,long companyId,int start,int end) throws SystemException{
		
		return vbpq_CategoryPersistence.findByTypeAndCompany(typeId, companyId,start,end);
	}
	
	public List<VBPQ_Category> findByTypeAndGroup(int typeId,long groupId) throws SystemException{
		
		return vbpq_CategoryPersistence.findByTypeAndGroup(typeId, groupId);
	}
	
	public List<VBPQ_Category> findByTypeAndGroup(int typeId,long groupId,int start,int end) throws SystemException{
		
		return vbpq_CategoryPersistence.findByTypeAndGroup(typeId, groupId,start,end);
	}
	
	public List<VBPQ_Category> findByKeyword(long groupId,int categoryTypeId,String keyword,int start,int end) throws SystemException{
		
		return VBPQ_CategoryFinderUtil.findByKeyword(groupId, categoryTypeId, keyword, start, end);
	}
	
	/**
	 * Truy van theo Id
	 */
	public VBPQ_Category getCategory(long categoryId) throws SystemException{
		return vbpq_CategoryPersistence.fetchByPrimaryKey(categoryId);
	}
	
	
	public void addCategoryResources(VBPQ_Category vbpqCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
			throws PortalException, SystemException{
		
		resourceLocalService.addResources(vbpqCategory.getCompanyId(), vbpqCategory.getGroupId(), 
				vbpqCategory.getUserId(), VBPQ_Category.class.getName(),
				vbpqCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
	
	public void addCategoryResources(VBPQ_Category vbpqCategory,String[] groupPermissions,String[] guestPermissions) 
			throws PortalException, SystemException{
		resourceLocalService.addModelResources(vbpqCategory.getCompanyId(), vbpqCategory.getGroupId(),
				vbpqCategory.getUserId(), VBPQ_Category.class.getName(),
				vbpqCategory.getCategoryId(), groupPermissions, guestPermissions);
	}


	public void addCategory(long companyId,long groupId,long userId,long parentId,int typeId,
			String categoryName,String categoryDesc,int displayPriority,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();

		long categoryId = counterLocalService.increment();
		
		VBPQ_Category vbpqCategory = vbpq_CategoryPersistence.create(categoryId);
										
		vbpqCategory.setCompanyId(companyId);
		vbpqCategory.setGroupId(groupId);
		vbpqCategory.setUserId(userId);
		vbpqCategory.setParentId(parentId);
		vbpqCategory.setTypeId(typeId);
		vbpqCategory.setCategoryName(categoryName);
		vbpqCategory.setCategoryDesc(categoryDesc);
		vbpqCategory.setCreateDate(now);
		vbpqCategory.setModifiedDate(now);
		vbpqCategory.setActive(DEFAULT_VBPQ_CATEGORY_ACTIVE_STATUS);
		vbpqCategory.setDisplayPriority(displayPriority);
		
		vbpq_CategoryPersistence.update(vbpqCategory, false);
		
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
			
			addCategoryResources(vbpqCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCategoryResources(vbpqCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
	}
	
	
	public void updateCategory(long categoryId,long companyId,long groupId,long userId,long parentId,int typeId,
			String categoryName,String categoryDesc,int displayPriority) throws SystemException{
		
		VBPQ_Category vbpqCategory = vbpq_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(vbpqCategory != null){
			
			Date now = new Date();
			
			vbpqCategory.setCompanyId(companyId);
			vbpqCategory.setGroupId(groupId);
			vbpqCategory.setUserId(userId);
			vbpqCategory.setParentId(parentId);
			vbpqCategory.setTypeId(typeId);
			vbpqCategory.setCategoryName(categoryName);
			vbpqCategory.setCategoryDesc(categoryDesc);			
			vbpqCategory.setModifiedDate(now);
			vbpqCategory.setDisplayPriority(displayPriority);
			
			vbpq_CategoryPersistence.update(vbpqCategory, false);
		}
	}
	
	public void deactiveCategory(long categoryId) throws SystemException{
		
		VBPQ_Category vbpqCategory = vbpq_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(vbpqCategory != null){
			vbpqCategory.setActive(false);
			
			vbpq_CategoryPersistence.update(vbpqCategory, false);
		}
	}
	
	
	public void deleteCategory(long companyId,long categoryId) throws SystemException, PortalException{
		
		VBPQ_Category vbpqCategory = vbpq_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		if(vbpqCategory != null){
			
			List<VBPQ_Category> childCategoryList = findByParentAndCompany(companyId, categoryId);
			
			if(!childCategoryList.isEmpty()){		
				
				for(int i = 0;i < childCategoryList.size(); i++){
					
					VBPQ_Category childCategory = childCategoryList.get(i);
					childCategory.setParentId(0);
					vbpq_CategoryPersistence.update(childCategory, false);
				}
			}
			vbpq_CategoryPersistence.remove(vbpqCategory);
			
			resourceLocalService.deleteResource(vbpqCategory.getCompanyId(), VBPQ_Category.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, vbpqCategory.getCategoryId());
		}
	}	
}