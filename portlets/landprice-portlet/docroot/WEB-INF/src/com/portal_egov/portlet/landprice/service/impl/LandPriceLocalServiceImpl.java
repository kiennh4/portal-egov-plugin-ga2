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

package com.portal_egov.portlet.landprice.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.landprice.NoSuchLandPriceException;
import com.portal_egov.portlet.landprice.model.LandPrice;
import com.portal_egov.portlet.landprice.service.base.LandPriceLocalServiceBaseImpl;
import com.portal_egov.portlet.landprice.service.persistence.LandPriceFinderUtil;

/**
 * The implementation of the land price local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.landprice.service.LandPriceLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.landprice.service.base.LandPriceLocalServiceBaseImpl
 * @see com.portal_egov.portlet.landprice.service.LandPriceLocalServiceUtil
 */
public class LandPriceLocalServiceImpl extends LandPriceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.landprice.service.LandPriceLocalServiceUtil} to
	 * access the land price local service.
	 */
	
	public List<LandPrice> findByGroup(long groupId) throws SystemException{
		
		return landPricePersistence.findByGroup(groupId);
	}
	
	public List<LandPrice> findByLocation(long locationId) throws SystemException{
		
		return landPricePersistence.findByLocation(locationId);
	}
	
	public List<LandPrice> findByStatisticYear(int statisticYear) throws SystemException{
		
		return landPricePersistence.findByStatisticYear(statisticYear);
	}
	
	public List<LandPrice> findByKeyword(long groupId,long locationId,String keyword,int statisticYear,int start,int end,OrderByComparator obc) throws SystemException{
		
		return LandPriceFinderUtil.findByKeyword(groupId,locationId, keyword,statisticYear, start, end, obc);
	}
	
	public LandPrice addLandPrice(long companyId,long groupId,long userId,String userName,
		long locationId,String title,String content,int statisticYear,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long priceId = counterLocalService.increment();
		
		LandPrice landPrice = landPricePersistence.create(priceId);
		
		landPrice.setCompanyId(companyId);
		landPrice.setGroupId(groupId);
		landPrice.setUserId(userId);
		landPrice.setUserName(userName);
		landPrice.setCreateDate(now);
		landPrice.setModifiedDate(now);
		
		landPrice.setLocationId(locationId);
		landPrice.setTitle(title);
		landPrice.setContent(content);
		landPrice.setStatisticYear(statisticYear);
		
		landPricePersistence.update(landPrice, false);
		
		resourceLocalService.addModelResources(landPrice, serviceContext);
		
		return landPrice;
	}
	
	public LandPrice updateLandPrice(long priceId,long companyId,long groupId,long userId,String userName,
		long locationId,String title,String content,int statisticYear,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		LandPrice landPrice = landPricePersistence.fetchByPrimaryKey(priceId);
		
		landPrice.setCompanyId(companyId);
		landPrice.setGroupId(groupId);
		landPrice.setUserId(userId);
		landPrice.setUserName(userName);
		landPrice.setModifiedDate(now);
		
		landPrice.setLocationId(locationId);
		landPrice.setTitle(title);
		landPrice.setContent(content);
		landPrice.setStatisticYear(statisticYear);
		
		landPricePersistence.update(landPrice, false);
		
		resourceLocalService.addModelResources(landPrice, serviceContext);
		
		updateObjectResources(landPrice, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return landPrice;
	}
	
	public LandPrice deleteLandPrice(long priceId) throws NoSuchLandPriceException, SystemException{
		
		return landPricePersistence.remove(priceId);
	}
	
	protected void updateObjectResources(LandPrice landPrice,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(landPrice.getCompanyId(),
			landPrice.getGroupId(), LandPrice.class.getName(),
			landPrice.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
