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

package com.portal_egov.portlet.banner.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.banner.NoSuchBannerGroupException;
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.model.BannerGroup;
import com.portal_egov.portlet.banner.service.BannerLocalServiceUtil;
import com.portal_egov.portlet.banner.service.base.BannerGroupLocalServiceBaseImpl;

/**
 * The implementation of the banner group local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.banner.service.BannerGroupLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.banner.service.base.BannerGroupLocalServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil
 */
public class BannerGroupLocalServiceImpl extends BannerGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil} to
	 * access the banner group local service.
	 */
	
	public List<BannerGroup> findAll() throws SystemException{
		
		return bannerGroupPersistence.findAll();
	}
	
	public List<BannerGroup> findByCompany(long companyId) throws SystemException{
		
		return bannerGroupPersistence.findByCompany(companyId);
	}
	
	public List<BannerGroup> findByGroup(long groupId) throws SystemException{
		
		return bannerGroupPersistence.findByGroup(groupId);
	}
	
	public BannerGroup getBannerGroup(long bannerGroupId) throws SystemException{
		return bannerGroupPersistence.fetchByPrimaryKey(bannerGroupId);
	}
	
	public BannerGroup addBannerGroup(long companyId,long groupId,long userId,String userName,String groupName,
		String groupDesc,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long bannerGroupId = counterLocalService.increment();
		
		BannerGroup bannerGroup = bannerGroupPersistence.create(bannerGroupId);
		
		bannerGroup.setCompanyId(companyId);
		bannerGroup.setGroupId(groupId);
		bannerGroup.setUserId(userId);
		bannerGroup.setUserName(userName);
		bannerGroup.setGroupName(groupName);
		bannerGroup.setGroupDesc(groupDesc);
		bannerGroup.setCreateDate(now);
		bannerGroup.setModifiedDate(now);
		
		bannerGroupPersistence.update(bannerGroup, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addBannerGroupResources(bannerGroup, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addBannerGroupResources(bannerGroup, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return bannerGroup;
	}
	
	public BannerGroup updateBannerGroup(long bannerGroupId,String groupName,String groupDesc) throws SystemException{
		
		BannerGroup bannerGroup = bannerGroupPersistence.fetchByPrimaryKey(bannerGroupId);
		
		if(bannerGroup != null){
			
			Date now = new Date();
			
			bannerGroup.setGroupName(groupName);
			bannerGroup.setGroupDesc(groupDesc);
			bannerGroup.setCreateDate(now);
			
			bannerGroupPersistence.update(bannerGroup, false);
		}
		
		return bannerGroup;
	}
	
	public BannerGroup deleteBannerGroup(long bannerGroupId) throws SystemException, PortalException{
		
		if(bannerGroupId > 0){
			
			BannerGroup bannerGroup = getBannerGroup(bannerGroupId);
			
			if(bannerGroup != null){
				
				List<Banner> bannerList = BannerLocalServiceUtil.findByBannerGroup(bannerGroupId);
				
				for(Banner banner : bannerList){
					
					banner.setBannerGroupId(0);
					
					BannerLocalServiceUtil.updateBanner(banner, false);
				}
			}
		}
		
		return bannerGroupPersistence.remove(bannerGroupId);
	}
	
	
	private void addBannerGroupResources(BannerGroup bannerGroup,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(bannerGroup.getCompanyId(), bannerGroup.getGroupId(), 
			bannerGroup.getUserId(), BannerGroup.class.getName(),
			bannerGroup.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addBannerGroupResources(BannerGroup bannerGroup,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(bannerGroup.getCompanyId(), bannerGroup.getGroupId(),
			bannerGroup.getUserId(), BannerGroup.class.getName(),
			bannerGroup.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
