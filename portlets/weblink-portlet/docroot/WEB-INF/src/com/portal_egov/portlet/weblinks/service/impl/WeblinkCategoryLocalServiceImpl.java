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

package com.portal_egov.portlet.weblinks.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil;
import com.portal_egov.portlet.weblinks.service.base.WeblinkCategoryLocalServiceBaseImpl;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkCategoryFinderUtil;

/**
 * The implementation of the weblink category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added,
 *  rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on 
 * the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.weblinks.service.base.WeblinkCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil
 */
public class WeblinkCategoryLocalServiceImpl extends WeblinkCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. 
	 * Always use {@link com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil} to access the weblink category local service.
	 */
	
	public int countAll() throws SystemException{
		return weblinkCategoryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return weblinkCategoryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return weblinkCategoryPersistence.countByGroup(groupId);
	}
	
	public List<WeblinkCategory> findAll() throws SystemException{
		return weblinkCategoryPersistence.findAll();
	}
	
	public List<WeblinkCategory> findByCompany(long companyId) throws SystemException{
		return weblinkCategoryPersistence.findByCompany(companyId);
	}
	
	public List<WeblinkCategory> findByCompany(long companyId,int start,int end) throws SystemException{
		return weblinkCategoryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<WeblinkCategory> findByGroup(long groupId) throws SystemException{
		return weblinkCategoryPersistence.findByGroup(groupId);
	}
	
	public List<WeblinkCategory> findByGroup(long groupId,int start,int end) throws SystemException{
		return weblinkCategoryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<WeblinkCategory> findByKeyword(long groupId,String keyword,int start,int end){
		return WeblinkCategoryFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public WeblinkCategory addCategory(long companyId,long groupId,long userId,String userName,String categoryName,
		String categoryDesc,long categoryIconId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long categoryId = counterLocalService.increment();
		
		WeblinkCategory weblinkCategory = weblinkCategoryPersistence.create(categoryId);
		
		weblinkCategory.setCompanyId(companyId);
		weblinkCategory.setGroupId(groupId);
		weblinkCategory.setUserId(userId);
		weblinkCategory.setUserName(userName);
		weblinkCategory.setCategoryName(categoryName);
		weblinkCategory.setCategoryDesc(categoryDesc);
		weblinkCategory.setCategoryIconId(categoryIconId);
		weblinkCategory.setCreateDate(now);
		weblinkCategory.setModifiedDate(now);
		
		weblinkCategoryPersistence.update(weblinkCategory, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addCategoryResources(weblinkCategory, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addCategoryResources(weblinkCategory, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return weblinkCategory;
	}
	
	public WeblinkCategory updateCategory(long companyId,long groupId,long userId,String userName,long categoryId,String categoryName,
		String categoryDesc,long categoryIconId) throws SystemException, PortalException{
		
		Date now = new Date();
		
		WeblinkCategory weblinkCategory = weblinkCategoryPersistence.fetchByPrimaryKey(categoryId);
		
		weblinkCategory.setCompanyId(companyId);
		weblinkCategory.setGroupId(groupId);
		weblinkCategory.setUserId(userId);
		weblinkCategory.setUserName(userName);
		weblinkCategory.setCategoryName(categoryName);
		weblinkCategory.setCategoryDesc(categoryDesc);
		weblinkCategory.setCategoryIconId(categoryIconId);
		weblinkCategory.setModifiedDate(now);
		
		weblinkCategoryPersistence.update(weblinkCategory, false);
		
		return weblinkCategory;
	}
	
	
	public void deleteCategory(long categoryId,boolean deleteWeblinks) throws SystemException, PortalException{
		
		if(categoryId > 0){
			
			WeblinkCategory weblinkCategory = getWeblinkCategory(categoryId);
			
			if(weblinkCategory != null){
				
				List<Weblink> weblinkList = WeblinkLocalServiceUtil.findByCategory(categoryId);
				
				if(deleteWeblinks && !weblinkList.isEmpty()){//Truong hop xoa tat ca cac lien ket thuoc chuyen muc
					
					for(Weblink weblink : weblinkList){
						//Xoa tat ca cac lien ket
						WeblinkLocalServiceUtil.deleteWeblink(weblink.getWeblinkId());
					}
				}else if(!deleteWeblinks && !weblinkList.isEmpty()){//Truong hop khong xoa cac lien ket thuoc chuyen muc
					
					for(Weblink weblink : weblinkList){
						//Cap nhat Id chuyen muc cua lien ket = 0
						weblink.setWeblinkCategoryId(0);
						WeblinkLocalServiceUtil.updateWeblink(weblink, false);
					}
				}
				
				//Xoa chuyen muc
				weblinkCategoryPersistence.remove(categoryId);
				
				//remove portal resource
				resourceLocalService.deleteResource(weblinkCategory.getCompanyId(), WeblinkCategory.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, categoryId);
			}
		}
	}
	
	private void addCategoryResources(WeblinkCategory weblinkCategory,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(weblinkCategory.getCompanyId(), weblinkCategory.getGroupId(), 
			weblinkCategory.getUserId(), WeblinkCategory.class.getName(),
			weblinkCategory.getCategoryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addCategoryResources(WeblinkCategory weblinkCategory,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(weblinkCategory.getCompanyId(), weblinkCategory.getGroupId(),
			weblinkCategory.getUserId(), WeblinkCategory.class.getName(),
			weblinkCategory.getCategoryId(), groupPermissions, guestPermissions);
	}
}