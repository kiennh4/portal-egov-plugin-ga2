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

package com.portal_egov.portlet.ykct.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.ykct.model.YKCT_Category;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil;
import com.portal_egov.portlet.ykct.service.base.YKCT_CategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_CategoryFinderUtil;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinderUtil;

/**
 * The implementation of the y k c t_ category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.ykct.service.base.YKCT_CategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil
 */
public class YKCT_CategoryLocalServiceImpl
	extends YKCT_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil} to access the y k c t_ category local service.
	 */
	
	public int countAll() throws SystemException{
		return ykct_CategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return ykct_CategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return ykct_CategoryPersistence.countByGroup(groupId);
	}
	
	public List<YKCT_Category> findAll() throws SystemException{
		return ykct_CategoryPersistence.findAll();
	}
	
	public List<YKCT_Category> findByCompany(long companyId) throws SystemException{
		return ykct_CategoryPersistence.findByCompany(companyId);
	}
	
	public List<YKCT_Category> findByCompany(long companyId,int start,int end) throws SystemException{
		return ykct_CategoryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<YKCT_Category> findByGroup(long groupId) throws SystemException{
		return ykct_CategoryPersistence.findByGroup(groupId);
	}
	
	public List<YKCT_Category> findByGroup(long groupId,int start,int end) throws SystemException{
		return ykct_CategoryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<YKCT_Category> findByKeyword(long groupId,String keyword,int start,int end){
		return YKCT_CategoryFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public YKCT_Category addCategory(long companyId,long groupId,long userId,String userName,String categoryName,
		String categoryDesc, ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		YKCT_Category ykctCategory = ykct_CategoryPersistence.create(categoryId);
		
		ykctCategory.setCompanyId(companyId);
		ykctCategory.setGroupId(groupId);
		ykctCategory.setUserId(userId);
		ykctCategory.setUserName(userName);
		ykctCategory.setCategoryName(categoryName);
		ykctCategory.setCategoryDesc(categoryDesc);
		ykctCategory.setCreateDate(now);
		ykctCategory.setModifiedDate(now);
		
		ykct_CategoryPersistence.update(ykctCategory, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCategoryResources(ykctCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCategoryResources(ykctCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return ykctCategory;
	}
	
	public YKCT_Category updateCategory(long companyId,long groupId,long userId,String userName,long categoryId,String categoryName,
		String categoryDesc) throws SystemException, PortalException{
		
		Date now = new Date();
		
		YKCT_Category ykctCategory = ykct_CategoryPersistence.fetchByPrimaryKey(categoryId);
		
		ykctCategory.setCompanyId(companyId);
		ykctCategory.setGroupId(groupId);
		ykctCategory.setUserId(userId);
		ykctCategory.setUserName(userName);
		ykctCategory.setCategoryName(categoryName);
		ykctCategory.setCategoryDesc(categoryDesc);
		ykctCategory.setModifiedDate(now);
		
		ykct_CategoryPersistence.update(ykctCategory, false);
		
		return ykctCategory;
	}
		
	public void deleteCategory(long categoryId,boolean deleteYKCTEntrys) throws SystemException, PortalException{
		
		if(categoryId > 0){
			
			YKCT_Category ykctCategory = getYKCT_Category(categoryId);
			
			if(ykctCategory != null){
				
				List<YKCT_Entry> ykctEntryList = YKCT_EntryLocalServiceUtil.findByCategory(categoryId);
				
				if(deleteYKCTEntrys && !ykctEntryList.isEmpty()){//Truong hop xoa tat ca cac lien ket thuoc chuyen muc
					
					for(YKCT_Entry ykctEntry : ykctEntryList){
						//Xoa tat ca cac lien ket
						YKCT_EntryLocalServiceUtil.deleteYKCT_Entry(ykctEntry.getEntryId());
					}
				}else if(!deleteYKCTEntrys && !ykctEntryList.isEmpty()){//Truong hop khong xoa cac lien ket thuoc chuyen muc
					
					for(YKCT_Entry ykctEntry : ykctEntryList){
						//Cap nhat Id chuyen muc cua lien ket = 0
						ykctEntry.setCategoryId(0);
						YKCT_EntryLocalServiceUtil.updateYKCT_Entry(ykctEntry, false);
					}
				}
				
				//Xoa chuyen muc
				ykct_CategoryPersistence.remove(categoryId);
				
				//remove portal resource
				resourceLocalService.deleteResource(ykctCategory.getCompanyId(), YKCT_Category.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, categoryId);
			}
		}
	}
	
	private void addCategoryResources(YKCT_Category ykctCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(ykctCategory.getCompanyId(), ykctCategory.getGroupId(), 
				ykctCategory.getUserId(), YKCT_Category.class.getName(),
				ykctCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCategoryResources(YKCT_Category ykctCategory,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(ykctCategory.getCompanyId(), ykctCategory.getGroupId(),
				ykctCategory.getUserId(), YKCT_Category.class.getName(),
				ykctCategory.getCategoryId(), groupPermissions, guestPermissions);
	}
}