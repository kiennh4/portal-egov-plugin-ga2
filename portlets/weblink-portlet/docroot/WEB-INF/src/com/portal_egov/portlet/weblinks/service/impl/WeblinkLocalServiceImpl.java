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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.service.base.WeblinkLocalServiceBaseImpl;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkFinderUtil;

/**
 * The implementation of the weblink local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, 
 * rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.weblinks.service.WeblinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS 
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.weblinks.service.base.WeblinkLocalServiceBaseImpl
 * @see com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil
 */
public class WeblinkLocalServiceImpl extends WeblinkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly.
	 *  Always use {@link com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil} to access the weblink local service.
	 */
	
	public int countAll() throws SystemException{
		return weblinkPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return weblinkPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return weblinkPersistence.countByGroup(groupId);
	}
	
	public int countByCategory(long categoryId) throws SystemException{
		return weblinkPersistence.countByCategory(categoryId);
	}
	
	public List<Weblink> findAll() throws SystemException{
		return weblinkPersistence.findAll();
	}
	
	public List<Weblink> findByCompany(long companyId) throws SystemException{
		return weblinkPersistence.findByCompany(companyId);
	}
	
	public List<Weblink> findByCompany(long companyId,int start,int end) throws SystemException{
		return weblinkPersistence.findByCompany(companyId,start,end);
	}
	
	public List<Weblink> findByGroup(long groupId) throws SystemException{
		return weblinkPersistence.findByGroup(groupId);
	}
	
	public List<Weblink> findByGroup(long groupId,int start,int end) throws SystemException{
		return weblinkPersistence.findByGroup(groupId,start,end);
	}
	
	public List<Weblink> findByCategory(long categoryId) throws SystemException{
		return weblinkPersistence.findByCategory(categoryId);
	}
	
	public List<Weblink> findByCategory(long categoryId,int start,int end) throws SystemException{
		return weblinkPersistence.findByCategory(categoryId,start,end);
	}
	
	public List<Weblink> findByKeyword(long groupId,long categoryId,String keyword,int start,int end,OrderByComparator obc){
		return WeblinkFinderUtil.findByKeyword(groupId, categoryId, keyword, start, end,obc);
	}
	
	public Weblink addWeblink(long companyId,long groupId,long userId,String userName,long weblinkCategoryId,String weblinkName,
		String weblinkDesc,String weblinkURL,long weblinkIconId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long weblinkId = counterLocalService.increment();
		
		Weblink weblink = weblinkPersistence.create(weblinkId);
		
		weblink.setCompanyId(companyId);
		weblink.setGroupId(groupId);
		weblink.setUserId(userId);
		weblink.setUserName(userName);
		weblink.setWeblinkCategoryId(weblinkCategoryId);
		weblink.setWeblinkName(weblinkName);
		weblink.setWeblinkDesc(weblinkDesc);
		weblink.setWeblinkURL(weblinkURL);
		weblink.setWeblinkIconId(weblinkIconId);
		weblink.setCreateDate(now);
		weblink.setModifiedDate(now);
		
		weblinkPersistence.update(weblink, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addWeblinkResources(weblink, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addWeblinkResources(weblink, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		return weblink;
		
	}
	
	public Weblink updateWeblink(long companyId,long groupId,long userId,String userName,long weblinkId,long weblinkCategoryId,String weblinkName,
		String weblinkDesc,String weblinkURL,long weblinkIconId) throws SystemException, PortalException{
		
		Date now = new Date();
		
		Weblink weblink = weblinkPersistence.fetchByPrimaryKey(weblinkId);
		
		weblink.setCompanyId(companyId);
		weblink.setGroupId(groupId);
		weblink.setUserId(userId);
		weblink.setUserName(userName);
		weblink.setWeblinkCategoryId(weblinkCategoryId);
		weblink.setWeblinkName(weblinkName);
		weblink.setWeblinkDesc(weblinkDesc);
		weblink.setWeblinkURL(weblinkURL);
		weblink.setWeblinkIconId(weblinkIconId);
		weblink.setModifiedDate(now);
		
		weblinkPersistence.update(weblink, false);
		
		return weblink;
		
	}
	
	public Weblink deleteWeblink(long weblinkId) throws SystemException, PortalException{
		if(weblinkId > 0){
			
			Weblink weblink = getWeblink(weblinkId);
			
			if(weblink != null){
				
				resourceLocalService.deleteResource(weblink.getCompanyId(), Weblink.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, weblinkId);
			}
		}
		
		return weblinkPersistence.remove(weblinkId);
	}
	
	private void addWeblinkResources(Weblink weblink,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(weblink.getCompanyId(), weblink.getGroupId(), 
			weblink.getUserId(), Weblink.class.getName(),
			weblink.getWeblinkId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addWeblinkResources(Weblink weblink,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(weblink.getCompanyId(), weblink.getGroupId(),
			weblink.getUserId(), Weblink.class.getName(),
			weblink.getWeblinkId(), groupPermissions, guestPermissions);
	}
}