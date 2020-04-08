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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.service.base.BannerLocalServiceBaseImpl;
import com.portal_egov.portlet.banner.service.persistence.BannerFinderUtil;
import com.portal_egov.portlet.banner.util.BannerUtil;

/**
 * The implementation of the banner local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.banner.service.BannerLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.banner.service.base.BannerLocalServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.BannerLocalServiceUtil
 */
public class BannerLocalServiceImpl extends BannerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.banner.service.BannerLocalServiceUtil} to
	 * access the banner local service.
	 */
	
	
	public List<Banner> findAll() throws SystemException{
		
		return bannerPersistence.findAll();
	}
	
	public List<Banner> findByCompany(long companyId) throws SystemException{
		
		return bannerPersistence.findByCompany(companyId);
	}
	
	public List<Banner> findByGroup(long groupId) throws SystemException{
		
		return bannerPersistence.findByGroup(groupId);
	}
	
	public List<Banner> findByBannerGroup(long bannerGroupId) throws SystemException{
		
		return bannerPersistence.findByBannerGroup(bannerGroupId);
	}
	
	public List<Banner> findByTitle(long groupId,long bannerGroupId,String bannerTitle,int start,int end,OrderByComparator obc){
		
		return BannerFinderUtil.findByTitle(groupId, bannerGroupId, bannerTitle, start, end, obc);
	}
	
	public Banner getBanner(long bannerId) throws SystemException{
		return bannerPersistence.fetchByPrimaryKey(bannerId);
	}
	
	
	public Banner getBannerCounter(long bannerId) throws SystemException{
		
		if(bannerId > 0){
			
			Banner banner = bannerPersistence.fetchByPrimaryKey(bannerId);
			
			if(banner != null){
				
				banner.setViewCounter(banner.getViewCounter() + 1);
				bannerPersistence.update(banner, false);
				
				return banner;
			}else{
				
				return null;
			}
		}else{
			
			return null;
		}
	}
	
	public Banner addBanner(long companyId,long groupId,long userId,String userName,long bannerGroupId,String bannerTitle,
		String bannerLink,long bannerImageId,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long bannerId = counterLocalService.increment();
		
		Banner banner = bannerPersistence.create(bannerId);
		
		banner.setCompanyId(companyId);
		banner.setGroupId(groupId);
		banner.setUserId(userId);
		banner.setUserName(userName);
		banner.setBannerGroupId(bannerGroupId);
		banner.setBannerTitle(bannerTitle);
		banner.setBannerLink(bannerLink);
		banner.setBannerImageId(bannerImageId);
		banner.setViewCounter(BannerUtil.BANNER_START_VIEW_COUNT);
		banner.setBannerStatus(BannerUtil.ACTIVE_BANNER_STATUS);
		banner.setCreateDate(now);
		banner.setModifiedDate(now);
		
		bannerPersistence.update(banner, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addBannerResources(banner, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addBannerResources(banner, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return banner;
		
	}
	
	public Banner updateBanner(long bannerId,long bannerGroupId,String bannerTitle,
			String bannerLink,long bannerImageId,int bannerStatus) throws SystemException{
		
		Date now = new Date();
		
		Banner banner = bannerPersistence.fetchByPrimaryKey(bannerId);
		
		banner.setBannerTitle(bannerTitle);
		banner.setBannerLink(bannerLink);
		banner.setBannerGroupId(bannerGroupId);
		banner.setBannerImageId(bannerImageId);
		banner.setBannerStatus(BannerUtil.ACTIVE_BANNER_STATUS);
		banner.setModifiedDate(now);
		
		bannerPersistence.update(banner, false);
		
		return banner;
	}
	
	
	public void updateBannerStatus(long bannerId,int bannerStatus) throws SystemException{
		
		if(bannerId > 0){
			
			Banner banner = bannerPersistence.fetchByPrimaryKey(bannerId);
			
			if(banner != null){
				
				banner.setBannerStatus(bannerStatus);
				bannerPersistence.update(banner, false);
			}
		}
	}
	
	
	private void addBannerResources(Banner banner,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(banner.getCompanyId(), banner.getGroupId(), 
			banner.getUserId(), Banner.class.getName(),
			banner.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addBannerResources(Banner banner,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(banner.getCompanyId(), banner.getGroupId(),
			banner.getUserId(), Banner.class.getName(),
			banner.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
